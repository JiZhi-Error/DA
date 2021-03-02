package com.tencent.mm.plugin.gamelife.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.cz;
import com.tencent.mm.plugin.gamelife.b;
import com.tencent.mm.plugin.gamelife.d.a;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.f.b;
import kotlin.g.b.p;
import kotlin.x;

public final class c extends MAutoStorage<cz> {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "GameLifeContact")};
    public static final a ybR = new a((byte) 0);
    final ISQLiteDatabase vDi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "GameLifeContact", cz.INDEX_CREATE);
        p.h(iSQLiteDatabase, "storage");
        a.C1414a aVar = a.ybF;
        AppMethodBeat.i(241326);
        this.vDi = iSQLiteDatabase;
        AppMethodBeat.o(241326);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(241327);
        a.C1414a aVar = a.ybF;
        AppMethodBeat.o(241327);
    }

    public final a aAZ(String str) {
        Throwable th;
        a aVar;
        Throwable th2 = null;
        AppMethodBeat.i(241324);
        p.h(str, ch.COL_USERNAME);
        Cursor rawQuery = this.vDi.rawQuery("SELECT *, rowid FROM GameLifeContact WHERE username = " + h.Fl(str), null, 2);
        try {
            Cursor cursor = rawQuery;
            if (cursor == null) {
                aVar = null;
            } else if (cursor.moveToFirst()) {
                a aVar2 = new a();
                aVar2.convertFrom(cursor);
                aVar = aVar2;
            } else {
                aVar = null;
            }
            x xVar = x.SXb;
            b.a(rawQuery, null);
            AppMethodBeat.o(241324);
            return aVar;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(rawQuery, th2);
            AppMethodBeat.o(241324);
            throw th;
        }
    }

    public final Map<String, a> fd(List<String> list) {
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(241325);
        p.h(list, ch.COL_USERNAME);
        StringBuilder sb = new StringBuilder("SELECT *, rowid FROM GameLifeContact WHERE username IN ");
        b.a aVar = com.tencent.mm.plugin.gamelife.b.xZZ;
        String sb2 = sb.append(b.a.fc(list)).toString();
        HashMap hashMap = new HashMap();
        Cursor rawQuery = this.vDi.rawQuery(sb2, null, 2);
        try {
            Cursor cursor = rawQuery;
            if (cursor.moveToFirst()) {
                while (true) {
                    p.g(cursor, "cursor");
                    if (cursor.isAfterLast()) {
                        break;
                    }
                    a aVar2 = new a();
                    aVar2.convertFrom(cursor);
                    String str = aVar2.field_username;
                    p.g(str, "field_username");
                    hashMap.put(str, aVar2);
                    cursor.moveToNext();
                }
            }
            x xVar = x.SXb;
            kotlin.f.b.a(rawQuery, null);
            HashMap hashMap2 = hashMap;
            AppMethodBeat.o(241325);
            return hashMap2;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            kotlin.f.b.a(rawQuery, th2);
            AppMethodBeat.o(241325);
            throw th;
        }
    }
}
