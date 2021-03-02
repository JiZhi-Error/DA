package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.event.IEvent;

public final class ia extends IEvent {
    public a dMC;

    public static final class a {
        public boolean dMD;
        public bcj dME;
        public long localId;
    }

    public ia() {
        this((byte) 0);
    }

    private ia(byte b2) {
        AppMethodBeat.i(208806);
        this.dMC = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(208806);
    }
}
