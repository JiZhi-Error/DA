package com.tencent.mm.plugin.flash.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.f.h;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flash.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class FaceNumberLayout extends LinearLayout {
    private static final int wIO = a.dKX();
    private int currentIndex;
    private int jcu;
    private d wIP;
    private Runnable wIQ;

    public FaceNumberLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceNumberLayout(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    private FaceNumberLayout(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, 0);
        AppMethodBeat.i(186709);
        this.currentIndex = 0;
        this.jcu = 0;
        this.wIQ = new Runnable() {
            /* class com.tencent.mm.plugin.flash.view.FaceNumberLayout.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(186708);
                Log.i("MicroMsg.FaceFlashManagerNumberView", "showNumberRunnable current index:%s", Integer.valueOf(FaceNumberLayout.this.currentIndex));
                if (FaceNumberLayout.this.getChildAt(FaceNumberLayout.this.currentIndex) != null) {
                    FaceNumberView faceNumberView = (FaceNumberView) FaceNumberLayout.this.getChildAt(FaceNumberLayout.this.currentIndex);
                    Log.i("MicroMsg.FaceFlashManagerNumberView", "show");
                    faceNumberView.wIS.setVisibility(4);
                    faceNumberView.wIT.clearAnimation();
                    faceNumberView.wIU.setFillAfter(true);
                    faceNumberView.wIU.setDuration(500);
                    faceNumberView.wIT.startAnimation(faceNumberView.wIU);
                    faceNumberView.wIT.setVisibility(0);
                    FaceNumberLayout.this.currentIndex++;
                    if (FaceNumberLayout.this.currentIndex <= FaceNumberLayout.this.jcu) {
                        FaceNumberLayout.this.wIP = h.RTc.n(FaceNumberLayout.this.wIQ, (long) FaceNumberLayout.wIO);
                    }
                }
                AppMethodBeat.o(186708);
            }
        };
        AppMethodBeat.o(186709);
    }

    static {
        AppMethodBeat.i(186713);
        AppMethodBeat.o(186713);
    }

    public void setNumbers(String str) {
        AppMethodBeat.i(186710);
        Log.i("MicroMsg.FaceFlashManagerNumberView", "setNumbers %s", str);
        this.jcu = str.length();
        this.currentIndex = getChildCount();
        setWeightSum((float) this.jcu);
        for (int i2 = 0; i2 < this.jcu; i2++) {
            FaceNumberView faceNumberView = new FaceNumberView(getContext());
            faceNumberView.setNumber(String.valueOf(str.charAt(i2)));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 1;
            addView(faceNumberView, layoutParams);
        }
        AppMethodBeat.o(186710);
    }

    public final void dLn() {
        AppMethodBeat.i(186711);
        Log.i("MicroMsg.FaceFlashManagerNumberView", "startShowNumber");
        if (this.wIP != null && !this.wIP.isDone() && !this.wIP.isCancelled()) {
            this.wIP.cancel(true);
        }
        this.wIP = h.RTc.aV(this.wIQ);
        AppMethodBeat.o(186711);
    }

    public final void release() {
        AppMethodBeat.i(186712);
        Log.i("MicroMsg.FaceFlashManagerNumberView", "release");
        if (this.wIP != null && !this.wIP.isDone() && !this.wIP.isCancelled()) {
            this.wIP.cancel(true);
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ((FaceNumberView) getChildAt(i2)).release();
        }
        AppMethodBeat.o(186712);
    }
}
