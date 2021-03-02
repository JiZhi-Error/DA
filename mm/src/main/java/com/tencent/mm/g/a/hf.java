package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.sdk.event.IEvent;

public final class hf extends IEvent {
    public a dLI;

    public static final class a {
        public g contact;
        public String username;
    }

    public hf() {
        this((byte) 0);
    }

    private hf(byte b2) {
        AppMethodBeat.i(168628);
        this.dLI = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(168628);
    }
}
