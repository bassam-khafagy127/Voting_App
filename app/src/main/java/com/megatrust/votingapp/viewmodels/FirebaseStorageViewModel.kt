package com.megatrust.votingapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.megatrust.votingapp.data.Voter
import com.megatrust.votingapp.repositories.FirebaseStorageRepository
import com.megatrust.votingapp.utills.Vote
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirebaseStorageViewModel @Inject constructor(private val repository: FirebaseStorageRepository) :
    ViewModel() {

    private val _existStatus = MutableLiveData<Vote>()
    val existStatus: LiveData<Vote> = _existStatus

    fun checkIfISVoteBefore(id: String) {
        repository.checkIfVoteBefore(id) {
            if (it) {
                // Document exists
                // Do something
                _existStatus.value = Vote.EXIST

            } else {
                // Document does not exist
                // Do something else
                _existStatus.value = Vote.NOT_EXIST

            }
        }
    }
}
