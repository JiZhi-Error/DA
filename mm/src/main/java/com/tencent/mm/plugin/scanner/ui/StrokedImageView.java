package com.tencent.mm.plugin.scanner.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class StrokedImageView extends ImageView {
    private int color;

    public StrokedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(51997);
        this.color = context.getResources().getColor(R.color.a65);
        AppMethodBeat.o(51997);
    }

    public void setStrokeColor(int i2) {
        this.color = i2;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(51998);
        super.onDraw(canvas);
        Rect clipBounds = canvas.getClipBounds();
        clipBounds.left++;
        clipBounds.top++;
        clipBounds.bottom--;
        clipBounds.right--;
        Paint paint = new Paint();
        paint.setColor(this.color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1.5f);
        canvas.drawRect(clipBounds, paint);
        AppMethodBeat.o(51998);
    }
}
