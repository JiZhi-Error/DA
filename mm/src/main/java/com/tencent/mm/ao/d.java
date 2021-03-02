package com.tencent.mm.ao;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.as;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d extends as {
    @Override // com.tencent.mm.model.as
    public final void transfer(int i2) {
        AppMethodBeat.i(20479);
        Log.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", Integer.valueOf(i2));
        if (!rT(i2)) {
            Log.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
            AppMethodBeat.o(20479);
            return;
        }
        h.INSTANCE.dN(336, 10);
        long currentTimeMillis = System.currentTimeMillis();
        bg.aVF();
        if (Util.nullAsNil((Integer) c.azQ().get(86017, (Object) null)) == 3) {
            Log.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
            AppMethodBeat.o(20479);
            return;
        }
        bg.aVF();
        c.getDataDB().execSQL("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
        bg.aVF();
        Cursor d2 = c.aSN().d("@all.weixin.android", "", null);
        d2.moveToFirst();
        while (!d2.isAfterLast()) {
            com.tencent.mm.storage.as asVar = new com.tencent.mm.storage.as();
            asVar.convertFrom(d2);
            bg.aVF();
            c.aSN().e(asVar.field_username, asVar);
            d2.moveToNext();
        }
        d2.close();
        Log.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        bg.aVF();
        c.azQ().set(86017, (Object) 3);
        Log.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        AppMethodBeat.o(20479);
    }

    @Override // com.tencent.mm.model.as
    public final boolean rT(int i2) {
        return i2 != 0 && i2 < 604176383;
    }

    @Override // com.tencent.mm.model.as
    public final String getTag() {
        return "MicroMsg.VerifyFlagDataTransfer";
    }
}
