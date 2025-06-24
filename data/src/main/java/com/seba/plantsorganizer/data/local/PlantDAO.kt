package com.seba.plantsorganizer.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.seba.plantsorganizer.data.model.PlantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantDAO {
    @Query("SELECT * FROM plants")
    fun getPlants(): Flow<List<PlantEntity>>

    @Query("SELECT * FROM plants WHERE id = :id")
    fun getPlantById(id: Long): Flow<PlantEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPlant(plantEntity: PlantEntity)

    @Delete
    fun removePlant(plantEntity: PlantEntity)

    @Query("SELECT COUNT(*) FROM plants")
    suspend fun countPlants(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg plants: PlantEntity)
}