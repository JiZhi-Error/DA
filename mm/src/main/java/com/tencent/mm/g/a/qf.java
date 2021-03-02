package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qf extends IEvent {
    public a dWy;

    public static final class a {
        public String appId;
        public String appName;
        public String content;
        public int dDG = 0;
        public String dDJ;
        public boolean dWA;
        public boolean dWz;
        public String icon;
        public int iconHeight;
        public int iconWidth;
        public long msgId;
        public int msgType;
    }

    public qf() {
        this((byte) 0);
    }

    private qf(byte b2) {
        AppMethodBeat.i(89649);
        this.dWy = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(89649);
    }
}
