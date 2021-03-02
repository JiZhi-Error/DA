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
import com.tencent.mm.ui.ao;
import com.tencent.tinker.loader.shareutil.ShareConstants;

public class ProgressImageView extends AppCompatImageView {
    private int HH = -1;
    private Paint mPaint = new Paint();
    private boolean qMA;
    boolean qMB;
    private int qMC;

    public ProgressImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(183821);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        AppMethodBeat.o(183821);
    }

    public void setProgress(int i2) {
        AppMethodBeat.i(183822);
        this.HH = i2;
        this.qMA = false;
        this.qMB = false;
        postInvalidate();
        AppMethodBeat.o(183822);
    }

    public final void cCo() {
        AppMethodBeat.i(183823);
        this.qMA = true;
        this.qMB = false;
        if (ao.isDarkMode()) {
            setImageResource(R.drawable.apk);
            AppMethodBeat.o(183823);
            return;
        }
        setImageResource(R.drawable.apl);
        AppMethodBeat.o(183823);
    }

    public final void cCp() {
        AppMethodBeat.i(184793);
        this.qMB = true;
        this.qMA = false;
        setImageResource("download_wait_wifi");
        AppMethodBeat.o(184793);
    }

    public void setImageResource(String str) {
        AppMethodBeat.i(183824);
        if (ao.isDarkMode()) {
            str = str + "_dark";
        }
        setImageResource(getResources().getIdentifier(str, ShareConstants.DEXMODE_RAW, getContext().getPackageName()));
        AppMethodBeat.o(183824);
    }

    public void setProgressColor(int i2) {
        this.qMC = i2;
    }

    @Override // android.support.v7.widget.AppCompatImageView
    public void setImageResource(int i2) {
        AppMethodBeat.i(183825);
        super.setImageResource(i2);
        AppMethodBeat.o(183825);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(183826);
        super.onDraw(canvas);
        if (this.qMA || this.HH == -1 || this.qMC == 0) {
            AppMethodBeat.o(183826);
            return;
        }
        float fromDPToPix = (float) a.fromDPToPix(getContext(), 2);
        this.mPaint.setStrokeWidth(fromDPToPix);
        float width = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        float width2 = ((float) (getWidth() / 2)) - (fromDPToPix / 2.0f);
        this.mPaint.setColor(b.n(getContext(), R.color.FG_3));
        canvas.drawCircle(width, height, width2, this.mPaint);
        this.mPaint.setColor(b.n(getContext(), this.qMC));
        canvas.drawArc(width - width2, height - width2, width + width2, height + width2, -90.0f, (((float) this.HH) / 100.0f) * 360.0f, false, this.mPaint);
        AppMethodBeat.o(183826);
    }
}
