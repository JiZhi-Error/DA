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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import org.json.JSONObject;

public final class h extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {
    public h() {
        super("onTapCallback", TbsListener.ErrorCode.TEST_THROWABLE_ISNOT_NULL);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.a.a
    public final void a(com.tencent.mm.aa.c.a aVar, JSONObject jSONObject, final b.a<JSONObject> aVar2) {
        AppMethodBeat.i(121324);
        ad.b ayQ = aVar.ayQ();
        b bVar = new b();
        bVar.id = ayQ.getString("__page_view_id", "");
        bVar.edD = jSONObject.optString("eventId", "");
        bVar.lny = jSONObject.optBoolean("hasHandler");
        bVar.lnz = jSONObject.optBoolean(ShareConstants.RES_PATH);
        XIPCInvoker.a(ayQ.getString("__process_name", MMApplicationContext.getProcessName()), bVar, a.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.d.h.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                Bundle bundle2;
                String str;
                AppMethodBeat.i(121319);
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
                aVar2.bt(h.this.a(z, str, bundle2));
                AppMethodBeat.o(121319);
            }
        });
        AppMethodBeat.o(121324);
    }

    static class a implements com.tencent.mm.ipcinvoker.b<b, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(b bVar, final d<Bundle> dVar) {
            AppMethodBeat.i(121321);
            b bVar2 = bVar;
            final Bundle bundle = new Bundle();
            View Yj = e.bBI().Yj(bVar2.id);
            if (!(Yj instanceof com.tencent.mm.plugin.appbrand.dynamic.h)) {
                Log.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "onTapCallback failed, view is not a instance of DynamicPageAccessible.(%s)", bVar2.id);
                bundle.putBoolean("ret", false);
                bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
                dVar.bn(bundle);
                AppMethodBeat.o(121321);
                return;
            }
            ((com.tencent.mm.plugin.appbrand.dynamic.h) Yj).a(bVar2.lny, bVar2.edD, bVar2.lnz, new t() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.d.h.a.AnonymousClass1 */

                @Override // com.tencent.mm.modelappbrand.t
                public final void b(boolean z, String str, Bundle bundle) {
                    AppMethodBeat.i(121320);
                    bundle.putBoolean("ret", z);
                    bundle.putString("reason", str);
                    bundle.putBundle("data", bundle);
                    dVar.bn(bundle);
                    AppMethodBeat.o(121320);
                }
            });
            AppMethodBeat.o(121321);
        }
    }

    public static class b implements f {
        String edD;
        String id;
        boolean lny;
        boolean lnz;

        @Override // com.tencent.mm.ipcinvoker.extension.f
        public final void e(Parcel parcel) {
            int i2;
            int i3 = 1;
            AppMethodBeat.i(121322);
            parcel.writeString(this.id);
            if (this.lny) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeString(this.edD);
            if (!this.lnz) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            AppMethodBeat.o(121322);
        }

        @Override // com.tencent.mm.ipcinvoker.extension.f
        public final void readFromParcel(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(121323);
            this.id = parcel.readString();
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.lny = z;
            this.edD = parcel.readString();
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.lnz = z2;
            AppMethodBeat.o(121323);
        }
    }
}
