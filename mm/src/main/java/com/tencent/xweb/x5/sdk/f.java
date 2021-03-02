package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.aj;
import org.xwalk.core.Log;

public final class f {
    static b SFJ;

    public interface a {
        void onNeedDownloadFinish(boolean z, int i2);
    }

    static {
        AppMethodBeat.i(157157);
        aj.initInterface();
        AppMethodBeat.o(157157);
    }

    public static void a(b bVar) {
        SFJ = bVar;
    }

    public static boolean lE(Context context) {
        AppMethodBeat.i(157149);
        if (SFJ != null) {
            boolean lE = SFJ.lE(context);
            AppMethodBeat.o(157149);
            return lE;
        }
        Log.e("TbsDownloader", "needSendRequest: sImp is null");
        AppMethodBeat.o(157149);
        return false;
    }

    public static boolean needDownload(Context context, boolean z) {
        AppMethodBeat.i(157150);
        boolean a2 = a(context, z, false, null);
        AppMethodBeat.o(157150);
        return a2;
    }

    public static boolean a(Context context, boolean z, boolean z2, a aVar) {
        AppMethodBeat.i(157151);
        if (SFJ != null) {
            boolean a2 = SFJ.a(context, z, z2, aVar);
            AppMethodBeat.o(157151);
            return a2;
        }
        Log.e("TbsDownloader", "needDownload: sImp is null");
        AppMethodBeat.o(157151);
        return false;
    }

    public static void startDownload(Context context) {
        AppMethodBeat.i(157152);
        startDownload(context, false);
        AppMethodBeat.o(157152);
    }

    public static synchronized void startDownload(Context context, boolean z) {
        synchronized (f.class) {
            AppMethodBeat.i(157153);
            if (SFJ != null) {
                SFJ.startDownload(context, z);
                AppMethodBeat.o(157153);
            } else {
                Log.e("TbsDownloader", "startDownload: sImp is null");
                AppMethodBeat.o(157153);
            }
        }
    }

    public static void stopDownload() {
        AppMethodBeat.i(157154);
        if (SFJ != null) {
            SFJ.stopDownload();
            AppMethodBeat.o(157154);
            return;
        }
        Log.e("TbsDownloader", "stopDownload: sImp is null");
        AppMethodBeat.o(157154);
    }

    public static synchronized boolean isDownloading() {
        boolean z;
        synchronized (f.class) {
            AppMethodBeat.i(157155);
            if (SFJ != null) {
                z = SFJ.isDownloading();
                AppMethodBeat.o(157155);
            } else {
                Log.e("TbsDownloader", "isDownloading: sImp is null");
                z = false;
                AppMethodBeat.o(157155);
            }
        }
        return z;
    }

    public static boolean isDownloadForeground() {
        AppMethodBeat.i(157156);
        if (SFJ != null) {
            boolean isDownloadForeground = SFJ.isDownloadForeground();
            AppMethodBeat.o(157156);
            return isDownloadForeground;
        }
        Log.e("TbsDownloader", "isDownloadForeground: sImp is null");
        AppMethodBeat.o(157156);
        return false;
    }
}
