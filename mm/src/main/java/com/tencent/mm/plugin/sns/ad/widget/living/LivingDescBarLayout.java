package com.tencent.mm.plugin.sns.ad.widget.living;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;

public class LivingDescBarLayout extends RelativeLayout {
    a DAz;

    public interface b {
        String XW(int i2);

        int getCount();
    }

    public LivingDescBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LivingDescBarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(202417);
        super.onFinishInflate();
        try {
            ((ImageView) findViewById(R.id.fu)).setImageResource(R.raw.ad_living_description_icon);
            this.DAz = new a((TextView) findViewById(R.id.fr), (TextView) findViewById(R.id.fs));
            AppMethodBeat.o(202417);
        } catch (Throwable th) {
            AppMethodBeat.o(202417);
        }
    }

    public void setSlideAdapter(b bVar) {
        AppMethodBeat.i(202418);
        a aVar = this.DAz;
        if (aVar != null) {
            aVar.a(bVar);
        }
        AppMethodBeat.o(202418);
    }

    public final void eYt() {
        AppMethodBeat.i(202419);
        a aVar = this.DAz;
        if (aVar != null) {
            aVar.stop();
        }
        AppMethodBeat.o(202419);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(202420);
        super.onAttachedToWindow();
        Log.w("SnsAd.LivingDescBarLayout", "onAttachedToWindow is called!!");
        AppMethodBeat.o(202420);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(202421);
        super.onDetachedFromWindow();
        a aVar = this.DAz;
        if (aVar != null) {
            aVar.a(null);
        }
        AppMethodBeat.o(202421);
    }

    static class a implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, Handler.Callback {
        private TextView DAA;
        private TextView DAB;
        Handler DAC = new Handler(Looper.getMainLooper(), this);
        b DAD;
        private int DAE = 0;
        float DAF = 0.0f;
        ValueAnimator aAO;
        int mState = 1;

        public a(TextView textView, TextView textView2) {
            AppMethodBeat.i(202408);
            this.DAA = textView;
            this.DAB = textView2;
            AppMethodBeat.o(202408);
        }

        public final void a(b bVar) {
            AppMethodBeat.i(202409);
            try {
                stop();
                if (bVar != null && bVar.getCount() > 0 && eYu()) {
                    this.DAE = 0;
                    String XW = bVar.XW(this.DAE);
                    this.DAA.setVisibility(0);
                    this.DAA.setText(XW);
                    if (bVar.getCount() > 1) {
                        this.DAC.sendEmptyMessageDelayed(1, 2000);
                    }
                }
                this.DAD = bVar;
                AppMethodBeat.o(202409);
            } catch (Throwable th) {
                AppMethodBeat.o(202409);
            }
        }

        public final void stop() {
            AppMethodBeat.i(202410);
            try {
                this.mState = 1;
                this.DAC.removeMessages(1);
                if (this.aAO != null && this.aAO.isRunning()) {
                    this.aAO.cancel();
                }
                AppMethodBeat.o(202410);
            } catch (Throwable th) {
                AppMethodBeat.o(202410);
            }
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(202411);
            Log.d("SlideController", "onAnimationStart is called ");
            try {
                b bVar = this.DAD;
                if (bVar == null || bVar.getCount() <= 0 || !eYu()) {
                    Log.d("SlideController", "onAnimationStart return because of count is 0 ");
                    AppMethodBeat.o(202411);
                    return;
                }
                this.DAB.setTranslationY(this.DAF);
                this.DAB.setAlpha(0.0f);
                this.DAB.setVisibility(0);
                this.DAB.setText(bVar.XW((this.DAE + 1) % bVar.getCount()));
                AppMethodBeat.o(202411);
            } catch (Throwable th) {
                AppMethodBeat.o(202411);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(202412);
            Log.d("SlideController", "onAnimationEnd is called ");
            try {
                b bVar = this.DAD;
                if (bVar == null || bVar.getCount() <= 0 || !eYu()) {
                    Log.d("SlideController", "onAnimationEnd return because of count is 0");
                    AppMethodBeat.o(202412);
                    return;
                }
                TextView textView = this.DAB;
                this.DAB = this.DAA;
                this.DAA = textView;
                fd(this.DAB);
                this.DAE = (this.DAE + 1) % bVar.getCount();
                this.DAF = 0.0f;
                if (this.mState == 0) {
                    this.DAC.sendEmptyMessageDelayed(1, 2000);
                }
                this.aAO = null;
                AppMethodBeat.o(202412);
            } catch (Throwable th) {
                AppMethodBeat.o(202412);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(202413);
            try {
                Log.d("SlideController", "onAnimationCancel is called ");
                fd(this.DAB);
                fd(this.DAA);
                AppMethodBeat.o(202413);
            } catch (Throwable th) {
                AppMethodBeat.o(202413);
            }
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(202414);
            try {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue instanceof Float) {
                    float floatValue = ((Float) animatedValue).floatValue();
                    if (eYu()) {
                        float f2 = this.DAF * floatValue;
                        this.DAB.setTranslationY(this.DAF - f2);
                        this.DAB.setAlpha(floatValue);
                        this.DAA.setTranslationY(-f2);
                        this.DAA.setAlpha(1.0f - floatValue);
                    }
                }
                AppMethodBeat.o(202414);
            } catch (Throwable th) {
                AppMethodBeat.o(202414);
            }
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(202415);
            try {
                if (message.what == 1) {
                    try {
                        if (this.aAO == null) {
                            this.aAO = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(1000L);
                            this.aAO.addUpdateListener(this);
                            this.aAO.addListener(this);
                        }
                        if (eYu()) {
                            this.DAF = (float) this.DAA.getHeight();
                            this.aAO.start();
                            this.mState = 0;
                        }
                    } catch (Throwable th) {
                    }
                    AppMethodBeat.o(202415);
                    return true;
                }
            } catch (Throwable th2) {
            }
            AppMethodBeat.o(202415);
            return false;
        }

        private static void fd(View view) {
            AppMethodBeat.i(202416);
            if (view != null) {
                view.setVisibility(4);
                view.setTranslationY(0.0f);
                view.setAlpha(1.0f);
            }
            AppMethodBeat.o(202416);
        }

        private boolean eYu() {
            return (this.DAB == null || this.DAA == null) ? false : true;
        }
    }
}
