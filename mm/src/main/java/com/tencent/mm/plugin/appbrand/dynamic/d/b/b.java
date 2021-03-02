package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements Runnable {
    public JSONObject lnV;
    public com.tencent.mm.plugin.appbrand.dynamic.d.b lnW;
    public b.a lnX;
    public e lnY;
    public String lnZ;
    public long loa;
    public String process;
    public String viewId;

    public final void a(String str, String str2, JSONObject jSONObject, com.tencent.mm.plugin.appbrand.dynamic.d.b bVar, b.a aVar, e eVar, String str3) {
        AppMethodBeat.i(121369);
        this.process = str;
        this.viewId = str2;
        this.lnV = jSONObject;
        this.lnW = bVar;
        this.lnX = aVar;
        this.lnY = eVar;
        this.lnZ = str3;
        this.loa = System.currentTimeMillis();
        AppMethodBeat.o(121369);
    }

    public final void run() {
        final DrawCanvasArg drawCanvasArg;
        AppMethodBeat.i(121370);
        if (this.lnY.YA(this.lnZ)) {
            u.v("DrawCanvasRunnable", "running draw", new Object[0]);
            Bundle bundle = new Bundle();
            bundle.putString("viewId", this.viewId);
            bundle.putInt("drawStrategy", this.lnY.bCe());
            bundle.putString("remoteProcess", g.axZ());
            a.dc(this.viewId, this.lnZ);
            switch (this.lnY.bCe()) {
                case 0:
                case 2:
                    drawCanvasArg = (DrawCanvasArg) this.lnY.d(this.lnV, this.lnZ);
                    this.lnY.cB(drawCanvasArg);
                    bundle.putParcelable("jsApiInvokeDataObj", drawCanvasArg);
                    break;
                case 1:
                    this.lnY.cB(this.lnZ);
                    bundle.putString("jsApiInvokeData", (String) this.lnY.d(this.lnV, this.lnZ));
                    drawCanvasArg = null;
                    break;
                default:
                    drawCanvasArg = null;
                    break;
            }
            String G = d.G(this.lnV);
            CollectSession cP = c.cP(G, "after_jsapi_invoke");
            bundle.putString("__session_id", G);
            bundle.putParcelable("__cost_time_session", cP);
            v.pl(19);
            hr vt = new hr().vt(u.Lv(this.viewId));
            vt.eBS = (long) u.Lt(this.viewId);
            vt.eMi = 11;
            hr vs = vt.vs(this.viewId);
            vs.eMj = System.currentTimeMillis();
            vs.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
            if (h.a(this.process, bundle, a.class, new com.tencent.mm.ipcinvoker.d<Bundle>() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.d.b.b.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(Bundle bundle) {
                    AppMethodBeat.i(121363);
                    Bundle bundle2 = bundle;
                    if (!(b.this.lnX == null || b.this.lnW == null)) {
                        b.this.lnX.bt(b.this.lnW.a(bundle2.getBoolean("ret"), bundle2.getString("reason", ""), (Map<String, ? extends Object>) null));
                    }
                    u.i("DrawCanvasRunnable", "invoke callback", new Object[0]);
                    if (!g.Fp(b.this.process)) {
                        b.this.lnY.W(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.dynamic.d.b.b.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(121362);
                                if (drawCanvasArg != null) {
                                    drawCanvasArg.reset();
                                }
                                AppMethodBeat.o(121362);
                            }
                        });
                    }
                    View Yj = com.tencent.mm.plugin.appbrand.dynamic.e.bBI().Yj(b.this.viewId);
                    if (Yj instanceof com.tencent.mm.plugin.appbrand.dynamic.h) {
                        ((com.tencent.mm.plugin.appbrand.dynamic.h) Yj).bBK();
                    }
                    AppMethodBeat.o(121363);
                }
            })) {
                this.lnY.bCd();
                AppMethodBeat.o(121370);
                return;
            }
            if (drawCanvasArg != null) {
                drawCanvasArg.reset();
            }
            AppMethodBeat.o(121370);
            return;
        }
        if (!(this.lnX == null || this.lnW == null)) {
            this.lnX.bt(this.lnW.a(true, "same actions with last draw, drop this", (Map<String, ? extends Object>) null));
        }
        AppMethodBeat.o(121370);
    }

    static class a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(121368);
            Bundle bundle2 = bundle;
            int i2 = bundle2.getInt("drawStrategy");
            u.v("DrawCanvasRunnable", "IPCInvoke_DrawCanvas strategy %d", Integer.valueOf(i2));
            switch (i2) {
                case 0:
                    String string = bundle2.getString("__session_id");
                    c.a((CollectSession) bundle2.getParcelable("__cost_time_session"));
                    c.cP(string, "after_cross_process_invoke");
                    Bundle bundle3 = new Bundle();
                    final String string2 = bundle2.getString("viewId");
                    View Yj = com.tencent.mm.plugin.appbrand.dynamic.e.bBI().Yj(string2);
                    DrawCanvasArg drawCanvasArg = (DrawCanvasArg) bundle2.getParcelable("jsApiInvokeDataObj");
                    final String string3 = bundle2.getString("remoteProcess");
                    if (!(Yj instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a)) {
                        if (drawCanvasArg != null) {
                            drawCanvasArg.reset();
                        }
                        Log.i("DrawCanvasRunnable", "drawCanvas failed, view is not a instance of DrawableView.(%s)", string2);
                        bundle3.putBoolean("ret", false);
                        bundle3.putString("reason", "view is not a instance of DrawableView");
                        dVar.bn(bundle3);
                        AppMethodBeat.o(121368);
                        return;
                    }
                    final int i3 = bundle2.getInt("drawStrategy");
                    if (drawCanvasArg != null) {
                        c.cP(string, "after_cp_parse_json_end");
                        if (Yj instanceof com.tencent.mm.plugin.appbrand.collector.d) {
                            com.tencent.mm.plugin.appbrand.collector.d dVar2 = (com.tencent.mm.plugin.appbrand.collector.d) Yj;
                            dVar2.setSessionId(string);
                            dVar2.setStartTime(drawCanvasArg.laz);
                        }
                        com.tencent.mm.plugin.appbrand.canvas.widget.a aVar = (com.tencent.mm.plugin.appbrand.canvas.widget.a) Yj;
                        if (drawCanvasArg.lax) {
                            aVar.b(drawCanvasArg, (a.AbstractC0561a) null);
                        } else {
                            aVar.a(drawCanvasArg, new a.AbstractC0561a() {
                                /* class com.tencent.mm.plugin.appbrand.dynamic.d.b.b.a.AnonymousClass2 */

                                @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a.AbstractC0561a
                                public final void a(final DrawCanvasArg drawCanvasArg) {
                                    AppMethodBeat.i(121367);
                                    if (g.Fp(string3)) {
                                        a.bH(string2, i3).W(new Runnable() {
                                            /* class com.tencent.mm.plugin.appbrand.dynamic.d.b.b.a.AnonymousClass2.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(121366);
                                                Log.v("DrawCanvasRunnable", "running release");
                                                if (drawCanvasArg != null) {
                                                    drawCanvasArg.reset();
                                                }
                                                AppMethodBeat.o(121366);
                                            }
                                        });
                                        AppMethodBeat.o(121367);
                                        return;
                                    }
                                    if (drawCanvasArg != null) {
                                        drawCanvasArg.reset();
                                    }
                                    AppMethodBeat.o(121367);
                                }
                            });
                        }
                        aVar.bzg();
                        bundle3.putBoolean("ret", true);
                        dVar.bn(bundle3);
                        AppMethodBeat.o(121368);
                        return;
                    }
                    Log.e("DrawCanvasRunnable", "no draw actions");
                    bundle3.putBoolean("ret", false);
                    bundle3.putString("reason", "no draw actions");
                    dVar.bn(bundle3);
                    AppMethodBeat.o(121368);
                    return;
                case 1:
                    String string4 = bundle2.getString("__session_id");
                    c.a((CollectSession) bundle2.getParcelable("__cost_time_session"));
                    c.cP(string4, "after_cross_process_invoke");
                    Bundle bundle4 = new Bundle();
                    String string5 = bundle2.getString("viewId");
                    View Yj2 = com.tencent.mm.plugin.appbrand.dynamic.e.bBI().Yj(string5);
                    if (!(Yj2 instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a)) {
                        Log.i("DrawCanvasRunnable", "drawCanvas failed, view is not a instance of DrawableView.(%s)", string5);
                        bundle4.putBoolean("ret", false);
                        bundle4.putString("reason", "view is not a instance of DrawableView");
                        dVar.bn(bundle4);
                        AppMethodBeat.o(121368);
                        return;
                    }
                    try {
                        JSONObject FE = com.tencent.mm.ab.h.FE(bundle2.getString("jsApiInvokeData"));
                        JSONArray optJSONArray = FE.optJSONArray("actions");
                        boolean optBoolean = FE.optBoolean("reserve");
                        c.cP(string4, "after_cp_parse_json_end");
                        if (Yj2 instanceof com.tencent.mm.plugin.appbrand.collector.d) {
                            com.tencent.mm.plugin.appbrand.collector.d dVar3 = (com.tencent.mm.plugin.appbrand.collector.d) Yj2;
                            dVar3.setSessionId(string4);
                            dVar3.setStartTime(FE.optLong("__invoke_jsapi_timestamp"));
                        }
                        com.tencent.mm.plugin.appbrand.canvas.widget.a aVar2 = (com.tencent.mm.plugin.appbrand.canvas.widget.a) Yj2;
                        if (optBoolean) {
                            aVar2.b(optJSONArray, (a.AbstractC0561a) null);
                        } else {
                            aVar2.a(optJSONArray, (a.AbstractC0561a) null);
                        }
                        aVar2.bzg();
                        bundle4.putBoolean("ret", true);
                        dVar.bn(bundle4);
                        AppMethodBeat.o(121368);
                        return;
                    } catch (JSONException e2) {
                        Log.e("DrawCanvasRunnable", "drawCanvas failed, IPC parse JSONObject error : %s", e2);
                        bundle4.putBoolean("ret", false);
                        bundle4.putString("reason", "parse json data error");
                        dVar.bn(bundle4);
                        AppMethodBeat.o(121368);
                        return;
                    }
                default:
                    String string6 = bundle2.getString("__session_id");
                    c.a((CollectSession) bundle2.getParcelable("__cost_time_session"));
                    c.cP(string6, "after_cross_process_invoke");
                    Bundle bundle5 = new Bundle();
                    final String string7 = bundle2.getString("viewId");
                    View Yj3 = com.tencent.mm.plugin.appbrand.dynamic.e.bBI().Yj(string7);
                    DrawCanvasArg drawCanvasArg2 = (DrawCanvasArg) bundle2.getParcelable("jsApiInvokeDataObj");
                    if (!(Yj3 instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a)) {
                        if (drawCanvasArg2 != null) {
                            drawCanvasArg2.reset();
                        }
                        Log.i("DrawCanvasRunnable", "drawCanvas failed, view is not a instance of DrawableView.(%s)", string7);
                        bundle5.putBoolean("ret", false);
                        bundle5.putString("reason", "view is not a instance of DrawableView");
                        dVar.bn(bundle5);
                        AppMethodBeat.o(121368);
                        return;
                    }
                    final int i4 = bundle2.getInt("drawStrategy");
                    if (drawCanvasArg2 != null) {
                        c.cP(string6, "after_cp_parse_json_end");
                        if (Yj3 instanceof com.tencent.mm.plugin.appbrand.collector.d) {
                            com.tencent.mm.plugin.appbrand.collector.d dVar4 = (com.tencent.mm.plugin.appbrand.collector.d) Yj3;
                            dVar4.setSessionId(string6);
                            dVar4.setStartTime(drawCanvasArg2.laz);
                        }
                        com.tencent.mm.plugin.appbrand.canvas.widget.a aVar3 = (com.tencent.mm.plugin.appbrand.canvas.widget.a) Yj3;
                        if (drawCanvasArg2.lax) {
                            aVar3.b(drawCanvasArg2, (a.AbstractC0561a) null);
                        } else {
                            try {
                                drawCanvasArg2.laB = new JSONObject(drawCanvasArg2.lay).optJSONArray("actions");
                            } catch (JSONException e3) {
                                Log.e("DrawCanvasArg", "drawCanvas failed, IPC parse JSONObject error : %s", e3);
                            }
                            aVar3.a(drawCanvasArg2, new a.AbstractC0561a() {
                                /* class com.tencent.mm.plugin.appbrand.dynamic.d.b.b.a.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a.AbstractC0561a
                                public final void a(final DrawCanvasArg drawCanvasArg) {
                                    AppMethodBeat.i(121365);
                                    a.bH(string7, i4).W(new Runnable() {
                                        /* class com.tencent.mm.plugin.appbrand.dynamic.d.b.b.a.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(121364);
                                            Log.v("DrawCanvasRunnable", "running release");
                                            if (drawCanvasArg != null) {
                                                drawCanvasArg.reset();
                                            }
                                            AppMethodBeat.o(121364);
                                        }
                                    });
                                    AppMethodBeat.o(121365);
                                }
                            });
                            if (drawCanvasArg2.laC == null) {
                                drawCanvasArg2.laC = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x029f: IPUT  
                                      (wrap: com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg$1 : 0x029c: CONSTRUCTOR  (r1v39 com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg$1) = (r0v58 'drawCanvasArg2' com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg) call: com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg.1.<init>(com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg):void type: CONSTRUCTOR)
                                      (r0v58 'drawCanvasArg2' com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg)
                                     com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg.laC com.tencent.f.i.b in method: com.tencent.mm.plugin.appbrand.dynamic.d.b.b.a.invoke(android.os.Bundle, com.tencent.mm.ipcinvoker.d<android.os.Bundle>):void, file: classes3.dex
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
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x029c: CONSTRUCTOR  (r1v39 com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg$1) = (r0v58 'drawCanvasArg2' com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg) call: com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg.1.<init>(com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.dynamic.d.b.b.a.invoke(android.os.Bundle, com.tencent.mm.ipcinvoker.d<android.os.Bundle>):void, file: classes3.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 40 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 44 more
                                    */
                                /*
                                // Method dump skipped, instructions count: 742
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.dynamic.d.b.b.a.invoke(java.lang.Object, com.tencent.mm.ipcinvoker.d):void");
                            }
                        }
                    }
