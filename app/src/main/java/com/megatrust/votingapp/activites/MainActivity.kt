package com.megatrust.votingapp.activites

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.megatrust.votingapp.R
import com.megatrust.votingapp.data.Voter
import com.megatrust.votingapp.viewmodels.FirebaseStorageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<FirebaseStorageViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    // ... UI setup and interaction ...

    private fun uploadData() {

    }
}