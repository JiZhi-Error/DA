package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;

public final class k extends b {
    private AnimatorSet CPA;
    private ValueAnimator EUa;
    private ValueAnimator EUb;
    ViewGroup EUc;
    FrameLayout.LayoutParams EUj;
    f EUt;
    LinearLayout.LayoutParams EUu;
    int[] wrA = new int[2];

    public k(final MMActivity mMActivity, a aVar) {
        AppMethodBeat.i(99947);
        this.activity = mMActivity;
        this.EUt = (f) aVar;
        this.EUa = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.a.k.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99943);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (((double) floatValue) != 1.0d) {
                    k.this.EUt.contentView.setScaleX(floatValue);
                    k.this.EUt.contentView.setScaleY(floatValue);
                    k.this.EUt.contentView.setAlpha(floatValue);
                }
                AppMethodBeat.o(99943);
            }
        });
        this.EUa.setDuration(400L);
        this.EUb = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.a.k.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99944);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                k.this.EUt.EWg.setAlpha(floatValue);
                k.this.EUt.EWf.setAlpha(floatValue);
                AppMethodBeat.o(99944);
            }
        });
        this.EUb.setDuration(100L);
        this.EUu = (LinearLayout.LayoutParams) this.EUt.contentView.getLayoutParams();
        this.EUc = (FrameLayout) this.activity.getBodyView().getParent();
        this.CPA = new AnimatorSet();
        this.CPA.playTogether(this.EUa, this.EUb);
        this.CPA.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.b.a.k.AnonymousClass3 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(99945);
                Log.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation start");
                k.this.EUt.contentView.getLocationInWindow(k.this.wrA);
                Log.i("MicroMsg.TurnCardAdDetailClickAnimation", "location in window %s, %s", Integer.valueOf(k.this.wrA[0]), Integer.valueOf(k.this.wrA[1]));
                ((ViewGroup) k.this.EUt.EAV).removeView(k.this.EUt.contentView);
                ViewGroup.LayoutParams layoutParams = k.this.EUt.EAV.getLayoutParams();
                layoutParams.width = k.this.EUt.contentView.getWidth();
                layoutParams.height = k.this.EUt.contentView.getHeight() + k.this.EUu.topMargin + k.this.EUu.bottomMargin;
                k.this.EUt.EAV.setLayoutParams(layoutParams);
                k.this.EUj = new FrameLayout.LayoutParams(-2, -2);
                k.this.EUj.leftMargin = k.this.wrA[0];
                k.this.EUj.rightMargin = (k.this.EUc.getWidth() - k.this.EUj.leftMargin) - k.this.EUt.contentView.getWidth();
                k.this.EUj.topMargin = k.this.wrA[1] - ao.getStatusBarHeight(mMActivity);
                k.this.EUj.bottomMargin = (k.this.EUc.getHeight() - k.this.EUj.topMargin) - k.this.EUt.contentView.getHeight();
                k.this.EUc.addView(k.this.EUt.contentView, k.this.EUj);
                AppMethodBeat.o(99945);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(99946);
                Log.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation end");
                ((ViewGroup) k.this.activity.getBodyView().getParent()).removeView(k.this.EUt.contentView);
                ((ViewGroup) k.this.EUt.EAV).addView(k.this.EUt.contentView, k.this.EUu);
                k.this.EUt.contentView.setScaleX(1.0f);
                k.this.EUt.contentView.setScaleY(1.0f);
                k.this.EUt.contentView.setAlpha(1.0f);
                k.this.EUt.EWg.setAlpha(1.0f);
                k.this.EUt.EWf.setAlpha(1.0f);
                if (k.this.ETY != null) {
                    k.this.ETY.onAnimationEnd();
                }
                AppMethodBeat.o(99946);
            }
        });
        AppMethodBeat.o(99947);
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.a.b
    public final void JW(long j2) {
        AppMethodBeat.i(99948);
        if (!this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(99948);
    }
}
