package com.tencent.mm.plugin.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class c {
    public static String HF(long j2) {
        AppMethodBeat.i(201014);
        String format = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j2));
        AppMethodBeat.o(201014);
        return format;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040 A[SYNTHETIC, Splitter:B:23:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r8, java.nio.charset.Charset r9) {
        /*
        // Method dump skipped, instructions count: 103
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.performance.c.a(java.lang.String, java.nio.charset.Charset):java.lang.String");
    }

    public static void T(o oVar) {
        AppMethodBeat.i(201016);
        o oVar2 = new o(MMApplicationContext.getContext().getExternalCacheDir() + "/Diagnostic");
        o oVar3 = new o(oVar2, oVar.getName());
        Log.i("MicroMsg.performance.Utils", "DevEnv: copy [%s] to sdcard [%s]", aa.z(oVar.her()), aa.z(oVar3.her()));
        if (!oVar2.exists()) {
            oVar2.mkdirs();
        }
        s.nx(aa.z(oVar.her()), aa.z(oVar3.her()));
        AppMethodBeat.o(201016);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052 A[SYNTHETIC, Splitter:B:20:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Set<java.lang.String> eBB() {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.performance.c.eBB():java.util.Set");
    }
}
