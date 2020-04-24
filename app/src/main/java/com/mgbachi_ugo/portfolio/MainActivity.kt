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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textname.text = getString(R.string.displayname)
        textskill.text = getString(R.string.skillname)
        description.text = getString(R.string.textdescription)

        adapter = IconRecyclerAdapter(this, iconC) {io ->
            val url = io.url
            val intent = Intent()
            intent.data = Uri.parse(url)
            intent.action = Intent.ACTION_VIEW
            startActivity(intent)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 3)
       recyclerView.setHasFixedSize(true)


    }



    override fun onStart() {
        super.onStart()
        Log.i("Main Activity", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("Main Activity", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Main Activity", "onPause called")
    }

}
