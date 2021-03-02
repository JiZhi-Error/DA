package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e {
    public void a(Bitmap bitmap, d dVar) {
        AppMethodBeat.i(135543);
        if (!(dVar == null || dVar.oFg == null)) {
            dVar.oFg.destroy(dVar.index);
        }
        AppMethodBeat.o(135543);
    }
}
