package com.tencent.mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.c.a;
import com.tencent.mm.openim.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginOpenIMRoom extends f implements c {
    private a jHN = new a();
    private b jHO = new b();

    public PluginOpenIMRoom() {
        AppMethodBeat.i(151308);
        AppMethodBeat.o(151308);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(151309);
        Log.i("MicroMsg.PluginOpenIMRoom", "onAccountInitialized");
        com.tencent.mm.roomsdk.a.b.a("@im.chatroom", new a());
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.jHN);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.jHN);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("SendMsgFailed", this.jHO);
        AppMethodBeat.o(151309);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(151310);
        Log.i("MicroMsg.PluginOpenIMRoom", "onAccountRelease");
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.jHN);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.jHN);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("SendMsgFailed", this.jHO);
        AppMethodBeat.o(151310);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
    }
}
