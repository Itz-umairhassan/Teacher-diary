package com.example.hifzdiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class TaskDB extends SQLiteOpenHelper {
    private static final String DB_NAME = "taskdb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "tasks";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our student name column
    private static final String NAME_COL = "name";

    private static  final String SABAQ="sabaq";
    private static  final String SABQI="sabqi";
    private static  final String MANZIL="manzil";

    // creating a constructor for our database handler.
    public TaskDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + SABAQ + " TEXT,"
                +SABQI+"INTEGER,"
                +MANZIL+"INTEGER)";

        db.execSQL(query);
    }

   public Task getTask(int id){
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM "+ TABLE_NAME+" WHERE "+ID_COL+" = "+id, null);

        Task tsk=null;
        if (c.moveToFirst()){
            int iid=c.getInt(1);
            String name=c.getString(2);
            String sabaq=c.getString(3);
            int sabqi=c.getInt(4);
            int manzil=c.getInt(5);

            tsk=new Task(iid,name,sabaq,sabqi,manzil);
        }
        c.close();
        db.close();

        return tsk;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
