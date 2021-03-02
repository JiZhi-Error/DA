package com.tencent.mm.pluginsdk.j.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.l;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.event.IListener;

public final class o implements c, com.tencent.mm.kernel.b.c {
    public static final o Kah = new o();
    private final IListener Kai = new IListener<l>() {
        /* class com.tencent.mm.pluginsdk.j.a.c.o.AnonymousClass2 */

        {
            AppMethodBeat.i(161792);
            this.__eventId = l.class.getName().hashCode();
            AppMethodBeat.o(161792);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(l lVar) {
            AppMethodBeat.i(152048);
            if (!lVar.dCi.isActive) {
                p.awI();
            }
            AppMethodBeat.o(152048);
            return false;
        }
    };
    private final p qsH = new p.a() {
        /* class com.tencent.mm.pluginsdk.j.a.c.o.AnonymousClass1 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(152047);
            p.awI();
            AppMethodBeat.o(152047);
        }
    };

    public o() {
        AppMethodBeat.i(152049);
        AppMethodBeat.o(152049);
    }

    static {
        AppMethodBeat.i(152052);
        AppMethodBeat.o(152052);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(152050);
        for (g gVar : r.gob()) {
            gVar.gnE();
        }
        g.aAg().a(this.qsH);
        this.Kai.alive();
        AppMethodBeat.o(152050);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(152051);
        g.aAg().b(this.qsH);
        this.Kai.dead();
        for (g gVar : r.gob()) {
            gVar.onAccountRelease();
        }
        AppMethodBeat.o(152051);
    }
}
