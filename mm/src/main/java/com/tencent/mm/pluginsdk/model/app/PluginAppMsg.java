package com.tencent.mm.pluginsdk.model.app;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vfs.y;

public class PluginAppMsg extends f implements w {
    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(169778);
        if (gVar.aBb()) {
            y.at(MessengerShareContentUtility.ATTACHMENT, MessengerShareContentUtility.ATTACHMENT, 19);
            y.at("Download", "Download", 23);
        }
        AppMethodBeat.o(169778);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-appmsg";
    }
}
