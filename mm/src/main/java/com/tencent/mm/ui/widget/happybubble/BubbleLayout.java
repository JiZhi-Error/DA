package com.tencent.mm.ui.widget.happybubble;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a;

public class BubbleLayout extends FrameLayout {
    private int Al;
    private int Am;
    private int An;
    private int Ao;
    private Paint QQj;
    private Path QQk;
    private a QQl;
    private int QQm;
    private int QQn;
    private int QQo;
    private int QQp;
    private int QQq;
    private int QQr;
    private int QQs;
    private int QQt;
    private b QQu;
    private Region QQv;
    private int SE;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;
    private int nYW;
    private Path xT;

    public interface b {
        void hbK();
    }

    public enum a {
        LEFT(1),
        TOP(2),
        RIGHT(3),
        BOTTOM(4);
        
        int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(143544);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(143544);
            return aVar;
        }

        static {
            AppMethodBeat.i(143545);
            AppMethodBeat.o(143545);
        }

        private a(int i2) {
            this.value = i2;
        }

        public static a apg(int i2) {
            a aVar = BOTTOM;
            switch (i2) {
                case 1:
                    return LEFT;
                case 2:
                    return TOP;
                case 3:
                    return RIGHT;
                case 4:
                    return BOTTOM;
                default:
                    return aVar;
            }
        }
    }

    public BubbleLayout(Context context) {
        this(context, null);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143546);
        this.QQv = new Region();
        setLayerType(1, null);
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.BubbleLayout, i2, 0);
        this.QQl = a.apg(obtainStyledAttributes.getInt(3, a.BOTTOM.value));
        this.QQn = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
        this.QQo = obtainStyledAttributes.getDimensionPixelOffset(6, com.tencent.mm.cb.a.fromDPToPix(getContext(), 17.0f));
        this.QQp = obtainStyledAttributes.getDimensionPixelOffset(4, com.tencent.mm.cb.a.fromDPToPix(getContext(), 17.0f));
        this.SE = obtainStyledAttributes.getDimensionPixelOffset(8, com.tencent.mm.cb.a.fromDPToPix(getContext(), 3.3f));
        this.QQq = obtainStyledAttributes.getDimensionPixelOffset(9, com.tencent.mm.cb.a.fromDPToPix(getContext(), 1.0f));
        this.QQr = obtainStyledAttributes.getDimensionPixelOffset(10, com.tencent.mm.cb.a.fromDPToPix(getContext(), 1.0f));
        this.QQs = obtainStyledAttributes.getDimensionPixelOffset(2, com.tencent.mm.cb.a.fromDPToPix(getContext(), 7.0f));
        this.QQm = obtainStyledAttributes.getDimensionPixelOffset(1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 8.0f));
        this.nYW = obtainStyledAttributes.getColor(7, -7829368);
        this.QQt = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        this.mPaint = new Paint(5);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.QQj = new Paint(5);
        this.QQj.setStyle(Paint.Style.FILL);
        this.xT = new Path();
        this.QQk = new Path();
        hbL();
        AppMethodBeat.o(143546);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void hbL() {
        AppMethodBeat.i(143547);
        int i2 = this.QQm * 2;
        switch (this.QQl) {
            case BOTTOM:
                setPadding(i2, i2, i2, this.QQp + i2);
                AppMethodBeat.o(143547);
                return;
            case TOP:
                setPadding(i2, this.QQp + i2, i2, i2);
                AppMethodBeat.o(143547);
                return;
            case LEFT:
                setPadding(this.QQp + i2, i2, i2, i2);
                AppMethodBeat.o(143547);
                return;
            case RIGHT:
                setPadding(i2, i2, this.QQp + i2, i2);
                break;
        }
        AppMethodBeat.o(143547);
    }

    public int getBubblePadding() {
        return this.QQm;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(143548);
        super.onSizeChanged(i2, i3, i4, i5);
        this.mWidth = i2;
        this.mHeight = i3;
        amZ();
        AppMethodBeat.o(143548);
    }

    public void invalidate() {
        AppMethodBeat.i(143549);
        amZ();
        super.invalidate();
        AppMethodBeat.o(143549);
    }

    public void postInvalidate() {
        AppMethodBeat.i(143550);
        amZ();
        super.postInvalidate();
        AppMethodBeat.o(143550);
    }

    private void amZ() {
        int i2;
        int i3;
        int i4 = 0;
        AppMethodBeat.i(143551);
        this.mPaint.setPathEffect(new CornerPathEffect((float) this.QQs));
        this.mPaint.setShadowLayer((float) this.SE, (float) this.QQq, (float) this.QQr, this.nYW);
        this.Al = (this.QQl == a.LEFT ? this.QQp : 0) + this.QQm;
        int i5 = this.QQm;
        if (this.QQl == a.TOP) {
            i2 = this.QQp;
        } else {
            i2 = 0;
        }
        this.Am = i2 + i5;
        int i6 = this.mWidth - this.QQm;
        if (this.QQl == a.RIGHT) {
            i3 = this.QQp;
        } else {
            i3 = 0;
        }
        this.An = i6 - i3;
        int i7 = this.mHeight - this.QQm;
        if (this.QQl == a.BOTTOM) {
            i4 = this.QQp;
        }
        this.Ao = i7 - i4;
        this.mPaint.setColor(this.QQt);
        this.QQj.setColor(this.QQt);
        this.xT.reset();
        this.QQk.reset();
        int i8 = this.QQn;
        if (this.QQp + i8 > this.Ao) {
            i8 = this.Ao - this.QQo;
        }
        if (i8 <= this.QQm) {
            i8 = this.QQm;
        }
        int i9 = this.QQn;
        if (this.QQp + i9 > this.An) {
            i9 = this.An - this.QQo;
        }
        if (i9 <= this.QQm) {
            i9 = this.QQm;
        }
        switch (this.QQl) {
            case BOTTOM:
                this.xT.moveTo((float) i9, (float) this.Ao);
                this.QQk.moveTo((float) i9, (float) this.Ao);
                this.QQk.rLineTo((float) (this.QQo / 2), (float) this.QQp);
                this.QQk.rLineTo((float) (this.QQo / 2), (float) (-this.QQp));
                this.QQk.lineTo((float) i9, (float) this.Ao);
                this.xT.lineTo((float) this.An, (float) this.Ao);
                this.xT.lineTo((float) this.An, (float) this.Am);
                this.xT.lineTo((float) this.Al, (float) this.Am);
                this.xT.lineTo((float) this.Al, (float) this.Ao);
                break;
            case TOP:
                this.xT.moveTo((float) i9, (float) this.Am);
                this.QQk.moveTo((float) i9, (float) this.Am);
                this.QQk.rLineTo((float) (this.QQo / 2), (float) (-this.QQp));
                this.QQk.rLineTo((float) (this.QQo / 2), (float) this.QQp);
                this.QQk.lineTo((float) i9, (float) this.Am);
                this.xT.lineTo((float) this.An, (float) this.Am);
                this.xT.lineTo((float) this.An, (float) this.Ao);
                this.xT.lineTo((float) this.Al, (float) this.Ao);
                this.xT.lineTo((float) this.Al, (float) this.Am);
                break;
            case LEFT:
                this.xT.moveTo((float) this.Al, (float) i8);
                this.QQk.moveTo((float) this.Al, (float) i8);
                this.QQk.rLineTo((float) (-this.QQp), (float) (this.QQo / 2));
                this.QQk.rLineTo((float) this.QQp, (float) (this.QQo / 2));
                this.QQk.lineTo((float) this.Al, (float) i8);
                this.xT.lineTo((float) this.Al, (float) this.Ao);
                this.xT.lineTo((float) this.An, (float) this.Ao);
                this.xT.lineTo((float) this.An, (float) this.Am);
                this.xT.lineTo((float) this.Al, (float) this.Am);
                break;
            case RIGHT:
                this.xT.moveTo((float) this.An, (float) i8);
                this.QQk.moveTo((float) this.An, (float) i8);
                this.QQk.rLineTo((float) this.QQp, (float) (this.QQo / 2));
                this.QQk.rLineTo((float) (-this.QQp), (float) (this.QQo / 2));
                this.QQk.lineTo((float) this.An, (float) i8);
                this.xT.lineTo((float) this.An, (float) this.Ao);
                this.xT.lineTo((float) this.Al, (float) this.Ao);
                this.xT.lineTo((float) this.Al, (float) this.Am);
                this.xT.lineTo((float) this.An, (float) this.Am);
                break;
        }
        this.xT.close();
        this.QQk.close();
        AppMethodBeat.o(143551);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(143552);
        super.onDraw(canvas);
        this.mPaint.setPathEffect(new CornerPathEffect((float) this.QQs));
        canvas.drawPath(this.xT, this.mPaint);
        this.mPaint.setPathEffect(null);
        canvas.drawPath(this.QQk, this.QQj);
        AppMethodBeat.o(143552);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(143553);
        if (motionEvent.getAction() == 0) {
            RectF rectF = new RectF();
            this.xT.computeBounds(rectF, true);
            this.QQv.setPath(this.xT, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
            if (!this.QQv.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && this.QQu != null) {
                this.QQu.hbK();
            }
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(143553);
        return onTouchEvent;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public Path getPath() {
        return this.xT;
    }

    public a getLook() {
        return this.QQl;
    }

    public int getLookPosition() {
        return this.QQn;
    }

    public int getLookWidth() {
        return this.QQo;
    }

    public int getLookLength() {
        return this.QQp;
    }

    public int getShadowColor() {
        return this.nYW;
    }

    public int getShadowRadius() {
        return this.SE;
    }

    public int getShadowX() {
        return this.QQq;
    }

    public int getShadowY() {
        return this.QQr;
    }

    public int getBubbleRadius() {
        return this.QQs;
    }

    public int getBubbleColor() {
        return this.QQt;
    }

    public void setBubbleColor(int i2) {
        this.QQt = i2;
    }

    public void setLook(a aVar) {
        AppMethodBeat.i(143554);
        this.QQl = aVar;
        hbL();
        AppMethodBeat.o(143554);
    }

    public void setLookPosition(int i2) {
        this.QQn = i2;
    }

    public void setLookWidth(int i2) {
        this.QQo = i2;
    }

    public void setLookLength(int i2) {
        AppMethodBeat.i(143555);
        this.QQp = i2;
        hbL();
        AppMethodBeat.o(143555);
    }

    public void setShadowColor(int i2) {
        this.nYW = i2;
    }

    public void setShadowRadius(int i2) {
        this.SE = i2;
    }

    public void setShadowX(int i2) {
        this.QQq = i2;
    }

    public void setShadowY(int i2) {
        this.QQr = i2;
    }

    public void setBubbleRadius(int i2) {
        this.QQs = i2;
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(143556);
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mLookPosition", this.QQn);
        bundle.putInt("mLookWidth", this.QQo);
        bundle.putInt("mLookLength", this.QQp);
        bundle.putInt("mShadowColor", this.nYW);
        bundle.putInt("mShadowRadius", this.SE);
        bundle.putInt("mShadowX", this.QQq);
        bundle.putInt("mShadowY", this.QQr);
        bundle.putInt("mBubbleRadius", this.QQs);
        bundle.putInt("mWidth", this.mWidth);
        bundle.putInt("mHeight", this.mHeight);
        bundle.putInt("mLeft", this.Al);
        bundle.putInt("mTop", this.Am);
        bundle.putInt("mRight", this.An);
        bundle.putInt("mBottom", this.Ao);
        AppMethodBeat.o(143556);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(143557);
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.QQn = bundle.getInt("mLookPosition");
            this.QQo = bundle.getInt("mLookWidth");
            this.QQp = bundle.getInt("mLookLength");
            this.nYW = bundle.getInt("mShadowColor");
            this.SE = bundle.getInt("mShadowRadius");
            this.QQq = bundle.getInt("mShadowX");
            this.QQr = bundle.getInt("mShadowY");
            this.QQs = bundle.getInt("mBubbleRadius");
            this.mWidth = bundle.getInt("mWidth");
            this.mHeight = bundle.getInt("mHeight");
            this.Al = bundle.getInt("mLeft");
            this.Am = bundle.getInt("mTop");
            this.An = bundle.getInt("mRight");
            this.Ao = bundle.getInt("mBottom");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            AppMethodBeat.o(143557);
            return;
        }
        super.onRestoreInstanceState(parcelable);
        AppMethodBeat.o(143557);
    }

    public void setOnClickEdgeListener(b bVar) {
        this.QQu = bVar;
    }
}
