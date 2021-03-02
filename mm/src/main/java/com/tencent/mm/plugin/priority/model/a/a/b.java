package com.tencent.mm.plugin.priority.model.a.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class b {
    public com.tencent.mm.plugin.priority.model.b AXQ;

    public b(com.tencent.mm.plugin.priority.model.b bVar) {
        AppMethodBeat.i(87820);
        this.AXQ = bVar;
        if (this.AXQ.ag(65, 0) != 7) {
            if (this.AXQ.ayi("C2CChatUsageResult")) {
                this.AXQ.aKd("C2CChatUsageResult");
            }
            this.AXQ.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, openrmf DOUBLE DEFAULT 0, staytimedev DOUBLE DEFAULT 0,sendmsgrmf DOUBLE DEFAULT 0, consumemsgrmf DOUBLE DEFAULT 0, totallsp DOUBLE DEFAULT 0, rank INTEGER DEFAULT -1, PRIMARY KEY(chat));", "C2CChatUsageResult"));
            this.AXQ.ah(65, 7);
            AppMethodBeat.o(87820);
            return;
        }
        Log.i("MicroMsg.Priority.C2CChatUsageResultStorage", "Exist Table %s Count %d", "C2CChatUsageResult", Integer.valueOf(this.AXQ.aKc("C2CChatUsageResult")));
        AppMethodBeat.o(87820);
    }

    public final List<Pair<String, String>> eCW() {
        AppMethodBeat.i(161936);
        Cursor rawQuery = this.AXQ.rawQuery(String.format("SELECT chat, openrmf, staytimedev, sendmsgrmf, consumemsgrmf, totallsp, rank FROM %s ORDER BY totallsp DESC;", "C2CChatUsageResult"), null);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            try {
                arrayList.add(new Pair(rawQuery.getString(0), String.format("open %.2f stay: %.2f send: %.2f consume: %.2f\ntotal: %.2f rank: %d", Double.valueOf(rawQuery.getDouble(1)), Double.valueOf(rawQuery.getDouble(2)), Double.valueOf(rawQuery.getDouble(3)), Double.valueOf(rawQuery.getDouble(4)), Double.valueOf(rawQuery.getDouble(5)), Integer.valueOf(rawQuery.getInt(6)))));
            } finally {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(161936);
            }
        }
        return arrayList;
    }

    public final xi aKg(String str) {
        AppMethodBeat.i(161937);
        String format = String.format("SELECT * FROM %s WHERE chat = ?", "C2CChatUsageResult");
        Cursor rawQuery = this.AXQ.rawQuery(format, new String[]{str});
        try {
            if (rawQuery.moveToNext()) {
                xi xiVar = new xi();
                xiVar.LiG = rawQuery.getString(0);
                xiVar.LiH = rawQuery.getDouble(1);
                xiVar.LiI = rawQuery.getDouble(2);
                xiVar.LiJ = rawQuery.getDouble(3);
                xiVar.LiK = rawQuery.getDouble(4);
                xiVar.LiL = rawQuery.getDouble(5);
                xiVar.xNc = rawQuery.getInt(6);
                return xiVar;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.o(161937);
            return null;
        } finally {
            if (rawQuery != null) {
                rawQuery.close();
            }
            AppMethodBeat.o(161937);
        }
    }
}
