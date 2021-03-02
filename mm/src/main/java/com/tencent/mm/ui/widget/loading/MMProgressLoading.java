package com.tencent.mm.ui.widget.loading;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ck.a;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.wxmm.v2helper;

public class MMProgressLoading extends View {
    private int luE;
    private int max;
    private Paint paint;
    private int progress;
    private int rHF;

    public MMProgressLoading(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(198355);
        c(context, attributeSet, 0);
        AppMethodBeat.o(198355);
    }

    public MMProgressLoading(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(198356);
        c(context, attributeSet, i2);
        AppMethodBeat.o(198356);
    }

    private void c(Context context, AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(198357);
        this.paint = new Paint();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0296a.ProgressLoading, i2, 0);
            this.luE = obtainStyledAttributes.getColor(1, getResources().getColor(R.color.am));
            this.max = obtainStyledAttributes.getInt(0, 100);
            this.progress = obtainStyledAttributes.getInt(3, 0);
            this.rHF = obtainStyledAttributes.getInt(2, -90);
            obtainStyledAttributes.recycle();
        }
        AppMethodBeat.o(198357);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(198358);
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int width2 = (int) (((double) (getWidth() / 2)) * 0.175d);
        int i2 = (width - (width2 / 2)) - 1;
        int color = getResources().getColor(R.color.a9);
        this.paint.setStrokeWidth((float) width2);
        this.paint.setColor(color);
        this.paint.setAlpha(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle((float) width, (float) width, (float) i2, this.paint);
        this.paint.setStrokeWidth((float) width2);
        this.paint.setColor(this.luE);
        this.paint.setAlpha(51);
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle((float) width, (float) width, (float) i2, this.paint);
        this.paint.setStrokeWidth((float) width2);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.paint.setColor(this.luE);
        canvas.drawArc(new RectF((float) (width - i2), (float) (width - i2), (float) (width + i2), (float) (width + i2)), (float) this.rHF, (float) ((this.progress * v2helper.VOIP_ENC_HEIGHT_LV1) / this.max), false, this.paint);
        AppMethodBeat.o(198358);
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int i2) {
        AppMethodBeat.i(198359);
        this.progress = Math.max(0, i2);
        this.progress = Math.min(i2, this.max);
        invalidate();
        AppMethodBeat.o(198359);
    }
}
