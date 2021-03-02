package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class le extends IEvent {
    public a dQr;

    public static final class a {
        public Intent dQs;
        public int requestCode;
        public int resultCode;
    }

    public le() {
        this((byte) 0);
    }

    private le(byte b2) {
        AppMethodBeat.i(91208);
        this.dQr = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91208);
    }
}
