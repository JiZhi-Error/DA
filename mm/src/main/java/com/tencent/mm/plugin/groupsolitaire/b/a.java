package com.tencent.mm.plugin.groupsolitaire.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;

public final class a {
    public long lastUpdateTime = 0;
    public boolean yeZ = false;
    public long yfa = 0;
    public boolean yfb = false;
    public long yfc = 0;

    public final void dXB() {
        AppMethodBeat.i(110316);
        this.lastUpdateTime = (long) cl.aWB();
        AppMethodBeat.o(110316);
    }
}
