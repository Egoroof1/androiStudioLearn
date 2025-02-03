package com.example.prolozenie

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.jar.Attributes.Name

class DbHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "app", factory, 1) {

        //создание БД ЛОГИКА
    override fun onCreate(db: SQLiteDatabase?) {
        //создали строку с SQL командой
        val query = "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, email TEXT, pass TEXT)"
        //обращаемся в саму бд. !! обрабатывают возможный null
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //сразу в БД прописываем команду очистки таблици
        db!!.execSQL("DROP TABLE IF EXISTS users")
        //пересоздаём таблицу
        onCreate(db)
    }

    fun addUser(user: User){
        val values = ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("pass", user.pass)

        val db = this.writableDatabase //пишем в БД
        db.insert("users", null, values)

        db.close()
    }

    fun getUser(login: String, pass: String): Boolean{
        val db = this.readableDatabase //читаем из БД

        //'' обязательнеы. Ищем в юзерах пользователя который логин совпадает с логином, а пароль с паролем
        // Второй параметр null тк мы ввели вс параметры в сам запрос
        val result = db.rawQuery("SELECT * FROM users WHERE login = '$login' AND pass = '$pass'", null)
        return result.moveToFirst() //позволяет взять первую запись. Если записть есть true
    }

}