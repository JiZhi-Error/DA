package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ac implements ab {
    private h iID;
    protected Map<String, o> iIE = new HashMap();

    public ac(h hVar) {
        AppMethodBeat.i(76392);
        this.iID = hVar;
        AppMethodBeat.o(76392);
    }

    public ac(ab abVar) {
        AppMethodBeat.i(76393);
        if (abVar == null) {
            AppMethodBeat.o(76393);
            return;
        }
        this.iID = abVar.aXU();
        a(abVar);
        AppMethodBeat.o(76393);
    }

    private void a(ab abVar) {
        AppMethodBeat.i(76394);
        for (o oVar : abVar.aXV()) {
            a(oVar);
        }
        AppMethodBeat.o(76394);
    }

    @Override // com.tencent.mm.modelappbrand.ab
    public final h aXU() {
        return this.iID;
    }

    @Override // com.tencent.mm.modelappbrand.ab
    public final <T> T LA(String str) {
        AppMethodBeat.i(76395);
        T t = (T) this.iIE.get(str);
        AppMethodBeat.o(76395);
        return t;
    }

    public final void a(o oVar) {
        AppMethodBeat.i(76396);
        this.iIE.put(oVar.getName(), oVar);
        AppMethodBeat.o(76396);
    }

    @Override // com.tencent.mm.modelappbrand.ab
    public final List<o> aXV() {
        AppMethodBeat.i(76397);
        ArrayList arrayList = new ArrayList(this.iIE.values());
        AppMethodBeat.o(76397);
        return arrayList;
    }
}
