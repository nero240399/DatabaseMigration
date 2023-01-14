package com.example.databasemigration

import androidx.room.ColumnInfo
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
 *
 * 3.0: id INTEGER PRIMARY KEY AUTOINCREMENT,
 * address TEXT, name TEXT,
 * balance TEXT, pendingBalance TEXT,
 * totalBalance TEXT
 */
@Entity
data class Wallet(
    val address: String,
    val balance: String,
    val pendingBalance: String,
    @ColumnInfo(name = "total_balance", defaultValue = "")
    val totalBalance: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
