package uz.vita.simplemvvm.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.vita.simplemvvm.data.local.room.model.User

@Dao
interface OsonDaoInterface {

    @Query("SELECT * FROM user")
    fun getUser(): LiveData<List<User>>

    @Insert
    fun insertUser(user: User)
}