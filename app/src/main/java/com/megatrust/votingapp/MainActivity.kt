package com.megatrust.votingapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.megatrust.votingapp.databinding.ActivityMainBinding
import com.megatrust.votingapp.utills.Vote
import com.megatrust.votingapp.utills.notVotedBefore
import com.megatrust.votingapp.utills.votedBefore
import com.megatrust.votingapp.viewmodels.FirebaseStorageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<FirebaseStorageViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeExistStatus(this)

        binding.apply {

            queryButton.setOnClickListener {
                val id = binding.idET.text?.trim().toString()
                viewModel.checkIfISVoteBefore(id)
            }
        }

    }

    private fun observeExistStatus(context: Context) {
        viewModel.existStatus.observe(this) { isVoted ->
            when (isVoted) {
                Vote.EXIST -> {
                    val number =
                        "${resources.getString(R.string.id)} (${binding.idET.text.toString()}) ${
                            resources.getString(R.string.eventVotedBefore)
                        }"
                    votedBefore(context, "$number")
                }

                Vote.NOT_EXIST -> {
                    val number =
                        "${resources.getString(R.string.id)} (${binding.idET.text.toString()}) ${
                            resources.getString(R.string.eventNeverVotedBefore)
                        }"
                    notVotedBefore(context, "$number")
                }
            }
        }
    }
}