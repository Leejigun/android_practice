package com.example.mathpresso.realmpractice.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mathpresso.realmpractice.R;
import com.example.mathpresso.realmpractice.model.Person;

import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by mathpresso on 2016-10-14.
 */
public class RetrofitExampleActivity extends Activity {
    private Realm realm;
    private Subscription subscription;
    private ViewGroup container;
    private GithubApi githubApi;
    private Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = (ViewGroup) findViewById(R.id.container);
        Realm.init(this);

        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.where(Person.class).findAll().deleteAllFromRealm();
        realm.commitTransaction();
        Person person = new Person();
        person.setName("jaysoo");
        person.setGithubUserName("jaysoo");
        realm.beginTransaction();
        realm.copyToRealm(person);
        realm.commitTransaction();

        githubApi = AppController.getInstance().createGitHubApi();

    }

    @Override
    protected void onResume() {
        super.onResume();
        subscription = realm.where(Person.class).isNotNull("githubUserName").findAllSorted("name").asObservable()
                .filter(new Func1<RealmResults<Person>, Boolean>() {
                    @Override
                    public Boolean call(RealmResults<Person> persons) {
                        return persons.isLoaded();
                    }
                }).flatMap(new Func1<RealmResults<Person>, Observable<Person>>() {
                    @Override
                    public Observable<Person> call(RealmResults<Person> persons) {
                        return Observable.from(persons);
                    }
                }).subscribe(new Subscriber<Person>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Person person) {
                        githubApi.user(person.getGithubUserName())
                                .map(new Func1<GithubUser, UserViewModel>() {
                                    @Override
                                    public UserViewModel call(GithubUser githubUser) {
                                        return new UserViewModel(githubUser.name, githubUser.public_repos, githubUser.public_gists);
                                    }
                                })
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<UserViewModel>() {
                                    @Override
                                    public void onCompleted() {

                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        e.printStackTrace();
                                    }

                                    @Override
                                    public void onNext(UserViewModel user) {
                                        TextView userView = new TextView(RetrofitExampleActivity.this);
                                        userView.setText(String.format(Locale.US, "%s: %d/%d", user.getUsername(), user.getPublicRepos(), user.getPublicGists()));
                                        container.addView(userView);
                                    }
                                });
                    }
                });
    }
//                .flatMap(new Func1<RealmResults<Person>, Observable<Person>>() {
//                    @Override
//                    public Observable<Person> call(RealmResults<Person> persons) {
//                        // Emit each person individually
//                        return Observable.from(persons);
//                    }
//                })
//                .flatMap(new Func1<Person, Observable<GithubUser>>() {
//                    @Override
//                    public Observable<GithubUser> call(Person person) {
//                        // get GitHub statistics. Retrofit automatically does this on a separate thread.
//                        return githubApi.user(person.getGithubUserName());
//                    }
//                }).map(new Func1<GithubUser, UserViewModel>() {
//                    @Override
//                    public UserViewModel call(GithubUser githubUser) {
//                        // Map Network model to our View model
//                        return new UserViewModel(githubUser.name, githubUser.public_repos, githubUser.public_gists);
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<UserViewModel>() {
//                    @Override
//                    public void call(UserViewModel user) {
//                        TextView userView = new TextView(RetrofitExampleActivity.this);
//                        userView.setText(String.format(Locale.US, "%s: %d/%d",user.getUsername(),user.getPublicRepos(),user.getPublicGists()));
//                        container.addView(userView);
//                    }
//
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        throwable.printStackTrace();
//                    }
//                });



    @Override
    protected void onPause() {
        super.onPause();
        subscription.unsubscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }


}
