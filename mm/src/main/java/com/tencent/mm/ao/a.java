package com.tencent.mm.ao;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.model.as;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class a extends as {
    @Override // com.tencent.mm.model.as
    public final boolean rT(int i2) {
        return i2 != 0 && i2 < 604372991;
    }

    @Override // com.tencent.mm.model.as
    public final String getTag() {
        return "MicroMsg.App.BizInfoDataTransfer";
    }

    @Override // com.tencent.mm.model.as
    public final void transfer(int i2) {
        AppMethodBeat.i(20475);
        Log.d("MicroMsg.App.BizInfoDataTransfer", "the previous version is %d", Integer.valueOf(i2));
        if (i2 != 0 && i2 < 604372991) {
            h.INSTANCE.dN(336, 12);
            bg.aVF();
            com.tencent.mm.storagebase.h dataDB = c.getDataDB();
            StringBuilder sb = new StringBuilder();
            sb.append("select BizInfo.username, BizInfo.extInfo");
            sb.append(" from rcontact , BizInfo");
            sb.append(" where rcontact.username = BizInfo.username");
            sb.append(" and (rcontact.type & 1 ) != 0 ");
            sb.append(" and ( rcontact.verifyFlag & 8 ) != 0 ");
            String sb2 = sb.toString();
            ArrayList<String> arrayList = new ArrayList();
            Log.d("MicroMsg.App.BizInfoDataTransfer", "sql %s", sb2);
            Cursor rawQuery = dataDB.rawQuery(sb.toString(), null, 2);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    com.tencent.mm.api.c cVar = new com.tencent.mm.api.c();
                    cVar.convertFrom(rawQuery);
                    if (cVar.cG(false).getServiceType() == 1) {
                        arrayList.add(cVar.field_username);
                    }
                }
                rawQuery.close();
            }
            if (arrayList.size() > 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Update BizInfo set type = 1 where 1 !=1 ");
                for (String str : arrayList) {
                    sb3.append(" or username = '").append(str).append("'");
                }
                String sb4 = sb3.toString();
                Log.d("MicroMsg.App.BizInfoDataTransfer", "update sql %s", sb4);
                ag.bah().execSQL("BizInfo", sb4);
            }
        }
        AppMethodBeat.o(20475);
    }
}
