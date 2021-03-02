package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cla;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class uk extends IEvent {
    public a eaK;

    public static final class a {
        public String dYs;
        public LinkedList<cla> eaL;
    }

    public uk() {
        this((byte) 0);
    }

    private uk(byte b2) {
        AppMethodBeat.i(5532);
        this.eaK = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(5532);
    }
}
