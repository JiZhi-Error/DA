package com.tencent.mm.plugin.finder.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ce;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.List;
import kotlin.a.e;
import kotlin.f.b;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

public final class d extends MAutoStorage<ce> {
    private static final String[] INDEX_CREATE;
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(g.info, "FinderContact")};
    public static final a vDj = new a((byte) 0);
    public final ISQLiteDatabase vDi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, g.info, "FinderContact", INDEX_CREATE);
        p.h(iSQLiteDatabase, "storage");
        g.a aVar = g.tsD;
        AppMethodBeat.i(166957);
        this.vDi = iSQLiteDatabase;
        AppMethodBeat.o(166957);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(166958);
        g.a aVar = g.tsD;
        String[] strArr = ce.INDEX_CREATE;
        p.g(strArr, "BaseFinderContact.INDEX_CREATE");
        List X = e.X(strArr);
        X.add(0, "DROP INDEX username_index");
        Object[] array = X.toArray(new String[0]);
        if (array == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(166958);
            throw tVar;
        }
        INDEX_CREATE = (String[]) array;
        AppMethodBeat.o(166958);
    }

    public final g asG(String str) {
        Throwable th;
        g gVar;
        Throwable th2 = null;
        AppMethodBeat.i(166956);
        p.h(str, ch.COL_USERNAME);
        Cursor rawQuery = this.vDi.rawQuery("SELECT *, rowid FROM FinderContact WHERE username = " + h.Fl(str), null, 2);
        try {
            Cursor cursor = rawQuery;
            if (cursor == null) {
                gVar = null;
            } else if (cursor.moveToFirst()) {
                g gVar2 = new g();
                gVar2.convertFrom(cursor);
                gVar = gVar2;
            } else {
                gVar = null;
            }
            x xVar = x.SXb;
            b.a(rawQuery, null);
            AppMethodBeat.o(166956);
            return gVar;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(rawQuery, th2);
            AppMethodBeat.o(166956);
            throw th;
        }
    }
}
