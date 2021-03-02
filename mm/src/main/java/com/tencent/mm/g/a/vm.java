package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vm extends IEvent {
    public a ebJ;

    public static final class a {
        public Context context;
        public String dJX;
        public int dKy;
    }

    public vm() {
        this((byte) 0);
    }

    private vm(byte b2) {
        AppMethodBeat.i(125636);
        this.ebJ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125636);
    }
}
