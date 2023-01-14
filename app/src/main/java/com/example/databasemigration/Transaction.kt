package com.example.databasemigration

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 1.0: id INTEGER PRIMARY KEY AUTOINCREMENT,
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
 *
 * 2.0: id INTEGER PRIMARY KEY AUTOINCREMENT,
 * hash TEXT, address TEXT,
 * toAddress TEXT, pubKey TEXT,
 * amount TEXT, pendingUse TEXT,
 * balance TEXT, fee TEXT,
 * tip TEXT, message TEXT,
 * time INTEGER, status INTEGER,
 * type TEXT, prevHash TEXT,
 * sign TEXT, receive_info TEXT,
 * isDeploy INTEGER, isCall INTEGER,
 * functionCall TEXT, data TEXT,
 * totalBalance TEXT
 */
@Entity
data class Transaction(
    val hash: String,
    val address: String,
    val toAddress: String,
    val pubKey: String,
    val amount: String,
    val pendingUse: String,
    val balance: String,
    val fee: String,
    val tip: String,
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
    @ColumnInfo(name = "data", defaultValue = "")
    val data: String,
    @ColumnInfo(name = "total_balance", defaultValue = "")
    val totalBalance: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)