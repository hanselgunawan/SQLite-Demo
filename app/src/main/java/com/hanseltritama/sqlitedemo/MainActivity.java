package com.hanseltritama.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            // MODE_PRIVATE = the database will ONLY be accessible inside the app
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            // Put table to database
//            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

            // Insert data to the database
//            myDatabase.execSQL("INSERT INTO users VALUES('Bruno', 22)");
//            myDatabase.execSQL("INSERT INTO users VALUES('Tom', 44)");

            // Remove data
//            myDatabase.execSQL("DELETE FROM users WHERE name = 'Hansel' LIMIT 1");

            // Update data
            myDatabase.execSQL("UPDATE users SET name = 'Hahaha' WHERE name = 'Hansel'");

            Cursor c = myDatabase.rawQuery("SELECT DISTINCT * FROM users WHERE age < 30", null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            c.moveToFirst();
            while (c != null) {

                Log.i("name", c.getString(nameIndex));
                Log.i("age", Integer.toString(c.getInt(ageIndex)));

                c.moveToNext();

            }


        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
