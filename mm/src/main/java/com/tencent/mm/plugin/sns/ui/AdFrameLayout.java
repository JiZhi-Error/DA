package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMFrameLayout;

public class AdFrameLayout extends MMFrameLayout {
    public AdFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void addView(View view) {
        AppMethodBeat.i(97666);
        super.addView(view);
        AppMethodBeat.o(97666);
    }

    public void removeView(View view) {
        AppMethodBeat.i(97667);
        super.removeView(view);
        AppMethodBeat.o(97667);
    }

    public void requestLayout() {
        AppMethodBeat.i(97668);
        super.requestLayout();
        AppMethodBeat.o(97668);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(97669);
        super.onDetachedFromWindow();
        AppMethodBeat.o(97669);
    }

    @Override // com.tencent.mm.ui.base.MMFrameLayout
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(97670);
        System.currentTimeMillis();
        super.onLayout(z, i2, i3, i4, i5);
        AppMethodBeat.o(97670);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(97671);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(97671);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(97672);
        super.draw(canvas);
        AppMethodBeat.o(97672);
    }
}
