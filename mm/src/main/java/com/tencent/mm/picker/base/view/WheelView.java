package com.tencent.mm.picker.base.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.picker.a;
import com.tencent.mm.picker.base.c.d;
import com.tencent.mm.picker.base.c.e;
import com.tencent.stubs.logger.Log;
import java.util.concurrent.Future;

public class WheelView extends View {
    private int Ku;
    private Paint cgU;
    String content;
    private int fs;
    private Handler handler;
    private int jKA;
    private int jKB;
    private int jKC;
    private int jKD;
    private float jKE;
    private int jKF;
    private int jKG;
    private int jKh;
    private int jKi;
    private final int jKj;
    private GestureDetector jKk;
    public com.tencent.mm.picker.base.b.b jKl;
    private boolean jKm;
    public boolean jKn;
    public final com.tencent.mm.picker.base.c.b jKo;
    public Future<?> jKp;
    private Paint jKq;
    private com.tencent.mm.picker.base.a.b<?> jKr;
    private int jKs;
    private float jKt;
    private int jKu;
    private float jKv;
    private float jKw;
    private float jKx;
    private int jKy;
    private int jKz;
    public boolean jqj;
    private String label;
    private Rect rect;
    private long startTime;
    private int textColor;
    private int textSize;

    public enum a {
        CLICK,
        FLING,
        DAGGLE;

        public static a valueOf(String str) {
            AppMethodBeat.i(175301);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(175301);
            return aVar;
        }

        static {
            AppMethodBeat.i(175302);
            AppMethodBeat.o(175302);
        }
    }

    public enum b {
        FILL,
        WRAP;

        public static b valueOf(String str) {
            AppMethodBeat.i(175304);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(175304);
            return bVar;
        }

        static {
            AppMethodBeat.i(175305);
            AppMethodBeat.o(175305);
        }
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(175306);
        this.jKh = 0;
        this.textColor = Color.rgb(255, 255, 255);
        this.jKj = 2;
        this.content = "";
        this.jKm = false;
        this.jKn = true;
        if (com.tencent.mm.picker.c.a.jKQ == null) {
            com.tencent.mm.picker.c.a.jKQ = new com.tencent.mm.picker.base.c.a();
        }
        this.jKo = com.tencent.mm.picker.c.a.jKQ;
        this.jKB = 5;
        this.fs = 0;
        this.jKE = 0.0f;
        this.startTime = 0;
        this.Ku = 17;
        this.jKG = 0;
        this.rect = new Rect();
        this.textSize = getResources().getDimensionPixelSize(R.dimen.afx);
        this.jKs = getResources().getDimensionPixelSize(R.dimen.afw);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0505a.WheelView, 0, 0);
            this.Ku = obtainStyledAttributes.getInt(1, 17);
            this.jKu = obtainStyledAttributes.getColor(0, -2763307);
            obtainStyledAttributes.recycle();
        }
        this.handler = new d(this);
        this.jKk = new GestureDetector(context, new com.tencent.mm.picker.base.b.a(this));
        this.jKk.setIsLongpressEnabled(false);
        this.jqj = true;
        this.jKx = 0.0f;
        this.jKy = -1;
        this.cgU = new Paint();
        this.cgU.setColor(this.textColor);
        this.cgU.setAntiAlias(true);
        this.cgU.setTextSize((float) this.textSize);
        this.jKq = new Paint();
        this.jKq.setColor(this.jKu);
        this.jKq.setAntiAlias(true);
        setLayerType(2, null);
        AppMethodBeat.o(175306);
    }

    private void bkT() {
        AppMethodBeat.i(175307);
        if (this.jKr == null) {
            AppMethodBeat.o(175307);
            return;
        }
        this.jKt = (float) (this.jKh + getPaddingBottom() + getPaddingTop());
        this.jKC = (int) (this.jKt * ((float) this.jKB));
        this.jKD = View.MeasureSpec.getSize(this.jKF);
        this.jKv = (((float) this.jKC) - this.jKt) / 2.0f;
        this.jKw = (((float) this.jKC) + this.jKt) / 2.0f;
        if (this.jKy == -1) {
            if (this.jqj) {
                this.jKy = (this.jKr.getItemsCount() + 1) / 2;
            } else {
                this.jKy = 0;
            }
        }
        this.jKA = this.jKy;
        AppMethodBeat.o(175307);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(175308);
        bkU();
        if (aVar == a.FLING || aVar == a.DAGGLE) {
            this.fs = (int) (((this.jKx % this.jKt) + this.jKt) % this.jKt);
            if (((float) this.fs) > this.jKt / 2.0f) {
                this.fs = (int) (this.jKt - ((float) this.fs));
            } else {
                this.fs = -this.fs;
            }
        }
        this.jKp = this.jKo.h(new e(this, this.fs), 10);
        AppMethodBeat.o(175308);
    }

    public final void bkU() {
        AppMethodBeat.i(175309);
        if (this.jKp != null && !this.jKp.isCancelled()) {
            this.jKp.cancel(true);
            this.jKp = null;
        }
        AppMethodBeat.o(175309);
    }

    public final void setCyclic(boolean z) {
        this.jqj = z;
    }

    public final void setCurrentItem(int i2) {
        AppMethodBeat.i(175310);
        this.jKz = i2;
        this.jKy = i2;
        this.jKx = 0.0f;
        invalidate();
        AppMethodBeat.o(175310);
    }

    public final void setOnItemSelectedListener(com.tencent.mm.picker.base.b.b bVar) {
        this.jKl = bVar;
    }

    public final void setAdapter(com.tencent.mm.picker.base.a.b<?> bVar) {
        AppMethodBeat.i(175311);
        this.jKr = bVar;
        bkT();
        invalidate();
        AppMethodBeat.o(175311);
    }

    public final com.tencent.mm.picker.base.a.b getAdapter() {
        return this.jKr;
    }

    public final int getCurrentItem() {
        AppMethodBeat.i(175312);
        if (this.jKr == null) {
            AppMethodBeat.o(175312);
            return 0;
        } else if (!this.jqj || (this.jKz >= 0 && this.jKz < this.jKr.getItemsCount())) {
            int max = Math.max(0, Math.min(this.jKz, this.jKr.getItemsCount() - 1));
            AppMethodBeat.o(175312);
            return max;
        } else {
            int max2 = Math.max(0, Math.min(Math.abs(Math.abs(this.jKz) - this.jKr.getItemsCount()), this.jKr.getItemsCount() - 1));
            AppMethodBeat.o(175312);
            return max2;
        }
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Object obj;
        AppMethodBeat.i(175313);
        super.onDraw(canvas);
        if (this.jKr == null) {
            AppMethodBeat.o(175313);
            return;
        }
        this.jKy = Math.min(Math.max(0, this.jKy), this.jKr.getItemsCount() - 1);
        Object[] objArr = new Object[this.jKB];
        Object obj2 = new Object();
        Object obj3 = new Object();
        try {
            this.jKA = (((int) (this.jKx / this.jKt)) % this.jKr.getItemsCount()) + this.jKy;
        } catch (ArithmeticException e2) {
            Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (!this.jqj) {
            if (this.jKA < 0) {
                this.jKA = 0;
            }
            if (this.jKA > this.jKr.getItemsCount() - 1) {
                this.jKA = this.jKr.getItemsCount() - 1;
            }
        } else {
            if (this.jKA < 0) {
                this.jKA = this.jKr.getItemsCount() + this.jKA;
            }
            if (this.jKA > this.jKr.getItemsCount() - 1) {
                this.jKA -= this.jKr.getItemsCount();
            }
        }
        float f2 = this.jKx % this.jKt;
        for (int i2 = 0; i2 < this.jKB; i2++) {
            int i3 = this.jKA - ((this.jKB / 2) - i2);
            if (i2 == 0) {
                obj2 = uI(i3 - 1);
            } else {
                obj2 = obj2;
            }
            if (i2 == this.jKB - 1) {
                obj3 = uI(i3 + 1);
            } else {
                obj3 = obj3;
            }
            objArr[i2] = uI(i3);
        }
        canvas.drawLine(0.0f, this.jKv, (float) this.jKD, this.jKv, this.jKq);
        canvas.drawLine(0.0f, this.jKw, (float) this.jKD, this.jKw, this.jKq);
        int i4 = 0;
        while (i4 < this.jKB + 2) {
            if (i4 == 0) {
                obj = obj2;
            } else if (i4 == (this.jKB + 2) - 1) {
                obj = obj3;
            } else {
                obj = objArr[i4 - 1];
            }
            float f3 = (((this.jKt * ((float) i4)) - f2) + (this.jKt / 2.0f)) - this.jKt;
            if (this.jKn || TextUtils.isEmpty(this.label) || TextUtils.isEmpty(cl(obj))) {
                this.content = cl(obj);
            } else {
                this.content = cl(obj) + this.label;
            }
            this.cgU.getTextBounds(this.content, 0, this.content.length(), this.rect);
            switch (this.Ku) {
                case 3:
                    this.jKG = 0;
                    break;
                case 5:
                    this.jKG = this.jKD - this.rect.width();
                    break;
                case 17:
                    if (this.jKm || this.label == null || this.label.equals("") || !this.jKn) {
                        if (this.jKD < this.rect.width()) {
                            bkX();
                            if (!bkY()) {
                                bkV();
                            }
                            this.cgU.getTextBounds(this.content, 0, this.content.length(), this.rect);
                            this.jKG = (int) (((double) (this.jKD - this.rect.width())) * 0.5d);
                            break;
                        } else {
                            this.jKG = (int) (((double) (this.jKD - this.rect.width())) * 0.5d);
                            break;
                        }
                    } else {
                        this.jKG = (int) (((double) (this.jKD - this.rect.width())) * 0.25d);
                        break;
                    }
                    break;
            }
            float f4 = ((float) this.jKC) / 2.0f;
            int interpolation = (int) ((1.0f - new AccelerateInterpolator(0.3f).getInterpolation(Math.abs((f3 - f4) / f4))) * ((float) this.jKi));
            if (((float) interpolation) < ((float) this.jKi) * 0.14f) {
                interpolation = (int) (((float) this.jKi) * 0.14f);
            } else if (interpolation > this.jKi) {
                interpolation = this.jKi;
            }
            this.cgU.setAlpha(interpolation);
            if (f3 >= this.jKv && f3 <= this.jKw) {
                this.jKz = (this.jKA - ((this.jKB / 2) - i4)) - 1;
            }
            if (f3 >= 0.0f && f3 <= ((float) this.jKC)) {
                Paint.FontMetricsInt fontMetricsInt = this.cgU.getFontMetricsInt();
                float f5 = (float) fontMetricsInt.bottom;
                canvas.drawText(this.content, (float) this.jKG, (f3 - f5) + ((f5 + ((float) Math.abs(fontMetricsInt.top))) / 2.0f), this.cgU);
            }
            i4++;
            this.cgU.setTextSize((float) this.textSize);
        }
        AppMethodBeat.o(175313);
    }

    private String uI(int i2) {
        AppMethodBeat.i(175314);
        if (this.jqj) {
            i2 = uJ(i2);
        }
        String uG = this.jKr.uG(i2);
        AppMethodBeat.o(175314);
        return uG;
    }

    private int uJ(int i2) {
        AppMethodBeat.i(175315);
        if (i2 < 0) {
            i2 = uJ(this.jKr.getItemsCount() + i2);
        } else if (i2 > this.jKr.getItemsCount() - 1) {
            i2 = uJ(i2 - this.jKr.getItemsCount());
        }
        AppMethodBeat.o(175315);
        return i2;
    }

    private static String cl(Object obj) {
        AppMethodBeat.i(175316);
        if (obj == null) {
            AppMethodBeat.o(175316);
            return "";
        }
        String obj2 = obj.toString();
        AppMethodBeat.o(175316);
        return obj2;
    }

    private void bkV() {
        AppMethodBeat.i(175317);
        this.cgU.getTextBounds(this.content, 0, this.content.length(), new Rect());
        this.cgU.getTextBounds(this.content, 0, 0, new Rect());
        int length = this.content.length();
        int i2 = 0;
        while (length - i2 > 1) {
            Rect rect2 = new Rect();
            int i3 = ((length - i2) >> 1) + i2;
            this.cgU.getTextBounds(this.content, 0, i3, rect2);
            if (rect2.width() >= bkW()) {
                length = i3 - 1;
            } else if (rect2.width() < bkW()) {
                i2 = i3 + 1;
            }
        }
        do {
            this.content = this.content.substring(0, i2);
            if (this.cgU.measureText(this.content + "...") <= ((float) bkW())) {
                break;
            }
            i2--;
        } while (i2 > 0);
        this.content += "...";
        AppMethodBeat.o(175317);
    }

    private int bkW() {
        AppMethodBeat.i(175318);
        int paddingLeft = (this.jKD - getPaddingLeft()) - getPaddingRight();
        AppMethodBeat.o(175318);
        return paddingLeft;
    }

    private void bkX() {
        AppMethodBeat.i(175319);
        int i2 = this.textSize;
        this.cgU.setTextSize((float) i2);
        while (i2 > this.jKs && !bkY()) {
            i2--;
            this.cgU.setTextSize((float) i2);
        }
        AppMethodBeat.o(175319);
    }

    private boolean bkY() {
        AppMethodBeat.i(175320);
        if (this.cgU.measureText(this.content) <= ((float) ((this.jKD - getPaddingLeft()) - getPaddingRight()))) {
            AppMethodBeat.o(175320);
            return true;
        }
        AppMethodBeat.o(175320);
        return false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(175321);
        this.jKF = i2;
        bkT();
        setMeasuredDimension(this.jKD, this.jKC);
        AppMethodBeat.o(175321);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int i2;
        AppMethodBeat.i(175322);
        GestureDetector gestureDetector = this.jKk;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/picker/base/view/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/picker/base/view/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        float f2 = ((float) (-this.jKy)) * this.jKt;
        float itemsCount = ((float) ((this.jKr.getItemsCount() - 1) - this.jKy)) * this.jKt;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                bkU();
                this.jKE = motionEvent.getRawY();
                z = false;
                break;
            case 1:
            default:
                if (!a2) {
                    if (System.currentTimeMillis() - this.startTime > 120) {
                        a(a.DAGGLE);
                        z = false;
                        break;
                    } else {
                        int y = (int) (motionEvent.getY() - (((float) this.jKC) / 2.0f));
                        if (y > 0) {
                            i2 = (int) (((float) y) + (this.jKt / 2.0f));
                        } else {
                            i2 = (int) (((float) y) - (this.jKt / 2.0f));
                        }
                        if (this.jKt != 0.0f) {
                            this.fs = (int) (((float) ((int) (((float) i2) / this.jKt))) * this.jKt);
                            a(a.CLICK);
                        }
                    }
                }
                z = false;
                break;
            case 2:
                float rawY = this.jKE - motionEvent.getRawY();
                this.jKE = motionEvent.getRawY();
                this.jKx += rawY;
                if (!this.jqj) {
                    if ((this.jKx - (this.jKt * 0.25f) < f2 && rawY < 0.0f) || (this.jKx + (this.jKt * 0.25f) > itemsCount && rawY > 0.0f)) {
                        this.jKx -= rawY;
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                }
                z = false;
                break;
        }
        if (!z && motionEvent.getAction() != 0) {
            invalidate();
        }
        AppMethodBeat.o(175322);
        return true;
    }

    public int getItemsCount() {
        AppMethodBeat.i(175323);
        if (this.jKr != null) {
            int itemsCount = this.jKr.getItemsCount();
            AppMethodBeat.o(175323);
            return itemsCount;
        }
        AppMethodBeat.o(175323);
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setGravity(int i2) {
        this.Ku = i2;
    }

    public void setIsOptions(boolean z) {
        this.jKm = z;
    }

    public void setDividerColor(int i2) {
        AppMethodBeat.i(175324);
        if (i2 != 0) {
            this.jKu = i2;
            this.jKq.setColor(this.jKu);
        }
        AppMethodBeat.o(175324);
    }

    public void setDividerHeight(float f2) {
        AppMethodBeat.i(175325);
        this.jKq.setStrokeWidth(f2);
        AppMethodBeat.o(175325);
    }

    public float getTotalScrollY() {
        return this.jKx;
    }

    public void setTotalScrollY(float f2) {
        this.jKx = f2;
    }

    public float getItemHeight() {
        return this.jKt;
    }

    public int getInitPosition() {
        return this.jKy;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public final WheelView uK(int i2) {
        AppMethodBeat.i(175326);
        this.jKh = i2;
        invalidate();
        AppMethodBeat.o(175326);
        return this;
    }

    public final WheelView uL(int i2) {
        AppMethodBeat.i(175327);
        this.textColor = i2;
        this.cgU.setColor(this.textColor);
        this.jKi = (int) ((((float) ((i2 >> 24) & 255)) / 255.0f) * 255.0f);
        AppMethodBeat.o(175327);
        return this;
    }
}
