package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.support.annotation.Keep;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.picker.b.a;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.r.c;
import java.util.Arrays;

public class AppBrandOptionsPickerV3 implements c<String> {
    private Context context;
    private String[] ozA;
    public b<String> ozD;
    private int ozE;
    public int ozF;

    @Keep
    public AppBrandOptionsPickerV3(Context context2) {
        AppMethodBeat.i(138032);
        this.context = context2;
        this.ozD = new b<>(context2);
        AppMethodBeat.o(138032);
    }

    public final void setOptionsArray(String[] strArr) {
        AppMethodBeat.i(138033);
        this.ozA = strArr;
        this.ozD.aO(Arrays.asList(strArr));
        AppMethodBeat.o(138033);
    }

    public final void init() {
        AppMethodBeat.i(138034);
        new a(this.context, new com.tencent.mm.picker.d.c() {
            /* class com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3.AnonymousClass1 */

            @Override // com.tencent.mm.picker.d.c
            public final void uP(int i2) {
                AppMethodBeat.i(138031);
                AppBrandOptionsPickerV3.this.ozE = i2;
                AppMethodBeat.o(138031);
            }
        }).uN(this.ozF).uM(android.support.v4.content.b.n(this.context, R.color.BW_0_Alpha_0_1)).a(this.ozD);
        setDividerHeight((float) this.context.getResources().getDimensionPixelSize(R.dimen.tv));
        this.context.getResources().getDimensionPixelSize(R.dimen.afs);
        setDividerColor(android.support.v4.content.b.n(this.context, R.color.BW_0_Alpha_0_1));
        this.ozD.jLI.dE(this.context.getResources().getDimensionPixelSize(R.dimen.cb), this.context.getResources().getDimensionPixelSize(R.dimen.cb));
        this.ozD.jLI.jLM.uL(android.support.v4.content.b.n(this.context, R.color.BW_0_Alpha_0_9)).uK(this.context.getResources().getDimensionPixelSize(R.dimen.cb)).setBackgroundColor(android.support.v4.content.b.n(this.context, R.color.f3048f));
        AppMethodBeat.o(138034);
    }

    private void setDividerColor(int i2) {
        AppMethodBeat.i(138035);
        this.ozD.jLI.setDividerColor(i2);
        AppMethodBeat.o(138035);
    }

    public final int getValue() {
        AppMethodBeat.i(138036);
        this.ozD.blg();
        int i2 = this.ozE;
        AppMethodBeat.o(138036);
        return i2;
    }

    public final void setDividerHeight(float f2) {
        AppMethodBeat.i(138037);
        this.ozD.setDividerHeight(f2);
        AppMethodBeat.o(138037);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public final String currentValue() {
        AppMethodBeat.i(138038);
        this.ozD.blg();
        String str = this.ozA[this.ozE];
        AppMethodBeat.o(138038);
        return str;
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

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public /* synthetic */ View getView() {
        AppMethodBeat.i(138039);
        WheelView blh = this.ozD.blh();
        AppMethodBeat.o(138039);
        return blh;
    }
}
