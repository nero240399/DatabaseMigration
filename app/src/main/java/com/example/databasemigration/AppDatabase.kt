package com.example.databasemigration

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [Wallet::class, Transaction::class, Node::class],
    version = 4,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3)
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract val walletDao: WalletDao
    abstract val transactionDao: TransactionDao
    abstract val nodeDao: NodeDao

    companion object {
        val migration3To4 = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "CREATE TABLE IF NOT EXISTS node (" +
                            "ip TEXT NOT NULL, " +
                            "port INTEGER NOT NULL, " +
                            "time INTEGER NOT NULL, " +
                            "id INTEGER NOT NULL PRIMARY KEY)"
                )
            }
        }
    }
}