package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b implements e {
    private long endTimeMs;
    private int frameCount = 0;
    private boolean iTN = false;
    private int ies;
    private String jtX;
    private long startTimeMs;
    private e.a zxX;
    private byte[] zxb = null;

    @Override // com.tencent.mm.plugin.mmsight.segment.e
    public final int n(String str, long j2, long j3) {
        AppMethodBeat.i(107604);
        Log.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s", str, Long.valueOf(j2), Long.valueOf(j3));
        this.jtX = str;
        this.startTimeMs = j2;
        this.endTimeMs = j3;
        if (!Util.isNullOrNil(str)) {
            long currentTicks = Util.currentTicks();
            int ffmpegOpenAndSeekFileVFS = MP4MuxerJNI.ffmpegOpenAndSeekFileVFS(str, ((double) j2) * 1000.0d, ((double) j3) * 1000.0d);
            Log.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
            AppMethodBeat.o(107604);
            return ffmpegOpenAndSeekFileVFS;
        }
        AppMethodBeat.o(107604);
        return -1;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.e
    public final void J(Runnable runnable) {
        AppMethodBeat.i(107605);
        Log.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
        this.iTN = true;
        this.frameCount = 0;
        while (this.iTN) {
            long currentTicks = Util.currentTicks();
            this.zxb = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.zxb);
            Log.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
            boolean ffmpegCheckIfReachEndTimestamp = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
            if (this.zxb == null || ffmpegCheckIfReachEndTimestamp) {
                Log.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", Boolean.valueOf(ffmpegCheckIfReachEndTimestamp));
                this.iTN = false;
                runnable.run();
                AppMethodBeat.o(107605);
                return;
            }
            this.frameCount++;
            if ((this.ies <= 1 || this.frameCount % this.ies != 0) && this.zxX != null) {
                this.zxX.bJ(this.zxb);
            }
        }
        AppMethodBeat.o(107605);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.e
    public final void a(e.a aVar) {
        this.zxX = aVar;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.e
    public final Point bhJ() {
        AppMethodBeat.i(107606);
        Point point = new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
        AppMethodBeat.o(107606);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.e
    public final void stop() {
        AppMethodBeat.i(107607);
        Log.i("MicroMsg.FFMpegTranscodeDecoder", "stop, start: %s", Boolean.valueOf(this.iTN));
        this.iTN = false;
        AppMethodBeat.o(107607);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.e
    public final int bhK() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.e
    public final void uf(int i2) {
        AppMethodBeat.i(107608);
        Log.i("MicroMsg.FFMpegTranscodeDecoder", "setFrameDropInterval: %s", Integer.valueOf(i2));
        this.ies = i2;
        AppMethodBeat.o(107608);
    }
}
