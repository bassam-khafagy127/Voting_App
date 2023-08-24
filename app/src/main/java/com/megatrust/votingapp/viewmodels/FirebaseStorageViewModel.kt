package com.megatrust.votingapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.megatrust.votingapp.data.Voter
import com.megatrust.votingapp.repositories.FirebaseStorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirebaseStorageViewModel @Inject constructor(private val repository: FirebaseStorageRepository) :
    ViewModel() {

    private val _uploadStatus = MutableLiveData<Boolean>()
    val uploadStatus: LiveData<Boolean> = _uploadStatus

    fun uploadVoting(voter: Voter) {
        repository.uploadVoting(voter)
    }

    fun getVote() {
       repository.getVote()
    }

}