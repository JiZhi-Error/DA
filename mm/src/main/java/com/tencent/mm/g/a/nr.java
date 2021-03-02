package com.tencent.mm.g.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nr extends IEvent {
    public a dTO;

    public static final class a {
        public Context context;
        public String group;
        public Intent intent;
        public int type = 0;
    }

    public nr() {
        this((byte) 0);
    }

    private nr(byte b2) {
        AppMethodBeat.i(89647);
        this.dTO = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(89647);
    }
}
