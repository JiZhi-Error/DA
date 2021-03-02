package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Arrays;

public final class am extends MAutoStorage<aw> {
    private static am NRH;
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(al.info, "CleanDeleteItem")};
    public ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* bridge */ /* synthetic */ boolean update(long j2, aw awVar) {
        AppMethodBeat.i(197173);
        boolean update = super.update(j2, awVar);
        AppMethodBeat.o(197173);
        return update;
    }

    static {
        AppMethodBeat.i(197174);
        AppMethodBeat.o(197174);
    }

    private am(h hVar) {
        super(hVar, al.info, "CleanDeleteItem", null);
        AppMethodBeat.i(197170);
        this.db = hVar;
        long currentTimeMillis = System.currentTimeMillis();
        long beginTransaction = hVar.beginTransaction(Thread.currentThread().getId());
        long currentTimeMillis2 = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList("CREATE INDEX IF NOT EXISTS ID ON CleanDeleteItem ( id )"));
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            hVar.execSQL("CleanDeleteItem", (String) arrayList.get(i2));
        }
        Log.d("MicroMsg.CleanDeleteItemStorage", "build new index last time[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        hVar.endTransaction(beginTransaction);
        Log.i("MicroMsg.CleanDeleteItemStorage", "executeInitSQL last time[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(197170);
    }

    public static am gBD() {
        AppMethodBeat.i(197171);
        g.aAi();
        g.aAf().azk();
        if (NRH == null) {
            NRH = new am(g.aAh().hqK);
        }
        am amVar = NRH;
        AppMethodBeat.o(197171);
        return amVar;
    }

    public final void a(long j2, PLong pLong, PLong pLong2) {
        AppMethodBeat.i(197172);
        String format = String.format("SELECT * FROM %s", "CleanDeleteItem");
        Log.i("MicroMsg.CleanDeleteItemStorage", "calculateFreeSpaceSize, sql = ".concat(String.valueOf(format)));
        Cursor rawQuery = rawQuery(format, new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(197172);
            return;
        }
        while (rawQuery.moveToNext()) {
            al alVar = new al();
            alVar.convertFrom(rawQuery);
            if (alVar.field_deleteTime - alVar.field_modifyTime < j2) {
                pLong2.value += alVar.field_size;
            }
            pLong.value += alVar.field_size;
        }
        rawQuery.close();
        AppMethodBeat.o(197172);
    }
}
