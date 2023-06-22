package uz.vita.simplemvvm.data.local.pref

interface SharedInterface {
    fun getToken(): String

    suspend fun saveToken(token: String)

    fun saveLang(lang: String)

    fun getLang(): String
}