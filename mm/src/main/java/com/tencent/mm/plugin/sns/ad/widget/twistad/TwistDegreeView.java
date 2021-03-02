package com.tencent.mm.plugin.sns.ad.widget.twistad;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class TwistDegreeView extends View {
    protected RectF DCb;
    protected int DCc;
    protected int DCd;
    protected int DCe;
    protected int DCf;
    protected int DCg;
    protected int DCh;
    protected Paint DCi;
    protected Paint DCj;
    protected Paint DCk;
    protected Paint DCl;
    protected Paint DCm;
    protected Paint DCn;
    protected float DCo = 0.9f;
    protected int DCp = 0;
    protected int atS;
    protected int atT;

    public TwistDegreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(202528);
        setLayerType(1, null);
        this.DCc = a.fromDPToPix(context, 50);
        this.DCd = a.fromDPToPix(context, 7);
        this.DCe = a.fromDPToPix(context, 7);
        this.DCh = a.fromDPToPix(context, 14);
        this.DCg = a.fromDPToPix(context, 4);
        this.DCf = a.fromDPToPix(context, 3);
        this.atT = a.fromDPToPix(context, 1);
        this.DCi = new Paint();
        this.DCi.setColor(Color.parseColor("#99FFFFFF"));
        this.DCi.setAntiAlias(true);
        this.DCi.setDither(true);
        this.DCi.setStyle(Paint.Style.STROKE);
        this.DCi.setStrokeCap(Paint.Cap.ROUND);
        this.DCi.setStrokeWidth((float) this.DCd);
        this.DCm = new Paint();
        this.DCm.setColor(Color.parseColor("#99FFFFFF"));
        this.DCm.setAntiAlias(true);
        this.DCm.setDither(true);
        this.DCj = new Paint();
        this.DCj.setColor(Color.parseColor("#4DFFFFFF"));
        this.DCj.setAntiAlias(true);
        this.DCj.setDither(true);
        this.DCk = new Paint();
        this.DCk.setColor(Color.parseColor("#FFFFFF"));
        this.DCk.setAntiAlias(true);
        this.DCk.setDither(true);
        this.DCk.setStyle(Paint.Style.STROKE);
        this.DCk.setStrokeCap(Paint.Cap.ROUND);
        this.DCk.setStrokeWidth((float) this.DCe);
        this.DCn = new Paint();
        this.DCn.setColor(Color.parseColor("#FFFFFF"));
        this.DCn.setAntiAlias(true);
        this.DCn.setDither(true);
        this.DCl = new Paint();
        this.DCl.setColor(Color.parseColor("#CCFFFFFF"));
        this.DCl.setAntiAlias(true);
        this.DCl.setDither(true);
        float f2 = (float) (this.DCd / 2);
        this.DCb = new RectF(f2, f2, ((float) (this.DCc * 2)) - f2, ((float) (this.DCc * 2)) - f2);
        AppMethodBeat.o(202528);
    }

    public void setProgress(float f2) {
        float f3 = 1.0f;
        float f4 = 0.0f;
        AppMethodBeat.i(202529);
        if (f2 > 0.0f) {
            f4 = f2;
        }
        if (f4 <= 1.0f) {
            f3 = f4;
        }
        this.DCo = f3 * 90.0f;
        if (this.DCo < 0.9f) {
            this.DCo = 0.9f;
        }
        invalidate();
        AppMethodBeat.o(202529);
    }

    public void setShowMode(int i2) {
        AppMethodBeat.i(202530);
        this.DCp = i2;
        postInvalidate();
        AppMethodBeat.o(202530);
    }

    public final void eYR() {
        AppMethodBeat.i(202531);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ad.widget.twistad.TwistDegreeView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(202527);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(TwistDegreeView.this.DCo, 0.9f);
                ofFloat.setDuration(150L);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.plugin.sns.ad.widget.twistad.TwistDegreeView.AnonymousClass1.AnonymousClass1 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(202526);
                        TwistDegreeView.this.DCo = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        TwistDegreeView.this.invalidate();
                        AppMethodBeat.o(202526);
                    }
                });
                ofFloat.start();
                AppMethodBeat.o(202527);
            }
        });
        AppMethodBeat.o(202531);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(202532);
        double radians = Math.toRadians(45.0d);
        int sin = (int) (((double) this.DCc) - (((double) this.DCc) * Math.sin(radians)));
        this.atS = (int) ((((double) this.DCc) - (Math.cos(radians) * ((double) this.DCc))) - ((double) (this.DCd / 2)));
        setMeasuredDimension(this.DCd + ((int) (((double) (this.DCc * 2)) * Math.cos(radians))), this.DCd + sin + (this.atT * 2));
        invalidate();
        AppMethodBeat.o(202532);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(202533);
        if (this.DCb != null) {
            canvas.save();
            canvas.translate((float) (-this.atS), (float) this.atT);
            canvas.drawArc(this.DCb, 225.0f, 90.0f, false, this.DCi);
            b(canvas, this.DCm);
            float f2 = this.DCo;
            if (this.DCp == 0) {
                canvas.drawArc(this.DCb, 315.0f - f2, f2, false, this.DCk);
            } else {
                canvas.drawArc(this.DCb, 225.0f, f2, false, this.DCk);
            }
            if (this.DCo >= 86.4f) {
                b(canvas, this.DCn);
            }
            canvas.restore();
        }
        AppMethodBeat.o(202533);
    }

    private void b(Canvas canvas, Paint paint) {
        AppMethodBeat.i(202534);
        Path triangle$191b16f3 = getTriangle$191b16f3();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        canvas.drawPath(triangle$191b16f3, paint);
        AppMethodBeat.o(202534);
    }

    private Path getTriangle$191b16f3() {
        Point point;
        Point point2;
        Point point3;
        AppMethodBeat.i(202535);
        double radians = Math.toRadians(45.0d);
        if (this.DCp == 0) {
            radians = Math.toRadians(135.0d);
        }
        int cos = (int) (((double) this.DCc) + (((double) (this.DCc - (this.DCd / 2))) * Math.cos(radians)));
        int sin = (int) (((double) this.DCc) - (Math.sin(radians) * ((double) (this.DCc - (this.DCd / 2)))));
        int i2 = this.DCh / 2;
        if (this.DCp == 0) {
            point = new Point(cos - i2, sin + i2);
            point2 = new Point(cos + i2, sin + i2);
            point3 = new Point(cos - i2, sin - i2);
        } else {
            point = new Point(cos - i2, sin + i2);
            point2 = new Point(cos + i2, sin + i2);
            point3 = new Point(cos + i2, sin - i2);
        }
        Path path = new Path();
        path.moveTo((float) point.x, (float) point.y);
        path.lineTo((float) point2.x, (float) point2.y);
        path.lineTo((float) point3.x, (float) point3.y);
        path.close();
        AppMethodBeat.o(202535);
        return path;
    }
}
