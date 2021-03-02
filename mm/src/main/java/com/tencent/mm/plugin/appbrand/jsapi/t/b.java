package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.az;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends d<s> {
    private static final int CTRL_INDEX = 107;
    private static final String NAME = "showActionSheet";
    public static a mnM;

    public interface a {
        void xl(int i2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, final JSONObject jSONObject, final int i2) {
        final String str;
        AppMethodBeat.i(138258);
        final s sVar2 = sVar;
        final ac currentPageView = sVar2.getCurrentPageView();
        if (currentPageView == null) {
            Log.w("MicroMsg.JsApiShowActionSheet", "invoke JsApi JsApiShowActionSheet failed, current page view is null.");
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(138258);
            return;
        }
        p.h(jSONObject, "$this$optStringStrictly");
        p.h("alertText", "name");
        Object opt = jSONObject.opt("alertText");
        if (opt instanceof String) {
            str = (String) opt;
        } else {
            str = "";
        }
        Log.i("MicroMsg.JsApiShowActionSheet", "invoke, alertText: ".concat(String.valueOf(str)));
        String optString = jSONObject.optString("itemList");
        final ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(optString);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add((String) jSONArray.get(i3));
            }
            sVar2.P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.t.b.AnonymousClass1 */

                public final void run() {
                    final int cu;
                    AppMethodBeat.i(138257);
                    if (!sVar2.isRunning()) {
                        AppMethodBeat.o(138257);
                        return;
                    }
                    currentPageView.nqO.a(az.ACTION_SHEET);
                    Activity ay = sVar2.ay(Activity.class);
                    final e eVar = new e((Context) ay, 1, false);
                    if (!Util.isNullOrNil(str)) {
                        String str = str;
                        Log.d("MicroMsg.JsApiShowActionSheet", "addAlertHeaderView");
                        TextView textView = new TextView(ay);
                        textView.setHeight(com.tencent.mm.cb.a.aH(ay, R.dimen.cp));
                        textView.setGravity(17);
                        textView.setTextColor(ay.getResources().getColor(R.color.l4));
                        textView.setTextSize(0, (float) com.tencent.mm.cb.a.aH(ay, R.dimen.bd));
                        textView.setMaxLines(1);
                        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) ay, 18);
                        textView.setPadding(fromDPToPix, 0, fromDPToPix, 0);
                        textView.setText(str);
                        eVar.V(textView, false);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("newTipsList");
                    final HashMap hashMap = new HashMap();
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject != null) {
                                hashMap.put(Integer.valueOf(optJSONObject.optInt(FirebaseAnalytics.b.INDEX, -1)), Integer.valueOf(optJSONObject.optInt("type", -1)));
                            }
                        }
                    }
                    if (j.cDv.isDarkMode()) {
                        cu = g.cu(jSONObject.optString("itemColorDark", ""), ay.getResources().getColor(R.color.a2x));
                    } else {
                        cu = g.cu(jSONObject.optString("itemColor", ""), ay.getResources().getColor(R.color.a2x));
                    }
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.t.b.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(138254);
                            eVar.setFooterView(null);
                            mVar.clear();
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                if (hashMap.containsKey(Integer.valueOf(i2))) {
                                    mVar.a(i2, (CharSequence) arrayList.get(i2), true);
                                } else {
                                    mVar.a(i2, cu, (CharSequence) arrayList.get(i2));
                                }
                            }
                            AppMethodBeat.o(138254);
                        }
                    };
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.t.b.AnonymousClass1.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(138255);
                            HashMap hashMap = new HashMap();
                            hashMap.put("tapIndex", Integer.valueOf(menuItem.getItemId()));
                            if (hashMap.containsKey(Integer.valueOf(i2)) && b.mnM != null) {
                                b.mnM.xl(((Integer) hashMap.get(Integer.valueOf(i2))).intValue());
                            }
                            sVar2.i(i2, b.this.n("ok", hashMap));
                            AppMethodBeat.o(138255);
                        }
                    };
                    eVar.PGl = new e.b() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.t.b.AnonymousClass1.AnonymousClass3 */

                        @Override // com.tencent.mm.ui.widget.a.e.b
                        public final void onDismiss() {
                            AppMethodBeat.i(161222);
                            sVar2.i(i2, b.this.h("fail cancel", null));
                            AppMethodBeat.o(161222);
                        }
                    };
                    eVar.dGm();
                    AppMethodBeat.o(138257);
                }
            });
            AppMethodBeat.o(138258);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiShowActionSheet", e2.getMessage());
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(138258);
        }
    }
}
