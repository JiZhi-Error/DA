package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class g extends b {
    private AnimatorSet CPA;
    private boolean DsW;
    f.a EUA;

    public g(MMActivity mMActivity, BaseTimeLineItem.BaseViewHolder baseViewHolder, boolean z) {
        AppMethodBeat.i(203885);
        try {
            this.DsW = z;
            this.activity = mMActivity;
            if (!(baseViewHolder instanceof f.a)) {
                AppMethodBeat.o(203885);
                return;
            }
            this.EUA = (f.a) baseViewHolder;
            View view = this.EUA.ExX;
            int height = view.getHeight();
            int width = view.getWidth();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(400L);
            int[] ha = ap.ha(this.activity);
            int i4 = ha[0];
            int i5 = ha[1];
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "rotation", 0.0f, (float) (this.DsW ? 90 : -90));
            ofFloat2.setDuration(400L);
            float f2 = height != 0 ? (((float) i4) * 1.0f) / ((float) height) : 1.0f;
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, f2);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, f2);
            ofFloat3.setDuration(400L);
            ofFloat4.setDuration(400L);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, (((float) i4) / 2.0f) - ((((float) width) / 2.0f) + ((float) i2)));
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, (((float) i5) / 2.0f) - ((((float) height) / 2.0f) + ((float) i3)));
            ofFloat5.setDuration(400L);
            ofFloat6.setDuration(400L);
            ValueAnimator ofFloat7 = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat7.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.g.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(203883);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    g.this.EUA.wnX.setAlpha(floatValue);
                    g.this.EUA.EVh.setAlpha(floatValue);
                    AppMethodBeat.o(203883);
                }
            });
            ofFloat7.setDuration(100L);
            this.CPA = new AnimatorSet();
            this.CPA.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6, ofFloat7);
            this.CPA.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.b.g.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(203884);
                    g.this.fkk();
                    if (g.this.ETY != null) {
                        g.this.ETY.onAnimationEnd();
                    }
                    g.this.EUA.hho = false;
                    AppMethodBeat.o(203884);
                }
            });
            AppMethodBeat.o(203885);
        } catch (Throwable th) {
            Log.e("MicroMsg.SimpleTwistClickAnimation", "init exp=" + th.toString());
            fkk();
            AppMethodBeat.o(203885);
        }
    }

    /* access modifiers changed from: protected */
    public final void fkk() {
        AppMethodBeat.i(203886);
        Log.i("MicroMsg.SimpleTwistClickAnimation", "resetViewStatus");
        try {
            this.EUA.ExX.setScaleX(1.0f);
            this.EUA.ExX.setScaleY(1.0f);
            this.EUA.ExX.setAlpha(1.0f);
            this.EUA.ExX.setRotation(0.0f);
            this.EUA.ExX.setTranslationX(0.0f);
            this.EUA.ExX.setTranslationY(0.0f);
            this.EUA.wnX.setAlpha(1.0f);
            this.EUA.EVh.setAlpha(1.0f);
            this.EUA.EVy.setAlpha(1.0f);
            AppMethodBeat.o(203886);
        } catch (Throwable th) {
            Log.e("MicroMsg.SimpleTwistClickAnimation", "resetViewStatus exp=" + th.toString());
            AppMethodBeat.o(203886);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.b.b
    public final void JW(long j2) {
        AppMethodBeat.i(203887);
        if (this.CPA != null && !this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
            if (this.EUA.EVy.getVisibility() == 0) {
                this.EUA.EVy.setAlpha(0.0f);
            }
        }
        AppMethodBeat.o(203887);
    }
}
