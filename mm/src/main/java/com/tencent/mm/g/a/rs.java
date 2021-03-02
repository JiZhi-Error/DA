package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.event.IEvent;

public final class rs extends IEvent {
    public a dYm;

    public static final class a {
        public SnsAdClick dYl;
        public int dYn;
        public int errorCode;
        public long timestamp;
        public String url;
        public String uxInfo;
    }

    public rs() {
        this((byte) 0);
    }

    private rs(byte b2) {
        AppMethodBeat.i(125627);
        this.dYm = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125627);
    }
}
