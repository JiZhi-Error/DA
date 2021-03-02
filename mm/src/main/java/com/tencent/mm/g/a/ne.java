package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class ne extends IEvent {
    public a dTc;
    public b dTd;

    public static final class a {
        public String chatroomName;
        public boolean dSQ = false;
        public LinkedList<String> dTe;
        public int scene = 0;
    }

    public static final class b {
        public int errCode;
    }

    public ne() {
        this((byte) 0);
    }

    private ne(byte b2) {
        AppMethodBeat.i(116460);
        this.dTc = new a();
        this.dTd = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116460);
    }
}
