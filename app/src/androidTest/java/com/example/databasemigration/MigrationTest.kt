package com.example.databasemigration

import androidx.core.database.getStringOrNull
import androidx.room.Room
import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

private const val DB_NAME = "test"

@RunWith(AndroidJUnit4::class)
class MigrationTest {

    @get:Rule
    val helper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        AppDatabase::class.java,
        emptyList(),
        FrameworkSQLiteOpenHelperFactory()
    )

    @Test
    fun migration1To2_containsCorrectData() {
        helper.createDatabase(DB_NAME, 1).apply {
            execSQL("INSERT INTO wallet VALUES('123456 1', '1', '2999', '1')")
            execSQL("INSERT INTO `transaction` VALUES ('123456 1', '123456 1', '123456 1', '123456 1', '1', '1', '1', '1', '1', '123456 1', '1', '1', '123456 1', '123456 1', '123456 1', '123456 1', '1', '1', '123456 1', '1')")
            close()
        }

        val db = helper.runMigrationsAndValidate(DB_NAME, 2, true)

        db.query("SELECT * FROM wallet").apply {
            assertThat(moveToFirst()).isTrue()
            assertThat(getStringOrNull(getColumnIndex("balance")) is String).isTrue()
            assertThat(getStringOrNull(getColumnIndex("pendingBalance")) is String).isTrue()
        }

        db.query("SELECT * FROM `transaction`").apply {
            assertThat(moveToFirst()).isTrue()
            assertThat(getStringOrNull(getColumnIndex("amount")) is String).isTrue()
            assertThat(getStringOrNull(getColumnIndex("pendingUse")) is String).isTrue()
            assertThat(getStringOrNull(getColumnIndex("balance")) is String).isTrue()
            assertThat(getStringOrNull(getColumnIndex("fee")) is String).isTrue()
            assertThat(getStringOrNull(getColumnIndex("tip")) is String).isTrue()
            assertThat(getString(getColumnIndex("data"))).isEqualTo("")
            assertThat(getString(getColumnIndex("total_balance"))).isEqualTo("")
        }
    }

    @Test
    fun migration2to3_containsCorrectData() {
        helper.createDatabase(DB_NAME, 1).apply {
            execSQL("INSERT INTO wallet VALUES('123456 1', '1', '2999', '1')")
            execSQL("INSERT INTO `transaction` VALUES ('123456 1', '123456 1', '123456 1', '123456 1', '1', '1', '1', '1', '1', '123456 1', '1', '1', '123456 1', '123456 1', '123456 1', '123456 1', '1', '1', '123456 1', '1')")
            close()
        }

        val db = helper.runMigrationsAndValidate(DB_NAME, 3, true)

        Room.databaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            AppDatabase::class.java,
            DB_NAME
        ).addMigrations(AppDatabase.migration3To4).build().apply {
            openHelper.writableDatabase.close()
        }

        db.query("SELECT * FROM wallet").apply {
            assertThat(moveToFirst()).isTrue()
            assertThat(getString(getColumnIndex("total_balance"))).isEqualTo("")
        }
    }

    @Test
    fun testAllMigrations() {
        helper.createDatabase(DB_NAME, 1).apply { close() }

        Room.databaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            AppDatabase::class.java,
            DB_NAME
        ).addMigrations(AppDatabase.migration3To4).build().apply {
            openHelper.writableDatabase.close()
        }
    }
}