package com.sukenda.mvp.service;


import com.sukenda.mvp.entity.Repository;
import com.sukenda.mvp.entity.User;

import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Url;

/**
 * Created by sukenda on 21/04/16.
 * Project : MVP
 * Email : soekenda09@gmail.com
 */
public interface GithubService {

    @GET("users/{username}/repos")
    Call<List<Repository>> publicRepositories(@Path("username") String username);

    @GET
    Call<User> userFromUrl(@Url String userUrl);

    class Factory {
        public static GithubService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            return retrofit.create(GithubService.class);
        }
    }
}
