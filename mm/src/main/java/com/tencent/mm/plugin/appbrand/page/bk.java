package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewActionBarExtensionImpl;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewActionBarExtension;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "isInForeground", "", "applyActionBarSizeProperty", "", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "onActionbarInstalled", "onBackground", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onForeground", "Companion", "luggage-wechat-full-sdk_release"})
public final class bk implements com.tencent.mm.plugin.appbrand.page.a.a {
    public static final a ntw = new a((byte) 0);
    private final ac cxr;
    private boolean ntv;

    static {
        AppMethodBeat.i(183075);
        AppMethodBeat.o(183075);
    }

    public bk(ac acVar) {
        p.h(acVar, "page");
        AppMethodBeat.i(183074);
        this.cxr = acVar;
        AppMethodBeat.o(183074);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onForeground() {
        AppMethodBeat.i(183071);
        this.ntv = true;
        b bRi = this.cxr.bRi();
        p.g(bRi, "page.actionBar");
        c(bRi);
        AppMethodBeat.o(183071);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onBackground() {
        this.ntv = false;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onDestroy() {
        this.ntv = false;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(183072);
        p.h(configuration, "newConfig");
        if (!this.ntv) {
            AppMethodBeat.o(183072);
            return;
        }
        b bRi = this.cxr.bRi();
        p.g(bRi, "page.actionBar");
        c(bRi);
        AppMethodBeat.o(183072);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.b
    public final void a(b bVar) {
        AppMethodBeat.i(230120);
        p.h(bVar, "actionBar");
        c(bVar);
        AppMethodBeat.o(230120);
    }

    private static void c(b bVar) {
        AppMethodBeat.i(230121);
        Context context = bVar.getContext();
        AppBrandCapsuleBarPlaceHolderView capsuleView = bVar.getCapsuleView();
        if (capsuleView != null) {
            p.g(capsuleView, LocaleUtil.ITALIAN);
            if (capsuleView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.LayoutParams layoutParams = capsuleView.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(230121);
                    throw tVar;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                p.g(context, "context");
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.oq);
                if (marginLayoutParams.rightMargin != dimensionPixelSize) {
                    marginLayoutParams.rightMargin = dimensionPixelSize;
                    Log.i("MPPageViewActionBarExtensionImpl", "[applyActionBarSizeProperty] reset capsule rightMargin:".concat(String.valueOf(dimensionPixelSize)));
                    capsuleView.requestLayout();
                }
            } else if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                RuntimeException runtimeException = new RuntimeException("it is not MarginLayoutParams");
                AppMethodBeat.o(230121);
                throw runtimeException;
            }
        }
        b.a navResetStyleListener = bVar.getNavResetStyleListener();
        int bQz = navResetStyleListener != null ? navResetStyleListener.bQz() : b.a.omi;
        bVar.cad();
        p.g(context, "context");
        bVar.setNavContainerMinimumWidth(context.getResources().getDimensionPixelOffset(bQz));
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.or);
        bVar.setActionBarHeight(dimensionPixelOffset);
        StringBuilder append = new StringBuilder("[applyActionBarSizeProperty] ActionBar height=").append(dimensionPixelOffset).append("  density=");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        Log.i("MPPageViewActionBarExtensionImpl", append.append(resources.getDisplayMetrics().density).toString());
        AppMethodBeat.o(230121);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/MPPageViewActionBarExtensionImpl$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
