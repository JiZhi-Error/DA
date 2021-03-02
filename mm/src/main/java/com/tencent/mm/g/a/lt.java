package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bp;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class lt extends IEvent {
    public a dRf;

    public static final class a {
        public ca dCM;
        public bp.b dRg;
    }

    public lt() {
        this((byte) 0);
    }

    private lt(byte b2) {
        AppMethodBeat.i(123464);
        this.dRf = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(123464);
    }
}
