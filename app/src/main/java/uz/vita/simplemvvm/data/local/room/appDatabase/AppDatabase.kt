package uz.vita.simplemvvm.data.local.room.appDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.vita.simplemvvm.data.local.room.OsonDaoInterface
import uz.vita.simplemvvm.data.local.room.model.Address
import uz.vita.simplemvvm.data.local.room.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): OsonDaoInterface

    companion object {
        private var dbINSTANCE: AppDatabase? = null

        fun getDataDB(context: Context): AppDatabase {
            if (dbINSTANCE == null) {
                dbINSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Oson"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return dbINSTANCE!!
        }
    }
}