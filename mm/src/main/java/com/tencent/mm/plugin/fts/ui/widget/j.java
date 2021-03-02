package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.e.b;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.plugin.fts.ui.widget.i;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.f;
import com.tencent.mm.plugin.websearch.webview.g;
import com.tencent.mm.protocal.protobuf.czc;
import com.tencent.mm.protocal.protobuf.fas;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j implements i, d {
    private static final int maxHeight = a.fromDPToPix(MMApplicationContext.getContext(), (int) TbsListener.ErrorCode.STARTDOWNLOAD_4);
    private boolean dDz;
    String dUA = "";
    private FrameLayout plP;
    i xbE;
    private boolean xgF;
    public WebSearchWebView xgX;
    private FrameLayout xgY;
    private fas xgZ;
    public g<fas> xha;
    private com.tencent.mm.plugin.fts.ui.e.a xhb;

    static {
        AppMethodBeat.i(176953);
        AppMethodBeat.o(176953);
    }

    public j(i iVar, FrameLayout frameLayout) {
        AppMethodBeat.i(176944);
        this.plP = frameLayout;
        this.xbE = iVar;
        this.xgZ = new fas();
        this.xgZ.sessionId = e.dOy();
        this.xgZ.scene = 1;
        fas fas = this.xgZ;
        HashMap hashMap = new HashMap();
        hashMap.put("scene", "1");
        hashMap.put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
        hashMap.put(TPDownloadProxyEnum.USER_PLATFORM, "android");
        hashMap.put("version", String.valueOf(ai.afr(5).bbw()));
        hashMap.put(DownloadInfo.NETTYPE, ai.ait());
        hashMap.put("wechatVersion", BuildInfo.CLIENT_VERSION);
        hashMap.put("webSearchVersion", String.valueOf(ai.afr(0).bbw()));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(ai.afr(5).fYs());
        stringBuffer.append(FilePathGenerator.ANDROID_DIR_SEP);
        stringBuffer.append("app.html");
        stringBuffer.append("?");
        stringBuffer.append(ai.toUrlParams(hashMap));
        fas.url = stringBuffer.toString();
        this.xha = new g<>(this);
        this.xhb = new com.tencent.mm.plugin.fts.ui.e.a(this);
        f fVar = new f((byte) 0);
        b bVar = new b();
        this.xgX = new WebSearchWebView(iVar.xfV);
        this.xgX.a(bVar, fVar);
        this.xgX.addJavascriptInterface(this.xhb, "pardusJSApi");
        int jn = a.jn(MMApplicationContext.getContext());
        this.xgY = new FrameLayout(MMApplicationContext.getContext());
        this.xgY.addView(this.xgX, new FrameLayout.LayoutParams(jn, maxHeight));
        frameLayout.addView(this.xgY, new FrameLayout.LayoutParams(jn, maxHeight));
        frameLayout.measure(jn, -2);
        frameLayout.requestLayout();
        Log.i("MicroMsg.FTS.PardusWebViewLogic", "containerWidth: %s webviewWidth: %s", Integer.valueOf(frameLayout.getMeasuredWidth()), Integer.valueOf(this.xgX.getMeasuredWidth()));
        this.xgX.loadUrl(this.xgZ.url);
        com.tencent.mm.kernel.g.azz().a(2975, this);
        AppMethodBeat.o(176944);
    }

    public final void dQf() {
        AppMethodBeat.i(176945);
        if (this.plP != null) {
            this.plP.setVisibility(8);
        }
        AppMethodBeat.o(176945);
    }

    public final void clearData() {
        this.xgF = false;
        this.dDz = false;
        this.dUA = "";
    }

    /* access modifiers changed from: package-private */
    public final void hA(String str, String str2) {
        AppMethodBeat.i(176946);
        try {
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(176946);
                return;
            }
            String nullAsNil = Util.nullAsNil(str2);
            Log.i("MicroMsg.FTS.PardusWebViewLogic", "notifyJsEvent %s %s", str, nullAsNil);
            final String format = String.format("javascript:window['%s'] && %s(%s)", str, str, nullAsNil);
            this.xbE.xfV.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.fts.ui.widget.j.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(235412);
                    j.this.xgX.evaluateJavascript(format, null);
                    AppMethodBeat.o(235412);
                }
            });
            AppMethodBeat.o(176946);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FTS.PardusWebViewLogic", e2, "notifyJsEvent", new Object[0]);
            AppMethodBeat.o(176946);
        }
    }

    @Override // com.tencent.mm.plugin.fts.ui.widget.d
    public final void aQ(JSONObject jSONObject) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(235416);
        try {
            final int optInt = jSONObject.optInt("height");
            JSONArray optJSONArray = jSONObject.optJSONArray("sugList");
            final String optString = jSONObject.optString("docId");
            final int length = optJSONArray != null ? optJSONArray.length() : 0;
            if (length > 0) {
                z = true;
            } else {
                z = false;
            }
            this.xgF = z;
            if (Util.isNullOrNil(optString)) {
                z2 = false;
            }
            this.dDz = z2;
            this.xbE.xfV.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.fts.ui.widget.j.AnonymousClass5 */

                public final void run() {
                    int round;
                    AppMethodBeat.i(235415);
                    if (j.this.xgX.isXWalkKernel()) {
                        round = a.fromDPToPix(MMApplicationContext.getContext(), optInt);
                    } else {
                        round = Math.round(com.tencent.mm.cc.a.gvp() * ((float) optInt));
                    }
                    Log.i("MicroMsg.FTS.PardusWebViewLogic", "start to update webview %d", Integer.valueOf(round));
                    j.this.xgX.getLayoutParams().height = round;
                    j.this.xgX.requestLayout();
                    j.this.xgY.getLayoutParams().height = 0;
                    j.this.xgY.requestLayout();
                    ValueAnimator ofInt = ValueAnimator.ofInt(0, round);
                    ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        /* class com.tencent.mm.plugin.fts.ui.widget.j.AnonymousClass5.AnonymousClass1 */

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            AppMethodBeat.i(235413);
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            Log.i("MicroMsg.FTS.PardusWebViewLogic", "webview onAnimationUpdate %d", Integer.valueOf(intValue));
                            j.this.xgY.getLayoutParams().height = intValue;
                            j.this.xgY.requestLayout();
                            AppMethodBeat.o(235413);
                        }
                    });
                    i iVar = j.this.xbE;
                    ofInt.addListener(new i.a(iVar.xbf));
                    ofInt.setDuration(400L);
                    ofInt.start();
                    j.this.plP.setVisibility(0);
                    j.this.plP.post(new Runnable() {
                        /* class com.tencent.mm.plugin.fts.ui.widget.j.AnonymousClass5.AnonymousClass2 */

                        public final void run() {
                            int i2 = 0;
                            AppMethodBeat.i(235414);
                            Log.i("MicroMsg.FTS.PardusWebViewLogic", "update footer view");
                            i iVar = j.this.xbE;
                            boolean z = j.this.xgF;
                            boolean z2 = j.this.dDz;
                            iVar.xgF = z;
                            iVar.dDz = z2;
                            iVar.cHi();
                            j.this.xbE.xfV.xbX.xbD.gF(length, j.this.dDz ? 2 : 0);
                            if (j.this.xgF) {
                                j.this.xbE.xfV.xbX.xbD.t(System.currentTimeMillis(), "PardusSug");
                            }
                            if (j.this.dDz) {
                                if (j.this.xgF) {
                                    i2 = 1;
                                }
                                j.this.xbE.xfV.xbX.xbD.a(i2, System.currentTimeMillis(), "PardusMore", 3, optString);
                                j.this.xbE.xfV.xbX.xbD.a(i2 + 1, System.currentTimeMillis(), optString, 3, optString);
                            }
                            AppMethodBeat.o(235414);
                        }
                    });
                    AppMethodBeat.o(235415);
                }
            });
            AppMethodBeat.o(235416);
        } catch (Exception e2) {
            AppMethodBeat.o(235416);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.fts.ui.widget.d
    public final void a(int i2, JSONObject jSONObject) {
        int i3;
        int i4;
        AppMethodBeat.i(235417);
        switch (i2) {
            case 1:
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject("actionInfo");
                    String optString = optJSONObject.optString(SearchIntents.EXTRA_QUERY);
                    JSONObject jSONObject2 = new JSONObject(optJSONObject.optString("extParams"));
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.optString(next));
                    }
                    this.xbE.m(hashMap, optString);
                    this.xbE.xfV.xbX.xbD.Nv(28);
                    this.xbE.xfV.xbX.xby = true;
                    this.xbE.Nz(6);
                    l.a(this.dUA, 1, 1, this.xbE.xfV.mve, this.xbE.xfV.xbX.xbD, 28, "", "", "");
                    AppMethodBeat.o(235417);
                    return;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FTS.PardusWebViewLogic", e2, "pardusAction", new Object[0]);
                    AppMethodBeat.o(235417);
                    return;
                }
            case 2:
                JSONObject optJSONObject2 = jSONObject.optJSONObject("actionInfo");
                String optString2 = optJSONObject2.optString(SearchIntents.EXTRA_QUERY);
                JSONObject jSONObject3 = new JSONObject(optJSONObject2.optString("extParams"));
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys2 = jSONObject3.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    hashMap2.put(next2, jSONObject3.optString(next2));
                }
                ((h) com.tencent.mm.kernel.g.af(h.class)).a(this.xbE.xfV, 3, optString2, String.valueOf(e.wVm), hashMap2);
                this.xbE.xfV.xbX.xbD.Nv(27);
                this.xbE.xfV.xbX.xby = true;
                this.xbE.Nz(5);
                if (this.xgF) {
                    i4 = 2;
                } else {
                    i4 = 1;
                }
                l.a(optString2, i4, 2, this.xbE.xfV.mve, this.xbE.xfV.xbX.xbD, 27, "3$".concat(String.valueOf(optJSONObject2.optString("nickname"))), optJSONObject2.optString("docId"), optJSONObject2.optString("appId"));
                AppMethodBeat.o(235417);
                return;
            case 3:
                czc czc = new czc();
                czc.KWb = jSONObject.optInt("actionType");
                JSONObject optJSONObject3 = jSONObject.optJSONObject("actionInfo");
                czc.UserName = optJSONObject3.optString("userName");
                czc.Lrs = optJSONObject3.optString("relativeURL");
                czc.Lrt = optJSONObject3.optInt("appVersion");
                czc.query = optJSONObject3.optString(SearchIntents.EXTRA_QUERY, "");
                czc.MEp = optJSONObject3.optString("extParams");
                czc.xIy = optJSONObject3.optString("jumpUrl");
                this.xbE.a(czc);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject.put("type", "pardusAction");
                jSONObject.put("actionId", "1");
                jSONObject.put(NativeProtocol.WEB_DIALOG_PARAMS, jSONObject);
                final String jSONObject5 = jSONObject4.toString();
                this.xbE.xfV.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.fts.ui.widget.j.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(184536);
                        j.this.hA("pardusActionCallBack", jSONObject5);
                        AppMethodBeat.o(184536);
                    }
                });
                this.xbE.Nz(4);
                this.xbE.xfV.xbX.xbD.Nv(27);
                this.xbE.xfV.xbX.xby = true;
                if (this.xgF) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                l.a(optJSONObject3.optString(SearchIntents.EXTRA_QUERY), i3, 1, this.xbE.xfV.mve, this.xbE.xfV.xbX.xbD, 27, "3$".concat(String.valueOf(optJSONObject3.optString("nickname"))), optJSONObject3.optString("docId"), optJSONObject3.optString("appId"));
                break;
        }
        AppMethodBeat.o(235417);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(235418);
        Log.i("MicroMsg.FTS.PardusWebViewLogic", "onSceneEnd errType:%s errCode:%s errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar instanceof w) {
            w wVar = (w) qVar;
            String nullAs = Util.nullAs(wVar.fxY().NvZ, "");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("retCode", i3);
                jSONObject.put("errMsg", str);
                jSONObject.put("json", nullAs);
                jSONObject.put("requestId", wVar.dPI);
            } catch (Exception e2) {
            }
            final String jSONObject2 = jSONObject.toString();
            this.xbE.xfV.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.fts.ui.widget.j.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(176943);
                    j.this.hA("pardusCommCgiReady", jSONObject2);
                    AppMethodBeat.o(176943);
                }
            });
        }
        AppMethodBeat.o(235418);
    }

    @Override // com.tencent.mm.plugin.websearch.webview.d
    public final WebSearchWebView dQg() {
        return this.xgX;
    }

    @Override // com.tencent.mm.plugin.websearch.webview.d
    public final Context getActivityContext() {
        return this.xbE.xfV;
    }

    @Override // com.tencent.mm.plugin.websearch.webview.c
    public final g<fas> dQh() {
        return this.xha;
    }

    @Override // com.tencent.mm.plugin.websearch.webview.c
    public final com.tencent.mm.plugin.websearch.webview.h<fas> dQi() {
        return this.xhb;
    }

    @Override // com.tencent.mm.plugin.fts.ui.widget.d
    public final void hVN() {
        AppMethodBeat.i(258250);
        com.tencent.f.h.RTc.aV(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
              (wrap: com.tencent.f.i : 0x0008: SGET  (r1v0 com.tencent.f.i) =  com.tencent.f.h.RTc com.tencent.f.i)
              (wrap: com.tencent.mm.plugin.fts.ui.widget.i$13 : 0x000c: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.fts.ui.widget.i$13) = 
              (wrap: com.tencent.mm.plugin.fts.ui.widget.i : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.fts.ui.widget.i) = (r4v0 'this' com.tencent.mm.plugin.fts.ui.widget.j A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.fts.ui.widget.j.xbE com.tencent.mm.plugin.fts.ui.widget.i)
             call: com.tencent.mm.plugin.fts.ui.widget.i.13.<init>(com.tencent.mm.plugin.fts.ui.widget.i):void type: CONSTRUCTOR)
             type: INTERFACE call: com.tencent.f.i.aV(java.lang.Runnable):com.tencent.f.i.d in method: com.tencent.mm.plugin.fts.ui.widget.j.hVN():void, file: classes7.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.fts.ui.widget.i$13) = 
              (wrap: com.tencent.mm.plugin.fts.ui.widget.i : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.fts.ui.widget.i) = (r4v0 'this' com.tencent.mm.plugin.fts.ui.widget.j A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.fts.ui.widget.j.xbE com.tencent.mm.plugin.fts.ui.widget.i)
             call: com.tencent.mm.plugin.fts.ui.widget.i.13.<init>(com.tencent.mm.plugin.fts.ui.widget.i):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.fts.ui.widget.j.hVN():void, file: classes7.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.fts.ui.widget.i, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
            this = this;
            r3 = 258250(0x3f0ca, float:3.61885E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            com.tencent.mm.plugin.fts.ui.widget.i r0 = r4.xbE
            com.tencent.f.i r1 = com.tencent.f.h.RTc
            com.tencent.mm.plugin.fts.ui.widget.i$13 r2 = new com.tencent.mm.plugin.fts.ui.widget.i$13
            r2.<init>()
            r1.aV(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.widget.j.hVN():void");
    }

    @Override // com.tencent.mm.plugin.websearch.webview.d
    public final /* bridge */ /* synthetic */ com.tencent.mm.plugin.websearch.webview.b dQj() {
        return this.xhb;
    }

    @Override // com.tencent.mm.plugin.websearch.webview.d
    public final /* bridge */ /* synthetic */ com.tencent.mm.plugin.websearch.webview.a dQk() {
        return this.xha;
    }

    @Override // com.tencent.mm.plugin.websearch.webview.d
    public final /* bridge */ /* synthetic */ Object dQl() {
        return this.xgZ;
    }
}
