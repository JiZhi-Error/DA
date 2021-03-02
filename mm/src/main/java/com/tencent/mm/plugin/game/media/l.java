package com.tencent.mm.plugin.game.media;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.k;

public final class l extends k {
    private a xBz;

    /* access modifiers changed from: package-private */
    public interface a {
        void bRR();

        void dUv();
    }

    public l(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.k
    public final void l(View view, View view2) {
        AppMethodBeat.i(41064);
        super.l(view, view2);
        setPullDownBackgroundColor(-1);
        AppMethodBeat.o(41064);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.k
    public final void yM(int i2) {
        AppMethodBeat.i(41065);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nrE.getLayoutParams();
        layoutParams.topMargin = i2 - this.nrE.getHeight();
        this.nrE.setLayoutParams(layoutParams);
        AppMethodBeat.o(41065);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.k
    public final void bRR() {
        AppMethodBeat.i(41066);
        if (this.xBz != null) {
            this.xBz.bRR();
        }
        AppMethodBeat.o(41066);
    }

    public final void dUu() {
        AppMethodBeat.i(41067);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.nms, "translationY", 0.0f, (float) getStayHeight());
        ofFloat.setDuration(250L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.game.media.l.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(41063);
                l.this.yM((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
                AppMethodBeat.o(41063);
            }
        });
        bRR();
        AppMethodBeat.o(41067);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.k
    public final void bRQ() {
        AppMethodBeat.i(41068);
        super.bRQ();
        if (this.xBz != null) {
            this.xBz.dUv();
        }
        AppMethodBeat.o(41068);
    }

    public final void setOnPullDownListener(a aVar) {
        this.xBz = aVar;
    }
}
