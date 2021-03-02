package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class b extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "ABTestInfo")};
    private ISQLiteDatabase db;

    static {
        AppMethodBeat.i(153157);
        AppMethodBeat.o(153157);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "ABTestInfo", null);
        this.db = iSQLiteDatabase;
    }

    public final void H(List<a> list, int i2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(153151);
        boolean z3 = false;
        long nowSecond = Util.nowSecond();
        this.db.delete("ABTestInfo", String.format(Locale.US, "%s<>0 and %s<%d", "endTime", "endTime", Long.valueOf(nowSecond)), null);
        if (1 == i2) {
            a aVar = new a();
            aVar.field_prioritylevel = 1;
            delete(aVar, false, "prioritylevel");
        }
        for (a aVar2 : list) {
            if (aVar2 == null || Util.isNullOrNil(aVar2.field_abtestkey)) {
                Log.e("MicroMsg.ABTestInfoStorage", "saveIfNecessary, Invalid item");
                z = false;
            } else {
                a aVar3 = new a();
                aVar3.field_abtestkey = aVar2.field_abtestkey;
                if (!super.get(aVar3, new String[0])) {
                    boolean insertNotify = super.insertNotify(aVar2, false);
                    Log.i("MicroMsg.ABTestInfoStorage", "Inserted: %s, Result: %b", aVar2.field_abtestkey, Boolean.valueOf(insertNotify));
                    z = insertNotify;
                } else if ((aVar2.field_sequence <= aVar3.field_sequence || aVar2.field_prioritylevel != aVar3.field_prioritylevel) && aVar2.field_prioritylevel <= aVar3.field_prioritylevel) {
                    Log.i("MicroMsg.ABTestInfoStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", aVar2.field_abtestkey, Long.valueOf(aVar3.field_sequence), Long.valueOf(aVar2.field_sequence), Integer.valueOf(aVar3.field_prioritylevel), Integer.valueOf(aVar2.field_prioritylevel));
                    z = false;
                } else {
                    boolean updateNotify = super.updateNotify(aVar2, false, new String[0]);
                    Log.i("MicroMsg.ABTestInfoStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", aVar2.field_abtestkey, Boolean.valueOf(updateNotify), Long.valueOf(aVar3.field_sequence), Long.valueOf(aVar2.field_sequence), Integer.valueOf(aVar3.field_prioritylevel), Integer.valueOf(aVar2.field_prioritylevel));
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
        AppMethodBeat.o(153151);
    }

    public final LinkedList<akc> gzx() {
        AppMethodBeat.i(153152);
        LinkedList<akc> linkedList = new LinkedList<>();
        Cursor all = getAll();
        if (all == null) {
            AppMethodBeat.o(153152);
        } else if (!all.moveToFirst()) {
            all.close();
            AppMethodBeat.o(153152);
        } else {
            a aVar = new a();
            do {
                aVar.convertFrom(all);
                akc akc = new akc();
                try {
                    akc.Lqu = Util.getInt(aVar.field_expId, 0);
                } catch (Exception e2) {
                    Log.e("MicroMsg.ABTestInfoStorage", "expId parse failed, %s", aVar.field_expId);
                }
                akc.priority = aVar.field_prioritylevel;
                linkedList.add(akc);
            } while (all.moveToNext());
            all.close();
            AppMethodBeat.o(153152);
        }
        return linkedList;
    }

    public final a biB(String str) {
        AppMethodBeat.i(153153);
        a aVar = new a();
        aVar.field_abtestkey = str;
        boolean z = super.get(aVar, new String[0]);
        if (z && aVar.field_endTime == 0) {
            aVar.field_endTime = MAlarmHandler.NEXT_FIRE_INTERVAL;
        }
        Log.i("MicroMsg.ABTestInfoStorage", "getByLayerId, id: %s, return: %b", str, Boolean.valueOf(z));
        AppMethodBeat.o(153153);
        return aVar;
    }

    public final int gO(String str, int i2) {
        AppMethodBeat.i(153154);
        a biB = biB(str);
        if (biB.isValid()) {
            int i3 = Util.getInt(biB.field_value, i2);
            AppMethodBeat.o(153154);
            return i3;
        }
        AppMethodBeat.o(153154);
        return i2;
    }

    public final String getExpIdByKey(String str) {
        AppMethodBeat.i(153155);
        a biB = biB(str);
        if (!biB.isValid()) {
            AppMethodBeat.o(153155);
            return "";
        } else if (biB.field_expId == null) {
            AppMethodBeat.o(153155);
            return "";
        } else {
            String str2 = biB.field_expId;
            AppMethodBeat.o(153155);
            return str2;
        }
    }

    public final String gzy() {
        AppMethodBeat.i(153156);
        Cursor all = getAll();
        if (all == null) {
            AppMethodBeat.o(153156);
            return "null cursor!!";
        } else if (!all.moveToFirst()) {
            all.close();
            AppMethodBeat.o(153156);
            return "cursor empty!!";
        } else {
            StringBuilder sb = new StringBuilder();
            a aVar = new a();
            do {
                sb.append("============\n");
                aVar.convertFrom(all);
                sb.append("abtestkey = ").append(aVar.field_abtestkey).append("\n");
                sb.append("sequence = ").append(aVar.field_sequence).append("\n");
                sb.append("priorityLV = ").append(aVar.field_prioritylevel).append("\n");
                sb.append("expId = ").append(aVar.field_expId).append("\n");
            } while (all.moveToNext());
            all.close();
            String sb2 = sb.toString();
            AppMethodBeat.o(153156);
            return sb2;
        }
    }
}
