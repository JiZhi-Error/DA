package com.tencent.mm.ao;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.as;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends as {
    @Override // com.tencent.mm.model.as
    public final String getTag() {
        return "MicroMsg.App.SyncTopConversation";
    }

    @Override // com.tencent.mm.model.as
    public final boolean rT(int i2) {
        return i2 != 0 && i2 < 620758015;
    }

    @Override // com.tencent.mm.model.as
    public final void transfer(int i2) {
        AppMethodBeat.i(20482);
        Log.d("MicroMsg.App.SyncTopConversation", "the previous version is %d", Integer.valueOf(i2));
        h.INSTANCE.dN(336, 15);
        bg.aVF();
        com.tencent.mm.storagebase.h dataDB = c.getDataDB();
        StringBuilder sb = new StringBuilder();
        sb.append("select username from rconversation");
        sb.append(" where flag & 4611686018427387904 != 0");
        Log.d("MicroMsg.App.SyncTopConversation", "sql:%s", sb);
        Cursor rawQuery = dataDB.rawQuery(sb.toString(), null, 2);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(0);
                Log.v("MicroMsg.App.SyncTopConversation", "userName %s", string);
                ab.E(string, false);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(20482);
    }
}
