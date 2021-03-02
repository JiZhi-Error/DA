package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class k extends IEvent {
    public a dCc;
    public b dCd;

    public static final class a {
        public int actionCode;
        public Context context;
        public String dCe;
        public boolean dCf;
        public boolean dCg;
    }

    public static final class b {
        public Bundle dCh;
    }

    public k() {
        this((byte) 0);
    }

    private k(byte b2) {
        AppMethodBeat.i(149847);
        this.dCc = new a();
        this.dCd = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149847);
    }
}
