package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ho extends IEvent {
    public a dMd;

    public static final class a {
        public String appId;
        public String appUserName;
        public String brandName;
        public int dMe;
        public String dMf;
    }

    public ho() {
        this((byte) 0);
    }

    private ho(byte b2) {
        AppMethodBeat.i(136974);
        this.dMd = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(136974);
    }
}
