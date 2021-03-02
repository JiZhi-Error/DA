package com.tencent.mm.plugin.clean.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2helper;

public class PieView extends View {
    private int dTz = 0;
    private Paint gxp;
    private int lCq = 6;
    private Paint qpU;
    private Paint qpV;
    private Paint qpW;
    private Paint qpX;
    private Paint qpY;
    private Paint qpZ;
    private int qqa;
    private int qqb;
    private int qqc;
    private int qqd;
    private int qqe;
    private int qqf;
    private int qqg = 0;
    private int qqh = -90;

    public PieView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(22843);
        initView();
        AppMethodBeat.o(22843);
    }

    public PieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(22844);
        initView();
        AppMethodBeat.o(22844);
    }

    public void setStage(int i2) {
        this.dTz = i2;
    }

    public void setGreenTargetAngle(int i2) {
        this.qqe = i2;
    }

    public void setDeepGrayTargetAngle(int i2) {
        this.qqf = i2;
    }

    public void setOtherAccTargetAngle(int i2) {
        this.qqg = i2;
    }

    private void initView() {
        AppMethodBeat.i(22845);
        this.gxp = EN(-1);
        this.qpU = EN(-657931);
        this.qpV = EN(-2565928);
        this.qpW = EN(-15223279);
        this.qpX = EN(-7876878);
        this.qpY = EN(-7876878);
        this.qpZ = EN(-1644567);
        AppMethodBeat.o(22845);
    }

    private static Paint EN(int i2) {
        AppMethodBeat.i(22846);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i2);
        AppMethodBeat.o(22846);
        return paint;
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(22847);
        float measuredWidth = (float) (getMeasuredWidth() / 2);
        float measuredHeight = (float) ((getMeasuredHeight() / 2) + getTop());
        float measuredHeight2 = (float) ((getMeasuredHeight() / 3) + 15);
        float f2 = measuredHeight2 - 15.0f;
        RectF rectF = new RectF(measuredWidth - measuredHeight2, measuredHeight - measuredHeight2, measuredWidth + measuredHeight2, measuredHeight + measuredHeight2);
        if (this.dTz == 0) {
            canvas.drawCircle(measuredWidth, measuredHeight, measuredHeight2, this.qpU);
            canvas.drawArc(rectF, (float) this.qqh, 45.0f, true, this.qpV);
            canvas.drawCircle(measuredWidth, measuredHeight, f2, this.gxp);
            this.qqh += 4;
            this.qqh %= v2helper.VOIP_ENC_HEIGHT_LV1;
        }
        if (this.dTz == 1) {
            float f3 = 10.0f + measuredHeight2;
            RectF rectF2 = new RectF(measuredWidth - f3, measuredHeight - f3, measuredWidth + f3, f3 + measuredHeight);
            this.qqa = W(this.qqa, this.qqe, this.lCq);
            canvas.drawArc(rectF2, -90.0f, (float) this.qqa, true, this.qpW);
            if (this.qqg <= 0) {
                if (this.qqa == this.qqe) {
                    this.qqc = W(this.qqc, this.qqf, this.lCq);
                    canvas.drawArc(rectF, (float) (this.qqe - 90), (float) this.qqc, true, this.qpX);
                }
                if (this.qqc == this.qqf) {
                    this.qqb = W(this.qqb, (360 - this.qqe) - this.qqf, this.lCq);
                    canvas.drawArc(rectF, (float) ((this.qqe - 90) + this.qqf), (float) this.qqb, true, this.qpY);
                }
            } else {
                if (this.qqa == this.qqe) {
                    this.qqd = W(this.qqd, this.qqg, this.lCq);
                    canvas.drawArc(rectF2, (float) (this.qqe - 90), (float) this.qqd, true, this.qpZ);
                }
                if (this.qqd == this.qqg) {
                    this.qqc = W(this.qqc, this.qqf, this.lCq);
                    canvas.drawArc(rectF, (float) ((this.qqg - 90) + this.qqe), (float) this.qqc, true, this.qpX);
                }
                if (this.qqc == this.qqf) {
                    this.qqb = W(this.qqb, ((360 - this.qqe) - this.qqf) - this.qqg, this.lCq);
                    canvas.drawArc(rectF, (float) ((this.qqe - 90) + this.qqf + this.qqg), (float) this.qqb, true, this.qpY);
                }
            }
        }
        invalidate();
        AppMethodBeat.o(22847);
    }

    private static int W(int i2, int i3, int i4) {
        if (i3 - i2 >= i4) {
            return i2 + i4;
        }
        if (i2 - i3 > i4) {
            return i2 - i4;
        }
        return i3;
    }
}
