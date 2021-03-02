package com.tencent.mm.openim.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;

public final class f extends MAutoStorage<e> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(e.info, "OpenIMWordingInfo")};
    public h iFy;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(e eVar) {
        AppMethodBeat.i(151337);
        boolean a2 = a(eVar);
        AppMethodBeat.o(151337);
        return a2;
    }

    static {
        AppMethodBeat.i(151338);
        AppMethodBeat.o(151338);
    }

    public f(h hVar) {
        super(hVar, e.info, "OpenIMWordingInfo", null);
        this.iFy = hVar;
    }

    public final boolean a(e eVar) {
        AppMethodBeat.i(151335);
        eVar.field_updateTime = Util.nowSecond();
        boolean replace = super.replace(eVar);
        AppMethodBeat.o(151335);
        return replace;
    }

    public final List<String> S(int i2, String str) {
        AppMethodBeat.i(151336);
        LinkedList linkedList = new LinkedList();
        String str2 = " select wordingId from OpenIMWordingInfo where language='" + str + "' order by updateTime limit " + i2;
        Log.d("MicroMsg.Openim.OpenIMWordingInfoStg", "getLastWording sql:%s", str2);
        Cursor rawQuery = this.iFy.rawQuery(str2, null, 2);
        if (rawQuery.moveToFirst()) {
            do {
                String string = rawQuery.getString(0);
                if (!Util.isNullOrNil(string)) {
                    linkedList.add(string);
                }
            } while (rawQuery.moveToNext());
        }
        Log.d("MicroMsg.Openim.OpenIMWordingInfoStg", "getLastWording result cnt: %d, language:%s", Integer.valueOf(linkedList.size()), str);
        rawQuery.close();
        AppMethodBeat.o(151336);
        return linkedList;
    }
}
