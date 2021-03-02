package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class x {
    public static String x(String str, long j2) {
        String str2;
        AppMethodBeat.i(42772);
        String format = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(j2));
        if (str == null || str.length() <= 1) {
            str2 = format + "fffffff";
        } else {
            str2 = format + g.getMessageDigest(str.getBytes()).substring(0, 7);
        }
        String str3 = (str2 + String.format("%04x", Long.valueOf(j2 % 65535))) + ((j2 % 7) + 100);
        AppMethodBeat.o(42772);
        return str3;
    }
}
