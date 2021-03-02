package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0014J&\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0014R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandActionBarHomeButtonStyle;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$AbsNavResetStyleListener;", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "hidden", "", "navStyleApplied", "getNavAreaLeftMarginResourceId", "", "isNavStyleInvisible", "onBackButtonClicked", "view", "Landroid/view/View;", "resetNavStyle", "", "navButton", "Landroid/widget/ImageView;", "navArea", "navContainer", "Companion", "luggage-wxa-app_release"})
public class b extends b.a {
    @Deprecated
    public static final a nnr = new a((byte) 0);
    public boolean nno;
    public boolean nnp;
    private final ac nnq;

    static {
        AppMethodBeat.i(219689);
        AppMethodBeat.o(219689);
    }

    public b(ac acVar) {
        p.h(acVar, "pageView");
        AppMethodBeat.i(219688);
        this.nnq = acVar;
        AppMethodBeat.o(219688);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandActionBarHomeButtonStyle$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.a
    public final void a(ImageView imageView, View view, View view2) {
        AppMethodBeat.i(219686);
        this.nnp = true;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                AppMethodBeat.o(219686);
                throw tVar;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            Context context = imageView.getContext();
            p.g(context, "navButton.context");
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.ov);
            layoutParams2.height = dimensionPixelOffset;
            layoutParams2.width = dimensionPixelOffset;
            layoutParams2.gravity = 17;
            imageView.setLayoutParams(layoutParams2);
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            imageView.clearColorFilter();
            imageView.setImageDrawable(android.support.v4.content.b.l(imageView.getContext(), R.drawable.bxd));
            com.tencent.mm.plugin.appbrand.widget.actionbar.b bRi = this.nnq.bRi();
            p.g(bRi, "pageView.actionBar");
            imageView.setColorFilter(bRi.getForegroundColor(), PorterDuff.Mode.SRC_ATOP);
            imageView.setBackgroundResource(R.drawable.cb);
            Context context2 = imageView.getContext();
            p.g(context2, "navButton.context");
            int dimensionPixelOffset2 = context2.getResources().getDimensionPixelOffset(R.dimen.k5);
            imageView.setPadding(dimensionPixelOffset2, imageView.getPaddingTop(), dimensionPixelOffset2, imageView.getPaddingBottom());
        }
        if (view != null) {
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            if (layoutParams3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                AppMethodBeat.o(219686);
                throw tVar2;
            }
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
            Context context3 = view.getContext();
            p.g(context3, "navArea.context");
            int dimensionPixelOffset3 = context3.getResources().getDimensionPixelOffset(R.dimen.os);
            layoutParams4.height = dimensionPixelOffset3;
            layoutParams4.width = dimensionPixelOffset3;
            layoutParams4.gravity = 17;
            Context context4 = view.getContext();
            p.g(context4, "navArea.context");
            layoutParams4.leftMargin = context4.getResources().getDimensionPixelOffset(R.dimen.ot);
            Context context5 = view.getContext();
            p.g(context5, "navArea.context");
            layoutParams4.rightMargin = context5.getResources().getDimensionPixelOffset(R.dimen.ou);
            view.setLayoutParams(layoutParams4);
            com.tencent.mm.plugin.appbrand.widget.actionbar.b bRi2 = this.nnq.bRi();
            p.g(bRi2, "pageView.actionBar");
            view.setBackgroundResource(bRi2.getForegroundColor() == -1 ? R.drawable.cy : R.drawable.cz);
        }
        if (view2 != null) {
            view2.setOnTouchListener(new View$OnTouchListenerC0770b(view));
            AppMethodBeat.o(219686);
            return;
        }
        AppMethodBeat.o(219686);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    /* renamed from: com.tencent.mm.plugin.appbrand.page.b$b  reason: collision with other inner class name */
    static final class View$OnTouchListenerC0770b implements View.OnTouchListener {
        final /* synthetic */ View nns;

        View$OnTouchListenerC0770b(View view) {
            this.nns = view;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(219685);
            if (this.nns != null) {
                this.nns.onTouchEvent(motionEvent);
                AppMethodBeat.o(219685);
                return true;
            }
            AppMethodBeat.o(219685);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.a
    public final int bQz() {
        return R.dimen.ot;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.a
    public boolean cz(View view) {
        AppMethodBeat.i(219687);
        p.h(view, "view");
        Log.i("MicroMsg.AppBrandActionBarHomeButtonStyle", "pageView click close button");
        com.tencent.mm.plugin.appbrand.widget.actionbar.b bRi = this.nnq.bRi();
        p.g(bRi, "pageView.actionBar");
        if (bRi.cae()) {
            Log.i("MicroMsg.AppBrandActionBarHomeButtonStyle", "pageView click close button, but nav area is hidden");
        } else {
            AppBrandRuntime runtime = this.nnq.getRuntime();
            p.g(runtime, "pageView.runtime");
            w brh = runtime.brh();
            if (brh != null) {
                brh.bQR();
            }
        }
        AppMethodBeat.o(219687);
        return true;
    }
}
