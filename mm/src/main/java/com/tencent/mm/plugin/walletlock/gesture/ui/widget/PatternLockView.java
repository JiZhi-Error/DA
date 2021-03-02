package com.tencent.mm.plugin.walletlock.gesture.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.walletlock.a;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView extends View {
    private float IwA;
    private float IwB;
    private a IwC;
    private Paint Iwe = new Paint();
    private Paint Iwf = new Paint();
    private Path Iwg = new Path();
    private Matrix Iwh = new Matrix();
    private Rect Iwi = new Rect();
    private Rect Iwj = new Rect();
    private ArrayList<f> Iwk = new ArrayList<>(9);
    private boolean[][] Iwl = ((boolean[][]) Array.newInstance(Boolean.TYPE, 3, 3));
    private c Iwm = c.Square;
    private int Iwn = 200;
    private float Iwo = 0.66f;
    private boolean Iwp = false;
    private boolean Iwq = true;
    private boolean Iwr = false;
    private b Iws;
    private Bitmap Iwt;
    private Bitmap Iwu;
    private Bitmap Iwv;
    private Bitmap Iww;
    private float Iwx;
    private float Iwy;
    private long Iwz;
    private int mBitmapHeight;
    private int mBitmapWidth;
    private boolean okz;
    private int qSa = 6;
    private int rLa;

    public interface a {
        void a(PatternLockView patternLockView);

        void a(PatternLockView patternLockView, List<f> list);
    }

    public enum b {
        Correct,
        Wrong,
        Animate;

        public static b valueOf(String str) {
            AppMethodBeat.i(129856);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(129856);
            return bVar;
        }

        static {
            AppMethodBeat.i(129857);
            AppMethodBeat.o(129857);
        }
    }

    public enum c {
        Square,
        Rectangle;

        public static c valueOf(String str) {
            AppMethodBeat.i(129863);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(129863);
            return cVar;
        }

        static {
            AppMethodBeat.i(129864);
            AppMethodBeat.o(129864);
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                AppMethodBeat.i(129858);
                SavedState savedState = new SavedState(parcel);
                AppMethodBeat.o(129858);
                return savedState;
            }
        };
        String IwI;
        int IwJ;
        boolean Iwp;
        boolean Iwq;
        boolean Iwr;

        public SavedState(Parcel parcel) {
            super(parcel);
            AppMethodBeat.i(129859);
            this.IwI = parcel.readString();
            this.IwJ = parcel.readInt();
            this.Iwq = ((Boolean) parcel.readValue(null)).booleanValue();
            this.Iwr = ((Boolean) parcel.readValue(null)).booleanValue();
            this.Iwp = ((Boolean) parcel.readValue(null)).booleanValue();
            AppMethodBeat.o(129859);
        }

        public SavedState(Parcelable parcelable, String str, int i2, boolean z, boolean z2, boolean z3) {
            super(parcelable);
            this.IwI = str;
            this.IwJ = i2;
            this.Iwq = z;
            this.Iwr = z2;
            this.Iwp = z3;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(129860);
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.IwI);
            parcel.writeInt(this.IwJ);
            parcel.writeValue(Boolean.valueOf(this.Iwq));
            parcel.writeValue(Boolean.valueOf(this.Iwr));
            parcel.writeValue(Boolean.valueOf(this.Iwp));
            AppMethodBeat.o(129860);
        }

        static {
            AppMethodBeat.i(129861);
            AppMethodBeat.o(129861);
        }
    }

    public PatternLockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int color;
        AppMethodBeat.i(129865);
        if (isInEditMode()) {
            color = -1;
        } else {
            color = getResources().getColor(R.color.Brand);
        }
        this.rLa = color;
        this.Iws = b.Correct;
        this.Iwt = null;
        this.Iwu = null;
        this.Iwv = null;
        this.Iww = null;
        this.Iwx = -1.0f;
        this.Iwy = -1.0f;
        this.okz = false;
        this.Iwz = 0;
        this.mBitmapWidth = 0;
        this.mBitmapHeight = 0;
        this.IwA = 0.0f;
        this.IwB = 0.0f;
        this.IwC = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C1928a.mm_patternlock_view);
        this.Iwq = obtainStyledAttributes.getBoolean(4, this.Iwq);
        this.Iwn = obtainStyledAttributes.getInt(1, this.Iwn);
        this.qSa = obtainStyledAttributes.getInt(2, this.qSa);
        this.Iwp = obtainStyledAttributes.getBoolean(0, this.Iwp);
        switch (obtainStyledAttributes.getInt(3, this.Iwm.ordinal())) {
            case 0:
                this.Iwm = c.Square;
                break;
            case 1:
                this.Iwm = c.Rectangle;
                break;
            default:
                this.Iwm = c.Square;
                break;
        }
        obtainStyledAttributes.recycle();
        setClickable(true);
        this.Iwf.setStyle(Paint.Style.STROKE);
        this.Iwf.setStrokeJoin(Paint.Join.ROUND);
        this.Iwf.setStrokeCap(Paint.Cap.ROUND);
        this.Iwf.setAntiAlias(true);
        this.Iwf.setDither(false);
        this.Iwf.setAlpha(this.Iwn);
        this.Iwe.setAntiAlias(true);
        this.Iwe.setDither(true);
        if (!isInEditMode()) {
            if (this.Iwt == null) {
                this.Iwt = drawable2Bitmap(com.tencent.mm.cb.a.l(getContext(), R.drawable.a6s));
                this.Iwu = drawable2Bitmap(com.tencent.mm.cb.a.l(getContext(), R.drawable.a6t));
                this.Iwv = this.Iwu;
                this.Iww = drawable2Bitmap(com.tencent.mm.cb.a.l(getContext(), R.drawable.a6u));
            }
            this.qSa = (int) (((float) this.qSa) * BitmapUtil.getDefaultDisplayMetrics().density);
            Bitmap[] bitmapArr = {this.Iwt, this.Iwu, this.Iwv, this.Iww};
            for (int i2 = 0; i2 < 4; i2++) {
                Bitmap bitmap = bitmapArr[i2];
                this.mBitmapWidth = Math.max(bitmap.getWidth(), this.mBitmapWidth);
                this.mBitmapHeight = Math.max(bitmap.getHeight(), this.mBitmapHeight);
            }
        }
        AppMethodBeat.o(129865);
    }

    private static Bitmap drawable2Bitmap(Drawable drawable) {
        AppMethodBeat.i(129866);
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        AppMethodBeat.o(129866);
        return createBitmap;
    }

    private static String ig(List<f> list) {
        AppMethodBeat.i(129867);
        if (list == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("pattern is null");
            AppMethodBeat.o(129867);
            throw illegalArgumentException;
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = list.get(i2);
            bArr[i2] = (byte) (fVar.Ivz + (fVar.Ivy * 3));
        }
        String str = new String(bArr);
        AppMethodBeat.o(129867);
        return str;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(129868);
        SavedState savedState = new SavedState(super.onSaveInstanceState(), ig(this.Iwk), this.Iws.ordinal(), this.Iwq, this.Iwr, this.Iwp);
        AppMethodBeat.o(129868);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(129869);
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        b bVar = b.Correct;
        String str = savedState.IwI;
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Serialized pattern is null");
            AppMethodBeat.o(129869);
            throw illegalArgumentException;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bytes = str.getBytes();
        for (byte b2 : bytes) {
            arrayList.add(f.jW(b2 / 3, b2 % 3));
        }
        a(bVar, arrayList);
        this.Iws = b.values()[savedState.IwJ];
        this.Iwq = savedState.Iwq;
        this.Iwr = savedState.Iwr;
        this.Iwp = savedState.Iwp;
        AppMethodBeat.o(129869);
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        AppMethodBeat.i(129870);
        int i2 = (int) ((3.0d * ((double) ((float) this.mBitmapWidth))) / ((double) getResources().getDisplayMetrics().density));
        AppMethodBeat.o(129870);
        return i2;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        AppMethodBeat.i(129871);
        int i2 = (int) ((3.0d * ((double) ((float) this.mBitmapHeight))) / ((double) getResources().getDisplayMetrics().density));
        AppMethodBeat.o(129871);
        return i2;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(129872);
        this.IwA = ((float) ((i2 - getPaddingLeft()) - getPaddingRight())) / 3.0f;
        this.IwB = ((float) ((i3 - getPaddingTop()) - getPaddingBottom())) / 3.0f;
        AppMethodBeat.o(129872);
    }

    private static int jX(int i2, int i3) {
        AppMethodBeat.i(129873);
        int size = View.MeasureSpec.getSize(i2);
        switch (View.MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i3 = Math.max(size, i3);
                break;
            case 0:
                break;
            default:
                i3 = size;
                break;
        }
        AppMethodBeat.o(129873);
        return i3;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        AppMethodBeat.i(129874);
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int jX = jX(i2, suggestedMinimumWidth);
        int jX2 = jX(i3, suggestedMinimumHeight);
        if (this.Iwm == c.Square) {
            int min = Math.min(jX, jX2);
            jX2 = min;
            i4 = min;
        } else {
            i4 = jX;
        }
        setMeasuredDimension(i4, jX2);
        AppMethodBeat.o(129874);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(129875);
        ArrayList<f> arrayList = this.Iwk;
        int size = arrayList.size();
        boolean[][] zArr = this.Iwl;
        if (this.Iws == b.Animate) {
            int elapsedRealtime = ((int) (SystemClock.elapsedRealtime() - this.Iwz)) % ((size + 1) * 700);
            int i2 = elapsedRealtime / 700;
            fVn();
            for (int i3 = 0; i3 < i2; i3++) {
                f fVar = arrayList.get(i3);
                zArr[fVar.Ivy][fVar.Ivz] = true;
            }
            if (i2 > 0 && i2 < size) {
                float f2 = ((float) (elapsedRealtime % 700)) / 700.0f;
                f fVar2 = arrayList.get(i2 - 1);
                float afc = afc(fVar2.Ivz);
                float afd = afd(fVar2.Ivy);
                f fVar3 = arrayList.get(i2);
                float afd2 = (afd(fVar3.Ivy) - afd) * f2;
                this.Iwx = afc + ((afc(fVar3.Ivz) - afc) * f2);
                this.Iwy = afd2 + afd;
            }
            invalidate();
        }
        this.Iwf.setColor(this.rLa);
        this.Iwf.setStrokeWidth((float) this.qSa);
        Path path = this.Iwg;
        path.rewind();
        boolean z = this.Iwq || this.Iws == b.Wrong;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        float f3 = this.IwA;
        float f4 = this.IwB;
        boolean z2 = (this.Iwe.getFlags() & 2) != 0;
        this.Iwe.setFilterBitmap(true);
        for (int i4 = 0; i4 < 3; i4++) {
            float f5 = (((float) i4) * f4) + ((float) paddingTop);
            for (int i5 = 0; i5 < 3; i5++) {
                float f6 = ((float) paddingLeft) + (((float) i5) * f3);
                if (!zArr[i4][i5]) {
                    a(canvas, (int) f6, (int) f5, zArr[i4][i5]);
                }
            }
        }
        if (z) {
            boolean z3 = false;
            for (int i6 = 0; i6 < size; i6++) {
                f fVar4 = arrayList.get(i6);
                if (!zArr[fVar4.Ivy][fVar4.Ivz]) {
                    break;
                }
                z3 = true;
                float afc2 = afc(fVar4.Ivz);
                float afd3 = afd(fVar4.Ivy);
                if (i6 == 0) {
                    path.moveTo(afc2, afd3);
                } else {
                    path.lineTo(afc2, afd3);
                }
            }
            if ((this.okz || this.Iws == b.Animate) && z3) {
                path.lineTo(this.Iwx, this.Iwy);
            }
            canvas.drawPath(path, this.Iwf);
        }
        for (int i7 = 0; i7 < 3; i7++) {
            float f7 = (((float) i7) * f4) + ((float) paddingTop);
            for (int i8 = 0; i8 < 3; i8++) {
                float f8 = ((float) paddingLeft) + (((float) i8) * f3);
                if (zArr[i7][i8]) {
                    a(canvas, (int) f8, (int) f7, zArr[i7][i8]);
                }
            }
        }
        this.Iwe.setFilterBitmap(z2);
        AppMethodBeat.o(129875);
    }

    private void a(Canvas canvas, int i2, int i3, boolean z) {
        Bitmap bitmap;
        AppMethodBeat.i(129876);
        if (!z || (!this.Iwq && this.Iws != b.Wrong)) {
            bitmap = this.Iwt;
        } else if (this.okz) {
            bitmap = this.Iwu;
        } else if (this.Iws == b.Wrong) {
            bitmap = this.Iww;
        } else if (this.Iws == b.Correct || this.Iws == b.Animate) {
            bitmap = this.Iwv;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("unknown display mode " + this.Iws);
            AppMethodBeat.o(129876);
            throw illegalStateException;
        }
        int i4 = this.mBitmapWidth;
        int i5 = this.mBitmapHeight;
        float f2 = this.IwA;
        float f3 = getResources().getDisplayMetrics().density;
        float min = Math.min((this.IwA - (33.0f * f3)) / ((float) this.mBitmapWidth), 1.0f);
        float min2 = Math.min((this.IwB - (f3 * 33.0f)) / ((float) this.mBitmapHeight), 1.0f);
        this.Iwh.setTranslate((float) (((int) ((f2 - ((float) i4)) * 0.5f)) + i2), (float) (((int) ((this.IwB - ((float) i5)) * 0.5f)) + i3));
        this.Iwh.preTranslate((float) (this.mBitmapWidth / 2), (float) (this.mBitmapHeight / 2));
        this.Iwh.preScale(min, min2);
        this.Iwh.preTranslate((float) ((-this.mBitmapWidth) / 2), (float) ((-this.mBitmapHeight) / 2));
        if (!isInEditMode()) {
            canvas.drawBitmap(bitmap, this.Iwh, this.Iwe);
        }
        AppMethodBeat.o(129876);
    }

    private f ap(float f2, float f3) {
        int i2 = 0;
        AppMethodBeat.i(129877);
        f fVar = null;
        float f4 = this.IwB;
        float f5 = f4 * this.Iwo;
        float paddingTop = ((f4 - f5) / 2.0f) + ((float) getPaddingTop());
        int i3 = 0;
        while (true) {
            if (i3 >= 3) {
                i3 = -1;
                break;
            }
            float f6 = (((float) i3) * f4) + paddingTop;
            if (f3 >= f6 && f3 <= f6 + f5) {
                break;
            }
            i3++;
        }
        if (i3 >= 0) {
            float f7 = this.IwA;
            float f8 = this.Iwo * f7;
            float paddingLeft = ((float) getPaddingLeft()) + ((f7 - f8) / 2.0f);
            while (true) {
                if (i2 >= 3) {
                    i2 = -1;
                    break;
                }
                float f9 = (((float) i2) * f7) + paddingLeft;
                if (f2 >= f9 && f2 <= f9 + f8) {
                    break;
                }
                i2++;
            }
            if (i2 >= 0 && !this.Iwl[i3][i2]) {
                fVar = f.jW(i3, i2);
            }
        }
        if (fVar != null) {
            this.Iwl[fVar.Ivy][fVar.Ivz] = true;
            this.Iwk.add(fVar);
            if (this.IwC != null) {
                new ArrayList(this.Iwk);
            }
            if (this.Iwp) {
                performHapticFeedback(1, 3);
            }
            AppMethodBeat.o(129877);
            return fVar;
        }
        AppMethodBeat.o(129877);
        return null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f2;
        AppMethodBeat.i(129878);
        if (!this.Iwr || !isEnabled()) {
            AppMethodBeat.o(129878);
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                fVo();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                f ap = ap(x, y);
                if (ap != null) {
                    this.okz = true;
                    this.Iws = b.Correct;
                    if (this.IwC != null) {
                    }
                } else {
                    this.okz = false;
                }
                if (ap != null) {
                    float afc = afc(ap.Ivz);
                    float afd = afd(ap.Ivy);
                    float f3 = this.IwA * 0.5f;
                    float f4 = this.IwB * 0.5f;
                    invalidate((int) (afc - f3), (int) (afd - f4), (int) (afc + f3), (int) (afd + f4));
                }
                this.Iwx = x;
                this.Iwy = y;
                AppMethodBeat.o(129878);
                return true;
            case 1:
                if (!this.Iwk.isEmpty()) {
                    this.okz = false;
                    if (this.IwC != null) {
                        this.IwC.a(this, new ArrayList(this.Iwk));
                    }
                    invalidate();
                }
                AppMethodBeat.o(129878);
                return true;
            case 2:
                float f5 = (float) this.qSa;
                int historySize = motionEvent.getHistorySize();
                this.Iwi.setEmpty();
                boolean z = false;
                int i2 = 0;
                while (i2 < historySize + 1) {
                    float historicalX = i2 < historySize ? motionEvent.getHistoricalX(i2) : motionEvent.getX();
                    float historicalY = i2 < historySize ? motionEvent.getHistoricalY(i2) : motionEvent.getY();
                    f ap2 = ap(historicalX, historicalY);
                    int size = this.Iwk.size();
                    if (ap2 != null && size == 1) {
                        this.okz = true;
                    }
                    float abs = Math.abs(historicalX - this.Iwx);
                    float abs2 = Math.abs(historicalY - this.Iwy);
                    if (abs > 0.0f || abs2 > 0.0f) {
                        z = true;
                    }
                    if (this.okz && size > 0) {
                        f fVar = this.Iwk.get(size - 1);
                        float afc2 = afc(fVar.Ivz);
                        float afd2 = afd(fVar.Ivy);
                        float min = Math.min(afc2, historicalX) - f5;
                        float max = Math.max(afc2, historicalX) + f5;
                        float min2 = Math.min(afd2, historicalY) - f5;
                        float max2 = Math.max(afd2, historicalY) + f5;
                        if (ap2 != null) {
                            float f6 = this.IwA * 0.5f;
                            float f7 = this.IwB * 0.5f;
                            float afc3 = afc(ap2.Ivz);
                            float afd3 = afd(ap2.Ivy);
                            min = Math.min(afc3 - f6, min);
                            max = Math.max(f6 + afc3, max);
                            f2 = Math.min(afd3 - f7, min2);
                            max2 = Math.max(afd3 + f7, max2);
                        } else {
                            f2 = min2;
                        }
                        this.Iwi.union(Math.round(min), Math.round(f2), Math.round(max), Math.round(max2));
                    }
                    i2++;
                }
                this.Iwx = motionEvent.getX();
                if (this.Iwx < ((float) (getPaddingLeft() + this.qSa))) {
                    this.Iwx = (float) (getPaddingLeft() + this.qSa);
                } else if (this.Iwx > ((float) (((getPaddingLeft() + getWidth()) - getPaddingRight()) - this.qSa))) {
                    this.Iwx = (float) (((getPaddingLeft() + getWidth()) - getPaddingRight()) - this.qSa);
                }
                this.Iwy = motionEvent.getY();
                if (this.Iwy < ((float) (getPaddingTop() + this.qSa))) {
                    this.Iwy = (float) (getPaddingTop() + this.qSa);
                } else if (this.Iwy > ((float) (((getPaddingTop() + getHeight()) - getPaddingRight()) - this.qSa))) {
                    this.Iwy = (float) (((getPaddingTop() + getHeight()) - getPaddingBottom()) - this.qSa);
                }
                if (z) {
                    this.Iwj.union(this.Iwi);
                    invalidate(this.Iwj);
                    this.Iwj.set(this.Iwi);
                }
                AppMethodBeat.o(129878);
                return true;
            case 3:
                if (this.okz) {
                    this.okz = false;
                    fVo();
                    if (this.IwC != null) {
                        this.IwC.a(this);
                    }
                }
                AppMethodBeat.o(129878);
                return true;
            default:
                AppMethodBeat.o(129878);
                return false;
        }
    }

    public boolean getEnableHapticFeedback() {
        return this.Iwp;
    }

    public void setEnableHapticFeedback(boolean z) {
        this.Iwp = z;
    }

    public boolean getDisplayLine() {
        return this.Iwq;
    }

    public void setDisplayLine(boolean z) {
        AppMethodBeat.i(129879);
        this.Iwq = z;
        invalidate();
        AppMethodBeat.o(129879);
    }

    public boolean getEnableInput() {
        return this.Iwr;
    }

    public void setEnableInput(boolean z) {
        this.Iwr = z;
    }

    public void setOnPatternListener(a aVar) {
        this.IwC = aVar;
    }

    private void fVn() {
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                this.Iwl[i2][i3] = false;
            }
        }
    }

    private float afc(int i2) {
        AppMethodBeat.i(129880);
        float paddingLeft = ((float) getPaddingLeft()) + (((float) i2) * this.IwA) + (this.IwA * 0.5f);
        AppMethodBeat.o(129880);
        return paddingLeft;
    }

    private float afd(int i2) {
        AppMethodBeat.i(129881);
        float paddingTop = ((float) getPaddingTop()) + (((float) i2) * this.IwB) + (this.IwB * 0.5f);
        AppMethodBeat.o(129881);
        return paddingTop;
    }

    public List<f> getPattern() {
        AppMethodBeat.i(129882);
        ArrayList arrayList = new ArrayList(this.Iwk);
        AppMethodBeat.o(129882);
        return arrayList;
    }

    private void a(b bVar, List<f> list) {
        AppMethodBeat.i(129883);
        this.Iwk.clear();
        fVn();
        this.Iwk.addAll(list);
        Iterator<f> it = this.Iwk.iterator();
        while (it.hasNext()) {
            f next = it.next();
            this.Iwl[next.Ivy][next.Ivz] = true;
        }
        setDisplayMode(bVar);
        AppMethodBeat.o(129883);
    }

    private void fVo() {
        AppMethodBeat.i(129884);
        this.Iwk.clear();
        fVn();
        this.Iws = b.Correct;
        invalidate();
        AppMethodBeat.o(129884);
    }

    public final void fVp() {
        AppMethodBeat.i(129885);
        fVo();
        if (this.IwC != null) {
            this.IwC.a(this);
        }
        AppMethodBeat.o(129885);
    }

    public void setDisplayMode(b bVar) {
        AppMethodBeat.i(129886);
        switch (bVar) {
            case Correct:
                this.rLa = getResources().getColor(R.color.to);
                break;
            case Wrong:
                this.rLa = getResources().getColor(R.color.tr);
                break;
            case Animate:
                if (this.Iwk.size() != 0) {
                    this.Iwr = false;
                    this.rLa = getResources().getColor(R.color.to);
                    f fVar = this.Iwk.get(0);
                    this.Iwx = afc(fVar.Ivz);
                    this.Iwy = afd(fVar.Ivy);
                    fVn();
                    this.Iwz = SystemClock.elapsedRealtime();
                    break;
                } else {
                    IllegalStateException illegalStateException = new IllegalStateException("You should set a pattern before animating.");
                    AppMethodBeat.o(129886);
                    throw illegalStateException;
                }
        }
        this.Iws = bVar;
        invalidate();
        AppMethodBeat.o(129886);
    }
}
