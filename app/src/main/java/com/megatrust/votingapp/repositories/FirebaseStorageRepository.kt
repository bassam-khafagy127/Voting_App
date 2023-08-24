package com.megatrust.votingapp.repositories

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.megatrust.votingapp.data.Voter
import javax.inject.Inject

class FirebaseStorageRepository @Inject constructor(
    private val firebaseFireStore: FirebaseFirestore
) {
   fun uploadVoting(voter: Voter){
       val voterMap = mapOf(
           "stringValue" to voter.stringValue,
           "booleanValue" to voter.booleanValue
       )
       firebaseFireStore.collection("Voters")
           .add(voterMap)
           .addOnSuccessListener {

           }
   }
    fun getVote(){
        firebaseFireStore.collection("Voters").get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val stringValue = document.getString("stringValue")
                    val booleanValue = document.getBoolean("booleanValue")
                    // Process the data
                    Log.d("Tagg","${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                // Handle error
                Log.d("Tagg","${exception.stackTrace}")

            }
    }
}