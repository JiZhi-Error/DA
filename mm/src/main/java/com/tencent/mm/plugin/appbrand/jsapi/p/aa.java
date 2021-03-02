package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.df;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.tabbar.e;
import com.tencent.mm.plugin.appbrand.widget.tabbar.h;
import org.json.JSONObject;

public class aa extends d<k> {
    private static final int CTRL_INDEX = 238;
    private static final String NAME = "setNavigationBarRightButton";

    public aa() {
        AppMethodBeat.i(229905);
        c.aem(NAME);
        AppMethodBeat.o(229905);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        final ac currentPageView;
        boolean z = false;
        AppMethodBeat.i(147214);
        k kVar2 = kVar;
        if (kVar2 instanceof ac) {
            currentPageView = (ac) kVar2;
        } else {
            currentPageView = ((s) kVar2).getCurrentPageView();
        }
        s j2 = df.j(kVar2);
        boolean optBoolean = jSONObject.optBoolean(MessengerShareContentUtility.SHARE_BUTTON_HIDE, false);
        if (currentPageView == null) {
            kVar2.i(i2, h("fail:page don't exist", null));
            AppMethodBeat.o(147214);
        } else if (j2 == null) {
            kVar2.i(i2, h("fail:internal error invalid js component", null));
            AppMethodBeat.o(147214);
        } else {
            if (!optBoolean) {
                z = true;
            }
            currentPageView.bV(z);
            if (optBoolean && bIj()) {
                String optString = jSONObject.optString("iconPath");
                if (!TextUtils.isEmpty(optString)) {
                    h hVar = new h(optString, new com.tencent.mm.plugin.appbrand.widget.tabbar.c(), j2);
                    hVar.a(new e() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.p.aa.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.widget.tabbar.e
                        public final void a(Bitmap bitmap, com.tencent.mm.plugin.appbrand.widget.tabbar.d dVar) {
                            AppMethodBeat.i(147213);
                            super.a(bitmap, dVar);
                            if (currentPageView.isRunning()) {
                                currentPageView.bRi().a(bitmap, new View.OnClickListener() {
                                    /* class com.tencent.mm.plugin.appbrand.jsapi.p.aa.AnonymousClass1.AnonymousClass1 */

                                    public final void onClick(View view) {
                                        AppMethodBeat.i(147212);
                                        b bVar = new b();
                                        bVar.bm(view);
                                        a.b("com/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigationBarRightButton$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                        com.tencent.mm.plugin.appbrand.page.c.d.h(currentPageView);
                                        a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigationBarRightButton$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(147212);
                                    }
                                });
                            }
                            AppMethodBeat.o(147213);
                        }
                    });
                    hVar.cdf();
                }
            }
            kVar2.i(i2, h("ok", null));
            AppMethodBeat.o(147214);
        }
    }

    /* access modifiers changed from: protected */
    public boolean bIj() {
        return true;
    }
}
