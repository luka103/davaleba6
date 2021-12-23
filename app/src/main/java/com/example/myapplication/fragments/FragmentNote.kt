package com.example.myapplication.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.R

class FragmentNote: Fragment(R.layout.fragment_note) {
    private lateinit var editTextNote: EditText
    private lateinit var buttonAdd: Button
    private lateinit var textView: TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        editTextNote = view.findViewById(R.id.editTextNote)
        val sharedPreferences = requireActivity()
            .getSharedPreferences("pref", Context.MODE_PRIVATE)

        val text = sharedPreferences.getString("note", "")
        textView.text = text
        buttonAdd.setOnClickListener() {
            var note = editTextNote.text.toString()
            var text = textView.text.toString()
            var result = note + "\n" + text
            textView.text = result
            sharedPreferences.edit().putString("note", result).apply()
        }
    }
    private fun init(){
        editTextNote = requireView().findViewById(R.id.editTextNote)
        buttonAdd = requireView().findViewById(R.id.buttonAdd)
        textView = requireView().findViewById(R.id.textView)
    }
}