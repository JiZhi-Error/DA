package com.tencent.mm.plugin.festival.finder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.appbrand.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.festival.c.j;
import com.tencent.mm.plugin.festival.finder.k;
import com.tencent.mm.plugin.festival.finder.w;
import com.tencent.mm.plugin.festival.model.a.e;
import com.tencent.mm.plugin.festival.ui.StarryNight;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.statemachine.IState;
import com.tencent.mm.sdk.statemachine.State;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00013B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010&\u001a\u00020 H\u0016J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020 H\u0016J\b\u0010*\u001a\u00020 H\u0002J\u0010\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u000eH\u0016J\u001a\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020(H\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020 8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00060#R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "presenter", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$Presenter;", "canvasPresenter", "Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$Presenter;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$Presenter;Lcom/tencent/mm/plugin/festival/finder/FestivalCanvasViewContract$Presenter;)V", "SM_DATA_KEY_RUN_ENTER_ANIMATION", "", "SM_MSG_ON_CANVAS_CLICK", "", "SM_MSG_TO_STATE_EXIT", "SM_MSG_TO_STATE_RUN_WISH_POSTED_ANIMATION", "SM_MSG_TO_STATE_WAIT_FOR_PICK_LOCATION", "SM_MSG_TO_STATE_WAIT_FOR_WISH_RESULT", "SM_MSG_TO_STATE_WAIT_FOR_ZOOM_IN", "cancelButton", "Landroid/view/View;", "canvasBlurScreenshotView", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "hintTextView", "Landroid/widget/TextView;", "isScenarioValid", "", "()Z", "stateMachine", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine;", "zoomInCoverView", "Lcom/tencent/mm/plugin/festival/finder/FestivalPrepareWishZoomInCoverView;", "canClearScreen", c.NAME, "", "onBackPress", "requestExitPrepareWishUI", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "ScenarioStateMachine", "plugin-festival_release"})
public final class ah extends p {
    final TextView HZZ;
    final k.a Uqk;
    final br UtA;
    final View UtB;
    final ImageView UtC;
    private b UtD;
    final int UtE;
    final int UtF;
    final int UtG;
    final int UtH;
    final int UtI;
    final int UtJ;
    final String UtK;
    final w.a UtL;
    final com.tencent.mm.live.c.b hOp;

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0002J0\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0014J\u0006\u0010\u001d\u001a\u00020\u0015J\b\u0010\u001e\u001a\u00020\u0015H\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0005R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine;", "Lcom/tencent/mm/plugin/appbrand/appstate/StateMachineWithCustomLog;", "(Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin;)V", "isInConstruction", "", "()Z", "<set-?>", "isQuitting", "isStarted", "stateEnterScenario", "Lcom/tencent/mm/sdk/statemachine/State;", "stateExitScenario", "stateRunWishPostedAnimation", "stateWaitForPickLocation", "stateWaitForWishResult", "stateWaitForZoomIn", "createHintTextAlphaAnimator", "Landroid/animation/Animator;", "cb", "Lkotlin/Function1;", "", "", "linearIt", "value", "fromStart", "fromEnd", "toStart", "toEnd", "onQuitting", "quitSafely", "start", "BaseState", "plugin-festival_release"})
    public final class b extends i {
        private final State UtN = new c(this);
        private final State UtO = new d(this);
        private final State UtP = new h(this);
        private final State UtQ = new f(this);
        private final State UtR = new g(this);
        private final State UtS = new e(this);
        boolean UtT;
        boolean isStarted;

        @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateEnterScenario$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$BaseState;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin;", "enterAnimation", "Landroid/animation/Animator;", "hasExited", "", "enter", "", "exit", "processMessage", "msg", "Landroid/os/Message;", "runEnterAnimation", "onEnd", "Lkotlin/Function0;", "plugin-festival_release"})
        public static final class c extends a {
            final /* synthetic */ b UtV;
            private Animator UtW;
            private boolean UtX;

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/util/FestivalViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-festival_release"})
            public static final class a implements ViewTreeObserver.OnPreDrawListener {
                final /* synthetic */ c UtY;
                final /* synthetic */ View nca;

                public a(View view, c cVar) {
                    this.nca = view;
                    this.UtY = cVar;
                }

                public final boolean onPreDraw() {
                    AppMethodBeat.i(262460);
                    this.nca.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (!this.UtY.UtX) {
                        c.a(this.UtY, new C1055a(this));
                    }
                    AppMethodBeat.o(262460);
                    return false;
                }

                @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateEnterScenario$1$enter$2$1"})
                /* renamed from: com.tencent.mm.plugin.festival.finder.ah$b$c$a$a  reason: collision with other inner class name */
                static final class C1055a extends q implements kotlin.g.a.a<x> {
                    final /* synthetic */ a UtZ;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    C1055a(a aVar) {
                        super(0);
                        this.UtZ = aVar;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(262459);
                        this.UtZ.UtY.UtV.sendMessage(ah.this.UtF);
                        x xVar = x.SXb;
                        AppMethodBeat.o(262459);
                        return xVar;
                    }
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(b bVar) {
                super();
                this.UtV = bVar;
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final void enter() {
                AppMethodBeat.i(262469);
                this.UtX = false;
                ah.this.UtL.Fh(true);
                ah.this.HZZ.setVisibility(4);
                ah.this.UtB.setVisibility(4);
                ah.this.hwr.setVisibility(0);
                ah.this.hwr.setAlpha(1.0f);
                ah.this.hwr.setBackgroundColor(0);
                ah.this.hwr.bringToFront();
                ah.this.UtA.setVisibility(0);
                ah.this.UtA.setScaleY(1.0f);
                ah.this.UtA.setScaleX(1.0f);
                ah.this.hwr.invalidate();
                ah.this.Uqk.egv();
                ViewGroup.LayoutParams layoutParams = ah.this.UtA.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams != null) {
                    int cR = kotlin.h.a.cR(ah.this.Uqk.getVRectDefault().top);
                    j jVar = j.UGJ;
                    Context context = ah.this.hwr.getContext();
                    p.g(context, "context");
                    int statusBarHeight = j.getStatusBarHeight(context);
                    Context context2 = ah.this.hwr.getContext();
                    p.g(context2, "context");
                    marginLayoutParams.topMargin = Math.max(cR, statusBarHeight + context2.getResources().getDimensionPixelSize(R.dimen.cn));
                    ah.this.UtA.requestLayout();
                }
                j jVar2 = j.UGJ;
                br brVar = ah.this.UtA;
                brVar.getViewTreeObserver().addOnPreDrawListener(new a(brVar, this));
                AppMethodBeat.o(262469);
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final void exit() {
                AppMethodBeat.i(262470);
                this.UtX = true;
                if (this.UtW != null) {
                    Animator animator = this.UtW;
                    if (animator == null) {
                        p.btv("enterAnimation");
                    }
                    animator.cancel();
                }
                AppMethodBeat.o(262470);
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState, com.tencent.mm.plugin.festival.finder.ah.b.a
            public final boolean processMessage(Message message) {
                AppMethodBeat.i(262471);
                if (message == null || message.what != ah.this.UtF) {
                    boolean processMessage = super.processMessage(message);
                    AppMethodBeat.o(262471);
                    return processMessage;
                }
                b.a(this.UtV, (IState) new ak(this.UtV).get());
                AppMethodBeat.o(262471);
                return true;
            }

            /* access modifiers changed from: package-private */
            @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateEnterScenario$1$runEnterAnimation$step1Animator$1$1$1", "com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateEnterScenario$1$$special$$inlined$apply$lambda$1"})
            /* renamed from: com.tencent.mm.plugin.festival.finder.ah$b$c$c  reason: collision with other inner class name */
            public static final class C1057c implements ValueAnimator.AnimatorUpdateListener {
                final /* synthetic */ c UtY;
                final /* synthetic */ float Uuc;

                C1057c(float f2, c cVar) {
                    this.Uuc = f2;
                    this.UtY = cVar;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(262464);
                    p.g(valueAnimator, "animator");
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    if (animatedValue == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                        AppMethodBeat.o(262464);
                        throw tVar;
                    }
                    float floatValue = ((Float) animatedValue).floatValue();
                    ah.this.UtA.setScaleX(floatValue);
                    ah.this.UtA.setScaleY(floatValue);
                    AppMethodBeat.o(262464);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateEnterScenario$1$runEnterAnimation$step1Animator$1$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "plugin-festival_release", "com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateEnterScenario$1$$special$$inlined$apply$lambda$2"})
            public static final class d extends AnimatorListenerAdapter {
                final /* synthetic */ c UtY;
                final /* synthetic */ float Uuc;
                final /* synthetic */ long Uud = 500;
                final /* synthetic */ AccelerateDecelerateInterpolator Uue;

                d(AccelerateDecelerateInterpolator accelerateDecelerateInterpolator, float f2, c cVar) {
                    this.Uue = accelerateDecelerateInterpolator;
                    this.Uuc = f2;
                    this.UtY = cVar;
                }

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(262465);
                    p.h(animator, "animation");
                    StarryNight.m mVar = new StarryNight.m();
                    mVar.UDM = Float.valueOf(ah.this.UtA.getVRect().width() / ((float) ah.this.Uqk.getSrcWidth()));
                    ValueAnimator hSm = mVar.hSm();
                    hSm.setDuration(this.Uud);
                    hSm.setInterpolator(this.Uue);
                    mVar.a(new Point(0, 0), new PointF(((float) ah.this.UtA.getLeft()) + ah.this.UtA.getVRect().left, ((float) ah.this.UtA.getTop()) + ah.this.UtA.getVRect().top));
                    ah.this.Uqk.setScaleAndTranslate(mVar);
                    AppMethodBeat.o(262465);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\b"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateEnterScenario$1$runEnterAnimation$step2Animator$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-festival_release", "com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateEnterScenario$1$$special$$inlined$apply$lambda$4"})
            public static final class e extends AnimatorListenerAdapter {
                final /* synthetic */ c UtY;

                e(c cVar) {
                    this.UtY = cVar;
                }

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(262466);
                    p.h(animator, "animation");
                    ah.this.hwr.setBackgroundColor(0);
                    ah.this.HZZ.setText(R.string.j9b);
                    ah.this.HZZ.setAlpha(0.0f);
                    ah.this.HZZ.setVisibility(0);
                    ah.this.UtB.setAlpha(0.0f);
                    ah.this.UtB.setVisibility(0);
                    ah.this.Uqk.dRg();
                    AppMethodBeat.o(262466);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(262467);
                    p.h(animator, "animation");
                    ah.this.UtB.setVisibility(0);
                    ah.this.UtB.setAlpha(1.0f);
                    ah.this.HZZ.setVisibility(0);
                    ah.this.HZZ.setAlpha(0.0f);
                    ah.this.UtA.setVisibility(0);
                    ah.this.UtA.setAlpha(1.0f);
                    AppMethodBeat.o(262467);
                }
            }

            /* access modifiers changed from: package-private */
            @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\b"}, hxF = {"<anonymous>", "", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateEnterScenario$1$runEnterAnimation$step2Animator$1$1$2$1", "com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateEnterScenario$1$$special$$inlined$apply$lambda$3", "com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateEnterScenario$1$$special$$inlined$apply$lambda$5"})
            public static final class f implements ValueAnimator.AnimatorUpdateListener {
                final /* synthetic */ c UtY;

                f(c cVar) {
                    this.UtY = cVar;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(262468);
                    p.g(valueAnimator, "animator");
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    if (animatedValue == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                        AppMethodBeat.o(262468);
                        throw tVar;
                    }
                    ah.this.UtB.setAlpha(((Float) animatedValue).floatValue());
                    AppMethodBeat.o(262468);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateEnterScenario$1$runEnterAnimation$2$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-festival_release"})
            /* renamed from: com.tencent.mm.plugin.festival.finder.ah$b$c$b  reason: collision with other inner class name */
            public static final class C1056b extends AnimatorListenerAdapter {
                final /* synthetic */ kotlin.g.a.a Usj;
                final /* synthetic */ Animator Uua;
                final /* synthetic */ Animator Uub;

                C1056b(Animator animator, Animator animator2, kotlin.g.a.a aVar) {
                    this.Uua = animator;
                    this.Uub = animator2;
                    this.Usj = aVar;
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(262463);
                    this.Usj.invoke();
                    AppMethodBeat.o(262463);
                }
            }

            public static final /* synthetic */ void a(c cVar, kotlin.g.a.a aVar) {
                AppMethodBeat.i(262472);
                float width = ((float) ah.this.hwr.getWidth()) / ah.this.UtA.getVRect().width();
                ValueAnimator ofFloat = ValueAnimator.ofFloat(width, 1.0f);
                ah.this.UtA.setScaleX(width);
                ah.this.UtA.setScaleY(width);
                ah.this.UtA.setPivotX(((float) ah.this.UtA.getWidth()) / 2.0f);
                ah.this.UtA.setPivotY(((float) ah.this.UtA.getHeight()) / 2.0f);
                AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
                p.g(ofFloat, "this");
                ofFloat.setInterpolator(accelerateDecelerateInterpolator);
                ofFloat.setDuration(500L);
                ofFloat.addUpdateListener(new C1057c(width, cVar));
                ofFloat.addListener(new d(accelerateDecelerateInterpolator, width, cVar));
                p.g(ofFloat, "ValueAnimator.ofFloat(ma…                        }");
                ValueAnimator valueAnimator = ofFloat;
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(300L);
                animatorSet.addListener(new e(cVar));
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat2.addUpdateListener(new f(cVar));
                animatorSet.playTogether(ofFloat2);
                AnimatorSet animatorSet2 = animatorSet;
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playSequentially(valueAnimator, animatorSet2);
                animatorSet3.addListener(new C1056b(valueAnimator, animatorSet2, aVar));
                animatorSet3.start();
                cVar.UtW = animatorSet3;
                AppMethodBeat.o(262472);
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            super("FestivalPrepareWishPluginStateMachine", Looper.getMainLooper());
            AppMethodBeat.i(262507);
            addState(this.UtN);
            addState(this.UtO);
            addState(this.UtP);
            addState(this.UtQ);
            addState(this.UtR);
            addState(this.UtS);
            setInitialState(this.UtN);
            AppMethodBeat.o(262507);
        }

        public static final /* synthetic */ void a(b bVar, IState iState) {
            AppMethodBeat.i(262508);
            bVar.transitionTo(iState);
            AppMethodBeat.o(262508);
        }

        public static final /* synthetic */ void c(b bVar) {
            AppMethodBeat.i(262509);
            bVar.quitNow();
            AppMethodBeat.o(262509);
        }

        public static final /* synthetic */ Message e(b bVar) {
            AppMethodBeat.i(262511);
            Message currentMessage = bVar.getCurrentMessage();
            AppMethodBeat.o(262511);
            return currentMessage;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$BaseState;", "Lcom/tencent/mm/sdk/statemachine/State;", "(Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine;)V", "processMessage", "", "msg", "Landroid/os/Message;", "plugin-festival_release"})
        public class a extends State {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public boolean processMessage(Message message) {
                AppMethodBeat.i(262457);
                if (message == null || message.what != ah.this.UtI || !(!p.j(this, (State) new ai(b.this).get()))) {
                    boolean processMessage = super.processMessage(message);
                    AppMethodBeat.o(262457);
                    return processMessage;
                }
                b.a(b.this, (IState) new aj(b.this).get());
                AppMethodBeat.o(262457);
                return true;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0002¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateExitScenario$1", "Lcom/tencent/mm/sdk/statemachine/State;", "enter", "", "runExitAnimation", "onEnd", "Lkotlin/Function0;", "plugin-festival_release"})
        public static final class d extends State {
            final /* synthetic */ b UtV;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            d(b bVar) {
                this.UtV = bVar;
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final void enter() {
                AppMethodBeat.i(262475);
                ah.a(ah.this);
                ah.this.UtL.Fh(false);
                ViewPropertyAnimator animate = ah.this.hwr.animate();
                animate.cancel();
                animate.setDuration(300);
                animate.alpha(0.0f);
                StarryNight.m mVar = new StarryNight.m();
                mVar.UDM = Float.valueOf(ah.this.Uqk.getVScaleDefault());
                RectF vRectDefault = ah.this.Uqk.getVRectDefault();
                mVar.a(new Point(0, 0), new PointF(vRectDefault.left, vRectDefault.top));
                mVar.hSm().setDuration(300L);
                ah.this.Uqk.setScaleAndTranslate(mVar);
                animate.setListener(new C1058b(this, new a(this)));
                animate.start();
                AppMethodBeat.o(262475);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateExitScenario$1$runExitAnimation$2$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-festival_release"})
            /* renamed from: com.tencent.mm.plugin.festival.finder.ah$b$d$b  reason: collision with other inner class name */
            public static final class C1058b extends AnimatorListenerAdapter {
                final /* synthetic */ kotlin.g.a.a Usj;
                final /* synthetic */ d Uuf;
                final /* synthetic */ long tph = 300;

                C1058b(d dVar, kotlin.g.a.a aVar) {
                    this.Uuf = dVar;
                    this.Usj = aVar;
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(262474);
                    p.h(animator, "animation");
                    this.Usj.invoke();
                    AppMethodBeat.o(262474);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
            static final class a extends q implements kotlin.g.a.a<x> {
                final /* synthetic */ d Uuf;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(d dVar) {
                    super(0);
                    this.Uuf = dVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(262473);
                    ah.this.hwr.setAlpha(0.0f);
                    ah.this.hwr.setVisibility(8);
                    b.c(this.Uuf.UtV);
                    b.C0376b.a(ah.this.hOp, b.c.wsW);
                    x xVar = x.SXb;
                    AppMethodBeat.o(262473);
                    return xVar;
                }
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$createHintTextAlphaAnimator$1$1"})
        /* renamed from: com.tencent.mm.plugin.festival.finder.ah$b$b  reason: collision with other inner class name */
        public static final class C1054b implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ kotlin.g.a.b ICi;
            final /* synthetic */ b UtV;

            C1054b(b bVar, kotlin.g.a.b bVar2) {
                this.UtV = bVar;
                this.ICi = bVar2;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float c2;
                AppMethodBeat.i(262458);
                p.g(valueAnimator, LocaleUtil.ITALIAN);
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                    AppMethodBeat.o(262458);
                    throw tVar;
                }
                float floatValue = ((Float) animatedValue).floatValue();
                if (floatValue < 1.0f) {
                    c2 = b.c(floatValue, 0.0f, 1.0f, 0.0f, 1.0f);
                } else if (((double) floatValue) < 1.7d) {
                    c2 = b.c(floatValue, 1.0f, 1.7f, 1.0f, 0.3f);
                } else if (((double) floatValue) < 2.4d) {
                    c2 = b.c(floatValue, 1.7f, 2.4f, 0.3f, 1.0f);
                } else {
                    c2 = ((double) floatValue) < 3.9d ? b.c(floatValue, 2.4f, 3.9f, 1.0f, 0.0f) : 0.0f;
                }
                this.ICi.invoke(Float.valueOf(c2));
                AppMethodBeat.o(262458);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateWaitForZoomIn$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$BaseState;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin;", "animator", "Landroid/animation/Animator;", "getAnimator", "()Landroid/animation/Animator;", "setAnimator", "(Landroid/animation/Animator;)V", "enter", "", "exit", "processMessage", "", "msg", "Landroid/os/Message;", "plugin-festival_release"})
        public static final class h extends a {
            private Animator FO;
            final /* synthetic */ b UtV;

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.festival.finder.ah$b$h$b  reason: collision with other inner class name */
            static final class C1061b extends q implements kotlin.g.a.b<Float, x> {
                final /* synthetic */ h Uum;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C1061b(h hVar) {
                    super(1);
                    this.Uum = hVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Float f2) {
                    AppMethodBeat.i(262498);
                    ah.this.HZZ.setAlpha(f2.floatValue());
                    x xVar = x.SXb;
                    AppMethodBeat.o(262498);
                    return xVar;
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            h(b bVar) {
                super();
                this.UtV = bVar;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
            static final class a implements View.OnClickListener {
                final /* synthetic */ h Uum;

                a(h hVar) {
                    this.Uum = hVar;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(262497);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateWaitForZoomIn$1$enter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    ah.this.fwd();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateWaitForZoomIn$1$enter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(262497);
                }
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final void enter() {
                AppMethodBeat.i(262501);
                ah.this.UtB.setOnClickListener(new a(this));
                this.FO = b.a(this.UtV, new C1061b(this));
                AppMethodBeat.o(262501);
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final void exit() {
                AppMethodBeat.i(262502);
                ah.this.UtA.animate().cancel();
                Animator animator = this.FO;
                if (animator != null) {
                    animator.cancel();
                    AppMethodBeat.o(262502);
                    return;
                }
                AppMethodBeat.o(262502);
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState, com.tencent.mm.plugin.festival.finder.ah.b.a
            public final boolean processMessage(Message message) {
                PointF pointF;
                AppMethodBeat.i(262503);
                if (message != null && message.what == ah.this.UtE) {
                    com.tencent.mm.plugin.festival.model.a.e eVar = com.tencent.mm.plugin.festival.model.a.e.UAo;
                    com.tencent.mm.plugin.festival.model.a.e.awH(2);
                    b.a(this.UtV, (IState) new ao(this.UtV).get());
                    AppMethodBeat.o(262503);
                    return true;
                } else if (message == null || message.what != ah.this.UtJ || (pointF = (PointF) message.getData().getParcelable("PARAM_FESTIVAL_FINDER_LIVE_CANVAS_CLICK_POINT")) == null || Float.isNaN(pointF.x) || Float.isNaN(pointF.y)) {
                    boolean processMessage = super.processMessage(message);
                    AppMethodBeat.o(262503);
                    return processMessage;
                } else {
                    int aZ = ah.this.Uqk.aZ(pointF.x);
                    int cV = ah.this.Uqk.cV(pointF.y);
                    Handler handler = this.UtV.getHandler();
                    if (handler == null) {
                        p.hyc();
                    }
                    Message obtainMessage = handler.obtainMessage(ah.this.UtE, aZ, cV);
                    obtainMessage.getData().putBoolean(ah.this.UtK, true);
                    obtainMessage.sendToTarget();
                    AppMethodBeat.o(262503);
                    return true;
                }
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J(\u0010\u0014\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateWaitForPickLocation$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$BaseState;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin;", "animator", "Landroid/animation/Animator;", "hasExited", "", "starryNightBottomMargin", "", "starryNightTopMargin", "checkClickPointValid", "pointF", "Landroid/graphics/PointF;", "enter", "", "exit", "processMessage", "msg", "Landroid/os/Message;", "runEnterAnimation", "onEnd", "Lkotlin/Function0;", "sx", "sy", "plugin-festival_release"})
        public static final class f extends a {
            private Animator FO;
            final /* synthetic */ b UtV;
            private boolean UtX;
            private int Uuh;
            private int Uui;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(b bVar) {
                super();
                this.UtV = bVar;
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final void enter() {
                Bundle data;
                boolean z = true;
                AppMethodBeat.i(262487);
                this.Uuh = 0;
                this.Uui = 0;
                this.UtX = false;
                a aVar = new a(this);
                ah.this.HZZ.setText(R.string.j9a);
                ah.this.HZZ.setAlpha(0.0f);
                Message e2 = b.e(this.UtV);
                if (e2 == null || (data = e2.getData()) == null || !data.getBoolean(ah.this.UtK)) {
                    z = false;
                }
                if (!z) {
                    aVar.invoke();
                    AppMethodBeat.o(262487);
                    return;
                }
                int i2 = b.e(this.UtV).arg1;
                int i3 = b.e(this.UtV).arg2;
                ViewPropertyAnimator animate = ah.this.UtA.animate();
                animate.cancel();
                animate.setDuration(200);
                animate.alpha(0.0f);
                animate.setListener(new C1060b(this, i2, i3, aVar));
                animate.start();
                AppMethodBeat.o(262487);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateWaitForPickLocation$1$runEnterAnimation$2$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-festival_release"})
            /* renamed from: com.tencent.mm.plugin.festival.finder.ah$b$f$b  reason: collision with other inner class name */
            public static final class C1060b extends AnimatorListenerAdapter {
                final /* synthetic */ int UrB;
                final /* synthetic */ int UrC;
                final /* synthetic */ kotlin.g.a.a Usj;
                final /* synthetic */ f Uuj;

                C1060b(f fVar, int i2, int i3, kotlin.g.a.a aVar) {
                    this.Uuj = fVar;
                    this.UrB = i2;
                    this.UrC = i3;
                    this.Usj = aVar;
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(262486);
                    ah.this.UtA.setAlpha(0.0f);
                    ah.this.UtA.setVisibility(8);
                    StarryNight.m mVar = new StarryNight.m();
                    f fVar = this.Uuj;
                    j jVar = j.UGJ;
                    Context context = ah.this.hwr.getContext();
                    p.g(context, "context");
                    int statusBarHeight = j.getStatusBarHeight(context);
                    Context context2 = ah.this.hwr.getContext();
                    p.g(context2, "context");
                    fVar.Uuh = statusBarHeight + context2.getResources().getDimensionPixelSize(R.dimen.cn);
                    f fVar2 = this.Uuj;
                    j jVar2 = j.UGJ;
                    Context context3 = ah.this.hwr.getContext();
                    p.g(context3, "context");
                    fVar2.Uui = j.aD(context3);
                    mVar.UDM = Float.valueOf(((float) ((ah.this.hwr.getHeight() - this.Uuj.Uuh) - this.Uuj.Uui)) / ((float) ah.this.Uqk.getSrcHeight()));
                    float f2 = (float) this.UrB;
                    Float f3 = mVar.UDM;
                    if (f3 == null) {
                        p.hyc();
                    }
                    float floatValue = f2 * f3.floatValue();
                    float width = (float) ah.this.hwr.getWidth();
                    float srcWidth = (float) (ah.this.Uqk.getSrcWidth() - this.UrB);
                    Float f4 = mVar.UDM;
                    if (f4 == null) {
                        p.hyc();
                    }
                    float floatValue2 = width - (srcWidth * f4.floatValue());
                    Point point = new Point(this.UrB, this.UrC);
                    float p = android.support.v4.b.a.p(((float) ah.this.hwr.getWidth()) / 2.0f, Math.min(floatValue, floatValue2), Math.max(floatValue, floatValue2));
                    float f5 = (float) this.UrC;
                    Float f6 = mVar.UDM;
                    if (f6 == null) {
                        p.hyc();
                    }
                    mVar.a(point, new PointF(p, (f5 * f6.floatValue()) + ((float) this.Uuj.Uuh)));
                    ValueAnimator hSm = mVar.hSm();
                    hSm.setDuration(400L);
                    hSm.addListener(new Animator.AnimatorListener(this) {
                        /* class com.tencent.mm.plugin.festival.finder.ah.b.f.C1060b.AnonymousClass1 */
                        final /* synthetic */ C1060b Uul;

                        {
                            this.Uul = r1;
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }

                        public final void onAnimationCancel(Animator animator) {
                        }

                        public final void onAnimationStart(Animator animator) {
                        }

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(262485);
                            this.Uul.Usj.invoke();
                            AppMethodBeat.o(262485);
                        }
                    });
                    ah.this.Uqk.setScaleAndTranslate(mVar);
                    AppMethodBeat.o(262486);
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0079  */
            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState, com.tencent.mm.plugin.festival.finder.ah.b.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean processMessage(android.os.Message r9) {
                /*
                // Method dump skipped, instructions count: 253
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.festival.finder.ah.b.f.processMessage(android.os.Message):boolean");
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final void exit() {
                AppMethodBeat.i(262489);
                ah.this.Uqk.setDraggable(false);
                ah.this.Uqk.Ff(false);
                this.UtX = true;
                Animator animator = this.FO;
                if (animator != null) {
                    animator.cancel();
                }
                this.FO = null;
                AppMethodBeat.o(262489);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
            static final class a extends q implements kotlin.g.a.a<x> {
                final /* synthetic */ f Uuj;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(f fVar) {
                    super(0);
                    this.Uuj = fVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(262482);
                    if (!this.Uuj.UtX) {
                        ah.this.Uqk.setDraggable(true);
                        ah.this.Uqk.Ff(true);
                        this.Uuj.FO = b.a(this.Uuj.UtV, new kotlin.g.a.b<Float, x>(this) {
                            /* class com.tencent.mm.plugin.festival.finder.ah.b.f.a.AnonymousClass1 */
                            final /* synthetic */ a Uuk;

                            {
                                this.Uuk = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // kotlin.g.a.b
                            public final /* synthetic */ x invoke(Float f2) {
                                AppMethodBeat.i(262481);
                                ah.this.HZZ.setAlpha(f2.floatValue());
                                x xVar = x.SXb;
                                AppMethodBeat.o(262481);
                                return xVar;
                            }
                        });
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(262482);
                    return xVar;
                }
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateWaitForWishResult$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$BaseState;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin;", "enter", "", "exit", "processMessage", "", "msg", "Landroid/os/Message;", "plugin-festival_release"})
        public static final class g extends a {
            final /* synthetic */ b UtV;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(b bVar) {
                super();
                this.UtV = bVar;
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final void enter() {
                Bitmap bitmap = null;
                AppMethodBeat.i(262494);
                com.tencent.mm.live.c.b bVar = ah.this.hOp;
                if (!(bVar instanceof FestivalFinderLiveVisitorPluginLayout)) {
                    bVar = null;
                }
                FestivalFinderLiveVisitorPluginLayout festivalFinderLiveVisitorPluginLayout = (FestivalFinderLiveVisitorPluginLayout) bVar;
                if (festivalFinderLiveVisitorPluginLayout != null) {
                    bitmap = FestivalFinderLiveVisitorPluginLayout.b(festivalFinderLiveVisitorPluginLayout);
                }
                if (bitmap == null) {
                    ImageView imageView = ah.this.UtC;
                    com.tencent.mm.plugin.festival.ui.b bVar2 = com.tencent.mm.plugin.festival.ui.b.UBn;
                    Context context = ah.this.hwr.getContext();
                    p.g(context, "context");
                    imageView.setImageDrawable(com.tencent.mm.plugin.festival.ui.b.mj(context));
                } else {
                    ah.this.UtC.setImageBitmap(bitmap);
                }
                ah.this.UtC.setVisibility(0);
                ah.this.UtC.bringToFront();
                ah.this.UtB.setVisibility(4);
                ah.this.HZZ.setVisibility(4);
                AppMethodBeat.o(262494);
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final void exit() {
                Bitmap bitmap;
                BitmapDrawable bitmapDrawable = null;
                AppMethodBeat.i(262495);
                Drawable drawable = ah.this.UtC.getDrawable();
                ah.this.UtC.setImageDrawable(null);
                if (drawable instanceof BitmapDrawable) {
                    bitmapDrawable = drawable;
                }
                BitmapDrawable bitmapDrawable2 = bitmapDrawable;
                if (!(bitmapDrawable2 == null || (bitmap = bitmapDrawable2.getBitmap()) == null)) {
                    bitmap.recycle();
                }
                ah.this.UtC.setVisibility(8);
                ah.this.UtB.setClickable(true);
                ah.this.UtB.setVisibility(0);
                ah.this.HZZ.setVisibility(0);
                AppMethodBeat.o(262495);
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState, com.tencent.mm.plugin.festival.finder.ah.b.a
            public final boolean processMessage(Message message) {
                AppMethodBeat.i(262496);
                if (message != null && message.what == ah.this.UtE) {
                    b.a(this.UtV, (IState) new am(this.UtV).get());
                    AppMethodBeat.o(262496);
                    return true;
                } else if (message == null || message.what != ah.this.UtH) {
                    boolean processMessage = super.processMessage(message);
                    AppMethodBeat.o(262496);
                    return processMessage;
                } else {
                    b.a(this.UtV, (IState) new an(this.UtV).get());
                    AppMethodBeat.o(262496);
                    return true;
                }
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0002¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateRunWishPostedAnimation$1", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$BaseState;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin;", "enter", "", "runAnimation", "onEnd", "Lkotlin/Function0;", "plugin-festival_release"})
        public static final class e extends a {
            final /* synthetic */ b UtV;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(b bVar) {
                super();
                this.UtV = bVar;
            }

            @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
            public final void enter() {
                AppMethodBeat.i(262480);
                ah.a(ah.this);
                Message e2 = b.e(this.UtV);
                p.g(e2, "currentMessage");
                a aVar = new a(this, e2.getData());
                ah.this.UtB.setVisibility(8);
                ah.this.HZZ.setVisibility(8);
                b.C0376b.a(ah.this.hOp, b.c.wMb);
                StarryNight.m mVar = new StarryNight.m();
                mVar.UDM = Float.valueOf(ah.this.Uqk.getVScaleDefault());
                mVar.a(new Point(0, 0), new PointF(ah.this.Uqk.getVRectDefault().left, ah.this.Uqk.getVRectDefault().top));
                ValueAnimator hSm = mVar.hSm();
                hSm.setDuration(1500L);
                hSm.addListener(new C1059b(this, aVar));
                hSm.addUpdateListener(new c(this, aVar));
                ah.this.Uqk.setScaleAndTranslate(mVar);
                ah.this.hwr.postDelayed(new d(this), 1200);
                AppMethodBeat.o(262480);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateRunWishPostedAnimation$1$runAnimation$1$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-festival_release", "com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateRunWishPostedAnimation$1$$special$$inlined$apply$lambda$1"})
            /* renamed from: com.tencent.mm.plugin.festival.finder.ah$b$e$b  reason: collision with other inner class name */
            public static final class C1059b extends AnimatorListenerAdapter {
                final /* synthetic */ kotlin.g.a.a Usj;
                final /* synthetic */ e Uug;
                final /* synthetic */ long tph = 1500;

                C1059b(e eVar, kotlin.g.a.a aVar) {
                    this.Uug = eVar;
                    this.Usj = aVar;
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(262477);
                    this.Usj.invoke();
                    AppMethodBeat.o(262477);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateRunWishPostedAnimation$1$runAnimation$1$1$2", "com/tencent/mm/plugin/festival/finder/FestivalFinderLivePrepareWishPlugin$ScenarioStateMachine$stateRunWishPostedAnimation$1$$special$$inlined$apply$lambda$2"})
            static final class c implements ValueAnimator.AnimatorUpdateListener {
                final /* synthetic */ kotlin.g.a.a Usj;
                final /* synthetic */ e Uug;
                final /* synthetic */ long tph = 1500;

                c(e eVar, kotlin.g.a.a aVar) {
                    this.Uug = eVar;
                    this.Usj = aVar;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(262478);
                    b.C0376b.a(ah.this.hOp, b.c.wMs);
                    AppMethodBeat.o(262478);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            static final class d implements Runnable {
                final /* synthetic */ e Uug;

                d(e eVar) {
                    this.Uug = eVar;
                }

                public final void run() {
                    AppMethodBeat.i(262479);
                    b.C0376b.a(ah.this.hOp, b.c.wMh);
                    AppMethodBeat.o(262479);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
            static final class a extends q implements kotlin.g.a.a<x> {
                final /* synthetic */ e Uug;
                final /* synthetic */ Bundle uxC;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(e eVar, Bundle bundle) {
                    super(0);
                    this.Uug = eVar;
                    this.uxC = bundle;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(262476);
                    ah.this.hOp.statusChange(b.c.wLX, this.uxC);
                    x xVar = x.SXb;
                    AppMethodBeat.o(262476);
                    return xVar;
                }
            }
        }

        @Override // com.tencent.mm.sdk.statemachine.StateMachine
        public final void start() {
            AppMethodBeat.i(262504);
            super.start();
            this.isStarted = true;
            AppMethodBeat.o(262504);
        }

        @Override // com.tencent.mm.sdk.statemachine.StateMachine
        public final void onQuitting() {
            AppMethodBeat.i(262505);
            super.onQuitting();
            this.UtT = true;
            AppMethodBeat.o(262505);
        }

        public final void quitSafely() {
            boolean z = true;
            AppMethodBeat.i(262506);
            Handler handler = getHandler();
            if (handler == null || !handler.hasMessages(-2)) {
                z = false;
            }
            if (z) {
                quit();
                AppMethodBeat.o(262506);
                return;
            }
            quitNow();
            AppMethodBeat.o(262506);
        }

        public static final /* synthetic */ float c(float f2, float f3, float f4, float f5, float f6) {
            return (((f2 - f3) / (f4 - f3)) * (f6 - f5)) + f5;
        }

        public static final /* synthetic */ Animator a(b bVar, kotlin.g.a.b bVar2) {
            AppMethodBeat.i(262510);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 8.9f);
            ofFloat.setDuration(8900L);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.addUpdateListener(new C1054b(bVar, bVar2));
            ofFloat.start();
            p.g(ofFloat, "ValueAnimator.ofFloat(0f…    start()\n            }");
            ValueAnimator valueAnimator = ofFloat;
            AppMethodBeat.o(262510);
            return valueAnimator;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ah(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, w.a aVar, k.a aVar2) {
        super(viewGroup, bVar);
        float fromDPToPix;
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        p.h(aVar, "presenter");
        p.h(aVar2, "canvasPresenter");
        AppMethodBeat.i(262519);
        this.hOp = bVar;
        this.UtL = aVar;
        this.Uqk = aVar2;
        viewGroup.setVisibility(8);
        Context context = this.hwr.getContext();
        p.g(context, "context");
        br brVar = new br(context);
        viewGroup.addView(brVar, new ViewGroup.LayoutParams(-1, -1));
        this.UtA = brVar;
        View findViewById = viewGroup.findViewById(R.id.aib);
        if (findViewById == null) {
            p.hyc();
        }
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) (!(layoutParams instanceof ViewGroup.MarginLayoutParams) ? null : layoutParams);
        findViewById.setOnApplyWindowInsetsListener(new a(findViewById, marginLayoutParams != null ? marginLayoutParams.topMargin : 0));
        findViewById.setVisibility(0);
        this.UtB = findViewById;
        TextView textView = new TextView(this.hwr.getContext());
        textView.setTextColor(-1);
        Context context2 = textView.getContext();
        p.g(context2, "context");
        textView.setTextSize(0, (float) context2.getResources().getDimensionPixelSize(R.dimen.hd));
        textView.setGravity(17);
        textView.setClickable(false);
        Context context3 = textView.getContext();
        p.g(context3, "context");
        textView.setMinHeight(context3.getResources().getDimensionPixelSize(R.dimen.ara));
        viewGroup.addView(textView, new ViewGroup.LayoutParams(-1, -2));
        ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams) ? null : layoutParams2);
        if (marginLayoutParams2 != null) {
            Context context4 = textView.getContext();
            p.g(context4, "context");
            marginLayoutParams2.topMargin = context4.getResources().getDimensionPixelSize(R.dimen.ar_);
            Context context5 = textView.getContext();
            p.g(context5, "context");
            marginLayoutParams2.leftMargin = context5.getResources().getDimensionPixelSize(R.dimen.ar9);
            Context context6 = textView.getContext();
            p.g(context6, "context");
            marginLayoutParams2.rightMargin = context6.getResources().getDimensionPixelSize(R.dimen.ar9);
        }
        com.tencent.mm.plugin.festival.model.c cVar = com.tencent.mm.plugin.festival.model.c.UxA;
        if (com.tencent.mm.plugin.festival.model.c.gFh()) {
            Context context7 = textView.getContext();
            p.g(context7, "context");
            fromDPToPix = (float) context7.getResources().getDimensionPixelSize(R.dimen.cb);
        } else {
            fromDPToPix = (float) com.tencent.mm.cb.a.fromDPToPix(textView.getContext(), 6);
        }
        textView.setShadowLayer(fromDPToPix, 0.0f, 0.0f, android.support.v4.content.b.n(textView.getContext(), R.color.agk));
        this.HZZ = textView;
        ImageView imageView = new ImageView(this.hwr.getContext());
        imageView.setVisibility(8);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(false);
        viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        this.UtC = imageView;
        this.UtE = 1;
        this.UtF = 2;
        this.UtG = 3;
        this.UtH = 4;
        this.UtI = 10;
        this.UtJ = 20;
        this.UtK = "DATA_KEY_RUN_ENTER_ANIMATION";
        AppMethodBeat.o(262519);
    }

    private final boolean fwa() {
        AppMethodBeat.i(262513);
        if (this.UtD != null) {
            b bVar = this.UtD;
            if (bVar == null) {
                p.btv("stateMachine");
            }
            if (bVar.isStarted) {
                b bVar2 = this.UtD;
                if (bVar2 == null) {
                    p.btv("stateMachine");
                }
                if (!bVar2.UtT) {
                    AppMethodBeat.o(262513);
                    return true;
                }
            }
        }
        AppMethodBeat.o(262513);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Landroid/view/WindowInsets;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "Landroid/view/View;", "insets", "onApplyWindowInsets"})
    static final class a implements View.OnApplyWindowInsetsListener {
        final /* synthetic */ int UtM;
        final /* synthetic */ View tCl;

        a(View view, int i2) {
            this.tCl = view;
            this.UtM = i2;
        }

        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            AppMethodBeat.i(262452);
            ViewGroup.LayoutParams layoutParams = this.tCl.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                int i2 = this.UtM;
                p.g(windowInsets, "insets");
                marginLayoutParams.topMargin = i2 + windowInsets.getSystemWindowInsetTop();
            }
            AppMethodBeat.o(262452);
            return windowInsets;
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(262514);
        boolean fwd = fwd();
        AppMethodBeat.o(262514);
        return fwd;
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(262515);
        super.unMount();
        if (fwa()) {
            b bVar = this.UtD;
            if (bVar == null) {
                p.btv("stateMachine");
            }
            bVar.quitSafely();
        }
        this.UtC.setImageDrawable(null);
        AppMethodBeat.o(262515);
    }

    /* access modifiers changed from: package-private */
    public final boolean fwd() {
        AppMethodBeat.i(262516);
        if (fwa()) {
            b bVar = this.UtD;
            if (bVar == null) {
                p.btv("stateMachine");
            }
            bVar.sendMessage(this.UtI);
            AppMethodBeat.o(262516);
            return true;
        }
        AppMethodBeat.o(262516);
        return false;
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(262517);
        p.h(cVar, "status");
        switch (ap.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                if (fwa()) {
                    b bVar = this.UtD;
                    if (bVar == null) {
                        p.btv("stateMachine");
                    }
                    bVar.quitSafely();
                    AppMethodBeat.o(262517);
                    return;
                }
                break;
            case 2:
                e eVar = e.UAo;
                e.reset();
                e.UAh = e.hSe();
                e.awH(1);
                this.UtD = new b();
                b bVar2 = this.UtD;
                if (bVar2 == null) {
                    p.btv("stateMachine");
                }
                bVar2.start();
                AppMethodBeat.o(262517);
                return;
            case 3:
                if (fwa()) {
                    b bVar3 = this.UtD;
                    if (bVar3 == null) {
                        p.btv("stateMachine");
                    }
                    bVar3.sendMessage(this.UtE);
                    AppMethodBeat.o(262517);
                    return;
                }
                b.C0376b.a(this.hOp, b.c.wsW);
                AppMethodBeat.o(262517);
                return;
            case 4:
                if (fwa()) {
                    b bVar4 = this.UtD;
                    if (bVar4 == null) {
                        p.btv("stateMachine");
                    }
                    Message obtainMessage = bVar4.getHandler().obtainMessage(this.UtH);
                    obtainMessage.setData(bundle);
                    obtainMessage.sendToTarget();
                    AppMethodBeat.o(262517);
                    return;
                }
                b.C0376b.a(this.hOp, b.c.wsW);
                AppMethodBeat.o(262517);
                return;
            case 5:
                if (fwa()) {
                    b bVar5 = this.UtD;
                    if (bVar5 == null) {
                        p.btv("stateMachine");
                    }
                    bVar5.sendMessage(this.UtI);
                    AppMethodBeat.o(262517);
                    return;
                }
                b.C0376b.a(this.hOp, b.c.wsW);
                AppMethodBeat.o(262517);
                return;
            case 6:
                if (fwa() && bundle != null) {
                    b bVar6 = this.UtD;
                    if (bVar6 == null) {
                        p.btv("stateMachine");
                    }
                    Message obtainMessage2 = bVar6.getHandler().obtainMessage(this.UtJ);
                    obtainMessage2.getData().putAll(bundle);
                    obtainMessage2.sendToTarget();
                    break;
                }
        }
        AppMethodBeat.o(262517);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(262518);
        if (!fwa()) {
            super.rg(8);
            AppMethodBeat.o(262518);
            return;
        }
        super.rg(i2);
        AppMethodBeat.o(262518);
    }

    public static final /* synthetic */ void a(ah ahVar) {
        AppMethodBeat.i(262520);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(ahVar.hwr.getContext());
        if (!(castActivityOrNull instanceof MMActivity)) {
            castActivityOrNull = null;
        }
        MMActivity mMActivity = (MMActivity) castActivityOrNull;
        if (mMActivity != null) {
            mMActivity.hideVKB();
            AppMethodBeat.o(262520);
            return;
        }
        AppMethodBeat.o(262520);
    }
}
