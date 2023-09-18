package com.example.pbb_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pbb_4.MainActivity.Companion.EXTRA_NAME
import com.example.pbb_4.databinding.ActivityMainBinding
import com.example.pbb_4.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding
    companion object {
        const val EXTRA_ADDRES = "extra_address"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)

        val name = intent.getStringExtra(EXTRA_NAME)
        with(binding) {
            btnDismiss.setOnClickListener {
                val intent = intent
                val address = textAddres.text.toString()
                intent.putExtra(EXTRA_NAME, name)
                intent.putExtra(EXTRA_ADDRES, address)

                finish()
            }
        }
        setContentView(binding.root)
    }
}