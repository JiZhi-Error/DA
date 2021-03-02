package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class d extends MAutoStorage<c> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(c.kXQ, "AppBrandBackgroundFetchData")};

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.kXQ, "AppBrandBackgroundFetchData", null);
    }

    static {
        AppMethodBeat.i(44709);
        AppMethodBeat.o(44709);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0049, code lost:
        if (super.get(r0, com.tencent.mm.g.c.ch.COL_USERNAME, "fetchType") != false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r6, int r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, int r11, long r12) {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.backgroundfetch.d.a(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, long):boolean");
    }

    private AppBrandBackgroundFetchDataParcel bt(String str, int i2) {
        AppMethodBeat.i(44706);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44706);
            return null;
        }
        c cVar = new c();
        cVar.field_username = str;
        cVar.field_fetchType = i2;
        if (super.get(cVar, ch.COL_USERNAME, "fetchType")) {
            AppBrandBackgroundFetchDataParcel appBrandBackgroundFetchDataParcel = new AppBrandBackgroundFetchDataParcel();
            appBrandBackgroundFetchDataParcel.username = cVar.field_username;
            appBrandBackgroundFetchDataParcel.kXP = cVar.field_fetchType;
            appBrandBackgroundFetchDataParcel.path = cVar.field_path;
            appBrandBackgroundFetchDataParcel.query = cVar.field_query;
            appBrandBackgroundFetchDataParcel.data = cVar.field_data;
            appBrandBackgroundFetchDataParcel.scene = cVar.field_scene;
            appBrandBackgroundFetchDataParcel.crj = cVar.field_updateTime;
            AppMethodBeat.o(44706);
            return appBrandBackgroundFetchDataParcel;
        }
        AppMethodBeat.o(44706);
        return null;
    }

    public final long bu(String str, int i2) {
        AppMethodBeat.i(44707);
        AppBrandBackgroundFetchDataParcel bt = bt(str, i2);
        if (bt != null) {
            long j2 = bt.crj;
            AppMethodBeat.o(44707);
            return j2;
        }
        AppMethodBeat.o(44707);
        return 0;
    }

    public final AppBrandBackgroundFetchDataParcel bv(String str, int i2) {
        AppMethodBeat.i(44708);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44708);
            return null;
        }
        AppBrandBackgroundFetchDataParcel bt = bt(y.Xy(str), i2);
        AppMethodBeat.o(44708);
        return bt;
    }
}
