package com.tencent.mm.openim.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class c extends a {
    public String jHv = null;
    public String jHw = null;

    public c(Map<String, String> map, ca caVar) {
        super(map, caVar);
    }

    @Override // com.tencent.mm.az.a
    public final boolean aTA() {
        AppMethodBeat.i(151264);
        if (this.values == null) {
            Log.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.o(151264);
            return false;
        }
        Log.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] type:%s, values size:%s", Util.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (Util.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved")) {
            Log.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] type err :%s", Util.nullAsNil(this.TYPE));
            AppMethodBeat.o(151264);
            return false;
        }
        if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.approver_username")) {
            this.jHv = Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.approver_username"));
        }
        if (this.values.containsKey(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.application_climsgid")) {
            this.jHw = Util.nullAsNil((String) this.values.get(".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.application_climsgid"));
        }
        AppMethodBeat.o(151264);
        return true;
    }
}
