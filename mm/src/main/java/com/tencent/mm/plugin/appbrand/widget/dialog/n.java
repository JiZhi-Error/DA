package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.tencent.luggage.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J\u0014\u0010\u0010\u001a\u00020\u000b*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\f\u0010\u0012\u001a\u00020\r*\u00020\u0006H\u0002J\u001a\u0010\u0013\u001a\u00020\u0004*\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0002J\f\u0010\u0016\u001a\u00020\u0004*\u00020\bH\u0002J\f\u0010\u0017\u001a\u00020\u0006*\u00020\u0006H\u0007¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper;", "", "()V", "applyStyleByRotation", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/View;", "buttonGroup", "rotation", "", "shouldInLargeScreenCompatMode", "", "getAppropriateLargeScreenRequestDialogWidth", "dialogMeasuredWidth", "dp2Px", "dp", "isLargeScreenEnv", "onPreDrawOnce", "block", "Lkotlin/Function0;", "postRequestLayout", "wrapScreenAdaptiveContextForRequestDialogIfNeed", "luggage-wechat-full-sdk_release"})
public final class n {
    public static final n JjY = new n();

    static {
        AppMethodBeat.i(148269);
        AppMethodBeat.o(148269);
    }

    private n() {
    }

    public static void a(Context context, View view, View view2, int i2, boolean z) {
        ViewGroup.LayoutParams layoutParams;
        ViewParent viewParent;
        ViewParent viewParent2;
        ViewParent viewParent3 = null;
        AppMethodBeat.i(183080);
        p.h(context, "context");
        p.h(view, "rootView");
        if (view2 != null) {
            layoutParams = view2.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (i2 == 1 || i2 == 3) {
            if (view2 != null) {
                viewParent = view2.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof RelativeLayout) {
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(183080);
                    throw tVar;
                }
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.sq);
            }
            if (!z) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.st);
                view.setLayoutParams(layoutParams2);
                AppMethodBeat.o(183080);
                return;
            }
        } else {
            if (view2 != null) {
                viewParent2 = view2.getParent();
            } else {
                viewParent2 = null;
            }
            if (viewParent2 instanceof RelativeLayout) {
                if (layoutParams == null) {
                    t tVar2 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(183080);
                    throw tVar2;
                }
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.sr);
            }
            if (z || !dk(context)) {
                ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                layoutParams3.width = -1;
                view.setLayoutParams(layoutParams3);
            } else {
                a aVar = new a(view, context);
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                p.g(viewTreeObserver, "this.viewTreeObserver");
                if (viewTreeObserver.isAlive()) {
                    view.getViewTreeObserver().addOnPreDrawListener(new b(view, aVar));
                }
                if (view2 != null) {
                    viewParent3 = view2.getParent();
                }
                if (viewParent3 instanceof RelativeLayout) {
                    if (layoutParams == null) {
                        t tVar3 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        AppMethodBeat.o(183080);
                        throw tVar3;
                    }
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.sq);
                    AppMethodBeat.o(183080);
                    return;
                }
            }
        }
        AppMethodBeat.o(183080);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/appbrand/widget/dialog/RequestDialogRotationHelper$onPreDrawOnce$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "luggage-wechat-full-sdk_release"})
    public static final class b implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ kotlin.g.a.a hvp;
        final /* synthetic */ View jCH;

        b(View view, kotlin.g.a.a aVar) {
            this.jCH = view;
            this.hvp = aVar;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.i(169661);
            ViewTreeObserver viewTreeObserver = this.jCH.getViewTreeObserver();
            p.g(viewTreeObserver, "this@onPreDrawOnce.viewTreeObserver");
            if (viewTreeObserver.isAlive()) {
                this.jCH.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            this.hvp.invoke();
            AppMethodBeat.o(169661);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ View jCI;

        c(View view) {
            this.jCI = view;
        }

        public final void run() {
            AppMethodBeat.i(169662);
            this.jCI.requestLayout();
            AppMethodBeat.o(169662);
        }
    }

    private static boolean dk(Context context) {
        AppMethodBeat.i(183081);
        Resources resources = context.getResources();
        p.g(resources, "this.resources");
        if ((resources.getConfiguration().screenLayout & 15) >= 3) {
            AppMethodBeat.o(183081);
            return true;
        }
        AppMethodBeat.o(183081);
        return false;
    }

    public static final int aZ(Context context, int i2) {
        AppMethodBeat.i(169666);
        p.h(context, "context");
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.st);
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        int max = Math.max(dimensionPixelSize, resources.getDisplayMetrics().widthPixels / 2);
        if (i2 < dimensionPixelSize) {
            i2 = dimensionPixelSize;
        } else if (i2 > max) {
            i2 = max;
        }
        Resources resources2 = context.getResources();
        p.g(resources2, "context.resources");
        int min = Math.min(i2, resources2.getDisplayMetrics().widthPixels);
        AppMethodBeat.o(169666);
        return min;
    }

    public static final Context dF(Context context) {
        AppMethodBeat.i(169667);
        p.h(context, "$this$wrapScreenAdaptiveContextForRequestDialogIfNeed");
        if (!dk(context)) {
            AppMethodBeat.o(169667);
            return context;
        }
        com.tencent.luggage.g.a aVar = new com.tencent.luggage.g.a(context, d.oro);
        AppMethodBeat.o(169667);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Landroid/util/DisplayMetrics;", "originalMetrics", "<anonymous parameter 1>", "Landroid/content/res/Configuration;", "applyScreenAdaptiveDensity"})
    public static final class d implements a.b {
        public static final d oro = new d();

        static {
            AppMethodBeat.i(169664);
            AppMethodBeat.o(169664);
        }

        d() {
        }

        @Override // com.tencent.luggage.g.a.b
        public final DisplayMetrics a(DisplayMetrics displayMetrics, Configuration configuration) {
            float f2;
            AppMethodBeat.i(169663);
            p.h(displayMetrics, "originalMetrics");
            p.h(configuration, "<anonymous parameter 1>");
            int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            if (((float) min) / displayMetrics.density >= 600.0f) {
                f2 = ((float) min) / 600.0f;
            } else if (((float) min) / displayMetrics.density <= 240.0f) {
                f2 = ((float) min) / 240.0f;
            } else {
                f2 = ((float) min) / 450.0f;
            }
            int round = Math.round(160.0f * f2);
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            displayMetrics2.setTo(displayMetrics);
            displayMetrics2.scaledDensity = (displayMetrics.scaledDensity / displayMetrics.density) * f2;
            displayMetrics2.densityDpi = round;
            displayMetrics2.density = f2;
            AppMethodBeat.o(169663);
            return displayMetrics2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ View orn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(View view, Context context) {
            super(0);
            this.orn = view;
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(169660);
            this.orn.getLayoutParams().width = n.aZ(this.$context, this.orn.getMeasuredWidth());
            n nVar = n.JjY;
            n.cT(this.orn);
            x xVar = x.SXb;
            AppMethodBeat.o(169660);
            return xVar;
        }
    }

    public static final /* synthetic */ void cT(View view) {
        AppMethodBeat.i(169668);
        MMHandlerThread.postToMainThread(new c(view));
        AppMethodBeat.o(169668);
    }
}
