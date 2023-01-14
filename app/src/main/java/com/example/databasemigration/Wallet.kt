package com.example.databasemigration

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 1.0: Bảng wallet gồm có các cột: id INTEGER PRIMARY KEY AUTOINCREMENT,
 * address TEXT, balance INTEGER,
 * pendingBalance INTEGER
 */
@Entity
data class Wallet(
    val address: String,
    val balance: Int,
    val pendingBalance: Int,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
