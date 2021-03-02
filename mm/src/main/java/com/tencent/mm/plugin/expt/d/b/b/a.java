package com.tencent.mm.plugin.expt.d.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.b.g;

public final class a {
    public Map<String, Long> syc = new HashMap();

    public a() {
        AppMethodBeat.i(220316);
        cMY();
        AppMethodBeat.o(220316);
    }

    private void cMY() {
        String[] split;
        String[] split2;
        AppMethodBeat.i(220317);
        MultiProcessMMKV cMR = b.cMR();
        if (cMR == null) {
            AppMethodBeat.o(220317);
            return;
        }
        String string = cMR.getString("mmkv_key_run_record", "");
        if (!g.eP(string) && (split = string.split(";")) != null && split.length > 0) {
            for (String str : split) {
                try {
                    if (!g.eP(str) && (split2 = str.split(",")) != null && split2.length > 0) {
                        this.syc.put(split2[0], Long.valueOf(Long.parseLong(split2[1])));
                    }
                } catch (Exception e2) {
                    Log.e("EdgeComputingRunRecord", "[EdgeComputingConfigRecord] initRecord throw Exception : " + e2.getMessage() + ", rr : " + str);
                }
            }
        }
        AppMethodBeat.o(220317);
    }

    public final void cMZ() {
        AppMethodBeat.i(220318);
        MultiProcessMMKV cMR = b.cMR();
        if (cMR == null) {
            AppMethodBeat.o(220318);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : this.syc.keySet()) {
            sb.append(str).append(",").append(this.syc.get(str)).append(";");
        }
        cMR.putString("mmkv_key_run_record", sb.toString());
        AppMethodBeat.o(220318);
    }

    public final long aon(String str) {
        AppMethodBeat.i(220319);
        if (g.eP(str)) {
            AppMethodBeat.o(220319);
            return 0;
        }
        synchronized (this.syc) {
            try {
                Long l = this.syc.get(str);
                if (l != null) {
                    return l.longValue();
                }
                AppMethodBeat.o(220319);
                return 0;
            } finally {
                AppMethodBeat.o(220319);
            }
        }
    }
}
