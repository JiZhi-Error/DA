package com.tencent.mm.plugin.appbrand.widget.tabbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class c {
    public void a(String str, d dVar) {
        AppMethodBeat.i(135542);
        Log.d("IconLoadErrorHandler ", "setTabBarFail: ".concat(String.valueOf(str)));
        if (dVar.oFg != null) {
            dVar.oFg.destroy(dVar.index);
        }
        AppMethodBeat.o(135542);
    }
}
