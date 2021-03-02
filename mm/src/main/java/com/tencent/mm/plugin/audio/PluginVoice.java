package com.tencent.mm.plugin.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.plugin.audio.a.b;
import com.tencent.mm.vfs.y;

public class PluginVoice extends f implements b {
    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-voice";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(177451);
        if (gVar.aBb()) {
            y.at("voice", "voice", 19);
            y.at("voice2", "voice2", 19);
        }
        AppMethodBeat.o(177451);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(148651);
        if (gVar.aBb()) {
            pin(new com.tencent.mm.model.y(o.class));
        }
        AppMethodBeat.o(148651);
    }
}
