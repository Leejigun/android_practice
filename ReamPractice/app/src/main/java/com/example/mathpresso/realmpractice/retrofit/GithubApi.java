package com.example.mathpresso.realmpractice.retrofit;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by mathpresso on 2016-10-14.
 */
interface GithubApi {
    @GET("/users/{user}")
    Observable<GithubUser> user(@Path("user")String user);
}
