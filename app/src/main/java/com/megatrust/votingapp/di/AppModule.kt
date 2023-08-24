package com.megatrust.votingapp.di

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.megatrust.votingapp.repositories.FirebaseStorageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseStorageRepository(storage: FirebaseFirestore): FirebaseStorageRepository {
        return FirebaseStorageRepository(storage)
    }

    @Provides
    @Singleton
    fun provideFireStoreDataBase(@ApplicationContext appContext: Context): FirebaseFirestore {
        FirebaseApp.initializeApp(appContext) // Initialize Firebase
        return FirebaseFirestore.getInstance()
    }
}
