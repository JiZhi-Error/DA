package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vf extends IEvent {
    public a ebD;

    public static final class a {
        public int EX;
        public Intent dQs;
        public int requestCode;
        public int resultCode;
    }

    public vf() {
        this((byte) 0);
    }

    private vf(byte b2) {
        AppMethodBeat.i(201823);
        this.ebD = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(201823);
    }
}
