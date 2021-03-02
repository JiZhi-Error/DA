package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.caa;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class nc extends IEvent {
    public a dSO;

    public static final class a {
        public LinkedList<caa> dSP;
        public boolean dSQ = false;
    }

    public nc() {
        this((byte) 0);
    }

    private nc(byte b2) {
        AppMethodBeat.i(101728);
        this.dSO = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(101728);
    }
}
