package com.chrismagaa.simple_lector_rss.data.network

import com.chrismagaa.simple_lector_rss.RSSResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface FeedService {


    @GET
    suspend fun getRSSFeed(@Url url: String): Response<RSSResponse>


}