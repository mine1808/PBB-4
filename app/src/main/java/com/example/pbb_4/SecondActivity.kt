package com.example.pbb_4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.pbb_4.MainActivity.Companion.EXTRA_NAME
import com.example.pbb_4.ThirdActivity.Companion.EXTRA_ADDRES
import com.example.pbb_4.databinding.ActivityMainBinding
import com.example.pbb_4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->

        if(result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val name = data?.getStringExtra(EXTRA_NAME)
            val address = data?.getStringExtra(EXTRA_ADDRES)

            binding.txtText2.text = "Hello $name di $address!"
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        with(binding) {
            txtText2.text = "Hello $name!"

            btnToThird.setOnClickListener {
                val intent = Intent( this@SecondActivity,
                    ThirdActivity::class.java).apply { putExtra(
                    EXTRA_NAME, name) }

                launcher.launch(intent)
            }
        }
    }
}