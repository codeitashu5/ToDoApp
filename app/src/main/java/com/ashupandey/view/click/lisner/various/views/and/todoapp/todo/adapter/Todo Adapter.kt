package com.ashupandey.view.click.lisner.various.views.and.todoapp.todo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ashupandey.view.click.lisner.various.views.and.todoapp.DataTask
import com.ashupandey.view.click.lisner.various.views.and.todoapp.R
import kotlinx.android.synthetic.main.layout_task.view.*
import kotlinx.coroutines.*
import java.text.ParsePosition

class TodoAdapter(
    val list: MutableList<DataTask>,
    val imageClicked: ImageClickedListner

): RecyclerView.Adapter<TodoAdapter.TaskViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.layout_task,
            parent,
            false
        )

        return TaskViewHolder(view)
    }
    //can't access the member of inherited class

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

         init {
             itemView.image.setOnClickListener{
                 val pos=adapterPosition
                 if(pos!=RecyclerView.NO_POSITION)
                 imageClicked.imageClicked(pos)
             }
         }

    }



    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.itemView.task.text = list[position].task
        holder.itemView.pre.text = list[position].pos.toString() + "."
    }

    override fun getItemCount(): Int {
        return list.size
    }


    interface ImageClickedListner{
        fun imageClicked(pos:Int)
    }
}


fun main(){
    println("start time - ${System.currentTimeMillis()}")
    runBlocking {
        launch {task1()}
        launch {task2()}
        }

    println("end time - ${System.currentTimeMillis()}")
}
 suspend fun  task1(){
    println("Starting task-1 on ${Thread.currentThread().name}")
    delay(2000)
    println("Ending task-1 on ${Thread.currentThread().name}")
}


 suspend fun  task2(){
    println("Starting task-2 on ${Thread.currentThread().name}")
        delay(2000)
        delay(2000)
    println("Ending task-2 on ${Thread.currentThread().name}")
}
