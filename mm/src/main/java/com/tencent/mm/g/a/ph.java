package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ph extends IEvent {
    public a dVp;
    public b dVq;

    public static final class a {
        public int channel;
        public Context context;
        public int scene;
        public String source;
        public int sourceType = 0;
        public String url;
    }

    public static final class b {
        public int ret = 0;
    }

    public ph() {
        this((byte) 0);
    }

    private ph(byte b2) {
        AppMethodBeat.i(91210);
        this.dVp = new a();
        this.dVq = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91210);
    }
}
