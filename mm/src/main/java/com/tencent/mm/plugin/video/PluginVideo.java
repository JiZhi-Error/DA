package com.tencent.mm.plugin.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.video.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;

public class PluginVideo extends f implements a {
    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-video";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(176825);
        if (gVar.aBb()) {
            y.at("video", "video", 19);
        }
        AppMethodBeat.o(176825);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(127139);
        Log.i("MicroMsg.PluginVideo", "plugin video execute");
        if (gVar.aBb()) {
            pin(new com.tencent.mm.model.y(o.class));
            pin(new com.tencent.mm.model.y(e.class));
            pin(new com.tencent.mm.model.y(n.class));
        }
        AppMethodBeat.o(127139);
    }
}
