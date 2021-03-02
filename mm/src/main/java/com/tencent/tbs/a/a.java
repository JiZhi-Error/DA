package com.tencent.tbs.a;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class a {
    private static final DateFormat RSf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);

    static {
        AppMethodBeat.i(174261);
        AppMethodBeat.o(174261);
    }

    public static String d(b bVar) {
        AppMethodBeat.i(174260);
        if (bVar == null) {
            AppMethodBeat.o(174260);
            return "";
        }
        String str = RSf.format(new Date(bVar.f2306a)) + " " + Process.myPid() + "-" + Process.myTid() + " " + c.a(bVar.RSg) + FilePathGenerator.ANDROID_DIR_SEP + bVar.f2307c + ": " + bVar.f2308d + "\n";
        AppMethodBeat.o(174260);
        return str;
    }
}
