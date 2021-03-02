package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aaq;
import com.tencent.mm.sdk.event.EventCenter;
import java.util.ArrayList;
import java.util.List;

public final class o extends a {
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final List<Integer> fWe() {
        AppMethodBeat.i(30098);
        ArrayList arrayList = new ArrayList();
        arrayList.add(11028);
        arrayList.add(11027);
        AppMethodBeat.o(30098);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final byte[] s(int i2, byte[] bArr) {
        AppMethodBeat.i(30099);
        switch (i2) {
            case 11027:
                acP(1);
                break;
            case 11028:
                acP(2);
                break;
        }
        AppMethodBeat.o(30099);
        return null;
    }

    private static void acP(int i2) {
        AppMethodBeat.i(30100);
        aaq aaq = new aaq();
        aaq.ehD.dDe = i2;
        EventCenter.instance.publish(aaq);
        AppMethodBeat.o(30100);
    }
}
