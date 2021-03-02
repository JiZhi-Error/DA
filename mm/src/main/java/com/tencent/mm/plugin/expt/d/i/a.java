package com.tencent.mm.plugin.expt.d.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.b.g;

public final class a {
    private ISQLiteDatabase kLX;
    private List<com.tencent.mm.plugin.expt.d.e.a.a> syA;
    private String syz;

    public a(ISQLiteDatabase iSQLiteDatabase, String str, List<com.tencent.mm.plugin.expt.d.e.a.a> list) {
        this.kLX = iSQLiteDatabase;
        this.syz = str;
        this.syA = list;
    }

    public final boolean cNc() {
        boolean z = false;
        AppMethodBeat.i(220366);
        if (this.kLX == null || g.eP(this.syz)) {
            AppMethodBeat.o(220366);
        } else {
            String aou = aou(this.syz);
            if (g.eP(aou)) {
                AppMethodBeat.o(220366);
            } else {
                Cursor cursor = null;
                try {
                    cursor = this.kLX.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[]{aou});
                    z = cursor.moveToNext();
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] checkTableExist throw Exception : " + e2.getMessage());
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    AppMethodBeat.o(220366);
                    throw th;
                }
                AppMethodBeat.o(220366);
            }
        }
        return z;
    }

    public final boolean cNd() {
        boolean z;
        AppMethodBeat.i(220367);
        if (this.kLX == null || g.eP(this.syz) || this.syA == null || this.syA.size() <= 0) {
            AppMethodBeat.o(220367);
            return false;
        }
        String aou = aou(this.syz);
        if (g.eP(aou)) {
            AppMethodBeat.o(220367);
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS " + aou + " ( ");
        for (com.tencent.mm.plugin.expt.d.e.a.a aVar : this.syA) {
            String GN = GN(aVar.type);
            String aot = aot(aVar.name);
            if (!g.eP(GN) && !g.eP(aot)) {
                sb.append(aot).append(" ").append(GN).append(",");
            }
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(");");
        Log.i("EdgeComputingDataDao", "[EdgeComputingDataDao] createTable tableName : %s", aou);
        Log.d("EdgeComputingDataDao", "[EdgeComputingDataDao] createTable tableName : %s, createTableSQL : %s", aou, sb.toString());
        h hVar = this.kLX instanceof h ? (h) this.kLX : null;
        if (hVar != null) {
            long beginTransaction = hVar.beginTransaction(-1);
            try {
                z = hVar.execSQL(aou, sb.toString());
                hVar.endTransaction(beginTransaction);
            } catch (Exception e2) {
                Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] createTable throw Exception : " + e2.getMessage());
                hVar.endTransaction(beginTransaction);
                z = false;
            } catch (Throwable th) {
                hVar.endTransaction(beginTransaction);
                AppMethodBeat.o(220367);
                throw th;
            }
        } else {
            z = false;
        }
        AppMethodBeat.o(220367);
        return z;
    }

    public final boolean cNe() {
        h hVar;
        boolean z;
        AppMethodBeat.i(220368);
        if (this.kLX == null || g.eP(this.syz)) {
            AppMethodBeat.o(220368);
            return false;
        }
        String aou = aou(this.syz);
        if (g.eP(aou)) {
            AppMethodBeat.o(220368);
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE INDEX ").append("report_time_ec_index_" + this.syz).append(" ON " + aou + " ( ").append(aot("report_time_ec")).append(" );");
        Log.i("EdgeComputingDataDao", "[EdgeComputingDataDao] createIndex tableName : %s", aou);
        Log.d("EdgeComputingDataDao", "[EdgeComputingDataDao] createIndex tableName : %s, createIndexSQL : %s", aou, sb.toString());
        if (this.kLX instanceof h) {
            hVar = (h) this.kLX;
        } else {
            hVar = null;
        }
        if (hVar != null) {
            long beginTransaction = hVar.beginTransaction(-1);
            try {
                z = hVar.execSQL(aou, sb.toString());
                hVar.endTransaction(beginTransaction);
            } catch (Exception e2) {
                Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] createIndex throw Exception : " + e2.getMessage());
                hVar.endTransaction(beginTransaction);
                z = false;
            } catch (Throwable th) {
                hVar.endTransaction(beginTransaction);
                AppMethodBeat.o(220368);
                throw th;
            }
        } else {
            z = false;
        }
        AppMethodBeat.o(220368);
        return z;
    }

    public final void cNf() {
        AppMethodBeat.i(220369);
        if (this.kLX == null || g.eP(this.syz) || this.syA == null || this.syA.size() <= 0) {
            AppMethodBeat.o(220369);
            return;
        }
        String aou = aou(this.syz);
        if (g.eP(aou)) {
            AppMethodBeat.o(220369);
            return;
        }
        h hVar = this.kLX instanceof h ? (h) this.kLX : null;
        if (hVar != null) {
            for (com.tencent.mm.plugin.expt.d.e.a.a aVar : this.syA) {
                String GN = GN(aVar.type);
                String aot = aot(aVar.name);
                if (!g.eP(GN) && !g.eP(aot) && !aos(aot)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ALTER TABLE ").append(aou).append(" ADD ");
                    sb.append(aot).append(" ").append(GN).append(";");
                    Log.i("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable tableName : %s", aou);
                    Log.d("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable tableName : %s, updateTableSQL : %s", aou, sb.toString());
                    long beginTransaction = hVar.beginTransaction(-1);
                    try {
                        Log.d("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable tableName : %s, result : %d, updateTableSQL : %s", aou, Boolean.valueOf(hVar.execSQL(aou, sb.toString())), sb.toString());
                        hVar.endTransaction(beginTransaction);
                    } catch (Exception e2) {
                        Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable throw Exception : " + e2.getMessage());
                        hVar.endTransaction(beginTransaction);
                    } catch (Throwable th) {
                        hVar.endTransaction(beginTransaction);
                        AppMethodBeat.o(220369);
                        throw th;
                    }
                }
            }
        }
        AppMethodBeat.o(220369);
    }

    public final boolean cNg() {
        h hVar;
        boolean z;
        AppMethodBeat.i(220370);
        if (this.kLX == null || g.eP(this.syz)) {
            AppMethodBeat.o(220370);
            return false;
        }
        String aou = aou(this.syz);
        if (g.eP(aou)) {
            AppMethodBeat.o(220370);
            return false;
        }
        String concat = "DROP TABLE IF EXISTS ".concat(String.valueOf(aou));
        Log.i("EdgeComputingDataDao", "[EdgeComputingDataDao] dropTable tableName : %s", aou);
        Log.d("EdgeComputingDataDao", "[EdgeComputingDataDao] dropTable tableName : %s, dropSql : %s", aou, concat);
        if (this.kLX instanceof h) {
            hVar = (h) this.kLX;
        } else {
            hVar = null;
        }
        if (hVar != null) {
            long beginTransaction = hVar.beginTransaction(-1);
            try {
                z = hVar.execSQL(aou, concat);
                hVar.endTransaction(beginTransaction);
            } catch (Exception e2) {
                Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] dropTable throw Exception : " + e2.getMessage());
                hVar.endTransaction(beginTransaction);
                z = false;
            } catch (Throwable th) {
                hVar.endTransaction(beginTransaction);
                AppMethodBeat.o(220370);
                throw th;
            }
        } else {
            z = false;
        }
        AppMethodBeat.o(220370);
        return z;
    }

    public final boolean dp(List<List<b>> list) {
        String str;
        boolean z = false;
        AppMethodBeat.i(220371);
        if (this.kLX == null || g.eP(this.syz) || list == null || list.size() <= 0) {
            AppMethodBeat.o(220371);
        } else {
            String aou = aou(this.syz);
            if (g.eP(aou)) {
                AppMethodBeat.o(220371);
            } else {
                StringBuilder sb = new StringBuilder("INSERT INTO ");
                sb.append(aou).append(" ( ");
                for (int i2 = 0; i2 < this.syA.size(); i2++) {
                    sb.append(aot(this.syA.get(i2).name)).append(",");
                }
                if (sb.toString().endsWith(",")) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(" ) VALUES ");
                for (List<b> list2 : list) {
                    sb.append("(");
                    for (b bVar : list2) {
                        try {
                            if (bVar.type == 0) {
                                str = "'" + bVar.stringValue + "'";
                            } else if (bVar.type == 1) {
                                str = String.valueOf(bVar.intValue);
                            } else {
                                if (bVar.type == 2) {
                                    str = String.valueOf(bVar.syi);
                                }
                                str = "''";
                            }
                        } catch (Exception e2) {
                            Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] insertPatch throw Exception : " + e2.getMessage());
                        }
                        sb.append(str).append(",");
                    }
                    if (sb.toString().endsWith(",")) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    sb.append("),");
                }
                if (sb.toString().endsWith(",")) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(";");
                Log.d("EdgeComputingDataDao", "[EdgeComputingDataDao] insertPatch tableName : ".concat(String.valueOf(aou)));
                h hVar = this.kLX instanceof h ? (h) this.kLX : null;
                if (hVar != null) {
                    long beginTransaction = hVar.beginTransaction(-1);
                    try {
                        z = this.kLX.execSQL(aou, sb.toString());
                        hVar.endTransaction(beginTransaction);
                    } catch (Exception e3) {
                        Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] insertPatch throw Exception : " + e3.getMessage());
                        hVar.endTransaction(beginTransaction);
                    } catch (Throwable th) {
                        hVar.endTransaction(beginTransaction);
                        AppMethodBeat.o(220371);
                        throw th;
                    }
                }
                AppMethodBeat.o(220371);
            }
        }
        return z;
    }

    public final boolean Dn(long j2) {
        h hVar;
        int i2;
        AppMethodBeat.i(220372);
        if (this.kLX == null || g.eP(this.syz)) {
            AppMethodBeat.o(220372);
            return false;
        }
        String aou = aou(this.syz);
        if (g.eP(aou)) {
            AppMethodBeat.o(220372);
            return false;
        }
        Log.i("EdgeComputingDataDao", "[EdgeComputingDataDao] deleteExpire tableName : " + aou + ", expireTimestamp : " + j2);
        if (this.kLX instanceof h) {
            hVar = (h) this.kLX;
        } else {
            hVar = null;
        }
        if (hVar != null) {
            long beginTransaction = hVar.beginTransaction(-1);
            try {
                i2 = hVar.delete(aou, aot("report_time_ec") + " < ?", new String[]{String.valueOf(j2)});
                hVar.endTransaction(beginTransaction);
            } catch (Exception e2) {
                Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] deleteExpire throw Exception : " + e2.getMessage());
                hVar.endTransaction(beginTransaction);
                i2 = 0;
            } catch (Throwable th) {
                hVar.endTransaction(beginTransaction);
                AppMethodBeat.o(220372);
                throw th;
            }
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            AppMethodBeat.o(220372);
            return true;
        }
        AppMethodBeat.o(220372);
        return false;
    }

    public final List<List<b>> cNh() {
        Cursor cursor;
        LinkedList linkedList;
        boolean z;
        AppMethodBeat.i(220373);
        if (this.kLX == null || g.eP(this.syz) || this.syA == null || this.syA.size() <= 0) {
            AppMethodBeat.o(220373);
            return null;
        }
        String aou = aou(this.syz);
        if (g.eP(aou)) {
            AppMethodBeat.o(220373);
            return null;
        }
        try {
            cursor = this.kLX.query(aou, null, null, null, null, null, null);
            if (cursor != null) {
                try {
                    LinkedList linkedList2 = new LinkedList();
                    while (cursor.moveToNext()) {
                        try {
                            ArrayList arrayList = new ArrayList();
                            Iterator<com.tencent.mm.plugin.expt.d.e.a.a> it = this.syA.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = false;
                                    break;
                                }
                                com.tencent.mm.plugin.expt.d.e.a.a next = it.next();
                                b bVar = new b();
                                bVar.name = next.name;
                                bVar.index = next.index;
                                bVar.type = next.type;
                                try {
                                    if (next.type != 0) {
                                        if (next.type != 1) {
                                            if (next.type != 2) {
                                                z = true;
                                                break;
                                            }
                                            bVar.syi = cursor.getLong(next.index);
                                        } else {
                                            bVar.intValue = cursor.getInt(next.index);
                                        }
                                    } else {
                                        bVar.stringValue = cursor.getString(next.index);
                                    }
                                    arrayList.add(bVar);
                                } catch (Exception e2) {
                                    z = true;
                                }
                            }
                            if (!z) {
                                linkedList2.add(arrayList);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            linkedList = linkedList2;
                            try {
                                Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] queryAll throw Exception : " + e.getMessage());
                                cursor.close();
                                Log.i("EdgeComputingDataDao", "[EdgeComputingDataDao] queryAll tableName : ".concat(String.valueOf(aou)));
                                AppMethodBeat.o(220373);
                                return linkedList;
                            } catch (Throwable th) {
                                th = th;
                                cursor.close();
                                AppMethodBeat.o(220373);
                                throw th;
                            }
                        }
                    }
                    linkedList = linkedList2;
                } catch (Exception e4) {
                    e = e4;
                    linkedList = null;
                    Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] queryAll throw Exception : " + e.getMessage());
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    Log.i("EdgeComputingDataDao", "[EdgeComputingDataDao] queryAll tableName : ".concat(String.valueOf(aou)));
                    AppMethodBeat.o(220373);
                    return linkedList;
                }
            } else {
                linkedList = null;
            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        } catch (Exception e5) {
            e = e5;
            cursor = null;
            linkedList = null;
            Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] queryAll throw Exception : " + e.getMessage());
            cursor.close();
            Log.i("EdgeComputingDataDao", "[EdgeComputingDataDao] queryAll tableName : ".concat(String.valueOf(aou)));
            AppMethodBeat.o(220373);
            return linkedList;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            AppMethodBeat.o(220373);
            throw th;
        }
        Log.i("EdgeComputingDataDao", "[EdgeComputingDataDao] queryAll tableName : ".concat(String.valueOf(aou)));
        AppMethodBeat.o(220373);
        return linkedList;
    }

    private boolean aos(String str) {
        boolean z = true;
        AppMethodBeat.i(220374);
        if (this.kLX == null || g.eP(this.syz) || g.eP(str)) {
            AppMethodBeat.o(220374);
            return false;
        }
        String aou = aou(this.syz);
        if (g.eP(aou)) {
            AppMethodBeat.o(220374);
            return false;
        }
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.kLX.rawQuery("select * from sqlite_master where name = ? and sql like ?;", new String[]{aou, "%" + str + "%"});
            if (rawQuery == null || !rawQuery.moveToFirst()) {
                z = false;
            }
            if (rawQuery != null && !rawQuery.isClosed()) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] checkColumnExist throw Exception : " + e2.getMessage());
            if (0 != 0 && !cursor.isClosed()) {
                cursor.close();
            }
            z = false;
        } catch (Throwable th) {
            if (0 != 0 && !cursor.isClosed()) {
                cursor.close();
            }
            AppMethodBeat.o(220374);
            throw th;
        }
        AppMethodBeat.o(220374);
        return z;
    }

    private static String GN(int i2) {
        if (i2 == 0) {
            return "TEXT ";
        }
        if (i2 == 1 || i2 == 2) {
            return "INTEGER ";
        }
        return null;
    }

    private static String aot(String str) {
        AppMethodBeat.i(220375);
        if (g.eP(str)) {
            AppMethodBeat.o(220375);
            return null;
        }
        String str2 = str + "_ ";
        AppMethodBeat.o(220375);
        return str2;
    }

    private static String aou(String str) {
        AppMethodBeat.i(220376);
        if (g.eP(str)) {
            AppMethodBeat.o(220376);
            return null;
        }
        String concat = "ec_data_table_".concat(String.valueOf(str));
        AppMethodBeat.o(220376);
        return concat;
    }
}
