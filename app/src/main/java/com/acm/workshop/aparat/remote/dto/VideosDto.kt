package com.acm.workshop.aparat.remote.dto

import com.google.gson.annotations.SerializedName


data class VideosDto(
    @SerializedName("mostviewedvideos") val mostviewedvideos: List<Mostviewedvideo>,
    @SerializedName("ui") val ui: Ui?
)