package com.acm.workshop.aparat.remote.dto

import com.google.gson.annotations.SerializedName


data class Mostviewedvideo(
    @SerializedName("autoplay")
    val autoplay: Boolean?,
    @SerializedName("big_poster")
    val bigPoster: String?,
    @SerializedName("create_date")
    val createDate: String?,
    @SerializedName("360d")
    val d: Boolean?,
    @SerializedName("deleteurl")
    val deleteurl: String?,
    @SerializedName("duration")
    val duration: String?,
    @SerializedName("frame")
    val frame: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("isHidden")
    val isHidden: Boolean?,
    @SerializedName("official")
    val official: String?,
    @SerializedName("process")
    val process: String?,
    @SerializedName("profilePhoto")
    val profilePhoto: String?,
    @SerializedName("sdate")
    val sdate: String?,
    @SerializedName("sdate_timediff")
    val sdateTimediff: Int?,
    @SerializedName("small_poster")
    val smallPoster: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("uid")
    val uid: String?,
    @SerializedName("userid")
    val userid: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("video_date_status")
    val videoDateStatus: String?,
    @SerializedName("visit_cnt")
    val visitCnt: Int?
)