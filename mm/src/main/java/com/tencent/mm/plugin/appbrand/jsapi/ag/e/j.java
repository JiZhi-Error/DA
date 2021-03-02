package com.tencent.mm.plugin.appbrand.jsapi.ag.e;

import android.graphics.Point;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.luggage.xweb_ext.extendplugin.component.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.d;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class j implements g {
    public final c cJT;
    a mLl = new a(this, (byte) 0);

    public j(c cVar) {
        AppMethodBeat.i(177243);
        this.cJT = cVar;
        cVar.cJC = new com.tencent.luggage.xweb_ext.extendplugin.component.video.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.j.AnonymousClass1 */

            @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.a
            public final void bZ(int i2, int i3) {
                AppMethodBeat.i(177222);
                if (j.this.mLl.mKh != null) {
                    float f2 = (((float) i2) * 100.0f) / ((float) i3);
                    int i4 = i3 - i2;
                    if (f2 < 99.0f || i4 > 1000) {
                        j.this.mLl.mKh.a(j.this.mLl, f2);
                    } else {
                        j.this.mLl.mKh.f(j.this.mLl);
                        AppMethodBeat.o(177222);
                        return;
                    }
                }
                AppMethodBeat.o(177222);
            }
        };
        if (cVar.cIW != null) {
            cVar.cIW.a(cVar.cJC);
        }
        AnonymousClass2 r0 = new s() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.j.AnonymousClass2 */

            @Override // com.tencent.luggage.xweb_ext.extendplugin.component.s
            public final void PL() {
                AppMethodBeat.i(177223);
                if (j.this.mLl.mKh != null) {
                    Log.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoading from XWebOnPlayListener");
                    j.this.mLl.mKh.a(j.this.mLl);
                }
                AppMethodBeat.o(177223);
            }

            @Override // com.tencent.luggage.xweb_ext.extendplugin.component.s
            public final void PM() {
                AppMethodBeat.i(177224);
                if (j.this.mLl.mKh != null) {
                    Log.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoadEnd from XWebOnPlayListener");
                    j.this.mLl.mKh.b(j.this.mLl);
                }
                AppMethodBeat.o(177224);
            }

            @Override // com.tencent.luggage.xweb_ext.extendplugin.component.s
            public final void bZ(boolean z) {
                AppMethodBeat.i(177225);
                if (j.this.mLl.mKh != null) {
                    j.this.mLl.mKh.a(j.this.mLl, z);
                }
                AppMethodBeat.o(177225);
            }

            @Override // com.tencent.luggage.xweb_ext.extendplugin.component.s
            public final void onPause() {
                AppMethodBeat.i(177226);
                if (j.this.mLl.mKh != null) {
                    j.this.mLl.mKh.c(j.this.mLl);
                }
                AppMethodBeat.o(177226);
            }

            @Override // com.tencent.luggage.xweb_ext.extendplugin.component.s
            public final void onError() {
                AppMethodBeat.i(177227);
                if (j.this.mLl.mKh != null) {
                    j.this.mLl.mKh.d(j.this.mLl);
                }
                AppMethodBeat.o(177227);
            }

            @Override // com.tencent.luggage.xweb_ext.extendplugin.component.s
            public final void onStop() {
                AppMethodBeat.i(177228);
                if (j.this.mLl.mKh != null) {
                    j.this.mLl.mKh.e(j.this.mLl);
                }
                AppMethodBeat.o(177228);
            }

            @Override // com.tencent.luggage.xweb_ext.extendplugin.component.s
            public final void PN() {
                AppMethodBeat.i(177229);
                if (j.this.mLl.mKh != null) {
                    j.this.mLl.mKh.g(j.this.mLl);
                }
                AppMethodBeat.o(177229);
            }
        };
        cVar.cEX = r0;
        if (cVar.cIW != null) {
            cVar.cIW.a(r0);
        }
        AppMethodBeat.o(177243);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.g
    public final int bIp() {
        AppMethodBeat.i(177244);
        c cVar = this.cJT;
        int i2 = (int) (cVar.cJD * ((float) cVar.cEF));
        Log.d(cVar.getLogTag(), "getVideoContainerWidth, videoContainerWidth: ".concat(String.valueOf(i2)));
        AppMethodBeat.o(177244);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.g
    public final int bIq() {
        AppMethodBeat.i(177245);
        c cVar = this.cJT;
        int i2 = (int) (cVar.cJE * ((float) cVar.cEG));
        Log.d(cVar.getLogTag(), "getVideoContainerHeight, videoContainerHeight: ".concat(String.valueOf(i2)));
        AppMethodBeat.o(177245);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.g
    public final Point bIr() {
        AppMethodBeat.i(215902);
        Point point = new Point(this.cJT.Qy(), this.cJT.Qz());
        AppMethodBeat.o(215902);
        return point;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.g
    public final void a(ac acVar, final g.a aVar) {
        AppMethodBeat.i(215903);
        i jsRuntime = acVar.getJsRuntime();
        if (jsRuntime == null) {
            Log.w("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
            aVar.ef(this.cJT.Qy(), this.cJT.Qz());
            AppMethodBeat.o(215903);
            return;
        }
        String str = "document.querySelector('embed[embed-id=\"" + this.cJT.getId() + "\"]').getBoundingClientRect().toJSON()";
        Log.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
        jsRuntime.evaluateJavascript(str, new ValueCallback<String>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.j.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                AppMethodBeat.i(177230);
                String str2 = str;
                Log.i("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, value: ".concat(String.valueOf(str2)));
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    c cVar = j.this.cJT;
                    cVar.cEH = com.tencent.mm.plugin.appbrand.ac.g.zD(jSONObject.optInt("x", cVar.cEH));
                    cVar.cEI = com.tencent.mm.plugin.appbrand.ac.g.zD(jSONObject.optInt("y", cVar.cEI));
                    Log.d(cVar.getLogTag(), "updateVideoPosition, mPosX: %d, mPosY: %d", Integer.valueOf(cVar.cEH), Integer.valueOf(cVar.cEI));
                    aVar.ef(j.this.cJT.Qy(), j.this.cJT.Qz());
                    AppMethodBeat.o(177230);
                } catch (JSONException e2) {
                    Log.w("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, parse " + str2 + " failed");
                    aVar.ef(j.this.cJT.Qy(), j.this.cJT.Qz());
                    AppMethodBeat.o(177230);
                }
            }
        });
        AppMethodBeat.o(215903);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.g
    public final com.tencent.mm.plugin.appbrand.jsapi.s.i bIs() {
        return this.mLl;
    }

    public final d bMm() {
        com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar = this.cJT.cIV;
        if (!(cVar instanceof d)) {
            return null;
        }
        return (d) cVar;
    }

    public final boolean e(Surface surface) {
        AppMethodBeat.i(215904);
        boolean e2 = this.cJT.e(surface);
        AppMethodBeat.o(215904);
        return e2;
    }

    class a implements com.tencent.mm.plugin.appbrand.jsapi.s.i {
        final String cDW;
        i.a mKh;
        volatile boolean mLn;
        c.g mLo;
        c.h mLp;
        c.b mLq;

        private a() {
            AppMethodBeat.i(177235);
            this.cDW = "MicroMsg.AppBrand.XWebVideoVideoController#" + hashCode();
            this.mKh = null;
            this.mLn = false;
            this.mLo = new c.g() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.j.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.g
                public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar) {
                    AppMethodBeat.i(215899);
                    a.this.mLn = true;
                    if (a.this.mKh != null) {
                        Log.i(a.this.cDW, "onLoadEnd from OnPreparedListener");
                        a.this.mKh.b(a.this);
                    }
                    AppMethodBeat.o(215899);
                }
            };
            this.mLp = new c.h() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.j.a.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.h
                public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar) {
                    AppMethodBeat.i(215900);
                    if (a.this.mKh != null) {
                        Log.i(a.this.cDW, "onLoadEnd from OnSeekCompleteListener");
                        a.this.mKh.b(a.this);
                        a.this.mKh.a((com.tencent.mm.plugin.appbrand.jsapi.s.i) a.this, false);
                    }
                    AppMethodBeat.o(215900);
                }
            };
            this.mLq = new c.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.j.a.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.b
                public final void QA() {
                    AppMethodBeat.i(215901);
                    if (a.this.mKh != null) {
                        a.this.mKh.g(a.this);
                    }
                    AppMethodBeat.o(215901);
                }
            };
            com.tencent.luggage.xweb_ext.extendplugin.component.video.c cVar = j.this.cJT;
            AnonymousClass4 r1 = new c.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.e.j.a.AnonymousClass4 */

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.video.c.b
                public final void cf(boolean z) {
                    AppMethodBeat.i(177234);
                    d bMm = j.this.bMm();
                    if (bMm == null) {
                        AppMethodBeat.o(177234);
                        return;
                    }
                    a.this.mLn = z;
                    bMm.b(a.this.mLo);
                    bMm.b(a.this.mLp);
                    bMm.b(a.this.mLq);
                    AppMethodBeat.o(177234);
                }
            };
            cVar.cJB = r1;
            if (cVar.cIV != null) {
                r1.cf(cVar.cJj);
            }
            AppMethodBeat.o(177235);
        }

        /* synthetic */ a(j jVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final String getKey() {
            AppMethodBeat.i(177236);
            String key = j.this.cJT.getKey();
            AppMethodBeat.o(177236);
            return key;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final Integer bIt() {
            Integer num = null;
            AppMethodBeat.i(178858);
            com.tencent.luggage.xweb_ext.extendplugin.component.video.c cVar = j.this.cJT;
            com.tencent.luggage.xweb_ext.extendplugin.a aVar = cVar.cED;
            if (aVar == null) {
                Log.w(cVar.getLogTag(), "getOriginPageViewId, invokeContext is null");
            } else {
                ac e2 = b.e(aVar);
                if (e2 == null) {
                    Log.w(cVar.getLogTag(), "getOriginPageViewId, pageView is null");
                } else {
                    num = Integer.valueOf(e2.hashCode());
                }
            }
            Log.d("MicroMsg.AppBrand.XWebVideoVideoController", "getOriginPageViewId, originPageViewId: ".concat(String.valueOf(num)));
            AppMethodBeat.o(178858);
            return num;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final int getVideoWidth() {
            AppMethodBeat.i(177237);
            d bMm = j.this.bMm();
            if (bMm == null) {
                AppMethodBeat.o(177237);
                return 0;
            }
            int videoWidth = bMm.getVideoWidth();
            AppMethodBeat.o(177237);
            return videoWidth;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final int getVideoHeight() {
            AppMethodBeat.i(177238);
            d bMm = j.this.bMm();
            if (bMm == null) {
                AppMethodBeat.o(177238);
                return 0;
            }
            int videoHeight = bMm.getVideoHeight();
            AppMethodBeat.o(177238);
            return videoHeight;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final boolean bIu() {
            return j.this.cJT.cFc;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final void start() {
            AppMethodBeat.i(177239);
            Log.d(this.cDW, "start");
            j.this.cJT.PU();
            AppMethodBeat.o(177239);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final void pause() {
            AppMethodBeat.i(177240);
            Log.d(this.cDW, "pause");
            j.this.cJT.Qs();
            AppMethodBeat.o(177240);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final void release() {
            AppMethodBeat.i(177241);
            Log.d(this.cDW, "release");
            com.tencent.luggage.xweb_ext.extendplugin.component.video.c cVar = j.this.cJT;
            cVar.k(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0017: INVOKE  
                  (r0v2 'cVar' com.tencent.luggage.xweb_ext.extendplugin.component.video.c)
                  (wrap: com.tencent.luggage.xweb_ext.extendplugin.component.video.c$26 : 0x0014: CONSTRUCTOR  (r1v1 com.tencent.luggage.xweb_ext.extendplugin.component.video.c$26) = (r0v2 'cVar' com.tencent.luggage.xweb_ext.extendplugin.component.video.c) call: com.tencent.luggage.xweb_ext.extendplugin.component.video.c.26.<init>(com.tencent.luggage.xweb_ext.extendplugin.component.video.c):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.luggage.xweb_ext.extendplugin.component.video.c.k(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.appbrand.jsapi.ag.e.j.a.release():void, file: classes8.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: CONSTRUCTOR  (r1v1 com.tencent.luggage.xweb_ext.extendplugin.component.video.c$26) = (r0v2 'cVar' com.tencent.luggage.xweb_ext.extendplugin.component.video.c) call: com.tencent.luggage.xweb_ext.extendplugin.component.video.c.26.<init>(com.tencent.luggage.xweb_ext.extendplugin.component.video.c):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.jsapi.ag.e.j.a.release():void, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.luggage.xweb_ext.extendplugin.component.video.c, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
                this = this;
                r2 = 177241(0x2b459, float:2.48368E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                java.lang.String r0 = r3.cDW
                java.lang.String r1 = "release"
                com.tencent.mm.sdk.platformtools.Log.d(r0, r1)
                com.tencent.mm.plugin.appbrand.jsapi.ag.e.j r0 = com.tencent.mm.plugin.appbrand.jsapi.ag.e.j.this
                com.tencent.luggage.xweb_ext.extendplugin.component.video.c r0 = r0.cJT
                com.tencent.luggage.xweb_ext.extendplugin.component.video.c$26 r1 = new com.tencent.luggage.xweb_ext.extendplugin.component.video.c$26
                r1.<init>()
                r0.k(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ag.e.j.a.release():void");
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final void a(i.a aVar) {
            AppMethodBeat.i(177242);
            if (aVar != null) {
                if (!this.mLn) {
                    Log.i(this.cDW, "onLoading from mPrepared");
                    aVar.a(this);
                } else {
                    Log.i(this.cDW, "onLoadEnd from mPrepared");
                    aVar.b(this);
                }
            }
            this.mKh = aVar;
            AppMethodBeat.o(177242);
        }
    }
}
