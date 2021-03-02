package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import org.xwalk.core.Log;

public class CameraFrontSightView extends View {
    public int mHeight;
    private Paint mPaint = new Paint();
    private int mStrokeWidth;
    public int mWidth;
    private boolean zAF = false;
    private boolean zAG = false;
    private boolean zAH = false;
    private boolean zAI = false;
    private long zAJ = 0;
    private int zAK;
    private int zAL;
    private ViewGroup.LayoutParams zAM;

    public CameraFrontSightView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(94502);
        AppMethodBeat.o(94502);
    }

    public CameraFrontSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(94503);
        AppMethodBeat.o(94503);
    }

    public final void hd(int i2, int i3) {
        AppMethodBeat.i(94504);
        this.zAM = getLayoutParams();
        if (this.zAM != null) {
            this.zAM.width = i2;
            this.zAM.height = i3;
        }
        this.mWidth = i2;
        this.mHeight = i3;
        this.zAK = this.mWidth / 2;
        this.zAL = this.mHeight / 2;
        this.mStrokeWidth = a.fromDPToPix(getContext(), 1);
        this.mPaint.setColor(-12206054);
        this.mPaint.setStrokeWidth((float) this.mStrokeWidth);
        AppMethodBeat.o(94504);
    }

    public void setFocusColor(int i2) {
        AppMethodBeat.i(187075);
        if (i2 != 0) {
            this.mPaint.setColor(i2);
        }
        AppMethodBeat.o(187075);
    }

    public final void ekE() {
        AppMethodBeat.i(94505);
        setVisibility(0);
        this.zAF = true;
        this.zAG = false;
        this.zAH = false;
        this.zAI = false;
        this.zAJ = System.currentTimeMillis();
        invalidate();
        AppMethodBeat.o(94505);
    }

    public final void aa(float f2, float f3) {
        AppMethodBeat.i(94506);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            Log.e("MicroMsg.CameraFrontSightView", "LayoutParams is not MarginLayoutParams! use doAimation()");
            AppMethodBeat.o(94506);
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.leftMargin = ((int) f2) - (this.mWidth / 2);
        marginLayoutParams.topMargin = ((int) f3) - (this.mHeight / 2);
        setLayoutParams(marginLayoutParams);
        ekE();
        AppMethodBeat.o(94506);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(94507);
        canvas.translate((float) (this.zAK / 2), (float) (this.zAL / 2));
        long currentTimeMillis = System.currentTimeMillis() - this.zAJ;
        if (currentTimeMillis > 200) {
            this.zAF = false;
            this.zAG = true;
        }
        if (currentTimeMillis > 800) {
            this.zAG = false;
            this.zAH = true;
        }
        if (currentTimeMillis > 1100) {
            this.zAH = false;
            this.zAI = true;
        }
        if (currentTimeMillis > 1300) {
            this.zAI = false;
            setVisibility(8);
            AppMethodBeat.o(94507);
            return;
        }
        if (this.zAF) {
            float f2 = (((float) (200 - currentTimeMillis)) / 200.0f) + 1.0f;
            canvas.scale(f2, f2, (float) (this.zAK / 2), (float) (this.zAL / 2));
            this.mPaint.setAlpha((int) ((2.0f - f2) * 255.0f));
        } else {
            canvas.scale(1.0f, 1.0f);
        }
        if (this.zAG) {
            float f3 = (((float) ((currentTimeMillis - 200) % 200)) / 200.0f) * 2.0f;
            this.mPaint.setAlpha((int) (((f3 > 1.0f ? f3 - 1.0f : 1.0f - f3) * 128.0f) + 127.0f));
        } else {
            this.mPaint.setAlpha(255);
        }
        if (this.zAI) {
            this.mPaint.setAlpha((int) ((1.0f - (((float) (currentTimeMillis - 1100)) / 200.0f)) * 255.0f));
        }
        canvas.drawLine(0.0f, 0.0f, (float) this.zAK, 0.0f, this.mPaint);
        canvas.drawLine(0.0f, 0.0f, 0.0f, (float) this.zAL, this.mPaint);
        canvas.drawLine((float) this.zAK, 0.0f, (float) this.zAK, (float) this.zAL, this.mPaint);
        canvas.drawLine(0.0f, (float) this.zAL, (float) this.zAK, (float) this.zAL, this.mPaint);
        canvas.drawLine(0.0f, (float) (this.zAL / 2), (float) (this.zAK / 10), (float) (this.zAL / 2), this.mPaint);
        canvas.drawLine((float) this.zAK, (float) (this.zAL / 2), (float) ((this.zAK * 9) / 10), (float) (this.zAL / 2), this.mPaint);
        canvas.drawLine((float) (this.zAK / 2), 0.0f, (float) (this.zAK / 2), (float) (this.zAL / 10), this.mPaint);
        canvas.drawLine((float) (this.zAK / 2), (float) this.zAL, (float) (this.zAK / 2), (float) ((this.zAL * 9) / 10), this.mPaint);
        invalidate();
        AppMethodBeat.o(94507);
    }
}
