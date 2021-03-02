package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed;
import com.tencent.mm.ui.chatting.viewitems.aa;
import com.tencent.mm.ui.chatting.viewitems.ab;
import com.tencent.mm.ui.chatting.viewitems.ae;
import com.tencent.mm.ui.chatting.viewitems.af;
import com.tencent.mm.ui.chatting.viewitems.ag;
import com.tencent.mm.ui.chatting.viewitems.ah;
import com.tencent.mm.ui.chatting.viewitems.ai;
import com.tencent.mm.ui.chatting.viewitems.aj;
import com.tencent.mm.ui.chatting.viewitems.ak;
import com.tencent.mm.ui.chatting.viewitems.am;
import com.tencent.mm.ui.chatting.viewitems.aq;
import com.tencent.mm.ui.chatting.viewitems.ar;
import com.tencent.mm.ui.chatting.viewitems.av;
import com.tencent.mm.ui.chatting.viewitems.aw;
import com.tencent.mm.ui.chatting.viewitems.ax;
import com.tencent.mm.ui.chatting.viewitems.az;
import com.tencent.mm.ui.chatting.viewitems.bd;
import com.tencent.mm.ui.chatting.viewitems.be;
import com.tencent.mm.ui.chatting.viewitems.bf;
import com.tencent.mm.ui.chatting.viewitems.bj;
import com.tencent.mm.ui.chatting.viewitems.bk;
import com.tencent.mm.ui.chatting.viewitems.bz;
import com.tencent.mm.ui.chatting.viewitems.ca;
import com.tencent.mm.ui.chatting.viewitems.e;
import com.tencent.mm.ui.chatting.viewitems.f;
import com.tencent.mm.ui.chatting.viewitems.g;
import com.tencent.mm.ui.chatting.viewitems.h;
import com.tencent.mm.ui.chatting.viewitems.i;
import com.tencent.mm.ui.chatting.viewitems.j;
import com.tencent.mm.ui.chatting.viewitems.k;
import com.tencent.mm.ui.chatting.viewitems.l;
import com.tencent.mm.ui.chatting.viewitems.m;
import com.tencent.mm.ui.chatting.viewitems.n;
import com.tencent.mm.ui.chatting.viewitems.o;
import com.tencent.mm.ui.chatting.viewitems.p;
import com.tencent.mm.ui.chatting.viewitems.q;
import com.tencent.mm.ui.chatting.viewitems.r;
import com.tencent.mm.ui.chatting.viewitems.s;
import com.tencent.mm.ui.chatting.viewitems.t;
import com.tencent.mm.ui.chatting.viewitems.u;
import com.tencent.mm.ui.chatting.viewitems.v;
import com.tencent.mm.ui.chatting.viewitems.w;
import com.tencent.mm.ui.chatting.viewitems.x;
import com.tencent.mm.ui.chatting.viewitems.y;
import com.tencent.mm.ui.chatting.viewitems.z;
import java.util.ArrayList;
import java.util.List;

public final class br {
    private static final List<c> PQL;

    public static c cR(ca caVar) {
        AppMethodBeat.i(37558);
        for (c cVar : PQL) {
            if (cVar.bM(caVar.getType(), caVar.field_isSend == 1)) {
                try {
                    c cVar2 = (c) cVar.getClass().newInstance();
                    AppMethodBeat.o(37558);
                    return cVar2;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Chatting.ItemFactory", e2, "", new Object[0]);
                }
            }
        }
        bd.a aVar = new bd.a();
        AppMethodBeat.o(37558);
        return aVar;
    }

    public static int gUk() {
        AppMethodBeat.i(37559);
        int size = PQL.size() + 2;
        AppMethodBeat.o(37559);
        return size;
    }

    public static int cS(ca caVar) {
        AppMethodBeat.i(37560);
        if (caVar.getType() == 49) {
            int g2 = m.g(k.b.HD(caVar.field_content));
            Log.d("MicroMsg.Chatting.ItemFactory", "maybe honeypay need change type: %s", Integer.valueOf(g2));
            if (g2 != 49) {
                caVar.setType(g2);
                bg.aVF();
                c.aSQ().a(caVar.field_msgId, caVar);
            }
        }
        for (int i2 = 0; i2 < PQL.size(); i2++) {
            if (PQL.get(i2).bM(caVar.getType(), caVar.field_isSend == 1)) {
                AppMethodBeat.o(37560);
                return i2;
            }
        }
        AppMethodBeat.o(37560);
        return 0;
    }

    static {
        AppMethodBeat.i(37561);
        ArrayList arrayList = new ArrayList();
        PQL = arrayList;
        arrayList.add(new bd.b());
        PQL.add(new bd.a());
        PQL.add(new e.C2107e());
        PQL.add(new e.d());
        PQL.add(new w.c());
        PQL.add(new w.b());
        PQL.add(new ag.c());
        PQL.add(new ag.b());
        PQL.add(new v.c());
        PQL.add(new v.b());
        PQL.add(new aa.c());
        PQL.add(new aa.b());
        PQL.add(new l.d());
        PQL.add(new l.c());
        PQL.add(new ab.b());
        PQL.add(new ab.a());
        PQL.add(new ba());
        PQL.add(new av.b());
        PQL.add(new aq.b());
        PQL.add(new aq.a());
        PQL.add(new bf.a());
        PQL.add(new bf.b());
        PQL.add(new ax.a());
        PQL.add(new am.c());
        PQL.add(new am.b());
        PQL.add(new ar.a());
        PQL.add(new be.b());
        PQL.add(new be.a());
        PQL.add(new aw.b());
        PQL.add(new aw.a());
        PQL.add(new bj.f());
        PQL.add(new bj.c());
        PQL.add(new bj.g());
        PQL.add(new ak.j());
        PQL.add(new bj.d());
        PQL.add(new bj.e());
        PQL.add(new bi());
        PQL.add(new bg());
        PQL.add(new bh());
        PQL.add(new az.a());
        PQL.add(new az.b());
        PQL.add(new bk.c());
        PQL.add(new bk.b());
        PQL.add(new ao());
        PQL.add(new d());
        PQL.add(new y.b());
        PQL.add(new y.c());
        PQL.add(new as());
        PQL.add(new at());
        PQL.add(new au());
        PQL.add(new ae.c());
        PQL.add(new ae.b());
        PQL.add(new f.c());
        PQL.add(new f.b());
        PQL.add(new j.c());
        PQL.add(new j.b());
        PQL.add(new h.c());
        PQL.add(new h.b());
        PQL.add(new i.c());
        PQL.add(new i.b());
        PQL.add(new ai.b());
        PQL.add(new ai.a());
        PQL.add(new aj.b());
        PQL.add(new aj.a());
        PQL.add(new ah.b());
        PQL.add(new ah.a());
        PQL.add(new x.c());
        PQL.add(new x.b());
        PQL.add(new av.a());
        PQL.add(new g.c());
        PQL.add(new g.b());
        PQL.add(new bz.c());
        PQL.add(new bz.b());
        PQL.add(new k.c());
        PQL.add(new ac());
        PQL.add(new p.b());
        PQL.add(new p.c());
        PQL.add(new z.b());
        PQL.add(new z.c());
        PQL.add(new t.b());
        PQL.add(new t.c());
        PQL.add(new m.b());
        PQL.add(new m.c());
        PQL.add(new n.b());
        PQL.add(new n.c());
        PQL.add(new o.b());
        PQL.add(new o.c());
        PQL.add(new r.b());
        PQL.add(new r.c());
        PQL.add(new ChatingItemAppMsgFinderLiveFeed.a());
        PQL.add(new ChatingItemAppMsgFinderLiveFeed.b());
        PQL.add(new af.a());
        PQL.add(new af.b());
        PQL.add(new u.b());
        PQL.add(new u.c());
        PQL.add(new ad());
        PQL.add(new q.a());
        PQL.add(new q.b());
        PQL.add(new s.b());
        PQL.add(new s.c());
        PQL.add(new ca.a());
        PQL.add(new ca.b());
        PQL.add(new bd.b() {
            /* class com.tencent.mm.ui.chatting.viewitems.br.AnonymousClass1 */

            @Override // com.tencent.mm.ui.chatting.viewitems.bd.b, com.tencent.mm.ui.chatting.viewitems.c
            public final boolean bM(int i2, boolean z) {
                AppMethodBeat.i(37556);
                Log.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", Integer.valueOf(i2), Boolean.valueOf(z));
                AppMethodBeat.o(37556);
                return z;
            }
        });
        PQL.add(new bd.a() {
            /* class com.tencent.mm.ui.chatting.viewitems.br.AnonymousClass2 */

            @Override // com.tencent.mm.ui.chatting.viewitems.bd.a, com.tencent.mm.ui.chatting.viewitems.c
            public final boolean bM(int i2, boolean z) {
                AppMethodBeat.i(37557);
                Log.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", Integer.valueOf(i2), Boolean.valueOf(z));
                if (!z) {
                    AppMethodBeat.o(37557);
                    return true;
                }
                AppMethodBeat.o(37557);
                return false;
            }
        });
        AppMethodBeat.o(37561);
    }
}
