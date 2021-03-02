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

public final class j extends a {
    private AnimatorSet CPA;
    private ValueAnimator EUa;
    private ValueAnimator EUb;
    ViewGroup EUc;
    FrameLayout.LayoutParams EUj;
    f EUt;
    LinearLayout.LayoutParams EUu;
    int[] wrA = new int[2];

    public j(final MMActivity mMActivity, a aVar) {
        AppMethodBeat.i(99941);
        this.activity = mMActivity;
        this.EUt = (f) aVar;
        this.EUa = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.a.j.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99937);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != 0.0f) {
                    j.this.EUt.contentView.setScaleX(floatValue);
                    j.this.EUt.contentView.setScaleY(floatValue);
                    j.this.EUt.contentView.setAlpha(floatValue);
                }
                AppMethodBeat.o(99937);
            }
        });
        this.EUa.setDuration(400L);
        this.EUb = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.a.j.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99938);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                j.this.EUt.EWg.setAlpha(floatValue);
                j.this.EUt.EWf.setAlpha(floatValue);
                AppMethodBeat.o(99938);
            }
        });
        this.EUb.setDuration(100L);
        this.EUb.setStartDelay(300);
        this.EUu = (LinearLayout.LayoutParams) this.EUt.contentView.getLayoutParams();
        this.EUc = (FrameLayout) this.activity.getBodyView().getParent();
        this.CPA = new AnimatorSet();
        this.CPA.playTogether(this.EUa, this.EUb);
        this.CPA.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.b.a.j.AnonymousClass3 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(99939);
                Log.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation start");
                j.this.EUt.EWg.setAlpha(0.0f);
                j.this.EUt.EWf.setAlpha(0.0f);
                j.this.EUt.contentView.getLocationInWindow(j.this.wrA);
                Log.i("MicroMsg.TurnCardAdDetailBackAnimation", "location in window %s, %s", Integer.valueOf(j.this.wrA[0]), Integer.valueOf(j.this.wrA[1]));
                ((ViewGroup) j.this.EUt.EAV).removeView(j.this.EUt.contentView);
                ViewGroup.LayoutParams layoutParams = j.this.EUt.EAV.getLayoutParams();
                layoutParams.width = j.this.EUt.contentView.getWidth();
                layoutParams.height = j.this.EUt.contentView.getHeight() + j.this.EUu.topMargin + j.this.EUu.bottomMargin;
                j.this.EUt.EAV.setLayoutParams(layoutParams);
                j.this.EUj = new FrameLayout.LayoutParams(-2, -2);
                j.this.EUj.leftMargin = j.this.wrA[0];
                j.this.EUj.rightMargin = (j.this.EUc.getWidth() - j.this.EUj.leftMargin) - j.this.EUt.contentView.getWidth();
                j.this.EUj.topMargin = j.this.wrA[1] - ao.getStatusBarHeight(mMActivity);
                j.this.EUj.bottomMargin = (j.this.EUc.getHeight() - j.this.EUj.topMargin) - j.this.EUt.contentView.getHeight();
                j.this.EUc.addView(j.this.EUt.contentView, j.this.EUj);
                AppMethodBeat.o(99939);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(99940);
                Log.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation end");
                ((ViewGroup) j.this.activity.getBodyView().getParent()).removeView(j.this.EUt.contentView);
                ((ViewGroup) j.this.EUt.EAV).addView(j.this.EUt.contentView, j.this.EUu);
                j.this.EUt.contentView.setScaleX(1.0f);
                j.this.EUt.contentView.setScaleY(1.0f);
                j.this.EUt.contentView.setAlpha(1.0f);
                j.this.EUt.EWf.setAlpha(1.0f);
                j.this.EUt.EWg.setAlpha(1.0f);
                if (j.this.ETY != null) {
                    j.this.ETY.onAnimationEnd();
                }
                AppMethodBeat.o(99940);
            }
        });
        AppMethodBeat.o(99941);
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.a.a
    public final void JW(long j2) {
        AppMethodBeat.i(99942);
        if (!this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(99942);
    }
}
