package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.HashMap;

public final class vz extends IEvent {
    public a ecd;

    public static final class a {
        public long ece;
        public int ecf;
        public HashMap ecg;
    }

    public vz() {
        this((byte) 0);
    }

    private vz(byte b2) {
        AppMethodBeat.i(94815);
        this.ecd = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(94815);
    }
}
