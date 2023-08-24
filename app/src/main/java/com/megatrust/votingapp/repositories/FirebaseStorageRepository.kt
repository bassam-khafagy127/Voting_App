package com.megatrust.votingapp.repositories

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.gson.Gson
import com.megatrust.votingapp.data.Voter
import javax.inject.Inject

class FirebaseStorageRepository @Inject constructor(
    private val firebaseFireStore: FirebaseFirestore
) {
    fun uploadData(voter: Voter) {

        firebaseFireStore.collection("Voters")
            .add(voter)
            .addOnSuccessListener { documentReference ->
                Log.d("TAGFire", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("TAGFire", "Error adding document", e)
            }
    }

    fun getUser(): Voter {
        var voter = Voter("", false)
        firebaseFireStore.collection("Voters")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("TAGFire", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("TAGFire", "Error getting documents.", exception)
            }
        return voter
    }
}