package com.tencent.wcdb;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CursorWrapper implements Cursor {
    protected final Cursor mCursor;

    public CursorWrapper(Cursor cursor) {
        this.mCursor = cursor;
    }

    public Cursor getWrappedCursor() {
        return this.mCursor;
    }

    @Override // java.io.Closeable, com.tencent.wcdb.Cursor, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(2738);
        this.mCursor.close();
        AppMethodBeat.o(2738);
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean isClosed() {
        AppMethodBeat.i(2739);
        boolean isClosed = this.mCursor.isClosed();
        AppMethodBeat.o(2739);
        return isClosed;
    }

    @Override // com.tencent.wcdb.Cursor
    public int getCount() {
        AppMethodBeat.i(2740);
        int count = this.mCursor.getCount();
        AppMethodBeat.o(2740);
        return count;
    }

    @Override // com.tencent.wcdb.Cursor
    public void deactivate() {
        AppMethodBeat.i(2741);
        this.mCursor.deactivate();
        AppMethodBeat.o(2741);
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean moveToFirst() {
        AppMethodBeat.i(2742);
        boolean moveToFirst = this.mCursor.moveToFirst();
        AppMethodBeat.o(2742);
        return moveToFirst;
    }

    @Override // com.tencent.wcdb.Cursor
    public int getColumnCount() {
        AppMethodBeat.i(2743);
        int columnCount = this.mCursor.getColumnCount();
        AppMethodBeat.o(2743);
        return columnCount;
    }

    @Override // com.tencent.wcdb.Cursor
    public int getColumnIndex(String str) {
        AppMethodBeat.i(2744);
        int columnIndex = this.mCursor.getColumnIndex(str);
        AppMethodBeat.o(2744);
        return columnIndex;
    }

    @Override // com.tencent.wcdb.Cursor, android.database.Cursor
    public int getColumnIndexOrThrow(String str) {
        AppMethodBeat.i(2745);
        int columnIndexOrThrow = this.mCursor.getColumnIndexOrThrow(str);
        AppMethodBeat.o(2745);
        return columnIndexOrThrow;
    }

    @Override // com.tencent.wcdb.Cursor
    public String getColumnName(int i2) {
        AppMethodBeat.i(2746);
        String columnName = this.mCursor.getColumnName(i2);
        AppMethodBeat.o(2746);
        return columnName;
    }

    @Override // com.tencent.wcdb.Cursor
    public String[] getColumnNames() {
        AppMethodBeat.i(2747);
        String[] columnNames = this.mCursor.getColumnNames();
        AppMethodBeat.o(2747);
        return columnNames;
    }

    @Override // com.tencent.wcdb.Cursor
    public double getDouble(int i2) {
        AppMethodBeat.i(2748);
        double d2 = this.mCursor.getDouble(i2);
        AppMethodBeat.o(2748);
        return d2;
    }

    @Override // com.tencent.wcdb.Cursor
    public Bundle getExtras() {
        AppMethodBeat.i(2749);
        Bundle extras = this.mCursor.getExtras();
        AppMethodBeat.o(2749);
        return extras;
    }

    @Override // com.tencent.wcdb.Cursor
    public float getFloat(int i2) {
        AppMethodBeat.i(2750);
        float f2 = this.mCursor.getFloat(i2);
        AppMethodBeat.o(2750);
        return f2;
    }

    @Override // com.tencent.wcdb.Cursor
    public int getInt(int i2) {
        AppMethodBeat.i(2751);
        int i3 = this.mCursor.getInt(i2);
        AppMethodBeat.o(2751);
        return i3;
    }

    @Override // com.tencent.wcdb.Cursor
    public long getLong(int i2) {
        AppMethodBeat.i(2752);
        long j2 = this.mCursor.getLong(i2);
        AppMethodBeat.o(2752);
        return j2;
    }

    @Override // com.tencent.wcdb.Cursor
    public short getShort(int i2) {
        AppMethodBeat.i(2753);
        short s = this.mCursor.getShort(i2);
        AppMethodBeat.o(2753);
        return s;
    }

    @Override // com.tencent.wcdb.Cursor
    public String getString(int i2) {
        AppMethodBeat.i(2754);
        String string = this.mCursor.getString(i2);
        AppMethodBeat.o(2754);
        return string;
    }

    @Override // com.tencent.wcdb.Cursor
    public void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
        AppMethodBeat.i(2755);
        this.mCursor.copyStringToBuffer(i2, charArrayBuffer);
        AppMethodBeat.o(2755);
    }

    @Override // com.tencent.wcdb.Cursor
    public byte[] getBlob(int i2) {
        AppMethodBeat.i(2756);
        byte[] blob = this.mCursor.getBlob(i2);
        AppMethodBeat.o(2756);
        return blob;
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean getWantsAllOnMoveCalls() {
        AppMethodBeat.i(2757);
        boolean wantsAllOnMoveCalls = this.mCursor.getWantsAllOnMoveCalls();
        AppMethodBeat.o(2757);
        return wantsAllOnMoveCalls;
    }

    public void setExtras(Bundle bundle) {
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean isAfterLast() {
        AppMethodBeat.i(2758);
        boolean isAfterLast = this.mCursor.isAfterLast();
        AppMethodBeat.o(2758);
        return isAfterLast;
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean isBeforeFirst() {
        AppMethodBeat.i(2759);
        boolean isBeforeFirst = this.mCursor.isBeforeFirst();
        AppMethodBeat.o(2759);
        return isBeforeFirst;
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean isFirst() {
        AppMethodBeat.i(2760);
        boolean isFirst = this.mCursor.isFirst();
        AppMethodBeat.o(2760);
        return isFirst;
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean isLast() {
        AppMethodBeat.i(2761);
        boolean isLast = this.mCursor.isLast();
        AppMethodBeat.o(2761);
        return isLast;
    }

    @Override // com.tencent.wcdb.Cursor
    public int getType(int i2) {
        AppMethodBeat.i(2762);
        int type = this.mCursor.getType(i2);
        AppMethodBeat.o(2762);
        return type;
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean isNull(int i2) {
        AppMethodBeat.i(2763);
        boolean isNull = this.mCursor.isNull(i2);
        AppMethodBeat.o(2763);
        return isNull;
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean moveToLast() {
        AppMethodBeat.i(2764);
        boolean moveToLast = this.mCursor.moveToLast();
        AppMethodBeat.o(2764);
        return moveToLast;
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean move(int i2) {
        AppMethodBeat.i(2765);
        boolean move = this.mCursor.move(i2);
        AppMethodBeat.o(2765);
        return move;
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean moveToPosition(int i2) {
        AppMethodBeat.i(2766);
        boolean moveToPosition = this.mCursor.moveToPosition(i2);
        AppMethodBeat.o(2766);
        return moveToPosition;
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean moveToNext() {
        AppMethodBeat.i(2767);
        boolean moveToNext = this.mCursor.moveToNext();
        AppMethodBeat.o(2767);
        return moveToNext;
    }

    @Override // com.tencent.wcdb.Cursor
    public int getPosition() {
        AppMethodBeat.i(2768);
        int position = this.mCursor.getPosition();
        AppMethodBeat.o(2768);
        return position;
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean moveToPrevious() {
        AppMethodBeat.i(2769);
        boolean moveToPrevious = this.mCursor.moveToPrevious();
        AppMethodBeat.o(2769);
        return moveToPrevious;
    }

    @Override // com.tencent.wcdb.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.i(2770);
        this.mCursor.registerContentObserver(contentObserver);
        AppMethodBeat.o(2770);
    }

    @Override // com.tencent.wcdb.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(2771);
        this.mCursor.registerDataSetObserver(dataSetObserver);
        AppMethodBeat.o(2771);
    }

    @Override // com.tencent.wcdb.Cursor
    public boolean requery() {
        AppMethodBeat.i(2772);
        boolean requery = this.mCursor.requery();
        AppMethodBeat.o(2772);
        return requery;
    }

    @Override // com.tencent.wcdb.Cursor
    public Bundle respond(Bundle bundle) {
        AppMethodBeat.i(2773);
        Bundle respond = this.mCursor.respond(bundle);
        AppMethodBeat.o(2773);
        return respond;
    }

    @Override // com.tencent.wcdb.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        AppMethodBeat.i(2774);
        this.mCursor.setNotificationUri(contentResolver, uri);
        AppMethodBeat.o(2774);
    }

    public Uri getNotificationUri() {
        return null;
    }

    @Override // com.tencent.wcdb.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.i(2775);
        this.mCursor.unregisterContentObserver(contentObserver);
        AppMethodBeat.o(2775);
    }

    @Override // com.tencent.wcdb.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(2776);
        this.mCursor.unregisterDataSetObserver(dataSetObserver);
        AppMethodBeat.o(2776);
    }
}
