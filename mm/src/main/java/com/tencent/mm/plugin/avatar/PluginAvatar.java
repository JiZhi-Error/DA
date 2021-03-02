package com.tencent.mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vfs.y;
import com.tencent.thumbplayer.core.common.TPAudioFrame;

public class PluginAvatar extends f implements b {
    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(151429);
        y.a("avatar", "avatar", TPAudioFrame.TP_CH_STEREO_LEFT, 7776000000L, 65);
        AppMethodBeat.o(151429);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(151430);
        if (gVar.aBb()) {
            pin(c.ceE());
        }
        AppMethodBeat.o(151430);
    }
}
