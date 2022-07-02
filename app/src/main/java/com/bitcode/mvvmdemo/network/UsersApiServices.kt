package com.bitcode.mvvmdemo.network

import com.bitcode.mvvmdemo.models.UsersResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UsersApiServices {

    @GET("users?")
    suspend fun getUsers(
        @Query("page") pageNumber : Int
    ): UsersResponse

    companion object {
        var usersApiServices: UsersApiServices? = null

        fun getInstance(): UsersApiServices {

            if (usersApiServices == null) {
                var retrofit = Retrofit.Builder()
                    .baseUrl("https://reqres.in/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                usersApiServices = retrofit.create(UsersApiServices::class.java)
            }

            return usersApiServices!!
        }
    }

}