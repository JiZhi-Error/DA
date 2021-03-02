package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a {
    private List<Object> hlM = new ArrayList();

    public a() {
        AppMethodBeat.i(177080);
        AppMethodBeat.o(177080);
    }

    public final a bl(Object obj) {
        AppMethodBeat.i(177081);
        this.hlM.add(obj);
        AppMethodBeat.o(177081);
        return this;
    }

    public final Object[] axQ() {
        AppMethodBeat.i(177082);
        Collections.reverse(this.hlM);
        Object[] array = this.hlM.toArray();
        AppMethodBeat.o(177082);
        return array;
    }

    public final Object pG(int i2) {
        AppMethodBeat.i(177083);
        Object obj = this.hlM.get(i2);
        AppMethodBeat.o(177083);
        return obj;
    }
}
