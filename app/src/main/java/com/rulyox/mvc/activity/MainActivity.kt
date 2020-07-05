package com.rulyox.mvc.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rulyox.mvc.R
import com.rulyox.mvc.adapter.MemoAdapter
import com.rulyox.mvc.memo.MemoStore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    companion object {

        private const val RESULT_ADD = 1

        private val memoAdapter: MemoAdapter = MemoAdapter()

        fun updateAdapter() {
            memoAdapter.setList(MemoStore.getList())
            memoAdapter.notifyDataSetChanged()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)

        initUI()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK && requestCode == RESULT_ADD) {

            updateAdapter()

        }

    }

    private fun initUI() {

        // recycler view
        main_recycler.layoutManager = LinearLayoutManager(this)
        main_recycler.addItemDecoration(DividerItemDecoration(main_recycler.context, DividerItemDecoration.VERTICAL))
        main_recycler.adapter = memoAdapter

        // add button
        main_fab.setOnClickListener {

            val addIntent = Intent(this@MainActivity, AddActivity::class.java)
            startActivityForResult(addIntent, RESULT_ADD)

        }

    }

}
