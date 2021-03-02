package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Keep;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.jsapi.r.c;
import com.tencent.smtt.sdk.WebView;

public class AppBrandOptionsPickerV2 extends YANumberPicker implements c<String> {
    private String[] ozA;
    private int ozC;

    @Keep
    public AppBrandOptionsPickerV2(Context context) {
        super(context);
        AppMethodBeat.i(138026);
        setDividerHeight(a.fromDPToPix(context, 2));
        setDividerColor(Color.parseColor("#1AAD19"));
        setItemPaddingVertical(a.fromDPToPix(context, 8));
        setNormalTextColor(Color.parseColor("#A5A5A5"));
        setSelectedTextColor(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.o(138026);
    }

    public final void setOptionsArray(String[] strArr) {
        AppMethodBeat.i(138027);
        if (strArr == null || strArr.length <= 0) {
            setEnabled(false);
            setVisibility(4);
            AppMethodBeat.o(138027);
            return;
        }
        setEnabled(true);
        setVisibility(0);
        this.ozA = strArr;
        int minValue = getMinValue();
        int maxValue = (getMaxValue() - minValue) + 1;
        int length = strArr.length - 1;
        if ((length - minValue) + 1 > maxValue) {
            setDisplayedValues(strArr);
            setMaxValue(length);
            AppMethodBeat.o(138027);
            return;
        }
        setMaxValue(length);
        setDisplayedValues(strArr);
        AppMethodBeat.o(138027);
    }

    public final void setForceWidth(int i2) {
        this.ozC = i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(138028);
        if (this.ozC > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.ozC, 1073741824);
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(138028);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final View getView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public void onShow(c cVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public void onHide(c cVar) {
        AppMethodBeat.i(138029);
        ccG();
        AppMethodBeat.o(138029);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public void onAttach(c cVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public void onDetach(c cVar) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public /* synthetic */ String currentValue() {
        AppMethodBeat.i(138030);
        if (this.ozA == null || this.ozA.length <= 0) {
            AppMethodBeat.o(138030);
            return "";
        }
        String str = this.ozA[getValue()];
        AppMethodBeat.o(138030);
        return str;
    }
}
