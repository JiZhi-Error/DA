package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.ChartGridView;
import java.util.ArrayList;
import java.util.List;

public class RadarGrid extends ChartGridView {
    public static final Point Ebi = new Point(0, 0);
    private int Ebe = 4;
    private int Ebf = 4;
    private c Ebh;
    private int Ebo = 80;
    private Point Ebp = Ebi;
    private Spannable[] Ebr;
    private List<PointF> Ebs;
    private Rect mRect = new Rect();
    private float maxValue = 1.0f;
    private Path xT = new Path();

    static {
        AppMethodBeat.i(96393);
        AppMethodBeat.o(96393);
    }

    public RadarGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(96361);
        fcR();
        AppMethodBeat.o(96361);
    }

    public RadarGrid(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(96362);
        fcR();
        AppMethodBeat.o(96362);
    }

    public RadarGrid(Context context, int i2, int i3, float f2, Spannable[] spannableArr, c cVar) {
        super(context);
        AppMethodBeat.i(96363);
        this.maxValue = f2;
        this.Ebe = i2;
        this.Ebf = i3;
        this.maxValue = f2;
        this.Ebr = spannableArr;
        this.Ebh = cVar;
        AppMethodBeat.o(96363);
    }

    private void fcR() {
        AppMethodBeat.i(96364);
        setMinimumHeight(160);
        setMinimumWidth(160);
        AppMethodBeat.o(96364);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.ChartGridView
    public final int fcO() {
        return this.Ebo * 2;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.ChartGridView
    public final int fcP() {
        return this.Ebo * 2;
    }

    private List<PointF> bT(float f2) {
        AppMethodBeat.i(96365);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.Ebe; i2++) {
            PointF pointF = new PointF();
            pointF.set((float) (((double) this.Ebp.x) - (((double) (((float) this.Ebo) * f2)) * Math.sin((((double) (i2 * 2)) * 3.141592653589793d) / ((double) this.Ebe)))), (float) (((double) this.Ebp.y) - (((double) (((float) this.Ebo) * f2)) * Math.cos((((double) (i2 * 2)) * 3.141592653589793d) / ((double) this.Ebe)))));
            arrayList.add(pointF);
        }
        AppMethodBeat.o(96365);
        return arrayList;
    }

    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        AppMethodBeat.i(96366);
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        this.Ebo = (int) (((double) (((float) Math.min(height, width)) / 2.0f)) * 0.8d);
        this.Ebp.set((int) (((float) width) / 2.0f), (int) (((float) height) / 2.0f));
        if (this.Ebh.EaU != null) {
            int i2 = (int) (((float) width) / 2.0f);
            int i3 = (int) (((float) height) / 2.0f);
            int i4 = (int) (((float) (this.Ebo * 2)) + (this.Ebh.EaR * 2.0f));
            int width2 = (this.Ebh.EaU.getWidth() * i4) / this.Ebh.EaU.getHeight();
            if (this.Ebh.EaU != null) {
                canvas.drawBitmap(Bitmap.createScaledBitmap(this.Ebh.EaU, width2, i4, false), (float) (i2 - (width2 >>> 1)), (float) (i3 - (i4 >>> 1)), (Paint) null);
            }
        }
        if (this.Ebh.EaB) {
            switch (this.Ebh.EaA) {
                case 0:
                    this.Ebs = bT(1.0f);
                    for (int i5 = 0; i5 < this.Ebe; i5++) {
                        PointF pointF = this.Ebs.get(i5);
                        if (i5 == 0) {
                            this.xT.moveTo(pointF.x, pointF.y);
                        } else {
                            this.xT.lineTo(pointF.x, pointF.y);
                        }
                    }
                    this.xT.close();
                    if (this.Ebh.backgroundColor != 0 && this.Ebh.EaU == null) {
                        canvas.drawPath(this.xT, getPaintGridFill());
                        break;
                    }
                case 1:
                    canvas.drawCircle((float) this.Ebp.x, (float) this.Ebp.y, (float) this.Ebo, getPaintGridFill());
                    break;
            }
        }
        if (this.Ebh.EaC) {
            this.Ebs = bT(1.0f);
            for (int i6 = 0; i6 < this.Ebe; i6++) {
                PointF pointF2 = this.Ebs.get(i6);
                canvas.drawLine((float) this.Ebp.x, (float) this.Ebp.y, pointF2.x, pointF2.y, getPaintGridLongitude());
            }
        }
        if (this.Ebh.EaB) {
            switch (this.Ebh.EaA) {
                case 0:
                    canvas.drawPath(this.xT, getPaintGridBorder());
                    this.xT.reset();
                    for (int i7 = 1; i7 < this.Ebf; i7++) {
                        this.Ebs = bT((((float) i7) * 1.0f) / ((float) this.Ebf));
                        for (int i8 = 0; i8 < this.Ebe; i8++) {
                            PointF pointF3 = this.Ebs.get(i8);
                            if (i8 == 0) {
                                this.xT.moveTo(pointF3.x, pointF3.y);
                            } else {
                                this.xT.lineTo(pointF3.x, pointF3.y);
                            }
                            canvas.drawCircle(pointF3.x, pointF3.y, (float) getGridDotRadius(), getPaintGridDot());
                        }
                        this.xT.close();
                        canvas.drawPath(this.xT, getPaintGridLatitude());
                        this.xT.reset();
                    }
                    break;
                case 1:
                    canvas.drawCircle((float) this.Ebp.x, (float) this.Ebp.y, (float) this.Ebo, getPaintGridBorder());
                    for (int i9 = 1; i9 < this.Ebf; i9++) {
                        canvas.drawCircle((float) this.Ebp.x, (float) this.Ebp.y, ((float) this.Ebo) * ((((float) i9) * 1.0f) / ((float) this.Ebf)), getPaintGridLatitude());
                    }
                    break;
            }
        }
        if (this.Ebr != null && this.Ebh.EaE) {
            if (this.Ebr.length != this.Ebe) {
                RuntimeException runtimeException = new RuntimeException("Labels array length not matches longitude lines number.");
                AppMethodBeat.o(96366);
                throw runtimeException;
            }
            for (int i10 = 0; i10 < this.Ebe; i10++) {
                Spannable spannable = this.Ebr[i10];
                if (!spannable.equals(null)) {
                    if (i10 == 0 || i10 == (this.Ebe >>> 1)) {
                        f2 = 0.5f;
                    } else if (i10 <= 0 || i10 >= (this.Ebe >>> 1)) {
                        f2 = 1.0f;
                    } else {
                        f2 = 0.0f;
                    }
                    if (i10 == 0) {
                        f3 = this.Ebh.EaM;
                    } else if (i10 == (this.Ebe >>> 1)) {
                        f3 = -this.Ebh.EaM;
                    } else {
                        f3 = 0.0f;
                    }
                    StaticLayout staticLayout = new StaticLayout(spannable, getTextPaintGLabelFont(), 1000, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, false);
                    canvas.save();
                    canvas.translate((float) (((double) (((float) this.Ebp.x) - (staticLayout.getLineWidth(0) * f2))) - (((double) (((float) this.Ebo) + this.Ebh.EaM)) * Math.sin(6.283185307179586d - ((((double) (i10 * 2)) * 3.141592653589793d) / ((double) this.Ebe))))), (float) ((((double) (this.Ebp.y - (staticLayout.getHeight() / 2))) - (((double) (((float) this.Ebo) + this.Ebh.EaM)) * Math.cos(6.283185307179586d - ((((double) (i10 * 2)) * 3.141592653589793d) / ((double) this.Ebe))))) - ((double) f3)));
                    staticLayout.draw(canvas);
                    canvas.restore();
                }
            }
        }
        AppMethodBeat.o(96366);
    }

    private Paint getPaintGridFill() {
        AppMethodBeat.i(96367);
        Paint paint = new Paint();
        paint.setColor(this.Ebh.backgroundColor);
        paint.setAntiAlias(true);
        AppMethodBeat.o(96367);
        return paint;
    }

    private Paint getPaintGridBorder() {
        int i2;
        float f2;
        AppMethodBeat.i(96368);
        Paint paint = new Paint();
        c cVar = this.Ebh;
        if (cVar.EaF == -1) {
            i2 = cVar.EaG;
        } else {
            i2 = cVar.EaF;
        }
        paint.setColor(i2);
        paint.setStyle(Paint.Style.STROKE);
        c cVar2 = this.Ebh;
        if (cVar2.EaJ == -1.0f) {
            f2 = cVar2.EaI;
        } else {
            f2 = cVar2.EaJ;
        }
        paint.setStrokeWidth(f2);
        paint.setAntiAlias(true);
        AppMethodBeat.o(96368);
        return paint;
    }

    private Paint getPaintGridLatitude() {
        AppMethodBeat.i(96369);
        Paint paint = new Paint();
        paint.setColor(this.Ebh.EaG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Ebh.EaI);
        paint.setAntiAlias(true);
        AppMethodBeat.o(96369);
        return paint;
    }

    private Paint getPaintGridDot() {
        AppMethodBeat.i(96370);
        Paint paint = new Paint();
        paint.setColor(this.Ebh.EaS);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        AppMethodBeat.o(96370);
        return paint;
    }

    private int getGridDotRadius() {
        return this.Ebh.EaT;
    }

    private Paint getPaintGridLongitude() {
        AppMethodBeat.i(96371);
        Paint paint = new Paint();
        paint.setColor(this.Ebh.EaH);
        paint.setStrokeWidth(this.Ebh.EaI);
        AppMethodBeat.o(96371);
        return paint;
    }

    private Paint getPaintGLabelFont() {
        AppMethodBeat.i(96372);
        Paint paint = new Paint();
        paint.setColor(this.Ebh.EaK);
        paint.setTextSize(this.Ebh.EaL);
        AppMethodBeat.o(96372);
        return paint;
    }

    private TextPaint getTextPaintGLabelFont() {
        AppMethodBeat.i(96373);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(this.Ebh.EaK);
        textPaint.setTextSize(this.Ebh.EaL);
        AppMethodBeat.o(96373);
        return textPaint;
    }

    private Paint getPaintGScaleFont() {
        int i2;
        AppMethodBeat.i(96374);
        Paint paint = new Paint();
        c cVar = this.Ebh;
        if (cVar.EaN == -1) {
            i2 = cVar.EaK;
        } else {
            i2 = cVar.EaN;
        }
        paint.setColor(i2);
        paint.setTextSize(this.Ebh.EaO);
        AppMethodBeat.o(96374);
        return paint;
    }

    public void setGridChartType(int i2) {
        AppMethodBeat.i(96375);
        this.Ebh.EaA = i2;
        invalidate();
        AppMethodBeat.o(96375);
    }

    public void setLonNum(int i2) {
        AppMethodBeat.i(96376);
        this.Ebe = i2;
        invalidate();
        AppMethodBeat.o(96376);
    }

    public void setLatNum(int i2) {
        AppMethodBeat.i(96377);
        this.Ebf = i2;
        invalidate();
        AppMethodBeat.o(96377);
    }

    public void setMaxValue(float f2) {
        AppMethodBeat.i(96378);
        this.maxValue = f2;
        invalidate();
        AppMethodBeat.o(96378);
    }

    public void setLabelsArray(Spannable[] spannableArr) {
        AppMethodBeat.i(96379);
        this.Ebr = spannableArr;
        invalidate();
        AppMethodBeat.o(96379);
    }

    public void setGridStyle(c cVar) {
        AppMethodBeat.i(96380);
        this.Ebh = cVar;
        invalidate();
        AppMethodBeat.o(96380);
    }

    public c getGridStyle() {
        return this.Ebh;
    }

    public void setBackgroundColor(int i2) {
        AppMethodBeat.i(96381);
        this.Ebh.backgroundColor = i2;
        invalidate();
        AppMethodBeat.o(96381);
    }

    public void setGridBorderColor(int i2) {
        AppMethodBeat.i(96382);
        this.Ebh.EaF = i2;
        invalidate();
        AppMethodBeat.o(96382);
    }

    public void setGridLatitudeColor(int i2) {
        AppMethodBeat.i(96383);
        this.Ebh.EaG = i2;
        invalidate();
        AppMethodBeat.o(96383);
    }

    public void setGridLongitudeColor(int i2) {
        AppMethodBeat.i(96384);
        this.Ebh.EaH = i2;
        invalidate();
        AppMethodBeat.o(96384);
    }

    public void setGridStrokeWidth(float f2) {
        AppMethodBeat.i(96385);
        this.Ebh.EaI = f2;
        invalidate();
        AppMethodBeat.o(96385);
    }

    public void setGridBorderStrokeWidth(float f2) {
        AppMethodBeat.i(96386);
        this.Ebh.EaJ = f2;
        invalidate();
        AppMethodBeat.o(96386);
    }

    public void setGridLabelColor(int i2) {
        AppMethodBeat.i(96387);
        this.Ebh.EaK = i2;
        invalidate();
        AppMethodBeat.o(96387);
    }

    public void setGridLabelSize(float f2) {
        AppMethodBeat.i(96388);
        this.Ebh.EaL = f2;
        invalidate();
        AppMethodBeat.o(96388);
    }

    public void setGridLabelPadding(float f2) {
        AppMethodBeat.i(96389);
        this.Ebh.EaM = f2;
        invalidate();
        AppMethodBeat.o(96389);
    }

    public void setGridScaleColor(int i2) {
        AppMethodBeat.i(96390);
        this.Ebh.EaN = i2;
        invalidate();
        AppMethodBeat.o(96390);
    }

    public void setGridScaleSize(float f2) {
        AppMethodBeat.i(96391);
        this.Ebh.EaO = f2;
        invalidate();
        AppMethodBeat.o(96391);
    }

    public void setGridScaleLabelPadding(float f2) {
        AppMethodBeat.i(96392);
        this.Ebh.EaP = f2;
        invalidate();
        AppMethodBeat.o(96392);
    }
}
