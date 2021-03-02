package com.pay.network.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class APCommMethod {
    public static void transformStrToMpInfoList(String str, List<String> list, List<String> list2) {
        AppMethodBeat.i(193303);
        int indexOf = str.indexOf("[");
        int indexOf2 = str.indexOf("]");
        if (!(indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf)) {
            String substring = str.substring(indexOf + 1, indexOf2);
            if (substring.length() == 0) {
                list.clear();
                list2.clear();
                AppMethodBeat.o(193303);
                return;
            }
            String[] split = substring.split(",");
            int length = split.length;
            if (length > 0 && length % 2 == 0) {
                list.clear();
                list2.clear();
                for (int i2 = 0; i2 < length / 2; i2++) {
                    String str2 = split[i2 * 2];
                    String str3 = split[(i2 * 2) + 1];
                    list.add(str2);
                    list2.add(str3);
                }
            }
        }
        AppMethodBeat.o(193303);
    }

    public static void transformStrToList(String str, List<String> list) {
        AppMethodBeat.i(193304);
        int indexOf = str.indexOf("[");
        int indexOf2 = str.indexOf("]");
        list.clear();
        if (!(indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf)) {
            String substring = str.substring(indexOf + 1, indexOf2);
            if (substring.length() != 0) {
                String[] split = substring.split(",");
                for (String str2 : split) {
                    list.add(str2);
                }
            }
        }
        AppMethodBeat.o(193304);
    }
}
