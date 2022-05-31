package com.example.regitrationloginroom.newModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.regitrationloginroom.newModel.repository.PersonRepository
import com.example.regitrationloginroom.newModel.viewmodel.PersonViewModel

class PersonDetailsViewModelFactory (private val personRepository: PersonRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonViewModel::class.java)){
            return PersonViewModel(personRepository) as T
        }
        throw IllegalArgumentException("ViewModel Not Found")
    }
}