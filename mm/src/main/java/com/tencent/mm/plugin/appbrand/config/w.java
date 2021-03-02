package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.protocal.protobuf.fcv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.e;
import java.util.List;

public final class w implements q {
    @Override // com.tencent.mm.plugin.appbrand.service.q
    public final WxaAttributes Xk(String str) {
        AppMethodBeat.i(44876);
        WxaAttributes d2 = n.buC().d(str, new String[0]);
        AppMethodBeat.o(44876);
        return d2;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.q
    public final WxaAttributes Xl(String str) {
        AppMethodBeat.i(44877);
        WxaAttributes e2 = n.buC().e(str, new String[0]);
        AppMethodBeat.o(44877);
        return e2;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.q
    public final String Xm(String str) {
        AppMethodBeat.i(226472);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(226472);
            return "";
        }
        String Xw = y.Xw(str);
        AppMethodBeat.o(226472);
        return Xw;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.q
    public final void a(String str, final q.a aVar) {
        AppMethodBeat.i(44878);
        aa.a(str, false, (aa.b<WxaAttributes>) new aa.b<WxaAttributes>() {
            /* class com.tencent.mm.plugin.appbrand.config.w.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.config.aa$b$a, java.lang.Object] */
            @Override // com.tencent.mm.plugin.appbrand.config.aa.b
            public final /* synthetic */ void a(aa.b.a aVar, WxaAttributes wxaAttributes) {
                AppMethodBeat.i(226467);
                WxaAttributes wxaAttributes2 = wxaAttributes;
                if (aVar != null) {
                    aVar.b(wxaAttributes2);
                }
                AppMethodBeat.o(226467);
            }
        });
        AppMethodBeat.o(44878);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.q
    public final void b(final String str, final q.a aVar) {
        AppMethodBeat.i(226473);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.config.w.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(226468);
                Pair<WxaAttributes, c.a<fcv>> a2 = aa.a(str, false, null, null);
                if (aVar != null) {
                    aVar.b((WxaAttributes) a2.first);
                }
                AppMethodBeat.o(226468);
            }
        });
        AppMethodBeat.o(226473);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.q
    public final e<WxaAttributes> Xn(final String str) {
        AppMethodBeat.i(44879);
        f b2 = g.ey(str).b(new a<WxaAttributes, String>() {
            /* class com.tencent.mm.plugin.appbrand.config.w.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ WxaAttributes call(String str) {
                AppMethodBeat.i(226470);
                final b hdH = com.tencent.mm.vending.g.g.hdH();
                w.this.a(str, new q.a() {
                    /* class com.tencent.mm.plugin.appbrand.config.w.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.service.q.a
                    public final void b(WxaAttributes wxaAttributes) {
                        AppMethodBeat.i(226469);
                        hdH.G(wxaAttributes);
                        AppMethodBeat.o(226469);
                    }
                });
                AppMethodBeat.o(226470);
                return null;
            }
        });
        AppMethodBeat.o(44879);
        return b2;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.q
    public final void c(String str, final q.a aVar) {
        AppMethodBeat.i(44880);
        aa.a(str, true, (aa.b<WxaAttributes>) new aa.b<WxaAttributes>() {
            /* class com.tencent.mm.plugin.appbrand.config.w.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.config.aa$b$a, java.lang.Object] */
            @Override // com.tencent.mm.plugin.appbrand.config.aa.b
            public final /* synthetic */ void a(aa.b.a aVar, WxaAttributes wxaAttributes) {
                AppMethodBeat.i(226471);
                WxaAttributes wxaAttributes2 = wxaAttributes;
                if (aVar != null) {
                    aVar.b(wxaAttributes2);
                }
                AppMethodBeat.o(226471);
            }
        });
        AppMethodBeat.o(44880);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.q
    public final void bq(List<String> list) {
        AppMethodBeat.i(44881);
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(44881);
            return;
        }
        Log.i("MicroMsg.AppBrand.WxaAttrExportService", "batchSync list %s", Util.listToString(list, ", "));
        aa.a(list, o.a.WXA_CUSTOMER_SERVICE, (aa.d) null);
        AppMethodBeat.o(44881);
    }
}
