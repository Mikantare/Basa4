package com.bespalov.basa4.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bespalov.basa4.data.TasksContract.*;

import androidx.annotation.Nullable;

public class TasksOpenHelper extends SQLiteOpenHelper {

    public TasksOpenHelper(@Nullable Context context) {
        super(context, TasksContract.DATABASE_NAME, null, TasksContract.DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + MemberEntry.TABLE_NAME + "(" +
                MemberEntry._ID + " INTEGER PRIMARY KEY, " +
                MemberEntry.KEY_PERFORMER + "TETX, " +
                MemberEntry.KEY_START_DATE + "TEXT, " +
                MemberEntry.KEY_END_DATE + "TEXT, " +
                MemberEntry.KEY_DESCRIPTION + "TEXT" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TasksContract.DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }
}
