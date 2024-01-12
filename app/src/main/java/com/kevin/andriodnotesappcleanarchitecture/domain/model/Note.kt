package com.kevin.andriodnotesappcleanarchitecture.domain.model

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val timeStamp: Long,
    val timeStampToDisplay: String? = ""
)