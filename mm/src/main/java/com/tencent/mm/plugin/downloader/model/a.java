package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    private static final HashMap<Long, Integer> qHY = new HashMap<>();
    private static HashSet<Long> qHZ = new HashSet<>();

    static {
        AppMethodBeat.i(88906);
        AppMethodBeat.o(88906);
    }

    public static boolean Cl(long j2) {
        AppMethodBeat.i(88903);
        if (System.currentTimeMillis() - j2 <= 259200000) {
            AppMethodBeat.o(88903);
            return true;
        }
        AppMethodBeat.o(88903);
        return false;
    }

    public static boolean Cm(final long j2) {
        boolean z;
        AppMethodBeat.i(88904);
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()) && Cl(j2) && qHZ.contains(Long.valueOf(j2))) {
            if (!qHY.containsKey(Long.valueOf(j2)) || qHY.get(Long.valueOf(j2)).intValue() < 2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                h.RTc.o(new Runnable() {
                    /* class com.tencent.mm.plugin.downloader.model.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(88902);
                        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
                        if (Cw != null && a.uF(Cw.field_status)) {
                            f.cBv().h(Cw);
                        }
                        a.qHY.put(Long.valueOf(j2), Integer.valueOf(Util.nullAs((Integer) a.qHY.get(Long.valueOf(j2)), 0) + 1));
                        AppMethodBeat.o(88902);
                    }
                }, 300000);
                AppMethodBeat.o(88904);
                return true;
            }
        }
        AppMethodBeat.o(88904);
        return false;
    }

    public static void cBp() {
        LinkedList linkedList;
        boolean z;
        g cX;
        AppMethodBeat.i(88905);
        qHZ.clear();
        b aSU = d.aSU();
        if (aSU == null) {
            linkedList = null;
        } else {
            Log.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status=4")));
            Cursor rawQuery = aSU.rawQuery("select * from FileDownloadInfo where status=4", new String[0]);
            linkedList = new LinkedList();
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    com.tencent.mm.plugin.downloader.g.a aVar = new com.tencent.mm.plugin.downloader.g.a();
                    aVar.convertFrom(rawQuery);
                    linkedList.add(aVar);
                }
                rawQuery.close();
            }
        }
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(88905);
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.downloader.g.a aVar2 = (com.tencent.mm.plugin.downloader.g.a) it.next();
            if (d.alf(aVar2.field_downloadUrl)) {
                Log.i("MicroMsg.DownloadRetry", "hasDuplicatedTask");
                d.alc(aVar2.field_downloadUrl);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(710, 26, 1, false);
            } else if (aVar2.field_downloaderType == 3 && s.YS(aVar2.field_filePath)) {
                int i2 = aVar2.field_errCode;
                if (i2 == com.tencent.mm.plugin.downloader.a.a.qFs || i2 == com.tencent.mm.plugin.downloader.a.a.qFw || i2 == com.tencent.mm.plugin.downloader.a.a.qFv) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z && (cX = com.tencent.mm.pluginsdk.model.app.h.cX(aVar2.field_appId, false)) != null && cX.NA() && Cl(aVar2.field_downloadId)) {
                    aVar2.field_downloadType = 3;
                    d.e(aVar2);
                    f.cBv().h(aVar2);
                    qHZ.add(Long.valueOf(aVar2.field_downloadId));
                    qHY.put(Long.valueOf(aVar2.field_downloadId), 1);
                }
            }
        }
        AppMethodBeat.o(88905);
    }

    static /* synthetic */ boolean uF(int i2) {
        return i2 == 4;
    }
}
