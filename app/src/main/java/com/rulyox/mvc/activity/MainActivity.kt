package com.rulyox.mvc.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rulyox.mvc.R
import com.rulyox.mvc.adapter.MemoAdapter
import com.rulyox.mvc.memo.Memo
import com.rulyox.mvc.memo.MemoStore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    private val memoAdapter: MemoAdapter = MemoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)

        initUI()

        // test
        MemoStore.addMemo(Memo(1, "memo1", "hello world"))
        MemoStore.addMemo(Memo(2, "memo2", "hello world"))
        MemoStore.addMemo(Memo(3, "memo3", "hello world"))
        memoAdapter.setList(MemoStore.getMemoList())
        memoAdapter.notifyDataSetChanged()

    }

    private fun initUI() {

        // recycler view
        main_recycler.layoutManager = LinearLayoutManager(this)
        main_recycler.addItemDecoration(DividerItemDecoration(main_recycler.context, DividerItemDecoration.VERTICAL))
        main_recycler.adapter = memoAdapter

    }

}
