package com.tencent.mm.plugin.appbrand.page;

import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.ui.AppBrandMenuFooter;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.bb;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.m.aa;
import com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.menu.u;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recent.l;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ao;
import com.tencent.xweb.ah;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import org.json.JSONObject;

public class ag extends c {
    private q kBw;
    private List<t> kHj;
    private AppBrandRecentView nrq;
    private f nrr;
    public final h nrs;
    private final AtomicBoolean nrt;
    private v nru;
    public al nrv;
    private Boolean nrw;
    private final o nrx;

    static /* synthetic */ boolean m(ag agVar) {
        AppMethodBeat.i(180351);
        boolean isDarkMode = agVar.isDarkMode();
        AppMethodBeat.o(180351);
        return isDarkMode;
    }

    static /* synthetic */ boolean n(ag agVar) {
        AppMethodBeat.i(227307);
        boolean bRL = agVar.bRL();
        AppMethodBeat.o(227307);
        return bRL;
    }

    @Override // com.tencent.luggage.sdk.b.a.c
    public /* synthetic */ d NP() {
        AppMethodBeat.i(47910);
        q runtime = getRuntime();
        AppMethodBeat.o(47910);
        return runtime;
    }

    public ag() {
        this(af.class);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ag(Class<? extends ae> cls) {
        super(cls);
        boolean z = false;
        AppMethodBeat.i(47884);
        this.nrs = new h(getComponentId());
        this.nrt = new AtomicBoolean(false);
        this.nrx = new o();
        this.kAU = (WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED) ? true : z;
        AppMethodBeat.o(47884);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ac
    public void a(Context context, AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(47885);
        Log.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| init start");
        this.kBw = (q) appBrandRuntime;
        if (bqZ() == null) {
            a(((q) appBrandRuntime).bqZ());
        }
        super.a(context, appBrandRuntime);
        h hVar = this.nrs;
        hVar.mAppId = appBrandRuntime.mAppId;
        hVar.kEc = appBrandRuntime;
        bRi().setCloseButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(47864);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                i.a(ag.this.getAppId(), ag.this.lBI, 22, "", Util.nowSecond(), 1, 0);
                a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(47864);
            }
        });
        if (appBrandRuntime.kAU && ((q) appBrandRuntime).bsr()) {
            bRi().setNavButtonLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass6 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(47871);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    ag.this.bRN();
                    a.a(true, (Object) this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(47871);
                    return true;
                }
            });
        }
        this.lxr = new com.tencent.mm.plugin.appbrand.permission.a((q) appBrandRuntime, this);
        if (bb.r(getRuntime())) {
            q runtime = getRuntime();
            String str = runtime.mAppId;
            com.tencent.mm.plugin.appbrand.h.a(str, 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0072: INVOKE  
                  (r1v4 'str' java.lang.String)
                  (wrap: com.tencent.mm.plugin.appbrand.bb$1 : 0x006f: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.appbrand.bb$1) = (r1v4 'str' java.lang.String), (r0v11 'runtime' com.tencent.mm.plugin.appbrand.q) call: com.tencent.mm.plugin.appbrand.bb.1.<init>(java.lang.String, com.tencent.mm.plugin.appbrand.q):void type: CONSTRUCTOR)
                 type: STATIC call: com.tencent.mm.plugin.appbrand.h.a(java.lang.String, com.tencent.mm.plugin.appbrand.h$c):void in method: com.tencent.mm.plugin.appbrand.page.ag.a(android.content.Context, com.tencent.mm.plugin.appbrand.AppBrandRuntime):void, file: classes3.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006f: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.appbrand.bb$1) = (r1v4 'str' java.lang.String), (r0v11 'runtime' com.tencent.mm.plugin.appbrand.q) call: com.tencent.mm.plugin.appbrand.bb.1.<init>(java.lang.String, com.tencent.mm.plugin.appbrand.q):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.page.ag.a(android.content.Context, com.tencent.mm.plugin.appbrand.AppBrandRuntime):void, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.bb, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 25 more
                */
            /*
            // Method dump skipped, instructions count: 227
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.page.ag.a(android.content.Context, com.tencent.mm.plugin.appbrand.AppBrandRuntime):void");
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final void aG(Context context) {
            AppMethodBeat.i(47886);
            super.aG(context);
            if (bRb() instanceof a) {
                a aVar = (a) bRb();
                if (aVar.nng != null) {
                    aVar.nng.setBaseContext(context);
                }
            }
            if (this.nmX != null) {
                this.nmX.aG(context);
            }
            com.tencent.mm.plugin.appbrand.jsapi.af.a bRM = bRM();
            if (bRM != null) {
                if (context == null) {
                    AppMethodBeat.o(47886);
                    return;
                }
                if (bRM.getContext() instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) bRM.getContext()).setBaseContext(context);
                }
                bRM.iGY.aG(context);
            }
            AppMethodBeat.o(47886);
        }

        public final h bRK() {
            return this.nrs;
        }

        @Override // com.tencent.luggage.sdk.b.a.c, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.plugin.appbrand.jsapi.k
        public q getRuntime() {
            AppMethodBeat.i(47887);
            q qVar = (q) super.NP();
            AppMethodBeat.o(47887);
            return qVar;
        }

        public final com.tencent.mm.plugin.appbrand.service.c bsE() {
            AppMethodBeat.i(47888);
            com.tencent.mm.plugin.appbrand.service.c cVar = (com.tencent.mm.plugin.appbrand.service.c) super.NQ();
            AppMethodBeat.o(47888);
            return cVar;
        }

        @Override // com.tencent.luggage.sdk.b.a.c, com.tencent.mm.plugin.appbrand.page.ac
        public void NR() {
            AppMethodBeat.i(47889);
            b((com.tencent.mm.plugin.appbrand.platform.window.c) null);
            super.NR();
            if (this.nrq != null) {
                this.nrq.release();
            }
            if (this.nrr != null) {
                f fVar = this.nrr;
                fVar.dismiss();
                if (fVar.omw != null) {
                    fVar.omw.removeAllViews();
                    fVar.omw = null;
                }
            }
            this.nru = null;
            AppMethodBeat.o(47889);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final View j(ViewGroup viewGroup) {
            boolean z = true;
            int i2 = 0;
            AppMethodBeat.i(180347);
            if (this.kBw == null || !bb.r(this.kBw) || !(viewGroup instanceof RelativeLayout)) {
                AppMethodBeat.o(180347);
                return null;
            }
            if (this.nrv == null) {
                this.nrv = new al(getContext());
            }
            al alVar = this.nrv;
            String str = this.kBw.bsC().iconUrl;
            String str2 = this.kBw.bsC().brandName;
            String vO = e.vO(this.kBw.bsB().leE.kNW);
            boolean NA = this.kBw.bsC().NA();
            if (this.kBw.bsC().originalFlag != 1) {
                z = false;
            }
            com.tencent.mm.modelappbrand.a.b.aXY().a(alVar.lIM, str, com.tencent.mm.modelappbrand.a.a.aXX(), g.iJB);
            alVar.nsc.setText(NA ? R.string.a3p : R.string.a3o);
            alVar.jVh.setText(str2);
            if (Util.isNullOrNil(vO)) {
                alVar.nsb.setVisibility(8);
                ImageView imageView = alVar.nsd;
                if (!z) {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            } else {
                alVar.nsb.setText(vO);
                alVar.nsb.setVisibility(0);
                alVar.nsd.setVisibility(8);
            }
            this.nrv.setJumpBtnOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(227296);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    q qVar = ag.this.kBw;
                    String str = ag.this.nna;
                    bb.a aVar = new bb.a();
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("currentPath", str);
                    aVar.L(hashMap).g(qVar.bsE()).bEo();
                    a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(227296);
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            layoutParams.topMargin = -getContext().getResources().getDimensionPixelSize(R.dimen.f3068rx);
            viewGroup.addView(this.nrv, layoutParams);
            al alVar2 = this.nrv;
            AppMethodBeat.o(180347);
            return alVar2;
        }

        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final Bitmap bRB() {
            Bitmap bitmap;
            AppMethodBeat.i(227299);
            com.tencent.luggage.game.page.d dVar = (com.tencent.luggage.game.page.d) S(com.tencent.luggage.game.page.d.class);
            if (dVar == null) {
                Bitmap bRB = super.bRB();
                AppMethodBeat.o(227299);
                return bRB;
            }
            try {
                bitmap = dVar.MQ().getMagicBrush().cLA.h(dVar.MQ().getVirtualElementId(), -1, true);
            } catch (NullPointerException e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandPageViewWC", e2, "hy: exception in get snapshot", new Object[0]);
                bitmap = null;
            }
            AppMethodBeat.o(227299);
            return bitmap;
        }

        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final boolean onBackPressed() {
            AppMethodBeat.i(180348);
            if (this.kBw == null || !bb.r(this.kBw)) {
                boolean onBackPressed = super.onBackPressed();
                AppMethodBeat.o(180348);
                return onBackPressed;
            }
            Log.i("MicroMsg.AppBrandPageViewWC", "SinglePageModeLogic onBackPressed");
            com.tencent.mm.plugin.appbrand.h.a(getAppId(), h.d.BACK);
            this.kBw.close();
            AppMethodBeat.o(180348);
            return true;
        }

        /* access modifiers changed from: protected */
        public void bOE() {
            AppMethodBeat.i(47890);
            com.tencent.mm.kernel.g.af(l.class);
            if (getRuntime().bsr()) {
                AppMethodBeat.o(47890);
                return;
            }
            try {
                this.nrq = ((l) com.tencent.mm.kernel.g.af(l.class)).a(getContext(), l.b.TYPE_MENU, new l.a() {
                    /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass9 */

                    @Override // com.tencent.mm.plugin.appbrand.widget.recent.l.a
                    public final LocalUsageInfo bRO() {
                        AppMethodBeat.i(47877);
                        if (!ag.this.isRunning()) {
                            AppMethodBeat.o(47877);
                            return null;
                        }
                        LocalUsageInfo localUsageInfo = new LocalUsageInfo(ag.this.getRuntime().bsC().username, ag.this.getRuntime().bsB().appId, ag.this.getRuntime().bsB().leE.kNW, ((AppBrandSysConfigLU) ag.this.getRuntime().bsB()).leE.pkgVersion, ag.this.getRuntime().bsB().brandName, ag.this.getRuntime().bsB().cyB, ag.this.getRuntime().bsB().jyi, ag.this.getRuntime().bsB().czf);
                        AppMethodBeat.o(47877);
                        return localUsageInfo;
                    }
                });
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandPageViewWC", e2, "appId[%s]", getAppId());
            }
            if (this.nrq == null) {
                AppMethodBeat.o(47890);
                return;
            }
            this.nrr = new f(getContext());
            this.nrr.setWidth(-1);
            this.nrr.setBackgroundDrawable(new ColorDrawable());
            this.nrq.refresh();
            this.nrr.setHeight(this.nrq.getLayoutParams().height);
            this.nrq.setBackground(com.tencent.mm.cb.a.l(getContext(), R.drawable.d0));
            this.nrr.setContentView(this.nrq);
            this.nrq.setOnItemClickListener(new AppBrandRecentView.b() {
                /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass10 */

                @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.b
                public final boolean a(View view, com.tencent.mm.plugin.appbrand.widget.recent.e eVar, float f2, float f3) {
                    AppMethodBeat.i(227298);
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass10.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(47878);
                            ag.this.nrr.dismiss();
                            AppMethodBeat.o(47878);
                        }
                    }, 100);
                    if (eVar.type == 1) {
                        LocalUsageInfo localUsageInfo = eVar.ooj;
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = 1090;
                        appBrandStatObject.dCw = ag.this.getAppId();
                        com.tencent.mm.plugin.appbrand.launching.e.f.mZp.a(ag.this.getContext(), localUsageInfo.username, null, null, localUsageInfo.iOo, -1, appBrandStatObject, null, null);
                        AppMethodBeat.o(227298);
                        return true;
                    }
                    AppMethodBeat.o(227298);
                    return false;
                }

                @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.b
                public final boolean b(View view, com.tencent.mm.plugin.appbrand.widget.recent.e eVar, float f2, float f3) {
                    return false;
                }
            });
            AppMethodBeat.o(47890);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public void bOF() {
            boolean z = true;
            AppMethodBeat.i(47891);
            super.bOF();
            b.d pageConfig = getPageConfig();
            boolean a2 = getRuntime().cCn.a(this, c.a.class);
            super.bV(!pageConfig.lcw || !a2);
            if (!a2 || !pageConfig.lcw || getRuntime().bsC().cyo != 7 || bRi().isFullscreenMode()) {
                Log.i("MicroMsg.AppBrandPageViewWC", "hasPermission:" + a2 + " navigationBarRightButtonHide:" + pageConfig.lcw + " appServiceType:" + getRuntime().bsC().cyo + " isFullscreenMode:" + bRi().isFullscreenMode());
            } else {
                com.tencent.mm.plugin.appbrand.widget.tabbar.b bVar = new com.tencent.mm.plugin.appbrand.widget.tabbar.b(pageConfig.lcv, new com.tencent.mm.plugin.appbrand.widget.tabbar.c() {
                    /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass12 */

                    @Override // com.tencent.mm.plugin.appbrand.widget.tabbar.c
                    public final void a(String str, com.tencent.mm.plugin.appbrand.widget.tabbar.d dVar) {
                        AppMethodBeat.i(47881);
                        super.a(str, dVar);
                        Log.e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(str)));
                        AppMethodBeat.o(47881);
                    }
                });
                bVar.a(new com.tencent.mm.plugin.appbrand.widget.tabbar.e() {
                    /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass13 */

                    @Override // com.tencent.mm.plugin.appbrand.widget.tabbar.e
                    public final void a(Bitmap bitmap, com.tencent.mm.plugin.appbrand.widget.tabbar.d dVar) {
                        AppMethodBeat.i(47883);
                        super.a(bitmap, dVar);
                        ag.this.bRi().a(bitmap, new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass13.AnonymousClass1 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(47882);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("MicroMsg.AppBrandPageViewWC", "CustomRightButton click");
                                com.tencent.mm.plugin.appbrand.page.c.d.h((ac) ag.this);
                                a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(47882);
                            }
                        });
                        AppMethodBeat.o(47883);
                    }
                });
                bVar.cdf();
            }
            if (bb.r(getRuntime())) {
                runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(227293);
                        Log.i("MicroMsg.AppBrandPageViewWC", "customActionBarIfNeed decorateActionBarToSinglePageMode");
                        if (ag.this.nqM == null) {
                            AppMethodBeat.o(227293);
                            return;
                        }
                        final Context context = ag.this.getContext();
                        ag.this.nqM.setNavResetStyleListener(new b.a() {
                            /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass4.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.a
                            public final void a(ImageView imageView, View view, View view2) {
                                AppMethodBeat.i(227291);
                                if (imageView != null) {
                                    imageView.clearColorFilter();
                                    imageView.setImageDrawable(com.tencent.mm.svg.a.a.h(context.getResources(), (ag.n(ag.this) || ag.this.getRuntime().NA()) ? R.raw.actionbar_icon_light_close : R.raw.actionbar_icon_dark_close));
                                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                                    layoutParams.height = -1;
                                    layoutParams.width = -2;
                                    imageView.setLayoutParams(layoutParams);
                                }
                                if (view != null) {
                                    view.setBackground(null);
                                }
                                AppMethodBeat.o(227291);
                            }

                            @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.a
                            public final int bQz() {
                                return omi;
                            }
                        });
                        ag.this.nqM.a(com.tencent.mm.svg.a.a.i(context.getResources(), (ag.n(ag.this) || ag.this.getRuntime().NA()) ? R.raw.actionbar_icon_light_more : R.raw.actionbar_icon_dark_more), new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass4.AnonymousClass2 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(227292);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$12$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                ag.this.bP(ag.this.bRh());
                                a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$12$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(227292);
                            }
                        });
                        ag.this.ii(!"squeezed".equals(ag.o(ag.this)));
                        ag.this.nqM.gz(false);
                        ag.this.nqM.setFullscreenMode(false);
                        ag.this.nqM.gx(true);
                        ag.p(ag.this);
                        AppMethodBeat.o(227293);
                    }
                });
                AppMethodBeat.o(47891);
            } else if (com.tencent.mm.plugin.appbrand.af.g.an(getRuntime())) {
                runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(180330);
                        if (ag.this.nqM != null) {
                            Log.i("MicroMsg.AppBrandPageViewWC", "weishi customActionBar");
                            ag.this.nqM.setNavResetStyleListener(new b.a() {
                                /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass5.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.a
                                public final void a(ImageView imageView, View view, View view2) {
                                    AppMethodBeat.i(227294);
                                    if (imageView != null) {
                                        imageView.clearColorFilter();
                                        Log.i("MicroMsg.AppBrandPageViewWC", "[weishi] set close button");
                                        imageView.setImageDrawable(com.tencent.mm.svg.a.a.h(ag.this.getContext().getResources(), R.raw.app_brand_weishi_video_btn_close));
                                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                                        layoutParams.height = -1;
                                        layoutParams.width = -2;
                                        imageView.setLayoutParams(layoutParams);
                                    }
                                    if (view != null) {
                                        view.setBackground(null);
                                    }
                                    AppMethodBeat.o(227294);
                                }

                                @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.a
                                public final int bQz() {
                                    return omi;
                                }
                            });
                            ag.this.nqM.setFullscreenMode(true);
                            ag.this.nqM.setForegroundStyle(false);
                            ag.this.nqM.gz(false);
                            ag.this.nqM.gx(true);
                            ag.this.nqM.setBackButtonClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass5.AnonymousClass2 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(227295);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$13$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    Log.i("MicroMsg.AppBrandPageViewWC", "[weishi] pageview click close button");
                                    com.tencent.mm.plugin.appbrand.af.g.bZS();
                                    if (ag.this.kBw != null) {
                                        com.tencent.mm.plugin.appbrand.h.a(ag.this.getAppId(), h.d.CLOSE);
                                        ag.this.kBw.close();
                                    }
                                    a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$13$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(227295);
                                }
                            });
                        }
                        if (ag.this.nqL != null) {
                            ag.this.nqL.setForceTopInsetsHeight(ag.this.getContext().getResources().getDimensionPixelSize(R.dimen.so));
                        }
                        AppMethodBeat.o(180330);
                    }
                });
                AppMethodBeat.o(47891);
            } else if (getRuntime() == null || !getRuntime().bsr()) {
                if (getRuntime().bsN()) {
                    com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar2 = this.nqM;
                    if (getRuntime().bsO()) {
                        z = false;
                    }
                    bVar2.gz(z);
                }
                AppMethodBeat.o(47891);
            } else {
                bRi().setNavHidden(false);
                AppMethodBeat.o(47891);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final View bRy() {
            AppMethodBeat.i(175036);
            if (bb.r(getRuntime())) {
                AppMethodBeat.o(175036);
                return null;
            }
            AppBrandMenuHeader appBrandMenuHeader = new AppBrandMenuHeader(getContext());
            appBrandMenuHeader.setPage(this);
            AppMethodBeat.o(175036);
            return appBrandMenuHeader;
        }

        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final View bRz() {
            AppMethodBeat.i(47893);
            if (com.tencent.mm.plugin.appbrand.ad.e.d(this)) {
                com.tencent.mm.plugin.appbrand.ad.a.b bVar = new com.tencent.mm.plugin.appbrand.ad.a.b();
                bVar.source = "menu";
                bVar.type = "menu";
                bVar.d((com.tencent.mm.plugin.appbrand.service.c) super.NQ());
                AppBrandMenuFooter appBrandMenuFooter = new AppBrandMenuFooter(getContext());
                appBrandMenuFooter.setPageView(this);
                appBrandMenuFooter.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass11 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(47880);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.plugin.appbrand.ad.e.c(ag.this);
                        a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(47880);
                    }
                });
                AppMethodBeat.o(47893);
                return appBrandMenuFooter;
            }
            View bRz = super.bRz();
            AppMethodBeat.o(47893);
            return bRz;
        }

        private boolean isDarkMode() {
            AppMethodBeat.i(180349);
            if (this.nrw == null) {
                this.nrw = Boolean.valueOf(ao.isDarkMode());
            }
            boolean booleanValue = this.nrw.booleanValue();
            AppMethodBeat.o(180349);
            return booleanValue;
        }

        private boolean bRL() {
            AppMethodBeat.i(227300);
            String str = getRuntime().getAppConfig().WV(this.lBI).lcC.lck;
            if (Util.isNullOrNil(str)) {
                boolean isDarkMode = isDarkMode();
                AppMethodBeat.o(227300);
                return isDarkMode;
            } else if (!e.a.BLACK.name().equalsIgnoreCase(str)) {
                AppMethodBeat.o(227300);
                return true;
            } else {
                AppMethodBeat.o(227300);
                return false;
            }
        }

        public final com.tencent.mm.plugin.appbrand.jsapi.af.a bRM() {
            AppMethodBeat.i(47896);
            try {
                View findViewById = getContentView().findViewById(R.id.pq);
                if (findViewById instanceof com.tencent.mm.plugin.appbrand.jsapi.af.a) {
                    com.tencent.mm.plugin.appbrand.jsapi.af.a aVar = (com.tencent.mm.plugin.appbrand.jsapi.af.a) findViewById;
                    AppMethodBeat.o(47896);
                    return aVar;
                }
                AppMethodBeat.o(47896);
                return null;
            } catch (NullPointerException e2) {
                AppMethodBeat.o(47896);
                return null;
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final List<t> bRg() {
            AppMethodBeat.i(47897);
            if (bb.r(getRuntime())) {
                boolean NA = getRuntime().NA();
                LinkedList linkedList = new LinkedList();
                WxaMenuHelper.a(linkedList, u.ShareAppMsg.ordinal(), true, true);
                WxaMenuHelper.a(linkedList, u.ShareToTimeLine.ordinal(), true, true);
                WxaMenuHelper.a(linkedList, u.Fav.ordinal(), true, false);
                WxaMenuHelper.a(linkedList, u.ShareToWork.ordinal(), true, false);
                WxaMenuHelper.a(linkedList, u.AboutUs.ordinal(), false, false);
                WxaMenuHelper.a(linkedList, u.Complaint.ordinal(), false, false);
                if (NA) {
                    WxaMenuHelper.a(linkedList, u.GrowthCare.ordinal(), false, false);
                }
                this.kHj = linkedList;
                AppMethodBeat.o(47897);
                return linkedList;
            }
            String appId = getAppId();
            LinkedList linkedList2 = new LinkedList();
            WxaMenuHelper.a(linkedList2, u.ShareAppMsg.ordinal(), true, true);
            WxaMenuHelper.a(linkedList2, u.ShareToTimeLine.ordinal(), true, true);
            WxaMenuHelper.a(linkedList2, u.Fav.ordinal(), true, false);
            WxaMenuHelper.a(linkedList2, u.ModifyCollection.ordinal(), true, false);
            AppBrandSysConfigWC TR = com.tencent.mm.plugin.appbrand.a.TR(appId);
            WxaMenuHelper.a(linkedList2, u.SendToDesktop.ordinal(), true, !CrashReportFactory.hasDebuger() && (TR == null || TR.leE.kNW == 1));
            WxaMenuHelper.a(linkedList2, u.ShareToWork.ordinal(), true, false);
            WxaMenuHelper.a(linkedList2, u.SendHandoff.ordinal(), true, false);
            WxaMenuHelper.a(linkedList2, u.CopyPath.ordinal(), false, false);
            WxaMenuHelper.a(linkedList2, u.splitScreen.ordinal(), false, false);
            WxaMenuHelper.a(linkedList2, u.Minimize.ordinal(), false, false);
            WxaMenuHelper.a(linkedList2, u.Setting.ordinal(), false, false);
            WxaMenuHelper.a(linkedList2, u.StickInWeChat.ordinal(), false, false);
            WxaMenuHelper.a(linkedList2, u.Complaint.ordinal(), false, false);
            WxaMenuHelper.a(linkedList2, u.Restart.ordinal(), false, false);
            WxaMenuHelper.a(linkedList2, u.CopyShortLink.ordinal(), false, false);
            WxaMenuHelper.a(linkedList2, u.GrowthCare.ordinal(), false, false);
            WxaMenuHelper.a(linkedList2, u.DevTools.ordinal(), false, false);
            this.kHj = linkedList2;
            AppMethodBeat.o(47897);
            return linkedList2;
        }

        @Override // com.tencent.luggage.sdk.b.a.c, com.tencent.mm.plugin.appbrand.page.ac
        public final boolean dE(String str) {
            AppMethodBeat.i(47898);
            Log.i("MicroMsg.AppBrandPageViewWC", "AppBrandPageViewProfile| loadURL appId:%s, url:%s, stack:%s", getAppId(), str, android.util.Log.getStackTraceString(new Throwable()));
            com.tencent.mm.plugin.appbrand.report.h hVar = this.nrs;
            hVar.nIs = Util.nowMilliSecond();
            hVar.nIr = str;
            b(getRuntime().getWindowAndroid());
            boolean dE = super.dE(str);
            AppMethodBeat.o(47898);
            return dE;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final void bRq() {
            AppMethodBeat.i(47899);
            super.bRq();
            com.tencent.mm.plugin.appbrand.report.h hVar = this.nrs;
            hVar.nIt = Util.nowMilliSecond() - hVar.nIs;
            if (bqZ().compareTo(getRuntime().bqZ()) != 0) {
                IllegalStateException illegalStateException = new IllegalStateException(String.format(Locale.ENGLISH, "onPageReady appId[%s] mismatch libReader, self[%s] runtime[%s]", getAppId(), bqZ().bvb(), getRuntime().bqZ().bvb()));
                AppMethodBeat.o(47899);
                throw illegalStateException;
            }
            AppMethodBeat.o(47899);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final void bRr() {
            String currentUrl;
            AppMethodBeat.i(47900);
            super.bRr();
            if (getRuntime().NA()) {
                com.tencent.mm.plugin.appbrand.report.h hVar = this.nrs;
                if (getRuntime().kAK) {
                    currentUrl = getRuntime().brs();
                } else {
                    currentUrl = getRuntime().bsD().getCurrentUrl();
                }
                hVar.aeF(currentUrl);
            } else {
                this.nrs.onForeground();
            }
            com.tencent.mm.plugin.appbrand.page.capsulebar.e eVar = getRuntime().kAx;
            AnonymousClass8 r1 = new View.OnLongClickListener() {
                /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass8 */

                static /* synthetic */ void a(AnonymousClass8 r1, View view) {
                    AppMethodBeat.i(227297);
                    r1.cC(view);
                    AppMethodBeat.o(227297);
                }

                public final boolean onLongClick(final View view) {
                    AppMethodBeat.i(47874);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    if (!ag.this.nrt.getAndSet(true)) {
                        ag.this.bOE();
                        if (ag.this.nrq != null) {
                            ag.this.nrq.setRefreshListener(new AppBrandRecentView.e() {
                                /* class com.tencent.mm.plugin.appbrand.page.ag.AnonymousClass8.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.e
                                public final void yL(int i2) {
                                    AppMethodBeat.i(47873);
                                    ag.this.nrq.setRefreshListener(null);
                                    AnonymousClass8.a(AnonymousClass8.this, view);
                                    AppMethodBeat.o(47873);
                                }
                            });
                            ag.this.nrq.refresh();
                        }
                    } else {
                        cC(view);
                    }
                    a.a(true, (Object) this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(47874);
                    return true;
                }

                private void cC(View view) {
                    AppMethodBeat.i(47875);
                    if (ag.this.nrq == null || ag.this.nrq.getCount() == 0) {
                        AppMethodBeat.o(47875);
                        return;
                    }
                    ag.this.nrq.refresh();
                    ag.this.nrr.showAsDropDown(view);
                    i.a(ag.this.getAppId(), ag.this.lBI, 21, "", Util.nowSecond(), 1, 0);
                    AppMethodBeat.o(47875);
                }
            };
            com.tencent.mm.plugin.appbrand.page.capsulebar.d dVar = eVar.nvi;
            if (dVar == null) {
                p.btv("capsuleBarView");
            }
            dVar.getCapsuleHomeButton().setOnLongClickListener(r1);
            AppMethodBeat.o(47900);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final void bRs() {
            AppMethodBeat.i(47901);
            super.bRs();
            if (this.nrr != null) {
                this.nrr.dismiss();
            }
            this.nrs.onBackground();
            AppMethodBeat.o(47901);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final void bRt() {
            AppMethodBeat.i(47902);
            super.bRt();
            this.nrs.onDestroy();
            AppMethodBeat.o(47902);
        }

        public final am bRI() {
            AppMethodBeat.i(47903);
            if (bRb() instanceof af) {
                am bRI = ((af) bRb()).bRI();
                AppMethodBeat.o(47903);
                return bRI;
            }
            AppMethodBeat.o(47903);
            return null;
        }

        @Override // com.tencent.luggage.sdk.b.a.c
        public void NW() {
            AppMethodBeat.i(47904);
            if (getRuntime().bsr()) {
                bRi().setNavHidden(false);
            } else {
                super.NW();
            }
            if (com.tencent.mm.plugin.appbrand.af.g.an(this.kBw) || bb.r(getRuntime())) {
                bRi().gx(true);
            }
            AppMethodBeat.o(47904);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final void bP(List<t> list) {
            AppMethodBeat.i(47905);
            this.nru = new v(this, list);
            this.nru.btY();
            AppMethodBeat.o(47905);
        }

        public final void bRN() {
            AppMethodBeat.i(47906);
            if (this.kHj == null || this.kHj.size() <= 0) {
                Log.w("MicroMsg.AppBrandPageViewWC", "showPageActionSheet appId[%s], url[%s], empty list skip", getAppId(), this.lBI);
                AppMethodBeat.o(47906);
                return;
            }
            bP(this.kHj);
            AppMethodBeat.o(47906);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.l
        public final void d(JSONObject jSONObject) {
            AppMethodBeat.i(47907);
            super.d(jSONObject);
            c(jSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.KyO));
            com.tencent.mm.plugin.appbrand.h.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdk(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.c.cds(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdo(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdz(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdu(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdv(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdr(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdq(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.i(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdx(), jSONObject);
            c(jSONObject, "useXWebWebGLCanvas", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdw()));
            c(jSONObject, "useSkiaCanvasRaf", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdm()));
            c(jSONObject, "useNewXWebCanvasToTFP", Boolean.valueOf(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdn()));
            AppMethodBeat.o(47907);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.g
        public final void On() {
            AppMethodBeat.i(227301);
            super.On();
            if (aa.f(this)) {
                Log.i("MicroMsg.AppBrandPageViewWC", "page initNativeTransLogic");
                if (com.tencent.mm.plugin.appbrand.xweb_ext.d.oGJ) {
                    Log.i("MicroMsg.XWebNativeTransInitLogic", "bind already");
                } else {
                    Log.i("MicroMsg.XWebNativeTransInitLogic", "bind");
                    ah.ON(com.tencent.mm.appbrand.v8.f.getNativeTransManager());
                    com.tencent.mm.plugin.appbrand.xweb_ext.d.oGJ = true;
                }
                com.tencent.mm.plugin.appbrand.m.i jsRuntime = getJsRuntime();
                int componentId = getComponentId();
                Log.i("Luggage.NativeTransLogic", "enableXwebNativeTrans componentId:%s ,appId:%s , stack:%s", Integer.valueOf(componentId), getAppId(), android.util.Log.getStackTraceString(new Throwable()));
                jsRuntime.evaluateJavascript("console.log('enableXwebNativeTrans. ntrans:' + typeof ntrans + ' componentId :" + componentId + "')", null);
                jsRuntime.evaluateJavascript("xweb.enableNativeTrans()", null);
                jsRuntime.evaluateJavascript("console.log('enableXwebNativeTrans. end ntrans:' + typeof ntrans  + ' componentId :" + componentId + "')", null);
                aa.a(getJsRuntime(), getComponentId(), getAppId());
            }
            AppMethodBeat.o(227301);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final void b(com.tencent.mm.plugin.appbrand.platform.window.c cVar) {
            AppMethodBeat.i(175037);
            if (cVar == null) {
                Application application = com.tencent.mm.kernel.g.aAe().azG().ca;
                if (this.nrx.getContext() == application && this.nrx == this.kEb) {
                    AppMethodBeat.o(175037);
                    return;
                }
                long currentTicks = Util.currentTicks();
                this.nrx.aG(application);
                super.b(this.nrx);
                aG(application);
                Log.w("MicroMsg.AppBrandPageViewWC", "setWindowAndroid, impl==null, appId:%s, url:%s, isRunning:%b, cost:%dms", getAppId(), this.lBI, Boolean.valueOf(isRunning()), Long.valueOf(Util.ticksToNow(currentTicks)));
                AppMethodBeat.o(175037);
                return;
            }
            if (cVar.compareTo(this.kEb) != 0) {
                long currentTicks2 = Util.currentTicks();
                super.b(cVar);
                if (!(getRuntime() == null || AndroidContextUtil.castActivityOrNull(getRuntime().mContext) == null)) {
                    aG(AndroidContextUtil.castActivityOrNull(getRuntime().mContext));
                }
                Log.i("MicroMsg.AppBrandPageViewWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, url:%s, cost:%dms, stack:%s", this.kEb, cVar, getAppId(), this.lBI, Long.valueOf(Util.ticksToNow(currentTicks2)), android.util.Log.getStackTraceString(new Throwable()));
            }
            AppMethodBeat.o(175037);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final void bRD() {
            String str;
            AppMethodBeat.i(227304);
            super.bRD();
            if (this.kBw == null) {
                str = "";
            } else {
                str = this.kBw.mAppId;
            }
            i.E(str, this.lBI, 1);
            AppMethodBeat.o(227304);
        }

        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final void bRF() {
            String str;
            AppMethodBeat.i(227305);
            super.bRF();
            if (!(this.nmX == null || this.nqQ == null)) {
                if (this.kBw == null) {
                    str = "";
                } else {
                    str = this.kBw.mAppId;
                }
                i.E(str, this.lBI, 2);
            }
            AppMethodBeat.o(227305);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final b bRG() {
            AppMethodBeat.i(227306);
            c cVar = new c(this);
            AppMethodBeat.o(227306);
            return cVar;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final boolean f(View view, Runnable runnable) {
            AppMethodBeat.i(227302);
            if (!this.nqW || android.support.v4.view.u.aD(view) || getRuntime() == null || !getRuntime().OS()) {
                boolean f2 = super.f(view, runnable);
                AppMethodBeat.o(227302);
                return f2;
            }
            MMHandlerThread.postToMainThread(runnable);
            AppMethodBeat.o(227302);
            return true;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.page.ac
        public final boolean b(View view, Runnable runnable, long j2) {
            AppMethodBeat.i(227303);
            if (!this.nqW || android.support.v4.view.u.aD(view) || getRuntime() == null || !getRuntime().OS()) {
                boolean b2 = super.b(view, runnable, j2);
                AppMethodBeat.o(227303);
                return b2;
            }
            MMHandlerThread.postToMainThreadDelayed(runnable, j2);
            AppMethodBeat.o(227303);
            return true;
        }

        @Override // com.tencent.luggage.sdk.b.a.c
        public final /* bridge */ /* synthetic */ com.tencent.luggage.sdk.b.a.c.d NQ() {
            AppMethodBeat.i(47909);
            com.tencent.mm.plugin.appbrand.service.c cVar = (com.tencent.mm.plugin.appbrand.service.c) super.NQ();
            AppMethodBeat.o(47909);
            return cVar;
        }

        @Override // com.tencent.luggage.sdk.b.a.c, com.tencent.mm.plugin.appbrand.page.ac
        public final /* synthetic */ s NY() {
            AppMethodBeat.i(47912);
            com.tencent.mm.plugin.appbrand.service.c cVar = (com.tencent.mm.plugin.appbrand.service.c) super.NQ();
            AppMethodBeat.o(47912);
            return cVar;
        }

        static /* synthetic */ String o(ag agVar) {
            AppMethodBeat.i(227308);
            if (!agVar.nqM.isFullscreenMode()) {
                AppMethodBeat.o(227308);
                return "squeezed";
            }
            String str = agVar.getRuntime().getAppConfig().WV(agVar.lBI).lcC.lch;
            if (Util.isNullOrNil(str)) {
                str = agVar.getRuntime().getAppConfig().bzF().lcC.lch;
            }
            if (Util.isNullOrNil(str)) {
                str = "float";
            }
            AppMethodBeat.o(227308);
            return str;
        }

        static /* synthetic */ void p(ag agVar) {
            AppMethodBeat.i(227309);
            b.f fVar = agVar.getRuntime().getAppConfig().WV(agVar.lBI).lcC;
            if (agVar.bRL()) {
                agVar.nqM.setForegroundStyle(false);
                agVar.nqM.zN(agVar.getContext().getResources().getColor(R.color.e5));
            } else {
                agVar.nqM.setForegroundStyle(true);
                agVar.nqM.zN(agVar.getContext().getResources().getColor(R.color.e6));
            }
            String str = fVar.lci;
            if (!Util.isNullOrNil(str)) {
                try {
                    agVar.wz(com.tencent.mm.plugin.appbrand.ac.g.afE(str));
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandPageViewWC", "decorateSinglePageModeNavigationBar color parse error");
                }
            }
            double d2 = fVar.lcj;
            if (d2 >= 0.0d) {
                agVar.s(d2);
            }
            String str2 = fVar.lcl;
            if (!Util.isNullOrNil(str2)) {
                agVar.YO(str2);
            }
            AppMethodBeat.o(227309);
        }
    }
