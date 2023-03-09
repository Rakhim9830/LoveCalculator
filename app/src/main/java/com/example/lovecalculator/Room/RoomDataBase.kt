package com.example.lovecalculator.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculator.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract  class RoomDataBase: RoomDatabase() {
abstract fun loveDao():Dao
}