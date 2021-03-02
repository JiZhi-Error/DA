package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;

public final class sm extends IEvent {
    public a dZa;

    public static final class a {
        public ArrayList dZb;
        public String dZc;
    }

    public sm() {
        this((byte) 0);
    }

    private sm(byte b2) {
        AppMethodBeat.i(125629);
        this.dZa = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125629);
    }
}
