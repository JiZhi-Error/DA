package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DrawedCallBackFrameLayout extends FrameLayout {
    private a OOc;

    public interface a {
        void dSa();
    }

    public DrawedCallBackFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(141623);
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(141623);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(141624);
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
        }
        if (this.OOc != null) {
            this.OOc.dSa();
            this.OOc = null;
        }
        AppMethodBeat.o(141624);
    }

    public void setListener(a aVar) {
        this.OOc = aVar;
    }
}
