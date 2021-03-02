package com.tencent.mm.blink;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class FirstScreenFrameLayout extends FrameLayout {
    public a gkU;

    public interface a {
        void ako();
    }

    public FirstScreenFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FirstScreenFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(131834);
        super.dispatchDraw(canvas);
        if (this.gkU != null) {
            new MMHandler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                /* class com.tencent.mm.blink.FirstScreenFrameLayout.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(131833);
                    if (FirstScreenFrameLayout.this.gkU != null) {
                        FirstScreenFrameLayout.this.gkU.ako();
                        FirstScreenFrameLayout.this.gkU = null;
                    }
                    AppMethodBeat.o(131833);
                }
            });
        }
        AppMethodBeat.o(131834);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(131835);
        super.setPadding(i2, i3, i4, i5);
        AppMethodBeat.o(131835);
    }
}
