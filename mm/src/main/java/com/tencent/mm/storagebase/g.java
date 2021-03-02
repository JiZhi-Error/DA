package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storagebase.i;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class g implements ISQLiteDatabase {
    private static String Otx = "";
    public boolean JWJ;
    public h Otw;
    public Map<String, i> Oty;
    public Queue<a> Otz;
    public int field_MARK_CURSOR_CHECK_IGNORE;
    public f jNN;

    public interface a {
        int a(g gVar);

        String getTableName();
    }

    public final void closeDB() {
        AppMethodBeat.i(133386);
        Otx = Util.getStack().toString();
        if (this.jNN != null) {
            this.jNN.close();
            this.jNN = null;
        }
        AppMethodBeat.o(133386);
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public final boolean isClose() {
        AppMethodBeat.i(133387);
        if (this.jNN == null || !this.jNN.isOpen()) {
            Log.e("MicroMsg.MemoryStorage", "memory db is close [%s]", Otx);
            AppMethodBeat.o(133387);
            return true;
        }
        AppMethodBeat.o(133387);
        return false;
    }

    public final int blz(String str) {
        String str2 = null;
        AppMethodBeat.i(133388);
        if (!this.JWJ) {
            AppMethodBeat.o(133388);
            return -4;
        } else if (this.Otw == null || this.Otw.inTransaction()) {
            Log.d("MicroMsg.MemoryStorage", "copy table but diskDB inTransaction");
            AppMethodBeat.o(133388);
            return -3;
        } else {
            try {
                if (f.a(this.jNN, str)) {
                    this.jNN.execSQL("drop table ".concat(String.valueOf(str)));
                    Log.i("MicroMsg.MemoryStorage", "table %s is in Memory DB,drop! ", str);
                }
                Cursor rawQuery = this.Otw.rawQuery(" select sql from sqlite_master where tbl_name=\"" + str + "\" and type = \"table\"", null);
                if (rawQuery != null) {
                    if (rawQuery.getCount() == 1) {
                        rawQuery.moveToFirst();
                        str2 = rawQuery.getString(0);
                    }
                    rawQuery.close();
                }
                if (str2 == null) {
                    Log.w("MicroMsg.MemoryStorage", "diskDB has not this table !");
                    AppMethodBeat.o(133388);
                    return -1;
                }
                this.jNN.execSQL(str2);
                this.jNN.execSQL("insert into " + str + " select * from old." + str);
                Log.d("MicroMsg.MemoryStorage", "copy table %s success", str);
                AppMethodBeat.o(133388);
                return 0;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MemoryStorage", e2, "copy table failed with exception.\n", new Object[0]);
                AppMethodBeat.o(133388);
                return -2;
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public final int delete(String str, String str2, String[] strArr) {
        AppMethodBeat.i(133389);
        Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(str)), this.Oty.containsKey(str));
        if (this.jNN == null || !this.jNN.isOpen()) {
            Log.w("MicroMsg.MemoryStorage", "memoryDB already close delete [%s] [%s]", str, Otx);
            if (this.Otw == null || !this.Otw.isOpen()) {
                AppMethodBeat.o(133389);
                return -1;
            }
            int delete = this.Otw.delete(str, str2, strArr);
            AppMethodBeat.o(133389);
            return delete;
        }
        i.a aVar = new i.a();
        aVar.funcType = 5;
        aVar.OtI = str2;
        aVar.Z(strArr);
        this.Oty.get(str).b(aVar);
        int delete2 = this.jNN.delete(str, str2, strArr);
        AppMethodBeat.o(133389);
        return delete2;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public final boolean execSQL(String str, String str2) {
        AppMethodBeat.i(133390);
        Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(str)), this.Oty.containsKey(str));
        if (this.jNN == null || !this.jNN.isOpen()) {
            Log.w("MicroMsg.MemoryStorage", "memoryDB already close execSQL [%s] [%s]", str, Otx);
            if (this.Otw == null || !this.Otw.isOpen()) {
                AppMethodBeat.o(133390);
                return false;
            }
            this.Otw.execSQL(str2, str);
            AppMethodBeat.o(133390);
            return true;
        }
        i.a aVar = new i.a();
        aVar.funcType = 1;
        aVar.sql = str2;
        this.Oty.get(str).b(aVar);
        this.jNN.execSQL(str2);
        AppMethodBeat.o(133390);
        return true;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public final long insert(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(133391);
        Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(str)), this.Oty.containsKey(str));
        if (this.jNN == null || !this.jNN.isOpen()) {
            Log.w("MicroMsg.MemoryStorage", "memoryDB already close insert [%s] [%s]", str, Otx);
            if (this.Otw == null || !this.Otw.isOpen()) {
                AppMethodBeat.o(133391);
                return -1;
            }
            long insert = this.Otw.insert(str, str2, contentValues);
            AppMethodBeat.o(133391);
            return insert;
        }
        i.a aVar = new i.a();
        aVar.funcType = 2;
        aVar.primaryKey = str2;
        aVar.values = new ContentValues(contentValues);
        this.Oty.get(str).b(aVar);
        long insert2 = this.jNN.insert(str, str2, contentValues);
        AppMethodBeat.o(133391);
        return insert2;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public final long replace(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(133392);
        Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(str)), this.Oty.containsKey(str));
        if (this.jNN == null || !this.jNN.isOpen()) {
            Log.w("MicroMsg.MemoryStorage", "memoryDB already close replace [%s] [%s]", str, Otx);
            if (this.Otw == null || !this.Otw.isOpen()) {
                AppMethodBeat.o(133392);
                return -1;
            }
            long replace = this.Otw.replace(str, str2, contentValues);
            AppMethodBeat.o(133392);
            return replace;
        }
        i.a aVar = new i.a();
        aVar.funcType = 4;
        aVar.primaryKey = str2;
        aVar.values = new ContentValues(contentValues);
        this.Oty.get(str).b(aVar);
        long replace2 = this.jNN.replace(str, str2, contentValues);
        AppMethodBeat.o(133392);
        return replace2;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        AppMethodBeat.i(133393);
        Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(str)), this.Oty.containsKey(str));
        if (this.jNN == null || !this.jNN.isOpen()) {
            Log.w("MicroMsg.MemoryStorage", "memoryDB already close update [%s] [%s]", str, Otx);
            if (this.Otw == null || !this.Otw.isOpen()) {
                AppMethodBeat.o(133393);
                return -1;
            }
            int update = this.Otw.update(str, contentValues, str2, strArr);
            AppMethodBeat.o(133393);
            return update;
        }
        i.a aVar = new i.a();
        aVar.funcType = 3;
        aVar.OtI = str2;
        aVar.values = new ContentValues(contentValues);
        aVar.Z(strArr);
        this.Oty.get(str).b(aVar);
        int update2 = this.jNN.update(str, contentValues, str2, strArr);
        AppMethodBeat.o(133393);
        return update2;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        AppMethodBeat.i(133394);
        if (this.jNN == null || !this.jNN.isOpen()) {
            Log.w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", str, Otx);
            Cursor gFu = d.gFu();
            AppMethodBeat.o(133394);
            return gFu;
        }
        Cursor query = this.jNN.query(str, strArr, str2, strArr2, str3, str4, str5, 0, null);
        AppMethodBeat.o(133394);
        return query;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i2) {
        AppMethodBeat.i(133395);
        Cursor query = query(str, strArr, str2, strArr2, str3, str4, str5);
        AppMethodBeat.o(133395);
        return query;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i2, String str6) {
        AppMethodBeat.i(197184);
        if (this.jNN == null || !this.jNN.isOpen()) {
            Log.w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", str, Otx);
            Cursor gFu = d.gFu();
            AppMethodBeat.o(197184);
            return gFu;
        }
        Cursor query = this.jNN.query(str, strArr, str2, strArr2, str3, str4, str5, 0, str6);
        AppMethodBeat.o(197184);
        return query;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public final Cursor rawQuery(String str, String[] strArr) {
        AppMethodBeat.i(133396);
        if (this.jNN == null || !this.jNN.isOpen()) {
            Log.w("MicroMsg.MemoryStorage", "memoryDB already close rawQuery [%s] [%s]", str, Otx);
            Cursor gFu = d.gFu();
            AppMethodBeat.o(133396);
            return gFu;
        }
        Cursor rawQuery = this.jNN.rawQuery(str, strArr, 0);
        AppMethodBeat.o(133396);
        return rawQuery;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public final Cursor rawQuery(String str, String[] strArr, int i2) {
        AppMethodBeat.i(133397);
        Cursor rawQuery = rawQuery(str, strArr);
        AppMethodBeat.o(133397);
        return rawQuery;
    }
}
