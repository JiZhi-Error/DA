package com.tencent.mm.plugin.multitask.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.ViewGroup;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.c.d;
import com.tencent.mm.plugin.multitask.f;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 +2\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\rH\u0002J\u0006\u0010\u0015\u001a\u00020\rJ\b\u0010\u0016\u001a\u00020\rH\u0002J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0013J\u001c\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010#\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ \u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0013J\u0010\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "displayHeight", "", "lastOrientation", "multiTaskFloatBallView", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallView;", "parent", "Landroid/view/ViewGroup;", "addFloatBallViewListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "attachFloatBallViewToWindow", "attachToView", "canNotShowFloatBall", "", "detachFloatBallViewFromWindow", "detachFromWindow", "detachFromWindowInternal", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "withTransAnimation", "withAlphaAnimation", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "initFloatBallView", "isAnimating", "markWechatInForeground", "inForeground", "onFloatBallInfoChanged", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "removeFloatBallViewListener", "resume", "withAnimation", "checkVisible", "setNeedTranslateAnimation", "needTranslateAnimation", "whenOrientationChange", "newOrientation", "Companion", "plugin-multitask_release"})
public final class b {
    public static final a Acm = new a((byte) 0);
    public MultiTaskFloatBallView Acl;
    private int displayHeight;
    private int lastOrientation = 1;
    private ViewGroup parent;

    static {
        AppMethodBeat.i(200655);
        AppMethodBeat.o(200655);
    }

    public b(Context context) {
        p.h(context, "context");
        AppMethodBeat.i(200654);
        this.displayHeight = com.tencent.mm.cb.a.jo(context);
        this.Acl = new MultiTaskFloatBallView(context, null, 6, (byte) 0);
        MultiTaskFloatBallView multiTaskFloatBallView = this.Acl;
        if (multiTaskFloatBallView != null) {
            multiTaskFloatBallView.a(new c(this));
            AppMethodBeat.o(200654);
            return;
        }
        AppMethodBeat.o(200654);
    }

    public static final /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(200657);
        bVar.ciW();
        AppMethodBeat.o(200657);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer$initFloatBallView$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "onMultiTaskPanelClicked", "", "onMultiTaskPanelDelete", "onMultiTaskPanelHide", "onMultiTaskPanelShow", "anim", "", "onOrientationChange", "orientation", "", "setTransformationListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "plugin-multitask_release"})
    public static final class c implements d {
        final /* synthetic */ b Acn;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(b bVar) {
            this.Acn = bVar;
        }

        @Override // com.tencent.mm.plugin.multitask.c.d
        public final void onOrientationChange(int i2) {
            AppMethodBeat.i(200649);
            b.a(this.Acn, i2);
            AppMethodBeat.o(200649);
        }
    }

    public final void a(MultiTaskInfo multiTaskInfo, AnimatorListenerAdapter animatorListenerAdapter) {
        MultiTaskFloatBallView multiTaskFloatBallView;
        MultiTaskFloatBallView multiTaskFloatBallView2;
        AppMethodBeat.i(200650);
        if (multiTaskInfo != null) {
            Object[] objArr = new Object[1];
            MultiTaskFloatBallView multiTaskFloatBallView3 = this.Acl;
            objArr[0] = multiTaskFloatBallView3 != null ? Boolean.valueOf(multiTaskFloatBallView3.oYj) : null;
            Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView %b", objArr);
            MultiTaskFloatBallView multiTaskFloatBallView4 = this.Acl;
            if (!(multiTaskFloatBallView4 == null || multiTaskFloatBallView4.oYj || (multiTaskFloatBallView2 = this.Acl) == null)) {
                multiTaskFloatBallView2.getVisibility();
                Log.i("MicroMsg.FloatBallView", "show without animation");
                multiTaskFloatBallView2.setVisibility(0);
            }
        } else {
            MultiTaskFloatBallView multiTaskFloatBallView5 = this.Acl;
            if (multiTaskFloatBallView5 != null && multiTaskFloatBallView5.getVisibility() == 0) {
                Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView");
                MultiTaskFloatBallView multiTaskFloatBallView6 = this.Acl;
                if (multiTaskFloatBallView6 != null) {
                    multiTaskFloatBallView6.d(false, false, animatorListenerAdapter);
                }
            }
        }
        if (this.Acl == null || (multiTaskFloatBallView = this.Acl) == null) {
            AppMethodBeat.o(200650);
            return;
        }
        multiTaskFloatBallView.a(multiTaskInfo, animatorListenerAdapter);
        AppMethodBeat.o(200650);
    }

    public final void B(ViewGroup viewGroup) {
        AppMethodBeat.i(200651);
        MultiTaskFloatBallView multiTaskFloatBallView = this.Acl;
        if (multiTaskFloatBallView != null) {
            multiTaskFloatBallView.setVisibility(8);
        }
        this.parent = viewGroup;
        if (viewGroup != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.leftMargin = 0 - f.Iaf;
            marginLayoutParams.topMargin = f.oYW - f.Iag;
            Log.i("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow success, topMargin:" + marginLayoutParams.topMargin);
            if (marginLayoutParams.topMargin > 0) {
                marginLayoutParams.topMargin -= f.Iag;
            }
            MultiTaskFloatBallView multiTaskFloatBallView2 = this.Acl;
            if (multiTaskFloatBallView2 != null) {
                multiTaskFloatBallView2.setLayoutParams(marginLayoutParams);
            }
            try {
                viewGroup.addView(this.Acl, viewGroup.getChildCount());
                Log.i("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow success");
                AppMethodBeat.o(200651);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FloatBallContainer", e2, "attachFloatBallViewToWindow fail", new Object[0]);
                AppMethodBeat.o(200651);
            }
        } else {
            Log.e("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow, window manager is null");
            AppMethodBeat.o(200651);
        }
    }

    public final void setNeedTranslateAnimation(boolean z) {
        MultiTaskFloatBallView multiTaskFloatBallView;
        AppMethodBeat.i(200652);
        if (this.Acl == null || (multiTaskFloatBallView = this.Acl) == null) {
            AppMethodBeat.o(200652);
            return;
        }
        multiTaskFloatBallView.setNeedTranslateAnimation(z);
        AppMethodBeat.o(200652);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer$detachFloatBallViewFromWindow$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.ui.b$b  reason: collision with other inner class name */
    public static final class C1521b extends AnimatorListenerAdapter {
        final /* synthetic */ b Acn;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1521b(b bVar) {
            this.Acn = bVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(200648);
            p.h(animator, "animation");
            b.a(this.Acn);
            AppMethodBeat.o(200648);
        }
    }

    /* access modifiers changed from: package-private */
    public final void ciW() {
        AppMethodBeat.i(200653);
        try {
            if (this.parent != null) {
                ViewGroup viewGroup = this.parent;
                if (viewGroup != null) {
                    viewGroup.removeView(this.Acl);
                }
                Log.i("MicroMsg.FloatBallContainer", "detachFromWindowInternal, detach all views");
                AppMethodBeat.o(200653);
                return;
            }
            Log.e("MicroMsg.FloatBallContainer", "detachFromWindowInternal, window manager is null");
            AppMethodBeat.o(200653);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FloatBallContainer", e2, "detachFromWindowInternal exception", new Object[0]);
            AppMethodBeat.o(200653);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer$Companion;", "", "()V", "TAG", "", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(b bVar, int i2) {
        AppMethodBeat.i(200656);
        Log.i("MicroMsg.FloatBallContainer", "whenOrientationChange new:%d, last:%d", Integer.valueOf(i2), Integer.valueOf(bVar.lastOrientation));
        if (bVar.lastOrientation != i2) {
            bVar.lastOrientation = i2;
        }
        AppMethodBeat.o(200656);
    }
}
