package com.megatrust.votingapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.megatrust.votingapp.data.Voter
import com.megatrust.votingapp.repositories.FirebaseStorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirebaseStorageViewModel @Inject constructor(private val repository: FirebaseStorageRepository) :
    ViewModel() {

    private val _uploadStatus = MutableLiveData<Boolean>()
    val uploadStatus: LiveData<Boolean> = _uploadStatus

    fun uploadData(voter: Voter) {
        viewModelScope.launch {
            try {
                repository.uploadData(voter)
                _uploadStatus.value = true
            } catch (e: Exception) {
                _uploadStatus.value = false
            }
        }

    }
    fun getVoters() = repository.getUser()

}