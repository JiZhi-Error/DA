package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.support.v4.view.u;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import com.tencent.luggage.a.b;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.cx;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.plugin.appbrand.page.a.g;
import com.tencent.mm.plugin.appbrand.page.bq;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public class bn<PAGE extends c> extends a<PAGE> implements g {
    private static final String[] ntX = {"custom_event_GenerateFuncReady", "custom_event_tapAnyWhere", "custom_event_vdSync", "onAppRoute", "onAppRouteDone"};
    private boolean nmZ;
    private boolean ntS = false;
    private boolean ntT = false;
    private boolean ntU = false;
    private e ntV = null;
    private String ntW;
    private a ntY;
    private final bq.a ntZ = new bq.a() {
        /* class com.tencent.mm.plugin.appbrand.page.bn.AnonymousClass3 */
        private final String nue = "page-frame.html";
        private boolean nuf = false;
        private boolean nug = false;
        private boolean nuh = false;

        /* access modifiers changed from: package-private */
        public final String bSh() {
            AppMethodBeat.i(147462);
            String str = d.czw + String.format(Locale.US, "%s/%d/", bn.this.getAppId(), Integer.valueOf(bn.this.NP().OM().leE.pkgVersion));
            AppMethodBeat.o(147462);
            return str;
        }

        private String bSi() {
            AppMethodBeat.i(147463);
            String str = bSh() + "page-frame.html";
            AppMethodBeat.o(147463);
            return str;
        }

        private void bSj() {
            AppMethodBeat.i(147464);
            bn bnVar = bn.this;
            JSONObject jSONObject = new JSONObject();
            DisplayMetrics vDisplayMetrics = ((c) bnVar.NN()).kEb.getVDisplayMetrics();
            bnVar.c(jSONObject, "width", Integer.valueOf((int) Math.ceil((double) (((float) vDisplayMetrics.widthPixels) / vDisplayMetrics.density))));
            bnVar.c(jSONObject, "pixelRatio", Float.valueOf(vDisplayMetrics.density));
            ((c) bnVar.NN()).getJsRuntime().evaluateJavascript(String.format(Locale.US, ";if(typeof __deviceInfo__ ==='undefined'){ var __deviceInfo__ = %s; } else {Object.assign(__deviceInfo__, %s)};", jSONObject.toString(), jSONObject.toString()), null);
            if (!this.nuh) {
                if (bn.this.nnf) {
                    bn.this.eD("wxa_library/webview_pf.js", com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/webview_pf.js"));
                }
                this.nuh = true;
            }
            if (!this.nuf) {
                bn.this.eD("wxa_library/android.js", com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/android.js"));
                this.nuf = true;
            }
            if (!this.nug) {
                bn.this.eD("WAWebview.js", bn.this.bQt().adT("WAWebview.js"));
                this.nug = true;
            }
            AppMethodBeat.o(147464);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.bq.a
        public final void im(boolean z) {
            AppMethodBeat.i(147465);
            Log.i("Luggage.MPPageViewRenderer", "injectEnvFields preload=%b, hash=%d, viewEngine.hash=%d", Boolean.valueOf(z), Integer.valueOf(bn.this.hashCode()), Integer.valueOf(((bq) bn.this.nmX).hashCode()));
            if (z) {
                l.a((c) bn.this.NN(), ((c) bn.this.NN()).bte());
                bSj();
                AppMethodBeat.o(147465);
                return;
            }
            bn bnVar = bn.this;
            if (!TextUtils.isEmpty("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);")) {
                ((c) bnVar.NN()).getJsRuntime().evaluateJavascript("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);", null);
            } else if (((c) bnVar.NN()).kAU) {
                IllegalAccessError illegalAccessError = new IllegalAccessError("Cannot find object_polyfill.js");
                AppMethodBeat.o(147465);
                throw illegalAccessError;
            }
            ((bq) bn.this.nmX).evaluateJavascript(String.format(Locale.US, "history.pushState({},\"\",\"%s\");", bSi()), null);
            ((bq) bn.this.nmX).a(";(function(){return window.devicePixelRatio})();", new ValueCallback<String>() {
                /* class com.tencent.mm.plugin.appbrand.page.bn.AnonymousClass3.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(147460);
                    String str2 = str;
                    if (bn.this.isRunning()) {
                        if (!"undefined".equals(str2)) {
                            float f2 = Util.getFloat(str2, -1.0f);
                            if (f2 > 0.0f) {
                                Log.i("Luggage.MPPageViewRenderer", "[%s] update density with window.devicePixelRatio = %s", AnonymousClass3.this.bSh(), str2);
                                float pixelRatio = bn.this.nng.getPixelRatio();
                                if (f2 != pixelRatio) {
                                    Log.w("Luggage.MPPageViewRenderer", "[%s] mismatch devicePixelRatio!!! interface[%f], WebView[%f]", AnonymousClass3.this.bSh(), Float.valueOf(pixelRatio), Float.valueOf(f2));
                                }
                                com.tencent.mm.plugin.appbrand.ac.g.aU(f2);
                            }
                        }
                        Log.w("Luggage.MPPageViewRenderer", "[%s] invalid window.devicePixelRatio %s", AnonymousClass3.this.bSh(), str2);
                        AppMethodBeat.o(147460);
                        return;
                    }
                    AppMethodBeat.o(147460);
                }
            });
            String jSONObject = bn.this.Or().toString();
            String format = String.format(Locale.US, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);", jSONObject);
            long currentTimeMillis = System.currentTimeMillis();
            bn.this.ntY = new a((byte) 0);
            bn.this.ntY.kEm = jSONObject;
            bn.this.ntY.kEn = currentTimeMillis;
            Log.i("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate assignWxConfig start, hash=%d", Integer.valueOf(bn.this.hashCode()));
            ((bq) bn.this.nmX).a(bn.adX("assignWxConfig"), format, new ValueCallback<String>() {
                /* class com.tencent.mm.plugin.appbrand.page.bn.AnonymousClass3.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(147461);
                    Log.i("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate assignWxConfig end, hash=%d", Integer.valueOf(bn.this.hashCode()));
                    bn.this.ntY.kEo = System.currentTimeMillis();
                    AppMethodBeat.o(147461);
                }
            });
            bSj();
            if (bn.this.NP().OM().cyC && !bn.this.NP().OQ()) {
                bn.this.eD("WAVConsole.js", ((ICommLibReader) bn.a(bn.this, ICommLibReader.class)).UM("WAVConsole.js"));
            }
            if (AppBrandPerformanceManager.e(bn.this.NP())) {
                bn.this.eD("WAPerf.js", ((ICommLibReader) bn.b(bn.this, ICommLibReader.class)).UM("WAPerf.js"));
            }
            if (bn.this.NP().OQ()) {
                bn.this.eD("WARemoteDebug.js", ((ICommLibReader) bn.c(bn.this, ICommLibReader.class)).UM("WARemoteDebug.js"));
            }
            String format2 = String.format(Locale.US, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", cx.z("onWxConfigReady", "", 0));
            Log.i("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate onWxConfigReady start, hash=%d", Integer.valueOf(bn.this.hashCode()));
            final long currentTimeMillis2 = System.currentTimeMillis();
            ((bq) bn.this.nmX).a(bn.adX("onWxConfigReady"), format2, new ValueCallback<String>() {
                /* class com.tencent.mm.plugin.appbrand.page.bn.AnonymousClass3.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(229953);
                    boolean parseBoolean = Boolean.parseBoolean(str);
                    if (parseBoolean) {
                        bn.this.ntY.kEn = currentTimeMillis2;
                        bn.this.ntY.kEo = System.currentTimeMillis();
                    }
                    Log.i("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate onWxConfigReady end, applied=%b, hash=%d, reportWxConfigInjectEnd cost=%dms", Boolean.valueOf(parseBoolean), Integer.valueOf(bn.this.hashCode()), Long.valueOf(bn.this.ntY.kEo - bn.this.ntY.kEn));
                    bn.this.q(bn.this.ntY.kEm, bn.this.ntY.kEn, bn.this.ntY.kEo);
                    AppMethodBeat.o(229953);
                }
            });
            bn.this.ntU = false;
            bn.this.bQv();
            AppMethodBeat.o(147465);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.bq.a
        public final void in(boolean z) {
            String bSi;
            AppMethodBeat.i(147466);
            if (z) {
                bSi = d.czw + "preload/page-frame.html";
            } else {
                bSi = bSi();
            }
            String UM = ((c) bn.this.NN()).bqZ().UM("WAPageFrame.html");
            Log.i("Luggage.MPPageViewRenderer", "loadPageFrame url[%s] preload[%b]", bSi, Boolean.valueOf(z));
            if (!z) {
                com.tencent.mm.plugin.appbrand.keylogger.c.a(bn.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
                ((bq) bn.this.nmX).ag(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.page.bn.AnonymousClass3.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(229954);
                        com.tencent.mm.plugin.appbrand.keylogger.c.b(bn.this.getAppId(), KSProcessWeAppLaunch.stepInjectWAPageFrameHtml);
                        AppMethodBeat.o(229954);
                    }
                });
            }
            ((bq) bn.this.nmX).x(bSi, UM);
            AppMethodBeat.o(147466);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.bq.a
        public final void bSk() {
            AppMethodBeat.i(147467);
            ab.k((ac) bn.this.NN());
            bn bnVar = bn.this;
            bnVar.nmY = false;
            if (bnVar.nnj != null) {
                bnVar.nnj.bSc();
            }
            bnVar.dy(bnVar.nna);
            q qVar = new q();
            ac acVar = (ac) bn.this.NN();
            com.tencent.luggage.sdk.b.a.c.d NQ = ((c) bn.this.NN()).NQ();
            HashMap hashMap = new HashMap();
            hashMap.put("path", acVar.lBI);
            qVar.L(hashMap).b(NQ, acVar.getComponentId()).bEo();
            AppMethodBeat.o(147467);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.bq.a
        public final boolean bSl() {
            AppMethodBeat.i(147468);
            if (bn.this.nmX.R(e.class) != null) {
                AppMethodBeat.o(147468);
                return false;
            }
            boolean l = ab.l((ac) bn.this.NN());
            if (l) {
                bn.this.nnd.removeAll();
                this.nuf = false;
                this.nug = false;
                this.nuh = false;
            }
            AppMethodBeat.o(147468);
            return l;
        }

        @Override // com.tencent.mm.plugin.appbrand.page.bq.a
        public final String bSm() {
            AppMethodBeat.i(147469);
            String bSh = bSh();
            AppMethodBeat.o(147469);
            return bSh;
        }

        @Override // com.tencent.mm.plugin.appbrand.page.bq.a
        public final ac bSn() {
            AppMethodBeat.i(147470);
            ac acVar = (ac) bn.this.NN();
            AppMethodBeat.o(147470);
            return acVar;
        }
    };

    static /* synthetic */ b a(bn bnVar, Class cls) {
        AppMethodBeat.i(182994);
        b T = bnVar.T(cls);
        AppMethodBeat.o(182994);
        return T;
    }

    static /* synthetic */ URL adX(String str) {
        AppMethodBeat.i(229960);
        URL adW = adW(str);
        AppMethodBeat.o(229960);
        return adW;
    }

    static /* synthetic */ b b(bn bnVar, Class cls) {
        AppMethodBeat.i(147489);
        b T = bnVar.T(cls);
        AppMethodBeat.o(147489);
        return T;
    }

    static /* synthetic */ b c(bn bnVar, Class cls) {
        AppMethodBeat.i(147490);
        b T = bnVar.T(cls);
        AppMethodBeat.o(147490);
        return T;
    }

    protected bn(PAGE page) {
        super(page);
        AppMethodBeat.i(147471);
        AppMethodBeat.o(147471);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        String kEm;
        long kEn;
        long kEo;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = (com.tencent.mm.plugin.appbrand.page.a.e) r3.nmX.R(com.tencent.mm.plugin.appbrand.page.a.e.class);
     */
    @Override // com.tencent.luggage.sdk.b.a.a.AbstractC0178a, com.tencent.mm.plugin.appbrand.page.a, com.tencent.mm.plugin.appbrand.page.ae
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T S(java.lang.Class<T> r4) {
        /*
            r3 = this;
            r2 = 147473(0x24011, float:2.06654E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            java.lang.Class<com.tencent.mm.plugin.appbrand.page.a.e> r0 = com.tencent.mm.plugin.appbrand.page.a.e.class
            if (r0 != r4) goto L_0x0035
            com.tencent.mm.plugin.appbrand.page.a.e r0 = r3.ntV
            if (r0 != 0) goto L_0x002b
            com.tencent.mm.plugin.appbrand.page.bb r0 = r3.nmX
            java.lang.Class<com.tencent.mm.plugin.appbrand.page.a.e> r1 = com.tencent.mm.plugin.appbrand.page.a.e.class
            com.tencent.mm.plugin.appbrand.m.j r0 = r0.R(r1)
            com.tencent.mm.plugin.appbrand.page.a.e r0 = (com.tencent.mm.plugin.appbrand.page.a.e) r0
            if (r0 == 0) goto L_0x002b
            com.tencent.mm.plugin.appbrand.page.bn$1 r1 = new com.tencent.mm.plugin.appbrand.page.bn$1
            r1.<init>(r0)
            r3.ntV = r1
            com.tencent.mm.plugin.appbrand.page.a.e r0 = r3.ntV
            java.lang.Object r0 = r4.cast(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x002a:
            return r0
        L_0x002b:
            com.tencent.mm.plugin.appbrand.page.a.e r0 = r3.ntV
            java.lang.Object r0 = r4.cast(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x002a
        L_0x0035:
            java.lang.Object r0 = super.S(r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.page.bn.S(java.lang.Class):java.lang.Object");
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.c, com.tencent.mm.plugin.appbrand.page.a
    public final boolean b(String str, String str2, int i2) {
        AppMethodBeat.i(185225);
        if (!this.nmZ && str.startsWith("custom_event_")) {
            if (str.startsWith("custom_event_vdSync") || str.startsWith("custom_event_vdSyncBatch")) {
                if (((c) NN()).nqW) {
                    if (!this.ntS) {
                        com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepVdSync);
                        this.ntS = true;
                    }
                    if (this.ntT) {
                        com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
                        this.ntT = false;
                    }
                }
                Log.i("Luggage.MPPageViewRenderer", "dispatch critical vdSync appId[%s] url[%s] event[%s] content[%s] src[%d]", getAppId(), this.lBI, str, org.apache.commons.b.g.id(str2, 20), Integer.valueOf(i2));
            } else {
                Log.i("Luggage.MPPageViewRenderer", "dispatch critical appId[%s] url[%s] event[%s] size[%d] src[%d]", getAppId(), this.lBI, str, Integer.valueOf(Util.nullAsNil(str2).length()), Integer.valueOf(i2));
            }
        }
        AppMethodBeat.o(185225);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.c, com.tencent.mm.plugin.appbrand.page.a
    public final boolean y(String str, String str2) {
        AppMethodBeat.i(229955);
        if (org.apache.commons.b.a.contains(ntX, str)) {
            Log.i("Luggage.MPPageViewRenderer", "publish critical appId[%s] url[%s] event[%s]", getAppId(), this.lBI, str);
            if (NN() != null && ((c) NN()).nqW && "custom_event_GenerateFuncReady".equals(str)) {
                this.ntT = true;
                com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
                if (this.ntS) {
                    com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepGenerateFuncReadyRespond);
                    this.ntT = false;
                }
            }
        }
        AppMethodBeat.o(229955);
        return false;
    }

    private void L(String str, String str2, String str3) {
        AppMethodBeat.i(229956);
        String a2 = org.apache.commons.b.g.a(new String[]{str, str2, str3}, ":");
        if (TextUtils.isEmpty(a2)) {
            AppMethodBeat.o(229956);
            return;
        }
        this.ntW = a2;
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("appUrl", str2);
        hashMap.put("appStatus", str3);
        ((bq) this.nmX).setAppBrandInfo(hashMap);
        if (((bq) this.nmX).MO()) {
            ((bq) this.nmX).evaluateJavascript("document.title=\"" + r.afJ(a2) + "\"", null);
        }
        AppMethodBeat.o(229956);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.g
    public final void bRA() {
        AppMethodBeat.i(147475);
        ((c) NN()).bEb();
        ((bq) this.nmX).bRA();
        ((c) NN()).bEc();
        AppMethodBeat.o(147475);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a, com.tencent.mm.plugin.appbrand.page.ae
    public void Ng() {
        AppMethodBeat.i(147477);
        Log.i("Luggage.MPPageViewRenderer", "dispatchPageReady url[%s]", this.lBI);
        this.nmZ = true;
        super.Ng();
        this.nmW.invalidate();
        if (((c) NN()).nqW) {
            com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageReady);
            com.tencent.mm.plugin.appbrand.keylogger.c.b(getAppId(), KSProcessWeAppLaunch.stepPageInit);
        }
        AppMethodBeat.o(147477);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a, com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
    public void dispatchStart() {
        AppMethodBeat.i(147478);
        super.dispatchStart();
        ((bq) this.nmX).bSq();
        AppMethodBeat.o(147478);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a, com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
    public final void Nd() {
        AppMethodBeat.i(147479);
        Log.i("Luggage.MPPageViewRenderer", "dispatchForeground appId[%s] url[%s]", getAppId(), this.lBI);
        super.Nd();
        L(getAppId(), this.lBI, "VISIBLE");
        AppMethodBeat.o(147479);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a, com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
    public final void Ne() {
        AppMethodBeat.i(147480);
        super.Ne();
        L(getAppId(), this.lBI, "INVISIBLE");
        AppMethodBeat.o(147480);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a, com.tencent.mm.plugin.appbrand.page.ae
    public boolean dy(String str) {
        AppMethodBeat.i(147481);
        this.nmZ = false;
        this.ntS = false;
        this.ntT = false;
        ((bq) this.nmX).ag(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.bn.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(147459);
                final ViewGroup viewGroup = bn.this.nmW;
                if (u.aD(viewGroup)) {
                    ((c) bn.this.NN()).post(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.page.bn.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(147458);
                            if (!u.aD(viewGroup)) {
                                AppMethodBeat.o(147458);
                                return;
                            }
                            if (!u.az(viewGroup)) {
                                Log.d("Luggage.MPPageViewRenderer", "loadURL[page], PageView(%s) not laid out, forceLayout", bn.this.lBI);
                                viewGroup.forceLayout();
                                ViewParent parent = viewGroup.getParent();
                                do {
                                    ((View) parent).forceLayout();
                                    parent = parent.getParent();
                                } while (parent instanceof View);
                                if (parent != null) {
                                    parent.requestLayout();
                                }
                            }
                            AppMethodBeat.o(147458);
                        }
                    });
                }
                AppMethodBeat.o(147459);
            }
        });
        boolean dy = super.dy(str);
        L(getAppId(), this.lBI, "INITIAL");
        AppMethodBeat.o(147481);
        return dy;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.a
    public final void bQw() {
        AppMethodBeat.i(147482);
        super.bQw();
        com.tencent.mm.plugin.appbrand.page.web_renderingcache.a aVar = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a) ((c) NN()).M(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class);
        if (aVar != null) {
            String adZ = aVar.adZ(this.lBI);
            String aea = aVar.aea(this.lBI);
            if (!TextUtils.isEmpty(adZ)) {
                Log.i("Luggage.MPPageViewRenderer", "onPageScriptWillExecute get RenderingCache by url[%s], content.size[%d], webviewData.size[%d]", this.lBI, Integer.valueOf(Util.nullAsNil(adZ).length()), Integer.valueOf(Util.nullAsNil(aea).length()));
                com.tencent.mm.plugin.appbrand.jsapi.v.a.a(adZ, aea, (ac) NN());
            }
        }
        AppMethodBeat.o(147482);
    }

    @Override // com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
    public final void a(Map<String, Object> map, bx bxVar) {
        com.tencent.mm.plugin.appbrand.page.web_renderingcache.a aVar;
        AppMethodBeat.i(147483);
        super.a(map, bxVar);
        Objects.requireNonNull(NN());
        if (!(bx.NAVIGATE_BACK == bxVar || (aVar = (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a) ((c) NN()).M(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class)) == null)) {
            String aeb = aVar.aeb(this.lBI);
            if (!TextUtils.isEmpty(aeb)) {
                try {
                    map.put("initialRenderingCacheData", new JSONObject(aeb));
                } catch (Exception e2) {
                    Log.printErrStackTrace("Luggage.MPPageViewRenderer", e2, "onFillRouteInEventData when parsing initialRenderingCacheData", new Object[0]);
                }
            }
        }
        HashMap hashMap = new HashMap();
        map.put("qualityData", hashMap);
        hashMap.put("navId", String.format(Locale.ENGLISH, "%d_%d", Integer.valueOf(((c) NN()).getComponentId()), Long.valueOf(Util.nowMilliSecond())));
        hashMap.put("isWebviewPreload", Boolean.valueOf(((bq) this.nmX).bSr()));
        hashMap.put("isPreloadPageFrame", Boolean.valueOf(this.ntU));
        map.put("prerender", Boolean.valueOf(NP().OS()));
        AppMethodBeat.o(147483);
    }

    /* access modifiers changed from: protected */
    public bc ej(Context context) {
        AppMethodBeat.i(147485);
        aw awVar = new aw(context);
        AppMethodBeat.o(147485);
        return awVar;
    }

    private static URL adW(String str) {
        AppMethodBeat.i(229958);
        try {
            URL url = new URL("https", WeChatHosts.domainString(R.string.e2b), str);
            AppMethodBeat.o(229958);
            return url;
        } catch (MalformedURLException e2) {
            AppMethodBeat.o(229958);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.a
    public be bQu() {
        AppMethodBeat.i(147486);
        be bQu = super.bQu();
        AppMethodBeat.o(147486);
        return bQu;
    }

    /* access modifiers changed from: protected */
    public void q(String str, long j2, long j3) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a
    public void a(d.a aVar, boolean z, long j2, long j3, Object obj) {
        AppMethodBeat.i(229959);
        super.a(aVar, z, j2, j3, obj);
        if ("WAPageFrame.html".equals(aVar.scriptName) && !TextUtils.isEmpty(getAppId())) {
            com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", j2, j3);
        }
        if (!this.ntU && NN() != null && ((c) NN()).NP() != null && ads("checkIsAppSharedPageFrameExecutionFinished").adw(aVar.scriptName)) {
            this.ntU = true;
        }
        AppMethodBeat.o(229959);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.g
    public final boolean bSg() {
        AppMethodBeat.i(147476);
        if (((bq) this.nmX) == null || !((bq) this.nmX).bSg()) {
            AppMethodBeat.o(147476);
            return false;
        }
        AppMethodBeat.o(147476);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.g
    public final boolean bsX() {
        AppMethodBeat.i(229957);
        if (((bq) this.nmX) == null || !((bq) this.nmX).bsX()) {
            AppMethodBeat.o(229957);
            return false;
        }
        AppMethodBeat.o(229957);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a
    public final /* synthetic */ bb ee(Context context) {
        AppMethodBeat.i(147487);
        br brVar = new br(ej(context));
        brVar.a(this.ntZ);
        super.b(com.tencent.luggage.sdk.b.a.b.a.a.class, brVar);
        AppMethodBeat.o(147487);
        return brVar;
    }
}
