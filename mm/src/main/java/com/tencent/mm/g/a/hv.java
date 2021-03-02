package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.sdk.event.IEvent;

public final class hv extends IEvent {
    public a dMr;

    public static final class a {
        public azt dMs;
        public int dMt = -1;
        public long dMu = 0;
        public long dMv = 0;
        public int dMw = -1;
        public long feedId;
        public int friendLikeCount = -1;
    }

    public hv() {
        this((byte) 0);
    }

    private hv(byte b2) {
        AppMethodBeat.i(168882);
        this.dMr = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(168882);
    }
}
