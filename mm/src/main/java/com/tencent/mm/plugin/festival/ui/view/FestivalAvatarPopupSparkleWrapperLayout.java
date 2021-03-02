package com.tencent.mm.plugin.festival.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

public final class FestivalAvatarPopupSparkleWrapperLayout extends FrameLayout {
    public static final a UEN = new a((byte) 0);
    final RectF UEE = new RectF();
    final RectF UEF = new RectF();
    private final RectF UEG = new RectF();
    private float UEH;
    Animator UEI;
    private final int[] UEJ;
    private final float UEK;
    public final float UEL = 1.0f;
    final long UEM = TimeUnit.SECONDS.toMillis(1);
    private final Paint paint;

    static {
        AppMethodBeat.i(263364);
        AppMethodBeat.o(263364);
    }

    public static final class f extends q implements kotlin.g.a.a<x> {
        public static final f UEP = new f();

        static {
            AppMethodBeat.i(263351);
            AppMethodBeat.o(263351);
        }

        f() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public static final /* synthetic */ void a(FestivalAvatarPopupSparkleWrapperLayout festivalAvatarPopupSparkleWrapperLayout, float f2) {
        AppMethodBeat.i(263365);
        festivalAvatarPopupSparkleWrapperLayout.setDrawScale(f2);
        AppMethodBeat.o(263365);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalAvatarPopupSparkleWrapperLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(263362);
        setWillNotDraw(false);
        setLayerType(1, null);
        Context context2 = getContext();
        p.g(context2, "context");
        this.UEK = ((float) context2.getResources().getDimensionPixelSize(R.dimen.aqp)) + 20.0f;
        this.UEJ = new int[]{android.support.v4.content.b.n(getContext(), R.color.BW_100_Alpha_0_1), android.support.v4.content.b.n(getContext(), R.color.BW_100_Alpha_0_3), android.support.v4.content.b.n(getContext(), R.color.BW_100_Alpha_0_5), android.support.v4.content.b.n(getContext(), R.color.BW_100_Alpha_0_6)};
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setMaskFilter(new BlurMaskFilter(40.0f, BlurMaskFilter.Blur.NORMAL));
        this.paint = paint2;
        AppMethodBeat.o(263362);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalAvatarPopupSparkleWrapperLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(263363);
        setWillNotDraw(false);
        setLayerType(1, null);
        Context context2 = getContext();
        p.g(context2, "context");
        this.UEK = ((float) context2.getResources().getDimensionPixelSize(R.dimen.aqp)) + 20.0f;
        this.UEJ = new int[]{android.support.v4.content.b.n(getContext(), R.color.BW_100_Alpha_0_1), android.support.v4.content.b.n(getContext(), R.color.BW_100_Alpha_0_3), android.support.v4.content.b.n(getContext(), R.color.BW_100_Alpha_0_5), android.support.v4.content.b.n(getContext(), R.color.BW_100_Alpha_0_6)};
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setMaskFilter(new BlurMaskFilter(40.0f, BlurMaskFilter.Blur.NORMAL));
        this.paint = paint2;
        AppMethodBeat.o(263363);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void setDrawScale(float f2) {
        AppMethodBeat.i(263352);
        if (f2 != this.UEH) {
            this.UEH = f2;
            u.X(this);
        }
        AppMethodBeat.o(263352);
    }

    public final float getDRAW_MIN_SCALE() {
        AppMethodBeat.i(263353);
        if (this.UEF.isEmpty() || this.UEE.isEmpty()) {
            AppMethodBeat.o(263353);
            return 0.0f;
        }
        float p = android.support.v4.b.a.p((this.UEE.width() / this.UEF.width()) + 0.1f, 0.8f, 0.9f);
        AppMethodBeat.o(263353);
        return p;
    }

    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(263354);
        super.onMeasure(i2, i3);
        float min = (float) Math.min(getMeasuredWidth(), getMeasuredHeight());
        this.UEE.set(0.0f, 0.0f, min, min);
        float width = this.UEE.width() + (this.UEK * 2.0f);
        this.UEF.set(0.0f, 0.0f, width, width);
        setMeasuredDimension(kotlin.h.a.cR(this.UEF.width()), kotlin.h.a.cR(this.UEF.width()));
        AppMethodBeat.o(263354);
    }

    public final void onDetachedFromWindow() {
        AppMethodBeat.i(263355);
        super.onDetachedFromWindow();
        Animator animator = this.UEI;
        if (animator != null) {
            animator.cancel();
            AppMethodBeat.o(263355);
            return;
        }
        AppMethodBeat.o(263355);
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AppMethodBeat.i(263356);
        FrameLayout.LayoutParams generateLayoutParams = super.generateLayoutParams(attributeSet);
        generateLayoutParams.gravity = 17;
        p.g(generateLayoutParams, "super.generateLayoutPara… Gravity.CENTER\n        }");
        AppMethodBeat.o(263356);
        return generateLayoutParams;
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.i(263358);
        FrameLayout.LayoutParams generateDefaultLayoutParams = super.generateDefaultLayoutParams();
        generateDefaultLayoutParams.gravity = 17;
        p.g(generateDefaultLayoutParams, "super.generateDefaultLay… Gravity.CENTER\n        }");
        AppMethodBeat.o(263358);
        return generateDefaultLayoutParams;
    }

    static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FestivalAvatarPopupSparkleWrapperLayout UEO;

        b(FestivalAvatarPopupSparkleWrapperLayout festivalAvatarPopupSparkleWrapperLayout) {
            this.UEO = festivalAvatarPopupSparkleWrapperLayout;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(263345);
            FestivalAvatarPopupSparkleWrapperLayout festivalAvatarPopupSparkleWrapperLayout = this.UEO;
            p.g(valueAnimator, "animator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(263345);
                throw tVar;
            }
            FestivalAvatarPopupSparkleWrapperLayout.a(festivalAvatarPopupSparkleWrapperLayout, ((Float) animatedValue).floatValue());
            AppMethodBeat.o(263345);
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ FestivalAvatarPopupSparkleWrapperLayout UEO;

        c(FestivalAvatarPopupSparkleWrapperLayout festivalAvatarPopupSparkleWrapperLayout) {
            this.UEO = festivalAvatarPopupSparkleWrapperLayout;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(263346);
            this.UEO.UEI = null;
            AppMethodBeat.o(263346);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(263347);
            this.UEO.UEI = null;
            AppMethodBeat.o(263347);
        }
    }

    public static /* synthetic */ void a(FestivalAvatarPopupSparkleWrapperLayout festivalAvatarPopupSparkleWrapperLayout) {
        AppMethodBeat.i(263361);
        f fVar = f.UEP;
        p.h(fVar, "onEnd");
        Animator animator = festivalAvatarPopupSparkleWrapperLayout.UEI;
        if (animator != null) {
            animator.cancel();
        }
        if (festivalAvatarPopupSparkleWrapperLayout.UEF.isEmpty() || festivalAvatarPopupSparkleWrapperLayout.UEE.isEmpty()) {
            fVar.invoke();
            AppMethodBeat.o(263361);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(festivalAvatarPopupSparkleWrapperLayout.UEH, festivalAvatarPopupSparkleWrapperLayout.getDRAW_MIN_SCALE());
        ofFloat.setRepeatCount(0);
        ofFloat.setDuration(kotlin.h.a.L((double) (((festivalAvatarPopupSparkleWrapperLayout.UEH - festivalAvatarPopupSparkleWrapperLayout.getDRAW_MIN_SCALE()) / (festivalAvatarPopupSparkleWrapperLayout.UEL - festivalAvatarPopupSparkleWrapperLayout.getDRAW_MIN_SCALE())) * ((float) festivalAvatarPopupSparkleWrapperLayout.UEM))));
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(new d(festivalAvatarPopupSparkleWrapperLayout, fVar));
        ofFloat.addListener(new e(festivalAvatarPopupSparkleWrapperLayout, fVar));
        ofFloat.start();
        festivalAvatarPopupSparkleWrapperLayout.UEI = ofFloat;
        AppMethodBeat.o(263361);
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FestivalAvatarPopupSparkleWrapperLayout UEO;
        final /* synthetic */ kotlin.g.a.a Usj;

        d(FestivalAvatarPopupSparkleWrapperLayout festivalAvatarPopupSparkleWrapperLayout, kotlin.g.a.a aVar) {
            this.UEO = festivalAvatarPopupSparkleWrapperLayout;
            this.Usj = aVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(263348);
            FestivalAvatarPopupSparkleWrapperLayout festivalAvatarPopupSparkleWrapperLayout = this.UEO;
            p.g(valueAnimator, "animator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(263348);
                throw tVar;
            }
            FestivalAvatarPopupSparkleWrapperLayout.a(festivalAvatarPopupSparkleWrapperLayout, ((Float) animatedValue).floatValue());
            AppMethodBeat.o(263348);
        }
    }

    public static final class e extends AnimatorListenerAdapter {
        final /* synthetic */ FestivalAvatarPopupSparkleWrapperLayout UEO;
        final /* synthetic */ kotlin.g.a.a Usj;

        e(FestivalAvatarPopupSparkleWrapperLayout festivalAvatarPopupSparkleWrapperLayout, kotlin.g.a.a aVar) {
            this.UEO = festivalAvatarPopupSparkleWrapperLayout;
            this.Usj = aVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(263349);
            p.h(animator, "animation");
            this.Usj.invoke();
            this.UEO.UEI = null;
            AppMethodBeat.o(263349);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(263350);
            p.h(animator, "animation");
            this.Usj.invoke();
            this.UEO.UEI = null;
            AppMethodBeat.o(263350);
        }
    }

    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(263360);
        p.h(canvas, "canvas");
        if (this.UEH > 0.0f) {
            float length = this.UEK / ((float) this.UEJ.length);
            float width = ((this.UEF.width() * (1.0f - this.UEH)) / 2.0f) + (length / 2.0f) + 20.0f;
            this.UEG.set(this.UEF);
            this.UEG.left += width;
            this.UEG.top += width;
            this.UEG.right -= width;
            this.UEG.bottom -= width;
            for (int i2 : this.UEJ) {
                this.paint.setColor(i2);
                canvas.drawOval(this.UEG, this.paint);
                this.UEG.left += length;
                this.UEG.top += length;
                this.UEG.right -= length;
                this.UEG.bottom -= length;
                if (this.UEG.isEmpty()) {
                    break;
                }
            }
        }
        super.onDraw(canvas);
        AppMethodBeat.o(263360);
    }
}
