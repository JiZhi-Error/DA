package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aw extends IEvent {
    public a dDW;

    public static final class a {
        public Activity activity;
        public String dDX;
    }

    public aw() {
        this((byte) 0);
    }

    private aw(byte b2) {
        AppMethodBeat.i(115969);
        this.dDW = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115969);
    }
}
