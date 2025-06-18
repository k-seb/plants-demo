package com.seba.plantsorganizer.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.seba.plantsorganizer.data.model.PlantEntity

const val DB_VERSION = 2

@Database(entities = [PlantEntity::class], version = DB_VERSION)
abstract class PlantsDatabase : RoomDatabase() {

    abstract fun plantDao(): PlantDAO
}