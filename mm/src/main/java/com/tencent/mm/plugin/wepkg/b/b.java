package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class b extends MAutoStorage<a> {
    private static b JLU;
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.iBg, "WePkgDiffPackage")};
    private static final Object lock = new Object();
    private ISQLiteDatabase kLX;

    static {
        AppMethodBeat.i(110561);
        AppMethodBeat.o(110561);
    }

    public static b gkD() {
        AppMethodBeat.i(110558);
        if (JLU == null) {
            synchronized (lock) {
                try {
                    if (JLU == null || !JLU.bAh()) {
                        JLU = new b(g.aAh().hqK);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(110558);
                    throw th;
                }
            }
        }
        b bVar = JLU;
        AppMethodBeat.o(110558);
        return bVar;
    }

    private b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.iBg, "WePkgDiffPackage", a.INDEX_CREATE);
        this.kLX = iSQLiteDatabase;
    }

    private boolean bAh() {
        return this.kLX != null;
    }

    public final a bcj(String str) {
        AppMethodBeat.i(110559);
        if (!bAh() || Util.isNullOrNil(str)) {
            AppMethodBeat.o(110559);
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=%s", "WePkgDiffPackage", "pkgId", "'" + str + "'"), new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(110559);
            return null;
        } else if (rawQuery.moveToFirst()) {
            a aVar = new a();
            aVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(110559);
            return aVar;
        } else {
            rawQuery.close();
            AppMethodBeat.o(110559);
            return null;
        }
    }

    public final boolean gC(String str) {
        AppMethodBeat.i(110560);
        if (!bAh() || Util.isNullOrNil(str)) {
            AppMethodBeat.o(110560);
            return false;
        }
        boolean execSQL = execSQL("WePkgDiffPackage", String.format("delete from %s where %s=%s", "WePkgDiffPackage", "pkgId", "'" + str + "'"));
        AppMethodBeat.o(110560);
        return execSQL;
    }
}
