package com.tencent.tencentmap.mapsdk.vector.compat.utils.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2helper;

public class RotationLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f2949a;

    public RotationLayout(Context context) {
        super(context);
    }

    public RotationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RotationLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(199494);
        if (this.f2949a == 1 || this.f2949a == 3) {
            super.onMeasure(i2, i3);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
            AppMethodBeat.o(199494);
            return;
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(199494);
    }

    public void setViewRotation(int i2) {
        this.f2949a = ((i2 + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1) / 90;
    }

    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(199495);
        if (this.f2949a == 0) {
            super.dispatchDraw(canvas);
            AppMethodBeat.o(199495);
            return;
        }
        if (this.f2949a == 1) {
            canvas.translate((float) getWidth(), 0.0f);
            canvas.rotate(90.0f, (float) (getWidth() / 2), 0.0f);
            canvas.translate((float) (getHeight() / 2), (float) (getWidth() / 2));
        } else if (this.f2949a == 2) {
            canvas.rotate(180.0f, (float) (getWidth() / 2), (float) (getHeight() / 2));
        } else {
            canvas.translate(0.0f, (float) getHeight());
            canvas.rotate(270.0f, (float) (getWidth() / 2), 0.0f);
            canvas.translate((float) (getHeight() / 2), (float) ((-getWidth()) / 2));
        }
        super.dispatchDraw(canvas);
        AppMethodBeat.o(199495);
    }
}
