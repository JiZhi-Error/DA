package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.lang.ref.WeakReference;

public final class tk extends IEvent {
    public a dZQ;
    public b dZR;

    public static final class a {
        public WeakReference aWF;
        public Runnable callback;
        public String dZS;
        public int scene;
        public int type;
    }

    public static final class b {
        public int actionType;
        public String dZT;
        public String errMsg;
    }

    public tk() {
        this((byte) 0);
    }

    private tk(byte b2) {
        AppMethodBeat.i(91219);
        this.dZQ = new a();
        this.dZR = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91219);
    }
}
