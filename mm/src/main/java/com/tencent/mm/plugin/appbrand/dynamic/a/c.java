package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.a;
import com.tencent.mm.plugin.appbrand.dynamic.b.d;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.b;
import com.tencent.mm.plugin.appbrand.dynamic.h.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import java.net.URLDecoder;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements View.OnAttachStateChangeListener, g, a.AbstractC0574a, MMUncaughtExceptionHandler.IOnUncaughtExceptionListener {
    private volatile e lmA;
    private volatile b lmH;
    private volatile e lmI;
    private String mToken;

    @Override // com.tencent.mm.modelappbrand.g
    public final void initialize() {
        AppMethodBeat.i(121224);
        if (!(this.mToken == null || this.mToken.length() == 0)) {
            shutdown();
        }
        this.mToken = "Token#" + System.nanoTime();
        MMUncaughtExceptionHandler.addOnUncaughtExceptionListener(this);
        ae.a(new d());
        AppMethodBeat.o(121224);
    }

    @Override // com.tencent.mm.modelappbrand.g
    public final void shutdown() {
        AppMethodBeat.i(121225);
        Map<Object, Set<View>> aXG = bBW().aXG();
        if (aXG == null || aXG.isEmpty()) {
            AppMethodBeat.o(121225);
            return;
        }
        for (Object obj : new LinkedHashSet(aXG.keySet())) {
            if (obj != null && (obj instanceof String)) {
                Lp((String) obj);
            }
        }
        AppMethodBeat.o(121225);
    }

    @Override // com.tencent.mm.modelappbrand.g
    public final View cU(Context context) {
        AppMethodBeat.i(121226);
        IPCDynamicPageView iPCDynamicPageView = new IPCDynamicPageView(context);
        AppMethodBeat.o(121226);
        return iPCDynamicPageView;
    }

    @Override // com.tencent.mm.modelappbrand.g
    public final String a(String str, View view, Bundle bundle, ab abVar) {
        String str2;
        AppMethodBeat.i(121227);
        if (!(view instanceof IPCDynamicPageView)) {
            AppMethodBeat.o(121227);
            return "";
        }
        com.tencent.mm.plugin.expansions.a.cMr();
        String Bs = n.Bs(System.nanoTime());
        com.tencent.mm.plugin.appbrand.collector.c.c("widget_launch", Bs, "on_bind_view", true);
        com.tencent.mm.plugin.appbrand.collector.c.cQ(Bs, "init_finish");
        IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
        String str3 = null;
        if (bundle != null) {
            String string = bundle.getString("app_id");
            str3 = bundle.getString("msg_id");
            bundle.putString("__session_id", str);
            bundle.putLong("__on_bind_nano_time", System.nanoTime());
            bundle.putString("__session_id", Bs);
            bundle.putParcelable("__cost_time_session", com.tencent.mm.plugin.appbrand.collector.c.WJ(Bs));
            str2 = string;
        } else {
            str2 = null;
        }
        String string2 = bundle.getString("wxa_unique_id");
        if (TextUtils.isEmpty(string2)) {
            string2 = WxaWidgetInitializer.da(str2, str3);
        }
        String string3 = bundle.getString("exec_process_name", SupportProcessIPCService.dkO);
        i.bBL().cZ(string2, string3);
        u.i("MicroMsg.DynamicPageService", "onBindView(%s)", string2);
        com.tencent.mm.plugin.appbrand.dynamic.e.bBI().c(string2, iPCDynamicPageView);
        String str4 = l.dN(bundle.getString("msg_path", "")).get("widgetData");
        if (!TextUtils.isEmpty(str4)) {
            try {
                JSONObject jSONObject = new JSONObject(URLDecoder.decode(str4));
                if (jSONObject.has("render_data") && jSONObject.getJSONObject("render_data").has("actions")) {
                    u.i("MicroMsg.DynamicPageService", "get render_data and begin predraw", new Object[0]);
                    JSONArray jSONArray = jSONObject.getJSONObject("render_data").getJSONArray("actions");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("actions", jSONArray);
                    jSONObject2.put("reserve", false);
                    String jSONObject3 = jSONObject2.toString();
                    jSONObject2.put("__invoke_jsapi_timestamp", System.currentTimeMillis());
                    b bVar = new b();
                    bVar.a(string3, string2, jSONObject2, null, null, com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bH(string2, bundle.getInt("draw_strategy")), jSONObject3);
                    com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bH(string2, bundle.getInt("draw_strategy")).a(bVar);
                    w wVar = (w) abVar.LA("WidgetPreDrawCallback");
                    if (wVar != null) {
                        wVar.aXT();
                    }
                    u.Ls(string2);
                }
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.DynamicPageService", e2, "", new Object[0]);
            }
        }
        iPCDynamicPageView.removeOnAttachStateChangeListener(this);
        iPCDynamicPageView.addOnAttachStateChangeListener(this);
        Assert.assertNotNull(string2);
        iPCDynamicPageView.lpP = System.currentTimeMillis();
        h aXU = abVar != null ? abVar.aXU() : null;
        if (iPCDynamicPageView.gIx != null && !string2.equals(iPCDynamicPageView.gIx)) {
            iPCDynamicPageView.cleanup();
        }
        if (aXU != null && (!string2.equals(iPCDynamicPageView.gIx) || !iPCDynamicPageView.gPl)) {
            aXU.L(iPCDynamicPageView, 0);
        }
        iPCDynamicPageView.gPl = false;
        u.i("MicroMsg.IPCDynamicPageView", "attach (%s)", string2);
        IPCDynamicPageView.llG.post(new Runnable(string2, bundle, abVar, str2) {
            /* class com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.AnonymousClass3 */
            final /* synthetic */ Bundle lly;
            final /* synthetic */ ab lpV;
            final /* synthetic */ String val$appId;
            final /* synthetic */ String val$id;

            {
                this.val$id = r2;
                this.lly = r3;
                this.lpV = r4;
                this.val$appId = r5;
            }

            public final void run() {
                AppMethodBeat.i(121521);
                if (IPCDynamicPageView.this.gIx != null && !this.val$id.equals(IPCDynamicPageView.this.gIx)) {
                    IPCDynamicPageView.this.detach();
                }
                IPCDynamicPageView.this.gIx = this.val$id;
                IPCDynamicPageView.this.lpQ.setTraceId(IPCDynamicPageView.this.gIx);
                IPCDynamicPageView.this.lpM = this.lly;
                IPCDynamicPageView.this.lpO = new ac(this.lpV);
                com.tencent.mm.plugin.appbrand.dynamic.a aVar = IPCDynamicPageView.this.lpN;
                String str = this.val$id;
                String str2 = this.val$appId;
                Bundle bundle = this.lly;
                aVar.gIx = str;
                String str3 = "Token#" + System.nanoTime();
                aVar.llv = str3;
                Bundle bundle2 = new Bundle();
                bundle2.putString("id", str);
                bundle2.putString("appId", str2);
                if (bundle != null) {
                    bundle2.putInt("scene", bundle.getInt("scene"));
                    bundle2.putInt("widgetType", bundle.getInt("widget_type"));
                    bundle2.putInt("serviceType", bundle.getInt("service_type"));
                    bundle2.putInt("wxaPkgType", bundle.getInt("msg_pkg_type"));
                    bundle2.putString("searchId", bundle.getString("search_id", ""));
                    bundle2.putInt("pkgVersion", bundle.getInt("pkg_version"));
                    bundle2.putString("preloadLaunchData", bundle.getString("preload_launch_data", ""));
                    bundle2.putString("preload_download_data", bundle.getString("preload_download_data", ""));
                    bundle2.putString("cache_key", bundle.getString("cache_key", ""));
                }
                bundle2.putString("view_process_name", com.tencent.mm.ipcinvoker.g.axZ());
                u.i("MicroMsg.DynamicIPCJsBridge", " attach %s， process %s", str, i.bBL().Yn(str));
                com.tencent.mm.ipcinvoker.h.a(i.bBL().Yn(str), bundle2, a.c.class, 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0135: INVOKE  
                      (wrap: java.lang.String : 0x012a: INVOKE  (r7v2 java.lang.String) = 
                      (wrap: com.tencent.mm.plugin.appbrand.dynamic.i : 0x0126: INVOKE  (r0v14 com.tencent.mm.plugin.appbrand.dynamic.i) =  type: STATIC call: com.tencent.mm.plugin.appbrand.dynamic.i.bBL():com.tencent.mm.plugin.appbrand.dynamic.i)
                      (r3v0 'str' java.lang.String)
                     type: VIRTUAL call: com.tencent.mm.plugin.appbrand.dynamic.i.Yn(java.lang.String):java.lang.String)
                      (r6v1 'bundle2' android.os.Bundle)
                      (wrap: java.lang.Class : 0x012e: CONST_CLASS   com.tencent.mm.plugin.appbrand.dynamic.a$c.class)
                      (wrap: com.tencent.mm.plugin.appbrand.dynamic.a$1 : 0x0132: CONSTRUCTOR  (r0v15 com.tencent.mm.plugin.appbrand.dynamic.a$1) = 
                      (r1v5 'aVar' com.tencent.mm.plugin.appbrand.dynamic.a)
                      (r2v2 'str3' java.lang.String)
                      (r3v0 'str' java.lang.String)
                      (r4v0 'str2' java.lang.String)
                      (r5v0 'bundle' android.os.Bundle)
                     call: com.tencent.mm.plugin.appbrand.dynamic.a.1.<init>(com.tencent.mm.plugin.appbrand.dynamic.a, java.lang.String, java.lang.String, java.lang.String, android.os.Bundle):void type: CONSTRUCTOR)
                     type: STATIC call: com.tencent.mm.ipcinvoker.h.a(java.lang.String, android.os.Parcelable, java.lang.Class, com.tencent.mm.ipcinvoker.d):boolean in method: com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.3.run():void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0132: CONSTRUCTOR  (r0v15 com.tencent.mm.plugin.appbrand.dynamic.a$1) = 
                      (r1v5 'aVar' com.tencent.mm.plugin.appbrand.dynamic.a)
                      (r2v2 'str3' java.lang.String)
                      (r3v0 'str' java.lang.String)
                      (r4v0 'str2' java.lang.String)
                      (r5v0 'bundle' android.os.Bundle)
                     call: com.tencent.mm.plugin.appbrand.dynamic.a.1.<init>(com.tencent.mm.plugin.appbrand.dynamic.a, java.lang.String, java.lang.String, java.lang.String, android.os.Bundle):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.3.run():void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 14 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.dynamic.a, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 20 more
                    */
                /*
                // Method dump skipped, instructions count: 321
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.AnonymousClass3.run():void");
            }
        });
        Log.v("MicroMsg.DynamicPageService", "onBindView(%s)", string2);
        com.tencent.mm.plugin.appbrand.dynamic.h.a bCk = com.tencent.mm.plugin.appbrand.dynamic.h.a.bCk();
        if (!(str == null || str.length() == 0)) {
            bCk.lpe.put(str, this);
        }
        com.tencent.mm.plugin.appbrand.dynamic.h.a.bCk().c(str, iPCDynamicPageView);
        bBW().d(str, iPCDynamicPageView);
        AppMethodBeat.o(121227);
        return string2;
    }

    @Override // com.tencent.mm.modelappbrand.g
    public final void a(String str, View view) {
        AppMethodBeat.i(121228);
        if (!(view instanceof IPCDynamicPageView)) {
            AppMethodBeat.o(121228);
            return;
        }
        IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
        Log.v("MicroMsg.DynamicPageService", "onUnBindView(%s)", iPCDynamicPageView.getExtId());
        iPCDynamicPageView.removeOnAttachStateChangeListener(this);
        bBW().e(str, iPCDynamicPageView);
        com.tencent.mm.plugin.appbrand.dynamic.h.a.bCk().b(str, iPCDynamicPageView);
        iPCDynamicPageView.detach();
        i.bBL().Yo(str);
        AppMethodBeat.o(121228);
    }

    @Override // com.tencent.mm.modelappbrand.g
    public final void cq(View view) {
        AppMethodBeat.i(121229);
        if (!(view instanceof IPCDynamicPageView)) {
            AppMethodBeat.o(121229);
            return;
        }
        ((IPCDynamicPageView) view).ws(2104);
        AppMethodBeat.o(121229);
    }

    @Override // com.tencent.mm.modelappbrand.g
    public final void Lp(String str) {
        AppMethodBeat.i(121230);
        com.tencent.mm.plugin.appbrand.dynamic.h.a.bCk().lpd.remove(str);
        com.tencent.mm.plugin.appbrand.dynamic.h.a bCk = com.tencent.mm.plugin.appbrand.dynamic.h.a.bCk();
        if (!(str == null || str.length() == 0)) {
            bCk.lpe.remove(str);
        }
        Set<View> ci = bBW().ci(str);
        if (ci == null || ci.isEmpty()) {
            AppMethodBeat.o(121230);
            return;
        }
        for (View view : ci) {
            if (view != null && (view instanceof IPCDynamicPageView)) {
                IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
                Log.v("MicroMsg.DynamicPageService", "onUnbindAllView, do unBindView(%s)", iPCDynamicPageView.getExtId());
                iPCDynamicPageView.removeOnAttachStateChangeListener(this);
                iPCDynamicPageView.detach();
            }
        }
        if (bBW().aXG().isEmpty()) {
            com.tencent.mm.ch.a.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.j.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(121461);
                    for (String str : i.bBL().bBM()) {
                        if (!com.tencent.mm.ipcinvoker.c.axW().Fo(str)) {
                            Log.i("MicroMsg.DynamicPkgUpdater", "has not Connected RemoteService, abort clearCache");
                            AppMethodBeat.o(121461);
                            return;
                        }
                        com.tencent.mm.ipcinvoker.h.a(str, null, b.class, null);
                    }
                    AppMethodBeat.o(121461);
                }
            });
        }
        i.bBL().Yo(str);
        AppMethodBeat.o(121230);
    }

    @Override // com.tencent.mm.modelappbrand.g
    public final p cr(View view) {
        if (view instanceof IPCDynamicPageView) {
            return (p) view;
        }
        return null;
    }

    private e bBW() {
        AppMethodBeat.i(121231);
        if (this.lmA == null) {
            synchronized (this) {
                try {
                    if (this.lmA == null) {
                        this.lmA = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121231);
                    throw th;
                }
            }
        }
        e eVar = this.lmA;
        AppMethodBeat.o(121231);
        return eVar;
    }

    @Override // com.tencent.mm.modelappbrand.g
    public final f aXH() {
        AppMethodBeat.i(121232);
        if (this.lmH == null) {
            synchronized (this) {
                try {
                    if (this.lmH == null) {
                        this.lmH = new b(bBW());
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121232);
                    throw th;
                }
            }
        }
        b bVar = this.lmH;
        AppMethodBeat.o(121232);
        return bVar;
    }

    @Override // com.tencent.mm.modelappbrand.g
    public final com.tencent.mm.modelappbrand.n aXI() {
        AppMethodBeat.i(121233);
        if (this.lmI == null) {
            synchronized (this) {
                try {
                    if (this.lmI == null) {
                        this.lmI = new e();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121233);
                    throw th;
                }
            }
        }
        e eVar = this.lmI;
        AppMethodBeat.o(121233);
        return eVar;
    }

    @Override // com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
    public final void uncaughtException(MMUncaughtExceptionHandler mMUncaughtExceptionHandler, String str, Throwable th) {
        AppMethodBeat.i(192517);
        Log.e("MicroMsg.DynamicPageService", "uncaughtException(%s)", android.util.Log.getStackTraceString(th));
        shutdown();
        AppMethodBeat.o(192517);
    }

    public final void onViewAttachedToWindow(View view) {
        AppMethodBeat.i(121235);
        if (view == null || !(view instanceof IPCDynamicPageView)) {
            AppMethodBeat.o(121235);
            return;
        }
        IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
        Log.d("MicroMsg.DynamicPageService", "onViewAttachedToWindow(%s)", iPCDynamicPageView.getExtId());
        iPCDynamicPageView.onResume();
        AppMethodBeat.o(121235);
    }

    public final void onViewDetachedFromWindow(View view) {
        AppMethodBeat.i(121236);
        if (view == null || !(view instanceof IPCDynamicPageView)) {
            AppMethodBeat.o(121236);
            return;
        }
        IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
        Log.d("MicroMsg.DynamicPageService", "onViewDetachedFromWindow(%s)", iPCDynamicPageView.getExtId());
        iPCDynamicPageView.onPause();
        AppMethodBeat.o(121236);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.h.a.AbstractC0574a
    public final void a(String str, IPCDynamicPageView iPCDynamicPageView) {
        AppMethodBeat.i(121237);
        Log.v("MicroMsg.DynamicPageService", "onOverLength(sessionId : %s, view : %s)", str, iPCDynamicPageView.getExtId());
        a(str, (View) iPCDynamicPageView);
        AppMethodBeat.o(121237);
    }
}
