package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class om extends IEvent {
    public a dUz;

    public static final class a {
        public String appId;
        public String dUA;
        public String dUB;
        public int scene;
        public int type;
        public String url;
        public int version;
    }

    public om() {
        this((byte) 0);
    }

    private om(byte b2) {
        AppMethodBeat.i(117613);
        this.dUz = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(117613);
    }
}
