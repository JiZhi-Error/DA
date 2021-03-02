package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class io extends IEvent {
    public a dNh;
    public b dNi;

    public static final class a {
        public Intent intent;
    }

    public static final class b {
        public int dIZ = 0;
    }

    public io() {
        this((byte) 0);
    }

    private io(byte b2) {
        AppMethodBeat.i(19811);
        this.dNh = new a();
        this.dNi = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19811);
    }
}
