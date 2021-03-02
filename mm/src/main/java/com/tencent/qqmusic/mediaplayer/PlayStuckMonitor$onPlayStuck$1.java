package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
public final class PlayStuckMonitor$onPlayStuck$1 implements Runnable {
    final /* synthetic */ boolean $continuous;
    final /* synthetic */ long $decodeTime;
    final /* synthetic */ long $playTime;

    PlayStuckMonitor$onPlayStuck$1(long j2, long j3, boolean z) {
        this.$decodeTime = j2;
        this.$playTime = j3;
        this.$continuous = z;
    }

    public final void run() {
        AppMethodBeat.i(190290);
        PlayStuckMonitor.access$getMCallback$p(PlayStuckMonitor.INSTANCE).d(Long.valueOf(this.$decodeTime), Long.valueOf(this.$playTime), Boolean.valueOf(this.$continuous));
        AppMethodBeat.o(190290);
    }
}
