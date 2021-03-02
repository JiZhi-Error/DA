package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;

public class MMAutoSizeTextView extends TextView {
    private float OPA;
    private float OPz;
    private float xZC;
    private Paint yt;

    public MMAutoSizeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(141850);
        init();
        AppMethodBeat.o(141850);
    }

    public MMAutoSizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141851);
        init();
        AppMethodBeat.o(141851);
    }

    private void init() {
        AppMethodBeat.i(141852);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
        this.OPz = (float) a.fromDPToPix(getContext(), 8);
        this.OPA = (float) a.fromDPToPix(getContext(), 22);
        this.yt = new Paint();
        this.yt.set(getPaint());
        gKD();
        AppMethodBeat.o(141852);
    }

    private void gW(String str, int i2) {
        AppMethodBeat.i(141853);
        Log.i("MicroMsg.MMAutoSizeTextView", "autoAdjustTextSize[text=%s, viewWidth=%d]", str, Integer.valueOf(i2));
        if (i2 <= 0) {
            AppMethodBeat.o(141853);
            return;
        }
        int paddingLeft = (i2 - getPaddingLeft()) - getPaddingRight();
        gKD();
        float f2 = this.xZC;
        this.yt.setTextSize(f2);
        while (true) {
            if (f2 <= this.OPz || this.yt.measureText(str) <= ((float) paddingLeft)) {
                break;
            }
            f2 -= 1.0f;
            if (f2 <= this.OPz) {
                f2 = this.OPz;
                break;
            }
            this.yt.setTextSize(f2);
        }
        Log.i("MicroMsg.MMAutoSizeTextView", "try size[%f], maxSize[%f], measureTextSize[%f], availableWidth[%d]", Float.valueOf(f2), Float.valueOf(this.xZC), Float.valueOf(this.yt.measureText(str)), Integer.valueOf(paddingLeft));
        setTextSize(0, f2);
        AppMethodBeat.o(141853);
    }

    private void gKD() {
        AppMethodBeat.i(141854);
        this.xZC = getTextSize();
        if (this.xZC <= this.OPz) {
            this.xZC = this.OPA;
        }
        AppMethodBeat.o(141854);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        AppMethodBeat.i(141855);
        Log.w("MicroMsg.MMAutoSizeTextView", "on text changed");
        super.onTextChanged(charSequence, i2, i3, i4);
        gW(charSequence.toString(), getWidth());
        AppMethodBeat.o(141855);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(141856);
        Log.w("MicroMsg.MMAutoSizeTextView", "on size changed");
        if (i2 != i4) {
            gW(getText().toString(), i2);
        }
        AppMethodBeat.o(141856);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(141857);
        try {
            super.onMeasure(i2, i3);
            AppMethodBeat.o(141857);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
            AppMethodBeat.o(141857);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(141858);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(141858);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
            AppMethodBeat.o(141858);
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(141859);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(141859);
            return baseline;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
            AppMethodBeat.o(141859);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(141860);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.o(141860);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.o(141860);
            return true;
        }
    }
}
