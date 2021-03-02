package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class ao extends MAutoStorage<ap> {
    public static final String mWc = MAutoStorage.getCreateSQLs(ap.kLR, "LaunchWxaAppRespTable");

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, boolean, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean delete(ap apVar, boolean z, String[] strArr) {
        AppMethodBeat.i(47279);
        boolean a2 = a(apVar, z, strArr);
        AppMethodBeat.o(47279);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean get(ap apVar, String[] strArr) {
        AppMethodBeat.i(47278);
        boolean a2 = a(apVar, strArr);
        AppMethodBeat.o(47278);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, boolean] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insertNotify(ap apVar, boolean z) {
        AppMethodBeat.i(47280);
        boolean a2 = a(apVar, z);
        AppMethodBeat.o(47280);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, boolean, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean updateNotify(ap apVar, boolean z, String[] strArr) {
        AppMethodBeat.i(47277);
        boolean b2 = b(apVar, z, strArr);
        AppMethodBeat.o(47277);
        return b2;
    }

    static {
        AppMethodBeat.i(47281);
        AppMethodBeat.o(47281);
    }

    public ao(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, ap.kLR, "LaunchWxaAppRespTable", ap.INDEX_CREATE);
    }

    public final ap a(String str, che che) {
        boolean z;
        AppMethodBeat.i(47271);
        if (Util.isNullOrNil(str) || che == null) {
            AppMethodBeat.o(47271);
            return null;
        }
        ap apVar = new ap();
        apVar.b(che);
        apVar.field_appId = str;
        ap apVar2 = new ap();
        apVar2.field_appId = str;
        boolean z2 = !a(apVar2, new String[]{"appId"});
        if (z2 || !apVar2.equals(apVar)) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.LaunchWxaAppCacheStorage", "flush resp, appId %s, apply %B, insert %B", str, Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z) {
            if (z2) {
                a(apVar, false);
            } else {
                b(apVar, false, "appId");
            }
        }
        if (z) {
            if (a(apVar2, "appId")) {
                AppMethodBeat.o(47271);
                return apVar2;
            }
        }
        AppMethodBeat.o(47271);
        return apVar;
    }

    public final boolean gC(String str) {
        AppMethodBeat.i(47272);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(47272);
            return false;
        }
        ap apVar = new ap();
        apVar.field_appId = str;
        boolean a2 = a(apVar, false, "appId");
        AppMethodBeat.o(47272);
        return a2;
    }

    private boolean a(ap apVar, boolean z, String... strArr) {
        AppMethodBeat.i(47273);
        if (!Util.isNullOrNil(strArr)) {
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    break;
                } else if (strArr[i2].equals("appId")) {
                    strArr[i2] = "appIdHash";
                    apVar.field_appIdHash = apVar.field_appId.hashCode();
                    break;
                } else {
                    i2++;
                }
            }
        }
        boolean delete = super.delete(apVar, z, strArr);
        AppMethodBeat.o(47273);
        return delete;
    }

    public final boolean a(ap apVar, String... strArr) {
        AppMethodBeat.i(47274);
        if (!Util.isNullOrNil(strArr)) {
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    break;
                } else if (strArr[i2].equals("appId")) {
                    strArr[i2] = "appIdHash";
                    apVar.field_appIdHash = apVar.field_appId.hashCode();
                    break;
                } else {
                    i2++;
                }
            }
        }
        boolean z = super.get(apVar, strArr);
        AppMethodBeat.o(47274);
        return z;
    }

    private boolean a(ap apVar, boolean z) {
        AppMethodBeat.i(47275);
        apVar.field_appIdHash = apVar.field_appId.hashCode();
        super.insertNotify(apVar, z);
        boolean a2 = a(apVar, "appId");
        Log.i("MicroMsg.LaunchWxaAppCacheStorage", "insertNotify appId %s ret %B", apVar.field_appId, Boolean.valueOf(a2));
        AppMethodBeat.o(47275);
        return a2;
    }

    private boolean b(ap apVar, boolean z, String... strArr) {
        AppMethodBeat.i(47276);
        if (!Util.isNullOrNil(strArr)) {
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    break;
                } else if (strArr[i2].equals("appId")) {
                    strArr[i2] = "appIdHash";
                    apVar.field_appIdHash = apVar.field_appId.hashCode();
                    break;
                } else {
                    i2++;
                }
            }
        }
        boolean updateNotify = super.updateNotify(apVar, z, strArr);
        Log.i("MicroMsg.LaunchWxaAppCacheStorage", "updateNotify appId %s, ret %B", apVar.field_appId, Boolean.valueOf(updateNotify));
        AppMethodBeat.o(47276);
        return updateNotify;
    }
}
