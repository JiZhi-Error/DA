package com.tencent.mm.plugin.performance.diagnostic;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class c implements com.tencent.mm.plugin.performance.a.c {
    public static final c ATi = new c();
    private final Map<String, a> ATj = new HashMap();

    public interface a {
        void eBN();
    }

    public c() {
        AppMethodBeat.i(201039);
        AppMethodBeat.o(201039);
    }

    static {
        AppMethodBeat.i(201042);
        AppMethodBeat.o(201042);
    }

    public final void a(String str, a aVar) {
        AppMethodBeat.i(201040);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.ReportLogic", "tag or reporter should not be null");
            AppMethodBeat.o(201040);
            return;
        }
        this.ATj.put(str, aVar);
        AppMethodBeat.o(201040);
    }

    @Override // com.tencent.mm.plugin.performance.a.c
    public final void eBD() {
    }

    @Override // com.tencent.mm.plugin.performance.a.c
    public final void aA(Map<String, String> map) {
        AppMethodBeat.i(201041);
        for (Map.Entry<String, a> entry : this.ATj.entrySet()) {
            if (map.containsKey(".cmd.diagnostic.report." + entry.getKey())) {
                entry.getValue().eBN();
            }
        }
        AppMethodBeat.o(201041);
    }

    @Override // com.tencent.mm.plugin.performance.a.c
    public final String eBC() {
        return ".cmd.diagnostic.report";
    }
}
