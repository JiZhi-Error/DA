package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;

public final class h extends a {
    AnimatorSet CPA;
    n.a EUE;
    private ValueAnimator EUa;
    private ValueAnimator EUb;

    public h(MMActivity mMActivity, BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(99982);
        try {
            this.activity = mMActivity;
            this.EUE = (n.a) baseViewHolder;
            this.EUa = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.h.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(99977);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue != 0.0f) {
                        h.this.EUE.ExX.setScaleX(floatValue);
                        h.this.EUE.ExX.setScaleY(floatValue);
                        h.this.EUE.ExX.setAlpha(floatValue);
                    }
                    AppMethodBeat.o(99977);
                }
            });
            this.EUa.setDuration(400L);
            this.EUa.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.h.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(99978);
                    if (h.this.EUE.hho) {
                        Log.i("MicroMsg.SphereCardAdBackAnimation", "holder is busy");
                        Iterator<Animator> it = h.this.CPA.getChildAnimations().iterator();
                        while (it.hasNext()) {
                            it.next().cancel();
                        }
                        AppMethodBeat.o(99978);
                        return;
                    }
                    h.this.EUE.hho = true;
                    h.this.EUE.wnX.setAlpha(0.0f);
                    h.this.EUE.EVh.setAlpha(0.0f);
                    AppMethodBeat.o(99978);
                }
            });
            this.EUb = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.h.AnonymousClass3 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(99979);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    h.this.EUE.wnX.setAlpha(floatValue);
                    h.this.EUE.EVh.setAlpha(floatValue);
                    AppMethodBeat.o(99979);
                }
            });
            this.EUb.setDuration(100L);
            this.EUb.setStartDelay(300);
            this.CPA = new AnimatorSet();
            this.CPA.playTogether(this.EUa, this.EUb);
            this.CPA.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.h.AnonymousClass4 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(99980);
                    Log.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation start");
                    AppMethodBeat.o(99980);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(99981);
                    Log.i("MicroMsg.SphereCardAdBackAnimation", "onAnimation end");
                    h.this.EUE.ExX.setScaleX(1.0f);
                    h.this.EUE.ExX.setScaleY(1.0f);
                    h.this.EUE.ExX.setAlpha(1.0f);
                    h.this.EUE.wnX.setAlpha(1.0f);
                    h.this.EUE.EVh.setAlpha(1.0f);
                    if (h.this.ETY != null) {
                        h.this.ETY.onAnimationEnd();
                    }
                    h.this.EUE.hho = false;
                    AppMethodBeat.o(99981);
                }
            });
            AppMethodBeat.o(99982);
        } catch (Throwable th) {
            Log.e("MicroMsg.SphereCardAdBackAnimation", "init exp=" + th.toString());
            AppMethodBeat.o(99982);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.b.a
    public final void JW(long j2) {
        AppMethodBeat.i(99983);
        if (this.CPA != null && !this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(99983);
    }
}
