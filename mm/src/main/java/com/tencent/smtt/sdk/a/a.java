package com.tencent.smtt.sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class a {
    public static String a(long j2) {
        AppMethodBeat.i(188293);
        String format = String.format(Locale.getDefault(), "%d(%s)", Long.valueOf(j2), new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(j2)));
        AppMethodBeat.o(188293);
        return format;
    }
}
