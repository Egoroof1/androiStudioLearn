package com.example.prolozenie

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "sofa", "Диван", "Крадкое описание", "Полное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описание", 500))
        items.add(Item(2, "light", "Свет", "Крадкое описание", "Полное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описание", 1500))
        items.add(Item(3, "kitchen", "Кухня", "Крадкое описание", "Полное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описаниеПолное описание", 300))

        //За счёт лайаут менеджер указываем в каком формате элементы будет располагаться
        //Мы выбрали линер лайаут что значит, друг под другом
        itemsList.layoutManager = LinearLayoutManager(this)

        //Заместо стандартного адаптера подставляем наш
        itemsList.adapter = ItemsAdapter(items, this)
    }
}