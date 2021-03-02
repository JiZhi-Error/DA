package com.tencent.mm.plugin.finder.live.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0013\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010-\u001a\u00020&H\u0002J\u0018\u0010.\u001a\u00020&2\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020&\u0018\u000100J\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0006\u00105\u001a\u00020&J\u0018\u00106\u001a\u00020&2\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020&\u0018\u000100R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R7\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_TRANSLATION_Y", "DIRECTION_LEFT", "DIRECTION_RIGHT", "MAX_OFFSET", "MIN_OFFSET", "TAG", "", "animationListener", "com/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer$animationListener$1", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer$animationListener$1;", "animationUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", TencentLocation.EXTRA_DIRECTION, "dividingLine", "maxTransX", "maxTransY", "minTransX", "minTransY", "offsetX", "", "offsetY", "onClick", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "touchDownTimestamp", "", "animToEdge", "hideStatePanel", "animationEnd", "Lkotlin/Function0;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "resetDefaultLayout", "showStatePanel", "plugin-finder_release"})
public final class FinderLiveLinkMicStateContainer extends RelativeLayout {
    private final int DIRECTION_LEFT;
    private final int DIRECTION_RIGHT;
    private final String TAG;
    private int direction;
    private final int uyV;
    private final int uyW;
    private final int uyX;
    private int uyY;
    private int uyZ;
    private int uza;
    private int uzb;
    private float uzc;
    private float uzd;
    private int uze;
    private long uzf;
    private final a uzg;
    private final ValueAnimator.AnimatorUpdateListener uzh;
    private kotlin.g.a.b<? super View, x> uzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveLinkMicStateContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        float f2;
        p.h(context, "context");
        AppMethodBeat.i(247489);
        this.TAG = "Finder.FinderLiveLinkMicStateContainer";
        this.uyW = au.az(context).x;
        this.DIRECTION_LEFT = 1;
        this.uyX = at.fromDPToPix(context, 116);
        this.direction = this.DIRECTION_RIGHT;
        this.uzg = new a(this, context);
        this.uzh = new b(this);
        setNestedScrollingEnabled(true);
        setActivated(true);
        setClickable(true);
        if (this.direction == this.DIRECTION_RIGHT) {
            f2 = ((float) au.az(context).x) / 2.0f;
        } else {
            f2 = -(((float) au.az(context).x) / 2.0f);
        }
        setTranslationX(f2);
        AppMethodBeat.o(247489);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer$animationListener$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ Context $context;
        final /* synthetic */ FinderLiveLinkMicStateContainer uzj;

        a(FinderLiveLinkMicStateContainer finderLiveLinkMicStateContainer, Context context) {
            this.uzj = finderLiveLinkMicStateContainer;
            this.$context = context;
        }

        public final void onAnimationEnd(Animator animator) {
            Drawable drawable;
            AppMethodBeat.i(247475);
            FinderLiveLinkMicStateContainer finderLiveLinkMicStateContainer = this.uzj;
            if (this.uzj.direction == this.uzj.DIRECTION_RIGHT) {
                drawable = this.$context.getResources().getDrawable(R.drawable.a13);
            } else {
                drawable = this.$context.getResources().getDrawable(R.drawable.a12);
            }
            finderLiveLinkMicStateContainer.setBackground(drawable);
            AppMethodBeat.o(247475);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(247476);
            if (this.uzj.direction == this.uzj.DIRECTION_RIGHT) {
                this.uzj.setTranslationX((float) this.uzj.uyZ);
                this.uzj.setBackground(this.$context.getResources().getDrawable(R.drawable.a13));
                AppMethodBeat.o(247476);
                return;
            }
            this.uzj.setTranslationX((float) this.uzj.uyY);
            this.uzj.setBackground(this.$context.getResources().getDrawable(R.drawable.a12));
            AppMethodBeat.o(247476);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FinderLiveLinkMicStateContainer uzj;

        b(FinderLiveLinkMicStateContainer finderLiveLinkMicStateContainer) {
            this.uzj = finderLiveLinkMicStateContainer;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(247477);
            ViewGroup.LayoutParams layoutParams = this.uzj.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(247477);
                throw tVar;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(247477);
                throw tVar2;
            }
            marginLayoutParams.setMarginEnd(((Integer) animatedValue).intValue());
            this.uzj.requestLayout();
            AppMethodBeat.o(247477);
        }
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super android.view.View, kotlin.x>, kotlin.g.a.b<android.view.View, kotlin.x> */
    public final kotlin.g.a.b<View, x> getOnClick() {
        return this.uzi;
    }

    public final void setOnClick(kotlin.g.a.b<? super View, x> bVar) {
        this.uzi = bVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FinderLiveLinkMicStateContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(247490);
        AppMethodBeat.o(247490);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        kotlin.g.a.b<? super View, x> bVar;
        AppMethodBeat.i(247484);
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getActionMasked()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.uzc = motionEvent.getRawX() - ((float) getLeft());
            this.uzd = motionEvent.getRawY() - ((float) getTop());
            this.uza = 0;
            this.uzb = au.az(getContext()).y - getMeasuredHeight();
            this.uyY = 0;
            this.uyZ = au.az(getContext()).x - getMeasuredWidth();
            this.uze = au.az(getContext()).x / 2;
            this.uzf = System.currentTimeMillis();
            Context context = getContext();
            p.g(context, "context");
            setBackground(context.getResources().getDrawable(R.drawable.a11));
            startNestedScroll(2);
        } else if (valueOf != null && valueOf.intValue() == 2) {
            Log.i(this.TAG, "x:" + motionEvent.getX() + " y:" + motionEvent.getY() + " rawx:" + motionEvent.getRawX() + " rawy:" + motionEvent.getRawY());
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (j.aI((float) this.uyV, j.aJ((float) this.uyW, ((float) getLeft()) + (((float) getMeasuredWidth()) / 2.0f))) > ((float) this.uze)) {
                this.direction = this.DIRECTION_RIGHT;
            } else {
                this.direction = this.DIRECTION_LEFT;
            }
            float aI = j.aI((float) this.uyY, j.aJ((float) this.uyZ, (((float) au.az(getContext()).x) - rawX) - this.uzc));
            float aI2 = j.aI((float) this.uza, j.aJ((float) this.uzb, rawY - this.uzd));
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(247484);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd((int) aI);
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(247484);
                throw tVar2;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) aI2;
            requestLayout();
        } else {
            if (valueOf == null || valueOf.intValue() != 3) {
                if (valueOf != null && valueOf.intValue() == 1) {
                    if (System.currentTimeMillis() - this.uzf < ((long) ViewConfiguration.getTapTimeout()) && (bVar = this.uzi) != null) {
                        bVar.invoke(this);
                    }
                }
            }
            ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
            if (layoutParams3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(247484);
                throw tVar3;
            }
            int marginEnd = ((ViewGroup.MarginLayoutParams) layoutParams3).getMarginEnd();
            if (this.direction == this.DIRECTION_RIGHT) {
                ValueAnimator duration = ObjectAnimator.ofInt(marginEnd, this.uyY).setDuration(100L);
                duration.addListener(this.uzg);
                duration.addUpdateListener(this.uzh);
                duration.start();
            } else {
                ValueAnimator duration2 = ObjectAnimator.ofInt(marginEnd, this.uyZ).setDuration(100L);
                duration2.addListener(this.uzg);
                duration2.addUpdateListener(this.uzh);
                duration2.start();
            }
            this.uzf = 0;
            this.uze = 0;
            stopNestedScroll();
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(247484);
        return onTouchEvent;
    }

    public final void diw() {
        AppMethodBeat.i(247485);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(247485);
            throw tVar;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.uyX;
        AppMethodBeat.o(247485);
    }

    public static /* synthetic */ void a(FinderLiveLinkMicStateContainer finderLiveLinkMicStateContainer) {
        AppMethodBeat.i(247487);
        finderLiveLinkMicStateContainer.Q(null);
        AppMethodBeat.o(247487);
    }

    public final void Q(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(247486);
        animate().translationX(0.0f).setListener(new e(this, aVar)).setDuration(500).start();
        AppMethodBeat.o(247486);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer$showStatePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
    public static final class e extends AnimatorListenerAdapter {
        final /* synthetic */ FinderLiveLinkMicStateContainer uzj;
        final /* synthetic */ kotlin.g.a.a uzk;

        e(FinderLiveLinkMicStateContainer finderLiveLinkMicStateContainer, kotlin.g.a.a aVar) {
            this.uzj = finderLiveLinkMicStateContainer;
            this.uzk = aVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(247482);
            this.uzj.bringToFront();
            kotlin.g.a.a aVar = this.uzk;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(247482);
                return;
            }
            AppMethodBeat.o(247482);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(247483);
            this.uzj.bringToFront();
            kotlin.g.a.a aVar = this.uzk;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(247483);
                return;
            }
            AppMethodBeat.o(247483);
        }
    }

    public final void R(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(247488);
        if (this.direction == this.DIRECTION_RIGHT) {
            animate().translationX((float) getMeasuredWidth()).setDuration(500).setListener(new c(this, aVar)).start();
            AppMethodBeat.o(247488);
            return;
        }
        animate().translationX(((float) this.uyY) - ((float) getMeasuredWidth())).setDuration(500).setListener(new d(this)).start();
        AppMethodBeat.o(247488);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer$hideStatePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ FinderLiveLinkMicStateContainer uzj;
        final /* synthetic */ kotlin.g.a.a uzk;

        c(FinderLiveLinkMicStateContainer finderLiveLinkMicStateContainer, kotlin.g.a.a aVar) {
            this.uzj = finderLiveLinkMicStateContainer;
            this.uzk = aVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(247478);
            kotlin.g.a.a aVar = this.uzk;
            if (aVar != null) {
                aVar.invoke();
            }
            ViewGroup.LayoutParams layoutParams = this.uzj.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(247478);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.uzj.uyX;
            this.uzj.direction = this.uzj.DIRECTION_RIGHT;
            AppMethodBeat.o(247478);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(247479);
            kotlin.g.a.a aVar = this.uzk;
            if (aVar != null) {
                aVar.invoke();
            }
            ViewGroup.LayoutParams layoutParams = this.uzj.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(247479);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.uzj.uyX;
            this.uzj.direction = this.uzj.DIRECTION_RIGHT;
            AppMethodBeat.o(247479);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer$hideStatePanel$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
    public static final class d extends AnimatorListenerAdapter {
        final /* synthetic */ FinderLiveLinkMicStateContainer uzj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderLiveLinkMicStateContainer finderLiveLinkMicStateContainer) {
            this.uzj = finderLiveLinkMicStateContainer;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(247480);
            this.uzj.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.uzj.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(247480);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.uzj.uyX;
            ViewGroup.LayoutParams layoutParams2 = this.uzj.getLayoutParams();
            if (layoutParams2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(247480);
                throw tVar2;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginEnd(0);
            this.uzj.setTranslationX(((float) au.az(this.uzj.getContext()).x) / 2.0f);
            FinderLiveLinkMicStateContainer finderLiveLinkMicStateContainer = this.uzj;
            Context context = this.uzj.getContext();
            p.g(context, "context");
            finderLiveLinkMicStateContainer.setBackground(context.getResources().getDrawable(R.drawable.a13));
            this.uzj.direction = this.uzj.DIRECTION_RIGHT;
            AppMethodBeat.o(247480);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(247481);
            this.uzj.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.uzj.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(247481);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.uzj.uyX;
            ViewGroup.LayoutParams layoutParams2 = this.uzj.getLayoutParams();
            if (layoutParams2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(247481);
                throw tVar2;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginEnd(0);
            this.uzj.setTranslationX(((float) au.az(this.uzj.getContext()).x) / 2.0f);
            FinderLiveLinkMicStateContainer finderLiveLinkMicStateContainer = this.uzj;
            Context context = this.uzj.getContext();
            p.g(context, "context");
            finderLiveLinkMicStateContainer.setBackground(context.getResources().getDrawable(R.drawable.a13));
            this.uzj.direction = this.uzj.DIRECTION_RIGHT;
            AppMethodBeat.o(247481);
        }
    }
}
