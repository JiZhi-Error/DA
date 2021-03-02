package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class iv extends IEvent {
    public a dNx;

    public static final class a {
        public String appId;
        public String extInfo;
        public String md5;
        public int scene;
        public String url;
    }

    public iv() {
        this((byte) 0);
    }

    private iv(byte b2) {
        AppMethodBeat.i(89642);
        this.dNx = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(89642);
    }
}
