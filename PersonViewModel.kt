package com.example.regitrationloginroom.newModel.viewmodel

import android.content.Intent
import android.provider.SyncStateContract.Helpers.insert
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.regitrationloginroom.LoginActivity
import com.example.regitrationloginroom.User
import com.example.regitrationloginroom.newModel.Event
import com.example.regitrationloginroom.newModel.Person

import com.example.regitrationloginroom.newModel.repository.PersonRepository
import kotlinx.coroutines.launch

class PersonViewModel(private val personRepository: PersonRepository) : ViewModel() {

    var firstname = MutableLiveData<String?>()
    var lastname = MutableLiveData<String?>()
    var email = MutableLiveData<String?>()
    var password = MutableLiveData<String?>()

    private val _message = MutableLiveData<Event<Int>>()



//    var cpassword = MutableLiveData<String?>()


    var saveOrUpdate = MutableLiveData<String>()
    var clearAllOrDelete = MutableLiveData<String>()

    private var isUpdateOrDelete = false
    private lateinit var personDatas: Person


    init {
        saveOrUpdate.value = "Save"
        clearAllOrDelete.value = "Clear All"
    }

    fun saveOrUpdateClick() {
//
//        val firstName: String = mBinding.firstName.text.toString()
//        val lastName: String = mBinding.lastName.text.toString()
//        val emailId: String = mBinding.emailId.text.toString()
//        val mobile : String = mBinding.mobile.text.toString()
//        val password: String = mBinding.password.text.toString()
//        val confirmPassword: String = mBinding.confirmPassword.text.toString()

//        val fname: String = firstname.value!!
//        val lname: String = lastname.value!!
//        val emails: String = email.value!!
////        val  : String = mBinding.mobile.text.toString()
//        val pass: String = password.value!!
//        val confirmPassword: String = cpassword.value!!

        if (firstname.value == "" || lastname.value == "" || email.value == "" || password.value == "") {

        }
        else{

            val fNameq = firstname.value!!
            val lNameq = lastname.value!!
            val emailds = email.value!!
            val passwordsq = password.value!!

            insertsdata(Person(0, fNameq, lNameq,emailds, passwordsq))


            firstname.value = null
            lastname.value = null
            email.value = null

            password.value = null
        }
//        if (fname.isEmpty()) {
//           Toast
//            return@OnClickListener
//
//        }
//
//        else if (lastName.isEmpty())
//        {
//            mBinding.lastName.setError("Field cannot be empty")
//            return@OnClickListener
//
//        }
//        else if (emailId.isEmpty())
//        {
//            mBinding.emailId.setError("Field cannot be empty")
//
//            return@OnClickListener
//
//        }
//        else if(mobile.isEmpty()){
//            mBinding.mobile.setError("Field cannot be empty")
//        }
//        else if (password.isEmpty())
//        {
//            mBinding.password.setError("Field cannot be empty")
//            return@OnClickListener
//
//        }
//        else if (confirmPassword.isEmpty())
//        {
//            mBinding.confirmPassword.setError("Field cannot be empty")
//            return@OnClickListener
//
//        }


//        if (password.equals(confirmPassword)){
//
//            var user = User( 0,firstName,lastName,emailId,password)
//            userDao.insert(user)
//
//
//            val moveToLogin = Intent(this, LoginActivity::class.java)
//            startActivity(moveToLogin)
//
//        }

//        personDatas.firstname = firstname.value!!
//        personDatas.lastname = lastname.value!!
//        personDatas.email = email.value!!
//        personDatas.password = password.value!!



//            saveOrUpdate.value = "Save"
//            clearAllOrDelete.value = "Clear All"

    }


    fun updateOrDeleteClick(person: Person){
        firstname.value = person.firstname
        lastname.value = person.lastname
        email.value = person.email
        password.value= person.password

        isUpdateOrDelete = true
        personDatas = person

        saveOrUpdate.value = "Update"
        clearAllOrDelete.value = "Delete"

    }

//    private fun clearAllOrDelete(){
//        if (isUpdateOrDelete){
//            delete(personDatas)
//
//            firstname.value = null
//            lastname.value = null
//            email.value = null
//            password.value = null
//
//            saveOrUpdate.value = "Save"
//            clearAllOrDelete.value = "Clear All"
//        }else{
//            clearAllOrDelete()
//        }
//    }



    private fun insertsdata(person: Person) {
        viewModelScope.launch {
            personRepository.inserts(person)
        }
    }

//    fun clearAll(){
//        viewModelScope.launch {
//            personRepository.deleteAll()
//            message.value = Event("All data cleared")
//        }
//    }
//
//    private fun update(person: Person){
//        viewModelScope.launch {
//            personRepository.update(person)
//            message.value = Event("Data update SuccessFully")
//        }
//    }
//    private fun delete(person: Person){
//        viewModelScope.launch {
//            personRepository.delete(person)
//            message.value = Event("Data delete SuccessFully")
//        }
//    }


    fun clearOrDeleteAll() {
        viewModelScope.launch {
            personRepository.deleteAll()
        }
    }

    val personList = personRepository.person
}