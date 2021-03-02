package com.tencent.mm.media.i;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.e;
import com.tencent.mm.plugin.mmsight.model.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001BU\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eB5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u0010J\u0006\u0010\u001d\u001a\u00020\u0006J6\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\nJ\u0006\u0010$\u001a\u00020%J$\u0010&\u001a\u00020%2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u0003J \u0010&\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.J\u0016\u0010/\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u000e\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020\u0003J\u0014\u00102\u001a\u00020%2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000304R\u000e\u0010\u0011\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u000e\u0010\u000f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/media/remuxer/MixMuxerController;", "", "remuxStartTime", "", "remuxEndTime", "outputBitrate", "", "outputVideoWidth", "outputVideoHeight", "useX264Encode", "", "outputFps", "", "enableHevc", "(JJIIIZFZ)V", "useSoftEncode", "(JJIZZ)V", "TAG", "", "aacSampleRate", "bufId", "channelCount", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "frameCount", "isRelease", "isUseFFmpegMuxer", "getRemuxEndTime", "()J", "getRemuxStartTime", "getBufID", "output", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "muxOuputFilePath", "sampleRate", "mute", "release", "", "writeAudioData", "startTime", "endTime", "encodeData", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "writeVideoData", "writeVideoDts", "dts", "writeVideoDtsList", "dtsList", "", "plugin-mediaeditor_release"})
public final class i {
    private final String TAG;
    public int bufId;
    private int duration;
    private int frameCount;
    private boolean ife;
    public final long iho;
    private final boolean iiC;
    private final boolean iiD;
    private final int iix;
    private float ijj;
    private int ijk;
    private int ijl;
    private boolean ijm;
    public final long remuxEndTime;

    public /* synthetic */ i(long j2, long j3, int i2, boolean z) {
        this(j2, j3, i2, z, false);
    }

    private i(long j2, long j3, int i2, boolean z, boolean z2) {
        AppMethodBeat.i(93832);
        this.iho = j2;
        this.remuxEndTime = j3;
        this.iix = i2;
        this.iiC = z;
        this.iiD = z2;
        this.TAG = "MicroMsg.MixMuxerController";
        this.duration = (int) (this.remuxEndTime - this.iho);
        if (this.duration != 0 && !this.iiC) {
            this.bufId = SightVideoJNI.initDataBufferForRemux(this.iiD);
        }
        this.ife = false;
        this.ijm = b.aj(this.iiC, this.iiD);
        Log.i(this.TAG, "init endTime:" + this.remuxEndTime + ", startTime:" + this.iho + ", duration:" + this.duration + ", bufId:" + this.bufId + ", enableHevc:" + this.iiD);
        AppMethodBeat.o(93832);
    }

    public i(long j2, long j3, int i2, int i3, int i4, boolean z, float f2, boolean z2) {
        this(j2, j3, i2, z, z2);
        AppMethodBeat.i(93833);
        this.ijj = f2;
        this.ijk = i3;
        this.ijl = i4;
        Log.i(this.TAG, "secondary create MixMuxerController, outputFps:" + f2 + ", outputVideoWidth:" + i3 + ", outputVideoHeight:" + i4 + ", enableHevc:" + z2);
        this.duration = (int) (j3 - j2);
        if (this.duration != 0) {
            if (z) {
                this.bufId = SightVideoJNI.initDataBufferForMMSightLock(i3, i4, 0, i3, i4, f2, i2, z2 ? 5 : 1, 8, 2, 23.0f, false, true, this.duration, false, z2, b.aj(true, z2));
            } else {
                this.bufId = SightVideoJNI.initDataBufferForRemux(z2);
            }
        }
        this.ife = false;
        this.ijm = b.aj(z, z2);
        Log.i(this.TAG, "secondary init endTime:" + j3 + ", startTime:" + j2 + ", duration:" + this.duration + ", bufId:" + this.bufId);
        AppMethodBeat.o(93833);
    }

    public /* synthetic */ i(long j2, long j3, int i2, int i3, int i4, boolean z, float f2) {
        this(j2, j3, i2, i3, i4, z, f2, false);
    }

    public final void g(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(93826);
        p.h(byteBuffer, "encodeData");
        p.h(bufferInfo, "bufferInfo");
        if (this.ife) {
            Log.e(this.TAG, "writeVideoData, already release");
            AppMethodBeat.o(93826);
            return;
        }
        Log.i(this.TAG, "writeH264Data: " + byteBuffer.capacity() + ", " + bufferInfo.size + ", bufId:" + this.bufId + ", pts:" + bufferInfo.presentationTimeUs);
        SightVideoJNI.writeH264DataLock(this.bufId, byteBuffer, bufferInfo.size, bufferInfo.presentationTimeUs);
        this.frameCount++;
        Log.i(this.TAG, "frameCount: " + this.frameCount);
        AppMethodBeat.o(93826);
    }

    public final void zJ(long j2) {
        AppMethodBeat.i(218757);
        if (this.ife) {
            Log.e(this.TAG, "writeVideoDts, already release");
            AppMethodBeat.o(218757);
            return;
        }
        Log.i(this.TAG, "writeVideoDts: ".concat(String.valueOf(j2)));
        SightVideoJNI.writeDtsDataLock(this.bufId, j2);
        AppMethodBeat.o(218757);
    }

    public final void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, MediaFormat mediaFormat) {
        int i2 = 1;
        AppMethodBeat.i(93827);
        p.h(byteBuffer, "encodeData");
        p.h(bufferInfo, "bufferInfo");
        if (this.ife) {
            Log.e(this.TAG, "writeAACData, already release");
            AppMethodBeat.o(93827);
        } else if (this.ijm) {
            int i3 = this.bufId;
            int i4 = bufferInfo.size;
            long j2 = bufferInfo.presentationTimeUs;
            int integer = (mediaFormat == null || !mediaFormat.containsKey("aac-profile")) ? 2 : mediaFormat.getInteger("aac-profile");
            int QL = (mediaFormat == null || !mediaFormat.containsKey("sample-rate")) ? 4 : a.QL(mediaFormat.getInteger("sample-rate"));
            if (mediaFormat != null && mediaFormat.containsKey("channel-count")) {
                i2 = mediaFormat.getInteger("channel-count");
            }
            SightVideoJNI.writeAACDataWithADTSLock(i3, byteBuffer, i4, j2, integer, QL, i2);
            AppMethodBeat.o(93827);
        } else {
            Log.i(this.TAG, "writeAACData: " + byteBuffer.capacity() + ", " + bufferInfo.size + ", bufId:" + this.bufId);
            SightVideoJNI.writeAACDataLock(this.bufId, byteBuffer, bufferInfo.size, bufferInfo.presentationTimeUs);
            AppMethodBeat.o(93827);
        }
    }

    public final int a(com.tencent.mm.media.f.a aVar, String str, int i2, int i3, boolean z) {
        int i4;
        int i5;
        boolean z2;
        AppMethodBeat.i(93828);
        p.h(str, "muxOuputFilePath");
        if (this.ife) {
            Log.e(this.TAG, "output, already release");
            AppMethodBeat.o(93828);
            return -1;
        } else if (this.frameCount > 0 || this.iiC) {
            Log.i(this.TAG, "sampelRate:" + i2 + ", channelCount:" + i3);
            boolean z3 = false;
            if (i2 == 0 || i3 == 0) {
                if (aVar != null) {
                    int i6 = aVar.audioTrackIndex;
                    String aMt = aVar.aMt();
                    MediaFormat mediaFormat = aVar.igi;
                    if (i6 >= 0 && mediaFormat != null && !Util.isNullOrNil(aMt)) {
                        int integer = mediaFormat.getInteger("channel-count");
                        i5 = mediaFormat.getInteger("sample-rate");
                        i4 = integer;
                    }
                }
                z3 = true;
                i5 = i2;
                i4 = i3;
            } else {
                i5 = i2;
                i4 = i3;
            }
            float f2 = (((float) this.frameCount) * 1000.0f) / ((float) this.duration);
            if (i4 > 0 || i5 > 0) {
                z2 = z3;
            } else {
                z2 = true;
            }
            Log.i(this.TAG, "output, fps:" + f2 + ", frameCount:" + this.frameCount + ", outputBitrate:" + this.iix + ", finalChannelCount:" + i4 + ", finalSampleRate:" + i5 + ", outputPath:" + str + ", bufId:" + this.bufId + ", mute:" + z + ", videoMute:" + z2 + ", mediaExtractor:" + aVar);
            int muxingLock = SightVideoJNI.muxingLock(this.bufId, null, i5, 1024, 2, i4, 0, str, f2, Math.max(1000, this.duration), this.iix, c.Dma, 8, 2, 23.0f, null, 0, false, z || z2, this.iiC, this.iiD, b.aj(this.iiC, this.iiD));
            release();
            if (muxingLock < 0) {
                e eVar = e.ilC;
                e.aOS();
            }
            AppMethodBeat.o(93828);
            return muxingLock;
        } else {
            Log.e(this.TAG, "output, no write h264 frame!!");
            e eVar2 = e.ilC;
            e.aOR();
            AppMethodBeat.o(93828);
            return -1;
        }
    }

    public final void release() {
        AppMethodBeat.i(93829);
        SightVideoJNI.releaseRecorderBufferRefLock("clear");
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.ife = true;
        AppMethodBeat.o(93829);
    }

    public static /* synthetic */ void a(i iVar, com.tencent.mm.media.f.a aVar) {
        AppMethodBeat.i(93831);
        iVar.a(aVar, iVar.iho, iVar.remuxEndTime);
        AppMethodBeat.o(93831);
    }

    private void a(com.tencent.mm.media.f.a aVar, long j2, long j3) {
        int i2;
        AppMethodBeat.i(93830);
        if (aVar == null) {
            AppMethodBeat.o(93830);
        } else if (this.ife) {
            Log.e(this.TAG, "writeAudioData, already release");
            AppMethodBeat.o(93830);
        } else if (aVar.ife) {
            Log.e(this.TAG, "writeAudioData, mediaExtractor already release");
            AppMethodBeat.o(93830);
        } else {
            int i3 = aVar.audioTrackIndex;
            String aMt = aVar.aMt();
            MediaFormat mediaFormat = aVar.igi;
            if (i3 < 0 || mediaFormat == null || Util.isNullOrNil(aMt)) {
                AppMethodBeat.o(93830);
                return;
            }
            Log.i(this.TAG, "writeAudioData, startTime: ".concat(String.valueOf(j2)));
            aVar.aMr();
            if (j2 > 0) {
                Log.i(this.TAG, "writeAudioData, seek to startTime:" + this.iho);
                aVar.seek(1000 * j2);
            }
            if (mediaFormat.containsKey("max-input-size")) {
                i2 = mediaFormat.getInteger("max-input-size");
            } else {
                i2 = 1024;
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
            while (true) {
                try {
                    allocateDirect.clear();
                    p.g(allocateDirect, "dstBuf");
                    com.tencent.mm.media.f.a.a(aVar, allocateDirect);
                    int i4 = aVar.sampleSize;
                    Log.d(this.TAG, "sampleSize: %d", Integer.valueOf(i4));
                    if (i4 <= 0) {
                        Log.i(this.TAG, "muxAudio size = %d. Saw eos.", Integer.valueOf(i4));
                        AppMethodBeat.o(93830);
                        return;
                    }
                    long sampleTime = aVar.getSampleTime();
                    Log.i(this.TAG, "aac pts:".concat(String.valueOf(sampleTime)));
                    if (sampleTime >= 1000 * j3) {
                        Log.i(this.TAG, "pts exceed endTime");
                        AppMethodBeat.o(93830);
                        return;
                    } else if (aVar.igg.getSampleTrackIndex() != i3) {
                        Log.e(this.TAG, "track index not match! break");
                        AppMethodBeat.o(93830);
                        return;
                    } else if (sampleTime < 1000 * j2) {
                        Log.i(this.TAG, "not reach start");
                    } else {
                        allocateDirect.position(0);
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        bufferInfo.set(0, i4, sampleTime, 0);
                        a(allocateDirect, bufferInfo, mediaFormat);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace(this.TAG, e2, "writeAudioData error", new Object[0]);
                    AppMethodBeat.o(93830);
                    return;
                }
            }
        }
    }
}
