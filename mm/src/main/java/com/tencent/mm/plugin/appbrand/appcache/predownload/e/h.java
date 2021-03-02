package com.tencent.mm.plugin.appbrand.appcache.predownload.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class h extends MAutoStorage<g> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(g.iBg, "WxaAttrVersionServerNotifyRecord")};

    public h(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, g.iBg, "WxaAttrVersionServerNotifyRecord", g.INDEX_CREATE);
    }

    static {
        AppMethodBeat.i(44445);
        AppMethodBeat.o(44445);
    }

    public final g VG(String str) {
        AppMethodBeat.i(226381);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(226381);
            return null;
        }
        g gVar = new g();
        gVar.field_username = str;
        if (get(gVar, new String[0])) {
            AppMethodBeat.o(226381);
            return gVar;
        }
        AppMethodBeat.o(226381);
        return null;
    }
}
