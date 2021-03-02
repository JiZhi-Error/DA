package com.tencent.mm.plugin.emojicapture.model.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.ac.d;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.ct;
import com.tencent.mm.plugin.appbrand.jsapi.p.ak;
import com.tencent.mm.plugin.appbrand.jsapi.pay.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001aH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u001fH\u0016J\b\u0010(\u001a\u00020#H\u0016J\b\u0010)\u001a\u00020#H\u0002R\u000e\u0010\u0007\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cXD¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoder;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;Landroid/view/Surface;)V", "TAG", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decoder", "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "extractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "waitInputQueueMaxCount", "", "waitInputQueueTimeout", "", "waitOutputQueueTimeout", "drainDecoder", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "inputDecoder", "processDecodeBuffer", "", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "startDecodeImpl", "plugin-emojicapture_release"})
public final class i extends l {
    final String TAG = "MicroMsg.MixVideoDecoder";
    private MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    z iec;
    c jto = new c();
    private MediaFormat mediaFormat;
    private String mime = "";
    final long rpZ = Util.MILLSECONDS_OF_MINUTE;
    private final long rqa = 10000;
    final int rqb = 10;
    private final Object rqc = new Object();
    private final Surface surface;
    private final String videoPath;

    public i(String str, Surface surface2) {
        p.h(str, "videoPath");
        p.h(surface2, "surface");
        AppMethodBeat.i(288);
        this.videoPath = str;
        this.surface = surface2;
        try {
            Log.i(this.TAG, "create decoder with path: " + this.videoPath);
            this.jto.setDataSource(this.videoPath);
            int trackCount = this.jto.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = this.jto.getTrackFormat(i2);
                p.g(trackFormat, "extractor.getTrackFormat(i)");
                String string = trackFormat.getString("mime");
                p.g(string, "trackFormat.getString(MediaFormat.KEY_MIME)");
                if (n.e(string, "video")) {
                    String string2 = trackFormat.getString("mime");
                    p.g(string2, "trackFormat.getString(MediaFormat.KEY_MIME)");
                    this.mime = string2;
                    this.mediaFormat = trackFormat;
                    String str2 = this.TAG;
                    StringBuilder sb = new StringBuilder("find video format ");
                    MediaFormat mediaFormat2 = this.mediaFormat;
                    if (mediaFormat2 == null) {
                        p.btv("mediaFormat");
                    }
                    Log.i(str2, sb.append(mediaFormat2).append(", mime: ").append(this.mime).toString());
                    this.jto.selectTrack(i2);
                    AppMethodBeat.o(288);
                    return;
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "init create extractor error", new Object[0]);
        }
        AppMethodBeat.o(288);
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.b.l
    public final int init() {
        AppMethodBeat.i(ct.CTRL_INDEX);
        if (this.mediaFormat == null || Util.isNullOrNil(this.mime)) {
            AppMethodBeat.o(ct.CTRL_INDEX);
            return -1;
        }
        try {
            z DZ = z.DZ(this.mime);
            p.g(DZ, "MediaCodecProxy.createDecoderByType(mime)");
            this.iec = DZ;
            z zVar = this.iec;
            if (zVar == null) {
                p.btv("decoder");
            }
            MediaFormat mediaFormat2 = this.mediaFormat;
            if (mediaFormat2 == null) {
                p.btv("mediaFormat");
            }
            zVar.a(mediaFormat2, this.surface, 0);
            z zVar2 = this.iec;
            if (zVar2 == null) {
                p.btv("decoder");
            }
            zVar2.start();
            AppMethodBeat.o(ct.CTRL_INDEX);
            return 0;
        } catch (Exception e2) {
            Log.e(this.TAG, "init decoder error " + e2.getMessage());
            AppMethodBeat.o(ct.CTRL_INDEX);
            return -1;
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.b.l
    public final void startDecode() {
        AppMethodBeat.i(ak.CTRL_INDEX);
        d.a("EmojiMixVideoDecoder_decodeThread", true, (kotlin.g.a.a) new a(this));
        AppMethodBeat.o(ak.CTRL_INDEX);
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.b.l
    public final void cJx() {
        AppMethodBeat.i(q.CTRL_INDEX);
        synchronized (this.rqc) {
            try {
                this.rqc.notifyAll();
            } catch (Exception e2) {
                Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
            }
            try {
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(q.CTRL_INDEX);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean aMg() {
        ByteBuffer[] byteBufferArr;
        AppMethodBeat.i(az.CTRL_INDEX);
        z zVar = this.iec;
        if (zVar == null) {
            p.btv("decoder");
        }
        int dequeueOutputBuffer = zVar.dequeueOutputBuffer(this.bufferInfo, this.rqa);
        z zVar2 = this.iec;
        if (zVar2 == null) {
            p.btv("decoder");
        }
        ByteBuffer[] outputBuffers = zVar2.getOutputBuffers();
        int i2 = dequeueOutputBuffer;
        while (true) {
            if (i2 != -1) {
                if (i2 != -2) {
                    if (i2 == -3) {
                        z zVar3 = this.iec;
                        if (zVar3 == null) {
                            p.btv("decoder");
                        }
                        if (zVar3.getOutputBuffers() != null) {
                            z zVar4 = this.iec;
                            if (zVar4 == null) {
                                p.btv("decoder");
                            }
                            byteBufferArr = zVar4.getOutputBuffers();
                        }
                        byteBufferArr = outputBuffers;
                    } else if (i2 < 0) {
                        Log.i(this.TAG, "drainDecoder loop outputBufferIndex:" + i2 + ", break");
                        break;
                    } else {
                        ByteBuffer byteBuffer = outputBuffers[i2];
                        long j2 = this.bufferInfo.presentationTimeUs;
                        if ((this.bufferInfo.flags & 4) != 0) {
                            Log.i(this.TAG, "drainDecoder loop reach eof");
                            z zVar5 = this.iec;
                            if (zVar5 == null) {
                                p.btv("decoder");
                            }
                            zVar5.releaseOutputBuffer(i2, true);
                            AppMethodBeat.o(az.CTRL_INDEX);
                            return true;
                        } else if (byteBuffer == null || this.bufferInfo.size == 0) {
                            z zVar6 = this.iec;
                            if (zVar6 == null) {
                                p.btv("decoder");
                            }
                            zVar6.releaseOutputBuffer(i2, true);
                            byteBufferArr = outputBuffers;
                        } else {
                            byteBuffer.position(this.bufferInfo.offset);
                            byteBuffer.limit(this.bufferInfo.offset + this.bufferInfo.size);
                            z zVar7 = this.iec;
                            if (zVar7 == null) {
                                p.btv("decoder");
                            }
                            zVar7.releaseOutputBuffer(i2, true);
                            MediaCodec.BufferInfo bufferInfo2 = this.bufferInfo;
                            Log.i(this.TAG, "processDecodeBuffer pts: " + bufferInfo2.presentationTimeUs + ", size: " + bufferInfo2.size);
                            b<? super Long, x> bVar = this.rqx;
                            if (bVar != null) {
                                bVar.invoke(Long.valueOf(bufferInfo2.presentationTimeUs * 1000));
                            }
                            synchronized (this.rqc) {
                                try {
                                    this.rqc.wait(50);
                                } catch (Exception e2) {
                                    Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
                                }
                                try {
                                    x xVar = x.SXb;
                                } finally {
                                    AppMethodBeat.o(az.CTRL_INDEX);
                                }
                            }
                            if ((this.bufferInfo.flags & 4) != 0) {
                                try {
                                    z zVar8 = this.iec;
                                    if (zVar8 == null) {
                                        p.btv("decoder");
                                    }
                                    zVar8.stop();
                                    z zVar9 = this.iec;
                                    if (zVar9 == null) {
                                        p.btv("decoder");
                                    }
                                    zVar9.release();
                                } catch (Exception e3) {
                                }
                                return true;
                            }
                            byteBufferArr = outputBuffers;
                        }
                    }
                    z zVar10 = this.iec;
                    if (zVar10 == null) {
                        p.btv("decoder");
                    }
                    i2 = zVar10.dequeueOutputBuffer(this.bufferInfo, this.rqa);
                    if (i2 < 0) {
                        break;
                    }
                    outputBuffers = byteBufferArr;
                } else {
                    String str = this.TAG;
                    StringBuilder sb = new StringBuilder("drainDecoder output format change: ");
                    z zVar11 = this.iec;
                    if (zVar11 == null) {
                        p.btv("decoder");
                    }
                    Log.i(str, sb.append(zVar11.getOutputFormat()).toString());
                    z zVar12 = this.iec;
                    if (zVar12 == null) {
                        p.btv("decoder");
                    }
                    MediaFormat outputFormat = zVar12.getOutputFormat();
                    p.g(outputFormat, "decoder.outputFormat");
                    this.mediaFormat = outputFormat;
                }
            } else {
                Log.i(this.TAG, "drainDecoder try again later");
                break;
            }
        }
        AppMethodBeat.o(az.CTRL_INDEX);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void cJy() {
        AppMethodBeat.i(287);
        Log.i(this.TAG, "sendDecoderEos");
        z zVar = this.iec;
        if (zVar == null) {
            p.btv("decoder");
        }
        int dequeueInputBuffer = zVar.dequeueInputBuffer(this.rpZ);
        int i2 = 0;
        while (dequeueInputBuffer < 0 && i2 < this.rqb) {
            if (!aMg()) {
                AppMethodBeat.o(287);
                return;
            }
            z zVar2 = this.iec;
            if (zVar2 == null) {
                p.btv("decoder");
            }
            dequeueInputBuffer = zVar2.dequeueInputBuffer(this.rpZ);
            i2++;
        }
        if (dequeueInputBuffer >= 0) {
            z zVar3 = this.iec;
            if (zVar3 == null) {
                p.btv("decoder");
            }
            ByteBuffer byteBuffer = zVar3.getInputBuffers()[dequeueInputBuffer];
            byteBuffer.clear();
            this.jto.readSampleData(byteBuffer, 0);
            byteBuffer.position(0);
            z zVar4 = this.iec;
            if (zVar4 == null) {
                p.btv("decoder");
            }
            zVar4.a(dequeueInputBuffer, 0, 0, 4);
        }
        aMg();
        AppMethodBeat.o(287);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ i rqd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(i iVar) {
            super(0);
            this.rqd = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0104 A[LOOP:0: B:1:0x001b->B:51:0x0104, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x010f  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0098 A[EDGE_INSN: B:55:0x0098->B:23:0x0098 ?: BREAK  , SYNTHETIC] */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
            // Method dump skipped, instructions count: 273
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emojicapture.model.b.i.a.invoke():java.lang.Object");
        }
    }
}
