package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yv extends IEvent {
    public a efb;
    public b efc;

    public static final class a {
        public Context context;
        public int type;
    }

    public static final class b {
        public boolean efd;
    }

    public yv() {
        this((byte) 0);
    }

    private yv(byte b2) {
        AppMethodBeat.i(116056);
        this.efb = new a();
        this.efc = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116056);
    }
}
