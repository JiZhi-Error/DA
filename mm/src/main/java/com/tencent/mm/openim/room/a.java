package com.tencent.mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.openim.b.c;
import com.tencent.mm.openim.b.d;
import com.tencent.mm.openim.b.f;
import com.tencent.mm.openim.b.k;
import com.tencent.mm.openim.b.m;
import com.tencent.mm.openim.d.g;
import com.tencent.mm.openim.d.j;
import com.tencent.mm.openim.room.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.roomsdk.a.c.b;
import com.tencent.mm.roomsdk.a.c.e;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import java.util.List;

public final class a implements com.tencent.mm.roomsdk.a.a.a {
    @Override // com.tencent.mm.roomsdk.a.a.a
    public final e alV() {
        AppMethodBeat.i(151292);
        e gvQ = e.gvQ();
        AppMethodBeat.o(151292);
        return gvQ;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list) {
        AppMethodBeat.i(151293);
        b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(false);
        Aw.gNg = new c(b.a.aM(list));
        AppMethodBeat.o(151293);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, String str2, String str3) {
        AppMethodBeat.i(223648);
        com.tencent.mm.roomsdk.a.c.b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(false);
        Aw.gNg = new c(b.a.aM(list));
        AppMethodBeat.o(223648);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, String str2, Object obj) {
        AppMethodBeat.i(223649);
        com.tencent.mm.roomsdk.a.c.b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(false);
        Aw.gNg = new com.tencent.mm.openim.b.a(str, b.a.aM(list), str2);
        AppMethodBeat.o(223649);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, int i2) {
        AppMethodBeat.i(151295);
        com.tencent.mm.roomsdk.a.c.b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(false);
        Aw.gNg = new d(str, b.a.aM(list));
        AppMethodBeat.o(151295);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, Object obj) {
        AppMethodBeat.i(223650);
        com.tencent.mm.roomsdk.a.c.b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(false);
        Aw.gNg = new k(str, b.a.aM(list));
        AppMethodBeat.o(223650);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, String str2, ca caVar) {
        AppMethodBeat.i(151297);
        com.tencent.mm.roomsdk.a.c.b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(false);
        Aw.gNg = new k(str, b.a.aM(list));
        AppMethodBeat.o(151297);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a Dt(String str) {
        AppMethodBeat.i(151298);
        com.tencent.mm.roomsdk.a.c.b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(false);
        Aw.gNg = new com.tencent.mm.openim.b.e(str);
        AppMethodBeat.o(151298);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a H(String str, int i2) {
        AppMethodBeat.i(151299);
        com.tencent.mm.roomsdk.a.c.b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(false);
        Aw.gNg = new f(str, i2);
        AppMethodBeat.o(151299);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a Z(String str, String str2) {
        AppMethodBeat.i(151300);
        com.tencent.mm.roomsdk.a.c.b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(false);
        Aw.gNg = new m(str2, str);
        AppMethodBeat.o(151300);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a Du(String str) {
        AppMethodBeat.i(151301);
        com.tencent.mm.roomsdk.a.c.c Ax = com.tencent.mm.roomsdk.a.c.a.Ax(false);
        Ax.NDQ = new j(str);
        AppMethodBeat.o(151301);
        return Ax;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a I(String str, int i2) {
        int i3;
        AppMethodBeat.i(151302);
        com.tencent.mm.roomsdk.a.c.c Ax = com.tencent.mm.roomsdk.a.c.a.Ax(false);
        if (i2 == 0) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        Ax.NDQ = new com.tencent.mm.openim.d.c(str, i3);
        AppMethodBeat.o(151302);
        return Ax;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a aa(String str, String str2) {
        AppMethodBeat.i(151303);
        com.tencent.mm.roomsdk.a.c.c Ax = com.tencent.mm.roomsdk.a.c.a.Ax(false);
        Ax.NDQ = new g(str, str2);
        AppMethodBeat.o(151303);
        return Ax;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a ab(String str, String str2) {
        return null;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a ac(String str, String str2) {
        AppMethodBeat.i(151304);
        com.tencent.mm.roomsdk.a.c.c Ax = com.tencent.mm.roomsdk.a.c.a.Ax(false);
        Ax.NDQ = new com.tencent.mm.openim.d.b(str, str2);
        AppMethodBeat.o(151304);
        return Ax;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a g(String str, String str2, String str3) {
        AppMethodBeat.i(151305);
        com.tencent.mm.roomsdk.a.c.c Ax = com.tencent.mm.roomsdk.a.c.a.Ax(false);
        Ax.NDQ = new com.tencent.mm.openim.d.d(str, str3);
        AppMethodBeat.o(151305);
        return Ax;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a b(String str, String str2, boolean z) {
        int i2;
        AppMethodBeat.i(151306);
        com.tencent.mm.roomsdk.a.c.c Ax = com.tencent.mm.roomsdk.a.c.a.Ax(false);
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        Ax.NDQ = new com.tencent.mm.openim.d.e(str, i2);
        AppMethodBeat.o(151306);
        return Ax;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final void a(as asVar, boolean z) {
        AppMethodBeat.i(151307);
        if (z) {
            asVar.aqQ();
            if (ab.p(asVar)) {
                asVar.nd(43);
                asVar.BF(com.tencent.mm.platformtools.f.Si(asVar.arI()));
                asVar.BG(com.tencent.mm.platformtools.f.Sh(asVar.arI()));
                asVar.BI(com.tencent.mm.platformtools.f.Sh(asVar.arJ()));
                asVar.BJ(asVar.arJ());
            }
            ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().c(asVar.field_username, asVar);
            ((r) com.tencent.mm.kernel.g.af(r.class)).EH(asVar.field_username);
            AppMethodBeat.o(151307);
            return;
        }
        ((r) com.tencent.mm.kernel.g.af(r.class)).EI(asVar.field_username);
        AppMethodBeat.o(151307);
    }
}
