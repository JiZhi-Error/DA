package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.f;
import com.tencent.mm.plugin.appbrand.ad.j;
import com.tencent.mm.plugin.appbrand.launching.q;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.x;

@SuppressLint({"ViewConstructor"})
public final class c extends FrameLayout implements q, ab, ac, ad, ae {
    private com.tencent.mm.plugin.appbrand.q kGW;
    private ab nRh;
    private f nRi;
    private j nRj;

    public c(Context context, AppBrandRuntime appBrandRuntime, ab abVar, j jVar) {
        super(context);
        AppMethodBeat.i(227546);
        this.kGW = (com.tencent.mm.plugin.appbrand.q) appBrandRuntime;
        this.nRh = abVar;
        this.nRj = jVar;
        com.tencent.mm.plugin.appbrand.q qVar = this.kGW;
        Log.i("MicroMsg.AppBrandAdLoadingSplash", "initRuntimeAdViewContainer, runtime:%s", qVar);
        this.nRi = new f(context, qVar);
        this.nRi.btL();
        this.nRi.btM();
        this.nRi.setForegroundStyle(false);
        this.nRi.setCloseButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.c.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(227542);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandAdLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (c.this.nRj != null) {
                    c.this.nRj.btS();
                }
                a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandAdLoadingSplash$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(227542);
            }
        });
        this.nRi.setOnHideListener(new f.a() {
            /* class com.tencent.mm.plugin.appbrand.ui.c.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.ad.f.a
            public final void UB(String str) {
                AppMethodBeat.i(227543);
                if (c.this.nRj != null) {
                    c.this.nRj.UC(str);
                }
                AppMethodBeat.o(227543);
            }
        });
        this.nRi.setOptionButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.c.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(227544);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandAdLoadingSplash$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandAdLoadingSplash$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(227544);
            }
        });
        if (this.nRh != null) {
            addView(this.nRh.getView(), new ViewGroup.LayoutParams(-1, -1));
        }
        if (this.nRi != null) {
            addView(this.nRi, new ViewGroup.LayoutParams(-1, -1));
        }
        AppMethodBeat.o(227546);
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(227547);
        super.onAttachedToWindow();
        try {
            Configuration configuration = getContext().getResources().getConfiguration();
            if (this.kGW.getWindowAndroid() instanceof o) {
                Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(((o) this.kGW.getWindowAndroid()).mContext);
                boolean z = configuration.orientation == 2;
                if ((!z || castActivityOrNull == null || Build.VERSION.SDK_INT < 24 || !castActivityOrNull.isInMultiWindowMode() || castActivityOrNull.getRequestedOrientation() != 1) && castActivityOrNull != null) {
                    Window window = castActivityOrNull.getWindow();
                    View decorView = window.getDecorView();
                    if (z) {
                        window.addFlags(1024);
                        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 4 | 256);
                        AppMethodBeat.o(227547);
                        return;
                    }
                    y.a(window, false, false);
                }
            }
            AppMethodBeat.o(227547);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandAdLoadingSplash", "onAttachedToWindow exception", e2);
            AppMethodBeat.o(227547);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ac
    public final f getRuntimeAdViewContainer() {
        return this.nRi;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ac
    public final ab getInternalLoadingSplash() {
        return this.nRh;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.af
    public final void B(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(227548);
        if (this.nRj != null) {
            this.nRj.btR();
        }
        AppMethodBeat.o(227548);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.af
    public final void bWI() {
        AppMethodBeat.i(227549);
        if (this.nRi != null) {
            f fVar = this.nRi;
            if (MMHandlerThread.isMainThread()) {
                fVar.setVisibility(8);
                AppMethodBeat.o(227549);
                return;
            }
            MMHandlerThread.postToMainThread(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0020: INVOKE  
                  (wrap: com.tencent.mm.plugin.appbrand.ad.f$4 : 0x001d: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.appbrand.ad.f$4) = (r0v1 'fVar' com.tencent.mm.plugin.appbrand.ad.f) call: com.tencent.mm.plugin.appbrand.ad.f.4.<init>(com.tencent.mm.plugin.appbrand.ad.f):void type: CONSTRUCTOR)
                 type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.appbrand.ui.c.bWI():void, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001d: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.appbrand.ad.f$4) = (r0v1 'fVar' com.tencent.mm.plugin.appbrand.ad.f) call: com.tencent.mm.plugin.appbrand.ad.f.4.<init>(com.tencent.mm.plugin.appbrand.ad.f):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.ui.c.bWI():void, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 23 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.ad.f, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 29 more
                */
            /*
                this = this;
                r2 = 227549(0x378dd, float:3.18864E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                com.tencent.mm.plugin.appbrand.ad.f r0 = r3.nRi
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.appbrand.ad.f r0 = r3.nRi
                boolean r1 = com.tencent.mm.sdk.platformtools.MMHandlerThread.isMainThread()
                if (r1 == 0) goto L_0x001b
                r1 = 8
                r0.setVisibility(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x001a:
                return
            L_0x001b:
                com.tencent.mm.plugin.appbrand.ad.f$4 r1 = new com.tencent.mm.plugin.appbrand.ad.f$4
                r1.<init>()
                com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r1)
            L_0x0023:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x001a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.c.bWI():void");
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.af
        public final void k(boolean z, String str) {
            AppMethodBeat.i(227550);
            if (this.nRi != null) {
                this.nRi.k(z, str);
            }
            AppMethodBeat.o(227550);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.ac
        public final void bWJ() {
            AppMethodBeat.i(227551);
            this.kGW.i(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.c.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(227545);
                    if (c.this.getParent() instanceof ViewGroup) {
                        Log.i("MicroMsg.AppBrandAdLoadingSplash", "remove AdLoadingSplash");
                        c.this.setVisibility(8);
                        ((ViewGroup) c.this.getParent()).removeView(c.this);
                        c.this.kGW.brN();
                    }
                    AppMethodBeat.o(227545);
                }
            }, 0);
            AppMethodBeat.o(227551);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.ac
        public final boolean brM() {
            AppMethodBeat.i(227552);
            if (this.nRi == null || indexOfChild(this.nRi) < 0 || this.nRi.getVisibility() != 0 || !p.Um(this.kGW.mAppId).kCO.kGq) {
                AppMethodBeat.o(227552);
                return false;
            }
            AppMethodBeat.o(227552);
            return true;
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.ab
        public final View getView() {
            return this;
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.ab
        public final void eo(String str, String str2) {
            AppMethodBeat.i(227553);
            if (this.nRh != null) {
                this.nRh.eo(str, str2);
            }
            AppMethodBeat.o(227553);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.ab
        public final void z(kotlin.g.a.a<x> aVar) {
            AppMethodBeat.i(227554);
            if (this.nRh != null) {
                this.nRh.z(aVar);
            }
            AppMethodBeat.o(227554);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.ab
        public final void setProgress(int i2) {
            AppMethodBeat.i(227555);
            if (this.nRh != null) {
                this.nRh.setProgress(i2);
            }
            AppMethodBeat.o(227555);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.ab
        public final void yu(int i2) {
            AppMethodBeat.i(227556);
            if (this.nRh != null) {
                this.nRh.yu(i2);
            }
            AppMethodBeat.o(227556);
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.q
        public final void vy(int i2) {
            AppMethodBeat.i(227557);
            if (this.nRh instanceof q) {
                ((q) this.nRh).vy(i2);
            }
            AppMethodBeat.o(227557);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.ae
        public final void setCanShowHideAnimation(boolean z) {
            AppMethodBeat.i(227558);
            if (this.nRh instanceof ae) {
                ((ae) this.nRh).setCanShowHideAnimation(z);
            }
            AppMethodBeat.o(227558);
        }

        @Override // com.tencent.mm.plugin.appbrand.ui.ad
        public final void C(kotlin.g.a.a<x> aVar) {
            AppMethodBeat.i(227559);
            if (this.nRh instanceof ad) {
                ((ad) this.nRh).C(aVar);
            }
            AppMethodBeat.o(227559);
        }
    }
