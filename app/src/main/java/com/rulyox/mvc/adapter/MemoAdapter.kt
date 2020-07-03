package com.rulyox.mvc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rulyox.mvc.R
import com.rulyox.mvc.memo.Memo

class MemoAdapter: RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {

    private var memoList: ArrayList<Memo>? = null

    fun setList(memoList: ArrayList<Memo>) {
        this.memoList = memoList
    }

    override fun getItemCount(): Int {
        return memoList?.size ?: 0
    }

    class MemoViewHolder(view: View, adapter: MemoAdapter): RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.item_title)
        var text: TextView = view.findViewById(R.id.item_text)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MemoViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false)

        return MemoViewHolder(view, this)

    }

    override fun onBindViewHolder(viewholder: MemoViewHolder, position: Int) {

        if(memoList == null) return

        val memo = memoList!![position]

        viewholder.title.text = memo.title
        viewholder.text.text = memo.text

    }

}
