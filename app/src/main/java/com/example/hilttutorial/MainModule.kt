package com.example.hilttutorial

import android.app.Activity
import android.content.Context
import androidx.core.app.ActivityCompat
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object MainModule {

    @ActivityScoped                                                                                 // hey this String lives as long as our Activity
    @Provides
    @Named("String2")
    fun provideTestString2(
        @ApplicationContext context: Context,                                                       // @ApplicationContext comes from MyApplication.kt that we build it .
        @Named("String1") testString1: String
    ) = "${context.getString(R.string.string_to_inject)} - $testString1"                            // we access to testString1 with top line . (actually use other dependency in the constructor)

    //Note : for use String that comes from String.xml , we must have context ., so we get from  " @ApplicationContext context: Context "
}