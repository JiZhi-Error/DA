package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Keep;
import android.support.v4.view.b.f;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;

public final class CircleProgressDrawable extends Drawable {
    private static final RectF FVF = new RectF(-21.0f, -21.0f, 21.0f, 21.0f);
    private static final RectF FVG = new RectF(-19.0f, -19.0f, 19.0f, 19.0f);
    private int FVM;
    private boolean FVN = false;
    private int FVO = 0;
    private RingPathTransform FVP = new RingPathTransform((byte) 0);
    private RingRotation FVW = new RingRotation((byte) 0);
    private Paint mPaint;
    private int mStrokeColor = WebView.NIGHT_MODE_COLOR;
    private int mStrokeWidth = 4;
    private ArrayList<Animator> xd;

    static {
        AppMethodBeat.i(131466);
        AppMethodBeat.o(131466);
    }

    public CircleProgressDrawable(Context context) {
        AppMethodBeat.i(131457);
        this.FVM = Math.round(context.getResources().getDisplayMetrics().density * 48.0f);
        this.xd = new ArrayList<>();
        AppMethodBeat.o(131457);
    }

    public final void setStrokeColor(int i2) {
        AppMethodBeat.i(131458);
        this.mStrokeColor = i2;
        invalidateSelf();
        AppMethodBeat.o(131458);
    }

    public final void cbk() {
        AppMethodBeat.i(131459);
        stop();
        this.xd.clear();
        this.xd.add(a(this.FVP));
        this.xd.add(a(this.FVW));
        AppMethodBeat.o(131459);
    }

    public final void start() {
        AppMethodBeat.i(131460);
        if (isStarted()) {
            AppMethodBeat.o(131460);
            return;
        }
        Iterator<Animator> it = this.xd.iterator();
        while (it.hasNext()) {
            it.next().start();
        }
        invalidateSelf();
        AppMethodBeat.o(131460);
    }

    private boolean isStarted() {
        AppMethodBeat.i(131461);
        Iterator<Animator> it = this.xd.iterator();
        while (it.hasNext()) {
            if (it.next().isStarted()) {
                AppMethodBeat.o(131461);
                return true;
            }
        }
        AppMethodBeat.o(131461);
        return false;
    }

    public final void stop() {
        AppMethodBeat.i(131462);
        Iterator<Animator> it = this.xd.iterator();
        while (it.hasNext()) {
            it.next().end();
        }
        AppMethodBeat.o(131462);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(131463);
        Rect bounds = getBounds();
        if (bounds.width() == 0 || bounds.height() == 0) {
            AppMethodBeat.o(131463);
            return;
        }
        if (this.mPaint == null) {
            this.mPaint = new Paint();
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth((float) this.mStrokeWidth);
            this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
            this.mPaint.setStrokeJoin(Paint.Join.MITER);
        }
        int save = canvas.save();
        canvas.translate((float) bounds.left, (float) bounds.top);
        int width = bounds.width();
        int height = bounds.height();
        Paint paint = this.mPaint;
        canvas.scale(((float) width) / FVF.width(), ((float) height) / FVF.height());
        canvas.translate(FVF.width() / 2.0f, FVF.height() / 2.0f);
        if (this.FVN) {
            int save2 = canvas.save();
            paint.setColor(this.FVO);
            canvas.drawArc(FVG, 0.0f, 360.0f, false, paint);
            canvas.restoreToCount(save2);
        }
        int save3 = canvas.save();
        paint.setColor(this.mStrokeColor);
        canvas.rotate(this.FVW.SM);
        canvas.drawArc(FVG, -90.0f + ((this.FVP.xD + this.FVP.xB) * 360.0f), 360.0f * (this.FVP.xC - this.FVP.xB), false, paint);
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
        AppMethodBeat.o(131463);
    }

    public final void setAlpha(int i2) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return -3;
    }

    /* access modifiers changed from: package-private */
    public static class RingPathTransform {
        public float xB;
        public float xC;
        public float xD;

        private RingPathTransform() {
            this.xB = 0.0f;
            this.xC = 0.0f;
            this.xD = 0.0f;
        }

        /* synthetic */ RingPathTransform(byte b2) {
            this();
        }

        @Keep
        public void setTrimPathStart(float f2) {
            this.xB = f2;
        }

        @Keep
        public void setTrimPathEnd(float f2) {
            this.xC = f2;
        }

        @Keep
        public void setTrimPathOffset(float f2) {
            this.xD = f2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class RingRotation {
        private float SM;

        private RingRotation() {
        }

        /* synthetic */ RingRotation(byte b2) {
            this();
        }

        @Keep
        public void setRotation(float f2) {
            this.SM = f2;
        }
    }

    private static Animator a(RingPathTransform ringPathTransform) {
        AppMethodBeat.i(131464);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(ringPathTransform, "trimPathStart", 0.0f, 0.75f);
        ofFloat.setDuration(1333L);
        ofFloat.setInterpolator(c.olo);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(ringPathTransform, "trimPathEnd", 0.0f, 0.75f);
        ofFloat2.setDuration(1333L);
        ofFloat2.setInterpolator(b.olo);
        ofFloat2.setRepeatCount(-1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(ringPathTransform, "trimPathOffset", 0.0f, 0.25f);
        ofFloat3.setDuration(1333L);
        ofFloat3.setInterpolator(a.olo);
        ofFloat3.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        AppMethodBeat.o(131464);
        return animatorSet;
    }

    private static Animator a(RingRotation ringRotation) {
        AppMethodBeat.i(131465);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(ringRotation, "rotation", 0.0f, 720.0f);
        ofFloat.setDuration(6665L);
        ofFloat.setInterpolator(a.olo);
        ofFloat.setRepeatCount(-1);
        AppMethodBeat.o(131465);
        return ofFloat;
    }

    /* access modifiers changed from: package-private */
    public static class c {
        public static final Interpolator olo = f.c(olq);
        private static final Path olq;

        static {
            AppMethodBeat.i(131456);
            Path path = new Path();
            olq = path;
            path.lineTo(0.5f, 0.0f);
            olq.cubicTo(0.7f, 0.0f, 0.6f, 1.0f, 1.0f, 1.0f);
            AppMethodBeat.o(131456);
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public static final Interpolator olo = f.c(olp);
        private static final Path olp;

        static {
            AppMethodBeat.i(131455);
            Path path = new Path();
            olp = path;
            path.cubicTo(0.2f, 0.0f, 0.1f, 1.0f, 0.5f, 1.0f);
            olp.lineTo(1.0f, 1.0f);
            AppMethodBeat.o(131455);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public static final Interpolator olo = new LinearInterpolator();

        static {
            AppMethodBeat.i(131454);
            AppMethodBeat.o(131454);
        }
    }

    public final int getIntrinsicWidth() {
        return this.FVM;
    }

    public final int getIntrinsicHeight() {
        return this.FVM;
    }
}
