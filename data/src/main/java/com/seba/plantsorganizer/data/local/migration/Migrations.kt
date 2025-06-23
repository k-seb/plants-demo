package com.seba.plantsorganizer.data.local.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        // Tworzymy nową tabelę z aktualną strukturą
        db.execSQL(
            """
            CREATE TABLE IF NOT EXISTS plants_new (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                name TEXT NOT NULL,
                description TEXT NOT NULL,
                photoPath TEXT NOT NULL,
                isFavourite INTEGER NOT NULL
            )
            """.trimIndent()
        )

        // Przenosimy dane: nowy id, puste description/photoPath
        db.execSQL(
            """
            INSERT INTO plants_new (id, name, description, photoPath, isFavourite)
            SELECT NULL, name, '', '', isFavourite FROM plants
            """.trimIndent()
        )

        // Usuwamy starą tabelę
        db.execSQL("DROP TABLE plants")

        // Zmieniamy nazwę nowej tabeli
        db.execSQL("ALTER TABLE plants_new RENAME TO plants")
    }
}
