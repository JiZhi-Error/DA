package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class g extends b {
    private AnimatorSet CPA;
    private boolean DsW;
    private ValueAnimator EUb;
    c EUm;

    public g(MMActivity mMActivity, a aVar, boolean z) {
        AppMethodBeat.i(203881);
        try {
            this.activity = mMActivity;
            this.EUm = (c) aVar;
            this.DsW = z;
            View view = this.EUm.ExX;
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
            this.EUb = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.EUb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.g.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(203878);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    g.this.EUm.wnX.setAlpha(floatValue);
                    g.this.EUm.EVh.setAlpha(floatValue);
                    AppMethodBeat.o(203878);
                }
            });
            this.EUb.setDuration(100L);
            this.CPA = new AnimatorSet();
            this.CPA.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6, this.EUb);
            this.CPA.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.sns.ui.b.a.g.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(203879);
                    Log.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation start");
                    AppMethodBeat.o(203879);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(203880);
                    Log.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation end");
                    g gVar = g.this;
                    Log.i("MicroMsg.FullCardAdDetailClickAnimation", "resetViewStatus");
                    try {
                        gVar.EUm.ExX.setScaleX(1.0f);
                        gVar.EUm.ExX.setScaleY(1.0f);
                        gVar.EUm.ExX.setAlpha(1.0f);
                        gVar.EUm.ExX.setRotation(0.0f);
                        gVar.EUm.ExX.setTranslationX(0.0f);
                        gVar.EUm.ExX.setTranslationY(0.0f);
                        gVar.EUm.wnX.setAlpha(1.0f);
                        gVar.EUm.EVh.setAlpha(1.0f);
                        gVar.EUm.EVy.setAlpha(1.0f);
                    } catch (Throwable th) {
                        Log.e("MicroMsg.FullCardAdDetailClickAnimation", "resetViewStatus exp=" + th.toString());
                    }
                    if (g.this.ETY != null) {
                        g.this.ETY.onAnimationEnd();
                    }
                    AppMethodBeat.o(203880);
                }
            });
            AppMethodBeat.o(203881);
        } catch (Throwable th) {
            Log.e("MicroMsg.FullCardAdDetailClickAnimation", "init exp=" + th.toString());
            AppMethodBeat.o(203881);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.b.a.b
    public final void JW(long j2) {
        AppMethodBeat.i(203882);
        if (this.CPA != null && !this.CPA.isStarted()) {
            this.CPA.setStartDelay(j2);
            this.CPA.start();
            if (this.EUm.EVy.getVisibility() == 0) {
                this.EUm.EVy.setAlpha(0.0f);
            }
        }
        AppMethodBeat.o(203882);
    }
}
