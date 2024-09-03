package com.example.jantricolorapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.jantricolorapp.data.ColorDatabase
import com.example.jantricolorapp.data.ColorRepository
import com.example.jantricolorapp.data.ColorRepositoryImpl
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
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
    fun provideColorDatabase(app: Application): ColorDatabase{
        return Room.databaseBuilder(
            app,
            ColorDatabase::class.java,
            "color_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideColorRepo(db: ColorDatabase) : ColorRepository{
        return ColorRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideFirestore(): FirebaseFirestore {
        val firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(true)
            .build()
        return firestore
    }

    @Provides
    @Singleton
    fun provideApplicationContext(@ApplicationContext context: Context): Context {
        return context
    }
}