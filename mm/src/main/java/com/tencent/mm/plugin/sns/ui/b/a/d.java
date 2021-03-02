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

public final class d extends b {
    private AnimatorSet CPA;
    b ETZ;
    private ValueAnimator EUa;
    private ValueAnimator EUb;
    ViewGroup EUc;
    LinearLayout.LayoutParams EUd;
    LinearLayout.LayoutParams EUe;
    LinearLayout.LayoutParams EUf;
    FrameLayout.LayoutParams EUj;
    int[] wrA = new int[2];

    public d(final MMActivity mMActivity, final a aVar) {
        AppMethodBeat.i(99910);
        this.activity = mMActivity;
        this.ETZ = (b) aVar;
        this.EUa = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.a.d.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99906);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (((double) floatValue) != 1.0d) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.ETZ.contentView.getLayoutParams();
                    layoutParams.leftMargin = (int) (((float) d.this.EUj.leftMargin) * floatValue);
                    layoutParams.rightMargin = (int) (((float) d.this.EUj.rightMargin) * floatValue);
                    layoutParams.topMargin = (int) (((float) d.this.EUj.topMargin) * floatValue);
                    layoutParams.bottomMargin = (int) (((float) d.this.EUj.bottomMargin) * floatValue);
                    d.this.ETZ.contentView.setLayoutParams(layoutParams);
                    d.this.ETZ.EUV.setScaleX(floatValue);
                    d.this.ETZ.EUV.setScaleY(floatValue);
                    d.this.ETZ.EUV.setAlpha(floatValue);
                }
                AppMethodBeat.o(99906);
            }
        });
        this.EUa.setDuration(400L);
        this.EUb = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.a.d.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99907);
                d.this.ETZ.EUW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AppMethodBeat.o(99907);
            }
        });
        this.EUb.setDuration(100L);
        this.EUd = (LinearLayout.LayoutParams) this.ETZ.contentView.getLayoutParams();
        this.EUe = (LinearLayout.LayoutParams) this.ETZ.EUV.getLayoutParams();
        this.EUf = (LinearLayout.LayoutParams) this.ETZ.EUW.getLayoutParams();
        this.CPA = new AnimatorSet();
        this.CPA.playTogether(this.EUa, this.EUb);
        this.EUc = (FrameLayout) mMActivity.getBodyView().getParent();
        this.CPA.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.b.a.d.AnonymousClass3 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(99908);
                Log.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation start");
                d.this.ETZ.contentView.getLocationInWindow(d.this.wrA);
                Log.i("MicroMsg.CardAdDetailClickAnimation", "card container location in window %s, %s", Integer.valueOf(d.this.wrA[0]), Integer.valueOf(d.this.wrA[1]));
                d.this.EUj = new FrameLayout.LayoutParams(-2, -2);
                d.this.EUj.leftMargin = d.this.wrA[0];
                d.this.EUj.rightMargin = (d.this.EUc.getWidth() - d.this.EUj.leftMargin) - d.this.ETZ.contentView.getWidth();
                d.this.EUj.topMargin = d.this.wrA[1] - ao.getStatusBarHeight(mMActivity);
                d.this.EUj.bottomMargin = (d.this.EUc.getHeight() - d.this.EUj.topMargin) - d.this.ETZ.contentView.getHeight();
                Log.i("MicroMsg.CardAdDetailClickAnimation", "left %s, top %s, right %s, bottom %s", Integer.valueOf(d.this.EUj.leftMargin), Integer.valueOf(d.this.EUj.topMargin), Integer.valueOf(d.this.EUj.rightMargin), Integer.valueOf(d.this.EUj.bottomMargin));
                int[] iArr = new int[2];
                d.this.ETZ.EUV.getLocationInWindow(iArr);
                Log.i("MicroMsg.CardAdDetailClickAnimation", "media container location in window %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = iArr[0];
                layoutParams.rightMargin = (d.this.EUc.getWidth() - layoutParams.leftMargin) - d.this.ETZ.EUV.getWidth();
                layoutParams.topMargin = iArr[1] - ao.getStatusBarHeight(mMActivity);
                layoutParams.bottomMargin = (d.this.EUc.getHeight() - layoutParams.topMargin) - d.this.ETZ.EUV.getHeight();
                int[] iArr2 = new int[2];
                d.this.ETZ.EUW.getLocationInWindow(iArr2);
                Log.i("MicroMsg.CardAdDetailClickAnimation", "other container location in window %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams2.leftMargin = iArr2[0];
                layoutParams2.rightMargin = (d.this.EUc.getWidth() - layoutParams2.leftMargin) - ((b) aVar).EUW.getWidth();
                layoutParams2.topMargin = iArr2[1] - ao.getStatusBarHeight(mMActivity);
                layoutParams2.bottomMargin = (d.this.EUc.getHeight() - layoutParams2.topMargin) - ((b) aVar).EUW.getHeight();
                ViewGroup.LayoutParams layoutParams3 = d.this.ETZ.EAV.getLayoutParams();
                layoutParams3.width = d.this.ETZ.contentView.getWidth();
                layoutParams3.height = d.this.ETZ.contentView.getHeight() + d.this.EUd.topMargin + d.this.EUd.bottomMargin;
                d.this.ETZ.EAV.setLayoutParams(layoutParams3);
                ((ViewGroup) d.this.ETZ.EAV).removeView(d.this.ETZ.contentView);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
                layoutParams4.leftMargin = d.this.EUj.leftMargin;
                layoutParams4.rightMargin = d.this.EUj.rightMargin;
                layoutParams4.topMargin = d.this.EUj.topMargin;
                layoutParams4.bottomMargin = d.this.EUj.bottomMargin;
                d.this.EUc.addView(d.this.ETZ.contentView, layoutParams4);
                ((ViewGroup) d.this.ETZ.contentView).removeView(d.this.ETZ.EUV);
                d.this.EUc.addView(d.this.ETZ.EUV, layoutParams);
                ((ViewGroup) d.this.ETZ.contentView).removeView(d.this.ETZ.EUW);
                d.this.EUc.addView(d.this.ETZ.EUW, layoutParams2);
                AppMethodBeat.o(99908);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(99909);
                Log.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation end");
                ((ViewGroup) mMActivity.getBodyView().getParent()).removeView(d.this.ETZ.contentView);
                ((ViewGroup) mMActivity.getBodyView().getParent()).removeView(d.this.ETZ.EUV);
                ((ViewGroup) mMActivity.getBodyView().getParent()).removeView(d.this.ETZ.EUW);
                d.this.ETZ.EUV.setScaleX(1.0f);
                d.this.ETZ.EUV.setScaleY(1.0f);
                d.this.ETZ.EUV.setAlpha(1.0f);
                ((ViewGroup) d.this.ETZ.EAV).addView(d.this.ETZ.contentView, d.this.EUd);
                ((ViewGroup) d.this.ETZ.contentView).addView(d.this.ETZ.EUV, d.this.EUe);
                ((ViewGroup) d.this.ETZ.contentView).addView(d.this.ETZ.EUW, d.this.EUf);
                d.this.ETZ.EUW.setAlpha(1.0f);
                if (d.this.ETY != null) {
                    d.this.ETY.onAnimationEnd();
                }
                AppMethodBeat.o(99909);
            }
        });
        AppMethodBeat.o(99910);
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.a.b
    public final void JW(long j2) {
        AppMethodBeat.i(99911);
        if (!this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(99911);
    }
}
