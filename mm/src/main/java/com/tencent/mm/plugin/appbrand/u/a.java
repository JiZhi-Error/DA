package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.a.j;
import com.tencent.mm.plugin.appbrand.u.b.a;
import com.tencent.mm.plugin.appbrand.u.c.d;
import com.tencent.mm.plugin.appbrand.u.c.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.u.b.a {
    private static Set<String> njR;

    @Override // com.tencent.mm.plugin.appbrand.u.b.a
    public final void a(StringBuffer stringBuffer) {
        AppMethodBeat.i(227223);
        super.a(stringBuffer);
        AppMethodBeat.o(227223);
    }

    @Override // com.tencent.mm.plugin.appbrand.u.b.a
    public final String bPR() {
        AppMethodBeat.i(47767);
        if (((Boolean) j.YI("debugNode").aLT()).booleanValue()) {
            try {
                Log.i("MicroMsg.AppBrandNodeJSInstallHelperWC", "hy: inject local node script!");
                String boY = s.boY(b.aKJ() + "nodjs_debug/node_jsapi.js");
                AppMethodBeat.o(47767);
                return boY;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandNodeJSInstallHelperWC", e2, "hy: can not find node script in sdcard!!", new Object[0]);
                AppMethodBeat.o(47767);
                return "";
            }
        } else {
            String bPR = super.bPR();
            AppMethodBeat.o(47767);
            return bPR;
        }
    }

    static {
        AppMethodBeat.i(47768);
        e.nkj = new e.a() {
            /* class com.tencent.mm.plugin.appbrand.u.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.u.c.e.a
            public final void kvStat(int i2, String str) {
                AppMethodBeat.i(47764);
                h.INSTANCE.kvStat(i2, str);
                AppMethodBeat.o(47764);
            }
        };
        d.nki = new d.a() {
            /* class com.tencent.mm.plugin.appbrand.u.a.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.u.c.d.a
            public final void Q(int i2, int i3, int i4) {
                AppMethodBeat.i(47765);
                h.INSTANCE.n((long) i2, (long) i3, (long) i4);
                AppMethodBeat.o(47765);
            }
        };
        com.tencent.mm.plugin.appbrand.u.b.b.a(new a.C0801a() {
            /* class com.tencent.mm.plugin.appbrand.u.a.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.u.b.a.C0801a, com.tencent.mm.plugin.appbrand.u.b.b.a
            public final void a(AppBrandRuntime appBrandRuntime, JSONObject jSONObject) {
                AppMethodBeat.i(47766);
                super.a(appBrandRuntime, jSONObject);
                try {
                    jSONObject.put("notSupport", a.njR.contains(MD5Util.getMD5String(appBrandRuntime.mAppId)));
                    jSONObject.put("switchWebsocket", ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_nodejs_websocket_open, 0));
                    jSONObject.put("jsApiPermissionDebugOn", ac.jOx.equals("1"));
                    AppMethodBeat.o(47766);
                } catch (JSONException e2) {
                    AppMethodBeat.o(47766);
                }
            }
        });
        HashSet hashSet = new HashSet();
        njR = hashSet;
        hashSet.add(MD5Util.getMD5String("wxa51f55ab3b2655b9"));
        njR.add(MD5Util.getMD5String("wx5b5555f4b7c7824b"));
        njR.add(MD5Util.getMD5String("wx8c67c6eee918d4ea"));
        njR.add(MD5Util.getMD5String("wx577c74fb940daaea"));
        njR.add(MD5Util.getMD5String("wx7d9e9cbea92ce71f"));
        njR.add(MD5Util.getMD5String("wx850d691fd02de8a1"));
        AppMethodBeat.o(47768);
    }
}
