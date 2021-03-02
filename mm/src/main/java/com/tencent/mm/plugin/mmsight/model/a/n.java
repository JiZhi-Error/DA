package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class n implements e {
    private int audioSampleRate;
    private int bitrate;
    private int bufId;
    private float cKu;
    private boolean iiC;
    private boolean iiD;
    private boolean isb;
    private int videoDuration;
    private String zwo;

    public n(int i2, String str, float f2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(89539);
        this.bufId = i2;
        this.zwo = str;
        this.cKu = f2;
        this.bitrate = i3;
        this.videoDuration = i4;
        this.audioSampleRate = i5;
        this.isb = z;
        this.iiC = z2;
        this.iiD = z3;
        Log.i("MicroMsg.MMSightMP4Muxer", "create MMSightMP4Muxer, bufId: %s, recordPath: %s, fps: %s, bitrate: %s, videoDuration: %s, audioSampleRate%s, mute: %s, useSoftEncode:%s, enableHevc:%s", Integer.valueOf(i2), str, Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
        AppMethodBeat.o(89539);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.e
    public final boolean ejY() {
        String str;
        AppMethodBeat.i(89540);
        long currentTicks = Util.currentTicks();
        new o(this.zwo).heq().mkdirs();
        String aNv = e.aNv(this.zwo);
        try {
            if (!s.YS(aNv)) {
                aNv = null;
            }
            str = aNv;
        } catch (Exception e2) {
            str = null;
        }
        Log.i("MicroMsg.MMSightMP4Muxer", "start mux, bufId: %s, aacFile: %s", Integer.valueOf(this.bufId), str);
        int muxingLock = SightVideoJNI.muxingLock(this.bufId, str, this.audioSampleRate, 1024, 2, 1, 0, this.zwo, this.cKu, Math.max(1000, this.videoDuration), this.bitrate, c.Dma, 8, 2, 23.0f, null, 0, false, this.isb, this.iiC, this.iiD, b.ak(this.iiC, this.iiD));
        Log.i("MicroMsg.MMSightMP4Muxer", "mux sight end, duration %ds, used %sms", Integer.valueOf(muxingLock), Long.valueOf(Util.ticksToNow(currentTicks)));
        if (!Util.isNullOrNil(str)) {
            try {
                s.deleteFile(str);
            } catch (Exception e3) {
            }
        }
        if (muxingLock >= 0) {
            AppMethodBeat.o(89540);
            return true;
        }
        AppMethodBeat.o(89540);
        return false;
    }
}
