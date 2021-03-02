package com.tencent.mm.g.a;

import android.telephony.PhoneStateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xt extends IEvent {
    public a eeb;

    public static final class a {
        public int action;
        public PhoneStateListener eec;
        public int eed;
    }

    public xt() {
        this((byte) 0);
    }

    private xt(byte b2) {
        AppMethodBeat.i(194255);
        this.eeb = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(194255);
    }
}
