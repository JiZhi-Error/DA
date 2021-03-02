package com.tencent.mm.plugin.downloader.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;

public final class b extends MAutoStorage<a> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "FileDownloadInfo"), "CREATE INDEX IF NOT EXISTS filedownloadinfo_appId  on FileDownloadInfo  (  appId )", "CREATE INDEX IF NOT EXISTS filedownloadinfo_status  on FileDownloadInfo  (  status )"};

    static {
        AppMethodBeat.i(89097);
        AppMethodBeat.o(89097);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "FileDownloadInfo", null);
    }

    public final a alb(String str) {
        a aVar = null;
        AppMethodBeat.i(89088);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FileDownloadInfoStorage", "appId is null");
            AppMethodBeat.o(89088);
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where appId=\"" + str + "\" or rawAppId=\"" + str + "\"", new String[0]);
            if (rawQuery == null) {
                AppMethodBeat.o(89088);
            } else {
                if (rawQuery.moveToFirst()) {
                    aVar = new a();
                    aVar.convertFrom(rawQuery);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(89088);
            }
        }
        return aVar;
    }

    public static String W(LinkedList<String> linkedList) {
        AppMethodBeat.i(89089);
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(89089);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i2 = 0; i2 < linkedList.size() - 2; i2++) {
            sb.append("\"").append(linkedList.get(i2)).append("\",");
        }
        sb.append("\"").append(linkedList.get(linkedList.size() - 1)).append("\")");
        String sb2 = sb.toString();
        AppMethodBeat.o(89089);
        return sb2;
    }

    public final a CH(long j2) {
        a aVar = null;
        AppMethodBeat.i(89090);
        if (j2 < 0) {
            Log.e("MicroMsg.FileDownloadInfoStorage", "download id is not avaiable");
            AppMethodBeat.o(89090);
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where downloadId=".concat(String.valueOf(j2)), new String[0]);
            if (rawQuery == null) {
                AppMethodBeat.o(89090);
            } else {
                if (rawQuery.moveToFirst()) {
                    aVar = new a();
                    aVar.convertFrom(rawQuery);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(89090);
            }
        }
        return aVar;
    }

    public final a ale(String str) {
        a aVar = null;
        AppMethodBeat.i(89091);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FileDownloadInfoStorage", "Null or nil url");
            AppMethodBeat.o(89091);
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where downloadUrl=\"" + str + "\"", new String[0]);
            if (rawQuery == null) {
                AppMethodBeat.o(89091);
            } else {
                if (rawQuery.moveToFirst()) {
                    aVar = new a();
                    aVar.convertFrom(rawQuery);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(89091);
            }
        }
        return aVar;
    }

    public final boolean cBL() {
        AppMethodBeat.i(89092);
        boolean execSQL = execSQL("FileDownloadInfo", "delete from FileDownloadInfo");
        AppMethodBeat.o(89092);
        return execSQL;
    }

    public final boolean alc(String str) {
        AppMethodBeat.i(89093);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, url is null");
            AppMethodBeat.o(89093);
            return false;
        }
        boolean execSQL = execSQL("FileDownloadInfo", "delete from FileDownloadInfo where downloadUrl=\"" + str + "\"");
        AppMethodBeat.o(89093);
        return execSQL;
    }

    public final boolean ald(String str) {
        AppMethodBeat.i(89094);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, appId is null");
            AppMethodBeat.o(89094);
            return false;
        }
        boolean execSQL = execSQL("FileDownloadInfo", "delete from FileDownloadInfo where appId=\"" + str + "\" or rawAppId=\"" + str + "\"");
        AppMethodBeat.o(89094);
        return execSQL;
    }

    public final LinkedList<a> cBt() {
        AppMethodBeat.i(192273);
        Log.i("MicroMsg.FileDownloadInfoStorage", "getAllTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo")));
        Cursor rawQuery = rawQuery("select * from FileDownloadInfo", new String[0]);
        LinkedList<a> linkedList = new LinkedList<>();
        if (rawQuery == null) {
            AppMethodBeat.o(192273);
        } else {
            while (rawQuery.moveToNext()) {
                a aVar = new a();
                aVar.convertFrom(rawQuery);
                linkedList.add(aVar);
            }
            rawQuery.close();
            AppMethodBeat.o(192273);
        }
        return linkedList;
    }

    public final boolean cW(String str, int i2) {
        AppMethodBeat.i(89095);
        String format = String.format("update %s set %s=%d where %s=\"%s\"", "FileDownloadInfo", "status", Integer.valueOf(i2), "downloadUrl", str);
        boolean execSQL = execSQL("FileDownloadInfo", format);
        Log.i("MicroMsg.FileDownloadInfoStorage", "updateDownloadState, sql : %s\ndownloadUrl : %s, status : %d, ret : %s", format, str, Integer.valueOf(i2), Boolean.valueOf(execSQL));
        AppMethodBeat.o(89095);
        return execSQL;
    }

    public final boolean alf(String str) {
        AppMethodBeat.i(89096);
        Cursor rawQuery = rawQuery(String.format("select count(*) from %s where %s=\"%s\"", "FileDownloadInfo", "downloadUrl", str), new String[0]);
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            AppMethodBeat.o(89096);
            return false;
        }
        int i2 = rawQuery.getInt(0);
        rawQuery.close();
        if (i2 > 1) {
            AppMethodBeat.o(89096);
            return true;
        }
        AppMethodBeat.o(89096);
        return false;
    }
}
