package com.megatrust.votingapp.repositories

import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class FirebaseStorageRepository @Inject constructor(
    private val firebaseFireStore: FirebaseFirestore
) {

}