package com.tencent.wxmm;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Surface;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

public class v2encoder {
    public static int EMethodGetQosPara = 25;
    public static final int EMethodGetRemoteHW = 26;
    public static final int ENUM_AVCEncCfgERROR = 2003;
    public static final int ENUM_AVCEncCreateERROR = 2002;
    public static final int ENUM_AVCEncERROR = 2004;
    public static final int ENUM_AVCEncNotFound = 2001;
    public static final int ENUM_AVCEncOK = 2000;
    public static final boolean SAVEVIDEOSTREAM = true;
    public static short[] SizeFormat2WH = {128, 96, 240, 160, 320, 240, 480, 360, 640, 480};
    private static final String TAG = "v2encoder";
    public static final int VFMT_420SP = 7;
    public static final int VFMT_HEVC_HW = 19;
    public static final int VFMT_ROTATE = 32;
    public static final int VFMT_i264 = 18;
    public static final byte enumCODEC_Vcodec2_hw = 4;
    public static final byte enumCODEC_f264 = 1;
    public static final byte enumCODEC_i264 = 8;
    public static final byte enumCODEC_vcodec2 = 16;
    public static int frameID = 0;
    private static String path = Environment.getExternalStorageDirectory().getAbsolutePath();
    private static int streamqueuesize = 100;
    private static final String[] supportedH264HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos.", "OMX.hisi"};
    public String ENCODING = "hevc";
    private int TIMEOUT_USEC = 12000;
    public byte[] configbyte = null;
    public int encLen = 0;
    public boolean isRuning = false;
    public long mGeneratedIdx = 0;
    int mPrevResolution = 8;
    int mProfileCfg = 1;
    public v2service mProtocol;
    int m_CapH;
    int m_CapW;
    int m_br_kbps;
    int m_framerate;
    int m_height;
    int m_width;
    private MediaCodec mediaCodec = null;
    protected MediaFormat mediaFormat;
    private BufferedOutputStream outputStream;
    v2stqos stQoS;

    static {
        AppMethodBeat.i(40791);
        AppMethodBeat.o(40791);
    }

    public static class Frame {
        public byte[] frameData = null;
        public int id;
        public int type = 0;

        public Frame(int i2) {
            this.id = i2;
        }
    }

    @SuppressLint({"NewApi"})
    private boolean SupportAvcCodec(String str, int i2) {
        AppMethodBeat.i(40775);
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 18) {
            for (int codecCount = MediaCodecList.getCodecCount() - 1; codecCount >= 0; codecCount--) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(codecCount);
                new StringBuilder("codecInfo : ").append(codecInfoAt.getName());
                if (codecInfoAt.isEncoder()) {
                    String[] supportedTypes = codecInfoAt.getSupportedTypes();
                    String name = codecInfoAt.getName();
                    for (String str2 : supportedTypes) {
                        if (str2.equalsIgnoreCase(str)) {
                            for (String str3 : supportedH264HwCodecPrefixes) {
                                if (name.startsWith(str3)) {
                                    try {
                                        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = codecInfoAt.getCapabilitiesForType(str).profileLevels;
                                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
                                            if (codecProfileLevel.profile == i2) {
                                                z = true;
                                            }
                                            new StringBuilder("steve : supported profiles:").append(codecProfileLevel.profile).append(", MIME:").append(str);
                                        }
                                    } catch (Exception e2) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(40775);
        return z;
    }

    private MediaCodecInfo selectCodec(String str) {
        AppMethodBeat.i(40776);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                new StringBuilder("selectCodec one : ").append(i2).append(supportedTypes);
                for (int i3 = 0; i3 < supportedTypes.length; i3++) {
                    if (supportedTypes[i3].equalsIgnoreCase(str)) {
                        new StringBuilder("selectCodec two : ").append(i3).append(codecInfoAt.getName());
                        AppMethodBeat.o(40776);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(40776);
        return null;
    }

    private void trySetProfile(MediaCodecInfo mediaCodecInfo) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        AppMethodBeat.i(40777);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(this.ENCODING);
                if (!(capabilitiesForType == null || (codecProfileLevelArr = capabilitiesForType.profileLevels) == null)) {
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel.level = 0;
                    codecProfileLevel.profile = 0;
                    for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                        int i2 = codecProfileLevel2.profile;
                        int i3 = codecProfileLevel2.level;
                        new StringBuilder("profile: ").append(i2).append(", level: ").append(i3);
                        if (isRecognizedProfile(i2) && i2 >= codecProfileLevel.profile && i3 >= codecProfileLevel.level) {
                            codecProfileLevel.profile = i2;
                            codecProfileLevel.level = i3;
                        }
                    }
                    new StringBuilder("best profile: ").append(codecProfileLevel.profile).append(", best level: ").append(codecProfileLevel.level);
                    if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                        this.mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                        this.mediaFormat.setInteger("level", 256);
                    }
                }
                AppMethodBeat.o(40777);
                return;
            } catch (Exception e2) {
                new StringBuilder("trySetProfile error: ").append(e2.getMessage());
            }
        }
        AppMethodBeat.o(40777);
    }

    @SuppressLint({"NewApi"})
    private void trySetBitRateMode(MediaCodecInfo mediaCodecInfo) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        MediaCodecInfo.EncoderCapabilities encoderCapabilities;
        AppMethodBeat.i(40778);
        try {
            if (!(Build.VERSION.SDK_INT <= 21 || (capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(this.ENCODING)) == null || (encoderCapabilities = capabilitiesForType.getEncoderCapabilities()) == null)) {
                if (encoderCapabilities.isBitrateModeSupported(2)) {
                    this.mediaFormat.setInteger("bitrate-mode", 2);
                    AppMethodBeat.o(40778);
                    return;
                } else if (encoderCapabilities.isBitrateModeSupported(1)) {
                    this.mediaFormat.setInteger("bitrate-mode", 1);
                }
            }
            AppMethodBeat.o(40778);
        } catch (Exception e2) {
            new StringBuilder("trySetBitRateMode error: ").append(e2.getMessage());
            AppMethodBeat.o(40778);
        }
    }

    private boolean isRecognizedProfile(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 8:
                return true;
            default:
                return false;
        }
    }

    @SuppressLint({"NewApi"})
    public int StartEncoder() {
        AppMethodBeat.i(40779);
        if (this.mediaCodec != null) {
            StopEncoder();
        }
        MediaCodecInfo selectCodec = selectCodec(this.ENCODING);
        if (selectCodec == null) {
            new StringBuilder("steve: Unable to find an appropriate codec for ").append(this.ENCODING);
            AppMethodBeat.o(40779);
            return -2001;
        }
        new StringBuilder("steve: found HW codec: ").append(selectCodec.getName());
        this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
        this.mediaFormat.setInteger("color-format", 21);
        this.mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.m_br_kbps * 1000);
        this.mediaFormat.setInteger("frame-rate", this.m_framerate);
        this.mediaFormat.setInteger("i-frame-interval", 1);
        String string = this.mediaFormat.getString("mime");
        if (this.ENCODING.equalsIgnoreCase("video/avc")) {
            boolean z = (this.mProfileCfg & 4) != 0;
            if (Build.VERSION.SDK_INT < 23 || !z) {
                if (selectCodec != null) {
                    trySetProfile(selectCodec);
                }
            } else if (SupportAvcCodec(string, 8)) {
                this.mediaFormat.setInteger(Scopes.PROFILE, 8);
            }
        }
        this.mediaFormat.setInteger("bitrate-mode", 2);
        try {
            this.mediaCodec = MediaCodec.createEncoderByType(string);
            new StringBuilder("steve: mediaFormat: ").append(this.mediaFormat);
            this.mediaCodec.configure(this.mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            this.mediaCodec.start();
            AppMethodBeat.o(40779);
            return 2000;
        } catch (Exception e2) {
            new StringBuilder(" error392:").append(e2.toString());
            AppMethodBeat.o(40779);
            return -2002;
        }
    }

    public v2encoder(int i2, int i3, int i4, int i5, int i6, v2service v2service) {
        AppMethodBeat.i(40780);
        this.m_width = i2;
        this.m_height = i3;
        this.m_CapW = i2;
        this.m_CapH = i3;
        this.mProtocol = v2service;
        this.m_framerate = i4;
        this.m_br_kbps = i5;
        this.mProfileCfg = i6;
        frameID = 0;
        this.mGeneratedIdx = 0;
        this.stQoS = new v2stqos();
        AppMethodBeat.o(40780);
    }

    public int InitHWEncoder(boolean z) {
        int i2;
        AppMethodBeat.i(40781);
        this.ENCODING = z ? "video/avc" : TPDecoderType.TP_CODEC_MIMETYPE_HEVC;
        byte[] bArr = new byte[4];
        bArr[0] = 0;
        this.mProtocol.setAppCmd(26, bArr, 4);
        new StringBuilder("InitHWEncoder remoteHW: ").append((int) bArr[0]).append((int) bArr[1]).append((int) bArr[2]).append((int) bArr[3]);
        if (z) {
            if ((bArr[0] & 1) == 0 && (bArr[0] & 8) == 0) {
                AppMethodBeat.o(40781);
                return -2;
            }
        } else if ((bArr[0] & enumCODEC_vcodec2) == 0 && (bArr[0] & 4) == 0) {
            AppMethodBeat.o(40781);
            return -3;
        }
        try {
            i2 = StartEncoder();
        } catch (Exception e2) {
            new StringBuilder("mediacodec init error: ").append(e2.getMessage());
            i2 = -2003;
        }
        if (i2 < 0) {
            AppMethodBeat.o(40781);
            return i2;
        }
        createfile(path + "/AVLog/mediacodec.h264");
        AppMethodBeat.o(40781);
        return i2;
    }

    private void createfile(String str) {
        AppMethodBeat.i(40782);
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            this.outputStream = new BufferedOutputStream(new FileOutputStream(file));
            AppMethodBeat.o(40782);
        } catch (Exception e2) {
            new StringBuilder(" error510:").append(e2.toString());
            AppMethodBeat.o(40782);
        }
    }

    @SuppressLint({"NewApi"})
    private void StopEncoder() {
        AppMethodBeat.i(40783);
        try {
            if (this.mediaCodec != null) {
                this.mediaCodec.stop();
                this.mediaCodec.release();
            }
            AppMethodBeat.o(40783);
        } catch (Exception e2) {
            new StringBuilder(" error523:").append(e2.toString());
            AppMethodBeat.o(40783);
        }
    }

    public void UninitHWEncoder() {
        AppMethodBeat.i(40784);
        this.isRuning = false;
        try {
            StopEncoder();
            if (this.outputStream != null) {
                this.outputStream.flush();
                this.outputStream.close();
            }
            AppMethodBeat.o(40784);
        } catch (Exception e2) {
            new StringBuilder(" error401:").append(e2.toString());
            AppMethodBeat.o(40784);
        }
    }

    public int DoMediacodecEnc(byte[] bArr, int i2) {
        int i3;
        int i4 = 0;
        AppMethodBeat.i(40785);
        byte[] bArr2 = null;
        new StringBuilder("steve: m_framerate: ").append(this.m_framerate).append(", m_br_kbps:").append(this.m_br_kbps).append(" cwh ").append(this.m_CapW).append(this.m_CapH).append(" ewh ").append(this.m_width).append(this.m_height);
        if (this.stQoS.cSkipFlag == 0) {
            bArr2 = new byte[(((this.m_CapW * this.m_CapH) * 3) / 2)];
            NV21ToNV12(bArr, bArr2, this.m_width, this.m_height, i2 & 32);
            this.encLen = ((this.m_width * this.m_height) * 3) >> 1;
            if (!(this.m_width == this.m_width && this.m_height == this.m_height)) {
                this.encLen = ((this.m_width * this.m_height) * 3) >> 1;
                try {
                    i3 = StartEncoder();
                } catch (Exception e2) {
                    new StringBuilder("mediacodec init error: ").append(e2.getMessage());
                    i3 = -2003;
                }
                if (i3 < 0) {
                    UninitHWEncoder();
                    AppMethodBeat.o(40785);
                    return i3;
                }
                i4 = i3;
            }
        }
        if (bArr2 != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                ByteBuffer[] inputBuffers = this.mediaCodec.getInputBuffers();
                ByteBuffer[] outputBuffers = this.mediaCodec.getOutputBuffers();
                int dequeueInputBuffer = this.mediaCodec.dequeueInputBuffer(-1);
                if (dequeueInputBuffer >= 0) {
                    long computePresentationTime = computePresentationTime(this.mGeneratedIdx);
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    byteBuffer.put(bArr2, 0, this.encLen);
                    this.mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, this.encLen, computePresentationTime, 0);
                    this.mGeneratedIdx++;
                }
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, (long) this.TIMEOUT_USEC);
                new StringBuilder("put YUV into encoder, size:").append(this.encLen).append(", idx:").append(frameID).append(", time:").append(currentTimeMillis).append("outbuf: ").append(dequeueOutputBuffer);
                i3 = i4;
                while (dequeueOutputBuffer >= 0) {
                    new StringBuilder("Get H264 Buffer Success! flag = ").append(bufferInfo.flags).append(", enc size = ").append(bufferInfo.size).append(",pts = ").append(bufferInfo.presentationTimeUs);
                    ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                    byte[] bArr3 = new byte[bufferInfo.size];
                    byteBuffer2.get(bArr3);
                    if (this.outputStream != null) {
                        this.outputStream.write(bArr3, 0, bArr3.length);
                    }
                    putH2645Data(bArr3, bufferInfo.flags, bArr3.length);
                    new StringBuilder("Protobuf  ").append(bufferInfo.size).append(" : ").append(bArr3.length);
                    i3 = bufferInfo.flags;
                    frameID++;
                    this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, (long) this.TIMEOUT_USEC);
                }
            } catch (Exception e3) {
                new StringBuilder(" error495:").append(e3.toString());
                i3 = -2004;
            }
        } else {
            i3 = i4;
        }
        AppMethodBeat.o(40785);
        return i3;
    }

    public void DoQosSvrCtrl() {
        AppMethodBeat.i(40786);
        if (this.mProtocol != null) {
            if (this.mProtocol.setAppCmd(EMethodGetQosPara, this.stQoS.s2p, this.stQoS.s2p.length) >= 0) {
                this.stQoS.parseS2PData();
                this.stQoS.printS2P();
            }
            if (this.stQoS.iKbps != this.m_br_kbps) {
                SetBitRate(this.m_br_kbps);
                this.m_br_kbps = this.stQoS.iKbps;
                new StringBuilder("steve[QoS]: Update BR! frameID: ").append(frameID).append(", new_br: ").append(this.m_br_kbps);
            }
            if (1 == this.stQoS.cIReqFlag) {
                MakeIFrame();
                new StringBuilder("steve[QoS]: Force I Frame! frameID: ").append(frameID);
            }
            if (this.stQoS.cFps != this.m_framerate) {
                this.m_framerate = this.stQoS.cFps;
            }
        }
        AppMethodBeat.o(40786);
    }

    @SuppressLint({"NewApi"})
    public boolean SetBitRate(int i2) {
        AppMethodBeat.i(40787);
        try {
            if (this.mediaCodec != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("video-bitrate", i2 * 1000);
                this.mediaCodec.setParameters(bundle);
                AppMethodBeat.o(40787);
                return true;
            }
        } catch (Exception e2) {
            new StringBuilder("steve: setRates failed:").append(e2);
        }
        AppMethodBeat.o(40787);
        return false;
    }

    @SuppressLint({"NewApi"})
    public void MakeIFrame() {
        AppMethodBeat.i(40788);
        if (this.mediaCodec != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("request-sync", 0);
            this.mediaCodec.setParameters(bundle);
        }
        AppMethodBeat.o(40788);
    }

    public void putH2645Data(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(40789);
        if (!(bArr == null || this.mProtocol == null)) {
            int i4 = 18;
            if (this.ENCODING.equalsIgnoreCase(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
                i4 = 19;
            }
            this.mProtocol.videoEncodeToSend(bArr, i3, this.m_width, i2, i4);
        }
        AppMethodBeat.o(40789);
    }

    private void NV21ToNV12(byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        int i5 = 0;
        AppMethodBeat.i(40790);
        if (bArr == null || bArr2 == null) {
            AppMethodBeat.o(40790);
            return;
        }
        int i6 = i2 * i3;
        if (i4 == 0) {
            System.arraycopy(bArr, 0, bArr2, 0, i6);
            while (i5 < i6 / 2) {
                bArr2[i6 + i5] = bArr[i6 + i5 + 1];
                bArr2[i6 + i5 + 1] = bArr[i6 + i5];
                i5 += 2;
            }
        } else {
            for (int i7 = 0; i7 < i6; i7++) {
                bArr2[i7] = bArr[(i6 - 1) - i7];
            }
            while (i5 < i6 / 2) {
                bArr2[i6 + i5] = bArr[(((i6 / 2) + i6) - 1) - i5];
                i5++;
            }
        }
        AppMethodBeat.o(40790);
    }

    private long computePresentationTime(long j2) {
        return 132 + ((TimeUtil.SECOND_TO_US * j2) / 15);
    }
}
