package com.seba.plantsorganizer.di

import android.app.Application
import androidx.room.Room
import com.seba.plantsorganizer.core.constants.C.DATABASE_NAME
import com.seba.plantsorganizer.data.local.PlantDAO
import com.seba.plantsorganizer.data.local.PlantsDatabase
import com.seba.plantsorganizer.data.local.migration.MIGRATION_1_2
import com.seba.plantsorganizer.data.repository.PlantsRepositoryImpl
import com.seba.plantsorganizer.domain.repository.PlantsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): PlantsDatabase {
        return Room.databaseBuilder(
            app,
            PlantsDatabase::class.java,
            DATABASE_NAME
        )
            .addMigrations(MIGRATION_1_2)
            .build()
    }

    @Provides
    @Singleton
    fun providePlantDao(db: PlantsDatabase) = db.plantDao()

    @Provides
    @Singleton
    fun providePlantsRepository(dao: PlantDAO): PlantsRepository {
        return PlantsRepositoryImpl(dao)
    }
}