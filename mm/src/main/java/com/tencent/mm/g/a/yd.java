package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yd extends IEvent {
    public a eey;

    public static final class a {
        public String ecu;
        public int eeA = 0;
        public String eeq;
        public byte[] ees;
        public String eez;
        public String id;
        public int ret;
        public String source;
        public int type;
    }

    public yd() {
        this((byte) 0);
    }

    private yd(byte b2) {
        AppMethodBeat.i(116055);
        this.eey = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116055);
    }
}
