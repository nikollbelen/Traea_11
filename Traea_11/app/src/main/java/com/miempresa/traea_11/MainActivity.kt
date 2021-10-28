package com.miempresa.traea_11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miempresa.traea_11.fragments.FragmentA
import com.miempresa.traea_11.fragments.FragmentB
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA = FragmentA()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentA).commit()
    }

    override fun passDataCom(editTextInput: String) {
        val bunble = Bundle()
        bunble.putString("message", editTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentB = FragmentB()
        fragmentB.arguments = bunble

        transaction.replace(R.id.fragment_container, fragmentB)
        transaction.commit()
    }
}