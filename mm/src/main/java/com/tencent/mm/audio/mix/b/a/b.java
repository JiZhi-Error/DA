package com.tencent.mm.audio.mix.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.f;
import com.tencent.mm.audio.mix.i.a;
import java.util.ArrayList;

public final class b implements f {
    private String appId;

    public b(String str) {
        this.appId = str;
    }

    @Override // com.tencent.mm.audio.mix.b.a.f
    public final void YC() {
        AppMethodBeat.i(136750);
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "runTask, appId:%s", this.appId);
        f.YL().clearCache();
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "delete all pcm cache File");
        ArrayList<String> YN = f.YL().YN();
        if (YN.size() > 0) {
            a.c(this.appId, YN);
        }
        AppMethodBeat.o(136750);
    }

    @Override // com.tencent.mm.audio.mix.b.a.f
    public final void end() {
        AppMethodBeat.i(136751);
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "end task");
        AppMethodBeat.o(136751);
    }
}
