package com.rulyox.mvc.memo

object MemoStore {

    private var memoList: ArrayList<Memo> = ArrayList()

    fun getMemoList(): ArrayList<Memo> {
        return memoList
    }

    fun addMemo(memo: Memo) {
        memoList.add(memo)
    }

    fun deleteMemo(id: Int) {

        for(memo in memoList) {
            if(memo.id == id) {
                memoList.remove(memo)
                return
            }
        }

    }

}
