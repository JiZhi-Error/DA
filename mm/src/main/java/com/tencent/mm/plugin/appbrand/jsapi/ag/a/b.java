package com.tencent.mm.plugin.appbrand.jsapi.ag.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.camera.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.ui.statusbar.d;

public final class b implements e {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.e
    public final int[] p(f fVar) {
        AppMethodBeat.i(215801);
        if (fVar == null) {
            int[] iArr = new int[2];
            AppMethodBeat.o(215801);
            return iArr;
        } else if (fVar instanceof k) {
            int[] f2 = ai.f((k) fVar);
            AppMethodBeat.o(215801);
            return f2;
        } else {
            Point az = d.az(fVar.getContext());
            int[] iArr2 = {az.x, az.y};
            AppMethodBeat.o(215801);
            return iArr2;
        }
    }
}
