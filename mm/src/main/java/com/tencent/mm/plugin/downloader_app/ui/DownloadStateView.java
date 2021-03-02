package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.b;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;

public class DownloadStateView extends AppCompatImageView {
    private int HH;
    private Paint mPaint;
    private int qMv = -1;

    public DownloadStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setProgressColor(int i2) {
        this.qMv = i2;
    }

    public void setProgress(int i2) {
        AppMethodBeat.i(175278);
        this.HH = i2;
        postInvalidate();
        AppMethodBeat.o(175278);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(175279);
        super.onDraw(canvas);
        if (this.HH < 0) {
            AppMethodBeat.o(175279);
            return;
        }
        float fromDPToPix = (float) a.fromDPToPix(getContext(), 2);
        getWidth();
        getWidth();
        float width = ((float) getWidth()) / 2.0f;
        float height = ((float) getHeight()) / 2.0f;
        float width2 = ((float) getWidth()) - (fromDPToPix / 2.0f);
        this.mPaint.setColor(b.n(getContext(), R.color.BW_0_Alpha_0_1));
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setStrokeWidth(fromDPToPix);
        canvas.drawCircle(width, height, width2, this.mPaint);
        this.mPaint.setColor(this.qMv);
        canvas.drawArc(width - width2, height - width2, width + width2, height + width2, -90.0f, (((float) this.HH) / 100.0f) * 360.0f, false, this.mPaint);
        AppMethodBeat.o(175279);
    }
}
