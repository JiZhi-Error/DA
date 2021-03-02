package com.tencent.mm.plugin.vlog.player;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.aj;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 12\u00020\u0001:\u00011B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020\u000eH\u0016J\b\u0010'\u001a\u00020\u000eH\u0016J\b\u0010(\u001a\u00020!H\u0016J\u0018\u0010)\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u000eH\u0016J\b\u0010+\u001a\u00020!H\u0016J\u0010\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u0011H\u0016J\b\u0010.\u001a\u00020!H\u0016J\b\u0010/\u001a\u00020!H\u0016J\b\u00100\u001a\u00020!H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/VLogMediaCodecPlayer;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "(IIILcom/tencent/mm/plugin/vlog/model/VideoMaterial;)V", "decoder", "Landroid/media/MediaCodec;", "info", "Landroid/media/MediaCodec$BufferInfo;", "inputDone", "", "lastBufferId", "lastPts", "", "mediaExtractor", "Landroid/media/MediaExtractor;", "mime", "", "outputDone", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "trackId", "videoFormat", "Landroid/media/MediaFormat;", "drainOutputBuffer", "curTime", "enableMute", "", "mute", "feedInputBuffer", "getOffsetPts", "pts", "isMirror", "isOES", "pause", "playing", "updateTex", "prepare", "readyAt", "seekTime", "release", "resume", "stop", "Companion", "plugin-vlog_release"})
public final class f extends b {
    public static final a GBL = new a((byte) 0);
    private boolean GBI;
    private boolean GBJ;
    private int GBK = -1;
    private MediaCodec decoder;
    private long idR = -1;
    private final MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
    private MediaExtractor mediaExtractor;
    private String mime = "";
    private Surface surface;
    private SurfaceTexture surfaceTexture;
    private int trackId = -1;
    private MediaFormat videoFormat;

    static {
        AppMethodBeat.i(110987);
        AppMethodBeat.o(110987);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(int i2, int i3, int i4, aj ajVar) {
        super(i2, i3, i4, ajVar);
        p.h(ajVar, "material");
        AppMethodBeat.i(110986);
        AppMethodBeat.o(110986);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/player/VLogMediaCodecPlayer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void O(long j2, boolean z) {
        SurfaceTexture surfaceTexture2;
        AppMethodBeat.i(110981);
        Log.d("MicroMsg.VLogVideoPlayer", "VideoPlayer playing : " + KW(j2));
        while (!KX(KW(j2))) {
            vc();
        }
        if (!z || (surfaceTexture2 = this.surfaceTexture) == null) {
            AppMethodBeat.o(110981);
            return;
        }
        surfaceTexture2.updateTexImage();
        AppMethodBeat.o(110981);
    }

    private final boolean KX(long j2) {
        MediaFormat outputFormat;
        int i2;
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(110982);
        try {
            MediaCodec mediaCodec = this.decoder;
            if (mediaCodec != null) {
                if (this.idR != -1) {
                    long j3 = this.idR / 1000;
                    if (j2 - j3 <= 0) {
                        Log.d("MicroMsg.VLogVideoPlayer", "[debug video] [draw] dura1 = " + j2 + ", dura2 = " + j3);
                        if (this.GBK != -1) {
                            mediaCodec.releaseOutputBuffer(this.GBK, true);
                            this.GBK = -1;
                        }
                        AppMethodBeat.o(110982);
                        return true;
                    }
                    Log.d("MicroMsg.VLogVideoPlayer", "[debug video] [drop] dura1 = " + j2 + ", dura2 = " + j3);
                    if (this.GBK != -1) {
                        mediaCodec.releaseOutputBuffer(this.GBK, false);
                        this.GBK = -1;
                    }
                }
                if (!this.GBJ) {
                    int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(this.info, 10000);
                    Log.d("MicroMsg.VLogVideoPlayer", "drainoutputbuffer bufferIndex: " + dequeueOutputBuffer + ", flags: " + this.info.flags);
                    if (dequeueOutputBuffer == -2) {
                        MediaCodec mediaCodec2 = this.decoder;
                        if (!(mediaCodec2 == null || (outputFormat = mediaCodec2.getOutputFormat()) == null)) {
                            this.width = outputFormat.getInteger("width");
                            this.height = outputFormat.getInteger("height");
                            if (outputFormat.containsKey("crop-left")) {
                                i2 = outputFormat.getInteger("crop-left");
                            } else {
                                i2 = -1;
                            }
                            this.cropLeft = i2;
                            if (outputFormat.containsKey("crop-top")) {
                                i3 = outputFormat.getInteger("crop-top");
                            } else {
                                i3 = -1;
                            }
                            this.cropTop = i3;
                            if (outputFormat.containsKey("crop-right")) {
                                i4 = outputFormat.getInteger("crop-right");
                            } else {
                                i4 = -1;
                            }
                            this.cropRight = i4;
                            if (outputFormat.containsKey("crop-bottom")) {
                                i5 = outputFormat.getInteger("crop-bottom");
                            } else {
                                i5 = -1;
                            }
                            this.cropBottom = i5;
                            Log.d("MicroMsg.VLogVideoPlayer", "[debug video] format change, cropLeft = " + this.cropLeft + ", cropTop = " + this.cropTop + ", cropRight = " + this.cropRight + ", cropBottom = " + this.cropBottom);
                        }
                    } else if (dequeueOutputBuffer >= 0) {
                        if ((this.info.flags & 4) != 0) {
                            this.GBJ = true;
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                            Log.d("MicroMsg.VLogVideoPlayer", "[debug video] [decode] output done, lastPts = " + this.idR);
                            AppMethodBeat.o(110982);
                            return true;
                        }
                        long j4 = this.info.presentationTimeUs;
                        Log.d("MicroMsg.VLogVideoPlayer", "[debug video] [decode] lastPts = " + this.idR + ", pts = " + j4);
                        this.idR = j4;
                        this.GBK = dequeueOutputBuffer;
                    }
                } else {
                    AppMethodBeat.o(110982);
                    return true;
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", e2, "drainOutputBuffer error", new Object[0]);
        }
        AppMethodBeat.o(110982);
        return false;
    }

    private final boolean vc() {
        MediaCodec mediaCodec;
        AppMethodBeat.i(110983);
        try {
            MediaExtractor mediaExtractor2 = this.mediaExtractor;
            if (!(mediaExtractor2 == null || (mediaCodec = this.decoder) == null || this.GBI)) {
                int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000);
                Log.d("MicroMsg.VLogVideoPlayer", "feedInputBuffer bufferIndex :".concat(String.valueOf(dequeueInputBuffer)));
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer inputBuffer = mediaCodec.getInputBuffer(dequeueInputBuffer);
                    if (inputBuffer == null) {
                        p.hyc();
                    }
                    p.g(inputBuffer, "decoder.getInputBuffer(bufferIndex)!!");
                    int readSampleData = mediaExtractor2.readSampleData(inputBuffer, 0);
                    long sampleTime = mediaExtractor2.getSampleTime();
                    Log.d("MicroMsg.VLogVideoPlayer", "[debug video] [decode] input pts = ".concat(String.valueOf(sampleTime)));
                    mediaExtractor2.advance();
                    if (readSampleData > 0) {
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 0);
                        AppMethodBeat.o(110983);
                        return true;
                    }
                    this.GBI = true;
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
                    Log.d("MicroMsg.VLogVideoPlayer", "[debug video] [decode] input done, pts = ".concat(String.valueOf(sampleTime)));
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", e2, "feedInputBuffer error", new Object[0]);
        }
        AppMethodBeat.o(110983);
        return false;
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void pause() {
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void resume() {
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void wC(boolean z) {
    }

    private final long KW(long j2) {
        AppMethodBeat.i(110978);
        s sVar = this.GBm;
        if (sVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoMaterial");
            AppMethodBeat.o(110978);
            throw tVar;
        }
        long j3 = ((aj) sVar).GzW + j2;
        AppMethodBeat.o(110978);
        return j3;
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void prepare() {
        AppMethodBeat.i(110979);
        this.bcY = true;
        this.surfaceTexture = new SurfaceTexture(this.Gxi);
        this.surface = new Surface(this.surfaceTexture);
        this.dYT = SightVideoJNI.getMp4RotateVFS(this.GBm.path);
        if (this.dYT == 90) {
            this.dYT = 3;
        } else if (this.dYT == 180) {
            this.dYT = 2;
        } else if (this.dYT == 270) {
            this.dYT = 1;
        }
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        mediaExtractor2.setDataSource(this.GBm.path);
        int trackCount = mediaExtractor2.getTrackCount();
        int i2 = 0;
        while (true) {
            if (i2 >= trackCount) {
                break;
            }
            MediaFormat trackFormat = mediaExtractor2.getTrackFormat(i2);
            p.g(trackFormat, "mediaExtractor.getTrackFormat(i)");
            String string = trackFormat.getString("mime");
            p.g(string, "mediaFormat.getString(MediaFormat.KEY_MIME)");
            if (n.J(string, "video", false)) {
                this.width = trackFormat.getInteger("width");
                this.height = trackFormat.getInteger("height");
                String string2 = trackFormat.getString("mime");
                p.g(string2, "mediaFormat.getString(MediaFormat.KEY_MIME)");
                this.mime = string2;
                this.videoFormat = trackFormat;
                this.trackId = i2;
                break;
            }
            i2++;
        }
        mediaExtractor2.release();
        StringBuilder append = new StringBuilder("prepare video, rotate = ").append(this.dYT).append(", width = ").append(this.width).append(", height = ").append(this.height).append(", startTime = ").append(this.GBm.startTime).append(", endTime = ").append(this.GBm.endTime).append(", videoStartTime = ");
        s sVar = this.GBm;
        if (sVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoMaterial");
            AppMethodBeat.o(110979);
            throw tVar;
        }
        Log.i("MicroMsg.VLogVideoPlayer", append.append(((aj) sVar).GzW).append(", videoEndTime = ").append(((aj) this.GBm).GzX).toString());
        AppMethodBeat.o(110979);
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void KV(long j2) {
        AppMethodBeat.i(183780);
        if (this.GBl) {
            AppMethodBeat.o(183780);
            return;
        }
        this.GBl = true;
        long currentTimeMillis = System.currentTimeMillis();
        this.mediaExtractor = new MediaExtractor();
        MediaExtractor mediaExtractor2 = this.mediaExtractor;
        if (mediaExtractor2 != null) {
            mediaExtractor2.setDataSource(this.GBm.path);
        }
        MediaExtractor mediaExtractor3 = this.mediaExtractor;
        if (mediaExtractor3 != null) {
            mediaExtractor3.selectTrack(this.trackId);
        }
        MediaExtractor mediaExtractor4 = this.mediaExtractor;
        if (mediaExtractor4 != null) {
            mediaExtractor4.seekTo(KW(j2) * 1000, 0);
        }
        StringBuilder append = new StringBuilder("[debug video] play seekTime :").append(KW(j2)).append(", real seekTime: ");
        MediaExtractor mediaExtractor5 = this.mediaExtractor;
        Log.i("MicroMsg.VLogVideoPlayer", append.append(mediaExtractor5 != null ? Long.valueOf(mediaExtractor5.getSampleTime()) : null).toString());
        if (this.videoFormat != null) {
            this.decoder = MediaCodec.createDecoderByType(this.mime);
            MediaCodec mediaCodec = this.decoder;
            if (mediaCodec != null) {
                mediaCodec.configure(this.videoFormat, this.surface, (MediaCrypto) null, 0);
            }
            MediaCodec mediaCodec2 = this.decoder;
            if (mediaCodec2 != null) {
                mediaCodec2.start();
            }
        }
        this.idR = -1;
        this.GBK = -1;
        this.GBI = false;
        this.GBJ = false;
        Log.d("MicroMsg.VLogVideoPlayer", "[prepare] video play time = ".concat(String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        AppMethodBeat.o(183780);
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void stop() {
        AppMethodBeat.i(110984);
        this.GBl = false;
        try {
            MediaCodec mediaCodec = this.decoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
            }
            MediaCodec mediaCodec2 = this.decoder;
            if (mediaCodec2 != null) {
                mediaCodec2.release();
            }
            this.decoder = null;
            MediaExtractor mediaExtractor2 = this.mediaExtractor;
            if (mediaExtractor2 != null) {
                mediaExtractor2.release();
            }
            this.mediaExtractor = null;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", e2, "stop error", new Object[0]);
        }
        Log.d("MicroMsg.VLogVideoPlayer", "video player stop");
        AppMethodBeat.o(110984);
    }

    @Override // com.tencent.mm.plugin.vlog.player.b
    public final void release() {
        AppMethodBeat.i(110985);
        this.GBl = false;
        try {
            MediaExtractor mediaExtractor2 = this.mediaExtractor;
            if (mediaExtractor2 != null) {
                mediaExtractor2.release();
            }
            MediaCodec mediaCodec = this.decoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
            }
            MediaCodec mediaCodec2 = this.decoder;
            if (mediaCodec2 != null) {
                mediaCodec2.release();
            }
            Surface surface2 = this.surface;
            if (surface2 != null) {
                surface2.release();
            }
            SurfaceTexture surfaceTexture2 = this.surfaceTexture;
            if (surfaceTexture2 != null) {
                surfaceTexture2.release();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", e2, "release error", new Object[0]);
        }
        this.surface = null;
        this.surfaceTexture = null;
        this.mediaExtractor = null;
        this.decoder = null;
        this.videoFormat = null;
        this.bcY = false;
        Log.d("MicroMsg.VLogVideoPlayer", "video player release");
        AppMethodBeat.o(110985);
    }
}
