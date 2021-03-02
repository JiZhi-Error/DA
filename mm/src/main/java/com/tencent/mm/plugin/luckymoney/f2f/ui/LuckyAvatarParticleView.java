package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class LuckyAvatarParticleView extends View {
    public static DisplayMetrics metrics;
    private ValueAnimator animator;
    private long duration;
    private Paint paint = new Paint();
    private int ySc;
    private int ySd;
    private List<Rect> ySe = new ArrayList();
    private List<Integer> ySf = new ArrayList();
    private List<Integer> ySg = new ArrayList();
    private int ySh;
    private int ySi;
    private int ySj;
    private int ySk;

    public LuckyAvatarParticleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(65051);
        AppMethodBeat.o(65051);
    }

    private int getRandomVelocity() {
        AppMethodBeat.i(65052);
        int random = this.ySh + ((int) (Math.random() * ((double) (this.ySi - this.ySh))));
        AppMethodBeat.o(65052);
        return random;
    }

    private int getRandomRectWidth() {
        AppMethodBeat.i(65053);
        int random = this.ySj + ((int) (Math.random() * ((double) (this.ySk - this.ySj))));
        AppMethodBeat.o(65053);
        return random;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(65054);
        super.onDraw(canvas);
        for (int i2 = 0; i2 < this.ySe.size(); i2++) {
            canvas.drawRect(this.ySe.get(i2), this.paint);
        }
        AppMethodBeat.o(65054);
    }

    public void setDuration(long j2) {
        AppMethodBeat.i(65055);
        this.duration = j2;
        this.animator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(this.duration);
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyAvatarParticleView.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(65050);
                if (((Float) valueAnimator.getAnimatedValue()).floatValue() == 1.0f) {
                    LuckyAvatarParticleView.this.ySe.clear();
                    LuckyAvatarParticleView.this.ySf.clear();
                    LuckyAvatarParticleView.this.ySg.clear();
                } else if (((Float) valueAnimator.getAnimatedValue()).floatValue() == 0.0f) {
                    LuckyAvatarParticleView.d(LuckyAvatarParticleView.this);
                } else {
                    for (int i2 = 0; i2 < LuckyAvatarParticleView.this.ySe.size(); i2++) {
                        LuckyAvatarParticleView.a(LuckyAvatarParticleView.this, i2);
                    }
                }
                LuckyAvatarParticleView.this.invalidate();
                AppMethodBeat.o(65050);
            }
        });
        AppMethodBeat.o(65055);
    }

    public void setColor(int i2) {
        AppMethodBeat.i(65056);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.FILL);
        AppMethodBeat.o(65056);
    }

    static /* synthetic */ void d(LuckyAvatarParticleView luckyAvatarParticleView) {
        AppMethodBeat.i(65057);
        for (int i2 = 0; i2 < 20; i2++) {
            int random = (int) (Math.random() * ((double) luckyAvatarParticleView.getHeight()));
            int randomRectWidth = luckyAvatarParticleView.getRandomRectWidth();
            luckyAvatarParticleView.ySe.add(new Rect(0, random, randomRectWidth, random + randomRectWidth));
            int randomVelocity = luckyAvatarParticleView.getRandomVelocity();
            luckyAvatarParticleView.ySf.add(Integer.valueOf(randomVelocity));
            int abs = (int) (((double) ((((float) Math.abs(random - luckyAvatarParticleView.ySd)) * (((float) randomVelocity) * 1.0f)) / ((float) Math.abs(luckyAvatarParticleView.ySc)))) + 0.5d);
            if (abs == 0) {
                abs = 1;
            }
            luckyAvatarParticleView.ySg.add(Integer.valueOf(abs));
        }
        for (int i3 = 20; i3 < 40; i3++) {
            int random2 = (int) (Math.random() * ((double) luckyAvatarParticleView.getHeight()));
            int randomRectWidth2 = luckyAvatarParticleView.getRandomRectWidth();
            luckyAvatarParticleView.ySe.add(new Rect(metrics.widthPixels, random2, metrics.widthPixels + randomRectWidth2, randomRectWidth2 + random2));
            int randomVelocity2 = luckyAvatarParticleView.getRandomVelocity();
            luckyAvatarParticleView.ySf.add(Integer.valueOf(randomVelocity2));
            int abs2 = (int) (((double) ((((float) Math.abs(random2 - luckyAvatarParticleView.ySd)) * (((float) randomVelocity2) * 1.0f)) / ((float) Math.abs(metrics.widthPixels - luckyAvatarParticleView.ySc)))) + 0.5d);
            if (abs2 == 0) {
                abs2 = 1;
            }
            luckyAvatarParticleView.ySg.add(Integer.valueOf(abs2));
        }
        AppMethodBeat.o(65057);
    }

    static /* synthetic */ void a(LuckyAvatarParticleView luckyAvatarParticleView, int i2) {
        AppMethodBeat.i(65058);
        Rect rect = luckyAvatarParticleView.ySe.get(i2);
        int width = rect.width();
        if (Math.abs(luckyAvatarParticleView.ySc - rect.left) <= luckyAvatarParticleView.ySf.get(i2).intValue()) {
            rect.left = luckyAvatarParticleView.ySc;
        } else if (luckyAvatarParticleView.ySc > rect.left) {
            rect.left = luckyAvatarParticleView.ySf.get(i2).intValue() + rect.left;
        } else if (luckyAvatarParticleView.ySc < rect.left) {
            rect.left -= luckyAvatarParticleView.ySf.get(i2).intValue();
        }
        rect.right = rect.left + width;
        if (Math.abs(luckyAvatarParticleView.ySd - rect.top) <= luckyAvatarParticleView.ySg.get(i2).intValue()) {
            rect.top = luckyAvatarParticleView.ySd;
        } else if (luckyAvatarParticleView.ySd > rect.top) {
            rect.top = luckyAvatarParticleView.ySg.get(i2).intValue() + rect.top;
        } else if (luckyAvatarParticleView.ySd < rect.top) {
            rect.top -= luckyAvatarParticleView.ySg.get(i2).intValue();
        }
        rect.bottom = rect.top + width;
        AppMethodBeat.o(65058);
    }
}
