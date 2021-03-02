package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import com.tencent.luggage.c.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;

public final class g implements a {
    @Override // com.tencent.luggage.c.a.a
    public final k aE(Context context) {
        AppMethodBeat.i(47484);
        d dVar = new d(context);
        dVar.setCancelable(false);
        AppMethodBeat.o(47484);
        return dVar;
    }

    @Override // com.tencent.luggage.c.a.a
    public final void a(k kVar) {
        AppMethodBeat.i(47485);
        if (kVar instanceof b) {
            ((b) kVar).dismiss();
        }
        AppMethodBeat.o(47485);
    }
}
