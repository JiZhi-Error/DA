package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.luggage.d.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitask.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 02\u00020\u0001:\u00010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u0018H\u0016J\u0012\u0010,\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u0018H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000eR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "page", "Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;", "(Lcom/tencent/mm/plugin/webview/luggage/LuggageMMWebPage;)V", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "indicatorBottomMargin", "", "getIndicatorBottomMargin", "()I", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "isSupportSwipeToMultiTask", "", "()Z", "mIntent", "mPage", "maskView", "getMaskView", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "convertToTranslucent", "", "translucentCallback", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$TranslucentCallback;", "finish", "withAnimation", "helper", "Lcom/tencent/mm/plugin/multitask/helper/IMultiTaskHelper;", "setSwipeBackEnable", "enable", "setSwipeBackListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter$IMultiTaskSwipeBackListener;", "useActivityEnv", "Companion", "plugin-webview_release"})
public final class u extends com.tencent.mm.plugin.multitask.a.b {
    public static final a IVf = new a((byte) 0);
    private static final String TAG = TAG;
    private final g ISU;
    private Activity activity;
    private final Intent mIntent;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public u(com.tencent.mm.plugin.webview.luggage.g r4) {
        /*
            r3 = this;
            r2 = 210333(0x3359d, float:2.9474E-40)
            java.lang.String r0 = "page"
            kotlin.g.b.p.h(r4, r0)
            android.content.Context r0 = r4.getContext()
            if (r0 != 0) goto L_0x001b
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type android.app.Activity"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x001b:
            android.app.Activity r0 = (android.app.Activity) r0
            r3.<init>(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            r3.ISU = r4
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            r3.mIntent = r0
            android.content.Intent r0 = r3.mIntent
            com.tencent.mm.plugin.webview.luggage.g r1 = r3.ISU
            android.os.Bundle r1 = r1.getParams()
            r0.putExtras(r1)
            com.tencent.mm.plugin.webview.luggage.g r0 = r3.ISU
            android.content.Context r0 = r0.getContext()
            if (r0 != 0) goto L_0x004b
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type android.app.Activity"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x004b:
            android.app.Activity r0 = (android.app.Activity) r0
            r3.activity = r0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.luggage.u.<init>(com.tencent.mm.plugin.webview.luggage.g):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskPageAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(210334);
        AppMethodBeat.o(210334);
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final Activity getActivity() {
        return this.activity;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b
    public final void setActivity(Activity activity2) {
        this.activity = activity2;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final Intent getIntent() {
        return this.mIntent;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final ViewGroup chG() {
        Window window;
        AppMethodBeat.i(210324);
        if (gbx()) {
            Activity activity2 = this.activity;
            View decorView = (activity2 == null || (window = activity2.getWindow()) == null) ? null : window.getDecorView();
            if (decorView == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(210324);
                throw tVar;
            }
            ViewGroup viewGroup = (ViewGroup) decorView;
            AppMethodBeat.o(210324);
            return viewGroup;
        }
        View contentView = this.ISU.getContentView();
        p.g(contentView, "mPage.contentView");
        ViewParent parent = contentView.getParent();
        if (parent == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(210324);
            throw tVar2;
        }
        ViewGroup viewGroup2 = (ViewGroup) parent;
        AppMethodBeat.o(210324);
        return viewGroup2;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final View getContentView() {
        AppMethodBeat.i(210325);
        if (gbx()) {
            Activity activity2 = this.activity;
            if (activity2 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(210325);
                throw tVar;
            }
            SwipeBackLayout swipeBackLayout = ((MMActivity) activity2).getSwipeBackLayout();
            AppMethodBeat.o(210325);
            return swipeBackLayout;
        }
        View contentView = this.ISU.getContentView();
        if (contentView == null) {
            t tVar2 = new t("null cannot be cast to non-null type me.imid.swipebacklayout.lib.SwipeBackLayout");
            AppMethodBeat.o(210325);
            throw tVar2;
        }
        me.imid.swipebacklayout.lib.SwipeBackLayout swipeBackLayout2 = (me.imid.swipebacklayout.lib.SwipeBackLayout) contentView;
        AppMethodBeat.o(210325);
        return swipeBackLayout2;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final View getMaskView() {
        AppMethodBeat.i(210326);
        if (gbx()) {
            Activity activity2 = this.activity;
            if (activity2 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(210326);
                throw tVar;
            }
            SwipeBackLayout swipeBackLayout = ((MMActivity) activity2).getSwipeBackLayout();
            p.g(swipeBackLayout, "(activity as MMActivity).swipeBackLayout");
            View targetContentView = swipeBackLayout.getTargetContentView();
            AppMethodBeat.o(210326);
            return targetContentView;
        }
        View contentView = this.ISU.getContentView();
        if (contentView == null) {
            t tVar2 = new t("null cannot be cast to non-null type me.imid.swipebacklayout.lib.SwipeBackLayout");
            AppMethodBeat.o(210326);
            throw tVar2;
        }
        View targetView = ((me.imid.swipebacklayout.lib.SwipeBackLayout) contentView).getTargetView();
        AppMethodBeat.o(210326);
        return targetView;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final boolean bPp() {
        AppMethodBeat.i(210327);
        if (getContentView() != null) {
            AppMethodBeat.o(210327);
            return true;
        }
        AppMethodBeat.o(210327);
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final int chH() {
        AppMethodBeat.i(210328);
        if (gbx()) {
            AppMethodBeat.o(210328);
            return -1;
        }
        AppMethodBeat.o(210328);
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, hxF = {"com/tencent/mm/plugin/webview/luggage/LuggageWebViewMultiTaskPageAdapter$setSwipeBackListener$1", "Lme/imid/swipebacklayout/lib/SwipeBackLayout$SwipeListener;", "onDispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onEdgeTouch", "edgeFlag", "", "onScrollOverThreshold", "onScrollStateChange", "state", "scrollPercent", "", "onViewReleased", "willSwipeBack", "", "plugin-webview_release"})
    public static final class b implements SwipeBackLayout.a {
        final /* synthetic */ a.AbstractC1499a IVg;

        b(a.AbstractC1499a aVar) {
            this.IVg = aVar;
        }

        @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.a
        public final void i(int i2, float f2) {
            AppMethodBeat.i(210320);
            a.AbstractC1499a aVar = this.IVg;
            if (aVar != null) {
                aVar.aY(f2);
                AppMethodBeat.o(210320);
                return;
            }
            AppMethodBeat.o(210320);
        }

        @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.a
        public final void LN() {
            AppMethodBeat.i(210321);
            a.AbstractC1499a aVar = this.IVg;
            if (aVar != null) {
                aVar.RF(1);
                AppMethodBeat.o(210321);
                return;
            }
            AppMethodBeat.o(210321);
        }

        @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.a
        public final int bS(boolean z) {
            AppMethodBeat.i(210322);
            a aVar = u.IVf;
            Log.i(u.TAG, "onViewReleased, ".concat(String.valueOf(z)));
            if (this.IVg != null) {
                int jJ = this.IVg.jJ(z);
                AppMethodBeat.o(210322);
                return jJ;
            }
            AppMethodBeat.o(210322);
            return 1;
        }

        @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.a
        public final void n(MotionEvent motionEvent) {
            AppMethodBeat.i(210323);
            p.h(motionEvent, "ev");
            a.AbstractC1499a aVar = this.IVg;
            if (aVar != null) {
                aVar.n(motionEvent);
                AppMethodBeat.o(210323);
                return;
            }
            AppMethodBeat.o(210323);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(210330);
        if (gbx()) {
            super.a(bVar);
            AppMethodBeat.o(210330);
        } else if (bVar != null) {
            bVar.ei(true);
            AppMethodBeat.o(210330);
        } else {
            AppMethodBeat.o(210330);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final void a(boolean z, com.tencent.mm.plugin.multitask.b.b bVar) {
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        AppMethodBeat.i(210331);
        p.h(bVar, "helper");
        j Lg = this.ISU.Lg();
        p.g(Lg, "mPage.containerCtrl");
        if (!Lg.Ly().bR(false)) {
            if (z) {
                Activity activity2 = this.activity;
                if (!(activity2 == null || (intent4 = activity2.getIntent()) == null)) {
                    intent4.putExtra("MMActivity.OverrideExitAnimation", R.anim.di);
                }
                Activity activity3 = this.activity;
                if (!(activity3 == null || (intent3 = activity3.getIntent()) == null)) {
                    intent3.putExtra("MMActivity.OverrideEnterAnimation", R.anim.s);
                }
            } else {
                Activity activity4 = this.activity;
                if (!(activity4 == null || (intent2 = activity4.getIntent()) == null)) {
                    intent2.putExtra("MMActivity.OverrideExitAnimation", 0);
                }
                Activity activity5 = this.activity;
                if (!(activity5 == null || (intent = activity5.getIntent()) == null)) {
                    intent.putExtra("MMActivity.OverrideEnterAnimation", 0);
                }
            }
            Activity activity6 = this.activity;
            if (activity6 != null) {
                activity6.finish();
                AppMethodBeat.o(210331);
                return;
            }
        }
        AppMethodBeat.o(210331);
    }

    private final boolean gbx() {
        AppMethodBeat.i(210332);
        String str = TAG;
        StringBuilder sb = new StringBuilder("useActivityEnv: ");
        j Lg = this.ISU.Lg();
        p.g(Lg, "mPage.containerCtrl");
        Log.i(str, sb.append(Lg.Lx().size()).toString());
        j Lg2 = this.ISU.Lg();
        p.g(Lg2, "mPage.containerCtrl");
        if (Lg2.Lx().size() <= 1) {
            AppMethodBeat.o(210332);
            return true;
        }
        AppMethodBeat.o(210332);
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final void a(a.AbstractC1499a aVar) {
        AppMethodBeat.i(210329);
        this.zZF = aVar;
        if (!gbx()) {
            View contentView = this.ISU.getContentView();
            if (contentView == null) {
                t tVar = new t("null cannot be cast to non-null type me.imid.swipebacklayout.lib.SwipeBackLayout");
                AppMethodBeat.o(210329);
                throw tVar;
            }
            ((me.imid.swipebacklayout.lib.SwipeBackLayout) contentView).a(new b(aVar));
        } else if (this.activity instanceof MMActivity) {
            Activity activity2 = this.activity;
            if (activity2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(210329);
                throw tVar2;
            } else if (((MMActivity) activity2).getSwipeBackLayout() != null) {
                Activity activity3 = this.activity;
                if (activity3 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(210329);
                    throw tVar3;
                }
                ((MMActivity) activity3).getSwipeBackLayout().setSwipeBackListener(this.zZE);
                AppMethodBeat.o(210329);
                return;
            }
        }
        AppMethodBeat.o(210329);
    }
}
