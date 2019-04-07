package com.example.calcdesign;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Calculations.db";
    public static final String TABLE_NAME = "calculations_table";
    public static final String COL_ID = "ID";
    public static final String COL_INPUT = "INPUT";
    public static final String COL_OUTPUT = "OUTPUT";
    public static final String CREATE_TABLE = "create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,INPUT TEXT,OUTPUT TEXT)";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String input, String output){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_INPUT,input);
        contentValues.put(COL_OUTPUT,output);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1 )
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + TABLE_NAME,null);
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }


}