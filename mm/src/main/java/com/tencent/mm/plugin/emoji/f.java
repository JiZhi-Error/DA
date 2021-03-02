package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.a;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.model.y;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class f extends y implements b {
    private static f qWz;

    private f() {
        super(a.class);
    }

    public static synchronized f cER() {
        f fVar;
        synchronized (f.class) {
            AppMethodBeat.i(104543);
            if (qWz == null) {
                qWz = new f();
            }
            fVar = qWz;
            AppMethodBeat.o(104543);
        }
        return fVar;
    }

    @Override // com.tencent.mm.kernel.api.b
    public final List<String> aAo() {
        AppMethodBeat.i(104544);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, "emoji/");
        AppMethodBeat.o(104544);
        return linkedList;
    }

    public static String cES() {
        AppMethodBeat.i(104545);
        com.tencent.mm.emoji.e.a aVar = com.tencent.mm.emoji.e.a.hdT;
        String awt = com.tencent.mm.emoji.e.a.awt();
        AppMethodBeat.o(104545);
        return awt;
    }
}
