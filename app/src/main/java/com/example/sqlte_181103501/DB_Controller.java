package com.example.sqlte_181103501;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;


public class DB_Controller extends SQLiteOpenHelper {


    public DB_Controller(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name "Test.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE STUDENTS(ID INTEGER PRIMARY KEY AUTOINCREMENT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1 {
        sqLiteDatabase.execSQL("DROP TABLE IF STUDENTS EXIST");
        onCreate(sqLiteDatabase);

    }
    public void insert_student(String firstname, String lastname){
        ContentValues contentValues = new ContentValues();
        contentValues.put("FIRSTNAME",firstname);
        contentValues.put("LASTNAME",lastname);
        this.getWritableDatabase().delete( "STUDENTS", "", contentValues;
    }
    public void delete_student(String firstname){
        this.getWritableDatabase().delete("STUDENTS", "FIRSTNAME='"+firstname+"'", "null")
    }
    public void List_all_student(TextView textView) {
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM STUDENT", null);
        textView.setText("");
        while (cursor.moveToNext()){
        textView.append (cursor.getString(1)+""+cursor.getString(2)+"/n";
        }
    }
}
