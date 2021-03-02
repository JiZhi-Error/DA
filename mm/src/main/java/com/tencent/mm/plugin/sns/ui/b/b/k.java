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
import com.tencent.thumbplayer.api.TPPlayerMgr;
import java.util.Iterator;

public final class k extends b {
    AnimatorSet CPA;
    p.b EUH;
    private ValueAnimator EUa;
    private ValueAnimator EUb;
    ViewGroup EUc;
    FrameLayout.LayoutParams EUj;
    LinearLayout.LayoutParams EUu;
    int[] wrA = new int[2];

    public k(MMActivity mMActivity, BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(100003);
        this.activity = mMActivity;
        this.EUH = (p.b) baseViewHolder;
        this.EUa = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.EUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.k.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99998);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Log.i("MicroMsg.TurnCardAdClickAnimation", "value %f", Float.valueOf(floatValue));
                if (floatValue != 1.0f) {
                    k.this.EUH.EZD.setScaleX(floatValue);
                    k.this.EUH.EZD.setScaleY(floatValue);
                    k.this.EUH.EZD.setAlpha(floatValue);
                }
                AppMethodBeat.o(99998);
            }
        });
        this.EUa.setDuration(400L);
        this.EUa.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.k.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(99999);
                if (k.this.EUH.hho) {
                    Log.i("MicroMsg.TurnCardAdClickAnimation", "holder is busy");
                    Iterator<Animator> it = k.this.CPA.getChildAnimations().iterator();
                    while (it.hasNext()) {
                        it.next().cancel();
                    }
                    AppMethodBeat.o(99999);
                    return;
                }
                k.this.EUH.hho = true;
                k.this.EUH.EZD.getLocationInWindow(k.this.wrA);
                Log.i("MicroMsg.TurnCardAdClickAnimation", "location in window %s, %s, %s, %s", Integer.valueOf(k.this.wrA[0]), Integer.valueOf(k.this.wrA[1]), Integer.valueOf(k.this.EUH.EZD.getWidth()), Integer.valueOf(k.this.EUH.EZD.getHeight()));
                k.this.EUH.EWC.removeView(k.this.EUH.EZD);
                ViewGroup.LayoutParams layoutParams = k.this.EUH.EWC.getLayoutParams();
                layoutParams.width = k.this.EUH.EZD.getWidth();
                layoutParams.height = k.this.EUH.EZD.getHeight() + k.this.EUu.topMargin + k.this.EUu.bottomMargin;
                k.this.EUH.EWC.setLayoutParams(layoutParams);
                k.this.EUj = new FrameLayout.LayoutParams(-2, -2);
                k.this.EUj.leftMargin = k.this.wrA[0];
                k.this.EUj.rightMargin = (k.this.EUc.getWidth() - k.this.EUj.leftMargin) - k.this.EUH.EZD.getWidth();
                k.this.EUj.topMargin = k.this.wrA[1];
                k.this.EUj.bottomMargin = (k.this.EUc.getHeight() - k.this.EUj.topMargin) - k.this.EUH.EZD.getHeight();
                k.this.EUc.addView(k.this.EUH.EZD, k.this.EUj);
                AppMethodBeat.o(99999);
            }
        });
        this.EUb = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.k.AnonymousClass3 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(100000);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                k.this.EUH.wnX.setAlpha(floatValue);
                k.this.EUH.EVh.setAlpha(floatValue);
                AppMethodBeat.o(100000);
            }
        });
        this.EUb.setDuration(100L);
        this.EUu = (LinearLayout.LayoutParams) this.EUH.EZD.getLayoutParams();
        this.EUc = (FrameLayout) this.activity.getBodyView().getParent();
        this.CPA = new AnimatorSet();
        this.CPA.playTogether(this.EUa, this.EUb);
        this.CPA.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.k.AnonymousClass4 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND);
                Log.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation start");
                AppMethodBeat.o(TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(TPPlayerMgr.EVENT_ID_APP_ENTER_FOREGROUND);
                Log.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation end");
                ((ViewGroup) k.this.EUH.EZD.getParent()).removeView(k.this.EUH.EZD);
                k.this.EUH.EWC.addView(k.this.EUH.EZD, k.this.EUu);
                k.this.EUH.EZD.setScaleX(1.0f);
                k.this.EUH.EZD.setScaleY(1.0f);
                k.this.EUH.EZD.setAlpha(1.0f);
                k.this.EUH.wnX.setAlpha(1.0f);
                k.this.EUH.EVh.setAlpha(1.0f);
                if (k.this.ETY != null) {
                    k.this.ETY.onAnimationEnd();
                }
                k.this.EUH.hho = false;
                AppMethodBeat.o(TPPlayerMgr.EVENT_ID_APP_ENTER_FOREGROUND);
            }
        });
        AppMethodBeat.o(100003);
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.b.b
    public final void JW(long j2) {
        AppMethodBeat.i(100004);
        if (!this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(100004);
    }
}
