package com.megatrust.votingapp.utills

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.megatrust.votingapp.R

fun votedBefore(context: Context, id: String) {
    val factory = LayoutInflater.from(context)
    val dialogView: View = factory.inflate(R.layout.has_voted_before_layout, null)
    val dialog = AlertDialog.Builder(context).create()
    dialog.setView(dialogView)
    dialogView.findViewById<TextView>(R.id.tv_show).text = id
    dialogView.findViewById<Button>(R.id.dismissBtn).setOnClickListener {
        dialog.dismiss()
    }
    dialog.show()

}

fun notVotedBefore(context: Context, id: String) {
    val factory = LayoutInflater.from(context)
    val dialogView: View = factory.inflate(R.layout.has_not_voted_before_layout, null)
    val dialog = AlertDialog.Builder(context).create()
    dialog.setView(dialogView)
    dialogView.findViewById<TextView>(R.id.tv_show).text = id
    dialogView.findViewById<Button>(R.id.dismissBtn).setOnClickListener {
        dialog.dismiss()
    }
    dialog.show()
}