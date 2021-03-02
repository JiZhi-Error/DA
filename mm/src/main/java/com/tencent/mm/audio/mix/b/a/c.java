package com.tencent.mm.audio.mix.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import com.tencent.mm.audio.mix.b.f;
import com.tencent.mm.audio.mix.i.a;
import com.tencent.mm.audio.mix.i.b;
import java.util.ArrayList;
import java.util.Iterator;

public final class c implements f {
    private String appId;

    public c(String str) {
        this.appId = str;
    }

    @Override // com.tencent.mm.audio.mix.b.a.f
    public final void YC() {
        AppMethodBeat.i(136752);
        b.i("MicroMsg.Mix.AudioPcmDataTrackRecycleCacheTask", "runTask, appId:%s", this.appId);
        f YL = f.YL();
        synchronized (YL.dup) {
            try {
                Iterator<String> it = YL.duo.iterator();
                while (it.hasNext()) {
                    d dVar = YL.cache.get(it.next());
                    if (dVar != null) {
                        dVar.recycle();
                    }
                }
                YL.duo.clear();
                YL.cache.clear();
            } finally {
                AppMethodBeat.o(136752);
            }
        }
        b.i("MicroMsg.Mix.AudioPcmDataTrackRecycleCacheTask", "delete all pcm cache File");
        ArrayList<String> YN = f.YL().YN();
        if (YN.size() > 0) {
            a.c(this.appId, YN);
        }
    }

    @Override // com.tencent.mm.audio.mix.b.a.f
    public final void end() {
        AppMethodBeat.i(136753);
        b.i("MicroMsg.Mix.AudioPcmDataTrackRecycleCacheTask", "end task");
        AppMethodBeat.o(136753);
    }
}
