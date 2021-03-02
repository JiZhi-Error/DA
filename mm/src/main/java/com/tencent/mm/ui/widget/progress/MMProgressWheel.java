package com.tencent.mm.ui.widget.progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a;

public class MMProgressWheel extends View {
    private static final String TAG = MMProgressWheel.class.getSimpleName();
    private final int QUJ = 16;
    private final int QUK = 270;
    private final long QUL = 200;
    private int QUM = 4;
    private int QUN = 4;
    private boolean QUO = false;
    private double QUP = 0.0d;
    private double QUQ = 460.0d;
    private float QUR = 0.0f;
    private boolean QUS = true;
    private long QUT = 0;
    private int QUU = -1442840576;
    private int QUV = 16777215;
    private Paint QUW = new Paint();
    private Paint QUX = new Paint();
    private RectF QUY = new RectF();
    private float QUZ = 230.0f;
    private long QVa = 0;
    private boolean QVb;
    private float QVc = 0.0f;
    private boolean QVd = false;
    private a QVe;
    private boolean QVf;
    private int circleRadius = 28;
    private float mProgress = 0.0f;

    public interface a {
    }

    static {
        AppMethodBeat.i(159683);
        AppMethodBeat.o(159683);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MMProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f2;
        boolean z = true;
        AppMethodBeat.i(159665);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0296a.MMProgressWheel);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.QUM = (int) TypedValue.applyDimension(1, (float) this.QUM, displayMetrics);
        this.QUN = (int) TypedValue.applyDimension(1, (float) this.QUN, displayMetrics);
        this.circleRadius = (int) TypedValue.applyDimension(1, (float) this.circleRadius, displayMetrics);
        this.circleRadius = (int) obtainStyledAttributes.getDimension(3, (float) this.circleRadius);
        this.QUO = obtainStyledAttributes.getBoolean(4, false);
        this.QUM = (int) obtainStyledAttributes.getDimension(2, (float) this.QUM);
        this.QUN = (int) obtainStyledAttributes.getDimension(8, (float) this.QUN);
        this.QUZ = obtainStyledAttributes.getFloat(9, this.QUZ / 360.0f) * 360.0f;
        this.QUQ = (double) obtainStyledAttributes.getInt(1, (int) this.QUQ);
        this.QUU = obtainStyledAttributes.getColor(0, this.QUU);
        this.QUV = obtainStyledAttributes.getColor(7, this.QUV);
        this.QVb = obtainStyledAttributes.getBoolean(5, false);
        if (obtainStyledAttributes.getBoolean(6, false)) {
            this.QVa = SystemClock.uptimeMillis();
            this.QVd = true;
            invalidate();
        }
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 17) {
            f2 = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);
        } else {
            f2 = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);
        }
        this.QVf = f2 == 0.0f ? false : z;
        AppMethodBeat.o(159665);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(159666);
        super.onMeasure(i2, i3);
        int paddingLeft = this.circleRadius + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.circleRadius + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            paddingLeft = size;
        } else if (mode == Integer.MIN_VALUE) {
            paddingLeft = Math.min(paddingLeft, size);
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(paddingLeft, paddingTop);
        AppMethodBeat.o(159666);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(159667);
        super.onSizeChanged(i2, i3, i4, i5);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (!this.QUO) {
            int min = Math.min(Math.min((i2 - paddingLeft) - paddingRight, (i3 - paddingBottom) - paddingTop), (this.circleRadius * 2) - (this.QUM * 2));
            int i6 = paddingLeft + ((((i2 - paddingLeft) - paddingRight) - min) / 2);
            int i7 = paddingTop + ((((i3 - paddingTop) - paddingBottom) - min) / 2);
            this.QUY = new RectF((float) (this.QUM + i6), (float) (this.QUM + i7), (float) ((i6 + min) - this.QUM), (float) ((i7 + min) - this.QUM));
        } else {
            this.QUY = new RectF((float) (paddingLeft + this.QUM), (float) (paddingTop + this.QUM), (float) ((i2 - paddingRight) - this.QUM), (float) ((i3 - paddingBottom) - this.QUM));
        }
        hcy();
        invalidate();
        AppMethodBeat.o(159667);
    }

    private void hcy() {
        AppMethodBeat.i(159668);
        this.QUW.setColor(this.QUU);
        this.QUW.setAntiAlias(true);
        this.QUW.setStyle(Paint.Style.STROKE);
        this.QUW.setStrokeWidth((float) this.QUM);
        this.QUX.setColor(this.QUV);
        this.QUX.setAntiAlias(true);
        this.QUX.setStyle(Paint.Style.STROKE);
        this.QUX.setStrokeWidth((float) this.QUN);
        AppMethodBeat.o(159668);
    }

    public void setCallback(a aVar) {
        AppMethodBeat.i(159669);
        this.QVe = aVar;
        if (!this.QVd) {
            hcz();
        }
        AppMethodBeat.o(159669);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        boolean z = true;
        AppMethodBeat.i(159670);
        super.onDraw(canvas);
        canvas.drawArc(this.QUY, 360.0f, 360.0f, false, this.QUX);
        if (!this.QVf) {
            AppMethodBeat.o(159670);
            return;
        }
        if (this.QVd) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.QVa;
            float f3 = (((float) uptimeMillis) * this.QUZ) / 1000.0f;
            if (this.QUT >= 200) {
                this.QUP = ((double) uptimeMillis) + this.QUP;
                if (this.QUP > this.QUQ) {
                    this.QUP -= this.QUQ;
                    this.QUT = 0;
                    this.QUS = !this.QUS;
                }
                float cos = (((float) Math.cos(((this.QUP / this.QUQ) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
                if (this.QUS) {
                    this.QUR = cos * 254.0f;
                } else {
                    float f4 = (1.0f - cos) * 254.0f;
                    this.mProgress += this.QUR - f4;
                    this.QUR = f4;
                }
            } else {
                this.QUT = uptimeMillis + this.QUT;
            }
            this.mProgress += f3;
            if (this.mProgress > 360.0f) {
                this.mProgress -= 360.0f;
            }
            this.QVa = SystemClock.uptimeMillis();
            float f5 = this.mProgress - 90.0f;
            float f6 = 16.0f + this.QUR;
            if (isInEditMode()) {
                f5 = 0.0f;
                f6 = 135.0f;
            }
            canvas.drawArc(this.QUY, f5, f6, false, this.QUW);
        } else {
            float f7 = this.mProgress;
            if (this.mProgress != this.QVc) {
                this.mProgress = Math.min(((((float) (SystemClock.uptimeMillis() - this.QVa)) / 1000.0f) * this.QUZ) + this.mProgress, this.QVc);
                this.QVa = SystemClock.uptimeMillis();
            } else {
                z = false;
            }
            if (f7 != this.mProgress) {
                hcz();
            }
            float f8 = 0.0f;
            float f9 = this.mProgress;
            if (!this.QVb) {
                f8 = ((float) (1.0d - Math.pow((double) (1.0f - (this.mProgress / 360.0f)), 4.0d))) * 360.0f;
                f9 = ((float) (1.0d - Math.pow((double) (1.0f - (this.mProgress / 360.0f)), 2.0d))) * 360.0f;
            }
            if (isInEditMode()) {
                f2 = 360.0f;
            } else {
                f2 = f9;
            }
            canvas.drawArc(this.QUY, f8 - 90.0f, f2, false, this.QUW);
        }
        if (z) {
            invalidate();
        }
        AppMethodBeat.o(159670);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        AppMethodBeat.i(159671);
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            this.QVa = SystemClock.uptimeMillis();
        }
        AppMethodBeat.o(159671);
    }

    private void hcz() {
        AppMethodBeat.i(159672);
        if (this.QVe != null) {
            Math.round((this.mProgress * 100.0f) / 360.0f);
        }
        AppMethodBeat.o(159672);
    }

    public void setInstantProgress(float f2) {
        AppMethodBeat.i(159673);
        if (this.QVd) {
            this.mProgress = 0.0f;
            this.QVd = false;
        }
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (Math.abs(f2 - this.QVc) <= 0.0f) {
            AppMethodBeat.o(159673);
            return;
        }
        this.QVc = Math.min(f2 * 360.0f, 360.0f);
        this.mProgress = this.QVc;
        this.QVa = SystemClock.uptimeMillis();
        invalidate();
        AppMethodBeat.o(159673);
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(159674);
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.mProgress = this.mProgress;
        wheelSavedState.QVc = this.QVc;
        wheelSavedState.QVd = this.QVd;
        wheelSavedState.QUZ = this.QUZ;
        wheelSavedState.QUM = this.QUM;
        wheelSavedState.QUU = this.QUU;
        wheelSavedState.QUN = this.QUN;
        wheelSavedState.QUV = this.QUV;
        wheelSavedState.circleRadius = this.circleRadius;
        wheelSavedState.QVb = this.QVb;
        wheelSavedState.QUO = this.QUO;
        AppMethodBeat.o(159674);
        return wheelSavedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(159675);
        if (!(parcelable instanceof WheelSavedState)) {
            super.onRestoreInstanceState(parcelable);
            AppMethodBeat.o(159675);
            return;
        }
        WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
        super.onRestoreInstanceState(wheelSavedState.getSuperState());
        this.mProgress = wheelSavedState.mProgress;
        this.QVc = wheelSavedState.QVc;
        this.QVd = wheelSavedState.QVd;
        this.QUZ = wheelSavedState.QUZ;
        this.QUM = wheelSavedState.QUM;
        this.QUU = wheelSavedState.QUU;
        this.QUN = wheelSavedState.QUN;
        this.QUV = wheelSavedState.QUV;
        this.circleRadius = wheelSavedState.circleRadius;
        this.QVb = wheelSavedState.QVb;
        this.QUO = wheelSavedState.QUO;
        this.QVa = SystemClock.uptimeMillis();
        AppMethodBeat.o(159675);
    }

    public float getProgress() {
        if (this.QVd) {
            return -1.0f;
        }
        return this.mProgress / 360.0f;
    }

    public void setProgress(float f2) {
        AppMethodBeat.i(159676);
        if (this.QVd) {
            this.mProgress = 0.0f;
            this.QVd = false;
            hcz();
        }
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (Math.abs(f2 - this.QVc) <= 0.0f) {
            AppMethodBeat.o(159676);
            return;
        }
        if (this.mProgress == this.QVc) {
            this.QVa = SystemClock.uptimeMillis();
        }
        this.QVc = Math.min(f2 * 360.0f, 360.0f);
        invalidate();
        AppMethodBeat.o(159676);
    }

    public void setLinearProgress(boolean z) {
        AppMethodBeat.i(159677);
        this.QVb = z;
        if (!this.QVd) {
            invalidate();
        }
        AppMethodBeat.o(159677);
    }

    public int getCircleRadius() {
        return this.circleRadius;
    }

    public void setCircleRadius(int i2) {
        AppMethodBeat.i(159678);
        this.circleRadius = i2;
        if (!this.QVd) {
            invalidate();
        }
        AppMethodBeat.o(159678);
    }

    public int getBarWidth() {
        return this.QUM;
    }

    public void setBarWidth(int i2) {
        AppMethodBeat.i(159679);
        this.QUM = i2;
        if (!this.QVd) {
            invalidate();
        }
        AppMethodBeat.o(159679);
    }

    public int getBarColor() {
        return this.QUU;
    }

    public void setBarColor(int i2) {
        AppMethodBeat.i(159680);
        this.QUU = i2;
        hcy();
        if (!this.QVd) {
            invalidate();
        }
        AppMethodBeat.o(159680);
    }

    public int getRimColor() {
        return this.QUV;
    }

    public void setRimColor(int i2) {
        AppMethodBeat.i(159681);
        this.QUV = i2;
        hcy();
        if (!this.QVd) {
            invalidate();
        }
        AppMethodBeat.o(159681);
    }

    public float getSpinSpeed() {
        return this.QUZ / 360.0f;
    }

    public void setSpinSpeed(float f2) {
        this.QUZ = 360.0f * f2;
    }

    public int getRimWidth() {
        return this.QUN;
    }

    public void setRimWidth(int i2) {
        AppMethodBeat.i(159682);
        this.QUN = i2;
        if (!this.QVd) {
            invalidate();
        }
        AppMethodBeat.o(159682);
    }

    static class WheelSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<WheelSavedState> CREATOR = new Parcelable.Creator<WheelSavedState>() {
            /* class com.tencent.mm.ui.widget.progress.MMProgressWheel.WheelSavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WheelSavedState[] newArray(int i2) {
                return new WheelSavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WheelSavedState createFromParcel(Parcel parcel) {
                AppMethodBeat.i(159661);
                WheelSavedState wheelSavedState = new WheelSavedState(parcel, (byte) 0);
                AppMethodBeat.o(159661);
                return wheelSavedState;
            }
        };
        int QUM;
        int QUN;
        boolean QUO;
        int QUU;
        int QUV;
        float QUZ;
        boolean QVb;
        float QVc;
        boolean QVd;
        int circleRadius;
        float mProgress;

        /* synthetic */ WheelSavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        static {
            AppMethodBeat.i(159664);
            AppMethodBeat.o(159664);
        }

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private WheelSavedState(Parcel parcel) {
            super(parcel);
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(159662);
            this.mProgress = parcel.readFloat();
            this.QVc = parcel.readFloat();
            this.QVd = parcel.readByte() != 0;
            this.QUZ = parcel.readFloat();
            this.QUM = parcel.readInt();
            this.QUU = parcel.readInt();
            this.QUN = parcel.readInt();
            this.QUV = parcel.readInt();
            this.circleRadius = parcel.readInt();
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.QVb = z;
            this.QUO = parcel.readByte() == 0 ? false : z2;
            AppMethodBeat.o(159662);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int i3;
            int i4 = 1;
            AppMethodBeat.i(159663);
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.mProgress);
            parcel.writeFloat(this.QVc);
            parcel.writeByte((byte) (this.QVd ? 1 : 0));
            parcel.writeFloat(this.QUZ);
            parcel.writeInt(this.QUM);
            parcel.writeInt(this.QUU);
            parcel.writeInt(this.QUN);
            parcel.writeInt(this.QUV);
            parcel.writeInt(this.circleRadius);
            if (this.QVb) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            if (!this.QUO) {
                i4 = 0;
            }
            parcel.writeByte((byte) i4);
            AppMethodBeat.o(159663);
        }
    }
}
