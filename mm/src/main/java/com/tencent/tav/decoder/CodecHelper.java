package com.tencent.tav.decoder;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Range;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.List;

public class CodecHelper {
    public static final int MAX_BIT_RATE = 8000000;
    private static final String TAG = CodecHelper.class.getSimpleName();

    static {
        AppMethodBeat.i(218143);
        AppMethodBeat.o(218143);
    }

    public static CGSize correctSupportSize(CGSize cGSize, String str) {
        AppMethodBeat.i(218131);
        int i2 = (int) cGSize.width;
        int i3 = (int) cGSize.height;
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        int i4 = 0;
        while (i4 < codecCount && mediaCodecInfo == null) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i4);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                boolean z = false;
                for (int i5 = 0; i5 < supportedTypes.length && !z; i5++) {
                    if (supportedTypes[i5].equals(str)) {
                        z = true;
                    }
                }
                if (z) {
                    i4++;
                    mediaCodecInfo = codecInfoAt;
                }
            }
            codecInfoAt = mediaCodecInfo;
            i4++;
            mediaCodecInfo = codecInfoAt;
        }
        int widthAlignment = getWidthAlignment(mediaCodecInfo, str);
        int heightAlignment = getHeightAlignment(mediaCodecInfo, str);
        int ceil = (int) (Math.ceil((double) ((((float) i2) * 1.0f) / ((float) widthAlignment))) * ((double) widthAlignment));
        int ceil2 = (int) (Math.ceil((double) ((((float) i3) * 1.0f) / ((float) heightAlignment))) * ((double) heightAlignment));
        Logger.d(TAG, "correctSupportSize 1: target = [" + ceil + ", " + ceil2 + "]");
        int clampWidth = clampWidth(mediaCodecInfo, str, i2);
        if (ceil != clampWidth) {
            ceil2 = (int) (((float) ceil2) * ((((float) clampWidth) * 1.0f) / ((float) ceil)));
        } else {
            clampWidth = ceil;
        }
        Logger.d(TAG, "correctSupportSize 2: target = [" + clampWidth + ", " + ceil2 + "]");
        int clampHeight = clampHeight(mediaCodecInfo, str, i3);
        if (ceil2 != clampHeight) {
            clampWidth = (int) (((((float) clampHeight) * 1.0f) / ((float) ceil2)) * ((float) clampWidth));
            ceil2 = clampHeight;
        }
        Logger.d(TAG, "correctSupportSize 3: target = [" + clampWidth + ", " + ceil2 + "]");
        if (!isSupported(mediaCodecInfo, str, clampWidth, ceil2)) {
            clampWidth = (int) (Math.ceil((double) (((float) i2) / 16.0f)) * 16.0d);
            ceil2 = (int) (Math.ceil((double) (((float) i3) / 16.0f)) * 16.0d);
        }
        Logger.i(TAG, "correctSupportSize return: target = [" + clampWidth + ", " + ceil2 + "]");
        CGSize cGSize2 = new CGSize((float) clampWidth, (float) ceil2);
        AppMethodBeat.o(218131);
        return cGSize2;
    }

    private static List<MediaCodecInfo> decoderCodecInfo(String str) {
        AppMethodBeat.i(218132);
        int codecCount = MediaCodecList.getCodecCount();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (!codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                int length = supportedTypes.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (supportedTypes[i3].equals(str)) {
                        arrayList.add(codecInfoAt);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        AppMethodBeat.o(218132);
        return arrayList;
    }

    private static List<MediaCodecInfo> encoderCodecInfo(String str) {
        AppMethodBeat.i(218133);
        int codecCount = MediaCodecList.getCodecCount();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                int length = supportedTypes.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (supportedTypes[i3].equals(str)) {
                        arrayList.add(codecInfoAt);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        AppMethodBeat.o(218133);
        return arrayList;
    }

    private static int getWidthAlignment(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.i(218134);
        if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(218134);
            return 16;
        } else if (mediaCodecInfo != null) {
            int widthAlignment = mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities().getWidthAlignment();
            AppMethodBeat.o(218134);
            return widthAlignment;
        } else {
            AppMethodBeat.o(218134);
            return 16;
        }
    }

    private static int getHeightAlignment(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.i(218135);
        if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(218135);
            return 16;
        } else if (mediaCodecInfo != null) {
            int heightAlignment = mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities().getHeightAlignment();
            AppMethodBeat.o(218135);
            return heightAlignment;
        } else {
            AppMethodBeat.o(218135);
            return 16;
        }
    }

    private static boolean isSupported(MediaCodecInfo mediaCodecInfo, String str, int i2, int i3) {
        AppMethodBeat.i(218136);
        if (Build.VERSION.SDK_INT < 21 || mediaCodecInfo == null || !mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities().isSizeSupported(i2, i3)) {
            AppMethodBeat.o(218136);
            return false;
        }
        AppMethodBeat.o(218136);
        return true;
    }

    public static int clampWidth(MediaCodecInfo mediaCodecInfo, String str, int i2) {
        AppMethodBeat.i(218137);
        if (Build.VERSION.SDK_INT < 21 || mediaCodecInfo == null) {
            AppMethodBeat.o(218137);
            return i2;
        }
        int intValue = mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities().getSupportedWidths().clamp(Integer.valueOf(i2)).intValue();
        AppMethodBeat.o(218137);
        return intValue;
    }

    public static int clampHeight(MediaCodecInfo mediaCodecInfo, String str, int i2) {
        AppMethodBeat.i(218138);
        if (Build.VERSION.SDK_INT < 21 || mediaCodecInfo == null) {
            AppMethodBeat.o(218138);
            return i2;
        }
        int intValue = mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities().getSupportedHeights().clamp(Integer.valueOf(i2)).intValue();
        AppMethodBeat.o(218138);
        return intValue;
    }

    public static boolean checkVideoOutSupported(int i2, int i3, int i4, int i5, String str) {
        AppMethodBeat.i(218139);
        List<MediaCodecInfo> encoderCodecInfo = encoderCodecInfo(str);
        if (encoderCodecInfo.size() > 0) {
            for (MediaCodecInfo mediaCodecInfo : encoderCodecInfo) {
                MediaCodecInfo.VideoCapabilities videoCapabilities = mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities();
                boolean contains = videoCapabilities.getBitrateRange().contains(Integer.valueOf(i5));
                boolean contains2 = videoCapabilities.getSupportedFrameRates().contains(Integer.valueOf(i4));
                boolean isSizeSupported = videoCapabilities.isSizeSupported(i2, i3);
                if (contains && contains2 && isSizeSupported) {
                    AppMethodBeat.o(218139);
                    return true;
                }
            }
        }
        AppMethodBeat.o(218139);
        return false;
    }

    public static boolean checkAudioOutSupported(int i2, int i3, int i4, String str) {
        boolean z;
        AppMethodBeat.i(218140);
        List<MediaCodecInfo> encoderCodecInfo = encoderCodecInfo(str);
        if (encoderCodecInfo.size() > 0) {
            for (MediaCodecInfo mediaCodecInfo : encoderCodecInfo) {
                MediaCodecInfo.AudioCapabilities audioCapabilities = mediaCodecInfo.getCapabilitiesForType(str).getAudioCapabilities();
                boolean contains = audioCapabilities.getBitrateRange().contains(Integer.valueOf(i2));
                boolean z2 = audioCapabilities.getMaxInputChannelCount() >= i3;
                Range<Integer>[] supportedSampleRateRanges = audioCapabilities.getSupportedSampleRateRanges();
                int length = supportedSampleRateRanges.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        z = false;
                        break;
                    } else if (supportedSampleRateRanges[i5].contains(Integer.valueOf(i4))) {
                        z = true;
                        break;
                    } else {
                        i5++;
                    }
                }
                if (contains && z2 && z) {
                    AppMethodBeat.o(218140);
                    return true;
                }
            }
        }
        AppMethodBeat.o(218140);
        return false;
    }

    public static void selectProfileAndLevel(MediaFormat mediaFormat) {
        int i2;
        int i3;
        int i4 = -1;
        AppMethodBeat.i(218141);
        MediaCodecInfo selectCodec = selectCodec("video/avc");
        if (selectCodec != null) {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = selectCodec.getCapabilitiesForType("video/avc");
            if (capabilitiesForType.profileLevels != null) {
                int i5 = 0;
                i3 = -1;
                while (true) {
                    i2 = i4;
                    if (i5 >= capabilitiesForType.profileLevels.length) {
                        break;
                    }
                    if (capabilitiesForType.profileLevels[i5].profile <= 8) {
                        if (capabilitiesForType.profileLevels[i5].profile > i2) {
                            i2 = capabilitiesForType.profileLevels[i5].profile;
                            i3 = capabilitiesForType.profileLevels[i5].level;
                        } else if (capabilitiesForType.profileLevels[i5].profile == i2 && capabilitiesForType.profileLevels[i5].level > i3) {
                            i3 = capabilitiesForType.profileLevels[i5].level;
                        }
                    }
                    i4 = i2;
                    i5++;
                }
            } else {
                i3 = -1;
                i2 = -1;
            }
            if (i2 == 8) {
                mediaFormat.setInteger(Scopes.PROFILE, i2);
                mediaFormat.setInteger("level", i3);
                Logger.i(TAG, String.format("selectProfileAndLevel: 0x%x, 0x%x", Integer.valueOf(i2), Integer.valueOf(i3)));
            }
        }
        AppMethodBeat.o(218141);
    }

    public static MediaCodecInfo selectCodec(String str) {
        String[] supportedTypes;
        AppMethodBeat.i(218142);
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        AppMethodBeat.o(218142);
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(218142);
        return null;
    }
}
