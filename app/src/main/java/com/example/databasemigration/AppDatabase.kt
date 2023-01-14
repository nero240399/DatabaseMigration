package com.example.databasemigration

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Wallet::class, Transaction::class],
    version = 2,
    autoMigrations = [
            AutoMigration(from = 1, to = 2)
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract val walletDao: WalletDao
    abstract val transactionDao: TransactionDao
}