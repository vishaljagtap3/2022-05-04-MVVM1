package com.bitcode.mvvmdemo.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
  var id : Int,
  var email : String,
  @SerializedName("first_name")
  var firstName : String,
  @SerializedName("last_name")
  var lastName : String,
  var avatar : String
)