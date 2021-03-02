package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class is extends IEvent {
    public a dNr;

    public static final class a {
        public int actionCode;
        public String appId;
        public Context context;
        public String extMsg;
        public String messageAction;
        public String messageExt;
        public int scene;
    }

    public is() {
        this((byte) 0);
    }

    private is(byte b2) {
        AppMethodBeat.i(116030);
        this.dNr = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(116030);
    }
}
