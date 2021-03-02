package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import com.tencent.luggage.a.e;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.g;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c implements b {
    String currentAppId;
    com.tencent.mm.plugin.appbrand.platform.window.b mKY;
    com.tencent.luggage.xweb_ext.extendplugin.component.video.c mKZ;
    private c.a mKa = new c.a() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.appbrand.a.c.a
        public final void a(String str, com.tencent.mm.plugin.appbrand.a.b bVar) {
            AppMethodBeat.i(139556);
            if (str.equalsIgnoreCase(c.this.currentAppId)) {
                Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onRunningStateChanged, state: ".concat(String.valueOf(bVar)));
                if (bVar == com.tencent.mm.plugin.appbrand.a.b.BACKGROUND) {
                    if (c.this.mKZ != null) {
                        com.tencent.luggage.xweb_ext.extendplugin.component.video.c cVar = c.this.mKZ;
                        cVar.k(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0034: INVOKE  
                              (r0v13 'cVar' com.tencent.luggage.xweb_ext.extendplugin.component.video.c)
                              (wrap: com.tencent.luggage.xweb_ext.extendplugin.component.video.c$17 : 0x0031: CONSTRUCTOR  (r1v3 com.tencent.luggage.xweb_ext.extendplugin.component.video.c$17) = (r0v13 'cVar' com.tencent.luggage.xweb_ext.extendplugin.component.video.c) call: com.tencent.luggage.xweb_ext.extendplugin.component.video.c.17.<init>(com.tencent.luggage.xweb_ext.extendplugin.component.video.c):void type: CONSTRUCTOR)
                             type: VIRTUAL call: com.tencent.luggage.xweb_ext.extendplugin.component.video.c.k(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.4.a(java.lang.String, com.tencent.mm.plugin.appbrand.a.b):void, file: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0031: CONSTRUCTOR  (r1v3 com.tencent.luggage.xweb_ext.extendplugin.component.video.c$17) = (r0v13 'cVar' com.tencent.luggage.xweb_ext.extendplugin.component.video.c) call: com.tencent.luggage.xweb_ext.extendplugin.component.video.c.17.<init>(com.tencent.luggage.xweb_ext.extendplugin.component.video.c):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.4.a(java.lang.String, com.tencent.mm.plugin.appbrand.a.b):void, file: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 29 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.luggage.xweb_ext.extendplugin.component.video.c, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 35 more
                            */
                        /*
                            this = this;
                            r3 = 139556(0x22124, float:1.9556E-40)
                            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                            com.tencent.mm.plugin.appbrand.jsapi.ag.e.c r0 = com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.this
                            java.lang.String r0 = r0.currentAppId
                            boolean r0 = r5.equalsIgnoreCase(r0)
                            if (r0 == 0) goto L_0x0051
                            java.lang.String r0 = "MicroMsg.SameLayer.AppBrandVideoCustomHandler"
                            java.lang.String r1 = "onRunningStateChanged, state: "
                            java.lang.String r2 = java.lang.String.valueOf(r6)
                            java.lang.String r1 = r1.concat(r2)
                            com.tencent.mm.sdk.platformtools.Log.i(r0, r1)
                            com.tencent.mm.plugin.appbrand.a.b r0 = com.tencent.mm.plugin.appbrand.a.b.BACKGROUND
                            if (r6 != r0) goto L_0x003b
                            com.tencent.mm.plugin.appbrand.jsapi.ag.e.c r0 = com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.this
                            com.tencent.luggage.xweb_ext.extendplugin.component.video.c r0 = r0.mKZ
                            if (r0 == 0) goto L_0x0051
                            com.tencent.mm.plugin.appbrand.jsapi.ag.e.c r0 = com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.this
                            com.tencent.luggage.xweb_ext.extendplugin.component.video.c r0 = r0.mKZ
                            com.tencent.luggage.xweb_ext.extendplugin.component.video.c$17 r1 = new com.tencent.luggage.xweb_ext.extendplugin.component.video.c$17
                            r1.<init>()
                            r0.k(r1)
                            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                        L_0x003a:
                            return
                        L_0x003b:
                            com.tencent.mm.plugin.appbrand.a.b r0 = com.tencent.mm.plugin.appbrand.a.b.kQH
                            if (r6 != r0) goto L_0x0051
                            com.tencent.mm.plugin.appbrand.jsapi.ag.e.c r0 = com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.this
                            com.tencent.luggage.xweb_ext.extendplugin.component.video.c r0 = r0.mKZ
                            if (r0 == 0) goto L_0x0051
                            com.tencent.mm.plugin.appbrand.jsapi.ag.e.c r0 = com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.this
                            com.tencent.luggage.xweb_ext.extendplugin.component.video.c r0 = r0.mKZ
                            com.tencent.luggage.xweb_ext.extendplugin.component.video.c$15 r1 = new com.tencent.luggage.xweb_ext.extendplugin.component.video.c$15
                            r1.<init>()
                            r0.k(r1)
                        L_0x0051:
                            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                            goto L_0x003a
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.AnonymousClass4.a(java.lang.String, com.tencent.mm.plugin.appbrand.a.b):void");
                    }
                };
                private a mLa;

                public c() {
                    AppMethodBeat.i(139557);
                    com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c cVar = (com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c) e.M(com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c.class);
                    if (cVar != null) {
                        this.mKY = cVar.bMn();
                    }
                    this.mLa = new a();
                    AppMethodBeat.o(139557);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final void b(com.tencent.luggage.xweb_ext.extendplugin.component.video.c cVar) {
                    this.mKZ = cVar;
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c QE() {
                    AppMethodBeat.i(139558);
                    d dVar = new d();
                    AppMethodBeat.o(139558);
                    return dVar;
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final d QF() {
                    AppMethodBeat.i(139559);
                    e eVar = new e();
                    AppMethodBeat.o(139559);
                    return eVar;
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e QD() {
                    AppMethodBeat.i(139560);
                    f fVar = new f();
                    AppMethodBeat.o(139560);
                    return fVar;
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final f QC() {
                    AppMethodBeat.i(139561);
                    g gVar = new g();
                    AppMethodBeat.o(139561);
                    return gVar;
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final b a(com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a aVar, com.tencent.luggage.xweb_ext.extendplugin.a aVar2) {
                    AppMethodBeat.i(139562);
                    b bVar = new b(aVar, aVar2);
                    AppMethodBeat.o(139562);
                    return bVar;
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final com.tencent.mm.plugin.appbrand.jsapi.video.e.c a(com.tencent.luggage.xweb_ext.extendplugin.a aVar, Handler handler) {
                    com.tencent.mm.plugin.appbrand.jsapi.video.e.c a2;
                    AppMethodBeat.i(215884);
                    if (!(aVar instanceof com.tencent.mm.plugin.appbrand.h.b)) {
                        AppMethodBeat.o(215884);
                        return null;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    h hVar = (h) e.M(h.class);
                    if (hVar == null) {
                        a2 = new com.tencent.mm.plugin.appbrand.jsapi.video.e.e();
                    } else {
                        a2 = hVar.a(aVar, handler);
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    a aVar2 = this.mLa;
                    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e bMj = bMj();
                    if (!(a2 == null || bMj == null)) {
                        if (a2 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) {
                            bMj.c(1234, 3, 1);
                            bMj.c(1234, 4, currentTimeMillis2);
                            aVar2.mNm.mEJ = 1;
                        } else if (a2 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.e) {
                            bMj.c(1234, 0, 1);
                            bMj.c(1234, 1, currentTimeMillis2);
                            aVar2.mNm.mEJ = 0;
                        }
                        bMj.c(1234, 6, 1);
                        aVar2.mNm.mNo = currentTimeMillis2;
                    }
                    AppMethodBeat.o(215884);
                    return a2;
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final String b(com.tencent.luggage.xweb_ext.extendplugin.a aVar, String str) {
                    AppMethodBeat.i(139564);
                    if (!(aVar instanceof com.tencent.mm.plugin.appbrand.h.b)) {
                        AppMethodBeat.o(139564);
                        return str;
                    } else if (Util.isNullOrNil(str) || !str.startsWith("cloud://")) {
                        com.tencent.mm.plugin.appbrand.jsapi.f NN = aVar.NN();
                        if (Util.isNullOrNil(str) || NN == null || NN.getFileSystem() == null || !NN.getFileSystem().Vi(str)) {
                            if (!Util.isNullOrNil(str) && e.M(g.class) != null) {
                                str = ((g) e.M(g.class)).getProxyUrl(str);
                            }
                            AppMethodBeat.o(139564);
                            return str;
                        }
                        o VY = NN.getFileSystem().VY(str);
                        if (VY != null) {
                            str = "file://" + aa.z(VY.her());
                        }
                        Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "convertVideoPath, videoPath:%s", str);
                        AppMethodBeat.o(139564);
                        return str;
                    } else {
                        AppMethodBeat.o(139564);
                        return null;
                    }
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar, String str) {
                    long j2;
                    AppMethodBeat.i(215885);
                    long j3 = 0;
                    if (e.M(g.class) != null) {
                        j3 = ((g) e.M(g.class)).f(str, 0, MAlarmHandler.NEXT_FIRE_INTERVAL);
                    }
                    if (j3 < 0) {
                        j2 = 0;
                    } else {
                        j2 = j3;
                    }
                    Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onVideoPathChanged, videoPath:%s, cachedSize:%s", str, Long.valueOf(j2));
                    if (!(this.mKZ == null || this.mKZ.cIW == null)) {
                        this.mKZ.cIW.aX(j2);
                    }
                    a aVar = this.mLa;
                    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e bMj = bMj();
                    if (!(cVar == null || bMj == null || Util.isNullOrNil(str))) {
                        bMj.c(1234, 10, 1);
                        if (j2 > 0) {
                            bMj.c(1234, 11, 1);
                            long longValue = BigInteger.valueOf(j2).divide(a.mNl).longValue();
                            bMj.c(1234, 13, longValue);
                            Log.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", Long.valueOf(j2), Long.valueOf(longValue));
                        }
                        a.C0623a aVar2 = aVar.mNm;
                        if (!Util.isNullOrNil(str)) {
                            if (str.length() > 512) {
                                str = str.substring(0, 512);
                            }
                            aVar2.videoPath = str;
                        } else {
                            aVar2.videoPath = "";
                        }
                        aVar.mNm.mNp = j2;
                    }
                    AppMethodBeat.o(215885);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final boolean j(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
                    final int i2;
                    AppMethodBeat.i(139566);
                    if (!(aVar instanceof com.tencent.mm.plugin.appbrand.h.b)) {
                        AppMethodBeat.o(139566);
                        return false;
                    }
                    JSONObject Ps = aVar.Ps();
                    com.tencent.mm.plugin.appbrand.jsapi.f fVar = ((com.tencent.mm.plugin.appbrand.h.b) aVar).lqg;
                    final ac acVar = null;
                    if (fVar instanceof ac) {
                        acVar = (ac) fVar;
                    } else if (fVar instanceof s) {
                        acVar = ((s) fVar).getCurrentPageView();
                    }
                    if (acVar == null) {
                        Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, page view is null");
                        AppMethodBeat.o(139566);
                        return false;
                    } else if (Ps == null || !Ps.has("data")) {
                        AppMethodBeat.o(139566);
                        return false;
                    } else {
                        JSONArray optJSONArray = Ps.optJSONArray("data");
                        if (optJSONArray == null || optJSONArray.length() == 0) {
                            Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, data array is null");
                            AppMethodBeat.o(139566);
                            return false;
                        }
                        switch (optJSONArray.optInt(0, 90)) {
                            case -90:
                                i2 = -90;
                                break;
                            case 0:
                                i2 = 0;
                                break;
                            case 90:
                                i2 = 90;
                                break;
                            default:
                                i2 = 90;
                                break;
                        }
                        acVar.P(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(139553);
                                if (!acVar.isRunning() || acVar.nmX == null) {
                                    Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, invalid state");
                                    AppMethodBeat.o(139553);
                                    return;
                                }
                                com.tencent.mm.plugin.appbrand.platform.window.d fullscreenImpl = acVar.nmX.getFullscreenImpl();
                                View wrapperView = acVar.nmX.getWrapperView();
                                if (fullscreenImpl == null || wrapperView == null) {
                                    Log.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, state error, FullscreenImp[%s], fullscreenWebView[%s]", fullscreenImpl, wrapperView);
                                    AppMethodBeat.o(139553);
                                    return;
                                }
                                fullscreenImpl.N(wrapperView, i2);
                                if (c.this.mKY != null) {
                                    fullscreenImpl.a(c.this.mKY);
                                }
                                Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "requestFullscreen, target orientation:%s", Integer.valueOf(i2));
                                AppMethodBeat.o(139553);
                            }
                        });
                        AppMethodBeat.o(139566);
                        return true;
                    }
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final boolean k(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
                    final ac acVar;
                    AppMethodBeat.i(139567);
                    if (!(aVar instanceof com.tencent.mm.plugin.appbrand.h.b)) {
                        AppMethodBeat.o(139567);
                        return false;
                    }
                    com.tencent.mm.plugin.appbrand.jsapi.f fVar = ((com.tencent.mm.plugin.appbrand.h.b) aVar).lqg;
                    if (fVar instanceof ac) {
                        acVar = (ac) fVar;
                    } else if (fVar instanceof s) {
                        acVar = ((s) fVar).getCurrentPageView();
                    } else {
                        acVar = null;
                    }
                    if (acVar == null) {
                        Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, page view is null");
                        AppMethodBeat.o(139567);
                        return false;
                    }
                    acVar.P(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(139554);
                            if (!acVar.isRunning() || acVar.nmX == null) {
                                Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, invalid state");
                                AppMethodBeat.o(139554);
                                return;
                            }
                            com.tencent.mm.plugin.appbrand.platform.window.d fullscreenImpl = acVar.nmX.getFullscreenImpl();
                            if (fullscreenImpl != null) {
                                fullscreenImpl.btC();
                                Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen");
                                AppMethodBeat.o(139554);
                                return;
                            }
                            Log.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "exitFullscreen, state error");
                            AppMethodBeat.o(139554);
                        }
                    });
                    AppMethodBeat.o(139567);
                    return true;
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final boolean t(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
                    ac acVar;
                    AppMethodBeat.i(139568);
                    if (!(aVar instanceof com.tencent.mm.plugin.appbrand.h.b)) {
                        AppMethodBeat.o(139568);
                        return false;
                    }
                    JSONObject Ps = aVar.Ps();
                    com.tencent.mm.plugin.appbrand.jsapi.f fVar = ((com.tencent.mm.plugin.appbrand.h.b) aVar).lqg;
                    if (fVar instanceof ac) {
                        acVar = (ac) fVar;
                    } else if (fVar instanceof s) {
                        acVar = ((s) fVar).getCurrentPageView();
                    } else {
                        acVar = null;
                    }
                    if (acVar == null) {
                        Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, page view is null");
                        AppMethodBeat.o(139568);
                        return false;
                    }
                    if (Ps != null && Ps.has("data")) {
                        JSONArray optJSONArray = Ps.optJSONArray("data");
                        if (optJSONArray == null || optJSONArray.length() == 0) {
                            Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, data array is null");
                            AppMethodBeat.o(139568);
                            return false;
                        }
                        final float optDouble = (float) optJSONArray.optDouble(0, -1.0d);
                        if (Float.isNaN(optDouble) || optDouble < 0.0f || optDouble > 1.0f) {
                            AppMethodBeat.o(139568);
                            return false;
                        } else if (acVar.getContext() instanceof Activity) {
                            final Activity activity = (Activity) acVar.getContext();
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.c.AnonymousClass3 */

                                public final void run() {
                                    float f2 = 0.01f;
                                    AppMethodBeat.i(139555);
                                    WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                                    if (optDouble >= 0.01f) {
                                        f2 = optDouble;
                                    }
                                    attributes.screenBrightness = f2;
                                    activity.getWindow().setAttributes(attributes);
                                    Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "setScreenBrightness, brightness:%s", Float.valueOf(attributes.screenBrightness));
                                    AppMethodBeat.o(139555);
                                }
                            });
                            AppMethodBeat.o(139568);
                            return true;
                        }
                    }
                    AppMethodBeat.o(139568);
                    return false;
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final void a(com.tencent.luggage.xweb_ext.extendplugin.a aVar, Bitmap bitmap) {
                    AppMethodBeat.i(178857);
                    if (!(aVar instanceof com.tencent.mm.plugin.appbrand.h.b)) {
                        AppMethodBeat.o(178857);
                    } else if (bitmap == null || bitmap.isRecycled()) {
                        Log.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, bitmap is null");
                        aVar.dP("fail:snapshot error");
                        AppMethodBeat.o(178857);
                    } else {
                        com.tencent.mm.plugin.appbrand.jsapi.f NN = aVar.NN();
                        String str = AndroidMediaUtil.getSysCameraDirPath() + String.format(Locale.US, "%s%d.%s", "capture", Long.valueOf(System.currentTimeMillis()), "jpg");
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        try {
                            BitmapUtil.saveBitmapToImage(bitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
                            i<String> iVar = new i<>();
                            if (NN.getFileSystem() == null) {
                                aVar.dP("fail");
                                AppMethodBeat.o(178857);
                            } else if (NN.getFileSystem().a(new o(str), "jpg", true, iVar) != m.OK) {
                                Log.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save snapshot failed");
                                aVar.dP("fail:snapshot error");
                                AppMethodBeat.o(178857);
                            } else {
                                if (bitmap != null && !bitmap.isRecycled()) {
                                    Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "bitmap recycle " + bitmap.toString());
                                    bitmap.recycle();
                                }
                                Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, actualPath:%s path:%s", str, iVar.value);
                                HashMap hashMap = new HashMap();
                                hashMap.put("tempImagePath", iVar.value);
                                hashMap.put("width", Integer.valueOf(width));
                                hashMap.put("height", Integer.valueOf(height));
                                aVar.f("ok", hashMap);
                                AppMethodBeat.o(178857);
                            }
                        } catch (IOException e2) {
                            Log.e("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "operateSnapshot, save bitmap exception", e2);
                            aVar.dP("fail:snapshot error");
                            AppMethodBeat.o(178857);
                        }
                    }
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final void u(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
                    AppMethodBeat.i(215886);
                    if (aVar != null && "wxfe02ecfe70800f46".equalsIgnoreCase(aVar.getAppId())) {
                        Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "onMediaPlayerVideoFirstFrame, send play event");
                        EventCenter.instance.publish(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
                    }
                    AppMethodBeat.o(215886);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final void c(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar) {
                    AppMethodBeat.i(215887);
                    a aVar = this.mLa;
                    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e bMj = bMj();
                    if (!(cVar == null || bMj == null || aVar.mNm.mNq > 0)) {
                        aVar.mNm.mNq = Util.nowMilliSecond();
                        bMj.c(1234, 20, 1);
                        if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) {
                            bMj.c(1234, 45, 1);
                            AppMethodBeat.o(215887);
                            return;
                        } else if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.e) {
                            bMj.c(1234, 40, 1);
                        }
                    }
                    AppMethodBeat.o(215887);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar, long j2) {
                    AppMethodBeat.i(215888);
                    a aVar = this.mLa;
                    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e bMj = bMj();
                    if (!(cVar == null || bMj == null)) {
                        if (aVar.mNm.mNr <= 0) {
                            aVar.mNm.mNr = Util.nowMilliSecond();
                            bMj.c(1234, 21, 1);
                            long j3 = aVar.mNm.mNr - aVar.mNm.mNq;
                            aVar.mNm.mNs = j3;
                            bMj.c(1234, 23, j3);
                            Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, prepareTime:%s", Long.valueOf(j3));
                            if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) {
                                bMj.c(1234, 46, 1);
                                bMj.c(1234, 48, j3);
                            } else if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.e) {
                                bMj.c(1234, 41, 1);
                                bMj.c(1234, 43, j3);
                            }
                        }
                        if (aVar.mNm.duration <= 0 && j2 > 0) {
                            long j4 = (long) ((1.0d * ((double) j2)) / 1000.0d);
                            aVar.mNm.duration = j4;
                            bMj.c(1234, 35, 1);
                            Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", Long.valueOf(j4));
                        }
                    }
                    AppMethodBeat.o(215888);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final void d(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar) {
                    AppMethodBeat.i(215889);
                    a aVar = this.mLa;
                    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e bMj = bMj();
                    if (!(cVar == null || bMj == null || aVar.mNm.mNv > 0)) {
                        aVar.mNm.mNt++;
                        aVar.mNm.mNv = Util.nowMilliSecond();
                        bMj.c(1234, 50, 1);
                        if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) {
                            bMj.c(1234, 98, 1);
                        }
                    }
                    AppMethodBeat.o(215889);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final void e(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar) {
                    AppMethodBeat.i(215890);
                    a aVar = this.mLa;
                    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e bMj = bMj();
                    if (!(cVar == null || bMj == null)) {
                        if (aVar.mNm.mNw <= 0) {
                            aVar.mNm.mNw = Util.nowMilliSecond();
                            bMj.c(1234, 51, 1);
                            long j2 = aVar.mNm.mNw - aVar.mNm.mNv;
                            aVar.mNm.mNu += j2;
                            bMj.c(1234, 53, j2);
                            Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", Long.valueOf(j2));
                            if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) {
                                bMj.c(1234, 99, 1);
                                bMj.c(1234, 101, j2);
                            }
                        }
                        a.C0623a aVar2 = aVar.mNm;
                        aVar2.mNv = 0;
                        aVar2.mNw = 0;
                    }
                    AppMethodBeat.o(215890);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar, int i2, int i3, String str) {
                    AppMethodBeat.i(215891);
                    a aVar = this.mLa;
                    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e bMj = bMj();
                    if (!(cVar == null || bMj == null)) {
                        bMj.c(1234, 65, 1);
                        Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) {
                            bMj.c(1234, 75, 1);
                        } else if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.e) {
                            bMj.c(1234, 70, 1);
                        }
                        if (!(cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.e)) {
                            com.tencent.mm.plugin.appbrand.jsapi.video.e.b el = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.el(i2, i3);
                            if (el != null) {
                                switch (a.AnonymousClass1.mNn[el.ordinal()]) {
                                    case 1:
                                        if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) {
                                            bMj.c(1234, 116, 1);
                                            break;
                                        }
                                        break;
                                    case 2:
                                        if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) {
                                            bMj.c(1234, 117, 1);
                                            break;
                                        }
                                        break;
                                    case 3:
                                        if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) {
                                            bMj.c(1234, 118, 1);
                                            break;
                                        }
                                        break;
                                    case 4:
                                        if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) {
                                            bMj.c(1234, 119, 1);
                                            break;
                                        }
                                        break;
                                    case 5:
                                        if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) {
                                            bMj.c(1234, 120, 1);
                                            break;
                                        }
                                        break;
                                    case 6:
                                        if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) {
                                            bMj.c(1234, 121, 1);
                                            break;
                                        }
                                        break;
                                    case 7:
                                        if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) {
                                            bMj.c(1234, 122, 1);
                                            break;
                                        }
                                        break;
                                    case 8:
                                        if (cVar instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) {
                                            bMj.c(1234, 123, 1);
                                            break;
                                        }
                                        break;
                                }
                            }
                        } else if (!Util.isNullOrNil(str)) {
                            if (str.equalsIgnoreCase("MEDIA_ERR_NETWORK")) {
                                bMj.c(1234, 72, 1);
                            } else if (str.equalsIgnoreCase("MEDIA_ERR_DECODE")) {
                                bMj.c(1234, 73, 1);
                            } else if (str.equalsIgnoreCase("MEDIA_ERR_SRC_NOT_SUPPORTED")) {
                                bMj.c(1234, 71, 1);
                            } else {
                                bMj.c(1234, 74, 1);
                            }
                        }
                        aVar.mNm.mNz = i2;
                        aVar.mNm.mNA = i3;
                        aVar.mNm.errorMsg = str;
                    }
                    AppMethodBeat.o(215891);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final void a(f.b bVar) {
                    AppMethodBeat.i(215892);
                    a.a(bMj(), bVar);
                    AppMethodBeat.o(215892);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final void a(com.tencent.luggage.xweb_ext.extendplugin.a aVar, com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar) {
                    AppMethodBeat.i(215893);
                    a aVar2 = this.mLa;
                    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e bMj = bMj();
                    if (bMj != null && !Util.isNullOrNil(aVar2.mNm.videoPath) && aVar2.mNm.mNq > 0) {
                        aVar2.mNm.mNx = Util.nowMilliSecond();
                        aVar2.a(bMj, aVar, cVar, "onMediaPlayerVideoStop");
                    }
                    AppMethodBeat.o(215893);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final void b(com.tencent.luggage.xweb_ext.extendplugin.a aVar, com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar) {
                    AppMethodBeat.i(215894);
                    a aVar2 = this.mLa;
                    com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e bMj = bMj();
                    if (bMj != null && !Util.isNullOrNil(aVar2.mNm.videoPath) && aVar2.mNm.mNq > 0) {
                        aVar2.mNm.mNy = Util.nowMilliSecond();
                        aVar2.a(bMj, aVar, cVar, "onMediaPlayerVideoEnd");
                    }
                    AppMethodBeat.o(215894);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a QG() {
                    AppMethodBeat.i(139577);
                    a aVar = new a();
                    AppMethodBeat.o(139577);
                    return aVar;
                }

                private com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e bMj() {
                    if (this.mKZ != null) {
                        return this.mKZ.cIZ;
                    }
                    return null;
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final void v(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
                    AppBrandRuntime runtime;
                    AppMethodBeat.i(139578);
                    if (aVar instanceof com.tencent.mm.plugin.appbrand.h.b) {
                        com.tencent.mm.plugin.appbrand.jsapi.f NN = aVar.NN();
                        this.currentAppId = NN.getAppId();
                        if (NN instanceof s) {
                            runtime = ((s) NN).getRuntime();
                        } else {
                            runtime = NN instanceof ac ? ((ac) NN).getRuntime() : null;
                        }
                        if (runtime != null && !"wxfe02ecfe70800f46".equalsIgnoreCase(runtime.mAppId)) {
                            Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "addOnRunningStateChangedListener");
                            runtime.kAH.a(this.mKa);
                        }
                    }
                    AppMethodBeat.o(139578);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b
                public final void w(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
                    AppBrandRuntime appBrandRuntime;
                    AppMethodBeat.i(139579);
                    if (aVar instanceof com.tencent.mm.plugin.appbrand.h.b) {
                        com.tencent.mm.plugin.appbrand.jsapi.f NN = aVar.NN();
                        if (NN instanceof s) {
                            appBrandRuntime = ((s) NN).getRuntime();
                        } else if (NN instanceof ac) {
                            appBrandRuntime = ((ac) NN).getRuntime();
                        } else {
                            appBrandRuntime = null;
                        }
                        if (appBrandRuntime != null) {
                            if (!"wxfe02ecfe70800f46".equalsIgnoreCase(appBrandRuntime.mAppId)) {
                                Log.i("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "removeOnRunningStateChangedListener");
                                appBrandRuntime.kAH.b(this.mKa);
                            }
                            Log.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease");
                            if (this.mKZ == null) {
                                Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, pluginHandler is null");
                                AppMethodBeat.o(139579);
                                return;
                            }
                            com.tencent.mm.plugin.appbrand.jsapi.ag.a aVar2 = (com.tencent.mm.plugin.appbrand.jsapi.ag.a) appBrandRuntime.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.a.class);
                            if (aVar2 == null) {
                                Log.w("MicroMsg.SameLayer.AppBrandVideoCustomHandler", "markVideoPlayerRelease, audioOfVideoBackgroundPlayManager is null");
                                AppMethodBeat.o(139579);
                                return;
                            }
                            aVar2.f(this.mKZ);
                        }
                    }
                    AppMethodBeat.o(139579);
                }
            }
