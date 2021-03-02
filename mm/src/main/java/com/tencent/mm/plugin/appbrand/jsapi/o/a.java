package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.p;
import java.util.HashMap;

public final class a extends bc {
    private static final int CTRL_INDEX = 530;
    private static final String NAME = "onLocalServiceEvent";
    private static a mga = new a();

    static {
        AppMethodBeat.i(144183);
        AppMethodBeat.o(144183);
    }

    public static void a(f fVar, p.c cVar) {
        AppMethodBeat.i(144178);
        a(fVar, cVar, "found");
        AppMethodBeat.o(144178);
    }

    public static void b(f fVar, p.c cVar) {
        AppMethodBeat.i(144179);
        a(fVar, cVar, "lost");
        AppMethodBeat.o(144179);
    }

    public static void c(f fVar, p.c cVar) {
        AppMethodBeat.i(144180);
        a(fVar, cVar, "resolveFail");
        AppMethodBeat.o(144180);
    }

    public static void t(f fVar) {
        AppMethodBeat.i(144181);
        a(fVar, null, "stopScan");
        AppMethodBeat.o(144181);
    }

    private static synchronized void a(f fVar, p.c cVar, String str) {
        synchronized (a.class) {
            AppMethodBeat.i(144182);
            HashMap hashMap = new HashMap();
            hashMap.put("event", str);
            if (TextUtils.equals(str, "found") || TextUtils.equals(str, "lost") || TextUtils.equals(str, "resolveFail")) {
                hashMap.put("serviceType", cVar.iBb);
                hashMap.put("serviceName", cVar.serviceName);
                if (!TextUtils.equals(str, "resolveFail")) {
                    hashMap.put("ip", cVar.ip);
                    hashMap.put("port", Integer.valueOf(cVar.port));
                    hashMap.put("attributes", cVar.njl);
                }
            }
            mga.L(hashMap).h(fVar).bEo();
            AppMethodBeat.o(144182);
        }
    }
}
