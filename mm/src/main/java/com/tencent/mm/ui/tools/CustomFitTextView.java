package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class CustomFitTextView extends TextView {
    private String Qqp;
    private Rect Qqq = new Rect();
    private LinkedList<String> Qqr = new LinkedList<>();
    public int Qqs;
    private Drawable Qqt;
    public boolean Qqu;
    private int Qqv = 0;
    private Paint cgU;
    private boolean kyn = true;
    public int maxLines;

    public CustomFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143056);
        AppMethodBeat.o(143056);
    }

    public CustomFitTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143057);
        AppMethodBeat.o(143057);
    }

    public final void a(String str, int i2, boolean z, int i3, int i4) {
        AppMethodBeat.i(143058);
        this.maxLines = i2;
        this.Qqp = str;
        if (this.Qqp == null) {
            Log.w("MicroMsg.CustomFitTextView", "ori text is null");
            this.Qqp = "";
        }
        if (this.maxLines <= 0) {
            Log.w("MicroMsg.CustomFitTextView", "maxLines is invalid");
            this.maxLines = 2;
        }
        this.Qqv = getResources().getDimensionPixelSize(R.dimen.f3062g);
        this.Qqu = z;
        this.Qqs = i3;
        if (this.Qqu) {
            this.Qqt = getResources().getDrawable(this.Qqs);
        }
        this.cgU = new Paint();
        this.cgU.set(getPaint());
        this.cgU.setAntiAlias(true);
        this.cgU.setColor(i4);
        hk(this.Qqp, getWidth());
        setHeight(Math.max(gXE(), a.fromDPToPix(getContext(), 32)));
        AppMethodBeat.o(143058);
    }

    private int gXE() {
        AppMethodBeat.i(143059);
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        int size = ((int) (((fontMetrics.leading + (fontMetrics.bottom - fontMetrics.top)) * ((float) this.Qqr.size())) + ((float) getPaddingTop()) + ((float) getPaddingBottom()))) + (Math.max(0, this.Qqr.size() - 1) * this.Qqv);
        AppMethodBeat.o(143059);
        return size;
    }

    private boolean hk(String str, int i2) {
        int i3;
        AppMethodBeat.i(143060);
        if (!this.kyn || i2 <= 0 || str == null || "".equals(str)) {
            AppMethodBeat.o(143060);
            return false;
        }
        this.Qqr.clear();
        int i4 = 0;
        int length = str.length();
        int paddingLeft = (i2 - getPaddingLeft()) - getPaddingRight();
        int intrinsicWidth = this.Qqu ? this.Qqt.getIntrinsicWidth() : 0;
        float measureText = ((float) intrinsicWidth) + getPaint().measureText(str, 0, length);
        int i5 = this.maxLines;
        if (Float.compare(measureText, (float) (this.maxLines * paddingLeft)) < 0) {
            i3 = (int) Math.ceil((double) (measureText / ((float) paddingLeft)));
        } else {
            i3 = i5;
        }
        int i6 = 0;
        while (true) {
            if (i6 >= i3) {
                break;
            }
            if (i6 == i3 - 1) {
                appendText(str.substring(i4, f(str, i4, length, intrinsicWidth, paddingLeft)).trim());
            } else {
                int f2 = f(str, i4, length, 0, paddingLeft);
                appendText(str.substring(i4, f2).trim());
                if (f2 >= length) {
                    Log.w("MicroMsg.CustomFitTextView", "not match last line, but match text length end");
                    break;
                }
                i4 = f2;
            }
            i6++;
        }
        AppMethodBeat.o(143060);
        return true;
    }

    private void appendText(String str) {
        AppMethodBeat.i(143061);
        if (this.Qqr != null) {
            if (str == null || "".equals(str)) {
                AppMethodBeat.o(143061);
                return;
            }
            this.Qqr.add(str);
        }
        AppMethodBeat.o(143061);
    }

    private int f(String str, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(143062);
        if (i3 <= i2) {
            int i6 = i2 + 1;
            AppMethodBeat.o(143062);
            return i6;
        } else if (getPaint().measureText(str, i2, i3) + ((float) i4) < ((float) i5)) {
            AppMethodBeat.o(143062);
            return i3;
        } else {
            int length = str.length();
            while (getPaint().measureText(str, i2, i3) + ((float) i4) > ((float) i5)) {
                i3 = (i3 + i2) >> 1;
            }
            while (i3 <= length && getPaint().measureText(str, i2, i3) + ((float) i4) < ((float) i5)) {
                i3++;
            }
            int min = Math.min(length, i3) - 1;
            int i7 = min;
            while (i7 >= 0 && Util.isAlpha(str.charAt(i7))) {
                i7--;
            }
            if (i7 < 0 || i7 == min) {
                int i8 = i3 - 1;
                AppMethodBeat.o(143062);
                return i8;
            }
            int i9 = i7 + 1;
            AppMethodBeat.o(143062);
            return i9;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(143063);
        if (!this.kyn) {
            AppMethodBeat.o(143063);
        } else if (this.Qqp == null || "".equals(this.Qqp) || this.Qqr.size() == 0) {
            AppMethodBeat.o(143063);
        } else {
            Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
            float f2 = fontMetrics.descent - fontMetrics.ascent;
            float paddingLeft = (float) getPaddingLeft();
            Iterator<String> it = this.Qqr.iterator();
            float paddingTop = (float) getPaddingTop();
            while (it.hasNext()) {
                float f3 = fontMetrics.leading + f2 + paddingTop;
                canvas.drawText(it.next(), paddingLeft, f3, this.cgU);
                paddingTop = f3;
            }
            if (this.Qqu) {
                getPaint().getTextBounds(this.Qqr.getLast(), 0, this.Qqr.getLast().length(), this.Qqq);
                int paddingLeft2 = getPaddingLeft() + this.Qqq.right;
                int i2 = (int) ((paddingTop - f2) - fontMetrics.leading);
                this.Qqt.setBounds(paddingLeft2, i2, this.Qqt.getIntrinsicWidth() + paddingLeft2, this.Qqt.getIntrinsicHeight() + i2);
                this.Qqt.draw(canvas);
            }
            AppMethodBeat.o(143063);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(143064);
        this.kyn = (i2 == i4 && i3 == i5) ? false : true;
        if (this.kyn) {
            hk(this.Qqp, i2);
        }
        AppMethodBeat.o(143064);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(143065);
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int fromDPToPix = a.fromDPToPix(getContext(), 32);
        if (hk(this.Qqp, size)) {
            fromDPToPix = Math.max(gXE(), fromDPToPix);
        }
        setMeasuredDimension(size, fromDPToPix);
        AppMethodBeat.o(143065);
    }
}
