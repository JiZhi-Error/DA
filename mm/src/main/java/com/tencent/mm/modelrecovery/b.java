package com.tencent.mm.modelrecovery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.recovery.log.RecoveryFileLog;
import com.tencent.rtmp.sharp.jni.QLog;
import java.io.IOException;

public final class b {
    public static void bex() {
        AppMethodBeat.i(20588);
        o oVar = new o(MMApplicationContext.getContext().getFilesDir(), "/recovery/recovery.log");
        String str = null;
        if (oVar.exists() && oVar.length() > 0) {
            try {
                str = s.boY(aa.z(oVar.her()));
                oVar.delete();
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.Recovery.RecoveryLogUtil", e2, "recoveryLog", new Object[0]);
            }
        }
        if (!Util.isNullOrNil(str)) {
            String[] split = str.split(RecoveryFileLog.LINE_SPLITTER);
            for (String str2 : split) {
                String[] split2 = str2.split(RecoveryFileLog.SPLITTER);
                if (split2 == null || split2.length != 3) {
                    Log.i("MicroMsg.Recovery.RecoveryLogUtil", str2);
                } else {
                    String str3 = split2[0];
                    char c2 = 65535;
                    switch (str3.hashCode()) {
                        case 69:
                            if (str3.equals(QLog.TAG_REPORTLEVEL_USER)) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            Log.e(split2[1], split2[2]);
                            continue;
                        default:
                            Log.i(split2[1], split2[2]);
                            continue;
                    }
                }
            }
            AppMethodBeat.o(20588);
            return;
        }
        Log.i("MicroMsg.Recovery.RecoveryLogUtil", "not found recovery log");
        AppMethodBeat.o(20588);
    }
}
