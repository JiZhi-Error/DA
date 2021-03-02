package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kz extends IEvent {
    public a dQb;

    public static final class a {
        public Boolean dQc;
        public int dQd;
        public Boolean dQe;
        public String imagePath;
        public String toUser;
    }

    public kz() {
        this((byte) 0);
    }

    private kz(byte b2) {
        AppMethodBeat.i(140988);
        this.dQb = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(140988);
    }
}
