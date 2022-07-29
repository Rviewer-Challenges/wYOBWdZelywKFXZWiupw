package com.chrismagaa.simple_lector_rss.domain.usecases

import com.chrismagaa.simple_lector_rss.repository.FeedRepository
import com.chrismagaa.simple_lector_rss.data.persistence.entities.toLocalDB
import com.chrismagaa.simple_lector_rss.domain.model.Post
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val feedRepository: FeedRepository) {

    suspend operator fun invoke(urls: List<String>): List<Post> {
        val posts = feedRepository.fetchFeedFromRSS(urls)

         if(posts.isNotEmpty()) {
             feedRepository.clearFeed()
             feedRepository.insertFeed(posts.map { it.toLocalDB() })
         }

        return feedRepository.fetchFeedFromLocalDB()
    }
}