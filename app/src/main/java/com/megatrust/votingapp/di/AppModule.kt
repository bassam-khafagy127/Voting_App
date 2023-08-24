package com.megatrust.votingapp.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.megatrust.votingapp.repositories.FirebaseStorageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideFireStoreDataBase() = FirebaseFirestore.getInstance()
}
