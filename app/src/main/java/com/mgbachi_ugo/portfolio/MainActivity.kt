package com.mgbachi_ugo.portfolio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import com.mgbachi_ugo.portfolio.IconData.iconC
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: IconRecyclerAdapter
    private lateinit var sharedPreference: SharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreference = SharedPreference(applicationContext)
        textname.text = sharedPreference.getName(Constants.KEY_NAME)
        textskill.text = sharedPreference.getUserName(Constants.KEY_USERNAME)
        description.text = sharedPreference.getEmail(Constants.KEY_EMAIL)

        adapter = IconRecyclerAdapter(this, IconData.iconC) {io ->
            val url = io.url
            val intent = Intent()
            intent.data = Uri.parse(url)
            intent.action = Intent.ACTION_VIEW
            startActivity(intent)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 3)
       recyclerView.setHasFixedSize(true)

        btn_logout.setOnClickListener {
            finish()
        }

    }
}
