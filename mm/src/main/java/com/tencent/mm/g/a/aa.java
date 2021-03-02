package com.tencent.mm.g.a;

import android.support.v4.app.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aa extends IEvent {
    public a dCY;

    public static final class a {
        public s.e dCZ;
        public String title;
        public String username;
    }

    public aa() {
        this((byte) 0);
    }

    private aa(byte b2) {
        AppMethodBeat.i(19788);
        this.dCY = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19788);
    }
}
