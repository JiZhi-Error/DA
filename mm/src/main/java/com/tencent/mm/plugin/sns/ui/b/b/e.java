package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;

public final class e extends a {
    AnimatorSet CPA;
    f.a EUA;
    private ValueAnimator EUa;
    private ValueAnimator EUb;

    public e(MMActivity mMActivity, BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(99968);
        try {
            this.activity = mMActivity;
            this.EUA = (f.a) baseViewHolder;
            this.EUa = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.e.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(99963);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue != 0.0f) {
                        e.this.EUA.ExX.setScaleX(floatValue);
                        e.this.EUA.ExX.setScaleY(floatValue);
                        e.this.EUA.ExX.setAlpha(floatValue);
                    }
                    AppMethodBeat.o(99963);
                }
            });
            this.EUa.setDuration(400L);
            this.EUa.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.e.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(99964);
                    if (e.this.EUA.hho) {
                        Log.i("MicroMsg.FullCardAdBackAnimation", "holder is busy");
                        Iterator<Animator> it = e.this.CPA.getChildAnimations().iterator();
                        while (it.hasNext()) {
                            it.next().cancel();
                        }
                        AppMethodBeat.o(99964);
                        return;
                    }
                    e.this.EUA.hho = true;
                    e.this.EUA.wnX.setAlpha(0.0f);
                    e.this.EUA.EVh.setAlpha(0.0f);
                    AppMethodBeat.o(99964);
                }
            });
            this.EUb = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.e.AnonymousClass3 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(99965);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    e.this.EUA.wnX.setAlpha(floatValue);
                    e.this.EUA.EVh.setAlpha(floatValue);
                    AppMethodBeat.o(99965);
                }
            });
            this.EUb.setDuration(100L);
            this.EUb.setStartDelay(300);
            this.CPA = new AnimatorSet();
            this.CPA.playTogether(this.EUa, this.EUb);
            this.CPA.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.e.AnonymousClass4 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(99966);
                    Log.i("MicroMsg.FullCardAdBackAnimation", "onAnimation start");
                    AppMethodBeat.o(99966);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(99967);
                    Log.i("MicroMsg.FullCardAdBackAnimation", "onAnimation end");
                    e.this.EUA.ExX.setScaleX(1.0f);
                    e.this.EUA.ExX.setScaleY(1.0f);
                    e.this.EUA.ExX.setAlpha(1.0f);
                    e.this.EUA.wnX.setAlpha(1.0f);
                    e.this.EUA.EVh.setAlpha(1.0f);
                    if (e.this.ETY != null) {
                        e.this.ETY.onAnimationEnd();
                    }
                    e.this.EUA.hho = false;
                    AppMethodBeat.o(99967);
                }
            });
            AppMethodBeat.o(99968);
        } catch (Throwable th) {
            Log.e("MicroMsg.FullCardAdBackAnimation", "init exp=" + th.toString());
            AppMethodBeat.o(99968);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.b.a
    public final void JW(long j2) {
        AppMethodBeat.i(99969);
        if (this.CPA != null && !this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(99969);
    }
}
