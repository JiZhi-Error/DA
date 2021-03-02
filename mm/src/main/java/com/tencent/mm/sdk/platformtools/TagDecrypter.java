package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.d;

public class TagDecrypter {
    private static final String TAG = "MicroMsg.TagDecrypter";
    private final d des;
    private LruCache<String, String> tagLruCache = new LruCache<>(256);

    public TagDecrypter(String str) {
        AppMethodBeat.i(157841);
        this.des = new d(str);
        AppMethodBeat.o(157841);
    }

    public String decryptTag(String str) {
        Exception e2;
        AppMethodBeat.i(157842);
        try {
            if (str.startsWith("!")) {
                if (this.tagLruCache.check(str)) {
                    String str2 = this.tagLruCache.get(str);
                    AppMethodBeat.o(157842);
                    return str2;
                }
                String substring = str.substring(1);
                try {
                    String[] split = substring.split("@");
                    if (split.length > 1) {
                        String str3 = split[0];
                        int intValue = Integer.valueOf(split[0]).intValue();
                        String substring2 = substring.substring(str3.length() + 1, str3.length() + 1 + intValue);
                        String str4 = this.des.fa(substring2) + substring.substring(intValue + str3.length() + 1);
                        this.tagLruCache.put(str, str4);
                        AppMethodBeat.o(157842);
                        return str4;
                    }
                    str = substring;
                } catch (Exception e3) {
                    e2 = e3;
                    str = substring;
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    str = "[td]".concat(String.valueOf(str));
                    AppMethodBeat.o(157842);
                    return str;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            str = "[td]".concat(String.valueOf(str));
            AppMethodBeat.o(157842);
            return str;
        }
        AppMethodBeat.o(157842);
        return str;
    }
}
