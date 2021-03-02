package com.tencent.mm.plugin.downloader_app.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadPendingReceive;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static Object lock = new Object();
    private static Map<String, Long> qKB = new HashMap();
    private static Map<String, Integer> qKC = new HashMap();

    static {
        AppMethodBeat.i(8839);
        AppMethodBeat.o(8839);
    }

    public static void l(a aVar) {
        int i2;
        boolean z = false;
        AppMethodBeat.i(8836);
        if (aVar == null) {
            Log.e("MicroMsg.DownloadNotificationManager", "updateNotification failed: null task info");
            AppMethodBeat.o(8836);
        } else if (!aVar.field_fromDownloadApp) {
            Log.i("MicroMsg.DownloadNotificationManager", "updateNotification not from download app");
            AppMethodBeat.o(8836);
        } else if (!aVar.field_autoDownload || aVar.field_status == 3) {
            if (aVar.field_totalSize > 0) {
                i2 = (int) ((aVar.field_downloadedSize * 100) / aVar.field_totalSize);
            } else {
                i2 = 0;
            }
            s.c cd = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id");
            Long l = qKB.get(aVar.field_downloadUrl);
            if (l == null) {
                l = Long.valueOf(System.currentTimeMillis());
                qKB.put(aVar.field_downloadUrl, l);
            }
            cd.i(l.longValue());
            if (!Util.isNullOrNil(aVar.field_notificationTitle)) {
                cd.f(aVar.field_notificationTitle);
            } else {
                cd.f(aVar.field_fileName);
            }
            switch (aVar.field_status) {
                case 1:
                    cd.as(com.tencent.mm.bq.a.ezb());
                    if (i2 == 0) {
                        i2 = 1;
                    }
                    if (i2 == 0) {
                        z = true;
                    }
                    cd.b(100, i2, z);
                    if (aVar.field_reserveInWifi) {
                        cd.g(MMApplicationContext.getContext().getString(R.string.cdq) + "·" + MMApplicationContext.getContext().getString(R.string.cdo));
                    } else {
                        cd.g(MMApplicationContext.getContext().getString(R.string.cdo));
                    }
                    cd.g(2, true);
                    cd.Hv = alr(aVar.field_appId);
                    break;
                case 2:
                    cancelNotification(aVar.field_downloadUrl);
                    AppMethodBeat.o(8836);
                    return;
                case 3:
                    cancelNotification(aVar.field_downloadUrl);
                    Context context = MMApplicationContext.getContext();
                    s.c cd2 = com.tencent.mm.bq.a.cd(context, "reminder_channel_id");
                    if (!Util.isNullOrNil(aVar.field_notificationTitle)) {
                        cd2.f(aVar.field_notificationTitle);
                    } else {
                        cd2.f(aVar.field_fileName);
                    }
                    cd2.as(com.tencent.mm.bq.a.ezb());
                    cd2.E(true);
                    Intent intent = new Intent();
                    Context context2 = MMApplicationContext.getContext();
                    intent.setClass(context2, FileDownloadPendingReceive.class);
                    intent.putExtra(FileDownloadService.qJa, 3);
                    intent.putExtra(FileDownloadService.qJb, aVar.field_filePath);
                    intent.putExtra(FileDownloadService.qJc, aVar.field_md5);
                    intent.putExtra("downloadId", aVar.field_downloadId);
                    cd2.Hv = PendingIntent.getBroadcast(context2, (int) System.currentTimeMillis(), intent, 0);
                    if (aVar.field_reserveInWifi) {
                        cd2.g(context.getString(R.string.bns));
                    } else if (aVar.field_autoDownload) {
                        if (!Util.isNullOrNil(aVar.field_notificationTitle)) {
                            cd2.f(aVar.field_notificationTitle + " · " + MMApplicationContext.getContext().getString(R.string.cdj));
                        } else {
                            cd2.f(aVar.field_fileName + " · " + MMApplicationContext.getContext().getString(R.string.cdj));
                        }
                        cd2.g(MMApplicationContext.getContext().getString(R.string.cdi));
                    } else {
                        cd2.g(context.getString(R.string.cdn));
                    }
                    ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(cd2.build());
                    AppMethodBeat.o(8836);
                    return;
                case 4:
                    cd.as(com.tencent.mm.bq.a.ezb());
                    cd.E(true);
                    cd.Hv = alr(aVar.field_appId);
                    if (aVar.field_errCode == com.tencent.mm.plugin.downloader.a.a.qFw || aVar.field_errCode == com.tencent.mm.plugin.downloader.a.a.qFs) {
                        cd.g(MMApplicationContext.getContext().getString(R.string.ff_));
                    } else if (!com.tencent.mm.plugin.downloader.model.a.Cl(aVar.field_downloadId)) {
                        cd.g(MMApplicationContext.getContext().getString(R.string.ff7));
                    } else if (com.tinkerboots.sdk.b.a.isWifi(MMApplicationContext.getContext())) {
                        cd.g(MMApplicationContext.getContext().getString(R.string.ff8));
                    } else {
                        cd.g(MMApplicationContext.getContext().getString(R.string.ff9));
                    }
                    cd.Hv = alr(aVar.field_appId);
                    break;
                case 5:
                    cancelNotification(aVar.field_downloadUrl);
                    AppMethodBeat.o(8836);
                    return;
                default:
                    cancelNotification(aVar.field_downloadUrl);
                    AppMethodBeat.o(8836);
                    return;
            }
            synchronized (lock) {
                try {
                    Integer num = qKC.get(aVar.field_downloadUrl);
                    if (num == null) {
                        qKC.put(aVar.field_downloadUrl, Integer.valueOf(((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(cd.build())));
                    } else {
                        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(num.intValue(), cd.build());
                    }
                    if (aVar.field_status == 4) {
                        qKC.remove(aVar.field_downloadUrl);
                        qKB.remove(aVar.field_downloadUrl);
                    }
                } finally {
                    AppMethodBeat.o(8836);
                }
            }
        } else {
            AppMethodBeat.o(8836);
        }
    }

    private static void cancelNotification(String str) {
        AppMethodBeat.i(8837);
        synchronized (lock) {
            try {
                Integer num = qKC.get(str);
                if (num == null) {
                    Log.i("MicroMsg.DownloadNotificationManager", "No notification id found");
                    return;
                }
                ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(num.intValue());
                Log.i("MicroMsg.DownloadNotificationManager", "cancelNotification, id = ".concat(String.valueOf(num)));
                qKC.remove(str);
                qKB.remove(str);
                AppMethodBeat.o(8837);
            } finally {
                AppMethodBeat.o(8837);
            }
        }
    }

    private static PendingIntent alr(String str) {
        AppMethodBeat.i(8838);
        Intent intent = new Intent(MMApplicationContext.getContext(), DownloadMainUI.class);
        intent.putExtra("appId", str);
        intent.putExtra("view_task", true);
        intent.putExtra("from_scene", 1);
        PendingIntent activity = PendingIntent.getActivity(MMApplicationContext.getContext(), (int) System.currentTimeMillis(), intent, 0);
        AppMethodBeat.o(8838);
        return activity;
    }
}
