package com.tencent.luggage.game.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import java.util.HashMap;

public final class b extends s {
    static final int CTRL_INDEX = -2;
    static final String NAME = "onKeyboardConfirm";

    public final void a(String str, com.tencent.mm.plugin.appbrand.s sVar) {
        AppMethodBeat.i(130607);
        HashMap hashMap = new HashMap(2);
        hashMap.put("errMsg", "ok");
        hashMap.put("value", str);
        L(hashMap).g(sVar).bEo();
        AppMethodBeat.o(130607);
    }
}
