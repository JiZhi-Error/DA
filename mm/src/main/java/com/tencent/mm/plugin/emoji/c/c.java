package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.br;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class c extends IListener<br> {
    public c() {
        AppMethodBeat.i(161067);
        this.__eventId = br.class.getName().hashCode();
        AppMethodBeat.o(161067);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(br brVar) {
        AppMethodBeat.i(108390);
        boolean a2 = a(brVar);
        AppMethodBeat.o(108390);
        return a2;
    }

    private static boolean a(br brVar) {
        AppMethodBeat.i(108389);
        if (brVar.dEV.dEO == 37) {
            if (brVar.dEV.subType == 5 && brVar.dEV.dDe == 2) {
                h cFT = h.cFT();
                Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "delete emoji egg!");
                try {
                    s.deleteFile(g.aAh().cachePath + "eggingfo.ini");
                    s.dy(aa.z(new o(h.getDataEmojiPath(), h.qZM).mUri), true);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e2, "", new Object[0]);
                }
                cFT.ran = null;
            }
            if (brVar.dEV.dDe == 0) {
                Log.i("MicroMsg.emoji.EmojiResUpdateOperationListener", "cache res type:%d subType:%d", Integer.valueOf(brVar.dEV.dEO), Integer.valueOf(brVar.dEV.subType));
            }
        }
        AppMethodBeat.o(108389);
        return false;
    }
}
