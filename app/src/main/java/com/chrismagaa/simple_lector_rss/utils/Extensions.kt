package com.chrismagaa.simple_lector_rss.utils

import android.os.Build
import android.text.Html
import android.text.Spanned
import android.util.Log
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun String.fromHTMLToSpanned(): Spanned{
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    } else {
        Html.fromHtml(this);
    }
}





