package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a;
import com.tencent.smtt.sdk.WebView;

public class MMVerticalTextView extends View {
    Rect OTT = new Rect();
    private TextPaint ayn = new TextPaint();
    private int direction;
    private String mText;

    public MMVerticalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142251);
        this.ayn.setAntiAlias(true);
        this.ayn.setTextSize(15.0f);
        this.ayn.setColor(WebView.NIGHT_MODE_COLOR);
        this.ayn.setTextAlign(Paint.Align.CENTER);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.verticaltextview);
        int resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId != 0) {
            this.mText = context.getString(resourceId);
        }
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(4, 15);
        if (dimensionPixelOffset > 0) {
            this.ayn.setTextSize((float) dimensionPixelOffset);
        }
        this.ayn.setColor(obtainStyledAttributes.getColor(3, WebView.NIGHT_MODE_COLOR));
        this.direction = obtainStyledAttributes.getInt(0, 0);
        this.ayn.setFakeBoldText(obtainStyledAttributes.getBoolean(2, false));
        obtainStyledAttributes.recycle();
        requestLayout();
        invalidate();
        AppMethodBeat.o(142251);
    }

    public void setText(String str) {
        AppMethodBeat.i(142252);
        this.mText = str;
        requestLayout();
        invalidate();
        AppMethodBeat.o(142252);
    }

    public void setTextSize(int i2) {
        AppMethodBeat.i(142253);
        this.ayn.setTextSize((float) i2);
        requestLayout();
        invalidate();
        AppMethodBeat.o(142253);
    }

    public void setTextColor(int i2) {
        AppMethodBeat.i(142254);
        this.ayn.setColor(i2);
        invalidate();
        AppMethodBeat.o(142254);
    }

    public void setMediumBold(boolean z) {
        AppMethodBeat.i(205252);
        this.ayn.setFakeBoldText(z);
        AppMethodBeat.o(205252);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(142255);
        this.ayn.getTextBounds(this.mText, 0, this.mText.length(), this.OTT);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            int height = this.OTT.height();
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(height, size);
            } else {
                size = height;
            }
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 != 1073741824) {
            int ceil = (int) Math.ceil((double) this.ayn.measureText(this.mText));
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(ceil, size2) : ceil;
        }
        setMeasuredDimension(size, size2);
        AppMethodBeat.o(142255);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(142256);
        super.onDraw(canvas);
        int height = getHeight();
        Path path = new Path();
        if (this.direction == 0) {
            int width = (getWidth() >> 1) - (this.OTT.height() >> 1);
            path.moveTo((float) width, 0.0f);
            path.lineTo((float) width, (float) height);
        } else {
            int width2 = (getWidth() >> 1) + (this.OTT.height() >> 1);
            path.moveTo((float) width2, (float) height);
            path.lineTo((float) width2, 0.0f);
        }
        canvas.drawTextOnPath(this.mText, path, 0.0f, 0.0f, this.ayn);
        AppMethodBeat.o(142256);
    }
}
