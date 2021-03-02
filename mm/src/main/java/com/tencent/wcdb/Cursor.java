package com.tencent.wcdb;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public interface Cursor extends android.database.Cursor {
    public static final int FIELD_TYPE_BLOB = 4;
    public static final int FIELD_TYPE_FLOAT = 2;
    public static final int FIELD_TYPE_INTEGER = 1;
    public static final int FIELD_TYPE_NULL = 0;
    public static final int FIELD_TYPE_STRING = 3;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer);

    void deactivate();

    byte[] getBlob(int i2);

    int getColumnCount();

    int getColumnIndex(String str);

    @Override // android.database.Cursor
    int getColumnIndexOrThrow(String str);

    String getColumnName(int i2);

    String[] getColumnNames();

    int getCount();

    double getDouble(int i2);

    Bundle getExtras();

    float getFloat(int i2);

    int getInt(int i2);

    long getLong(int i2);

    int getPosition();

    short getShort(int i2);

    String getString(int i2);

    int getType(int i2);

    boolean getWantsAllOnMoveCalls();

    boolean isAfterLast();

    boolean isBeforeFirst();

    boolean isClosed();

    boolean isFirst();

    boolean isLast();

    boolean isNull(int i2);

    boolean move(int i2);

    boolean moveToFirst();

    boolean moveToLast();

    boolean moveToNext();

    boolean moveToPosition(int i2);

    boolean moveToPrevious();

    void registerContentObserver(ContentObserver contentObserver);

    void registerDataSetObserver(DataSetObserver dataSetObserver);

    @Deprecated
    boolean requery();

    Bundle respond(Bundle bundle);

    void setNotificationUri(ContentResolver contentResolver, Uri uri);

    void unregisterContentObserver(ContentObserver contentObserver);

    void unregisterDataSetObserver(DataSetObserver dataSetObserver);
}
