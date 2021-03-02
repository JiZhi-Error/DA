package com.tencent.mm.plugin.sns.ad.widget.a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.ad.i.h;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsListener;

public final class e extends a {
    protected int DBc;
    protected int DBd;

    public e(Context context, FrameLayout frameLayout, Bitmap bitmap, int i2, int i3, int i4, int i5, int i6) {
        super(context, frameLayout, bitmap, i2, i3, i4, i5, i6);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ad.widget.a.a
    public final void c(View view, int i2, int i3, int i4) {
        AppMethodBeat.i(202454);
        if (this.DBc == 0) {
            this.DBc = a.fromDPToPix(this.mContext, (int) TXLiveConstants.RENDER_ROTATION_180);
        }
        if (this.DBd == 0) {
            this.DBd = a.fromDPToPix(this.mContext, (int) TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
        }
        int i5 = (this.DAR + this.mMaxSize) - i2;
        int al = (i5 * 1000) / ((int) h.al((float) this.DBc, (float) this.DBd));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration((long) ((int) h.al(0.0f, (float) this.atU)));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, (float) i5);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.setDuration((long) al);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat2).after(ofFloat);
        animatorSet.start();
        AppMethodBeat.o(202454);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ad.widget.a.a
    public final Rect eYz() {
        boolean z;
        AppMethodBeat.i(202455);
        Rect rect = new Rect();
        int i2 = 0;
        while (true) {
            int al = (int) h.al((float) this.DAQ, (float) this.mMaxSize);
            a(rect, (int) h.al((float) (-this.mMaxSize), (float) (-this.mMaxSize)), (int) h.al((float) (al / 2), (float) (this.DAS - (al / 2))), al);
            int i3 = 0;
            while (true) {
                if (i3 >= this.DAW.size()) {
                    z = false;
                    break;
                } else if (Rect.intersects((Rect) this.DAW.get(i3), rect)) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                AppMethodBeat.o(202455);
                return rect;
            }
            int i4 = i2 + 1;
            if (i4 > 20) {
                AppMethodBeat.o(202455);
                return rect;
            }
            i2 = i4;
        }
    }
}
