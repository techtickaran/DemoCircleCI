package com.agohra.democircleci.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agohra.democircleci.R

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

//        val resp = UserRepository(ListOfUsersAPI())
//
//        GlobalScope.launch(Dispatchers.Main) {
//
//            val movies =resp.getUsers()
//            Toast.makeText(this@ListActivity,movies.toString(),Toast.LENGTH_SHORT).show()
//        }
    }
}
