package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class c {
    Context owO;
    boolean oxd = false;
    b oxf;
    f oxg;
    int oxh;
    int oxi;

    public final a cco() {
        AppMethodBeat.i(49954);
        if (this.oxf == null) {
            this.oxf = new b();
            this.oxf.owO = this.owO;
            this.oxf.setPanelManager(this);
        }
        b bVar = this.oxf;
        AppMethodBeat.o(49954);
        return bVar;
    }

    public static int[] ccp() {
        AppMethodBeat.i(49955);
        Display defaultDisplay = ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
        int[] iArr = {defaultDisplay.getWidth(), defaultDisplay.getHeight()};
        AppMethodBeat.o(49955);
        return iArr;
    }

    /* access modifiers changed from: protected */
    public e cbY() {
        AppMethodBeat.i(49956);
        e gxR = e.gxR();
        AppMethodBeat.o(49956);
        return gxR;
    }
}
