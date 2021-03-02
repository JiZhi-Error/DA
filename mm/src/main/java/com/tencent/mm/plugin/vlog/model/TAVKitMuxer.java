package com.tencent.mm.plugin.vlog.model;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer;", "", "()V", "TAG", "", "setup", "", "SightVideoJNIMediaMuxer", "SightVideoJNIMediaMuxerFactory", "plugin-vlog_release"})
public final class TAVKitMuxer {
    public static final TAVKitMuxer Gzj = new TAVKitMuxer();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(190675);
        AppMethodBeat.o(190675);
    }

    private TAVKitMuxer() {
    }

    public static void setup() {
        AppMethodBeat.i(190674);
        MediaMuxerFactory.setMuxerCreator(new SightVideoJNIMediaMuxerFactory());
        AppMethodBeat.o(190674);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer$SightVideoJNIMediaMuxerFactory;", "Lcom/tencent/tav/decoder/muxer/MediaMuxerFactory$MediaMuxerCreator;", "()V", "createMediaMuxer", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "path", "", "format", "", "plugin-vlog_release"})
    public static final class SightVideoJNIMediaMuxerFactory implements MediaMuxerFactory.MediaMuxerCreator {
        @Override // com.tencent.tav.decoder.muxer.MediaMuxerFactory.MediaMuxerCreator
        public final IMediaMuxer createMediaMuxer(String str, int i2) {
            AppMethodBeat.i(190673);
            p.h(str, "path");
            SightVideoJNIMediaMuxer sightVideoJNIMediaMuxer = new SightVideoJNIMediaMuxer(str, i2);
            AppMethodBeat.o(190673);
            return sightVideoJNIMediaMuxer;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\tH\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u0012H\u0002J\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0012J\u000e\u0010*\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020&H\u0002J\u0006\u0010.\u001a\u00020\u0005J\"\u0010/\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\t2\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0005H\u0002J\b\u00102\u001a\u00020\u0012H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u00020&H\u0016J\u0010\u00105\u001a\u00020&2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u00106\u001a\u00020&H\u0016J\b\u00107\u001a\u00020&H\u0016J\b\u00108\u001a\u00020\u0005H\u0016J \u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\u0018\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020BH\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer$SightVideoJNIMediaMuxer;", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "path", "", "format", "", "(Ljava/lang/String;I)V", "audioChannelCount", "audioFormat", "Landroid/media/MediaFormat;", "audioId", "audioSampleRate", "bufId", "dtsCount", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "exportConfig", "Lcom/tencent/tav/core/ExportConfig;", "isHevc", "", "isStarted", "isUseFFMpegMuxer", "pendingVideoDts", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "softEncode", "videoBitrate", "videoFormat", "videoFps", "", "videoFrameCount", "videoHeight", "videoId", "videoWidth", "addTrack", "mediaFormat", "audioTrackIndex", "checkInitBufId", "", "checkVideoFormatValid", "configMuxerToSoftEncode", "isSoftEncode", "configToUseHevc", "doWriteVideoDts", "dts", "flushPendingVideoDts", "getBufId", "getMediaFormatInt", "key", "defVal", "ignoreHeader", "isMuxerStarted", "release", "setExportConfig", "start", "stop", "videoTrackIndex", "writeSampleData", "trackId", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "writeSampleDataTime", "isVideo", "sampleTime", "Lcom/tencent/tav/coremedia/CMTime;", "plugin-vlog_release"})
    public static final class SightVideoJNIMediaMuxer implements IMediaMuxer {
        private int audioChannelCount;
        private MediaFormat audioFormat;
        private int audioId = -1;
        private int audioSampleRate;
        private volatile int bufId = -1;
        private int dtsCount;
        private int duration;
        private ExportConfig exportConfig;
        private final int format;
        private boolean isHevc;
        private boolean isStarted;
        private boolean isUseFFMpegMuxer;
        private final String path;
        private ArrayList<Long> pendingVideoDts = new ArrayList<>();
        private boolean softEncode;
        private int videoBitrate;
        private MediaFormat videoFormat;
        private float videoFps;
        private int videoFrameCount;
        private int videoHeight;
        private int videoId = -1;
        private int videoWidth;

        public SightVideoJNIMediaMuxer(String str, int i2) {
            p.h(str, "path");
            AppMethodBeat.i(190672);
            this.path = str;
            this.format = i2;
            AppMethodBeat.o(190672);
        }

        public final void configToUseHevc(boolean z) {
            AppMethodBeat.i(190658);
            this.isHevc = z;
            TAVKitMuxer tAVKitMuxer = TAVKitMuxer.Gzj;
            Log.i(TAVKitMuxer.TAG, "configToUseHevc: ".concat(String.valueOf(z)));
            AppMethodBeat.o(190658);
        }

        public final void configMuxerToSoftEncode(boolean z) {
            AppMethodBeat.i(190659);
            this.softEncode = z;
            TAVKitMuxer tAVKitMuxer = TAVKitMuxer.Gzj;
            Log.i(TAVKitMuxer.TAG, "configMuxerToSoftEncode:".concat(String.valueOf(z)));
            AppMethodBeat.o(190659);
        }

        private final void checkInitBufId() {
            AppMethodBeat.i(190660);
            TAVKitMuxer tAVKitMuxer = TAVKitMuxer.Gzj;
            Log.i(TAVKitMuxer.TAG, "checkInitBufId bufId:" + this.bufId);
            if (this.bufId < 0) {
                if (!this.softEncode || !checkVideoFormatValid()) {
                    this.bufId = SightVideoJNI.initDataBufferForRemux(this.isHevc);
                } else if (this.videoFormat != null) {
                    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.videoWidth, this.videoHeight, 0, this.videoWidth, this.videoHeight, this.videoFps, this.videoBitrate, this.isHevc ? 5 : 1, 8, 2, 23.0f, false, true, this.duration, false, this.isHevc, b.al(true, this.isHevc));
                }
                this.isUseFFMpegMuxer = b.al(this.softEncode, this.isHevc);
                TAVKitMuxer tAVKitMuxer2 = TAVKitMuxer.Gzj;
                Log.i(TAVKitMuxer.TAG, "init bufId:" + this.bufId + ", isHevc:" + this.isHevc + ", softEncode:" + this.softEncode + ", video size:[" + this.videoWidth + 'x' + this.videoHeight + "], fps:" + this.videoFps + ", isUseFFMpegMuxer:" + this.isUseFFMpegMuxer);
            }
            AppMethodBeat.o(190660);
        }

        private final boolean checkVideoFormatValid() {
            MediaFormat mediaFormat;
            MediaFormat mediaFormat2;
            MediaFormat mediaFormat3;
            AppMethodBeat.i(190661);
            MediaFormat mediaFormat4 = this.videoFormat;
            if (mediaFormat4 == null || !mediaFormat4.containsKey("width") || (mediaFormat = this.videoFormat) == null || !mediaFormat.containsKey("height") || (mediaFormat2 = this.videoFormat) == null || !mediaFormat2.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) || (mediaFormat3 = this.videoFormat) == null || !mediaFormat3.containsKey("frame-rate")) {
                AppMethodBeat.o(190661);
                return false;
            }
            AppMethodBeat.o(190661);
            return true;
        }

        @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
        public final void start() {
            AppMethodBeat.i(190662);
            TAVKitMuxer tAVKitMuxer = TAVKitMuxer.Gzj;
            Log.i(TAVKitMuxer.TAG, "start");
            this.isStarted = true;
            AppMethodBeat.o(190662);
        }

        @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
        public final boolean ignoreHeader() {
            return false;
        }

        @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
        public final boolean isMuxerStarted() {
            return this.isStarted;
        }

        @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
        public final void setExportConfig(ExportConfig exportConfig2) {
            AppMethodBeat.i(190663);
            p.h(exportConfig2, "exportConfig");
            this.exportConfig = exportConfig2;
            AppMethodBeat.o(190663);
        }

        @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
        public final void stop() {
            AppMethodBeat.i(190664);
            TAVKitMuxer tAVKitMuxer = TAVKitMuxer.Gzj;
            Log.i(TAVKitMuxer.TAG, "stop, duration:" + this.duration + "，frameCount:" + this.videoFrameCount + ", dtsCount:" + this.dtsCount);
            TAVKitMuxer tAVKitMuxer2 = TAVKitMuxer.Gzj;
            Log.i(TAVKitMuxer.TAG, "stop videoFormat:" + this.videoFormat);
            TAVKitMuxer tAVKitMuxer3 = TAVKitMuxer.Gzj;
            Log.i(TAVKitMuxer.TAG, "stop audioFormat:" + this.audioFormat);
            if (this.duration <= 0) {
                TAVKitMuxer tAVKitMuxer4 = TAVKitMuxer.Gzj;
                Log.e(TAVKitMuxer.TAG, "error duration is 0");
                AppMethodBeat.o(190664);
                return;
            }
            this.audioSampleRate = getMediaFormatInt(this.audioFormat, "sample-rate", 0);
            this.audioChannelCount = getMediaFormatInt(this.audioFormat, "channel-count", 0);
            int mediaFormatInt = getMediaFormatInt(this.videoFormat, "frame-rate", 0);
            this.videoBitrate = getMediaFormatInt(this.videoFormat, FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, 0);
            float f2 = (((float) this.videoFrameCount) * 1000.0f) / ((float) this.duration);
            TAVKitMuxer tAVKitMuxer5 = TAVKitMuxer.Gzj;
            Log.i(TAVKitMuxer.TAG, "audioSampleRate:" + this.audioSampleRate + ", audioChannelCount:" + this.audioChannelCount + ", mediaFormatFps:" + mediaFormatInt + ", videoBitrate:" + this.videoBitrate + ", duration:" + this.duration + ", countFps:" + f2 + ", configToSoftEncode:" + this.softEncode);
            TAVKitMuxer tAVKitMuxer6 = TAVKitMuxer.Gzj;
            String str = TAVKitMuxer.TAG;
            StringBuilder sb = new StringBuilder("exportConfig: audioSampleRate:");
            ExportConfig exportConfig2 = this.exportConfig;
            StringBuilder append = sb.append(exportConfig2 != null ? Integer.valueOf(exportConfig2.getAudioSampleRateHz()) : null).append(", audioChannelCount:");
            ExportConfig exportConfig3 = this.exportConfig;
            StringBuilder append2 = append.append(exportConfig3 != null ? Integer.valueOf(exportConfig3.getAudioChannelCount()) : null).append(", videoBitrate:");
            ExportConfig exportConfig4 = this.exportConfig;
            Log.i(str, append2.append(exportConfig4 != null ? Integer.valueOf(exportConfig4.getVideoBitRate()) : null).toString());
            if (!this.softEncode) {
                this.videoFps = f2;
            }
            if (this.audioSampleRate <= 0) {
                ExportConfig exportConfig5 = this.exportConfig;
                this.audioSampleRate = exportConfig5 != null ? exportConfig5.getAudioSampleRateHz() : 0;
            }
            if (this.audioChannelCount <= 0) {
                ExportConfig exportConfig6 = this.exportConfig;
                this.audioChannelCount = exportConfig6 != null ? exportConfig6.getAudioChannelCount() : 0;
            }
            if (this.videoBitrate <= 0) {
                ExportConfig exportConfig7 = this.exportConfig;
                this.videoBitrate = exportConfig7 != null ? exportConfig7.getVideoBitRate() : 0;
            }
            int muxingLock = SightVideoJNI.muxingLock(this.bufId, null, this.audioSampleRate, 1024, 2, this.audioChannelCount, 0, this.path, this.videoFps, Math.max(1000, this.duration), this.videoBitrate, c.Dma, 8, 2, 23.0f, null, 0, false, this.audioSampleRate <= 0 && this.audioChannelCount <= 0, this.softEncode, this.isHevc, b.al(this.softEncode, this.isHevc));
            TAVKitMuxer tAVKitMuxer7 = TAVKitMuxer.Gzj;
            Log.i(TAVKitMuxer.TAG, "stop ret:".concat(String.valueOf(muxingLock)));
            this.isStarted = false;
            AppMethodBeat.o(190664);
        }

        @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
        public final void writeSampleDataTime(boolean z, CMTime cMTime) {
            AppMethodBeat.i(190665);
            p.h(cMTime, "sampleTime");
            if (z && !this.softEncode) {
                TAVKitMuxer tAVKitMuxer = TAVKitMuxer.Gzj;
                Log.i(TAVKitMuxer.TAG, "write video dts:" + cMTime.getTimeUs());
                if (this.bufId < 0) {
                    TAVKitMuxer tAVKitMuxer2 = TAVKitMuxer.Gzj;
                    Log.i(TAVKitMuxer.TAG, "save pending dts:" + cMTime.getTimeUs());
                    this.pendingVideoDts.add(Long.valueOf(cMTime.getTimeUs()));
                    AppMethodBeat.o(190665);
                    return;
                }
                doWriteVideoDts(cMTime.getTimeUs());
            }
            AppMethodBeat.o(190665);
        }

        @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
        public final void writeSampleData(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            int i3;
            int i4;
            int i5;
            MediaFormat mediaFormat;
            MediaFormat mediaFormat2;
            MediaFormat mediaFormat3;
            AppMethodBeat.i(190666);
            p.h(byteBuffer, "byteBuffer");
            p.h(bufferInfo, "bufferInfo");
            boolean z = i2 == this.videoId;
            TAVKitMuxer tAVKitMuxer = TAVKitMuxer.Gzj;
            Log.i(TAVKitMuxer.TAG, "writeSampleData, trackId:" + i2 + ", isVideo:" + z + ", pts:" + bufferInfo.presentationTimeUs);
            if (i2 == this.videoId) {
                this.videoFrameCount++;
                SightVideoJNI.writeH264DataLock(this.bufId, byteBuffer, bufferInfo.size, bufferInfo.presentationTimeUs);
            } else if (i2 == this.audioId) {
                if (this.isUseFFMpegMuxer) {
                    if (this.audioFormat == null || (mediaFormat3 = this.audioFormat) == null || !mediaFormat3.containsKey("aac-profile")) {
                        i3 = 2;
                    } else {
                        MediaFormat mediaFormat4 = this.audioFormat;
                        if (mediaFormat4 == null) {
                            p.hyc();
                        }
                        i3 = mediaFormat4.getInteger("aac-profile");
                    }
                    if (this.audioFormat == null || (mediaFormat2 = this.audioFormat) == null || !mediaFormat2.containsKey("sample-rate")) {
                        i4 = 4;
                    } else {
                        MediaFormat mediaFormat5 = this.audioFormat;
                        if (mediaFormat5 == null) {
                            p.hyc();
                        }
                        i4 = a.QL(mediaFormat5.getInteger("sample-rate"));
                    }
                    if (this.audioFormat == null || (mediaFormat = this.audioFormat) == null || !mediaFormat.containsKey("channel-count")) {
                        i5 = 1;
                    } else {
                        MediaFormat mediaFormat6 = this.audioFormat;
                        if (mediaFormat6 == null) {
                            p.hyc();
                        }
                        i5 = mediaFormat6.getInteger("channel-count");
                    }
                    SightVideoJNI.writeAACDataWithADTSLock(this.bufId, byteBuffer, bufferInfo.size, bufferInfo.presentationTimeUs, i3, i4, i5);
                } else {
                    SightVideoJNI.writeAACDataLock(this.bufId, byteBuffer, bufferInfo.size, bufferInfo.presentationTimeUs);
                }
            }
            int cR = kotlin.h.a.cR(((float) bufferInfo.presentationTimeUs) / 1000.0f);
            if (cR > this.duration) {
                this.duration = cR;
            }
            AppMethodBeat.o(190666);
        }

        private final int getMediaFormatInt(MediaFormat mediaFormat, String str, int i2) {
            AppMethodBeat.i(190667);
            if (mediaFormat == null) {
                AppMethodBeat.o(190667);
                return i2;
            } else if (mediaFormat.containsKey(str)) {
                int integer = mediaFormat.getInteger(str);
                AppMethodBeat.o(190667);
                return integer;
            } else {
                AppMethodBeat.o(190667);
                return i2;
            }
        }

        @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
        public final void release() {
            AppMethodBeat.i(190668);
            SightVideoJNI.releaseRecorderBufferRefLock("clear");
            SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
            this.isStarted = false;
            AppMethodBeat.o(190668);
        }

        @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
        public final int audioTrackIndex() {
            return this.audioId;
        }

        @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
        public final int videoTrackIndex() {
            return this.videoId;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x00d5  */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x0048  */
        @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int addTrack(android.media.MediaFormat r7) {
            /*
            // Method dump skipped, instructions count: 228
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.model.TAVKitMuxer.SightVideoJNIMediaMuxer.addTrack(android.media.MediaFormat):int");
        }

        private final void flushPendingVideoDts() {
            AppMethodBeat.i(190670);
            TAVKitMuxer tAVKitMuxer = TAVKitMuxer.Gzj;
            Log.i(TAVKitMuxer.TAG, "flushPendingVideoDts size:" + this.pendingVideoDts.size());
            Iterator<Long> it = this.pendingVideoDts.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                p.g(next, "dts");
                doWriteVideoDts(next.longValue());
            }
            this.pendingVideoDts.clear();
            AppMethodBeat.o(190670);
        }

        private final void doWriteVideoDts(long j2) {
            AppMethodBeat.i(190671);
            if (this.dtsCount == 0) {
                SightVideoJNI.writeDtsDataLock(this.bufId, ((long) (kotlin.h.a.cR(1000.0f / this.videoFps) * -1)) * 1000);
                this.dtsCount++;
            }
            SightVideoJNI.writeDtsDataLock(this.bufId, j2);
            this.dtsCount++;
            AppMethodBeat.o(190671);
        }

        public final int getBufId() {
            return this.bufId;
        }
    }
}
