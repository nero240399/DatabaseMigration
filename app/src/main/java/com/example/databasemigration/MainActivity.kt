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
        ).addMigrations(AppDatabase.migration3To4).build()

        lifecycleScope.launch {
            db.walletDao.getWallets().forEach(::println)
            db.transactionDao.getTransactions().forEach(::println)
            db.nodeDao.getNodes().forEach(::println)
        }

/*        lifecycleScope.launch {
            (1..3000).forEach {
                db.nodeDao.insertNode(
                    Node(
                        ip = "192 $it",
                        port = it,
                        time = it
                    )
                )
            }
        }*/
    }
}