package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;

public final class c extends a {
    AnimatorSet CPA = new AnimatorSet();
    a.C1738a EUx;

    public c(MMActivity mMActivity, BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(99954);
        this.activity = mMActivity;
        this.EUx = (a.C1738a) baseViewHolder;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.c.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99949);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != 0.0f) {
                    c.this.EUx.qVR.setScaleX(floatValue);
                    c.this.EUx.qVR.setScaleY(floatValue);
                    c.this.EUx.qVR.setAlpha(floatValue);
                }
                AppMethodBeat.o(99949);
            }
        });
        ofFloat.setDuration(400L);
        ofFloat.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.c.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(99950);
                if (c.this.EUx.hho) {
                    Log.i("MicroMsg.CardAdBackAnimation", "holder is busy");
                    Iterator<Animator> it = c.this.CPA.getChildAnimations().iterator();
                    while (it.hasNext()) {
                        it.next().cancel();
                    }
                    AppMethodBeat.o(99950);
                    return;
                }
                c.this.EUx.hho = true;
                AppMethodBeat.o(99950);
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.c.AnonymousClass3 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99951);
                c.this.EUx.EXY.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AppMethodBeat.o(99951);
            }
        });
        ofFloat2.setDuration(100L);
        ofFloat2.setStartDelay(300);
        this.CPA.playTogether(ofFloat, ofFloat2);
        this.CPA.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.c.AnonymousClass4 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(99952);
                Log.i("MicroMsg.CardAdBackAnimation", "onAnimation start");
                c.this.EUx.EXY.setAlpha(0.0f);
                AppMethodBeat.o(99952);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(99953);
                Log.i("MicroMsg.CardAdBackAnimation", "onAnimation end");
                c.this.EUx.qVR.setScaleX(1.0f);
                c.this.EUx.qVR.setScaleY(1.0f);
                c.this.EUx.qVR.setAlpha(1.0f);
                c.this.EUx.EXY.setAlpha(1.0f);
                if (c.this.ETY != null) {
                    c.this.ETY.onAnimationEnd();
                }
                c.this.EUx.hho = false;
                AppMethodBeat.o(99953);
            }
        });
        AppMethodBeat.o(99954);
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.b.a
    public final void JW(long j2) {
        AppMethodBeat.i(99955);
        if (!this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(99955);
    }
}
