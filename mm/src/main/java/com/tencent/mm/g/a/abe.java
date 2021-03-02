package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abe extends IEvent {
    public a eiw;

    public static final class a {
        public String appId;
        public int eix;
        public String filePath;
        public String md5;
        public int version;
    }

    public abe() {
        this((byte) 0);
    }

    private abe(byte b2) {
        AppMethodBeat.i(194334);
        this.eiw = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(194334);
    }
}
