package com.rulyox.mvc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rulyox.mvc.R
import com.rulyox.mvc.memo.Memo

class MemoAdapter(val clickListener: ItemClickListener): RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {

    interface ItemClickListener {

        fun onItemClick(position: Int, view: View)

    }

    private var memoList: ArrayList<Memo>? = null

    fun setList(memoList: ArrayList<Memo>) {
        this.memoList = memoList
    }

    override fun getItemCount(): Int {
        return memoList?.size ?: 0
    }

    class MemoViewHolder(adapter: MemoAdapter, view: View): RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.item_title)
        val text: TextView = view.findViewById(R.id.item_text)

        init {

            view.setOnClickListener {

                adapter.clickListener.onItemClick(adapterPosition, view)

            }

        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MemoViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false)
        return MemoViewHolder(this, view)

    }

    override fun onBindViewHolder(viewholder: MemoViewHolder, position: Int) {

        memoList?.let {

            val memo = it[position]

            viewholder.title.text = memo.title
            viewholder.text.text = memo.text

        }

    }

}
