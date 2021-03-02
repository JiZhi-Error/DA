package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qz extends IEvent {
    public a dXz;

    public static final class a {
        public int dFL;
        public int dFM;
        public String dWl;
        public int dXA;
        public int dXB;
        public float dXC;
        public float dXD;
        public int dXx;
        public String filePath;
        public String result;
    }

    public qz() {
        this((byte) 0);
    }

    private qz(byte b2) {
        AppMethodBeat.i(116042);
        this.dXz = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116042);
    }
}
