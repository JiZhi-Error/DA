package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class b implements p {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        AppMethodBeat.i(223647);
        Log.d("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "consumeNewXml subType:%s", Util.nullAs(str, ""));
        if (Util.nullAsNil(str).equals("SendMsgFailed") && map != null) {
            try {
                String trim = Util.nullAsNil(map.get(".sysmsg.SendMsgFailed.newmsgid")).trim();
                String trim2 = Util.nullAsNil(map.get(".sysmsg.SendMsgFailed.tousername")).trim();
                Log.i("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "msgId:%s toUsername:%s", trim, trim2);
                ca aJ = ((l) g.af(l.class)).eiy().aJ(trim2, Util.safeParseLong(trim));
                aJ.setStatus(5);
                ((l) g.af(l.class)).eiy().a(aJ.field_msgId, aJ);
            } catch (Exception e2) {
                Log.e("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "consumeNewXml Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            }
        }
        AppMethodBeat.o(223647);
        return null;
    }
}
