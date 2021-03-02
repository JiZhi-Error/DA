package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qy extends IEvent {
    public a dXy;

    public static final class a {
        public String filePath;
        public String result;
    }

    public qy() {
        this((byte) 0);
    }

    private qy(byte b2) {
        AppMethodBeat.i(116041);
        this.dXy = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116041);
    }
}
