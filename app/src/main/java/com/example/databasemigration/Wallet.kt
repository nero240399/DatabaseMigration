package com.example.databasemigration

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 1.0: id INTEGER PRIMARY KEY AUTOINCREMENT,
 * address TEXT, balance INTEGER,
 * pendingBalance INTEGER
 *
 * 2.0: id INTEGER PRIMARY KEY AUTOINCREMENT,
 * address TEXT, name TEXT, balance TEXT,
 * pendingBalance TEXT
 */
@Entity
data class Wallet(
    val address: String,
    val balance: String,
    val pendingBalance: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
