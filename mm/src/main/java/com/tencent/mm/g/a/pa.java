package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pa extends IEvent {
    public a dVb;

    public static final class a {
        public Context context;
        public Bundle dUl;
        public boolean dUo = true;
        public String dVc;
        public long msgId = -1;
        public int scene;
    }

    public pa() {
        this((byte) 0);
    }

    private pa(byte b2) {
        AppMethodBeat.i(127409);
        this.dVb = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(127409);
    }
}
