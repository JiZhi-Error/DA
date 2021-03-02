package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.j;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class i extends MAutoStorage<j> {
    public static final String mWc = MAutoStorage.getCreateSQLs(j.kLR, "LaunchWxaWidgetRespData");

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, boolean, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean delete(j jVar, boolean z, String[] strArr) {
        AppMethodBeat.i(76407);
        j jVar2 = jVar;
        if (!Util.isNullOrNil(strArr)) {
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    break;
                } else if (strArr[i2].equals("appId")) {
                    strArr[i2] = "appIdHash";
                    jVar2.field_appIdHash = jVar2.field_appId.hashCode();
                    break;
                } else {
                    i2++;
                }
            }
        }
        boolean delete = super.delete(jVar2, z, strArr);
        AppMethodBeat.o(76407);
        return delete;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean get(j jVar, String[] strArr) {
        AppMethodBeat.i(76406);
        boolean a2 = a(jVar, strArr);
        AppMethodBeat.o(76406);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, boolean] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insertNotify(j jVar, boolean z) {
        AppMethodBeat.i(76408);
        boolean a2 = a(jVar, z);
        AppMethodBeat.o(76408);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, boolean, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean updateNotify(j jVar, boolean z, String[] strArr) {
        AppMethodBeat.i(76405);
        boolean a2 = a(jVar, z, strArr);
        AppMethodBeat.o(76405);
        return a2;
    }

    static {
        AppMethodBeat.i(76409);
        AppMethodBeat.o(76409);
    }

    public i(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, j.kLR, "LaunchWxaWidgetRespData", j.INDEX_CREATE);
    }

    public final j a(String str, int i2, int i3, chg chg) {
        boolean z;
        AppMethodBeat.i(76400);
        if (Util.isNullOrNil(str) || chg == null) {
            AppMethodBeat.o(76400);
            return null;
        }
        j jVar = new j();
        jVar.field_appIdHash = str.hashCode();
        jVar.field_appId = str;
        jVar.field_pkgType = i2;
        jVar.field_widgetType = i3;
        boolean z2 = !a(jVar, new String[]{"appId", "pkgType", "widgetType"});
        if (!j.a(jVar.field_launchAction, chg.MmG)) {
            jVar.field_launchAction = chg.MmG;
            z = true;
        } else {
            z = false;
        }
        if (!j.a(jVar.field_jsApiInfo, chg.MmA)) {
            jVar.field_jsApiInfo = chg.MmA;
            z = true;
        }
        if (!j.a(jVar.field_versionInfo, chg.MmH)) {
            jVar.field_versionInfo = chg.MmH;
            z = true;
        }
        if (!j.a(jVar.field_widgetSetting, chg.MmI)) {
            jVar.field_widgetSetting = chg.MmI;
            z = true;
        }
        if (z) {
            if (z2) {
                a(jVar, false);
            } else {
                a(jVar, false, "appId", "pkgType", "widgetType");
            }
        }
        if (z) {
            a(jVar, "appId", "pkgType", "widgetType");
        }
        AppMethodBeat.o(76400);
        return jVar;
    }

    public final j U(String str, int i2, int i3) {
        AppMethodBeat.i(76401);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(76401);
            return null;
        }
        j jVar = new j();
        jVar.field_appIdHash = str.hashCode();
        jVar.field_appId = str;
        jVar.field_pkgType = i2;
        jVar.field_widgetType = i3;
        if (a(jVar, "appId", "pkgType", "widgetType")) {
            AppMethodBeat.o(76401);
            return jVar;
        }
        AppMethodBeat.o(76401);
        return null;
    }

    public final boolean a(j jVar, String... strArr) {
        AppMethodBeat.i(76402);
        if (!Util.isNullOrNil(strArr)) {
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    break;
                } else if (strArr[i2].equals("appId")) {
                    strArr[i2] = "appIdHash";
                    jVar.field_appIdHash = jVar.field_appId.hashCode();
                    break;
                } else {
                    i2++;
                }
            }
        }
        boolean z = super.get(jVar, strArr);
        AppMethodBeat.o(76402);
        return z;
    }

    private boolean a(j jVar, boolean z) {
        AppMethodBeat.i(76403);
        jVar.field_appIdHash = jVar.field_appId.hashCode();
        super.insertNotify(jVar, z);
        boolean a2 = a(jVar, "appId");
        AppMethodBeat.o(76403);
        return a2;
    }

    private boolean a(j jVar, boolean z, String... strArr) {
        AppMethodBeat.i(76404);
        if (!Util.isNullOrNil(strArr)) {
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    break;
                } else if (strArr[i2].equals("appId")) {
                    strArr[i2] = "appIdHash";
                    jVar.field_appIdHash = jVar.field_appId.hashCode();
                    break;
                } else {
                    i2++;
                }
            }
        }
        boolean updateNotify = super.updateNotify(jVar, z, strArr);
        AppMethodBeat.o(76404);
        return updateNotify;
    }
}
