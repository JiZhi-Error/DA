package com.tencent.mm.plugin.festival.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;

public final class g {

    static class a {
        String[] UGG;
        String fuJ;
        String fuK;

        public a(String str, String str2, String str3) {
            AppMethodBeat.i(261979);
            this.UGG = new String[]{Util.nullAsNil(str), Util.nullAsNil(str2), Util.nullAsNil(str3)};
            AppMethodBeat.o(261979);
        }
    }

    public static String bH(String str, String str2, String str3) {
        AppMethodBeat.i(261980);
        a aVar = new a(str, str2, str3);
        if (aVar.UGG.length > 2) {
            if (RegionCodeDecoder.bkO(aVar.UGG[0])) {
                RegionCodeDecoder.gEm();
                aVar.fuJ = RegionCodeDecoder.mW(aVar.UGG[0], aVar.UGG[1]);
            } else {
                RegionCodeDecoder.gEm();
                aVar.fuJ = RegionCodeDecoder.bkP(aVar.UGG[0]);
            }
            RegionCodeDecoder.gEm();
            aVar.fuK = RegionCodeDecoder.bs(aVar.UGG[0], aVar.UGG[1], aVar.UGG[2]);
        } else if (aVar.UGG.length == 2) {
            RegionCodeDecoder.gEm();
            aVar.fuJ = RegionCodeDecoder.bkP(aVar.UGG[0]);
            RegionCodeDecoder.gEm();
            aVar.fuK = RegionCodeDecoder.mW(aVar.UGG[0], aVar.UGG[1]);
        } else {
            RegionCodeDecoder.gEm();
            aVar.fuJ = RegionCodeDecoder.bkP(aVar.UGG[0]);
            aVar.fuK = "";
        }
        if (!Util.isNullOrNil(aVar.fuJ)) {
            str2 = aVar.fuJ;
        }
        if (!Util.isNullOrNil(aVar.fuK)) {
            str3 = aVar.fuK;
        }
        String trim = org.apache.commons.b.g.a(new String[]{str2, str3}, " ").trim();
        AppMethodBeat.o(261980);
        return trim;
    }
}
