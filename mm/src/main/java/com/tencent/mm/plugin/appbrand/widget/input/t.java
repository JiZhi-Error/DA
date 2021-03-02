package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public final class t extends r {
    public t(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final View getInputPanel() {
        AppMethodBeat.i(136473);
        w dc = w.dc(this);
        AppMethodBeat.o(136473);
        return dc;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.y
    public final void setPasswordMode(boolean z) {
        int i2;
        AppMethodBeat.i(136474);
        cbU();
        int inputType = getInputType() | 1;
        if (z) {
            i2 = inputType | 128;
        } else {
            i2 = inputType & -129;
        }
        setInputType(i2);
        super.setPasswordMode(z);
        cbV();
        AppMethodBeat.o(136474);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.y
    public final void cbz() {
        AppMethodBeat.i(136475);
        try {
            aj.dg(this).restartInput(this);
            AppMethodBeat.o(136475);
        } catch (RuntimeException e2) {
            Log.e("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection restartInput re=%s", e2);
            try {
                aj.dg(this).showSoftInput(this, 0);
                AppMethodBeat.o(136475);
            } catch (RuntimeException e3) {
                Log.e("Luggage.Wxa.AppBrandInputWidgetSingleLineWithSoftKeyboard", "ensureInputConnection showSoftInput re=%s", e3);
                AppMethodBeat.o(136475);
            }
        }
    }
}
