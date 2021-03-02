package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class h implements f.b {
    @Override // com.tencent.mm.model.f.b
    public final String getSubType() {
        return "qy_revoke_msg";
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        AppMethodBeat.i(20316);
        String str2 = map.get(".sysmsg.brand_username");
        String str3 = map.get(".sysmsg.replacemsg");
        bg.aVF();
        LinkedList<ca> iJ = c.aSQ().iJ(str2, map.get(".sysmsg.revoke_climsgid"));
        if (iJ == null || iJ.isEmpty()) {
            AppMethodBeat.o(20316);
        } else {
            Iterator<ca> it = iJ.iterator();
            while (it.hasNext()) {
                final ca next = it.next();
                if ((next.fqJ & 4) != 4) {
                    next.setContent(str3);
                    next.setType(10000);
                    bp.a(next, aVar);
                    bg.aVF();
                    c.aSQ().a(next.field_msgId, next);
                }
                bg.aVF();
                az bjY = c.aST().bjY(str2);
                if (bjY != null && bjY.field_unReadCount > 0) {
                    bg.aVF();
                    if (bjY.field_unReadCount >= c.aSQ().aB(next)) {
                        bjY.nt(bjY.field_unReadCount - 1);
                        bg.aVF();
                        c.aST().a(bjY, bjY.field_username);
                    }
                }
                if (next != null) {
                    g.aAk().postToWorker(new Runnable() {
                        /* class com.tencent.mm.model.h.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(231537);
                            Log.i("MicroMsg.BizChatSysCmdMsgConsumerHandleRevokeMsg", "[deleteLocalFile] id:%s type:%s", Long.valueOf(next.field_msgId), Integer.valueOf(next.getType()));
                            switch (next.getType()) {
                                case 3:
                                case 34:
                                case 43:
                                case 44:
                                case 49:
                                case 62:
                                case 268435505:
                                    bp.z(next);
                                    break;
                            }
                            AppMethodBeat.o(231537);
                        }
                    });
                }
            }
            AppMethodBeat.o(20316);
        }
        return null;
    }
}
