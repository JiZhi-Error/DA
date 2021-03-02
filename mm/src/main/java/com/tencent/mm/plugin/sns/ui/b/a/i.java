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

public final class i extends b {
    private AnimatorSet CPA;
    private ValueAnimator EUa;
    private ValueAnimator EUb;
    d EUq;

    public i(MMActivity mMActivity, a aVar) {
        AppMethodBeat.i(99935);
        try {
            this.activity = mMActivity;
            this.EUq = (d) aVar;
            this.EUa = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.i.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(99931);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue != 1.0f) {
                        i.this.EUq.ExX.setScaleX(floatValue);
                        i.this.EUq.ExX.setScaleY(floatValue);
                        i.this.EUq.ExX.setAlpha(floatValue);
                    }
                    AppMethodBeat.o(99931);
                }
            });
            this.EUa.setDuration(400L);
            this.EUa.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.i.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                }
            });
            this.EUb = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.i.AnonymousClass3 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(99932);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    i.this.EUq.EVJ.setAlpha(floatValue);
                    i.this.EUq.EVK.setAlpha(floatValue);
                    AppMethodBeat.o(99932);
                }
            });
            this.EUb.setDuration(100L);
            this.CPA = new AnimatorSet();
            this.CPA.playTogether(this.EUa, this.EUb);
            this.CPA.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.i.AnonymousClass4 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(99933);
                    Log.i("MicroMsg.SphereCardAdDetailClickAnimation", "onAnimation start");
                    AppMethodBeat.o(99933);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(99934);
                    Log.i("MicroMsg.SphereCardAdDetailClickAnimation", "onAnimation end");
                    i.this.EUq.ExX.setScaleX(1.0f);
                    i.this.EUq.ExX.setScaleY(1.0f);
                    i.this.EUq.ExX.setAlpha(1.0f);
                    i.this.EUq.EVJ.setAlpha(1.0f);
                    i.this.EUq.EVK.setAlpha(1.0f);
                    if (i.this.ETY != null) {
                        i.this.ETY.onAnimationEnd();
                    }
                    i.this.EUq.EgD.feu();
                    i.this.EUq.EgD.Ejd.requestRender();
                    AppMethodBeat.o(99934);
                }
            });
            AppMethodBeat.o(99935);
        } catch (Throwable th) {
            Log.e("MicroMsg.SphereCardAdDetailClickAnimation", "init exp=" + th.toString());
            AppMethodBeat.o(99935);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.a.b
    public final void JW(long j2) {
        AppMethodBeat.i(99936);
        if (this.CPA != null && !this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(99936);
    }
}
