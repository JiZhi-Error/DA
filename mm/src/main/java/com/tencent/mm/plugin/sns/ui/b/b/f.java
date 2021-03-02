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

public final class f extends b {
    AnimatorSet CPA;
    f.a EUA;
    private ValueAnimator EUa;
    private ValueAnimator EUb;

    public f(MMActivity mMActivity, BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(99975);
        try {
            this.activity = mMActivity;
            this.EUA = (f.a) baseViewHolder;
            this.EUa = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.f.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(99970);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue != 1.0f) {
                        f.this.EUA.ExX.setScaleX(floatValue);
                        f.this.EUA.ExX.setScaleY(floatValue);
                        f.this.EUA.ExX.setAlpha(floatValue);
                    }
                    AppMethodBeat.o(99970);
                }
            });
            this.EUa.setDuration(400L);
            this.EUa.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.f.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(99971);
                    if (f.this.EUA.hho) {
                        Log.i("MicroMsg.FullCardAdClickAnimation", "holder is busy");
                        f fVar = f.this;
                        if (fVar.CPA != null) {
                            fVar.CPA.end();
                        }
                        AppMethodBeat.o(99971);
                        return;
                    }
                    f.this.EUA.hho = true;
                    AppMethodBeat.o(99971);
                }
            });
            this.EUb = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.f.AnonymousClass3 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(99972);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    f.this.EUA.wnX.setAlpha(floatValue);
                    f.this.EUA.EVh.setAlpha(floatValue);
                    AppMethodBeat.o(99972);
                }
            });
            this.EUb.setDuration(100L);
            this.CPA = new AnimatorSet();
            this.CPA.playTogether(this.EUa, this.EUb);
            this.CPA.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.f.AnonymousClass4 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(99973);
                    Log.i("MicroMsg.FullCardAdClickAnimation", "onAnimation start");
                    AppMethodBeat.o(99973);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(99974);
                    Log.i("MicroMsg.FullCardAdClickAnimation", "onAnimation end");
                    f.this.EUA.ExX.setScaleX(1.0f);
                    f.this.EUA.ExX.setScaleY(1.0f);
                    f.this.EUA.ExX.setAlpha(1.0f);
                    f.this.EUA.wnX.setAlpha(1.0f);
                    f.this.EUA.EVh.setAlpha(1.0f);
                    if (f.this.ETY != null) {
                        f.this.ETY.onAnimationEnd();
                    }
                    f.this.EUA.hho = false;
                    if (f.this.EUA.EUK.EwA) {
                        if (f.this.EUA.EUK.Ewt.getVisibility() == 0) {
                            f.this.EUA.EUK.Ewt.aT(0, false);
                            Log.i("MicroMsg.FullCardAdClickAnimation", "seek newVideoView to 0");
                            AppMethodBeat.o(99974);
                            return;
                        }
                    } else if (f.this.EUA.EUK.Ews.getVisibility() == 0) {
                        f.this.EUA.EUK.Ews.Dnr.clear();
                        Log.i("MicroMsg.FullCardAdClickAnimation", "seek sightView to 0");
                    }
                    AppMethodBeat.o(99974);
                }
            });
            AppMethodBeat.o(99975);
        } catch (Throwable th) {
            Log.e("MicroMsg.FullCardAdClickAnimation", "init exp=" + th.toString());
            AppMethodBeat.o(99975);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.b.b
    public final void JW(long j2) {
        AppMethodBeat.i(99976);
        if (this.CPA != null && !this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(99976);
    }
}
