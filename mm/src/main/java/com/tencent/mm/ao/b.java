package com.tencent.mm.ao;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.as;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends as {
    @Override // com.tencent.mm.model.as
    public final boolean rT(int i2) {
        return i2 != 0 && i2 < 637735215;
    }

    @Override // com.tencent.mm.model.as
    public final String getTag() {
        return "MicroMsg.App.BizPlaceTopDataTransfer";
    }

    @Override // com.tencent.mm.model.as
    public final void transfer(int i2) {
        AppMethodBeat.i(20476);
        Log.d("MicroMsg.App.BizPlaceTopDataTransfer", "the previous version is %d", Integer.valueOf(i2));
        if (rT(i2)) {
            Log.i("MicroMsg.App.BizPlaceTopDataTransfer", "begin biz place to top data transfer.");
            long currentTimeMillis = System.currentTimeMillis();
            h.INSTANCE.idkeyStat(336, 0, 1, true);
            bg.aVF();
            com.tencent.mm.storagebase.h dataDB = c.getDataDB();
            String str = "select conv.username" + " from " + "rconversation" + " as conv, " + "rcontact" + " as ct " + " where conv." + "parentRef" + "='" + "officialaccounts" + "' and conv." + ch.COL_USERNAME + " = ct." + ch.COL_USERNAME + " and ct." + "verifyFlag" + " & " + 8 + " = 0";
            Log.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer query sql(%s)", str);
            Cursor rawQuery = dataDB.rawQuery(str, null, 2);
            if (rawQuery == null) {
                Log.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor is null.");
                AppMethodBeat.o(20476);
                return;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, query cost : %s msec.", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
            StringBuilder sb = new StringBuilder();
            sb.append("update ");
            sb.append("rconversation");
            sb.append(" set ");
            sb.append("parentRef");
            sb.append("='' where ");
            sb.append(ch.COL_USERNAME);
            sb.append(" in (");
            if (rawQuery.moveToFirst()) {
                h.INSTANCE.idkeyStat(336, 1, 1, true);
                sb.append("'");
                sb.append(rawQuery.getString(0));
                sb.append("'");
                int i3 = 1;
                while (rawQuery.moveToNext()) {
                    sb.append(",");
                    sb.append("'");
                    sb.append(rawQuery.getString(0));
                    sb.append("'");
                    i3++;
                }
                sb.append(")");
                String sb2 = sb.toString();
                Log.i("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update count(%d)", Integer.valueOf(i3));
                Log.v("MicroMsg.App.BizPlaceTopDataTransfer", "transfer update sql(%s)", sb2);
                rawQuery.close();
                if (dataDB.execSQL("rconversation", sb.toString())) {
                    h.INSTANCE.idkeyStat(336, 2, 1, true);
                } else {
                    h.INSTANCE.idkeyStat(336, 3, 1, true);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                Log.i("MicroMsg.App.BizPlaceTopDataTransfer", "do biz place to top data transfer, update cost : %s msec,  total cost : %s msec.", Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis));
            } else {
                rawQuery.close();
                Log.i("MicroMsg.App.BizPlaceTopDataTransfer", "cursor count is 0.");
                AppMethodBeat.o(20476);
                return;
            }
        }
        AppMethodBeat.o(20476);
    }
}
