package com.example.chat.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chat.R
import com.example.chat.databinding.FragmentChatBinding
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue

class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private val database = Firebase.database
    private val DBRef = database.getReference("message")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DBRef.setValue("Hello, World!")

        binding.btnSend.setOnClickListener {
            DBRef.setValue(binding.etMessage.text.toString())
            binding.etMessage.text.clear()
        }

        DBRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                Log.w(TAG, "Value is $value")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }

    companion object {
        const val TAG = "Chat"
        fun newInstance(): ChatFragment = ChatFragment()
    }
}