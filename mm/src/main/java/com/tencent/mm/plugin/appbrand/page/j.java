package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.page.capsulebar.c;
import java.util.Objects;

public final class j extends ao {
    public j(ViewGroup viewGroup) {
        super(viewGroup);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ao
    public final boolean a(View view, int i2, int i3, float[] fArr, int i4, boolean z) {
        AppMethodBeat.i(219354);
        boolean a2 = super.a(view, i2, i3, fArr, i4, z);
        AppMethodBeat.o(219354);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ao
    public final boolean a(View view, int i2, int i3, float[] fArr, int i4, boolean z, boolean z2) {
        AppMethodBeat.i(219355);
        boolean a2 = super.a(view, i2, i3, fArr, i4, z, z2);
        AppMethodBeat.o(219355);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a, com.tencent.mm.plugin.appbrand.page.ao
    public final boolean a(View view, int i2, int i3, float[] fArr, int i4, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(219356);
        boolean a2 = super.a(view, i2, i3, fArr, i4, z, z2, z3);
        AppMethodBeat.o(219356);
        return a2;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(219357);
        ((ViewGroup) Objects.requireNonNull(b(0, false, false))).addView(cVar, -1, -2);
        d(new ao.b(cVar, 1, 0, 1000, true, false, false));
        AppMethodBeat.o(219357);
    }
}
