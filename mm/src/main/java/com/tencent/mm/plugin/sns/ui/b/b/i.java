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

public final class i extends b {
    AnimatorSet CPA;
    n.a EUE;
    private ValueAnimator EUa;
    private ValueAnimator EUb;

    public i(MMActivity mMActivity, BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(99989);
        try {
            this.activity = mMActivity;
            this.EUE = (n.a) baseViewHolder;
            this.EUa = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.i.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(99984);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue != 1.0f) {
                        i.this.EUE.ExX.setScaleX(floatValue);
                        i.this.EUE.ExX.setScaleY(floatValue);
                        i.this.EUE.ExX.setAlpha(floatValue);
                    }
                    AppMethodBeat.o(99984);
                }
            });
            this.EUa.setDuration(400L);
            this.EUa.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.i.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(99985);
                    if (i.this.EUE.hho) {
                        Log.i("MicroMsg.SphereCardAdClickAnimation", "holder is busy");
                        i iVar = i.this;
                        if (iVar.CPA != null) {
                            iVar.CPA.end();
                        }
                        AppMethodBeat.o(99985);
                        return;
                    }
                    i.this.EUE.hho = true;
                    AppMethodBeat.o(99985);
                }
            });
            this.EUb = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.i.AnonymousClass3 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(99986);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    i.this.EUE.wnX.setAlpha(floatValue);
                    i.this.EUE.EVh.setAlpha(floatValue);
                    AppMethodBeat.o(99986);
                }
            });
            this.EUb.setDuration(100L);
            this.CPA = new AnimatorSet();
            this.CPA.playTogether(this.EUa, this.EUb);
            this.CPA.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.i.AnonymousClass4 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(99987);
                    Log.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation start");
                    AppMethodBeat.o(99987);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(99988);
                    Log.i("MicroMsg.SphereCardAdClickAnimation", "onAnimation end");
                    i.this.EUE.ExX.setScaleX(1.0f);
                    i.this.EUE.ExX.setScaleY(1.0f);
                    i.this.EUE.ExX.setAlpha(1.0f);
                    i.this.EUE.wnX.setAlpha(1.0f);
                    i.this.EUE.EVh.setAlpha(1.0f);
                    if (i.this.ETY != null) {
                        i.this.ETY.onAnimationEnd();
                    }
                    i.this.EUE.EZp.feu();
                    i.this.EUE.EZp.Ejd.requestRender();
                    i.this.EUE.hho = false;
                    AppMethodBeat.o(99988);
                }
            });
            AppMethodBeat.o(99989);
        } catch (Throwable th) {
            Log.e("MicroMsg.SphereCardAdClickAnimation", "init exp=" + th.toString());
            AppMethodBeat.o(99989);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.b.b
    public final void JW(long j2) {
        AppMethodBeat.i(99990);
        if (this.CPA != null && !this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(99990);
    }
}
