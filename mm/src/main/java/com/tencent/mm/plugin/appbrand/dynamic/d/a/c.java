package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import com.tencent.mm.aa.c.b;
import com.tencent.mm.ab.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.plugin.appbrand.dynamic.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class c implements b {
    private MMHandler csE = new MMHandler("JsApiExecutor-Thread:" + hashCode());
    public String gIx;
    public a lnK;
    private LruCache<String, JSONObject> lnL = new LruCache<String, JSONObject>() {
        /* class com.tencent.mm.plugin.appbrand.dynamic.d.a.c.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.sdk.platformtools.LruCache
        public final /* synthetic */ JSONObject create(String str) {
            AppMethodBeat.i(121349);
            JSONObject Yy = Yy(str);
            AppMethodBeat.o(121349);
            return Yy;
        }

        private static JSONObject Yy(String str) {
            AppMethodBeat.i(121348);
            try {
                if (Util.isNullOrNil(str)) {
                    str = "{}";
                }
                long nanoTime = System.nanoTime();
                JSONObject FE = h.FE(str);
                com.tencent.mm.plugin.appbrand.dynamic.i.b.h(System.nanoTime() - nanoTime, str.length());
                AppMethodBeat.o(121348);
                return FE;
            } catch (Exception e2) {
                Log.e("MicroMsg.DefaultJsApiExecutor", android.util.Log.getStackTraceString(e2));
                AppMethodBeat.o(121348);
                return null;
            }
        }
    };

    public c() {
        AppMethodBeat.i(121351);
        AppMethodBeat.o(121351);
    }

    @Override // com.tencent.mm.aa.c.b
    public final String Fx(String str) {
        AppMethodBeat.i(121352);
        Log.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) do not exist.", str);
        String as = as(str, "fail:not supported");
        AppMethodBeat.o(121352);
        return as;
    }

    @Override // com.tencent.mm.aa.c.b
    public final String a(final com.tencent.mm.aa.c.a aVar, com.tencent.mm.aa.d.a aVar2, final com.tencent.mm.aa.b.b bVar, final String str, final b.a aVar3) {
        String str2;
        AppMethodBeat.i(121353);
        final String str3 = bVar.name;
        if (!aVar2.pP(bVar.index)) {
            u.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) no permission.", str3);
            String as = as(str3, "fail:access denied");
            AppMethodBeat.o(121353);
            return as;
        }
        final String Bs = n.Bs(System.nanoTime());
        final boolean WP = d.WP(str3);
        com.tencent.mm.plugin.appbrand.collector.c.c("jsapi_draw_canvas", Bs, "start_jsapi_invoke", WP);
        com.tencent.mm.plugin.appbrand.collector.c.cQ(Bs, "after_draw_actions");
        if (bVar instanceof b) {
            JSONObject Yx = Yx(str);
            if (Yx == null) {
                String as2 = as(str3, "fail:invalid data");
                AppMethodBeat.o(121353);
                return as2;
            }
            str2 = bVar.a(aVar, Yx, aVar3);
        } else {
            this.csE.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.d.a.c.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(121350);
                    com.tencent.mm.plugin.appbrand.collector.c.k(Bs, "parse_json_start", WP);
                    JSONObject Yx = c.this.Yx(str);
                    if (Yx == null) {
                        aVar3.bt(c.this.as(str3, "fail:invalid data"));
                        AppMethodBeat.o(121350);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("rawJsapiData", str);
                    com.tencent.mm.plugin.appbrand.collector.c.k(Bs, "parse_json_end", WP);
                    d.a(Bs, str, Yx);
                    bVar.a(aVar, Yx, bundle, aVar3);
                    AppMethodBeat.o(121350);
                }
            });
            str2 = "";
        }
        if (this.lnK != null) {
            this.lnK.YD(str3);
        }
        AppMethodBeat.o(121353);
        return str2;
    }

    @Override // com.tencent.mm.aa.c.b
    public final void quit() {
        AppMethodBeat.i(121354);
        this.csE.getSerial().RUS.quit();
        if (this.lnK != null) {
            this.lnK.report();
        }
        com.tencent.mm.plugin.appbrand.dynamic.d.b.a.Yz(this.gIx);
        u.v("MicroMsg.DefaultJsApiExecutor", "cache perf hit %d, miss %d, hit rate  " + ((float) ((((double) this.lnL.hitCount()) * 1.0d) / ((double) (this.lnL.hitCount() + this.lnL.missCount())))), Integer.valueOf(this.lnL.hitCount()), Integer.valueOf(this.lnL.missCount()));
        AppMethodBeat.o(121354);
    }

    /* access modifiers changed from: package-private */
    public final JSONObject Yx(String str) {
        AppMethodBeat.i(121355);
        JSONObject jSONObject = this.lnL.get(str);
        AppMethodBeat.o(121355);
        return jSONObject;
    }

    @Override // com.tencent.mm.aa.c.b
    public final String as(String str, String str2) {
        AppMethodBeat.i(121356);
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", str + ":" + str2);
        String jSONObject = new JSONObject(hashMap).toString();
        AppMethodBeat.o(121356);
        return jSONObject;
    }
}
