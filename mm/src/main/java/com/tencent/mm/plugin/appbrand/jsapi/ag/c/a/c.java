package com.tencent.mm.plugin.appbrand.jsapi.ag.c.a;

import android.graphics.Point;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.luggage.xweb_ext.extendplugin.component.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.i;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements g {
    public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a cFS;
    private a mKe = new a(this, (byte) 0);

    public c(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a aVar) {
        AppMethodBeat.i(177217);
        this.cFS = aVar;
        AppMethodBeat.o(177217);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.g
    public final int bIp() {
        return this.cFS.cEF;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.g
    public final int bIq() {
        return this.cFS.cEG;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.g
    public final Point bIr() {
        AppMethodBeat.i(215864);
        Point point = new Point(this.cFS.cEH, this.cFS.cEI);
        AppMethodBeat.o(215864);
        return point;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.g
    public final void a(ac acVar, final g.a aVar) {
        AppMethodBeat.i(215865);
        i jsRuntime = acVar.getJsRuntime();
        if (jsRuntime == null) {
            Log.w("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
            aVar.ef(this.cFS.cEH, this.cFS.cEI);
            AppMethodBeat.o(215865);
            return;
        }
        String str = "document.querySelector('embed[embed-id=\"" + this.cFS.getId() + "\"]').getBoundingClientRect().toJSON()";
        Log.i("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, jsScript: ".concat(String.valueOf(str)));
        jsRuntime.evaluateJavascript(str, new ValueCallback<String>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                AppMethodBeat.i(177204);
                String str2 = str;
                Log.i("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, value: ".concat(String.valueOf(str2)));
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a aVar = c.this.cFS;
                    aVar.cEH = com.tencent.mm.plugin.appbrand.ac.g.zD(jSONObject.optInt("x", aVar.cEH));
                    aVar.cEI = com.tencent.mm.plugin.appbrand.ac.g.zD(jSONObject.optInt("y", aVar.cEI));
                    Log.d(aVar.getLogTag(), "updateVideoPosition, mPosX: %d, mPosY: %d", Integer.valueOf(aVar.cEH), Integer.valueOf(aVar.cEI));
                    aVar.ef(c.this.cFS.cEH, c.this.cFS.cEI);
                    AppMethodBeat.o(177204);
                } catch (JSONException e2) {
                    Log.w("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, parse " + str2 + " failed");
                    aVar.ef(c.this.cFS.cEH, c.this.cFS.cEI);
                    AppMethodBeat.o(177204);
                }
            }
        });
        AppMethodBeat.o(215865);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.s.g
    public final com.tencent.mm.plugin.appbrand.jsapi.s.i bIs() {
        return this.mKe;
    }

    public final boolean e(Surface surface) {
        AppMethodBeat.i(215866);
        boolean e2 = this.cFS.e(surface);
        AppMethodBeat.o(215866);
        return e2;
    }

    public final boolean bU(int i2, int i3) {
        AppMethodBeat.i(215867);
        boolean bU = this.cFS.bU(i2, i3);
        AppMethodBeat.o(215867);
        return bU;
    }

    class a implements com.tencent.mm.plugin.appbrand.jsapi.s.i {
        int cEY;
        i.a mKh;
        private s mKi;

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        private a() {
            AppMethodBeat.i(177211);
            this.mKh = null;
            this.cEY = -1;
            this.mKi = new s() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c.a.AnonymousClass1 */

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.s
                public final void PL() {
                    AppMethodBeat.i(177205);
                    if (a.this.mKh != null) {
                        a.this.mKh.a(a.this);
                        AppMethodBeat.o(177205);
                        return;
                    }
                    a.this.cEY = 0;
                    AppMethodBeat.o(177205);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.s
                public final void PM() {
                    AppMethodBeat.i(177206);
                    if (a.this.mKh != null) {
                        a.this.mKh.b(a.this);
                        AppMethodBeat.o(177206);
                        return;
                    }
                    a.this.cEY = 1;
                    AppMethodBeat.o(177206);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.s
                public final void bZ(boolean z) {
                    int i2;
                    AppMethodBeat.i(177207);
                    if (a.this.mKh != null) {
                        a.this.mKh.a(a.this, z);
                        AppMethodBeat.o(177207);
                        return;
                    }
                    a aVar = a.this;
                    if (z) {
                        i2 = 2;
                    } else {
                        i2 = 3;
                    }
                    aVar.cEY = i2;
                    AppMethodBeat.o(177207);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.s
                public final void onPause() {
                    AppMethodBeat.i(177208);
                    if (a.this.mKh != null) {
                        a.this.mKh.c(a.this);
                        AppMethodBeat.o(177208);
                        return;
                    }
                    a.this.cEY = 4;
                    AppMethodBeat.o(177208);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.s
                public final void onError() {
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.s
                public final void onStop() {
                    AppMethodBeat.i(177209);
                    if (a.this.mKh != null) {
                        a.this.mKh.e(a.this);
                        AppMethodBeat.o(177209);
                        return;
                    }
                    a.this.cEY = 6;
                    AppMethodBeat.o(177209);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.s
                public final void PN() {
                    AppMethodBeat.i(177210);
                    if (a.this.mKh != null) {
                        a.this.mKh.g(a.this);
                        AppMethodBeat.o(177210);
                        return;
                    }
                    a.this.cEY = 7;
                    AppMethodBeat.o(177210);
                }
            };
            com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a aVar = c.this.cFS;
            s sVar = this.mKi;
            aVar.cEX = sVar;
            if (sVar != null) {
                switch (aVar.cEY) {
                    case 0:
                        sVar.PL();
                        AppMethodBeat.o(177211);
                        return;
                    case 1:
                        sVar.PM();
                        AppMethodBeat.o(177211);
                        return;
                    case 2:
                        sVar.PM();
                        sVar.bZ(true);
                        AppMethodBeat.o(177211);
                        return;
                    case 3:
                        sVar.PM();
                        sVar.bZ(false);
                        AppMethodBeat.o(177211);
                        return;
                    case 4:
                        sVar.onPause();
                        AppMethodBeat.o(177211);
                        return;
                    case 5:
                        sVar.onError();
                        AppMethodBeat.o(177211);
                        return;
                    case 6:
                        sVar.onStop();
                        AppMethodBeat.o(177211);
                        return;
                    case 7:
                        sVar.PN();
                        break;
                }
            }
            AppMethodBeat.o(177211);
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final String getKey() {
            AppMethodBeat.i(177212);
            String key = c.this.cFS.getKey();
            Log.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getKey, key: ".concat(String.valueOf(key)));
            AppMethodBeat.o(177212);
            return key;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final Integer bIt() {
            Integer num = null;
            AppMethodBeat.i(178853);
            com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a aVar = c.this.cFS;
            com.tencent.luggage.xweb_ext.extendplugin.a aVar2 = aVar.cED;
            if (aVar2 == null) {
                Log.w(aVar.getLogTag(), "getOriginPageViewId, invokeContext is null");
            } else {
                ac e2 = b.e(aVar2);
                if (e2 == null) {
                    Log.w(aVar.getLogTag(), "getOriginPageViewId, pageView is null");
                } else {
                    num = Integer.valueOf(e2.hashCode());
                }
            }
            Log.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getOriginPageViewId, originPageViewId: ".concat(String.valueOf(num)));
            AppMethodBeat.o(178853);
            return num;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final int getVideoWidth() {
            return -1;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final int getVideoHeight() {
            return -1;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final boolean bIu() {
            return c.this.cFS.cFc;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final void start() {
            AppMethodBeat.i(177213);
            c.this.cFS.PU();
            AppMethodBeat.o(177213);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final void pause() {
            AppMethodBeat.i(177214);
            c.this.cFS.dR("pause");
            AppMethodBeat.o(177214);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
        public final void release() {
            AppMethodBeat.i(177215);
            com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a aVar = c.this.cFS;
            if (aVar.cEP != null) {
                aVar.cEP.post(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  
                      (wrap: android.os.Handler : 0x000e: IGET  (r1v1 android.os.Handler) = (r0v1 'aVar' com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a) com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.cEP android.os.Handler)
                      (wrap: com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a$16 : 0x0012: CONSTRUCTOR  (r2v0 com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a$16) = (r0v1 'aVar' com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a) call: com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.16.<init>(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c.a.release():void, file: classes8.dex
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
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r2v0 com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a$16) = (r0v1 'aVar' com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a) call: com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.16.<init>(com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c.a.release():void, file: classes8.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 19 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 25 more
                    */
                /*
                    this = this;
                    r3 = 177215(0x2b43f, float:2.48331E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c r0 = com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c.this
                    com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a r0 = r0.cFS
                    android.os.Handler r1 = r0.cEP
                    if (r1 == 0) goto L_0x0018
                    android.os.Handler r1 = r0.cEP
                    com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a$16 r2 = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a$16
                    r2.<init>()
                    r1.post(r2)
                L_0x0018:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.c.a.release():void");
            }

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.plugin.appbrand.jsapi.s.i
            public final void a(i.a aVar) {
                AppMethodBeat.i(177216);
                this.mKh = aVar;
                if (aVar != null) {
                    switch (this.cEY) {
                        case 0:
                            aVar.a(this);
                            AppMethodBeat.o(177216);
                            return;
                        case 1:
                            aVar.b(this);
                            AppMethodBeat.o(177216);
                            return;
                        case 2:
                            aVar.b(this);
                            aVar.a((com.tencent.mm.plugin.appbrand.jsapi.s.i) this, true);
                            AppMethodBeat.o(177216);
                            return;
                        case 3:
                            aVar.b(this);
                            aVar.a((com.tencent.mm.plugin.appbrand.jsapi.s.i) this, false);
                            AppMethodBeat.o(177216);
                            return;
                        case 4:
                            aVar.c(this);
                            AppMethodBeat.o(177216);
                            return;
                        case 5:
                            aVar.d(this);
                            AppMethodBeat.o(177216);
                            return;
                        case 6:
                            aVar.e(this);
                            AppMethodBeat.o(177216);
                            return;
                        case 7:
                            aVar.g(this);
                            break;
                    }
                }
                AppMethodBeat.o(177216);
            }
        }
    }
