package com.tencent.mm.plugin.sns.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.at;

public class ImageIndicatorView extends View {
    public int FdA = 0;
    private int maZ = 0;
    private Paint paint = new Paint();
    private int radius = 0;

    public ImageIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(203980);
        init();
        AppMethodBeat.o(203980);
    }

    public ImageIndicatorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(203981);
        init();
        AppMethodBeat.o(203981);
    }

    private void init() {
        AppMethodBeat.i(203982);
        this.maZ = at.fromDPToPix(getContext(), 4);
        this.radius = at.fromDPToPix(getContext(), 2);
        AppMethodBeat.o(203982);
    }

    public final void aan(int i2) {
        this.FdA = i2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(203983);
        if (this.FdA > 0) {
            int measuredWidth = getMeasuredWidth() / 2;
            if (this.FdA > 1) {
                measuredWidth -= ((this.FdA * (this.radius + this.radius)) + ((this.FdA - 1) * this.maZ)) / 2;
            }
            for (int i2 = 0; i2 < this.FdA; i2++) {
                if (i2 == 0) {
                    this.paint.setColor(getContext().getResources().getColor(R.color.Orange_100));
                } else {
                    this.paint.setColor(getContext().getResources().getColor(R.color.BW_90));
                }
                canvas.drawCircle((float) (((this.maZ + this.radius + this.radius) * i2) + measuredWidth), (float) (((getMeasuredHeight() - (getPaddingBottom() + getPaddingTop())) / 2) + getPaddingTop()), (float) this.radius, this.paint);
            }
        }
        AppMethodBeat.o(203983);
    }
}
