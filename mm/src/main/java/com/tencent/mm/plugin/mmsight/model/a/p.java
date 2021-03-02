package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

@TargetApi(18)
@Deprecated
public class p implements e {
    protected boolean isStart = false;
    protected MediaMuxer mediaMuxer;
    protected int zwv = -1;
    protected int zww = -1;
    protected boolean zwx = false;
    protected boolean zwy = false;
    protected long zwz = 0;

    public p(String str) {
        AppMethodBeat.i(241184);
        try {
            this.mediaMuxer = new MediaMuxer(str, 0);
            this.mediaMuxer.setOrientationHint(0);
            Log.d("MicroMsg.MMSightSystemMediaMuxer", "create muxer, orientation: %s, filename: %s", 0, str);
            AppMethodBeat.o(241184);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightSystemMediaMuxer", "new muxer error: %s", e2.getMessage());
            AppMethodBeat.o(241184);
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.e
    public final boolean ejY() {
        return false;
    }

    public final synchronized void g(MediaFormat mediaFormat) {
        AppMethodBeat.i(89573);
        try {
            if (this.mediaMuxer != null && this.zwv == -1) {
                this.zwv = this.mediaMuxer.addTrack(mediaFormat);
                Log.i("MicroMsg.MMSightSystemMediaMuxer", "addX264Track, x264TrackIndex: %s", Integer.valueOf(this.zwv));
                if (!(this.isStart || this.zwv == -1 || this.zww == -1)) {
                    Log.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
                    this.mediaMuxer.start();
                    this.isStart = true;
                }
            }
            AppMethodBeat.o(89573);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightSystemMediaMuxer", "addX264Track error: %s", e2.getMessage());
            AppMethodBeat.o(89573);
        }
    }

    public synchronized void f(MediaFormat mediaFormat) {
        AppMethodBeat.i(89574);
        try {
            if (this.mediaMuxer != null && this.zww == -1) {
                this.zww = this.mediaMuxer.addTrack(mediaFormat);
                Log.i("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", Integer.valueOf(this.zww));
                if (!(this.isStart || this.zww == -1 || this.zwv == -1)) {
                    Log.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
                    this.mediaMuxer.start();
                    this.isStart = true;
                }
            }
            AppMethodBeat.o(89574);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack error: %s", e2.getMessage());
            AppMethodBeat.o(89574);
        }
    }

    public final synchronized void j(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(89575);
        try {
            if (!(this.mediaMuxer == null || this.zww == -1 || !this.isStart || byteBuffer == null || bufferInfo == null)) {
                long j2 = bufferInfo.presentationTimeUs;
                bufferInfo.presentationTimeUs = (System.nanoTime() - this.zwz) / 1000;
                long currentTicks = Util.currentTicks();
                this.mediaMuxer.writeSampleData(this.zww, byteBuffer, bufferInfo);
                Log.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", Integer.valueOf(bufferInfo.size), Long.valueOf(Util.ticksToNow(currentTicks)), Long.valueOf(j2), Long.valueOf(bufferInfo.presentationTimeUs));
            }
            AppMethodBeat.o(89575);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData error: %s", e2.getMessage());
            AppMethodBeat.o(89575);
        }
    }

    public final synchronized void k(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(241185);
            try {
                if (!(this.mediaMuxer == null || this.zwv == -1 || !this.isStart)) {
                    boolean z2 = byteBuffer != null;
                    if (bufferInfo == null) {
                        z = false;
                    }
                    if (z && z2) {
                        long j2 = bufferInfo.presentationTimeUs;
                        bufferInfo.presentationTimeUs = (System.nanoTime() - this.zwz) / 1000;
                        bufferInfo.flags = 1;
                        long currentTicks = Util.currentTicks();
                        this.mediaMuxer.writeSampleData(this.zwv, byteBuffer, bufferInfo);
                        Log.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", Integer.valueOf(bufferInfo.size), Long.valueOf(Util.ticksToNow(currentTicks)), Long.valueOf(j2), Long.valueOf(bufferInfo.presentationTimeUs));
                    }
                }
                AppMethodBeat.o(241185);
            } catch (Exception e2) {
                Log.e("MicroMsg.MMSightSystemMediaMuxer", "writeX264SampleData error: %s", e2.getMessage());
                AppMethodBeat.o(241185);
            }
        }
    }

    public final long ekh() {
        return this.zwz;
    }

    public final void eki() {
        AppMethodBeat.i(241186);
        this.zwz = System.nanoTime();
        AppMethodBeat.o(241186);
    }

    public final boolean ekj() {
        return this.isStart;
    }

    public final synchronized void finish() {
        AppMethodBeat.i(241187);
        try {
            Log.i("MicroMsg.MMSightSystemMediaMuxer", "finish");
            this.isStart = false;
            if (this.mediaMuxer != null) {
                this.mediaMuxer.stop();
                this.mediaMuxer.release();
            }
            AppMethodBeat.o(241187);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightSystemMediaMuxer", "stop error: %s", e2.getMessage());
            AppMethodBeat.o(241187);
        }
    }
}
