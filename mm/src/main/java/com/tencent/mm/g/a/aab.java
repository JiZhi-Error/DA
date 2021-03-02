package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aab extends IEvent {
    public a egN;

    public static final class a {
        public String dDL;
        public int egM = 0;
        public Intent intent;
        public int requestCode = 0;
        public int result = 0;
    }

    public aab() {
        this((byte) 0);
    }

    private aab(byte b2) {
        AppMethodBeat.i(91228);
        this.egN = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91228);
    }
}
