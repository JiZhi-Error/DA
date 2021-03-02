package com.tencent.mm.aa.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c {
    a hph;
    private com.tencent.mm.aa.d.a hpi;
    public d hpj;
    b hpk;

    public c(Context context, e eVar, com.tencent.mm.aa.d.a aVar, b bVar) {
        AppMethodBeat.i(144805);
        this.hph = new a(context, eVar);
        this.hpi = aVar;
        this.hpk = bVar;
        AppMethodBeat.o(144805);
    }

    public final String h(String str, String str2, final int i2) {
        b bVar;
        AppMethodBeat.i(144806);
        try {
            d dVar = this.hpj;
            if (Util.isNullOrNil(str)) {
                bVar = null;
            } else {
                bVar = dVar.hpo.get(str);
            }
            if (bVar == null) {
                String Fx = this.hpk.Fx(str);
                AppMethodBeat.o(144806);
                return Fx;
            }
            String a2 = this.hpk.a(this.hph, this.hpi, bVar, str2, new b.a() {
                /* class com.tencent.mm.aa.c.c.AnonymousClass1 */

                @Override // com.tencent.mm.aa.b.b.a
                public final void bt(Object obj) {
                    String obj2;
                    AppMethodBeat.i(144803);
                    e eVar = c.this.hph.hpm;
                    int i2 = i2;
                    if (obj == null) {
                        obj2 = "";
                    } else {
                        obj2 = obj.toString();
                    }
                    if (Util.isNullOrNil(obj2)) {
                        obj2 = "{}";
                    }
                    eVar.hpr.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", Integer.valueOf(i2), obj2), null);
                    AppMethodBeat.o(144803);
                }
            });
            AppMethodBeat.o(144806);
            return a2;
        } catch (Exception e2) {
            Log.e("MicroMsg.MiniJsApiCore", "Invoke JsApi error: %s, %s", str, android.util.Log.getStackTraceString(e2));
            AppMethodBeat.o(144806);
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a implements a {
        e hpm;
        ad.b hpn = new ad.b();
        Context mContext;

        a(Context context, e eVar) {
            AppMethodBeat.i(144804);
            this.mContext = context;
            this.hpm = eVar;
            AppMethodBeat.o(144804);
        }

        @Override // com.tencent.mm.aa.c.a
        public final Context getContext() {
            return this.mContext;
        }

        @Override // com.tencent.mm.aa.c.a
        public final ad.b ayQ() {
            return this.hpn;
        }
    }
}
