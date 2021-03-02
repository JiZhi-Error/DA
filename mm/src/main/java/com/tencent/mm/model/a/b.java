package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b {
    public String endTime;
    public String gWQ;
    public String iGw;
    public String iGx;
    public HashMap<String, e> iGy = new HashMap<>();

    public b() {
        AppMethodBeat.i(153089);
        AppMethodBeat.o(153089);
    }

    public final e KR(String str) {
        AppMethodBeat.i(153090);
        if (this.iGy == null || !this.iGy.containsKey(str)) {
            AppMethodBeat.o(153090);
            return null;
        }
        e eVar = this.iGy.get(str);
        AppMethodBeat.o(153090);
        return eVar;
    }
}
