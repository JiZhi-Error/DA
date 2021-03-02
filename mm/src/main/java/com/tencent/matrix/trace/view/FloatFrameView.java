package com.tencent.matrix.trace.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.util.Iterator;
import java.util.LinkedList;

public class FloatFrameView extends LinearLayout {
    public TextView ddA;
    public TextView ddB;
    public TextView ddC;
    public TextView ddD;
    public TextView ddq;
    public LineChartView ddr;
    public TextView dds;
    public TextView ddt;
    public TextView ddu;
    public TextView ddv;
    public TextView ddw;
    public TextView ddx;
    public TextView ddy;
    public TextView ddz;

    public FloatFrameView(Context context) {
        super(context);
        bh(context);
    }

    public FloatFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bh(context);
    }

    private void bh(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LayoutInflater.from(context).inflate(R.layout.alt, this);
        this.ddq = (TextView) findViewById(R.id.d9n);
        this.ddA = (TextView) findViewById(R.id.c7p);
        this.ddB = (TextView) findViewById(R.id.hb8);
        this.ddA.setText("{other info}");
        this.ddC = (TextView) findViewById(R.id.gmf);
        this.dds = (TextView) findViewById(R.id.ean);
        this.ddt = (TextView) findViewById(R.id.eao);
        this.ddu = (TextView) findViewById(R.id.eap);
        this.ddv = (TextView) findViewById(R.id.eaq);
        this.ddD = (TextView) findViewById(R.id.iec);
        this.ddw = (TextView) findViewById(R.id.ie9);
        this.ddx = (TextView) findViewById(R.id.ie_);
        this.ddy = (TextView) findViewById(R.id.iea);
        this.ddz = (TextView) findViewById(R.id.ieb);
        this.ddr = (LineChartView) findViewById(R.id.ar6);
    }

    public static class LineChartView extends View {
        private final TextPaint ddE;
        private final Paint ddF;
        private final Paint ddG;
        final LinkedList<a> ddH;
        float ddI;
        float ddJ;
        private Path ddK;
        private Path ddL;
        private float[] ddM;
        private float[] ddN;
        private int ddO;
        private int ddP;
        private int ddQ;
        private int ddR;
        private int ddS;
        private int ddT;
        float ddU;
        float ddV;
        float height;
        private final Paint paint;
        float textSize;
        float width;

        public LineChartView(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.ddK = new Path();
            this.ddL = new Path();
            this.ddM = new float[2];
            this.ddN = new float[2];
            this.ddO = getContext().getResources().getColor(R.color.wl);
            this.ddP = getContext().getResources().getColor(R.color.wp);
            this.ddQ = getContext().getResources().getColor(R.color.wo);
            this.ddR = getContext().getResources().getColor(R.color.wn);
            this.ddS = getContext().getResources().getColor(R.color.wm);
            this.ddT = getContext().getResources().getColor(R.color.ku);
            this.ddU = (float) dip2px(getContext(), 8.0f);
            this.paint = new Paint();
            this.ddE = new TextPaint(1);
            TextPaint textPaint = this.ddE;
            float dip2px = (float) dip2px(getContext(), 8.0f);
            this.textSize = dip2px;
            textPaint.setTextSize(dip2px);
            this.ddE.setStrokeWidth((float) dip2px(getContext(), 1.0f));
            this.ddE.setColor(this.ddT);
            this.ddF = new TextPaint(1);
            this.ddF.setStrokeWidth((float) dip2px(getContext(), 1.0f));
            this.ddF.setStyle(Paint.Style.STROKE);
            this.ddF.setPathEffect(new DashPathEffect(new float[]{6.0f, 6.0f}, 0.0f));
            this.ddG = new Paint(this.ddE);
            this.ddG.setStrokeWidth((float) dip2px(getContext(), 1.0f));
            this.ddG.setColor(this.ddT);
            this.ddG.setStyle(Paint.Style.STROKE);
            this.ddG.setPathEffect(new DashPathEffect(new float[]{6.0f, 6.0f}, 0.0f));
            this.ddH = new LinkedList<>();
        }

        public LineChartView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                this.width = (float) getMeasuredWidth();
                this.height = (float) getMeasuredHeight();
                this.ddV = this.width - (3.0f * this.ddU);
                this.ddJ = (float) dip2px(getContext(), 1.0f);
                this.paint.setStrokeWidth(this.ddJ);
                this.ddI = this.ddJ * 2.0f;
                float f2 = this.ddV / 60.0f;
                this.ddM[0] = (10.0f * f2) + (this.width - this.ddV);
                this.ddM[1] = (this.ddI * 50.0f) + this.ddU;
                this.ddK.moveTo(this.ddM[0], this.ddM[1]);
                this.ddK.lineTo(this.ddM[0], 0.0f);
                this.ddN[0] = (f2 * 30.0f) + (this.width - this.ddV);
                this.ddN[1] = (this.ddI * 50.0f) + this.ddU;
                this.ddL.moveTo(this.ddN[0], this.ddN[1]);
                this.ddL.lineTo(this.ddN[0], 0.0f);
            }
        }

        @SuppressLint({"DefaultLocale"})
        public void draw(Canvas canvas) {
            int i2;
            super.draw(canvas);
            Iterator<a> it = this.ddH.iterator();
            int i3 = 0;
            int i4 = 1;
            while (it.hasNext()) {
                a next = it.next();
                int i5 = i3 + next.fps;
                if (LineChartView.this.paint.getColor() != next.color) {
                    LineChartView.this.paint.setColor(next.color);
                }
                next.ddW[1] = ((float) (i4 + 1)) * LineChartView.this.ddI;
                next.ddW[3] = next.ddW[1];
                canvas.drawLine(next.ddW[0], next.ddW[1], next.ddW[2], next.ddW[3], LineChartView.this.paint);
                if (i4 % 25 == 0) {
                    Path path = new Path();
                    float f2 = next.ddW[1];
                    path.moveTo(0.0f, f2);
                    path.lineTo((float) getMeasuredHeight(), f2);
                    canvas.drawPath(path, this.ddG);
                    this.ddE.setColor(this.ddT);
                    canvas.drawText((i4 / 5) + "s", 0.0f, this.textSize + f2, this.ddE);
                    if (i4 > 0) {
                        int i6 = i5 / i4;
                        TextPaint textPaint = this.ddE;
                        if (i6 > 57) {
                            i2 = this.ddO;
                        } else if (i6 > 51) {
                            i2 = this.ddP;
                        } else if (i6 > 36) {
                            i2 = this.ddQ;
                        } else if (i6 > 18) {
                            i2 = this.ddR;
                        } else {
                            i2 = this.ddS;
                        }
                        textPaint.setColor(i2);
                        canvas.drawText(i6 + "FPS", 0.0f, f2 - (this.textSize / 2.0f), this.ddE);
                    }
                }
                i3 = i5;
                i4++;
            }
            this.ddE.setColor(this.ddT);
            this.ddF.setColor(this.ddP);
            canvas.drawPath(this.ddK, this.ddF);
            canvas.drawText("50", this.ddM[0] - (this.textSize / 2.0f), this.ddM[1] + this.textSize, this.ddE);
            this.ddF.setColor(this.ddQ);
            canvas.drawPath(this.ddL, this.ddF);
            canvas.drawText(PayuSecureEncrypt.ENCRYPT_VERSION_HASH, this.ddN[0] - (this.textSize / 2.0f), this.ddN[1] + this.textSize, this.ddE);
        }

        private static int dip2px(Context context, float f2) {
            return (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
        }

        class a {
            int color;
            float[] ddW = new float[4];
            int fps;

            a(int i2, int i3) {
                this.fps = i2;
                this.color = i3;
                this.ddW[0] = LineChartView.this.width;
                this.ddW[2] = ((((float) (60 - i2)) * LineChartView.this.ddV) / 60.0f) + (((float) LineChartView.this.getWidth()) - LineChartView.this.ddV);
            }
        }
    }
}
