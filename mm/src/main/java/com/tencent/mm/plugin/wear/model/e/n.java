package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.h;
import java.util.ArrayList;
import java.util.List;

public final class n extends a {
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final List<Integer> fWe() {
        AppMethodBeat.i(30096);
        ArrayList arrayList = new ArrayList();
        arrayList.add(11033);
        arrayList.add(11030);
        AppMethodBeat.o(30096);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final byte[] s(int i2, byte[] bArr) {
        AppMethodBeat.i(30097);
        switch (i2) {
            case 11030:
                byte[] aWp = h.aWp("wechatvoicesilk");
                AppMethodBeat.o(30097);
                return aWp;
            case 11031:
            case 11032:
            default:
                AppMethodBeat.o(30097);
                return null;
            case 11033:
                byte[] aWp2 = h.aWp("stlport_shared");
                AppMethodBeat.o(30097);
                return aWp2;
        }
    }
}
