package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class e extends a {
    private AnimatorSet CPA;
    private ValueAnimator EUa;
    private ValueAnimator EUb;
    c EUm;

    public e(MMActivity mMActivity, a aVar) {
        AppMethodBeat.i(99916);
        try {
            this.activity = mMActivity;
            this.EUm = (c) aVar;
            this.EUa = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.e.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(99912);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue != 0.0f) {
                        e.this.EUm.ExX.setScaleX(floatValue);
                        e.this.EUm.ExX.setScaleY(floatValue);
                        e.this.EUm.ExX.setAlpha(floatValue);
                    }
                    AppMethodBeat.o(99912);
                }
            });
            this.EUa.setDuration(400L);
            this.EUa.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.e.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(179327);
                    e.this.EUm.wnX.setAlpha(0.0f);
                    e.this.EUm.EVh.setAlpha(0.0f);
                    AppMethodBeat.o(179327);
                }
            });
            this.EUb = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.e.AnonymousClass3 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(179328);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    e.this.EUm.wnX.setAlpha(floatValue);
                    e.this.EUm.EVh.setAlpha(floatValue);
                    AppMethodBeat.o(179328);
                }
            });
            this.EUb.setDuration(100L);
            this.EUb.setStartDelay(300);
            this.CPA = new AnimatorSet();
            this.CPA.playTogether(this.EUa, this.EUb);
            this.CPA.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.e.AnonymousClass4 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(179329);
                    Log.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation start");
                    AppMethodBeat.o(179329);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(179330);
                    Log.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation end");
                    e.this.EUm.ExX.setScaleX(1.0f);
                    e.this.EUm.ExX.setScaleY(1.0f);
                    e.this.EUm.ExX.setAlpha(1.0f);
                    e.this.EUm.wnX.setAlpha(1.0f);
                    e.this.EUm.EVh.setAlpha(1.0f);
                    if (e.this.ETY != null) {
                        e.this.ETY.onAnimationEnd();
                    }
                    AppMethodBeat.o(179330);
                }
            });
            AppMethodBeat.o(99916);
        } catch (Throwable th) {
            Log.e("MicroMsg.FullCardAdDetailBackAnimation", "init exp=" + th.toString());
            AppMethodBeat.o(99916);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.a.a
    public final void JW(long j2) {
        AppMethodBeat.i(99917);
        if (this.CPA != null && !this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(99917);
    }
}
