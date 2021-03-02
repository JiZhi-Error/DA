package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.xx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements a {
    List<a> EDW = new ArrayList();
    protected FrameLayout EeM;
    TopStoryViewPager GkA;
    View GkB;
    int GkC = 0;
    boolean GkD = false;
    boolean GkE = true;
    private boolean GkF;
    private boolean GkG;
    private boolean GkH;
    protected IListener<xx> GkI = new IListener<xx>() {
        /* class com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass5 */

        {
            AppMethodBeat.i(161623);
            this.__eventId = xx.class.getName().hashCode();
            AppMethodBeat.o(161623);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xx xxVar) {
            AppMethodBeat.i(125924);
            xx xxVar2 = xxVar;
            switch (xxVar2.eei.actionType) {
                case 1:
                    xxVar2.eej.eek = true;
                    break;
                case 2:
                    b.this.Gkn.finish();
                    break;
                case 3:
                    xxVar2.eej.eel = b.this.eel;
                    break;
            }
            AppMethodBeat.o(125924);
            return true;
        }
    };
    protected e.a GkJ = new e.a() {
        /* class com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.topstory.a.e.a
        public final void a(final int i2, String str, final String str2, int i3, int i4, String str3) {
            AppMethodBeat.i(125930);
            if (b.this.Gkr != null) {
                b.this.Gkr.c(str, str2, i3, i4, i2, str3);
            }
            for (final c.b bVar : b.this.Gku) {
                if (bVar.category == 110) {
                    b.this.Gkn.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(125925);
                            bVar.cA(i2, str2);
                            AppMethodBeat.o(125925);
                        }
                    });
                    if (!b.this.dLD) {
                        ar.a(((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxw(), 107, 2, i2, 0, "");
                    }
                }
            }
            AppMethodBeat.o(125930);
        }

        @Override // com.tencent.mm.plugin.topstory.a.e.a
        public final void p(final String str, long j2, int i2) {
            AppMethodBeat.i(236383);
            if (b.this.Gkr != null) {
                b.this.Gkr.q(str, j2, i2);
            }
            Iterator<c.b> it = b.this.Gku.iterator();
            if (it.hasNext()) {
                final c.b next = it.next();
                if (next.category == 110) {
                    b.this.Gkn.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass6.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(125926);
                            next.cB(1, str);
                            AppMethodBeat.o(125926);
                        }
                    });
                    if (!b.this.dLD && next.Gkd <= 0) {
                        ar.a(((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxo(), 107, 1, 0, 0, "");
                    }
                }
            }
            AppMethodBeat.o(236383);
        }

        @Override // com.tencent.mm.plugin.topstory.a.e.a
        public final void a(final int i2, String str, final String str2, int i3, int i4, String str3, boolean z) {
            AppMethodBeat.i(125932);
            if (z && b.this.Gkr != null) {
                b.this.Gkr.c(str, str2, i3, i4, i2, str3);
            }
            Iterator<c.b> it = b.this.Gku.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                final c.b next = it.next();
                if (next.category == 110) {
                    b.this.Gkn.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass6.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(125927);
                            next.cA(i2, str2);
                            AppMethodBeat.o(125927);
                        }
                    });
                    if (i2 > 0 && !b.this.dLD) {
                        ar.a(((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxw(), 107, 2, next.Gkd, 0, "");
                        AppMethodBeat.o(125932);
                        return;
                    }
                }
            }
            AppMethodBeat.o(125932);
        }

        @Override // com.tencent.mm.plugin.topstory.a.e.a
        public final void fxO() {
            AppMethodBeat.i(236384);
            for (final c.b bVar : b.this.Gku) {
                if (bVar.category == 110) {
                    b.this.Gkn.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass6.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(125928);
                            bVar.cB(0, "");
                            AppMethodBeat.o(125928);
                        }
                    });
                    AppMethodBeat.o(236384);
                    return;
                }
            }
            AppMethodBeat.o(236384);
        }

        @Override // com.tencent.mm.plugin.topstory.a.e.a
        public final void fP(String str, int i2) {
            AppMethodBeat.i(236385);
            if (b.this.Gkr != null) {
                com.tencent.mm.plugin.topstory.ui.a.e eVar = b.this.Gkr;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(NativeProtocol.WEB_DIALOG_PARAMS, str);
                    jSONObject.put("reddotType", i2);
                } catch (JSONException e2) {
                    Log.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendNotifyReddotExtMsg json exception: " + e2.getMessage());
                }
                MMHandlerThread.postToMainThread(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002a: INVOKE  
                      (wrap: com.tencent.mm.plugin.topstory.ui.a.e$2 : 0x0027: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.topstory.ui.a.e$2) = 
                      (r1v0 'eVar' com.tencent.mm.plugin.topstory.ui.a.e)
                      (wrap: java.lang.String : 0x0021: INVOKE  (r0v8 java.lang.String) = (r2v0 'jSONObject' org.json.JSONObject) type: VIRTUAL call: org.json.JSONObject.toString():java.lang.String)
                     call: com.tencent.mm.plugin.topstory.ui.a.e.2.<init>(com.tencent.mm.plugin.topstory.ui.a.e, java.lang.String):void type: CONSTRUCTOR)
                     type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.topstory.ui.home.b.6.fP(java.lang.String, int):void, file: classes7.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0027: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.topstory.ui.a.e$2) = 
                      (r1v0 'eVar' com.tencent.mm.plugin.topstory.ui.a.e)
                      (wrap: java.lang.String : 0x0021: INVOKE  (r0v8 java.lang.String) = (r2v0 'jSONObject' org.json.JSONObject) type: VIRTUAL call: org.json.JSONObject.toString():java.lang.String)
                     call: com.tencent.mm.plugin.topstory.ui.a.e.2.<init>(com.tencent.mm.plugin.topstory.ui.a.e, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.topstory.ui.home.b.6.fP(java.lang.String, int):void, file: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 19 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.topstory.ui.a.e, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 25 more
                    */
                /*
                    this = this;
                    r6 = 236385(0x39b61, float:3.31246E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                    com.tencent.mm.plugin.topstory.ui.home.b r0 = com.tencent.mm.plugin.topstory.ui.home.b.this
                    com.tencent.mm.plugin.topstory.ui.a.e r0 = r0.Gkr
                    if (r0 == 0) goto L_0x002d
                    com.tencent.mm.plugin.topstory.ui.home.b r0 = com.tencent.mm.plugin.topstory.ui.home.b.this
                    com.tencent.mm.plugin.topstory.ui.a.e r1 = r0.Gkr
                    org.json.JSONObject r2 = new org.json.JSONObject
                    r2.<init>()
                    java.lang.String r0 = "params"
                    r2.put(r0, r8)     // Catch:{ JSONException -> 0x0031 }
                    java.lang.String r0 = "reddotType"
                    r2.put(r0, r9)     // Catch:{ JSONException -> 0x0031 }
                L_0x0021:
                    java.lang.String r0 = r2.toString()
                    com.tencent.mm.plugin.topstory.ui.a.e$2 r2 = new com.tencent.mm.plugin.topstory.ui.a.e$2
                    r2.<init>(r0)
                    com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
                L_0x002d:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                    return
                L_0x0031:
                    r0 = move-exception
                    java.lang.String r3 = "MicroMsg.TopStory.TopStoryWebViewJSApi"
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    java.lang.String r5 = "onWebRecommendNotifyReddotExtMsg json exception: "
                    r4.<init>(r5)
                    java.lang.String r0 = r0.getMessage()
                    java.lang.StringBuilder r0 = r4.append(r0)
                    java.lang.String r0 = r0.toString()
                    com.tencent.mm.sdk.platformtools.Log.w(r3, r0)
                    goto L_0x0021
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass6.fP(java.lang.String, int):void");
            }

            @Override // com.tencent.mm.plugin.topstory.a.e.a
            public final void bt(final String str, final long j2) {
                AppMethodBeat.i(125935);
                b.this.Gkn.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass6.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(125929);
                        b.this.bv(str, j2);
                        AppMethodBeat.o(125929);
                    }
                });
                AppMethodBeat.o(125935);
            }
        };
        protected MMActivity Gkn;
        protected boolean Gko;
        protected com.tencent.mm.plugin.topstory.ui.a.c Gkp;
        protected WebSearchWebView Gkq;
        protected com.tencent.mm.plugin.topstory.ui.a.e Gkr;
        protected View Gks;
        protected View Gkt;
        protected List<c.b> Gku = new ArrayList();
        View Gkv;
        int Gkw = 0;
        long Gkx = 0;
        boolean Gky = false;
        private LinearLayout Gkz;
        boolean dLD = false;
        protected eii eel;
        private p iRt = new p.a() {
            /* class com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass7 */

            @Override // com.tencent.mm.network.p
            public final void onNetworkChange(int i2) {
                AppMethodBeat.i(125936);
                try {
                    MMHandlerThread.postToMainThread(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                          (wrap: com.tencent.mm.plugin.topstory.ui.a.e$17 : 0x000c: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.topstory.ui.a.e$17) = 
                          (wrap: com.tencent.mm.plugin.topstory.ui.a.e : 0x0008: IGET  (r0v2 com.tencent.mm.plugin.topstory.ui.a.e) = 
                          (wrap: com.tencent.mm.plugin.topstory.ui.home.b : 0x0006: IGET  (r0v1 com.tencent.mm.plugin.topstory.ui.home.b) = (r5v0 'this' com.tencent.mm.plugin.topstory.ui.home.b$7 A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.topstory.ui.home.b.7.GkK com.tencent.mm.plugin.topstory.ui.home.b)
                         com.tencent.mm.plugin.topstory.ui.home.b.Gkr com.tencent.mm.plugin.topstory.ui.a.e)
                         call: com.tencent.mm.plugin.topstory.ui.a.e.17.<init>(com.tencent.mm.plugin.topstory.ui.a.e):void type: CONSTRUCTOR)
                         type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.topstory.ui.home.b.7.onNetworkChange(int):void, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.topstory.ui.a.e$17) = 
                          (wrap: com.tencent.mm.plugin.topstory.ui.a.e : 0x0008: IGET  (r0v2 com.tencent.mm.plugin.topstory.ui.a.e) = 
                          (wrap: com.tencent.mm.plugin.topstory.ui.home.b : 0x0006: IGET  (r0v1 com.tencent.mm.plugin.topstory.ui.home.b) = (r5v0 'this' com.tencent.mm.plugin.topstory.ui.home.b$7 A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.topstory.ui.home.b.7.GkK com.tencent.mm.plugin.topstory.ui.home.b)
                         com.tencent.mm.plugin.topstory.ui.home.b.Gkr com.tencent.mm.plugin.topstory.ui.a.e)
                         call: com.tencent.mm.plugin.topstory.ui.a.e.17.<init>(com.tencent.mm.plugin.topstory.ui.a.e):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.topstory.ui.home.b.7.onNetworkChange(int):void, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 19 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.topstory.ui.a.e, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 25 more
                        */
                    /*
                        this = this;
                        r4 = 125936(0x1ebf0, float:1.76474E-40)
                        com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                        com.tencent.mm.plugin.topstory.ui.home.b r0 = com.tencent.mm.plugin.topstory.ui.home.b.this     // Catch:{ Exception -> 0x0016 }
                        com.tencent.mm.plugin.topstory.ui.a.e r0 = r0.Gkr     // Catch:{ Exception -> 0x0016 }
                        com.tencent.mm.plugin.topstory.ui.a.e$17 r1 = new com.tencent.mm.plugin.topstory.ui.a.e$17     // Catch:{ Exception -> 0x0016 }
                        r1.<init>()     // Catch:{ Exception -> 0x0016 }
                        com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r1)     // Catch:{ Exception -> 0x0016 }
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                    L_0x0015:
                        return
                    L_0x0016:
                        r0 = move-exception
                        java.lang.String r1 = "MicroMsg.TopStory.TopStoryHomeUIComponentImpl"
                        java.lang.String r2 = ""
                        r3 = 0
                        java.lang.Object[] r3 = new java.lang.Object[r3]
                        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(r1, r0, r2, r3)
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                        goto L_0x0015
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass7.onNetworkChange(int):void");
                }
            };
            protected ThreeDotsLoadingView odq;
            int uis = -1;

            static /* synthetic */ void a(b bVar) {
                AppMethodBeat.i(125980);
                bVar.fyo();
                AppMethodBeat.o(125980);
            }

            /* access modifiers changed from: package-private */
            public static class a {
                View Gla;
                FrameLayout Glb;
                ImageView Glc;
                int Gld = 0;

                a() {
                }
            }

            public b(MMActivity mMActivity, boolean z) {
                AppMethodBeat.i(125955);
                this.Gkn = mMActivity;
                this.Gko = z;
                AppMethodBeat.o(125955);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:85:0x03fe, code lost:
                r0 = r14.Gkn.getIntent().getBundleExtra("key_extra_data");
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onCreate(android.os.Bundle r15) {
                /*
                // Method dump skipped, instructions count: 1290
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.topstory.ui.home.b.onCreate(android.os.Bundle):void");
            }

            @Override // com.tencent.mm.plugin.topstory.ui.home.a
            public final void jo(int i2, int i3) {
                AppMethodBeat.i(125958);
                ar.q("", 0, 0, i2);
                String afq = ai.afq(i2);
                HashMap hashMap = new HashMap();
                try {
                    hashMap.put("topStoryScene", String.valueOf(this.eel.scene));
                    hashMap.put("deviceName", URLEncoder.encode(d.DEVICE_NAME, "utf8"));
                    hashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
                    hashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
                    hashMap.put("from", URLEncoder.encode(this.Gkn.getString(R.string.hpd), "utf8"));
                    g.aAf();
                    hashMap.put(OpenSDKTool4Assistant.EXTRA_UIN, com.tencent.mm.kernel.a.ayV());
                    hashMap.put("timeZone", URLEncoder.encode(Util.getTimeZoneOffset(), "utf8"));
                    hashMap.put("ostype", d.KyK);
                    hashMap.put("subScene", String.valueOf(i3));
                    hashMap.put(IssueStorage.COLUMN_EXT_INFO, ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxG());
                } catch (Exception e2) {
                }
                ((h) g.af(h.class)).a(this.Gkn, i2, "", afq, hashMap, this.Gkn.getResources().getString(R.string.hpw), this.Gkn.getResources().getColor(R.color.BW_93));
                AppMethodBeat.o(125958);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.home.a
            public final void fym() {
                AppMethodBeat.i(125959);
                if (!this.GkE || this.EDW.size() <= 0) {
                    this.GkE = true;
                    AppMethodBeat.o(125959);
                    return;
                }
                final int i2 = this.uis;
                this.GkA.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass18 */

                    public final void run() {
                        AppMethodBeat.i(125954);
                        if (i2 == b.this.uis) {
                            b.this.EDW.get(b.this.uis).Glc.setVisibility(8);
                            Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onH5RenderFinished hide fakeIv " + b.this.uis);
                        }
                        AppMethodBeat.o(125954);
                    }
                }, 100);
                AppMethodBeat.o(125959);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.home.a
            public final int fyn() {
                return this.GkC;
            }

            public final boolean abS(int i2) {
                AppMethodBeat.i(125960);
                if (i2 == 4) {
                    onBackBtnClick();
                    AppMethodBeat.o(125960);
                    return true;
                }
                AppMethodBeat.o(125960);
                return false;
            }

            /* access modifiers changed from: protected */
            public final void onBackBtnClick() {
                AppMethodBeat.i(125961);
                if (this.Gky) {
                    fyo();
                    AppMethodBeat.o(125961);
                    return;
                }
                if (this.GkG) {
                    i.a(this.eel, "uiBackBtnClick", System.currentTimeMillis());
                } else if (!this.GkF) {
                    i.a(this.eel, "uiBackBtnClickWithoutGetSearchData", System.currentTimeMillis());
                } else if (this.GkH) {
                    i.a(this.eel, "uiBackBtnClickWithoutH5Ready", System.currentTimeMillis());
                } else {
                    i.a(this.eel, "uiBackBtnClickWithoutDataReady", System.currentTimeMillis());
                }
                ar.afB(19);
                if (this.Gko) {
                    this.Gkn.finish();
                    AppMethodBeat.o(125961);
                    return;
                }
                this.Gkn.moveTaskToBack(true);
                AppMethodBeat.o(125961);
            }

            /* access modifiers changed from: package-private */
            public final void fyo() {
                AppMethodBeat.i(125962);
                if (this.Gkr != null) {
                    this.Gkr.fzW();
                    fyl();
                }
                AppMethodBeat.o(125962);
            }

            /* access modifiers changed from: protected */
            public final void onResume() {
                AppMethodBeat.i(125963);
                i.a(this.eel, "uiOnResume", System.currentTimeMillis());
                this.Gkr.aTJ("onResume");
                if (this.Gkq != null) {
                    this.Gkq.onResume();
                }
                com.tencent.mm.cr.d.bpI("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                for (c.b bVar : this.Gku) {
                    if (bVar.Gkd > 0) {
                        if (bVar.category == 110) {
                            ar.a(((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxw(), 107, 2, bVar.Gkd, 0, "");
                        }
                    } else if (bVar.Gkc > 0) {
                        if (bVar.category == 110) {
                            ar.a(((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxo(), 107, 1, 0, 0, "");
                        } else if (bVar.category == 100) {
                            eiq eiq = new eiq();
                            eiq.msgId = bVar.Gke;
                            ar.a(eiq, 107, 3, 0, 0, "");
                        }
                    }
                }
                this.dLD = false;
                this.GkD = false;
                AppMethodBeat.o(125963);
            }

            /* access modifiers changed from: protected */
            public final void onPause() {
                AppMethodBeat.i(125964);
                i.a(this.eel, "uiOnPause", System.currentTimeMillis());
                this.Gkr.aTJ("onPause");
                if (this.Gkq != null) {
                    this.Gkq.onPause();
                }
                this.dLD = true;
                if (g.af(com.tencent.mm.plugin.ball.c.a.class) != null) {
                    int i2 = this.Gkw;
                    if (this.Gkw == 0) {
                        i2 = c.fyf();
                    }
                    if (i2 == 100) {
                        ((com.tencent.mm.plugin.ball.c.a) g.af(com.tencent.mm.plugin.ball.c.a.class)).d(104, false, false);
                        AppMethodBeat.o(125964);
                        return;
                    } else if (i2 == 110) {
                        ((com.tencent.mm.plugin.ball.c.a) g.af(com.tencent.mm.plugin.ball.c.a.class)).d(103, false, false);
                    }
                }
                AppMethodBeat.o(125964);
            }

            /* access modifiers changed from: protected */
            public final void onDestroy() {
                AppMethodBeat.i(125965);
                this.Gkq.QDX = null;
                try {
                    if (this.eel.channelId == 100 && this.Gkr != null) {
                        com.tencent.mm.plugin.topstory.ui.a.a.a(this.Gkr, "onWebCommendLeaveFromFindPage", "");
                    }
                    if (this.Gkq.getParent() != null && this.Gkq.getParent().equals(this.EeM)) {
                        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "webViewContainer remove topstoryWebview");
                        this.EeM.removeView(this.Gkq);
                    }
                } catch (Exception e2) {
                }
                if (this.Gkq != null) {
                    this.Gkq.onDestroy();
                }
                eii eii = this.eel;
                long activityBrowseTimeMs = this.Gkn.getActivityBrowseTimeMs();
                if (activityBrowseTimeMs > 0) {
                    String format = String.format("%s,%s,%s,%s", Integer.valueOf(eii.scene), Long.valueOf(activityBrowseTimeMs), Integer.valueOf(eii.channelId), Integer.valueOf(eii.Nhz));
                    Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomePageBrowseTime 15018 %s", format);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(15018, format);
                }
                i.a(this.eel, "uiOnDestroy", System.currentTimeMillis());
                ar.afB(18);
                com.tencent.mm.plugin.topstory.ui.a.c cVar = this.Gkp;
                cVar.IHe = null;
                cVar.Gqo = null;
                g.azz().b(1943, cVar);
                g.azz().b(2582, cVar.Gqr);
                g.azz().b(2802, cVar.Gnc);
                g.azz().b(2906, cVar.Gqq);
                this.GkI.dead();
                g.aAg().b(this.iRt);
                ((com.tencent.mm.plugin.topstory.ui.b) g.ah(com.tencent.mm.plugin.topstory.ui.b.class)).setHaokanEventListener(null);
                ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().b(this.GkJ);
                AppMethodBeat.o(125965);
            }

            /* access modifiers changed from: protected */
            public final void onNewIntent(Intent intent) {
                AppMethodBeat.i(125966);
                eii eii = new eii();
                try {
                    eii.parseFrom(intent.getByteArrayExtra("key_context"));
                } catch (Exception e2) {
                    this.Gkn.finish();
                }
                this.eel.sessionId = eii.sessionId;
                this.eel.dVO = eii.dVO;
                this.eel.scene = eii.scene;
                this.eel.dPI = eii.dPI;
                this.eel.wib = ai.ait();
                i.a(this.eel, "uiOnNewIntent", System.currentTimeMillis());
                ar.afB(20);
                this.Gkr.aTJ("onNewIntent");
                AppMethodBeat.o(125966);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.home.a
            public final MMActivity eeF() {
                return this.Gkn;
            }

            @Override // com.tencent.mm.plugin.topstory.ui.home.a
            public final void fyj() {
                this.GkF = true;
            }

            @Override // com.tencent.mm.plugin.topstory.ui.home.a
            public final void fyk() {
                AppMethodBeat.i(125967);
                this.GkG = true;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(125920);
                        b.this.odq.gZi();
                        b.this.Gks.setVisibility(8);
                        b.this.Gkq.setVisibility(0);
                        AppMethodBeat.o(125920);
                    }
                });
                AppMethodBeat.o(125967);
            }

            /* access modifiers changed from: protected */
            public boolean fyp() {
                return true;
            }

            @Override // com.tencent.mm.plugin.topstory.ui.home.a
            public final void aTA(String str) {
                AppMethodBeat.i(125968);
                for (a aVar : this.EDW) {
                    if (aVar.Glc != null) {
                        aVar.Gld = 0;
                        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "invalid cache when onSearchDataReady");
                    }
                }
                this.GkH = true;
                this.Gkr.aTA(str);
                AppMethodBeat.o(125968);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.home.a
            public final void aTB(String str) {
                AppMethodBeat.i(125969);
                MMHandlerThread.postToMainThread(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  
                      (wrap: com.tencent.mm.plugin.topstory.ui.a.e$13 : 0x000a: CONSTRUCTOR  (r1v0 com.tencent.mm.plugin.topstory.ui.a.e$13) = 
                      (wrap: com.tencent.mm.plugin.topstory.ui.a.e : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.topstory.ui.a.e) = (r3v0 'this' com.tencent.mm.plugin.topstory.ui.home.b A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.topstory.ui.home.b.Gkr com.tencent.mm.plugin.topstory.ui.a.e)
                      (r4v0 'str' java.lang.String)
                     call: com.tencent.mm.plugin.topstory.ui.a.e.13.<init>(com.tencent.mm.plugin.topstory.ui.a.e, java.lang.String):void type: CONSTRUCTOR)
                     type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.topstory.ui.home.b.aTB(java.lang.String):void, file: classes7.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r1v0 com.tencent.mm.plugin.topstory.ui.a.e$13) = 
                      (wrap: com.tencent.mm.plugin.topstory.ui.a.e : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.topstory.ui.a.e) = (r3v0 'this' com.tencent.mm.plugin.topstory.ui.home.b A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.topstory.ui.home.b.Gkr com.tencent.mm.plugin.topstory.ui.a.e)
                      (r4v0 'str' java.lang.String)
                     call: com.tencent.mm.plugin.topstory.ui.a.e.13.<init>(com.tencent.mm.plugin.topstory.ui.a.e, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.topstory.ui.home.b.aTB(java.lang.String):void, file: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 14 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.topstory.ui.a.e, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 20 more
                    */
                /*
                    this = this;
                    r2 = 125969(0x1ec11, float:1.7652E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    com.tencent.mm.plugin.topstory.ui.a.e r0 = r3.Gkr
                    com.tencent.mm.plugin.topstory.ui.a.e$13 r1 = new com.tencent.mm.plugin.topstory.ui.a.e$13
                    r1.<init>(r4)
                    com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r1)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.topstory.ui.home.b.aTB(java.lang.String):void");
            }

            @Override // com.tencent.mm.plugin.topstory.ui.home.a
            public final void aTC(String str) {
                AppMethodBeat.i(125970);
                MMHandlerThread.postToMainThread(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  
                      (wrap: com.tencent.mm.plugin.topstory.ui.a.e$16 : 0x000a: CONSTRUCTOR  (r1v0 com.tencent.mm.plugin.topstory.ui.a.e$16) = 
                      (wrap: com.tencent.mm.plugin.topstory.ui.a.e : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.topstory.ui.a.e) = (r3v0 'this' com.tencent.mm.plugin.topstory.ui.home.b A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.topstory.ui.home.b.Gkr com.tencent.mm.plugin.topstory.ui.a.e)
                      (r4v0 'str' java.lang.String)
                     call: com.tencent.mm.plugin.topstory.ui.a.e.16.<init>(com.tencent.mm.plugin.topstory.ui.a.e, java.lang.String):void type: CONSTRUCTOR)
                     type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.topstory.ui.home.b.aTC(java.lang.String):void, file: classes7.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r1v0 com.tencent.mm.plugin.topstory.ui.a.e$16) = 
                      (wrap: com.tencent.mm.plugin.topstory.ui.a.e : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.topstory.ui.a.e) = (r3v0 'this' com.tencent.mm.plugin.topstory.ui.home.b A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.topstory.ui.home.b.Gkr com.tencent.mm.plugin.topstory.ui.a.e)
                      (r4v0 'str' java.lang.String)
                     call: com.tencent.mm.plugin.topstory.ui.a.e.16.<init>(com.tencent.mm.plugin.topstory.ui.a.e, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.topstory.ui.home.b.aTC(java.lang.String):void, file: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 14 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.topstory.ui.a.e, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 20 more
                    */
                /*
                    this = this;
                    r2 = 125970(0x1ec12, float:1.76522E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    com.tencent.mm.plugin.topstory.ui.a.e r0 = r3.Gkr
                    com.tencent.mm.plugin.topstory.ui.a.e$16 r1 = new com.tencent.mm.plugin.topstory.ui.a.e$16
                    r1.<init>(r4)
                    com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r1)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.topstory.ui.home.b.aTC(java.lang.String):void");
            }

            @Override // com.tencent.mm.plugin.topstory.ui.home.a
            public final void aTD(String str) {
                AppMethodBeat.i(125971);
                MMHandlerThread.postToMainThread(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  
                      (wrap: com.tencent.mm.plugin.topstory.ui.a.e$15 : 0x000a: CONSTRUCTOR  (r1v0 com.tencent.mm.plugin.topstory.ui.a.e$15) = 
                      (wrap: com.tencent.mm.plugin.topstory.ui.a.e : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.topstory.ui.a.e) = (r3v0 'this' com.tencent.mm.plugin.topstory.ui.home.b A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.topstory.ui.home.b.Gkr com.tencent.mm.plugin.topstory.ui.a.e)
                      (r4v0 'str' java.lang.String)
                     call: com.tencent.mm.plugin.topstory.ui.a.e.15.<init>(com.tencent.mm.plugin.topstory.ui.a.e, java.lang.String):void type: CONSTRUCTOR)
                     type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.topstory.ui.home.b.aTD(java.lang.String):void, file: classes7.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r1v0 com.tencent.mm.plugin.topstory.ui.a.e$15) = 
                      (wrap: com.tencent.mm.plugin.topstory.ui.a.e : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.topstory.ui.a.e) = (r3v0 'this' com.tencent.mm.plugin.topstory.ui.home.b A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.topstory.ui.home.b.Gkr com.tencent.mm.plugin.topstory.ui.a.e)
                      (r4v0 'str' java.lang.String)
                     call: com.tencent.mm.plugin.topstory.ui.a.e.15.<init>(com.tencent.mm.plugin.topstory.ui.a.e, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.topstory.ui.home.b.aTD(java.lang.String):void, file: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 14 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.topstory.ui.a.e, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 20 more
                    */
                /*
                    this = this;
                    r2 = 125971(0x1ec13, float:1.76523E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    com.tencent.mm.plugin.topstory.ui.a.e r0 = r3.Gkr
                    com.tencent.mm.plugin.topstory.ui.a.e$15 r1 = new com.tencent.mm.plugin.topstory.ui.a.e$15
                    r1.<init>(r4)
                    com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r1)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.topstory.ui.home.b.aTD(java.lang.String):void");
            }

            @Override // com.tencent.mm.plugin.topstory.ui.home.a
            public final void jn(final int i2, final int i3) {
                AppMethodBeat.i(125972);
                this.Gkn.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(125922);
                        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "showNavBarShadow %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
                        b.this.Gkt.setBackgroundColor(i2 + (TPMediaCodecProfileLevel.HEVCMainTierLevel62 * i3));
                        b.this.Gkt.setVisibility(0);
                        b.this.Gky = true;
                        b.this.Gkt.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass3.AnonymousClass1 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(125921);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                b.a(b.this);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/home/TopStoryHomeUIComponentImpl$11$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(125921);
                            }
                        });
                        if (b.this.GkA != null) {
                            b.this.GkA.setScrollEnable(false);
                        }
                        AppMethodBeat.o(125922);
                    }
                });
                AppMethodBeat.o(125972);
            }

            @Override // com.tencent.mm.plugin.topstory.ui.home.a
            public final void fyl() {
                AppMethodBeat.i(125973);
                this.Gkn.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(125923);
                        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "hideNavBarShadow");
                        b.this.Gkt.setVisibility(8);
                        b.this.Gky = false;
                        if (b.this.GkA != null) {
                            b.this.GkA.setScrollEnable(true);
                        }
                        AppMethodBeat.o(125923);
                    }
                });
                AppMethodBeat.o(125973);
            }

            public final void a(com.tencent.mm.plugin.topstory.ui.a.c cVar, WebSearchWebView webSearchWebView, com.tencent.mm.plugin.topstory.ui.a.e eVar, eii eii) {
                AppMethodBeat.i(236386);
                this.Gkp = cVar;
                this.Gkq = webSearchWebView;
                this.Gkr = eVar;
                this.Gkr.IHe = this;
                this.eel = eii;
                com.tencent.mm.plugin.topstory.ui.a.c cVar2 = this.Gkp;
                cVar2.IHe = this;
                g.azz().a(2582, cVar2.Gqr);
                g.azz().a(2802, cVar2.Gnc);
                g.azz().a(2906, cVar2.Gqq);
                this.EeM.addView(this.Gkq, new FrameLayout.LayoutParams(-1, -1));
                AppMethodBeat.o(236386);
            }

            /* access modifiers changed from: package-private */
            public final void bv(String str, long j2) {
                AppMethodBeat.i(125975);
                this.Gkv.setVisibility(0);
                eiq eiq = new eiq();
                eiq.msgId = str;
                eiq.NhO = j2;
                ar.a(eiq, 107, 5, 0, 0, "");
                AppMethodBeat.o(125975);
            }

            /* access modifiers changed from: protected */
            public final void onSaveInstanceState(Bundle bundle) {
                AppMethodBeat.i(125976);
                try {
                    bundle.putByteArray("key_context", this.eel.toByteArray());
                    Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onSaveInstanceState %s", this.eel.sGQ);
                    AppMethodBeat.o(125976);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", e2, "onSaveInstanceState", new Object[0]);
                    AppMethodBeat.o(125976);
                }
            }

            static Bitmap a(WebSearchWebView webSearchWebView, int i2, int i3) {
                Bitmap bitmap;
                AppMethodBeat.i(236387);
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    bitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
                    webSearchWebView.drawCanvas(new Canvas(bitmap));
                    Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "captureWebView success, cost:" + (System.currentTimeMillis() - currentTimeMillis));
                    com.tencent.mm.plugin.topstory.a.a.b.fxU();
                } catch (Throwable th) {
                    bitmap = null;
                    Log.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", th, "captureWebView error", new Object[0]);
                    com.tencent.mm.plugin.topstory.a.a.b.fxU();
                }
                AppMethodBeat.o(236387);
                return bitmap;
            }

            public final synchronized void bc(int i2, boolean z) {
                boolean z2;
                boolean z3 = false;
                synchronized (this) {
                    AppMethodBeat.i(125978);
                    Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView, from " + (z ? "viewpager" : "tab"));
                    if (i2 == this.uis) {
                        Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView return");
                        AppMethodBeat.o(125978);
                    } else {
                        final int i3 = i2 == 0 ? 1 : 0;
                        this.uis = i2;
                        final a aVar = this.EDW.get(i3);
                        if (this.GkB.getParent() == this.EDW.get(i3).Glb) {
                            if (aVar.Gld <= 0) {
                                z2 = true;
                            } else {
                                aVar.Glc.setVisibility(0);
                                Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "changeView cacheworked");
                                z2 = false;
                            }
                            aVar.Gld = 2;
                            z3 = z2;
                        } else {
                            aVar.Glc.setVisibility(0);
                        }
                        final c.b bVar = this.Gku.get(this.uis);
                        this.GkE = false;
                        final String str = "";
                        if (bVar.category == 100 && bVar.Gkc > 0) {
                            str = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxC();
                        }
                        if (z3) {
                            com.tencent.f.h.RTc.b(new Runnable() {
                                /* class com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass8 */

                                public final void run() {
                                    AppMethodBeat.i(125938);
                                    final Bitmap a2 = b.a(b.this.Gkq, aVar.Glb.getWidth(), aVar.Glb.getHeight());
                                    b.this.Gkn.runOnUiThread(new Runnable() {
                                        /* class com.tencent.mm.plugin.topstory.ui.home.b.AnonymousClass8.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(125937);
                                            if (a2 != null) {
                                                aVar.Glc.setImageBitmap(a2);
                                            } else {
                                                aVar.Glc.setImageDrawable(b.this.Gkn.getResources().getDrawable(R.color.f3043a));
                                                aVar.Gld = 0;
                                            }
                                            aVar.Glc.setVisibility(0);
                                            Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "layout %s,%s, fakeIv %s,%s", Integer.valueOf(aVar.Glb.getWidth()), Integer.valueOf(aVar.Glb.getHeight()), Integer.valueOf(aVar.Glc.getWidth()), Integer.valueOf(aVar.Glc.getHeight()));
                                            if (b.this.GkB.getParent() != null) {
                                                ((ViewGroup) b.this.GkB.getParent()).removeView(b.this.GkB);
                                                Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:" + i3);
                                            }
                                            b.this.EDW.get(b.this.uis).Glb.addView(b.this.GkB, new FrameLayout.LayoutParams(-1, -1));
                                            Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + b.this.uis);
                                            b.this.Gkr.m(bVar.Gkb, bVar.Gkc, bVar.Gkd, str);
                                            AppMethodBeat.o(125937);
                                        }
                                    });
                                    AppMethodBeat.o(125938);
                                }
                            }, "CaptureWebViewTask");
                        } else {
                            if (this.GkB.getParent() != null) {
                                ((ViewGroup) this.GkB.getParent()).removeView(this.GkB);
                                Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "remove view from:".concat(String.valueOf(i3)));
                            }
                            this.EDW.get(this.uis).Glb.addView(this.GkB, new FrameLayout.LayoutParams(-1, -1));
                            Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "add view to:" + this.uis);
                            this.Gkr.m(bVar.Gkb, bVar.Gkc, bVar.Gkd, str);
                        }
                        ar.b(bVar.category, this.Gkw, Util.isNullOrNil(bVar.Gkf) ? bVar.Gke : bVar.Gkf, this.eel.hes, z);
                        AppMethodBeat.o(125978);
                    }
                }
            }

            public final void onActivityResult(int i2, int i3, Intent intent) {
                AppMethodBeat.i(125979);
                if (i2 == 1 && i3 == -1) {
                    String stringExtra = intent.getStringExtra("key_video_play_info");
                    String stringExtra2 = intent.getStringExtra("key_search_id");
                    com.tencent.mm.plugin.topstory.ui.a.e eVar = this.Gkr;
                    try {
                        Log.i("MicroMsg.TopStory.TopStoryWebViewJSApi", "onVideoPlayInfo %s %s", stringExtra2, stringExtra);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("videoPlayInfo", stringExtra);
                        jSONObject.put("searchId", stringExtra2);
                        MMHandlerThread.postToMainThread(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0044: INVOKE  
                              (wrap: com.tencent.mm.plugin.topstory.ui.a.e$10 : 0x0041: CONSTRUCTOR  (r0v6 com.tencent.mm.plugin.topstory.ui.a.e$10) = (r2v0 'eVar' com.tencent.mm.plugin.topstory.ui.a.e), (r3v1 'jSONObject' org.json.JSONObject) call: com.tencent.mm.plugin.topstory.ui.a.e.10.<init>(com.tencent.mm.plugin.topstory.ui.a.e, org.json.JSONObject):void type: CONSTRUCTOR)
                             type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.topstory.ui.home.b.onActivityResult(int, int, android.content.Intent):void, file: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0041: CONSTRUCTOR  (r0v6 com.tencent.mm.plugin.topstory.ui.a.e$10) = (r2v0 'eVar' com.tencent.mm.plugin.topstory.ui.a.e), (r3v1 'jSONObject' org.json.JSONObject) call: com.tencent.mm.plugin.topstory.ui.a.e.10.<init>(com.tencent.mm.plugin.topstory.ui.a.e, org.json.JSONObject):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.topstory.ui.home.b.onActivityResult(int, int, android.content.Intent):void, file: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 24 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.topstory.ui.a.e, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 30 more
                            */
                        /*
                            this = this;
                            r0 = 1
                            r7 = 125979(0x1ec1b, float:1.76534E-40)
                            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
                            if (r9 != r0) goto L_0x004c
                            r0 = -1
                            if (r10 != r0) goto L_0x004c
                            java.lang.String r0 = "key_video_play_info"
                            java.lang.String r0 = r11.getStringExtra(r0)
                            java.lang.String r1 = "key_search_id"
                            java.lang.String r1 = r11.getStringExtra(r1)
                            com.tencent.mm.plugin.topstory.ui.a.e r2 = r8.Gkr
                            java.lang.String r3 = "MicroMsg.TopStory.TopStoryWebViewJSApi"
                            java.lang.String r4 = "onVideoPlayInfo %s %s"
                            r5 = 2
                            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x004b }
                            r6 = 0
                            r5[r6] = r1     // Catch:{ Exception -> 0x004b }
                            r6 = 1
                            r5[r6] = r0     // Catch:{ Exception -> 0x004b }
                            com.tencent.mm.sdk.platformtools.Log.i(r3, r4, r5)     // Catch:{ Exception -> 0x004b }
                            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x004b }
                            r3.<init>()     // Catch:{ Exception -> 0x004b }
                            java.lang.String r4 = "videoPlayInfo"
                            r3.put(r4, r0)     // Catch:{ Exception -> 0x004b }
                            java.lang.String r0 = "searchId"
                            r3.put(r0, r1)     // Catch:{ Exception -> 0x004b }
                            com.tencent.mm.plugin.topstory.ui.a.e$10 r0 = new com.tencent.mm.plugin.topstory.ui.a.e$10     // Catch:{ Exception -> 0x004b }
                            r0.<init>(r3)     // Catch:{ Exception -> 0x004b }
                            com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r0)     // Catch:{ Exception -> 0x004b }
                            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
                        L_0x004a:
                            return
                        L_0x004b:
                            r0 = move-exception
                        L_0x004c:
                            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
                            goto L_0x004a
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.topstory.ui.home.b.onActivityResult(int, int, android.content.Intent):void");
                    }

                    @Override // com.tencent.mm.plugin.websearch.webview.d
                    public final WebSearchWebView dQg() {
                        return this.Gkq;
                    }

                    @Override // com.tencent.mm.plugin.websearch.webview.d
                    public final Context getActivityContext() {
                        return this.Gkn;
                    }

                    /* Return type fixed from 'com.tencent.mm.plugin.websearch.webview.b' to match base method */
                    @Override // com.tencent.mm.plugin.websearch.webview.d
                    public final /* bridge */ /* synthetic */ com.tencent.mm.plugin.websearch.webview.b<eii> dQj() {
                        return this.Gkr;
                    }

                    /* Return type fixed from 'com.tencent.mm.plugin.websearch.webview.a' to match base method */
                    @Override // com.tencent.mm.plugin.websearch.webview.d
                    public final /* bridge */ /* synthetic */ com.tencent.mm.plugin.websearch.webview.a<eii> dQk() {
                        return this.Gkp;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // com.tencent.mm.plugin.websearch.webview.d
                    public final /* bridge */ /* synthetic */ eii dQl() {
                        return this.eel;
                    }
                }
