package com.tencent.mm.plugin.downloader.model;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.b.q;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class h {
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0091 A[SYNTHETIC, Splitter:B:27:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ac A[SYNTHETIC, Splitter:B:35:0x00ac] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String alp(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 204
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.downloader.model.h.alp(java.lang.String):java.lang.String");
    }

    public static a c(g gVar) {
        AppMethodBeat.i(89016);
        a aVar = new a();
        aVar.field_downloadUrl = gVar.kMX;
        aVar.field_secondaryUrl = gVar.qIE;
        aVar.field_fileSize = gVar.mFileSize;
        aVar.field_downloadUrlHashCode = gVar.kMX.hashCode();
        aVar.field_fileName = gVar.mFileName;
        aVar.field_fileType = gVar.qIG;
        aVar.field_md5 = gVar.qIF;
        aVar.field_appId = gVar.mAppId;
        aVar.field_autoInstall = gVar.qIH;
        aVar.field_showNotification = gVar.lCY;
        aVar.field_packageName = gVar.mPackageName;
        aVar.field_autoDownload = gVar.qIJ;
        aVar.field_scene = gVar.mScene;
        aVar.field_downloadInWifi = gVar.lBG;
        aVar.field_fromWeApp = gVar.qIM;
        aVar.field_extInfo = gVar.lAo;
        aVar.field_isSecondDownload = gVar.qIN;
        aVar.field_fromDownloadApp = gVar.qIO;
        aVar.field_reserveInWifi = gVar.lBG;
        aVar.field_downloadType = gVar.mDownloadType;
        aVar.field_uiarea = gVar.qIS;
        aVar.field_noticeId = gVar.qIR;
        aVar.field_ssid = gVar.qIQ;
        aVar.field_startScene = gVar.mScene;
        LinkedList<com.tencent.mm.plugin.downloader.c.b.a> linkedList = gVar.qIT;
        if (!Util.isNullOrNil(linkedList)) {
            q qVar = new q();
            qVar.qGz = linkedList;
            try {
                aVar.field_sectionMd5Byte = qVar.toByteArray();
            } catch (IOException e2) {
            }
        }
        aVar.field_rawAppId = gVar.qIU;
        aVar.field_notificationTitle = gVar.qIX;
        AppMethodBeat.o(89016);
        return aVar;
    }

    public static boolean CE(long j2) {
        AppMethodBeat.i(89017);
        if (CF(j2)) {
            AppMethodBeat.o(89017);
            return true;
        }
        LinkedList<a> cBu = d.cBu();
        if (Util.isNullOrNil(cBu)) {
            AppMethodBeat.o(89017);
            return false;
        }
        Iterator<a> it = cBu.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!(next.field_status == 3 || next.field_status == 6 || next.field_status == 1)) {
                Log.i("MicroMsg.FileDownloadUtil", "delete appId : %s, path : %s", next.field_appId, next.field_filePath);
                d.Cx(next.field_downloadId);
                s.deleteFile(next.field_filePath);
                ((c) g.af(c.class)).EN(next.field_appId);
                if (yV(j2)) {
                    AppMethodBeat.o(89017);
                    return true;
                }
            }
        }
        AppMethodBeat.o(89017);
        return false;
    }

    public static boolean CF(long j2) {
        AppMethodBeat.i(89018);
        long j3 = (long) (1.3f * ((float) j2));
        Log.d("MicroMsg.FileDownloadUtil", "checkHasEnoughSpace, realSize = %d, needSize = %d", Long.valueOf(j2), Long.valueOf(j3));
        boolean yV = e.yV(j3);
        AppMethodBeat.o(89018);
        return yV;
    }

    private static boolean yV(long j2) {
        AppMethodBeat.i(89019);
        long freeSpace = Environment.getExternalStorageDirectory().getFreeSpace();
        Log.d("MicroMsg.FileDownloadUtil", "isSDCardHaveEnoughSpace, freeSpace = %d, needSize = %d", Long.valueOf(freeSpace), Long.valueOf(j2));
        if (freeSpace >= j2) {
            AppMethodBeat.o(89019);
            return true;
        }
        AppMethodBeat.o(89019);
        return false;
    }
}
