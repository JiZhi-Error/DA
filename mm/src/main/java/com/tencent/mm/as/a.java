package com.tencent.mm.as;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.k.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.Iterator;
import java.util.List;

public class a {
    private static a iVU;

    public static a bcg() {
        AppMethodBeat.i(20488);
        if (iVU == null) {
            synchronized (a.class) {
                try {
                    if (iVU == null) {
                        iVU = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(20488);
                    throw th;
                }
            }
        }
        a aVar = iVU;
        AppMethodBeat.o(20488);
        return aVar;
    }

    static /* synthetic */ void Ol(String str) {
        AppMethodBeat.i(20489);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.GetChatroomMsgChecker", "[checkDirtyBlock] username is null!");
            AppMethodBeat.o(20489);
            return;
        }
        long aWy = cl.aWy();
        long j2 = aWy - 259200000;
        Log.i("MicroMsg.GetChatroomMsgChecker", "[checkDirtyBlock] serverTime:" + aWy + " beforeTime:" + j2 + " beforeTime format:" + f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, j2 / 1000) + "username:" + str);
        b eit = ((l) g.af(l.class)).eit();
        aj aEh = eit.aEh(str);
        if (aEh.field_seqBlockInfo != null) {
            List<c> Nf = aEh.Nf(j2);
            StringBuilder sb = new StringBuilder();
            sb.append("clear:");
            for (c cVar : Nf) {
                sb.append("[" + cVar.gCy).append(":").append(cVar.gCz + "] time:").append(f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, cVar.gCB / 1000)).append(APLogFileUtil.SEPARATOR_LOG);
                aEh.field_seqBlockInfo.gCC.remove(cVar);
            }
            sb.append("\nafter:");
            Iterator<c> it = aEh.field_seqBlockInfo.gCC.iterator();
            while (it.hasNext()) {
                c next = it.next();
                sb.append("[" + next.gCy).append(":").append(next.gCz + "] time:").append(f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, next.gCB / 1000)).append(APLogFileUtil.SEPARATOR_LOG);
            }
            if (Nf.size() > 0) {
                Log.i("MicroMsg.GetChatroomMsgChecker", "[checkDirtyBlock] ret:" + eit.b(aEh) + " result:" + sb.toString());
            }
            com.tencent.mm.ui.chatting.l.c cVar2 = com.tencent.mm.ui.chatting.l.c.PEZ;
            com.tencent.mm.ui.chatting.l.c.aU(str, Nf.size(), aEh.field_seqBlockInfo.gCC.size());
        }
        AppMethodBeat.o(20489);
    }
}
