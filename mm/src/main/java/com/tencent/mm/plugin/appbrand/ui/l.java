package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u000e\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\tH\u0007J\u000e\u0010\n\u001a\u00020\b*\u0004\u0018\u00010\u000bH\u0007¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLoadingSplashUtils;", "", "()V", "fromDPToPix", "", "Landroid/content/Context;", "dp", "hideImmediately", "", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "safeDetachFromWindow", "Landroid/view/View;", "luggage-wxa-app_release"})
public final class l {
    public static final l nUf = new l();

    static {
        AppMethodBeat.i(160939);
        AppMethodBeat.o(160939);
    }

    private l() {
    }

    public static final void a(ab abVar) {
        View view;
        AppMethodBeat.i(160938);
        if (abVar == null || (view = abVar.getView()) == null) {
            AppMethodBeat.o(160938);
            return;
        }
        if (view.isAttachedToWindow()) {
            View view2 = abVar.getView();
            p.g(view2, "view");
            Animation animation = view2.getAnimation();
            if (animation != null) {
                animation.cancel();
            }
            abVar.getView().animate().cancel();
            View view3 = abVar.getView();
            p.g(view3, "view");
            view3.setVisibility(8);
            View view4 = abVar.getView();
            p.g(view4, "view");
            ViewParent parent = view4.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(160938);
                throw tVar;
            }
            ((ViewGroup) parent).removeView(abVar.getView());
        }
        AppMethodBeat.o(160938);
    }

    public static final void cG(View view) {
        AppMethodBeat.i(219785);
        if (view == null) {
            AppMethodBeat.o(219785);
            return;
        }
        view.setVisibility(8);
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(view);
            AppMethodBeat.o(219785);
            return;
        }
        AppMethodBeat.o(219785);
    }
}
