package com.tencent.mm.c;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.e.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends b {
    private int dgM = 200;
    private ValueAnimator dgN;
    c dgO;
    private float dgP;
    private float dgQ;
    private float dgR;
    Rect dgS;
    private RectF dgT;
    Matrix dgU;
    public long dgV = 0;
    public Animator.AnimatorListener wY;

    public a(c cVar) {
        AppMethodBeat.i(9108);
        this.dgO = cVar;
        this.dgU = new Matrix();
        this.dgT = new RectF();
        AppMethodBeat.o(9108);
    }

    public final void a(float f2, Rect rect, float f3, float f4) {
        AppMethodBeat.i(204715);
        this.dgQ = f3;
        this.dgR = f4;
        this.dgS = rect;
        this.dgT.set(this.dgS);
        this.dgP = f2;
        AppMethodBeat.o(204715);
    }

    public final void play() {
        AppMethodBeat.i(9109);
        Log.i("MicroMsg.CropActionUpAnim", "[play]");
        if (!this.dgZ) {
            AppMethodBeat.o(9109);
            return;
        }
        this.isStarted = false;
        this.dgZ = false;
        this.dgN = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("scale", 1.0f, this.dgP), PropertyValuesHolder.ofFloat("deltaX", 0.0f, this.dgQ), PropertyValuesHolder.ofFloat("deltaY", 0.0f, this.dgR), PropertyValuesHolder.ofFloat("background_alpha", 0.0f, 255.0f));
        this.dgN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.c.a.AnonymousClass1 */
            Matrix dgW = new Matrix(a.this.dgO.getMainMatrix());
            Rect dgX = new Rect(a.this.dgS);

            {
                AppMethodBeat.i(9105);
                AppMethodBeat.o(9105);
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(9106);
                float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue("deltaX")).floatValue();
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue("scale")).floatValue();
                float floatValue4 = ((Float) valueAnimator.getAnimatedValue("background_alpha")).floatValue();
                a.this.dgU.reset();
                a.this.dgU.postTranslate(floatValue2, floatValue);
                RectF rectF = new RectF(this.dgX);
                a.this.dgU.mapRect(rectF);
                rectF.round(a.this.dgS);
                a.this.dgU.postScale(floatValue3, floatValue3, (float) a.this.dgS.centerX(), (float) a.this.dgS.centerY());
                Matrix matrix = new Matrix(this.dgW);
                matrix.postConcat(a.this.dgU);
                a.this.dgO.getMainMatrix().set(matrix);
                com.tencent.mm.z.a.pO((int) floatValue4);
                RectF rectF2 = new RectF(this.dgX);
                a.this.dgU.mapRect(rectF2);
                rectF2.round(a.this.dgS);
                a.this.dgO.Yb();
                AppMethodBeat.o(9106);
            }
        });
        this.dgN.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.c.a.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
                a.this.dgO.dsx = true;
                a.this.dgZ = false;
                a.this.isStarted = true;
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(9107);
                a.this.dgZ = true;
                a.this.isStarted = false;
                a.this.dgV = 0;
                a.this.dgO.Ye();
                a.this.dgO.Yc();
                if (a.this.wY != null) {
                    a.this.wY.onAnimationEnd(animator);
                }
                AppMethodBeat.o(9107);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        this.dgN.setInterpolator(new LinearInterpolator());
        this.dgN.setDuration((long) this.dgM);
        this.dgN.setStartDelay(this.dgV);
        this.dgN.start();
        AppMethodBeat.o(9109);
    }

    public final void cancel() {
        AppMethodBeat.i(9110);
        Log.d("MicroMsg.CropActionUpAnim", "[cancel]");
        this.isStarted = false;
        this.dgZ = true;
        if (this.dgN != null) {
            this.dgN.cancel();
        }
        AppMethodBeat.o(9110);
    }
}
