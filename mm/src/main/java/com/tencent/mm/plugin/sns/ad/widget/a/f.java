package com.tencent.mm.plugin.sns.ad.widget.a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.h;

public final class f extends a {
    public f(Context context, FrameLayout frameLayout, Bitmap bitmap, int i2, int i3, int i4, int i5, int i6) {
        super(context, frameLayout, bitmap, i2, i3, i4, i5, i6);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ad.widget.a.a
    public final void c(View view, int i2, int i3, int i4) {
        AppMethodBeat.i(202456);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 0.0f);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration((long) ((int) h.al(0.0f, 0.8f * ((float) this.atU))));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "rotation", 0.0f, (((float) this.atU) / 1000.0f) * 180.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.setDuration((long) this.atU);
        ofFloat2.setRepeatCount(10);
        ofFloat2.start();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ofFloat3.setDuration(400L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        ofFloat4.setDuration(400L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat5.setInterpolator(new LinearInterpolator());
        ofFloat5.setDuration(400L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat3).with(ofFloat4).with(ofFloat5).with(ofFloat2).after(ofFloat);
        animatorSet.start();
        AppMethodBeat.o(202456);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ad.widget.a.a
    public final Rect eYz() {
        boolean z;
        AppMethodBeat.i(202457);
        Rect rect = new Rect();
        int i2 = 0;
        while (true) {
            int al = (int) h.al((float) this.DAQ, (float) this.mMaxSize);
            a(rect, (int) h.al((float) (al / 2), (float) (this.DAR - (al / 2))), (int) h.al((float) (al / 2), (float) (this.DAS - (al / 2))), al);
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
                AppMethodBeat.o(202457);
                return rect;
            }
            int i4 = i2 + 1;
            if (i4 > 20) {
                AppMethodBeat.o(202457);
                return rect;
            }
            i2 = i4;
        }
    }
}
