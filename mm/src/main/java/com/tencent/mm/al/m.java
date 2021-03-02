package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m implements q, b, com.tencent.mm.kernel.api.bucket.b, c {
    private t iOE;
    private u iOF;

    @Override // com.tencent.mm.al.q
    public final t aSR() {
        return this.iOE;
    }

    @Override // com.tencent.mm.al.q
    public final u aSS() {
        return this.iOF;
    }

    @Override // com.tencent.mm.al.q
    public final String aTh() {
        AppMethodBeat.i(124101);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().hqG).append("brandicon/").toString();
        AppMethodBeat.o(124101);
        return sb2;
    }

    @Override // com.tencent.mm.al.q
    public final String aZV() {
        AppMethodBeat.i(212174);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().hqG).append("bizcache/").toString();
        AppMethodBeat.o(212174);
        return sb2;
    }

    @Override // com.tencent.mm.kernel.api.b
    public final List<String> aAo() {
        AppMethodBeat.i(124102);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, "brandicon/", "bizcache/");
        AppMethodBeat.o(124102);
        return linkedList;
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(124103);
        i eiy = ((l) g.af(l.class)).eiy();
        t tVar = new t(eiy);
        this.iOE = tVar;
        eiy.a(tVar);
        this.iOF = new u(((l) g.af(l.class)).aST());
        AppMethodBeat.o(124103);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public final void parallelsDependency() {
        AppMethodBeat.i(124104);
        a.a(this, c.class).bI(g.ah(s.class));
        AppMethodBeat.o(124104);
    }
}
