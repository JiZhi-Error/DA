package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class p extends MAutoStorage<aa> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(o.info, "AppSort")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(31047);
        AppMethodBeat.o(31047);
    }

    public p(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, o.info, "AppSort", null);
        AppMethodBeat.i(31044);
        this.db = iSQLiteDatabase;
        iSQLiteDatabase.execSQL("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( flag )");
        iSQLiteDatabase.execSQL("AppSort", "CREATE INDEX IF NOT EXISTS flagIdIndex ON AppSort ( sortId )");
        AppMethodBeat.o(31044);
    }

    public final List<String> Mq(long j2) {
        AppMethodBeat.i(31045);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder(256);
        sb.append("select * from AppSort");
        sb.append(" where ");
        sb.append("flag = ").append(j2);
        sb.append(" order by sortId desc ");
        Cursor rawQuery = rawQuery(sb.toString(), new String[0]);
        if (rawQuery == null) {
            Log.e("MicroMsg.AppSortStorage", "getAppListByFlag : cursor is null");
            AppMethodBeat.o(31045);
            return null;
        }
        Log.d("MicroMsg.AppSortStorage", "getAppListByFlag count = %d", Integer.valueOf(rawQuery.getCount()));
        int columnIndex = rawQuery.getColumnIndex("appId");
        while (rawQuery.moveToNext()) {
            arrayList.add(rawQuery.getString(columnIndex));
        }
        rawQuery.close();
        AppMethodBeat.o(31045);
        return arrayList;
    }

    public final boolean a(o oVar) {
        AppMethodBeat.i(31046);
        boolean insert = super.insert(oVar);
        AppMethodBeat.o(31046);
        return insert;
    }
}
