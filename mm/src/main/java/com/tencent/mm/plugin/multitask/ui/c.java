package com.tencent.mm.plugin.multitask.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.animation.b.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0012\u001a\u00020\rJ\u001e\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J \u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u001c\u0010\u001c\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u001e\u0010\u001e\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001f\u001a\u00020\rH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBInfoChangedListener;", "()V", "adapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "forceHideAllFloatBall", "", "isFloatBallContainerExisted", "()Z", "multiTaskFloatBallContainer", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskFloatBallContainer;", "needTranslateAnimation", "addFloatBallViewListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "attachFloatBallContainer", "attachPageAdapter", "detachFloatBallContainer", "doOnFloatBallInfoChanged", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animatorListenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "hideFloatBallContainer", "withTransAnimation", "withAlphaAnimation", "isAnimating", "onFloatBallInfoChanged", "removeFloatBallViewListener", "updateMultiTaskFBInfoList", "updateNeedTranslateAnimation", "Companion", "plugin-multitask_release"})
public final class c implements com.tencent.mm.plugin.multitask.c.b {
    public static final a AcB = new a((byte) 0);
    public com.tencent.mm.plugin.multitask.a.a AcA;
    public b Acz;
    private boolean oYj;

    static {
        AppMethodBeat.i(200702);
        AppMethodBeat.o(200702);
    }

    public static final /* synthetic */ void a(c cVar, MultiTaskInfo multiTaskInfo, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(200704);
        cVar.b(multiTaskInfo, animatorListenerAdapter);
        AppMethodBeat.o(200704);
    }

    public static final /* synthetic */ void c(c cVar) {
        AppMethodBeat.i(200703);
        cVar.cjb();
        AppMethodBeat.o(200703);
    }

    public final boolean ciY() {
        return this.Acz != null;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.multitask.ui.c$c  reason: collision with other inner class name */
    public static final class RunnableC1524c implements Runnable {
        final /* synthetic */ c AcC;
        final /* synthetic */ boolean AcD;
        final /* synthetic */ boolean AcE;
        final /* synthetic */ AnimatorListenerAdapter AcF;

        RunnableC1524c(c cVar, boolean z, boolean z2, AnimatorListenerAdapter animatorListenerAdapter) {
            this.AcC = cVar;
            this.AcD = z;
            this.AcE = z2;
            this.AcF = animatorListenerAdapter;
        }

        public final void run() {
            AppMethodBeat.i(200693);
            if (this.AcC.ciY()) {
                b bVar = this.AcC.Acz;
                if (bVar != null) {
                    boolean z = this.AcD;
                    boolean z2 = this.AcE;
                    AnimatorListenerAdapter animatorListenerAdapter = this.AcF;
                    if (bVar.Acl != null) {
                        Log.i("MicroMsg.FloatBallContainer", "hide MultiTaskFloatBallView, transAnim:" + z + ", alphaAnim:" + z2);
                        MultiTaskFloatBallView multiTaskFloatBallView = bVar.Acl;
                        if (multiTaskFloatBallView != null) {
                            multiTaskFloatBallView.d(z, z2, animatorListenerAdapter);
                            AppMethodBeat.o(200693);
                            return;
                        }
                        AppMethodBeat.o(200693);
                    } else if (animatorListenerAdapter != null) {
                        animatorListenerAdapter.onAnimationCancel(null);
                        AppMethodBeat.o(200693);
                    } else {
                        AppMethodBeat.o(200693);
                    }
                } else {
                    AppMethodBeat.o(200693);
                }
            } else {
                AnimatorListenerAdapter animatorListenerAdapter2 = this.AcF;
                if (animatorListenerAdapter2 != null) {
                    animatorListenerAdapter2.onAnimationCancel(null);
                    AppMethodBeat.o(200693);
                    return;
                }
                AppMethodBeat.o(200693);
            }
        }
    }

    public final void e(boolean z, boolean z2, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(200695);
        MMHandlerThread.postToMainThread(new RunnableC1524c(this, z, z2, animatorListenerAdapter));
        AppMethodBeat.o(200695);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ c AcC;

        b(c cVar) {
            this.AcC = cVar;
        }

        public final void run() {
            AppMethodBeat.i(200692);
            if (this.AcC.ciY()) {
                c.c(this.AcC);
                b bVar = this.AcC.Acz;
                if (bVar != null) {
                    MultiTaskFloatBallView multiTaskFloatBallView = bVar.Acl;
                    if (multiTaskFloatBallView == null || multiTaskFloatBallView.getVisibility() != 0) {
                        bVar.ciW();
                    } else {
                        MultiTaskFloatBallView multiTaskFloatBallView2 = bVar.Acl;
                        if (multiTaskFloatBallView2 != null && multiTaskFloatBallView2.getVisibility() == 0) {
                            MultiTaskFloatBallView multiTaskFloatBallView3 = bVar.Acl;
                            Boolean valueOf = multiTaskFloatBallView3 != null ? Boolean.valueOf(multiTaskFloatBallView3.oYj) : null;
                            Log.i("MicroMsg.FloatBallContainer", "detachFromWindow, hide floatBallView, needTranslateAnimation: %b", valueOf);
                            if (p.j(valueOf, Boolean.TRUE)) {
                                MultiTaskFloatBallView multiTaskFloatBallView4 = bVar.Acl;
                                if (multiTaskFloatBallView4 != null) {
                                    b.C1521b bVar2 = new b.C1521b(bVar);
                                    Log.i("MicroMsg.FloatBallView", "alvinluo hideByTranslation");
                                    multiTaskFloatBallView4.setNeedTranslateAnimation(false);
                                    if (multiTaskFloatBallView4.getVisibility() == 8) {
                                        Log.i("MicroMsg.FloatBallView", "hideByTranslation float ball already hide");
                                    } else if (multiTaskFloatBallView4.Aco != null) {
                                        ViewGroup.LayoutParams layoutParams = multiTaskFloatBallView4.getLayoutParams();
                                        if (layoutParams == null) {
                                            t tVar = new t("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
                                            AppMethodBeat.o(200692);
                                            throw tVar;
                                        }
                                        boolean BT = multiTaskFloatBallView4.BT(((WindowManager.LayoutParams) layoutParams).x);
                                        com.tencent.mm.plugin.multitask.animation.b.b bVar3 = multiTaskFloatBallView4.Aco;
                                        if (bVar3 != null) {
                                            int currentStateWidth = multiTaskFloatBallView4.getCurrentStateWidth();
                                            if (bVar3.targetView != null) {
                                                if (bVar3.chJ()) {
                                                    Log.i("MicroMsg.FloatBallViewAnimationHandler", "isAnimatingHide");
                                                } else {
                                                    if (bVar3.chI()) {
                                                        Log.i("MicroMsg.FloatBallViewAnimationHandler", "cancel show animator");
                                                        Animator animator = bVar3.oWg;
                                                        if (animator != null) {
                                                            animator.cancel();
                                                        }
                                                    }
                                                    Log.v("MicroMsg.FloatBallViewAnimationHandler", "playHideTranslateAnimation, view:%s, width: %d, isDockLeft: %b", bVar3.targetView, Integer.valueOf(currentStateWidth), Boolean.valueOf(BT));
                                                    bVar3.oWh = bVar3.a(false, currentStateWidth, BT, (AnimatorListenerAdapter) new b.C1505b(bVar3.targetView, bVar2));
                                                    Animator animator2 = bVar3.oWh;
                                                    if (animator2 != null) {
                                                        animator2.start();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                MultiTaskFloatBallView multiTaskFloatBallView5 = bVar.Acl;
                                if (multiTaskFloatBallView5 != null) {
                                    multiTaskFloatBallView5.d(false, false, null);
                                }
                                bVar.ciW();
                            }
                        }
                    }
                }
                this.AcC.Acz = null;
            }
            AppMethodBeat.o(200692);
        }
    }

    private void ciZ() {
        AppMethodBeat.i(200696);
        MMHandlerThread.postToMainThread(new b(this));
        AppMethodBeat.o(200696);
    }

    @Override // com.tencent.mm.plugin.multitask.c.b
    public final void a(MultiTaskInfo multiTaskInfo, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(200697);
        Log.d("MicroMsg.MultiTaskUIManager", "onFloatBallInfoChanged");
        if (p.j(Looper.getMainLooper(), Looper.myLooper())) {
            b(multiTaskInfo, animatorListenerAdapter);
            AppMethodBeat.o(200697);
            return;
        }
        MMHandlerThread.postToMainThread(new d(this, multiTaskInfo, animatorListenerAdapter));
        AppMethodBeat.o(200697);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ c AcC;
        final /* synthetic */ AnimatorListenerAdapter AcF;
        final /* synthetic */ MultiTaskInfo uLz;

        d(c cVar, MultiTaskInfo multiTaskInfo, AnimatorListenerAdapter animatorListenerAdapter) {
            this.AcC = cVar;
            this.uLz = multiTaskInfo;
            this.AcF = animatorListenerAdapter;
        }

        public final void run() {
            AppMethodBeat.i(200694);
            c.a(this.AcC, this.uLz, this.AcF);
            AppMethodBeat.o(200694);
        }
    }

    private final void b(MultiTaskInfo multiTaskInfo, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(200698);
        try {
            this.oYj = false;
            if (multiTaskInfo == null) {
                Log.i("MicroMsg.MultiTaskUIManager", "empty ball info list");
                ciZ();
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationCancel(null);
                    AppMethodBeat.o(200698);
                    return;
                }
                AppMethodBeat.o(200698);
            } else if (!ciY()) {
                Log.i("MicroMsg.MultiTaskUIManager", "float ball did not create");
                cja();
                c(multiTaskInfo, animatorListenerAdapter);
                AppMethodBeat.o(200698);
            } else {
                Log.i("MicroMsg.MultiTaskUIManager", "float ball already created");
                c(multiTaskInfo, animatorListenerAdapter);
                AppMethodBeat.o(200698);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.MultiTaskUIManager", "doOnFloatBallInfoChanged exp:%s", e2);
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationCancel(null);
                AppMethodBeat.o(200698);
                return;
            }
            AppMethodBeat.o(200698);
        }
    }

    private final void cja() {
        AppMethodBeat.i(200699);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        this.Acz = new b(context);
        b bVar = this.Acz;
        if (bVar != null) {
            com.tencent.mm.plugin.multitask.a.a aVar = this.AcA;
            bVar.B(aVar != null ? aVar.chG() : null);
        }
        cjb();
        AppMethodBeat.o(200699);
    }

    private final void c(MultiTaskInfo multiTaskInfo, AnimatorListenerAdapter animatorListenerAdapter) {
        b bVar;
        AppMethodBeat.i(200700);
        if (!ciY() || (bVar = this.Acz) == null) {
            AppMethodBeat.o(200700);
            return;
        }
        bVar.a(multiTaskInfo, animatorListenerAdapter);
        AppMethodBeat.o(200700);
    }

    private final void cjb() {
        AppMethodBeat.i(200701);
        if (this.oYj) {
            b bVar = this.Acz;
            if (bVar != null) {
                bVar.setNeedTranslateAnimation(this.oYj);
            }
            this.oYj = false;
        }
        AppMethodBeat.o(200701);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager$Companion;", "", "()V", "TAG", "", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
