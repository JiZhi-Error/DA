package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.extension.f;
import com.tencent.mm.model.ad;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.smtt.sdk.TbsListener;
import org.json.JSONObject;

public final class i extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {
    public i() {
        super("openApp", TbsListener.ErrorCode.TEST_THROWABLE_IS_NULL);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.a.a
    public final void a(com.tencent.mm.aa.c.a aVar, JSONObject jSONObject, final b.a<JSONObject> aVar2) {
        AppMethodBeat.i(121330);
        ad.b ayQ = aVar.ayQ();
        b bVar = new b();
        bVar.id = ayQ.getString("__page_view_id", "");
        bVar.url = jSONObject.optString("url", "");
        XIPCInvoker.a(ayQ.getString("__process_name", MMApplicationContext.getProcessName()), bVar, a.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.d.i.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                Bundle bundle2;
                String str;
                AppMethodBeat.i(121325);
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
                aVar2.bt(i.this.a(z, str, bundle2));
                AppMethodBeat.o(121325);
            }
        });
        AppMethodBeat.o(121330);
    }

    static class a implements com.tencent.mm.ipcinvoker.b<b, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(b bVar, final d<Bundle> dVar) {
            AppMethodBeat.i(121327);
            b bVar2 = bVar;
            final Bundle bundle = new Bundle();
            View Yj = e.bBI().Yj(bVar2.id);
            if (!(Yj instanceof h)) {
                Log.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "openApp failed, view is not a instance of DynamicPageAccessible.(%s)", bVar2.id);
                bundle.putBoolean("ret", false);
                bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
                dVar.bn(bundle);
                AppMethodBeat.o(121327);
                return;
            }
            ((h) Yj).a(bVar2.url, new t() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.d.i.a.AnonymousClass1 */

                @Override // com.tencent.mm.modelappbrand.t
                public final void b(boolean z, String str, Bundle bundle) {
                    AppMethodBeat.i(121326);
                    bundle.putBoolean("ret", z);
                    bundle.putString("reason", str);
                    bundle.putBundle("data", bundle);
                    dVar.bn(bundle);
                    AppMethodBeat.o(121326);
                }
            });
            AppMethodBeat.o(121327);
        }
    }

    public static class b implements f {
        String id;
        String url;

        @Override // com.tencent.mm.ipcinvoker.extension.f
        public final void e(Parcel parcel) {
            AppMethodBeat.i(121328);
            parcel.writeString(this.id);
            parcel.writeString(this.url);
            AppMethodBeat.o(121328);
        }

        @Override // com.tencent.mm.ipcinvoker.extension.f
        public final void readFromParcel(Parcel parcel) {
            AppMethodBeat.i(121329);
            this.id = parcel.readString();
            this.url = parcel.readString();
            AppMethodBeat.o(121329);
        }
    }
}
