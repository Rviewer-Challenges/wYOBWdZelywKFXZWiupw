package com.chrismagaa.simple_lector_rss.domain.usecases

import com.chrismagaa.simple_lector_rss.domain.model.Post
import com.chrismagaa.simple_lector_rss.repository.FeedRepository
import javax.inject.Inject

class GetPostsSavedUseCase @Inject constructor(private val feedRepository: FeedRepository){
    suspend operator fun invoke(): List<Post> {
        return feedRepository.fetchPostsSaved()
    }
}