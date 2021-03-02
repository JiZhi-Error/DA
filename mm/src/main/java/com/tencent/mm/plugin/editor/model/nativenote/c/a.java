package com.tencent.mm.plugin.editor.model.nativenote.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends View {
    private int mPadding;
    private Paint mPaint;
    private int mType = 2;
    private RectF qRU;
    private RectF qRV;
    private RectF qRW;
    private RectF qRX;
    private int qRY;
    private int qRZ;
    private int qSa;
    private int qSb;
    private AbstractC0950a qSc;

    /* renamed from: com.tencent.mm.plugin.editor.model.nativenote.c.a$a  reason: collision with other inner class name */
    public interface AbstractC0950a {
        void a(int i2, MotionEvent motionEvent);
    }

    public a(Context context, int i2, int i3, int i4, int i5, AbstractC0950a aVar) {
        super(context);
        AppMethodBeat.i(181845);
        this.mType = i2;
        this.qRZ = i3;
        this.qSa = i4;
        this.qRY = (this.qRZ * 2) / 5;
        this.mPadding = this.qRY;
        this.qSb = (this.qRY * 3) / 4;
        this.mPaint = new Paint(1);
        this.mPaint.setColor(i5);
        this.qSc = aVar;
        this.qRU = new RectF((float) this.mPadding, (float) this.qRZ, (float) (this.mPadding + (this.qRY * 2)), (float) (this.qRZ + (this.qRY * 2)));
        this.qRV = new RectF((float) (this.qSb - this.qRY), (float) this.qRZ, (float) (this.qSb + this.qRY), (float) (this.qRZ + (this.qRY * 2)));
        this.qRW = new RectF((float) this.mPadding, (float) this.qRZ, (float) (this.mPadding + (this.qRY * 2)), (float) (this.qRZ + (this.qRY * 2)));
        this.qRX = new RectF((float) (this.mPadding + this.qSa), (float) this.qRZ, (float) (this.mPadding + this.qSa + (this.qRY * 2)), (float) (this.qRZ + (this.qRY * 2)));
        AppMethodBeat.o(181845);
    }

    public final int getType() {
        return this.mType;
    }

    public final int getViewHeight() {
        return this.qRZ + (this.qRY * 2) + this.mPadding;
    }

    public final int getViewWidth() {
        if (this.mType == 3 || this.mType == 4) {
            return this.mPadding + this.qRY + this.qSb;
        }
        return this.qSa + ((this.mPadding + this.qRY) * 2);
    }

    public final int getOffsetForCursorMid() {
        return this.mPadding + this.qRY + 1;
    }

    public final int getViewPadding() {
        return this.mPadding;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(181846);
        switch (this.mType) {
            case 2:
                canvas.drawRect((float) (this.mPadding + this.qRY), 0.0f, (float) (this.mPadding + this.qRY + this.qSa), (float) (this.qRZ + (this.qRY * 2)), this.mPaint);
                canvas.drawArc(this.qRW, 90.0f, 180.0f, true, this.mPaint);
                canvas.drawArc(this.qRX, 270.0f, 180.0f, true, this.mPaint);
                AppMethodBeat.o(181846);
                return;
            case 3:
                canvas.drawRect((float) (((this.mPadding + this.qRY) + this.qSb) - this.qSa), 0.0f, (float) (this.mPadding + this.qRY + this.qSb), (float) this.qRZ, this.mPaint);
                canvas.drawArc(this.qRU, 90.0f, 180.0f, true, this.mPaint);
                canvas.drawRect((float) (this.mPadding + this.qRY), (float) this.qRZ, (float) (this.mPadding + this.qRY + this.qSb), (float) (this.qRZ + (this.qRY * 2)), this.mPaint);
                AppMethodBeat.o(181846);
                return;
            case 4:
                canvas.drawRect(0.0f, 0.0f, (float) this.qSa, (float) this.qRZ, this.mPaint);
                canvas.drawRect(0.0f, (float) this.qRZ, (float) this.qSb, (float) (this.qRZ + (this.qRY * 2)), this.mPaint);
                canvas.drawArc(this.qRV, 270.0f, 180.0f, true, this.mPaint);
                break;
        }
        AppMethodBeat.o(181846);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(181847);
        if (this.qSc != null) {
            this.qSc.a(this.mType, motionEvent);
        }
        AppMethodBeat.o(181847);
        return true;
    }
}
