package com.example.rxworkshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rxworkshop.data.DataModel
import com.example.rxworkshop.list.Adapter
import com.google.android.material.progressindicator.LinearProgressIndicator
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private lateinit var mainView: View
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressIndicator: LinearProgressIndicator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        loadCharacter()
    }


    private fun initView() {
        mainView = findViewById(R.id.main_view)
        progressIndicator = findViewById(R.id.progress)
        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun setRecyclerData(data: List<DataModel>){
        val adapter = Adapter()
        adapter.setUpStaffList(data)
        recyclerView.adapter = adapter
    }


    private fun loadCharacter() {
        setProgress(true)
        NetworkHolder.retrofitservice!!.getCharacter().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.results.map { DataModel(it.id, it.name) }.toList() }.subscribe({
                      setRecyclerData(it)
            }, {
                it.printStackTrace()
            })
    }

    private fun setProgress(isVisible: Boolean){
        progressIndicator.isVisible = isVisible
    }


}
