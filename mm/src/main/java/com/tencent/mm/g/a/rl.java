package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rl extends IEvent {
    public a dYc;

    public static final class a {
        public Activity activity;
    }

    public rl() {
        this((byte) 0);
    }

    private rl(byte b2) {
        AppMethodBeat.i(177635);
        this.dYc = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(177635);
    }
}
