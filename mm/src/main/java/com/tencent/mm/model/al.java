package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;

public final class al {
    public static void aVk() {
        AppMethodBeat.i(CdnLogic.kMediaTypeSmartHwPage);
        Cursor gCc = c.aSN().gCc();
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(gCc == null ? 0 : gCc.getCount());
        Log.i("MicroMsg.HardCodeUpdateTask", "[unstarAllBizContactFor50] size:%s", objArr);
        if (gCc.moveToFirst()) {
            do {
                as asVar = new as();
                asVar.convertFrom(gCc);
                asVar.arc();
                c.aSN().c(asVar.field_username, asVar);
            } while (gCc.moveToNext());
        }
        gCc.close();
        AppMethodBeat.o(CdnLogic.kMediaTypeSmartHwPage);
    }
}
