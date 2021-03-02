package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gl extends IEvent {
    public a dKn;

    public static final class a {
        public String dKo;
        public int dKp = 0;
        public Activity dKq;
        public int mRequestCode;
    }

    public gl() {
        this((byte) 0);
    }

    private gl(byte b2) {
        AppMethodBeat.i(63288);
        this.dKn = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(63288);
    }
}
