package com.example.mathpresso.realmpractice.retrofit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by mathpresso on 2016-10-14.
 */
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubUser {
    public String name;
    public int public_repos;
    public int public_gists;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public int getPublic_gists() {
        return public_gists;
    }

    public void setPublic_gists(int public_gists) {
        this.public_gists = public_gists;
    }
}
