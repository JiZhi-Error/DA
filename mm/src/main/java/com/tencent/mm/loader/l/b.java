package com.tencent.mm.loader.l;

import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b {
    public static final String icT = (com.tencent.mm.loader.j.b.aKJ() + ".tmp");
    public static final String icU = (com.tencent.mm.loader.j.b.aKJ() + ".loader");
    public static long icV = 0;

    public static String aLN() {
        String str = icT + FilePathGenerator.ANDROID_DIR_SEP + new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        Log.d("MicroMsg.Loader.ImageTmpFilehUtils", "[cpan] get tmp file path:%s", str);
        o oVar = new o(icT);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        o oVar2 = new o(str);
        if (!oVar2.exists()) {
            oVar2.mkdirs();
        }
        return str;
    }
}
