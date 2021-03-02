package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;

public final class c {
    private static String TAG = "MicroMsg.BackupModelFactory";

    public static d BA(int i2) {
        AppMethodBeat.i(22163);
        switch (i2) {
            case -1:
                a cgZ = a.cgZ();
                AppMethodBeat.o(22163);
                return cgZ;
            case 0:
            default:
                AppMethodBeat.o(22163);
                return null;
            case 1:
                b cga = b.cga();
                AppMethodBeat.o(22163);
                return cga;
            case 2:
                com.tencent.mm.plugin.backup.d.b cfv = com.tencent.mm.plugin.backup.d.b.cfv();
                AppMethodBeat.o(22163);
                return cfv;
        }
    }
}
