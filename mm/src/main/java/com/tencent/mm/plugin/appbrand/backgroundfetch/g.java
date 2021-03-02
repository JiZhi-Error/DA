package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class g extends MAutoStorage<f> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(f.iBg, "AppBrandBackgroundFetchDataToken")};

    static {
        AppMethodBeat.i(44743);
        AppMethodBeat.o(44743);
    }

    public g(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, f.iBg, "AppBrandBackgroundFetchDataToken", null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0039, code lost:
        if (super.get(r1, com.tencent.mm.g.c.ch.COL_USERNAME) != false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cN(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            r6 = 0
            r0 = 1
            r5 = 44740(0xaec4, float:6.2694E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            boolean r1 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r8)
            if (r1 != 0) goto L_0x0014
            boolean r1 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r9)
            if (r1 == 0) goto L_0x0018
        L_0x0014:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x0017:
            return r0
        L_0x0018:
            com.tencent.mm.plugin.appbrand.backgroundfetch.f r2 = new com.tencent.mm.plugin.appbrand.backgroundfetch.f
            r2.<init>()
            r2.field_username = r8
            r2.field_token = r9
            boolean r1 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r8)
            if (r1 != 0) goto L_0x0045
            com.tencent.mm.plugin.appbrand.backgroundfetch.f r1 = new com.tencent.mm.plugin.appbrand.backgroundfetch.f
            r1.<init>()
            r1.field_username = r8
            java.lang.String[] r3 = new java.lang.String[r0]
            java.lang.String r4 = "username"
            r3[r6] = r4
            boolean r3 = super.get(r1, r3)
            if (r3 == 0) goto L_0x0045
        L_0x003b:
            if (r1 != 0) goto L_0x0047
            boolean r0 = super.insert(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x0017
        L_0x0045:
            r1 = 0
            goto L_0x003b
        L_0x0047:
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r1 = "username"
            r0[r6] = r1
            boolean r0 = super.update(r2, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.backgroundfetch.g.cN(java.lang.String, java.lang.String):boolean");
    }

    public final AppBrandBackgroundFetchDataTokenParcel Wy(String str) {
        AppMethodBeat.i(44741);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44741);
            return null;
        }
        f fVar = new f();
        fVar.field_username = str;
        if (super.get(fVar, ch.COL_USERNAME)) {
            AppBrandBackgroundFetchDataTokenParcel appBrandBackgroundFetchDataTokenParcel = new AppBrandBackgroundFetchDataTokenParcel();
            appBrandBackgroundFetchDataTokenParcel.username = fVar.field_username;
            appBrandBackgroundFetchDataTokenParcel.token = fVar.field_token;
            AppMethodBeat.o(44741);
            return appBrandBackgroundFetchDataTokenParcel;
        }
        AppMethodBeat.o(44741);
        return null;
    }

    public final boolean gC(String str) {
        AppMethodBeat.i(44742);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44742);
            return true;
        }
        f fVar = new f();
        fVar.field_username = str;
        boolean delete = super.delete(fVar, ch.COL_USERNAME);
        AppMethodBeat.o(44742);
        return delete;
    }
}
