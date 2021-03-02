package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class c {
    public static String it(String str, String str2) {
        AppMethodBeat.i(26129);
        Log.d("MicroMsg.Label.LabelUtils", "original:%s,waitToAddLabel:%s", str, str2);
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(26129);
            return str;
        } else if (Util.isNullOrNil(str)) {
            String str3 = str2 + "\u0000";
            AppMethodBeat.o(26129);
            return str3;
        } else {
            if (str.endsWith("\u0000")) {
                str = str.replace("\u0000", "");
            }
            if (Util.stringsToList(str.split(",")).contains(str2)) {
                String str4 = str + "\u0000";
                AppMethodBeat.o(26129);
                return str4;
            }
            String str5 = str + "," + str2 + "\u0000";
            AppMethodBeat.o(26129);
            return str5;
        }
    }

    public static String iu(String str, String str2) {
        AppMethodBeat.i(26130);
        Log.d("MicroMsg.Label.LabelUtils", "original:%s,waitToDelLabel:%s", str, str2);
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(26130);
            return str;
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(26130);
            return "";
        } else {
            if (str.endsWith("\u0000")) {
                str = str.replace("\u0000", "");
            }
            ArrayList<String> stringsToList = Util.stringsToList(str.split(","));
            if (stringsToList.contains(str2)) {
                stringsToList.remove(str2);
                String fj = fj(stringsToList);
                AppMethodBeat.o(26130);
                return fj;
            }
            AppMethodBeat.o(26130);
            return str;
        }
    }

    public static String fj(List<String> list) {
        AppMethodBeat.i(26131);
        StringBuilder sb = new StringBuilder();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(list.get(i2));
                if (i2 < size - 1) {
                    sb.append(",");
                }
            }
            sb.append("\u0000");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(26131);
        return sb2;
    }
}
