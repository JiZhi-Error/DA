package com.tencent.mm.plugin.profile.ui.newbizinfo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class a extends MAutoStorage<h> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(h.iBg, "ProfileInfo")};
    public static final String[] iBi = new String[0];

    static {
        AppMethodBeat.i(27598);
        AppMethodBeat.o(27598);
    }

    public a(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, h.iBg, "ProfileInfo", iBi);
    }

    public final h aKz(String str) {
        AppMethodBeat.i(27597);
        h hVar = new h();
        hVar.field_username = str;
        if (!get(hVar, ch.COL_USERNAME)) {
            Log.e("MicroMsg.ProfileInfoStorage", "profileInfo is null");
            AppMethodBeat.o(27597);
            return null;
        }
        Log.i("MicroMsg.ProfileInfoStorage", "get username:%s", hVar.field_username);
        AppMethodBeat.o(27597);
        return hVar;
    }
}
