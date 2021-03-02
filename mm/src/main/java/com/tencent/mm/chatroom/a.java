package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.d;
import com.tencent.mm.chatroom.d.g;
import com.tencent.mm.chatroom.d.i;
import com.tencent.mm.chatroom.d.j;
import com.tencent.mm.chatroom.d.l;
import com.tencent.mm.chatroom.d.n;
import com.tencent.mm.chatroom.d.p;
import com.tencent.mm.chatroom.d.q;
import com.tencent.mm.chatroom.d.u;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.cph;
import com.tencent.mm.protocal.protobuf.cpi;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.roomsdk.a.c.b;
import com.tencent.mm.roomsdk.a.c.c;
import com.tencent.mm.roomsdk.a.c.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import java.util.List;

public final class a implements com.tencent.mm.roomsdk.a.a.a {
    public String TAG = "MicroMsg.DefaultChatRoom";

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final e alV() {
        AppMethodBeat.i(12404);
        e gvQ = e.gvQ();
        AppMethodBeat.o(12404);
        return gvQ;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list) {
        AppMethodBeat.i(12405);
        b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(true);
        Aw.gNg = new i(str, list);
        AppMethodBeat.o(12405);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, String str2, String str3) {
        AppMethodBeat.i(194005);
        b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(true);
        Aw.gNg = new i(str, list, str2, str3);
        AppMethodBeat.o(194005);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, String str2, Object obj) {
        AppMethodBeat.i(194006);
        b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(true);
        Aw.gNg = new g(str, list, str2, obj);
        AppMethodBeat.o(194006);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, int i2) {
        AppMethodBeat.i(12407);
        b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(true);
        Aw.gNg = new j(str, list, i2);
        AppMethodBeat.o(12407);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, Object obj) {
        AppMethodBeat.i(194007);
        b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(true);
        Aw.gNg = new p(str, list, obj);
        AppMethodBeat.o(194007);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a a(String str, List<String> list, String str2, ca caVar) {
        AppMethodBeat.i(12409);
        b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(true);
        Aw.gNg = new p(str, list, str2, caVar);
        AppMethodBeat.o(12409);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a Dt(String str) {
        AppMethodBeat.i(12410);
        b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(true);
        Aw.gNg = new l(str);
        AppMethodBeat.o(12410);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a H(String str, int i2) {
        AppMethodBeat.i(12411);
        b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(true);
        Aw.gNg = new n(str, i2);
        AppMethodBeat.o(12411);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a Z(String str, String str2) {
        AppMethodBeat.i(12412);
        b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(true);
        Aw.gNg = new q(str, str2);
        AppMethodBeat.o(12412);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a Du(String str) {
        AppMethodBeat.i(12413);
        ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new d(str));
        com.tencent.mm.roomsdk.a.c.d dVar = new com.tencent.mm.roomsdk.a.c.d();
        dVar.a(new com.tencent.mm.chatroom.f.b((String) com.tencent.mm.kernel.g.aAh().azQ().get(2, (Object) null), str));
        AppMethodBeat.o(12413);
        return dVar;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a I(String str, int i2) {
        AppMethodBeat.i(12414);
        c Ax = com.tencent.mm.roomsdk.a.c.a.Ax(true);
        Ax.NDQ = new com.tencent.mm.chatroom.f.a(str, i2);
        AppMethodBeat.o(12414);
        return Ax;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a aa(String str, String str2) {
        AppMethodBeat.i(12415);
        c Ax = com.tencent.mm.roomsdk.a.c.a.Ax(true);
        cpk cpk = new cpk();
        cpk.KGR = new dqi().bhy(Util.nullAsNil(str));
        cpk.Mvg = new dqi().bhy(Util.nullAsNil(str2));
        Ax.NDQ = new k.a(27, cpk);
        AppMethodBeat.o(12415);
        return Ax;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a ab(String str, String str2) {
        AppMethodBeat.i(194008);
        c Ax = com.tencent.mm.roomsdk.a.c.a.Ax(true);
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
        if (Kn != null && ((int) Kn.gMZ) > 0) {
            Kn.BD(str2);
            Ax.NDQ = new k.a(2, ab.H(Kn));
        }
        AppMethodBeat.o(194008);
        return Ax;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a ac(String str, String str2) {
        AppMethodBeat.i(12416);
        b Aw = com.tencent.mm.roomsdk.a.c.a.Aw(true);
        Aw.gNg = new u(str, str2);
        AppMethodBeat.o(12416);
        return Aw;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a g(String str, String str2, String str3) {
        AppMethodBeat.i(12417);
        c Ax = com.tencent.mm.roomsdk.a.c.a.Ax(true);
        cph cph = new cph();
        cph.KGO = str;
        cph.UserName = str2;
        cph.Liq = Util.nullAsNil(str3);
        Ax.NDQ = new k.a(48, cph);
        AppMethodBeat.o(12417);
        return Ax;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final com.tencent.mm.roomsdk.a.c.a b(String str, String str2, boolean z) {
        int i2 = 1;
        AppMethodBeat.i(12418);
        c Ax = com.tencent.mm.roomsdk.a.c.a.Ax(true);
        cpi cpi = new cpi();
        cpi.KGO = str;
        cpi.UserName = str2;
        cpi.Mvf = 1;
        if (!z) {
            i2 = 2;
        }
        cpi.Cyb = i2;
        Ax.NDQ = new k.a(49, cpi);
        AppMethodBeat.o(12418);
        return Ax;
    }

    @Override // com.tencent.mm.roomsdk.a.a.a
    public final void a(as asVar, boolean z) {
        AppMethodBeat.i(12419);
        if (z) {
            ab.C(asVar);
            AppMethodBeat.o(12419);
            return;
        }
        ab.G(asVar);
        AppMethodBeat.o(12419);
    }
}
