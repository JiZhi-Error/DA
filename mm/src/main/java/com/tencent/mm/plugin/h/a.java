package com.tencent.mm.plugin.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.v;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a extends y implements b {
    private static a qEZ;

    private a() {
        super(v.class);
    }

    public static synchronized a cBk() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(151484);
            if (qEZ == null) {
                qEZ = new a();
            }
            aVar = qEZ;
            AppMethodBeat.o(151484);
        }
        return aVar;
    }

    @Override // com.tencent.mm.kernel.api.b
    public final List<String> aAo() {
        AppMethodBeat.i(151485);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, "package/");
        AppMethodBeat.o(151485);
        return linkedList;
    }

    public static String aTf() {
        AppMethodBeat.i(151486);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().hqG).append("package/").toString();
        AppMethodBeat.o(151486);
        return sb2;
    }
}
