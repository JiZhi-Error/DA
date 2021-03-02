package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class q extends a<s> {
    public static final int CTRL_INDEX = 902;
    public static final String NAME = "openMapApp";
    final r lXi = new r();
    Map<String, String> lXj;
    protected LocationInfo lXk = new LocationInfo((byte) 0);
    protected LocationInfo lXl = new LocationInfo((byte) 0);
    protected d lXm;
    double latitude = 0.0d;
    double longitude = 0.0d;

    public q() {
        AppMethodBeat.i(226853);
        AppMethodBeat.o(226853);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.a
    public final /* synthetic */ void d(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(226854);
        final s sVar2 = sVar;
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiOpenMapApp", "data is null");
            sVar2.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(226854);
            return;
        }
        Log.i("MicroMsg.JsApiOpenMapApp", "data:%s", jSONObject);
        if (!q(sVar2)) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("errCode", -2);
            sVar2.i(i2, n("fail:system permission denied", hashMap));
            AppMethodBeat.o(226854);
            return;
        }
        try {
            this.latitude = jSONObject.getDouble("latitude");
            this.longitude = jSONObject.getDouble("longitude");
            String string = jSONObject.getString("destination");
            this.lXk.yFu = this.latitude;
            this.lXk.yFv = this.longitude;
            this.lXk.yFx = string;
            this.lXk.yFw = 15;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.JsApiOpenMapApp", e2, "", new Object[0]);
        }
        LocationInfo locationInfo = this.lXl;
        LocationInfo locationInfo2 = this.lXk;
        String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(MMApplicationContext.getDefaultPreference(), sVar2.getContext());
        Log.d("MicroMsg.JsApiOpenMapApp", " initLanguage ".concat(String.valueOf(loadApplicationLanguage)));
        if (loadApplicationLanguage.equals(LocaleUtil.LANGUAGE_DEFAULT)) {
            LocaleUtil.updateApplicationResourceLocale(sVar2.getContext(), Locale.ENGLISH);
            loadApplicationLanguage = LocaleUtil.ENGLISH;
        } else {
            LocaleUtil.updateApplicationResourceLocale(sVar2.getContext(), LocaleUtil.transLanguageToLocale(loadApplicationLanguage));
        }
        locationInfo2.yFy = loadApplicationLanguage;
        locationInfo.yFy = loadApplicationLanguage;
        if (this.lXm == null) {
            this.lXm = new d(sVar2.getContext());
        }
        this.lXi.W(sVar2.getRuntime());
        Bundle bundle = new Bundle();
        a aVar = (a) sVar2.M(a.class);
        if (aVar != null) {
            aVar.a("gcj02", new a.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.i.q.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.utils.b.a.b
                public final void a(int i2, String str, a.C0814a aVar) {
                    AppMethodBeat.i(226849);
                    Log.i("MicroMsg.JsApiOpenMapApp", "errCode:%d, errStr:%s, location:%s", Integer.valueOf(i2), str, aVar);
                    q.this.lXi.bGG();
                    if (i2 == 0) {
                        q.this.lXl.yFu = aVar.latitude;
                        q.this.lXl.yFv = aVar.longitude;
                        q.this.lXl.yFw = 15;
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.i.q.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(226848);
                                q.a(q.this, sVar2, q.this.latitude, q.this.longitude);
                                AppMethodBeat.o(226848);
                            }
                        });
                        sVar2.i(i2, q.this.h("ok", null));
                        AppMethodBeat.o(226849);
                        return;
                    }
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("errCode", Integer.valueOf(i2));
                    sVar2.i(i2, q.this.n("fail:".concat(String.valueOf(str)), hashMap));
                    AppMethodBeat.o(226849);
                }
            }, bundle);
        }
        AppMethodBeat.o(226854);
    }

    static /* synthetic */ void a(q qVar, final s sVar, final double d2, final double d3) {
        AppMethodBeat.i(226855);
        final e eVar = new e(sVar.getContext(), 1, true);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.i.q.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(226850);
                q qVar = q.this;
                Activity ay = sVar.ay(Activity.class);
                double d2 = d2;
                double d3 = d3;
                ArrayList arrayList = new ArrayList();
                arrayList.add("com.tencent.map");
                arrayList.add("com.google.android.apps.maps");
                arrayList.add("com.baidu.BaiduMap");
                arrayList.add("com.autonavi.minimap");
                arrayList.add("com.sogou.map.android.maps");
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", Double.valueOf(d2), Double.valueOf(d3))));
                PackageManager packageManager = ay.getPackageManager();
                HashMap hashMap = new HashMap();
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 65536)) {
                    if (arrayList.contains(resolveInfo.activityInfo.packageName)) {
                        hashMap.put(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.loadLabel(ay.getPackageManager()).toString());
                    }
                }
                qVar.lXj = hashMap;
                boolean z = !ChannelUtil.isGPVersion();
                if (!z && q.a(q.this)) {
                    z = true;
                }
                if (z) {
                    mVar.aS(2, R.string.hmx, 0);
                }
                int i2 = 3;
                for (Map.Entry<String, String> entry : q.this.lXj.entrySet()) {
                    if (!entry.getKey().equals("com.tencent.map")) {
                        mVar.b(i2, entry.getValue(), 0);
                    }
                    i2++;
                }
                AppMethodBeat.o(226850);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.i.q.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(226851);
                switch (menuItem.getItemId()) {
                    case 2:
                        Log.i("MicroMsg.JsApiOpenMapApp", "click tencent map: %s", Boolean.valueOf(q.this.lXj.containsKey("com.tencent.map")));
                        if (!q.a(q.this)) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", "http://mapdownload.map.qq.com/?key=wx&referer=wx1&channel=00008");
                            c.b(sVar.ay(Activity.class), "webview", ".ui.tools.WebViewUI", intent);
                            break;
                        } else {
                            q.this.lXm.a(q.this.lXk, q.this.lXl, "com.tencent.map", false);
                            break;
                        }
                    default:
                        if (q.this.lXj != null) {
                            Iterator<Map.Entry<String, String>> it = q.this.lXj.entrySet().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                } else {
                                    Map.Entry<String, String> next = it.next();
                                    if (next.getValue().equals(menuItem.getTitle())) {
                                        q.this.lXm.a(q.this.lXk, q.this.lXl, next.getKey(), false);
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                }
                eVar.bMo();
                AppMethodBeat.o(226851);
            }
        };
        View inflate = LayoutInflater.from(sVar.getContext()).inflate(R.layout.ee, (ViewGroup) null, false);
        ((ImageView) inflate.findViewById(R.id.b4f)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.i.q.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(226852);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiOpenMapApp$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                eVar.bMo();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiOpenMapApp$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(226852);
            }
        });
        ((TextView) inflate.findViewById(R.id.eqy)).setText(sVar.ay(Activity.class).getString(R.string.o3, new Object[]{qVar.lXk.yFx}));
        eVar.V(inflate, false);
        eVar.Dm(true);
        eVar.dGm();
        AppMethodBeat.o(226855);
    }

    static /* synthetic */ boolean a(q qVar) {
        AppMethodBeat.i(226856);
        boolean containsKey = qVar.lXj.containsKey("com.tencent.map");
        Log.i("MicroMsg.JsApiOpenMapApp", "install tencent map: %s.", Boolean.valueOf(containsKey));
        AppMethodBeat.o(226856);
        return containsKey;
    }
}
