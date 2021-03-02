package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaRecorder;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.i.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class i implements c {
    private int audioBitrate;
    private int audioChannelCount;
    private int audioSampleRate;
    c.a zvM;
    private MMHandler zvS = new MMHandler() {
        /* class com.tencent.mm.plugin.mmsight.model.a.i.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(89495);
            if (i.this.zvM != null) {
                i.this.zvM.aQY();
                i.this.zvM = null;
            }
            AppMethodBeat.o(89495);
        }
    };
    private MediaRecorder zwf;
    private boolean zwg = false;

    public i(int i2, int i3, int i4) {
        AppMethodBeat.i(89496);
        this.audioSampleRate = i2;
        this.audioBitrate = i3;
        this.audioChannelCount = i4;
        if (this.audioChannelCount <= 0) {
            this.audioChannelCount = 1;
        }
        Log.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder, sampleRate: %s, bitrate: %s, audioChannelCount: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(89496);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final void rA(int i2) {
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final int H(int i2, String str) {
        AppMethodBeat.i(89497);
        Log.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder init tempPath[%s], sampleRate[%d]", str, Integer.valueOf(this.audioSampleRate));
        this.zwf = new e();
        this.zwf.setAudioSource(1);
        this.zwf.setOutputFormat(2);
        this.zwf.setAudioEncoder(3);
        this.zwf.setAudioChannels(this.audioChannelCount);
        this.zwf.setAudioEncodingBitRate(this.audioBitrate);
        this.zwf.setAudioSamplingRate(this.audioSampleRate);
        this.zwf.setOutputFile(str);
        try {
            this.zwf.prepare();
            AppMethodBeat.o(89497);
            return 0;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e2, "mediaRecorder prepare error: %s", e2.getMessage());
            AppMethodBeat.o(89497);
            return -1;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final int a(c.a aVar) {
        AppMethodBeat.i(89498);
        Log.i("MicroMsg.MMSightAACMediaRecorder", "start, onPcmReady: %s", aVar);
        this.zvM = aVar;
        try {
            if (this.zwf != null && !this.zwg) {
                this.zwf.start();
            }
            this.zvS.sendEmptyMessage(0);
            AppMethodBeat.o(89498);
            return 0;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e2, "start record aac.mp4 error:%s", e2.getMessage());
            this.zvS.sendEmptyMessage(0);
            AppMethodBeat.o(89498);
            return -1;
        } catch (Throwable th) {
            this.zvS.sendEmptyMessage(0);
            AppMethodBeat.o(89498);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final int a(c.b bVar) {
        AppMethodBeat.i(89499);
        Log.i("MicroMsg.MMSightAACMediaRecorder", "stop, mediaRecorder: %s, callback: %s", this.zwf, bVar);
        if (this.zwf == null) {
            if (bVar != null) {
                bVar.aQX();
            }
            AppMethodBeat.o(89499);
            return 0;
        }
        try {
            if (!this.zwg) {
                this.zwf.stop();
                this.zwf.release();
            }
            this.zwf = null;
            if (bVar != null) {
                bVar.aQX();
            }
            AppMethodBeat.o(89499);
            return 0;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e2, "stop record aac.mp4 error:%s", e2.getMessage());
            AppMethodBeat.o(89499);
            return -1;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final void clear() {
        AppMethodBeat.i(89500);
        try {
            if (this.zwf != null) {
                if (!this.zwg) {
                    this.zwf.stop();
                    this.zwf.release();
                }
                this.zwf = null;
            }
            AppMethodBeat.o(89500);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e2, "clear error: %s", e2.getMessage());
            AppMethodBeat.o(89500);
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final void ejW() {
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final void pause() {
        AppMethodBeat.i(89501);
        if (d.oD(24)) {
            this.zwf.pause();
        }
        AppMethodBeat.o(89501);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final void resume() {
        AppMethodBeat.i(89502);
        if (d.oD(24)) {
            this.zwf.resume();
        }
        AppMethodBeat.o(89502);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final c.a ejX() {
        return null;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final void rc(boolean z) {
        this.zwg = z;
    }
}
