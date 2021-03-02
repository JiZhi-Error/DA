package com.tencent.mm.plugin.setting.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.at;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontSelectorView extends View {
    private static SoftReference<Bitmap> DfP = null;
    private static int DfY = 8;
    private List<b> DfQ = new ArrayList(8);
    private int DfR = 0;
    private int DfS = 0;
    private int DfT = 0;
    private int DfU = 0;
    private int DfV = 0;
    private int DfW = 0;
    private a DfX = null;
    private boolean DfZ = false;
    private float aTD = 0.0f;
    private float aTE = 0.0f;
    private int gTn = 0;
    private boolean sYU = false;
    private int topOffset = 0;
    private int ygL = 0;

    public interface a {
        void ig(int i2);
    }

    public FontSelectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(74626);
        AppMethodBeat.o(74626);
    }

    public FontSelectorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(74627);
        AppMethodBeat.o(74627);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(74628);
        super.onLayout(z, i2, i3, i4, i5);
        eTM();
        this.DfQ.clear();
        setClickable(true);
        this.DfR = com.tencent.mm.cb.a.fromDPToPix(getContext(), 30);
        this.topOffset = com.tencent.mm.cb.a.fromDPToPix(getContext(), 10);
        int width = getWidth();
        this.ygL = (getHeight() / 2) + this.topOffset;
        DfY = 8;
        this.gTn = (width - (this.DfR * 2)) / (DfY - 1);
        Bitmap bitmap = DfP.get();
        if (bitmap == null) {
            eTM();
            bitmap = DfP.get();
        }
        for (int i6 = 0; i6 < DfY; i6++) {
            b bVar = new b((byte) 0);
            bVar.left = (this.DfR + (this.gTn * i6)) - (bitmap.getWidth() / 2);
            bVar.top = this.ygL - (bitmap.getHeight() / 2);
            bVar.right = this.DfR + (this.gTn * i6) + (bitmap.getWidth() / 2);
            bVar.bottom = this.ygL + (bitmap.getHeight() / 2);
            this.DfQ.add(bVar);
        }
        this.DfS = this.DfW;
        if (this.DfV >= 0) {
            this.DfT = this.DfQ.get(this.DfS).left;
        } else if (this.DfT <= this.DfQ.get(this.DfS).right - (this.gTn / 2)) {
            this.DfT = this.DfQ.get(this.DfS).left;
        } else {
            this.DfT = this.DfQ.get(this.DfS).right;
        }
        this.DfU = this.DfQ.get(this.DfS).top;
        invalidate();
        AppMethodBeat.o(74628);
    }

    public static void eTL() {
        DfY = 8;
    }

    private void eTM() {
        AppMethodBeat.i(74629);
        if (DfP == null || DfP.get() == null) {
            DfP = new SoftReference<>(BitmapFactory.decodeResource(getResources(), R.drawable.c9u));
        }
        AppMethodBeat.o(74629);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(74630);
        super.onDraw(canvas);
        if (canvas == null) {
            AppMethodBeat.o(74630);
            return;
        }
        eTM();
        Paint paint = new Paint();
        paint.setARGB(255, 152, 152, 152);
        paint.setStrokeWidth(2.0f);
        int width = getWidth();
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), 5);
        canvas.drawLine((float) this.DfR, (float) this.ygL, (float) (width - this.DfR), (float) this.ygL, paint);
        for (int i2 = 0; i2 < DfY; i2++) {
            canvas.drawLine((float) (this.DfR + (this.gTn * i2)), (float) (this.ygL - fromDPToPix), (float) (this.DfR + (this.gTn * i2)), (float) (this.ygL + fromDPToPix), paint);
        }
        Bitmap bitmap = DfP.get();
        if (bitmap == null) {
            eTM();
        }
        canvas.drawBitmap(bitmap, (float) this.DfT, (float) this.DfU, (Paint) null);
        String string = getResources().getString(R.string.gm1);
        getResources().getString(R.string.gm0);
        getResources().getString(R.string.gm3);
        float aH = ((float) at.aH(getContext(), R.dimen.is)) * com.tencent.mm.cb.a.iW(getContext());
        Paint paint2 = new Paint();
        paint2.setTextSize(aH);
        int bR = bR(aH);
        paint2.setColor(getResources().getColor(R.color.a2x));
        paint2.setAntiAlias(true);
        canvas.drawText("A", (float) (this.DfR - (((int) paint2.measureText("A")) / 2)), (float) ((this.ygL - bR) - (bitmap.getHeight() / 3)), paint2);
        float aH2 = ((float) at.aH(getContext(), R.dimen.is)) * com.tencent.mm.cb.a.iX(getContext());
        paint2.setTextSize(aH2);
        canvas.drawText(string, (float) ((this.DfR + (this.gTn * 1)) - (((int) paint2.measureText(string)) / 2)), (float) ((this.ygL - bR(aH2)) - (bitmap.getHeight() / 3)), paint2);
        float aH3 = ((float) at.aH(getContext(), R.dimen.is)) * com.tencent.mm.cb.a.jd(getContext());
        paint2.setTextSize(aH3);
        canvas.drawText("A", (float) ((this.DfR + (this.gTn * (DfY - 1))) - (((int) paint2.measureText("A")) / 2)), (float) ((this.ygL - bR(aH3)) - (bitmap.getHeight() / 3)), paint2);
        AppMethodBeat.o(74630);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(74631);
        switch (motionEvent.getAction()) {
            case 0:
                this.aTD = motionEvent.getX();
                this.aTE = motionEvent.getY();
                b bVar = this.DfQ.get(this.DfS);
                if (this.aTD >= ((float) bVar.left) && this.aTD <= ((float) bVar.right) && this.aTE >= ((float) bVar.top) && this.aTE <= ((float) bVar.bottom)) {
                    z2 = true;
                }
                if (!z2) {
                    this.sYU = true;
                    z = super.onTouchEvent(motionEvent);
                    break;
                } else {
                    this.DfZ = true;
                    z = true;
                    break;
                }
            case 1:
                if (!this.DfZ) {
                    if (this.sYU) {
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        if (Math.abs(x - this.aTD) <= 10.0f && Math.abs(y - this.aTE) <= 10.0f) {
                            int i2 = 0;
                            while (true) {
                                if (i2 < DfY) {
                                    b bVar2 = this.DfQ.get(i2);
                                    if (x < ((float) (bVar2.left - 5)) || x > ((float) (bVar2.right + 5))) {
                                        i2++;
                                    } else {
                                        this.DfS = i2;
                                        this.DfW = this.DfS;
                                        this.DfT = bVar2.left;
                                        if (this.DfX != null) {
                                            this.DfX.ig(this.DfS);
                                        }
                                    }
                                }
                            }
                        }
                        this.sYU = false;
                        invalidate();
                        z = true;
                        break;
                    }
                    z = super.onTouchEvent(motionEvent);
                    break;
                } else {
                    int i3 = 0;
                    while (true) {
                        if (i3 < DfY - 1) {
                            b bVar3 = this.DfQ.get(i3);
                            b bVar4 = this.DfQ.get(i3 + 1);
                            if (this.DfT <= bVar3.left + (this.gTn / 2) && this.DfT >= bVar3.left) {
                                this.DfS = i3;
                                this.DfT = bVar3.left;
                            } else if (this.DfT < bVar4.left - (this.gTn / 2) || this.DfT > bVar4.left) {
                                i3++;
                            } else {
                                this.DfS = i3 + 1;
                                this.DfT = bVar4.left;
                            }
                        }
                    }
                    this.DfW = this.DfS;
                    if (this.DfX != null) {
                        this.DfX.ig(this.DfS);
                    }
                    invalidate();
                    this.DfZ = false;
                    z = true;
                    break;
                }
                break;
            case 2:
                if (!this.DfZ) {
                    z = super.onTouchEvent(motionEvent);
                    break;
                } else {
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    this.DfV = (int) (x2 - this.aTD);
                    this.DfT = (int) (x2 - ((float) this.DfR));
                    this.aTD = x2;
                    this.aTE = y2;
                    b bVar5 = this.DfQ.get(0);
                    b bVar6 = this.DfQ.get(DfY - 1);
                    if (this.DfT <= bVar5.left) {
                        this.DfT = bVar5.left;
                    } else if (this.DfT >= bVar6.left) {
                        this.DfT = bVar6.left;
                    } else {
                        int i4 = 0;
                        while (true) {
                            if (i4 < DfY) {
                                b bVar7 = this.DfQ.get(i4);
                                if (this.DfT < bVar7.left - 5 || this.DfT > bVar7.right + 5) {
                                    i4++;
                                } else {
                                    this.DfS = i4;
                                    this.DfW = this.DfS;
                                    if (this.DfX != null) {
                                        this.DfX.ig(this.DfS);
                                    }
                                }
                            }
                        }
                    }
                    invalidate();
                    z = true;
                    break;
                }
                break;
            default:
                z = true;
                break;
        }
        AppMethodBeat.o(74631);
        return z;
    }

    private static int bR(float f2) {
        AppMethodBeat.i(74632);
        Paint paint = new Paint();
        paint.setTextSize(f2);
        paint.setAntiAlias(true);
        int ceil = (int) Math.ceil((double) paint.getFontMetrics().bottom);
        AppMethodBeat.o(74632);
        return ceil;
    }

    static class b {
        public int bottom;
        public int left;
        public int right;
        public int top;

        private b() {
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public void setOnChangeListener(a aVar) {
        this.DfX = aVar;
    }

    public void setSliderIndex(int i2) {
        this.DfW = i2;
    }
}
