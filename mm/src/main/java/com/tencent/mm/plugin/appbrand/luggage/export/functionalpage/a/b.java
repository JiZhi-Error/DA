package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.u;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
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
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.permission.a.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.MaxHeightRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020DH\u0002J$\u0010F\u001a\u00020G2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u00010\u000b2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010K\u001a\u00020DH\u0002J\u0010\u0010L\u001a\u00020D2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010M\u001a\u00020D2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\u0012\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u0012\u0010T\u001a\u00020Q2\b\u0010U\u001a\u0004\u0018\u000103H\u0016J\n\u0010V\u001a\u0004\u0018\u000103H\u0016J \u0010W\u001a\u0012\u0012\u0004\u0012\u00020\u000b0Xj\b\u0012\u0004\u0012\u00020\u000b`Y2\u0006\u0010Z\u001a\u00020QH\u0002J\n\u0010[\u001a\u0004\u0018\u000101H\u0002J\b\u0010\\\u001a\u00020DH\u0002J\u0012\u0010]\u001a\u00020D2\b\u0010\u0005\u001a\u0004\u0018\u00010^H\u0016J\u0012\u0010_\u001a\u00020D2\b\u0010\u0005\u001a\u0004\u0018\u00010^H\u0016J\u0012\u0010`\u001a\u00020D2\b\u0010a\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010b\u001a\u00020D2\b\b\u0001\u0010c\u001a\u00020\tH\u0016J\u0010\u0010d\u001a\u00020D2\u0006\u0010e\u001a\u00020\tH\u0016J\u0012\u0010f\u001a\u00020D2\b\u0010g\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010h\u001a\u00020D2\u0006\u0010\u0005\u001a\u00020iH\u0016J\u0012\u0010j\u001a\u00020D2\b\u0010k\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010l\u001a\u00020D2\u0006\u0010m\u001a\u00020\u000bH\u0016J\u0018\u0010n\u001a\u00020D2\u000e\u0010o\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010pH\u0016J\u0010\u0010q\u001a\u00020D2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010r\u001a\u00020D2\u0006\u0010q\u001a\u00020QH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\n\u001a\u0004\u0018\u00010\u0019@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X.¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020100X\u0004¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X.¢\u0006\u0002\n\u0000R(\u0010=\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u000e\"\u0004\b?\u0010\u0010R(\u0010@\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\u0010¨\u0006s"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;)V", "BACKGROUND_COLOR", "", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "funcTv", "Landroid/widget/TextView;", "iconUrl", "getIconUrl", "setIconUrl", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "itemCheckedListener", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "getListener", "()Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;)V", "loadingView", "Landroid/view/View;", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDescTv", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mItems", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "mLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "mNameTv", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/ui/MaxHeightRecyclerView;", "requestContainer", "Landroid/widget/RelativeLayout;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "adjustRequestContainerHeight", "", "callOnCancel", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "decorateSystemBars", "dismiss", "dispatchConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "getLastPointerDownTouchEvent", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "getSelectedItem", "onCreateView", "setExplainOnClickListener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "setFunctionButtonVisibility", "visibility", "setNegativeButtonText", "negativeButtonText", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setPositiveButtonText", "positiveButtonText", "setScope", "scope", "setSelectListItem", "items", "", "show", "showExplainIv", "plugin-appbrand-integration_release"})
@SuppressLint({"ViewConstructor"})
public final class b extends com.tencent.mm.ui.statusbar.b implements com.tencent.mm.plugin.appbrand.permission.a.b {
    private final List<i.a> cvc;
    private View hSw;
    private String iconUrl;
    private TextView jVh;
    private TextView jVn;
    private String lGX;
    private ImageView lIM;
    private ImageView lIO;
    private Button lJa;
    private Button lJb;
    private String lJe;
    private final int nbL;
    private MaxHeightRecyclerView nbM;
    private RelativeLayout nbN;
    private b.c nbO;
    private MotionEvent nbP;
    private String nbQ;
    private TextView nbR;
    private String nbS;
    private TextView nbT;
    private String nbU;
    private LinearLayout nbV;
    private i nbW;
    private i.b nbX;
    private TextView nbY;
    private com.tencent.mm.plugin.appbrand.d nbZ;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-appbrand-integration_release"})
    public static final class c implements View.OnLayoutChangeListener {
        final /* synthetic */ b ncb;

        public c(b bVar) {
            this.ncb = bVar;
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            AppMethodBeat.i(228934);
            p.h(view, "view");
            view.removeOnLayoutChangeListener(this);
            b.e(this.ncb);
            AppMethodBeat.o(228934);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View nca;
        final /* synthetic */ b ncb;

        public a(View view, b bVar) {
            this.nca = view;
            this.ncb = bVar;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.i(228932);
            this.nca.getViewTreeObserver().removeOnPreDrawListener(this);
            ViewParent parent = b.d(this.ncb).getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null && viewGroup.getMeasuredHeight() > b.d(this.ncb).getMeasuredHeight()) {
                ViewGroup.LayoutParams layoutParams = b.d(this.ncb).getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = viewGroup.getMeasuredHeight();
                }
                b.d(this.ncb).requestLayout();
            }
            AppMethodBeat.o(228932);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
    public static final class g implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d mpE;
        final /* synthetic */ View nca;

        public g(View view, com.tencent.mm.plugin.appbrand.d dVar) {
            this.nca = view;
            this.mpE = dVar;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.i(228939);
            this.nca.getViewTreeObserver().removeOnPreDrawListener(this);
            View view = this.nca;
            view.setTranslationY((float) view.getMeasuredHeight());
            ViewPropertyAnimator duration = view.animate().setInterpolator(new AccelerateDecelerateInterpolator()).translationY(0.0f).setDuration(300);
            duration.setListener(new a(this));
            duration.start();
            AppMethodBeat.o(228939);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$show$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-appbrand-integration_release", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$$special$$inlined$apply$lambda$1"})
        public static final class a extends AnimatorListenerAdapter {
            final /* synthetic */ g ncc;

            a(g gVar) {
                this.ncc = gVar;
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(228938);
                Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.ncc.mpE.getContext());
                if (castActivityOrNull != null) {
                    com.tencent.mm.ui.statusbar.c.bt(castActivityOrNull).requestApplyInsets();
                    AppMethodBeat.o(228938);
                    return;
                }
                AppMethodBeat.o(228938);
            }
        }
    }

    public static final /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(228967);
        bVar.bON();
        AppMethodBeat.o(228967);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.appbrand.d b(b bVar) {
        AppMethodBeat.i(228969);
        com.tencent.mm.plugin.appbrand.d dVar = bVar.nbZ;
        if (dVar == null) {
            p.btv("component");
        }
        AppMethodBeat.o(228969);
        return dVar;
    }

    public static final /* synthetic */ i.a c(b bVar) {
        AppMethodBeat.i(228970);
        i.a selectedItem = bVar.getSelectedItem();
        AppMethodBeat.o(228970);
        return selectedItem;
    }

    public static final /* synthetic */ RelativeLayout d(b bVar) {
        AppMethodBeat.i(228971);
        RelativeLayout relativeLayout = bVar.nbN;
        if (relativeLayout == null) {
            p.btv("requestContainer");
        }
        AppMethodBeat.o(228971);
        return relativeLayout;
    }

    public static final /* synthetic */ void e(b bVar) {
        AppMethodBeat.i(228972);
        bVar.bOO();
        AppMethodBeat.o(228972);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(com.tencent.mm.plugin.appbrand.d r8, com.tencent.mm.plugin.appbrand.permission.a.b.c r9) {
        /*
        // Method dump skipped, instructions count: 491
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.b.<init>(com.tencent.mm.plugin.appbrand.d, com.tencent.mm.plugin.appbrand.permission.a.b$c):void");
    }

    public final b.c getListener() {
        return this.nbO;
    }

    public final void setListener(b.c cVar) {
        this.nbO = cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final MotionEvent getLastPointerDownTouchEvent() {
        return this.nbP;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(228940);
        if (motionEvent != null && motionEvent.getAction() == 0) {
            this.nbP = MotionEvent.obtain(motionEvent);
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(228940);
        return dispatchTouchEvent;
    }

    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        KeyEvent.DispatcherState keyDispatcherState;
        AppMethodBeat.i(228941);
        if (u.aD(this) && keyEvent != null && 4 == keyEvent.getKeyCode() && (keyDispatcherState = getKeyDispatcherState()) != null) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState.startTracking(keyEvent, this);
                AppMethodBeat.o(228941);
                return true;
            } else if (1 == keyEvent.getAction() && !keyEvent.isCanceled() && keyDispatcherState.isTracking(keyEvent)) {
                bON();
                AppMethodBeat.o(228941);
                return true;
            }
        }
        boolean dispatchKeyEventPreIme = super.dispatchKeyEventPreIme(keyEvent);
        AppMethodBeat.o(228941);
        return dispatchKeyEventPreIme;
    }

    private final void bON() {
        AppMethodBeat.i(228942);
        b.c cVar = this.nbO;
        if (cVar != null) {
            b.c.a.a(cVar, 3, new ArrayList());
        }
        com.tencent.mm.plugin.appbrand.d dVar = this.nbZ;
        if (dVar == null) {
            p.btv("component");
        }
        i(dVar);
        AppMethodBeat.o(228942);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ b ncb;

        f(b bVar) {
            this.ncb = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(228937);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b.a(this.ncb);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(228937);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$3$1"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ b ncb;

        d(b bVar) {
            this.ncb = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(228935);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ArrayList a2 = b.a(this.ncb, false);
            b.c listener = this.ncb.getListener();
            if (listener != null) {
                b.c.a.a(listener, 2, a2);
            }
            this.ncb.i(b.b(this.ncb));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(228935);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$4$1"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ b ncb;

        e(b bVar) {
            this.ncb = bVar;
        }

        public final void onClick(View view) {
            int i2;
            AppMethodBeat.i(228936);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ArrayList<String> a2 = b.a(this.ncb, true);
            b.c listener = this.ncb.getListener();
            if (listener != null) {
                i.a c2 = b.c(this.ncb);
                if (c2 != null) {
                    i2 = c2.lGW;
                } else {
                    i2 = 0;
                }
                listener.a(1, a2, i2);
            }
            this.ncb.i(b.b(this.ncb));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPageJsAuthorizePresenterUIView$onCreateView$$inlined$also$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(228936);
        }
    }

    private final void bOO() {
        AppMethodBeat.i(228943);
        RelativeLayout relativeLayout = this.nbN;
        if (relativeLayout == null) {
            p.btv("requestContainer");
        }
        RelativeLayout relativeLayout2 = relativeLayout;
        relativeLayout2.getViewTreeObserver().addOnPreDrawListener(new a(relativeLayout2, this));
        AppMethodBeat.o(228943);
    }

    public final void dispatchConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(228944);
        super.dispatchConfigurationChanged(configuration);
        RelativeLayout relativeLayout = this.nbN;
        if (relativeLayout == null) {
            p.btv("requestContainer");
        }
        relativeLayout.addOnLayoutChangeListener(new c(this));
        AppMethodBeat.o(228944);
    }

    public final String getAppBrandName() {
        return this.lJe;
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setAppBrandName(String str) {
        AppMethodBeat.i(228945);
        this.lJe = str;
        TextView textView = this.jVh;
        if (textView == null) {
            p.btv("mNameTv");
        }
        textView.setText(str);
        AppMethodBeat.o(228945);
    }

    public final String getRequestDesc() {
        return this.nbQ;
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setRequestDesc(String str) {
        AppMethodBeat.i(228946);
        this.nbQ = str;
        TextView textView = this.jVn;
        if (textView == null) {
            p.btv("mDescTv");
        }
        textView.setText(str);
        AppMethodBeat.o(228946);
    }

    public final String getSimpleDetailDesc() {
        return this.nbS;
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setSimpleDetailDesc(String str) {
        boolean z;
        AppMethodBeat.i(228947);
        this.nbS = str;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            TextView textView = this.nbR;
            if (textView == null) {
                p.btv("mSimpleDetailDescTv");
            }
            textView.setText(str);
            TextView textView2 = this.nbR;
            if (textView2 == null) {
                p.btv("mSimpleDetailDescTv");
            }
            textView2.setVisibility(0);
        }
        AppMethodBeat.o(228947);
    }

    public final String getApplyWording() {
        return this.nbU;
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setApplyWording(String str) {
        AppMethodBeat.i(228948);
        this.nbU = str;
        TextView textView = this.nbT;
        if (textView == null) {
            p.btv("mApplyWordingTv");
        }
        textView.setText(str);
        AppMethodBeat.o(228948);
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setIconUrl(String str) {
        AppMethodBeat.i(228949);
        this.iconUrl = str;
        com.tencent.mm.modelappbrand.a.b aXY = com.tencent.mm.modelappbrand.a.b.aXY();
        ImageView imageView = this.lIM;
        if (imageView == null) {
            p.btv("mIconIv");
        }
        aXY.a(imageView, getIconUrl(), R.drawable.cg_, com.tencent.mm.modelappbrand.a.g.iJB);
        AppMethodBeat.o(228949);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setScope(String str) {
        AppMethodBeat.i(228950);
        p.h(str, "scope");
        this.lGX = str;
        AppMethodBeat.o(228950);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setSelectListItem(List<i.a> list) {
        AppMethodBeat.i(228951);
        if (list == null) {
            AppMethodBeat.o(228951);
        } else if (list.isEmpty()) {
            AppMethodBeat.o(228951);
        } else {
            this.cvc.clear();
            this.cvc.addAll(list);
            i iVar = this.nbW;
            if (iVar == null) {
                p.btv("mAdapter");
            }
            iVar.notifyDataSetChanged();
            LinearLayout linearLayout = this.nbV;
            if (linearLayout == null) {
                p.btv("mSelectListLayout");
            }
            linearLayout.setVisibility(0);
            TextView textView = this.nbR;
            if (textView == null) {
                p.btv("mSimpleDetailDescTv");
            }
            textView.setVisibility(8);
            View view = this.hSw;
            if (view == null) {
                p.btv("loadingView");
            }
            view.setVisibility(8);
            AppMethodBeat.o(228951);
        }
    }

    public final i.b getItemCheckedListener() {
        return this.nbX;
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setItemCheckedListener(i.b bVar) {
        AppMethodBeat.i(228952);
        this.nbX = bVar;
        i iVar = this.nbW;
        if (iVar == null) {
            p.btv("mAdapter");
        }
        iVar.nbX = bVar;
        AppMethodBeat.o(228952);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setOnListItemLongClickListener(i.d dVar) {
        AppMethodBeat.i(228953);
        p.h(dVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        i iVar = this.nbW;
        if (iVar == null) {
            p.btv("mAdapter");
        }
        iVar.oqX = dVar;
        AppMethodBeat.o(228953);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void ia(boolean z) {
        AppMethodBeat.i(228954);
        ImageView imageView = this.lIO;
        if (imageView == null) {
            p.btv("mExplainIv");
        }
        imageView.setVisibility(z ? 0 : 8);
        ImageView imageView2 = this.lIO;
        if (imageView2 == null) {
            p.btv("mExplainIv");
        }
        imageView2.setImageDrawable(android.support.v4.content.b.l(getContext(), R.drawable.bxy));
        AppMethodBeat.o(228954);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setExplainOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(228955);
        ImageView imageView = this.lIO;
        if (imageView == null) {
            p.btv("mExplainIv");
        }
        imageView.setOnClickListener(onClickListener);
        AppMethodBeat.o(228955);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setFunctionButtonText(String str) {
        AppMethodBeat.i(228956);
        if (TextUtils.isEmpty(str)) {
            TextView textView = this.nbY;
            if (textView == null) {
                p.btv("funcTv");
            }
            textView.setText("");
            TextView textView2 = this.nbY;
            if (textView2 == null) {
                p.btv("funcTv");
            }
            textView2.setVisibility(4);
            AppMethodBeat.o(228956);
            return;
        }
        TextView textView3 = this.nbY;
        if (textView3 == null) {
            p.btv("funcTv");
        }
        textView3.setText(str);
        TextView textView4 = this.nbY;
        if (textView4 == null) {
            p.btv("funcTv");
        }
        textView4.setVisibility(0);
        AppMethodBeat.o(228956);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setFunctionButtonVisibility(int i2) {
        AppMethodBeat.i(228957);
        TextView textView = this.nbY;
        if (textView == null) {
            p.btv("funcTv");
        }
        textView.setVisibility(i2);
        AppMethodBeat.o(228957);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setFunctionButtonTextColor(int i2) {
        AppMethodBeat.i(228958);
        TextView textView = this.nbY;
        if (textView == null) {
            p.btv("funcTv");
        }
        textView.setTextColor(i2);
        AppMethodBeat.o(228958);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setFunctionButtonOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(228959);
        TextView textView = this.nbY;
        if (textView == null) {
            p.btv("funcTv");
        }
        textView.setOnClickListener(onClickListener);
        AppMethodBeat.o(228959);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setNegativeButtonText(String str) {
        AppMethodBeat.i(228960);
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            Button button = this.lJb;
            if (button == null) {
                p.btv("mBtnReject");
            }
            button.setText(str);
        }
        AppMethodBeat.o(228960);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.a.b
    public final void setPositiveButtonText(String str) {
        AppMethodBeat.i(228961);
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            Button button = this.lJa;
            if (button == null) {
                p.btv("mBtnAccept");
            }
            button.setText(str);
        }
        AppMethodBeat.o(228961);
    }

    private final i.a getSelectedItem() {
        AppMethodBeat.i(228962);
        i iVar = this.nbW;
        if (iVar == null) {
            p.btv("mAdapter");
        }
        for (i.a aVar : iVar.iHf) {
            if (aVar != null && aVar.jCx) {
                AppMethodBeat.o(228962);
                return aVar;
            }
        }
        AppMethodBeat.o(228962);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.f
    public final void h(com.tencent.mm.plugin.appbrand.d dVar) {
        ViewGroup viewGroup;
        AppMethodBeat.i(228963);
        p.h(dVar, "component");
        this.nbZ = dVar;
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
        b bVar = this;
        bVar.getViewTreeObserver().addOnPreDrawListener(new g(bVar, dVar));
        S(this.nbL, !ao.isDarkMode());
        setBackgroundColor(this.nbL);
        com.tencent.mm.plugin.appbrand.d dVar2 = this.nbZ;
        if (dVar2 == null) {
            p.btv("component");
        }
        Context context2 = dVar2.getContext();
        if (!(context2 instanceof AppBrandUI)) {
            context2 = null;
        }
        AppBrandUI appBrandUI = (AppBrandUI) context2;
        if (appBrandUI != null) {
            appBrandUI.setNavigationbarColor(this.nbL);
            AppMethodBeat.o(228963);
            return;
        }
        AppMethodBeat.o(228963);
    }

    public final void i(com.tencent.mm.plugin.appbrand.d dVar) {
        AppMethodBeat.i(228964);
        p.h(dVar, "component");
        animate().cancel();
        animate().translationY((float) getMeasuredHeight()).setDuration(300).withEndAction(new RunnableC0747b(this)).start();
        AppMethodBeat.o(228964);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.b$b  reason: collision with other inner class name */
    public static final class RunnableC0747b implements Runnable {
        final /* synthetic */ b ncb;

        RunnableC0747b(b bVar) {
            this.ncb = bVar;
        }

        public final void run() {
            AppMethodBeat.i(228933);
            a.cw(this.ncb);
            AppMethodBeat.o(228933);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.h
    public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.d dVar, String str, ag agVar) {
        AppMethodBeat.i(228965);
        p.h(dVar, "component");
        Context context = dVar.getContext();
        p.g(context, "component.context");
        d dVar2 = new d(context);
        dVar2.setExplainContent(str);
        d dVar3 = dVar2;
        AppMethodBeat.o(228965);
        return dVar3;
    }

    public static final /* synthetic */ ArrayList a(b bVar, boolean z) {
        String str;
        AppMethodBeat.i(228968);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(bVar.lGX)) {
            arrayList.add(bVar.lGX);
            AppMethodBeat.o(228968);
            return arrayList;
        }
        i iVar = bVar.nbW;
        if (iVar == null) {
            p.btv("mAdapter");
        }
        List<i.a> list = iVar.iHf;
        if (list.size() == 1) {
            i.a aVar = list.get(0);
            if (!(aVar == null || (str = aVar.scope) == null)) {
                arrayList.add(str);
            }
            AppMethodBeat.o(228968);
            return arrayList;
        }
        for (T t : list) {
            if (!(t == null || t.jCx != z || t.scope == null)) {
                String str2 = t.scope;
                if (str2 == null) {
                    p.hyc();
                }
                arrayList.add(str2);
            }
        }
        AppMethodBeat.o(228968);
        return arrayList;
    }
}
