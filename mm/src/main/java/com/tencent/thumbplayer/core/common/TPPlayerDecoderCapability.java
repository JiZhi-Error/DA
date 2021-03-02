package com.tencent.thumbplayer.core.common;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPCodecCapability;
import java.util.HashMap;

public class TPPlayerDecoderCapability {
    private static String TAG = "TPPlayerDecoderCapability";
    private long mNativeContext = 0;

    private static native boolean _addVCodecBlacklist(int i2, int i3, TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange);

    private static native boolean _addVCodecWhitelist(int i2, int i3, TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange);

    private static native HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> _getDecoderMaxCapabilityMap(int i2);

    private static native boolean _isVCodecCapabilitySupport(int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static synchronized void init(Context context, boolean z) {
        synchronized (TPPlayerDecoderCapability.class) {
            AppMethodBeat.i(189780);
            TPCodecUtils.init(context, z);
            AppMethodBeat.o(189780);
        }
    }

    public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int i2) {
        AppMethodBeat.i(189781);
        try {
            HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> _getDecoderMaxCapabilityMap = _getDecoderMaxCapabilityMap(i2);
            AppMethodBeat.o(189781);
            return _getDecoderMaxCapabilityMap;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189781);
            return null;
        }
    }

    public static boolean addVCodecBlacklist(int i2, int i3, TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange) {
        AppMethodBeat.i(189782);
        try {
            boolean _addVCodecBlacklist = _addVCodecBlacklist(i2, i3, tPVCodecPropertyRange);
            AppMethodBeat.o(189782);
            return _addVCodecBlacklist;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189782);
            return false;
        }
    }

    public static boolean addVCodecWhitelist(int i2, int i3, TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange) {
        AppMethodBeat.i(189783);
        try {
            boolean _addVCodecWhitelist = _addVCodecWhitelist(i2, i3, tPVCodecPropertyRange);
            AppMethodBeat.o(189783);
            return _addVCodecWhitelist;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189783);
            return false;
        }
    }

    public static boolean isVCodecCapabilitySupport(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AppMethodBeat.i(189784);
        if (102 == i2) {
            String str = "";
            switch (i3) {
                case 26:
                    str = "video/avc";
                    break;
                case 172:
                    str = TPDecoderType.TP_CODEC_MIMETYPE_HEVC;
                    break;
            }
            if (TPCodecUtils.isInMediaCodecWhiteList(str, i4, i5)) {
                AppMethodBeat.o(189784);
                return true;
            } else if (TPCodecUtils.isBlackListForHardwareDec(str)) {
                AppMethodBeat.o(189784);
                return false;
            }
        }
        try {
            boolean _isVCodecCapabilitySupport = _isVCodecCapabilitySupport(i2, i3, i4, i5, i6, i7, i8);
            AppMethodBeat.o(189784);
            return _isVCodecCapabilitySupport;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            AppMethodBeat.o(189784);
            return false;
        }
    }

    public static boolean isDolbyDSSupported() {
        AppMethodBeat.i(189785);
        boolean isHwDolbyDSSupported = TPCodecUtils.isHwDolbyDSSupported();
        AppMethodBeat.o(189785);
        return isHwDolbyDSSupported;
    }

    public static boolean isDDPlusSupported() {
        AppMethodBeat.i(189786);
        boolean isHwDDPlusSupported = TPCodecUtils.isHwDDPlusSupported();
        AppMethodBeat.o(189786);
        return isHwDDPlusSupported;
    }

    public static boolean isHDRsupport(int i2, int i3, int i4) {
        AppMethodBeat.i(189787);
        boolean isHDRsupport = TPCodecUtils.isHDRsupport(i2, i3, i4);
        AppMethodBeat.o(189787);
        return isHDRsupport;
    }

    public static boolean isBlackListForHdr10(String str) {
        AppMethodBeat.i(189788);
        boolean isBlackListForHdr10 = TPCodecUtils.isBlackListForHdr10(str);
        AppMethodBeat.o(189788);
        return isBlackListForHdr10;
    }

    public static boolean isBlackListForVidHdr10Enhance(String str, String str2) {
        AppMethodBeat.i(189789);
        boolean isBlackListForVidHdr10Enhance = TPCodecUtils.isBlackListForVidHdr10Enhance(str, str2);
        AppMethodBeat.o(189789);
        return isBlackListForVidHdr10Enhance;
    }

    public static boolean isWhiteListForHdr10(String str) {
        AppMethodBeat.i(189790);
        boolean isWhiteListForHdr10 = TPCodecUtils.isWhiteListForHdr10(str);
        AppMethodBeat.o(189790);
        return isWhiteListForHdr10;
    }

    public static boolean isBlackListForHdr10Enhance(String str) {
        AppMethodBeat.i(189791);
        boolean isBlackListForHdr10Enhance = TPCodecUtils.isBlackListForHdr10Enhance(str);
        AppMethodBeat.o(189791);
        return isBlackListForHdr10Enhance;
    }

    public static boolean isWhiteListForHdr10Enhance(String str) {
        AppMethodBeat.i(189792);
        boolean isWhiteListForHdr10Enhance = TPCodecUtils.isWhiteListForHdr10Enhance(str);
        AppMethodBeat.o(189792);
        return isWhiteListForHdr10Enhance;
    }

    public static boolean probeACodecMaxCapability() {
        return true;
    }

    public static boolean isACodecCapabilitySupport(int i2, int i3, int i4, int i5) {
        return true;
    }

    public static boolean addACodecBlacklist(int i2, int i3, TPCodecCapability.TPACodecCapability tPACodecCapability) {
        return true;
    }
}
