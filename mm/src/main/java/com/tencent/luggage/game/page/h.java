package com.tencent.luggage.game.page;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.luggage.game.c.e;
import com.tencent.luggage.game.d.a.a.d;
import com.tencent.luggage.game.page.WAGamePageViewContainerLayout;
import com.tencent.luggage.game.page.b;
import com.tencent.luggage.h.j;
import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.b.a.c.f;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.AppBrandPageFullScreenView;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.page.bg;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class h<PAGE extends c> extends a<PAGE> implements b.AbstractC0174b, d {
    protected WAGamePageViewContainerLayout cwY;
    private MagicBrushView cwZ;
    private ao cxa;
    protected b cxb;
    private Bitmap cxc;
    private Bitmap cxd;
    private ImageView cxe;
    private final a cxf = new a();
    double cxg = 60.0d;
    private AtomicBoolean cxh = new AtomicBoolean(false);
    private final View.OnAttachStateChangeListener cxi = new View.OnAttachStateChangeListener() {
        /* class com.tencent.luggage.game.page.h.AnonymousClass1 */

        public final void onViewAttachedToWindow(View view) {
            AppMethodBeat.i(130651);
            Log.i("Luggage.Game.WAGamePageViewRenderer", "WAGamePageView onAttachedToWindow, notify mb foreground once");
            h.this.cwZ.getMagicBrush().Rc();
            h.this.cwZ.post(new Runnable() {
                /* class com.tencent.luggage.game.page.h.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(130650);
                    h.this.cwY.removeOnAttachStateChangeListener(this);
                    AppMethodBeat.o(130650);
                }
            });
            AppMethodBeat.o(130651);
        }

        public final void onViewDetachedFromWindow(View view) {
        }
    };

    public h(PAGE page) {
        super(page);
        AppMethodBeat.i(130656);
        Nb();
        f fVar = page.NQ().cBj;
        synchronized (this.czn) {
            try {
                this.czn.putAll(fVar.czn);
            } finally {
                AppMethodBeat.o(130656);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void Nb() {
        AppMethodBeat.i(130657);
        b(d.class, this);
        AppMethodBeat.o(130657);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public final View a(LayoutInflater layoutInflater) {
        AppMethodBeat.i(130658);
        WAGamePageViewContainerLayout wAGamePageViewContainerLayout = new WAGamePageViewContainerLayout(layoutInflater.getContext());
        this.cwY = wAGamePageViewContainerLayout;
        AppMethodBeat.o(130658);
        return wAGamePageViewContainerLayout;
    }

    /* access modifiers changed from: protected */
    public MagicBrushView aH(Context context) {
        AppMethodBeat.i(130659);
        MagicBrushView magicBrushView = new MagicBrushView(context, MagicBrushView.h.SurfaceView);
        AppMethodBeat.o(130659);
        return magicBrushView;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ae
    public void cb(View view) {
        AppMethodBeat.i(130660);
        com.tencent.luggage.game.d.a.a.b bVar = (com.tencent.luggage.game.d.a.a.b) S(com.tencent.luggage.game.d.a.a.b.class);
        if (bVar == null) {
            Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", new d(), "hy: not on game service!", new Object[0]);
            AppMethodBeat.o(130660);
            return;
        }
        this.cwZ = aH(getContext());
        this.cwZ.setId(R.id.oa);
        e magicBrush = bVar.getMagicBrush();
        this.cwZ.setMagicBrush(magicBrush);
        magicBrush.cLy.add(new e.b() {
            /* class com.tencent.luggage.game.page.h.AnonymousClass2 */

            @Override // com.tencent.magicbrush.e.b
            public final void onFirstFrame() {
                AppMethodBeat.i(130652);
                if (h.this.cxh.compareAndSet(false, true)) {
                    ((c) h.this.NN()).adM("onFirstFrame");
                    com.tencent.mm.plugin.appbrand.keylogger.c.b(h.this.getAppId(), KSProcessWeAppLaunch.stepPageReady_Game);
                    com.tencent.mm.plugin.appbrand.keylogger.c.b(h.this.getAppId(), KSProcessWeAppLaunch.stepPageInit_Game);
                }
                AppMethodBeat.o(130652);
            }
        });
        this.cwY.addView(this.cwZ, 0, new FrameLayout.LayoutParams(-1, -1));
        this.cxb = new b(getContext());
        this.cxb.setNativeWidgetAddedCallback(this);
        this.cwY.addView(this.cxb, -1, new ViewGroup.LayoutParams(-1, -1));
        this.cxa = new c(this.cxb);
        this.cxa.setFullscreenImpl(((c) NN()).getFullscreenImpl());
        this.cxa.a(new bd() {
            /* class com.tencent.luggage.game.page.h.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.page.bd
            public final void a(AppBrandPageFullScreenView appBrandPageFullScreenView) {
                AppMethodBeat.i(130653);
                if (appBrandPageFullScreenView != null && appBrandPageFullScreenView.getParent() == null) {
                    h.this.cwY.addView(appBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
                }
                AppMethodBeat.o(130653);
            }
        });
        ao aoVar = this.cxa;
        AnonymousClass4 r1 = new bg() {
            /* class com.tencent.luggage.game.page.h.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.page.bg
            public final void a(FrameLayout frameLayout) {
                AppMethodBeat.i(178040);
                if (frameLayout != null && frameLayout.getParent() == null) {
                    h.this.cwY.addView(frameLayout, 0, new ViewGroup.LayoutParams(-1, -1));
                }
                AppMethodBeat.o(178040);
            }
        };
        Log.i("MicroMsg.AppBrandWebViewCustomViewContainer", "setUnderViewAttacher notnull:%b", Boolean.TRUE);
        aoVar.nsE = r1;
        if (aoVar.nsD != null) {
            if (ao.$assertionsDisabled || aoVar.nsE != null) {
                aoVar.nsE.a(aoVar.nsD);
            } else {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(130660);
                throw assertionError;
            }
        }
        boolean z = ((c) NN()).NP().OM().cyC;
        boolean z2 = ((c) NN()).NP().OM().cyC;
        if (z || z2) {
            final com.tencent.luggage.game.d.a.a.b bVar2 = (com.tencent.luggage.game.d.a.a.b) ((c) NN()).NQ().S(com.tencent.luggage.game.d.a.a.b.class);
            if (bVar2 != null) {
                com.tencent.luggage.game.c.e Mg = bVar2.Mg();
                e.b bVar3 = new e.b();
                bVar3.cuQ = (k) NN();
                bVar3.cvr = bVar2.getMagicBrush();
                bVar3.cvs = this.cwY;
                bVar3.cvt = z;
                bVar3.cvu = z2;
                bVar3.cvv = new e.c() {
                    /* class com.tencent.luggage.game.page.h.AnonymousClass5 */

                    @Override // com.tencent.luggage.game.c.e.c
                    public final void F(List<com.tencent.luggage.game.c.f> list) {
                        AppMethodBeat.i(178041);
                        try {
                            h hVar = h.this;
                            com.tencent.magicbrush.e magicBrush = bVar2.getMagicBrush();
                            if (magicBrush == null) {
                                Log.e("Luggage.Game.WAGamePageViewRenderer", "hy: can not retrieve runtime!");
                                AppMethodBeat.o(178041);
                                return;
                            }
                            com.tencent.magicbrush.a QP = magicBrush.cxx.QP();
                            list.add(new com.tencent.luggage.game.c.f("MinFPS", new StringBuilder().append(Math.round(hVar.cxg)).toString()));
                            list.add(new com.tencent.luggage.game.c.f("RT-FPS", new StringBuilder().append(Math.round(QP.cKu)).toString()));
                            list.add(new com.tencent.luggage.game.c.f("EX-FPS", new StringBuilder().append(Math.round(QP.cKv)).toString()));
                            AppMethodBeat.o(178041);
                        } catch (Exception e2) {
                            AppMethodBeat.o(178041);
                        }
                    }
                };
                Mg.cuW = bVar3.cvr;
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    IllegalStateException illegalStateException = new IllegalStateException("You can only init GameInspector in main thread.");
                    AppMethodBeat.o(130660);
                    throw illegalStateException;
                } else if (Mg.mState == 0) {
                    Mg.mContext = bVar3.cvs.getContext();
                    if (bVar3.cvt) {
                        e.c cVar = bVar3.cvv;
                        Mg.cvg = new com.tencent.luggage.game.c.d(Mg.mContext);
                        Mg.cvg.cvd = cVar;
                        Mg.cvg.setBackground(Mg.mContext.getResources().getDrawable(R.drawable.cx));
                    }
                    if (bVar3.cvu) {
                        Mg.cvh = com.tencent.luggage.game.c.b.a(Mg.cuW, Mg.mContext, bVar3.cuQ);
                    }
                    FrameLayout frameLayout = bVar3.cvs;
                    frameLayout.setClipChildren(false);
                    float f2 = Mg.mContext.getResources().getDisplayMetrics().density;
                    if (Mg.cvh != null) {
                        frameLayout.addView(Mg.cvh.getView(), new FrameLayout.LayoutParams(-1, -1));
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 8388693;
                        layoutParams.bottomMargin = (int) (55.0f * f2);
                        int i2 = (int) (f2 * 15.0f);
                        layoutParams.rightMargin = i2;
                        layoutParams.leftMargin = i2;
                        frameLayout.addView(Mg.cvh.cuT, layoutParams);
                    }
                    if (Mg.cvg != null) {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams2.topMargin = j.cDv.aP(Mg.mContext);
                        frameLayout.addView(Mg.cvg, layoutParams2);
                    }
                    synchronized (Mg.cvi) {
                        try {
                            if (Mg.mState == 0) {
                                Mg.mState = 1;
                                if (bVar3.cvu && Mg.cvh != null) {
                                    Mg.cvh.post(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0222: INVOKE  
                                          (wrap: com.tencent.luggage.game.c.b : 0x021b: IGET  (r0v46 com.tencent.luggage.game.c.b) = (r4v2 'Mg' com.tencent.luggage.game.c.e) com.tencent.luggage.game.c.e.cvh com.tencent.luggage.game.c.b)
                                          (wrap: com.tencent.luggage.game.c.e$1 : 0x021f: CONSTRUCTOR  (r2v8 com.tencent.luggage.game.c.e$1) = (r4v2 'Mg' com.tencent.luggage.game.c.e) call: com.tencent.luggage.game.c.e.1.<init>(com.tencent.luggage.game.c.e):void type: CONSTRUCTOR)
                                         type: VIRTUAL call: com.tencent.luggage.game.c.b.post(java.lang.Runnable):void in method: com.tencent.luggage.game.page.h.cb(android.view.View):void, file: classes3.dex
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
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:249)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:71)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
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
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x021f: CONSTRUCTOR  (r2v8 com.tencent.luggage.game.c.e$1) = (r4v2 'Mg' com.tencent.luggage.game.c.e) call: com.tencent.luggage.game.c.e.1.<init>(com.tencent.luggage.game.c.e):void type: CONSTRUCTOR in method: com.tencent.luggage.game.page.h.cb(android.view.View):void, file: classes3.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 57 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.luggage.game.c.e, state: GENERATED_AND_UNLOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 63 more
                                        */
                                    /*
                                    // Method dump skipped, instructions count: 574
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.game.page.h.cb(android.view.View):void");
                                }

                                @Override // com.tencent.mm.plugin.appbrand.page.ae
                                public final RelativeLayout.LayoutParams cc(View view) {
                                    AppMethodBeat.i(222889);
                                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                                    AppMethodBeat.o(222889);
                                    return layoutParams;
                                }

                                @Override // com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
                                public void b(com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar) {
                                    AppMethodBeat.i(130661);
                                    bVar.setFullscreenMode(true);
                                    AppBrandCapsuleBarPlaceHolderView capsuleView = bVar.getCapsuleView();
                                    if (capsuleView != null && (capsuleView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) capsuleView.getLayoutParams();
                                        marginLayoutParams.rightMargin += bVar.getContext().getResources().getDimensionPixelSize(R.dimen.po);
                                        marginLayoutParams.topMargin += bVar.getContext().getResources().getDimensionPixelSize(R.dimen.pp);
                                        capsuleView.requestLayout();
                                    }
                                    AppMethodBeat.o(130661);
                                }

                                @Override // com.tencent.mm.plugin.appbrand.page.ae
                                public final bf Nc() {
                                    return this.cxb;
                                }

                                @Override // com.tencent.mm.plugin.appbrand.page.ae
                                public final ao getCustomViewContainer() {
                                    return this.cxa;
                                }

                                @Override // com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
                                public void dispatchStart() {
                                    AppMethodBeat.i(130662);
                                    super.dispatchStart();
                                    super.b(com.tencent.mm.plugin.appbrand.page.a.h.class, new com.tencent.luggage.game.page.a.b((ac) NN()));
                                    super.b(com.tencent.mm.plugin.appbrand.page.a.d.class, new g((ac) NN(), NP().getAppConfig().lbP.cBG));
                                    AppMethodBeat.o(130662);
                                }

                                @Override // com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
                                public final void Nd() {
                                    AppMethodBeat.i(130663);
                                    super.Nd();
                                    Nh();
                                    Ni();
                                    this.cwZ.getMagicBrush().Rc();
                                    AppMethodBeat.o(130663);
                                }

                                @Override // com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
                                public void Ne() {
                                    AppMethodBeat.i(130664);
                                    super.Ne();
                                    this.cwZ.getMagicBrush().Rd();
                                    AppMethodBeat.o(130664);
                                }

                                @Override // com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
                                public void dispatchDestroy() {
                                    AppMethodBeat.i(130665);
                                    super.dispatchDestroy();
                                    Nh();
                                    Ni();
                                    if (!(NN() == null || ((c) NN()).NQ() == null || ((c) NN()).NQ().S(com.tencent.luggage.game.d.a.a.b.class) == null)) {
                                        com.tencent.luggage.game.c.e Mg = ((com.tencent.luggage.game.d.a.a.b) ((c) NN()).NQ().S(com.tencent.luggage.game.d.a.a.b.class)).Mg();
                                        Mg.mState = 2;
                                        Mg.cvj.cxP.clear();
                                        Mg.cuW = null;
                                        if (Mg.cvh != null) {
                                            Mg.cvh.cuP.destroy();
                                            Mg.cvh = null;
                                        }
                                        if (Mg.cvg != null) {
                                            Mg.cvg.cve.stopTimer();
                                            Mg.cvg = null;
                                        }
                                    }
                                    AppMethodBeat.o(130665);
                                }

                                @Override // com.tencent.mm.plugin.appbrand.page.a.c
                                public final Map<String, p> Nf() {
                                    AppMethodBeat.i(130666);
                                    Map<String, p> emptyMap = Collections.emptyMap();
                                    AppMethodBeat.o(130666);
                                    return emptyMap;
                                }

                                @Override // com.tencent.mm.plugin.appbrand.page.ae
                                public final boolean dy(String str) {
                                    return true;
                                }

                                @Override // com.tencent.mm.plugin.appbrand.page.ae
                                public final void Ng() {
                                }

                                @Override // com.tencent.mm.plugin.appbrand.page.a.c
                                public final boolean b(String str, String str2, int i2) {
                                    AppMethodBeat.i(130667);
                                    ((c) NN()).NQ().c(str, str2, i2);
                                    AppMethodBeat.o(130667);
                                    return true;
                                }

                                @Override // com.tencent.mm.plugin.appbrand.page.a.c
                                public final boolean y(String str, String str2) {
                                    AppMethodBeat.i(222890);
                                    ((c) NN()).NQ().c(str, str2, 0);
                                    AppMethodBeat.o(222890);
                                    return true;
                                }

                                @Override // com.tencent.mm.plugin.appbrand.page.a.c
                                public final bb aI(Context context) {
                                    return this.cxf;
                                }

                                private void Nh() {
                                    AppMethodBeat.i(130668);
                                    if (this.cxe != null) {
                                        if (this.cxe.getDrawable() instanceof BitmapDrawable) {
                                            BitmapDrawable bitmapDrawable = (BitmapDrawable) this.cxe.getDrawable();
                                            this.cxe.setImageDrawable(null);
                                            try {
                                                bitmapDrawable.getBitmap().recycle();
                                            } catch (Exception e2) {
                                                Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", e2, "hy: cleanupCoverScreenshot error!", new Object[0]);
                                            }
                                        }
                                        this.cxe.setVisibility(8);
                                    }
                                    if (this.cxc != null) {
                                        try {
                                            this.cxc.recycle();
                                        } catch (Exception e3) {
                                            Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", e3, "hy: cleanupCoverScreenshot error!", new Object[0]);
                                        }
                                        this.cxc = null;
                                    }
                                    AppMethodBeat.o(130668);
                                }

                                @Override // com.tencent.luggage.game.page.d
                                public final void MP() {
                                    Bitmap a2;
                                    AppMethodBeat.i(130669);
                                    Nh();
                                    if (!MQ().getMagicBrush().cLi.LO()) {
                                        AppMethodBeat.o(130669);
                                        return;
                                    }
                                    e.b btm = ((c) NN()).kEb.getOrientationHandler().btm();
                                    if (org.apache.commons.b.a.contains(new e.b[]{e.b.LANDSCAPE_SENSOR, e.b.LANDSCAPE_LOCKED, e.b.LANDSCAPE_LEFT, e.b.LANDSCAPE_RIGHT}, btm)) {
                                        if (this.cxe == null) {
                                            Log.w("Luggage.Game.WAGamePageViewRenderer", "markBeforeStartToTransparent coverImage is NULL, return");
                                            AppMethodBeat.o(130669);
                                            return;
                                        }
                                        if (this.cwZ == null) {
                                            Log.e("Luggage.Game.WAGamePageViewRenderer", "captureScreen, view == null");
                                            a2 = null;
                                        } else {
                                            a2 = com.tencent.magicbrush.b.a(this.cwZ.getMagicBrush().cLA);
                                        }
                                        this.cxc = a2;
                                        this.cwY.setOnConfigurationChangedListener(new WAGamePageViewContainerLayout.a() {
                                            /* class com.tencent.luggage.game.page.h.AnonymousClass6 */

                                            @Override // com.tencent.luggage.game.page.WAGamePageViewContainerLayout.a
                                            public final void a(WAGamePageViewContainerLayout.b bVar, WAGamePageViewContainerLayout.b bVar2) {
                                                AppMethodBeat.i(178042);
                                                Log.v("Luggage.Game.WAGamePageViewRenderer", "hy: after change. old direction:%s, new direction: %s", bVar, bVar2);
                                                if (h.this.cxc == null) {
                                                    Log.e("Luggage.Game.WAGamePageViewRenderer", "hy: screenshot is null");
                                                    AppMethodBeat.o(178042);
                                                } else if ((h.a(bVar) && h.a(bVar2)) || (h.b(bVar) && h.b(bVar2))) {
                                                    AppMethodBeat.o(178042);
                                                } else if (h.a(bVar2)) {
                                                    Matrix matrix = new Matrix();
                                                    if ((bVar2 == WAGamePageViewContainerLayout.b.PORTRAIT && bVar == WAGamePageViewContainerLayout.b.LANDSCAPE) || (bVar2 == WAGamePageViewContainerLayout.b.PORTRAIT_REVERSE && bVar == WAGamePageViewContainerLayout.b.LANDSCAPE_REVERSE)) {
                                                        matrix.postRotate(90.0f);
                                                    } else {
                                                        matrix.postRotate(270.0f);
                                                    }
                                                    h.this.cxe.setVisibility(0);
                                                    h.this.cxe.setImageBitmap(Bitmap.createBitmap(h.this.cxc, 0, 0, h.this.cxc.getWidth(), h.this.cxc.getHeight(), matrix, true));
                                                    AppMethodBeat.o(178042);
                                                } else {
                                                    h.this.cwY.setOnConfigurationChangedListener(null);
                                                    AppMethodBeat.o(178042);
                                                }
                                            }
                                        });
                                    }
                                    AppMethodBeat.o(130669);
                                }

                                @Override // com.tencent.luggage.game.page.d
                                public final Bitmap u(int i2, boolean z) {
                                    Bitmap bitmap = null;
                                    AppMethodBeat.i(130670);
                                    Log.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap");
                                    if (i2 == -1) {
                                        Log.e("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId is illegal");
                                        AppMethodBeat.o(130670);
                                    } else {
                                        Log.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId:%d,sync:%b", Integer.valueOf(i2), Boolean.valueOf(z));
                                        if (this.cwZ == null) {
                                            Log.e("Luggage.Game.WAGamePageViewRenderer", "captureCanvas with [%d], view == null", Integer.valueOf(i2));
                                        } else {
                                            bitmap = this.cwZ.getMagicBrush().cLA.h(this.cwZ.getVirtualElementId(), i2, false);
                                        }
                                        Log.i("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap end");
                                        AppMethodBeat.o(130670);
                                    }
                                    return bitmap;
                                }

                                @Override // com.tencent.luggage.game.page.d
                                public MagicBrushView MQ() {
                                    return this.cwZ;
                                }

                                @Override // com.tencent.luggage.game.page.d
                                public final void MR() {
                                    AppMethodBeat.i(130671);
                                    Log.i("Luggage.Game.WAGamePageViewRenderer", "hy: markBeforeStartToBackground");
                                    try {
                                        Ni();
                                        this.cxd = com.tencent.magicbrush.b.a(this.cwZ.getMagicBrush().cLA);
                                        AppMethodBeat.o(130671);
                                    } catch (Exception e2) {
                                        Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", e2, "hy: captureDefaultWindow error!", new Object[0]);
                                        AppMethodBeat.o(130671);
                                    }
                                }

                                @Override // com.tencent.luggage.game.page.d
                                public final Bitmap MS() {
                                    AppMethodBeat.i(130672);
                                    if (this.cxd != null) {
                                        Log.i("Luggage.Game.WAGamePageViewRenderer", "hy: getCanvasSecurityGuardBitmap");
                                        Bitmap bitmap = this.cxd;
                                        AppMethodBeat.o(130672);
                                        return bitmap;
                                    }
                                    AppMethodBeat.o(130672);
                                    return null;
                                }

                                private void Ni() {
                                    AppMethodBeat.i(130673);
                                    if (this.cxd != null) {
                                        try {
                                            Log.i("Luggage.Game.WAGamePageViewRenderer", "hy: cleanupCanvasSecurityGuard");
                                            this.cxd.recycle();
                                        } catch (Exception e2) {
                                            Log.printErrStackTrace("Luggage.Game.WAGamePageViewRenderer", e2, "hy: cleanupCanvasSecurityGuard error!", new Object[0]);
                                        }
                                        this.cxd = null;
                                    }
                                    AppMethodBeat.o(130673);
                                }

                                @Override // com.tencent.luggage.game.page.b.AbstractC0174b
                                public void ca(View view) {
                                    AppMethodBeat.i(222891);
                                    if (view.getVisibility() != 0) {
                                        AppMethodBeat.o(222891);
                                        return;
                                    }
                                    if (this.cxh.compareAndSet(false, true)) {
                                        ((c) NN()).adM("onNativeWidgetViewAdded");
                                    }
                                    AppMethodBeat.o(222891);
                                }

                                static /* synthetic */ boolean a(WAGamePageViewContainerLayout.b bVar) {
                                    return bVar == WAGamePageViewContainerLayout.b.PORTRAIT || bVar == WAGamePageViewContainerLayout.b.PORTRAIT_REVERSE;
                                }

                                static /* synthetic */ boolean b(WAGamePageViewContainerLayout.b bVar) {
                                    return bVar == WAGamePageViewContainerLayout.b.LANDSCAPE || bVar == WAGamePageViewContainerLayout.b.LANDSCAPE_REVERSE;
                                }
                            }
