package com.tencent.mm.openim.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;

public final class d extends MAutoStorage<c> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "OpenIMAppIdInfo")};
    public h iFy;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(c cVar) {
        AppMethodBeat.i(151332);
        boolean a2 = a(cVar);
        AppMethodBeat.o(151332);
        return a2;
    }

    static {
        AppMethodBeat.i(151333);
        AppMethodBeat.o(151333);
    }

    public d(h hVar) {
        super(hVar, c.info, "OpenIMAppIdInfo", null);
        this.iFy = hVar;
    }

    public final boolean a(c cVar) {
        AppMethodBeat.i(151330);
        cVar.field_updateTime = Util.nowSecond();
        boolean replace = super.replace(cVar);
        AppMethodBeat.o(151330);
        return replace;
    }

    public final List<String> Sd(String str) {
        AppMethodBeat.i(151331);
        LinkedList linkedList = new LinkedList();
        Cursor rawQuery = this.iFy.rawQuery("select distinct appid from OpenIMAppIdInfo where appid=? ", new String[]{str}, 2);
        if (rawQuery.moveToFirst()) {
            do {
                String string = rawQuery.getString(0);
                if (!Util.isNullOrNil(string)) {
                    linkedList.add(string);
                }
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        AppMethodBeat.o(151331);
        return linkedList;
    }
}
