package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.segment.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.tav.decoder.EncoderWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(18)
public final class p extends a {
    private int bufId;
    private a.C1481a zzE;
    private a.C1481a zzF;

    @Override // com.tencent.mm.plugin.mmsight.segment.f, com.tencent.mm.plugin.mmsight.segment.a
    public final void b(String str, String str2, VideoTransPara videoTransPara) {
        AppMethodBeat.i(107691);
        super.b(str, str2, videoTransPara);
        AppMethodBeat.o(107691);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.f, com.tencent.mm.plugin.mmsight.segment.a
    public final int ab(long j2, long j3) {
        AppMethodBeat.i(107692);
        m.QP(h.getDecoderType());
        int ab = super.ab(j2, j3);
        if (ab == -1) {
            m.QQ(h.getDecoderType());
        }
        AppMethodBeat.o(107692);
        return ab;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mmsight.segment.a
    public final int a(c cVar, List<a.C1481a> list, List<a.C1481a> list2) {
        int i2;
        AppMethodBeat.i(107693);
        this.zzE = list2.get(0);
        if (!(list == null || list.size() == 0)) {
            this.zzF = list.get(0);
        }
        if (this.jtH <= 0) {
            i2 = 1048576;
        } else {
            i2 = this.jtH;
        }
        if (a(cVar, i2, this.bufId, this.jtD) == -1) {
            Log.e("VideoClipperAPI18", "transcodeAndMux error");
            release();
            AppMethodBeat.o(107693);
            return -1;
        }
        AppMethodBeat.o(107693);
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x030c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(com.tencent.mm.compatible.i.c r17, int r18, int r19, java.lang.String r20) {
        /*
        // Method dump skipped, instructions count: 938
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.p.a(com.tencent.mm.compatible.i.c, int, int, java.lang.String):int");
    }

    private boolean a(c cVar, int i2, int i3) {
        AppMethodBeat.i(107695);
        if (this.zzF == null) {
            AppMethodBeat.o(107695);
            return false;
        }
        cVar.selectTrack(this.zzF.index);
        cVar.seekTo(this.cwj * 1000, 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        try {
            this.zzF.mediaFormat.getInteger("channel-count");
        } catch (Exception e2) {
            Log.e("VideoClipperAPI18", "get channel count error: %s", 1);
        }
        Log.i("VideoClipperAPI18", "audio channel count");
        if (CaptureMMProxy.getInstance().getInt(ar.a.USERINFO_LOCAL_SIGHT_COMPRESS_TO_SINGLE_CHANNEL_INT_SYNC, 0) == 1) {
            g gVar = new g(cVar, this.zzF.mediaFormat, this.cwj, this.jtG, this.jtF);
            gVar.zyq = true;
            try {
                gVar.zyo = z.DZ(gVar.mime);
                gVar.zyo.a(gVar.jtq, (Surface) null, 0);
                gVar.zyo.start();
                gVar.jtq = gVar.zyo.getOutputFormat();
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e3, "init decoder error: %s", e3.getMessage());
            }
            try {
                gVar.ieU = new MediaFormat();
                gVar.ieU.setString("mime", EncoderWriter.OUTPUT_AUDIO_MIME_TYPE);
                gVar.ieU.setInteger("aac-profile", 2);
                gVar.ieU.setInteger("sample-rate", gVar.jtV.audioSampleRate);
                gVar.ieU.setInteger("channel-count", 1);
                gVar.ieU.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, gVar.jtV.audioBitrate);
                gVar.ieU.setInteger("max-input-size", 16384);
                gVar.zyp = z.q(gVar.mime, false);
                gVar.zyp.a(gVar.ieU, (Surface) null, 1);
                gVar.zyo.start();
            } catch (Exception e4) {
                Log.e("MicroMsg.MediaCodecAACTranscoder", "init encoder error: %s", e4.getMessage());
                gVar.zyq = false;
                gVar.zyr = new ArrayList();
                gVar.zyp.release();
                gVar.zyp = null;
            }
            Log.i("MicroMsg.MediaCodecAACTranscoder", "init finish, canEncodeDecodeBothExist: %s", Boolean.valueOf(gVar.zyq));
            gVar.eku();
            AppMethodBeat.o(107695);
            return true;
        }
        while (true) {
            allocateDirect.clear();
            int readSampleData = cVar.readSampleData(allocateDirect, 0);
            Log.d("VideoClipperAPI18", "sampleSize: %d", Integer.valueOf(readSampleData));
            if (readSampleData <= 0) {
                Log.i("VideoClipperAPI18", "VideoClipperAPI18.muxAudio size = %d. Saw eos.", Integer.valueOf(readSampleData));
                break;
            } else if (cVar.gLF.getSampleTime() >= this.jtG * 1000) {
                break;
            } else if (cVar.gLF.getSampleTrackIndex() != this.zzF.index) {
                Log.e("VideoClipperAPI18", "track index not match! break");
                break;
            } else {
                allocateDirect.position(0);
                MP4MuxerJNI.writeAACData(i3, allocateDirect, readSampleData);
                cVar.gLF.advance();
            }
        }
        AppMethodBeat.o(107695);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x007e  */
    @Override // com.tencent.mm.plugin.mmsight.segment.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int QZ(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 135
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.p.QZ(java.lang.String):int");
    }
}
