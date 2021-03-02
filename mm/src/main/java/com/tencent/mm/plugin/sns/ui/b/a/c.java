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
import com.tencent.mm.plugin.sns.ui.c.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;

public final class c extends a {
    private AnimatorSet CPA;
    b ETZ;
    private ValueAnimator EUa;
    private ValueAnimator EUb;
    ViewGroup EUc;
    LinearLayout.LayoutParams EUd;
    LinearLayout.LayoutParams EUe;
    LinearLayout.LayoutParams EUf;
    FrameLayout.LayoutParams EUg;
    int[] wrA = new int[2];

    public c(final MMActivity mMActivity, final a aVar) {
        AppMethodBeat.i(99904);
        this.activity = mMActivity;
        this.ETZ = (b) aVar;
        this.EUa = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.a.c.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99900);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != 0.0f) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.ETZ.contentView.getLayoutParams();
                    layoutParams.leftMargin = (int) (((float) c.this.EUg.leftMargin) * floatValue);
                    layoutParams.rightMargin = (int) (((float) c.this.EUg.rightMargin) * floatValue);
                    layoutParams.topMargin = (int) (((float) c.this.EUg.topMargin) * floatValue);
                    layoutParams.bottomMargin = (int) (((float) c.this.EUg.bottomMargin) * floatValue);
                    layoutParams.width = (c.this.EUc.getWidth() - layoutParams.leftMargin) - layoutParams.rightMargin;
                    layoutParams.height = (c.this.EUc.getHeight() - layoutParams.topMargin) - layoutParams.bottomMargin;
                    c.this.ETZ.contentView.setLayoutParams(layoutParams);
                    c.this.ETZ.contentView.setAlpha(floatValue);
                    c.this.ETZ.EUV.setScaleX(floatValue);
                    c.this.ETZ.EUV.setScaleY(floatValue);
                    c.this.ETZ.EUV.setAlpha(floatValue);
                }
                AppMethodBeat.o(99900);
            }
        });
        this.EUa.setDuration(400L);
        this.EUb = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.a.c.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99901);
                c.this.ETZ.EUW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AppMethodBeat.o(99901);
            }
        });
        this.EUb.setDuration(100L);
        this.EUb.setStartDelay(300);
        this.EUd = (LinearLayout.LayoutParams) this.ETZ.contentView.getLayoutParams();
        this.EUe = (LinearLayout.LayoutParams) this.ETZ.EUV.getLayoutParams();
        this.EUf = (LinearLayout.LayoutParams) this.ETZ.EUW.getLayoutParams();
        this.CPA = new AnimatorSet();
        this.CPA.playTogether(this.EUa, this.EUb);
        this.EUc = (FrameLayout) mMActivity.getBodyView().getParent();
        this.CPA.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.b.a.c.AnonymousClass3 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(99902);
                Log.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation start");
                c.this.ETZ.contentView.getLocationInWindow(c.this.wrA);
                Log.i("MicroMsg.CardAdDetailBackAnimation", "card container location in window %s, %s", Integer.valueOf(c.this.wrA[0]), Integer.valueOf(c.this.wrA[1]));
                c.this.EUg = new FrameLayout.LayoutParams(-2, -2);
                c.this.EUg.leftMargin = c.this.wrA[0];
                c.this.EUg.rightMargin = (c.this.EUc.getWidth() - c.this.EUg.leftMargin) - c.this.ETZ.contentView.getWidth();
                c.this.EUg.topMargin = c.this.wrA[1] - ao.getStatusBarHeight(mMActivity);
                c.this.EUg.bottomMargin = (c.this.EUc.getHeight() - c.this.EUg.topMargin) - c.this.ETZ.contentView.getHeight();
                int[] iArr = new int[2];
                c.this.ETZ.EUV.getLocationInWindow(iArr);
                Log.i("MicroMsg.CardAdDetailBackAnimation", "media container location in window %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = iArr[0];
                layoutParams.rightMargin = (c.this.EUc.getWidth() - layoutParams.leftMargin) - c.this.ETZ.EUV.getWidth();
                layoutParams.topMargin = iArr[1] - ao.getStatusBarHeight(mMActivity);
                layoutParams.bottomMargin = (c.this.EUc.getHeight() - layoutParams.topMargin) - c.this.ETZ.EUV.getHeight();
                int[] iArr2 = new int[2];
                c.this.ETZ.EUW.getLocationInWindow(iArr2);
                Log.i("MicroMsg.CardAdDetailBackAnimation", "other container location in window %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams2.leftMargin = iArr2[0];
                layoutParams2.rightMargin = (c.this.EUc.getWidth() - layoutParams2.leftMargin) - ((b) aVar).EUW.getWidth();
                layoutParams2.topMargin = iArr2[1] - ao.getStatusBarHeight(mMActivity);
                layoutParams2.bottomMargin = (c.this.EUc.getHeight() - layoutParams2.topMargin) - ((b) aVar).EUW.getHeight();
                ViewGroup.LayoutParams layoutParams3 = c.this.ETZ.EAV.getLayoutParams();
                layoutParams3.width = c.this.ETZ.contentView.getWidth();
                layoutParams3.height = c.this.ETZ.contentView.getHeight() + c.this.EUd.topMargin + c.this.EUd.bottomMargin;
                c.this.ETZ.EAV.setLayoutParams(layoutParams3);
                c.this.ETZ.EUW.setAlpha(0.0f);
                ((ViewGroup) c.this.ETZ.EAV).removeView(c.this.ETZ.contentView);
                c.this.EUc.addView(c.this.ETZ.contentView, new FrameLayout.LayoutParams(-1, -1));
                ((ViewGroup) c.this.ETZ.contentView).removeView(c.this.ETZ.EUV);
                c.this.EUc.addView(c.this.ETZ.EUV, layoutParams);
                ((ViewGroup) c.this.ETZ.contentView).removeView(c.this.ETZ.EUW);
                c.this.EUc.addView(c.this.ETZ.EUW, layoutParams2);
                c.this.ETZ.EUV.setScaleX(0.0f);
                c.this.ETZ.EUV.setScaleY(0.0f);
                c.this.ETZ.EUV.setAlpha(0.0f);
                AppMethodBeat.o(99902);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(99903);
                Log.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation end");
                ((ViewGroup) mMActivity.getBodyView().getParent()).removeView(c.this.ETZ.contentView);
                ((ViewGroup) mMActivity.getBodyView().getParent()).removeView(c.this.ETZ.EUV);
                ((ViewGroup) mMActivity.getBodyView().getParent()).removeView(c.this.ETZ.EUW);
                c.this.ETZ.EUV.setScaleX(1.0f);
                c.this.ETZ.EUV.setScaleY(1.0f);
                c.this.ETZ.EUV.setAlpha(1.0f);
                ((ViewGroup) c.this.ETZ.EAV).addView(c.this.ETZ.contentView, c.this.EUd);
                ((ViewGroup) c.this.ETZ.contentView).addView(c.this.ETZ.EUV, c.this.EUe);
                ((ViewGroup) c.this.ETZ.contentView).addView(c.this.ETZ.EUW, c.this.EUf);
                c.this.ETZ.contentView.setAlpha(1.0f);
                c.this.ETZ.EUW.setAlpha(1.0f);
                if (c.this.ETY != null) {
                    c.this.ETY.onAnimationEnd();
                }
                AppMethodBeat.o(99903);
            }
        });
        AppMethodBeat.o(99904);
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.a.a
    public final void JW(long j2) {
        AppMethodBeat.i(99905);
        if (!this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(99905);
    }
}
