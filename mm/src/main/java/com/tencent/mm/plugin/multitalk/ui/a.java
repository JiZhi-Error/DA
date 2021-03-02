package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.List;

public final class a extends q {
    private String chatroomName;
    private List<String> jWf;

    public a(n nVar, String str) {
        super(nVar, null, true, true);
        AppMethodBeat.i(114707);
        this.chatroomName = str;
        and();
        AppMethodBeat.o(114707);
    }

    @Override // com.tencent.mm.ui.contact.q
    public final void and() {
        AppMethodBeat.i(114708);
        Log.i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
        this.jWf = ((c) g.af(c.class)).aSX().Kh(this.chatroomName);
        if (this.jWf == null) {
            this.jWf = new ArrayList();
        }
        AppMethodBeat.o(114708);
    }

    @Override // com.tencent.mm.ui.contact.p
    public final com.tencent.mm.ui.contact.a.a va(int i2) {
        AppMethodBeat.i(114709);
        as Kn = ((l) g.af(l.class)).aSN().Kn(this.jWf.get(i2));
        e eVar = new e(i2);
        eVar.contact = Kn;
        eVar.PWh = eWh();
        AppMethodBeat.o(114709);
        return eVar;
    }

    public final int getCount() {
        AppMethodBeat.i(114710);
        int size = this.jWf.size();
        AppMethodBeat.o(114710);
        return size;
    }
}
