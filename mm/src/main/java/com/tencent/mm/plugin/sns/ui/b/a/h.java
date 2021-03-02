package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class h extends a {
    private AnimatorSet CPA;
    private ValueAnimator EUa;
    private ValueAnimator EUb;
    d EUq;

    public h(MMActivity mMActivity, a aVar) {
        AppMethodBeat.i(99929);
        try {
            this.activity = mMActivity;
            this.EUq = (d) aVar;
            this.EUa = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.h.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(99924);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue != 0.0f) {
                        h.this.EUq.ExX.setScaleX(floatValue);
                        h.this.EUq.ExX.setScaleY(floatValue);
                        h.this.EUq.ExX.setAlpha(floatValue);
                    }
                    AppMethodBeat.o(99924);
                }
            });
            this.EUa.setDuration(400L);
            this.EUa.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.h.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(99925);
                    h.this.EUq.EVJ.setAlpha(0.0f);
                    h.this.EUq.EVK.setAlpha(0.0f);
                    AppMethodBeat.o(99925);
                }
            });
            this.EUb = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.h.AnonymousClass3 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(99926);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    h.this.EUq.EVJ.setAlpha(floatValue);
                    h.this.EUq.EVK.setAlpha(floatValue);
                    AppMethodBeat.o(99926);
                }
            });
            this.EUb.setDuration(100L);
            this.EUb.setStartDelay(300);
            this.CPA = new AnimatorSet();
            this.CPA.playTogether(this.EUa, this.EUb);
            this.CPA.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.h.AnonymousClass4 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(99927);
                    Log.i("MicroMsg.SphereCardAdDetailBackAnimation", "onAnimation start");
                    AppMethodBeat.o(99927);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(99928);
                    Log.i("MicroMsg.SphereCardAdDetailBackAnimation", "onAnimation end");
                    h.this.EUq.ExX.setScaleX(1.0f);
                    h.this.EUq.ExX.setScaleY(1.0f);
                    h.this.EUq.ExX.setAlpha(1.0f);
                    h.this.EUq.EVJ.setAlpha(1.0f);
                    h.this.EUq.EVK.setAlpha(1.0f);
                    if (h.this.ETY != null) {
                        h.this.ETY.onAnimationEnd();
                    }
                    AppMethodBeat.o(99928);
                }
            });
            AppMethodBeat.o(99929);
        } catch (Throwable th) {
            Log.e("MicroMsg.SphereCardAdDetailBackAnimation", "init exp=" + th.toString());
            AppMethodBeat.o(99929);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.a.a
    public final void JW(long j2) {
        AppMethodBeat.i(99930);
        if (this.CPA != null && !this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(99930);
    }
}
