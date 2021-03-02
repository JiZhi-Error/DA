package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class at extends MAutoStorage<as> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(as.kLR, "WxaJsApiPluginInfo")};

    static {
        AppMethodBeat.i(227093);
        AppMethodBeat.o(227093);
    }

    public at(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, as.kLR, "WxaJsApiPluginInfo", as.INDEX_CREATE);
    }

    public final ys ach(String str) {
        AppMethodBeat.i(227092);
        try {
            as asVar = new as();
            asVar.field_appId = str;
            if (get(asVar, new String[0])) {
                Log.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s)", str);
                ys ysVar = new ys();
                ysVar.parseFrom(asVar.field_permissionProtoBlob);
                if (ysVar.LjS.zy.length > 0) {
                    AppMethodBeat.o(227092);
                    return ysVar;
                }
                Log.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "found info with appId(%s) but jsapi_control_bytes invalid", str);
            }
            AppMethodBeat.o(227092);
            return null;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.LaunchWxaJsApiPluginInfoStorage", e2, "get with appId(%s)", str);
            AppMethodBeat.o(227092);
            return null;
        }
    }
}
