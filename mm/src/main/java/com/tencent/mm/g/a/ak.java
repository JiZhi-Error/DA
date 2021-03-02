package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ak extends IEvent {
    public a dDl;

    public static final class a {
        public Activity activity;
    }

    public ak() {
        this((byte) 0);
    }

    private ak(byte b2) {
        AppMethodBeat.i(149851);
        this.dDl = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149851);
    }
}
