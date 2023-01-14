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

        (1..3000).forEach {
            lifecycleScope.launch {
                db.walletDao.insertWallet(
                    Wallet(
                        address = "123456 $it",
                        balance = it,
                        pendingBalance = 3000 - it
                    )
                )
            }
            lifecycleScope.launch {
                db.transactionDao.insertTransaction(
                    Transaction(
                        hash = "123456 $it",
                        address = "123456 $it",
                        toAddress = "123456 $it",
                        pubKey = "123456 $it",
                        amount = it,
                        pendingUse = it,
                        balance = it,
                        fee = it,
                        tip = it,
                        message = "123456 $it",
                        time = it,
                        status = it,
                        type = "123456 $it",
                        prevHash = "123456 $it",
                        sign = "123456 $it",
                        receiveInfo = "123456 $it",
                        isDeploy = it,
                        isCall = it,
                        functionCall = "123456 $it"
                    )
                )
            }
        }
    }
}