package com.tencent.mm.plugin.sns.ad.widget.a;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends View {
    protected Paint DAX = new Paint();
    protected RectF DAZ;
    protected ValueAnimator.AnimatorUpdateListener DBa = new ValueAnimator.AnimatorUpdateListener() {
        /* class com.tencent.mm.plugin.sns.ad.widget.a.b.AnonymousClass1 */

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(202445);
            try {
                b.this.HH = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.invalidate();
                AppMethodBeat.o(202445);
            } catch (Exception e2) {
                AppMethodBeat.o(202445);
            }
        }
    };
    protected int HH;
    protected AnimatorSet xc;

    public b(Context context) {
        super(context);
        AppMethodBeat.i(202446);
        this.DAX.setColor(Color.parseColor("#FFEDEDED"));
        this.DAX.setAntiAlias(true);
        this.DAX.setDither(true);
        this.DAX.setStyle(Paint.Style.STROKE);
        AppMethodBeat.o(202446);
    }

    public final void ax(int i2, int i3, int i4) {
        AppMethodBeat.i(202447);
        clear();
        int i5 = i4 / 2;
        this.DAZ = new RectF((float) i5, (float) i5, (float) ((i3 * 2) - i5), (float) ((i3 * 2) - i5));
        this.DAX.setStrokeWidth((float) i4);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 362);
        ofInt.setDuration((long) i2);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(this.DBa);
        this.xc = new AnimatorSet();
        this.xc.playSequentially(ofInt);
        this.xc.start();
        AppMethodBeat.o(202447);
    }

    public final void clear() {
        AppMethodBeat.i(202448);
        if (this.xc != null) {
            this.xc.cancel();
        }
        this.HH = 0;
        invalidate();
        AppMethodBeat.o(202448);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(202449);
        if (this.DAZ != null) {
            canvas.drawArc(this.DAZ, -90.0f, (float) this.HH, false, this.DAX);
        }
        AppMethodBeat.o(202449);
    }
}
