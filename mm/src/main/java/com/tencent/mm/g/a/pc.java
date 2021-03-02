package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pc extends IEvent {
    public a dVf;

    public static final class a {
        public int action;
        public String appId;
        public boolean dVg;
        public int duration;
        public int errCode;
        public String errMsg;
        public String filePath;
        public int fileSize;
        public byte[] frameBuffer;
        public String state;
    }

    public pc() {
        this((byte) 0);
    }

    private pc(byte b2) {
        AppMethodBeat.i(146134);
        this.dVf = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(146134);
    }
}
