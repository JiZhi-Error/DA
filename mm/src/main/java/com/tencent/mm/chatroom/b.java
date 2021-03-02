package com.tencent.mm.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.chatroom.c.a;
import com.tencent.mm.chatroom.d.h;
import com.tencent.mm.chatroom.d.i;
import com.tencent.mm.chatroom.d.j;
import com.tencent.mm.chatroom.d.n;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.g.a.xi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class b implements bd {
    private static a grl;
    private c<nc> grf = new c<nc>() {
        /* class com.tencent.mm.chatroom.b.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.pluginsdk.c.c
        public final /* synthetic */ q a(nc ncVar) {
            AppMethodBeat.i(12420);
            h hVar = new h(ncVar.dSO.dSP);
            AppMethodBeat.o(12420);
            return hVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, com.tencent.mm.ak.q, com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.pluginsdk.c.c
        public final /* bridge */ /* synthetic */ IEvent a(int i2, q qVar, nc ncVar) {
            return ncVar;
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(IEvent iEvent) {
            AppMethodBeat.i(12421);
            nc ncVar = (nc) iEvent;
            if (ncVar.dSO.dSQ) {
                c.j(ncVar);
                AppMethodBeat.o(12421);
            } else {
                k(ncVar);
                AppMethodBeat.o(12421);
            }
            return false;
        }

        @Override // com.tencent.mm.pluginsdk.c.c
        public final int alY() {
            return 181;
        }
    };
    private c<nf> grg = new c<nf>() {
        /* class com.tencent.mm.chatroom.b.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.pluginsdk.c.c
        public final /* synthetic */ q a(nf nfVar) {
            AppMethodBeat.i(12422);
            nf nfVar2 = nfVar;
            n nVar = new n(nfVar2.dTf.chatroomName, nfVar2.dTf.dTg);
            AppMethodBeat.o(12422);
            return nVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, com.tencent.mm.ak.q, com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.pluginsdk.c.c
        public final /* bridge */ /* synthetic */ IEvent a(int i2, q qVar, nf nfVar) {
            return nfVar;
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(IEvent iEvent) {
            AppMethodBeat.i(12423);
            nf nfVar = (nf) iEvent;
            if (nfVar.dTf.dSQ) {
                c.j(nfVar);
                AppMethodBeat.o(12423);
            } else {
                k(nfVar);
                AppMethodBeat.o(12423);
            }
            return false;
        }

        @Override // com.tencent.mm.pluginsdk.c.c
        public final int alY() {
            return 551;
        }
    };
    private c<ne> grh = new c<ne>() {
        /* class com.tencent.mm.chatroom.b.AnonymousClass3 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.pluginsdk.c.c
        public final /* synthetic */ q a(ne neVar) {
            AppMethodBeat.i(12424);
            ne neVar2 = neVar;
            j jVar = new j(neVar2.dTc.chatroomName, neVar2.dTc.dTe, neVar2.dTc.scene);
            AppMethodBeat.o(12424);
            return jVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, com.tencent.mm.ak.q, com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.pluginsdk.c.c
        public final /* bridge */ /* synthetic */ IEvent a(int i2, q qVar, ne neVar) {
            ne neVar2 = neVar;
            neVar2.dTd.errCode = i2;
            return neVar2;
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(IEvent iEvent) {
            AppMethodBeat.i(12425);
            ne neVar = (ne) iEvent;
            if (neVar.dTc.dSQ) {
                c.j(neVar);
                AppMethodBeat.o(12425);
            } else {
                k(neVar);
                AppMethodBeat.o(12425);
            }
            return false;
        }

        @Override // com.tencent.mm.pluginsdk.c.c
        public final int alY() {
            return 179;
        }
    };
    private c<nj> gri = new c<nj>() {
        /* class com.tencent.mm.chatroom.b.AnonymousClass4 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.pluginsdk.c.c
        public final /* synthetic */ q a(nj njVar) {
            AppMethodBeat.i(12426);
            nj njVar2 = njVar;
            com.tencent.mm.chatroom.d.q qVar = new com.tencent.mm.chatroom.d.q(njVar2.dTv.dTx, njVar2.dTv.chatroomName);
            AppMethodBeat.o(12426);
            return qVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, com.tencent.mm.ak.q, com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.pluginsdk.c.c
        public final /* bridge */ /* synthetic */ IEvent a(int i2, q qVar, nj njVar) {
            nj njVar2 = njVar;
            njVar2.dTw.errCode = i2;
            return njVar2;
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(IEvent iEvent) {
            AppMethodBeat.i(12427);
            nj njVar = (nj) iEvent;
            if (njVar.dTv.dSQ) {
                c.j(njVar);
                AppMethodBeat.o(12427);
            } else {
                k(njVar);
                AppMethodBeat.o(12427);
            }
            return false;
        }

        @Override // com.tencent.mm.pluginsdk.c.c
        public final int alY() {
            return 700;
        }
    };
    private c<nd> grj = new c<nd>() {
        /* class com.tencent.mm.chatroom.b.AnonymousClass5 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.pluginsdk.c.c
        public final /* synthetic */ q a(nd ndVar) {
            AppMethodBeat.i(12428);
            nd ndVar2 = ndVar;
            i iVar = new i(ndVar2.dSR.dST, ndVar2.dSR.dSU);
            AppMethodBeat.o(12428);
            return iVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, com.tencent.mm.ak.q, com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.pluginsdk.c.c
        public final /* bridge */ /* synthetic */ IEvent a(int i2, q qVar, nd ndVar) {
            nd ndVar2 = ndVar;
            i iVar = (i) qVar;
            ndVar2.dSS.dSV = iVar.dSV;
            ndVar2.dSS.dSW = iVar.dSW;
            ndVar2.dSS.dSX = iVar.dSX;
            ndVar2.dSS.dSY = iVar.grY;
            ndVar2.dSS.dTb = iVar.dTb;
            ndVar2.dSS.dSZ = iVar.dSZ;
            ndVar2.dSS.dTa = iVar.dTa;
            return ndVar2;
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(IEvent iEvent) {
            AppMethodBeat.i(12429);
            nd ndVar = (nd) iEvent;
            if (ndVar.dSR.dSQ) {
                c.j(ndVar);
                AppMethodBeat.o(12429);
            } else {
                k(ndVar);
                AppMethodBeat.o(12429);
            }
            return false;
        }

        @Override // com.tencent.mm.pluginsdk.c.c
        public final int alY() {
            return 119;
        }
    };
    private IListener grk = new IListener<xi>() {
        /* class com.tencent.mm.chatroom.b.AnonymousClass6 */

        {
            AppMethodBeat.i(160775);
            this.__eventId = xi.class.getName().hashCode();
            AppMethodBeat.o(160775);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xi xiVar) {
            AppMethodBeat.i(12430);
            xi xiVar2 = xiVar;
            if (xiVar2.edC.edD.equals(nc.class.getName())) {
                if (xiVar2.edC.dJY == 1) {
                    b.this.grf.gmc();
                } else {
                    b.this.grf.ecc();
                }
            } else if (xiVar2.edC.edD.equals(nf.class.getName())) {
                if (xiVar2.edC.dJY == 1) {
                    b.this.grg.gmc();
                } else {
                    b.this.grg.ecc();
                }
            } else if (xiVar2.edC.edD.equals(nd.class.getName())) {
                if (xiVar2.edC.dJY == 1) {
                    b.this.grj.gmc();
                } else {
                    b.this.grj.ecc();
                }
            } else if (xiVar2.edC.edD.equals(ne.class.getName())) {
                if (xiVar2.edC.dJY == 1) {
                    b.this.grh.gmc();
                } else {
                    b.this.grh.ecc();
                }
            } else if (xiVar2.edC.edD.equals(nj.class.getName())) {
                if (xiVar2.edC.dJY == 1) {
                    b.this.gri.gmc();
                } else {
                    b.this.gri.ecc();
                }
            }
            AppMethodBeat.o(12430);
            return false;
        }
    };

    public b() {
        AppMethodBeat.i(12431);
        AppMethodBeat.o(12431);
    }

    private static b alW() {
        AppMethodBeat.i(12432);
        b bVar = (b) y.at(b.class);
        AppMethodBeat.o(12432);
        return bVar;
    }

    private static a alX() {
        AppMethodBeat.i(12433);
        g.aAf().azk();
        alW();
        if (grl == null) {
            alW();
            grl = new a();
        }
        alW();
        a aVar = grl;
        AppMethodBeat.o(12433);
        return aVar;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(12434);
        com.tencent.mm.roomsdk.a.b.a("@chatroom", new a());
        EventCenter.instance.addListener(this.grk);
        EventCenter.instance.addListener(this.grf);
        EventCenter.instance.addListener(this.grj);
        EventCenter.instance.addListener(this.grg);
        EventCenter.instance.addListener(this.grh);
        EventCenter.instance.addListener(this.gri);
        a alX = alX();
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApplication", (cj.a) alX.grL, true);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("NewXmlChatRoomAccessVerifyApproval", (cj.a) alX.grL, true);
        ((e) g.af(e.class)).a("link_admin_explain", alX);
        AppMethodBeat.o(12434);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(12435);
        EventCenter.instance.removeListener(this.grk);
        EventCenter.instance.removeListener(this.grf);
        EventCenter.instance.removeListener(this.grj);
        EventCenter.instance.removeListener(this.grg);
        EventCenter.instance.removeListener(this.grh);
        EventCenter.instance.removeListener(this.gri);
        a alX = alX();
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApplication", alX.grL, true);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("NewXmlChatRoomAccessVerifyApproval", alX.grL, true);
        ((e) g.af(e.class)).aDU("link_admin_explain");
        AppMethodBeat.o(12435);
    }
}
