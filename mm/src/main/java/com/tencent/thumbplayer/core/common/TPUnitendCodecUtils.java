package com.tencent.thumbplayer.core.common;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class TPUnitendCodecUtils {
    private static int DolbyVisionProfileDvavPen = 1;
    private static int DolbyVisionProfileDvavPer = 0;
    private static int DolbyVisionProfileDvavSe = 9;
    private static int DolbyVisionProfileDvheDen = 3;
    private static int DolbyVisionProfileDvheDer = 2;
    private static int DolbyVisionProfileDvheDtb = 7;
    private static int DolbyVisionProfileDvheDth = 6;
    private static int DolbyVisionProfileDvheDtr = 4;
    private static int DolbyVisionProfileDvheSt = 8;
    private static int DolbyVisionProfileDvheStn = 5;
    private static HashMap<String, String> mSecureDecoderNameMaps = null;

    public static synchronized String getSecureDecoderName(String str) {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        String str2 = null;
        synchronized (TPUnitendCodecUtils.class) {
            AppMethodBeat.i(189862);
            if (TextUtils.equals("video/avc", str) || TextUtils.equals(TPDecoderType.TP_CODEC_MIMETYPE_HEVC, str) || TextUtils.equals(TPDecoderType.TP_CODEC_MIMETYPE_DOLBYVISION, str)) {
                if (mSecureDecoderNameMaps == null) {
                    mSecureDecoderNameMaps = new HashMap<>();
                }
                if (mSecureDecoderNameMaps.containsKey(str)) {
                    str2 = mSecureDecoderNameMaps.get(str);
                    AppMethodBeat.o(189862);
                } else {
                    MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
                    if (codecInfos == null) {
                        AppMethodBeat.o(189862);
                    } else {
                        int length = codecInfos.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            }
                            MediaCodecInfo mediaCodecInfo = codecInfos[i2];
                            if (!mediaCodecInfo.isEncoder()) {
                                try {
                                    codecCapabilities = mediaCodecInfo.getCapabilitiesForType(str);
                                } catch (Exception e2) {
                                    codecCapabilities = null;
                                }
                                if (codecCapabilities != null && codecCapabilities.isFeatureSupported("secure-playback")) {
                                    str2 = mediaCodecInfo.getName();
                                    break;
                                }
                            }
                            i2++;
                        }
                        mSecureDecoderNameMaps.put(str, str2);
                        AppMethodBeat.o(189862);
                    }
                }
            } else {
                AppMethodBeat.o(189862);
            }
        }
        return str2;
    }

    public static synchronized String getDolbyVisionDecoderName(String str, int i2, int i3, boolean z) {
        String str2;
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        synchronized (TPUnitendCodecUtils.class) {
            AppMethodBeat.i(189863);
            if (!TextUtils.equals(TPDecoderType.TP_CODEC_MIMETYPE_DOLBYVISION, str)) {
                str2 = null;
                AppMethodBeat.o(189863);
            } else if (Build.VERSION.SDK_INT < 21) {
                str2 = null;
                AppMethodBeat.o(189863);
            } else {
                MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
                if (codecInfos == null) {
                    str2 = null;
                    AppMethodBeat.o(189863);
                } else {
                    str2 = null;
                    int length = codecInfos.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        }
                        MediaCodecInfo mediaCodecInfo = codecInfos[i4];
                        TPNativeLog.printLog(2, "TPUnitendCodecUtils", "getDolbyVisionDecoderName name:" + mediaCodecInfo.getName());
                        if (!mediaCodecInfo.isEncoder()) {
                            try {
                                codecCapabilities = mediaCodecInfo.getCapabilitiesForType(str);
                            } catch (Exception e2) {
                                codecCapabilities = null;
                            }
                            if (codecCapabilities != null) {
                                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = codecCapabilities.profileLevels;
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= codecProfileLevelArr.length) {
                                        break;
                                    }
                                    int convertOmxProfileToDolbyVision = convertOmxProfileToDolbyVision(codecProfileLevelArr[i5].profile);
                                    if (convertOmxProfileToDolbyVision == i2) {
                                        TPNativeLog.printLog(2, "TPUnitendCodecUtils", "getDolbyVisionDecoderName i:" + i5 + " profile:" + convertOmxProfileToDolbyVision + " dvProfile:" + i2 + " bSecure:" + z + " name:" + mediaCodecInfo.getName());
                                        if (!z) {
                                            str2 = mediaCodecInfo.getName();
                                            break;
                                        } else if (codecCapabilities.isFeatureSupported("secure-playback")) {
                                            str2 = mediaCodecInfo.getName();
                                            break;
                                        }
                                    }
                                    i5++;
                                }
                                if (str2 != null) {
                                    TPNativeLog.printLog(2, "TPUnitendCodecUtils", "getDolbyVisionDecoderName name:".concat(String.valueOf(str2)));
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                        i4++;
                    }
                    AppMethodBeat.o(189863);
                }
            }
        }
        return str2;
    }

    public static int convertOmxProfileToDolbyVision(int i2) {
        AppMethodBeat.i(189864);
        int i3 = 0;
        switch (i2) {
            case 1:
                i3 = DolbyVisionProfileDvavPer;
                break;
            case 2:
                i3 = DolbyVisionProfileDvavPen;
                break;
            case 4:
                i3 = DolbyVisionProfileDvheDer;
                break;
            case 8:
                i3 = DolbyVisionProfileDvheDen;
                break;
            case 16:
                i3 = DolbyVisionProfileDvheDtr;
                break;
            case 32:
                i3 = DolbyVisionProfileDvheStn;
                break;
            case 64:
                i3 = DolbyVisionProfileDvheDth;
                break;
            case 128:
                i3 = DolbyVisionProfileDvheDtb;
                break;
            case 256:
                i3 = DolbyVisionProfileDvheSt;
                break;
            case 512:
                i3 = DolbyVisionProfileDvavSe;
                break;
        }
        TPNativeLog.printLog(2, "TPUnitendCodecUtils", "convertOmxProfileToDolbyVision omxProfile:" + i2 + " dolbyVisionProfile:" + i3);
        AppMethodBeat.o(189864);
        return i3;
    }
}
