package com.example.danhba


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listInfo = ArrayList<Info>()

        var info1 = Info("1","0974979259","Dung","Dung.nn204956@sis.hust.edu.vn")
        var info2 = Info("2","0362466866","Uyen","Uyen@gmail.com")
        var info3 = Info("3","0123456789","Tan","Tan.dv184956@sis.hust.edu.vn")
        var info4 = Info("4","0368422144","Vu","Vu@gmail.com")
        var info5 = Info("5","0125678946","Hung","Hung.NN204956")
        listInfo.add(info1)
        listInfo.add(info2)
        listInfo.add(info3)
        listInfo.add(info4)
        listInfo.add(info5)

        listInfo.add(info1)
        listInfo.add(info2)
        listInfo.add(info3)
        listInfo.add(info4)
        listInfo.add(info5)

        var infoAdapter = InfoAdapter(this,listInfo)
        var recyclerView = findViewById<RecyclerView>(R.id.list_item)
        val layoutManager = LinearLayoutManager( this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = infoAdapter
        recyclerView.layoutManager = layoutManager
        infoAdapter.onItemClick = {
            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("id",it.id)
            intent.putExtra("name",it.name)
            intent.putExtra("phone",it.phone)
            intent.putExtra("email",it.email)
            startActivity(intent)
        }
        registerForContextMenu(recyclerView)
    }

}