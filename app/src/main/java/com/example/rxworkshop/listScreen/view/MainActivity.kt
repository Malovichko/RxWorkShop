package com.example.rxworkshop.listScreen.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rxworkshop.R
import com.example.rxworkshop.domain.model.DataModel
import com.example.rxworkshop.data.NetworkHolder
import com.example.rxworkshop.present.list.Adapter
import com.google.android.material.progressindicator.LinearProgressIndicator
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity(), CharacterListView {
    private lateinit var mainView: View
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressIndicator: LinearProgressIndicator
    private lateinit var toolbar: Toolbar
    private val presenter = CharacterListPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initListener()
        presenter.loadCharacter()
        presenter.onViewCreated()
    }


    private fun initView() {
        mainView = findViewById(R.id.main_view)
        progressIndicator = findViewById(R.id.progress)
        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        toolbar = findViewById(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu_toolbar)
    }

    private fun initListener() {
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_item_save -> {
                    presenter.clearCharacterList()
                    presenter.getListFromDB()
                    presenter.onViewCreated()
                    Log.i("tag", "Нажата кнопка")
                    return@setOnMenuItemClickListener true
                }
            }
            false
        }
    }

    override fun setUpRecyclerList(list: List<DataModel>) {
        val adapter = Adapter()
        adapter.setUpStaffList(list)
        adapter.setOnClickListener { Log.i("tag", "id: $it") }
        recyclerView.adapter = adapter
    }

    override fun setProgress(isVisible: Boolean) {
        progressIndicator.isVisible = isVisible
    }

//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.menu_toolbar, menu)
//        return super.onCreateOptionsMenu(menu)
//    }


//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.menu_item_save -> {
//                Log.i("tag", "Нажата кнопка 1")
//                presenter.getListFromDB()
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}
