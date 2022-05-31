package com.example.regitrationloginroom.newModel.dao

import androidx.lifecycle.LiveData
import androidx.room.*

import com.example.regitrationloginroom.newModel.Person

@Dao
interface PersonDao {

    @Insert
    suspend fun insertPerson(person: Person)

    @Update
    suspend fun updatePerson(person: Person)

    @Delete
    suspend fun deletePerson(person: Person)

    @Query("SELECT * FROM person_details")
    fun getUser(): LiveData<List<Person>>

    @Query("DELETE FROM person_details")
    suspend fun deleteAllPerson()
}