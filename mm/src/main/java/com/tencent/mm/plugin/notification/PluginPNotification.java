package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.notification.d.a;
import com.tencent.mm.vfs.y;

public class PluginPNotification extends f implements a {
    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(231767);
        y.at("FailMsgFileCache", "FailMsgFileCache", 7);
        AppMethodBeat.o(231767);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(231768);
        if (gVar.aBb()) {
            pin(a.eyT());
        }
        AppMethodBeat.o(231768);
    }
}
