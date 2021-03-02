package com.tencent.mm.plugin.n;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public final class f {
    public static final String[] UYX = {"OMX.qcom.", "OMX.Exynos.", "OMX.hisi"};
    private static long zrm = 0;

    @TargetApi(21)
    public static boolean ejb() {
        AppMethodBeat.i(133903);
        try {
            if (d.oD(21)) {
                MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
                int length = codecInfos.length;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    String b2 = b(codecInfos[i2]);
                    if (!Util.isNullOrNil(b2)) {
                        arrayList.add(Integer.valueOf(i2));
                        arrayList2.add(b2);
                    }
                }
                if (arrayList.isEmpty()) {
                    AppMethodBeat.o(133903);
                    return false;
                }
                AppMethodBeat.o(133903);
                return true;
            }
            AppMethodBeat.o(133903);
            return false;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecUtil", e2, "isSupportHevc error", new Object[0]);
            AppMethodBeat.o(133903);
            return false;
        }
    }

    public static boolean aFg(String str) {
        AppMethodBeat.i(208740);
        try {
            MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
            int length = codecInfos.length;
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < length; i2++) {
                if (!Util.isNullOrNil(b(codecInfos[i2], str))) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            if (arrayList.isEmpty()) {
                AppMethodBeat.o(208740);
                return false;
            }
            AppMethodBeat.o(208740);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecUtil", e2, "isSupportHevc error", new Object[0]);
            AppMethodBeat.o(208740);
            return false;
        }
    }

    public static boolean ejc() {
        AppMethodBeat.i(133904);
        if (Util.milliSecondsToNow(zrm) > Util.MILLSECONDS_OF_DAY) {
            AppMethodBeat.o(133904);
            return true;
        }
        AppMethodBeat.o(133904);
        return false;
    }

    public static String ejd() {
        int i2;
        AppMethodBeat.i(133905);
        Log.d("MicroMsg.MediaCodecUtil", "check hevc info last rpt time[%d]", Long.valueOf(zrm));
        try {
            zrm = Util.nowMilliSecond();
            if (d.oD(21)) {
                long currentTicks = Util.currentTicks();
                MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
                int length = codecInfos.length;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < length; i3++) {
                    String b2 = b(codecInfos[i3]);
                    if (!Util.isNullOrNil(b2)) {
                        arrayList.add(Integer.valueOf(i3));
                        arrayList2.add(b2);
                    }
                }
                if (arrayList.isEmpty()) {
                    AppMethodBeat.o(133905);
                    return "";
                }
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                boolean z4 = false;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                int i11 = 0;
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                int i12 = 0;
                while (i12 < arrayList.size()) {
                    int intValue = ((Integer) arrayList.get(i12)).intValue();
                    String str = (String) arrayList2.get(i12);
                    z = codecInfos[intValue].isEncoder();
                    z2 = !codecInfos[intValue].isEncoder();
                    MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfos[intValue].getCapabilitiesForType(str);
                    if (capabilitiesForType != null) {
                        z3 = true;
                        MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                        if (videoCapabilities != null) {
                            i4 = Math.max(videoCapabilities.getBitrateRange().getLower().intValue(), i4);
                            i5 = Math.max(videoCapabilities.getBitrateRange().getUpper().intValue(), i5);
                            i6 = Math.max(videoCapabilities.getSupportedFrameRates().getLower().intValue(), i6);
                            i7 = Math.max(videoCapabilities.getSupportedFrameRates().getUpper().intValue(), i7);
                            i8 = Math.max(videoCapabilities.getSupportedWidths().getLower().intValue(), i8);
                            i9 = Math.max(videoCapabilities.getSupportedWidths().getUpper().intValue(), i9);
                            i10 = Math.max(videoCapabilities.getSupportedHeights().getLower().intValue(), i10);
                            i2 = Math.max(videoCapabilities.getSupportedHeights().getUpper().intValue(), i11);
                        } else {
                            i2 = i11;
                        }
                        sb.append(codecInfos[intValue].getName()).append("|");
                    } else {
                        z4 = true;
                        sb2.append(codecInfos[intValue].getName()).append("|");
                        i2 = i11;
                    }
                    i12++;
                    i11 = i2;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(1).append(",");
                if (z2 && z) {
                    sb3.append(3).append(",");
                } else if (z) {
                    sb3.append(2).append(",");
                } else {
                    sb3.append(1).append(",");
                }
                if (z3 && z4) {
                    sb3.append(3).append(",");
                } else if (z4) {
                    sb3.append(2).append(",");
                } else {
                    sb3.append(1).append(",");
                }
                sb3.append(sb.toString()).append(",");
                sb3.append(sb2.toString()).append(",");
                sb3.append(i4).append(",").append(i5).append(",");
                sb3.append(i6).append(",").append(i7).append(",");
                sb3.append(i8).append(",").append(i9).append(",");
                sb3.append(i10).append(",").append(i11);
                String sb4 = sb3.toString();
                Log.i("MicroMsg.MediaCodecUtil", "high api 21 cost[%d] hevc info %s", Long.valueOf(Util.ticksToNow(currentTicks)), sb4);
                AppMethodBeat.o(133905);
                return sb4;
            }
            String eje = eje();
            AppMethodBeat.o(133905);
            return eje;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecUtil", e2, "report hevc info error %s", e2.toString());
            AppMethodBeat.o(133905);
            return "";
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.MediaCodecUtil", th, "report hevc info error %s", th.toString());
            AppMethodBeat.o(133905);
            return "";
        }
    }

    private static String eje() {
        AppMethodBeat.i(133906);
        long currentTicks = Util.currentTicks();
        int codecCount = MediaCodecList.getCodecCount();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < codecCount; i2++) {
            String b2 = b(MediaCodecList.getCodecInfoAt(i2));
            if (!Util.isNullOrNil(b2)) {
                arrayList.add(Integer.valueOf(i2));
                arrayList2.add(b2);
            }
        }
        if (arrayList.isEmpty()) {
            AppMethodBeat.o(133906);
            return "";
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            int intValue = ((Integer) arrayList.get(i3)).intValue();
            String str = (String) arrayList2.get(i3);
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(intValue);
            z = codecInfoAt.isEncoder();
            z2 = !codecInfoAt.isEncoder();
            if (codecInfoAt.getCapabilitiesForType(str) != null) {
                z3 = true;
                sb.append(codecInfoAt.getName()).append("|");
            } else {
                z4 = true;
                sb2.append(codecInfoAt.getName()).append("|");
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(1).append(",");
        if (z2 && z) {
            sb3.append(3).append(",");
        } else if (z) {
            sb3.append(2).append(",");
        } else {
            sb3.append(1).append(",");
        }
        if (z3 && z4) {
            sb3.append(3).append(",");
        } else if (z4) {
            sb3.append(2).append(",");
        } else {
            sb3.append(1).append(",");
        }
        sb3.append(sb.toString()).append(",");
        sb3.append(sb2.toString());
        String sb4 = sb3.toString();
        Log.i("MicroMsg.MediaCodecUtil", "below api 21 cost[%d] hevc info %s", Long.valueOf(Util.ticksToNow(currentTicks)), sb4);
        AppMethodBeat.o(133906);
        return sb4;
    }

    private static String b(MediaCodecInfo mediaCodecInfo) {
        AppMethodBeat.i(133907);
        String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
        for (String str : supportedTypes) {
            if (!Util.isNullOrNil(str) && str.contains("hevc")) {
                AppMethodBeat.o(133907);
                return str;
            }
        }
        AppMethodBeat.o(133907);
        return "";
    }

    private static String b(MediaCodecInfo mediaCodecInfo, String str) {
        AppMethodBeat.i(208741);
        String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
        for (String str2 : supportedTypes) {
            if (!Util.isNullOrNil(str2) && str2.contains(str)) {
                AppMethodBeat.o(208741);
                return str2;
            }
        }
        AppMethodBeat.o(208741);
        return "";
    }

    @TargetApi(21)
    public static boolean hWm() {
        AppMethodBeat.i(263527);
        try {
            if (d.oD(21)) {
                MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
                int length = codecInfos.length;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    MediaCodecInfo mediaCodecInfo = codecInfos[i2];
                    if (mediaCodecInfo.isEncoder()) {
                        String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                        for (int i3 = 0; i3 < supportedTypes.length; i3++) {
                            if (!Util.isNullOrNil(supportedTypes[i3]) && supportedTypes[i3].contains("hevc")) {
                                String name = mediaCodecInfo.getName();
                                String[] strArr = UYX;
                                int length2 = strArr.length;
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= length2) {
                                        break;
                                    } else if (name.startsWith(strArr[i4])) {
                                        Log.i("MicroMsg.MediaCodecUtil", "steve : recognized H.265 HW encoder found:".concat(String.valueOf(name)));
                                        arrayList.add(Integer.valueOf(i2));
                                        arrayList2.add(supportedTypes[i3]);
                                        break;
                                    } else {
                                        i4++;
                                    }
                                }
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    AppMethodBeat.o(263527);
                    return false;
                }
                AppMethodBeat.o(263527);
                return true;
            }
            AppMethodBeat.o(263527);
            return false;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecUtil", e2, "isSupportHevcEnc error", new Object[0]);
            AppMethodBeat.o(263527);
            return false;
        }
    }
}
