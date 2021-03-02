package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class es extends IEvent {
    public a dIa;

    public static final class a {
        public Context context;
        public int op = 0;
        public String userName;
    }

    public es() {
        this((byte) 0);
    }

    private es(byte b2) {
        AppMethodBeat.i(116002);
        this.dIa = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116002);
    }
}
