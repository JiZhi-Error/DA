package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.support.annotation.Keep;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.r.c;

public class AppBrandEmptyPickerView extends View implements c<Object> {
    @Keep
    AppBrandEmptyPickerView(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.c
    public Object currentValue() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(137991);
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getResources().getDimensionPixelSize(R.dimen.aft), 1073741824));
        AppMethodBeat.o(137991);
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
