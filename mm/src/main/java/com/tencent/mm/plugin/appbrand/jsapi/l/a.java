package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.o.b;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.p.a;
import com.tencent.mm.plugin.appbrand.s.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends b {
    public static final int CTRL_INDEX = 467;
    public static final String NAME = "createLoadSubPackageTask";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String bjl() {
        AppMethodBeat.i(139893);
        StringBuilder sb = new StringBuilder();
        c.bPx();
        String sb2 = sb.append(c.bPw()).toString();
        AppMethodBeat.o(139893);
        return sb2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String auJ() {
        return "loadTaskId";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final void a(f fVar, JSONObject jSONObject, final String str) {
        AppMethodBeat.i(182227);
        final k kVar = (k) fVar;
        final String appId = fVar.getAppId();
        final String optString = jSONObject.optString("moduleName");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: null or nil moduleName");
            a(kVar, str, optString);
            AppMethodBeat.o(182227);
            return;
        }
        AppBrandRuntime runtime = kVar.getRuntime();
        if (runtime == null || runtime.isDestroyed()) {
            Log.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: runtime is not in valid state!");
            a(kVar, str, optString);
            AppMethodBeat.o(182227);
            return;
        }
        com.tencent.mm.plugin.appbrand.p.a aVar = runtime.kAI;
        if (aVar == null) {
            Log.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: modularizingHelper null!");
            a(kVar, str, optString);
            AppMethodBeat.o(182227);
        } else if (aVar.bPn() || optString.equals(ModulePkgInfo.MAIN_MODULE_NAME)) {
            try {
                aVar.a(optString, new a.b() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.l.a.AnonymousClass1 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.plugin.appbrand.p.a.b
                    public final void a(a.d dVar) {
                        AppMethodBeat.i(139888);
                        Log.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: loadResult: %s, with appId[%s] moduleName[%s]", dVar.toString(), appId, optString);
                        switch (AnonymousClass3.mfu[dVar.ordinal()]) {
                            case 1:
                                C0672a.a(kVar, str, "success", optString);
                                AppMethodBeat.o(139888);
                                return;
                            case 2:
                            case 3:
                                C0672a.a(kVar, str, "fail", optString);
                                AppMethodBeat.o(139888);
                                return;
                            case 4:
                                Log.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: should not happen cancel!!");
                                C0672a.a(kVar, str, "fail", optString);
                                break;
                        }
                        AppMethodBeat.o(139888);
                    }
                }, new a.AbstractC0766a() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.l.a.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.appbrand.p.a.AbstractC0766a
                    public final void b(com.tencent.mm.plugin.appbrand.p.c cVar) {
                        AppMethodBeat.i(139889);
                        Log.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: module name: %s progress: %s", optString, cVar.toString());
                        C0672a.a(kVar, str, "progressUpdate", optString, cVar.getProgress(), cVar.bww(), cVar.getTotalLength());
                        AppMethodBeat.o(139889);
                    }
                });
                AppMethodBeat.o(182227);
            } catch (IllegalAccessError e2) {
                Log.printErrStackTrace("MicroMsg.JsApiCreateLoadSubPackageTask", e2, "loadModule(%s)", optString);
                a(kVar, str, optString);
                AppMethodBeat.o(182227);
            }
        } else {
            Log.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: not support modularizing but still called JsApiCreateLoadSubPackageTask");
            a(kVar, str, optString);
            AppMethodBeat.o(182227);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.a$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] mfu = new int[a.d.values().length];

        static {
            AppMethodBeat.i(139890);
            try {
                mfu[a.d.OK.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mfu[a.d.FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                mfu[a.d.MODULE_NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                mfu[a.d.CANCEL.ordinal()] = 4;
                AppMethodBeat.o(139890);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(139890);
            }
        }
    }

    private static void a(f fVar, String str, String str2) {
        AppMethodBeat.i(230539);
        C0672a.a(fVar, str, "fail", str2);
        AppMethodBeat.o(230539);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.a$a  reason: collision with other inner class name */
    public static class C0672a extends s {
        public static final int CTRL_INDEX = 468;
        public static final String NAME = "onLoadSubPackageTaskStateChange";

        static void a(f fVar, String str, String str2, String str3) {
            AppMethodBeat.i(139891);
            a(fVar, str, str2, str3, -1, -1, -1);
            AppMethodBeat.o(139891);
        }

        static void a(f fVar, String str, String str2, String str3, int i2, long j2, long j3) {
            AppMethodBeat.i(139892);
            Log.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: formatEventCallback taskId: %s, state: %s, progress: %d, currentWritten: %d, totalWritten: %d", str, str2, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3));
            HashMap hashMap = new HashMap();
            hashMap.put("taskId", str);
            hashMap.put("state", str2);
            hashMap.put("moduleName", str3);
            if (i2 >= 0) {
                hashMap.put("progress", Integer.valueOf(i2));
            }
            if (j2 >= 0) {
                hashMap.put("totalBytesWritten", Long.valueOf(j2));
            }
            if (j3 >= 0) {
                hashMap.put("totalBytesExpectedToWrite", Long.valueOf(j3));
            }
            new C0672a().g(fVar).Zg(new JSONObject(hashMap).toString()).bEo();
            AppMethodBeat.o(139892);
        }
    }
}
