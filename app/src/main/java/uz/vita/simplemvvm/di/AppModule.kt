package uz.vita.simplemvvm.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.vita.simplemvvm.data.Repository
import uz.vita.simplemvvm.data.local.pref.SharedInterface
import uz.vita.simplemvvm.data.local.pref.SharedPrefRepository
import uz.vita.simplemvvm.data.local.room.OsonDaoInterface
import uz.vita.simplemvvm.data.local.room.appDatabase.AppDatabase
import uz.vita.simplemvvm.data.remote.ApiInterface
import uz.vita.simplemvvm.data.remote.RetrofitBuilder
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitGetServer(): ApiInterface {
        return RetrofitBuilder.apiInterfaceBuilder()
    }

    @Singleton
    @Provides
    fun getAppDB(context: Application): AppDatabase {
        return AppDatabase.getDataDB(context)
    }

    @Singleton
    @Provides
    fun getDao(appDB: AppDatabase): OsonDaoInterface {
        return appDB.dao()
    }

    @Provides
    @Singleton
    fun provideSharedPref(@ApplicationContext context: Context): SharedInterface {
        return SharedPrefRepository(context)
    }

    @Provides
    @Singleton
    fun provideRemoteRepository(
        apiInterface: ApiInterface,
        sharedPrefRepository: SharedInterface,
        osonDaoInterface: OsonDaoInterface
    ): Repository {
        return Repository(
            apiInterface = apiInterface,
            sharedInterface = sharedPrefRepository,
            roomDaoInterface = osonDaoInterface
        )
    }



}