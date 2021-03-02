package com.tencent.magicbrush.handler.glfont;

import com.tencent.magicbrush.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static d.a cMS = new d.a() {
        /* class com.tencent.magicbrush.handler.glfont.a.AnonymousClass1 */

        @Override // com.tencent.magicbrush.a.d.a
        public final void ik(int i2) {
        }
    };

    static {
        AppMethodBeat.i(140005);
        AppMethodBeat.o(140005);
    }

    public static void a(d.a aVar) {
        cMS = aVar;
    }

    public static d.a Rx() {
        return cMS;
    }
}
