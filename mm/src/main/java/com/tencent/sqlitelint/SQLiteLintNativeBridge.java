package com.tencent.sqlitelint;

import android.database.Cursor;
import android.database.SQLException;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.util.SLog;
import java.util.ArrayList;

public class SQLiteLintNativeBridge {
    private static final String TAG = "SQLiteLint.SQLiteLintNativeBridge";

    private native void execSqlCallback(long j2, long j3, String str, int i2, String[] strArr, String[] strArr2);

    public static native void nativeAddToWhiteList(String str, String[] strArr, String[][] strArr2);

    public static native void nativeEnableCheckers(String str, String[] strArr);

    static native void nativeInstall(String str);

    static native void nativeNotifySqlExecute(String str, String str2, long j2, String str3);

    static native void nativeUninstall(String str);

    public static void loadLibrary() {
        AppMethodBeat.i(52863);
        System.loadLibrary("SqliteLint-lib");
        SLog.nativeSetLogger(2);
        AppMethodBeat.o(52863);
    }

    SQLiteLintNativeBridge() {
    }

    private static void onPublishIssue(String str, ArrayList<SQLiteLintIssue> arrayList) {
        AppMethodBeat.i(52864);
        try {
            SQLiteLintAndroidCoreManager.INSTANCE.get(str).onPublish(arrayList);
            AppMethodBeat.o(52864);
        } catch (Throwable th) {
            SLog.e(TAG, "onPublishIssue ex ", th.getMessage());
            AppMethodBeat.o(52864);
        }
    }

    private String[] sqliteLintExecSql(String str, String str2, boolean z, long j2, long j3) {
        AppMethodBeat.i(52865);
        String[] strArr = new String[2];
        try {
            SLog.i(TAG, "dbPath %s, sql is %s ,needCallBack: %b", str, str2, Boolean.valueOf(z));
            strArr[0] = "";
            strArr[1] = "-1";
            ISQLiteExecutionDelegate iSQLiteExecutionDelegate = null;
            SQLiteLintAndroidCore sQLiteLintAndroidCore = SQLiteLintAndroidCoreManager.INSTANCE.get(str);
            if (sQLiteLintAndroidCore != null) {
                iSQLiteExecutionDelegate = sQLiteLintAndroidCore.getSQLiteExecutionDelegate();
            }
            if (iSQLiteExecutionDelegate == null) {
                SLog.w(TAG, "sqliteLintExecSql mExecSqlImp is null", new Object[0]);
                AppMethodBeat.o(52865);
                return strArr;
            }
            if (z) {
                try {
                    Cursor rawQuery = iSQLiteExecutionDelegate.rawQuery(str2, new String[0]);
                    if (rawQuery == null || rawQuery.getCount() < 0) {
                        SLog.w(TAG, "sqliteLintExecSql cu is null", new Object[0]);
                        strArr[0] = "Cursor is null";
                    } else {
                        doExecSqlCallback(j2, j3, str, rawQuery);
                        strArr[1] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } catch (Exception e2) {
                    SLog.w(TAG, "sqliteLintExecSql rawQuery exp: %s", e2.getMessage());
                    strArr[0] = e2.getMessage();
                }
            } else {
                try {
                    iSQLiteExecutionDelegate.execSQL(str2);
                    strArr[1] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                } catch (SQLException e3) {
                    SLog.w(TAG, "sqliteLintExecSql execSQL exp: %s", e3.getMessage());
                    strArr[0] = e3.getMessage();
                }
            }
            AppMethodBeat.o(52865);
            return strArr;
        } catch (Throwable th) {
            SLog.e(TAG, "sqliteLintExecSql ex ", th.getMessage());
        }
    }

    private void doExecSqlCallback(long j2, long j3, String str, Cursor cursor) {
        AppMethodBeat.i(52866);
        if (cursor == null) {
            SLog.w(TAG, "doExecSqlCallback cu is null", new Object[0]);
            AppMethodBeat.o(52866);
            return;
        }
        while (cursor.moveToNext()) {
            int columnCount = cursor.getColumnCount();
            String[] strArr = new String[columnCount];
            String[] strArr2 = new String[columnCount];
            for (int i2 = 0; i2 < columnCount; i2++) {
                strArr[i2] = cursor.getColumnName(i2);
                switch (cursor.getType(i2)) {
                    case 1:
                        strArr2[i2] = String.valueOf(cursor.getLong(i2));
                        break;
                    case 2:
                        strArr2[i2] = String.valueOf(cursor.getFloat(i2));
                        break;
                    case 3:
                        strArr2[i2] = String.valueOf(cursor.getString(i2));
                        break;
                    case 4:
                        strArr2[i2] = String.valueOf(cursor.getBlob(i2));
                        break;
                    default:
                        strArr2[i2] = "";
                        break;
                }
            }
            execSqlCallback(j2, j3, str, columnCount, strArr2, strArr);
        }
        AppMethodBeat.o(52866);
    }
}
