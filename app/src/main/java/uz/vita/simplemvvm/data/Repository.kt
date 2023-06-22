package uz.vita.simplemvvm.data

import uz.vita.simplemvvm.data.local.pref.SharedInterface
import uz.vita.simplemvvm.data.local.room.OsonDaoInterface
import uz.vita.simplemvvm.data.local.room.model.User
import uz.vita.simplemvvm.data.remote.ApiInterface
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val sharedInterface: SharedInterface,
    private val roomDaoInterface: OsonDaoInterface
) {

    suspend fun getUserCard() = apiInterface.getUserCard(sharedInterface.getToken())

    suspend fun saveToken(token: String) = sharedInterface.saveToken(token)

    fun saveUser(user: User) = roomDaoInterface.insertUser(user)

    fun getUserLocal() = roomDaoInterface.getUser()

}