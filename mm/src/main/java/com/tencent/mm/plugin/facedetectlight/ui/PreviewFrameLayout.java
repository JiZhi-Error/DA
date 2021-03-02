package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PreviewFrameLayout extends RelativeLayout {
    private double sZu = 1.3333333333333333d;

    public PreviewFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public double getmAspectRatio() {
        return this.sZu;
    }

    public void setAspectRatio(double d2) {
        AppMethodBeat.i(104329);
        if (d2 <= 0.0d) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(104329);
            throw illegalArgumentException;
        }
        if (this.sZu != d2) {
            this.sZu = d2;
            requestLayout();
        }
        AppMethodBeat.o(104329);
    }
}
