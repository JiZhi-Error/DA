package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends a {
    private static String TAG = "MicroMsg.BackupStorageModel";
    private static d oQI;
    private b oQJ;
    private a oQK;

    public static d cgP() {
        AppMethodBeat.i(21763);
        if (oQI == null) {
            d dVar = new d();
            oQI = dVar;
            a(dVar);
        }
        d dVar2 = oQI;
        AppMethodBeat.o(21763);
        return dVar2;
    }

    @Override // com.tencent.mm.plugin.backup.b.a
    public final void ceH() {
        oQI = null;
    }

    public final b cgQ() {
        AppMethodBeat.i(21764);
        if (this.oQJ == null) {
            this.oQJ = new b();
        }
        b bVar = this.oQJ;
        AppMethodBeat.o(21764);
        return bVar;
    }

    public final a cgR() {
        AppMethodBeat.i(21765);
        if (this.oQK == null) {
            this.oQK = new a();
        }
        a aVar = this.oQK;
        AppMethodBeat.o(21765);
        return aVar;
    }

    public final void cgS() {
        AppMethodBeat.i(21766);
        Log.i(TAG, "backupInitStorage.");
        b cgQ = cgQ();
        bg.aVF();
        String accPath = c.getAccPath();
        bg.aVF();
        cgQ.cx(accPath, c.getUin());
        AppMethodBeat.o(21766);
    }
}
