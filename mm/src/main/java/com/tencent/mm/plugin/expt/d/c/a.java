package com.tencent.mm.plugin.expt.d.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.b.g;

public final class a {
    public final List<List<String>> gn(String str, String str2) {
        r.a aVar;
        Cursor cursor;
        boolean z;
        ArrayList arrayList = null;
        AppMethodBeat.i(220320);
        if (g.eP(str) || g.eP(str2)) {
            AppMethodBeat.o(220320);
        } else {
            String str3 = com.tencent.mm.kernel.g.aAh().cachePath + str;
            Log.d("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL dbPath : " + str + ", realDBPath : " + str3 + ", sql : " + str2);
            try {
                aVar = r.a(hashCode(), str3, new HashMap(), true);
            } catch (Exception e2) {
                Log.e("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL createDBInstance throw Exception : " + e2.getMessage());
                Log.d("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL createDBInstance throw Exception, realDBPath : ".concat(String.valueOf(str3)));
                aVar = null;
            }
            if (aVar == null) {
                Log.d("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL dataDB is null, realDBPath : ".concat(String.valueOf(str3)));
                AppMethodBeat.o(220320);
            } else {
                try {
                    cursor = aVar.rawQuery(str2, null);
                } catch (Exception e3) {
                    Log.e("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL rawQuery throw Exception : " + e3.getMessage());
                    cursor = null;
                }
                if (cursor == null || !cursor.moveToFirst()) {
                    if (aVar != null && !aVar.isClose()) {
                        aVar.uS(hashCode());
                    }
                    AppMethodBeat.o(220320);
                } else {
                    String[] columnNames = cursor.getColumnNames();
                    if (columnNames == null || columnNames.length <= 0) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (aVar != null && !aVar.isClose()) {
                            aVar.uS(hashCode());
                        }
                        AppMethodBeat.o(220320);
                    } else {
                        arrayList = new ArrayList();
                        do {
                            try {
                                ArrayList arrayList2 = new ArrayList();
                                for (int i2 = 0; i2 < columnNames.length; i2++) {
                                    try {
                                        arrayList2.add(cursor.getString(i2));
                                    } catch (Exception e4) {
                                        z = true;
                                    }
                                }
                                z = false;
                                if (!z) {
                                    arrayList.add(arrayList2);
                                }
                            } catch (Exception e5) {
                                Log.e("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL moveToNext throw Exception : " + e5.getMessage());
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (aVar != null && !aVar.isClose()) {
                                    aVar.uS(hashCode());
                                }
                            } catch (Throwable th) {
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (aVar != null && !aVar.isClose()) {
                                    aVar.uS(hashCode());
                                }
                                AppMethodBeat.o(220320);
                                throw th;
                            }
                        } while (cursor.moveToNext());
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (aVar != null && !aVar.isClose()) {
                            aVar.uS(hashCode());
                        }
                        AppMethodBeat.o(220320);
                    }
                }
            }
        }
        return arrayList;
    }

    public final boolean c(String str, String str2, List<String> list, List<List<String>> list2) {
        String str3;
        AppMethodBeat.i(220321);
        if (g.eP(str) || g.eP(str2) || list == null || list.size() <= 0 || list2.size() <= 0) {
            AppMethodBeat.o(220321);
            return false;
        }
        String str4 = com.tencent.mm.kernel.g.aAh().cachePath + str;
        Log.d("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB dbPath : " + str + ", realDBPath : " + str4);
        r.a aVar = null;
        try {
            aVar = r.a(hashCode(), str4, new HashMap(), true);
        } catch (Exception e2) {
            Log.e("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB createDBInstance throw Exception : " + e2.getMessage());
            Log.d("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB createDBInstance throw Exception, realDBPath : ".concat(String.valueOf(str4)));
        }
        if (aVar == null) {
            Log.d("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB dataDB is null, realDBPath : ".concat(String.valueOf(str4)));
            AppMethodBeat.o(220321);
            return false;
        } else if (a(aVar, str2) || a(aVar, str2, list)) {
            StringBuilder sb = new StringBuilder("INSERT INTO ");
            sb.append(str2).append(" ( ");
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(list.get(i2)).append(",");
            }
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(" ) VALUES ");
            for (List<String> list3 : list2) {
                sb.append("(");
                for (int i3 = 0; i3 < list.size(); i3++) {
                    try {
                        str3 = list3.get(i3);
                    } catch (Exception e3) {
                        Log.e("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB throw Exception : " + e3.getMessage());
                        str3 = "''";
                    }
                    sb.append("'").append(str3).append("',");
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
            Log.d("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB tableName : ".concat(String.valueOf(str2)));
            boolean z = false;
            r.a aVar2 = aVar instanceof h ? aVar : null;
            if (aVar2 != null) {
                long beginTransaction = aVar2.beginTransaction(-1);
                try {
                    z = aVar.execSQL(str2, sb.toString());
                    aVar2.endTransaction(beginTransaction);
                    if (aVar != null && !aVar.isClose()) {
                        aVar.uS(hashCode());
                    }
                } catch (Exception e4) {
                    Log.e("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB throw Exception : " + e4.getMessage());
                    aVar2.endTransaction(beginTransaction);
                    if (aVar != null && !aVar.isClose()) {
                        aVar.uS(hashCode());
                    }
                } catch (Throwable th) {
                    aVar2.endTransaction(beginTransaction);
                    if (aVar != null && !aVar.isClose()) {
                        aVar.uS(hashCode());
                    }
                    AppMethodBeat.o(220321);
                    throw th;
                }
            }
            AppMethodBeat.o(220321);
            return z;
        } else {
            if (aVar != null && !aVar.isClose()) {
                aVar.uS(hashCode());
            }
            AppMethodBeat.o(220321);
            return false;
        }
    }

    private static boolean a(r.a aVar, String str) {
        boolean z = false;
        AppMethodBeat.i(220322);
        if (aVar == null || g.eP(str)) {
            AppMethodBeat.o(220322);
        } else {
            Cursor cursor = null;
            try {
                cursor = aVar.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[]{str});
                z = cursor.moveToNext();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception e2) {
                Log.e("EdgeComputingDBService", "[EdgeComputingDBService] checkTableExist throw Exception : " + e2.getMessage());
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                AppMethodBeat.o(220322);
                throw th;
            }
            AppMethodBeat.o(220322);
        }
        return z;
    }

    private static boolean a(r.a aVar, String str, List<String> list) {
        boolean z;
        AppMethodBeat.i(220323);
        if (aVar == null || g.eP(str) || list == null || list.size() <= 0) {
            AppMethodBeat.o(220323);
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS " + str + " ( ");
        for (String str2 : list) {
            sb.append(str2).append(" TEXT,");
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(");");
        Log.i("EdgeComputingDBService", "[EdgeComputingDBService] createTable tableName : %s", str);
        Log.d("EdgeComputingDBService", "[EdgeComputingDBService] createTable tableName : %s, createTableSQL : %s", str, sb.toString());
        if (!(aVar instanceof h)) {
            aVar = null;
        }
        if (aVar != null) {
            long beginTransaction = aVar.beginTransaction(-1);
            try {
                z = aVar.execSQL(str, sb.toString());
                aVar.endTransaction(beginTransaction);
            } catch (Exception e2) {
                Log.e("EdgeComputingDBService", "[EdgeComputingDataDao] createTable throw Exception : " + e2.getMessage());
                aVar.endTransaction(beginTransaction);
                z = false;
            } catch (Throwable th) {
                aVar.endTransaction(beginTransaction);
                AppMethodBeat.o(220323);
                throw th;
            }
        } else {
            z = false;
        }
        AppMethodBeat.o(220323);
        return z;
    }
}
