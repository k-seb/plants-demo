package com.seba.plantsorganizer.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.seba.plantsorganizer.core.constants.C
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = C.TABLE_NAME_PLANTS)
data class PlantEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String = "",
    val description: String = "",
    val photoPath: String = "",
    val isFavourite: Boolean = false,
) : Parcelable