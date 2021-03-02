package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPCodecCapability;
import java.util.HashMap;

public class TPThumbplayerCapabilityHelper {
    public static synchronized void init(Context context, boolean z) {
        synchronized (TPThumbplayerCapabilityHelper.class) {
            AppMethodBeat.i(189847);
            TPPlayerDecoderCapability.init(context, z);
            AppMethodBeat.o(189847);
        }
    }

    @Deprecated
    public static boolean isVCodecCapabilitySupport(int i2, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(189848);
        boolean isVCodecCapabilitySupport = isVCodecCapabilitySupport(i2, i3, i4, i5, i6, i7, 30);
        AppMethodBeat.o(189848);
        return isVCodecCapabilitySupport;
    }

    public static boolean isVCodecCapabilitySupport(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AppMethodBeat.i(189849);
        boolean isVCodecCapabilitySupport = TPPlayerDecoderCapability.isVCodecCapabilitySupport(i2, i3, i4, i5, i6, i7, i8);
        AppMethodBeat.o(189849);
        return isVCodecCapabilitySupport;
    }

    @Deprecated
    public static boolean isVCodecCapabilityCanSupport(int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(189850);
        boolean isVCodecCapabilityCanSupport = isVCodecCapabilityCanSupport(i2, i3, i4, i5, i6, 30);
        AppMethodBeat.o(189850);
        return isVCodecCapabilityCanSupport;
    }

    public static boolean isVCodecCapabilityCanSupport(int i2, int i3, int i4, int i5, int i6, int i7) {
        boolean isVCodecCapabilitySupport;
        AppMethodBeat.i(189851);
        if (isVCodecCapabilitySupport(101, i2, i3, i4, i5, i6, i7)) {
            isVCodecCapabilitySupport = true;
        } else {
            isVCodecCapabilitySupport = isVCodecCapabilitySupport(102, i2, i3, i4, i5, i6, i7);
        }
        AppMethodBeat.o(189851);
        return isVCodecCapabilitySupport;
    }

    public static boolean addVCodecBlacklist(int i2, int i3, TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange) {
        AppMethodBeat.i(189852);
        boolean addVCodecBlacklist = TPPlayerDecoderCapability.addVCodecBlacklist(i2, i3, tPVCodecPropertyRange);
        AppMethodBeat.o(189852);
        return addVCodecBlacklist;
    }

    public static boolean addVCodecWhitelist(int i2, int i3, TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange) {
        AppMethodBeat.i(189853);
        boolean addVCodecWhitelist = TPPlayerDecoderCapability.addVCodecWhitelist(i2, i3, tPVCodecPropertyRange);
        AppMethodBeat.o(189853);
        return addVCodecWhitelist;
    }

    public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int i2) {
        AppMethodBeat.i(189854);
        HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> vCodecDecoderMaxCapabilityMap = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(i2);
        AppMethodBeat.o(189854);
        return vCodecDecoderMaxCapabilityMap;
    }

    public static TPCodecCapability.TPVCodecMaxCapability getVCodecMaxCapability(int i2) {
        AppMethodBeat.i(189855);
        TPCodecCapability.TPVCodecMaxCapability tPVCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
        HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> vCodecDecoderMaxCapabilityMap = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(102);
        HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> vCodecDecoderMaxCapabilityMap2 = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(101);
        if (vCodecDecoderMaxCapabilityMap == null || vCodecDecoderMaxCapabilityMap2 == null) {
            if (vCodecDecoderMaxCapabilityMap != null) {
                if (vCodecDecoderMaxCapabilityMap.containsKey(Integer.valueOf(i2))) {
                    tPVCodecMaxCapability = vCodecDecoderMaxCapabilityMap.get(Integer.valueOf(i2));
                }
            } else if (vCodecDecoderMaxCapabilityMap2 != null && vCodecDecoderMaxCapabilityMap2.containsKey(Integer.valueOf(i2))) {
                tPVCodecMaxCapability = vCodecDecoderMaxCapabilityMap2.get(Integer.valueOf(i2));
            }
        } else if (vCodecDecoderMaxCapabilityMap.containsKey(Integer.valueOf(i2)) && vCodecDecoderMaxCapabilityMap2.containsKey(Integer.valueOf(i2))) {
            tPVCodecMaxCapability = vCodecDecoderMaxCapabilityMap.get(Integer.valueOf(i2)).maxLumaSamples >= vCodecDecoderMaxCapabilityMap2.get(Integer.valueOf(i2)).maxLumaSamples ? vCodecDecoderMaxCapabilityMap.get(Integer.valueOf(i2)) : vCodecDecoderMaxCapabilityMap2.get(Integer.valueOf(i2));
        }
        AppMethodBeat.o(189855);
        return tPVCodecMaxCapability;
    }

    public static boolean isDDSupported() {
        AppMethodBeat.i(189856);
        boolean isDDPlusSupported = TPPlayerDecoderCapability.isDDPlusSupported();
        AppMethodBeat.o(189856);
        return isDDPlusSupported;
    }

    public static boolean isDDPlusSupported() {
        AppMethodBeat.i(189857);
        boolean isDDPlusSupported = TPPlayerDecoderCapability.isDDPlusSupported();
        AppMethodBeat.o(189857);
        return isDDPlusSupported;
    }

    public static boolean isDolbyDSSupported() {
        AppMethodBeat.i(189858);
        boolean isDolbyDSSupported = TPPlayerDecoderCapability.isDolbyDSSupported();
        AppMethodBeat.o(189858);
        return isDolbyDSSupported;
    }

    public static int[] getDRMCapabilities() {
        AppMethodBeat.i(189859);
        int[] dRMCapabilities = TPDrm.getDRMCapabilities();
        AppMethodBeat.o(189859);
        return dRMCapabilities;
    }

    public static boolean isDRMsupport(int i2) {
        boolean z = false;
        AppMethodBeat.i(189860);
        int[] dRMCapabilities = getDRMCapabilities();
        if (dRMCapabilities.length != 0) {
            int i3 = 0;
            while (true) {
                if (i3 >= dRMCapabilities.length) {
                    break;
                } else if (i2 == dRMCapabilities[i3]) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
        }
        AppMethodBeat.o(189860);
        return z;
    }

    public static boolean isHDRsupport(int i2, int i3, int i4) {
        AppMethodBeat.i(189861);
        boolean isHDRsupport = TPPlayerDecoderCapability.isHDRsupport(i2, i3, i4);
        AppMethodBeat.o(189861);
        return isHDRsupport;
    }

    public static boolean isSupportMediaCodecRotateInternal() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isSupportNativeMediaCodec() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isSupportSetOutputSurfaceApi() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
