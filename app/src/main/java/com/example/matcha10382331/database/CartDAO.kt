package com.example.matcha10382331.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CartDAO {
    @Query("SELECT * FROM CartModel")
    fun getAll(): List<CartModel>

    @Insert
    fun InsertAll(vararg item: CartModel)
}