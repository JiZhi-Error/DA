package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B*\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001b\u0010\u0005\u001a\u0017\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bJ\b\u00103\u001a\u00020\bH\u0016J\b\u00104\u001a\u00020\bH\u0016J\b\u00105\u001a\u00020\bH\u0016J\b\u00106\u001a\u00020\bH\u0016R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001aR\u0014\u0010&\u001a\u00020'8BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R(\u0010+\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\r@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u00020\u0019*\u0004\u0018\u00010\r8BX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialBottomSheet;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "contentViewConfigureAction", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialWebView;", "", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridContentViewConfigureAction;", "Lkotlin/ExtensionFunctionType;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "anchorView", "Landroid/view/View;", "getAnchorView", "()Landroid/view/View;", "anchorView$delegate", "Lkotlin/Lazy;", "containerDialog", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialDialog;", "dialog", "Landroid/app/Dialog;", "getDialog", "()Landroid/app/Dialog;", "isLandscape", "", "()Z", "isLandscapeWhenShow", "isShowing", "value", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;)V", "rotatedFromShow", "getRotatedFromShow", "rotation", "", "getRotation", "()I", "rotationWhenShow", "titleView", "getTitleView", "setTitleView", "(Landroid/view/View;)V", "treeObserver", "Landroid/view/ViewTreeObserver;", "isHide", "(Landroid/view/View;)Z", "dead", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "onGlobalLayout", "show", "plugin-appbrand-integration_release"})
public final class a implements ViewTreeObserver.OnGlobalLayoutListener, com.tencent.mm.plugin.appbrand.openmaterial.ui.a {
    private final Context context;
    private View nmd;
    public a.AbstractC0763a nme;
    public final b nmf = new b(this.context);
    private final f nmg = g.a(k.NONE, new C0764a(this));
    private ViewTreeObserver nmh;
    private boolean nmi;
    private int nmj;

    private final View getAnchorView() {
        AppMethodBeat.i(229207);
        View view = (View) this.nmg.getValue();
        AppMethodBeat.o(229207);
        return view;
    }

    public a(Context context2, b<? super OpenMaterialWebView, x> bVar) {
        p.h(context2, "context");
        p.h(bVar, "contentViewConfigureAction");
        AppMethodBeat.i(229214);
        this.context = context2;
        HybridOpenMaterialView hybridOpenMaterialView = this.nmf.nml;
        OpenMaterialWebView openMaterialWebView = new OpenMaterialWebView(this.context);
        bVar.invoke(openMaterialWebView);
        hybridOpenMaterialView.setContentView(openMaterialWebView);
        this.nmf.setOnDismissListener(new DialogInterface.OnDismissListener(this) {
            /* class com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a.AnonymousClass1 */
            final /* synthetic */ a nmk;

            {
                this.nmk = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                ViewTreeObserver viewTreeObserver;
                AppMethodBeat.i(229204);
                ViewTreeObserver viewTreeObserver2 = this.nmk.nmh;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        a aVar = this.nmk;
                        View c2 = a.c(this.nmk);
                        aVar.nmh = c2 != null ? c2.getViewTreeObserver() : null;
                        viewTreeObserver = this.nmk.nmh;
                    } else {
                        viewTreeObserver = viewTreeObserver2;
                    }
                    if (viewTreeObserver != null) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this.nmk);
                    }
                    this.nmk.nmh = null;
                }
                AppMethodBeat.o(229204);
            }
        });
        AppMethodBeat.o(229214);
    }

    public static final /* synthetic */ View c(a aVar) {
        AppMethodBeat.i(229215);
        View anchorView = aVar.getAnchorView();
        AppMethodBeat.o(229215);
        return anchorView;
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.ui.a
    public final Dialog getDialog() {
        return this.nmf;
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.ui.a
    public final void setTitleView(View view) {
        AppMethodBeat.i(229206);
        if (view != null) {
            this.nmf.nml.setTitleView(view);
        }
        this.nmd = view;
        AppMethodBeat.o(229206);
    }

    private final boolean isLandscape() {
        AppMethodBeat.i(229208);
        Resources resources = this.context.getResources();
        p.g(resources, "context.resources");
        if (2 == resources.getConfiguration().orientation) {
            AppMethodBeat.o(229208);
            return true;
        }
        AppMethodBeat.o(229208);
        return false;
    }

    private final int getRotation() {
        AppMethodBeat.i(229209);
        if (this.context instanceof Activity) {
            WindowManager windowManager = ((Activity) this.context).getWindowManager();
            p.g(windowManager, "context.windowManager");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            p.g(defaultDisplay, "context.windowManager.defaultDisplay");
            int rotation = defaultDisplay.getRotation();
            AppMethodBeat.o(229209);
            return rotation;
        }
        AppMethodBeat.o(229209);
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.ui.a
    public final void show() {
        ViewTreeObserver viewTreeObserver;
        AppMethodBeat.i(229210);
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "show");
        this.nmi = isLandscape();
        this.nmj = getRotation();
        View anchorView = getAnchorView();
        if (anchorView != null) {
            boolean z = this.nmh == null;
            this.nmh = anchorView.getViewTreeObserver();
            if (z && (viewTreeObserver = this.nmh) != null) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
            }
        }
        if ((this.context instanceof Activity) && !((Activity) this.context).isFinishing()) {
            ((Activity) this.context).isDestroyed();
        }
        this.nmf.show();
        AppMethodBeat.o(229210);
    }

    @Override // com.tencent.mm.plugin.appbrand.openmaterial.ui.a
    public final void hide() {
        AppMethodBeat.i(229211);
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", MessengerShareContentUtility.SHARE_BUTTON_HIDE);
        if ((this.context instanceof Activity) && !((Activity) this.context).isFinishing()) {
            ((Activity) this.context).isDestroyed();
        }
        this.nmf.dismiss();
        AppMethodBeat.o(229211);
    }

    @Override // com.tencent.mm.vending.e.a
    public final void dead() {
        AppMethodBeat.i(229212);
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "dead");
        this.nmf.nml.dead();
        AppMethodBeat.o(229212);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
        if (r0 != false) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onGlobalLayout() {
        /*
            r7 = this;
            r6 = 229213(0x37f5d, float:3.21196E-40)
            r1 = 1
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            java.lang.String r2 = "MicroMsg.AppBrand.HybridOpenMaterialBottomSheet"
            java.lang.String r3 = "onGlobalLayout"
            com.tencent.mm.sdk.platformtools.Log.d(r2, r3)
            com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.b r2 = r7.nmf
            boolean r2 = r2.isShowing()
            java.lang.String r3 = "MicroMsg.AppBrand.HybridOpenMaterialBottomSheet"
            java.lang.String r4 = "isShowing, "
            java.lang.String r5 = java.lang.String.valueOf(r2)
            java.lang.String r4 = r4.concat(r5)
            com.tencent.mm.sdk.platformtools.Log.d(r3, r4)
            if (r2 == 0) goto L_0x0055
            android.view.View r2 = r7.getAnchorView()
            if (r2 == 0) goto L_0x003c
            boolean r3 = r2.isShown()
            if (r3 != 0) goto L_0x0059
            int r2 = r2.getVisibility()
            if (r2 == 0) goto L_0x0059
        L_0x003c:
            r2 = r1
        L_0x003d:
            if (r2 != 0) goto L_0x0052
            boolean r2 = r7.nmi
            boolean r3 = r7.isLandscape()
            if (r2 != r3) goto L_0x004f
            int r2 = r7.nmj
            int r3 = r7.getRotation()
            if (r2 == r3) goto L_0x0050
        L_0x004f:
            r0 = r1
        L_0x0050:
            if (r0 == 0) goto L_0x0055
        L_0x0052:
            r7.hide()
        L_0x0055:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x0059:
            r2 = r0
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a.onGlobalLayout():void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/View;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a$a  reason: collision with other inner class name */
    static final class C0764a extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ a nmk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0764a(a aVar) {
            super(0);
            this.nmk = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            View view;
            AppMethodBeat.i(229205);
            if (this.nmk.context instanceof Activity) {
                Window window = ((Activity) this.nmk.context).getWindow();
                p.g(window, "context.window");
                view = window.getDecorView().findViewById(16908290);
                if (view == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.View");
                    AppMethodBeat.o(229205);
                    throw tVar;
                }
            } else {
                view = null;
            }
            AppMethodBeat.o(229205);
            return view;
        }
    }
}
