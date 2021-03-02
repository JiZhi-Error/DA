package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/FpsCounter;", "", "()V", "frames", "", "getFrames", "()I", "setFrames", "(I)V", "lastTick", "", "getLastTick", "()J", "setLastTick", "(J)V", "addFrame", "", "getFps", "reset", "plugin-vlog_release"})
public final class n {
    public int frames;
    public long jkM;

    public final void reset() {
        this.jkM = 0;
        this.frames = 0;
    }

    public final int getFps() {
        AppMethodBeat.i(190581);
        if (this.frames == 0) {
            AppMethodBeat.o(190581);
            return 0;
        }
        int ticksToNow = (int) (((long) (this.frames * 1000)) / Util.ticksToNow(this.jkM));
        AppMethodBeat.o(190581);
        return ticksToNow;
    }
}
