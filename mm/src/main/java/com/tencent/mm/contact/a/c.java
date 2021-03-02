package com.tencent.mm.contact.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.a.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.openim.d.a;
import com.tencent.mm.openim.d.f;
import com.tencent.mm.openim.d.h;
import com.tencent.mm.openim.d.k;
import com.tencent.mm.openim.d.m;
import com.tencent.mm.openim.d.n;
import com.tencent.mm.openim.d.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;

public final class c implements r {
    @Override // com.tencent.mm.model.ar
    public final void Ey(String str) {
        AppMethodBeat.i(257880);
        if (ab.Iy(str)) {
            ((l) g.af(l.class)).aSM().d(new f(str, 1));
            AppMethodBeat.o(257880);
            return;
        }
        ((l) g.af(l.class)).aSM().d(new o(str, 1));
        AppMethodBeat.o(257880);
    }

    @Override // com.tencent.mm.model.ar
    public final void Ez(String str) {
        AppMethodBeat.i(257881);
        if (ab.Iy(str)) {
            ((l) g.af(l.class)).aSM().d(new f(str, 2));
            AppMethodBeat.o(257881);
            return;
        }
        ((l) g.af(l.class)).aSM().d(new o(str, 2));
        AppMethodBeat.o(257881);
    }

    @Override // com.tencent.mm.model.ar, com.tencent.mm.plugin.messenger.foundation.a.r
    public final aq EA(String str) {
        AppMethodBeat.i(257882);
        b bVar = new b(true);
        bVar.a(new n(str, 1));
        AppMethodBeat.o(257882);
        return bVar;
    }

    @Override // com.tencent.mm.model.ar, com.tencent.mm.plugin.messenger.foundation.a.r
    public final aq EB(String str) {
        AppMethodBeat.i(257883);
        b bVar = new b(true);
        bVar.a(new n(str, 2));
        AppMethodBeat.o(257883);
        return bVar;
    }

    @Override // com.tencent.mm.model.ar
    public final void EC(String str) {
        AppMethodBeat.i(257884);
        ((l) g.af(l.class)).aSM().d(new m(str, 1));
        AppMethodBeat.o(257884);
    }

    @Override // com.tencent.mm.model.ar
    public final void ED(String str) {
        AppMethodBeat.i(257885);
        ((l) g.af(l.class)).aSM().d(new m(str, 2));
        AppMethodBeat.o(257885);
    }

    @Override // com.tencent.mm.model.ar, com.tencent.mm.plugin.messenger.foundation.a.r
    public final void am(String str, String str2) {
        AppMethodBeat.i(257886);
        ((l) g.af(l.class)).aSM().d(new k(str, str2));
        AppMethodBeat.o(257886);
    }

    @Override // com.tencent.mm.model.ar
    public final void EE(String str) {
        AppMethodBeat.i(257887);
        ((l) g.af(l.class)).aSM().d(new h(str, 1));
        AppMethodBeat.o(257887);
    }

    @Override // com.tencent.mm.model.ar
    public final void EF(String str) {
        AppMethodBeat.i(257888);
        ((l) g.af(l.class)).aSM().d(new h(str, 2));
        AppMethodBeat.o(257888);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.r
    public final void EG(String str) {
        AppMethodBeat.i(257889);
        ((l) g.af(l.class)).aSM().d(new a(str));
        AppMethodBeat.o(257889);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.r
    public final void EH(String str) {
        AppMethodBeat.i(257890);
        ((l) g.af(l.class)).aSM().d(new com.tencent.mm.openim.d.l(str, 1));
        AppMethodBeat.o(257890);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.r
    public final void EI(String str) {
        AppMethodBeat.i(257891);
        ((l) g.af(l.class)).aSM().d(new com.tencent.mm.openim.d.l(str, 2));
        AppMethodBeat.o(257891);
    }
}
