package com.tencent.mm.ui.l.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import java.util.HashMap;

public final class b extends s {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "UnityEvent";
    private final a QmB;

    public interface a {
        String gWV();
    }

    public b(a aVar) {
        this.QmB = aVar;
    }

    public final void L(f fVar) {
        AppMethodBeat.i(234452);
        HashMap hashMap = new HashMap(2);
        hashMap.put("event", this.QmB.gWV());
        hashMap.put("param", null);
        g(fVar).L(hashMap).bEo();
        AppMethodBeat.o(234452);
    }

    /* renamed from: com.tencent.mm.ui.l.a.b.a.a.b$b  reason: collision with other inner class name */
    public static class C2118b implements a {
        @Override // com.tencent.mm.ui.l.a.b.a.a.b.a
        public final String gWV() {
            return "clearAllVFX";
        }
    }
}
