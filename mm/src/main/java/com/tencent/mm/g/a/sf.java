package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sf extends IEvent {
    public a dYO;
    public b dYP;

    public static final class a {
        public Context context;
        public int dYQ;
        public Bundle extras;
    }

    public static final class b {
        public boolean dYN;
        public Bundle extras;
    }

    public sf() {
        this((byte) 0);
    }

    private sf(byte b2) {
        AppMethodBeat.i(149884);
        this.dYO = new a();
        this.dYP = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149884);
    }
}
