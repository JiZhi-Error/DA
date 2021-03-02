package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.q;
import com.tencent.mm.plugin.appbrand.phonenumber.u;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010K\u001a\u00020(H\u0002J\b\u0010L\u001a\u00020(H\u0002J$\u0010M\u001a\u00020N2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010O\u001a\u0004\u0018\u00010\t2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\b\u0010R\u001a\u00020(H\u0002J\u0010\u0010S\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010T\u001a\u00020(2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0012\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\b\u0010[\u001a\u00020(H\u0002J\u0010\u0010\\\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010]\u001a\u00020(2\u0006\u0010\\\u001a\u00020XH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R0\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020(0'@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010.\u001a\b\u0012\u0004\u0012\u00020(0'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R \u00101\u001a\b\u0012\u0004\u0012\u00020(0'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R0\u00104\u001a\b\u0012\u0004\u0012\u00020(0'2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020(0'@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010+\"\u0004\b6\u0010-R \u00107\u001a\b\u0012\u0004\u0012\u00020(0'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010+\"\u0004\b9\u0010-R \u0010:\u001a\b\u0012\u0004\u0012\u00020(0'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010+\"\u0004\b<\u0010-R<\u0010?\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020(0=2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020(0=@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CRD\u0010F\u001a\u0012\u0012\u0004\u0012\u00020>0Dj\b\u0012\u0004\u0012\u00020>`E2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020>0Dj\b\u0012\u0004\u0012\u00020>`E@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006^"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;)V", "BACKGROUND_COLOR", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "iconUrl", "getIconUrl", "setIconUrl", "mApplyWordingTv", "Landroid/widget/TextView;", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mContentLayout", "Landroid/widget/LinearLayout;", "mFuncTv", "mIconIv", "Landroid/widget/ImageView;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "mLoadingView", "Landroid/view/View;", "mNameTv", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "mRequestDescTv", "mRootView", "Landroid/widget/RelativeLayout;", "mSimpleDetailDescTv", "Lkotlin/Function0;", "", "onAccept", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onPhoneItemSelect", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "adjustRequestContainerHeight", "callOnCancel", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "decorateSystemBars", "dismiss", "dispatchConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "onCreateView", "show", "showPrivacyExplainEntry", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class c extends com.tencent.mm.ui.statusbar.b implements com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a {
    private View gAy;
    private String iconUrl;
    private TextView jVh;
    private ImageView lIM;
    private Button lJa;
    private Button lJb;
    private String lJe;
    private ArrayList<PhoneItem> lJn;
    private kotlin.g.a.a<x> lJo;
    private kotlin.g.a.a<x> lJq;
    private kotlin.g.a.a<x> lJt;
    private kotlin.g.a.a<x> lJu;
    private kotlin.g.a.a<x> lJv;
    private RecyclerView mRecyclerView;
    private final int nbL;
    private TextView nbR;
    private TextView nbT;
    private final com.tencent.mm.plugin.appbrand.d nbZ;
    private RelativeLayout ncd;
    private TextView nce;
    private LinearLayout ncf;
    private TextView ncg;
    private q nch;
    private kotlin.g.a.a<x> nci;
    private kotlin.g.a.b<? super PhoneItem, x> ncj;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c$c  reason: collision with other inner class name */
    public static final class View$OnLayoutChangeListenerC0748c implements View.OnLayoutChangeListener {
        final /* synthetic */ c nck;

        public View$OnLayoutChangeListenerC0748c(c cVar) {
            this.nck = cVar;
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            AppMethodBeat.i(228975);
            kotlin.g.b.p.h(view, "view");
            view.removeOnLayoutChangeListener(this);
            c.h(this.nck);
            AppMethodBeat.o(228975);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View nca;
        final /* synthetic */ c nck;

        public a(View view, c cVar) {
            this.nca = view;
            this.nck = cVar;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.i(228973);
            this.nca.getViewTreeObserver().removeOnPreDrawListener(this);
            ViewParent parent = c.g(this.nck).getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null && viewGroup.getMeasuredHeight() > c.g(this.nck).getMeasuredHeight()) {
                ViewGroup.LayoutParams layoutParams = c.g(this.nck).getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = viewGroup.getMeasuredHeight();
                }
                c.g(this.nck).requestLayout();
            }
            AppMethodBeat.o(228973);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
    public static final class o implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d mpE;
        final /* synthetic */ View nca;

        public o(View view, com.tencent.mm.plugin.appbrand.d dVar) {
            this.nca = view;
            this.mpE = dVar;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.i(228991);
            this.nca.getViewTreeObserver().removeOnPreDrawListener(this);
            View view = this.nca;
            view.setTranslationY((float) view.getMeasuredHeight());
            ViewPropertyAnimator duration = view.animate().setInterpolator(new AccelerateDecelerateInterpolator()).translationY(0.0f).setDuration(300);
            duration.setListener(new a(this));
            duration.start();
            AppMethodBeat.o(228991);
            return true;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$show$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-appbrand-integration_release", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$$special$$inlined$apply$lambda$1"})
        public static final class a extends AnimatorListenerAdapter {
            final /* synthetic */ o nct;

            a(o oVar) {
                this.nct = oVar;
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(228990);
                Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.nct.mpE.getContext());
                if (castActivityOrNull != null) {
                    com.tencent.mm.ui.statusbar.c.bt(castActivityOrNull).requestApplyInsets();
                    AppMethodBeat.o(228990);
                    return;
                }
                AppMethodBeat.o(228990);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final d ncl = new d();

        static {
            AppMethodBeat.i(228976);
            AppMethodBeat.o(228976);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final e ncm = new e();

        static {
            AppMethodBeat.i(228977);
            AppMethodBeat.o(228977);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final f ncn = new f();

        static {
            AppMethodBeat.i(228978);
            AppMethodBeat.o(228978);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final j nco = new j();

        static {
            AppMethodBeat.i(228982);
            AppMethodBeat.o(228982);
        }

        j() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final k ncp = new k();

        static {
            AppMethodBeat.i(228983);
            AppMethodBeat.o(228983);
        }

        k() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final l ncq = new l();

        static {
            AppMethodBeat.i(228984);
            AppMethodBeat.o(228984);
        }

        l() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.b<PhoneItem, x> {
        public static final m ncr = new m();

        static {
            AppMethodBeat.i(228986);
            AppMethodBeat.o(228986);
        }

        m() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(PhoneItem phoneItem) {
            AppMethodBeat.i(228985);
            kotlin.g.b.p.h(phoneItem, "<anonymous parameter 0>");
            x xVar = x.SXb;
            AppMethodBeat.o(228985);
            return xVar;
        }
    }

    public static final /* synthetic */ q a(c cVar) {
        AppMethodBeat.i(229012);
        q qVar = cVar.nch;
        if (qVar == null) {
            kotlin.g.b.p.btv("mItemAdapter");
        }
        AppMethodBeat.o(229012);
        return qVar;
    }

    public static final /* synthetic */ RecyclerView c(c cVar) {
        AppMethodBeat.i(229013);
        RecyclerView recyclerView = cVar.mRecyclerView;
        if (recyclerView == null) {
            kotlin.g.b.p.btv("mRecyclerView");
        }
        AppMethodBeat.o(229013);
        return recyclerView;
    }

    public static final /* synthetic */ LinearLayout d(c cVar) {
        AppMethodBeat.i(229014);
        LinearLayout linearLayout = cVar.ncf;
        if (linearLayout == null) {
            kotlin.g.b.p.btv("mContentLayout");
        }
        AppMethodBeat.o(229014);
        return linearLayout;
    }

    public static final /* synthetic */ View e(c cVar) {
        AppMethodBeat.i(229015);
        View view = cVar.gAy;
        if (view == null) {
            kotlin.g.b.p.btv("mLoadingView");
        }
        AppMethodBeat.o(229015);
        return view;
    }

    public static final /* synthetic */ TextView f(c cVar) {
        AppMethodBeat.i(229016);
        TextView textView = cVar.ncg;
        if (textView == null) {
            kotlin.g.b.p.btv("mFuncTv");
        }
        AppMethodBeat.o(229016);
        return textView;
    }

    public static final /* synthetic */ RelativeLayout g(c cVar) {
        AppMethodBeat.i(229017);
        RelativeLayout relativeLayout = cVar.ncd;
        if (relativeLayout == null) {
            kotlin.g.b.p.btv("mRootView");
        }
        AppMethodBeat.o(229017);
        return relativeLayout;
    }

    public static final /* synthetic */ void h(c cVar) {
        AppMethodBeat.i(229018);
        cVar.bOO();
        AppMethodBeat.o(229018);
    }

    public static final /* synthetic */ void i(c cVar) {
        AppMethodBeat.i(229019);
        cVar.bON();
        AppMethodBeat.o(229019);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(com.tencent.mm.plugin.appbrand.d r8) {
        /*
        // Method dump skipped, instructions count: 593
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c.<init>(com.tencent.mm.plugin.appbrand.d):void");
    }

    public final String getAppBrandName() {
        return this.lJe;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setAppBrandName(String str) {
        AppMethodBeat.i(228993);
        this.lJe = str;
        TextView textView = this.jVh;
        if (textView == null) {
            kotlin.g.b.p.btv("mNameTv");
        }
        textView.setText(str != null ? str : "");
        AppMethodBeat.o(228993);
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setIconUrl(String str) {
        AppMethodBeat.i(228994);
        this.iconUrl = str;
        com.tencent.mm.modelappbrand.a.b aXY = com.tencent.mm.modelappbrand.a.b.aXY();
        ImageView imageView = this.lIM;
        if (imageView == null) {
            kotlin.g.b.p.btv("mIconIv");
        }
        aXY.a(imageView, getIconUrl(), R.drawable.cg_, com.tencent.mm.modelappbrand.a.g.iJB);
        AppMethodBeat.o(228994);
    }

    public final ArrayList<PhoneItem> getPhoneItems() {
        return this.lJn;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setPhoneItems(ArrayList<PhoneItem> arrayList) {
        AppMethodBeat.i(228995);
        kotlin.g.b.p.h(arrayList, "value");
        this.lJn = arrayList;
        this.nbZ.P(new n(this));
        AppMethodBeat.o(228995);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class n implements Runnable {
        final /* synthetic */ c nck;

        n(c cVar) {
            this.nck = cVar;
        }

        public final void run() {
            AppMethodBeat.i(228989);
            c cVar = this.nck;
            String appId = this.nck.nbZ.getAppId();
            kotlin.g.b.p.g(appId, "component.appId");
            Context context = this.nck.getContext();
            kotlin.g.b.p.g(context, "context");
            cVar.nch = new q(appId, context, this.nck.getPhoneItems());
            c.c(this.nck).setAdapter(c.a(this.nck));
            c.d(this.nck).setVisibility(0);
            if (this.nck.getPhoneItems().size() == 0) {
                c.e(this.nck).setVisibility(0);
                c.c(this.nck).setVisibility(8);
                c.f(this.nck).setVisibility(8);
                AppMethodBeat.o(228989);
            } else if (this.nck.getPhoneItems().size() == 1) {
                c.e(this.nck).setVisibility(8);
                c.c(this.nck).setVisibility(0);
                RecyclerView.a adapter = c.c(this.nck).getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                c.f(this.nck).setVisibility(0);
                c.f(this.nck).setText(this.nck.getContext().getString(R.string.a2z));
                c.f(this.nck).setOnClickListener(new View.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c.n.AnonymousClass1 */
                    final /* synthetic */ n ncs;

                    {
                        this.ncs = r1;
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.i(228987);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        this.ncs.nck.getOnAddPhoneNumber().invoke();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(228987);
                    }
                });
                u uVar = u.nAe;
                u.bTz();
                AppMethodBeat.o(228989);
            } else {
                c.e(this.nck).setVisibility(8);
                c.c(this.nck).setVisibility(0);
                c.f(this.nck).setVisibility(0);
                RecyclerView.a adapter2 = c.c(this.nck).getAdapter();
                if (adapter2 != null) {
                    adapter2.notifyDataSetChanged();
                }
                c.f(this.nck).setText(this.nck.getContext().getString(R.string.a2x));
                c.f(this.nck).setOnClickListener(new View.OnClickListener(this) {
                    /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.c.n.AnonymousClass2 */
                    final /* synthetic */ n ncs;

                    {
                        this.ncs = r1;
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.i(228988);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        this.ncs.nck.getOnManagePhoneNumber().invoke();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$phoneItems$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(228988);
                    }
                });
                u uVar2 = u.nAe;
                u.bTz();
                AppMethodBeat.o(228989);
            }
        }
    }

    public final kotlin.g.a.a<x> getOnAccept() {
        return this.lJo;
    }

    public final void setOnAccept(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(228996);
        kotlin.g.b.p.h(aVar, "value");
        this.lJo = aVar;
        Button button = this.lJa;
        if (button == null) {
            kotlin.g.b.p.btv("mBtnAccept");
        }
        CharSequence text = button.getText();
        if (text == null || text.length() == 0) {
            Button button2 = this.lJa;
            if (button2 == null) {
                kotlin.g.b.p.btv("mBtnAccept");
            }
            Context context = getContext();
            kotlin.g.b.p.g(context, "context");
            button2.setText(context.getResources().getString(R.string.a36));
        }
        AppMethodBeat.o(228996);
    }

    public final kotlin.g.a.a<x> getOnDeny() {
        return this.nci;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setOnDeny(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(228997);
        kotlin.g.b.p.h(aVar, "value");
        this.nci = aVar;
        Button button = this.lJb;
        if (button == null) {
            kotlin.g.b.p.btv("mBtnReject");
        }
        CharSequence text = button.getText();
        if (text == null || text.length() == 0) {
            Button button2 = this.lJb;
            if (button2 == null) {
                kotlin.g.b.p.btv("mBtnReject");
            }
            Context context = getContext();
            kotlin.g.b.p.g(context, "context");
            button2.setText(context.getResources().getString(R.string.a37));
        }
        AppMethodBeat.o(228997);
    }

    public final kotlin.g.a.a<x> getOnCancel() {
        return this.lJq;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setOnCancel(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(228998);
        kotlin.g.b.p.h(aVar, "<set-?>");
        this.lJq = aVar;
        AppMethodBeat.o(228998);
    }

    public final kotlin.g.a.a<x> getOnExplain() {
        return this.lJt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setOnExplain(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(228999);
        kotlin.g.b.p.h(aVar, "<set-?>");
        this.lJt = aVar;
        AppMethodBeat.o(228999);
    }

    public final kotlin.g.a.a<x> getOnAddPhoneNumber() {
        return this.lJu;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setOnAddPhoneNumber(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(229000);
        kotlin.g.b.p.h(aVar, "<set-?>");
        this.lJu = aVar;
        AppMethodBeat.o(229000);
    }

    public final kotlin.g.a.a<x> getOnManagePhoneNumber() {
        return this.lJv;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setOnManagePhoneNumber(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(229001);
        kotlin.g.b.p.h(aVar, "<set-?>");
        this.lJv = aVar;
        AppMethodBeat.o(229001);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem, kotlin.x>, kotlin.g.a.b<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem, kotlin.x> */
    public final kotlin.g.a.b<PhoneItem, x> getOnPhoneItemSelect() {
        return this.ncj;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void setOnPhoneItemSelect(kotlin.g.a.b<? super PhoneItem, x> bVar) {
        AppMethodBeat.i(229002);
        kotlin.g.b.p.h(bVar, "value");
        this.ncj = bVar;
        Button button = this.lJa;
        if (button == null) {
            kotlin.g.b.p.btv("mBtnAccept");
        }
        CharSequence text = button.getText();
        if (text == null || text.length() == 0) {
            Button button2 = this.lJa;
            if (button2 == null) {
                kotlin.g.b.p.btv("mBtnAccept");
            }
            Context context = getContext();
            kotlin.g.b.p.g(context, "context");
            button2.setText(context.getResources().getString(R.string.a36));
        }
        AppMethodBeat.o(229002);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
    public final void hm(boolean z) {
        AppMethodBeat.i(229003);
        ImageView imageView = (ImageView) findViewById(R.id.h3w);
        kotlin.g.b.p.g(imageView, "optionBtn");
        imageView.setVisibility(z ? 0 : 8);
        if (z) {
            imageView.setImageDrawable(android.support.v4.content.b.l(getContext(), R.drawable.bxy));
            imageView.setOnClickListener(new p(this));
            AppMethodBeat.o(229003);
            return;
        }
        imageView.setOnClickListener(null);
        AppMethodBeat.o(229003);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class p implements View.OnClickListener {
        final /* synthetic */ c nck;

        p(c cVar) {
            this.nck = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(228992);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$showPrivacyExplainEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.nck.getOnExplain().invoke();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$showPrivacyExplainEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(228992);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.f
    public final void h(com.tencent.mm.plugin.appbrand.d dVar) {
        ViewGroup viewGroup;
        AppMethodBeat.i(229004);
        kotlin.g.b.p.h(dVar, "component");
        Context context = dVar.getContext();
        if (!(context instanceof Activity)) {
            context = null;
        }
        Activity activity = (Activity) context;
        if (!(activity == null || (viewGroup = (ViewGroup) activity.findViewById(16908290)) == null)) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
        bringToFront();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        c cVar = this;
        cVar.getViewTreeObserver().addOnPreDrawListener(new o(cVar, dVar));
        S(this.nbL, !ao.isDarkMode());
        setBackgroundColor(this.nbL);
        Context context2 = this.nbZ.getContext();
        if (!(context2 instanceof AppBrandUI)) {
            context2 = null;
        }
        AppBrandUI appBrandUI = (AppBrandUI) context2;
        if (appBrandUI != null) {
            appBrandUI.setNavigationbarColor(this.nbL);
            AppMethodBeat.o(229004);
            return;
        }
        AppMethodBeat.o(229004);
    }

    public final void i(com.tencent.mm.plugin.appbrand.d dVar) {
        AppMethodBeat.i(229005);
        kotlin.g.b.p.h(dVar, "component");
        animate().cancel();
        animate().translationY((float) getMeasuredHeight()).setDuration(300).withEndAction(new b(this)).start();
        AppMethodBeat.o(229005);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ c nck;

        b(c cVar) {
            this.nck = cVar;
        }

        public final void run() {
            AppMethodBeat.i(228974);
            a.cw(this.nck);
            AppMethodBeat.o(228974);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.h
    public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.d dVar, String str, ag agVar) {
        AppMethodBeat.i(229006);
        kotlin.g.b.p.h(dVar, "component");
        Context context = dVar.getContext();
        kotlin.g.b.p.g(context, "component.context");
        d dVar2 = new d(context);
        dVar2.setExplainContent(str);
        d dVar3 = dVar2;
        AppMethodBeat.o(229006);
        return dVar3;
    }

    private final void bOO() {
        AppMethodBeat.i(229007);
        RelativeLayout relativeLayout = this.ncd;
        if (relativeLayout == null) {
            kotlin.g.b.p.btv("mRootView");
        }
        RelativeLayout relativeLayout2 = relativeLayout;
        relativeLayout2.getViewTreeObserver().addOnPreDrawListener(new a(relativeLayout2, this));
        AppMethodBeat.o(229007);
    }

    public final void dispatchConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(229008);
        super.dispatchConfigurationChanged(configuration);
        RelativeLayout relativeLayout = this.ncd;
        if (relativeLayout == null) {
            kotlin.g.b.p.btv("mRootView");
        }
        relativeLayout.addOnLayoutChangeListener(new View$OnLayoutChangeListenerC0748c(this));
        AppMethodBeat.o(229008);
    }

    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        KeyEvent.DispatcherState keyDispatcherState;
        AppMethodBeat.i(229009);
        if (android.support.v4.view.u.aD(this) && keyEvent != null && 4 == keyEvent.getKeyCode() && (keyDispatcherState = getKeyDispatcherState()) != null) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState.startTracking(keyEvent, this);
                AppMethodBeat.o(229009);
                return true;
            } else if (1 == keyEvent.getAction() && !keyEvent.isCanceled() && keyDispatcherState.isTracking(keyEvent)) {
                bON();
                AppMethodBeat.o(229009);
                return true;
            }
        }
        boolean dispatchKeyEventPreIme = super.dispatchKeyEventPreIme(keyEvent);
        AppMethodBeat.o(229009);
        return dispatchKeyEventPreIme;
    }

    private final void bON() {
        AppMethodBeat.i(229010);
        getOnCancel().invoke();
        i(this.nbZ);
        AppMethodBeat.o(229010);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ c nck;

        g(c cVar) {
            this.nck = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(228979);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            c.i(this.nck);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(228979);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h implements View.OnClickListener {
        final /* synthetic */ c nck;

        h(c cVar) {
            this.nck = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(228980);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.nck.getOnAccept().invoke();
            Iterator<PhoneItem> it = c.a(this.nck).lJn.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PhoneItem next = it.next();
                if (next.nzz) {
                    kotlin.g.a.b<PhoneItem, x> onPhoneItemSelect = this.nck.getOnPhoneItemSelect();
                    kotlin.g.b.p.g(next, "phoneItem");
                    onPhoneItemSelect.invoke(next);
                    break;
                }
            }
            this.nck.i(this.nck.nbZ);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(228980);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ c nck;

        i(c cVar) {
            this.nck = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(228981);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.nck.getOnDeny().invoke();
            this.nck.i(this.nck.nbZ);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePhoneNumberManagerPresenterUIView$onCreateView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(228981);
        }
    }
}
