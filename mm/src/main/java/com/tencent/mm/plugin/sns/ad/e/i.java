package com.tencent.mm.plugin.sns.ad.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    protected View DsR;
    protected View DsS;
    protected AnimatorSet DsT;
    protected AnimatorSet DsU;
    protected boolean DsV;
    protected boolean DsW;
    private final int dgM = 500;
    protected Context mContext;
    protected boolean nmN = false;

    public i(View view, View view2, Context context, boolean z) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        AppMethodBeat.i(201937);
        this.DsR = view;
        this.DsS = view2;
        this.mContext = context;
        this.DsW = z;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat((Object) null, "alpha", 1.0f, 0.0f);
        ofFloat4.setDuration(0L);
        if (this.DsW) {
            ofFloat = ObjectAnimator.ofFloat((Object) null, "rotationY", -180.0f, 10.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat((Object) null, "rotationY", 180.0f, -10.0f);
        }
        ofFloat.setDuration(500L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat((Object) null, "alpha", 0.0f, 1.0f);
        ofFloat5.setDuration(0L);
        ofFloat5.setStartDelay(250);
        if (this.DsW) {
            ofFloat2 = ObjectAnimator.ofFloat((Object) null, "rotationY", 10.0f, 0.0f);
        } else {
            ofFloat2 = ObjectAnimator.ofFloat((Object) null, "rotationY", -10.0f, 0.0f);
        }
        ofFloat2.setDuration(500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat4).with(ofFloat).with(ofFloat5);
        animatorSet.play(ofFloat2).after(ofFloat);
        this.DsT = animatorSet;
        if (this.DsW) {
            ofFloat3 = ObjectAnimator.ofFloat((Object) null, "rotationY", 0.0f, 190.0f);
        } else {
            ofFloat3 = ObjectAnimator.ofFloat((Object) null, "rotationY", 0.0f, -190.0f);
        }
        ofFloat3.setDuration(500L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat((Object) null, "alpha", 1.0f, 0.0f);
        ofFloat6.setDuration(0L);
        ofFloat6.setStartDelay(250);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(ofFloat3).with(ofFloat6);
        this.DsU = animatorSet2;
        this.DsT.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ad.e.i.AnonymousClass1 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(201935);
                super.onAnimationStart(animator);
                i.this.nmN = true;
                AppMethodBeat.o(201935);
            }
        });
        this.DsU.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.sns.ad.e.i.AnonymousClass2 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(201936);
                super.onAnimationEnd(animator);
                i.this.nmN = false;
                AppMethodBeat.o(201936);
            }
        });
        float f2 = this.DsR.getContext().getResources().getDisplayMetrics().density * -3000.0f;
        this.DsR.setCameraDistance(f2);
        this.DsS.setCameraDistance(f2);
        AppMethodBeat.o(201937);
    }

    public final void eWQ() {
        AppMethodBeat.i(201938);
        if (!this.nmN) {
            if (!this.DsV) {
                this.DsT.setTarget(this.DsR);
                this.DsU.setTarget(this.DsS);
                this.DsT.start();
                this.DsU.start();
                this.DsV = true;
                AppMethodBeat.o(201938);
                return;
            }
            this.DsT.setTarget(this.DsS);
            this.DsU.setTarget(this.DsR);
            this.DsT.start();
            this.DsU.start();
            this.DsV = false;
        }
        AppMethodBeat.o(201938);
    }
}
