package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.wcdb.database.SQLiteStatement;

public interface h {
    long V(long j2, long j3);

    void W(long j2, long j3);

    Cursor ayh(String str);

    boolean ayi(String str);

    void beginTransaction();

    void commit();

    SQLiteStatement compileStatement(String str);

    void execSQL(String str);

    void execSQL(String str, Object[] objArr);

    boolean gD(int i2, int i3);

    boolean inTransaction();

    Cursor rawQuery(String str, String[] strArr);
}
