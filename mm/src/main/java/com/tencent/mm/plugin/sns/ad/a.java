package com.tencent.mm.plugin.sns.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class a implements d {
    private Map<Integer, com.tencent.mm.plugin.sns.ad.f.a> DrM = new HashMap();

    public a() {
        AppMethodBeat.i(94962);
        AppMethodBeat.o(94962);
    }

    public final void a(com.tencent.mm.plugin.sns.ad.f.a aVar) {
        AppMethodBeat.i(94963);
        this.DrM.put(Integer.valueOf(aVar.getKey()), aVar);
        AppMethodBeat.o(94963);
    }

    @Override // com.tencent.mm.plugin.sns.b.d
    public final void a(int i2, int i3, Object... objArr) {
        AppMethodBeat.i(94964);
        com.tencent.mm.plugin.sns.ad.f.a aVar = this.DrM.get(Integer.valueOf(i2));
        if (aVar == null) {
            Log.w("SnsAdReportService", "can not find %s implementation for kv %d", com.tencent.mm.plugin.sns.ad.f.a.class, Integer.valueOf(i2));
            AppMethodBeat.o(94964);
            return;
        }
        aVar.a(i3, objArr);
        AppMethodBeat.o(94964);
    }

    @Override // com.tencent.mm.plugin.sns.b.d
    public final void a(int i2, Object... objArr) {
        AppMethodBeat.i(94965);
        com.tencent.mm.plugin.sns.ad.f.a aVar = this.DrM.get(Integer.valueOf(i2));
        if (aVar == null) {
            Log.w("SnsAdReportService", "can not find %s implementation for kv %d", com.tencent.mm.plugin.sns.ad.f.a.class, Integer.valueOf(i2));
            AppMethodBeat.o(94965);
            return;
        }
        aVar.v(objArr);
        AppMethodBeat.o(94965);
    }
}
