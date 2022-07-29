package com.chrismagaa.simple_lector_rss.data.network

import com.chrismagaa.simple_lector_rss.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class FeedClient @Inject constructor(private val feedService: FeedService){

    suspend fun getFeed(url: String): List<Item>{
        return withContext(Dispatchers.IO){
            val response = feedService.getRSSFeed(url)
            for(responseItem in response.body()!!.channel!!.itemList!!){
                responseItem.titleBlog = response.body()!!.channel?.title?: ""
            }
             response.body()?.channel?.itemList?: emptyList()
        }

    }

}