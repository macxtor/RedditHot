package com.example.reddit_wombat.data.remote.api

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditApi {


    @GET("/top.json")
    fun getDeferredTop(
        @Query("after") after: String,
        @Query("limit") limit: String
    ): Deferred<RedditNewsResponse>


}