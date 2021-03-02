package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.g;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public class ShakeEggAnimFrame extends FrameLayout {
    List<View> Djn = new ArrayList();
    int rd = 0;
    int size = 0;

    public ShakeEggAnimFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(28385);
        AppMethodBeat.o(28385);
    }

    class b extends a {
        private float Djq;
        private float Djr;
        private float Djs;
        private float Djt;
        private float Dju = 0.01f;
        private float Djv = 0.02f;
        private float Djw;
        private float Djx;
        private float Djy;
        private float Djz;
        private int hbc;
        private int oh;

        public b(int i2, int i3) {
            super();
            AppMethodBeat.i(28381);
            this.hbc = i2;
            this.oh = i3;
            this.Djq = ShakeEggAnimFrame.ak(0.1f, 0.9f);
            this.Djr = this.Djq;
            this.Djt = ShakeEggAnimFrame.ak(-0.3f, -0.1f);
            restart();
            AppMethodBeat.o(28381);
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f2, Transformation transformation) {
            AppMethodBeat.i(28382);
            float f3 = this.Djw;
            float f4 = this.Djy;
            if (this.Djw != this.Djx) {
                f3 = this.Djw + ((this.Djx - this.Djw) * f2);
            }
            if (this.Djy != this.Djz) {
                f4 = this.Djy + ((this.Djz - this.Djy) * f2);
            }
            transformation.getMatrix().setTranslate(f3, f4);
            if (f2 == 1.0f) {
                restart();
            }
            AppMethodBeat.o(28382);
        }

        private void restart() {
            AppMethodBeat.i(28383);
            if (this.Djt > 0.0f) {
                this.Djv += this.Dju;
            }
            this.Djs = this.Djt;
            this.Djt += this.Djv;
            if (this.Djs > 1.1f) {
                eUT();
            }
            resolve();
            AppMethodBeat.o(28383);
        }

        public final void initialize(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(28384);
            super.initialize(i2, i3, i4, i5);
            setRepeatCount(-1);
            setDuration((long) this.duration);
            AppMethodBeat.o(28384);
        }

        private void resolve() {
            this.Djw = this.Djq * ((float) this.hbc);
            this.Djx = this.Djr * ((float) this.hbc);
            this.Djy = this.Djs * ((float) this.oh);
            this.Djz = this.Djt * ((float) this.oh);
        }
    }

    abstract class a extends Animation {
        protected int duration = 100;
        View targetView;

        a() {
        }

        public final void eUT() {
            Assert.assertTrue(this.targetView != null);
            this.targetView.post(new Runnable() {
                /* class com.tencent.mm.plugin.shake.ui.ShakeEggAnimFrame.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(28380);
                    if (a.this.targetView != null) {
                        a.this.targetView.clearAnimation();
                        ShakeEggAnimFrame shakeEggAnimFrame = ShakeEggAnimFrame.this;
                        View view = a.this.targetView;
                        shakeEggAnimFrame.Djn.remove(view);
                        shakeEggAnimFrame.removeView(view);
                    }
                    AppMethodBeat.o(28380);
                }
            });
        }
    }

    static float ak(float f2, float f3) {
        AppMethodBeat.i(28387);
        float random = (((float) Math.random()) * (f3 - f2)) + f2;
        AppMethodBeat.o(28387);
        return random;
    }

    private int getSize() {
        AppMethodBeat.i(28388);
        if (this.size == 0) {
            int textSize = (int) (((double) new TextView(getContext()).getTextSize()) * 1.2d);
            AppMethodBeat.o(28388);
            return textSize;
        }
        int i2 = this.size;
        AppMethodBeat.o(28388);
        return i2;
    }

    public final void aE(Activity activity) {
        AppMethodBeat.i(28386);
        for (View view : this.Djn) {
            view.clearAnimation();
            removeView(view);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        setVisibility(0);
        for (int i2 = 0; i2 < 30; i2++) {
            b bVar = new b(displayMetrics.widthPixels, displayMetrics.heightPixels);
            g.gxZ();
            com.tencent.mm.ce.b gxI = com.tencent.mm.ce.b.gxI();
            Drawable a2 = gxI.a(gxI.NKE.get(107), true);
            a2.setBounds(0, 0, getSize(), getSize());
            ImageSpan imageSpan = new ImageSpan(a2, 1);
            SpannableString spannableString = new SpannableString("  ");
            spannableString.setSpan(imageSpan, 0, 1, 33);
            TextView textView = new TextView(getContext());
            textView.setSingleLine();
            textView.setText(spannableString);
            textView.setAnimation(bVar);
            textView.setTag(bVar);
            addView(textView);
            bVar.targetView = textView;
            this.Djn.add(textView);
        }
        AppMethodBeat.o(28386);
    }
}
