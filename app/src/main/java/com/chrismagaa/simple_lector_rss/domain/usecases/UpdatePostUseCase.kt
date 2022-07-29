package com.chrismagaa.simple_lector_rss.domain.usecases

import com.chrismagaa.simple_lector_rss.data.persistence.entities.toLocalDB
import com.chrismagaa.simple_lector_rss.domain.model.Post
import com.chrismagaa.simple_lector_rss.repository.FeedRepository
import javax.inject.Inject

class UpdatePostUseCase @Inject constructor(
    private val postRepository: FeedRepository
) {
    suspend operator fun invoke(post: Post){
        postRepository.updatePost(post.toLocalDB())
    }
}