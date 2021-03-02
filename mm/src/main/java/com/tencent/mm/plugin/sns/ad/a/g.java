package com.tencent.mm.plugin.sns.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g {
    public String DrY;
    public List<String> DrZ;
    public List<String> Dsa;
    public List<String> Dsb;
    public String finderLiveId;
    public String finderUsername;
    public int liveType;

    public static g B(Map<String, String> map, String str) {
        AppMethodBeat.i(201857);
        if (c.isEmpty(map)) {
            AppMethodBeat.o(201857);
            return null;
        }
        String str2 = map.get(str + ".liveType");
        if (str2 == null) {
            AppMethodBeat.o(201857);
            return null;
        }
        try {
            g gVar = new g();
            gVar.liveType = Util.safeParseInt(str2);
            gVar.DrY = Util.nullAsNil(map.get(str + ".liveParams"));
            gVar.finderUsername = Util.nullAsNil(map.get(str + ".finderUsername"));
            gVar.finderLiveId = Util.nullAsNil(map.get(str + ".finderLiveId"));
            gVar.DrZ = C(map, str + ".pendingDescList");
            gVar.Dsa = C(map, str + ".livingDescList");
            gVar.Dsb = C(map, str + ".endDescList");
            AppMethodBeat.o(201857);
            return gVar;
        } catch (Throwable th) {
            AppMethodBeat.o(201857);
            return null;
        }
    }

    private static List<String> C(Map<String, String> map, String str) {
        AppMethodBeat.i(201858);
        if (c.isEmpty(map)) {
            AppMethodBeat.o(201858);
            return null;
        }
        String str2 = map.get(str + ".descText");
        if (str2 == null) {
            AppMethodBeat.o(201858);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        int i2 = 1;
        while (true) {
            String str3 = map.get(str + ".descText" + i2);
            if (str3 != null) {
                arrayList.add(str3);
                i2++;
            } else {
                AppMethodBeat.o(201858);
                return arrayList;
            }
        }
    }
}
