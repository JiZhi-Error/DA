package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.model.a;
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.decoder.EncoderWriter;
import java.nio.ByteBuffer;

@TargetApi(16)
public class h implements c {
    private final int TIMEOUT_USEC = 10000;
    private int audioBitrate;
    private int audioChannelCount;
    int audioSampleRate;
    volatile c dyI = null;
    z ieT;
    final Object iff = new Object();
    private boolean ijm = false;
    private int jtk;
    private MediaFormat mAudioFormat;
    int ndx;
    volatile boolean pause = false;
    private long startTime = 0;
    private MediaCodec.BufferInfo zvE;
    long zvF = 0;
    int zvG;
    int zvH;
    long zvI;
    long zvJ;
    boolean zvK = false;
    private boolean zvL = false;
    public c.a zvM = null;
    p zvN;
    private final Object zvO = new Object();
    volatile boolean zvP = false;
    private volatile boolean zvQ = false;
    boolean zvR = true;
    MMHandler zvS = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.mmsight.model.a.h.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(89477);
            if (h.this.zvM != null) {
                h.this.zvM.aQY();
                h.this.zvM = null;
            }
            AppMethodBeat.o(89477);
        }
    };
    protected boolean zvT;
    boolean zvU;
    final Object zvV = new byte[0];
    c.b zvW;
    long zvX = 0;
    private long zvY = -1;
    boolean zvZ = false;
    MMHandler zwa;
    Runnable zwb = new Runnable() {
        /* class com.tencent.mm.plugin.mmsight.model.a.h.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(89478);
            if (h.this.dyI == null) {
                AppMethodBeat.o(89478);
                return;
            }
            h.this.zvZ = true;
            h.this.eka();
            AppMethodBeat.o(89478);
        }
    };
    long zwc = 0;
    private c.a zwd = new c.a() {
        /* class com.tencent.mm.plugin.mmsight.model.a.h.AnonymousClass3 */

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
            if (r8.zvP != false) goto L_0x0032;
         */
        @Override // com.tencent.mm.audio.b.c.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void w(byte[] r10, int r11) {
            /*
            // Method dump skipped, instructions count: 569
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.model.a.h.AnonymousClass3.w(byte[], int):void");
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void cj(int i2, int i3) {
            AppMethodBeat.i(89480);
            Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(89480);
        }
    };

    public h(int i2, int i3, int i4, p pVar, boolean z) {
        AppMethodBeat.i(241182);
        this.audioBitrate = i3;
        this.audioSampleRate = i2;
        this.audioChannelCount = i4;
        if (this.audioChannelCount <= 0) {
            this.audioChannelCount = 1;
        }
        this.zvN = pVar;
        this.zvR = ((b) g.af(b.class)).a(b.a.clicfg_ignore_mediacodec_lock, true);
        this.ijm = z;
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s, audioChannelCount:%s, isUseFFmpegMuxer:%s", Integer.valueOf(this.audioBitrate), Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.audioChannelCount), Boolean.valueOf(this.ijm));
        AppMethodBeat.o(241182);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final void pause() {
        AppMethodBeat.i(89483);
        this.zvK = false;
        this.pause = true;
        this.zvY = Util.currentTicks();
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "pause, time:%s", Long.valueOf(this.zvY));
        AppMethodBeat.o(89483);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final void resume() {
        AppMethodBeat.i(89484);
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "resume, pauseTime:%s", Long.valueOf(this.zvY));
        this.pause = false;
        if (this.zvY > 0) {
            this.zvX += Util.ticksToNow(this.zvY);
        }
        this.zvY = 0;
        this.zvK = true;
        AppMethodBeat.o(89484);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public void rA(int i2) {
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public int H(int i2, String str) {
        boolean z;
        AppMethodBeat.i(89485);
        if (!this.zvL && this.dyI != null) {
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.zvW == null);
            Log.e("MicroMsg.MMSightAACMediaCodecRecorder", "call init, before pcmRecorder stop, stopCallback null ? %B", objArr);
            this.dyI.ZZ();
        }
        if (this.ieT != null) {
            Object[] objArr2 = new Object[1];
            if (this.zvW == null) {
                z = true;
            } else {
                z = false;
            }
            objArr2[0] = Boolean.valueOf(z);
            Log.e("MicroMsg.MMSightAACMediaCodecRecorder", "call init, before audioEncoder stop, stopCallback null ? %B", objArr2);
            aMi();
            if (this.zvW != null) {
                this.zvW.aQX();
                this.zvW = null;
            }
        }
        this.ndx = 0;
        this.zvT = false;
        synchronized (this.zvV) {
            try {
                this.zvU = false;
                this.zvZ = false;
                this.zvW = null;
            } catch (Throwable th) {
                AppMethodBeat.o(89485);
                throw th;
            }
        }
        if (!this.zvL) {
            this.dyI = new com.tencent.mm.audio.b.c(this.audioSampleRate, this.audioChannelCount, 5);
            this.dyI.setAudioSource(1);
            this.dyI.jk(128);
            this.dyI.dc(true);
            this.dyI.dzv = this.zwd;
        }
        if (this.zwa == null) {
            Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "create pcm control handler");
            this.zwa = new MMHandler();
        } else if (this.zwa.getLooper() != Looper.myLooper()) {
            Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "error pcm control handler looper[%s, %s], recreate handler", this.zwa.getLooper(), Looper.myLooper());
            this.zwa = new MMHandler();
        }
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "sample rate %d, audio rate %d", Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.audioBitrate));
        try {
            this.zvE = new MediaCodec.BufferInfo();
            this.mAudioFormat = new MediaFormat();
            this.mAudioFormat.setString("mime", EncoderWriter.OUTPUT_AUDIO_MIME_TYPE);
            this.mAudioFormat.setInteger("aac-profile", 2);
            this.mAudioFormat.setInteger("sample-rate", this.audioSampleRate);
            this.mAudioFormat.setInteger("channel-count", this.audioChannelCount);
            this.mAudioFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.audioBitrate);
            this.mAudioFormat.setInteger("max-input-size", this.audioChannelCount * 16384);
            this.ieT = z.q(EncoderWriter.OUTPUT_AUDIO_MIME_TYPE, false);
            this.ieT.a(this.mAudioFormat, (Surface) null, 1);
            this.ieT.start();
            if (this.zvR) {
                this.zvP = false;
                this.startTime = System.currentTimeMillis();
            } else {
                synchronized (this.iff) {
                    try {
                        this.zvP = false;
                        this.startTime = System.currentTimeMillis();
                    } catch (Throwable th2) {
                        AppMethodBeat.o(89485);
                        throw th2;
                    }
                }
            }
            this.zvK = false;
            AppMethodBeat.o(89485);
            return 0;
        } catch (Throwable th3) {
            this.zvK = false;
            AppMethodBeat.o(89485);
            throw th3;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final int a(c.a aVar) {
        int i2 = 0;
        AppMethodBeat.i(89486);
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", aVar);
        this.zvM = aVar;
        if (this.zvL) {
            this.zvS.sendEmptyMessage(0);
        } else if (this.dyI == null) {
            Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
            AppMethodBeat.o(89486);
            return -1;
        } else if (!this.dyI.aai()) {
            i2 = -1;
        }
        this.zvX = 0;
        this.zvY = -1;
        AppMethodBeat.o(89486);
        return i2;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final int a(c.b bVar) {
        boolean z;
        AppMethodBeat.i(89487);
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(this.dyI == null);
        if (this.zvW == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(bVar == null);
        objArr[3] = Boolean.valueOf(this.zvT);
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]", objArr);
        if (this.dyI != null || this.zvL) {
            this.zvT = true;
            synchronized (this.zvV) {
                try {
                    this.zvW = bVar;
                    if (this.zvU && bVar != null) {
                        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
                        bVar.aQX();
                        this.zvW = null;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(89487);
                    throw th;
                }
            }
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.mmsight.model.a.h.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(89481);
                    try {
                        h.this.aMi();
                        h.this.eka();
                        AppMethodBeat.o(89481);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder error: %s", e2.getMessage());
                        AppMethodBeat.o(89481);
                    }
                }
            }, 500);
            AppMethodBeat.o(89487);
            return 0;
        }
        AppMethodBeat.o(89487);
        return -1;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final void clear() {
        AppMethodBeat.i(89488);
        Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
        aMi();
        eka();
        AppMethodBeat.o(89488);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void eka() {
        AppMethodBeat.i(89489);
        if (this.dyI != null && !this.zvL) {
            Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
            this.dyI.ZZ();
            this.dyI = null;
        }
        AppMethodBeat.o(89489);
    }

    /* access modifiers changed from: protected */
    public final void aMi() {
        AppMethodBeat.i(89490);
        if (this.zvR) {
            ekb();
            AppMethodBeat.o(89490);
            return;
        }
        synchronized (this.iff) {
            try {
                ekb();
            } finally {
                AppMethodBeat.o(89490);
            }
        }
    }

    private void ekb() {
        AppMethodBeat.i(89491);
        if (this.zvP || 0 == this.startTime) {
            AppMethodBeat.o(89491);
            return;
        }
        while (this.zvQ) {
            Thread.yield();
        }
        this.zvP = true;
        try {
            if (this.ieT != null) {
                Log.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
                this.ieT.stop();
                this.ieT.release();
                this.ieT = null;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightAACMediaCodecRecorder", "clear error: %s", e2.getMessage());
        } finally {
            this.ieT = null;
            AppMethodBeat.o(89491);
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final void ejW() {
        this.zvK = true;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final c.a ejX() {
        return this.zwd;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c
    public final void rc(boolean z) {
        this.zvL = z;
    }

    /* access modifiers changed from: package-private */
    public final void rd(boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(89492);
        if (this.ieT == null) {
            Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:".concat(String.valueOf(z)));
            AppMethodBeat.o(89492);
            return;
        }
        try {
            ByteBuffer[] outputBuffers = this.ieT.getOutputBuffers();
            while (true) {
                this.jtk = this.ieT.dequeueOutputBuffer(this.zvE, 10000);
                Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", Integer.valueOf(this.jtk));
                if (this.jtk == -1) {
                    Log.d("MicroMsg.MMSightAACMediaCodecRecorder", "no output available, break");
                    AppMethodBeat.o(89492);
                    return;
                } else if (this.jtk == -3) {
                    outputBuffers = this.ieT.getOutputBuffers();
                } else if (this.jtk == -2) {
                    MediaFormat outputFormat = this.ieT.getOutputFormat();
                    Log.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(outputFormat)));
                    if (this.zvN != null) {
                        this.zvN.f(outputFormat);
                    }
                } else if (this.jtk < 0) {
                    Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", Integer.valueOf(this.jtk));
                } else {
                    Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
                    ByteBuffer byteBuffer = outputBuffers[this.jtk];
                    if (byteBuffer == null) {
                        RuntimeException runtimeException = new RuntimeException("encoderOutputBuffer " + this.jtk + " was null");
                        AppMethodBeat.o(89492);
                        throw runtimeException;
                    } else if (this.zvP) {
                        AppMethodBeat.o(89492);
                        return;
                    } else {
                        this.zvQ = true;
                        if ((this.zvE.flags & 2) != 0) {
                            Log.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", Integer.valueOf(this.zvE.size), Boolean.valueOf(aQF()));
                            if (aQF()) {
                                this.zvE.size = 0;
                            }
                        }
                        if (this.zvE.size != 0) {
                            if (this.zvN != null && !this.zvN.ekj()) {
                                this.zvN.f(this.ieT.getOutputFormat());
                            }
                            byteBuffer.position(this.zvE.offset);
                            byteBuffer.limit(this.zvE.offset + this.zvE.size);
                            if (this.ijm) {
                                try {
                                    MediaCodec.BufferInfo bufferInfo = this.zvE;
                                    int integer = this.ieT.getOutputFormat() != null ? this.ieT.getOutputFormat().getInteger("aac-profile") : 2;
                                    if (this.ieT.getOutputFormat() != null) {
                                        i5 = a.QL(this.ieT.getOutputFormat().getInteger("sample-rate"));
                                    } else {
                                        i5 = 4;
                                    }
                                    if (this.ieT.getOutputFormat() != null) {
                                        i6 = this.ieT.getOutputFormat().getInteger("channel-count");
                                    } else {
                                        i6 = 1;
                                    }
                                    a(byteBuffer, bufferInfo, integer, i5, i6);
                                } catch (Exception e2) {
                                    MediaCodec.BufferInfo bufferInfo2 = this.zvE;
                                    if (this.mAudioFormat != null) {
                                        i2 = this.mAudioFormat.getInteger("aac-profile");
                                    } else {
                                        i2 = 2;
                                    }
                                    if (this.mAudioFormat != null) {
                                        i3 = a.QL(this.mAudioFormat.getInteger("sample-rate"));
                                    } else {
                                        i3 = 4;
                                    }
                                    if (this.mAudioFormat != null) {
                                        i4 = this.mAudioFormat.getInteger("channel-count");
                                    } else {
                                        i4 = 1;
                                    }
                                    a(byteBuffer, bufferInfo2, i2, i3, i4);
                                }
                            } else {
                                h(byteBuffer, this.zvE);
                            }
                        }
                        this.ieT.releaseOutputBuffer(this.jtk, false);
                        this.zvQ = false;
                        if ((this.zvE.flags & 4) != 0) {
                            if (!z) {
                                Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
                                AppMethodBeat.o(89492);
                                return;
                            }
                            Log.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
                            aMi();
                            AppMethodBeat.o(89492);
                            return;
                        }
                    }
                }
            }
        } catch (Exception e3) {
            Log.e("MicroMsg.MMSightAACMediaCodecRecorder", "drainEncoder error: %s", e3.getMessage());
            AppMethodBeat.o(89492);
        }
    }

    /* access modifiers changed from: protected */
    public void h(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(89493);
        if (this.zvN != null && (bufferInfo.flags & 4) == 0) {
            this.zvN.j(byteBuffer, bufferInfo);
        }
        AppMethodBeat.o(89493);
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i2, int i3, int i4) {
        AppMethodBeat.i(89494);
        if (this.zvN != null && (bufferInfo.flags & 4) == 0) {
            this.zvN.j(byteBuffer, bufferInfo);
        }
        AppMethodBeat.o(89494);
    }

    /* access modifiers changed from: protected */
    public boolean aQF() {
        return false;
    }
}
