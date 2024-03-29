package com.gnacoding.submissionbfaa.data.data_source.remote

import com.gnacoding.submissionbfaa.domain.model.SearchResponse
import com.gnacoding.submissionbfaa.domain.model.User
import com.gnacoding.submissionbfaa.domain.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token ${Constants.GITHUB_TOKEN}")
    fun searchUser(@Query("q") query: String): Call<SearchResponse>

    @GET("users/{username}")
    @Headers("Authorization: token ${Constants.GITHUB_TOKEN}")
    fun getDetailUser(@Path("username") username: String): Call<User>

    @GET("users/{username}/followers")
    @Headers("Authorization: token ${Constants.GITHUB_TOKEN}")
    fun getFollowers(@Path("username") username: String): Call<List<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token ${Constants.GITHUB_TOKEN}")
    fun getFollowing(@Path("username") username: String): Call<List<User>>
}