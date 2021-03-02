package com.tencent.mm.ui.widget.progress;

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
import com.tencent.mm.ui.at;
import com.tencent.wxmm.v2helper;

public class RoundProgressBtn extends View {
    private float GoD;
    private int QVg;
    private int QVh = 0;
    private int QVi = 0;
    private int QVj = at.aH(getContext(), R.dimen.bt);
    private int luE;
    private int max;
    private Paint paint;
    private int progress;
    private int rHF;
    private float xzK;

    public RoundProgressBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(159685);
        c(context, attributeSet, 0);
        AppMethodBeat.o(159685);
    }

    public RoundProgressBtn(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(159686);
        c(context, attributeSet, i2);
        AppMethodBeat.o(159686);
    }

    private void c(Context context, AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(159687);
        this.paint = new Paint();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0296a.RoundProgressBtn, i2, 0);
            this.QVg = obtainStyledAttributes.getColor(4, getContext().getResources().getColor(R.color.a5t));
            this.xzK = obtainStyledAttributes.getDimension(5, 0.0f);
            this.luE = obtainStyledAttributes.getColor(2, getContext().getResources().getColor(R.color.afp));
            this.GoD = obtainStyledAttributes.getDimension(3, this.xzK);
            this.max = obtainStyledAttributes.getInt(0, 100);
            this.progress = obtainStyledAttributes.getInt(1, 0);
            this.rHF = obtainStyledAttributes.getInt(6, -90);
            obtainStyledAttributes.recycle();
        }
        AppMethodBeat.o(159687);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(159688);
        super.onDraw(canvas);
        int width = getWidth() / 2;
        if (this.xzK == 0.0f) {
            this.xzK = (float) ((int) (((double) (getWidth() / 2)) * 0.167d));
        }
        this.GoD = this.xzK;
        this.QVh = (int) this.xzK;
        this.QVi = (int) (((float) width) * 0.667f);
        int i2 = (int) (((float) width) - (this.xzK / 2.0f));
        this.paint.setStrokeWidth(this.xzK);
        this.paint.setColor(this.QVg);
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle((float) width, (float) width, (float) i2, this.paint);
        this.paint.setStrokeWidth(this.GoD);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.paint.setColor(this.luE);
        canvas.drawArc(new RectF((float) (width - i2), (float) (width - i2), (float) (width + i2), (float) (i2 + width)), (float) this.rHF, (float) ((this.progress * v2helper.VOIP_ENC_HEIGHT_LV1) / this.max), false, this.paint);
        this.paint.setStrokeWidth(0.0f);
        this.paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(((float) width) - (this.xzK * 1.5f), (float) (width - (this.QVi / 2)), ((float) width) - (this.xzK * 0.5f), (float) ((this.QVi / 2) + width), this.paint);
        canvas.drawRect((((float) this.QVh) * 0.5f) + ((float) width), (float) (width - (this.QVi / 2)), (((float) this.QVh) * 1.5f) + ((float) width), (float) ((this.QVi / 2) + width), this.paint);
        AppMethodBeat.o(159688);
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int i2) {
        AppMethodBeat.i(159689);
        this.progress = Math.max(0, i2);
        this.progress = Math.min(i2, this.max);
        invalidate();
        AppMethodBeat.o(159689);
    }
}
