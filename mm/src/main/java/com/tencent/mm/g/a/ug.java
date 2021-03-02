package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class ug extends IEvent {
    public a eaD;

    public static final class a {
        public String dNA;
        public long eaB;
        public List eaE;
        public Boolean eaF;
        public Boolean eaz;
        public int version;
    }

    public ug() {
        this((byte) 0);
    }

    private ug(byte b2) {
        AppMethodBeat.i(121036);
        this.eaD = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(121036);
    }
}
