package com.tencent.wcdb.repair;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.support.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DBDumpUtil {
    private static final String TAG = "WCDB.DBDumpUtil";

    public interface ExecuteSqlCallback {
        String preExecute(String str);
    }

    private static native boolean nativeDumpDB(String str, String str2, String str3);

    private static native boolean nativeIsSqlComplete(String str);

    public static boolean doRecoveryDb(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        AppMethodBeat.i(3334);
        boolean doRecoveryDb = doRecoveryDb(sQLiteDatabase, str, str2, str3, null, null, null, true);
        AppMethodBeat.o(3334);
        return doRecoveryDb;
    }

    public static boolean doRecoveryDb(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, List<String> list, List<String> list2, ExecuteSqlCallback executeSqlCallback, boolean z) {
        String str4;
        String str5;
        int i2;
        AppMethodBeat.i(3335);
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            Log.w(TAG, "Database is not open");
            AppMethodBeat.o(3335);
            return false;
        } else if (!nativeDumpDB(str, str2, str3)) {
            AppMethodBeat.o(3335);
            return false;
        } else {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(str3));
                sQLiteDatabase.execSQL("PRAGMA foreign_keys=OFF;");
                sQLiteDatabase.beginTransaction();
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                try {
                    HashMap hashMap = new HashMap();
                    boolean z2 = false;
                    String str6 = null;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (z2) {
                                str4 = str6 + "\n" + readLine;
                                if (!str4.endsWith(";")) {
                                    str6 = str4;
                                } else if (!nativeIsSqlComplete(str4)) {
                                    str6 = str4;
                                }
                            } else if (readLine.startsWith("INSERT") || readLine.startsWith("CREATE TABLE")) {
                                if (!readLine.endsWith(";") || !nativeIsSqlComplete(readLine)) {
                                    if (!TextUtils.isEmpty(str6)) {
                                        readLine = str6 + "\n" + readLine;
                                    }
                                    z2 = true;
                                    str6 = readLine;
                                } else {
                                    str4 = readLine;
                                }
                            }
                            boolean z3 = false;
                            if (list2 == null || list2.size() <= 0) {
                                if (list != null && list.size() > 0) {
                                    str5 = getTableNameFromSql(str4);
                                    Iterator<String> it = list.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            if (str5.equals(it.next())) {
                                                z3 = true;
                                                str4 = "";
                                                break;
                                            }
                                        } else {
                                            z3 = false;
                                            break;
                                        }
                                    }
                                } else {
                                    str5 = null;
                                }
                            } else {
                                str5 = getTableNameFromSql(str4);
                                Iterator<String> it2 = list2.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        if (str5.equals(it2.next())) {
                                            z3 = false;
                                            break;
                                        }
                                    } else {
                                        z3 = true;
                                        break;
                                    }
                                }
                            }
                            if (z3) {
                                Log.i(TAG, "filter table %s", str5);
                                z2 = false;
                                str6 = str4;
                            } else {
                                try {
                                    if (str4.startsWith("CREATE TABLE")) {
                                        hashMap.put(str5, buildColumnsString(getColumnNamesFromSql(str4)));
                                    } else if (str4.startsWith("INSERT INTO")) {
                                        String str7 = (String) hashMap.get(str5);
                                        if (!TextUtils.isEmpty(str7)) {
                                            StringBuilder sb = new StringBuilder("INSERT INTO ");
                                            sb.append("\"").append(str5).append("\"");
                                            String sb2 = sb.toString();
                                            sb.append(str7);
                                            str4 = str4.replace(sb2, sb.toString());
                                        }
                                    }
                                    String str8 = null;
                                    if (executeSqlCallback != null) {
                                        str8 = executeSqlCallback.preExecute(str4);
                                    }
                                    if (TextUtils.isEmpty(str8)) {
                                        str8 = str4;
                                    }
                                    i4++;
                                    sQLiteDatabase.execSQL(str8);
                                    i2 = i5 + 1;
                                    if (i2 >= 100) {
                                        try {
                                            sQLiteDatabase.setTransactionSuccessful();
                                            sQLiteDatabase.endTransaction();
                                            sQLiteDatabase.beginTransaction();
                                            i2 = 0;
                                        } catch (Exception e2) {
                                            i3++;
                                            z2 = false;
                                            str6 = null;
                                            i5 = i2;
                                        }
                                    }
                                } catch (Exception e3) {
                                    i2 = i5;
                                    i3++;
                                    z2 = false;
                                    str6 = null;
                                    i5 = i2;
                                }
                                z2 = false;
                                str6 = null;
                                i5 = i2;
                            }
                        } else {
                            try {
                                break;
                            } catch (IOException e4) {
                            }
                        }
                    }
                    bufferedReader.close();
                    if (i4 > i3) {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.setTransactionSuccessful();
                        }
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                        if (z) {
                            File file = new File(str3);
                            if (file.exists()) {
                                file.delete();
                            }
                            File file2 = new File(str);
                            if (file2.exists()) {
                                file2.delete();
                            }
                        }
                        Log.i(TAG, "restore : %d , fail:%d ", Integer.valueOf(i4), Integer.valueOf(i3));
                        AppMethodBeat.o(3335);
                        return true;
                    }
                    AppMethodBeat.o(3335);
                    return false;
                } catch (IOException e5) {
                    Log.w(TAG, "I/O error in read sql file ");
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                    }
                    AppMethodBeat.o(3335);
                    return false;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                    }
                    AppMethodBeat.o(3335);
                    throw th;
                }
            } catch (FileNotFoundException e8) {
                Log.w(TAG, "SQL file '%s' not found", str3);
                AppMethodBeat.o(3335);
                return false;
            }
        }
    }

    public static String buildColumnsString(ArrayList<String> arrayList) {
        AppMethodBeat.i(3336);
        if (arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.o(3336);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            sb.append(arrayList.get(i2));
            if (i2 != arrayList.size() - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        String sb2 = sb.toString();
        System.out.println(sb2);
        AppMethodBeat.o(3336);
        return sb2;
    }

    public static String getTableNameFromSql(String str) {
        AppMethodBeat.i(3337);
        if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        String[] split = str.split("\\s");
        if (split == null || split.length <= 1) {
            AppMethodBeat.o(3337);
            return null;
        }
        String replaceAll = split[2].replaceAll("\"", "");
        AppMethodBeat.o(3337);
        return replaceAll;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0066 A[SYNTHETIC, Splitter:B:18:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a A[SYNTHETIC, Splitter:B:24:0x007a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFromFile(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wcdb.repair.DBDumpUtil.readFromFile(java.lang.String):byte[]");
    }

    public static ArrayList<String> getColumnNamesFromSql(String str) {
        AppMethodBeat.i(3339);
        ArrayList<String> arrayList = new ArrayList<>();
        String[] split = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")")).trim().split(",");
        for (int i2 = 0; i2 < split.length; i2++) {
            split[i2] = split[i2].trim();
            arrayList.add(split[i2].substring(0, split[i2].indexOf(" ")));
        }
        AppMethodBeat.o(3339);
        return arrayList;
    }
}
