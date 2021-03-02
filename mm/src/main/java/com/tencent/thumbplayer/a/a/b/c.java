package com.tencent.thumbplayer.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPSurfaceRenderInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.thumbplayer.core.common.TPSubtitleFrame;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.core.player.TPNativePlayerSurfaceRenderInfo;
import com.tencent.thumbplayer.utils.d;
import com.tencent.thumbplayer.utils.g;

public final class c {
    private static String TAG = "TPThumbPlayerUtils";

    public static class a {
        int RYp;
        int RYq;

        public a(int i2, int i3) {
            this.RYp = i2;
            this.RYq = i3;
        }
    }

    public static TPPlayerMsg.TPVideoCropInfo a(ITPNativePlayerMessageCallback.VideoCropInfo videoCropInfo) {
        AppMethodBeat.i(188981);
        if (videoCropInfo == null) {
            AppMethodBeat.o(188981);
            return null;
        }
        TPPlayerMsg.TPVideoCropInfo tPVideoCropInfo = new TPPlayerMsg.TPVideoCropInfo();
        tPVideoCropInfo.width = videoCropInfo.width;
        tPVideoCropInfo.height = videoCropInfo.height;
        tPVideoCropInfo.cropLeft = videoCropInfo.cropLeft;
        tPVideoCropInfo.cropRight = videoCropInfo.cropRight;
        tPVideoCropInfo.cropTop = videoCropInfo.cropTop;
        tPVideoCropInfo.cropBottom = videoCropInfo.cropBottom;
        AppMethodBeat.o(188981);
        return tPVideoCropInfo;
    }

    public static int aqZ(int i2) {
        int i3;
        AppMethodBeat.i(188982);
        switch (i2) {
            case 1:
                i3 = 1;
                break;
            case 2:
                i3 = 2;
                break;
            case 101:
                i3 = 101;
                break;
            case 102:
                i3 = 102;
                break;
            default:
                g.e(TAG, "decoderType: " + i2 + " not recognition, return -1");
                i3 = -1;
                break;
        }
        AppMethodBeat.o(188982);
        return i3;
    }

    public static TPVideoFrameBuffer a(TPVideoFrame tPVideoFrame) {
        AppMethodBeat.i(188983);
        TPVideoFrameBuffer tPVideoFrameBuffer = new TPVideoFrameBuffer();
        tPVideoFrameBuffer.data = tPVideoFrame.data;
        tPVideoFrameBuffer.lineSize = tPVideoFrame.linesize;
        tPVideoFrameBuffer.format = d.arE(tPVideoFrame.format);
        tPVideoFrameBuffer.srcHeight = tPVideoFrame.height;
        tPVideoFrameBuffer.srcWidth = tPVideoFrame.width;
        tPVideoFrameBuffer.dstHeight = tPVideoFrame.height;
        tPVideoFrameBuffer.dstWidth = tPVideoFrame.width;
        if (tPVideoFrame.sampleAspectRatioDen > 0 && tPVideoFrame.sampleAspectRatioNum > 0) {
            tPVideoFrameBuffer.dstWidth = Math.round((((float) tPVideoFrame.sampleAspectRatioNum) / ((float) tPVideoFrame.sampleAspectRatioDen)) * ((float) tPVideoFrameBuffer.dstWidth));
        }
        tPVideoFrameBuffer.rotation = tPVideoFrame.rotation;
        tPVideoFrameBuffer.ptsMs = tPVideoFrame.ptsUs / 1000;
        AppMethodBeat.o(188983);
        return tPVideoFrameBuffer;
    }

    public static TPAudioFrameBuffer a(TPAudioFrame tPAudioFrame) {
        AppMethodBeat.i(188984);
        if (tPAudioFrame == null) {
            AppMethodBeat.o(188984);
            return null;
        }
        TPAudioFrameBuffer tPAudioFrameBuffer = new TPAudioFrameBuffer();
        tPAudioFrameBuffer.format = d.arF(tPAudioFrame.format);
        tPAudioFrameBuffer.data = tPAudioFrame.data;
        tPAudioFrameBuffer.size = tPAudioFrame.linesize;
        tPAudioFrameBuffer.sampleRate = tPAudioFrame.sampleRate;
        tPAudioFrameBuffer.channelLayout = tPAudioFrame.channelLayout;
        tPAudioFrameBuffer.ptsMs = tPAudioFrame.ptsUs / 1000;
        tPAudioFrameBuffer.nbSamples = tPAudioFrame.nbSamples;
        tPAudioFrameBuffer.channels = tPAudioFrame.channels;
        AppMethodBeat.o(188984);
        return tPAudioFrameBuffer;
    }

    public static TPSubtitleFrameBuffer a(TPSubtitleFrame tPSubtitleFrame) {
        int i2 = 26;
        AppMethodBeat.i(188985);
        if (tPSubtitleFrame == null) {
            AppMethodBeat.o(188985);
            return null;
        }
        TPSubtitleFrameBuffer tPSubtitleFrameBuffer = new TPSubtitleFrameBuffer();
        tPSubtitleFrameBuffer.data = tPSubtitleFrame.data;
        tPSubtitleFrameBuffer.lineSize = tPSubtitleFrame.linesize;
        int i3 = tPSubtitleFrame.format;
        if (-1 == i3 || 26 != i3) {
            i2 = -1;
        }
        tPSubtitleFrameBuffer.format = i2;
        tPSubtitleFrameBuffer.srcHeight = tPSubtitleFrame.height;
        tPSubtitleFrameBuffer.srcWidth = tPSubtitleFrame.width;
        tPSubtitleFrameBuffer.dstHeight = tPSubtitleFrame.height;
        tPSubtitleFrameBuffer.dstWidth = tPSubtitleFrame.width;
        tPSubtitleFrameBuffer.rotation = tPSubtitleFrame.rotation;
        tPSubtitleFrameBuffer.ptsMs = tPSubtitleFrame.ptsUs / 1000;
        AppMethodBeat.o(188985);
        return tPSubtitleFrameBuffer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.thumbplayer.api.TPPostProcessFrameBuffer a(com.tencent.thumbplayer.core.common.TPPostProcessFrame r7) {
        /*
        // Method dump skipped, instructions count: 133
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.a.a.b.c.a(com.tencent.thumbplayer.core.common.TPPostProcessFrame):com.tencent.thumbplayer.api.TPPostProcessFrameBuffer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.thumbplayer.core.common.TPPostProcessFrame c(com.tencent.thumbplayer.api.TPPostProcessFrameBuffer r7) {
        /*
        // Method dump skipped, instructions count: 223
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.a.a.b.c.c(com.tencent.thumbplayer.api.TPPostProcessFrameBuffer):com.tencent.thumbplayer.core.common.TPPostProcessFrame");
    }

    public static TPPlayerMsg.TPMediaCodecInfo a(ITPNativePlayerMessageCallback.MediaCodecInfo mediaCodecInfo) {
        AppMethodBeat.i(188988);
        if (mediaCodecInfo == null) {
            AppMethodBeat.o(188988);
            return null;
        }
        TPPlayerMsg.TPMediaCodecInfo tPMediaCodecInfo = new TPPlayerMsg.TPMediaCodecInfo();
        switch (mediaCodecInfo.mediaType) {
            case 0:
                tPMediaCodecInfo.mediaType = TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO;
                break;
            case 1:
                tPMediaCodecInfo.mediaType = TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_AUDIO;
                break;
            default:
                tPMediaCodecInfo.mediaType = TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_UNKNOWN;
                break;
        }
        switch (mediaCodecInfo.infoType) {
            case 0:
                tPMediaCodecInfo.infoType = TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY;
                break;
            case 1:
                tPMediaCodecInfo.infoType = TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION;
                break;
            default:
                tPMediaCodecInfo.infoType = TPPlayerMsg.TPMediaCodecInfo.TP_INFO_UNKNOWN;
                break;
        }
        tPMediaCodecInfo.msg = mediaCodecInfo.msg;
        AppMethodBeat.o(188988);
        return tPMediaCodecInfo;
    }

    public static TPSurfaceRenderInfo a(TPNativePlayerSurfaceRenderInfo tPNativePlayerSurfaceRenderInfo) {
        TPSurfaceRenderInfo.TPVideoCropInfo tPVideoCropInfo = null;
        AppMethodBeat.i(188989);
        if (tPNativePlayerSurfaceRenderInfo == null) {
            AppMethodBeat.o(188989);
            return null;
        }
        TPSurfaceRenderInfo tPSurfaceRenderInfo = new TPSurfaceRenderInfo();
        tPSurfaceRenderInfo.displayWidth = tPNativePlayerSurfaceRenderInfo.displayWidth;
        tPSurfaceRenderInfo.displayHeight = tPNativePlayerSurfaceRenderInfo.displayHeight;
        TPNativePlayerSurfaceRenderInfo.TPVideoCropInfo tPVideoCropInfo2 = tPNativePlayerSurfaceRenderInfo.videoCropInfo;
        if (tPVideoCropInfo2 != null) {
            tPVideoCropInfo = new TPSurfaceRenderInfo.TPVideoCropInfo();
            tPVideoCropInfo.cropLeft = tPVideoCropInfo2.cropLeft;
            tPVideoCropInfo.cropRight = tPVideoCropInfo2.cropRight;
            tPVideoCropInfo.cropTop = tPVideoCropInfo2.cropTop;
            tPVideoCropInfo.cropBottom = tPVideoCropInfo2.cropBottom;
            tPVideoCropInfo.width = tPVideoCropInfo2.width;
            tPVideoCropInfo.height = tPVideoCropInfo2.height;
        }
        tPSurfaceRenderInfo.videoCropInfo = tPVideoCropInfo;
        AppMethodBeat.o(188989);
        return tPSurfaceRenderInfo;
    }
}
