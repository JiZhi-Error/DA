package com.tencent.mm.plugin.mobile.verify;

import android.os.Bundle;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.mobile.verify.a.a;
import com.tencent.mm.plugin.mobile.verify.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PluginMobileVerify extends f implements a {
    private Map<String, a.AbstractC1483a> callbacks = new ConcurrentHashMap();

    public PluginMobileVerify() {
        AppMethodBeat.i(224125);
        AppMethodBeat.o(224125);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    public a.AbstractC1483a getCallback(String str) {
        AppMethodBeat.i(224126);
        a.AbstractC1483a aVar = this.callbacks.get(str);
        AppMethodBeat.o(224126);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.mobile.verify.a.a
    public void getMobileToken(String str, String str2, a.AbstractC1483a aVar) {
        AppMethodBeat.i(224127);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.PluginMobileVerify", "sessionId  is empty!");
            Bundle bundle = new Bundle();
            bundle.putString("session", str);
            aVar.F(bundle);
            AppMethodBeat.o(224127);
            return;
        }
        Log.i("MicroMsg.PluginMobileVerify", "getMobileNumber %s, callback %s", str, aVar);
        if (aVar != null) {
            this.callbacks.put(str, aVar);
        }
        h.RTc.aX(new b(str, str2));
        AppMethodBeat.o(224127);
    }

    @Override // com.tencent.mm.plugin.mobile.verify.a.a
    public void removeCallback(String str) {
        AppMethodBeat.i(224128);
        this.callbacks.remove(str);
        AppMethodBeat.o(224128);
    }
}
