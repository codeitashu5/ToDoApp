package com.ashupandey.view.click.lisner.various.views.and.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ashupandey.view.click.lisner.various.views.and.todoapp.todo.adapter.TodoAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.util.concurrent.CopyOnWriteArrayList
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity(), TodoAdapter.ImageClickedListner {

    val list = mutableListOf<DataTask>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerTodo.layoutManager = LinearLayoutManager(this)
        recyclerTodo.adapter = TodoAdapter(list, this)

        floatingActionButton.setOnClickListener {
            if (edit1.text.toString().length == 0 || edit2.text.toString().length == 0)
                Toast.makeText(this, "Fill the required fildes", Toast.LENGTH_SHORT).show()
            else {
                list.add(DataTask(edit1.text.toString().toInt(), edit2.text.toString()))
                recyclerTodo.adapter?.notifyDataSetChanged()
            }
            edit2.setText("")
            edit1.setText("")
            edit1.requestFocus(R.id.edit2)
        }
    }

    override fun imageClicked(pos: Int) {
        list.removeAt(pos)
        recyclerTodo.adapter?.notifyDataSetChanged()
    }


}


fun main() {
    println("start time - ${System.currentTimeMillis()}")
    thread{
        task1 {
            println(" end time task-1 - ${System.currentTimeMillis()}")
        }
    }

    thread {
        task2 {
            println(" end time task-2 - ${System.currentTimeMillis()}")
        }
    }

    println("End time main - ${System.currentTimeMillis()}")
}

private fun task1(onEnd: () -> Unit) {
    println("Starting task-1 on ${Thread.currentThread().name}")
    Thread.sleep(2000)
    println("Ending task-1 on ${Thread.currentThread().name}")
    onEnd()
}

private fun task2(onEnd: () -> Unit) {
    println("Starting task-2 on ${Thread.currentThread().name}")
    Thread.sleep(2000)
    println("Ending task-2 on ${Thread.currentThread().name}")
    onEnd()
}




























