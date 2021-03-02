package com.tencent.mm.chatroom.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;

public final class b extends y {
    private static b gsN;

    public b() {
        super(com.tencent.mm.chatroom.b.class);
    }

    public static synchronized b amg() {
        b bVar;
        synchronized (b.class) {
            AppMethodBeat.i(12505);
            if (gsN == null) {
                gsN = new b();
            }
            bVar = gsN;
            AppMethodBeat.o(12505);
        }
        return bVar;
    }
}
