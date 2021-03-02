package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ef extends IEvent {
    public a dHy;
    public b dHz;

    public static final class a {
        public String dHp;
        public long msgId;
    }

    public static final class b {
        public boolean dGX;
    }

    public ef() {
        this((byte) 0);
    }

    private ef(byte b2) {
        AppMethodBeat.i(115989);
        this.dHy = new a();
        this.dHz = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115989);
    }
}
