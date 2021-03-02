package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uq extends IEvent {
    public a eaT;

    public static final class a {
        public String action;
        public Intent intent;
    }

    public uq() {
        this((byte) 0);
    }

    private uq(byte b2) {
        AppMethodBeat.i(223488);
        this.eaT = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(223488);
    }
}
