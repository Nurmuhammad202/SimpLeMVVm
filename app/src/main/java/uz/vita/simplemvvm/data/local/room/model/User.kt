package uz.vita.simplemvvm.data.local.room.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey var userId: Int = 0,
    var firstName: String?,
    @Embedded var address: Address?
) {
    constructor() : this(0, "", null)
}