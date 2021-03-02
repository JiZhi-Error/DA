package com.tencent.mm.plugin.appbrand.task.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class c extends MAutoStorage<b> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(b.kLR, "WxaCheckDemoInfo")};

    static {
        AppMethodBeat.i(227539);
        AppMethodBeat.o(227539);
    }

    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, b.kLR, "WxaCheckDemoInfo", b.INDEX_CREATE);
    }

    public final boolean aD(String str, boolean z) {
        AppMethodBeat.i(227534);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "setWxaCheckDemoInfoData,invalid input %s", str);
            AppMethodBeat.o(227534);
            return false;
        } else if (aE(str, z)) {
            Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "setWxaCheckDemoInfoData appId:%s ok", str);
            AppMethodBeat.o(227534);
            return true;
        } else {
            AppMethodBeat.o(227534);
            return false;
        }
    }

    private boolean aE(String str, boolean z) {
        AppMethodBeat.i(227535);
        b bVar = new b();
        bVar.field_appId = str;
        boolean z2 = get(bVar, new String[0]);
        bVar.field_permissionDemo = z;
        bVar.field_versiontime = Util.nowSecond();
        if (z2) {
            boolean update = update(bVar, new String[0]);
            AppMethodBeat.o(227535);
            return update;
        }
        boolean insert = insert(bVar);
        AppMethodBeat.o(227535);
        return insert;
    }

    public final int Xi(String str) {
        AppMethodBeat.i(227536);
        try {
            b bVar = new b();
            bVar.field_appId = str;
            if (get(bVar, new String[0])) {
                Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "found info with appId(%s) versiontime(%d)", str, Long.valueOf(bVar.field_versiontime));
                if (Util.secondsToNow(bVar.field_versiontime) > 86400) {
                    AppMethodBeat.o(227536);
                    return 0;
                } else if (bVar.field_permissionDemo) {
                    AppMethodBeat.o(227536);
                    return 2;
                } else {
                    AppMethodBeat.o(227536);
                    return 1;
                }
            } else {
                AppMethodBeat.o(227536);
                return 0;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", e2, "get with appId(%s)", str);
            AppMethodBeat.o(227536);
            return 0;
        }
    }

    public final boolean gC(String str) {
        AppMethodBeat.i(227537);
        Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "delete appId(%s)", str);
        b bVar = new b();
        bVar.field_appId = str;
        boolean delete = delete(bVar, new String[0]);
        AppMethodBeat.o(227537);
        return delete;
    }

    public final void byC() {
        AppMethodBeat.i(227538);
        try {
            Log.i("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", "deleteAll");
            super.execSQL("WxaCheckDemoInfo", "delete from WxaCheckDemoInfo");
            AppMethodBeat.o(227538);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandTaskWxaCheckDemoInfoStorage", e2, " deleteAll Exception", new Object[0]);
            AppMethodBeat.o(227538);
        }
    }
}
