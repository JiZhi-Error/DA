package com.tencent.mm.plugin.appbrand.permission;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.bw;
import com.tencent.mm.plugin.appbrand.jsapi.bx;
import com.tencent.mm.plugin.appbrand.jsapi.ca;
import com.tencent.mm.plugin.appbrand.jsapi.ce;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.plugin.appbrand.jsapi.cg;
import com.tencent.mm.plugin.appbrand.jsapi.ch;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f;
import com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.c;
import com.tencent.mm.plugin.appbrand.jsapi.pay.g;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.appbrand.jsapi.pay.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.plugin.appbrand.jsapi.share.e;
import com.tencent.mm.plugin.appbrand.jsapi.share.l;
import com.tencent.mm.plugin.appbrand.menu.o;
import com.tencent.mm.plugin.appbrand.menu.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.widget.f.a;
import com.tencent.mm.plugin.appbrand.widget.f.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;

final class b {
    private static final SparseIntArray nxh = new SparseIntArray() {
        /* class com.tencent.mm.plugin.appbrand.permission.b.AnonymousClass1 */

        public final int get(int i2) {
            AppMethodBeat.i(47991);
            int i3 = super.get(i2, R.string.mp);
            AppMethodBeat.o(47991);
            return i3;
        }
    };
    private static final Set<String> nxi = new HashSet();

    static {
        AppMethodBeat.i(47994);
        nxh.put(n.NAME.hashCode(), R.string.ml);
        nxh.put(q.NAME.hashCode(), R.string.ml);
        nxh.put(JsApiStartPlayVoice.NAME.hashCode(), R.string.mm);
        nxh.put(JsApiOperateMusicPlayer.NAME.hashCode(), R.string.mm);
        nxh.put(d.NAME.hashCode(), R.string.mn);
        nxh.put(o.a.NAME.hashCode(), R.string.mn);
        nxh.put(e.NAME.hashCode(), R.string.mn);
        nxh.put(l.NAME.hashCode(), R.string.mn);
        nxh.put(p.a.NAME.hashCode(), R.string.mn);
        nxh.put(f.NAME.hashCode(), R.string.mk);
        nxi.add(n.NAME);
        nxi.add(q.NAME);
        nxi.add(JsApiStartPlayVoice.NAME);
        nxi.add(JsApiOperateMusicPlayer.NAME);
        nxi.add(d.NAME);
        nxi.add(o.a.NAME);
        nxi.add(e.NAME);
        nxi.add(l.NAME);
        nxi.add(p.a.NAME);
        nxi.add(f.NAME);
        nxi.add(JsApiMakeVoIPCall.NAME);
        nxi.add(am.NAME);
        nxi.add("chooseContact");
        nxi.add(bv.NAME);
        nxi.add(ca.NAME);
        nxi.add(ce.NAME);
        nxi.add(cf.NAME);
        nxi.add(cg.NAME);
        nxi.add(ch.NAME);
        nxi.add(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.NAME);
        nxi.add(c.NAME);
        nxi.add(bw.NAME);
        nxi.add(bx.NAME);
        nxi.add(g.NAME);
        AppMethodBeat.o(47994);
    }

    static void n(final AppBrandRuntime appBrandRuntime, String str) {
        AppMethodBeat.i(47993);
        if (appBrandRuntime == null || Util.isNullOrNil(str)) {
            AppMethodBeat.o(47993);
            return;
        }
        String string = MMApplicationContext.getResources().getString(nxh.get(str.hashCode()));
        final String string2 = MMApplicationContext.getResources().getString(R.string.mo, string);
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.permission.b.AnonymousClass2 */

            public final void run() {
                t currentPage;
                ac currentPageView;
                AppMethodBeat.i(47992);
                w brh = appBrandRuntime.brh();
                if (!(brh == null || (currentPage = brh.getCurrentPage()) == null || (currentPageView = currentPage.getCurrentPageView()) == null)) {
                    com.tencent.mm.plugin.appbrand.widget.f.b bVar = currentPageView.nqT;
                    String str = string2;
                    if (bVar.nnq.isRunning()) {
                        b.a ccI = bVar.ccI();
                        bVar.ccJ();
                        if (bVar.oBy == null) {
                            bVar.oBy = new a(bVar.nnq.getContext());
                            bVar.oBy.c(ccI);
                        }
                        bVar.oBy.agi(str);
                    }
                }
                AppMethodBeat.o(47992);
            }
        });
        AppMethodBeat.o(47993);
    }
}
