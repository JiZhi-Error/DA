package com.tencent.thumbplayer.api.capability;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.b.a;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.common.TPCodecCapability;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.utils.d;
import java.util.HashMap;

public class TPCapability {
    public static boolean addVCodecBlacklist(int i2, int i3, TPVCodecCapabilityForSet tPVCodecCapabilityForSet) {
        AppMethodBeat.i(189062);
        TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange = new TPCodecCapability.TPVCodecPropertyRange();
        tPVCodecPropertyRange.set(tPVCodecCapabilityForSet.getUpperboundWidth(), tPVCodecCapabilityForSet.getUpperboundHeight(), tPVCodecCapabilityForSet.getLowerboundWidth(), tPVCodecCapabilityForSet.getLowerboundHeight(), tPVCodecCapabilityForSet.getProfile(), tPVCodecCapabilityForSet.getLevel());
        boolean addVCodecBlacklist = TPThumbplayerCapabilityHelper.addVCodecBlacklist(d.arC(i2), d.arD(i3), tPVCodecPropertyRange);
        AppMethodBeat.o(189062);
        return addVCodecBlacklist;
    }

    public static boolean addVCodecWhitelist(int i2, int i3, TPVCodecCapabilityForSet tPVCodecCapabilityForSet) {
        AppMethodBeat.i(189063);
        TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange = new TPCodecCapability.TPVCodecPropertyRange();
        tPVCodecPropertyRange.set(tPVCodecCapabilityForSet.getUpperboundWidth(), tPVCodecCapabilityForSet.getUpperboundHeight(), tPVCodecCapabilityForSet.getLowerboundWidth(), tPVCodecCapabilityForSet.getLowerboundHeight(), tPVCodecCapabilityForSet.getProfile(), tPVCodecCapabilityForSet.getLevel());
        boolean addVCodecWhitelist = TPThumbplayerCapabilityHelper.addVCodecWhitelist(d.arC(i2), d.arD(i3), tPVCodecPropertyRange);
        AppMethodBeat.o(189063);
        return addVCodecWhitelist;
    }

    public static TPVCodecCapabilityForGet getThumbPlayerVCodecMaxCapability(int i2) {
        AppMethodBeat.i(189064);
        if (!TPPlayerMgr.isThumbPlayerEnable()) {
            TPVCodecCapabilityForGet tPVCodecCapabilityForGet = new TPVCodecCapabilityForGet(0, 0, 0, 30);
            AppMethodBeat.o(189064);
            return tPVCodecCapabilityForGet;
        }
        TPCodecCapability.TPVCodecMaxCapability vCodecMaxCapability = TPThumbplayerCapabilityHelper.getVCodecMaxCapability(d.arD(i2));
        if (vCodecMaxCapability == null) {
            TPVCodecCapabilityForGet tPVCodecCapabilityForGet2 = new TPVCodecCapabilityForGet(0, 0, 0, 30);
            AppMethodBeat.o(189064);
            return tPVCodecCapabilityForGet2;
        }
        TPVCodecCapabilityForGet tPVCodecCapabilityForGet3 = new TPVCodecCapabilityForGet(vCodecMaxCapability.maxLumaSamples, vCodecMaxCapability.maxProfile, vCodecMaxCapability.maxLevel, vCodecMaxCapability.maxFramerateFormaxLumaSamples);
        AppMethodBeat.o(189064);
        return tPVCodecCapabilityForGet3;
    }

    public static TPVCodecCapabilityForGet getThumbPlayerVCodecTypeMaxCapability(int i2, int i3) {
        AppMethodBeat.i(189065);
        if (!TPNativeLibraryLoader.isLibLoaded()) {
            TPVCodecCapabilityForGet tPVCodecCapabilityForGet = new TPVCodecCapabilityForGet(0, 0, 0, 30);
            AppMethodBeat.o(189065);
            return tPVCodecCapabilityForGet;
        }
        if (101 == i3) {
            i3 = 101;
        } else if (102 == i3) {
            i3 = 102;
        }
        HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> vCodecDecoderMaxCapabilityMap = TPThumbplayerCapabilityHelper.getVCodecDecoderMaxCapabilityMap(i3);
        if (vCodecDecoderMaxCapabilityMap == null || vCodecDecoderMaxCapabilityMap.isEmpty() || vCodecDecoderMaxCapabilityMap.get(Integer.valueOf(d.arD(i2))) == null) {
            TPVCodecCapabilityForGet tPVCodecCapabilityForGet2 = new TPVCodecCapabilityForGet(0, 0, 0, 30);
            AppMethodBeat.o(189065);
            return tPVCodecCapabilityForGet2;
        }
        TPVCodecCapabilityForGet tPVCodecCapabilityForGet3 = new TPVCodecCapabilityForGet(vCodecDecoderMaxCapabilityMap.get(Integer.valueOf(d.arD(i2))).maxLumaSamples, vCodecDecoderMaxCapabilityMap.get(Integer.valueOf(d.arD(i2))).maxProfile, vCodecDecoderMaxCapabilityMap.get(Integer.valueOf(d.arD(i2))).maxLevel, vCodecDecoderMaxCapabilityMap.get(Integer.valueOf(d.arD(i2))).maxFramerateFormaxLumaSamples);
        AppMethodBeat.o(189065);
        return tPVCodecCapabilityForGet3;
    }

    public static boolean isDDSupported() {
        AppMethodBeat.i(189066);
        if (!TPPlayerMgr.isThumbPlayerEnable()) {
            AppMethodBeat.o(189066);
            return false;
        }
        boolean isDDSupported = TPThumbplayerCapabilityHelper.isDDSupported();
        AppMethodBeat.o(189066);
        return isDDSupported;
    }

    public static boolean isDDPlusSupported() {
        AppMethodBeat.i(189067);
        if (!TPPlayerMgr.isThumbPlayerEnable()) {
            AppMethodBeat.o(189067);
            return false;
        }
        boolean isDDPlusSupported = TPThumbplayerCapabilityHelper.isDDPlusSupported();
        AppMethodBeat.o(189067);
        return isDDPlusSupported;
    }

    public static boolean isDolbyDSSupported() {
        AppMethodBeat.i(189068);
        if (!TPPlayerMgr.isThumbPlayerEnable()) {
            AppMethodBeat.o(189068);
            return false;
        }
        boolean isDolbyDSSupported = TPThumbplayerCapabilityHelper.isDolbyDSSupported();
        AppMethodBeat.o(189068);
        return isDolbyDSSupported;
    }

    public static boolean isDolbyVisionSupported() {
        return false;
    }

    public static int[] getDRMCapabilities() {
        AppMethodBeat.i(189069);
        int[] dRMCapabilities = a.getDRMCapabilities();
        AppMethodBeat.o(189069);
        return dRMCapabilities;
    }

    public static boolean isDRMsupport(int i2) {
        AppMethodBeat.i(189070);
        boolean aqY = a.aqY(i2);
        AppMethodBeat.o(189070);
        return aqY;
    }

    public static boolean isHDRsupport(int i2, int i3, int i4) {
        AppMethodBeat.i(189071);
        if (!TPPlayerMgr.isThumbPlayerEnable()) {
            AppMethodBeat.o(189071);
            return false;
        }
        if (i2 == 0) {
            i2 = 0;
        } else if (1 == i2) {
            i2 = 1;
        } else if (2 == i2) {
            i2 = 2;
        } else if (3 == i2) {
            i2 = 3;
        }
        boolean isHDRsupport = TPThumbplayerCapabilityHelper.isHDRsupport(i2, i3, i4);
        AppMethodBeat.o(189071);
        return isHDRsupport;
    }

    public static boolean isVCodecCapabilityCanSupport(int i2, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(189072);
        if (!TPPlayerMgr.isThumbPlayerEnable()) {
            AppMethodBeat.o(189072);
            return false;
        }
        boolean isVCodecCapabilityCanSupport = TPThumbplayerCapabilityHelper.isVCodecCapabilityCanSupport(i2, i3, i4, 0, 0, i7);
        AppMethodBeat.o(189072);
        return isVCodecCapabilityCanSupport;
    }
}
