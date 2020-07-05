package com.rulyox.mvc.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rulyox.mvc.R
import com.rulyox.mvc.activity.MainActivity
import com.rulyox.mvc.memo.Memo
import com.rulyox.mvc.memo.MemoStore

class MemoAdapter: RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {

    private var memoList: ArrayList<Memo>? = null

    fun setList(memoList: ArrayList<Memo>) {
        this.memoList = memoList
    }

    override fun getItemCount(): Int {
        return memoList?.size ?: 0
    }

    class MemoViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val parent: LinearLayout = view.findViewById(R.id.item_parent)
        val title: TextView = view.findViewById(R.id.item_title)
        val text: TextView = view.findViewById(R.id.item_text)

        init {

            parent.setOnClickListener {

                AlertDialog.Builder(view.context)
                    .setTitle(R.string.dialog_delete_memo)
                    .setMessage(R.string.dialog_delete_text)
                    .setPositiveButton(R.string.dialog_delete) { dialog, _ ->

                        MemoStore.delete(adapterPosition)
                        MainActivity.updateAdapter()

                        dialog.dismiss()

                    }
                    .setNegativeButton(R.string.dialog_cancel) { dialog, _ ->

                        dialog.dismiss()

                    }
                    .show()

            }

        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MemoViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false)
        return MemoViewHolder(view)

    }

    override fun onBindViewHolder(viewholder: MemoViewHolder, position: Int) {

        if(memoList == null) return

        val memo = memoList!![position]

        viewholder.title.text = memo.title
        viewholder.text.text = memo.text

    }

}
