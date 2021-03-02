package com.tencent.mm.plugin.appbrand.game.f;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.luggage.game.page.h;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.af;
import com.tencent.mm.plugin.appbrand.bb;
import com.tencent.mm.plugin.appbrand.game.a.s;
import com.tencent.mm.plugin.appbrand.game.e.b.b;
import com.tencent.mm.plugin.appbrand.game.f.a.b;
import com.tencent.mm.plugin.appbrand.game.f.a.c;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.protocal.protobuf.fdn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;

public class e<PAGE extends ag> extends h<PAGE> implements a {
    private MagicBrushView ltj = null;
    private b ltk = null;

    public e(PAGE page) {
        super(page);
    }

    @Override // com.tencent.luggage.game.page.h
    public final MagicBrushView aH(Context context) {
        MagicBrushView.b bVar;
        AppMethodBeat.i(45188);
        long currentTicks = Util.currentTicks();
        boolean booleanValue = ((Boolean) s.lrT.aLT()).booleanValue();
        Log.i("MicroMsg.WAGamePageViewRendererWC", "hy: create magicbrush view in wc, use texture view: %b", Boolean.valueOf(booleanValue));
        if (booleanValue) {
            bVar = new c(context);
        } else {
            bVar = new b(context);
        }
        this.ltj = new MagicBrushView(context, bVar);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepCreateMagicBrushView, "", currentTicks, Util.currentTicks());
        MagicBrushView magicBrushView = this.ltj;
        AppMethodBeat.o(45188);
        return magicBrushView;
    }

    @Override // com.tencent.luggage.game.page.d, com.tencent.luggage.game.page.h, com.tencent.mm.plugin.appbrand.game.f.a
    public final MagicBrushView MQ() {
        return this.ltj;
    }

    @Override // com.tencent.luggage.game.page.h, com.tencent.mm.plugin.appbrand.page.ae
    public final void cb(View view) {
        AppMethodBeat.i(226620);
        super.cb(view);
        if (bDp()) {
            View view2 = new View(getContext());
            view2.setBackgroundResource(R.color.w);
            this.cwY.addView(view2, this.cwY.indexOfChild(this.cxb), new FrameLayout.LayoutParams(-1, -1));
            View view3 = new View(getContext());
            view3.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Integer.MIN_VALUE, 0}));
            int statusBarHeight = au.getStatusBarHeight(getContext()) + a.aH(getContext(), R.dimen.or);
            this.cwY.addView(view3, new FrameLayout.LayoutParams(-1, statusBarHeight));
            com.tencent.luggage.game.d.a.a.b bVar = (com.tencent.luggage.game.d.a.a.b) ((ag) NN()).bsE().S(com.tencent.luggage.game.d.a.a.b.class);
            if (bVar != null) {
                com.tencent.luggage.game.c.e Mg = bVar.Mg();
                if (!(Mg.cvh == null || Mg.cvh.getView() == null)) {
                    View view4 = Mg.cvh.getView();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view4.getLayoutParams();
                    layoutParams.topMargin = statusBarHeight;
                    layoutParams.bottomMargin = 52;
                    view4.setLayoutParams(layoutParams);
                }
            }
            ((ag) NN()).getFullscreenImpl().a(new com.tencent.mm.plugin.appbrand.platform.window.b() {
                /* class com.tencent.mm.plugin.appbrand.game.f.e.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.platform.window.b
                public final void bDq() {
                    AppMethodBeat.i(226618);
                    ((ag) e.this.NN()).bRi().setVisibility(4);
                    ((ag) e.this.NN()).nrv.setVisibility(4);
                    AppMethodBeat.o(226618);
                }

                @Override // com.tencent.mm.plugin.appbrand.platform.window.b
                public final void Na() {
                    AppMethodBeat.i(226619);
                    ((ag) e.this.NN()).bRi().setVisibility(0);
                    ((ag) e.this.NN()).nrv.setVisibility(0);
                    AppMethodBeat.o(226619);
                }
            });
        }
        AppMethodBeat.o(226620);
    }

    @Override // com.tencent.luggage.game.page.h, com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
    public final void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar) {
        AppMethodBeat.i(226621);
        if (bDp()) {
            bVar.setFullscreenMode(false);
            bVar.setBackgroundAlpha(0.0d);
            bVar.setForegroundColor(-1);
            bVar.setMainTitle(NP().ON().brandName);
            AppMethodBeat.o(226621);
            return;
        }
        super.b(bVar);
        AppMethodBeat.o(226621);
    }

    @Override // com.tencent.luggage.game.page.h, com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
    public final void dispatchStart() {
        AppMethodBeat.i(226622);
        super.dispatchStart();
        if (bDp()) {
            ((com.tencent.mm.plugin.appbrand.page.a.h) S(com.tencent.mm.plugin.appbrand.page.a.h.class)).Nj();
        }
        AppMethodBeat.o(226622);
    }

    @Override // com.tencent.luggage.game.page.h, com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
    public final void Ne() {
        AppMethodBeat.i(45189);
        if (com.tencent.mm.plugin.appbrand.h.Uc(((ag) NN()).getAppId()) == h.d.CLOSE && this.ltk != null && this.ltk.bDk()) {
            new com.tencent.mm.plugin.appbrand.game.e.b.b().a(((ag) NN()).bsE(), b.a.BeforeBack, 0);
        }
        super.Ne();
        AppMethodBeat.o(45189);
    }

    @Override // com.tencent.luggage.game.page.h, com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
    public final void dispatchDestroy() {
        AppMethodBeat.i(45190);
        String appId = ((ag) NN()).getAppId();
        Log.i("MicroMsg.OnStartReportCanvasDataEvent", "stopListeningOperationEvent, appId:%s", appId);
        if (com.tencent.mm.plugin.appbrand.game.e.b.b.kYj != null) {
            MMToClientEvent.b(appId, com.tencent.mm.plugin.appbrand.game.e.b.b.kYj);
            com.tencent.mm.plugin.appbrand.game.e.b.b.kYj = null;
        }
        super.dispatchDestroy();
        AppMethodBeat.o(45190);
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a
    public final b bDj() {
        return this.ltk;
    }

    @Override // com.tencent.luggage.game.page.h
    public final void Nb() {
        AppMethodBeat.i(45192);
        b(a.class, this);
        AppMethodBeat.o(45192);
    }

    private boolean bDp() {
        AppMethodBeat.i(226623);
        boolean r = bb.r(((ag) NN()).getRuntime());
        AppMethodBeat.o(226623);
        return r;
    }

    @Override // com.tencent.luggage.game.page.h, com.tencent.luggage.game.page.b.AbstractC0174b
    public final void ca(View view) {
        AppMethodBeat.i(226624);
        if (!af.p(((ag) NN()).getRuntime())) {
            AppMethodBeat.o(226624);
            return;
        }
        super.ca(view);
        AppMethodBeat.o(226624);
    }

    @Override // com.tencent.mm.plugin.appbrand.game.f.a
    public final void a(com.tencent.mm.plugin.appbrand.report.b bVar) {
        AppMethodBeat.i(45191);
        fdn fdn = bVar.nGe;
        this.ltk = new b(fdn, NP());
        if (fdn == null || !fdn.NyX) {
            Log.w("MicroMsg.WAGamePageViewRendererWC", "hy: no server config or do not need sample. do not do anything");
            AppMethodBeat.o(45191);
            return;
        }
        Log.i("MicroMsg.WAGamePageViewRendererWC", "hy: should do server sample");
        b bVar2 = this.ltk;
        if (bVar2.lsZ == null || bVar2.bDl() == null || Util.isNullOrNil(bVar2.lsZ.Nzf) || !bVar2.lsZ.NyX || bVar2.ltb == null) {
            Log.w("MicroMsg.WAGameCanvasSecurityGuard", "hy: should not do server config!");
            AppMethodBeat.o(45191);
        } else if (bVar2.bDm()) {
            Log.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: running, trigger send event after 1 sec");
            MMHandlerThread.postToMainThreadDelayed(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0065: INVOKE  
                  (wrap: com.tencent.mm.plugin.appbrand.game.f.b$1 : 0x0060: CONSTRUCTOR  (r1v15 com.tencent.mm.plugin.appbrand.game.f.b$1) = (r0v4 'bVar2' com.tencent.mm.plugin.appbrand.game.f.b) call: com.tencent.mm.plugin.appbrand.game.f.b.1.<init>(com.tencent.mm.plugin.appbrand.game.f.b):void type: CONSTRUCTOR)
                  (1000 long)
                 type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThreadDelayed(java.lang.Runnable, long):void in method: com.tencent.mm.plugin.appbrand.game.f.e.a(com.tencent.mm.plugin.appbrand.report.b):void, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0060: CONSTRUCTOR  (r1v15 com.tencent.mm.plugin.appbrand.game.f.b$1) = (r0v4 'bVar2' com.tencent.mm.plugin.appbrand.game.f.b) call: com.tencent.mm.plugin.appbrand.game.f.b.1.<init>(com.tencent.mm.plugin.appbrand.game.f.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.game.f.e.a(com.tencent.mm.plugin.appbrand.report.b):void, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 25 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.game.f.b, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 31 more
                */
            /*
            // Method dump skipped, instructions count: 134
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.game.f.e.a(com.tencent.mm.plugin.appbrand.report.b):void");
        }
    }
