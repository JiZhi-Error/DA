package com.tencent.mm.plugin.game.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public class TextProgressBar extends ProgressBar {
    private int HH;
    private int mAk;
    private Context mContext;
    private Paint mPaint;
    private String mText;

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public void setProgress(int i2) {
        AppMethodBeat.i(42625);
        setText(i2);
        super.setProgress(i2);
        AppMethodBeat.o(42625);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public synchronized void onDraw(Canvas canvas) {
        AppMethodBeat.i(42626);
        super.onDraw(canvas);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(Color.rgb(69, 192, 26));
        this.mPaint.setTextSize((float) this.mAk);
        Rect rect = new Rect();
        this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), rect);
        float width = (float) ((getWidth() / 2) - rect.centerX());
        float height = (float) ((getHeight() / 2) - rect.centerY());
        canvas.drawText(this.mText, width, height, this.mPaint);
        float width2 = (((float) this.HH) / 100.0f) * ((float) getWidth());
        if (width2 > width) {
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setAntiAlias(true);
            paint.setTextSize((float) this.mAk);
            RectF rectF = new RectF(0.0f, 0.0f, width2, (float) getHeight());
            canvas.save();
            canvas.clipRect(rectF);
            canvas.drawText(this.mText, width, height, paint);
            canvas.restore();
        }
        AppMethodBeat.o(42626);
    }

    public void setTextSize(int i2) {
        AppMethodBeat.i(42627);
        this.mAk = a.fromDPToPix(this.mContext, i2);
        AppMethodBeat.o(42627);
    }

    private void setText(int i2) {
        AppMethodBeat.i(42628);
        this.HH = i2;
        this.mText = String.valueOf(i2) + "%";
        AppMethodBeat.o(42628);
    }
}
