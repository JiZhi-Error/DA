package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;

public final class j extends a {
    AnimatorSet CPA;
    p.b EUH;
    private ValueAnimator EUa;
    private ValueAnimator EUb;
    ViewGroup EUc;
    FrameLayout.LayoutParams EUj;
    LinearLayout.LayoutParams EUu;
    int[] wrA = new int[2];

    public j(MMActivity mMActivity, BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(99996);
        this.activity = mMActivity;
        this.EUH = (p.b) baseViewHolder;
        this.EUa = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.j.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99991);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Log.i("MicroMsg.TurnCardAdBackAnimation", "value %f", Float.valueOf(floatValue));
                if (floatValue != 0.0f) {
                    j.this.EUH.EZD.setScaleX(floatValue);
                    j.this.EUH.EZD.setScaleY(floatValue);
                    j.this.EUH.EZD.setAlpha(floatValue);
                }
                AppMethodBeat.o(99991);
            }
        });
        this.EUa.setDuration(400L);
        this.EUa.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.j.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(99992);
                if (j.this.EUH.hho) {
                    Log.i("MicroMsg.TurnCardAdBackAnimation", "holder is busy");
                    Iterator<Animator> it = j.this.CPA.getChildAnimations().iterator();
                    while (it.hasNext()) {
                        it.next().cancel();
                    }
                    AppMethodBeat.o(99992);
                    return;
                }
                j.this.EUH.hho = true;
                j.this.EUH.wnX.setAlpha(0.0f);
                j.this.EUH.EVh.setAlpha(0.0f);
                j.this.EUH.EZD.getLocationInWindow(j.this.wrA);
                Log.i("MicroMsg.TurnCardAdBackAnimation", "location in window %s, %s", Integer.valueOf(j.this.wrA[0]), Integer.valueOf(j.this.wrA[1]));
                j.this.EUH.EWC.removeView(j.this.EUH.EZD);
                ViewGroup.LayoutParams layoutParams = j.this.EUH.EWC.getLayoutParams();
                layoutParams.width = j.this.EUH.EZD.getWidth();
                layoutParams.height = j.this.EUH.EZD.getHeight() + j.this.EUu.topMargin + j.this.EUu.bottomMargin;
                j.this.EUH.EWC.setLayoutParams(layoutParams);
                j.this.EUj = new FrameLayout.LayoutParams(-2, -2);
                j.this.EUj.leftMargin = j.this.wrA[0];
                j.this.EUj.rightMargin = (j.this.EUc.getWidth() - j.this.EUj.leftMargin) - j.this.EUH.EZD.getWidth();
                j.this.EUj.topMargin = j.this.wrA[1];
                j.this.EUj.bottomMargin = (j.this.EUc.getHeight() - j.this.EUj.topMargin) - j.this.EUH.EZD.getHeight();
                j.this.EUc.addView(j.this.EUH.EZD, j.this.EUj);
                AppMethodBeat.o(99992);
            }
        });
        this.EUb = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.j.AnonymousClass3 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99993);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                j.this.EUH.wnX.setAlpha(floatValue);
                j.this.EUH.EVh.setAlpha(floatValue);
                AppMethodBeat.o(99993);
            }
        });
        this.EUb.setDuration(100L);
        this.EUb.setStartDelay(300);
        this.EUu = (LinearLayout.LayoutParams) this.EUH.EZD.getLayoutParams();
        this.EUc = (FrameLayout) this.activity.getBodyView().getParent();
        this.CPA = new AnimatorSet();
        this.CPA.playTogether(this.EUa, this.EUb);
        this.CPA.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.j.AnonymousClass4 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(99994);
                Log.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation start");
                AppMethodBeat.o(99994);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(99995);
                Log.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation end");
                ((ViewGroup) j.this.EUH.EZD.getParent()).removeView(j.this.EUH.EZD);
                j.this.EUH.EWC.addView(j.this.EUH.EZD, j.this.EUu);
                j.this.EUH.EZD.setScaleX(1.0f);
                j.this.EUH.EZD.setScaleY(1.0f);
                j.this.EUH.EZD.setAlpha(1.0f);
                j.this.EUH.wnX.setAlpha(1.0f);
                j.this.EUH.EVh.setAlpha(1.0f);
                if (j.this.ETY != null) {
                    j.this.ETY.onAnimationEnd();
                }
                j.this.EUH.hho = false;
                AppMethodBeat.o(99995);
            }
        });
        AppMethodBeat.o(99996);
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.b.a
    public final void JW(long j2) {
        AppMethodBeat.i(99997);
        if (!this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(99997);
    }
}
