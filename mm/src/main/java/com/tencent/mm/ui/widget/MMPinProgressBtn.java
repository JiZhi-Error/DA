package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class MMPinProgressBtn extends CompoundButton {
    private Paint DAX;
    private int HH;
    private int QCZ;
    private int QDa;
    private final float QDb = 4.0f;
    private Runnable QDc = new Runnable() {
        /* class com.tencent.mm.ui.widget.MMPinProgressBtn.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(143379);
            if (MMPinProgressBtn.this.getVisibility() != 0) {
                Log.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
                AppMethodBeat.o(143379);
                return;
            }
            MMPinProgressBtn.this.HH++;
            if (MMPinProgressBtn.this.HH >= MMPinProgressBtn.this.QCZ) {
                MMPinProgressBtn.this.HH--;
                Log.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
                AppMethodBeat.o(143379);
                return;
            }
            MMPinProgressBtn.this.invalidate();
            MMPinProgressBtn.this.postDelayed(MMPinProgressBtn.this.QDc, 200);
            AppMethodBeat.o(143379);
        }
    };
    private Paint ST;
    private RectF asb = new RectF();
    private int style;

    public MMPinProgressBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143384);
        c(context, attributeSet, 0);
        AppMethodBeat.o(143384);
    }

    public MMPinProgressBtn(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143385);
        c(context, attributeSet, i2);
        AppMethodBeat.o(143385);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(android.content.Context r10, android.util.AttributeSet r11, int r12) {
        /*
        // Method dump skipped, instructions count: 166
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.MMPinProgressBtn.c(android.content.Context, android.util.AttributeSet, int):void");
    }

    public int getMax() {
        return this.QCZ;
    }

    public void setMax(int i2) {
        AppMethodBeat.i(143387);
        this.QCZ = Math.max(0, i2);
        invalidate();
        AppMethodBeat.o(143387);
    }

    public int getProgress() {
        return this.HH;
    }

    public void setProgress(int i2) {
        AppMethodBeat.i(143388);
        this.HH = Math.max(0, i2);
        this.HH = Math.min(i2, this.QCZ);
        invalidate();
        AppMethodBeat.o(143388);
    }

    public final void gYN() {
        AppMethodBeat.i(143389);
        removeCallbacks(this.QDc);
        post(this.QDc);
        AppMethodBeat.o(143389);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(143390);
        setMeasuredDimension(resolveSize(this.QDa, i2), resolveSize(this.QDa, i3));
        AppMethodBeat.o(143390);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(143391);
        super.onDraw(canvas);
        this.asb.set(2.0f, 2.0f, ((float) this.QDa) - 2.0f, ((float) this.QDa) - 2.0f);
        this.asb.offset((float) ((getWidth() - this.QDa) / 2), (float) ((getHeight() - this.QDa) / 2));
        canvas.drawArc(this.asb, 0.0f, 360.0f, true, this.ST);
        switch (this.style) {
            case 0:
                this.asb.set(8.0f, 8.0f, ((float) this.QDa) - 8.0f, ((float) this.QDa) - 8.0f);
                this.asb.offset((float) ((getWidth() - this.QDa) / 2), (float) ((getHeight() - this.QDa) / 2));
                canvas.drawArc(this.asb, -90.0f, 360.0f * ((((float) this.HH) * 1.0f) / ((float) this.QCZ)), true, this.DAX);
                AppMethodBeat.o(143391);
                return;
            case 1:
                this.asb.set(2.0f, 2.0f, ((float) this.QDa) - 2.0f, ((float) this.QDa) - 2.0f);
                this.asb.offset((float) ((getWidth() - this.QDa) / 2), (float) ((getHeight() - this.QDa) / 2));
                canvas.drawArc(this.asb, 270.0f, (((((float) this.HH) * 1.0f) / ((float) this.QCZ)) * 360.0f) - 360.0f, true, this.DAX);
                break;
        }
        AppMethodBeat.o(143391);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.tencent.mm.ui.widget.MMPinProgressBtn.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                AppMethodBeat.i(143380);
                SavedState savedState = new SavedState(parcel, (byte) 0);
                AppMethodBeat.o(143380);
                return savedState;
            }
        };
        private int HH;
        private int QCZ;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            AppMethodBeat.i(143381);
            this.HH = parcel.readInt();
            this.QCZ = parcel.readInt();
            AppMethodBeat.o(143381);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(143382);
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.HH);
            parcel.writeInt(this.QCZ);
            AppMethodBeat.o(143382);
        }

        static {
            AppMethodBeat.i(143383);
            AppMethodBeat.o(143383);
        }
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(143392);
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isSaveEnabled()) {
            SavedState savedState = new SavedState(onSaveInstanceState);
            savedState.QCZ = this.QCZ;
            savedState.HH = this.HH;
            AppMethodBeat.o(143392);
            return savedState;
        }
        AppMethodBeat.o(143392);
        return onSaveInstanceState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(143393);
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            AppMethodBeat.o(143393);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.QCZ = savedState.QCZ;
        this.HH = savedState.HH;
        AppMethodBeat.o(143393);
    }
}
