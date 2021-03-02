package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.g;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d implements b, c {
    private static d ynN;

    private d() {
    }

    public static synchronized d dZE() {
        d dVar;
        synchronized (d.class) {
            AppMethodBeat.i(151492);
            if (ynN == null) {
                ynN = new d();
            }
            dVar = ynN;
            AppMethodBeat.o(151492);
        }
        return dVar;
    }

    @Override // com.tencent.mm.kernel.api.b
    public final List<String> aAo() {
        AppMethodBeat.i(151493);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, "image/", "image2/", "bizimg/", "webcanvascache/");
        AppMethodBeat.o(151493);
        return linkedList;
    }

    public static String aSY() {
        AppMethodBeat.i(151494);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().hqG).append("image/").toString();
        AppMethodBeat.o(151494);
        return sb2;
    }

    public static String aSZ() {
        AppMethodBeat.i(151495);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().hqG).append("image2/").toString();
        AppMethodBeat.o(151495);
        return sb2;
    }

    public static String dZF() {
        AppMethodBeat.i(151496);
        AppMethodBeat.o(151496);
        return "wcf://bizimg/";
    }
}
