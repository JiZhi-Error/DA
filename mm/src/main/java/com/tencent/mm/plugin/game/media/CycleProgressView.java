package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.wxmm.v2helper;

public class CycleProgressView extends View {
    private Paint paint;
    private int progress = 0;
    private float xzK;

    public CycleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(40885);
        init();
        AppMethodBeat.o(40885);
    }

    public CycleProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(40886);
        init();
        AppMethodBeat.o(40886);
    }

    private void init() {
        AppMethodBeat.i(40887);
        this.paint = new Paint();
        AppMethodBeat.o(40887);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(40888);
        super.onDraw(canvas);
        int width = getWidth() / 2;
        if (this.xzK == 0.0f) {
            this.xzK = (float) ((int) (((double) (getWidth() / 2)) * 0.167d));
        }
        int i2 = (int) (((float) width) - (this.xzK / 2.0f));
        this.paint.setStrokeWidth(this.xzK);
        this.paint.setColor(b.n(getContext(), R.color.BW_0_Alpha_0_1));
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle((float) width, (float) width, (float) i2, this.paint);
        this.paint.setStrokeWidth(this.xzK);
        this.paint.setColor(b.n(getContext(), R.color.afz));
        canvas.drawArc(new RectF((float) (width - i2), (float) (width - i2), (float) (width + i2), (float) (width + i2)), -90.0f, (float) ((this.progress * v2helper.VOIP_ENC_HEIGHT_LV1) / 100), false, this.paint);
        this.paint.setStrokeWidth(0.0f);
        this.paint.setStyle(Paint.Style.FILL);
        AppMethodBeat.o(40888);
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int i2) {
        AppMethodBeat.i(40889);
        this.progress = Math.max(0, i2);
        this.progress = Math.min(i2, 100);
        invalidate();
        AppMethodBeat.o(40889);
    }
}
