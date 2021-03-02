package com.tencent.mm.ui.widget.picker;

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
import com.tencent.mm.ck.a;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.widget.picker.a.e;
import com.tencent.mm.ui.widget.picker.d.c;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class WheelView extends View {
    private int Ku;
    private boolean QTL;
    public c QTP;
    public ScheduledFuture<?> QTQ;
    private e<?> QTR;
    private boolean QTS;
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
    public ScheduledExecutorService jKb;
    private int jKh;
    private int jKi;
    private final int jKj;
    private GestureDetector jKk;
    private boolean jKm;
    public boolean jKn;
    private Paint jKq;
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
    private Context mContext;
    private Rect rect;
    private long startTime;
    private int textColor;
    private int textSize;

    public enum a {
        CLICK,
        FLING,
        DAGGLE;

        public static a valueOf(String str) {
            AppMethodBeat.i(198469);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(198469);
            return aVar;
        }

        static {
            AppMethodBeat.i(198470);
            AppMethodBeat.o(198470);
        }
    }

    public enum b {
        FILL,
        WRAP;

        public static b valueOf(String str) {
            AppMethodBeat.i(198472);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(198472);
            return bVar;
        }

        static {
            AppMethodBeat.i(198473);
            AppMethodBeat.o(198473);
        }
    }

    public WheelView(Context context) {
        this(context, null);
        this.mContext = context;
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(198474);
        this.jKh = 0;
        this.textColor = Color.rgb(255, 255, 255);
        this.jKj = 2;
        this.content = "";
        this.jKm = false;
        this.jKn = true;
        this.jKb = Executors.newSingleThreadScheduledExecutor();
        this.jKB = 5;
        this.fs = 0;
        this.jKE = 0.0f;
        this.startTime = 0;
        this.Ku = 17;
        this.jKG = 0;
        this.rect = new Rect();
        this.mContext = context;
        this.textSize = getResources().getDimensionPixelSize(R.dimen.afx);
        this.jKs = getResources().getDimensionPixelSize(R.dimen.afw);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0296a.WheelView, 0, 0);
            this.Ku = obtainStyledAttributes.getInt(1, 17);
            this.jKu = obtainStyledAttributes.getColor(0, -2763307);
            obtainStyledAttributes.recycle();
        }
        this.handler = new com.tencent.mm.ui.widget.picker.e.b(this);
        this.jKk = new GestureDetector(context, new com.tencent.mm.ui.widget.picker.d.b(this));
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
        AppMethodBeat.o(198474);
    }

    private void bkT() {
        AppMethodBeat.i(198475);
        if (this.QTR == null) {
            AppMethodBeat.o(198475);
            return;
        }
        this.jKt = (float) (this.jKh + getPaddingBottom() + getPaddingTop());
        this.jKC = (int) (this.jKt * ((float) this.jKB));
        this.jKD = View.MeasureSpec.getSize(this.jKF);
        this.jKv = (((float) this.jKC) - this.jKt) / 2.0f;
        this.jKw = (((float) this.jKC) + this.jKt) / 2.0f;
        if (this.jKy == -1) {
            if (this.jqj) {
                this.jKy = (this.QTR.getItemsCount() + 1) / 2;
            } else {
                this.jKy = 0;
            }
        }
        this.jKA = this.jKy;
        AppMethodBeat.o(198475);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(198476);
        bkU();
        if (aVar == a.FLING || aVar == a.DAGGLE) {
            this.fs = (int) (((this.jKx % this.jKt) + this.jKt) % this.jKt);
            if (((float) this.fs) > this.jKt / 2.0f) {
                this.fs = (int) (this.jKt - ((float) this.fs));
            } else {
                this.fs = -this.fs;
            }
        }
        this.QTQ = this.jKb.scheduleWithFixedDelay(new com.tencent.mm.ui.widget.picker.e.c(this, this.fs), 0, 10, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(198476);
    }

    public final void bkU() {
        AppMethodBeat.i(198477);
        if (this.QTQ != null && !this.QTQ.isCancelled()) {
            this.QTQ.cancel(true);
            this.QTQ = null;
        }
        AppMethodBeat.o(198477);
    }

    public final void setCyclic(boolean z) {
        this.jqj = z;
    }

    public final void setCurrentItem(int i2) {
        AppMethodBeat.i(198478);
        this.jKz = i2;
        this.jKy = i2;
        this.jKx = 0.0f;
        hcn();
        invalidate();
        AppMethodBeat.o(198478);
    }

    public final void setOnItemSelectedListener(c cVar) {
        this.QTP = cVar;
    }

    public final void setAdapter(e<?> eVar) {
        AppMethodBeat.i(198479);
        this.QTR = eVar;
        bkT();
        invalidate();
        AppMethodBeat.o(198479);
    }

    public final e getAdapter() {
        return this.QTR;
    }

    public final int getCurrentItem() {
        AppMethodBeat.i(198480);
        if (this.QTR == null) {
            AppMethodBeat.o(198480);
            return 0;
        } else if (this.QTL && this.jKz == 0) {
            AppMethodBeat.o(198480);
            return -1;
        } else if (!this.jqj || (this.jKz >= 0 && this.jKz < this.QTR.getItemsCount())) {
            int max = Math.max(0, Math.min(this.jKz, this.QTR.getItemsCount() - 1));
            AppMethodBeat.o(198480);
            return max;
        } else {
            int max2 = Math.max(0, Math.min(Math.abs(Math.abs(this.jKz) - this.QTR.getItemsCount()), this.QTR.getItemsCount() - 1));
            AppMethodBeat.o(198480);
            return max2;
        }
    }

    public final void hcn() {
        AppMethodBeat.i(198481);
        String cl = cl(uI(getCurrentItem()));
        if (!TextUtils.isEmpty(cl)) {
            setContentDescription(cl);
        }
        AppMethodBeat.o(198481);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Object obj;
        AppMethodBeat.i(198482);
        super.onDraw(canvas);
        if (this.QTR == null) {
            AppMethodBeat.o(198482);
            return;
        }
        this.jKy = Math.min(Math.max(0, this.jKy), this.QTR.getItemsCount() - 1);
        Object[] objArr = new Object[this.jKB];
        Object obj2 = new Object();
        Object obj3 = new Object();
        try {
            this.jKA = (((int) (this.jKx / this.jKt)) % this.QTR.getItemsCount()) + this.jKy;
        } catch (ArithmeticException e2) {
            as.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配", new Object[0]);
        }
        if (!this.jqj) {
            if (this.jKA < 0) {
                this.jKA = 0;
            }
            if (this.jKA > this.QTR.getItemsCount() - 1) {
                this.jKA = this.QTR.getItemsCount() - 1;
            }
        } else {
            if (this.jKA < 0) {
                this.jKA = this.QTR.getItemsCount() + this.jKA;
            }
            if (this.jKA > this.QTR.getItemsCount() - 1) {
                this.jKA -= this.QTR.getItemsCount();
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
            if (this.jKn || TextUtils.isEmpty(this.label) || TextUtils.isEmpty(cl(obj)) || (this.QTL && obj.equals(this.mContext.getString(R.string.fmf)))) {
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
        AppMethodBeat.o(198482);
    }

    private String uI(int i2) {
        AppMethodBeat.i(198483);
        if (this.jqj) {
            i2 = uJ(i2);
        }
        String uG = this.QTR.uG(i2);
        AppMethodBeat.o(198483);
        return uG;
    }

    private int uJ(int i2) {
        AppMethodBeat.i(198484);
        if (i2 < 0) {
            i2 = uJ(this.QTR.getItemsCount() + i2);
        } else if (i2 > this.QTR.getItemsCount() - 1) {
            i2 = uJ(i2 - this.QTR.getItemsCount());
        }
        AppMethodBeat.o(198484);
        return i2;
    }

    private static String cl(Object obj) {
        AppMethodBeat.i(198485);
        if (obj == null) {
            AppMethodBeat.o(198485);
            return "";
        }
        String obj2 = obj.toString();
        AppMethodBeat.o(198485);
        return obj2;
    }

    private void bkV() {
        AppMethodBeat.i(198486);
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
        AppMethodBeat.o(198486);
    }

    private int bkW() {
        AppMethodBeat.i(198487);
        int paddingLeft = (this.jKD - getPaddingLeft()) - getPaddingRight();
        AppMethodBeat.o(198487);
        return paddingLeft;
    }

    private void bkX() {
        AppMethodBeat.i(198488);
        int i2 = this.textSize;
        this.cgU.setTextSize((float) i2);
        while (i2 > this.jKs && !bkY()) {
            i2--;
            this.cgU.setTextSize((float) i2);
        }
        AppMethodBeat.o(198488);
    }

    private boolean bkY() {
        AppMethodBeat.i(198489);
        if (this.cgU.measureText(this.content) <= ((float) ((this.jKD - getPaddingLeft()) - getPaddingRight()))) {
            AppMethodBeat.o(198489);
            return true;
        }
        AppMethodBeat.o(198489);
        return false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(198490);
        this.jKF = i2;
        bkT();
        setMeasuredDimension(this.jKD, this.jKC);
        AppMethodBeat.o(198490);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int i2;
        AppMethodBeat.i(198491);
        GestureDetector gestureDetector = this.jKk;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/ui/widget/picker/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/widget/picker/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        float f2 = ((float) (-this.jKy)) * this.jKt;
        float itemsCount = ((float) ((this.QTR.getItemsCount() - 1) - this.jKy)) * this.jKt;
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
        AppMethodBeat.o(198491);
        return true;
    }

    public int getItemsCount() {
        AppMethodBeat.i(198492);
        if (this.QTR != null) {
            int itemsCount = this.QTR.getItemsCount();
            AppMethodBeat.o(198492);
            return itemsCount;
        }
        AppMethodBeat.o(198492);
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
        AppMethodBeat.i(198493);
        if (i2 != 0) {
            this.jKu = i2;
            this.jKq.setColor(this.jKu);
        }
        AppMethodBeat.o(198493);
    }

    public void setLongTermYear(boolean z) {
        this.QTL = z;
    }

    public void setLongTermMonthDay(boolean z) {
        this.QTS = z;
    }

    public void setDividerHeight(float f2) {
        AppMethodBeat.i(198494);
        this.jKq.setStrokeWidth(f2);
        AppMethodBeat.o(198494);
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

    public final WheelView apr(int i2) {
        AppMethodBeat.i(198495);
        this.jKh = i2;
        invalidate();
        AppMethodBeat.o(198495);
        return this;
    }

    public final WheelView aps(int i2) {
        AppMethodBeat.i(198496);
        this.textColor = i2;
        this.cgU.setColor(this.textColor);
        this.jKi = (int) ((((float) ((i2 >> 24) & 255)) / 255.0f) * 255.0f);
        AppMethodBeat.o(198496);
        return this;
    }
}
