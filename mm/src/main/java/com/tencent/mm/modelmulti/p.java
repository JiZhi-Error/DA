package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.as.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class p implements bd {
    public static HashMap<Integer, h.b> baseDBFactories = new HashMap<>();
    private c jed;

    static {
        AppMethodBeat.i(20556);
        AppMethodBeat.o(20556);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(20551);
        EventCenter eventCenter = EventCenter.instance;
        c cVar = new c();
        this.jed = cVar;
        eventCenter.addListener(cVar);
        AppMethodBeat.o(20551);
    }

    public static o bdR() {
        AppMethodBeat.i(20552);
        g.aAi();
        g.aAf().azk();
        o bdR = ((l) g.af(l.class)).bdR();
        AppMethodBeat.o(20552);
        return bdR;
    }

    public static q bdS() {
        AppMethodBeat.i(20553);
        q bdS = ((b) g.af(b.class)).bdS();
        AppMethodBeat.o(20553);
        return bdS;
    }

    public static p bdT() {
        AppMethodBeat.i(20554);
        bg.aVz();
        p pVar = (p) cg.KG(p.class.getName());
        if (pVar == null) {
            pVar = new p();
            bg.aVz().a(p.class.getName(), pVar);
        }
        AppMethodBeat.o(20554);
        return pVar;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(20555);
        if (this.jed != null) {
            c cVar = this.jed;
            EventCenter.instance.removeListener(cVar.iWd);
            com.tencent.mm.as.b.bch().iVW = null;
            ((l) g.af(l.class)).aST().remove(cVar);
            bdT();
            bdR().remove(cVar);
            EventCenter.instance.removeListener(this.jed);
        }
        AppMethodBeat.o(20555);
    }
}
