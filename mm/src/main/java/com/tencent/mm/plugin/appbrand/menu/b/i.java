package com.tencent.mm.plugin.appbrand.menu.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\"\u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/menu/devtools/SecondaryMenuDelegate_GameGlyphBitmap;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseSecondaryMenuDelegate;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "TAG", "", "attachOnRootView", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "bitmap", "Landroid/graphics/Bitmap;", "getTitle", "context", "Landroid/content/Context;", "pageView", "appId", "makeBitmapImage", "Landroid/view/View;", "performItemClick", "removeFromRootView", "shouldShow", "", "plugin-appbrand-integration_release"})
public final class i implements b<ag> {
    private static final String TAG = TAG;
    public static final i nfY = new i();

    static {
        AppMethodBeat.i(229056);
        AppMethodBeat.o(229056);
    }

    private i() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ boolean a(Context context, ag agVar, String str) {
        AppMethodBeat.i(229053);
        ag agVar2 = agVar;
        p.h(context, "context");
        p.h(agVar2, "pageView");
        p.h(str, "appId");
        m av = agVar2.av(AppBrandSysConfigWC.class);
        p.g(av, "pageView.getConfig(AppBr…dSysConfigWC::class.java)");
        AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) av;
        if ((appBrandSysConfigWC.leE.kNW == 1 || appBrandSysConfigWC.leE.kNW == 2 || WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv() || BuildInfo.IS_FLAVOR_RED) && (agVar2.getRuntime() instanceof q)) {
            q runtime = agVar2.getRuntime();
            if (runtime == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
                AppMethodBeat.o(229053);
                throw tVar;
            } else if (runtime.NA()) {
                AppMethodBeat.o(229053);
                return true;
            }
        }
        AppMethodBeat.o(229053);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ String b(Context context, ag agVar, String str) {
        AppMethodBeat.i(229054);
        p.h(context, "context");
        p.h(agVar, "pageView");
        p.h(str, "appId");
        AppMethodBeat.o(229054);
        return "Glyph Bitmap";
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ void c(Context context, ag agVar, String str) {
        e eVar;
        Bitmap bitmap;
        IMBFontHandler Rh;
        AppMethodBeat.i(229055);
        ag agVar2 = agVar;
        p.h(context, "context");
        p.h(agVar2, "pageView");
        q runtime = agVar2.getRuntime();
        p.g(runtime, "pageView.runtime");
        c bsE = runtime.bsE();
        if (bsE instanceof d) {
            com.tencent.luggage.game.d.a.a.b bVar = (com.tencent.luggage.game.d.a.a.b) bsE.S(com.tencent.luggage.game.d.a.a.b.class);
            eVar = bVar != null ? bVar.getMagicBrush() : null;
        } else {
            eVar = null;
        }
        if (eVar == null || (Rh = eVar.Rh()) == null) {
            bitmap = null;
        } else {
            bitmap = Rh.getBitmapAtlas();
        }
        if (bitmap == null) {
            Log.i("GameGlyphBitmap", "bitmap is null");
            AppMethodBeat.o(229055);
            return;
        }
        Activity activity = (Activity) context;
        Log.i(TAG, "dl: attachOnRootView");
        View findViewById = activity.findViewById(16908290);
        if (findViewById == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(229055);
            throw tVar;
        }
        FrameLayout frameLayout = (FrameLayout) findViewById;
        SubsamplingScaleImageView subsamplingScaleImageView = new SubsamplingScaleImageView(activity, null);
        subsamplingScaleImageView.setImage(com.davemorrissey.labs.subscaleview.view.a.l(bitmap));
        subsamplingScaleImageView.setBackgroundColor(-13224394);
        subsamplingScaleImageView.setScaleRate(1.0f);
        frameLayout.addView(subsamplingScaleImageView, -1, -1);
        Button button = new Button(activity, null, 16843563);
        button.setText("EXIT");
        button.setTextColor(-1);
        button.setOnClickListener(new a(activity));
        Button button2 = button;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(100);
        layoutParams.topMargin = 100;
        frameLayout.addView(button2, layoutParams);
        AppMethodBeat.o(229055);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/menu/devtools/SecondaryMenuDelegate_GameGlyphBitmap$attachOnRootView$1$1"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ Activity nfZ;

        a(Activity activity) {
            this.nfZ = activity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(229052);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/menu/devtools/SecondaryMenuDelegate_GameGlyphBitmap$attachOnRootView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            i iVar = i.nfY;
            i.D(this.nfZ);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/menu/devtools/SecondaryMenuDelegate_GameGlyphBitmap$attachOnRootView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(229052);
        }
    }

    public static final /* synthetic */ void D(Activity activity) {
        AppMethodBeat.i(229057);
        Log.i(TAG, "dl: attachOnRootView");
        View findViewById = activity.findViewById(16908290);
        if (findViewById == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(229057);
            throw tVar;
        }
        FrameLayout frameLayout = (FrameLayout) findViewById;
        frameLayout.removeViewAt(frameLayout.getChildCount() - 1);
        frameLayout.removeViewAt(frameLayout.getChildCount() - 1);
        AppMethodBeat.o(229057);
    }
}
