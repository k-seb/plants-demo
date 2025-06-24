package com.seba.plantsorganizer.di

import android.app.Application
import androidx.room.Room
import com.seba.plantsorganizer.BuildConfig
import com.seba.plantsorganizer.core.constants.C.DATABASE_NAME
import com.seba.plantsorganizer.data.local.PlantDAO
import com.seba.plantsorganizer.data.local.PlantsDatabase
import com.seba.plantsorganizer.data.local.migration.MIGRATION_1_2
import com.seba.plantsorganizer.data.model.PlantEntity
import com.seba.plantsorganizer.data.repository.PlantsRepositoryImpl
import com.seba.plantsorganizer.domain.repository.PlantsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
    fun providePlantsDao(db: PlantsDatabase): PlantDAO {
        val dao = db.plantDao()

        if (BuildConfig.DEBUG) {
            CoroutineScope(Dispatchers.IO).launch {
                val isEmpty = dao.countPlants() == 0
                if (isEmpty) {
                    dao.insertAll(
                        PlantEntity(
                            id = 1L,
                            name = "Monstera",
                            description = "Duża roślina doniczkowa z charakterystycznymi dziurami w liściach.",
                            photoPath = "",
                            isFavourite = true
                        ),
                        PlantEntity(
                            id = 2L,
                            name = "Bazylia",
                            description = "Popularne zioło używane w kuchni, szczególnie we włoskich potrawach.",
                            photoPath = "",
                            isFavourite = false
                        ),
                        PlantEntity(
                            id = 3L,
                            name = "Pilea",
                            description = "Roślina o okrągłych liściach, znana jako 'pieniążek'.",
                            photoPath = "",
                            isFavourite = true
                        ),
                        PlantEntity(
                            id = 4L,
                            name = "Sansewieria",
                            description = "Roślina o sztywnych, mieczowatych liściach – bardzo odporna.",
                            photoPath = "",
                            isFavourite = false
                        ),
                        PlantEntity(
                            id = 5L,
                            name = "Aloes",
                            description = "Roślina o mięsistych liściach, znana ze swoich właściwości leczniczych.",
                            photoPath = "",
                            isFavourite = false
                        ),
                        PlantEntity(
                            id = 6L,
                            name = "Fikus sprężysty",
                            description = "Popularna roślina domowa o dużych, błyszczących liściach.",
                            photoPath = "",
                            isFavourite = false
                        )
                    )
                }
            }
        }

        return dao
    }

    @Provides
    @Singleton
    fun providePlantsRepository(dao: PlantDAO): PlantsRepository {
        return PlantsRepositoryImpl(dao)
    }
}