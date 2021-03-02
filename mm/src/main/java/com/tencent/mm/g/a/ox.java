package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ox extends IEvent {
    public a dUX;

    public static final class a {
        public Context context;
        public int dUY;
        public String extraInfo;
        public int jumpType;
    }

    public ox() {
        this((byte) 0);
    }

    private ox(byte b2) {
        AppMethodBeat.i(89648);
        this.dUX = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(89648);
    }
}
