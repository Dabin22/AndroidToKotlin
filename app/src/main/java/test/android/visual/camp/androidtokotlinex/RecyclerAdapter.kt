package test.android.visual.camp.androidtokotlinex

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import java.util.ArrayList
import kotlinx.android.synthetic.main.activity_recycler_item.view.*

/**
 * Created by dabin on 2018. 4. 18..
 */

class RecyclerAdapter(private val itemLayout: Int) : RecyclerView.Adapter<RecyclerAdapter.Holder>() {
    private val datas: ArrayList<String>

    init {
        datas = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  Holder(parent)


    override fun onBindViewHolder(holder: Holder, position: Int) {
        val contents = datas[position]
        with(holder.itemView){
            no_tv.text = position.toString() + ". "
            content_tv.text = contents
        }


    }

    override fun getItemCount(): Int {
        return datas.size
    }

    fun addContents(contents: String) {
        datas.add(contents)
    }

    inner class Holder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_recycler_item,parent,false))

}
