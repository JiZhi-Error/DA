package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.h;
import com.tencent.mm.g.a.am;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

final class a extends IListener<am> {
    a() {
        AppMethodBeat.i(161674);
        this.__eventId = am.class.getName().hashCode();
        AppMethodBeat.o(161674);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(am amVar) {
        AppMethodBeat.i(102660);
        boolean a2 = a(amVar);
        AppMethodBeat.o(102660);
        return a2;
    }

    private boolean a(am amVar) {
        AppMethodBeat.i(102659);
        if (!(amVar instanceof am)) {
            Log.f("MicroMsg.ReaderAppBindQQ.EventListener", "not bind qq event");
            AppMethodBeat.o(102659);
            return false;
        }
        if (amVar.dDo.dDq == 0) {
            try {
                int aUl = z.aUl() | TPMediaCodecProfileLevel.HEVCMainTierLevel52;
                g.aAh().azQ().set(34, Integer.valueOf(aUl));
                dbw dbw = new dbw();
                dbw.KEc = TPMediaCodecProfileLevel.HEVCMainTierLevel52;
                dbw.MGK = 1;
                ((l) g.af(l.class)).aSM().d(new k.a(39, dbw));
                ((l) g.af(l.class)).aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", aUl, "", ""));
                g.b(new g.a() {
                    /* class com.tencent.mm.plugin.readerapp.c.a.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.readerapp.c.g.a
                    public final void eHF() {
                    }
                });
                com.tencent.mm.kernel.g.aAh().azQ().set(40, Integer.valueOf(z.aUe() & -33));
                ((l) com.tencent.mm.kernel.g.af(l.class)).aSM().d(new h(21, 2));
                Log.d("MicroMsg.ReaderAppBindQQ.EventListener", "doClearReaderAppWeiboHelper succ ");
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ReaderAppBindQQ.EventListener", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(102659);
        return false;
    }
}
