package com.example.hifzdiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class TaskDB extends SQLiteOpenHelper {
    private static final String DB_NAME = "taskdb";

    // below int is our database version
    private static final int DB_VERSION = 2;

    // below variable is for our table name.
    private static final String TABLE_NAME = "tasks";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our student name column
    private static final String NAME_COL = "name";

    private static  final String SABAQ="sabaq";
    private static  final String SABQI="sabqi";
    private static  final String MANZIL="manzil";
    private static  final String ST_ID="stid";

    // creating a constructor for our database handler.
    public TaskDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +ST_ID+" TEXT,"
                + NAME_COL + " TEXT,"
                + SABAQ + " TEXT,"
                +SABQI+"INTEGER,"
                +MANZIL+"INTEGER)";

        db.execSQL(query);
    }


    public void insert_new(String name,int id){
        SQLiteDatabase db2 = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL,name);
        values.put(ST_ID,id);
        values.put(SABAQ,"1");
        values.put(SABQI,0);
        values.put(MANZIL,0);

        // after adding all values we are passing
        // content values to our table.
        db2.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db2.close();
    }

    public Task get_new(String name,int id){
        Task tsk = null;
        SQLiteDatabase db=this.getReadableDatabase();
        String upid=""+id;
        Cursor c = db.rawQuery("SELECT * FROM "+ TABLE_NAME+" WHERE stid='"+id+"'", null);

        if (c.moveToFirst()) {
            int iid = c.getInt(1);
            String name1 = c.getString(3);
            String sabaq = c.getString(4);
            int sabqi = c.getInt(5);
            int manzil = c.getInt(6);
            tsk = new Task(iid,id, name1, sabaq, sabqi, manzil);

        }

        c.close();
        db.close();
        return tsk;
    }

   public Task getTask(String name1,int id){



        //Cursor c= db.rawQuery("SELECT * FROM "+ TABLE_NAME+" WHERE "+ID_COL+" = "+id, null);
        Boolean ff=false;
       Task tsk = null;
            SQLiteDatabase db=this.getReadableDatabase();
            String upid=""+id;
             Cursor c = db.rawQuery("SELECT * FROM "+ TABLE_NAME+" WHERE stid='"+id+"'", null);

            if (c.moveToFirst()) {
                int iid = c.getInt(1);
                String name = c.getString(3);
                String sabaq = c.getString(4);
                int sabqi = c.getInt(5);
                int manzil = c.getInt(6);

                ff=true;
                tsk = new Task(iid,id, name, sabaq, sabqi, manzil);

            }else{
                insert_new(name1,id);
                tsk=get_new(name1,id);
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
