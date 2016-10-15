package com.example.mathpresso.realmpractice.retrofit;

/**
 * Created by mathpresso on 2016-10-15.
 */
public class UserViewModel {
    private final String username;
    private final int publicRepos;
    private final int publicGists;

    public UserViewModel(String username, int publicRepos, int publicGists) {
        this.username = username;
        this.publicRepos = publicRepos;
        this.publicGists = publicGists;
    }

    public String getUsername() {
        return username;
    }

    public int getPublicRepos() {
        return publicRepos;
    }

    public int getPublicGists() {
        return publicGists;
    }
}
