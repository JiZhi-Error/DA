package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class d {
    public static void a(Map<String, String> map, ano ano) {
        AppMethodBeat.i(103501);
        if (map == null || ano == null) {
            Log.w("MicroMsg.FavTagParser", "maps is null or item is null");
            AppMethodBeat.o(103501);
            return;
        }
        ano.Lyo.clear();
        int i2 = 0;
        while (i2 < 1024) {
            String str = map.get(".favitem.taglist.tag" + (i2 > 0 ? Integer.valueOf(i2) : ""));
            if (str == null) {
                break;
            }
            ano.Lyo.add(str);
            i2++;
        }
        if (!ano.Lyo.isEmpty()) {
            Log.d("MicroMsg.FavTagParser", "user def tag not empty, res=%s", ano.Lyo);
        }
        ano.Lyn.clear();
        int i3 = 0;
        while (i3 < 1024) {
            String str2 = map.get(".favitem.recommendtaglist.tag" + (i3 > 0 ? Integer.valueOf(i3) : ""));
            if (str2 == null) {
                break;
            }
            ano.Lyn.add(str2);
            i3++;
        }
        if (!ano.Lyn.isEmpty()) {
            Log.d("MicroMsg.FavTagParser", "recommended tag not empty, res=%s", ano.Lyn);
        }
        AppMethodBeat.o(103501);
    }

    public static String a(ano ano) {
        AppMethodBeat.i(103502);
        if (ano == null || (ano.Lyo.isEmpty() && ano.Lyn.isEmpty())) {
            Log.v("MicroMsg.FavTagParser", "tag list toXml data list empty");
            AppMethodBeat.o(103502);
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int size = ano.Lyo.size();
        stringBuffer.append("<taglist count='").append(size).append("'>");
        for (int i2 = 0; i2 < size; i2++) {
            stringBuffer.append("<tag>").append(Util.escapeStringForXml(ano.Lyo.get(i2))).append("</tag>");
        }
        stringBuffer.append("</taglist>");
        int size2 = ano.Lyn.size();
        stringBuffer.append("<recommendtaglist count='").append(size2).append("'>");
        for (int i3 = 0; i3 < size2; i3++) {
            stringBuffer.append("<tag>").append(Util.escapeStringForXml(ano.Lyn.get(i3))).append("</tag>");
        }
        stringBuffer.append("</recommendtaglist>");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(103502);
        return stringBuffer2;
    }
}
