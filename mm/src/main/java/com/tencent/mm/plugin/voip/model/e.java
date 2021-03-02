package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.video.render.i;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.cap;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import java.io.BufferedOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

@TargetApi(16)
public final class e {
    public static int EMethodGetQosPara = 25;
    public static int GTO = 60;
    public static short[] SizeFormat2WH = {128, 96, 240, 160, 320, 240, 480, 360, 640, 480};
    public static int VFMT_HEVC_HW = 19;
    public static int VFMT_i264 = 18;
    public static int frameID = 0;
    private static String path = b.aKJ();
    private static int streamqueuesize = 100;
    public static final String[] supportedH264HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos.", "OMX.hisi", "OMX.MTK", "OMX.sprd"};
    public String ENCODING = "hevc";
    l GSZ = null;
    private byte[] GTK = null;
    private byte[] GTL = null;
    private ByteBuffer GTM = null;
    a GTN;
    private int TIMEOUT_USEC = 12000;
    public byte[] configbyte = null;
    public int encLen = 0;
    public long igB = 0;
    public boolean isRuning = false;
    public long mGeneratedIdx = 0;
    int mPrevResolution = 8;
    int mProfileCfg = 1;
    int m_CapH;
    int m_CapW;
    int m_br_kbps;
    int m_framerate;
    int m_height;
    int m_width;
    protected MediaFormat mediaFormat;
    private BufferedOutputStream outputStream;
    public int qsb = 0;
    private z qsc;
    private byte[] qsd = null;
    private MediaMuxer qse;
    private int qsf;
    private boolean qsg;
    private BufferedOutputStream qsh;
    g qsi = null;
    public int qsj = 0;
    public int qsk = 8;
    public int qsl = 0;
    public int qsm = 0;
    public LinkedList<caq> zLK = new LinkedList<>();
    public LinkedList<Integer> zLL = new LinkedList<>();
    public int zLM = 0;

    static {
        AppMethodBeat.i(177015);
        AppMethodBeat.o(177015);
    }

    /* access modifiers changed from: package-private */
    public class a {
        public short GTP;
        public short GTQ;
        public byte cFps;
        public byte cHPPMaxLyr;
        public byte cIPeriod;
        public byte cIReqFlag;
        public byte cQPmax;
        public byte cQPmin;
        public byte cRSLevel;
        public byte cResolution;
        public byte cRsvd1;
        public byte cRsvd2;
        public byte cSkipFlag;
        public byte cSwitch;
        public short iKbps;
        public byte[] s2p = new byte[18];

        public a() {
            AppMethodBeat.i(114832);
            AppMethodBeat.o(114832);
        }
    }

    @SuppressLint({"NewApi"})
    private boolean a(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.i(114833);
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 18 && 8 <= this.qsk) {
            String name = mediaCodecInfo.getName();
            for (String str2 : supportedH264HwCodecPrefixes) {
                if (name.startsWith(str2)) {
                    try {
                        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = mediaCodecInfo.getCapabilitiesForType(str).profileLevels;
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
                            if (codecProfileLevel.profile == 8) {
                                z = true;
                            }
                            Log.i("MeidaCodec[HWEnc]", "steve : [" + name + "] supported profiles:" + codecProfileLevel.profile + ", maxAllowedProfile: " + this.qsk + ", MIME:" + str);
                        }
                    } catch (Exception e2) {
                    }
                }
            }
        }
        AppMethodBeat.o(114833);
        return z;
    }

    private boolean a(MediaCodecInfo mediaCodecInfo, String str, int i2) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        boolean z;
        AppMethodBeat.i(114834);
        boolean z2 = false;
        if (d.oD(23)) {
            try {
                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                if (!(capabilitiesForType == null || (codecProfileLevelArr = capabilitiesForType.profileLevels) == null)) {
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel.level = 0;
                    codecProfileLevel.profile = 0;
                    for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                        int i3 = codecProfileLevel2.profile;
                        int i4 = codecProfileLevel2.level;
                        boolean z3 = false;
                        switch (i3) {
                            case 1:
                            case 2:
                            case 8:
                                z = true;
                                break;
                            default:
                                z = false;
                                break;
                        }
                        if (z) {
                            z3 = true;
                            if (i3 >= codecProfileLevel.profile && i4 >= codecProfileLevel.level && i3 <= i2) {
                                codecProfileLevel.profile = i3;
                                codecProfileLevel.level = i4;
                            }
                        }
                        Log.i("MeidaCodec[HWEnc]", "steve : profile: " + i3 + ", level: " + i4 + ", maxProfile: " + i2 + ", isRecognized:" + z3);
                    }
                    Log.i("MeidaCodec[HWEnc]", "best profile: " + codecProfileLevel.profile + ", best level: " + codecProfileLevel.level);
                    if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                        this.mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                        this.mediaFormat.setInteger("level", 256);
                        z2 = true;
                    }
                }
            } catch (Exception e2) {
                Log.e("MeidaCodec[HWEnc]", "trySetProfile error: " + e2.getMessage());
            }
        }
        AppMethodBeat.o(114834);
        return z2;
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo) {
        boolean z = false;
        AppMethodBeat.i(114835);
        String name = mediaCodecInfo.getName();
        String[] strArr = supportedH264HwCodecPrefixes;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (name.startsWith(strArr[i2])) {
                z = true;
                Log.d("MeidaCodec[HWEnc]", "steve : known H.264 HW encoder :".concat(String.valueOf(name)));
                break;
            } else {
                i2++;
            }
        }
        AppMethodBeat.o(114835);
        return z;
    }

    @SuppressLint({"NewApi"})
    private int cyY() {
        MediaCodecInfo mediaCodecInfo;
        boolean z;
        String[] supportedTypes;
        AppMethodBeat.i(114836);
        if (this.qsc != null) {
            StopEncoder();
        }
        String str = this.ENCODING;
        int codecCount = MediaCodecList.getCodecCount();
        int i2 = 0;
        loop0:
        while (true) {
            if (i2 >= codecCount) {
                mediaCodecInfo = null;
                break;
            }
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        String name = codecInfoAt.getName();
                        for (String str3 : supportedH264HwCodecPrefixes) {
                            if (name.startsWith(str3)) {
                                Log.i("MeidaCodec[HWEnc]", "steve : H.264 HW encoder found:".concat(String.valueOf(name)));
                                mediaCodecInfo = codecInfoAt;
                                break loop0;
                            }
                        }
                        continue;
                    }
                }
                continue;
            }
            i2++;
        }
        if (mediaCodecInfo == null) {
            Log.e("MeidaCodec[HWEnc]", "steve: Unable to find an appropriate codec for " + this.ENCODING);
            this.qsb = 2001;
            int i3 = -this.qsb;
            AppMethodBeat.o(114836);
            return i3;
        }
        Log.i("MeidaCodec[HWEnc]", "steve: found HW codec: " + mediaCodecInfo.getName());
        this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
        this.mediaFormat.setInteger("color-format", 21);
        this.mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.m_br_kbps * 1000);
        this.mediaFormat.setInteger("frame-rate", this.m_framerate);
        this.mediaFormat.setInteger("i-frame-interval", 4);
        String string = this.mediaFormat.getString("mime");
        this.qsj = 1;
        if (this.ENCODING.equalsIgnoreCase("video/avc") && a(mediaCodecInfo) && d.oD(23)) {
            boolean z2 = this.mProfileCfg > 0 && (this.mProfileCfg & 1) != 0;
            boolean z3 = this.mProfileCfg > 0 && (this.mProfileCfg & 4) != 0;
            boolean a2 = a(mediaCodecInfo, string);
            if (z3 && a2) {
                this.mediaFormat.setInteger(Scopes.PROFILE, 8);
                this.mediaFormat.setInteger("level", 256);
                z = true;
            } else if (z2) {
                this.mediaFormat.setInteger(Scopes.PROFILE, 1);
                this.mediaFormat.setInteger("level", 256);
                z = true;
            } else if (mediaCodecInfo != null) {
                z = a(mediaCodecInfo, string, this.qsk);
            } else {
                z = false;
            }
            if (z) {
                this.qsj = this.mediaFormat.getInteger(Scopes.PROFILE);
            } else {
                this.qsj = 1;
            }
        }
        this.mediaFormat.setInteger("bitrate-mode", 2);
        try {
            this.qsc = z.q(string, false);
            Log.i("MeidaCodec[HWEnc]", "steve: mediaFormat: " + this.mediaFormat + ", actProfile: " + this.qsj);
            this.qsc.a(this.mediaFormat, (Surface) null, 1);
            this.qsc.start();
            this.qsi = new g();
            AppMethodBeat.o(114836);
            return 2000;
        } catch (Exception e2) {
            Log.e("MeidaCodec[HWEnc]", " error:" + e2.toString());
            this.qsb = 2002;
            int i4 = -this.qsb;
            AppMethodBeat.o(114836);
            return i4;
        }
    }

    public e(int i2, int i3, int i4, int i5, int i6, String str) {
        AppMethodBeat.i(114837);
        this.m_width = i2;
        this.m_height = i3;
        this.m_CapW = i2;
        this.m_CapH = i3;
        this.ENCODING = str;
        this.m_framerate = i4;
        this.m_br_kbps = i5;
        this.mProfileCfg = i6;
        frameID = 0;
        this.mGeneratedIdx = 0;
        this.GTN = new a();
        this.qsc = null;
        this.qsk = 8;
        this.qsj = 0;
        this.qsl = 0;
        this.qsb = 0;
        caq caq = new caq();
        caq.MfO = 1;
        caq.MfP = 24;
        caq.MfQ = 1;
        caq.MfR = 24;
        caq.MfS = 0;
        caq.MfT = 0;
        this.zLK.add(caq);
        this.zLL.add(0);
        this.qsd = null;
        this.GTM = null;
        this.qsm = 0;
        this.zLM = 0;
        this.igB = 0;
        AppMethodBeat.o(114837);
    }

    @SuppressLint({"NewApi"})
    private void StopEncoder() {
        AppMethodBeat.i(114838);
        try {
            if (this.qsc != null) {
                this.qsc.stop();
                this.qsc.release();
            }
            AppMethodBeat.o(114838);
        } catch (Exception e2) {
            Log.e("MeidaCodec[HWEnc]", " error:" + e2.toString());
            AppMethodBeat.o(114838);
        }
    }

    public final void emB() {
        AppMethodBeat.i(114839);
        this.isRuning = false;
        try {
            StopEncoder();
            if (this.outputStream != null) {
                this.outputStream.flush();
                this.outputStream.close();
            }
            if (this.qsh != null) {
                this.qsh.flush();
                this.qsh.close();
            }
            if (this.qse != null) {
                this.qse.stop();
                this.qse.release();
            }
            AppMethodBeat.o(114839);
        } catch (Exception e2) {
            Log.e("MeidaCodec[HWEnc]", " error:" + e2.toString());
            AppMethodBeat.o(114839);
        }
    }

    private static String bO(byte[] bArr) {
        AppMethodBeat.i(114840);
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(hexString));
            }
            str = str + hexString;
        }
        AppMethodBeat.o(114840);
        return str;
    }

    private static ArrayList<Integer> bS(byte[] bArr) {
        AppMethodBeat.i(114841);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i2 = 0;
        String bO = bO(bArr);
        String bO2 = bO(new byte[]{0, 0, 0, 1});
        Log.d("MeidaCodec[HWEnc]", "parent: " + bO + ", child:" + bO2);
        while (true) {
            int indexOf = bO.indexOf(bO2, i2);
            if (indexOf != -1) {
                Log.d("MeidaCodec[HWEnc]", "vps/sps/pps start: " + i2 + ", nextStartIdx:" + indexOf);
                i2 = bO2.length() + indexOf;
                arrayList.add(Integer.valueOf(indexOf / 2));
            } else {
                AppMethodBeat.o(114841);
                return arrayList;
            }
        }
    }

    public final int b(byte[] bArr, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        AppMethodBeat.i(114842);
        byte[] bArr2 = null;
        if (!(i2 == this.m_CapW && i3 == this.m_CapH)) {
            this.m_CapW = i2;
            this.m_CapH = i3;
            this.qsd = new byte[(((this.m_CapW * this.m_CapH) * 3) / 2)];
        }
        if (this.qsd == null) {
            this.qsd = new byte[(((this.m_CapW * this.m_CapH) * 3) / 2)];
        }
        Log.d("MeidaCodec[HWEnc]", "steve: m_framerate: " + this.m_framerate + ", m_br_kbps:" + this.m_br_kbps);
        if (this.GTN.cSkipFlag != 0 || this.GSZ.GVV == null) {
            i5 = 0;
        } else {
            this.GSZ.GVV.videoHWProcess(bArr, bArr.length, this.m_CapW, this.m_CapH, i4, this.qsd);
            byte[] bArr3 = this.qsd;
            if (this.m_width == this.GSZ.GVV.field_HWEncW && this.m_height == this.GSZ.GVV.field_HWEncH) {
                i5 = 0;
            } else {
                Log.d("MeidaCodec[HWEnc]", "restart encoder! clipWH:" + this.GSZ.GVV.field_HWEncW + "x" + this.GSZ.GVV.field_HWEncH + ", wh:" + this.m_width + "x" + this.m_height);
                this.m_width = this.GSZ.GVV.field_HWEncW;
                this.m_height = this.GSZ.GVV.field_HWEncH;
                this.encLen = ((this.m_width * this.m_height) * 3) >> 1;
                try {
                    i5 = cyY();
                } catch (Exception e2) {
                    Log.e("MeidaCodec[HWEnc]", "mediacodec init error: " + e2.getMessage());
                    this.qsb = 2003;
                    i5 = -this.qsb;
                }
                if (i5 < 0) {
                    Log.e("MeidaCodec[HWEnc]", "mediacodec init failed, stop HW encoding! ret: ".concat(String.valueOf(i5)));
                    emB();
                    AppMethodBeat.o(114842);
                    return i5;
                }
            }
            if (frameID <= 100 && this.qsh != null) {
                try {
                    this.qsh.write(this.qsd, 0, this.encLen);
                    bArr2 = bArr3;
                } catch (Exception e3) {
                    Log.e("MeidaCodec[HWEnc]", " error:" + e3.toString());
                }
            }
            bArr2 = bArr3;
        }
        if (bArr2 == null || this.qsc == null) {
            int i8 = this.qsm;
            this.qsm = i8 + 1;
            if (i8 > 5) {
                this.qsb = 2006;
                i5 = -this.qsb;
            }
        } else {
            try {
                this.qsm = 0;
                Log.d("MeidaCodec[HWEnc]", "steve: put YUV into encoder, size:" + this.encLen + ", idx:" + frameID + ", time:" + System.currentTimeMillis());
                ByteBuffer[] inputBuffers = this.qsc.getInputBuffers();
                ByteBuffer[] outputBuffers = this.qsc.getOutputBuffers();
                int dequeueInputBuffer = this.qsc.dequeueInputBuffer(-1);
                if (dequeueInputBuffer >= 0) {
                    long computePresentationTime = computePresentationTime(this.mGeneratedIdx);
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    byteBuffer.put(bArr2, 0, this.encLen);
                    this.qsc.a(dequeueInputBuffer, this.encLen, computePresentationTime, 0);
                    this.mGeneratedIdx++;
                }
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.qsc.dequeueOutputBuffer(bufferInfo, (long) this.TIMEOUT_USEC);
                if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.qsc.getOutputFormat();
                    Log.i("MeidaCodec[HWEnc]", "steve: encoder output format changed: ".concat(String.valueOf(outputFormat)));
                    if (outputFormat.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) && ((double) outputFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)) > ((double) (this.m_br_kbps * 1000)) * 1.5d) {
                        Log.e("MeidaCodec[HWEnc]", "steve: bitrate NOT match!! real:" + outputFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) + ", target:" + this.m_br_kbps);
                        this.qsb = 2007;
                        int i9 = -this.qsb;
                        AppMethodBeat.o(114842);
                        return i9;
                    }
                }
                while (dequeueOutputBuffer >= 0) {
                    ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                    byte[] bArr4 = new byte[bufferInfo.size];
                    byteBuffer2.get(bArr4);
                    if (this.outputStream != null) {
                        this.outputStream.write(bArr4, 0, bArr4.length);
                    }
                    if (bufferInfo.flags == 2) {
                        ArrayList<Integer> bS = bS(bArr4);
                        cap cap = new cap();
                        int i10 = 0;
                        int i11 = 0;
                        int i12 = 0;
                        int i13 = 0;
                        int i14 = 0;
                        int i15 = 0;
                        if (bS.size() == 3 && this.ENCODING.equalsIgnoreCase(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
                            i10 = bS.get(0).intValue() + 4;
                            i12 = bS.get(1).intValue() + 4;
                            i14 = bS.get(2).intValue() + 4;
                            i11 = (i12 - i10) - 4;
                            i13 = (i14 - i12) - 4;
                            i15 = bufferInfo.size - i14;
                            cap.MfN = com.tencent.mm.bw.b.Q(bArr4, i10, i11);
                        } else if (bS.size() == 2) {
                            i12 = bS.get(0).intValue() + 4;
                            i14 = bS.get(1).intValue() + 4;
                            i13 = (i14 - i12) - 4;
                            i15 = bufferInfo.size - i14;
                        }
                        if (this.GTK == null) {
                            this.GTK = new byte[bufferInfo.size];
                        }
                        if (this.GTK != null) {
                            if (bufferInfo.size > this.GTK.length) {
                                this.GTK = new byte[bufferInfo.size];
                            }
                            System.arraycopy(bArr4, 0, this.GTK, 0, bufferInfo.size);
                        }
                        Log.d("MeidaCodec[HWEnc]", "sps start: " + i12 + ", len:" + i13 + ", pps start:" + i14 + ", len:" + i15 + ", vps start: " + i10 + ", len:" + i11);
                        if (this.qsj == 1 || !this.qsi.cg(bArr4)) {
                            cap.MfK = 4;
                            cap.MfL = com.tencent.mm.bw.b.Q(bArr4, i12, i13);
                            cap.MfM = com.tencent.mm.bw.b.Q(bArr4, i14, i15);
                            int I = I(cap.toByteArray(), bufferInfo.flags, cap.toByteArray().length);
                            if (I < 0) {
                                AppMethodBeat.o(114842);
                                return I;
                            }
                        } else {
                            this.qsl = this.qsi.GTT;
                            this.qsk = 1;
                            Log.i("MeidaCodec[HWEnc]", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.qsk + ", checkCodeForBSlice:" + this.qsl);
                            try {
                                i7 = cyY();
                            } catch (Exception e4) {
                                Log.e("MeidaCodec[HWEnc]", "mediacodec reinit error: " + e4.getMessage());
                                this.qsb = 2005;
                                i7 = -this.qsb;
                            }
                            AppMethodBeat.o(114842);
                            return i7;
                        }
                    } else if (this.qsj != 1 && this.qsi.ch(bArr4)) {
                        this.qsl = this.qsi.GTT;
                        this.qsk = 1;
                        Log.i("MeidaCodec[HWEnc]", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.qsk + ", checkCodeForBSlice:" + this.qsl);
                        try {
                            i6 = cyY();
                        } catch (Exception e5) {
                            Log.e("MeidaCodec[HWEnc]", "mediacodec reinit error: " + e5.getMessage());
                            this.qsb = 2005;
                            i6 = -this.qsb;
                        }
                        AppMethodBeat.o(114842);
                        return i6;
                    } else if (bufferInfo.flags == 0 || bufferInfo.flags == 1) {
                        int i16 = 0;
                        if (bufferInfo.flags == 1) {
                            byte[] bArr5 = new byte[this.GTK.length];
                            System.arraycopy(bArr4, 0, bArr5, 0, this.GTK.length);
                            if (Arrays.equals(bArr5, this.GTK)) {
                                i16 = this.GTK.length;
                                Log.d("MeidaCodec[HWEnc]", "EQU!!!, head_len[%d]", Integer.valueOf(i16));
                            } else {
                                if (this.GTL == null) {
                                    this.GTL = new byte[100];
                                }
                                System.arraycopy(bArr4, 0, this.GTL, 0, bufferInfo.size > 100 ? 100 : bufferInfo.size);
                                ArrayList<Integer> bS2 = bS(this.GTL);
                                if (bS2.size() == 3 && this.ENCODING.equalsIgnoreCase("video/avc")) {
                                    int intValue = bS2.get(0).intValue();
                                    int intValue2 = bS2.get(1).intValue();
                                    i16 = bS2.get(2).intValue();
                                    int i17 = intValue2 - intValue;
                                    int i18 = i16 - intValue2;
                                    Log.i("MeidaCodec[HWEnc]", "spsStart[%d], ppsStart[%d], frameStart[%d], spsLen[%d], ppsLen[%d]", Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                                    if (this.GTK.length < i17 + i18) {
                                        this.GTK = new byte[(i17 + i18)];
                                    }
                                    System.arraycopy(bArr4, intValue, this.GTK, 0, i17);
                                    System.arraycopy(bArr4, i18, this.GTK, i17, i18);
                                    cap cap2 = new cap();
                                    cap2.MfK = 4;
                                    cap2.MfL = com.tencent.mm.bw.b.Q(bArr4, intValue + 4, i17 - 4);
                                    cap2.MfM = com.tencent.mm.bw.b.Q(bArr4, intValue2 + 4, i18 - 4);
                                    I(cap2.toByteArray(), 2, cap2.toByteArray().length);
                                }
                            }
                        }
                        ByteBuffer allocate = ByteBuffer.allocate(4);
                        allocate.putInt((bufferInfo.size - 4) - i16);
                        System.arraycopy(allocate.order(ByteOrder.BIG_ENDIAN).array(), 0, bArr4, i16, 4);
                        Log.d("MeidaCodec[HWEnc]", " type:" + bufferInfo.flags + ", size:" + bufferInfo.size + ", idx:" + frameID + ", time:" + System.currentTimeMillis() + ", head_len:" + i16);
                        cao cao = new cao();
                        cao.MfG = com.tencent.mm.bw.b.Q(bArr4, i16, bufferInfo.size - i16);
                        cao.MfH = 1;
                        cao.MfI = this.zLK;
                        this.zLL.set(0, Integer.valueOf(bufferInfo.size - i16));
                        cao.MfJ = this.zLL;
                        int I2 = I(cao.toByteArray(), bufferInfo.flags, cao.toByteArray().length);
                        if (I2 < 0) {
                            AppMethodBeat.o(114842);
                            return I2;
                        }
                    } else {
                        this.qsb = 2009;
                        int i19 = -this.qsb;
                        Log.i("MeidaCodec[HWEnc]", "steve:unknown frame error!!! type:" + bufferInfo.flags + ", len:" + bufferInfo.size);
                        AppMethodBeat.o(114842);
                        return i19;
                    }
                    if (this.qsg && byteBuffer2 != null) {
                        this.qse.writeSampleData(this.qsf, byteBuffer2, bufferInfo);
                    }
                    i5 = bufferInfo.flags;
                    frameID++;
                    this.qsc.releaseOutputBuffer(dequeueOutputBuffer, false);
                    dequeueOutputBuffer = this.qsc.dequeueOutputBuffer(bufferInfo, (long) this.TIMEOUT_USEC);
                }
            } catch (Exception e6) {
                Log.e("MeidaCodec[HWEnc]", " error:" + e6.toString());
                this.qsb = 2004;
                i5 = -this.qsb;
            }
        }
        AppMethodBeat.o(114842);
        return i5;
    }

    public final int a(ByteBuffer byteBuffer, int i2, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7;
        ByteBuffer byteBuffer2;
        int i8;
        int i9;
        AppMethodBeat.i(235481);
        ByteBuffer byteBuffer3 = null;
        if (!(i2 == this.m_CapW && i3 == this.m_CapH)) {
            this.m_CapW = i2;
            this.m_CapH = i3;
            this.GTM = ByteBuffer.allocateDirect(((this.m_CapW * this.m_CapH) * 3) / 2);
        }
        if (this.GTM == null) {
            this.GTM = ByteBuffer.allocateDirect(((this.m_CapW * this.m_CapH) * 3) / 2);
        }
        Log.d("MeidaCodec[HWEnc]", "steve: m_framerate: " + this.m_framerate + ", m_br_kbps:" + this.m_br_kbps);
        if (this.GTN.cSkipFlag != 0 || this.GSZ.GVV == null) {
            i5 = 0;
        } else {
            if (z) {
                long currentTicks = Util.currentTicks();
                this.GSZ.GVV.videoHWProcess2(byteBuffer, byteBuffer.capacity(), this.m_CapW, this.m_CapH, i4, this.GTM);
                i iVar = i.HnR;
                i.aO(0, Util.ticksToNow(currentTicks));
                byteBuffer2 = this.GTM;
            } else {
                byteBuffer2 = byteBuffer;
            }
            if (z) {
                i8 = this.GSZ.GVV.field_HWEncW;
            } else {
                i8 = i2;
            }
            if (z) {
                i9 = this.GSZ.GVV.field_HWEncH;
            } else {
                i9 = i3;
            }
            if (this.m_width == i8 && this.m_height == i9) {
                i5 = 0;
            } else {
                Log.d("MeidaCodec[HWEnc]", "restart encoder! clipWH:" + i2 + "x" + i3 + ", wh:" + this.m_width + "x" + this.m_height);
                this.m_width = i8;
                this.m_height = i9;
                this.encLen = ((this.m_width * this.m_height) * 3) >> 1;
                try {
                    i5 = cyY();
                } catch (Exception e2) {
                    Log.e("MeidaCodec[HWEnc]", "mediacodec init error: " + e2.getMessage());
                    this.qsb = 2003;
                    i5 = -this.qsb;
                }
                if (i5 < 0) {
                    Log.e("MeidaCodec[HWEnc]", "mediacodec init failed, stop HW encoding! ret: ".concat(String.valueOf(i5)));
                    emB();
                    AppMethodBeat.o(235481);
                    return i5;
                }
            }
            if (frameID <= 100 && this.qsh != null) {
                try {
                    this.qsh.write(this.GTM.array(), 0, this.encLen);
                    byteBuffer3 = byteBuffer2;
                } catch (Exception e3) {
                    Log.e("MeidaCodec[HWEnc]", " error:" + e3.toString());
                }
            }
            byteBuffer3 = byteBuffer2;
        }
        if (byteBuffer3 == null || this.qsc == null) {
            int i10 = this.qsm;
            this.qsm = i10 + 1;
            if (i10 > 5) {
                this.qsb = 2006;
                i5 = -this.qsb;
            }
        } else {
            try {
                this.qsm = 0;
                Log.d("MeidaCodec[HWEnc]", "steve: put YUV into encoder, size:" + this.encLen + ", idx:" + frameID + ", time:" + System.currentTimeMillis());
                ByteBuffer[] inputBuffers = this.qsc.getInputBuffers();
                ByteBuffer[] outputBuffers = this.qsc.getOutputBuffers();
                int dequeueInputBuffer = this.qsc.dequeueInputBuffer(-1);
                if (dequeueInputBuffer >= 0) {
                    long computePresentationTime = computePresentationTime(this.mGeneratedIdx);
                    byteBuffer3.rewind().limit(this.encLen);
                    ByteBuffer byteBuffer4 = inputBuffers[dequeueInputBuffer];
                    byteBuffer4.clear();
                    byteBuffer4.put(byteBuffer3);
                    byteBuffer3.clear();
                    this.qsc.a(dequeueInputBuffer, this.encLen, computePresentationTime, 0);
                    this.mGeneratedIdx++;
                }
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.qsc.dequeueOutputBuffer(bufferInfo, (long) this.TIMEOUT_USEC);
                if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.qsc.getOutputFormat();
                    Log.i("MeidaCodec[HWEnc]", "steve: encoder output format changed: ".concat(String.valueOf(outputFormat)));
                    if (outputFormat.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) && ((double) outputFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE)) > ((double) (this.m_br_kbps * 1000)) * 1.5d) {
                        Log.e("MeidaCodec[HWEnc]", "steve: bitrate NOT match!! real:" + outputFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) + ", target:" + this.m_br_kbps);
                        this.qsb = 2007;
                        int i11 = -this.qsb;
                        AppMethodBeat.o(235481);
                        return i11;
                    }
                }
                while (dequeueOutputBuffer >= 0) {
                    ByteBuffer byteBuffer5 = outputBuffers[dequeueOutputBuffer];
                    byte[] bArr = new byte[bufferInfo.size];
                    byteBuffer5.get(bArr);
                    if (this.outputStream != null) {
                        this.outputStream.write(bArr, 0, bArr.length);
                    }
                    if (bufferInfo.flags == 2) {
                        ArrayList<Integer> bS = bS(bArr);
                        cap cap = new cap();
                        int i12 = 0;
                        int i13 = 0;
                        int i14 = 0;
                        int i15 = 0;
                        int i16 = 0;
                        int i17 = 0;
                        if (bS.size() == 3 && this.ENCODING.equalsIgnoreCase(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
                            i12 = bS.get(0).intValue() + 4;
                            i14 = bS.get(1).intValue() + 4;
                            i16 = bS.get(2).intValue() + 4;
                            i13 = (i14 - i12) - 4;
                            i15 = (i16 - i14) - 4;
                            i17 = bufferInfo.size - i16;
                            cap.MfN = com.tencent.mm.bw.b.Q(bArr, i12, i13);
                        } else if (bS.size() == 2) {
                            i14 = bS.get(0).intValue() + 4;
                            i16 = bS.get(1).intValue() + 4;
                            i15 = (i16 - i14) - 4;
                            i17 = bufferInfo.size - i16;
                        }
                        if (this.GTK == null) {
                            this.GTK = new byte[bufferInfo.size];
                        }
                        if (this.GTK != null) {
                            if (bufferInfo.size > this.GTK.length) {
                                this.GTK = new byte[bufferInfo.size];
                            }
                            System.arraycopy(bArr, 0, this.GTK, 0, bufferInfo.size);
                        }
                        Log.d("MeidaCodec[HWEnc]", "sps start: " + i14 + ", len:" + i15 + ", pps start:" + i16 + ", len:" + i17 + ", vps start: " + i12 + ", len:" + i13);
                        if (this.qsj == 1 || !this.qsi.cg(bArr)) {
                            cap.MfK = 4;
                            cap.MfL = com.tencent.mm.bw.b.Q(bArr, i14, i15);
                            cap.MfM = com.tencent.mm.bw.b.Q(bArr, i16, i17);
                            int I = I(cap.toByteArray(), bufferInfo.flags, cap.toByteArray().length);
                            if (I < 0) {
                                AppMethodBeat.o(235481);
                                return I;
                            }
                        } else {
                            this.qsl = this.qsi.GTT;
                            this.qsk = 1;
                            Log.i("MeidaCodec[HWEnc]", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.qsk + ", checkCodeForBSlice:" + this.qsl);
                            try {
                                i7 = cyY();
                            } catch (Exception e4) {
                                Log.e("MeidaCodec[HWEnc]", "mediacodec reinit error: " + e4.getMessage());
                                this.qsb = 2005;
                                i7 = -this.qsb;
                            }
                            AppMethodBeat.o(235481);
                            return i7;
                        }
                    } else if (this.qsj != 1 && this.qsi.ch(bArr)) {
                        this.qsl = this.qsi.GTT;
                        this.qsk = 1;
                        Log.i("MeidaCodec[HWEnc]", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.qsk + ", checkCodeForBSlice:" + this.qsl);
                        try {
                            i6 = cyY();
                        } catch (Exception e5) {
                            Log.e("MeidaCodec[HWEnc]", "mediacodec reinit error: " + e5.getMessage());
                            this.qsb = 2005;
                            i6 = -this.qsb;
                        }
                        AppMethodBeat.o(235481);
                        return i6;
                    } else if (bufferInfo.flags == 0 || bufferInfo.flags == 1) {
                        int i18 = 0;
                        if (bufferInfo.flags == 1) {
                            byte[] bArr2 = new byte[this.GTK.length];
                            System.arraycopy(bArr, 0, bArr2, 0, this.GTK.length);
                            if (Arrays.equals(bArr2, this.GTK)) {
                                i18 = this.GTK.length;
                                Log.d("MeidaCodec[HWEnc]", "EQU!!!, head_len[%d]", Integer.valueOf(i18));
                            } else {
                                if (this.GTL == null) {
                                    this.GTL = new byte[100];
                                }
                                System.arraycopy(bArr, 0, this.GTL, 0, bufferInfo.size > 100 ? 100 : bufferInfo.size);
                                ArrayList<Integer> bS2 = bS(this.GTL);
                                if (bS2.size() == 3 && this.ENCODING.equalsIgnoreCase("video/avc")) {
                                    int intValue = bS2.get(0).intValue();
                                    int intValue2 = bS2.get(1).intValue();
                                    i18 = bS2.get(2).intValue();
                                    int i19 = intValue2 - intValue;
                                    int i20 = i18 - intValue2;
                                    Log.i("MeidaCodec[HWEnc]", "spsStart[%d], ppsStart[%d], frameStart[%d], spsLen[%d], ppsLen[%d]", Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i20));
                                    if (this.GTK.length < i19 + i20) {
                                        this.GTK = new byte[(i19 + i20)];
                                    }
                                    System.arraycopy(bArr, intValue, this.GTK, 0, i19);
                                    System.arraycopy(bArr, i20, this.GTK, i19, i20);
                                    cap cap2 = new cap();
                                    cap2.MfK = 4;
                                    cap2.MfL = com.tencent.mm.bw.b.Q(bArr, intValue + 4, i19 - 4);
                                    cap2.MfM = com.tencent.mm.bw.b.Q(bArr, intValue2 + 4, i20 - 4);
                                    I(cap2.toByteArray(), 2, cap2.toByteArray().length);
                                }
                            }
                        }
                        ByteBuffer allocate = ByteBuffer.allocate(4);
                        allocate.putInt((bufferInfo.size - 4) - i18);
                        System.arraycopy(allocate.order(ByteOrder.BIG_ENDIAN).array(), 0, bArr, i18, 4);
                        Log.d("MeidaCodec[HWEnc]", " type:" + bufferInfo.flags + ", size:" + bufferInfo.size + ", idx:" + frameID + ", time:" + System.currentTimeMillis() + ", head_len:" + i18);
                        cao cao = new cao();
                        cao.MfG = com.tencent.mm.bw.b.Q(bArr, i18, bufferInfo.size - i18);
                        cao.MfH = 1;
                        cao.MfI = this.zLK;
                        this.zLL.set(0, Integer.valueOf(bufferInfo.size - i18));
                        cao.MfJ = this.zLL;
                        int I2 = I(cao.toByteArray(), bufferInfo.flags, cao.toByteArray().length);
                        if (I2 < 0) {
                            AppMethodBeat.o(235481);
                            return I2;
                        }
                    } else {
                        this.qsb = 2009;
                        int i21 = -this.qsb;
                        Log.i("MeidaCodec[HWEnc]", "steve:unknown frame error!!! type:" + bufferInfo.flags + ", len:" + bufferInfo.size);
                        AppMethodBeat.o(235481);
                        return i21;
                    }
                    if (this.qsg && byteBuffer5 != null) {
                        this.qse.writeSampleData(this.qsf, byteBuffer5, bufferInfo);
                    }
                    i5 = bufferInfo.flags;
                    frameID++;
                    this.qsc.releaseOutputBuffer(dequeueOutputBuffer, false);
                    dequeueOutputBuffer = this.qsc.dequeueOutputBuffer(bufferInfo, (long) this.TIMEOUT_USEC);
                }
            } catch (Exception e6) {
                Log.e("MeidaCodec[HWEnc]", " error:" + e6.toString());
                this.qsb = 2004;
                i5 = -this.qsb;
            }
        }
        AppMethodBeat.o(235481);
        return i5;
    }

    public final void DoQosSvrCtrl() {
        AppMethodBeat.i(235482);
        if (!(this.GSZ == null || this.GSZ.GVV == null)) {
            if (!(this.GSZ == null || this.GSZ.GVV == null || this.GSZ.GVV.setAppCmd(EMethodGetQosPara, this.GTN.s2p, this.GTN.s2p.length) < 0)) {
                a aVar = this.GTN;
                ByteBuffer wrap = ByteBuffer.wrap(aVar.s2p);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                aVar.iKbps = wrap.getShort();
                aVar.cFps = wrap.get();
                aVar.cIPeriod = wrap.get();
                aVar.cRSLevel = wrap.get();
                aVar.cQPmin = wrap.get();
                aVar.cQPmax = wrap.get();
                aVar.cHPPMaxLyr = wrap.get();
                aVar.cSwitch = wrap.get();
                aVar.cResolution = wrap.get();
                aVar.cRsvd1 = wrap.get();
                aVar.cRsvd2 = wrap.get();
                aVar.cSkipFlag = wrap.get();
                aVar.cIReqFlag = wrap.get();
                aVar.GTP = wrap.getShort();
                aVar.GTQ = wrap.getShort();
                a aVar2 = this.GTN;
                Log.i("MeidaCodec[HWEnc]", "raw S2P:" + aVar2.s2p);
                Log.i("MeidaCodec[HWEnc]", "-S2P- iKbps:" + ((int) aVar2.iKbps) + ", fps:" + ((int) aVar2.cFps) + ", IP:" + ((int) aVar2.cIPeriod) + ", RS:" + ((int) aVar2.cRSLevel) + ", QPMin:" + ((int) aVar2.cQPmin) + ", QPMax:" + ((int) aVar2.cQPmax) + ", HPP:" + ((int) aVar2.cHPPMaxLyr) + ", SWitch:" + ((int) aVar2.cSwitch) + ", Reso:" + ((int) aVar2.cResolution) + ", Rsvd1:" + ((int) aVar2.cRsvd1) + ", Rsvd2:" + ((int) aVar2.cRsvd2) + ", Skip:" + ((int) aVar2.cSkipFlag) + ", IReq:" + ((int) aVar2.cIReqFlag) + ", iEncW:" + ((int) aVar2.GTP) + ", iEncH:" + ((int) aVar2.GTQ));
                c cVar = c.HgQ;
                c.ec(this.GTN.GTP, this.GTN.GTQ);
            }
            int i2 = this.GTN.iKbps;
            if (!(this.qsj == 8)) {
                i2 = (int) (((double) i2) * (((((double) Math.max(Math.min(this.GSZ.GVV.Hbr, 30), 0)) * 1.0d) / 100.0d) + 1.0d));
            }
            if (this.m_br_kbps != i2) {
                SetBitRate(i2);
                Log.i("MeidaCodec[HWEnc]", "steve[QoS]: Update BR! frameID: " + frameID + ", new_br: " + this.m_br_kbps + ", tuneBR:" + i2 + ", tuneRatio:" + this.GSZ.GVV.Hbr);
                this.m_br_kbps = i2;
            }
            if (1 == this.GTN.cIReqFlag && frameID > 0) {
                if (this.qsc != null) {
                    Log.v("MeidaCodec[HWEnc]", "steve: Sync frame request soon!");
                    Bundle bundle = new Bundle();
                    bundle.putInt("request-sync", 0);
                    this.qsc.setParameters(bundle);
                }
                Log.i("MeidaCodec[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + frameID);
            }
            if (this.GTN.cFps != this.m_framerate) {
                this.m_framerate = this.GTN.cFps;
            }
        }
        AppMethodBeat.o(235482);
    }

    @SuppressLint({"NewApi"})
    private boolean SetBitRate(int i2) {
        AppMethodBeat.i(114843);
        try {
            if (this.qsc != null) {
                Bundle bundle = new Bundle();
                int i3 = i2 * 1000;
                Log.v("MeidaCodec[HWEnc]", "steve: setRates: ".concat(String.valueOf(i3)));
                bundle.putInt("video-bitrate", i3);
                this.qsc.setParameters(bundle);
                AppMethodBeat.o(114843);
                return true;
            }
        } catch (Exception e2) {
            Log.e("MeidaCodec[HWEnc]", "steve: setRates failed:".concat(String.valueOf(e2)));
        }
        AppMethodBeat.o(114843);
        return false;
    }

    private int I(byte[] bArr, int i2, int i3) {
        int i4;
        AppMethodBeat.i(114844);
        if (!(bArr == null || this.GSZ.GVV == null)) {
            int i5 = VFMT_i264;
            if (this.ENCODING.equalsIgnoreCase(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
                i5 = VFMT_HEVC_HW;
            }
            i4 = this.GSZ.GVV.videoEncodeToSend(bArr, i3, this.m_width, i2, i5);
            if (i4 >= 0) {
                this.zLM = 0;
                Log.d("MeidaCodec[HWEnc]", "steve: send successfully! frameLen = " + i3 + ", type = " + i2 + ", pkt cnt = " + i4);
            } else {
                int i6 = this.zLM;
                this.zLM = i6 + 1;
                if (i6 > 5) {
                    this.qsb = 2008;
                    i4 = -this.qsb;
                    Log.e("MeidaCodec[HWEnc]", "steve: hw send error for 5 times!! send ret = ".concat(String.valueOf(i4)));
                }
            }
            AppMethodBeat.o(114844);
            return i4;
        }
        i4 = 0;
        AppMethodBeat.o(114844);
        return i4;
    }

    private long computePresentationTime(long j2) {
        AppMethodBeat.i(235483);
        int min = Math.min(Math.max(this.m_framerate, 15), 30);
        if (j2 == 0 || this.igB == 0) {
            this.igB = 132;
        } else {
            this.igB = ((long) (1000000 / min)) + this.igB;
        }
        long j3 = this.igB;
        AppMethodBeat.o(235483);
        return j3;
    }
}
