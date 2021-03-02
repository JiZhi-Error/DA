package com.tencent.mm.plugin.thumbplayer.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000203J\u0006\u00105\u001a\u000203J\u0006\u00106\u001a\u000203J\b\u00107\u001a\u00020\u0017H\u0016J\u0006\u00108\u001a\u000203J\u0006\u00109\u001a\u000203R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001a\u0010\u001f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001a\u0010\"\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001a\u0010%\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\u001a\u0010(\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R\u001a\u0010+\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u000e\u0010.\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000f\"\u0004\b1\u0010\u0011¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "", "()V", "errCode", "", "getErrCode", "()I", "setErrCode", "(I)V", "errType", "getErrType", "setErrType", "firstFrameCost", "", "getFirstFrameCost", "()J", "setFirstFrameCost", "(J)V", "hasError", "", "getHasError", "()Z", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "playTime", "getPlayTime", "setPlayTime", "renderPtsNegative", "getRenderPtsNegative", "setRenderPtsNegative", "renderPtsOutOfBound", "getRenderPtsOutOfBound", "setRenderPtsOutOfBound", "renderTime", "getRenderTime", "setRenderTime", "startTick", "getStartTick", "setStartTick", "waitCount", "getWaitCount", "setWaitCount", "waitStartTick", "waitTimeSum", "getWaitTimeSum", "setWaitTimeSum", "firstFrameRendered", "", "reset", "start", "stop", "toString", "waitEnd", "waitStart", "plugin-thumbplayer_release"})
public final class b {
    public long VfA;
    int VfB;
    int VfC;
    int VfD;
    public long Vfx;
    public int Vfy;
    public long Vfz;
    public int errCode = 1000;
    public int errType;
    public long gXF;
    private String id = "";
    long vgo;

    public final boolean hXC() {
        return this.errCode != 1000;
    }

    public final void stop() {
        AppMethodBeat.i(260000);
        this.vgo = Util.ticksToNow(this.gXF);
        AppMethodBeat.o(260000);
    }

    public final String toString() {
        AppMethodBeat.i(260001);
        String str = "start:" + this.gXF + ", stop:" + this.vgo + ", firstFrame:" + this.Vfx + "; wait:" + this.Vfy + ",cost:" + this.Vfz;
        AppMethodBeat.o(260001);
        return str;
    }
}
