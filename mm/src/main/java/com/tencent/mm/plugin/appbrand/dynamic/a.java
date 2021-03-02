package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet;
import com.tencent.mm.plugin.appbrand.m.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.Map;
import junit.framework.Assert;

public final class a {
    public String gIx;
    public String llv;
    h llw;

    public a(h hVar) {
        this.llw = hVar;
    }

    public final void bE(String str, int i2) {
        AppMethodBeat.i(121136);
        if (this.gIx == null || this.gIx.length() == 0) {
            AppMethodBeat.o(121136);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putInt("widgetState", i2);
        h.a(i.bBL().Yn(str), bundle, f.a.class, null);
        AppMethodBeat.o(121136);
    }

    public static class c implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, final com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(121129);
            Bundle bundle2 = bundle;
            String string = bundle2.getString("id");
            String string2 = bundle2.getString("appId");
            int i2 = bundle2.getInt("wxaPkgType");
            int i3 = bundle2.getInt("pkgVersion");
            int i4 = bundle2.getInt("scene");
            String string3 = bundle2.getString("searchId");
            int i5 = bundle2.getInt("widgetType");
            int i6 = bundle2.getInt("serviceType");
            bundle2.getString("wxa_unique_id");
            String string4 = bundle2.getString("preloadLaunchData", "");
            String string5 = bundle2.getString("preload_download_data", "");
            if (i5 == 1 && !u.Lu(string)) {
                u.a(string, i6, string2, string2, 0);
            }
            if (d.bBH().Yi(string) == null) {
                c cVar = new c(MMApplicationContext.getContext());
                d bBH = d.bBH();
                if (Util.isNullOrNil(string)) {
                    Log.w("MicroMsg.DynamicPageViewIPCProxyManager", "add IPCProxy into manager failed, key is null or nil.");
                } else {
                    if (bBH.llW.put(string, cVar) != null) {
                        Log.i("MicroMsg.DynamicPageViewIPCProxyManager", "add a new IPCProxy and remove old one with key : %s.", string);
                    }
                    Log.d("MicroMsg.DynamicPageViewIPCProxyManager", "add IPCProxy success.(%s)", string);
                }
            }
            i.bBL().cZ(string, bundle2.getString("view_process_name"));
            f bBJ = f.bBJ();
            String string6 = bundle2.getString("cache_key", bundle2.getString(SearchIntents.EXTRA_QUERY));
            if (bBJ.llZ.containsKey(string)) {
                Log.w("MicroMsg.DynamicPageViewStateMonitor", "OnAttach with same widgetId[%s]", string);
                bBJ.llZ.remove(string);
            }
            bBJ.llZ.put(string, new f.b(string, string2, i6, string6));
            j bBN = j.bBN();
            int i7 = i2 + 1;
            String string7 = bundle2.getString("cache_key", bundle2.getString(SearchIntents.EXTRA_QUERY));
            if (bBN.llZ.containsKey(string)) {
                com.tencent.mm.ipcinvoker.h.b.w("WidgetReporter_14443", "OnAttach with same widgetId[%s]", string);
                bBN.llZ.remove(string);
            }
            j.b bVar = new j.b(string, string2, i7, string7, i6);
            bBN.llZ.put(string, bVar);
            Bundle bundle3 = bVar.toBundle();
            h.a(MainProcessIPCService.dkO, bundle3, j.a.class, null);
            h.a(SupportProcessIPCService.dkO, bundle3, j.a.class, null);
            h.a(ToolsMpProcessIPCService.dkO, bundle3, j.a.class, null);
            bBN.P(string, JsApiShowImageOperateSheet.CTRL_INDEX, 0);
            b.postToWorker(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0168: INVOKE  
                  (wrap: com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer$1 : 0x0165: CONSTRUCTOR  (r9v1 com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer$1) = 
                  (r4v0 'string' java.lang.String)
                  (wrap: int : 0x015b: INVOKE  (r11v3 int) = (r14v0 'i5' int), (r9v0 'i2' int) type: STATIC call: com.tencent.mm.plugin.appbrand.dynamic.k.b.dV(int, int):int)
                  (r12v0 'i3' int)
                  (r5v0 'string2' java.lang.String)
                  (r14v0 'i5' int)
                  (r15v0 'i4' int)
                  (r16v0 'string4' java.lang.String)
                  (r8v0 'i6' int)
                  (wrap: com.tencent.mm.plugin.appbrand.dynamic.a$c$1 : 0x0158: CONSTRUCTOR  (r18v0 com.tencent.mm.plugin.appbrand.dynamic.a$c$1) = 
                  (r21v0 'this' com.tencent.mm.plugin.appbrand.dynamic.a$c A[IMMUTABLE_TYPE, THIS])
                  (r23v0 'dVar' com.tencent.mm.ipcinvoker.d<android.os.Bundle> A[SKIP_ARG])
                 call: com.tencent.mm.plugin.appbrand.dynamic.a.c.1.<init>(com.tencent.mm.plugin.appbrand.dynamic.a$c, com.tencent.mm.ipcinvoker.d):void type: CONSTRUCTOR)
                  (r19v0 'string3' java.lang.String)
                  (r20v0 'string5' java.lang.String)
                 call: com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.1.<init>(java.lang.String, int, int, java.lang.String, int, int, java.lang.String, int, com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer$a, java.lang.String, java.lang.String):void type: CONSTRUCTOR)
                 type: STATIC call: com.tencent.mm.plugin.appbrand.dynamic.b.postToWorker(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.appbrand.dynamic.a.c.invoke(android.os.Bundle, com.tencent.mm.ipcinvoker.d<android.os.Bundle>):void, file: classes3.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0165: CONSTRUCTOR  (r9v1 com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer$1) = 
                  (r4v0 'string' java.lang.String)
                  (wrap: int : 0x015b: INVOKE  (r11v3 int) = (r14v0 'i5' int), (r9v0 'i2' int) type: STATIC call: com.tencent.mm.plugin.appbrand.dynamic.k.b.dV(int, int):int)
                  (r12v0 'i3' int)
                  (r5v0 'string2' java.lang.String)
                  (r14v0 'i5' int)
                  (r15v0 'i4' int)
                  (r16v0 'string4' java.lang.String)
                  (r8v0 'i6' int)
                  (wrap: com.tencent.mm.plugin.appbrand.dynamic.a$c$1 : 0x0158: CONSTRUCTOR  (r18v0 com.tencent.mm.plugin.appbrand.dynamic.a$c$1) = 
                  (r21v0 'this' com.tencent.mm.plugin.appbrand.dynamic.a$c A[IMMUTABLE_TYPE, THIS])
                  (r23v0 'dVar' com.tencent.mm.ipcinvoker.d<android.os.Bundle> A[SKIP_ARG])
                 call: com.tencent.mm.plugin.appbrand.dynamic.a.c.1.<init>(com.tencent.mm.plugin.appbrand.dynamic.a$c, com.tencent.mm.ipcinvoker.d):void type: CONSTRUCTOR)
                  (r19v0 'string3' java.lang.String)
                  (r20v0 'string5' java.lang.String)
                 call: com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.1.<init>(java.lang.String, int, int, java.lang.String, int, int, java.lang.String, int, com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer$a, java.lang.String, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.dynamic.a.c.invoke(android.os.Bundle, com.tencent.mm.ipcinvoker.d<android.os.Bundle>):void, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
            // Method dump skipped, instructions count: 412
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.dynamic.a.c.invoke(java.lang.Object, com.tencent.mm.ipcinvoker.d):void");
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a$a  reason: collision with other inner class name */
    public static class C0569a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private C0569a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(121124);
            Bundle bundle2 = bundle;
            final String string = bundle2.getString("id");
            final String string2 = bundle2.getString("appId");
            final Bundle bundle3 = bundle2.getBundle("extData");
            final c Yi = d.bBH().Yi(string);
            if (Yi == null) {
                Log.e("MicroMsg.IPCInvoke_AttachTo", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                u.e("MicroMsg.IPCInvoke_AttachTo", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                AppMethodBeat.o(121124);
                return;
            }
            u.i("MicroMsg.IPCInvoke_AttachTo", "IPCInvoke_AttachTo invoke", new Object[0]);
            b.V(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.a.C0569a.AnonymousClass1 */

                public final void run() {
                    long j2;
                    String str;
                    boolean z;
                    com.tencent.mm.aa.c.e eVar;
                    AppMethodBeat.i(121123);
                    u.i("MicroMsg.IPCInvoke_AttachTo", "ui thread attach", new Object[0]);
                    try {
                        c cVar = Yi;
                        String str2 = string;
                        String str3 = string2;
                        Bundle bundle = bundle3;
                        Assert.assertNotNull(str2);
                        if (!str2.equals(cVar.gIx) && cVar.hpm != null) {
                            cVar.cleanup();
                            cVar.gc = false;
                            cVar.hpm = null;
                        }
                        cVar.gIx = str2;
                        cVar.appId = str3;
                        if (bundle != null) {
                            String string = bundle.getString("cache_key", "");
                            cVar.Nv = bundle.getString(SearchIntents.EXTRA_QUERY);
                            cVar.llK = bundle.getBoolean("is_testing_ui");
                            cVar.mUrl = bundle.getString("url");
                            cVar.llJ = bundle.getInt("widget_type");
                            cVar.hes = bundle.getString("search_id");
                            cVar.mSessionId = bundle.getString("__session_id");
                            long j3 = bundle.getLong("__on_bind_nano_time");
                            if (!Util.isNullOrNil(cVar.mSessionId)) {
                                com.tencent.mm.plugin.appbrand.collector.c.a((CollectSession) bundle.getParcelable("__cost_time_session"));
                            }
                            j2 = j3;
                            str = string;
                        } else {
                            j2 = 0;
                            str = "";
                        }
                        u.i("MicroMsg.DynamicPageViewIPCProxy", "attach(%s, %s)", str2, str3);
                        boolean z2 = true;
                        if (cVar.llJ == 1) {
                            z2 = false;
                        } else {
                            cVar.llL = com.tencent.mm.plugin.appbrand.dynamic.j.b.YE(str2);
                        }
                        if (cVar.llL == null) {
                            cVar.llL = new com.tencent.mm.plugin.appbrand.widget.e();
                            z = false;
                        } else {
                            z = z2;
                        }
                        cVar.llL.field_id = str2;
                        cVar.llL.field_cacheKey = str;
                        cVar.llL.field_appId = u.Lv(cVar.gIx);
                        if (cVar.hpm == null) {
                            u.i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge is null", new Object[0]);
                            com.tencent.mm.plugin.appbrand.collector.c.cP(cVar.mSessionId, "before_init_js_engine");
                            Context context = cVar.mContext;
                            String str4 = cVar.gIx;
                            WxaWidgetContext Ys = k.Ys(str4);
                            if (Ys == null || bundle == null) {
                                Log.w("MicroMsg.WxaWidgetInitializer", "FwContext is null(id : %s)", str4);
                                eVar = null;
                            } else {
                                Log.i("MicroMsg.WxaWidgetInitializer", "initJsBridge(%s)", str4);
                                eVar = com.tencent.mm.plugin.appbrand.dynamic.h.e.a(context, Ys, new com.tencent.mm.plugin.appbrand.dynamic.d.c.a(str4, Ys.bBR()), bundle);
                            }
                            cVar.hpm = eVar;
                            com.tencent.mm.plugin.appbrand.collector.c.cP(cVar.mSessionId, "after_init_js_engine");
                            cVar.hpm.gIx = cVar.gIx;
                            if (cVar.hpm.hpr instanceof com.tencent.mm.plugin.appbrand.dynamic.e.a) {
                                ((com.tencent.mm.plugin.appbrand.dynamic.e.a) cVar.hpm.hpr).setJsExceptionHandler(new com.tencent.mm.plugin.appbrand.m.h() {
                                    /* class com.tencent.mm.plugin.appbrand.dynamic.c.AnonymousClass3 */

                                    @Override // com.tencent.mm.plugin.appbrand.m.h
                                    public final void u(String str, String str2) {
                                        AppMethodBeat.i(121143);
                                        u.i("MicroMsg.DynamicPageViewIPCProxy", "js error msg %s, stackTrace %s", str, str2);
                                        Bundle bundle = new Bundle();
                                        bundle.putString("widgetId", c.this.gIx);
                                        bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "onWidgetJsError");
                                        bundle.putString("data", str2);
                                        String Yn = i.bBL().Yn(c.this.gIx);
                                        if (Yn == null) {
                                            ToolsProcessIPCService.a(bundle, b.class);
                                            AppMethodBeat.o(121143);
                                            return;
                                        }
                                        h.a(Yn, bundle, b.class, null);
                                        AppMethodBeat.o(121143);
                                    }
                                });
                                cVar.hpm.hpr.a(new z() {
                                    /* class com.tencent.mm.plugin.appbrand.dynamic.c.AnonymousClass4 */

                                    @Override // com.tencent.mm.plugin.appbrand.m.z
                                    public final void onError(String str) {
                                        AppMethodBeat.i(121144);
                                        u.i("MicroMsg.DynamicPageViewIPCProxy", "console js error stackTrace %s", str);
                                        if (!TextUtils.isEmpty(str) && str.contains("widgetThirdScriptError")) {
                                            Bundle bundle = new Bundle();
                                            bundle.putString("widgetId", c.this.gIx);
                                            bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "onWidgetJsError");
                                            bundle.putString("data", str);
                                            String Yn = i.bBL().Yn(c.this.gIx);
                                            if (Yn == null) {
                                                ToolsProcessIPCService.a(bundle, b.class);
                                                AppMethodBeat.o(121144);
                                                return;
                                            }
                                            h.a(Yn, bundle, b.class, null);
                                        }
                                        AppMethodBeat.o(121144);
                                    }
                                });
                            }
                            if (bundle != null) {
                                cVar.H(bundle.getBundle("__env_args"));
                            }
                            cVar.hpm.onStart();
                            if (cVar.llM) {
                                cVar.hpm.a(new com.tencent.mm.plugin.appbrand.dynamic.f.f());
                            } else {
                                cVar.hpm.b(new com.tencent.mm.plugin.appbrand.dynamic.f.g());
                            }
                            u.i("MicroMsg.DynamicPageViewIPCProxy", "before dispatch onCanvasInsertJsEvent", new Object[0]);
                            com.tencent.mm.aa.c.e eVar2 = cVar.hpm;
                            String str5 = "";
                            String str6 = "";
                            String str7 = "";
                            Map<String, String> map = null;
                            int i2 = 0;
                            int i3 = 0;
                            if (bundle != null) {
                                i2 = bundle.getInt("view_init_width");
                                i3 = bundle.getInt("view_init_height");
                                str5 = bundle.getString("cache_key", "");
                                str6 = bundle.getString("msg_title", "");
                                String string2 = bundle.getString("msg_path", "");
                                str7 = l.dM(string2);
                                map = l.dN(string2);
                            }
                            com.tencent.mm.plugin.appbrand.dynamic.f.b bVar = new com.tencent.mm.plugin.appbrand.dynamic.f.b();
                            bVar.cacheKey = str5;
                            bVar.title = str6;
                            bVar.path = str7;
                            bVar.loD = map;
                            bVar.loE = i2;
                            bVar.loF = i3;
                            eVar2.a(bVar, new ValueCallback<String>() {
                                /* class com.tencent.mm.plugin.appbrand.dynamic.c.AnonymousClass5 */

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // android.webkit.ValueCallback
                                public final /* synthetic */ void onReceiveValue(String str) {
                                    AppMethodBeat.i(121145);
                                    u.i("MicroMsg.DynamicPageViewIPCProxy", "dispatch canvasInsert event result %s", str);
                                    AppMethodBeat.o(121145);
                                }
                            });
                            u.i("MicroMsg.DynamicPageViewIPCProxy", "after dispatch onCanvasInsertJsEvent", new Object[0]);
                            hr vt = new hr().vt(u.Lv(str2));
                            vt.eBS = (long) u.Lt(str2);
                            vt.eMi = 8;
                            hr vs = vt.vs(str2);
                            vs.eMj = System.currentTimeMillis();
                            vs.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                            if (j2 > 0) {
                                long nanoTime = (System.nanoTime() - j2) / TimeUtil.SECOND_TO_US;
                                int i4 = 22;
                                if (nanoTime <= 50) {
                                    i4 = 0;
                                } else if (nanoTime <= 100) {
                                    i4 = 1;
                                } else if (nanoTime <= 200) {
                                    i4 = 2;
                                } else if (nanoTime <= 300) {
                                    i4 = 3;
                                } else if (nanoTime <= 400) {
                                    i4 = 4;
                                } else if (nanoTime <= 500) {
                                    i4 = 5;
                                } else if (nanoTime <= 600) {
                                    i4 = 6;
                                } else if (nanoTime <= 1000) {
                                    i4 = 17;
                                } else if (nanoTime <= 1500) {
                                    i4 = 18;
                                } else if (nanoTime <= 2000) {
                                    i4 = 19;
                                } else if (nanoTime <= 2500) {
                                    i4 = 20;
                                } else if (nanoTime <= 3000) {
                                    i4 = 21;
                                }
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(677, (long) i4, 1, false);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(677, 8, 1, false);
                            }
                            com.tencent.mm.plugin.appbrand.collector.c.cP(cVar.mSessionId, "init_finish");
                            com.tencent.mm.plugin.appbrand.collector.c.print(cVar.mSessionId);
                            u.i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge init complete", new Object[0]);
                        } else {
                            u.i("MicroMsg.DynamicPageViewIPCProxy", "jsbridge not null", new Object[0]);
                            com.tencent.mm.plugin.appbrand.collector.c.WK(cVar.mSessionId);
                            if (bundle != null) {
                                cVar.H(bundle.getBundle("__env_args"));
                            }
                            cVar.hpm.onStart();
                            if (cVar.llM) {
                                cVar.hpm.a(new com.tencent.mm.plugin.appbrand.dynamic.f.f());
                            } else {
                                cVar.hpm.b(new com.tencent.mm.plugin.appbrand.dynamic.f.g());
                            }
                        }
                        cVar.gc = true;
                        if (z) {
                            cVar.a(cVar.hpm, cVar.llL);
                        } else if (cVar.llK) {
                            cVar.llL.field_data = bundle.getString("init_data");
                            cVar.a(cVar.hpm, cVar.llL);
                        }
                        cVar.bBG();
                        AppMethodBeat.o(121123);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.IPCInvoke_AttachTo", e2, "caught exception", new Object[0]);
                        AppMethodBeat.o(121123);
                    }
                }
            });
            AppMethodBeat.o(121124);
        }
    }

    public static class b implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, final com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            Integer num;
            final c cVar = null;
            AppMethodBeat.i(121126);
            final String string = bundle.getString("id");
            d bBH = d.bBH();
            if (Util.isNullOrNil(string)) {
                Log.w("MicroMsg.DynamicPageViewIPCProxyManager", "remove IPCProxy from manager failed, key is null or nil.");
            } else {
                c remove = bBH.llW.remove(string);
                Object[] objArr = new Object[2];
                objArr[0] = string;
                if (remove != null) {
                    num = Integer.valueOf(remove.hashCode());
                } else {
                    num = null;
                }
                objArr[1] = num;
                Log.d("MicroMsg.DynamicPageViewIPCProxyManager", "remove IPCProxy success.(key : %s, ref : %s)", objArr);
                if (remove != null) {
                    cVar = remove;
                }
            }
            if (cVar == null) {
                Log.e("MicroMsg.IPCInvoke_Detach", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                AppMethodBeat.o(121126);
                return;
            }
            b.V(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.a.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(121125);
                    c cVar = cVar;
                    Log.i("MicroMsg.DynamicPageViewIPCProxy", "detach(%s)", cVar.gIx);
                    cVar.gc = false;
                    cVar.cleanup();
                    cVar.hpm = null;
                    cVar.llL = null;
                    cVar.gIx = null;
                    cVar.mSessionId = null;
                    k.Yt(string);
                    dVar.bn(null);
                    f.bBJ().Yk(string);
                    AppMethodBeat.o(121125);
                }
            });
            AppMethodBeat.o(121126);
        }
    }

    public static class d implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(121131);
            String string = bundle.getString("id");
            final c Yi = d.bBH().Yi(string);
            if (Yi == null) {
                Log.e("MicroMsg.IPCInvoke_OnPause", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                AppMethodBeat.o(121131);
                return;
            }
            b.V(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.a.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(121130);
                    c cVar = Yi;
                    Log.i("MicroMsg.DynamicPageViewIPCProxy", "onPause(%s)", cVar.gIx);
                    cVar.llN = true;
                    AppMethodBeat.o(121130);
                }
            });
            AppMethodBeat.o(121131);
        }
    }

    public static class e implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private e() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(121133);
            String string = bundle.getString("id");
            final c Yi = d.bBH().Yi(string);
            if (Yi == null) {
                Log.e("MicroMsg.IPCInvoke_OnResume", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                AppMethodBeat.o(121133);
                return;
            }
            b.V(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.a.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(121132);
                    Yi.onResume();
                    AppMethodBeat.o(121132);
                }
            });
            AppMethodBeat.o(121133);
        }
    }

    public static class g implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private g() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(121135);
            Bundle bundle2 = bundle;
            String string = bundle2.getString("id");
            Bundle bundle3 = bundle2.getBundle("__env_args");
            if (bundle3 == null) {
                Log.i("MicroMsg.IPCInvoke_UpdateEnvArgs", "envArgs is null.");
                AppMethodBeat.o(121135);
                return;
            }
            c Yi = d.bBH().Yi(string);
            if (Yi == null) {
                Log.e("MicroMsg.IPCInvoke_UpdateEnvArgs", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                AppMethodBeat.o(121135);
                return;
            }
            Yi.H(bundle3);
            AppMethodBeat.o(121135);
        }
    }

    public static class f implements k<Bundle, IPCBoolean> {
        private f() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(Bundle bundle) {
            AppMethodBeat.i(121134);
            Bundle bundle2 = bundle;
            String string = bundle2.getString("id");
            String string2 = bundle2.getString("event");
            String string3 = bundle2.getString("data");
            c Yi = d.bBH().Yi(string);
            if (Yi == null) {
                Log.e("MicroMsg.IPCInvoke_PublishJsEvent", "get DynamicPageViewIPCProxy(id : %s) return null.", string);
                IPCBoolean iPCBoolean = new IPCBoolean(false);
                AppMethodBeat.o(121134);
                return iPCBoolean;
            }
            IPCBoolean iPCBoolean2 = new IPCBoolean(Yi.cY(string2, string3));
            AppMethodBeat.o(121134);
            return iPCBoolean2;
        }
    }
}
