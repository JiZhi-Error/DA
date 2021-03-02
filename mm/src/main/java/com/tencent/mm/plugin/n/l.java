package com.tencent.mm.plugin.n;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;

public final class l extends i {
    private long dyM = 0;
    float mwH = 1.0f;
    Surface surface;
    private int videoHeight;
    private int videoWidth;
    boolean zsm = false;
    private boolean zsn = false;
    boolean zso = false;
    long zsp = -1;

    public l(h hVar, MMHandler mMHandler) {
        super(hVar, mMHandler);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.n.i
    public final boolean a(long j2, long j3, z zVar, ByteBuffer byteBuffer, int i2, MediaCodec.BufferInfo bufferInfo) {
        boolean z;
        AppMethodBeat.i(133954);
        Object[] objArr = new Object[8];
        objArr[0] = info();
        objArr[1] = Integer.valueOf(this.state);
        objArr[2] = Long.valueOf(j2);
        objArr[3] = Long.valueOf(j3);
        objArr[4] = Integer.valueOf(i2);
        objArr[5] = Long.valueOf(bufferInfo.presentationTimeUs);
        objArr[6] = Boolean.valueOf((bufferInfo.flags & 1) != 0);
        objArr[7] = Integer.valueOf(bufferInfo.flags);
        Log.d("MicroMsg.VideoTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d, pts:%s, keyframe:%s, flags:%s", objArr);
        if (e.Qz(this.state)) {
            Log.i("MicroMsg.VideoTrackDataSource", "%s video track flush surface", info());
            zVar.releaseOutputBuffer(i2, true);
            setState(4);
            AppMethodBeat.o(133954);
            return true;
        } else if (e.Qy(this.state)) {
            long j4 = bufferInfo.presentationTimeUs / 1000;
            long j5 = j2 - j4;
            Log.d("MicroMsg.VideoTrackDataSource", "%s start to handle precision seek[%d, %d] diff[%d]", info(), Long.valueOf(j4), Long.valueOf(j2), Long.valueOf(j5));
            if (j5 <= 30) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i("MicroMsg.VideoTrackDataSource", "%s precision seek done to surface", info());
                zVar.releaseOutputBuffer(i2, true);
                if (this.zsn) {
                    setState(7);
                    this.zsn = false;
                }
                this.zsn = true;
            } else {
                zVar.releaseOutputBuffer(i2, false);
            }
            AppMethodBeat.o(133954);
            return true;
        } else if (!e.QA(this.state)) {
            Log.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", info(), Integer.valueOf(this.state));
            AppMethodBeat.o(133954);
            return false;
        } else {
            long j6 = bufferInfo.presentationTimeUs / 1000;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j7 = elapsedRealtime - j3;
            long j8 = (long) (((((float) j6) / this.mwH) - ((float) j2)) - ((float) j7));
            Log.d("MicroMsg.VideoTrackDataSource", "%s earlyMs[%d] time[%d, %d, %d] sample[%d %d]", info(), Long.valueOf(j8), Long.valueOf(j7), Long.valueOf(elapsedRealtime), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j6));
            if (j8 < -30) {
                Log.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too late to show video frame. throw now", info());
                zVar.releaseOutputBuffer(i2, false);
                this.zrC.zrw = 0;
                AppMethodBeat.o(133954);
                return true;
            } else if (j8 < 30) {
                this.zrC.zrt = bufferInfo.presentationTimeUs;
                if (j8 > 11) {
                    try {
                        Thread.sleep(j8 - 10);
                    } catch (Exception e2) {
                    }
                }
                if (!e.QA(this.state)) {
                    Log.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", info(), Integer.valueOf(this.state));
                    AppMethodBeat.o(133954);
                    return false;
                }
                if (Math.abs(j6 - this.dyM) > 1000 || this.dyM <= 0) {
                    Log.i("MicroMsg.VideoTrackDataSource", "%s finish to process index[%d] time[%d] to surface", info(), Integer.valueOf(i2), Long.valueOf(j6));
                    this.dyM = j6;
                }
                zVar.releaseOutputBuffer(i2, true);
                AppMethodBeat.o(133954);
                return true;
            } else {
                Log.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too early now do nothing.", info());
                AppMethodBeat.o(133954);
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.n.i
    public final String type() {
        return "video";
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.n.i
    public final boolean a(z zVar) {
        AppMethodBeat.i(133955);
        if (zVar == null) {
            AppMethodBeat.o(133955);
        } else {
            if (this.surface == null) {
                Log.w("MicroMsg.VideoTrackDataSource", "%s decoder configure surface but surface is null.", info());
                this.zsm = false;
            } else {
                this.zsm = true;
            }
            Log.i("MicroMsg.VideoTrackDataSource", "%s handleDecoderBeforeStart", info());
            Log.i("MicroMsg.VideoTrackDataSource", "%s before prepare init decoder, surface valid: %s", info(), Boolean.valueOf(this.surface.isValid()));
            zVar.a(ejl(), this.surface, 0);
            this.dyM = 0;
            AppMethodBeat.o(133955);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(23)
    public final void ejp() {
        AppMethodBeat.i(133956);
        try {
            if (this.iec != null) {
                z zVar = this.iec;
                Surface surface2 = this.surface;
                try {
                    MediaCodecProxyUtils.b.oA(81);
                    zVar.gJE.setOutputSurface(surface2);
                    MediaCodecProxyUtils.b.oA(82);
                    AppMethodBeat.o(133956);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.MediaCodecProxy", e2, "MediaCodecProxy setOutputSurface", new Object[0]);
                    z.a(34, e2, zVar.gJF);
                    AppMethodBeat.o(133956);
                    throw e2;
                }
            } else {
                AppMethodBeat.o(133956);
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.VideoTrackDataSource", e3, "%s change surface23 error [%s]", info(), e3.toString());
            ejq();
            AppMethodBeat.o(133956);
        }
    }

    /* access modifiers changed from: package-private */
    public final void ejq() {
        AppMethodBeat.i(133957);
        Log.i("MicroMsg.VideoTrackDataSource", "%s change surface below 23", info());
        if (this.iec != null) {
            releaseDecoder();
            aa(this.zrC.zrt, -1);
            ejk();
        }
        AppMethodBeat.o(133957);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.n.i
    public final void b(MediaFormat mediaFormat, String str, int i2) {
        int mp4RotateVFS;
        boolean z;
        AppMethodBeat.i(133958);
        super.b(mediaFormat, str, i2);
        this.videoHeight = mediaFormat.getInteger("height");
        this.videoWidth = mediaFormat.getInteger("width");
        if (mediaFormat.containsKey("rotation-degrees")) {
            mp4RotateVFS = mediaFormat.getInteger("rotation-degrees");
            z = true;
        } else {
            mp4RotateVFS = SightVideoJNI.getMp4RotateVFS(this.path);
            Log.w("MicroMsg.VideoTrackDataSource", "%s it don't contains rotation key. degrees [%d]", info(), Integer.valueOf(mp4RotateVFS));
            z = false;
        }
        if (Math.abs(mp4RotateVFS) == 90 || Math.abs(mp4RotateVFS) == 270) {
            int i3 = this.videoWidth;
            this.videoWidth = this.videoHeight;
            this.videoHeight = i3;
        }
        if (z) {
            mp4RotateVFS = 0;
        }
        this.zrD.obtainMessage(4, this.videoWidth, this.videoHeight, Integer.valueOf(mp4RotateVFS)).sendToTarget();
        Log.i("MicroMsg.VideoTrackDataSource", "%s video size[%d, %d] degrees[%d]", info(), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(mp4RotateVFS));
        AppMethodBeat.o(133958);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.n.i
    public final boolean as(int i2, long j2) {
        AppMethodBeat.i(133959);
        Log.d("MicroMsg.VideoTrackDataSource", "%s reset extractor flag[%d] needReset[%b]", info(), Integer.valueOf(i2), Boolean.valueOf(this.zrC.rsr));
        if (!this.zrC.rsr || i2 != 1 || this.zsp == j2) {
            AppMethodBeat.o(133959);
            return false;
        }
        boolean aa = aa(j2, -1);
        this.zsp = j2;
        AppMethodBeat.o(133959);
        return aa;
    }
}
