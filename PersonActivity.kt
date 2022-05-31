package com.example.regitrationloginroom.newModel.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.regitrationloginroom.R
import com.example.regitrationloginroom.databinding.ActivityMainBinding
import com.example.regitrationloginroom.newModel.dao.PersonDatabase
import com.example.regitrationloginroom.newModel.factory.PersonDetailsViewModelFactory
import com.example.regitrationloginroom.newModel.repository.PersonRepository
import com.example.regitrationloginroom.newModel.viewmodel.PersonViewModel

class PersonActivity : AppCompatActivity(){

    private lateinit var personViewModel: PersonViewModel
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding = ActivityPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.personRecyclerview.layoutManager = LinearLayoutManager(this)

        val dao = PersonDatabase.getInstance(this).dao
        val personRepository = PersonRepository(dao)
        val factory = PersonDetailsViewModelFactory(personRepository)
        personViewModel = ViewModelProvider(this, factory)[PersonViewModel::class.java]

        binding.personViewModel = personViewModel
        binding.lifecycleOwner = this

        displayPersonsList()

        personViewModel.navigateToDetails.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun displayPersonsList() {

    }


}