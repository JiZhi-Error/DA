package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import org.json.JSONObject;

public final class n extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {
    public n() {
        super("showPickerView", 456);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.a.a
    public final void a(com.tencent.mm.aa.c.a aVar, JSONObject jSONObject, final b.a<JSONObject> aVar2) {
        AppMethodBeat.i(121344);
        ad.b ayQ = aVar.ayQ();
        String string = ayQ.getString("__page_view_id", "");
        Bundle bundle = new Bundle();
        bundle.putString("id", string);
        bundle.putString("data", jSONObject.toString());
        XIPCInvoker.a(ayQ.getString("__process_name", g.aAe().azG().mProcessName), bundle, a.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.d.n.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                Bundle bundle2;
                String str;
                AppMethodBeat.i(121341);
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
                aVar2.bt(n.this.a(z, str, bundle2));
                AppMethodBeat.o(121341);
            }
        });
        AppMethodBeat.o(121344);
    }

    static class a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, final d<Bundle> dVar) {
            AppMethodBeat.i(121343);
            Bundle bundle2 = bundle;
            final Bundle bundle3 = new Bundle();
            View Yj = e.bBI().Yj(bundle2.getString("id"));
            if (!(Yj instanceof h)) {
                com.tencent.mm.ipcinvoker.h.b.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "showPickerView failed, view is not a instance of DynamicPageAccessible.(%s)", bundle2.getString("id"));
                bundle3.putBoolean("ret", false);
                bundle3.putString("reason", "view is not a instance of DynamicPageAccessible");
                dVar.bn(bundle3);
                AppMethodBeat.o(121343);
                return;
            }
            ((h) Yj).a("selector", bundle2.getString("data"), new t() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.d.n.a.AnonymousClass1 */

                @Override // com.tencent.mm.modelappbrand.t
                public final void b(boolean z, String str, Bundle bundle) {
                    AppMethodBeat.i(121342);
                    bundle3.putBoolean("ret", z);
                    bundle3.putString("reason", str);
                    bundle3.putBundle("data", bundle);
                    dVar.bn(bundle3);
                    AppMethodBeat.o(121342);
                }
            });
            AppMethodBeat.o(121343);
        }
    }
}
