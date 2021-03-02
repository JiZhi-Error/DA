package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uj extends IEvent {
    public a eaI;
    public b eaJ;

    public static final class a {
        public Intent intent;
        public String username;
    }

    public static final class b {
    }

    public uj() {
        this((byte) 0);
    }

    private uj(byte b2) {
        AppMethodBeat.i(155375);
        this.eaI = new a();
        this.eaJ = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(155375);
    }
}
