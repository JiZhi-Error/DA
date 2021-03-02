package com.tencent.mm.plugin.music.e;

import android.media.AudioTrack;
import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.b.k;

public final class l extends j {
    @Override // com.tencent.mm.plugin.music.e.j, com.tencent.mm.plugin.music.e.b
    public final MediaPlayer etV() {
        AppMethodBeat.i(62962);
        k kVar = new k();
        AppMethodBeat.o(62962);
        return kVar;
    }

    @Override // com.tencent.mm.plugin.music.e.j, com.tencent.mm.plugin.music.e.b
    public final AudioTrack as(int i2, int i3, int i4) {
        AppMethodBeat.i(62963);
        e eVar = new e(3, i2, i3, i4);
        AppMethodBeat.o(62963);
        return eVar;
    }
}
