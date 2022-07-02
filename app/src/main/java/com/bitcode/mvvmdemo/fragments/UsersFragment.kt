package com.bitcode.mvvmdemo.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bitcode.mvvmdemo.adapters.UsersAdapter
import com.bitcode.mvvmdemo.viewmodels.UsersViewModel
import com.bitcode.mvvmdemo.databinding.UsersFragmentBinding

class UsersFragment : Fragment() {

    private lateinit var binding : UsersFragmentBinding
    private lateinit var usersViewModel: UsersViewModel
    private lateinit var usersAdapter : UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = UsersFragmentBinding.inflate(inflater)

        initViewModels()
        initRecyclerView()
        initObservers()

        usersViewModel.getUsers()

        return binding.root
    }

    private fun initObservers() {
        usersViewModel.usersLiveData.observe(
            viewLifecycleOwner
        ) {

            Log.e("tag", "Got data")

            usersViewModel.usersLiveData.value!!.addAll(it)
            usersAdapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView() {

        usersAdapter = UsersAdapter(usersViewModel.usersLiveData!!.value!!)
        binding.recyclerUsers.adapter = usersAdapter
        binding.recyclerUsers.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    private fun initViewModels() {

        usersViewModel = ViewModelProvider(
            this
        ).get(UsersViewModel::class.java)

    }

}


