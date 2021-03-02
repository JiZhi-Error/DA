package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

/* renamed from: com.tencent.mm.g.a.do  reason: invalid class name */
public final class Cdo extends IEvent {
    public b dGA;
    public a dGz;

    /* renamed from: com.tencent.mm.g.a.do$a */
    public static final class a {
        public int type;
    }

    /* renamed from: com.tencent.mm.g.a.do$b */
    public static final class b {
        public boolean dGB;
    }

    public Cdo() {
        this((byte) 0);
    }

    private Cdo(byte b2) {
        AppMethodBeat.i(104415);
        this.dGz = new a();
        this.dGA = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(104415);
    }
}
