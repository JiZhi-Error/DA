package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class ah {
    public int DZU;
    public boolean DZV;
    public String DZW;
    public boolean DZX = false;
    public String DZY;
    public long DZZ = 0;
    public Map<String, String> Eaa = new HashMap();
    public String adExtInfo;
    public String aid;
    public int bizId;
    public String dRS;
    public String kZe;
    public String lAN;
    public int source;
    public String uin;
    public String uxInfo;
    public String viewId;

    public ah() {
        AppMethodBeat.i(96323);
        AppMethodBeat.o(96323);
    }

    public final String aPU(String str) {
        AppMethodBeat.i(96324);
        String str2 = this.Eaa.get(str);
        AppMethodBeat.o(96324);
        return str2;
    }

    public final String getSnsId() {
        if (this.dRS == null) {
            return "";
        }
        return this.dRS;
    }

    public final String getViewId() {
        AppMethodBeat.i(202830);
        if (Util.isNullOrNil(this.viewId)) {
            AppMethodBeat.o(202830);
            return "";
        }
        String str = this.viewId;
        AppMethodBeat.o(202830);
        return str;
    }

    public final String fcN() {
        AppMethodBeat.i(202831);
        if (Util.isNullOrNil(this.DZY)) {
            AppMethodBeat.o(202831);
            return "";
        }
        String str = this.DZY;
        AppMethodBeat.o(202831);
        return str;
    }
}
