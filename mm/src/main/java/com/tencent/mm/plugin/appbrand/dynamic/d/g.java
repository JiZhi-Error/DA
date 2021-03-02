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
import com.tencent.mm.plugin.appbrand.jsapi.bp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.smtt.sdk.TbsListener;
import org.json.JSONObject;

public final class g extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {
    public g() {
        super(bp.NAME, TbsListener.ErrorCode.TEST_THROWABLE_ISNOT_NULL);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.a.a
    public final void a(com.tencent.mm.aa.c.a aVar, JSONObject jSONObject, final b.a<JSONObject> aVar2) {
        AppMethodBeat.i(121318);
        ad.b ayQ = aVar.ayQ();
        a aVar3 = new a((byte) 0);
        aVar3.id = ayQ.getString("__page_view_id", "");
        aVar3.ebd = jSONObject.optString("phoneNumber", "");
        XIPCInvoker.a(ayQ.getString("__process_name", MMApplicationContext.getProcessName()), aVar3, b.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.d.g.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                Bundle bundle2;
                String str;
                AppMethodBeat.i(121313);
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
                aVar2.bt(g.this.a(z, str, bundle2));
                AppMethodBeat.o(121313);
            }
        });
        AppMethodBeat.o(121318);
    }

    static class b implements com.tencent.mm.ipcinvoker.b<a, Bundle> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(a aVar, final d<Bundle> dVar) {
            AppMethodBeat.i(121317);
            a aVar2 = aVar;
            final Bundle bundle = new Bundle();
            View Yj = e.bBI().Yj(aVar2.id);
            if (!(Yj instanceof h)) {
                Log.i("MicroMsg.IPCInvoke_RequestMakePhoneCall", "makePhoneCall failed, view is not a instance of DynamicPageAccessible.(%s)", aVar2.id);
                bundle.putBoolean("ret", false);
                bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
                dVar.bn(bundle);
                AppMethodBeat.o(121317);
                return;
            }
            ((h) Yj).b(aVar2.ebd, new t() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.d.g.b.AnonymousClass1 */

                @Override // com.tencent.mm.modelappbrand.t
                public final void b(boolean z, String str, Bundle bundle) {
                    AppMethodBeat.i(121316);
                    bundle.putBoolean("ret", z);
                    bundle.putString("reason", str);
                    bundle.putBundle("data", bundle);
                    dVar.bn(bundle);
                    AppMethodBeat.o(121316);
                }
            });
            AppMethodBeat.o(121317);
        }
    }

    static class a implements f {
        String ebd;
        String id;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.ipcinvoker.extension.f
        public final void e(Parcel parcel) {
            AppMethodBeat.i(121314);
            parcel.writeString(this.id);
            parcel.writeString(this.ebd);
            AppMethodBeat.o(121314);
        }

        @Override // com.tencent.mm.ipcinvoker.extension.f
        public final void readFromParcel(Parcel parcel) {
            AppMethodBeat.i(121315);
            this.id = parcel.readString();
            this.ebd = parcel.readString();
            AppMethodBeat.o(121315);
        }
    }
}
