package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.List;

public class VerticalStepViewIndicator extends View {
    private float dhi;
    private int mHeight;
    private List<c> mPM;
    private int mPN;
    private final String mPQ;
    private int mPR;
    private float mPS;
    private float mPT;
    private Drawable mPU;
    private Drawable mPV;
    private Drawable mPW;
    private Drawable mPX;
    private float mPY;
    private float mPZ;
    private float mQa;
    private List<Float> mQb;
    private Paint mQc;
    private Paint mQd;
    private int mQe;
    private int mQf;
    private PathEffect mQg;
    private a mQh;
    private boolean mQi;
    private Rect mRect;
    private Path xT;

    public interface a {
        void bNc();
    }

    public void setOnDrawListener(a aVar) {
        this.mQh = aVar;
    }

    public float getCircleRadius() {
        return this.mPT;
    }

    public VerticalStepViewIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalStepViewIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(221339);
        this.mPQ = getClass().getSimpleName();
        this.mPR = (int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
        this.mPM = new ArrayList();
        this.mQe = b.n(getContext(), R.color.ack);
        this.mQf = -1;
        this.xT = new Path();
        this.mQg = new DashPathEffect(new float[]{8.0f, 8.0f, 8.0f, 8.0f}, 1.0f);
        this.mQb = new ArrayList();
        this.mQc = new Paint();
        this.mQd = new Paint();
        this.mQc.setAntiAlias(true);
        this.mQc.setColor(this.mQe);
        this.mQc.setStyle(Paint.Style.STROKE);
        this.mQc.setStrokeWidth(2.0f);
        this.mQd.setAntiAlias(true);
        this.mQd.setColor(this.mQf);
        this.mQd.setStyle(Paint.Style.STROKE);
        this.mQd.setStrokeWidth(2.0f);
        this.mQc.setPathEffect(this.mQg);
        this.mQd.setStyle(Paint.Style.FILL);
        this.mPS = 0.05f * ((float) this.mPR);
        this.mPT = 0.28f * ((float) this.mPR);
        this.mQa = 0.85f * ((float) this.mPR);
        this.mPU = b.l(getContext(), R.drawable.btl);
        this.mPV = b.l(getContext(), R.drawable.btj);
        this.mPW = b.l(getContext(), R.drawable.btm);
        this.mPX = b.l(getContext(), R.drawable.btk);
        this.mQi = true;
        AppMethodBeat.o(221339);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(221340);
        super.onMeasure(i2, i3);
        int i4 = this.mPR;
        this.mHeight = 0;
        int size = this.mPM.size();
        if (size > 0) {
            this.mHeight = (int) ((((float) (size - 1)) * this.mQa) + ((float) (getPaddingTop() + getPaddingBottom())) + (this.mPT * 2.0f * ((float) size)));
        }
        if (View.MeasureSpec.getMode(i2) != 0) {
            i4 = Math.min(i4, View.MeasureSpec.getSize(i2));
        }
        setMeasuredDimension(i4, this.mHeight);
        AppMethodBeat.o(221340);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(221341);
        super.onSizeChanged(i2, i3, i4, i5);
        this.dhi = (float) (getWidth() / 2);
        this.mPY = this.dhi - (this.mPS / 2.0f);
        this.mPZ = this.dhi + (this.mPS / 2.0f);
        for (int i6 = 0; i6 < this.mPM.size(); i6++) {
            if (this.mQi) {
                this.mQb.add(Float.valueOf(((float) this.mHeight) - ((this.mPT + ((((float) i6) * this.mPT) * 2.0f)) + (((float) i6) * this.mQa))));
            } else {
                this.mQb.add(Float.valueOf(this.mPT + (((float) i6) * this.mPT * 2.0f) + (((float) i6) * this.mQa)));
            }
        }
        if (this.mQh != null) {
            this.mQh.bNc();
        }
        AppMethodBeat.o(221341);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(221342);
        super.onDraw(canvas);
        if (this.mQh != null) {
            this.mQh.bNc();
        }
        this.mQc.setColor(this.mQe);
        this.mQd.setColor(this.mQf);
        for (int i2 = 0; i2 < this.mQb.size() - 1; i2++) {
            float floatValue = this.mQb.get(i2).floatValue();
            float floatValue2 = this.mQb.get(i2 + 1).floatValue();
            if (i2 < this.mPN) {
                if (this.mQi) {
                    canvas.drawRect(this.mPY, (floatValue2 + this.mPT) - 10.0f, this.mPZ, (floatValue - this.mPT) + 10.0f, this.mQd);
                } else {
                    canvas.drawRect(this.mPY, (this.mPT + floatValue) - 10.0f, this.mPZ, (floatValue2 - this.mPT) + 10.0f, this.mQd);
                }
            } else if (this.mQi) {
                this.xT.moveTo(this.dhi, floatValue2 + this.mPT);
                this.xT.lineTo(this.dhi, floatValue - this.mPT);
                canvas.drawPath(this.xT, this.mQc);
            } else {
                this.xT.moveTo(this.dhi, this.mPT + floatValue);
                this.xT.lineTo(this.dhi, floatValue2 - this.mPT);
                canvas.drawPath(this.xT, this.mQc);
            }
        }
        for (int i3 = 0; i3 < this.mQb.size(); i3++) {
            float floatValue3 = this.mQb.get(i3).floatValue();
            this.mRect = new Rect((int) (this.dhi - this.mPT), (int) (floatValue3 - this.mPT), (int) (this.dhi + this.mPT), (int) (floatValue3 + this.mPT));
            int i4 = this.mPM.get(i3).mState;
            if (i4 == 0) {
                this.mPU.setBounds(this.mRect);
                this.mPU.draw(canvas);
            } else if (i4 == 2) {
                this.mPV.setBounds(this.mRect);
                this.mPV.draw(canvas);
            } else if (i4 == -2) {
                this.mPW.setBounds(this.mRect);
                this.mPW.draw(canvas);
            } else {
                this.mPX.setBounds(this.mRect);
                this.mPX.draw(canvas);
            }
        }
        AppMethodBeat.o(221342);
    }

    public List<Float> getCircleCenterPointPositionList() {
        return this.mQb;
    }

    public void setSteps(List<c> list) {
        AppMethodBeat.i(221343);
        if (list == null) {
            this.mPM = new ArrayList();
            AppMethodBeat.o(221343);
            return;
        }
        this.mPM = list;
        requestLayout();
        AppMethodBeat.o(221343);
    }

    public void setIndicatorLinePaddingProportion(float f2) {
        this.mQa = ((float) this.mPR) * f2;
    }

    public void setComplectingPosition(int i2) {
        AppMethodBeat.i(221344);
        this.mPN = i2;
        requestLayout();
        AppMethodBeat.o(221344);
    }

    public void setUnCompletedLineColor(int i2) {
        this.mQe = i2;
    }

    public void setCompletedLineColor(int i2) {
        this.mQf = i2;
    }

    public void setDefaultIcon(Drawable drawable) {
        this.mPW = drawable;
    }

    public void setCompleteIcon(Drawable drawable) {
        this.mPU = drawable;
    }

    public void setAttentionIcon(Drawable drawable) {
        this.mPV = drawable;
    }
}
