package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ad;
import com.tencent.mm.modelappbrand.af;
import com.tencent.mm.modelappbrand.ag;
import com.tencent.mm.modelappbrand.ah;
import com.tencent.mm.modelappbrand.ai;
import com.tencent.mm.modelappbrand.aj;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.y;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.dynamic.a;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.bp;
import com.tencent.mm.plugin.appbrand.widget.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveConstants;
import org.json.JSONArray;

public class IPCDynamicPageView extends LinearLayout implements p, a, h {
    public static MMHandler llG = new MMHandler("WxaWidget#UIActionThread");
    private static LinearLayout.LayoutParams lpT = new LinearLayout.LayoutParams(-1, -1);
    public String gIx;
    public volatile boolean gPl;
    private long kZb;
    private e llL;
    private Bundle lpM;
    private com.tencent.mm.plugin.appbrand.dynamic.a lpN;
    public ab lpO;
    public long lpP;
    private a lpQ;
    private Runnable lpR = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.AnonymousClass1 */

        public final void run() {
            int i2 = 1;
            AppMethodBeat.i(121519);
            if (!IPCDynamicPageView.this.gPl) {
                IPCDynamicPageView.this.gPl = true;
                IPCDynamicPageView.b(IPCDynamicPageView.this);
                long currentTimeMillis = System.currentTimeMillis() - IPCDynamicPageView.this.lpP;
                if (currentTimeMillis <= 1000) {
                    i2 = 0;
                } else if (currentTimeMillis > 2000) {
                    if (currentTimeMillis <= 3000) {
                        i2 = 2;
                    } else if (currentTimeMillis <= 4000) {
                        i2 = 3;
                    } else if (currentTimeMillis <= 5000) {
                        i2 = 4;
                    } else if (currentTimeMillis <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
                        i2 = 5;
                    } else if (currentTimeMillis <= 7000) {
                        i2 = 6;
                    } else if (currentTimeMillis <= 8000) {
                        i2 = 7;
                    } else if (currentTimeMillis <= 9000) {
                        i2 = 8;
                    } else {
                        i2 = currentTimeMillis <= 10000 ? 9 : 10;
                    }
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(645, (long) i2, 1, false);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(645, 11, 1, false);
                IPCDynamicPageView.this.ws(TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY);
            }
            IPCDynamicPageView.this.kZb = System.currentTimeMillis();
            IPCDynamicPageView.this.lpQ.bzg();
            AppMethodBeat.o(121519);
        }
    };
    private Runnable lpS = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(121520);
            String str = IPCDynamicPageView.this.gIx;
            if (Util.isNullOrNil(str)) {
                Log.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
                AppMethodBeat.o(121520);
                return;
            }
            IPCDynamicPageView.this.mDetached = true;
            com.tencent.mm.plugin.appbrand.dynamic.a aVar = IPCDynamicPageView.this.lpN;
            if (str == null || str.length() == 0) {
                Log.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", Integer.valueOf(aVar.hashCode()));
            } else {
                Log.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", Integer.valueOf(aVar.hashCode()), str);
                Bundle bundle = new Bundle();
                bundle.putString("id", str);
                com.tencent.mm.ipcinvoker.h.a(i.bBL().Yn(str), bundle, a.b.class, 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00be: INVOKE  
                      (wrap: java.lang.String : 0x00b3: INVOKE  (r3v4 java.lang.String) = 
                      (wrap: com.tencent.mm.plugin.appbrand.dynamic.i : 0x00af: INVOKE  (r3v3 com.tencent.mm.plugin.appbrand.dynamic.i) =  type: STATIC call: com.tencent.mm.plugin.appbrand.dynamic.i.bBL():com.tencent.mm.plugin.appbrand.dynamic.i)
                      (r0v1 'str' java.lang.String)
                     type: VIRTUAL call: com.tencent.mm.plugin.appbrand.dynamic.i.Yn(java.lang.String):java.lang.String)
                      (r2v4 'bundle' android.os.Bundle)
                      (wrap: java.lang.Class : 0x00b7: CONST_CLASS   com.tencent.mm.plugin.appbrand.dynamic.a$b.class)
                      (wrap: com.tencent.mm.plugin.appbrand.dynamic.a$2 : 0x00bb: CONSTRUCTOR  (r5v2 com.tencent.mm.plugin.appbrand.dynamic.a$2) = (r1v3 'aVar' com.tencent.mm.plugin.appbrand.dynamic.a), (r0v1 'str' java.lang.String) call: com.tencent.mm.plugin.appbrand.dynamic.a.2.<init>(com.tencent.mm.plugin.appbrand.dynamic.a, java.lang.String):void type: CONSTRUCTOR)
                     type: STATIC call: com.tencent.mm.ipcinvoker.h.a(java.lang.String, android.os.Parcelable, java.lang.Class, com.tencent.mm.ipcinvoker.d):boolean in method: com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.2.run():void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00bb: CONSTRUCTOR  (r5v2 com.tencent.mm.plugin.appbrand.dynamic.a$2) = (r1v3 'aVar' com.tencent.mm.plugin.appbrand.dynamic.a), (r0v1 'str' java.lang.String) call: com.tencent.mm.plugin.appbrand.dynamic.a.2.<init>(com.tencent.mm.plugin.appbrand.dynamic.a, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.2.run():void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 23 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.dynamic.a, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 29 more
                    */
                /*
                // Method dump skipped, instructions count: 242
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.AnonymousClass2.run():void");
            }
        };
        private volatile boolean mDetached;

        static /* synthetic */ void b(IPCDynamicPageView iPCDynamicPageView) {
            AppMethodBeat.i(121564);
            iPCDynamicPageView.wr(4);
            AppMethodBeat.o(121564);
        }

        static {
            AppMethodBeat.i(121566);
            AppMethodBeat.o(121566);
        }

        public IPCDynamicPageView(Context context) {
            super(context);
            AppMethodBeat.i(121526);
            init(context);
            AppMethodBeat.o(121526);
        }

        public IPCDynamicPageView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            AppMethodBeat.i(121527);
            init(context);
            AppMethodBeat.o(121527);
        }

        public IPCDynamicPageView(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            AppMethodBeat.i(121528);
            init(context);
            AppMethodBeat.o(121528);
        }

        private void init(Context context) {
            AppMethodBeat.i(121529);
            this.lpN = new com.tencent.mm.plugin.appbrand.dynamic.a(this);
            View cU = b.cU(context);
            addView(cU, lpT);
            this.lpQ = (com.tencent.mm.plugin.appbrand.canvas.widget.a) cU;
            this.lpQ.setTraceId(this.gIx);
            AppMethodBeat.o(121529);
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.h
        public final void d(final String str, final String str2, final Bundle bundle) {
            AppMethodBeat.i(121530);
            llG.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(121522);
                    String str = "";
                    if (bundle != null) {
                        str = bundle.getString("cache_key", "");
                    }
                    u.i("MicroMsg.IPCDynamicPageView", "prepare(%s, %s)", str, str2);
                    IPCDynamicPageView.this.llL = b.YE(str);
                    if (IPCDynamicPageView.this.llL == null) {
                        IPCDynamicPageView.this.llL = new e();
                    }
                    IPCDynamicPageView.this.llL.field_id = str;
                    IPCDynamicPageView.this.llL.field_cacheKey = str;
                    IPCDynamicPageView.this.llL.field_appId = u.Lv(IPCDynamicPageView.this.gIx);
                    IPCDynamicPageView.this.getDrawContext().hpn.l("id", str);
                    com.tencent.mm.plugin.appbrand.dynamic.e.bBI().c(str, IPCDynamicPageView.this);
                    if (bundle != null) {
                        bundle.putBundle("__env_args", IPCDynamicPageView.b(IPCDynamicPageView.this, bundle));
                    }
                    com.tencent.mm.plugin.appbrand.dynamic.a unused = IPCDynamicPageView.this.lpN;
                    String str2 = str;
                    String str3 = str2;
                    Bundle bundle = bundle;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("id", str2);
                    bundle2.putString("appId", str3);
                    bundle2.putBundle("extData", bundle);
                    u.i("MicroMsg.DynamicIPCJsBridge", "before IPCInvoke_AttachTo invoke", new Object[0]);
                    com.tencent.mm.ipcinvoker.h.a(i.bBL().Yn(str2), bundle2, a.C0569a.class, null);
                    AppMethodBeat.o(121522);
                }
            });
            AppMethodBeat.o(121530);
        }

        public final void detach() {
            AppMethodBeat.i(121531);
            if (com.tencent.f.j.a.hmE() == llG.getSerial()) {
                this.lpS.run();
                AppMethodBeat.o(121531);
                return;
            }
            llG.post(this.lpS);
            AppMethodBeat.o(121531);
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.h
        public final void cleanup() {
            AppMethodBeat.i(121532);
            if (this.llL != null) {
                Log.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s, %s, %s, %s)", this.gIx, this.llL.field_id, this.llL.field_appId, this.llL.field_cacheKey);
            } else {
                Log.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s)", this.gIx);
            }
            bzh();
            AppMethodBeat.o(121532);
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.h
        public final void wm(int i2) {
            AppMethodBeat.i(121533);
            wr(i2);
            detach();
            AppMethodBeat.o(121533);
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.h
        public final void bBK() {
            AppMethodBeat.i(121534);
            if (this.lpO == null) {
                AppMethodBeat.o(121534);
                return;
            }
            ag agVar = (ag) this.lpO.LA("onUiUpdate");
            if (agVar == null) {
                AppMethodBeat.o(121534);
                return;
            }
            agVar.aXW();
            AppMethodBeat.o(121534);
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.h
        public final void b(String str, t tVar) {
            AppMethodBeat.i(121535);
            if (this.lpO == null) {
                tVar.b(false, "listener is null", null);
                AppMethodBeat.o(121535);
                return;
            }
            ad adVar = (ad) this.lpO.LA(bp.NAME);
            if (adVar == null) {
                tVar.b(false, "listener is null", null);
                AppMethodBeat.o(121535);
                return;
            }
            adVar.LB(str);
            AppMethodBeat.o(121535);
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.h
        public final void c(String str, t tVar) {
            AppMethodBeat.i(121536);
            if (this.lpO == null) {
                tVar.b(false, "listener is null", null);
                AppMethodBeat.o(121536);
                return;
            }
            ai aiVar = (ai) this.lpO.LA("onSearchWAWidgetReloadData");
            if (aiVar == null) {
                tVar.b(false, "listener is null", null);
                AppMethodBeat.o(121536);
                return;
            }
            aiVar.LD(str);
            AppMethodBeat.o(121536);
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.h
        public final void a(String str, t tVar) {
            AppMethodBeat.i(121537);
            if (this.lpO == null) {
                tVar.b(false, "listener is null", null);
                AppMethodBeat.o(121537);
                return;
            }
            ah ahVar = (ah) this.lpO.LA("openApp");
            if (ahVar == null) {
                tVar.b(false, "listener is null", null);
                AppMethodBeat.o(121537);
                return;
            }
            ahVar.LC(str);
            AppMethodBeat.o(121537);
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.h
        public final void a(boolean z, String str, boolean z2, t tVar) {
            AppMethodBeat.i(121538);
            if (this.lpO == null) {
                tVar.b(false, "listener is null", null);
                AppMethodBeat.o(121538);
                return;
            }
            af afVar = (af) this.lpO.LA("OnTapCallback");
            if (afVar == null) {
                tVar.b(false, "listener is null", null);
                AppMethodBeat.o(121538);
                return;
            }
            afVar.b(z, str, z2);
            AppMethodBeat.o(121538);
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.h
        public final void a(String str, String str2, t tVar) {
            AppMethodBeat.i(121539);
            if (this.lpO == null) {
                tVar.b(false, "listener is null", null);
                AppMethodBeat.o(121539);
                return;
            }
            y yVar = (y) this.lpO.LA("showPicker");
            if (yVar == null) {
                tVar.b(false, "listener is null", null);
                AppMethodBeat.o(121539);
                return;
            }
            yVar.a(str, str2, tVar);
            AppMethodBeat.o(121539);
        }

        @Override // com.tencent.mm.plugin.appbrand.dynamic.h
        public final void b(int i2, t tVar) {
            AppMethodBeat.i(121540);
            if (this.lpO == null) {
                tVar.b(false, "listener is null", null);
                AppMethodBeat.o(121540);
                return;
            }
            aj ajVar = (aj) this.lpO.LA("setWidgetSize");
            if (ajVar == null) {
                tVar.b(false, "listener is null", null);
                AppMethodBeat.o(121540);
                return;
            }
            ajVar.a(i2, tVar);
            AppMethodBeat.o(121540);
        }

        @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
        public final boolean o(Canvas canvas) {
            AppMethodBeat.i(121541);
            boolean o = this.lpQ.o(canvas);
            AppMethodBeat.o(121541);
            return o;
        }

        @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
        public final void bzg() {
            AppMethodBeat.i(121542);
            long currentTimeMillis = System.currentTimeMillis() - this.kZb;
            llG.removeCallbacks(this.lpR);
            if (currentTimeMillis < 12) {
                llG.postDelayed(this.lpR, currentTimeMillis);
                AppMethodBeat.o(121542);
                return;
            }
            this.lpR.run();
            AppMethodBeat.o(121542);
        }

        @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
        public final void a(JSONArray jSONArray, a.AbstractC0561a aVar) {
            AppMethodBeat.i(121543);
            this.lpQ.a(jSONArray, aVar);
            AppMethodBeat.o(121543);
        }

        @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
        public final void b(JSONArray jSONArray, a.AbstractC0561a aVar) {
            AppMethodBeat.i(121544);
            this.lpQ.b(jSONArray, aVar);
            AppMethodBeat.o(121544);
        }

        @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
        public final void a(DrawCanvasArg drawCanvasArg, a.AbstractC0561a aVar) {
            AppMethodBeat.i(121545);
            this.lpQ.a(drawCanvasArg, aVar);
            AppMethodBeat.o(121545);
        }

        @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
        public final void b(DrawCanvasArg drawCanvasArg, a.AbstractC0561a aVar) {
            AppMethodBeat.i(121546);
            this.lpQ.b(drawCanvasArg, aVar);
            AppMethodBeat.o(121546);
        }

        @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
        public final void bzh() {
            AppMethodBeat.i(121547);
            this.lpQ.bzh();
            AppMethodBeat.o(121547);
        }

        @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
        public final void U(Runnable runnable) {
            AppMethodBeat.i(121548);
            this.lpQ.U(runnable);
            AppMethodBeat.o(121548);
        }

        @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
        public d getDrawContext() {
            AppMethodBeat.i(121549);
            d drawContext = this.lpQ.getDrawContext();
            AppMethodBeat.o(121549);
            return drawContext;
        }

        @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
        public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a aVar) {
            AppMethodBeat.i(121550);
            this.lpQ.setDrawActionReportable(aVar);
            AppMethodBeat.o(121550);
        }

        @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
        public void setTraceId(String str) {
            AppMethodBeat.i(121551);
            this.lpQ.setTraceId(str);
            AppMethodBeat.o(121551);
        }

        @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
        public String getTraceId() {
            AppMethodBeat.i(121552);
            String traceId = this.lpQ.getTraceId();
            AppMethodBeat.o(121552);
            return traceId;
        }

        public final void onPause() {
            AppMethodBeat.i(121553);
            Log.i("MicroMsg.IPCDynamicPageView", "onPause(%s)", this.gIx);
            llG.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(121523);
                    com.tencent.mm.plugin.appbrand.dynamic.a unused = IPCDynamicPageView.this.lpN;
                    String str = IPCDynamicPageView.this.gIx;
                    Bundle bundle = new Bundle();
                    bundle.putString("id", str);
                    com.tencent.mm.ipcinvoker.h.a(i.bBL().Yn(str), bundle, a.d.class, null);
                    AppMethodBeat.o(121523);
                }
            });
            AppMethodBeat.o(121553);
        }

        @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
        public final void onResume() {
            AppMethodBeat.i(121554);
            Log.i("MicroMsg.IPCDynamicPageView", "onResume(%s)", this.gIx);
            this.lpQ.onResume();
            llG.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(121524);
                    com.tencent.mm.plugin.appbrand.dynamic.a unused = IPCDynamicPageView.this.lpN;
                    String str = IPCDynamicPageView.this.gIx;
                    Bundle bundle = new Bundle();
                    bundle.putString("id", str);
                    com.tencent.mm.ipcinvoker.h.a(i.bBL().Yn(str), bundle, a.e.class, null);
                    AppMethodBeat.o(121524);
                }
            });
            AppMethodBeat.o(121554);
        }

        @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
        public final boolean isPaused() {
            AppMethodBeat.i(121555);
            boolean isPaused = this.lpQ.isPaused();
            AppMethodBeat.o(121555);
            return isPaused;
        }

        @Override // com.tencent.mm.plugin.appbrand.collector.g
        public String getSessionId() {
            AppMethodBeat.i(121556);
            String sessionId = this.lpQ.getSessionId();
            AppMethodBeat.o(121556);
            return sessionId;
        }

        @Override // com.tencent.mm.plugin.appbrand.collector.g
        public void setSessionId(String str) {
            AppMethodBeat.i(121557);
            this.lpQ.setSessionId(str);
            AppMethodBeat.o(121557);
        }

        @Override // com.tencent.mm.plugin.appbrand.collector.d
        public void setStartTime(long j2) {
            AppMethodBeat.i(121558);
            this.lpQ.setStartTime(j2);
            AppMethodBeat.o(121558);
        }

        @Override // com.tencent.mm.plugin.appbrand.collector.d
        public final void bzi() {
            AppMethodBeat.i(121559);
            this.lpQ.bzi();
            AppMethodBeat.o(121559);
        }

        public String getExtId() {
            return this.gIx;
        }

        public Bundle getExtData() {
            return this.lpM;
        }

        /* access modifiers changed from: protected */
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(121560);
            super.onSizeChanged(i2, i3, i4, i5);
            Log.i("MicroMsg.IPCDynamicPageView", "onSizeChanged(w : %d, h : %d, oldw : %d, oldh : %d)", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            Bundle bundle = new Bundle();
            bundle.putInt("__page_view_width", i2);
            bundle.putInt("__page_view_height", i3);
            String str = this.gIx;
            Bundle bundle2 = new Bundle();
            bundle2.putString("id", str);
            bundle2.putBundle("__env_args", bundle);
            com.tencent.mm.ipcinvoker.h.a(i.bBL().Yn(str), bundle2, a.g.class, null);
            AppMethodBeat.o(121560);
        }

        private void wr(final int i2) {
            AppMethodBeat.i(121561);
            if (this.lpO == null) {
                Log.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener wrapper is null.", this.gIx, Integer.valueOf(i2));
                AppMethodBeat.o(121561);
                return;
            }
            final com.tencent.mm.modelappbrand.h aXU = this.lpO.aXU();
            if (aXU == null) {
                Log.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener is null.", this.gIx, Integer.valueOf(i2));
                AppMethodBeat.o(121561);
            } else if (Looper.getMainLooper() == Looper.myLooper()) {
                aXU.L(this, i2);
                AppMethodBeat.o(121561);
            } else {
                com.tencent.mm.plugin.appbrand.dynamic.b.V(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(121525);
                        aXU.L(IPCDynamicPageView.this, i2);
                        AppMethodBeat.o(121525);
                    }
                });
                AppMethodBeat.o(121561);
            }
        }

        @Override // com.tencent.mm.modelappbrand.p
        public final boolean aW(String str, String str2) {
            AppMethodBeat.i(121562);
            com.tencent.mm.plugin.appbrand.dynamic.a aVar = this.lpN;
            String str3 = this.gIx;
            if (aVar.gIx == null || aVar.gIx.length() == 0 || str == null || str.length() == 0) {
                AppMethodBeat.o(121562);
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString("id", str3);
            bundle.putString("event", str);
            bundle.putString("data", str2);
            IPCBoolean iPCBoolean = (IPCBoolean) com.tencent.mm.ipcinvoker.h.a(i.bBL().Yn(str3), bundle, a.f.class);
            if (iPCBoolean != null) {
                boolean z = iPCBoolean.value;
                AppMethodBeat.o(121562);
                return z;
            }
            AppMethodBeat.o(121562);
            return false;
        }

        public final void ws(int i2) {
            AppMethodBeat.i(121563);
            this.lpN.bE(this.gIx, i2);
            AppMethodBeat.o(121563);
        }

        static /* synthetic */ Bundle b(IPCDynamicPageView iPCDynamicPageView, Bundle bundle) {
            AppMethodBeat.i(121565);
            Bundle bundle2 = new Bundle();
            bundle2.putString("__page_view_id", iPCDynamicPageView.gIx);
            bundle2.putString("__process_name", MMApplicationContext.getProcessName());
            bundle2.putInt("__draw_strategy", bundle.getInt("draw_strategy", 0));
            int measuredWidth = iPCDynamicPageView.getMeasuredWidth();
            int measuredHeight = iPCDynamicPageView.getMeasuredHeight();
            if ((measuredWidth == 0 || measuredHeight == 0) && bundle != null) {
                measuredWidth = bundle.getInt("view_init_width");
                measuredHeight = bundle.getInt("view_init_height");
            }
            bundle2.putInt("__page_view_width", measuredWidth);
            bundle2.putInt("__page_view_height", measuredHeight);
            if (!(iPCDynamicPageView.llL == null || iPCDynamicPageView.llL.field_appId == null)) {
                bundle2.putString("__page_app_id", iPCDynamicPageView.llL.field_appId);
            }
            AppMethodBeat.o(121565);
            return bundle2;
        }
    }
