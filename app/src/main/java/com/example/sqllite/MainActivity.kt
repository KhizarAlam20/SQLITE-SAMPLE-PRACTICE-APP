package com.example.sqllite
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqllite.databinding.ActivityMainBinding
import detailClass

class MainActivity : AppCompatActivity() {
   lateinit var binding : ActivityMainBinding
    var listCategories = arrayListOf<detailClass>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        listCategories = ArrayList<detailClass>()
        setContentView(binding.root)

        listCategories.add(detailClass("Ahmed","a@gmail.com"))
        listCategories.add(detailClass("dssds","a@gmail.com"))
        listCategories.add(detailClass("Ahmeo","a@gmail.com"))
        listCategories.add(detailClass("Ahmeu","a@gmail.com"))
        listCategories.add(detailClass("Ahmer","a@gmail.com"))
        listCategories.add(detailClass("Ahmed","a@gmail.com"))
        listCategories.add(detailClass("Ahmed","a@gmail.com"))
        listCategories.add(detailClass("Ahmed","a@gmail.com"))
        listCategories.add(detailClass("Ahmed","a@gmail.com"))
        listCategories.add(detailClass("Ahmed","a@gmail.com"))
        listCategories.add(detailClass("Ahmed","a@gmail.com"))
        listCategories.add(detailClass("Ahmed","a@gmail.com"))

        binding.rcv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rcv.adapter = rcvAdapters(this,listCategories)

    }
}