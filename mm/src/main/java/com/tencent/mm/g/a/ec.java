package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import org.json.JSONArray;

public final class ec extends IEvent {
    public a dHl;
    public b dHm;

    public static final class a {
        public String brandName;
        public Context context;
    }

    public static final class b {
        public boolean dGX;
        public JSONArray dHk;
    }

    public ec() {
        this((byte) 0);
    }

    private ec(byte b2) {
        AppMethodBeat.i(115986);
        this.dHl = new a();
        this.dHm = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(115986);
    }
}
