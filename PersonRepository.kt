package com.example.regitrationloginroom.newModel.repository


import com.example.regitrationloginroom.newModel.Person
import com.example.regitrationloginroom.newModel.dao.PersonDao

class PersonRepository(private val dao: PersonDao) {

    suspend fun inserts(person: Person) {
        dao.insertPerson(person)
    }

    suspend fun update(person: Person) {
        dao.updatePerson(person)
    }

    suspend fun delete(person: Person) {
        dao.deletePerson(person)
    }

    suspend fun deleteAll() {
        dao.deleteAllPerson()
    }

    val person =dao.getUser()
}