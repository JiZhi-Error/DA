package com.tencent.mm.plugin.appbrand.jsapi.af;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.av;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.widget.actionbar.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g extends b<ag> {
    public static final int CTRL_INDEX = 298;
    public static final String NAME = "insertHTMLWebView";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.h, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final /* synthetic */ View a(ag agVar, JSONObject jSONObject) {
        AppMethodBeat.i(47017);
        final ag agVar2 = agVar;
        if (agVar2.bRM() != null) {
            AppMethodBeat.o(47017);
            return null;
        }
        agVar2.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.af.g.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(47011);
                f fVar = (f) agVar2.S(f.class);
                if (fVar != null) {
                    fVar.il(true);
                    fVar.ij(false);
                } else if (agVar2.kAU && !(agVar2 instanceof d)) {
                    fVar.il(true);
                }
                if (!(agVar2 instanceof d)) {
                    agVar2.bRu();
                    agVar2.bRi().a(new a() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.af.g.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.a
                        public final void bLE() {
                            AppMethodBeat.i(47010);
                            a bRM = agVar2.bRM();
                            if (bRM != null) {
                                bRM.iGY.getView().scrollTo(bRM.iGY.getWebScrollX(), 0);
                            }
                            AppMethodBeat.o(47010);
                        }
                    });
                }
                AppMethodBeat.o(47011);
            }
        });
        final a aVar = new a(agVar2.getContext(), agVar2.getRuntime(), agVar2);
        aVar.setId(R.id.pq);
        aVar.setBackgroundColor(a(agVar2, jSONObject));
        agVar2.nnC.lxI.add(new i.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.af.g.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.a
            public final boolean onBackPressed() {
                AppMethodBeat.i(47012);
                a aVar = aVar;
                if (aVar.mDestroyed) {
                    AppMethodBeat.o(47012);
                    return false;
                } else if (aVar.getWebView().canGoBack()) {
                    aVar.getExitReporter().a(aVar.lBN, true);
                    aVar.getWebView().goBack();
                    aVar.mGS = true;
                    AppMethodBeat.o(47012);
                    return true;
                } else {
                    aVar.getExitReporter().a(aVar.lBN, false);
                    AppMethodBeat.o(47012);
                    return false;
                }
            }
        });
        agVar2.a(new i.d() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.af.g.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
            public final void onForeground() {
                AppMethodBeat.i(47013);
                aVar.getWebView().onResume();
                g.l(aVar);
                AppMethodBeat.o(47013);
            }
        });
        agVar2.a(new i.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.af.g.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
            public final void onBackground() {
                AppMethodBeat.i(47014);
                aVar.getWebView().onPause();
                AppMethodBeat.o(47014);
            }
        });
        AppMethodBeat.o(47017);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.h, int, android.view.View, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final /* synthetic */ void a(ag agVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(47016);
        ag agVar2 = agVar;
        ((a) view).setViewId(i2);
        Log.i("MicroMsg.AppBrand.JsApiInsertHTMLWebView", "onInsertView appId[%s] viewId[%d] viewHash[%d]", agVar2.getAppId(), Integer.valueOf(i2), Integer.valueOf(view.hashCode()));
        com.tencent.mm.ipcinvoker.i.Fq(ToolsProcessIPCService.dkO);
        l((a) view);
        if (agVar2 instanceof d) {
            a aVar = (a) view;
            String optString = jSONObject.optString("src");
            if (!(aVar.iGY == null || optString == null)) {
                aVar.mGP.setCurrentUrl(optString);
                aVar.iGY.loadUrl(optString);
            }
        }
        av.a(agVar2, (a) view);
        AppMethodBeat.o(47016);
    }

    private static int a(ag agVar, JSONObject jSONObject) {
        AppMethodBeat.i(184724);
        try {
            if (jSONObject.has("backgroundColor")) {
                int afE = com.tencent.mm.plugin.appbrand.ac.g.afE(jSONObject.getString("backgroundColor"));
                AppMethodBeat.o(184724);
                return afE;
            }
        } catch (Exception e2) {
        }
        if (agVar instanceof d) {
            AppMethodBeat.o(184724);
            return 0;
        } else if (agVar.getRuntime().getAppConfig().bzD()) {
            int n = android.support.v4.content.b.n(agVar.getContext(), R.color.w);
            AppMethodBeat.o(184724);
            return n;
        } else {
            AppMethodBeat.o(184724);
            return -1;
        }
    }

    static void l(a aVar) {
        AppMethodBeat.i(227046);
        try {
            bb bbVar = aVar.getPageView().nmX;
            if (bbVar != null) {
                bbVar.getWrapperView().setFocusable(false);
                bbVar.getWrapperView().setFocusableInTouchMode(false);
                bbVar.getContentView().setFocusable(false);
                bbVar.getContentView().setFocusableInTouchMode(false);
                if (bbVar.getWrapperView() instanceof ViewGroup) {
                    ((ViewGroup) bbVar.getWrapperView()).setDescendantFocusability(393216);
                }
            }
        } catch (Throwable th) {
        }
        try {
            View view = aVar.getWebView().getView();
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            aVar.requestFocus();
            AppMethodBeat.o(227046);
        } catch (Throwable th2) {
            AppMethodBeat.o(227046);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(47015);
        int i2 = jSONObject.getInt("htmlId");
        AppMethodBeat.o(47015);
        return i2;
    }
}
