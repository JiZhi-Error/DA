package com.tencent.mm.plugin.downloader;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class b implements a, d, com.tencent.mm.plugin.downloader.a.d {
    private com.tencent.mm.plugin.downloader.g.b qFb;
    private long qFc = 0;

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseOpened(h hVar, h hVar2) {
        AppMethodBeat.i(88816);
        this.qFb = new com.tencent.mm.plugin.downloader.g.b(hVar);
        AppMethodBeat.o(88816);
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    @Override // com.tencent.mm.plugin.downloader.a.d
    public final com.tencent.mm.plugin.downloader.g.b aSU() {
        AppMethodBeat.i(88817);
        g.aAi();
        g.aAf().azk();
        com.tencent.mm.plugin.downloader.g.b bVar = this.qFb;
        AppMethodBeat.o(88817);
        return bVar;
    }

    @Override // com.tencent.mm.kernel.api.a
    public final HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(88818);
        Log.d("MicroMsg.FileDownloaderService", "collectDatabaseFactory");
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("FILEDOWNLOAD_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.downloader.b.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.downloader.g.b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(88818);
        return hashMap;
    }

    @Override // com.tencent.mm.plugin.downloader.a.d
    public final void kR(boolean z) {
        AppMethodBeat.i(88819);
        Log.i("MicroMsg.FileDownloaderService", "active: ".concat(String.valueOf(z)));
        if (!z && (System.currentTimeMillis() - this.qFc) / 1000 > 1800) {
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.downloader.b.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(88815);
                    b.cBl();
                    AppMethodBeat.o(88815);
                }
            }, "checkDownloadFile");
            this.qFc = System.currentTimeMillis();
        }
        AppMethodBeat.o(88819);
    }

    static /* synthetic */ void cBl() {
        int i2;
        boolean z;
        boolean z2;
        AppMethodBeat.i(88820);
        LinkedList<com.tencent.mm.plugin.downloader.g.a> cBt = com.tencent.mm.plugin.downloader.model.d.cBt();
        if (!Util.isNullOrNil(cBt)) {
            Iterator<com.tencent.mm.plugin.downloader.g.a> it = cBt.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.downloader.g.a next = it.next();
                long currentTimeMillis = (System.currentTimeMillis() - next.field_updateTime) / 1000;
                if (s.YS(next.field_filePath)) {
                    i2 = next.field_totalSize > 0 ? (int) ((next.field_downloadedSize * 100) / next.field_totalSize) : 0;
                } else {
                    i2 = 0;
                }
                if (next.field_status != 1) {
                    Log.d("MicroMsg.FileDownloaderService", "freeSpace : %d", Long.valueOf(Environment.getExternalStorageDirectory().getFreeSpace()));
                    if (Environment.getExternalStorageDirectory().getFreeSpace() <= 2147483648L) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (currentTimeMillis >= 2592000) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(710, 20, 1, false);
                        z2 = true;
                    } else {
                        if (z) {
                            Log.d("MicroMsg.FileDownloaderService", "less than 2G, interval : %d, percent : %d", Long.valueOf(currentTimeMillis), Integer.valueOf(i2));
                            if (currentTimeMillis >= 604800 && i2 <= 10) {
                                Log.d("MicroMsg.FileDownloaderService", "one week");
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(710, 21, 1, false);
                                z2 = true;
                            } else if (currentTimeMillis >= 172800 && i2 <= 2) {
                                Log.d("MicroMsg.FileDownloaderService", "two day");
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(710, 22, 1, false);
                                z2 = true;
                            }
                        }
                        z2 = false;
                    }
                    if (z2) {
                        s.deleteFile(next.field_filePath);
                        com.tencent.mm.plugin.downloader.model.d.Cx(next.field_downloadId);
                        ((c) g.af(c.class)).EN(next.field_appId);
                    }
                    Log.i("MicroMsg.FileDownloaderService", "checkRemovedDownloadFile, appId: %s, interval: %d, percent: %d, delete: %b, path : %s", next.field_appId, Long.valueOf(currentTimeMillis), Integer.valueOf(i2), Boolean.valueOf(z2), next.field_filePath);
                }
            }
        }
        AppMethodBeat.o(88820);
    }
}
