package com.tencent.mm.plugin.record.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class k extends MAutoStorage<j> implements e {
    private Vector<d> BGU = new Vector<>();
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean delete(j jVar, String[] strArr) {
        AppMethodBeat.i(9514);
        boolean a2 = a(jVar, strArr);
        AppMethodBeat.o(9514);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(j jVar) {
        AppMethodBeat.i(9515);
        boolean b2 = b(jVar);
        AppMethodBeat.o(9515);
        return b2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(j jVar) {
        AppMethodBeat.i(9511);
        boolean a2 = a(jVar);
        AppMethodBeat.o(9511);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(long j2, j jVar) {
        AppMethodBeat.i(9513);
        j jVar2 = jVar;
        if (super.update(j2, jVar2)) {
            b(1, jVar2);
            AppMethodBeat.o(9513);
            return true;
        }
        AppMethodBeat.o(9513);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(j jVar, String[] strArr) {
        AppMethodBeat.i(9512);
        boolean b2 = b(jVar, strArr);
        AppMethodBeat.o(9512);
        return b2;
    }

    public k(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, j.info, "RecordCDNInfo", null);
        AppMethodBeat.i(9500);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(9500);
    }

    @Override // com.tencent.mm.plugin.record.a.e
    public final void a(final d dVar) {
        AppMethodBeat.i(9501);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.record.b.k.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(9497);
                if (!k.this.BGU.contains(dVar)) {
                    k.this.BGU.add(dVar);
                }
                AppMethodBeat.o(9497);
            }
        });
        AppMethodBeat.o(9501);
    }

    @Override // com.tencent.mm.plugin.record.a.e
    public final void b(final d dVar) {
        AppMethodBeat.i(9502);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.record.b.k.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(9498);
                k.this.BGU.remove(dVar);
                AppMethodBeat.o(9498);
            }
        });
        AppMethodBeat.o(9502);
    }

    private void b(final int i2, final j jVar) {
        AppMethodBeat.i(9503);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.record.b.k.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(9499);
                Iterator it = k.this.BGU.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).a(i2, jVar);
                }
                AppMethodBeat.o(9499);
            }
        });
        AppMethodBeat.o(9503);
    }

    @Override // com.tencent.mm.plugin.record.a.e
    public final List<j> eIk() {
        AppMethodBeat.i(9504);
        LinkedList linkedList = new LinkedList();
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM RecordCDNInfo WHERE status != 3 AND status != 4 AND status != 2 AND status != -1", null, 2);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                j jVar = new j();
                jVar.convertFrom(rawQuery);
                linkedList.add(jVar);
            }
            rawQuery.close();
        }
        Log.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(9504);
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.record.a.e
    public final List<j> Vt(int i2) {
        AppMethodBeat.i(9505);
        LinkedList linkedList = new LinkedList();
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM RecordCDNInfo WHERE recordLocalId = ".concat(String.valueOf(i2)), null, 2);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                j jVar = new j();
                jVar.convertFrom(rawQuery);
                linkedList.add(jVar);
            }
            rawQuery.close();
        }
        Log.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(9505);
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.record.a.e
    public final j aKX(String str) {
        j jVar = null;
        AppMethodBeat.i(9506);
        Cursor rawQuery = this.db.rawQuery("SELECT * FROM RecordCDNInfo WHERE mediaId='" + str + "'", null, 2);
        if (rawQuery != null && rawQuery.moveToFirst()) {
            jVar = new j();
            jVar.convertFrom(rawQuery);
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        AppMethodBeat.o(9506);
        return jVar;
    }

    @Override // com.tencent.mm.plugin.record.a.e
    public final boolean a(j jVar, String... strArr) {
        AppMethodBeat.i(9507);
        if (super.delete(jVar, strArr)) {
            b(0, jVar);
            AppMethodBeat.o(9507);
            return true;
        }
        AppMethodBeat.o(9507);
        return false;
    }

    @Override // com.tencent.mm.plugin.record.a.e
    public final boolean b(j jVar, String... strArr) {
        AppMethodBeat.i(9508);
        if (super.update(jVar, strArr)) {
            b(1, jVar);
            AppMethodBeat.o(9508);
            return true;
        }
        AppMethodBeat.o(9508);
        return false;
    }

    @Override // com.tencent.mm.plugin.record.a.e
    public final boolean a(j jVar) {
        AppMethodBeat.i(9509);
        if (super.replace(jVar)) {
            b(1, jVar);
            AppMethodBeat.o(9509);
            return true;
        }
        AppMethodBeat.o(9509);
        return false;
    }

    @Override // com.tencent.mm.plugin.record.a.e
    public final boolean b(j jVar) {
        AppMethodBeat.i(9510);
        if (jVar != null) {
            Log.v("MicroMsg.RecordMsgCDNStorage", "insert record cdn info %s", jVar);
            if (super.insert(jVar)) {
                b(2, jVar);
                AppMethodBeat.o(9510);
                return true;
            }
            AppMethodBeat.o(9510);
            return false;
        }
        Log.e("MicroMsg.RecordMsgCDNStorage", "insert null record cdn info");
        AppMethodBeat.o(9510);
        return false;
    }
}
