package com.example.databasemigration

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 3.0: id INTEGER PRIMARY KEY AUTOINCREMENT,
 * ip TEXT, port INTEGER,
 * time INTEGER
 */
@Entity
data class Node(
    val ip: String,
    val port: Int,
    val time: Int,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)