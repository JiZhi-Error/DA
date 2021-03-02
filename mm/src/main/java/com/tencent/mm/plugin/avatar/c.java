package com.tencent.mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c extends y implements b {
    private static c oII;

    private c() {
        super(p.class);
    }

    public static synchronized c ceE() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(151426);
            if (oII == null) {
                oII = new c();
            }
            cVar = oII;
            AppMethodBeat.o(151426);
        }
        return cVar;
    }

    @Override // com.tencent.mm.kernel.api.b
    public final List<String> aAo() {
        AppMethodBeat.i(151427);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, "avatar/");
        AppMethodBeat.o(151427);
        return linkedList;
    }

    public static String ceF() {
        AppMethodBeat.i(151428);
        String str = g.aAh().cachePath + "avatar/";
        AppMethodBeat.o(151428);
        return str;
    }
}
