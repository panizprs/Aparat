package com.acm.workshop.aparat.remote.dto

import com.google.gson.annotations.SerializedName


data class Ui(
    @SerializedName("pagingBack")
    val pagingBack: String?,
    @SerializedName("pagingForward")
    val pagingForward: String?
)