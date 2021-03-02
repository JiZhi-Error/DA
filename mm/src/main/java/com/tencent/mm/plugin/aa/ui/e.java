package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.List;

public final class e extends q {
    private String chatroomName;
    private List<String> jWf;

    public e(n nVar, String str) {
        super(nVar, null, true, true);
        AppMethodBeat.i(63553);
        this.chatroomName = str;
        and();
        AppMethodBeat.o(63553);
    }

    @Override // com.tencent.mm.ui.contact.q
    public final void and() {
        AppMethodBeat.i(63554);
        Log.i("MicroMsg.AASelectInitAdapter", "resetData");
        this.jWf = i.SA(this.chatroomName);
        if (ab.Iz(this.chatroomName)) {
            bmF();
        }
        AppMethodBeat.o(63554);
    }

    @Override // com.tencent.mm.ui.contact.p
    public final a va(int i2) {
        AppMethodBeat.i(63555);
        g.aAi();
        as Kn = ((l) g.af(l.class)).aSN().Kn(this.jWf.get(i2));
        c cVar = new c(i2);
        cVar.dFl = this.chatroomName;
        cVar.contact = Kn;
        cVar.PWh = true;
        AppMethodBeat.o(63555);
        return cVar;
    }

    public final int getCount() {
        AppMethodBeat.i(63556);
        int size = this.jWf.size();
        AppMethodBeat.o(63556);
        return size;
    }

    private void bmF() {
        AppMethodBeat.i(213013);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (this.jWf != null && this.jWf.size() > 0) {
            for (String str : this.jWf) {
                if (as.bjp(str)) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
            if (arrayList.size() > 0) {
                this.jWf.clear();
                this.jWf.addAll(arrayList2);
                this.jWf.addAll(arrayList);
            }
        }
        AppMethodBeat.o(213013);
    }
}
