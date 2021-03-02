package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ek extends IEvent {
    public a dHP;

    public static final class a {
        public String brandName;
        public String dGL;
        public byte[] data;
    }

    public ek() {
        this((byte) 0);
    }

    private ek(byte b2) {
        AppMethodBeat.i(115994);
        this.dHP = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115994);
    }
}
