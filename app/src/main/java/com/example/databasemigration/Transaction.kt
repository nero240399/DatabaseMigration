package com.example.databasemigration

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 1.0: Bảng transaction gồm có các cột: id INTEGER PRIMARY KEY AUTOINCREMENT,
 * hash TEXT, address TEXT,
 * toAddress TEXT, pubKey TEXT,
 * amount INTEGER, pendingUse INTEGER,
 * balance INTEGER, fee INTEGER,
 * tip INTEGER, message TEXT,
 * time INTEGER, status INTEGER,
 * type TEXT,prevHash TEXT,
 * sign TEXT,receive_info TEXT,
 * isDeploy INTEGER,isCall INTEGER,
 * functionCall TEXT
 */
@Entity
data class Transaction(
    val hash: String,
    val address: String,
    val toAddress: String,
    val pubKey: String,
    val amount: Int,
    val pendingUse: Int,
    val balance: Int,
    val fee: Int,
    val tip: Int,
    val message: String,
    val time: Int,
    val status: Int,
    val type: String,
    val prevHash: String,
    val sign: String,
    val receiveInfo: String,
    val isDeploy: Int,
    val isCall: Int,
    val functionCall: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)