package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class je extends IEvent {
    public a dNT;
    public b dNU;

    public static final class a {
        public int actionCode;
        public Context context;
        public Bundle dNV;
        public String result;
        public String username;
    }

    public static final class b {
        public int ret = 0;
    }

    public je() {
        this((byte) 0);
    }

    private je(byte b2) {
        AppMethodBeat.i(117546);
        this.dNT = new a();
        this.dNU = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(117546);
    }
}
