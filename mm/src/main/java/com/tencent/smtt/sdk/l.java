package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import java.io.File;
import java.util.ArrayList;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2085a = CookieManager.LOGTAG;

    /* renamed from: b  reason: collision with root package name */
    static File f2086b;

    public static File a(Context context) {
        AppMethodBeat.i(188249);
        if (f2086b == null && context != null) {
            f2086b = new File(context.getDir("webview", 0), "Cookies");
        }
        if (f2086b == null) {
            f2086b = new File("/data/data/" + context.getPackageName() + File.separator + "app_webview" + File.separator + "Cookies");
        }
        File file = f2086b;
        AppMethodBeat.o(188249);
        return file;
    }

    public static boolean b(Context context) {
        AppMethodBeat.i(188250);
        if (context == null) {
            AppMethodBeat.o(188250);
            return false;
        }
        f.a(a(context), false);
        AppMethodBeat.o(188250);
        return true;
    }

    public static SQLiteDatabase c(Context context) {
        SQLiteDatabase sQLiteDatabase = null;
        AppMethodBeat.i(188251);
        if (context == null) {
            AppMethodBeat.o(188251);
        } else {
            File a2 = a(context);
            if (a2 == null) {
                AppMethodBeat.o(188251);
            } else {
                try {
                    sQLiteDatabase = SQLiteDatabase.openDatabase(a2.getAbsolutePath(), null, 0);
                } catch (Exception e2) {
                }
                if (sQLiteDatabase == null) {
                    TbsLog.i(f2085a, "dbPath is not exist!");
                }
                AppMethodBeat.o(188251);
            }
        }
        return sQLiteDatabase;
    }

    public static ArrayList<String> a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        AppMethodBeat.i(188252);
        if (sQLiteDatabase == null) {
            AppMethodBeat.o(188252);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
            new StringBuilder("db version:").append(sQLiteDatabase.getVersion());
            if (rawQuery.moveToFirst()) {
                do {
                    String string = rawQuery.getString(1);
                    String string2 = rawQuery.getString(4);
                    arrayList.add(string);
                    new StringBuilder("tablename:").append(string).append("->").append(string2);
                    a(sQLiteDatabase, string);
                } while (rawQuery.moveToNext());
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
            AppMethodBeat.o(188252);
            throw th;
        }
        AppMethodBeat.o(188252);
        return arrayList;
    }

    private static String a(SQLiteDatabase sQLiteDatabase, String str) {
        AppMethodBeat.i(188253);
        Cursor rawQuery = sQLiteDatabase.rawQuery("select * from ".concat(String.valueOf(str)), null);
        int count = rawQuery.getCount();
        int columnCount = rawQuery.getColumnCount();
        StringBuilder sb = new StringBuilder();
        sb.append("raws:" + count + ",columns:" + columnCount + "\n");
        if (count <= 0 || !rawQuery.moveToFirst()) {
            String sb2 = sb.toString();
            AppMethodBeat.o(188253);
            return sb2;
        }
        do {
            sb.append("\n");
            for (int i2 = 0; i2 < columnCount; i2++) {
                try {
                    sb.append(rawQuery.getString(i2)).append(",");
                } catch (Exception e2) {
                }
            }
            sb.append("\n");
        } while (rawQuery.moveToNext());
        String sb22 = sb.toString();
        AppMethodBeat.o(188253);
        return sb22;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int d(android.content.Context r9) {
        /*
        // Method dump skipped, instructions count: 202
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.l.d(android.content.Context):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0095, code lost:
        if (r0 != false) goto L_0x0097;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0181  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r12, com.tencent.smtt.sdk.CookieManager.a r13, java.lang.String r14, boolean r15, boolean r16) {
        /*
        // Method dump skipped, instructions count: 518
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.l.a(android.content.Context, com.tencent.smtt.sdk.CookieManager$a, java.lang.String, boolean, boolean):void");
    }
}
