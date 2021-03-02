package com.tencent.mm.plugin.lite.b;

import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.List;

public final class c {
    private static final c yEA = new c();

    static {
        AppMethodBeat.i(198855);
        AppMethodBeat.o(198855);
    }

    private c() {
    }

    public static c ecA() {
        return yEA;
    }

    public static boolean ecB() {
        AppMethodBeat.i(198854);
        Log.d("MicroMsg.LiteApp.LiteAppCleaner", "doCleanLiteApp start");
        f.ecC();
        List<WxaLiteAppInfo> ecD = f.ecD();
        if (ecD != null && !ecD.isEmpty()) {
            for (WxaLiteAppInfo wxaLiteAppInfo : ecD) {
                o oVar = new o(s.k(ar.NSg + "/pkg/" + wxaLiteAppInfo.appId, true));
                if (oVar.exists()) {
                    o[] het = oVar.het();
                    if (het != null) {
                        for (o oVar2 : het) {
                            Log.i("MicroMsg.LiteApp.LiteAppCleaner", "app path:%s local path:", wxaLiteAppInfo.path, aa.z(oVar2.mUri));
                            if (!aa.z(oVar2.mUri).equalsIgnoreCase(s.k(wxaLiteAppInfo.path, true))) {
                                Log.w("MicroMsg.LiteApp.LiteAppCleaner", "delete old version folder.");
                                s.dy(aa.z(oVar2.mUri), true);
                            }
                        }
                    } else {
                        Log.d("MicroMsg.LiteApp.LiteAppCleaner", "version is empty");
                    }
                } else {
                    Log.w("MicroMsg.LiteApp.LiteAppCleaner", "appId %s 目录不存在", wxaLiteAppInfo.appId);
                }
            }
        }
        Log.d("MicroMsg.LiteApp.LiteAppCleaner", "doCleanLiteApp end");
        AppMethodBeat.o(198854);
        return true;
    }
}
