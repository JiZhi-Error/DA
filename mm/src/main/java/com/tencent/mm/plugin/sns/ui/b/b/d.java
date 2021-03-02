package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.ad.timeline.b.g;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class d extends b {
    AnimatorSet CPA = new AnimatorSet();
    a.C1738a EUx;

    public d(MMActivity mMActivity, BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(99961);
        this.activity = mMActivity;
        this.EUx = (a.C1738a) baseViewHolder;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.d.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99956);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != 1.0f) {
                    d.this.EUx.qVR.setScaleX(floatValue);
                    d.this.EUx.qVR.setScaleY(floatValue);
                    d.this.EUx.qVR.setAlpha(floatValue);
                }
                AppMethodBeat.o(99956);
            }
        });
        ofFloat.setDuration(400L);
        ofFloat.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.d.AnonymousClass2 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(99957);
                if (d.this.EUx.hho) {
                    Log.i("MicroMsg.CardAdClickAnimation", "holder is busy");
                    d.this.CPA.end();
                    AppMethodBeat.o(99957);
                    return;
                }
                d.this.EUx.hho = true;
                AppMethodBeat.o(99957);
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.d.AnonymousClass3 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(99958);
                d.this.EUx.EXY.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AppMethodBeat.o(99958);
            }
        });
        ofFloat2.setDuration(100L);
        this.CPA.playTogether(ofFloat, ofFloat2);
        this.CPA.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ui.b.b.d.AnonymousClass4 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(99959);
                Log.i("MicroMsg.CardAdClickAnimation", "onAnimation start");
                AppMethodBeat.o(99959);
            }

            public final void onAnimationEnd(Animator animator) {
                boolean z;
                AppMethodBeat.i(99960);
                Log.i("MicroMsg.CardAdClickAnimation", "onAnimation end");
                d.this.EUx.qVR.setScaleX(1.0f);
                d.this.EUx.qVR.setScaleY(1.0f);
                d.this.EUx.qVR.setAlpha(1.0f);
                d.this.EUx.EXY.setAlpha(1.0f);
                if (!d.this.EUx.EYk) {
                    TimeLineObject b2 = g.b(d.this.EUx);
                    if (b2 == null || b2.ContentObj == null) {
                        z = false;
                    } else {
                        z = b2.ContentObj.LoU == 15 || b2.ContentObj.LoU == 5;
                    }
                    if (z) {
                        d.this.EUx.EUK.Ews.Dnr.clear();
                    }
                } else if (m.G(d.this.EUx.EYj)) {
                    View childAt = d.this.EUx.EYj.getChildAt(0);
                    if (childAt instanceof OnlineVideoView) {
                        ((OnlineVideoView) childAt).aT(0, false);
                    }
                }
                if (d.this.ETY != null) {
                    d.this.ETY.onAnimationEnd();
                }
                d.this.EUx.hho = false;
                AppMethodBeat.o(99960);
            }
        });
        AppMethodBeat.o(99961);
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.b.b
    public final void JW(long j2) {
        AppMethodBeat.i(99962);
        if (!this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
        }
        AppMethodBeat.o(99962);
    }
}
