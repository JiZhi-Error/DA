package com.tencent.pb.common.c;

import java.util.Iterator;

public final class f {
    public static boolean isNullOrEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean nG(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    public static String a(Iterable<?> iterable, String str, String str2) {
        Iterator<?> it = iterable.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next().toString().replace(str, str2));
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static boolean equals(String str, String str2) {
        if (str == str2 || (str != null && str2 != null && str.equals(str2))) {
            return true;
        }
        return false;
    }

    public static boolean eP(String str) {
        return str == null || str.length() == 0;
    }

    public static String bpK(String str) {
        if (eP(str)) {
            return "";
        }
        return str;
    }
}
