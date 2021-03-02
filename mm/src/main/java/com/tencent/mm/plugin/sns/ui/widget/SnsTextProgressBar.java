package com.tencent.mm.plugin.sns.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.i;

public class SnsTextProgressBar extends ProgressBar {
    private String FfU;
    private int HH;
    private int mAk;
    private Context mContext;
    private Paint mPaint;
    private String mText;

    public SnsTextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(100565);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, i.a.SnsTextProgressBar, 0, 0);
        try {
            setTextSize(obtainStyledAttributes.getInteger(0, 18));
        } finally {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(100565);
        }
    }

    public void setProgress(int i2) {
        AppMethodBeat.i(100566);
        setText(i2);
        super.setProgress(i2);
        AppMethodBeat.o(100566);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public synchronized void onDraw(Canvas canvas) {
        int i2;
        AppMethodBeat.i(100567);
        super.onDraw(canvas);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        if (this.FfU == null || this.FfU.length() <= 0) {
            i2 = this.mContext.getResources().getColor(R.color.ag4);
        } else {
            i2 = Color.parseColor(this.FfU);
        }
        this.mPaint.setColor(i2);
        this.mPaint.setTextSize((float) this.mAk);
        Rect rect = new Rect();
        this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        canvas.drawText(this.mText, (float) ((getWidth() / 2) - rect.centerX()), (float) ((getHeight() / 2) - rect.centerY()), this.mPaint);
        AppMethodBeat.o(100567);
    }

    public void setTextSize(int i2) {
        AppMethodBeat.i(100568);
        this.mAk = a.fromDPToPix(this.mContext, i2);
        AppMethodBeat.o(100568);
    }

    private void setText(int i2) {
        AppMethodBeat.i(100569);
        this.HH = i2;
        this.mText = String.valueOf(i2) + "%";
        AppMethodBeat.o(100569);
    }

    public void setPaintColor(String str) {
        this.FfU = str;
    }
}
