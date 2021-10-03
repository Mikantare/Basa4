package com.bespalov.basa4.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.widget.Toast;

import com.bespalov.basa4.data.TasksContract.MemberEntry;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TasksContentProvider extends ContentProvider {

    TasksOpenHelper tasksOpenHelper;

    private static final int TASKS = 111;
    private static final int TASKS_ID = 222;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(TasksContract.AUTHORITY, TasksContract.PATH_TASKS, TASKS);
        uriMatcher.addURI(TasksContract.AUTHORITY, TasksContract.PATH_TASKS + "/#", TASKS_ID);
    }

    @Override
    public boolean onCreate() {
        tasksOpenHelper = new TasksOpenHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {

        SQLiteDatabase database = tasksOpenHelper.getReadableDatabase();
        Cursor cursor;

        int match = uriMatcher.match(uri);
        switch (match) {
            case TASKS:
                cursor = database.query(MemberEntry.TABLE_NAME, strings, s, strings1, null, null, s1);
                break;
            case TASKS_ID:
                s = MemberEntry._ID + "=?";
                strings1 = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(MemberEntry.TABLE_NAME, strings, s, strings1, null, null, s1);
                break;
            default:
                Toast.makeText(getContext(), "Incorrect URI: " + uri, Toast.LENGTH_LONG).show();
                throw new IllegalArgumentException("Can't query incorrectURI " + uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        int match = uriMatcher.match(uri);

        switch (match) {
            case TASKS:
                return MemberEntry.CONTENT_MULTIPLE_ITEMS;
            case TASKS_ID:
                return MemberEntry.CONTENT_SINGLE_ITEMS;
            default:
                throw new IllegalArgumentException("Unknow Uri: " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
