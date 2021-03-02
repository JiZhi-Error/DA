package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatBrands;

public class WeChatSomeFeatureSwitch {
    public static boolean temporaryBlockMinorLanguage() {
        AppMethodBeat.i(200978);
        if (!WeChatBrands.AppInfo.current().isMainland()) {
            AppMethodBeat.o(200978);
            return true;
        }
        AppMethodBeat.o(200978);
        return false;
    }

    public static boolean blockCNMobile() {
        AppMethodBeat.i(200979);
        if (!WeChatBrands.AppInfo.current().isMainland()) {
            AppMethodBeat.o(200979);
            return true;
        }
        AppMethodBeat.o(200979);
        return false;
    }

    public static boolean onlyUSMobile() {
        AppMethodBeat.i(200980);
        boolean isUS = WeChatBrands.AppInfo.current().isUS();
        AppMethodBeat.o(200980);
        return isUS;
    }

    public static boolean blockFTSUpdate() {
        AppMethodBeat.i(200981);
        if (!WeChatBrands.AppInfo.current().isMainland()) {
            AppMethodBeat.o(200981);
            return true;
        }
        AppMethodBeat.o(200981);
        return false;
    }

    public static boolean blockWeixinUrl() {
        AppMethodBeat.i(200982);
        if (!WeChatBrands.AppInfo.current().isMainland()) {
            AppMethodBeat.o(200982);
            return true;
        }
        AppMethodBeat.o(200982);
        return false;
    }

    public static boolean hardcodeWeChatUSTeam() {
        AppMethodBeat.i(200983);
        boolean isUS = WeChatBrands.AppInfo.current().isUS();
        AppMethodBeat.o(200983);
        return isUS;
    }

    public static boolean forceGooglePlayChannel() {
        AppMethodBeat.i(200984);
        if (!WeChatBrands.AppInfo.current().isMainland()) {
            AppMethodBeat.o(200984);
            return true;
        }
        AppMethodBeat.o(200984);
        return false;
    }

    public static boolean blockBizEetnryRemoteConfigs() {
        return true;
    }
}
