package com.tencent.mm.bj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bn;

public final class c {
    public static long C(String str, long j2) {
        bn aEm;
        AppMethodBeat.i(20662);
        long j3 = 0;
        if (!(str == null || (aEm = d.bgM().aEm(str)) == null)) {
            j3 = aEm.field_createTime + 1;
        }
        if (j3 > j2 * 1000) {
            AppMethodBeat.o(20662);
            return j3;
        }
        long j4 = j2 * 1000;
        AppMethodBeat.o(20662);
        return j4;
    }

    public static void f(long j2, String str) {
        AppMethodBeat.i(20663);
        Log.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", Long.valueOf(j2), str);
        Log.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = ".concat(String.valueOf(d.bgN().x(j2, str))));
        Log.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = ".concat(String.valueOf(d.bgM().aEn(str))));
        AppMethodBeat.o(20663);
    }
}
