package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wx extends IEvent {
    public a edn;

    public static final class a {
        public Context context;
        public String edo;
    }

    public wx() {
        this((byte) 0);
    }

    private wx(byte b2) {
        AppMethodBeat.i(19838);
        this.edn = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19838);
    }
}
