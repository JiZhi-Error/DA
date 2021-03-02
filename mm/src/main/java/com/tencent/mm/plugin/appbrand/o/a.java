package com.tencent.mm.plugin.appbrand.o;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.luggage.sdk.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.platform.window.g;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.statusbar.c;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.k;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0010\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00017B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u000eH\u0002J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0012\u00102\u001a\u00020\u00162\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u00105\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u00106\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager;", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowViewImplScope;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "ctx", "Landroid/content/Context;", "baseWindow", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "currentWindowStableInsetBottom", "", "isMonitorWindowInsets", "", "onApplyWindowInsetsListener", "com/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager$onApplyWindowInsetsListener$2$1", "getOnApplyWindowInsetsListener", "()Lcom/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager$onApplyWindowInsetsListener$2$1;", "onApplyWindowInsetsListener$delegate", "Lkotlin/Lazy;", "applyWindowConfig", "", "initConfig", "createFullscreenHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "provider", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler$FullScreenViewContainerProvider;", "forceLightMode", "getOrientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "getScale", "", "getStatusBar", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid$WindowStatusBar;", "getVDisplayMetrics", "Landroid/util/DisplayMetrics;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "monitorWindowInsets", "monitor", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onApplyWindowInsets", "insets", "Landroid/view/WindowInsets;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "setSoftOrientation", "name", "", "setupWindowLayoutParams", "shouldInLargeScreenCompatMode", "Companion", "plugin-appbrand-integration_release"})
public final class a implements f<AppBrandInitConfigWC>, g {
    public static final C0754a mZG = new C0754a((byte) 0);
    private final Context ctx;
    private final q kFk;
    private int mZC;
    private boolean mZD;
    private final kotlin.f mZE = kotlin.g.a(k.NONE, new d(this));
    private final com.tencent.mm.plugin.appbrand.platform.window.c mZF;

    static {
        AppMethodBeat.i(228820);
        AppMethodBeat.o(228820);
    }

    private final d.AnonymousClass1 bOo() {
        AppMethodBeat.i(228807);
        d.AnonymousClass1 r0 = (d.AnonymousClass1) this.mZE.getValue();
        AppMethodBeat.o(228807);
        return r0;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ a mZH;
        final /* synthetic */ HalfScreenConfig mZI;

        b(a aVar, HalfScreenConfig halfScreenConfig) {
            this.mZH = aVar;
            this.mZI = halfScreenConfig;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.appbrand.o.a$b$a  reason: collision with other inner class name */
        static final class C0755a extends kotlin.g.b.q implements kotlin.g.a.b<HalfScreenConfig.a, Integer> {
            public static final C0755a mZJ = new C0755a();

            static {
                AppMethodBeat.i(228799);
                AppMethodBeat.o(228799);
            }

            C0755a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Integer invoke(HalfScreenConfig.a aVar) {
                int i2;
                AppMethodBeat.i(228798);
                HalfScreenConfig.a aVar2 = aVar;
                p.h(aVar2, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
                switch (b.$EnumSwitchMapping$0[aVar2.ordinal()]) {
                    case 1:
                        i2 = R.anim.ac;
                        break;
                    default:
                        i2 = MMFragmentActivity.a.ogp;
                        break;
                }
                Integer valueOf = Integer.valueOf(i2);
                AppMethodBeat.o(228798);
                return valueOf;
            }
        }

        public final void onClick(View view) {
            AppMethodBeat.i(228800);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager$applyWindowConfig$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Activity context = this.mZH.kFk.getContext();
            if (context != null) {
                HalfScreenConfig halfScreenConfig = this.mZI;
                p.g(context, LocaleUtil.ITALIAN);
                C0755a aVar = C0755a.mZJ;
                p.h(context, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                p.h(aVar, "toAnimationRes");
                if (!p.j(halfScreenConfig.lfq, HalfScreenConfig.CloseWhenClickEmptyAreaConfig.lfE)) {
                    Intent intent = new Intent();
                    intent.putExtra("extra_start_by_half_screen_empty_area_click_scene", true);
                    intent.addFlags(603979776);
                    intent.setClass(context, Class.forName(halfScreenConfig.lfq.lfC));
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/config/HalfScreenConfig", "performCloseHalfScreen", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/config/HalfScreenConfig", "performCloseHalfScreen", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.overridePendingTransition(0, ((Number) aVar.invoke(halfScreenConfig.lfq.lfD)).intValue());
                }
            }
            this.mZH.kFk.close();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager$applyWindowConfig$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(228800);
        }
    }

    public a(q qVar, Context context, com.tencent.mm.plugin.appbrand.platform.window.c cVar) {
        p.h(qVar, "rt");
        p.h(context, "ctx");
        p.h(cVar, "baseWindow");
        AppMethodBeat.i(228819);
        this.kFk = qVar;
        this.ctx = context;
        this.mZF = cVar;
        AppMethodBeat.o(228819);
    }

    public static final /* synthetic */ void a(a aVar, WindowInsets windowInsets) {
        AppMethodBeat.i(228821);
        aVar.onApplyWindowInsets(windowInsets);
        AppMethodBeat.o(228821);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.luggage.sdk.config.AppBrandInitConfigLU] */
    @Override // com.tencent.luggage.sdk.d.f
    public final /* synthetic */ void a(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(228818);
        AppBrandInitConfigWC appBrandInitConfigWC2 = appBrandInitConfigWC;
        p.h(appBrandInitConfigWC2, "initConfig");
        f(appBrandInitConfigWC2);
        AppMethodBeat.o(228818);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.luggage.sdk.config.AppBrandInitConfigLU] */
    @Override // com.tencent.luggage.sdk.d.f
    public final /* synthetic */ void b(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(228811);
        AppBrandInitConfigWC appBrandInitConfigWC2 = appBrandInitConfigWC;
        p.h(appBrandInitConfigWC2, "initConfig");
        f(appBrandInitConfigWC2);
        AppMethodBeat.o(228811);
    }

    @Override // com.tencent.luggage.sdk.d.f
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(228803);
        p.h(configuration, "newConfig");
        AppMethodBeat.o(228803);
    }

    private final void f(AppBrandInitConfigWC appBrandInitConfigWC) {
        b bVar;
        c cVar;
        AppMethodBeat.i(228804);
        Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "applyWindowConfig");
        g(appBrandInitConfigWC);
        HalfScreenConfig halfScreenConfig = appBrandInitConfigWC.kHL;
        p.g(halfScreenConfig, "initConfig.halfScreenConfig");
        com.tencent.mm.plugin.appbrand.widget.c brj = this.kFk.brj();
        p.g(brj, "rt.contentView");
        ViewParent parent = brj.getParent();
        if (parent == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(228804);
            throw tVar;
        }
        View view = (View) parent;
        if (!halfScreenConfig.isEnable() || !halfScreenConfig.lfo) {
            bVar = null;
        } else {
            Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "closeWhenClickEmptyArea appId:" + this.kFk.getAppId() + " config:" + halfScreenConfig);
            bVar = new b(this, halfScreenConfig);
        }
        view.setOnClickListener(bVar);
        com.tencent.mm.plugin.appbrand.widget.c brj2 = this.kFk.brj();
        if (halfScreenConfig.isEnable()) {
            cVar = new c(halfScreenConfig);
        } else {
            cVar = null;
        }
        brj2.setRoundCornerProvider(cVar);
        AppMethodBeat.o(228804);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0014\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "provide"})
    public static final class c implements c.a {
        final /* synthetic */ HalfScreenConfig mZI;

        c(HalfScreenConfig halfScreenConfig) {
            this.mZI = halfScreenConfig;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.c.a
        public final float[] bOp() {
            float f2;
            float f3;
            float f4;
            float f5 = 0.0f;
            HalfScreenConfig.BackgroundShapeConfig backgroundShapeConfig = this.mZI.lfp;
            float[] fArr = new float[8];
            fArr[0] = backgroundShapeConfig.lfw ? backgroundShapeConfig.tt : 0.0f;
            fArr[1] = backgroundShapeConfig.lfw ? backgroundShapeConfig.tt : 0.0f;
            if (backgroundShapeConfig.lfx) {
                f2 = backgroundShapeConfig.tt;
            } else {
                f2 = 0.0f;
            }
            fArr[2] = f2;
            fArr[3] = backgroundShapeConfig.lfx ? backgroundShapeConfig.tt : 0.0f;
            if (backgroundShapeConfig.lfz) {
                f3 = backgroundShapeConfig.tt;
            } else {
                f3 = 0.0f;
            }
            fArr[4] = f3;
            fArr[5] = backgroundShapeConfig.lfz ? backgroundShapeConfig.tt : 0.0f;
            if (backgroundShapeConfig.lfy) {
                f4 = backgroundShapeConfig.tt;
            } else {
                f4 = 0.0f;
            }
            fArr[6] = f4;
            if (backgroundShapeConfig.lfy) {
                f5 = backgroundShapeConfig.tt;
            }
            fArr[7] = f5;
            return fArr;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public final boolean OG() {
        AppMethodBeat.i(228805);
        HalfScreenConfig halfScreenConfig = this.kFk.bsC().kHL;
        boolean isEnable = halfScreenConfig.kuZ & halfScreenConfig.isEnable();
        AppMethodBeat.o(228805);
        return isEnable;
    }

    private final void g(AppBrandInitConfigWC appBrandInitConfigWC) {
        WxaWindowLayoutParams wxaWindowLayoutParams;
        AppMethodBeat.i(228806);
        HalfScreenConfig halfScreenConfig = appBrandInitConfigWC.kHL;
        p.g(halfScreenConfig, "initConfig.halfScreenConfig");
        if (halfScreenConfig.isEnable()) {
            wxaWindowLayoutParams = new WxaWindowLayoutParams(-1, halfScreenConfig.height - this.mZC);
            wxaWindowLayoutParams.gravity = 80;
            this.kFk.getWindowAndroid().a(this.ctx.getResources().getColor(R.color.ac_), this.kFk);
            hZ(true);
        } else {
            WxaWindowLayoutParams wxaWindowLayoutParams2 = new WxaWindowLayoutParams(-1, -1);
            hZ(false);
            wxaWindowLayoutParams = wxaWindowLayoutParams2;
        }
        this.kFk.getWindowAndroid().a(wxaWindowLayoutParams, this.kFk);
        AppMethodBeat.o(228806);
    }

    private final void hZ(boolean z) {
        AppMethodBeat.i(228808);
        Activity context = this.kFk.getContext();
        if (!(context instanceof Activity)) {
            context = null;
        }
        if (context == null) {
            Log.w("MicroMsg.AppBrandHalfWindowLayoutManager", "[monitorWindowInsets] runtime context is null!");
            AppMethodBeat.o(228808);
        } else if (!z) {
            this.mZD = false;
            com.tencent.mm.ui.statusbar.c.bt(context).b(bOo());
            AppMethodBeat.o(228808);
        } else if (this.mZD) {
            AppMethodBeat.o(228808);
        } else {
            this.mZD = true;
            WindowInsets bo = ap.bo(context);
            if (bo != null) {
                p.g(bo, "this");
                onApplyWindowInsets(bo);
            }
            com.tencent.mm.ui.statusbar.c.bt(context).a(bOo());
            AppMethodBeat.o(228808);
        }
    }

    private final void onApplyWindowInsets(WindowInsets windowInsets) {
        AppMethodBeat.i(228809);
        Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "onApplyWindowInsets insets=" + windowInsets + ", currentWindowStableInsetBottom=" + this.mZC);
        if (this.mZC != windowInsets.getStableInsetBottom()) {
            this.mZC = windowInsets.getStableInsetBottom();
            AppBrandInitConfigWC bsC = this.kFk.bsC();
            p.g(bsC, "rt.initConfig");
            g(bsC);
        }
        AppMethodBeat.o(228809);
    }

    @Override // com.tencent.luggage.sdk.d.f
    public final void a(com.tencent.mm.plugin.appbrand.config.b bVar) {
        AppMethodBeat.i(228810);
        p.h(bVar, "appConfig");
        Log.i("MicroMsg.AppBrandHalfWindowLayoutManager", "onAppConfigGot");
        AppMethodBeat.o(228810);
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public final e getOrientationHandler() {
        AppMethodBeat.i(228812);
        e orientationHandler = this.mZF.getOrientationHandler();
        p.g(orientationHandler, "baseWindow.orientationHandler");
        AppMethodBeat.o(228812);
        return orientationHandler;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public final DisplayMetrics getVDisplayMetrics() {
        AppMethodBeat.i(228813);
        if (this.kFk.bsC().kHL.isEnable()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Resources resources = this.ctx.getResources();
            p.g(resources, "ctx.resources");
            displayMetrics.setTo(resources.getDisplayMetrics());
            displayMetrics.heightPixels = this.kFk.bsC().kHL.height;
            AppMethodBeat.o(228813);
            return displayMetrics;
        }
        DisplayMetrics vDisplayMetrics = this.mZF.getVDisplayMetrics();
        p.g(vDisplayMetrics, "baseWindow.vDisplayMetrics");
        AppMethodBeat.o(228813);
        return vDisplayMetrics;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public final c.C0789c getStatusBar() {
        AppMethodBeat.i(228814);
        if (this.kFk.bsC().kHL.isEnable()) {
            c.C0789c cVar = new c.C0789c();
            cVar.height = 0;
            cVar.visibility = 8;
            AppMethodBeat.o(228814);
            return cVar;
        }
        c.C0789c statusBar = this.mZF.getStatusBar();
        AppMethodBeat.o(228814);
        return statusBar;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public final boolean OD() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public final com.tencent.mm.plugin.appbrand.platform.window.d a(d.b bVar) {
        AppMethodBeat.i(228815);
        com.tencent.mm.plugin.appbrand.platform.window.d a2 = this.mZF.a(bVar);
        p.g(a2, "baseWindow.createFullscreenHandler(provider)");
        AppMethodBeat.o(228815);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public final float getScale() {
        AppMethodBeat.i(228816);
        float scale = this.mZF.getScale();
        AppMethodBeat.o(228816);
        return scale;
    }

    @Override // com.tencent.mm.plugin.appbrand.platform.window.g
    public final void setSoftOrientation(String str) {
        AppMethodBeat.i(228817);
        this.mZF.setSoftOrientation(str);
        AppMethodBeat.o(228817);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.o.a$a  reason: collision with other inner class name */
    public static final class C0754a {
        private C0754a() {
        }

        public /* synthetic */ C0754a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<anonymous>", "com/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager$onApplyWindowInsetsListener$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager$onApplyWindowInsetsListener$2$1;"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<AnonymousClass1> {
        final /* synthetic */ a mZH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar) {
            super(0);
            this.mZH = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ AnonymousClass1 invoke() {
            AppMethodBeat.i(228802);
            AnonymousClass1 r0 = new c.a(this) {
                /* class com.tencent.mm.plugin.appbrand.o.a.d.AnonymousClass1 */
                final /* synthetic */ d mZK;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.mZK = r1;
                }

                @Override // com.tencent.mm.ui.statusbar.c.a
                public final void yf(int i2) {
                    AppMethodBeat.i(228801);
                    Activity context = this.mZK.mZH.kFk.getContext();
                    if (!(context instanceof Activity)) {
                        context = null;
                    }
                    if (context == null) {
                        AppMethodBeat.o(228801);
                        return;
                    }
                    WindowInsets bo = ap.bo(context);
                    if (bo != null) {
                        a aVar = this.mZK.mZH;
                        p.g(bo, "this");
                        a.a(aVar, bo);
                        AppMethodBeat.o(228801);
                        return;
                    }
                    AppMethodBeat.o(228801);
                }
            };
            AppMethodBeat.o(228802);
            return r0;
        }
    }
}
