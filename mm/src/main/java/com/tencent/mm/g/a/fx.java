package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.event.IEvent;

public final class fx extends IEvent {
    public a dJu;
    public b dJv;

    public static final class a {
        public String content;
        public String dJw;
        public int flags;
        public int type;
    }

    public static final class b {
        public q dJx;
        public long msgId = 0;
    }

    public fx() {
        this((byte) 0);
    }

    private fx(byte b2) {
        AppMethodBeat.i(116018);
        this.dJu = new a();
        this.dJv = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116018);
    }
}
