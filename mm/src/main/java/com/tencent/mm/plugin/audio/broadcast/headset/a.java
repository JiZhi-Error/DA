package com.tencent.mm.plugin.audio.broadcast.headset;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/audio/broadcast/headset/HeadsetPlugMgr;", "", "()V", "onHeadsetPlugStateUpdate", "", "isConnected", "", "plugin-audio_release"})
public final class a {
    public static final a oHK = new a();

    static {
        AppMethodBeat.i(223949);
        AppMethodBeat.o(223949);
    }

    private a() {
    }

    public static final void jo(boolean z) {
        AppMethodBeat.i(223948);
        if (z) {
            a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
            a.C0831a.cea().iY(8);
            AppMethodBeat.o(223948);
            return;
        }
        a.C0831a aVar2 = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.cea().iY(9);
        AppMethodBeat.o(223948);
    }
}
