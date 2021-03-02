package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.f;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ab {
    private static final ab jNL = new ab();
    public static AtomicBoolean jNM = new AtomicBoolean(true);
    public f jNN;

    static {
        AppMethodBeat.i(197123);
        AppMethodBeat.o(197123);
    }

    public static ab blL() {
        return jNL;
    }

    private ab() {
    }

    public class a {
        public String sql;
        public String table;

        public a(String str, String str2) {
            this.table = str;
            this.sql = str2;
        }
    }

    public static String a(String str, String[] strArr, String[] strArr2) {
        AppMethodBeat.i(197117);
        for (int i2 = 0; i2 < 2; i2++) {
            if (strArr[i2].equalsIgnoreCase(str)) {
                String str2 = strArr2[i2];
                AppMethodBeat.o(197117);
                return str2;
            }
        }
        AppMethodBeat.o(197117);
        return "";
    }

    public static boolean a(String[] strArr, String str, String str2) {
        AppMethodBeat.i(197118);
        if (str.startsWith("sqlite_")) {
            AppMethodBeat.o(197118);
            return false;
        } else if (str.equals(str2)) {
            AppMethodBeat.o(197118);
            return false;
        } else if (str.startsWith(str2)) {
            AppMethodBeat.o(197118);
            return false;
        } else {
            for (int i2 = 0; i2 < 2; i2++) {
                if (str2.equalsIgnoreCase(strArr[i2])) {
                    AppMethodBeat.o(197118);
                    return true;
                }
            }
            AppMethodBeat.o(197118);
            return false;
        }
    }

    public static boolean a(f fVar, String str, String str2) {
        AppMethodBeat.i(197119);
        Exception exc = null;
        try {
            fVar.execSQL("DROP INDEX ".concat(String.valueOf(str)));
        } catch (Exception e2) {
            exc = e2;
            Log.e("TableIndexFixer", "DROP INDEX, failure! indexName=%s %s", str, exc);
            e.INSTANCE.idkeyStat(1457, 0, 1, true);
            e.INSTANCE.a(20708, "1", 0, exc.getMessage() + " indexName=" + str);
        }
        if (exc == null) {
            Log.i("TableIndexFixer", "DROP INDEX, successfully! indexName=%s, tblName=%s", str, str2);
        }
        if (exc == null) {
            AppMethodBeat.o(197119);
            return true;
        }
        AppMethodBeat.o(197119);
        return false;
    }

    public static boolean a(f fVar, String str, String str2, String str3) {
        AppMethodBeat.i(197120);
        if (Util.isNullOrNil(str)) {
            Log.e("TableIndexFixer", "[createIndex] rightTblName is wrong.");
            AppMethodBeat.o(197120);
            return false;
        }
        Exception e2 = null;
        String replaceAll = str3.replaceAll(str2, str);
        try {
            fVar.execSQL(replaceAll);
        } catch (Exception e3) {
            e2 = e3;
            Log.e("TableIndexFixer", "CREATE INDEX, failure! sql=%s %s", replaceAll, e2);
            e.INSTANCE.idkeyStat(1457, 5, 1, true);
            e.INSTANCE.a(20708, "1", 4, e2.getMessage() + "sql=" + replaceAll);
        }
        if (e2 == null) {
            Log.i("TableIndexFixer", "CREATE INDEX, successfully! %s => %s", str3, replaceAll);
        }
        if (e2 == null) {
            AppMethodBeat.o(197120);
            return true;
        }
        AppMethodBeat.o(197120);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(com.tencent.mm.storagebase.f r5) {
        /*
            r2 = 0
            r1 = 0
            r4 = 197121(0x30201, float:2.76225E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.lang.String r0 = "select count(id) from ImgInfo2"
            android.database.Cursor r3 = r5.rawQuery(r0, r2, r1)
            r3.moveToFirst()     // Catch:{ Throwable -> 0x0020, all -> 0x003e }
            r0 = 0
            int r0 = r3.getInt(r0)     // Catch:{ Throwable -> 0x0020, all -> 0x003e }
            if (r3 == 0) goto L_0x001c
            r3.close()
        L_0x001c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r0
        L_0x0020:
            r0 = move-exception
            r1 = 197121(0x30201, float:2.76225E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)     // Catch:{ all -> 0x0028 }
            throw r0     // Catch:{ all -> 0x0028 }
        L_0x0028:
            r1 = move-exception
            r2 = r0
        L_0x002a:
            if (r3 == 0) goto L_0x0031
            if (r2 == 0) goto L_0x003a
            r3.close()     // Catch:{ Throwable -> 0x0035 }
        L_0x0031:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r1
        L_0x0035:
            r0 = move-exception
            r2.addSuppressed(r0)
            goto L_0x0031
        L_0x003a:
            r3.close()
            goto L_0x0031
        L_0x003e:
            r0 = move-exception
            r1 = r0
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.ab.a(com.tencent.mm.storagebase.f):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(com.tencent.mm.storagebase.f r5) {
        /*
            r2 = 0
            r1 = 0
            r4 = 197122(0x30202, float:2.76227E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.lang.String r0 = "select count(filename) from videoinfo2"
            android.database.Cursor r3 = r5.rawQuery(r0, r2, r1)
            r3.moveToFirst()     // Catch:{ Throwable -> 0x0020, all -> 0x003e }
            r0 = 0
            int r0 = r3.getInt(r0)     // Catch:{ Throwable -> 0x0020, all -> 0x003e }
            if (r3 == 0) goto L_0x001c
            r3.close()
        L_0x001c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r0
        L_0x0020:
            r0 = move-exception
            r1 = 197122(0x30202, float:2.76227E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)     // Catch:{ all -> 0x0028 }
            throw r0     // Catch:{ all -> 0x0028 }
        L_0x0028:
            r1 = move-exception
            r2 = r0
        L_0x002a:
            if (r3 == 0) goto L_0x0031
            if (r2 == 0) goto L_0x003a
            r3.close()     // Catch:{ Throwable -> 0x0035 }
        L_0x0031:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r1
        L_0x0035:
            r0 = move-exception
            r2.addSuppressed(r0)
            goto L_0x0031
        L_0x003a:
            r3.close()
            goto L_0x0031
        L_0x003e:
            r0 = move-exception
            r1 = r0
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.ab.b(com.tencent.mm.storagebase.f):int");
    }
}
