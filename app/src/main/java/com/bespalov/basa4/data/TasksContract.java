package com.bespalov.basa4.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class TasksContract {

    public static final String DATABASE_NAME = "taskDB";
    public static final int DATABASE_VERSION = 1;

    public static final String SCHEME = "content://";
    public static final String AUTHORITY = "com.bespalov.basa4";
    public static final String PATH_TASKS = "tasks";

    public static final Uri BASE_CONTENT_URI =
            Uri.parse(SCHEME + AUTHORITY);

    private TasksContract() {
    }

    public static final class MemberEntry implements BaseColumns {

        public static final String TABLE_NAME = "tasks";

        public static final String _ID = BaseColumns._ID;
        public static final String KEY_PERFORMER = "performer";
        public static final String KEY_START_DATE = "startDATE";
        public static final String KEY_END_DATE = "endDATE";
        public static final String KEY_DESCRIPTION = "description";

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(BASE_CONTENT_URI, PATH_TASKS);

        public static final String CONTENT_MULTIPLE_ITEMS = ContentResolver.CURSOR_DIR_BASE_TYPE +
                "/" + AUTHORITY + "/" + PATH_TASKS;
        public static final String CONTENT_SINGLE_ITEMS = ContentResolver.CURSOR_ITEM_BASE_TYPE +
                "/" + AUTHORITY + "/" + PATH_TASKS;
    }
}

