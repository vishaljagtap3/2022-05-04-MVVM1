package com.bitcode.mvvmdemo.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitcode.mvvmdemo.network.UsersApiServices
import com.bitcode.mvvmdemo.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsersViewModel : ViewModel() {

    var pageNumber = 0
    //var users = ArrayList<User>()

    var usersLiveData = MutableLiveData<ArrayList<User>>(  ArrayList<User>() )

    var usersApiServices = UsersApiServices.getInstance()

    fun getUsers() {

        CoroutineScope(Dispatchers.IO).launch {
            var usersResponse = usersApiServices.getUsers(++pageNumber)

            withContext(Dispatchers.Main) {
                //usersLiveData.value!!.addAll(usersResponse.users)
                usersLiveData.postValue(usersResponse.users)
            }

        }


    }

}