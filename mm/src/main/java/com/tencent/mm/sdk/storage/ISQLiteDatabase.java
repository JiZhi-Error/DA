package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;

public interface ISQLiteDatabase {
    public static final int CURSOR_ASYNC = 3;
    public static final int CURSOR_DEFAULT = 0;
    public static final int CURSOR_HEAP = 4;
    public static final int CURSOR_IMMEDIATE = 2;
    public static final int CURSOR_WINDOWED = 1;

    int delete(String str, String str2, String[] strArr);

    boolean execSQL(String str, String str2);

    long insert(String str, String str2, ContentValues contentValues);

    boolean isClose();

    Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5);

    Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i2);

    Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i2, String str6);

    Cursor rawQuery(String str, String[] strArr);

    Cursor rawQuery(String str, String[] strArr, int i2);

    long replace(String str, String str2, ContentValues contentValues);

    int update(String str, ContentValues contentValues, String str2, String[] strArr);
}
