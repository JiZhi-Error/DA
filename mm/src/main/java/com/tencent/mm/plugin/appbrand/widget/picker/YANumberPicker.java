package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.u;
import android.support.v4.widget.p;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.b.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.smtt.sdk.WebView;

public class YANumberPicker extends View {
    private int aYN;
    private int aYO;
    private int aqo = 2;
    private float dep = 0.0f;
    private p hgg;
    private boolean mHasInit = false;
    private int mScrollState = 0;
    private VelocityTracker mVelocityTracker;
    private int oAA = 8;
    private String oAB;
    private String oAC;
    private String oAD;
    private String oAE;
    private float oAF = 1.0f;
    private float oAG = 0.0f;
    private float oAH = 0.0f;
    private float oAI = 0.0f;
    private boolean oAJ = true;
    private boolean oAK = true;
    private boolean oAL = false;
    private boolean oAM = true;
    private boolean oAN = false;
    private boolean oAO = false;
    private boolean oAP = true;
    private Paint oAQ = new Paint();
    private TextPaint oAR = new TextPaint();
    private Paint oAS = new Paint();
    private String[] oAT;
    private CharSequence[] oAU;
    private CharSequence[] oAV;
    private MMHandler oAW;
    private Handler oAX;
    private d oAY;
    private b oAZ;
    private int oAa = -695533;
    private int oAb = 0;
    private int oAc = 0;
    private int oAd = 0;
    private int oAe = 0;
    private int oAf = 0;
    private int oAg = 0;
    private int oAh = 0;
    private int oAi = 0;
    private int oAj = 0;
    private int oAk = -695533;
    private int oAl = 0;
    private int oAm = 0;
    private int oAn = 3;
    private int oAo = 0;
    private int oAp = 0;
    private int oAq = -1;
    private int oAr = -1;
    private int oAs = 0;
    private int oAt = 0;
    private int oAu = 0;
    private int oAv = 0;
    private int oAw = 0;
    private int oAx = 0;
    private int oAy = 0;
    private int oAz = 150;
    private a oBa;
    private c oBb;
    private int oBc;
    private int oBd;
    private int oBe;
    private int oBf;
    private float oBg = 0.0f;
    private float oBh = 0.0f;
    private boolean oBi = false;
    private float oBj;
    private float oBk;
    private float oBl;
    private int oBm = 0;
    private int oBn = 0;
    private int oBo = 0;
    private int oBp = 0;
    private int oBq = 0;
    private int onv;
    private int ozY = -13421773;
    private int ozZ = -695533;

    public interface a {
    }

    public interface b {
        void a(YANumberPicker yANumberPicker, int i2);
    }

    public interface c {
    }

    public interface d {
    }

    static /* synthetic */ void b(YANumberPicker yANumberPicker, int i2) {
        AppMethodBeat.i(138145);
        yANumberPicker.Ay(i2);
        AppMethodBeat.o(138145);
    }

    static /* synthetic */ int c(YANumberPicker yANumberPicker, int i2) {
        AppMethodBeat.i(138147);
        int Az = yANumberPicker.Az(i2);
        AppMethodBeat.o(138147);
        return Az;
    }

    static /* synthetic */ Message c(int i2, int i3, int i4, Object obj) {
        AppMethodBeat.i(138146);
        Message b2 = b(i2, i3, i4, obj);
        AppMethodBeat.o(138146);
        return b2;
    }

    public YANumberPicker(Context context) {
        super(context);
        AppMethodBeat.i(138091);
        init(context);
        AppMethodBeat.o(138091);
    }

    public YANumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(138092);
        a(context, attributeSet);
        init(context);
        AppMethodBeat.o(138092);
    }

    public YANumberPicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(138093);
        a(context, attributeSet);
        init(context);
        AppMethodBeat.o(138093);
    }

    private void a(Context context, AttributeSet attributeSet) {
        String[] strArr;
        AppMethodBeat.i(138094);
        if (attributeSet == null) {
            AppMethodBeat.o(138094);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0163a.YANumberPicker);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 17) {
                this.oAn = obtainStyledAttributes.getInt(index, 3);
            } else if (index == 3) {
                this.oAk = obtainStyledAttributes.getColor(index, -695533);
            } else if (index == 4) {
                this.aqo = obtainStyledAttributes.getDimensionPixelSize(index, 2);
            } else if (index == 5) {
                this.oAl = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == 6) {
                this.oAm = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == 19) {
                CharSequence[] textArray = obtainStyledAttributes.getTextArray(index);
                if (textArray == null) {
                    strArr = null;
                } else {
                    String[] strArr2 = new String[textArray.length];
                    for (int i3 = 0; i3 < textArray.length; i3++) {
                        strArr2[i3] = textArray[i3].toString();
                    }
                    strArr = strArr2;
                }
                this.oAT = strArr;
            } else if (index == 21) {
                this.ozY = obtainStyledAttributes.getColor(index, -13421773);
            } else if (index == 22) {
                this.ozZ = obtainStyledAttributes.getColor(index, -695533);
            } else if (index == 20) {
                this.oAa = obtainStyledAttributes.getColor(index, -695533);
            } else if (index == 25) {
                this.oAb = obtainStyledAttributes.getDimensionPixelSize(index, d(context, 13.0f));
            } else if (index == 26) {
                this.oAc = obtainStyledAttributes.getDimensionPixelSize(index, d(context, 15.0f));
            } else if (index == 24) {
                this.oAd = obtainStyledAttributes.getDimensionPixelSize(index, d(context, 14.0f));
            } else if (index == 14) {
                this.oAq = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == 13) {
                this.oAr = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == 27) {
                this.oAK = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == 18) {
                this.oAJ = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == 8) {
                this.oAB = obtainStyledAttributes.getString(index);
            } else if (index == 0) {
                this.oAE = obtainStyledAttributes.getString(index);
            } else if (index == 7) {
                this.oAD = obtainStyledAttributes.getString(index);
            } else if (index == 12) {
                this.oAg = obtainStyledAttributes.getDimensionPixelSize(index, e(context, 8.0f));
            } else if (index == 11) {
                this.oAh = obtainStyledAttributes.getDimensionPixelSize(index, e(context, 8.0f));
            } else if (index == 10) {
                this.oAi = obtainStyledAttributes.getDimensionPixelSize(index, e(context, 2.0f));
            } else if (index == 9) {
                this.oAj = obtainStyledAttributes.getDimensionPixelSize(index, e(context, 5.0f));
            } else if (index == 1) {
                this.oAU = obtainStyledAttributes.getTextArray(index);
            } else if (index == 2) {
                this.oAV = obtainStyledAttributes.getTextArray(index);
            } else if (index == 16) {
                this.oAO = obtainStyledAttributes.getBoolean(index, false);
            } else if (index == 15) {
                this.oAP = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == 23) {
                this.oAC = obtainStyledAttributes.getString(index);
            }
        }
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(138094);
    }

    private void initHandler() {
        AppMethodBeat.i(138096);
        this.oAW = new MMHandler("HandlerThread-For-Refreshing") {
            /* class com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                int c2;
                int i2 = 0;
                AppMethodBeat.i(138089);
                switch (message.what) {
                    case 1:
                        if (!YANumberPicker.this.hgg.UD.isFinished()) {
                            if (YANumberPicker.this.mScrollState == 0) {
                                YANumberPicker.b(YANumberPicker.this, 1);
                            }
                            YANumberPicker.this.oAW.sendMessageDelayed(YANumberPicker.c(1, 0, 0, message.obj), 32);
                            AppMethodBeat.o(138089);
                            return;
                        }
                        if (YANumberPicker.this.oBn != 0) {
                            if (YANumberPicker.this.mScrollState == 0) {
                                YANumberPicker.b(YANumberPicker.this, 1);
                            }
                            if (YANumberPicker.this.oBn < (-YANumberPicker.this.onv) / 2) {
                                int i3 = (int) ((((float) (YANumberPicker.this.onv + YANumberPicker.this.oBn)) * 300.0f) / ((float) YANumberPicker.this.onv));
                                YANumberPicker.this.hgg.startScroll(0, YANumberPicker.this.oBo, 0, YANumberPicker.this.oBn + YANumberPicker.this.onv, i3 * 3);
                                c2 = YANumberPicker.c(YANumberPicker.this, YANumberPicker.this.oBo + YANumberPicker.this.onv + YANumberPicker.this.oBn);
                                i2 = i3;
                            } else {
                                int i4 = (int) ((((float) (-YANumberPicker.this.oBn)) * 300.0f) / ((float) YANumberPicker.this.onv));
                                YANumberPicker.this.hgg.startScroll(0, YANumberPicker.this.oBo, 0, YANumberPicker.this.oBn, i4 * 3);
                                c2 = YANumberPicker.c(YANumberPicker.this, YANumberPicker.this.oBo + YANumberPicker.this.oBn);
                                i2 = i4;
                            }
                            YANumberPicker.this.postInvalidate();
                        } else {
                            YANumberPicker.b(YANumberPicker.this, 0);
                            c2 = YANumberPicker.c(YANumberPicker.this, YANumberPicker.this.oBo);
                        }
                        Message c3 = YANumberPicker.c(2, YANumberPicker.this.oAy, c2, message.obj);
                        if (YANumberPicker.this.oAP) {
                            YANumberPicker.this.oAX.sendMessageDelayed(c3, (long) (i2 * 2));
                            AppMethodBeat.o(138089);
                            return;
                        }
                        YANumberPicker.this.oAW.sendMessageDelayed(c3, (long) (i2 * 2));
                        AppMethodBeat.o(138089);
                        return;
                    case 2:
                        YANumberPicker.a(YANumberPicker.this, message.arg1, message.arg2, message.obj);
                        break;
                }
                AppMethodBeat.o(138089);
            }
        };
        this.oAX = new Handler() {
            /* class com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker.AnonymousClass2 */

            public final void handleMessage(Message message) {
                AppMethodBeat.i(138090);
                super.handleMessage(message);
                switch (message.what) {
                    case 3:
                        YANumberPicker.this.requestLayout();
                        AppMethodBeat.o(138090);
                        return;
                    case 2:
                        YANumberPicker.a(YANumberPicker.this, message.arg1, message.arg2, message.obj);
                        break;
                }
                AppMethodBeat.o(138090);
            }
        };
        AppMethodBeat.o(138096);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int max;
        int i4 = 0;
        AppMethodBeat.i(138097);
        super.onMeasure(i2, i3);
        jn(false);
        int mode = View.MeasureSpec.getMode(i2);
        this.oBp = mode;
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            max = size;
        } else {
            int i5 = Math.max(this.oAe, this.oAf) == 0 ? 0 : this.oAh;
            if (Math.max(this.oAe, this.oAf) != 0) {
                i4 = this.oAg;
            }
            max = Math.max(this.oAw, ((i5 + i4 + Math.max(this.oAe, this.oAf) + (this.oAj * 2)) * 2) + Math.max(this.oAu, this.oAx)) + getPaddingLeft() + getPaddingRight();
            if (mode == Integer.MIN_VALUE) {
                max = Math.min(max, size);
            }
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        this.oBq = mode2;
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 != 1073741824) {
            int paddingTop = (this.oAn * (this.oAv + (this.oAi * 2))) + getPaddingTop() + getPaddingBottom();
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(paddingTop, size2) : paddingTop;
        }
        setMeasuredDimension(max, size2);
        AppMethodBeat.o(138097);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        int i6;
        boolean z;
        AppMethodBeat.i(138098);
        super.onSizeChanged(i2, i3, i4, i5);
        this.aYN = i2;
        this.aYO = i3;
        this.onv = this.aYO / this.oAn;
        this.oBl = ((float) ((this.aYN + getPaddingLeft()) - getPaddingRight())) / 2.0f;
        if (getOneRecycleSize() <= 1) {
            i6 = 0;
        } else if (this.mHasInit) {
            i6 = getValue() - this.oAs;
        } else {
            i6 = this.oAL ? this.oBm + ((this.oAn - 1) / 2) : 0;
        }
        if (!this.oAK || !this.oAM) {
            z = false;
        } else {
            z = true;
        }
        U(i6, z);
        if (this.oAb > this.onv) {
            this.oAb = this.onv;
        }
        if (this.oAc > this.onv) {
            this.oAc = this.onv;
        }
        if (this.oAS == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("mPaintHint should not be null.");
            AppMethodBeat.o(138098);
            throw illegalArgumentException;
        }
        this.oAS.setTextSize((float) this.oAd);
        this.oAI = a(this.oAS.getFontMetrics());
        this.oAe = a(this.oAB, this.oAS);
        if (this.oAR == null) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("mPaintText should not be null.");
            AppMethodBeat.o(138098);
            throw illegalArgumentException2;
        }
        this.oAR.setTextSize((float) this.oAc);
        this.oAH = a(this.oAR.getFontMetrics());
        this.oAR.setTextSize((float) this.oAb);
        this.oAG = a(this.oAR.getFontMetrics());
        ccy();
        this.oAo = this.oAn / 2;
        this.oAp = this.oAo + 1;
        this.oBj = (float) ((this.oAo * this.aYO) / this.oAn);
        this.oBk = (float) ((this.oAp * this.aYO) / this.oAn);
        if (this.oAl < 0) {
            this.oAl = 0;
        }
        if (this.oAm < 0) {
            this.oAm = 0;
        }
        if (this.oAl + this.oAm != 0 && getPaddingLeft() + this.oAl >= (this.aYN - getPaddingRight()) - this.oAm) {
            int paddingLeft = (((getPaddingLeft() + this.oAl) + getPaddingRight()) + this.oAm) - this.aYN;
            this.oAl = (int) (((float) this.oAl) - ((((float) paddingLeft) * ((float) this.oAl)) / ((float) (this.oAl + this.oAm))));
            this.oAm = (int) (((float) this.oAm) - ((((float) paddingLeft) * ((float) this.oAm)) / ((float) (this.oAl + this.oAm))));
        }
        this.mHasInit = true;
        AppMethodBeat.o(138098);
    }

    public void postInvalidate() {
        AppMethodBeat.i(138099);
        if (!u.aD(this)) {
            AppMethodBeat.o(138099);
            return;
        }
        super.postInvalidate();
        AppMethodBeat.o(138099);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(138100);
        super.onAttachedToWindow();
        if (this.oAW == null) {
            initHandler();
        }
        AppMethodBeat.o(138100);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(138101);
        super.onDetachedFromWindow();
        this.oAW.quit();
        this.oAX = null;
        if (this.onv == 0) {
            AppMethodBeat.o(138101);
            return;
        }
        if (!this.hgg.UD.isFinished()) {
            this.hgg.UD.abortAnimation();
            this.oBo = this.hgg.UD.getCurrY();
            ccz();
            if (this.oBn != 0) {
                if (this.oBn < (-this.onv) / 2) {
                    this.oBo = this.oBo + this.onv + this.oBn;
                } else {
                    this.oBo += this.oBn;
                }
                ccz();
            }
            Ay(0);
        }
        int Az = Az(this.oBo);
        if (Az != this.oAy && this.oAO) {
            try {
                if (this.oAZ != null) {
                    this.oAZ.a(this, this.oAs + Az);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.YANumberPicker", e2, "", new Object[0]);
            }
        }
        this.oAy = Az;
        AppMethodBeat.o(138101);
    }

    public int getOneRecycleSize() {
        return (this.oAr - this.oAq) + 1;
    }

    public int getRawContentSize() {
        if (this.oAT != null) {
            return this.oAT.length;
        }
        return 0;
    }

    public String[] getDisplayedValues() {
        return this.oAT;
    }

    public void setWrapSelectorWheel(boolean z) {
        AppMethodBeat.i(138103);
        if (this.oAK != z) {
            if (z) {
                this.oAK = z;
                ccE();
                postInvalidate();
            } else if (this.mScrollState == 0) {
                ccx();
                AppMethodBeat.o(138103);
                return;
            } else {
                this.oAN = true;
                AppMethodBeat.o(138103);
                return;
            }
        }
        AppMethodBeat.o(138103);
    }

    public int getMinValue() {
        return this.oAs;
    }

    public int getMaxValue() {
        return this.oAt;
    }

    public void setMinValue(int i2) {
        AppMethodBeat.i(138104);
        this.oAs = i2;
        this.oAq = 0;
        ccy();
        AppMethodBeat.o(138104);
    }

    public void setMaxValue(int i2) {
        AppMethodBeat.i(138105);
        if (this.oAT == null) {
            NullPointerException nullPointerException = new NullPointerException("mDisplayedValues should not be null");
            AppMethodBeat.o(138105);
            throw nullPointerException;
        } else if ((i2 - this.oAs) + 1 > this.oAT.length) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + ((i2 - this.oAs) + 1) + " and mDisplayedValues.length is " + this.oAT.length);
            AppMethodBeat.o(138105);
            throw illegalArgumentException;
        } else {
            this.oAt = i2;
            this.oAr = (this.oAt - this.oAs) + this.oAq;
            r(this.oAq, this.oAr, true);
            ccy();
            AppMethodBeat.o(138105);
        }
    }

    public void setValue(int i2) {
        AppMethodBeat.i(138106);
        if (i2 < this.oAs) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("should not set a value less than mMinValue, value is ".concat(String.valueOf(i2)));
            AppMethodBeat.o(138106);
            throw illegalArgumentException;
        } else if (i2 > this.oAt) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("should not set a value greater than mMaxValue, value is ".concat(String.valueOf(i2)));
            AppMethodBeat.o(138106);
            throw illegalArgumentException2;
        } else {
            setPickedIndexRelativeToRaw(i2 - this.oAs);
            AppMethodBeat.o(138106);
        }
    }

    public int getValue() {
        AppMethodBeat.i(138107);
        int pickedIndexRelativeToRaw = getPickedIndexRelativeToRaw() + this.oAs;
        AppMethodBeat.o(138107);
        return pickedIndexRelativeToRaw;
    }

    public String getContentByCurrValue() {
        AppMethodBeat.i(138108);
        String str = this.oAT[getValue() - this.oAs];
        AppMethodBeat.o(138108);
        return str;
    }

    public boolean getWrapSelectorWheel() {
        return this.oAK;
    }

    public boolean getWrapSelectorWheelAbsolutely() {
        return this.oAK && this.oAM;
    }

    public void setHintText(String str) {
        boolean equals;
        AppMethodBeat.i(138109);
        String str2 = this.oAB;
        if (str2 != null) {
            equals = str2.equals(str);
        } else if (str == null) {
            equals = true;
        } else {
            equals = false;
        }
        if (equals) {
            AppMethodBeat.o(138109);
            return;
        }
        this.oAB = str;
        this.oAI = a(this.oAS.getFontMetrics());
        this.oAe = a(this.oAB, this.oAS);
        this.oAX.sendEmptyMessage(3);
        AppMethodBeat.o(138109);
    }

    public void setPickedIndexRelativeToMin(int i2) {
        AppMethodBeat.i(138110);
        if (i2 >= 0 && i2 < getOneRecycleSize()) {
            this.oAy = this.oAq + i2;
            U(i2, this.oAK && this.oAM);
            postInvalidate();
        }
        AppMethodBeat.o(138110);
    }

    public void setNormalTextColor(int i2) {
        AppMethodBeat.i(138111);
        if (this.ozY == i2) {
            AppMethodBeat.o(138111);
            return;
        }
        this.ozY = i2;
        postInvalidate();
        AppMethodBeat.o(138111);
    }

    public void setSelectedTextColor(int i2) {
        AppMethodBeat.i(138112);
        if (this.ozZ == i2) {
            AppMethodBeat.o(138112);
            return;
        }
        this.ozZ = i2;
        postInvalidate();
        AppMethodBeat.o(138112);
    }

    public void setHintTextColor(int i2) {
        AppMethodBeat.i(138113);
        if (this.oAa == i2) {
            AppMethodBeat.o(138113);
            return;
        }
        this.oAa = i2;
        this.oAS.setColor(this.oAa);
        postInvalidate();
        AppMethodBeat.o(138113);
    }

    public void setDividerColor(int i2) {
        AppMethodBeat.i(138114);
        if (this.oAk == i2) {
            AppMethodBeat.o(138114);
            return;
        }
        this.oAk = i2;
        this.oAQ.setColor(this.oAk);
        postInvalidate();
        AppMethodBeat.o(138114);
    }

    public void setDividerHeight(int i2) {
        AppMethodBeat.i(138115);
        if (i2 == this.aqo) {
            AppMethodBeat.o(138115);
            return;
        }
        this.aqo = i2;
        this.oAQ.setStrokeWidth((float) this.aqo);
        postInvalidate();
        AppMethodBeat.o(138115);
    }

    public void setItemPaddingVertical(int i2) {
        AppMethodBeat.i(138116);
        if (this.oAi == i2) {
            AppMethodBeat.o(138116);
            return;
        }
        this.oAi = i2;
        postInvalidate();
        AppMethodBeat.o(138116);
    }

    public void setPickedIndexRelativeToRaw(int i2) {
        AppMethodBeat.i(138117);
        if (this.oAq >= 0 && this.oAq <= i2 && i2 <= this.oAr) {
            this.oAy = i2;
            U(i2 - this.oAq, this.oAK && this.oAM);
            postInvalidate();
        }
        AppMethodBeat.o(138117);
    }

    public int getPickedIndexRelativeToRaw() {
        int Az;
        AppMethodBeat.i(138118);
        if (this.oBn == 0) {
            Az = Az(this.oBo);
        } else if (this.oBn < (-this.onv) / 2) {
            Az = Az(this.oBo + this.onv + this.oBn);
        } else {
            Az = Az(this.oBo + this.oBn);
        }
        AppMethodBeat.o(138118);
        return Az;
    }

    private void r(int i2, int i3, boolean z) {
        boolean z2;
        AppMethodBeat.i(138119);
        if (i2 > i3) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + i2 + ", maxShowIndex is " + i3 + ".");
            AppMethodBeat.o(138119);
            throw illegalArgumentException;
        } else if (this.oAT == null) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("mDisplayedValues should not be null, you need to set mDisplayedValues first.");
            AppMethodBeat.o(138119);
            throw illegalArgumentException2;
        } else if (i2 < 0) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("minShowIndex should not be less than 0, now minShowIndex is ".concat(String.valueOf(i2)));
            AppMethodBeat.o(138119);
            throw illegalArgumentException3;
        } else if (i2 > this.oAT.length - 1) {
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.oAT.length - 1) + " minShowIndex is " + i2);
            AppMethodBeat.o(138119);
            throw illegalArgumentException4;
        } else if (i3 < 0) {
            IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is ".concat(String.valueOf(i3)));
            AppMethodBeat.o(138119);
            throw illegalArgumentException5;
        } else if (i3 > this.oAT.length - 1) {
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.oAT.length - 1) + " maxShowIndex is " + i3);
            AppMethodBeat.o(138119);
            throw illegalArgumentException6;
        } else {
            this.oAq = i2;
            this.oAr = i3;
            if (z) {
                this.oAy = this.oAq + 0;
                if (!this.oAK || !this.oAM) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                U(0, z2);
                postInvalidate();
            }
            AppMethodBeat.o(138119);
        }
    }

    public void setFriction(float f2) {
        AppMethodBeat.i(138120);
        if (f2 <= 0.0f) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("you should set a a positive float friction, now friction is ".concat(String.valueOf(f2)));
            AppMethodBeat.o(138120);
            throw illegalArgumentException;
        }
        ViewConfiguration.get(getContext());
        this.oAF = ViewConfiguration.getScrollFriction() / f2;
        AppMethodBeat.o(138120);
    }

    private void Ay(int i2) {
        if (this.mScrollState != i2) {
            this.mScrollState = i2;
        }
    }

    public void setOnScrollListener(a aVar) {
        this.oBa = aVar;
    }

    public void setOnValueChangedListener(b bVar) {
        this.oAZ = bVar;
    }

    public void setOnValueChangedListenerRelativeToRaw(d dVar) {
        this.oAY = dVar;
    }

    public void setOnValueChangeListenerInScrolling(c cVar) {
        this.oBb = cVar;
    }

    public void setContentTextTypeface(Typeface typeface) {
        AppMethodBeat.i(138121);
        this.oAR.setTypeface(typeface);
        AppMethodBeat.o(138121);
    }

    public void setHintTextTypeface(Typeface typeface) {
        AppMethodBeat.i(138122);
        this.oAS.setTypeface(typeface);
        AppMethodBeat.o(138122);
    }

    private int Az(int i2) {
        boolean z = false;
        AppMethodBeat.i(138123);
        if (this.onv == 0) {
            AppMethodBeat.o(138123);
            return 0;
        }
        int i3 = (i2 / this.onv) + (this.oAn / 2);
        int oneRecycleSize = getOneRecycleSize();
        if (this.oAK && this.oAM) {
            z = true;
        }
        int s = s(i3, oneRecycleSize, z);
        if (s < 0 || s >= getOneRecycleSize()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + s + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.oAK);
            AppMethodBeat.o(138123);
            throw illegalArgumentException;
        }
        int i4 = s + this.oAq;
        AppMethodBeat.o(138123);
        return i4;
    }

    private static int s(int i2, int i3, boolean z) {
        if (i3 <= 0) {
            return 0;
        }
        if (!z) {
            return i2;
        }
        int i4 = i2 % i3;
        if (i4 < 0) {
            return i4 + i3;
        }
        return i4;
    }

    private void ccx() {
        AppMethodBeat.i(138124);
        U(getPickedIndexRelativeToRaw() - this.oAq, false);
        this.oAK = false;
        postInvalidate();
        AppMethodBeat.o(138124);
    }

    private void ccy() {
        AppMethodBeat.i(138125);
        this.oBe = 0;
        this.oBf = (-this.oAn) * this.onv;
        if (this.oAT != null) {
            this.oBe = ((getOneRecycleSize() - (this.oAn / 2)) - 1) * this.onv;
            this.oBf = (-(this.oAn / 2)) * this.onv;
        }
        AppMethodBeat.o(138125);
    }

    private int AA(int i2) {
        if (this.oAK && this.oAM) {
            return i2;
        }
        if (i2 < this.oBf) {
            return this.oBf;
        }
        if (i2 > this.oBe) {
            return this.oBe;
        }
        return i2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(138126);
        if (this.onv == 0) {
            AppMethodBeat.o(138126);
        } else {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            this.oBh = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.oBi = true;
                    this.oAW.removeMessages(1);
                    ccF();
                    this.dep = this.oBh;
                    this.oBg = (float) this.oBo;
                    Ay(0);
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                case 1:
                    if (!this.oBi) {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000);
                        int yVelocity = (int) (velocityTracker.getYVelocity() * this.oAF);
                        if (Math.abs(yVelocity) > this.oAz) {
                            this.hgg.UD.fling(0, this.oBo, 0, -yVelocity, Integer.MIN_VALUE, Integer.MAX_VALUE, AA(Integer.MIN_VALUE), AA(Integer.MAX_VALUE));
                            invalidate();
                            Ay(2);
                        }
                        this.oAW.sendMessageDelayed(b(1, 0, 0, null), 0);
                        if (this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                            this.mVelocityTracker.recycle();
                            this.mVelocityTracker = null;
                            break;
                        }
                    } else {
                        float y = motionEvent.getY();
                        int i5 = 0;
                        while (true) {
                            if (i5 < this.oAn) {
                                if (((float) (this.onv * i5)) <= y && y < ((float) (this.onv * (i5 + 1)))) {
                                    if (i5 >= 0 && i5 < this.oAn) {
                                        int i6 = i5 - (this.oAn / 2);
                                        if (!this.oAK || !this.oAM) {
                                            int pickedIndexRelativeToRaw = getPickedIndexRelativeToRaw();
                                            if (pickedIndexRelativeToRaw + i6 > this.oAr) {
                                                i6 = this.oAr - pickedIndexRelativeToRaw;
                                            } else if (pickedIndexRelativeToRaw + i6 < this.oAq) {
                                                i6 = this.oAq - pickedIndexRelativeToRaw;
                                            }
                                        }
                                        if (this.oBn < (-this.onv) / 2) {
                                            i2 = this.onv + this.oBn;
                                            int i7 = (int) ((((float) (this.onv + this.oBn)) * 300.0f) / ((float) this.onv));
                                            if (i6 < 0) {
                                                i3 = (-i7) - (i6 * 300);
                                            } else {
                                                i3 = i7 + (i6 * 300);
                                            }
                                        } else {
                                            i2 = this.oBn;
                                            int i8 = (int) ((((float) (-this.oBn)) * 300.0f) / ((float) this.onv));
                                            if (i6 < 0) {
                                                i3 = i8 - (i6 * 300);
                                            } else {
                                                i3 = i8 + (i6 * 300);
                                            }
                                        }
                                        int i9 = i2 + (i6 * this.onv);
                                        if (i3 < 300) {
                                            i4 = 300;
                                        } else {
                                            i4 = i3;
                                        }
                                        if (i4 > 600) {
                                            i4 = 600;
                                        }
                                        this.hgg.startScroll(0, this.oBo, 0, i9, i4);
                                        this.oAW.sendMessageDelayed(b(1, 0, 0, null), (long) (i4 / 4));
                                        postInvalidate();
                                        break;
                                    }
                                } else {
                                    i5++;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    float f2 = this.dep - this.oBh;
                    if (!this.oBi || ((float) (-this.oAA)) >= f2 || f2 >= ((float) this.oAA)) {
                        this.oBi = false;
                        this.oBo = AA((int) (f2 + this.oBg));
                        ccz();
                        invalidate();
                    }
                    Ay(1);
                    break;
                case 3:
                    this.oBg = (float) this.oBo;
                    ccF();
                    this.oAW.sendMessageDelayed(b(1, 0, 0, null), 0);
                    break;
            }
            AppMethodBeat.o(138126);
        }
        return true;
    }

    private static float a(Paint.FontMetrics fontMetrics) {
        AppMethodBeat.i(138127);
        if (fontMetrics == null) {
            AppMethodBeat.o(138127);
            return 0.0f;
        }
        float abs = Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
        AppMethodBeat.o(138127);
        return abs;
    }

    private void U(int i2, boolean z) {
        AppMethodBeat.i(138128);
        this.oBm = i2 - ((this.oAn - 1) / 2);
        this.oBm = s(this.oBm, getOneRecycleSize(), z);
        if (this.onv == 0) {
            this.oAL = true;
            AppMethodBeat.o(138128);
            return;
        }
        this.oBo = this.oBm * this.onv;
        this.oBc = this.oBm + (this.oAn / 2);
        this.oBc %= getOneRecycleSize();
        if (this.oBc < 0) {
            this.oBc += getOneRecycleSize();
        }
        this.oBd = this.oBc;
        ccz();
        AppMethodBeat.o(138128);
    }

    public void computeScroll() {
        AppMethodBeat.i(138129);
        if (this.onv == 0) {
            AppMethodBeat.o(138129);
            return;
        }
        if (this.hgg.UD.computeScrollOffset()) {
            this.oBo = this.hgg.UD.getCurrY();
            ccz();
            postInvalidate();
        }
        AppMethodBeat.o(138129);
    }

    private void ccz() {
        AppMethodBeat.i(138130);
        this.oBm = (int) Math.floor((double) (((float) this.oBo) / ((float) this.onv)));
        this.oBn = -(this.oBo - (this.oBm * this.onv));
        if (this.oBb != null) {
            if ((-this.oBn) > this.onv / 2) {
                this.oBd = this.oBm + 1 + (this.oAn / 2);
            } else {
                this.oBd = this.oBm + (this.oAn / 2);
            }
            this.oBd %= getOneRecycleSize();
            if (this.oBd < 0) {
                this.oBd += getOneRecycleSize();
            }
            this.oBc = this.oBd;
        }
        AppMethodBeat.o(138130);
    }

    private void jn(boolean z) {
        AppMethodBeat.i(138131);
        ccA();
        ccB();
        if (z && (this.oBp == Integer.MIN_VALUE || this.oBq == Integer.MIN_VALUE)) {
            this.oAX.sendEmptyMessage(3);
        }
        AppMethodBeat.o(138131);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        float f2;
        float f3;
        AppMethodBeat.i(138132);
        super.onDraw(canvas);
        float f4 = 0.0f;
        for (int i3 = 0; i3 < this.oAn + 1; i3++) {
            float f5 = (float) (this.oBn + (this.onv * i3));
            int s = s(this.oBm + i3, getOneRecycleSize(), this.oAK && this.oAM);
            if (i3 == this.oAn / 2) {
                f4 = ((float) (this.onv + this.oBn)) / ((float) this.onv);
                i2 = a(f4, this.ozY, this.ozZ);
                float f6 = (float) this.oAb;
                f2 = f6 + ((((float) this.oAc) - f6) * f4);
                float f7 = this.oAG;
                f3 = f7 + ((this.oAH - f7) * f4);
            } else if (i3 == (this.oAn / 2) + 1) {
                i2 = a(1.0f - f4, this.ozY, this.ozZ);
                float f8 = (float) this.oAb;
                f2 = ((1.0f - f4) * (((float) this.oAc) - f8)) + f8;
                float f9 = this.oAG;
                f3 = ((1.0f - f4) * (this.oAH - f9)) + f9;
            } else {
                i2 = this.ozY;
                f2 = (float) this.oAb;
                f3 = this.oAG;
            }
            this.oAR.setColor(i2);
            this.oAR.setTextSize(f2);
            if (s >= 0 && s < getOneRecycleSize()) {
                CharSequence charSequence = this.oAT[this.oAq + s];
                if (this.oAC != null) {
                    charSequence = TextUtils.ellipsize(charSequence, this.oAR, (float) (getWidth() - (this.oAj * 2)), getEllipsizeType());
                }
                canvas.drawText(charSequence.toString(), this.oBl, f3 + f5 + ((float) (this.onv / 2)), this.oAR);
            } else if (!TextUtils.isEmpty(this.oAD)) {
                canvas.drawText(this.oAD, this.oBl, f3 + f5 + ((float) (this.onv / 2)), this.oAR);
            }
        }
        if (this.oAJ) {
            canvas.drawLine((float) (getPaddingLeft() + this.oAl), this.oBj, (float) ((this.aYN - getPaddingRight()) - this.oAm), this.oBj, this.oAQ);
            canvas.drawLine((float) (getPaddingLeft() + this.oAl), this.oBk, (float) ((this.aYN - getPaddingRight()) - this.oAm), this.oBk, this.oAQ);
        }
        if (!TextUtils.isEmpty(this.oAB)) {
            canvas.drawText(this.oAB, this.oBl + ((float) ((this.oAu + this.oAe) / 2)) + ((float) this.oAg), ((this.oBj + this.oBk) / 2.0f) + this.oAI, this.oAS);
        }
        AppMethodBeat.o(138132);
    }

    public void setEllipsizeType(String str) {
        AppMethodBeat.i(138133);
        String[] strArr = {"end", "middle", "start"};
        for (int i2 = 0; i2 < 3; i2++) {
            if (strArr[i2].equals(str)) {
                this.oAC = str;
                AppMethodBeat.o(138133);
                return;
            }
        }
        this.oAC = "end";
        AppMethodBeat.o(138133);
    }

    private TextUtils.TruncateAt getEllipsizeType() {
        AppMethodBeat.i(138134);
        String str = this.oAC;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c2 = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.START;
                AppMethodBeat.o(138134);
                return truncateAt;
            case 1:
                TextUtils.TruncateAt truncateAt2 = TextUtils.TruncateAt.MIDDLE;
                AppMethodBeat.o(138134);
                return truncateAt2;
            case 2:
                TextUtils.TruncateAt truncateAt3 = TextUtils.TruncateAt.END;
                AppMethodBeat.o(138134);
                return truncateAt3;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal text ellipsize type.");
                AppMethodBeat.o(138134);
                throw illegalArgumentException;
        }
    }

    private void ccA() {
        AppMethodBeat.i(138135);
        float textSize = this.oAR.getTextSize();
        this.oAR.setTextSize((float) this.oAc);
        this.oAu = a(this.oAT, this.oAR);
        this.oAw = a(this.oAU, this.oAR);
        this.oAx = a(this.oAV, this.oAR);
        this.oAR.setTextSize((float) this.oAd);
        this.oAf = a(this.oAE, this.oAR);
        this.oAR.setTextSize(textSize);
        AppMethodBeat.o(138135);
    }

    private static int a(CharSequence[] charSequenceArr, Paint paint) {
        AppMethodBeat.i(138136);
        if (charSequenceArr == null) {
            AppMethodBeat.o(138136);
            return 0;
        }
        int i2 = 0;
        for (CharSequence charSequence : charSequenceArr) {
            if (charSequence != null) {
                i2 = Math.max(a(charSequence, paint), i2);
            }
        }
        AppMethodBeat.o(138136);
        return i2;
    }

    private static int a(CharSequence charSequence, Paint paint) {
        AppMethodBeat.i(138137);
        if (!TextUtils.isEmpty(charSequence)) {
            int measureText = (int) (paint.measureText(charSequence.toString()) + 0.5f);
            AppMethodBeat.o(138137);
            return measureText;
        }
        AppMethodBeat.o(138137);
        return 0;
    }

    private void ccB() {
        AppMethodBeat.i(138138);
        float textSize = this.oAR.getTextSize();
        this.oAR.setTextSize((float) this.oAc);
        this.oAv = (int) (((double) (this.oAR.getFontMetrics().bottom - this.oAR.getFontMetrics().top)) + 0.5d);
        this.oAR.setTextSize(textSize);
        AppMethodBeat.o(138138);
    }

    private void ccC() {
        AppMethodBeat.i(138139);
        ccD();
        ccE();
        if (this.oAq == -1) {
            this.oAq = 0;
        }
        if (this.oAr == -1) {
            this.oAr = this.oAT.length - 1;
        }
        r(this.oAq, this.oAr, false);
        AppMethodBeat.o(138139);
    }

    private void ccD() {
        if (this.oAT == null) {
            this.oAT = new String[1];
            this.oAT[0] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }

    private void ccE() {
        this.oAM = this.oAT.length > this.oAn;
    }

    private void ccF() {
        AppMethodBeat.i(138140);
        if (this.hgg != null && !this.hgg.UD.isFinished()) {
            this.hgg.startScroll(0, this.hgg.UD.getCurrY(), 0, 0, 1);
            this.hgg.UD.abortAnimation();
            postInvalidate();
        }
        AppMethodBeat.o(138140);
    }

    public final void ccG() {
        AppMethodBeat.i(138141);
        ccF();
        if (this.oAW != null) {
            this.oAW.sendMessageDelayed(b(1, 0, 0, null), 0);
        }
        AppMethodBeat.o(138141);
    }

    private static Message b(int i2, int i3, int i4, Object obj) {
        AppMethodBeat.i(138142);
        Message obtain = Message.obtain();
        obtain.what = i2;
        obtain.arg1 = i3;
        obtain.arg2 = i4;
        obtain.obj = obj;
        AppMethodBeat.o(138142);
        return obtain;
    }

    private static int d(Context context, float f2) {
        AppMethodBeat.i(138143);
        int i2 = (int) ((context.getResources().getDisplayMetrics().scaledDensity * f2) + 0.5f);
        AppMethodBeat.o(138143);
        return i2;
    }

    private static int e(Context context, float f2) {
        AppMethodBeat.i(138144);
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
        AppMethodBeat.o(138144);
        return i2;
    }

    private static int a(float f2, int i2, int i3) {
        int i4 = (i2 & WebView.NIGHT_MODE_COLOR) >>> 24;
        int i5 = (i2 & 16711680) >>> 16;
        int i6 = (i2 & 65280) >>> 8;
        int i7 = (i2 & 255) >>> 0;
        return (((int) ((((float) (((-16777216 & i3) >>> 24) - i4)) * f2) + ((float) i4))) << 24) | (((int) ((((float) (((16711680 & i3) >>> 16) - i5)) * f2) + ((float) i5))) << 16) | (((int) ((((float) (((65280 & i3) >>> 8) - i6)) * f2) + ((float) i6))) << 8) | ((int) ((((float) (((i3 & 255) >>> 0) - i7)) * f2) + ((float) i7)));
    }

    private void init(Context context) {
        AppMethodBeat.i(138095);
        this.hgg = p.a(context, null);
        this.oAz = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.oAA = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.oAb == 0) {
            this.oAb = d(context, 13.0f);
        }
        if (this.oAc == 0) {
            this.oAc = d(context, 15.0f);
        }
        if (this.oAd == 0) {
            this.oAd = d(context, 14.0f);
        }
        if (this.oAg == 0) {
            this.oAg = e(context, 8.0f);
        }
        if (this.oAh == 0) {
            this.oAh = e(context, 8.0f);
        }
        this.oAQ.setColor(this.oAk);
        this.oAQ.setAntiAlias(true);
        this.oAQ.setStyle(Paint.Style.STROKE);
        this.oAQ.setStrokeWidth((float) this.aqo);
        this.oAR.setColor(this.ozY);
        this.oAR.setAntiAlias(true);
        this.oAR.setTextAlign(Paint.Align.CENTER);
        this.oAS.setColor(this.oAa);
        this.oAS.setAntiAlias(true);
        this.oAS.setTextAlign(Paint.Align.CENTER);
        this.oAS.setTextSize((float) this.oAd);
        if (this.oAn % 2 == 0) {
            this.oAn++;
        }
        if (this.oAq == -1 || this.oAr == -1) {
            ccC();
        }
        initHandler();
        AppMethodBeat.o(138095);
    }

    public void setDisplayedValues(String[] strArr) {
        boolean z = true;
        AppMethodBeat.i(138102);
        if (this.oAW != null) {
            this.oAW.removeMessages(1);
        }
        ccF();
        if (strArr == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("newDisplayedValues should not be null.");
            AppMethodBeat.o(138102);
            throw illegalArgumentException;
        } else if ((this.oAt - this.oAs) + 1 > strArr.length) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + ((this.oAt - this.oAs) + 1) + " newDisplayedValues.length is " + strArr.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
            AppMethodBeat.o(138102);
            throw illegalArgumentException2;
        } else {
            this.oAT = strArr;
            ccE();
            jn(true);
            this.oAy = this.oAq + 0;
            if (!this.oAK || !this.oAM) {
                z = false;
            }
            U(0, z);
            postInvalidate();
            this.oAX.sendEmptyMessage(3);
            AppMethodBeat.o(138102);
        }
    }

    static /* synthetic */ void a(YANumberPicker yANumberPicker, int i2, int i3, Object obj) {
        AppMethodBeat.i(138148);
        yANumberPicker.Ay(0);
        if (i2 != i3 && ((obj == null || !(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) && yANumberPicker.oAZ != null)) {
            yANumberPicker.oAZ.a(yANumberPicker, yANumberPicker.oAs + i3);
        }
        yANumberPicker.oAy = i3;
        if (yANumberPicker.oAN) {
            yANumberPicker.oAN = false;
            yANumberPicker.ccx();
        }
        AppMethodBeat.o(138148);
    }
}
