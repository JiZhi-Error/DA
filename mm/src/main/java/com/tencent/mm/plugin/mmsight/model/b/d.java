package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d implements a {
    private long endTimeMs;
    private int frameCount = 0;
    private boolean iTN = false;
    private int ies = 0;
    private String jtX;
    private long startTimeMs;
    private int videoFps;
    private h zxa;
    private byte[] zxb = null;
    private double zxc;

    @Override // com.tencent.mm.plugin.mmsight.model.b.a
    public final int e(String str, long j2, long j3, int i2) {
        AppMethodBeat.i(89616);
        Log.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s, videoFps: %s", str, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2));
        this.jtX = str;
        this.startTimeMs = j2;
        this.endTimeMs = j3;
        this.videoFps = i2;
        this.zxc = 1000.0d / ((double) i2);
        if (!Util.isNullOrNil(str)) {
            long currentTicks = Util.currentTicks();
            int ffmpegOpenAndSeekFileLock = MP4MuxerJNI.ffmpegOpenAndSeekFileLock(str, ((double) j2) * 1000.0d, ((double) j3) * 1000.0d);
            Log.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
            AppMethodBeat.o(89616);
            return ffmpegOpenAndSeekFileLock;
        }
        AppMethodBeat.o(89616);
        return -1;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.b.a
    public final void ekm() {
        AppMethodBeat.i(89617);
        Log.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
        this.iTN = true;
        this.frameCount = 0;
        while (this.iTN) {
            long currentTicks = Util.currentTicks();
            this.zxb = MP4MuxerJNI.ffmpegGetNextVideoFrameDataLock(this.zxb);
            Log.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
            boolean ffmpegCheckIfReachEndTimestampLock = MP4MuxerJNI.ffmpegCheckIfReachEndTimestampLock();
            this.frameCount++;
            if (this.ies <= 1 || this.frameCount % this.ies != 0) {
                if (this.zxa != null) {
                    this.zxa.a(this.zxb, this.zxb == null || ffmpegCheckIfReachEndTimestampLock, (long) (((double) this.frameCount) * this.zxc * 1000.0d));
                }
                if (this.zxb == null || ffmpegCheckIfReachEndTimestampLock) {
                    Log.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", Boolean.valueOf(ffmpegCheckIfReachEndTimestampLock));
                    Log.i("MicroMsg.FFMpegTranscodeDecoder", "decode finish, frame count: %s", Integer.valueOf(this.frameCount));
                    this.iTN = false;
                    AppMethodBeat.o(89617);
                    return;
                }
            }
        }
        AppMethodBeat.o(89617);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.b.a
    public final void a(h hVar) {
        this.zxa = hVar;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.b.a
    public final Point bhJ() {
        AppMethodBeat.i(89618);
        Point point = new Point(MP4MuxerJNI.ffmpegGetVideoWidthLock(), MP4MuxerJNI.ffmpegGetVideoHeightLock());
        AppMethodBeat.o(89618);
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.b.a
    public final void uf(int i2) {
        this.zxc = (double) i2;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.b.a
    public final int bhK() {
        return 2;
    }
}
