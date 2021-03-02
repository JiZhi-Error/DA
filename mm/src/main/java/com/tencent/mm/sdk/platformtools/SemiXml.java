package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class SemiXml {
    public static final String MAGIC_HEAD = "~SEMI_XML~";
    private static final String TAG = "MicroMsg.SemiXml";

    public static String encode(Map<String, String> map) {
        AppMethodBeat.i(157823);
        if (map == null) {
            AppMethodBeat.o(157823);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(MAGIC_HEAD);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null) {
                int length = key.length();
                int length2 = value.length();
                sb.append((char) (length >> 16)).append((char) length).append(key);
                sb.append((char) (length2 >> 16)).append((char) length2).append(value);
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(157823);
        return sb2;
    }

    public static Map<String, String> decode(String str) {
        AppMethodBeat.i(157824);
        if (str == null || !str.startsWith(MAGIC_HEAD)) {
            AppMethodBeat.o(157824);
            return null;
        }
        String substring = str.substring(10);
        HashMap hashMap = new HashMap();
        int length = substring.length() - 4;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            try {
                int i4 = i3 + 1;
                int charAt = (substring.charAt(i2) << 16) + substring.charAt(i3) + i4;
                String substring2 = substring.substring(i4, charAt);
                int i5 = charAt + 1;
                int i6 = i5 + 1;
                i2 = (substring.charAt(charAt) << 16) + substring.charAt(i5) + i6;
                hashMap.put(substring2, substring.substring(i6, i2));
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(157824);
        return hashMap;
    }
}
