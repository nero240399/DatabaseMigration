package com.example.databasemigration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_database.db"
        ).build()

        lifecycleScope.launch {
            db.walletDao.getWallets().forEach(::println)
            db.transactionDao.getTransactions().forEach(::println)
        }
    }
}