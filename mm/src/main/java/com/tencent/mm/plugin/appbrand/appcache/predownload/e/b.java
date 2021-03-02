package com.tencent.mm.plugin.appbrand.appcache.predownload.e;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class b extends MAutoStorage<a> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(a.iBg, "PredownloadBlockCgiRequest")};
    private final ISQLiteDatabase kLX;

    static {
        AppMethodBeat.i(44436);
        AppMethodBeat.o(44436);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.iBg, "PredownloadBlockCgiRequest", a.INDEX_CREATE);
        this.kLX = iSQLiteDatabase;
    }

    public final Pair<Boolean, Integer> I(String str, int i2, int i3) {
        AppMethodBeat.i(44433);
        Pair<Boolean, Integer> c2 = c(ch.COL_USERNAME, str, i2, i3);
        AppMethodBeat.o(44433);
        return c2;
    }

    public final Pair<Boolean, Integer> J(String str, int i2, int i3) {
        AppMethodBeat.i(44434);
        Pair<Boolean, Integer> c2 = c("appId", str, i2, i3);
        AppMethodBeat.o(44434);
        return c2;
    }

    private Pair<Boolean, Integer> c(String str, String str2, int i2, int i3) {
        int i4 = -1;
        AppMethodBeat.i(44435);
        long nowSecond = Util.nowSecond();
        Cursor rawQuery = this.kLX.rawQuery("select reportId from PredownloadBlockCgiRequest where " + str + "=? and startTime<" + nowSecond + " and " + nowSecond + "<endTime and cgiList like '%;" + i2 + ";%' and sceneList like '%;" + i3 + ";%'", new String[]{str2});
        if (rawQuery == null || rawQuery.isClosed()) {
            Pair<Boolean, Integer> create = Pair.create(Boolean.FALSE, -1);
            AppMethodBeat.o(44435);
            return create;
        }
        boolean moveToFirst = rawQuery.moveToFirst();
        if (moveToFirst) {
            i4 = rawQuery.getInt(0);
        }
        rawQuery.close();
        Pair<Boolean, Integer> create2 = Pair.create(Boolean.valueOf(moveToFirst), Integer.valueOf(i4));
        AppMethodBeat.o(44435);
        return create2;
    }
}
