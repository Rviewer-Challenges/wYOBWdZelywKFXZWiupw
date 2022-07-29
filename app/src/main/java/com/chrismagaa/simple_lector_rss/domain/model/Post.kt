package com.chrismagaa.simple_lector_rss.domain.model

import android.os.Parcelable
import com.chrismagaa.simple_lector_rss.Item
import com.chrismagaa.simple_lector_rss.data.persistence.entities.PostEntity
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.*


@Parcelize
class Post(
    val title: String,
    val date: Date,
    val titleBlog: String,
    val link: String,
    var description: String,
    var isFavorite: Boolean,
): Parcelable{

    fun getPictureURLFromDescription(): String {
        val pattern = "<img[^>]*src=\"([^\"]+)\"[^?]*>"
            val regex = Regex(pattern)
            val match = regex.find(this.description)
            var url = match?.groupValues?.get(1) ?: ""
            url = url.replace("http","https")
            return url
    }

    fun getDateFormatted(): String {
        val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.US)
        return sdf.format(this.date)
    }
}


fun Item.toDomain() = Post(
    title = title,
    titleBlog = titleBlog?: "",
    date = date,
    description = description,
    link = link,
    isFavorite = false
)

fun PostEntity.toDomain() = Post(
    title = title,
    titleBlog = titleBlog,
    date = date,
    description = description,
    link = link,
    isFavorite = isFavorite
)