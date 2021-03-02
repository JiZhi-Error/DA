package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class h {
    public j Bro;

    public h(String str) {
        AppMethodBeat.i(122662);
        this.Bro = new j(str, 10);
        AppMethodBeat.o(122662);
    }

    public final i fe(String str, int i2) {
        AppMethodBeat.i(122663);
        byte[] readFromFile = j.readFromFile(this.Bro.Brx + ff(str, i2));
        if (readFromFile == null || readFromFile.length == 0) {
            AppMethodBeat.o(122663);
            return null;
        }
        try {
            i iVar = (i) new i().parseFrom(readFromFile);
            AppMethodBeat.o(122663);
            return iVar;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.DraftBoxMgr", e2, "", new Object[0]);
            AppMethodBeat.o(122663);
            return null;
        }
    }

    public static String ff(String str, int i2) {
        String str2;
        AppMethodBeat.i(122664);
        if (str == null || str.length() == 0) {
            str2 = new StringBuilder().append(g.aAh().azQ().get(9, (Object) null)).toString();
        } else {
            str2 = str + "_" + i2;
        }
        AppMethodBeat.o(122664);
        return str2;
    }
}
