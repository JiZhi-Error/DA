package com.tencent.mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.h;
import com.tencent.mm.g.a.la;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.chatroom.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginChatroom extends f implements c, d {
    private h qne = new h();
    private IListener qnf = new IListener<la>() {
        /* class com.tencent.mm.plugin.chatroom.PluginChatroom.AnonymousClass1 */

        {
            AppMethodBeat.i(194531);
            this.__eventId = la.class.getName().hashCode();
            AppMethodBeat.o(194531);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(la laVar) {
            AppMethodBeat.i(194532);
            if (laVar.dQf.dOz) {
                v.fr(true);
            }
            AppMethodBeat.o(194532);
            return false;
        }
    };

    public PluginChatroom() {
        AppMethodBeat.i(184640);
        AppMethodBeat.o(184640);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-chatroom";
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(101789);
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.b(b.class, new w());
        }
        AppMethodBeat.o(101789);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(184641);
        Log.d("MicroMsg.PluginChatroom", "onAccountInitialized");
        this.qnf.alive();
        v.fr(false);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("NewXmlUpgradeAssociateChatRoom", this.qne);
        AppMethodBeat.o(184641);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(184642);
        Log.d("MicroMsg.PluginChatroom", "onAccountRelease");
        this.qnf.dead();
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("NewXmlUpgradeAssociateChatRoom", this.qne);
        AppMethodBeat.o(184642);
    }
}
