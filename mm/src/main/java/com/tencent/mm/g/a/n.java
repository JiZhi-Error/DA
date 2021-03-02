package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import org.json.JSONObject;

public final class n extends IEvent {
    public a dCn;

    public static final class a {
        public String dCo;
        public String dCp;
        public JSONObject dCq;
    }

    public n() {
        this((byte) 0);
    }

    private n(byte b2) {
        AppMethodBeat.i(144177);
        this.dCn = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(144177);
    }
}
