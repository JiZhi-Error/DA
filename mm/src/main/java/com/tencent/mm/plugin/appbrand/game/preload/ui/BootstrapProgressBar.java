package com.tencent.mm.plugin.appbrand.game.preload.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.WebView;

public class BootstrapProgressBar extends View implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
    private Paint luA;
    private Canvas luB;
    private Bitmap luC;
    private Bitmap luD;
    private int luE;
    private Paint lun;
    private Paint luo;
    private Paint lup;
    private float luq = 0.0f;
    private float lur = 0.0f;
    private float lus = 100.0f;
    private boolean lut = false;
    private boolean luu = false;
    private boolean luv = true;
    private boolean luw = true;
    private boolean luy = true;
    private ValueAnimator luz;

    public BootstrapProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(45297);
        bDx();
        AppMethodBeat.o(45297);
    }

    public BootstrapProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(45298);
        bDx();
        AppMethodBeat.o(45298);
    }

    private void bDx() {
        AppMethodBeat.i(45299);
        Log.d("BootstrapProgressBar", "initialise");
        ValueAnimator.setFrameDelay(15);
        this.luA = new Paint();
        this.lun = new Paint();
        this.lun.setStyle(Paint.Style.FILL);
        this.lun.setAntiAlias(true);
        this.luo = new Paint();
        this.luo.setStyle(Paint.Style.FILL);
        this.luo.setAntiAlias(true);
        this.lup = new Paint();
        this.lup.setStyle(Paint.Style.FILL);
        this.lup.setARGB(38, 0, 0, 0);
        setProgress(this.luq);
        setMaxProgress(this.lus);
        AppMethodBeat.o(45299);
    }

    public void setProgressColor(int i2) {
        AppMethodBeat.i(45300);
        this.luE = i2;
        this.lun.setColor(this.luE);
        Paint paint = this.luo;
        int i3 = this.luE;
        paint.setColor(Color.rgb(((int) ((((float) Color.red(i3)) * 0.7f) + (((float) Color.red((int) WebView.NIGHT_MODE_COLOR)) * 0.3f))) / 1, ((int) ((((float) Color.green(i3)) * 0.7f) + (((float) Color.green((int) WebView.NIGHT_MODE_COLOR)) * 0.3f))) / 1, ((int) ((((float) Color.blue(i3)) * 0.7f) + (((float) Color.blue((int) WebView.NIGHT_MODE_COLOR)) * 0.3f))) / 1));
        this.luD = null;
        this.luC = null;
        this.luB = null;
        invalidate();
        AppMethodBeat.o(45300);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        AppMethodBeat.i(45301);
        this.lur = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
        AppMethodBeat.o(45301);
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        AppMethodBeat.i(45302);
        bDy();
        AppMethodBeat.o(45302);
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    private void bDy() {
        AppMethodBeat.i(45303);
        if (!this.lut || !this.luu) {
            AppMethodBeat.o(45303);
            return;
        }
        clearAnimation();
        this.luz = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.luz.setDuration(300L);
        this.luz.setRepeatCount(-1);
        this.luz.setRepeatMode(1);
        this.luz.setInterpolator(new LinearInterpolator());
        this.luz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(45296);
                BootstrapProgressBar.this.invalidate();
                AppMethodBeat.o(45296);
            }
        });
        this.luz.start();
        AppMethodBeat.o(45303);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(45304);
        setMeasuredDimension(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        AppMethodBeat.o(45304);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(45305);
        if (i3 != i5) {
            this.luD = null;
        }
        super.onSizeChanged(i2, i3, i4, i5);
        AppMethodBeat.o(45305);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(45306);
        float width = (float) getWidth();
        float height = (float) getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            AppMethodBeat.o(45306);
            return;
        }
        if (this.luC == null) {
            this.luC = Bitmap.createBitmap((int) width, (int) height, Bitmap.Config.ARGB_8888);
        }
        if (this.luB == null) {
            this.luB = new Canvas(this.luC);
        }
        this.luB.drawColor(0, PorterDuff.Mode.CLEAR);
        float f2 = this.luq / this.lus;
        int i2 = (int) (width * f2);
        float f3 = 0.0f;
        float currentTimeMillis = ((float) (System.currentTimeMillis() % 370)) / 370.0f;
        if (this.lut && this.luu) {
            f3 = 2.0f * height * (1.0f - currentTimeMillis);
        }
        if (f2 < 1.0f) {
            this.luB.save();
            Path path = new Path();
            path.moveTo(0.0f, 0.0f);
            path.lineTo((float) i2, 0.0f);
            path.lineTo(((float) i2) - height, height);
            path.lineTo(0.0f, height);
            this.luB.clipPath(path);
        }
        if (this.lut) {
            if (this.luD == null) {
                Paint paint = this.luo;
                Paint paint2 = this.lun;
                Bitmap createBitmap = Bitmap.createBitmap(((int) height) * 2, (int) height, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                Path path2 = new Path();
                path2.moveTo(0.0f, 0.0f);
                path2.lineTo(height, 0.0f);
                path2.lineTo(0.0f, height);
                canvas2.drawPath(path2, paint);
                path2.reset();
                path2.moveTo(0.0f + height, 0.0f);
                path2.lineTo(0.0f, height);
                path2.lineTo(0.0f + height, height);
                path2.lineTo(0.0f + (2.0f * height), 0.0f);
                canvas2.drawPath(path2, paint2);
                float f4 = 0.0f + (2.0f * height);
                path2.reset();
                path2.moveTo(f4, 0.0f);
                path2.lineTo(f4 - height, height);
                path2.lineTo(f4, height);
                canvas2.drawPath(path2, paint);
                this.luD = createBitmap;
            }
            float f5 = 0.0f - f3;
            while (f5 < ((float) i2)) {
                this.luB.drawBitmap(this.luD, f5, 0.0f, this.luA);
                f5 += (float) this.luD.getWidth();
            }
        } else {
            this.luB.drawRect(0.0f, 0.0f, (float) i2, height, this.lun);
        }
        if (f2 < 1.0f) {
            this.luB.restore();
        }
        Path path3 = new Path();
        path3.moveTo(0.0f, 0.0f);
        path3.lineTo(width, 0.0f);
        path3.lineTo(width, height);
        path3.lineTo(0.0f, height);
        this.luB.drawPath(path3, this.lup);
        float f6 = this.luv ? height / 2.0f : 0.0f;
        Bitmap bitmap = this.luC;
        boolean z = this.luy;
        boolean z2 = this.luw;
        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas3 = new Canvas(createBitmap2);
        Paint paint3 = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Rect rect2 = new Rect(0, 0, bitmap.getWidth() / 2, bitmap.getHeight());
        Rect rect3 = new Rect(bitmap.getWidth() / 2, 0, bitmap.getWidth(), bitmap.getHeight());
        paint3.setAntiAlias(true);
        paint3.setColor(-1);
        paint3.setStyle(Paint.Style.FILL);
        canvas3.drawARGB(0, 0, 0, 0);
        canvas3.drawRoundRect(new RectF(rect), f6, f6, paint3);
        if (!z2) {
            canvas3.drawRect(rect2, paint3);
        }
        if (!z) {
            canvas3.drawRect(rect3, paint3);
        }
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas3.drawBitmap(bitmap, rect, rect, paint3);
        canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, this.luA);
        AppMethodBeat.o(45306);
    }

    @SuppressLint({"DefaultLocale"})
    public void setProgress(float f2) {
        AppMethodBeat.i(45307);
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > this.lus) {
            f2 = 100.0f;
        }
        this.luq = f2;
        if (this.luu) {
            clearAnimation();
            this.luz = ValueAnimator.ofFloat(this.lur, this.luq);
            this.luz.setDuration(300L);
            this.luz.setRepeatCount(0);
            this.luz.setRepeatMode(1);
            this.luz.setInterpolator(new LinearInterpolator());
            this.luz.addUpdateListener(this);
            this.luz.addListener(this);
            this.luz.start();
            AppMethodBeat.o(45307);
            return;
        }
        this.lur = f2;
        invalidate();
        AppMethodBeat.o(45307);
    }

    public float getProgress() {
        return this.luq;
    }

    public void setStriped(boolean z) {
        AppMethodBeat.i(45308);
        this.lut = z;
        invalidate();
        bDy();
        AppMethodBeat.o(45308);
    }

    public void setAnimated(boolean z) {
        AppMethodBeat.i(45309);
        this.luu = z;
        invalidate();
        bDy();
        AppMethodBeat.o(45309);
    }

    public float getMaxProgress() {
        return this.lus;
    }

    public void setMaxProgress(float f2) {
        AppMethodBeat.i(45310);
        if (getProgress() <= f2) {
            this.lus = f2;
            invalidate();
            AppMethodBeat.o(45310);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("MaxProgress cant be smaller than the current progress %d<%d", Float.valueOf(getProgress()), Float.valueOf(f2)));
        AppMethodBeat.o(45310);
        throw illegalArgumentException;
    }
}
