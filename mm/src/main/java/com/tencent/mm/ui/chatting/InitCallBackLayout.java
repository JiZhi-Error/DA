package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InitCallBackLayout extends FrameLayout {
    private ar OLl;
    private boolean hasDrawed;

    public InitCallBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(34834);
        super.onDraw(canvas);
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.OLl != null) {
                this.OLl.dSa();
            }
        }
        AppMethodBeat.o(34834);
    }

    public void setListener(ar arVar) {
        this.OLl = arVar;
    }
}
