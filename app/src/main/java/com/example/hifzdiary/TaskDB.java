package com.example.hifzdiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class TaskDB extends SQLiteOpenHelper {
    private static final String DB_NAME = "taskdb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "students";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our student name column
    private static final String NAME_COL = "name";

    // below variable is for our class column.
    private static final String CLASS_COL = "class";

    // variable for roll number column
    private static  final String ROLL_COL="roll";

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
                + CLASS_COL + " TEXT,"
                + ROLL_COL + " TEXT)";

        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewStudent(String studentName, String studentRoll,String studentClass) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, studentName);
        values.put(CLASS_COL,studentClass);
        values.put(ROLL_COL,studentRoll);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public ArrayList<Student>getStudents(){
        ArrayList<Student>students=new ArrayList<>();

        SQLiteDatabase db=this.getReadableDatabase();

        //String query="SELECT * FROM "+TABLE_NAME;

        Cursor c = db.rawQuery("SELECT * FROM "+ TABLE_NAME, null);

        Student temp_st;
        if (c.moveToFirst()){
            do {
                // Passing values
                int id=c.getInt(0);
                String name=c.getString(1);
                String clas=c.getString(2);
                String roll=c.getString(3);

                temp_st=new Student(id,name,clas,roll,R.drawable.d);

                students.add(temp_st);

                // Do something Here with values
            } while(c.moveToNext());
        }
        c.close();
        db.close();

        return students;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
