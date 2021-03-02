package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import org.json.JSONArray;

public final class eb extends IEvent {
    public a dHi;
    public b dHj;

    public static final class a {
        public String brandName;
        public Context context;
    }

    public static final class b {
        public boolean dGX;
        public JSONArray dHk;
    }

    public eb() {
        this((byte) 0);
    }

    private eb(byte b2) {
        AppMethodBeat.i(115985);
        this.dHi = new a();
        this.dHj = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115985);
    }
}
