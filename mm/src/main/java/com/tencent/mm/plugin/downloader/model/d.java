package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d {
    public static a Cw(long j2) {
        AppMethodBeat.i(88951);
        b aSU = aSU();
        if (aSU == null) {
            AppMethodBeat.o(88951);
            return null;
        }
        a CH = aSU.CH(j2);
        AppMethodBeat.o(88951);
        return CH;
    }

    public static a alb(String str) {
        AppMethodBeat.i(88952);
        b aSU = aSU();
        if (aSU == null) {
            AppMethodBeat.o(88952);
            return null;
        }
        a alb = aSU.alb(str);
        AppMethodBeat.o(88952);
        return alb;
    }

    public static long d(a aVar) {
        AppMethodBeat.i(88953);
        if (aVar == null) {
            AppMethodBeat.o(88953);
            return -1;
        }
        b aSU = aSU();
        if (aSU == null) {
            AppMethodBeat.o(88953);
            return -1;
        }
        ald(aVar.field_appId);
        alc(aVar.field_downloadUrl);
        ald(aVar.field_rawAppId);
        aVar.field_updateTime = System.currentTimeMillis();
        Log.i("MicroMsg.FileDownloadInfoDBHelper", "insert downloadinfo: " + aVar.field_downloadId + ", ret=" + aSU.insert(aVar));
        long j2 = aVar.field_downloadId;
        AppMethodBeat.o(88953);
        return j2;
    }

    public static long e(a aVar) {
        AppMethodBeat.i(88954);
        if (aVar == null) {
            AppMethodBeat.o(88954);
            return -1;
        }
        b aSU = aSU();
        if (aSU == null) {
            AppMethodBeat.o(88954);
            return -1;
        }
        aVar.field_updateTime = System.currentTimeMillis();
        Log.i("MicroMsg.FileDownloadInfoDBHelper", "Update Downloadinfo, ID: %d, ret: %b, Status: %d", Long.valueOf(aVar.field_downloadId), Boolean.valueOf(aSU.update(aVar, new String[0])), Integer.valueOf(aVar.field_status));
        long j2 = aVar.field_downloadId;
        AppMethodBeat.o(88954);
        return j2;
    }

    public static boolean cW(String str, int i2) {
        AppMethodBeat.i(88955);
        b aSU = aSU();
        if (aSU == null) {
            AppMethodBeat.o(88955);
            return false;
        }
        boolean cW = aSU.cW(str, i2);
        AppMethodBeat.o(88955);
        return cW;
    }

    public static boolean alc(String str) {
        AppMethodBeat.i(88956);
        Log.i("MicroMsg.FileDownloadInfoDBHelper", "removeDownloadInfoByURLIfExist url: [%s]", str);
        b aSU = aSU();
        if (aSU == null) {
            AppMethodBeat.o(88956);
            return false;
        }
        boolean alc = aSU.alc(str);
        AppMethodBeat.o(88956);
        return alc;
    }

    public static boolean ald(String str) {
        AppMethodBeat.i(88957);
        Log.i("MicroMsg.FileDownloadInfoDBHelper", "removeDownloadInfoByAppIdIfExist id: [%s]", str);
        b aSU = aSU();
        if (aSU == null) {
            AppMethodBeat.o(88957);
            return false;
        }
        boolean ald = aSU.ald(str);
        AppMethodBeat.o(88957);
        return ald;
    }

    public static a ale(String str) {
        AppMethodBeat.i(88958);
        b aSU = aSU();
        if (aSU == null) {
            AppMethodBeat.o(88958);
            return null;
        }
        a ale = aSU.ale(str);
        AppMethodBeat.o(88958);
        return ale;
    }

    public static boolean Cx(long j2) {
        AppMethodBeat.i(88959);
        Log.i("MicroMsg.FileDownloadInfoDBHelper", "removeDownloadInfo id: [%s]", Long.valueOf(j2));
        b aSU = aSU();
        if (aSU == null) {
            AppMethodBeat.o(88959);
            return false;
        }
        a aVar = new a();
        aVar.field_downloadId = j2;
        boolean delete = aSU.delete(aVar, new String[0]);
        AppMethodBeat.o(88959);
        return delete;
    }

    public static LinkedList<a> cBs() {
        AppMethodBeat.i(88960);
        b aSU = aSU();
        if (aSU == null) {
            AppMethodBeat.o(88960);
            return null;
        }
        Log.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiRunningTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status=1 and downloadInWifi=1")));
        Cursor rawQuery = aSU.rawQuery("select * from FileDownloadInfo where status=1 and downloadInWifi=1", new String[0]);
        LinkedList<a> linkedList = new LinkedList<>();
        if (rawQuery == null) {
            AppMethodBeat.o(88960);
            return linkedList;
        }
        while (rawQuery.moveToNext()) {
            a aVar = new a();
            aVar.convertFrom(rawQuery);
            linkedList.add(aVar);
        }
        rawQuery.close();
        AppMethodBeat.o(88960);
        return linkedList;
    }

    public static LinkedList<a> cBt() {
        AppMethodBeat.i(192257);
        b aSU = aSU();
        if (aSU == null) {
            AppMethodBeat.o(192257);
            return null;
        }
        LinkedList<a> cBt = aSU.cBt();
        AppMethodBeat.o(192257);
        return cBt;
    }

    public static b aSU() {
        AppMethodBeat.i(88961);
        if (g.aAf().azp()) {
            g.aAf();
            if (!com.tencent.mm.kernel.a.azj()) {
                if (g.af(com.tencent.mm.plugin.downloader.a.d.class) == null) {
                    Log.e("MicroMsg.FileDownloadInfoDBHelper", "service not ready");
                    AppMethodBeat.o(88961);
                    return null;
                }
                b aSU = ((com.tencent.mm.plugin.downloader.a.d) g.af(com.tencent.mm.plugin.downloader.a.d.class)).aSU();
                AppMethodBeat.o(88961);
                return aSU;
            }
        }
        Log.e("MicroMsg.FileDownloadInfoDBHelper", "no user login");
        AppMethodBeat.o(88961);
        return null;
    }

    public static LinkedList<a> cBu() {
        AppMethodBeat.i(88962);
        b aSU = aSU();
        if (aSU == null) {
            AppMethodBeat.o(88962);
            return null;
        }
        String format = String.format("select * from %s where %s<%d order by %s desc", "FileDownloadInfo", ch.COL_UPDATETIME, Long.valueOf(System.currentTimeMillis() - 604800000), ch.COL_UPDATETIME);
        Log.i("MicroMsg.FileDownloadInfoStorage", "getUpdateTimeBiggerThanTimeInterval, sql = ".concat(String.valueOf(format)));
        Cursor rawQuery = aSU.rawQuery(format, new String[0]);
        LinkedList<a> linkedList = new LinkedList<>();
        if (rawQuery == null) {
            AppMethodBeat.o(88962);
            return linkedList;
        }
        while (rawQuery.moveToNext()) {
            a aVar = new a();
            aVar.convertFrom(rawQuery);
            linkedList.add(aVar);
        }
        rawQuery.close();
        AppMethodBeat.o(88962);
        return linkedList;
    }

    public static boolean alf(String str) {
        AppMethodBeat.i(88963);
        b aSU = aSU();
        if (aSU == null) {
            AppMethodBeat.o(88963);
            return false;
        }
        boolean alf = aSU.alf(str);
        AppMethodBeat.o(88963);
        return alf;
    }
}
