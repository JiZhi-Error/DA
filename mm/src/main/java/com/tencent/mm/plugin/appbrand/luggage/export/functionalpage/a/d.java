package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.u;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.permission.g;
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u000e\u0010\u0014\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dismissing", "", "value", "", "explainContent", "getExplainContent", "()Ljava/lang/String;", "setExplainContent", "(Ljava/lang/String;)V", "explainContentTv", "Landroid/widget/TextView;", "explainTitle", "getExplainTitle", "setExplainTitle", "explainTitleTv", "dismiss", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "dispatchKeyEventPreIme", "event", "Landroid/view/KeyEvent;", "show", "parent", "Landroid/view/ViewGroup;", "plugin-appbrand-integration_release"})
public final class d extends com.tencent.mm.ui.statusbar.b implements g {
    private boolean jLA;
    private final TextView ncu;
    private final TextView ncv;
    private String ncw;
    private String ncx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(229030);
        LayoutInflater.from(context).inflate(R.layout.dv, (ViewGroup) this, true);
        setBackgroundColor(android.support.v4.content.b.n(context, R.color.afz));
        CF(false);
        View findViewById = findViewById(R.id.gh7);
        p.g(findViewById, "this.findViewById(R.id.privacy_explain_title)");
        this.ncu = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.gh6);
        p.g(findViewById2, "this.findViewById(R.id.privacy_explain_content)");
        this.ncv = (TextView) findViewById2;
        WeImageView weImageView = (WeImageView) findViewById(R.id.ds);
        weImageView.setIconColor(android.support.v4.content.b.n(context, R.color.BW_0_Alpha_0_9));
        weImageView.setOnClickListener(new a(this, context));
        AppMethodBeat.o(229030);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.d$d  reason: collision with other inner class name */
    public static final class ViewTreeObserver$OnPreDrawListenerC0749d implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View nca;
        final /* synthetic */ d ncy;

        public ViewTreeObserver$OnPreDrawListenerC0749d(View view, d dVar) {
            this.nca = view;
            this.ncy = dVar;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.i(229024);
            this.nca.getViewTreeObserver().removeOnPreDrawListener(this);
            View view = this.nca;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.ncy.getContext(), MMFragmentActivity.a.ogm);
            loadAnimation.setAnimationListener(new a(view, this));
            view.startAnimation(loadAnimation);
            AppMethodBeat.o(229024);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b¸\u0006\t"}, hxF = {"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$show$1$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$$special$$inlined$let$lambda$1"})
        /* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.d$d$a */
        public static final class a implements Animation.AnimationListener {
            final /* synthetic */ ViewTreeObserver$OnPreDrawListenerC0749d ncA;
            final /* synthetic */ View ncz;

            a(View view, ViewTreeObserver$OnPreDrawListenerC0749d dVar) {
                this.ncz = view;
                this.ncA = dVar;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(229023);
                Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.ncA.ncy.getContext());
                if (castActivityOrNull != null) {
                    com.tencent.mm.ui.statusbar.c.bt(castActivityOrNull).requestApplyInsets();
                    AppMethodBeat.o(229023);
                    return;
                }
                AppMethodBeat.o(229023);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$1$1"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ d ncy;

        a(d dVar, Context context) {
            this.ncy = dVar;
            this.$context$inlined = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(229020);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$$special$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.ncy.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$$special$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(229020);
        }
    }

    public final String getExplainTitle() {
        return this.ncw;
    }

    public final void setExplainTitle(String str) {
        AppMethodBeat.i(229025);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            str = getContext().getString(R.string.a2f);
        }
        this.ncw = str;
        this.ncu.setText(this.ncw);
        AppMethodBeat.o(229025);
    }

    public final String getExplainContent() {
        return this.ncx;
    }

    public final void setExplainContent(String str) {
        AppMethodBeat.i(229026);
        this.ncx = str;
        String str2 = str;
        if (str2 == null || n.aL(str2)) {
            this.ncv.setText("");
            AppMethodBeat.o(229026);
            return;
        }
        this.ncv.setText(com.tencent.mm.plugin.appbrand.utils.html.c.a(str, false, (c.a) new c(this)));
        this.ncv.setMovementMethod(LinkMovementMethod.getInstance());
        this.ncv.setLinkTextColor(Color.parseColor("#FF576B95"));
        AppMethodBeat.o(229026);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "performOpenUrl"})
    static final class c implements c.a {
        final /* synthetic */ d ncy;

        c(d dVar) {
            this.ncy = dVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.utils.html.c.a
        public final void YF(String str) {
            AppMethodBeat.i(229022);
            Context context = this.ncy.getContext();
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("forceHideShare", true);
            com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(229022);
        }
    }

    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        KeyEvent.DispatcherState keyDispatcherState;
        AppMethodBeat.i(229027);
        if (u.aD(this) && keyEvent != null && 4 == keyEvent.getKeyCode() && (keyDispatcherState = getKeyDispatcherState()) != null) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState.startTracking(keyEvent, this);
                AppMethodBeat.o(229027);
                return true;
            } else if (1 == keyEvent.getAction() && !keyEvent.isCanceled() && keyDispatcherState.isTracking(keyEvent)) {
                dismiss();
                AppMethodBeat.o(229027);
                return true;
            }
        }
        boolean dispatchKeyEventPreIme = super.dispatchKeyEventPreIme(keyEvent);
        AppMethodBeat.o(229027);
        return dispatchKeyEventPreIme;
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.f
    public final void h(com.tencent.mm.plugin.appbrand.d dVar) {
        ViewGroup viewGroup;
        AppMethodBeat.i(229028);
        p.h(dVar, "component");
        Context context = dVar.getContext();
        if (!(context instanceof Activity)) {
            context = null;
        }
        Activity activity = (Activity) context;
        if (activity == null || (viewGroup = (ViewGroup) activity.findViewById(16908290)) == null) {
            AppMethodBeat.o(229028);
            return;
        }
        p.h(viewGroup, "parent");
        viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        bringToFront();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        d dVar2 = this;
        dVar2.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver$OnPreDrawListenerC0749d(dVar2, this));
        AppMethodBeat.o(229028);
    }

    public final void dismiss() {
        AppMethodBeat.i(229029);
        if (this.jLA) {
            AppMethodBeat.o(229029);
            return;
        }
        this.jLA = true;
        animate().cancel();
        Animation animation = getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), MMFragmentActivity.a.ogp);
        loadAnimation.setAnimationListener(new b(this));
        startAnimation(loadAnimation);
        AppMethodBeat.o(229029);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$dismiss$1$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
    public static final class b extends com.tencent.mm.ui.widget.c {
        final /* synthetic */ d ncy;

        b(d dVar) {
            this.ncy = dVar;
        }

        @Override // com.tencent.mm.ui.widget.c
        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(229021);
            a.cw(this.ncy);
            AppMethodBeat.o(229021);
        }
    }
}
