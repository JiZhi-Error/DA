package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.support.v4.view.u;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.luggage.sdk.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u000245B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0018J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012H\u0002J\u0016\u0010$\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012J\u000e\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u0018J\u0006\u0010,\u001a\u00020\u0018J\u0010\u0010-\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010/J\u0014\u00100\u001a\u000201*\u0002022\u0006\u00103\u001a\u00020\u0016H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00060\u0014R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u00066"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "blinkHelperExport", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;", "getBlinkHelperExport$luggage_wxa_app_release", "()Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;", "setBlinkHelperExport$luggage_wxa_app_release", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarBlinkHelper;)V", "blinkWrapper", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper;", "capsuleBarContainerLayout", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarContainerLayout;", "capsuleBarView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarImplView;", "currentActivePage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "pageContexts", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContextMapImpl;", "savedCapsuleBarContainerLayoutVisibility", "", "applyFixedWidthToPlaceHolderView", "", "placeHolderView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarPlaceHolderView;", "destroy", "getOptionButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "hideCapsuleBar", "installCapsuleBar", "onEnterFullscreen", "onExitFullscreen", "onPageDestroyed", "page", "onPageSwitchedIn", "type", "Lcom/tencent/mm/plugin/appbrand/page/PageOpenType;", "registerPage", "resetCapsuleBarContext", "newBase", "Landroid/content/Context;", "restoreCapsureBarVisibility", "saveCapsuleBarVisibility", "setCapsuleHomeButtonLongClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnLongClickListener;", "toFrameLayout_LayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "Landroid/view/ViewGroup$LayoutParams;", "gravity", "PageContext", "PageContextMapImpl", "luggage-wxa-app_release"})
public final class e {
    public final AppBrandRuntime kGM;
    public c nvh;
    public d nvi;
    public int nvj;
    public h nvk;
    public a nvl;
    public final b nvm = new b();
    ac nvn;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, hxF = {"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke", "com/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$installCapsuleBar$1$1"})
    public static final class c extends q implements kotlin.g.a.b<d, x> {
        final /* synthetic */ e nvr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(e eVar) {
            super(1);
            this.nvr = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(d dVar) {
            AppMethodBeat.i(219710);
            d dVar2 = dVar;
            p.h(dVar2, "$receiver");
            dVar2.b(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.appbrand.page.capsulebar.e.c.AnonymousClass1 */
                final /* synthetic */ c nvu;

                {
                    this.nvu = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(219708);
                    e.d(this.nvu.nvr).bSA();
                    x xVar = x.SXb;
                    AppMethodBeat.o(219708);
                    return xVar;
                }
            });
            dVar2.a(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.appbrand.page.capsulebar.e.c.AnonymousClass2 */
                final /* synthetic */ c nvu;

                {
                    this.nvu = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(219709);
                    e.d(this.nvu.nvr).bSz();
                    x xVar = x.SXb;
                    AppMethodBeat.o(219709);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(219710);
            return xVar;
        }
    }

    public e(AppBrandRuntime appBrandRuntime) {
        p.h(appBrandRuntime, "runtime");
        AppMethodBeat.i(219714);
        this.kGM = appBrandRuntime;
        AppMethodBeat.o(219714);
    }

    public static final /* synthetic */ d a(e eVar) {
        AppMethodBeat.i(219715);
        d dVar = eVar.nvi;
        if (dVar == null) {
            p.btv("capsuleBarView");
        }
        AppMethodBeat.o(219715);
        return dVar;
    }

    public static final /* synthetic */ h d(e eVar) {
        AppMethodBeat.i(219719);
        h hVar = eVar.nvk;
        if (hVar == null) {
            p.btv("blinkWrapper");
        }
        AppMethodBeat.o(219719);
        return hVar;
    }

    public final void ek(Context context) {
        AppMethodBeat.i(219711);
        p.h(context, "newBase");
        c cVar = this.nvh;
        if (cVar == null) {
            p.btv("capsuleBarContainerLayout");
        }
        cVar.aG(context);
        AppMethodBeat.o(219711);
    }

    public final AppBrandOptionButton btD() {
        AppMethodBeat.i(219712);
        d dVar = this.nvi;
        if (dVar == null) {
            p.btv("capsuleBarView");
        }
        AppBrandOptionButton optionBtn = dVar.getOptionBtn();
        p.g(optionBtn, "capsuleBarView.optionBtn");
        AppMethodBeat.o(219712);
        return optionBtn;
    }

    public final void a(ac acVar, bx bxVar) {
        AppMethodBeat.i(219713);
        p.h(acVar, "page");
        p.h(bxVar, "type");
        if (this.nvn != null) {
            b bVar = this.nvm;
            ac acVar2 = this.nvn;
            if (acVar2 == null) {
                p.hyc();
            }
            a w = bVar.w(acVar2);
            if (w != null) {
                w.onDetached();
            }
        }
        this.nvn = acVar;
        this.nvm.x(acVar).bSx();
        AppMethodBeat.o(219713);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0006\u0010\u0014\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\u0011J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016JR\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000fH\u0016J\u0012\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010%\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u000fH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContext;", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$CapsuleBarInteractionDelegate;", "Landroid/view/View$OnLayoutChangeListener;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "homeButtonOnClickListener", "Landroid/view/View$OnClickListener;", "isAttached", "", "optionButtonOnClickListener", "getPage", "()Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "styleColor", "", "adjustCapsuleBarViewProperties", "", "dispatchCapsuleViewVisibilityChanged", "visibility", "onAttached", "onDetached", "onEnterFullscreen", "onExitFullscreen", "onLayoutChange", "v", "Landroid/view/View;", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "setHomeButtonOnClickListener", "l", "setOptionButtonOnClickListener", "setStyleColor", "color", "luggage-wxa-app_release"})
    public final class a extends com.tencent.mm.plugin.appbrand.platform.window.b implements View.OnLayoutChangeListener, b.AbstractC0818b {
        final ac cxr;
        private boolean iuM;
        private int nvo = -1;
        private View.OnClickListener nvp;
        private View.OnClickListener nvq;
        final /* synthetic */ e nvr;

        public a(e eVar, ac acVar) {
            p.h(acVar, "page");
            this.nvr = eVar;
            AppMethodBeat.i(219703);
            this.cxr = acVar;
            this.cxr.a(new i.c(this) {
                /* class com.tencent.mm.plugin.appbrand.page.capsulebar.e.a.AnonymousClass1 */
                final /* synthetic */ a nvs;

                {
                    this.nvs = r1;
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
                public final void onDestroy() {
                    a aVar = null;
                    AppMethodBeat.i(219692);
                    e eVar = this.nvs.nvr;
                    ac acVar = this.nvs.cxr;
                    if (p.j(acVar, eVar.nvn)) {
                        eVar.nvn = null;
                    }
                    b bVar = eVar.nvm;
                    p.h(acVar, "page");
                    int indexOfKey = bVar.nvt.indexOfKey(acVar.hashCode());
                    if (indexOfKey >= 0) {
                        aVar = bVar.nvt.valueAt(indexOfKey);
                        bVar.nvt.removeAt(indexOfKey);
                    }
                    if (aVar != null) {
                        aVar.onDetached();
                        AppMethodBeat.o(219692);
                        return;
                    }
                    AppMethodBeat.o(219692);
                }
            });
            this.cxr.bRi().setCapsuleBarInteractionDelegate(this);
            AppMethodBeat.o(219703);
        }

        public final void bSx() {
            AppMethodBeat.i(219693);
            this.iuM = true;
            com.tencent.mm.plugin.appbrand.platform.window.d fullscreenImpl = this.cxr.getFullscreenImpl();
            if (fullscreenImpl == null || !fullscreenImpl.bTK()) {
                e.c(this.nvr);
            } else {
                e.b(this.nvr);
            }
            com.tencent.mm.plugin.appbrand.platform.window.d fullscreenImpl2 = this.cxr.getFullscreenImpl();
            if (fullscreenImpl2 != null) {
                fullscreenImpl2.a(this);
            }
            e.a(this.nvr).addOnLayoutChangeListener(this);
            com.tencent.mm.plugin.appbrand.widget.actionbar.b bRi = this.cxr.bRi();
            p.g(bRi, "page.actionBar");
            AppBrandCapsuleBarPlaceHolderView capsuleView = bRi.getCapsuleView();
            ViewParent parent = capsuleView != null ? capsuleView.getParent() : null;
            if (!(parent instanceof View)) {
                parent = null;
            }
            View view = (View) parent;
            if (view != null) {
                view.addOnLayoutChangeListener(this);
            }
            this.cxr.bRi().addOnLayoutChangeListener(this);
            setHomeButtonOnClickListener(this.nvp);
            setOptionButtonOnClickListener(this.nvq);
            setStyleColor(this.nvo);
            bSy();
            AppMethodBeat.o(219693);
        }

        public final void onDetached() {
            ViewParent viewParent;
            AppMethodBeat.i(219694);
            this.iuM = false;
            com.tencent.mm.plugin.appbrand.platform.window.d fullscreenImpl = this.cxr.getFullscreenImpl();
            if (fullscreenImpl != null) {
                fullscreenImpl.b(this);
            }
            e.a(this.nvr).removeOnLayoutChangeListener(this);
            com.tencent.mm.plugin.appbrand.widget.actionbar.b bRi = this.cxr.bRi();
            p.g(bRi, "page.actionBar");
            AppBrandCapsuleBarPlaceHolderView capsuleView = bRi.getCapsuleView();
            if (capsuleView != null) {
                viewParent = capsuleView.getParent();
            } else {
                viewParent = null;
            }
            if (!(viewParent instanceof View)) {
                viewParent = null;
            }
            View view = (View) viewParent;
            if (view != null) {
                view.removeOnLayoutChangeListener(this);
            }
            this.cxr.bRi().removeOnLayoutChangeListener(this);
            AppMethodBeat.o(219694);
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.b
        public final void bDq() {
            AppMethodBeat.i(259541);
            e.b(this.nvr);
            AppMethodBeat.o(259541);
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.b
        public final void Na() {
            AppMethodBeat.i(259542);
            e.c(this.nvr);
            AppMethodBeat.o(259542);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.AbstractC0818b
        public final void setStyleColor(int i2) {
            AppMethodBeat.i(219697);
            this.nvo = i2;
            if (this.iuM) {
                e.a(this.nvr).setStyleColor(this.nvo);
            }
            AppMethodBeat.o(219697);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.AbstractC0818b
        public final void setHomeButtonOnClickListener(View.OnClickListener onClickListener) {
            AppMethodBeat.i(219698);
            this.nvp = onClickListener;
            if (this.iuM) {
                e.a(this.nvr).setHomeButtonOnClickListener(this.nvp);
            }
            AppMethodBeat.o(219698);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.AbstractC0818b
        public final void setOptionButtonOnClickListener(View.OnClickListener onClickListener) {
            AppMethodBeat.i(219699);
            this.nvq = onClickListener;
            if (this.iuM) {
                e.a(this.nvr).setOptionButtonOnClickListener(this.nvq);
            }
            AppMethodBeat.o(219699);
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            AppMethodBeat.i(219700);
            if (this.iuM && !(i2 == i6 && i3 == i7 && i4 == i8 && i5 == i9)) {
                bSy();
            }
            AppMethodBeat.o(219700);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.b.AbstractC0818b
        public final void vI(int i2) {
            AppMethodBeat.i(219701);
            bSy();
            AppMethodBeat.o(219701);
        }

        private final void bSy() {
            ViewGroup.LayoutParams layoutParams;
            AppMethodBeat.i(219702);
            d a2 = e.a(this.nvr);
            View capsuleContentAreaView = a2.getCapsuleContentAreaView();
            p.g(capsuleContentAreaView, "capsuleBarImplView.capsuleContentAreaView");
            if (capsuleContentAreaView.isLaidOut()) {
                com.tencent.mm.plugin.appbrand.widget.actionbar.b bRi = this.cxr.bRi();
                p.g(bRi, "page.actionBar");
                AppBrandCapsuleBarPlaceHolderView capsuleView = bRi.getCapsuleView();
                if (capsuleView != null) {
                    View capsuleContentAreaView2 = a2.getCapsuleContentAreaView();
                    p.g(capsuleContentAreaView2, "capsuleBarImplView.capsuleContentAreaView");
                    capsuleView.setFixedWidth(capsuleContentAreaView2.getMeasuredWidth());
                }
            }
            com.tencent.mm.plugin.appbrand.widget.actionbar.b bRi2 = this.cxr.bRi();
            p.g(bRi2, "page.actionBar");
            AppBrandCapsuleBarPlaceHolderView capsuleView2 = bRi2.getCapsuleView();
            if (!(capsuleView2 == null || (layoutParams = capsuleView2.getLayoutParams()) == null)) {
                View capsuleContentAreaView3 = a2.getCapsuleContentAreaView();
                p.g(capsuleContentAreaView3, "capsuleBarImplView.capsuleContentAreaView");
                FrameLayout.LayoutParams e2 = e.e(layoutParams);
                e2.width = -2;
                capsuleContentAreaView3.setLayoutParams(e2);
            }
            ViewGroup.LayoutParams layoutParams2 = a2.getLayoutParams();
            if (layoutParams2 != null) {
                int i2 = layoutParams2.height;
                com.tencent.mm.plugin.appbrand.widget.actionbar.b bRi3 = this.cxr.bRi();
                p.g(bRi3, "page.actionBar");
                if (i2 != bRi3.getMeasuredHeight() && u.az(this.cxr.bRi())) {
                    com.tencent.mm.plugin.appbrand.widget.actionbar.b bRi4 = this.cxr.bRi();
                    p.g(bRi4, "page.actionBar");
                    layoutParams2.height = bRi4.getMeasuredHeight();
                    a2.requestLayout();
                }
            }
            com.tencent.mm.plugin.appbrand.widget.actionbar.b bRi5 = this.cxr.bRi();
            p.g(bRi5, "page.actionBar");
            AppBrandCapsuleBarPlaceHolderView capsuleView3 = bRi5.getCapsuleView();
            if (capsuleView3 != null) {
                int visibility = capsuleView3.getVisibility();
                if (a2.getVisibility() != visibility) {
                    a2.setVisibility(visibility);
                }
                AppMethodBeat.o(219702);
                return;
            }
            AppMethodBeat.o(219702);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\b\u0018\u00010\u0005R\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u00060\u0005R\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\u000b\u001a\b\u0018\u00010\u0005R\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\n\u0010\u000e\u001a\u00060\u0005R\u00020\u0006H\u0002R\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u00060\u0005R\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContextMapImpl;", "", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;)V", "sparseArray", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContext;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;", "get", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "getOrCreate", "remove", "set", "", "context", "luggage-wxa-app_release"})
    public final class b {
        final SparseArray<a> nvt = new SparseArray<>();

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            AppMethodBeat.i(219707);
            AppMethodBeat.o(219707);
        }

        public final void a(ac acVar, a aVar) {
            AppMethodBeat.i(219704);
            p.h(acVar, "page");
            p.h(aVar, "context");
            this.nvt.put(acVar.hashCode(), aVar);
            AppMethodBeat.o(219704);
        }

        public final a w(ac acVar) {
            AppMethodBeat.i(219705);
            p.h(acVar, "page");
            a aVar = this.nvt.get(acVar.hashCode(), null);
            AppMethodBeat.o(219705);
            return aVar;
        }

        public final a x(ac acVar) {
            AppMethodBeat.i(219706);
            p.h(acVar, "page");
            a aVar = this.nvt.get(acVar.hashCode(), null);
            if (aVar == null) {
                aVar = new a(e.this, acVar);
                a(acVar, aVar);
            }
            AppMethodBeat.o(219706);
            return aVar;
        }
    }

    public static final /* synthetic */ void b(e eVar) {
        AppMethodBeat.i(219716);
        h hVar = eVar.nvk;
        if (hVar == null) {
            p.btv("blinkWrapper");
        }
        hVar.bSA();
        c cVar = eVar.nvh;
        if (cVar == null) {
            p.btv("capsuleBarContainerLayout");
        }
        cVar.setVisibility(4);
        AppMethodBeat.o(219716);
    }

    public static final /* synthetic */ void c(e eVar) {
        AppMethodBeat.i(219717);
        h hVar = eVar.nvk;
        if (hVar == null) {
            p.btv("blinkWrapper");
        }
        hVar.bSz();
        c cVar = eVar.nvh;
        if (cVar == null) {
            p.btv("capsuleBarContainerLayout");
        }
        cVar.setVisibility(0);
        AppMethodBeat.o(219717);
    }

    public static final /* synthetic */ FrameLayout.LayoutParams e(ViewGroup.LayoutParams layoutParams) {
        FrameLayout.LayoutParams layoutParams2;
        AppMethodBeat.i(219718);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(219718);
                throw tVar;
            }
            layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        } else if (layoutParams == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            AppMethodBeat.o(219718);
            throw tVar2;
        } else {
            layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        }
        layoutParams2.gravity = 21;
        AppMethodBeat.o(219718);
        return layoutParams2;
    }
}
