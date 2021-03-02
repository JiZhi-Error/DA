package com.tencent.mm.g.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sd extends IEvent {
    public a dYH;

    public static final class a {
        public Context context;
        public Intent intent;
    }

    public sd() {
        this((byte) 0);
    }

    private sd(byte b2) {
        AppMethodBeat.i(91217);
        this.dYH = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91217);
    }
}
