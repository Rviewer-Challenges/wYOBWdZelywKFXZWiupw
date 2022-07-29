package com.chrismagaa.simple_lector_rss.data.persistence.entities

import androidx.room.*
import com.chrismagaa.simple_lector_rss.domain.model.Post
import java.util.*

@Entity(tableName = "post_table", primaryKeys = [ "title"])
data class PostEntity @JvmOverloads constructor(
    @ColumnInfo(name = "title")
    val title: String,
    val date: Date,
    val titleBlog: String,
    val link: String,
    val description: String,
    val isFavorite: Boolean
)

fun Post.toLocalDB() = PostEntity (
        title = title,
        titleBlog = titleBlog,
        date = date,
        link = link,
        description = description,
        isFavorite = isFavorite)

