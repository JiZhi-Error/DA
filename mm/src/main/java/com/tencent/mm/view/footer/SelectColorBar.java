package com.tencent.mm.view.footer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;

public class SelectColorBar extends View {
    public static final int[] RoQ = {-1, WebView.NIGHT_MODE_COLOR, -707825, -17592, -16535286, -15172610, -7054596, -449092};
    private Rect[] RoL;
    private Paint RoO = new Paint(1);
    private boolean RoU = true;
    private final float Roz = getResources().getDimension(R.dimen.a48);
    private a Rpt;
    private int Rpu = -1;
    private Paint hog;

    public interface a {
        void acC(int i2);
    }

    public SelectColorBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(9417);
        this.RoO.setColor(-16711936);
        this.RoL = new Rect[RoQ.length];
        this.hog = new Paint(1);
        this.hog.setStyle(Paint.Style.FILL);
        this.hog.setStrokeCap(Paint.Cap.ROUND);
        AppMethodBeat.o(9417);
    }

    public void setSelectColorListener(a aVar) {
        this.Rpt = aVar;
    }

    public void setSelectColor(int i2) {
        AppMethodBeat.i(9418);
        int i3 = 0;
        while (true) {
            if (i3 >= RoQ.length) {
                break;
            } else if (RoQ[i3] == i2) {
                this.Rpu = i3;
                break;
            } else {
                i3++;
            }
        }
        this.RoU = false;
        postInvalidate();
        AppMethodBeat.o(9418);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(9419);
        int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((int) getResources().getDimension(R.dimen.xl), 1073741824));
        if (this.RoL == null) {
            this.RoL = new Rect[RoQ.length];
        }
        float dimension = getResources().getDimension(R.dimen.a0r);
        float measuredWidth = (((float) (getMeasuredWidth() - getPaddingLeftAndRight())) - ((2.0f * dimension) * ((float) RoQ.length))) / ((float) (RoQ.length - 1));
        int i4 = (int) (2.0f * dimension);
        int paddingLeftAndRight = (int) (((float) (getPaddingLeftAndRight() / 2)) + dimension + 5.0f);
        int detailHeight = getDetailHeight() / 2;
        for (int i5 = 0; i5 < RoQ.length; i5++) {
            this.RoL[i5] = new Rect(paddingLeftAndRight - i4, detailHeight - i4, paddingLeftAndRight + i4, detailHeight + i4);
            paddingLeftAndRight = (int) (((float) paddingLeftAndRight) + (2.0f * dimension) + measuredWidth);
        }
        AppMethodBeat.o(9419);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i2 = 0;
        AppMethodBeat.i(9420);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                while (true) {
                    if (i2 >= this.RoL.length) {
                        break;
                    } else if (this.RoL[i2].contains(x, y)) {
                        this.Rpu = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
            case 1:
            case 3:
                while (true) {
                    if (this.RoL != null && i2 < this.RoL.length) {
                        if (!this.RoL[i2].contains(x, y) || i2 != this.Rpu || this.Rpt == null) {
                            i2++;
                        } else {
                            this.Rpt.acC(RoQ[i2]);
                        }
                    }
                }
                requestLayout();
                postInvalidate();
                break;
        }
        AppMethodBeat.o(9420);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(9421);
        super.onDraw(canvas);
        canvas.drawColor(0);
        float dimension = getResources().getDimension(R.dimen.a0r);
        float measuredWidth = (((float) (getMeasuredWidth() - getPaddingLeftAndRight())) - ((2.0f * dimension) * ((float) RoQ.length))) / ((float) (RoQ.length - 1));
        float paddingLeftAndRight = ((float) (getPaddingLeftAndRight() / 2)) + dimension + 5.0f;
        float detailHeight = (1.0f * ((float) getDetailHeight())) / 2.0f;
        for (int i2 = 0; i2 < RoQ.length; i2++) {
            float f2 = 0.0f;
            if (this.Rpu == i2) {
                this.RoU = false;
                f2 = 6.0f;
            } else if (this.RoU && i2 == 2) {
                f2 = 6.0f;
            }
            this.hog.setColor(-1);
            canvas.drawCircle(paddingLeftAndRight, detailHeight, dimension + 5.0f + f2, this.hog);
            this.hog.setColor(RoQ[i2]);
            canvas.drawCircle(paddingLeftAndRight, detailHeight, f2 + dimension, this.hog);
            paddingLeftAndRight += (2.0f * dimension) + measuredWidth;
        }
        AppMethodBeat.o(9421);
    }

    /* access modifiers changed from: protected */
    public int getDetailHeight() {
        AppMethodBeat.i(9422);
        int dimension = (int) getResources().getDimension(R.dimen.xl);
        AppMethodBeat.o(9422);
        return dimension;
    }

    public int getPaddingLeftAndRight() {
        return (int) (2.0f * this.Roz);
    }

    public int getCurColor() {
        if (this.Rpu == -1) {
            return RoQ[2];
        }
        return RoQ[this.Rpu];
    }
}
