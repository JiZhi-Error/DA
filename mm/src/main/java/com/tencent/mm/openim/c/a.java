package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class a implements q {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.q
    public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
        AppMethodBeat.i(151260);
        Log.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "onNewXmlReceived() ");
        if (map != null) {
            de deVar = aVar.heO;
            if (Util.isEqual(deVar.xKb, 10002)) {
                String a2 = z.a(deVar.KHn);
                if (Util.isNullOrNil(a2)) {
                    Log.w("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "msg content is null");
                    AppMethodBeat.o(151260);
                    return;
                }
                String a3 = z.a(deVar.KHl);
                ca aJ = ((l) g.af(l.class)).eiy().aJ(a3, deVar.Brn);
                boolean z = false;
                if (aJ.field_msgId > 0) {
                    z = true;
                }
                aJ.yF(deVar.Brn);
                aJ.setCreateTime(bp.C(a3, (long) deVar.CreateTime));
                aJ.setType(10002);
                aJ.setContent(a2);
                aJ.nv(0);
                aJ.Cy(a3);
                aJ.BB(deVar.KHq);
                aJ.gDN();
                bp.a(aJ, aVar);
                if (!z) {
                    bp.x(aJ);
                    AppMethodBeat.o(151260);
                    return;
                }
                ((l) g.af(l.class)).eiy().b(deVar.Brn, aJ);
                AppMethodBeat.o(151260);
                return;
            }
            Log.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "not new xml type:%d ", Integer.valueOf(deVar.xKb));
        }
        AppMethodBeat.o(151260);
    }
}
