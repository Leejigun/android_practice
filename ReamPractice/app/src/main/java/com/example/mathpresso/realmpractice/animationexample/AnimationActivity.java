package com.example.mathpresso.realmpractice.animationexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mathpresso.realmpractice.R;
import com.example.mathpresso.realmpractice.model.Person;

import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

public class AnimationActivity extends AppCompatActivity {
    private Realm realm;
    private Subscription subscription;
    private ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = (ViewGroup) findViewById(R.id.container);
        realm = Realm.getDefaultInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();
        subscription = realm.where(Person.class).findAllAsync().asObservable()
                .flatMap(new Func1<RealmResults<Person>, Observable<Person>>() {
                    @Override
                    public Observable<Person> call(RealmResults<Person> persons) {
                        return Observable.from(persons);
                    }
                }).zipWith(Observable.interval(1, TimeUnit.SECONDS), new Func2<Person, Long, Person>() {
                    @Override
                    public Person call(Person person, Long aLong) {
                        return person;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Person>() {
                    @Override
                    public void call(Person user) {
                        TextView userView = new TextView(AnimationActivity.this);
                        userView.setText(user.getName());
                        container.addView(userView);
                    }
                });
    }
}
