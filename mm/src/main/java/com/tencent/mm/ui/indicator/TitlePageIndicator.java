package com.tencent.mm.ui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.v;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.CustomViewPager;
import java.util.ArrayList;

public class TitlePageIndicator extends View implements b {
    private ViewPager.OnPageChangeListener Qlc;
    private int Qld = -1;
    private float Qle;
    private int Qlf;
    private final Paint Qlg = new Paint();
    private boolean Qlh;
    private int Qli;
    private int Qlj;
    private int Qlk;
    private int Qll;
    private float Qlm;
    private float Qln;
    private float Qlo;
    private a Qlp;
    private a Qlq;
    private int mActivePointerId = -1;
    private final Rect mBounds = new Rect();
    private float mLastMotionX = -1.0f;
    private int mScrollState;
    private int mTouchSlop;
    private CustomViewPager mViewPager;
    private boolean okz;

    public TitlePageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(205321);
        init();
        AppMethodBeat.o(205321);
    }

    public TitlePageIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(205322);
        init();
        AppMethodBeat.o(205322);
    }

    private void init() {
        AppMethodBeat.i(205323);
        if (isInEditMode()) {
            AppMethodBeat.o(205323);
            return;
        }
        this.Qln = (float) a.fromDPToPix(getContext(), 16);
        this.Qlm = (float) a.fromDPToPix(getContext(), 16);
        this.Qlo = (float) a.fromDPToPix(getContext(), 16);
        this.Qli = a.n(getContext(), R.color.f3046d);
        this.Qlj = a.n(getContext(), R.color.afz);
        this.Qlk = a.fromDPToPix(getContext(), 17);
        this.Qll = a.fromDPToPix(getContext(), 22);
        this.Qlp = new a(this.Qli, this.Qlj);
        this.Qlq = new a(this.Qlj, this.Qli);
        this.Qlh = true;
        this.Qlg.setAntiAlias(true);
        this.Qlg.setTextAlign(Paint.Align.LEFT);
        this.mTouchSlop = v.a(ViewConfiguration.get(getContext()));
        AppMethodBeat.o(205323);
    }

    public int getSelectedColor() {
        return this.Qlj;
    }

    public void setSelectedColor(int i2) {
        AppMethodBeat.i(205324);
        this.Qlj = i2;
        invalidate();
        AppMethodBeat.o(205324);
    }

    public void setSelectedBold(boolean z) {
        AppMethodBeat.i(205325);
        this.Qlh = z;
        invalidate();
        AppMethodBeat.o(205325);
    }

    public int getTextColor() {
        return this.Qli;
    }

    public void setTextColor(int i2) {
        AppMethodBeat.i(205326);
        this.Qlg.setColor(i2);
        this.Qli = i2;
        invalidate();
        AppMethodBeat.o(205326);
    }

    public float getTextSize() {
        AppMethodBeat.i(205327);
        float textSize = this.Qlg.getTextSize();
        AppMethodBeat.o(205327);
        return textSize;
    }

    public void setTextSize(float f2) {
        AppMethodBeat.i(205328);
        this.Qlg.setTextSize(f2);
        invalidate();
        AppMethodBeat.o(205328);
    }

    public float getTitlePadding() {
        return this.Qlm;
    }

    public void setTitlePadding(float f2) {
        AppMethodBeat.i(205329);
        this.Qlm = f2;
        invalidate();
        AppMethodBeat.o(205329);
    }

    public float getTopPadding() {
        return this.Qln;
    }

    public void setTopPadding(float f2) {
        AppMethodBeat.i(205330);
        this.Qln = f2;
        invalidate();
        AppMethodBeat.o(205330);
    }

    public float getClipPadding() {
        return this.Qlo;
    }

    public void setTypeface(Typeface typeface) {
        AppMethodBeat.i(205331);
        this.Qlg.setTypeface(typeface);
        invalidate();
        AppMethodBeat.o(205331);
    }

    public Typeface getTypeface() {
        AppMethodBeat.i(205332);
        Typeface typeface = this.Qlg.getTypeface();
        AppMethodBeat.o(205332);
        return typeface;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        int i2;
        Rect a2;
        AppMethodBeat.i(205333);
        super.onDraw(canvas);
        if (this.mViewPager == null) {
            AppMethodBeat.o(205333);
            return;
        }
        int count = getCount();
        if (count == 0) {
            AppMethodBeat.o(205333);
            return;
        }
        if (this.Qld == -1 && this.mViewPager != null) {
            this.Qld = this.mViewPager.getCurrentItem();
        }
        int left = getLeft();
        int width = left + getWidth();
        int i3 = this.Qld;
        if (((double) this.Qle) <= 0.5d) {
            f2 = this.Qle;
            i2 = i3;
        } else {
            f2 = 1.0f - this.Qle;
            i2 = i3 + 1;
        }
        Paint paint = this.Qlg;
        ArrayList arrayList = new ArrayList();
        int count2 = getCount();
        int width2 = getWidth();
        getHeight();
        int i4 = width2 / 2;
        for (int i5 = 0; i5 < count2; i5++) {
            if (i2 == i5) {
                paint.setTextSize(((float) this.Qll) - (((float) (this.Qll - this.Qlk)) * f2));
                a2 = a(i5, paint);
            } else {
                paint.setTextSize((((float) (this.Qll - this.Qlk)) * f2) + ((float) this.Qlk));
                a2 = a(i5, paint);
            }
            int i6 = a2.right - a2.left;
            int i7 = a2.bottom;
            int i8 = a2.top;
            a2.left = (((int) (((float) i4) - (((float) i6) / 2.0f))) - (((int) (((float) this.Qlf) - (this.Qle * (((float) i6) + getClipPadding())))) / 2)) + (((int) (((float) (i5 - this.Qld)) * (((float) (width2 - i6)) - getClipPadding()))) / 2);
            a2.right = i6 + a2.left;
            arrayList.add(a2);
        }
        int size = arrayList.size();
        if (this.Qld >= size) {
            setCurrentItem(size - 1);
            AppMethodBeat.o(205333);
            return;
        }
        int i9 = 0;
        while (i9 < count) {
            Rect rect = (Rect) arrayList.get(i9);
            if ((rect.left > left && rect.left < width) || (rect.right > left && rect.right < width)) {
                boolean z = i9 == i2;
                CharSequence aoj = aoj(i9);
                if (z) {
                    this.Qlg.setTextSize(((float) this.Qll) - (((float) (this.Qll - this.Qlk)) * f2));
                    this.Qlg.setColor(this.Qlq.getColor((int) (100.0f * f2)));
                } else {
                    this.Qlg.setTextSize((((float) (this.Qll - this.Qlk)) * f2) + ((float) this.Qlk));
                    this.Qlg.setColor(this.Qlp.getColor((int) (100.0f * f2)));
                }
                canvas.drawText(aoj, 0, aoj.length(), (float) rect.left, (float) rect.bottom, this.Qlg);
            }
            i9++;
        }
        AppMethodBeat.o(205333);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2 = 0;
        AppMethodBeat.i(205334);
        if (super.onTouchEvent(motionEvent)) {
            AppMethodBeat.o(205334);
            return true;
        } else if (this.mViewPager == null || getCount() == 0) {
            AppMethodBeat.o(205334);
            return false;
        } else {
            int action = motionEvent.getAction() & 255;
            switch (action) {
                case 0:
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    this.mLastMotionX = motionEvent.getX();
                    break;
                case 1:
                case 3:
                    if (!this.okz) {
                        int count = getCount();
                        int width = getWidth();
                        float f2 = ((float) width) / 2.0f;
                        float f3 = ((float) width) / 6.0f;
                        float f4 = f2 - f3;
                        float f5 = f3 + f2;
                        float x = motionEvent.getX();
                        if (x < f4) {
                            if (this.Qld > 0) {
                                if (action != 3) {
                                    this.mViewPager.setCurrentItem(this.Qld - 1);
                                }
                                AppMethodBeat.o(205334);
                                return true;
                            }
                        } else if (x > f5 && this.Qld < count - 1) {
                            if (action != 3) {
                                this.mViewPager.setCurrentItem(this.Qld + 1);
                            }
                            AppMethodBeat.o(205334);
                            return true;
                        }
                    }
                    this.okz = false;
                    this.mActivePointerId = -1;
                    if (this.mViewPager.isFakeDragging()) {
                        this.mViewPager.endFakeDrag();
                        break;
                    }
                    break;
                case 2:
                    float x2 = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                    float f6 = x2 - this.mLastMotionX;
                    if (!this.okz && Math.abs(f6) > ((float) this.mTouchSlop)) {
                        this.okz = true;
                    }
                    if (this.okz) {
                        this.mLastMotionX = x2;
                        if (this.mViewPager.isFakeDragging() || this.mViewPager.beginFakeDrag()) {
                            this.mViewPager.fakeDragBy(f6);
                            break;
                        }
                    }
                    break;
                case 5:
                    int actionIndex = motionEvent.getActionIndex();
                    this.mLastMotionX = motionEvent.getX(actionIndex);
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                    break;
                case 6:
                    int actionIndex2 = motionEvent.getActionIndex();
                    if (motionEvent.getPointerId(actionIndex2) == this.mActivePointerId) {
                        if (actionIndex2 == 0) {
                            i2 = 1;
                        }
                        this.mActivePointerId = motionEvent.getPointerId(i2);
                    }
                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                    break;
            }
            AppMethodBeat.o(205334);
            return true;
        }
    }

    private Rect a(int i2, Paint paint) {
        AppMethodBeat.i(205335);
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        CharSequence aoj = aoj(i2);
        paint.getTextBounds(aoj.toString(), 0, aoj.length(), rect2);
        rect.left = 0;
        rect.top = (getHeight() - rect2.height()) / 2;
        rect.right = rect.left + rect2.width();
        rect.bottom = rect2.height() + rect.top;
        AppMethodBeat.o(205335);
        return rect;
    }

    public void setViewPager(CustomViewPager customViewPager) {
        AppMethodBeat.i(205336);
        if (this.mViewPager == customViewPager) {
            AppMethodBeat.o(205336);
            return;
        }
        if (this.mViewPager != null) {
            this.mViewPager.setOnPageChangeListener(null);
        }
        if (customViewPager.getAdapter() == null) {
            IllegalStateException illegalStateException = new IllegalStateException("ViewPager does not have adapter instance.");
            AppMethodBeat.o(205336);
            throw illegalStateException;
        }
        this.mViewPager = customViewPager;
        this.mViewPager.setOnPageChangeListener(this);
        invalidate();
        AppMethodBeat.o(205336);
    }

    public void setCurrentItem(int i2) {
        AppMethodBeat.i(205337);
        if (this.mViewPager == null) {
            IllegalStateException illegalStateException = new IllegalStateException("ViewPager has not been bound.");
            AppMethodBeat.o(205337);
            throw illegalStateException;
        }
        this.mViewPager.setCurrentItem(i2);
        this.Qld = i2;
        invalidate();
        AppMethodBeat.o(205337);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        AppMethodBeat.i(205338);
        this.mScrollState = i2;
        if (this.Qlc != null) {
            this.Qlc.onPageScrollStateChanged(i2);
        }
        AppMethodBeat.o(205338);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        AppMethodBeat.i(205339);
        Log.i("MicroMsg.TitlePageIndicator", "onPageScrolled %s, %s, %s", Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3));
        this.Qld = i2;
        this.Qle = f2;
        this.Qlf = i3;
        invalidate();
        if (this.Qlc != null) {
            this.Qlc.onPageScrolled(i2, f2, i3);
        }
        AppMethodBeat.o(205339);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        AppMethodBeat.i(205340);
        if (this.mScrollState == 0) {
            this.Qld = i2;
            invalidate();
        }
        if (this.Qlc != null) {
            this.Qlc.onPageSelected(i2);
        }
        AppMethodBeat.o(205340);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.Qlc = onPageChangeListener;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(205341);
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Qld = savedState.zXP;
        requestLayout();
        AppMethodBeat.o(205341);
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(205342);
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.zXP = this.Qld;
        AppMethodBeat.o(205342);
        return savedState;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.tencent.mm.ui.indicator.TitlePageIndicator.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                AppMethodBeat.i(205317);
                SavedState savedState = new SavedState(parcel, (byte) 0);
                AppMethodBeat.o(205317);
                return savedState;
            }
        };
        int zXP;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            AppMethodBeat.i(205318);
            this.zXP = parcel.readInt();
            AppMethodBeat.o(205318);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(205319);
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.zXP);
            AppMethodBeat.o(205319);
        }

        static {
            AppMethodBeat.i(205320);
            AppMethodBeat.o(205320);
        }
    }

    private CharSequence aoj(int i2) {
        AppMethodBeat.i(205343);
        CharSequence pageTitle = this.mViewPager.getAdapter().getPageTitle(i2);
        if (pageTitle == null) {
            pageTitle = "";
        }
        AppMethodBeat.o(205343);
        return pageTitle;
    }

    private int getCount() {
        AppMethodBeat.i(205344);
        int count = this.mViewPager.getAdapter().getCount() + 1;
        AppMethodBeat.o(205344);
        return count;
    }
}
