package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.Util;

public final class ad {
    private static String[] kLP = {ModulePkgInfo.MAIN_MODULE_NAME, ModulePkgInfo.MODULE_WITHOUT_PLUGIN_CODE, ModulePkgInfo.MODULE_WITHOUT_MULTI_PLUGIN_CODE, ModulePkgInfo.PLUGIN_CODE};
    private final String appId;
    private final String cBp;
    private volatile String kLO;

    public ad(String str, String str2) {
        AppMethodBeat.i(146000);
        this.appId = str;
        this.cBp = Ve(str2);
        AppMethodBeat.o(146000);
    }

    private static String Ve(String str) {
        AppMethodBeat.i(146001);
        if (Util.isNullOrNil(str) || a.contains(kLP, str)) {
            AppMethodBeat.o(146001);
            return str;
        }
        String We = n.We(str);
        AppMethodBeat.o(146001);
        return We;
    }

    public ad(String str, String str2, int i2) {
        AppMethodBeat.i(146002);
        switch (i2) {
            case 0:
                this.cBp = "";
                break;
            case 6:
                this.cBp = ModulePkgInfo.PLUGIN_CODE;
                break;
            case 12:
                this.cBp = ModulePkgInfo.MODULE_WITHOUT_PLUGIN_CODE;
                break;
            case 13:
                this.cBp = Ve(str2) + '$' + ModulePkgInfo.MODULE_WITHOUT_PLUGIN_CODE;
                break;
            case 22:
                this.cBp = ModulePkgInfo.MODULE_WITHOUT_MULTI_PLUGIN_CODE;
                break;
            case 23:
                this.cBp = Ve(str2) + '$' + ModulePkgInfo.MODULE_WITHOUT_MULTI_PLUGIN_CODE;
                break;
            default:
                this.cBp = Ve(str2);
                break;
        }
        this.appId = str;
        AppMethodBeat.o(146002);
    }

    public ad(String str) {
        this.appId = str;
        this.cBp = null;
    }

    public final String toString() {
        AppMethodBeat.i(146003);
        if (Util.isNullOrNil(this.kLO)) {
            this.kLO = this.appId + (Util.isNullOrNil(this.cBp) ? "" : "$" + this.cBp);
        }
        String str = this.kLO;
        AppMethodBeat.o(146003);
        return str;
    }
}
