package com.example.mathpresso.realmpractice.retrofit;

import android.app.Application;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by mathpresso on 2016-10-15.
 */
public class AppController extends Application {
    private static Retrofit mRetrofit;
    private static AppController mInstance;

    public synchronized static AppController getInstance(){ return mInstance; }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public  GithubApi createGitHubApi(){
        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(AUTHENTICATION_INTERCEPTOR)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okClient)
                .build();
        return mRetrofit.create(GithubApi.class);
    }

    private static final Interceptor AUTHENTICATION_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            String githubToken = "6c0e1bff043e277178fbbec10f31e0f0f51c0240";
            Request original = chain.request();
            Request.Builder builder = original.newBuilder().addHeader("Authorization", String.format("token %s", githubToken));
            Request request = builder.build();
            Response response = chain.proceed(request);
            return response;
        }
    };
}
