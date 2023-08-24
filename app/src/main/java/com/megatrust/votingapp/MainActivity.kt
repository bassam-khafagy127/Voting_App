package com.megatrust.votingapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.megatrust.votingapp.data.Voter
import com.megatrust.votingapp.databinding.ActivityMainBinding
import com.megatrust.votingapp.viewmodels.FirebaseStorageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val viewModel by viewModels<FirebaseStorageViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            voteData.setOnClickListener {
                uploadVote()
            }

            getData.setOnClickListener {
                getVote()
            }
        }

    }

    // ... UI setup and interaction ...

    private fun uploadVote() {
        viewModel.uploadVoting(Voter("300025546416488548", true))
    }

    private fun getVote() {
        viewModel.getVote()
    }
}