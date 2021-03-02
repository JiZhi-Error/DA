package com.tencent.mm.plugin.expt.d.h.b.a;

import com.eclipsesource.v8.V8Array;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.apache.commons.b.g;

public final class a extends com.tencent.mm.plugin.expt.d.h.b.a {
    @Override // com.tencent.mm.plugin.expt.d.h.b.b
    public final Object b(V8Array v8Array) {
        AppMethodBeat.i(220363);
        if (v8Array == null || v8Array.length() <= 0) {
            AppMethodBeat.o(220363);
        } else {
            String string = v8Array.getString(0);
            if (g.eP(string)) {
                AppMethodBeat.o(220363);
            } else {
                Log.d("EdgeComputingJsApiBase", "[EdgeComputingJsApiDebugAlert] logic, msg : ".concat(String.valueOf(string)));
                AppMethodBeat.o(220363);
            }
        }
        return null;
    }

    @Override // com.tencent.mm.plugin.expt.d.h.b.b
    public final String cNb() {
        return "debug_alert";
    }

    @Override // com.tencent.mm.plugin.expt.d.h.b.b
    public final int getType() {
        return 1;
    }
}
