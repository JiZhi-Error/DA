package com.tencent.mm.plugin.appbrand.jsapi.ab;

import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import org.json.JSONObject;

public final class a extends d<c> {
    private static final int CTRL_INDEX = 359;
    private static final String NAME = "updateApp";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* bridge */ /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46829);
        a(cVar, i2);
        AppMethodBeat.o(46829);
    }

    public final void a(final c cVar, final int i2) {
        AppMethodBeat.i(46828);
        LaunchParcel e2 = i.e(cVar.getRuntime().bsC());
        e2.mYM = Util.nowMilliSecond();
        new AppBrandPreInitTask(cVar.getContext(), e2, new AppBrandPreInitTask.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ab.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a
            public final void a(final AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
                AppMethodBeat.i(227002);
                if (appBrandInitConfigWC == null) {
                    cVar.i(i2, a.this.h("fail sync error", null));
                    AppMethodBeat.o(227002);
                } else if (cVar.getRuntime() == null || cVar.getRuntime().SO || cVar.getRuntime().isDestroyed()) {
                    Log.e("MicroMsg.AppBrand.JsApiUpdateApp", "onResult with newConfig(%s %d %d) but runtime destroyed", appBrandInitConfigWC.appId, Integer.valueOf(appBrandInitConfigWC.eix), Integer.valueOf(appBrandInitConfigWC.appVersion));
                    AppMethodBeat.o(227002);
                } else if (cVar.getRuntime().bsB().leE.kNW == 0 && appBrandInitConfigWC.appVersion == cVar.getRuntime().bsB().leE.pkgVersion && !WeChatEnvironment.hasDebugger()) {
                    cVar.i(i2, a.this.h("fail the current version is the latest version", null));
                    AppMethodBeat.o(227002);
                } else {
                    cVar.P(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.ab.a.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(46826);
                            final AnonymousClass1 r1 = new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.ab.a.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(227000);
                                    q runtime = cVar.getRuntime();
                                    AppBrandInitConfigWC appBrandInitConfigWC = appBrandInitConfigWC;
                                    if (runtime == null || appBrandInitConfigWC == null) {
                                        Log.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart skip with Null runtime");
                                        AppMethodBeat.o(227000);
                                    } else if (!runtime.mInitialized) {
                                        Log.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart %s, not initialized", runtime.mAppId);
                                        AppMethodBeat.o(227000);
                                    } else {
                                        runtime.i(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0045: INVOKE  
                                              (r0v3 'runtime' com.tencent.mm.plugin.appbrand.q)
                                              (wrap: com.tencent.mm.plugin.appbrand.ay$1 : 0x0040: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.appbrand.ay$1) = 
                                              (r0v3 'runtime' com.tencent.mm.plugin.appbrand.q)
                                              (r1v1 'appBrandInitConfigWC' com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC)
                                             call: com.tencent.mm.plugin.appbrand.ay.1.<init>(com.tencent.mm.plugin.appbrand.q, com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC):void type: CONSTRUCTOR)
                                              (0 long)
                                             type: VIRTUAL call: com.tencent.mm.plugin.appbrand.AppBrandRuntime.i(java.lang.Runnable, long):void in method: com.tencent.mm.plugin.appbrand.jsapi.ab.a.1.1.1.run():void, file: classes3.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0040: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.appbrand.ay$1) = 
                                              (r0v3 'runtime' com.tencent.mm.plugin.appbrand.q)
                                              (r1v1 'appBrandInitConfigWC' com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC)
                                             call: com.tencent.mm.plugin.appbrand.ay.1.<init>(com.tencent.mm.plugin.appbrand.q, com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.jsapi.ab.a.1.1.1.run():void, file: classes3.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                            	... 21 more
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.ay, state: GENERATED_AND_UNLOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                            	... 27 more
                                            */
                                        /*
                                            this = this;
                                            r6 = 227000(0x376b8, float:3.18095E-40)
                                            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                                            com.tencent.mm.plugin.appbrand.jsapi.ab.a$1$1 r0 = com.tencent.mm.plugin.appbrand.jsapi.ab.a.AnonymousClass1.AnonymousClass1.this
                                            com.tencent.mm.plugin.appbrand.jsapi.ab.a$1 r0 = com.tencent.mm.plugin.appbrand.jsapi.ab.a.AnonymousClass1.this
                                            com.tencent.mm.plugin.appbrand.service.c r0 = r6
                                            com.tencent.mm.plugin.appbrand.q r0 = r0.getRuntime()
                                            com.tencent.mm.plugin.appbrand.jsapi.ab.a$1$1 r1 = com.tencent.mm.plugin.appbrand.jsapi.ab.a.AnonymousClass1.AnonymousClass1.this
                                            com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC r1 = r7
                                            if (r0 == 0) goto L_0x0018
                                            if (r1 != 0) goto L_0x0025
                                        L_0x0018:
                                            java.lang.String r0 = "MicroMsg.AppBrand.RuntimeRestartHelper"
                                            java.lang.String r1 = "restart skip with Null runtime"
                                            com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
                                            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                                        L_0x0024:
                                            return
                                        L_0x0025:
                                            boolean r2 = r0.mInitialized
                                            if (r2 != 0) goto L_0x003e
                                            java.lang.String r1 = "MicroMsg.AppBrand.RuntimeRestartHelper"
                                            java.lang.String r2 = "restart %s, not initialized"
                                            r3 = 1
                                            java.lang.Object[] r3 = new java.lang.Object[r3]
                                            r4 = 0
                                            java.lang.String r0 = r0.mAppId
                                            r3[r4] = r0
                                            com.tencent.mm.sdk.platformtools.Log.e(r1, r2, r3)
                                            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                                            goto L_0x0024
                                        L_0x003e:
                                            com.tencent.mm.plugin.appbrand.ay$1 r2 = new com.tencent.mm.plugin.appbrand.ay$1
                                            r2.<init>(r0, r1)
                                            r4 = 0
                                            r0.i(r2, r4)
                                            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                                            goto L_0x0024
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ab.a.AnonymousClass1.AnonymousClass1.AnonymousClass1.run():void");
                                    }
                                };
                                if (BuildInfo.CLIENT_VERSION_INT < 654315264 || !j.a.vP(cVar.getRuntime().kAq.eix)) {
                                    b bVar = new b(cVar.getContext());
                                    bVar.setCanceledOnTouchOutside(false);
                                    bVar.setCancelable(false);
                                    bVar.setMessage(cVar.getContext().getString(cVar.getRuntime().NA() ? R.string.mx : R.string.my, cVar.getRuntime().bsC().brandName));
                                    AnonymousClass2 r0 = new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.plugin.appbrand.jsapi.ab.a.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(46825);
                                            r1.run();
                                            AppMethodBeat.o(46825);
                                        }
                                    };
                                    if (cVar.getRuntime().bsB().leE.kNW != 0) {
                                        bVar.a(R.string.mw, r0);
                                        bVar.b(R.string.mu, new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.appbrand.jsapi.ab.a.AnonymousClass1.AnonymousClass1.AnonymousClass3 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(227001);
                                                cVar.i(i2, a.this.h("fail user canceled updateApp", null));
                                                AppMethodBeat.o(227001);
                                            }
                                        });
                                    } else {
                                        bVar.a(R.string.mv, r0);
                                    }
                                    cVar.getDialogContainer().b(bVar);
                                    AppMethodBeat.o(46826);
                                    return;
                                }
                                r1.run();
                                AppMethodBeat.o(46826);
                            }
                        });
                        AppMethodBeat.o(227002);
                    }
                }
            }).bNf();
            AppMethodBeat.o(46828);
        }
    }
