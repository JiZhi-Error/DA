package com.tencent.mm.plugin.multitalk.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Surface;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.voip.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import java.io.BufferedOutputStream;

@TargetApi(16)
public final class h {
    public static short[] SizeFormat2WH = {128, 96, 240, 160, 320, 240, 480, 360, 640, 480};
    public static int VFMT_HEVC_HW = 19;
    public static int VFMT_i264 = 18;
    public static int frameID = 0;
    private static String path = Environment.getExternalStorageDirectory().getAbsolutePath();
    private static int streamqueuesize = 100;
    private static final String[] supportedH264HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos.", "OMX.hisi", "OMX.MTK"};
    public String ENCODING = "hevc";
    private int TIMEOUT_USEC = 12000;
    public byte[] configbyte = null;
    public int encLen = 0;
    public long igB = 0;
    public boolean isRuning = false;
    public long mGeneratedIdx = 0;
    int mPrevResolution = 8;
    int mProfileCfg = 1;
    int m_CapH = 240;
    int m_CapW = 320;
    int m_br_kbps;
    int m_framerate;
    int m_height = 240;
    int m_width = 320;
    protected MediaFormat mediaFormat;
    private BufferedOutputStream outputStream;
    public int qsb = 0;
    z qsc;
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
    a zHw = null;

    static {
        AppMethodBeat.i(239033);
        AppMethodBeat.o(239033);
    }

    @SuppressLint({"NewApi"})
    private boolean a(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.i(239024);
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
                            Log.d("ILink[HWEnc]", "steve : [" + name + "] supported profiles:" + codecProfileLevel.profile + ", maxAllowedProfile: " + this.qsk + ", MIME:" + str);
                        }
                    } catch (Exception e2) {
                    }
                }
            }
        }
        AppMethodBeat.o(239024);
        return z;
    }

    private boolean a(MediaCodecInfo mediaCodecInfo, String str, int i2) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        boolean z;
        AppMethodBeat.i(239025);
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
                        Log.i("ILink[HWEnc]", "steve : profile: " + i3 + ", level: " + i4 + ", maxProfile: " + i2 + ", isRecognized:" + z3);
                    }
                    Log.i("ILink[HWEnc]", "best profile: " + codecProfileLevel.profile + ", best level: " + codecProfileLevel.level);
                    if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                        this.mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                        this.mediaFormat.setInteger("level", 256);
                        z2 = true;
                    }
                }
            } catch (Exception e2) {
                Log.e("ILink[HWEnc]", "trySetProfile error: " + e2.getMessage());
            }
        }
        AppMethodBeat.o(239025);
        return z2;
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo) {
        boolean z = false;
        AppMethodBeat.i(239026);
        String name = mediaCodecInfo.getName();
        String[] strArr = supportedH264HwCodecPrefixes;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (name.startsWith(strArr[i2])) {
                z = true;
                Log.d("ILink[HWEnc]", "steve : known H.264 HW encoder :".concat(String.valueOf(name)));
                break;
            } else {
                i2++;
            }
        }
        AppMethodBeat.o(239026);
        return z;
    }

    @SuppressLint({"NewApi"})
    private int cyY() {
        MediaCodecInfo mediaCodecInfo;
        String[] supportedTypes;
        boolean z = false;
        AppMethodBeat.i(239027);
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
                        Log.d("ILink[HWEnc]", "steve : H.264 HW encoder found:".concat(String.valueOf(codecInfoAt.getName())));
                        mediaCodecInfo = codecInfoAt;
                        break loop0;
                    }
                }
                continue;
            }
            i2++;
        }
        if (mediaCodecInfo == null) {
            Log.e("ILink[HWEnc]", "steve: Unable to find an appropriate codec for " + this.ENCODING);
            this.qsb = 2001;
            int i3 = -this.qsb;
            AppMethodBeat.o(239027);
            return i3;
        }
        Log.i("ILink[HWEnc]", "steve: found HW codec: " + mediaCodecInfo.getName());
        this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
        this.mediaFormat.setInteger("color-format", 21);
        this.mediaFormat.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.m_br_kbps * 1000);
        this.mediaFormat.setInteger("frame-rate", this.m_framerate);
        this.mediaFormat.setInteger("i-frame-interval", 1);
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
            Log.i("ILink[HWEnc]", "steve: mediaFormat: " + this.mediaFormat + ", actProfile: " + this.qsj);
            this.qsc.a(this.mediaFormat, (Surface) null, 1);
            this.qsc.start();
            this.qsi = new g();
            AppMethodBeat.o(239027);
            return 2000;
        } catch (Exception e2) {
            Log.e("ILink[HWEnc]", " error:" + e2.toString());
            this.qsb = 2002;
            int i4 = -this.qsb;
            AppMethodBeat.o(239027);
            return i4;
        }
    }

    public h(int i2, int i3, String str) {
        AppMethodBeat.i(239028);
        this.ENCODING = str;
        this.m_framerate = i2;
        this.m_br_kbps = i3;
        this.mProfileCfg = -1;
        new StringBuilder().append(path).append("/AVLog/enc.yuv");
        o oVar = new o(path + "/AVLog/mediacodec.h264");
        if (oVar.exists()) {
            oVar.delete();
        }
        try {
            this.outputStream = new BufferedOutputStream(s.ap(oVar));
        } catch (Exception e2) {
            Log.e("ILink[HWEnc]", " error:" + e2.toString());
        }
        frameID = 0;
        this.mGeneratedIdx = 0;
        this.zHw = new a();
        this.qsc = null;
        this.qsk = 8;
        this.qsj = 0;
        this.qsl = 0;
        this.qsb = 0;
        this.qsd = null;
        this.qsm = 0;
        this.igB = 0;
        AppMethodBeat.o(239028);
    }

    @SuppressLint({"NewApi"})
    private void StopEncoder() {
        AppMethodBeat.i(239029);
        try {
            if (this.qsc != null) {
                this.qsc.stop();
                this.qsc.release();
            }
            AppMethodBeat.o(239029);
        } catch (Exception e2) {
            Log.e("ILink[HWEnc]", " error:" + e2.toString());
            AppMethodBeat.o(239029);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x03a1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0169  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(byte[] r11, int r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 941
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.b.h.b(byte[], int, int, int):int");
    }

    @SuppressLint({"NewApi"})
    public final boolean SetBitRate(int i2) {
        AppMethodBeat.i(239031);
        try {
            if (this.qsc != null) {
                Bundle bundle = new Bundle();
                int i3 = i2 * 1000;
                Log.v("ILink[HWEnc]", "steve: setRates: ".concat(String.valueOf(i3)));
                bundle.putInt("video-bitrate", i3);
                this.qsc.setParameters(bundle);
                AppMethodBeat.o(239031);
                return true;
            }
        } catch (Exception e2) {
            Log.e("ILink[HWEnc]", "steve: setRates failed:".concat(String.valueOf(e2)));
        }
        AppMethodBeat.o(239031);
        return false;
    }

    private void E(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(239032);
        int i4 = VFMT_i264;
        if (this.ENCODING.equalsIgnoreCase(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
            i4 = VFMT_HEVC_HW;
        }
        int c2 = m.c(bArr, this.m_width, i2, i4);
        if (c2 > 0) {
            Log.d("ILink[HWEnc]", "steve: send successfully! frameLen = " + i3 + ", type = " + i2 + ", pkt cnt = " + c2);
        }
        AppMethodBeat.o(239032);
    }
}
