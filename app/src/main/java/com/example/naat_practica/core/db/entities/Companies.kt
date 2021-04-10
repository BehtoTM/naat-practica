package com.example.naat_practica.core.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "companies")
data class Companies(
        @PrimaryKey var id: Int,
        @ColumnInfo(name = "company_name") var name: String? = null,
        @ColumnInfo(name = "type_recharge") var type: String? = null,
        @ColumnInfo(name = "company_icon") var icon: Int? = null
) {
    constructor(): this(0, "", "", null)

    override fun toString(): String {
        return "MODEL: {\nid: $id,\nname: $name,\ntype: $type,\nicon: $icon\n}"
    }
}