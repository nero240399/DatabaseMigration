package com.example.databasemigration

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Wallet::class, Transaction::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract val walletDao: WalletDao
    abstract val transactionDao: TransactionDao
}