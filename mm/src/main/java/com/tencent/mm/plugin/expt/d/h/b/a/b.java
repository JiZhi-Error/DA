package com.tencent.mm.plugin.expt.d.h.b.a;

import com.eclipsesource.v8.V8Array;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.h.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.b.g;

public final class b extends a {
    @Override // com.tencent.mm.plugin.expt.d.h.b.b
    public final Object b(V8Array v8Array) {
        AppMethodBeat.i(220364);
        if (v8Array == null || v8Array.length() <= 0) {
            AppMethodBeat.o(220364);
            return null;
        }
        String string = v8Array.getString(0);
        Log.d("EdgeComputingJsApiBase", "[EdgeComputingJsApiReadEdgeDBData]] logic, sql : ".concat(String.valueOf(string)));
        if (g.eP(string)) {
            AppMethodBeat.o(220364);
            return null;
        }
        List<List<String>> aok = com.tencent.mm.plugin.expt.d.a.cMI().aok(string);
        if (aok == null || aok.size() <= 0) {
            AppMethodBeat.o(220364);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (List<String> list : aok) {
            if (list != null && list.size() > 0) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                Iterator<String> it = list.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    if (next == null) {
                        next = "";
                    }
                    if (g.eH(next, ",")) {
                        next = g.bC(next, ",", "\\#");
                    }
                    if (g.eH(next, ";")) {
                        next = g.bC(next, ";", "\\$");
                    }
                    sb.append(next);
                    if (i2 < list.size() - 1) {
                        sb.append(",");
                    }
                    i2++;
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(220364);
        return sb2;
    }

    @Override // com.tencent.mm.plugin.expt.d.h.b.b
    public final String cNb() {
        return "read_edge_db_data";
    }

    @Override // com.tencent.mm.plugin.expt.d.h.b.b
    public final int getType() {
        return 5;
    }
}
