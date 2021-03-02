package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fa extends IEvent {
    public a dIs;
    public b dIt;

    public static final class a {
        public boolean clear;
        public String dGL;
        public int direction;
    }

    public static final class b {
        public boolean dGX;
    }

    public fa() {
        this((byte) 0);
    }

    private fa(byte b2) {
        AppMethodBeat.i(116010);
        this.dIs = new a();
        this.dIt = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116010);
    }
}
