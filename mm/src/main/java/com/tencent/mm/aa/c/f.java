package com.tencent.mm.aa.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.d;
import com.tencent.mm.aa.d.a;
import java.util.HashMap;
import junit.framework.Assert;
import org.json.JSONObject;

public final class f {
    a hpi;
    d hpr;
    g hpu;

    public f(d dVar, g gVar, a aVar) {
        AppMethodBeat.i(144818);
        Assert.assertNotNull(dVar);
        Assert.assertNotNull(gVar);
        Assert.assertNotNull(aVar);
        this.hpr = dVar;
        this.hpu = gVar;
        this.hpi = aVar;
        AppMethodBeat.o(144818);
    }

    static String ayR() {
        AppMethodBeat.i(144819);
        HashMap hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        String jSONObject = new JSONObject(hashMap).toString();
        AppMethodBeat.o(144819);
        return jSONObject;
    }
}
