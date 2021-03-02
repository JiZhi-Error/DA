package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sh extends IEvent {
    public a dYV;
    public b dYW;

    public static final class a {
        public Context context;
        public int dYQ;
        public Bundle extras;
    }

    public static final class b {
        public boolean dYN;
        public Bundle extras;
    }

    public sh() {
        this((byte) 0);
    }

    private sh(byte b2) {
        AppMethodBeat.i(149885);
        this.dYV = new a();
        this.dYW = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149885);
    }
}
