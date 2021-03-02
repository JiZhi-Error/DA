package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class n extends MAutoStorage<m> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(m.iBg, "WxaWidgetInfo")};
    public static final String[] iBi = new String[0];

    static {
        AppMethodBeat.i(76413);
        AppMethodBeat.o(76413);
    }

    public n(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, m.iBg, "WxaWidgetInfo", iBi);
    }

    public final m afV(String str) {
        AppMethodBeat.i(76412);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(76412);
            return null;
        }
        m mVar = new m();
        mVar.field_appId = str;
        mVar.field_appIdHash = str.hashCode();
        if (!get(mVar, "appIdHash")) {
            AppMethodBeat.o(76412);
            return null;
        }
        AppMethodBeat.o(76412);
        return mVar;
    }
}
