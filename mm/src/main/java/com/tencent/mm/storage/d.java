package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class d extends MAutoStorage<c> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "ABTestItem")};
    private final ISQLiteDatabase db;

    static {
        AppMethodBeat.i(153166);
        AppMethodBeat.o(153166);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "ABTestItem", null);
        this.db = iSQLiteDatabase;
    }

    public final c Fu(String str) {
        AppMethodBeat.i(153161);
        c cVar = new c();
        cVar.field_layerId = str;
        boolean z = super.get(cVar, new String[0]);
        if (z && cVar.field_endTime == 0) {
            cVar.field_endTime = MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        Log.i("MicroMsg.ABTestStorage", "getByLayerId, id: %s, return: %b", str, Boolean.valueOf(z));
        AppMethodBeat.o(153161);
        return cVar;
    }

    public final void H(List<c> list, int i2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(153163);
        boolean z3 = false;
        long nowSecond = Util.nowSecond();
        this.db.delete("ABTestItem", String.format(Locale.US, "%s<>0 and %s<%d", "endTime", "endTime", Long.valueOf(nowSecond)), null);
        if (i2 == 0) {
            c cVar = new c();
            cVar.field_prioritylevel = 1;
            delete(cVar, false, "prioritylevel");
        }
        for (c cVar2 : list) {
            if (cVar2 == null || Util.isNullOrNil(cVar2.field_layerId)) {
                Log.e("MicroMsg.ABTestStorage", "saveIfNecessary, Invalid item");
                z = false;
            } else {
                c cVar3 = new c();
                cVar3.field_layerId = cVar2.field_layerId;
                if (!super.get(cVar3, new String[0])) {
                    boolean insertNotify = super.insertNotify(cVar2, false);
                    Log.i("MicroMsg.ABTestStorage", "Inserted: %s, Result: %b", cVar2.field_layerId, Boolean.valueOf(insertNotify));
                    z = insertNotify;
                } else if ((cVar2.field_sequence <= cVar3.field_sequence || cVar2.field_prioritylevel != cVar3.field_prioritylevel) && cVar2.field_prioritylevel <= cVar3.field_prioritylevel) {
                    Log.i("MicroMsg.ABTestStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", cVar2.field_layerId, Long.valueOf(cVar3.field_sequence), Long.valueOf(cVar2.field_sequence), Integer.valueOf(cVar3.field_prioritylevel), Integer.valueOf(cVar2.field_prioritylevel));
                    z = false;
                } else {
                    boolean updateNotify = super.updateNotify(cVar2, false, new String[0]);
                    Log.i("MicroMsg.ABTestStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", cVar2.field_layerId, Boolean.valueOf(updateNotify), Long.valueOf(cVar3.field_sequence), Long.valueOf(cVar2.field_sequence), Integer.valueOf(cVar3.field_prioritylevel), Integer.valueOf(cVar2.field_prioritylevel));
                    z = updateNotify;
                }
            }
            if (z) {
                z2 = true;
            } else {
                z2 = z3;
            }
            z3 = z2;
        }
        if (z3) {
            doNotify("event_updated");
        }
        AppMethodBeat.o(153163);
    }

    public final String gzy() {
        AppMethodBeat.i(153164);
        Cursor all = getAll();
        if (all == null) {
            AppMethodBeat.o(153164);
            return "null cursor!!";
        } else if (!all.moveToFirst()) {
            all.close();
            AppMethodBeat.o(153164);
            return "cursor empty!!";
        } else {
            StringBuilder sb = new StringBuilder();
            c cVar = new c();
            do {
                sb.append("============\n");
                cVar.convertFrom(all);
                sb.append("layerId = ").append(cVar.field_layerId).append("\n");
                sb.append("sequence = ").append(cVar.field_sequence).append("\n");
                sb.append("priorityLV = ").append(cVar.field_prioritylevel).append("\n");
                sb.append("expId = ").append(cVar.field_expId).append("\n");
            } while (all.moveToNext());
            all.close();
            String sb2 = sb.toString();
            AppMethodBeat.o(153164);
            return sb2;
        }
    }

    public final LinkedList<akc> gzx() {
        AppMethodBeat.i(153165);
        LinkedList<akc> linkedList = new LinkedList<>();
        Cursor all = getAll();
        if (all == null || !all.moveToFirst()) {
            AppMethodBeat.o(153165);
        } else {
            c cVar = new c();
            do {
                cVar.convertFrom(all);
                akc akc = new akc();
                try {
                    akc.Lqu = Util.getInt(cVar.field_expId, 0);
                } catch (Exception e2) {
                    Log.e("MicroMsg.ABTestStorage", "expId parse failed, %s", cVar.field_expId);
                }
                akc.priority = cVar.field_prioritylevel;
                linkedList.add(akc);
            } while (all.moveToNext());
            all.close();
            AppMethodBeat.o(153165);
        }
        return linkedList;
    }

    public final Map<String, c> biC(String str) {
        Cursor rawQuery;
        AppMethodBeat.i(153162);
        if (Util.isNullOrNil(str)) {
            rawQuery = null;
        } else {
            rawQuery = rawQuery(String.format("select * from %s where %s = %s", "ABTestItem", "business", str), new String[0]);
        }
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            HashMap hashMap = new HashMap(0);
            AppMethodBeat.o(153162);
            return hashMap;
        }
        HashMap hashMap2 = new HashMap();
        do {
            c cVar = new c();
            cVar.convertFrom(rawQuery);
            hashMap2.put(cVar.field_layerId, cVar);
        } while (rawQuery.moveToNext());
        rawQuery.close();
        AppMethodBeat.o(153162);
        return hashMap2;
    }
}
