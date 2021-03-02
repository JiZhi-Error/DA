package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class zz extends IEvent {
    public a egG;
    public b egH;

    public static final class a {
        public LinkedList<String> egI;
    }

    public static final class b {
    }

    public zz() {
        this((byte) 0);
    }

    private zz(byte b2) {
        AppMethodBeat.i(91226);
        this.egG = new a();
        this.egH = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91226);
    }
}
