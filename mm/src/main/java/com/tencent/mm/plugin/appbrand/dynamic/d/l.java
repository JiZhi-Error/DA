package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.ad;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.plugin.appbrand.dynamic.widget.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public final class l extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {
    public l(int i2) {
        super("setWidgetSize", i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.a.a
    public final void a(com.tencent.mm.aa.c.a aVar, JSONObject jSONObject, final b.a<JSONObject> aVar2) {
        AppMethodBeat.i(121336);
        ad.b ayQ = aVar.ayQ();
        a.C0577a aVar3 = new a.C0577a();
        aVar3.id = ayQ.getString("__page_view_id", "");
        aVar3.width = jSONObject.optInt("width", ayQ.getInt("__page_view_width", 0));
        aVar3.height = jSONObject.optInt("height", ayQ.getInt("__page_view_height", 0));
        XIPCInvoker.a(ayQ.getString("__process_name", MMApplicationContext.getProcessName()), aVar3, a.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.d.l.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                Bundle bundle2;
                String str;
                AppMethodBeat.i(121333);
                Bundle bundle3 = bundle;
                boolean z = false;
                if (bundle3 != null) {
                    z = bundle3.getBoolean("ret");
                    String string = bundle3.getString("reason");
                    bundle2 = bundle3.getBundle("data");
                    str = string;
                } else {
                    bundle2 = null;
                    str = null;
                }
                aVar2.bt(l.this.a(z, str, bundle2));
                AppMethodBeat.o(121333);
            }
        });
        AppMethodBeat.o(121336);
    }

    static class a implements com.tencent.mm.ipcinvoker.b<a.C0577a, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(a.C0577a aVar, final d<Bundle> dVar) {
            AppMethodBeat.i(121335);
            a.C0577a aVar2 = aVar;
            final Bundle bundle = new Bundle();
            View Yj = e.bBI().Yj(aVar2.id);
            if (!(Yj instanceof h)) {
                Log.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "drawCanvas failed, view is not a instance of DynamicPageAccessible.(%s)", aVar2.id);
                bundle.putBoolean("ret", false);
                bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
                dVar.bn(bundle);
                AppMethodBeat.o(121335);
                return;
            }
            ((h) Yj).b(aVar2.height, new t() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.d.l.a.AnonymousClass1 */

                @Override // com.tencent.mm.modelappbrand.t
                public final void b(boolean z, String str, Bundle bundle) {
                    AppMethodBeat.i(121334);
                    bundle.putBoolean("ret", z);
                    bundle.putString("reason", str);
                    bundle.putBundle("data", bundle);
                    dVar.bn(bundle);
                    AppMethodBeat.o(121334);
                }
            });
            AppMethodBeat.o(121335);
        }
    }
}
