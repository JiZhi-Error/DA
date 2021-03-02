package com.tencent.mm.plugin.luckymoney.story.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.edn;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class d extends MAutoStorage<c> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "LocalStoryDetail")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(163698);
        AppMethodBeat.o(163698);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "LocalStoryDetail", null);
        this.db = iSQLiteDatabase;
    }

    public final List<edn> aDB(String str) {
        AppMethodBeat.i(163697);
        String format = String.format("SELECT * from %s where %s=?", "LocalStoryDetail", "packet_id");
        Cursor rawQuery = this.db.rawQuery(format, new String[]{str});
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            c cVar = new c();
            cVar.convertFrom(rawQuery);
            arrayList.add(c.a(cVar));
        }
        rawQuery.close();
        AppMethodBeat.o(163697);
        return arrayList;
    }
}
