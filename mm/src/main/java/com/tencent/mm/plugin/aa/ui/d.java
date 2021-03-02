package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d extends q {
    private List<String> dSU;
    private ArrayList<String> jVT;

    public d(n nVar, ArrayList<String> arrayList) {
        super(nVar, null, true, true);
        AppMethodBeat.i(63549);
        this.jVT = arrayList;
        and();
        AppMethodBeat.o(63549);
    }

    @Override // com.tencent.mm.ui.contact.q
    public final void and() {
        AppMethodBeat.i(63550);
        Log.i("MicroMsg.AASelectInitAdapter", "resetData");
        if (this.dSU == null) {
            this.dSU = new ArrayList();
        }
        this.dSU.clear();
        Iterator<String> it = this.jVT.iterator();
        while (it.hasNext()) {
            this.dSU.add(it.next());
        }
        AppMethodBeat.o(63550);
    }

    @Override // com.tencent.mm.ui.contact.p
    public final a va(int i2) {
        AppMethodBeat.i(63551);
        String str = this.dSU.get(i2);
        g.aAi();
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn != null && Util.isNullOrNil(Kn.field_username)) {
            Kn.setUsername(str);
        }
        c cVar = new c(i2);
        cVar.contact = Kn;
        cVar.PWh = true;
        AppMethodBeat.o(63551);
        return cVar;
    }

    public final int getCount() {
        AppMethodBeat.i(63552);
        int size = this.dSU.size();
        AppMethodBeat.o(63552);
        return size;
    }
}
