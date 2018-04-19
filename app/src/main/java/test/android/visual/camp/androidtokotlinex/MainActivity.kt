package test.android.visual.camp.androidtokotlinex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = RecyclerAdapter(R.layout.activity_recycler_item)
        recycler_view.adapter = adapter
        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        recycler_view?.layoutManager = manager

        button.setOnClickListener {
            val contents = editText?.text.toString()
            if (contents.length > 0) {
                adapter.addContents(contents)
                adapter.notifyDataSetChanged()
                editText?.setText("")
            } else {
                Toast.makeText(applicationContext, "내용입력하고 버튼 누르세요", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
