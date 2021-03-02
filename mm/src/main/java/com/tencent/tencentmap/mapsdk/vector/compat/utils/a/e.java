package com.tencent.tencentmap.mapsdk.vector.compat.utils.a;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private int f2840a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f2841b = 0;

    public e(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(199492);
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int max = Math.max(measuredWidth, measuredHeight);
        if (measuredWidth > measuredHeight) {
            this.f2840a = measuredWidth - measuredHeight;
            this.f2841b = 0;
        } else {
            this.f2840a = 0;
            this.f2841b = measuredHeight - measuredWidth;
        }
        setMeasuredDimension(max, max);
        AppMethodBeat.o(199492);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(199493);
        canvas.translate((float) (this.f2841b / 2), (float) (this.f2840a / 2));
        super.draw(canvas);
        AppMethodBeat.o(199493);
    }
}
