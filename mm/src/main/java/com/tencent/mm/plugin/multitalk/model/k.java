package com.tencent.mm.plugin.multitalk.model;

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
import com.tencent.mm.plugin.multitalk.b.p;
import com.tencent.mm.plugin.voip.model.g;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.cap;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import java.io.BufferedOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

@TargetApi(16)
public final class k {
    public static short[] SizeFormat2WH = {128, 96, 240, 160, 320, 240, 480, 360, 640, 480};
    public static int VFMT_HEVC_HW = 19;
    public static int VFMT_i264 = 18;
    public static int frameID = 0;
    private static String path = b.aKJ();
    private static int streamqueuesize = 100;
    public static final String[] supportedH264HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos.", "OMX.hisi", "OMX.MTK", "OMX.sprd"};
    public static int zLJ = 39;
    public static int zLO = 53;
    public String ENCODING = "video/avc";
    private int TIMEOUT_USEC = 12000;
    public byte[] configbyte = null;
    public int encLen = 0;
    public long igB = 0;
    public boolean isRuning = false;
    public long mGeneratedIdx = 0;
    int mPrevResolution;
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
    public a zLN;

    static {
        AppMethodBeat.i(239353);
        AppMethodBeat.o(239353);
    }

    class a {
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
        public byte[] s2p = new byte[14];

        public a() {
            AppMethodBeat.i(239336);
            AppMethodBeat.o(239336);
        }
    }

    @SuppressLint({"NewApi"})
    private boolean a(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.i(239337);
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
                            Log.i("MultiAvcEncoder[HWEnc]", "steve : [" + name + "] supported profiles:" + codecProfileLevel.profile + ", maxAllowedProfile: " + this.qsk + ", MIME:" + str);
                        }
                    } catch (Exception e2) {
                    }
                }
            }
        }
        AppMethodBeat.o(239337);
        return z;
    }

    public static boolean aFU(String str) {
        boolean z;
        Exception e2;
        AppMethodBeat.i(239338);
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                z = false;
                for (int codecCount = MediaCodecList.getCodecCount() - 1; codecCount >= 0; codecCount--) {
                    try {
                        MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(codecCount);
                        Log.i("MultiAvcEncoder[HWEnc]", "steve codecInfo : " + codecInfoAt.getName());
                        String[] supportedTypes = codecInfoAt.getSupportedTypes();
                        String name = codecInfoAt.getName();
                        for (String str2 : supportedTypes) {
                            if (str2.equalsIgnoreCase(str)) {
                                for (String str3 : supportedH264HwCodecPrefixes) {
                                    if (name.startsWith(str3)) {
                                        try {
                                            Log.i("MultiAvcEncoder[HWEnc]", "steve : H.264 HW encoder found:".concat(String.valueOf(name)));
                                            z = true;
                                        } catch (Exception e3) {
                                            e2 = e3;
                                            z = true;
                                            Log.printErrStackTrace("MultiAvcEncoder[HWEnc]", e2, "SupportAvcCodec error: %s", e2.getMessage());
                                            AppMethodBeat.o(239338);
                                            return z;
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        Log.printErrStackTrace("MultiAvcEncoder[HWEnc]", e2, "SupportAvcCodec error: %s", e2.getMessage());
                        AppMethodBeat.o(239338);
                        return z;
                    }
                }
            } else {
                z = false;
            }
        } catch (Exception e5) {
            e2 = e5;
            z = false;
            Log.printErrStackTrace("MultiAvcEncoder[HWEnc]", e2, "SupportAvcCodec error: %s", e2.getMessage());
            AppMethodBeat.o(239338);
            return z;
        }
        AppMethodBeat.o(239338);
        return z;
    }

    private static MediaCodecInfo selectCodec(String str) {
        String[] supportedTypes;
        AppMethodBeat.i(239339);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        String name = codecInfoAt.getName();
                        for (String str3 : supportedH264HwCodecPrefixes) {
                            if (name.startsWith(str3)) {
                                Log.i("MultiAvcEncoder[HWEnc]", "steve : H.264 HW encoder found:".concat(String.valueOf(name)));
                                AppMethodBeat.o(239339);
                                return codecInfoAt;
                            }
                        }
                        continue;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(239339);
        return null;
    }

    private boolean a(MediaCodecInfo mediaCodecInfo, String str, int i2) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        boolean z;
        AppMethodBeat.i(239340);
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
                        Log.i("MultiAvcEncoder[HWEnc]", "steve : profile: " + i3 + ", level: " + i4 + ", maxProfile: " + i2 + ", isRecognized:" + z3);
                    }
                    Log.i("MultiAvcEncoder[HWEnc]", "best profile: " + codecProfileLevel.profile + ", best level: " + codecProfileLevel.level);
                    if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                        this.mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                        this.mediaFormat.setInteger("level", 256);
                        z2 = true;
                    }
                }
            } catch (Exception e2) {
                Log.e("MultiAvcEncoder[HWEnc]", "trySetProfile error: " + e2.getMessage());
            }
        }
        AppMethodBeat.o(239340);
        return z2;
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo) {
        boolean z = false;
        AppMethodBeat.i(239341);
        String name = mediaCodecInfo.getName();
        String[] strArr = supportedH264HwCodecPrefixes;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (name.startsWith(strArr[i2])) {
                z = true;
                Log.d("MultiAvcEncoder[HWEnc]", "steve : known H.264 HW encoder :".concat(String.valueOf(name)));
                break;
            } else {
                i2++;
            }
        }
        AppMethodBeat.o(239341);
        return z;
    }

    @SuppressLint({"NewApi"})
    private int cyY() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(239342);
        Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] InitHWEncoder!" + this.ENCODING);
        if (this.qsc != null) {
            StopEncoder();
        }
        MediaCodecInfo selectCodec = selectCodec(this.ENCODING);
        if (selectCodec == null) {
            Log.e("MultiAvcEncoder[HWEnc]", "steve: Unable to find an appropriate codec for " + this.ENCODING);
            this.qsb = 2001;
            int i2 = -this.qsb;
            AppMethodBeat.o(239342);
            return i2;
        }
        Log.i("MultiAvcEncoder[HWEnc]", "steve: found HW codec: " + selectCodec.getName());
        this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
        this.mediaFormat.setInteger("color-format", 21);
        this.mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.m_br_kbps * 1000);
        this.mediaFormat.setInteger("frame-rate", this.m_framerate);
        this.mediaFormat.setInteger("i-frame-interval", 1);
        String string = this.mediaFormat.getString("mime");
        this.qsj = 1;
        if (this.ENCODING.equalsIgnoreCase("video/avc") && a(selectCodec) && d.oD(23)) {
            boolean z3 = this.mProfileCfg > 0 && (this.mProfileCfg & 1) != 0;
            if (this.mProfileCfg <= 0 || (this.mProfileCfg & 4) == 0) {
                z = false;
            } else {
                z = true;
            }
            boolean a2 = a(selectCodec, string);
            if (z && a2) {
                this.mediaFormat.setInteger(Scopes.PROFILE, 8);
                this.mediaFormat.setInteger("level", 256);
                z2 = true;
            } else if (z3) {
                this.mediaFormat.setInteger(Scopes.PROFILE, 1);
                this.mediaFormat.setInteger("level", 256);
                z2 = true;
            } else if (selectCodec != null) {
                z2 = a(selectCodec, string, this.qsk);
            }
            if (z2) {
                this.qsj = this.mediaFormat.getInteger(Scopes.PROFILE);
            } else {
                this.qsj = 1;
            }
        }
        this.mediaFormat.setInteger("bitrate-mode", 2);
        try {
            this.qsc = z.q(string, false);
            SetBitRate(this.m_br_kbps);
            Log.i("MultiAvcEncoder[HWEnc]", "steve: mediaFormat: " + this.mediaFormat + ", actProfile: " + this.qsj);
            this.qsc.a(this.mediaFormat, (Surface) null, 1);
            this.qsc.start();
            this.qsi = new g();
            AppMethodBeat.o(239342);
            return 2000;
        } catch (Exception e2) {
            Log.e("MultiAvcEncoder[HWEnc]", " error:" + e2.toString());
            this.qsb = 2002;
            int i3 = -this.qsb;
            AppMethodBeat.o(239342);
            return i3;
        }
    }

    public k(String str) {
        AppMethodBeat.i(239343);
        Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] MultiAvcEncoder width[%d], height[%d], framerate[%d], bitrate[%d], profileCfg[%d]", 1920, 1080, 5, 3000, 0, str);
        this.mPrevResolution = 8;
        this.m_width = 1920;
        this.m_height = 1080;
        this.m_CapW = 1920;
        this.m_CapH = 1080;
        this.ENCODING = str;
        this.m_framerate = 5;
        this.m_br_kbps = 3000;
        this.mProfileCfg = 0;
        frameID = 0;
        this.mGeneratedIdx = 0;
        this.zLN = new a();
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
        this.qsm = 0;
        this.zLM = 0;
        this.igB = 0;
        try {
            cyY();
            AppMethodBeat.o(239343);
        } catch (Exception e2) {
            Log.e("MultiAvcEncoder[HWEnc]", "mediacodec init error: " + e2.getMessage());
            this.qsb = 2003;
            AppMethodBeat.o(239343);
        }
    }

    @SuppressLint({"NewApi"})
    private void StopEncoder() {
        AppMethodBeat.i(239344);
        try {
            if (this.qsc != null) {
                this.qsc.stop();
                this.qsc.release();
            }
            AppMethodBeat.o(239344);
        } catch (Exception e2) {
            Log.e("MultiAvcEncoder[HWEnc]", " error:" + e2.toString());
            AppMethodBeat.o(239344);
        }
    }

    private static String bO(byte[] bArr) {
        AppMethodBeat.i(239345);
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(hexString));
            }
            str = str + hexString;
        }
        AppMethodBeat.o(239345);
        return str;
    }

    private static ArrayList<Integer> bS(byte[] bArr) {
        AppMethodBeat.i(239346);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i2 = 0;
        String bO = bO(bArr);
        String bO2 = bO(new byte[]{0, 0, 0, 1});
        Log.d("MultiAvcEncoder[HWEnc]", "parent: " + bO + ", child:" + bO2);
        while (true) {
            int indexOf = bO.indexOf(bO2, i2);
            if (indexOf != -1) {
                Log.d("MultiAvcEncoder[HWEnc]", "vps/sps/pps start: " + i2 + ", nextStartIdx:" + indexOf);
                i2 = bO2.length() + indexOf;
                arrayList.add(Integer.valueOf(indexOf / 2));
            } else {
                AppMethodBeat.o(239346);
                return arrayList;
            }
        }
    }

    public static int emC() {
        AppMethodBeat.i(239347);
        Log.i("MultiAvcEncoder[HWEnc]", "closecodec: targetCodec: 8localClose: trueremoteClose: false" + "isEncoderTag: true");
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putShort(2);
        allocate.putShort(8);
        allocate.putShort(0);
        ac.eol().zMd.setAppCmd(zLJ, allocate.array(), 6);
        AppMethodBeat.o(239347);
        return 1;
    }

    public final int b(byte[] bArr, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        AppMethodBeat.i(239348);
        byte[] bArr2 = null;
        SetBitRate(this.m_br_kbps);
        Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] m_CapW[%d], m_CapH[%d], w[%d], h[%d], m_width[%d], m_height[%d]", Integer.valueOf(this.m_CapW), Integer.valueOf(this.m_CapH), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.m_width), Integer.valueOf(this.m_height));
        if (!(i2 == this.m_CapW && i3 == this.m_CapH)) {
            this.m_CapW = i2;
            this.m_CapH = i3;
            this.qsd = new byte[(((this.m_CapW * this.m_CapH) * 3) / 2)];
        }
        if (this.qsd == null) {
            this.qsd = new byte[(((this.m_CapW * this.m_CapH) * 3) / 2)];
        }
        Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] m_CapW[%d], m_CapH[%d], w[%d], h[%d], m_width[%d], m_height[%d]", Integer.valueOf(this.m_CapW), Integer.valueOf(this.m_CapH), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.m_width), Integer.valueOf(this.m_height));
        Log.i("MultiAvcEncoder[HWEnc]", "steve: m_framerate: " + this.m_framerate + ", m_br_kbps:" + this.m_br_kbps + ", format:" + i4 + ", cSkipFlag:" + ((int) this.zLN.cSkipFlag) + ", m_width:" + this.m_width + ", m_height:" + this.m_height + ", w:" + i2 + ", h:" + i3 + ", rawFrame:" + bArr + ", yuv420sp:" + this.qsd);
        if (this.zLN.cSkipFlag != 0 || this.qsd == null) {
            i5 = 0;
        } else {
            int i8 = this.m_CapW;
            int i9 = this.m_CapH;
            ac.eol().zMd.screenTrans(bArr, this.m_CapW, this.m_CapH, i4, this.qsd, i8, i9, i4);
            Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] m_CapW[%d], m_CapH[%d], w[%d], h[%d], m_width[%d], m_height[%d]", Integer.valueOf(this.m_CapW), Integer.valueOf(this.m_CapH), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.m_width), Integer.valueOf(this.m_height));
            byte[] bArr3 = this.qsd;
            this.encLen = ((this.m_width * this.m_height) * 3) >> 1;
            if (this.m_width == i8 && this.m_height == i9) {
                i5 = 0;
            } else {
                this.m_width = i8;
                this.m_height = i9;
                this.encLen = ((this.m_width * this.m_height) * 3) >> 1;
                try {
                    i5 = cyY();
                } catch (Exception e2) {
                    Log.e("MultiAvcEncoder[HWEnc]", "mediacodec init error: " + e2.getMessage());
                    this.qsb = 2003;
                    i5 = -this.qsb;
                }
                if (i5 < 0) {
                    Log.e("MultiAvcEncoder[HWEnc]", "mediacodec init failed, stop HW encoding! ret: ".concat(String.valueOf(i5)));
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
                    } catch (Exception e3) {
                        Log.e("MultiAvcEncoder[HWEnc]", " error:" + e3.toString());
                    }
                    AppMethodBeat.o(239348);
                    return i5;
                }
            }
            if (frameID <= 100 && this.qsh != null) {
                try {
                    this.qsh.write(this.qsd, 0, this.encLen);
                    bArr2 = bArr3;
                } catch (Exception e4) {
                    Log.e("MultiAvcEncoder[HWEnc]", " error:" + e4.toString());
                }
            }
            bArr2 = bArr3;
        }
        if (bArr2 == null || this.qsc == null) {
            int i10 = this.qsm;
            this.qsm = i10 + 1;
            if (i10 > 5) {
                Log.e("MultiAvcEncoder[HWEnc]", " anlingao[multi_hw] ENUM_AVCEncNULLPointer: 2006");
                this.qsb = 2006;
                i5 = -this.qsb;
            }
        } else {
            try {
                this.qsm = 0;
                Log.d("MultiAvcEncoder[HWEnc]", "steve: put YUV into encoder, size:" + this.encLen + ", idx:" + frameID + ", time:" + System.currentTimeMillis());
                ByteBuffer[] inputBuffers = this.qsc.getInputBuffers();
                ByteBuffer[] outputBuffers = this.qsc.getOutputBuffers();
                int dequeueInputBuffer = this.qsc.dequeueInputBuffer(-1);
                Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] inputBufferIndex: ".concat(String.valueOf(dequeueInputBuffer)));
                if (dequeueInputBuffer >= 0) {
                    long j2 = this.mGeneratedIdx;
                    int min = Math.min(Math.max(this.m_framerate, 15), 30);
                    if (j2 == 0 || this.igB == 0) {
                        this.igB = 132;
                    } else {
                        this.igB += (long) (1000000 / min);
                    }
                    long j3 = this.igB;
                    Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] pts: ".concat(String.valueOf(j3)));
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    byteBuffer.put(bArr2, 0, this.encLen);
                    this.qsc.a(dequeueInputBuffer, this.encLen, j3, 0);
                    this.mGeneratedIdx++;
                }
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.qsc.dequeueOutputBuffer(bufferInfo, (long) this.TIMEOUT_USEC);
                Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] outputBufferIndex: ".concat(String.valueOf(dequeueOutputBuffer)));
                if (dequeueOutputBuffer == -2) {
                    Log.i("MultiAvcEncoder[HWEnc]", "steve: encoder output format changed: ".concat(String.valueOf(this.qsc.getOutputFormat())));
                }
                Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] outputBufferIndex: ".concat(String.valueOf(dequeueOutputBuffer)));
                while (dequeueOutputBuffer >= 0) {
                    ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                    byte[] bArr4 = new byte[bufferInfo.size];
                    byteBuffer2.get(bArr4);
                    if (this.outputStream != null) {
                        this.outputStream.write(bArr4, 0, bArr4.length);
                    }
                    Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] bufferInfo.flags: " + bufferInfo.flags);
                    if (bufferInfo.flags == 2) {
                        ArrayList<Integer> bS = bS(bArr4);
                        cap cap = new cap();
                        int i11 = 0;
                        int i12 = 0;
                        int i13 = 0;
                        int i14 = 0;
                        int i15 = 0;
                        int i16 = 0;
                        if (bS.size() == 3 && this.ENCODING.equalsIgnoreCase(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
                            i11 = bS.get(0).intValue() + 4;
                            i13 = bS.get(1).intValue() + 4;
                            i15 = bS.get(2).intValue() + 4;
                            i12 = (i13 - i11) - 4;
                            i14 = (i15 - i13) - 4;
                            i16 = bufferInfo.size - i15;
                            cap.MfN = com.tencent.mm.bw.b.Q(bArr4, i11, i12);
                        } else if (bS.size() == 2) {
                            i13 = bS.get(0).intValue() + 4;
                            i15 = bS.get(1).intValue() + 4;
                            i14 = (i15 - i13) - 4;
                            i16 = bufferInfo.size - i15;
                        }
                        Log.d("MultiAvcEncoder[HWEnc]", "sps start: " + i13 + ", len:" + i14 + ", pps start:" + i15 + ", len:" + i16 + ", vps start: " + i11 + ", len:" + i12);
                        if (this.qsj == 1 || !this.qsi.cg(bArr4)) {
                            cap.MfK = 4;
                            cap.MfL = com.tencent.mm.bw.b.Q(bArr4, i13, i14);
                            cap.MfM = com.tencent.mm.bw.b.Q(bArr4, i15, i16);
                            int I = I(cap.toByteArray(), bufferInfo.flags, cap.toByteArray().length);
                            if (I < 0) {
                                AppMethodBeat.o(239348);
                                return I;
                            }
                        } else {
                            this.qsl = this.qsi.GTT;
                            this.qsk = 1;
                            Log.i("MultiAvcEncoder[HWEnc]", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.qsk + ", checkCodeForBSlice:" + this.qsl);
                            try {
                                i7 = cyY();
                            } catch (Exception e5) {
                                Log.e("MultiAvcEncoder[HWEnc]", "mediacodec reinit error: " + e5.getMessage());
                                this.qsb = 2005;
                                i7 = -this.qsb;
                            }
                            AppMethodBeat.o(239348);
                            return i7;
                        }
                    } else if (this.qsj != 1 && this.qsi.ch(bArr4)) {
                        this.qsl = this.qsi.GTT;
                        this.qsk = 1;
                        Log.i("MultiAvcEncoder[HWEnc]", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.qsk + ", checkCodeForBSlice:" + this.qsl);
                        try {
                            i6 = cyY();
                        } catch (Exception e6) {
                            Log.e("MultiAvcEncoder[HWEnc]", "mediacodec reinit error: " + e6.getMessage());
                            this.qsb = 2005;
                            i6 = -this.qsb;
                        }
                        AppMethodBeat.o(239348);
                        return i6;
                    } else if (bufferInfo.flags == 0 || bufferInfo.flags == 1) {
                        ByteBuffer allocate = ByteBuffer.allocate(4);
                        allocate.putInt(bufferInfo.size - 4);
                        System.arraycopy(allocate.order(ByteOrder.BIG_ENDIAN).array(), 0, bArr4, 0, 4);
                        Log.d("MultiAvcEncoder[HWEnc]", " type:" + bufferInfo.flags + ", size:" + bufferInfo.size + ", idx:" + frameID + ", time:" + System.currentTimeMillis());
                        cao cao = new cao();
                        cao.MfG = com.tencent.mm.bw.b.Q(bArr4, 0, bufferInfo.size);
                        cao.MfH = 1;
                        cao.MfI = this.zLK;
                        this.zLL.set(0, Integer.valueOf(bufferInfo.size));
                        cao.MfJ = this.zLL;
                        int I2 = I(cao.toByteArray(), bufferInfo.flags, cao.toByteArray().length);
                        if (I2 < 0) {
                            AppMethodBeat.o(239348);
                            return I2;
                        }
                    } else {
                        this.qsb = 2009;
                        int i17 = -this.qsb;
                        Log.i("MultiAvcEncoder[HWEnc]", "steve:unknown frame error!!! type:" + bufferInfo.flags + ", len:" + bufferInfo.size);
                        AppMethodBeat.o(239348);
                        return i17;
                    }
                    if (this.qsg && byteBuffer2 != null) {
                        this.qse.writeSampleData(this.qsf, byteBuffer2, bufferInfo);
                    }
                    i5 = bufferInfo.flags;
                    frameID++;
                    this.qsc.releaseOutputBuffer(dequeueOutputBuffer, false);
                    dequeueOutputBuffer = this.qsc.dequeueOutputBuffer(bufferInfo, (long) this.TIMEOUT_USEC);
                }
            } catch (Exception e7) {
                Log.e("MultiAvcEncoder[HWEnc]", " error:" + e7.toString());
                this.qsb = 2004;
                i5 = -this.qsb;
            }
        }
        AppMethodBeat.o(239348);
        return i5;
    }

    public final void DoQosSvrCtrl() {
        AppMethodBeat.i(239349);
        int appCmd = ac.eol().zMd.setAppCmd(zLO, this.zLN.s2p, this.zLN.s2p.length);
        Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] EMethodGetQosPara ret[%d], len[%d]", Integer.valueOf(appCmd), Integer.valueOf(this.zLN.s2p.length));
        if (appCmd >= 0) {
            a aVar = this.zLN;
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
            a aVar2 = this.zLN;
            Log.d("MultiAvcEncoder[HWEnc]", "raw S2P:" + aVar2.s2p);
            Log.d("MultiAvcEncoder[HWEnc]", "-S2P- iKbps:" + ((int) aVar2.iKbps) + ", fps:" + ((int) aVar2.cFps) + ", IP:" + ((int) aVar2.cIPeriod) + ", RS:" + ((int) aVar2.cRSLevel) + ", QPMin:" + ((int) aVar2.cQPmin) + ", QPMax:" + ((int) aVar2.cQPmax) + ", HPP:" + ((int) aVar2.cHPPMaxLyr) + ", SWitch:" + ((int) aVar2.cSwitch) + ", Reso:" + ((int) aVar2.cResolution) + ", Rsvd1:" + ((int) aVar2.cRsvd1) + ", Rsvd2:" + ((int) aVar2.cRsvd2) + ", Skip:" + ((int) aVar2.cSkipFlag) + ", IReq:" + ((int) aVar2.cIReqFlag));
        }
        short s = this.zLN.iKbps;
        if (this.m_br_kbps != s) {
            SetBitRate(s);
            Log.i("MultiAvcEncoder[HWEnc]", "steve[QoS]: Update BR! frameID: " + frameID + ", new_br: " + this.m_br_kbps + ", tuneBR:" + ((int) s));
            this.m_br_kbps = s;
        }
        if (1 == this.zLN.cIReqFlag && frameID > 0) {
            if (this.qsc != null) {
                Log.v("MultiAvcEncoder[HWEnc]", "steve: Sync frame request soon!");
                Bundle bundle = new Bundle();
                bundle.putInt("request-sync", 0);
                this.qsc.setParameters(bundle);
            }
            Log.i("MultiAvcEncoder[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + frameID);
        }
        if (this.zLN.cFps != this.m_framerate) {
            this.m_framerate = this.zLN.cFps;
        }
        AppMethodBeat.o(239349);
    }

    public final boolean emD() {
        AppMethodBeat.i(239350);
        Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] cRsvd1: " + ((int) this.zLN.cRsvd1));
        if ((this.zLN.cRsvd1 & 1) == 1) {
            AppMethodBeat.o(239350);
            return true;
        }
        AppMethodBeat.o(239350);
        return false;
    }

    @SuppressLint({"NewApi"})
    private boolean SetBitRate(int i2) {
        AppMethodBeat.i(239351);
        try {
            if (this.qsc != null) {
                if (i2 <= 0) {
                    i2 = 700;
                }
                Bundle bundle = new Bundle();
                int i3 = i2 * 1000;
                Log.v("MultiAvcEncoder[HWEnc]", "steve: setRates: ".concat(String.valueOf(i3)));
                bundle.putInt("video-bitrate", i3);
                this.qsc.setParameters(bundle);
                AppMethodBeat.o(239351);
                return true;
            }
        } catch (Exception e2) {
            Log.e("MultiAvcEncoder[HWEnc]", "steve: setRates failed:".concat(String.valueOf(e2)));
        }
        AppMethodBeat.o(239351);
        return false;
    }

    private int I(byte[] bArr, int i2, int i3) {
        int i4;
        AppMethodBeat.i(239352);
        if (bArr != null) {
            int i5 = VFMT_i264;
            if (this.ENCODING.equalsIgnoreCase(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
                i5 = VFMT_HEVC_HW;
            }
            if (ac.eom().ens()) {
                i4 = p.INSTANCE.g(bArr, this.m_width, i2, i5 + 128);
            } else {
                i4 = ac.eol().zMd.d(bArr, i3, this.m_width, i2, i5);
            }
            Log.i("MultiAvcEncoder[HWEnc]", "anlingao[multi_hw] ret[%d],  m_width[%d], m_height[%d], type[%d], format[%d]", Integer.valueOf(i4), Integer.valueOf(this.m_width), Integer.valueOf(this.m_height), Integer.valueOf(i2), Integer.valueOf(i5));
            if (i4 >= 0) {
                this.zLM = 0;
                Log.d("MultiAvcEncoder[HWEnc]", "steve: send successfully! frameLen = " + i3 + ", type = " + i2 + ", pkt cnt = " + i4);
            } else {
                int i6 = this.zLM;
                this.zLM = i6 + 1;
                if (i6 > 5) {
                    this.qsb = 2008;
                    i4 = -this.qsb;
                    Log.e("MultiAvcEncoder[HWEnc]", "steve: hw send error for 5 times!! send ret = ".concat(String.valueOf(i4)));
                }
            }
            AppMethodBeat.o(239352);
            return i4;
        }
        i4 = 0;
        AppMethodBeat.o(239352);
        return i4;
    }
}
