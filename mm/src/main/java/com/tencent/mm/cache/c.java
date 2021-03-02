package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import java.util.HashMap;
import java.util.Stack;

public final class c {
    private static c gpB = new c();
    private Stack<h> bNI = new Stack<>();
    HashMap<String, Stack<h>> map = new HashMap<>();

    private c() {
        AppMethodBeat.i(9207);
        AppMethodBeat.o(9207);
    }

    static {
        AppMethodBeat.i(9210);
        AppMethodBeat.o(9210);
    }

    public static c alF() {
        return gpB;
    }

    public final void Dp(String str) {
        AppMethodBeat.i(204749);
        if (this.map.containsKey(str)) {
            this.bNI = this.map.get(str);
            AppMethodBeat.o(204749);
            return;
        }
        this.map.put(str, new Stack<>());
        AppMethodBeat.o(204749);
    }

    public final void b(h hVar) {
        AppMethodBeat.i(9208);
        this.bNI.push(hVar);
        AppMethodBeat.o(9208);
    }

    public final h alG() {
        AppMethodBeat.i(9209);
        if (this.bNI.empty()) {
            h hVar = h.DEFAULT;
            AppMethodBeat.o(9209);
            return hVar;
        }
        h pop = this.bNI.pop();
        AppMethodBeat.o(9209);
        return pop;
    }
}
