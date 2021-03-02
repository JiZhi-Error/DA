package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.jsapi.r.c;
import com.tencent.mm.ui.widget.picker.f;

public class AppBrandOptionsPicker extends NumberPicker implements c<String> {
    private int mMaxWidth;
    private int mMinWidth;
    private String[] ozA;
    private int ozB;

    @Keep
    public AppBrandOptionsPicker(Context context) {
        super(new ContextThemeWrapper(context, (int) R.style.a1j));
        AppMethodBeat.i(138018);
        f.a(this, getResources().getDrawable(R.drawable.ee));
        f.d(this);
        f.f(this);
        d.a(this);
        this.mMinWidth = a.fromDPToPix(context, 100);
        this.ozB = a.fromDPToPix(context, 20);
        AppMethodBeat.o(138018);
    }

    public void setOptionsArray(String[] strArr) {
        AppMethodBeat.i(138019);
        if (strArr == null) {
            AppMethodBeat.o(138019);
            return;
        }
        this.ozA = strArr;
        setDisplayedValues(null);
        setMinValue(0);
        setMaxValue(Math.max(strArr.length - 1, 0));
        if (strArr.length <= 0) {
            strArr = null;
        }
        super.setDisplayedValues(strArr);
        AppMethodBeat.o(138019);
    }

    public final void setExtraPadding(int i2) {
        AppMethodBeat.i(138020);
        this.ozB = Math.max(i2, 0);
        AppMethodBeat.o(138020);
    }

    public final void setMinWidth(int i2) {
        this.mMinWidth = i2;
    }

    public final void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    @Deprecated
    public void setDisplayedValues(String[] strArr) {
        AppMethodBeat.i(138021);
        super.setDisplayedValues(strArr);
        AppMethodBeat.o(138021);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(138022);
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE || View.MeasureSpec.getMode(i2) == 1073741824) {
            this.mMaxWidth = View.MeasureSpec.getSize(i2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), i3);
        if (getMeasuredWidth() > this.mMinWidth || (this.mMaxWidth > 0 && this.mMinWidth > this.mMaxWidth)) {
            int measuredWidth = getMeasuredWidth() + (this.ozB * 2);
            if (this.mMaxWidth > 0 && this.mMaxWidth <= measuredWidth) {
                measuredWidth = this.mMaxWidth;
            }
            setMeasuredDimension(measuredWidth, getMeasuredHeight());
            AppMethodBeat.o(138022);
            return;
        }
        setMeasuredDimension(this.mMinWidth, getMeasuredHeight());
        AppMethodBeat.o(138022);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(138023);
        super.onAttachedToWindow();
        f.e(this);
        AppMethodBeat.o(138023);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final String currentValue() {
        AppMethodBeat.i(138024);
        if (this.ozA == null || this.ozA.length <= 0) {
            AppMethodBeat.o(138024);
            return "";
        }
        String str = this.ozA[getValue()];
        AppMethodBeat.o(138024);
        return str;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public View getView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public void onShow(c cVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public void onHide(c cVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public void onAttach(c cVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public void onDetach(c cVar) {
    }
}
