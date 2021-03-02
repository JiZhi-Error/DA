package com.tencent.mm.plugin.music.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class d extends MAutoStorage<c> {
    public f<String, c> AlG = new c(20);
    public ISQLiteDatabase db;

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "PieceMusicInfo", null);
        AppMethodBeat.i(63179);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(63179);
    }

    public final c aHX(String str) {
        AppMethodBeat.i(63180);
        if (this.AlG.get(str) != null) {
            c cVar = this.AlG.get(str);
            AppMethodBeat.o(63180);
            return cVar;
        }
        String format = String.format("Select * From PieceMusicInfo Where musicId=?", new Object[0]);
        Cursor rawQuery = this.db.rawQuery(format, new String[]{str}, 2);
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.o(63180);
            return null;
        }
        c cVar2 = new c();
        cVar2.convertFrom(rawQuery);
        rawQuery.close();
        this.AlG.put(str, cVar2);
        AppMethodBeat.o(63180);
        return cVar2;
    }
}
