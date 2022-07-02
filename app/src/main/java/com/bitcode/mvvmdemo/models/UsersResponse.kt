package com.bitcode.mvvmdemo.models

import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("page")
    var pageNumber : Int,
    @SerializedName("total_pages")
    var totalPages : Int,
    @SerializedName("data")
    var users : ArrayList<User>
)