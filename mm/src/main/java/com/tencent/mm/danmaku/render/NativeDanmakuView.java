package com.tencent.mm.danmaku.render;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.e.e;

public class NativeDanmakuView extends View {
    a gPX;

    public interface a {
        void ate();

        void onDestroy();

        void onDraw(Canvas canvas);
    }

    public NativeDanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NativeDanmakuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(241701);
        e.d("NativeDanmakuView", "onDraw");
        if (this.gPX != null) {
            this.gPX.onDraw(canvas);
        }
        AppMethodBeat.o(241701);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(241702);
        e.d("NativeDanmakuView", "onLayout");
        if (this.gPX != null) {
            this.gPX.ate();
        }
        AppMethodBeat.o(241702);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(241703);
        super.onDetachedFromWindow();
        if (this.gPX != null) {
            this.gPX.onDestroy();
        }
        AppMethodBeat.o(241703);
    }
}
