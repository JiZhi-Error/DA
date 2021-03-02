package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public final class i {
    private static boolean sInitialized = false;
    private static final File ynq = new File(b.aKB(), "patch_ver_history.bin");
    private static int ynr = 0;
    private static int yns = 0;

    static {
        AppMethodBeat.i(117512);
        AppMethodBeat.o(117512);
    }

    private static int dZq() {
        AppMethodBeat.i(117509);
        int intValue = Integer.decode(a.CLIENT_VERSION).intValue();
        AppMethodBeat.o(117509);
        return intValue;
    }

    private static void gO(int i2, int i3) {
        DataOutputStream dataOutputStream;
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(117510);
        if (!ynq.exists()) {
            ynq.getParentFile().mkdirs();
        }
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(ynq)));
            try {
                dataOutputStream.writeInt(i2);
                dataOutputStream.writeInt(i3);
                dataOutputStream.flush();
                Util.qualityClose(dataOutputStream);
                AppMethodBeat.o(117510);
            } catch (Throwable th3) {
                th2 = th3;
                try {
                    Log.printErrStackTrace("MicroMsg.TinkerRollbackStatistic", th2, "[-] Fail to store base clientversion[%s] and patch clientversion[%s]", Integer.valueOf(i2), Integer.valueOf(i3));
                    Util.qualityClose(dataOutputStream);
                    AppMethodBeat.o(117510);
                } catch (Throwable th4) {
                    th = th4;
                    Util.qualityClose(dataOutputStream);
                    AppMethodBeat.o(117510);
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            dataOutputStream = null;
            Util.qualityClose(dataOutputStream);
            AppMethodBeat.o(117510);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void dZr() {
        /*
        // Method dump skipped, instructions count: 274
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.hp.tinker.i.dZr():void");
    }
}
