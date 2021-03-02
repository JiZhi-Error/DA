package com.tencent.mm.plugin.record.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.h;
import com.tencent.mm.plugin.record.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.List;

public final class o extends MAutoStorage<k> implements h {
    private ISQLiteDatabase db;

    public o(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, k.info, "RecordMessageInfo", null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.plugin.record.a.h
    public final List<k> eIl() {
        AppMethodBeat.i(9516);
        LinkedList linkedList = new LinkedList();
        Cursor all = getAll();
        if (all != null) {
            all.moveToFirst();
            while (!all.isAfterLast()) {
                k kVar = new k();
                try {
                    kVar.convertFrom(all);
                } catch (Exception e2) {
                    Log.e("MicroMsg.RecordMsgStorage", "convert recordInfo Exception: " + e2.getMessage());
                }
                linkedList.add(kVar);
                all.moveToNext();
            }
            all.close();
        }
        Log.d("MicroMsg.RecordMsgStorage", "get all finish, result count %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(9516);
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.record.a.h
    public final void Vu(int i2) {
        AppMethodBeat.i(9517);
        Log.d("MicroMsg.RecordMsgStorage", "delete record msg item, local id %d, result %d", Integer.valueOf(i2), Integer.valueOf(this.db.delete("RecordMessageInfo", "localId=?", new String[]{String.valueOf(i2)})));
        AppMethodBeat.o(9517);
    }

    @Override // com.tencent.mm.plugin.record.a.h
    public final k Vv(int i2) {
        k kVar = null;
        AppMethodBeat.i(9518);
        String concat = "SELECT * FROM RecordMessageInfo WHERE localId=".concat(String.valueOf(i2));
        Log.d("MicroMsg.RecordMsgStorage", "get by local id, sql[%s], local[%d]", concat, Integer.valueOf(i2));
        Cursor rawQuery = this.db.rawQuery(concat, null, 2);
        if (rawQuery != null && rawQuery.moveToFirst()) {
            kVar = new k();
            kVar.convertFrom(rawQuery);
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        AppMethodBeat.o(9518);
        return kVar;
    }
}
