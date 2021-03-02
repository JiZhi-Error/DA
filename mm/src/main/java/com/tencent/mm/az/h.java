package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class h implements p {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        AppMethodBeat.i(184639);
        Log.d("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "consumeNewXml， subType:%s", Util.nullAs(str, ""));
        if (Util.nullAsNil(str).equals("NewXmlUpgradeAssociateChatRoom") && map != null) {
            if (map.containsKey(".sysmsg.NewXmlUpgradeAssociateChatRoom.text")) {
                String nullAsNil = Util.nullAsNil(map.get(".sysmsg.NewXmlUpgradeAssociateChatRoom.text"));
                String nullAsNil2 = Util.nullAsNil(map.get(".sysmsg.NewXmlUpgradeAssociateChatRoom.roomname"));
                if (Util.isNullOrNil(nullAsNil) || Util.isNullOrNil(nullAsNil2)) {
                    Log.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "chatroom:%s text:%s ", Util.nullAs(nullAsNil2, ""), Util.secPrint(nullAsNil));
                } else {
                    ca caVar = new ca();
                    caVar.nv(0);
                    caVar.Cy(nullAsNil2);
                    caVar.setStatus(3);
                    caVar.setContent(nullAsNil);
                    caVar.setCreateTime(bp.C(nullAsNil2, System.currentTimeMillis() / 1000));
                    caVar.setType(10000);
                    caVar.setFlag(caVar.field_flag | 8);
                    Log.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "chatroom:%s text:%s msgId:%s", nullAsNil2, Util.secPrint(nullAsNil), Long.valueOf(bp.x(caVar)));
                }
            } else {
                Log.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "no contains text");
            }
        }
        AppMethodBeat.o(184639);
        return null;
    }
}
