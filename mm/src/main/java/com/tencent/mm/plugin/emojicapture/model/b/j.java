package com.tencent.mm.plugin.emojicapture.model.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.audio.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.h;
import com.tencent.mm.plugin.appbrand.jsapi.audio.i;
import com.tencent.mm.plugin.appbrand.jsapi.audio.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001f\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0002J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0015H\u0016J\b\u0010(\u001a\u00020!H\u0016R\u000e\u0010\t\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "videoDuration", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;ILandroid/view/Surface;)V", "TAG", "codecCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1;", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "inputEos", "", "inputSampleTime", "", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "processDecodeBuffer", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "plugin-emojicapture_release"})
public final class j extends l {
    final String TAG = "MicroMsg.EmojiMixVideoDecoderAsync";
    private HandlerThread decoderThread = d.hA("EmojiMixVideoDecoderAsync_decodeThread", 5);
    z iec;
    c jto = new c();
    MediaFormat mediaFormat;
    private String mime = "";
    private final Object rqc = new Object();
    boolean rqe;
    long rqf;
    private final a rqg = new a(this);
    private final Surface surface;
    private final int videoDuration;
    private final String videoPath;

    public j(String str, int i2, Surface surface2) {
        p.h(str, "videoPath");
        p.h(surface2, "surface");
        AppMethodBeat.i(i.CTRL_INDEX);
        this.videoPath = str;
        this.videoDuration = i2;
        this.surface = surface2;
        try {
            Log.i(this.TAG, "create decoder with path: " + this.videoPath);
            this.jto.setDataSource(this.videoPath);
            int trackCount = this.jto.getTrackCount();
            for (int i3 = 0; i3 < trackCount; i3++) {
                MediaFormat trackFormat = this.jto.getTrackFormat(i3);
                p.g(trackFormat, "extractor.getTrackFormat(i)");
                String string = trackFormat.getString("mime");
                p.g(string, "trackFormat.getString(MediaFormat.KEY_MIME)");
                if (n.e(string, "video")) {
                    String string2 = trackFormat.getString("mime");
                    p.g(string2, "trackFormat.getString(MediaFormat.KEY_MIME)");
                    this.mime = string2;
                    this.mediaFormat = trackFormat;
                    Log.i(this.TAG, "find video format " + this.mediaFormat + ", mime: " + this.mime);
                    this.jto.selectTrack(i3);
                    AppMethodBeat.o(i.CTRL_INDEX);
                    return;
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "init create extractor error", new Object[0]);
        }
        AppMethodBeat.o(i.CTRL_INDEX);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, hxF = {"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", FirebaseAnalytics.b.INDEX, "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-emojicapture_release"})
    public static final class a extends MediaCodec.Callback {
        final /* synthetic */ j rqh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(j jVar) {
            this.rqh = jVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a8, code lost:
            if (r2 <= r0) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ae, code lost:
            if ((r11.flags & 4) == 0) goto L_0x00b0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onOutputBufferAvailable(android.media.MediaCodec r9, int r10, android.media.MediaCodec.BufferInfo r11) {
            /*
            // Method dump skipped, instructions count: 222
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emojicapture.model.b.j.a.onOutputBufferAvailable(android.media.MediaCodec, int, android.media.MediaCodec$BufferInfo):void");
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
            boolean z;
            AppMethodBeat.i(g.CTRL_INDEX);
            p.h(mediaCodec, "codec");
            Log.i(this.rqh.TAG, "onInputBufferAvailable ".concat(String.valueOf(i2)));
            if (i2 >= 0) {
                try {
                    if (!this.rqh.rqe) {
                        z zVar = this.rqh.iec;
                        ByteBuffer inputBuffer = zVar != null ? zVar.getInputBuffer(i2) : null;
                        if (inputBuffer == null) {
                            Log.w(this.rqh.TAG, "inputBuffer is null");
                            AppMethodBeat.o(g.CTRL_INDEX);
                            return;
                        }
                        inputBuffer.clear();
                        int readSampleData = this.rqh.jto.readSampleData(inputBuffer, 0);
                        this.rqh.jto.advance();
                        inputBuffer.position(0);
                        long sampleTime = this.rqh.jto.getSampleTime();
                        Log.i(this.rqh.TAG, "sampleTime: " + sampleTime + ", sampleSize: " + readSampleData);
                        if (sampleTime > this.rqh.rqf) {
                            this.rqh.rqf = sampleTime;
                        }
                        if (readSampleData < 0 || sampleTime < 0) {
                            Log.i(this.rqh.TAG, "read sample end");
                            z = true;
                        } else {
                            z = false;
                        }
                        this.rqh.rqe = z;
                        z zVar2 = this.rqh.iec;
                        if (zVar2 != null) {
                            zVar2.a(i2, readSampleData, sampleTime, this.rqh.rqe ? 4 : 0);
                            AppMethodBeat.o(g.CTRL_INDEX);
                            return;
                        }
                        AppMethodBeat.o(g.CTRL_INDEX);
                        return;
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace(this.rqh.TAG, e2, "onInputBufferAvailable", new Object[0]);
                }
            }
            AppMethodBeat.o(g.CTRL_INDEX);
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            AppMethodBeat.i(291);
            p.h(mediaCodec, "codec");
            p.h(mediaFormat, "format");
            Log.i(this.rqh.TAG, "onOutputFormatChanged ".concat(String.valueOf(mediaFormat)));
            this.rqh.mediaFormat = mediaFormat;
            AppMethodBeat.o(291);
        }

        public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.audio.l.CTRL_INDEX);
            p.h(mediaCodec, "codec");
            p.h(codecException, "e");
            Log.e(this.rqh.TAG, "onError, codec:" + mediaCodec + ", " + codecException.isRecoverable() + ' ' + codecException.isTransient() + ' ' + codecException.getDiagnosticInfo());
            if (!codecException.isRecoverable() && !codecException.isTransient()) {
                j.a(this.rqh);
                this.rqh.release();
                kotlin.g.a.a<x> aVar = this.rqh.rqy;
                if (aVar != null) {
                    aVar.invoke();
                    AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.audio.l.CTRL_INDEX);
                    return;
                }
            }
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.audio.l.CTRL_INDEX);
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.b.l
    public final int init() {
        AppMethodBeat.i(h.CTRL_INDEX);
        if (this.mediaFormat == null || Util.isNullOrNil(this.mime)) {
            AppMethodBeat.o(h.CTRL_INDEX);
            return -1;
        }
        try {
            this.iec = z.DZ(this.mime);
            z zVar = this.iec;
            if (zVar != null) {
                zVar.a(this.mediaFormat, this.surface, 0);
            }
            if (com.tencent.mm.compatible.util.d.oD(23)) {
                this.decoderThread.start();
                HandlerThread handlerThread = this.decoderThread;
                p.g(handlerThread, "decoderThread");
                Handler handler = new Handler(handlerThread.getLooper());
                z zVar2 = this.iec;
                if (zVar2 != null) {
                    zVar2.setCallback(this.rqg, handler);
                }
            } else {
                z zVar3 = this.iec;
                if (zVar3 != null) {
                    zVar3.setCallback(this.rqg);
                }
            }
            AppMethodBeat.o(h.CTRL_INDEX);
            return 0;
        } catch (Exception e2) {
            Log.e(this.TAG, "init decoder error " + e2.getMessage());
            AppMethodBeat.o(h.CTRL_INDEX);
            return -1;
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.b.l
    public final void startDecode() {
        AppMethodBeat.i(294);
        if (this.iec == null) {
            kotlin.g.a.a<x> aVar = this.rqy;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(294);
                return;
            }
            AppMethodBeat.o(294);
            return;
        }
        z zVar = this.iec;
        if (zVar != null) {
            zVar.start();
            AppMethodBeat.o(294);
            return;
        }
        AppMethodBeat.o(294);
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.b.l
    public final void cJx() {
        AppMethodBeat.i(k.CTRL_INDEX);
        synchronized (this.rqc) {
            try {
                this.rqc.notifyAll();
            } catch (Exception e2) {
                Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
            }
            try {
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(k.CTRL_INDEX);
            }
        }
    }

    public final void release() {
        AppMethodBeat.i(296);
        Log.i(this.TAG, "release");
        try {
            this.decoderThread.quit();
            z zVar = this.iec;
            if (zVar != null) {
                zVar.stop();
            }
            z zVar2 = this.iec;
            if (zVar2 != null) {
                zVar2.release();
                AppMethodBeat.o(296);
                return;
            }
            AppMethodBeat.o(296);
        } catch (Exception e2) {
            AppMethodBeat.o(296);
        }
    }

    public static final /* synthetic */ void a(j jVar, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.af.g.CTRL_INDEX);
        Log.i(jVar.TAG, "processDecodeBuffer pts: " + bufferInfo.presentationTimeUs + ", size: " + bufferInfo.size);
        b<? super Long, x> bVar = jVar.rqx;
        if (bVar != null) {
            bVar.invoke(Long.valueOf(bufferInfo.presentationTimeUs * 1000));
        }
        synchronized (jVar.rqc) {
            try {
                jVar.rqc.wait(3000);
            } catch (Exception e2) {
                Log.printErrStackTrace(jVar.TAG, e2, "", new Object[0]);
            }
            try {
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.af.g.CTRL_INDEX);
            }
        }
    }

    public static final /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.af.h.CTRL_INDEX);
        Log.i(jVar.TAG, "sendDecoderEos");
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.af.h.CTRL_INDEX);
    }
}
