package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ya extends IEvent {
    public a eep;

    public static final class a {
        public String eeq;
        public boolean eer;
        public byte[] ees;
        public String id;
        public String source;
        public int type;
    }

    public ya() {
        this((byte) 0);
    }

    private ya(byte b2) {
        AppMethodBeat.i(116052);
        this.eep = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116052);
    }
}
