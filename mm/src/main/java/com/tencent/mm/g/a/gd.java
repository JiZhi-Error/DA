package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bu;
import com.tencent.mm.sdk.event.IEvent;

public final class gd extends IEvent {
    public a dJK;

    public static final class a {
        public boolean dJL;
        public boolean dJM;
        public int dJN;
        public bu.a dJO;
        public int type;
        public String username;
    }

    public gd() {
        this((byte) 0);
    }

    private gd(byte b2) {
        AppMethodBeat.i(116022);
        this.dJK = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116022);
    }
}
