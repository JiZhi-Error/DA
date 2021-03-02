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

public final class f extends b {
    private AnimatorSet CPA;
    private ValueAnimator EUa;
    private ValueAnimator EUb;
    c EUm;

    public f(MMActivity mMActivity, a aVar) {
        AppMethodBeat.i(99922);
        try {
            this.activity = mMActivity;
            this.EUm = (c) aVar;
            this.EUa = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.f.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(99918);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue != 1.0f) {
                        f.this.EUm.ExX.setScaleX(floatValue);
                        f.this.EUm.ExX.setScaleY(floatValue);
                        f.this.EUm.ExX.setAlpha(floatValue);
                    }
                    AppMethodBeat.o(99918);
                }
            });
            this.EUa.setDuration(400L);
            this.EUa.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.f.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                }
            });
            this.EUb = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.f.AnonymousClass3 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(179331);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    f.this.EUm.wnX.setAlpha(floatValue);
                    f.this.EUm.EVh.setAlpha(floatValue);
                    AppMethodBeat.o(179331);
                }
            });
            this.EUb.setDuration(100L);
            this.CPA = new AnimatorSet();
            this.CPA.playTogether(this.EUa, this.EUb);
            this.CPA.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.f.AnonymousClass4 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(179332);
                    Log.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation start");
                    AppMethodBeat.o(179332);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(179333);
                    Log.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation end");
                    f.this.EUm.ExX.setScaleX(1.0f);
                    f.this.EUm.ExX.setScaleY(1.0f);
                    f.this.EUm.ExX.setAlpha(1.0f);
                    f.this.EUm.wnX.setAlpha(1.0f);
                    f.this.EUm.EVh.setAlpha(1.0f);
                    if (f.this.ETY != null) {
                        f.this.ETY.onAnimationEnd();
                    }
                    if (f.this.EUm.EUK.EwA) {
                        if (f.this.EUm.EUK.Ewt.getVisibility() == 0) {
                            f.this.EUm.EUK.Ewt.aT(0, false);
                            Log.i("MicroMsg.FullCardAdDetailClickAnimation", "seek newVideoView to 0");
                            AppMethodBeat.o(179333);
                            return;
                        }
                    } else if (f.this.EUm.EUK.Ews.getVisibility() == 0) {
                        f.this.EUm.EUK.Ews.Dnr.clear();
                        Log.i("MicroMsg.FullCardAdDetailClickAnimation", "seek sightView to 0");
                    }
                    AppMethodBeat.o(179333);
                }
            });
            AppMethodBeat.o(99922);
        } catch (Throwable th) {
            Log.e("MicroMsg.FullCardAdDetailClickAnimation", "init exp=" + th.toString());
            AppMethodBeat.o(99922);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.a.b
    public final void JW(long j2) {
        AppMethodBeat.i(99923);
        if (this.CPA != null && !this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(99923);
    }
}
