package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class IniParser {
    public static Map<String, String> parse(String str) {
        String[] split;
        AppMethodBeat.i(157563);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(157563);
            return null;
        }
        HashMap hashMap = new HashMap();
        String[] split2 = str.split("\n");
        for (String str2 : split2) {
            if (str2 != null && str2.length() > 0 && (split = str2.trim().split("=", 2)) != null && split.length >= 2) {
                String str3 = split[0];
                String str4 = split[1];
                if (str3 != null && str3.length() > 0 && str3.matches("^[a-zA-Z0-9_.]*")) {
                    hashMap.put(str3, str4);
                }
            }
        }
        AppMethodBeat.o(157563);
        return hashMap;
    }
}
