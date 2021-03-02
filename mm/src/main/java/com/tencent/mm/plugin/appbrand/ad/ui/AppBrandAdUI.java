package com.tencent.mm.plugin.appbrand.ad.ui;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.ad.a.c;
import com.tencent.mm.plugin.appbrand.ad.f;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.ui.ah;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.statusbar.d;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tavkit.component.TAVExporter;
import java.util.List;

public class AppBrandAdUI extends MMBaseActivity {
    private AppBrandRuntime kGM;
    private f kGV;
    private FrameLayout kHl;
    private a kHm;
    private IListener<b> kHn = new IListener<b>() {
        /* class com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI.AnonymousClass5 */

        {
            AppMethodBeat.i(160566);
            this.__eventId = b.class.getName().hashCode();
            AppMethodBeat.o(160566);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(b bVar) {
            AppMethodBeat.i(44057);
            b bVar2 = bVar;
            if (AppBrandAdUI.this.kGM == null || Util.isNullOrNil(AppBrandAdUI.this.kGM.mAppId) || !AppBrandAdUI.this.kGM.mAppId.equalsIgnoreCase(bVar2.kHp.appId)) {
                AppMethodBeat.o(44057);
                return false;
            }
            Log.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "receive close splash ad event, finish");
            AppBrandAdUI.this.finish();
            AppBrandAdUI.this.overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
            AppMethodBeat.o(44057);
            return true;
        }
    };

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppBrandAdUI() {
        AppMethodBeat.i(44058);
        AppMethodBeat.o(44058);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44060);
        setRequestedOrientation(1);
        super.onCreate(bundle);
        View decorView = getWindow().getDecorView();
        decorView.requestApplyInsets();
        if (Build.VERSION.SDK_INT >= 26) {
            decorView.setSystemUiVisibility(1296);
        } else {
            decorView.setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        }
        d.e(getWindow());
        d.d(getWindow(), true);
        this.kHl = new FrameLayout(this);
        this.kHl.setBackgroundColor(0);
        setContentView(this.kHl);
        String stringExtra = getIntent().getStringExtra("appId");
        if (Util.isNullOrNil(stringExtra)) {
            Log.e("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onCreate, appId is null");
            finish();
            AppMethodBeat.o(44060);
            return;
        }
        this.kGM = a.TQ(stringExtra);
        if (this.kGM == null || this.kGM.isDestroyed()) {
            Log.e("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onCreate, runtime is null");
            finish();
            AppMethodBeat.o(44060);
            return;
        }
        if (this.kGM.NY() != null) {
            this.kGM.NY().btf();
        }
        this.kGV = new f(this, this.kGM);
        this.kGM.kAw = this.kGV;
        this.kGV.btL();
        this.kGV.setActionBarFullscreenMode(true);
        f fVar = this.kGV;
        if (fVar.kGP != null) {
            fVar.kGP.gx(true);
        }
        this.kGV.btM();
        f fVar2 = this.kGV;
        if (fVar2.kGP != null) {
            fVar2.kGP.gy(true);
        }
        this.kGV.setTitle(getResources().getString(R.string.i5));
        if (ao.isDarkMode()) {
            this.kGV.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
            this.kGV.setForegroundStyle(false);
        } else {
            this.kGV.setBackgroundColor(-1);
            this.kGV.setForegroundStyle(true);
        }
        this.kGV.setBackButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(44053);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (AppBrandAdUI.this.kGM != null) {
                    com.tencent.mm.plugin.appbrand.ad.a.b bVar2 = new com.tencent.mm.plugin.appbrand.ad.a.b();
                    bVar2.source = "menu";
                    bVar2.type = "back";
                    bVar2.d(AppBrandAdUI.this.kGM.NY());
                }
                AppBrandAdUI.this.finish();
                AppBrandAdUI.this.overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(44053);
            }
        });
        this.kGV.setCloseButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(44054);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (AppBrandAdUI.this.kGM != null) {
                    com.tencent.mm.plugin.appbrand.ad.a.b bVar2 = new com.tencent.mm.plugin.appbrand.ad.a.b();
                    bVar2.source = "menu";
                    bVar2.type = "close";
                    bVar2.d(AppBrandAdUI.this.kGM.NY());
                    h.a(AppBrandAdUI.this.kGM.mAppId, h.d.CLOSE);
                    AppBrandAdUI.this.kGM.close();
                    c cVar = new c();
                    cVar.source = "menu";
                    cVar.d(AppBrandAdUI.this.kGM.NY());
                }
                AppBrandAdUI.this.finish();
                ((ah) e.M(ah.class)).m(AppBrandAdUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(44054);
            }
        });
        this.kGV.setOptionButtonClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI.AnonymousClass3 */

            public final void onClick(View view) {
                ac pageView;
                List<t> bRh;
                AppMethodBeat.i(44055);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!(AppBrandAdUI.this.kGM == null || AppBrandAdUI.this.kGM.brh() == null || AppBrandAdUI.this.kGM.brh().getPageView() == null || (bRh = (pageView = AppBrandAdUI.this.kGM.brh().getPageView()).bRh()) == null || bRh.isEmpty() || !(pageView instanceof ag))) {
                    AppBrandAdUI.this.kHm = new a(AppBrandAdUI.this, pageView, bRh);
                    AppBrandAdUI.this.kHm.btY();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(44055);
            }
        });
        this.kGV.setOnHideListener(new f.a() {
            /* class com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.ad.f.a
            public final void UB(String str) {
                AppMethodBeat.i(44056);
                if (AppBrandAdUI.this.kGM != null && "menu".equalsIgnoreCase(str)) {
                    com.tencent.mm.plugin.appbrand.ad.a.d dVar = new com.tencent.mm.plugin.appbrand.ad.a.d();
                    dVar.source = str;
                    dVar.d(AppBrandAdUI.this.kGM.NY());
                    c cVar = new c();
                    cVar.source = str;
                    cVar.d(AppBrandAdUI.this.kGM.NY());
                }
                AppMethodBeat.o(44056);
            }
        });
        f fVar3 = this.kGV;
        if (MMHandlerThread.isMainThread()) {
            fVar3.btN();
        } else {
            MMHandlerThread.postToMainThread(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0167: INVOKE  
                  (wrap: com.tencent.mm.plugin.appbrand.ad.f$1 : 0x0164: CONSTRUCTOR  (r1v16 com.tencent.mm.plugin.appbrand.ad.f$1) = (r0v31 'fVar3' com.tencent.mm.plugin.appbrand.ad.f) call: com.tencent.mm.plugin.appbrand.ad.f.1.<init>(com.tencent.mm.plugin.appbrand.ad.f):void type: CONSTRUCTOR)
                 type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI.onCreate(android.os.Bundle):void, file: classes3.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0164: CONSTRUCTOR  (r1v16 com.tencent.mm.plugin.appbrand.ad.f$1) = (r0v31 'fVar3' com.tencent.mm.plugin.appbrand.ad.f) call: com.tencent.mm.plugin.appbrand.ad.f.1.<init>(com.tencent.mm.plugin.appbrand.ad.f):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI.onCreate(android.os.Bundle):void, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 27 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.ad.f, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 33 more
                */
            /*
            // Method dump skipped, instructions count: 363
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI.onCreate(android.os.Bundle):void");
        }

        @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
        public void onResume() {
            AppMethodBeat.i(44061);
            super.onResume();
            Log.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onResume");
            if (this.kGM != null) {
                com.tencent.mm.plugin.appbrand.ad.a.e eVar = new com.tencent.mm.plugin.appbrand.ad.a.e();
                eVar.source = "menu";
                eVar.d(this.kGM.NY());
            }
            AppMethodBeat.o(44061);
        }

        @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
        public void onPause() {
            AppMethodBeat.i(44062);
            super.onPause();
            Log.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onPause");
            if (this.kHm != null) {
                this.kHm.btZ();
            }
            if (this.kGM != null) {
                com.tencent.mm.plugin.appbrand.ad.a.d dVar = new com.tencent.mm.plugin.appbrand.ad.a.d();
                dVar.source = "menu";
                dVar.d(this.kGM.NY());
            }
            AppMethodBeat.o(44062);
        }

        @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
        public void onDestroy() {
            AppMethodBeat.i(44063);
            super.onDestroy();
            Log.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onDestroy");
            if (this.kHn != null) {
                this.kHn.dead();
                this.kHn = null;
            }
            if (this.kHm != null) {
                this.kHm.btZ();
            }
            if (this.kGV != null) {
                this.kGV.k(false, "menu");
                if (this.kGV.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.kGV.getParent()).removeView(this.kGV);
                }
                this.kGV = null;
            }
            if (this.kGM != null) {
                this.kGM.kAw = null;
                if (this.kGM.NY() != null) {
                    this.kGM.NY().btf();
                }
            }
            AppMethodBeat.o(44063);
        }

        public void onConfigurationChanged(Configuration configuration) {
            AppMethodBeat.i(44064);
            super.onConfigurationChanged(configuration);
            setRequestedOrientation(1);
            AppMethodBeat.o(44064);
        }

        public void onBackPressed() {
            AppMethodBeat.i(226280);
            super.onBackPressed();
            if (isFinishing()) {
                overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
            }
            AppMethodBeat.o(226280);
        }
    }
