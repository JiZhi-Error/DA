package com.tencent.mm.ao;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.as;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class c extends as {
    @Override // com.tencent.mm.model.as
    public final boolean rT(int i2) {
        return i2 != 0 && i2 < 620757033;
    }

    @Override // com.tencent.mm.model.as
    public final void transfer(int i2) {
        AppMethodBeat.i(20478);
        Log.d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "the previous version is %d", Integer.valueOf(i2));
        if (i2 != 0 && i2 < 620757033) {
            h.INSTANCE.dN(336, 13);
            LinkedList<String> linkedList = new LinkedList();
            bg.aVF();
            Cursor e2 = com.tencent.mm.model.c.aSN().e("@black.android", "", null);
            if (e2 != null) {
                e2.moveToFirst();
                while (!e2.isAfterLast()) {
                    com.tencent.mm.storage.as asVar = new com.tencent.mm.storage.as();
                    asVar.convertFrom(e2);
                    linkedList.add(asVar.field_username);
                    e2.moveToNext();
                }
                e2.close();
            }
            if (linkedList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Update rconversation");
                sb.append(" set parentRef = '@blacklist' where 1 != 1 ");
                for (String str : linkedList) {
                    sb.append(" or username = '").append(str).append("'");
                }
                String sb2 = sb.toString();
                Log.d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "update sql: %s", sb2);
                bg.aVF();
                com.tencent.mm.model.c.getDataDB().execSQL("rconversation", sb2);
            }
        }
        AppMethodBeat.o(20478);
    }

    @Override // com.tencent.mm.model.as
    public final String getTag() {
        return "MicroMsg.DataTransfer.BlackListConvDataTransfer";
    }
}
