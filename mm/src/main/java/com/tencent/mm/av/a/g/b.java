package com.tencent.mm.av.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b {
    public static final String icT = (com.tencent.mm.loader.j.b.aKJ() + ".tmp");
    public static long icV = 0;

    static {
        AppMethodBeat.i(130455);
        AppMethodBeat.o(130455);
    }

    public static String aLN() {
        AppMethodBeat.i(130449);
        String str = icT + FilePathGenerator.ANDROID_DIR_SEP + new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        Log.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", str);
        o oVar = new o(icT);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        AppMethodBeat.o(130449);
        return str;
    }

    public static boolean bdA() {
        AppMethodBeat.i(130450);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - icV > Util.MILLSECONDS_OF_DAY) {
            Log.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need clean tmp file.");
            icV = currentTimeMillis;
            AppMethodBeat.o(130450);
            return true;
        }
        Log.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] need not clean tmp file.");
        AppMethodBeat.o(130450);
        return false;
    }

    public static boolean bdB() {
        AppMethodBeat.i(130451);
        o oVar = new o(icT);
        try {
            if (oVar.exists() && !oVar.isFile()) {
                b(oVar, true);
            }
            AppMethodBeat.o(130451);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] clean tmp file path exception.");
            AppMethodBeat.o(130451);
            return false;
        }
    }

    private static boolean AD(long j2) {
        AppMethodBeat.i(130452);
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("MicroMsg.imageloader.ImageTmpFilehUtils", "[cpan] can delete current time:%d,listModified:%d", Long.valueOf(currentTimeMillis), Long.valueOf(j2));
        if (currentTimeMillis - j2 >= 259200000) {
            AppMethodBeat.o(130452);
            return true;
        }
        AppMethodBeat.o(130452);
        return false;
    }

    private static void l(o oVar) {
        AppMethodBeat.i(130453);
        if (oVar != null && oVar.isFile() && oVar.exists()) {
            oVar.delete();
        }
        AppMethodBeat.o(130453);
    }

    private static void b(o oVar, boolean z) {
        AppMethodBeat.i(130454);
        if (oVar != null && oVar.exists() && oVar.isDirectory()) {
            o[] het = oVar.het();
            if (het != null && het.length > 0) {
                for (o oVar2 : het) {
                    if (oVar2 != null && oVar2.exists()) {
                        if (oVar2.isFile()) {
                            l(oVar2);
                        } else if (AD(oVar2.lastModified()) && z) {
                            b(oVar2, false);
                        }
                    }
                }
            }
            oVar.delete();
        }
        AppMethodBeat.o(130454);
    }
}
