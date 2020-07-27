package com.rulyox.mvc.activity

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
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
    }

    private lateinit var memoAdapter: MemoAdapter

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

        // adapter
        val itemClickListener = object: MemoAdapter.ItemClickListener {

            override fun onItemClick(position: Int, view: View) {

                AlertDialog.Builder(view.context)
                    .setTitle(R.string.dialog_delete_memo)
                    .setMessage(R.string.dialog_delete_text)
                    .setPositiveButton(R.string.dialog_delete) { dialog, _ ->

                        MemoStore.delete(position)
                        updateAdapter()

                        dialog.dismiss()

                    }
                    .setNegativeButton(R.string.dialog_cancel) { dialog, _ ->

                        dialog.dismiss()

                    }
                    .show()

            }

        }
        memoAdapter = MemoAdapter(itemClickListener)

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

    fun updateAdapter() {

        memoAdapter.setList(MemoStore.getList())
        memoAdapter.notifyDataSetChanged()

    }

}
