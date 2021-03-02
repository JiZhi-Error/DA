package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ehp;
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class f {
    static ehp pzR;

    public static ehp cnr() {
        AppMethodBeat.i(6134);
        if (pzR != null) {
            ehp ehp = pzR;
            AppMethodBeat.o(6134);
            return ehp;
        }
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_BIZ_TIME_LINE_OFTEN_READ_STRING_SYNC, "");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(6134);
            return null;
        }
        ehp ehp2 = new ehp();
        try {
            ehp2.parseFrom(Base64.decode(str, 0));
            pzR = ehp2;
            AppMethodBeat.o(6134);
            return ehp2;
        } catch (IOException e2) {
            Log.e("MicroMsg.BizTimeLineOftenReadHelper", "getOftenRead exp: %s", e2.getMessage());
            AppMethodBeat.o(6134);
            return null;
        }
    }

    public static boolean cns() {
        AppMethodBeat.i(195021);
        ehp cnr = cnr();
        if (cnr == null || Util.isNullOrNil(cnr.Nhd)) {
            AppMethodBeat.o(195021);
            return true;
        }
        AppMethodBeat.o(195021);
        return false;
    }

    public static boolean ahR(String str) {
        AppMethodBeat.i(6135);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(6135);
            return false;
        }
        ehp cnr = cnr();
        if (cnr == null) {
            AppMethodBeat.o(6135);
            return false;
        }
        LinkedList<ehs> linkedList = cnr.Nhd;
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(6135);
            return false;
        }
        Iterator<ehs> it = linkedList.iterator();
        while (it.hasNext()) {
            ehs next = it.next();
            if (next != null && str.equals(next.KJV)) {
                AppMethodBeat.o(6135);
                return true;
            }
        }
        AppMethodBeat.o(6135);
        return false;
    }
}
