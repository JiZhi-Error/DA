package com.tencent.mm.plugin.appbrand.ad;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.p.u;
import com.tencent.mm.plugin.appbrand.page.capsulebar.d;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0001J\u0011\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rH\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u0001J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0001J\t\u0010\u0014\u001a\u00020\u0012H\u0001J\u0011\u0010\u0015\u001a\n \u000e*\u0004\u0018\u00010\u00160\u0016H\u0001J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0011\u0010\u0019\u001a\n \u000e*\u0004\u0018\u00010\u001a0\u001aH\u0001J\t\u0010\u001b\u001a\u00020\u000bH\u0001J\u0019\u0010\u001c\u001a\u00020\u000b2\u000e\u0010\u001d\u001a\n \u000e*\u0004\u0018\u00010\u001e0\u001eH\u0001J\u0011\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0010H\u0001J\u0011\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0012H\u0001J\u0019\u0010#\u001a\u00020\u000b2\u000e\u0010\u001d\u001a\n \u000e*\u0004\u0018\u00010\u001e0\u001eH\u0001J\u0011\u0010$\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0012H\u0001J\u000e\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'J\u0019\u0010%\u001a\u00020\u000b2\u000e\u0010(\u001a\n \u000e*\u0004\u0018\u00010)0)H\u0001J\u000e\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020'J\u0011\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020'H\u0001J\u0019\u0010.\u001a\u00020\u000b2\u000e\u0010/\u001a\n \u000e*\u0004\u0018\u00010\u00160\u0016H\u0001J\u0011\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020'H\u0001J\u0019\u00102\u001a\u00020\u000b2\u000e\u0010\u001d\u001a\n \u000e*\u0004\u0018\u00010\u001e0\u001eH\u0001J\u0011\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020'H\u0001J\u000e\u00105\u001a\u00020\u000b2\u0006\u00104\u001a\u00020'J\u000e\u00106\u001a\u00020\u000b2\u0006\u00104\u001a\u00020'R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ad/AppBrandActionBarWithCapsule;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/IAppBrandActionBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "(Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;)V", "capsuleBarImplView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarImplView;", "destroy", "", "getActionView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBackgroundAlpha", "", "getBackgroundColor", "", "getCapsuleView", "getForegroundColor", "getMainTitle", "", "getOptionButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "getParent", "Landroid/view/ViewParent;", "resetForegroundStyle", "setBackButtonClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "setBackgroundAlpha", "alpha", u.NAME, "color", "setCloseButtonClickListener", "setForegroundColor", "setForegroundStyle", "isBlack", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "setFullscreenMode", "fullscreen", "setLoadingIconVisibility", "visible", "setMainTitle", "title", "setNavHidden", "hidden", "setOptionButtonClickListener", "showCapsuleArea", "show", "showNavArea", "showTitleArea", "luggage-wxa-app_release"})
public final class a implements e {
    private d kGm;
    final b kGn;

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void destroy() {
        AppMethodBeat.i(219663);
        this.kGn.destroy();
        AppMethodBeat.o(219663);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final View getActionView() {
        AppMethodBeat.i(219664);
        View actionView = this.kGn.getActionView();
        AppMethodBeat.o(219664);
        return actionView;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final int getBackgroundColor() {
        AppMethodBeat.i(219665);
        int backgroundColor = this.kGn.getBackgroundColor();
        AppMethodBeat.o(219665);
        return backgroundColor;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void gz(boolean z) {
        AppMethodBeat.i(219673);
        this.kGn.gz(z);
        AppMethodBeat.o(219673);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void setBackButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(219666);
        this.kGn.setBackButtonClickListener(onClickListener);
        AppMethodBeat.o(219666);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void setBackgroundColor(int i2) {
        AppMethodBeat.i(219667);
        this.kGn.setBackgroundColor(i2);
        AppMethodBeat.o(219667);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void setCloseButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(219668);
        this.kGn.setCloseButtonClickListener(onClickListener);
        AppMethodBeat.o(219668);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void setForegroundColor(int i2) {
        AppMethodBeat.i(219669);
        this.kGn.setForegroundColor(i2);
        AppMethodBeat.o(219669);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void setForegroundStyle(String str) {
        AppMethodBeat.i(219670);
        this.kGn.setForegroundStyle(str);
        AppMethodBeat.o(219670);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void setLoadingIconVisibility(boolean z) {
        AppMethodBeat.i(219671);
        this.kGn.setLoadingIconVisibility(z);
        AppMethodBeat.o(219671);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.e
    public final void setMainTitle(CharSequence charSequence) {
        AppMethodBeat.i(219672);
        this.kGn.setMainTitle(charSequence);
        AppMethodBeat.o(219672);
    }

    private a(b bVar) {
        AppMethodBeat.i(219661);
        this.kGn = bVar;
        View findViewById = this.kGn.findViewById(R.id.h70);
        if (findViewById == null) {
            p.hyc();
        }
        if (findViewById == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(219661);
            throw tVar;
        }
        ((ViewGroup) findViewById).removeAllViews();
        this.kGm = new d(((ViewGroup) findViewById).getContext());
        ViewGroup viewGroup = (ViewGroup) findViewById;
        d dVar = this.kGm;
        if (dVar == null) {
            p.btv("capsuleBarImplView");
        }
        viewGroup.addView(dVar, new ViewGroup.LayoutParams(-2, -2));
        this.kGn.setCapsuleBarInteractionDelegate(new C0533a(this));
        AppMethodBeat.o(219661);
    }

    public static final /* synthetic */ d a(a aVar) {
        AppMethodBeat.i(219674);
        d dVar = aVar.kGm;
        if (dVar == null) {
            p.btv("capsuleBarImplView");
        }
        AppMethodBeat.o(219674);
        return dVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        this(new b(context));
        p.h(context, "context");
        AppMethodBeat.i(219662);
        AppMethodBeat.o(219662);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/ad/AppBrandActionBarWithCapsule$1$1", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$CapsuleBarInteractionDelegate;", "dispatchCapsuleViewVisibilityChanged", "", "visibility", "", "setHomeButtonOnClickListener", "l", "Landroid/view/View$OnClickListener;", "setOptionButtonOnClickListener", "setStyleColor", "color", "luggage-wxa-app_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ad.a$a  reason: collision with other inner class name */
    public static final class C0533a implements b.AbstractC0818b {
        final /* synthetic */ a kGo;

        C0533a(a aVar) {
            this.kGo = aVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.AbstractC0818b
        public final void setStyleColor(int i2) {
            AppMethodBeat.i(219653);
            a.a(this.kGo).setStyleColor(i2);
            AppMethodBeat.o(219653);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.AbstractC0818b
        public final void setHomeButtonOnClickListener(View.OnClickListener onClickListener) {
            AppMethodBeat.i(219654);
            a.a(this.kGo).setHomeButtonOnClickListener(onClickListener);
            AppMethodBeat.o(219654);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.AbstractC0818b
        public final void setOptionButtonOnClickListener(View.OnClickListener onClickListener) {
            AppMethodBeat.i(219655);
            a.a(this.kGo).setOptionButtonOnClickListener(onClickListener);
            AppMethodBeat.o(219655);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.AbstractC0818b
        public final void vI(int i2) {
            AppMethodBeat.i(219656);
            a.a(this.kGo).setVisibility(i2);
            AppMethodBeat.o(219656);
        }
    }

    public final void setFullscreenMode(boolean z) {
        AppMethodBeat.i(219657);
        this.kGn.setFullscreenMode(z);
        AppMethodBeat.o(219657);
    }

    public final void gx(boolean z) {
        AppMethodBeat.i(219658);
        this.kGn.gx(z);
        AppMethodBeat.o(219658);
    }

    public final void gy(boolean z) {
        AppMethodBeat.i(219659);
        this.kGn.gy(z);
        AppMethodBeat.o(219659);
    }

    public final AppBrandOptionButton btD() {
        AppMethodBeat.i(219660);
        d dVar = this.kGm;
        if (dVar == null) {
            p.btv("capsuleBarImplView");
        }
        AppBrandOptionButton optionBtn = dVar.getOptionBtn();
        AppMethodBeat.o(219660);
        return optionBtn;
    }
}
