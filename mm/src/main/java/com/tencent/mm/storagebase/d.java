package com.tencent.mm.storagebase;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storagebase.a.a;
import com.tencent.mm.storagebase.a.f;
import java.util.HashMap;

public final class d implements Cursor, com.tencent.mm.storagebase.a.d {
    private static Cursor Ota;

    public static Cursor gFu() {
        AppMethodBeat.i(133330);
        if (Ota == null) {
            Ota = new d();
        }
        Cursor cursor = Ota;
        AppMethodBeat.o(133330);
        return cursor;
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public final void setNotificationUri(ContentResolver contentResolver, Uri uri) {
    }

    public final Bundle respond(Bundle bundle) {
        return null;
    }

    public final boolean requery() {
        return false;
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
    }

    public final boolean moveToPrevious() {
        return false;
    }

    public final boolean moveToPosition(int i2) {
        return false;
    }

    public final boolean moveToNext() {
        return false;
    }

    public final boolean moveToLast() {
        return false;
    }

    public final boolean moveToFirst() {
        return false;
    }

    public final boolean move(int i2) {
        return false;
    }

    public final boolean isNull(int i2) {
        return false;
    }

    public final boolean isLast() {
        return false;
    }

    public final boolean isFirst() {
        return false;
    }

    public final boolean isClosed() {
        return false;
    }

    public final boolean isBeforeFirst() {
        return false;
    }

    public final boolean isAfterLast() {
        return true;
    }

    public final boolean getWantsAllOnMoveCalls() {
        return false;
    }

    public final String getString(int i2) {
        return null;
    }

    public final short getShort(int i2) {
        return 0;
    }

    public final int getPosition() {
        return 0;
    }

    public final long getLong(int i2) {
        return 0;
    }

    public final int getInt(int i2) {
        return 0;
    }

    public final float getFloat(int i2) {
        return 0.0f;
    }

    public final Bundle getExtras() {
        return null;
    }

    public final double getDouble(int i2) {
        return 0.0d;
    }

    public final int getCount() {
        return 0;
    }

    public final String[] getColumnNames() {
        return null;
    }

    public final String getColumnName(int i2) {
        return null;
    }

    @Override // android.database.Cursor
    public final int getColumnIndexOrThrow(String str) {
        return 0;
    }

    public final int getColumnIndex(String str) {
        return 0;
    }

    public final int getColumnCount() {
        return 0;
    }

    public final byte[] getBlob(int i2) {
        return null;
    }

    public final void deactivate() {
    }

    public final void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public final int getType(int i2) {
        return 0;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final boolean aky(int i2) {
        return false;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final boolean ed(Object obj) {
        return false;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final a akz(int i2) {
        return null;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final a ee(Object obj) {
        return null;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final SparseArray[] gFv() {
        return null;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final HashMap gFw() {
        return null;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final boolean gFx() {
        return false;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final boolean a(Object obj, a aVar) {
        return false;
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final void AO(boolean z) {
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final void a(f.a aVar) {
    }

    @Override // com.tencent.mm.storagebase.a.d
    public final void akA(int i2) {
    }

    public final Uri getNotificationUri() {
        return null;
    }

    public final void setExtras(Bundle bundle) {
    }
}
