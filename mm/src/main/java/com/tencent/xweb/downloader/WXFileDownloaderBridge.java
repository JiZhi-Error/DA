package com.tencent.xweb.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public class WXFileDownloaderBridge implements b {
    public static a SAX = null;
    public c SAY = null;

    public static void a(a aVar) {
        AppMethodBeat.i(156946);
        Log.i("WXFileDownloaderBridge", "XWalkLib SetFileDownloaderProxy:" + (aVar == null));
        SAX = aVar;
        AppMethodBeat.o(156946);
    }

    public static boolean isValid() {
        return SAX != null;
    }

    @Override // com.tencent.xweb.downloader.b
    public final void c(String str, String str2, boolean z) {
        AppMethodBeat.i(156947);
        Log.i("WXFileDownloaderBridge", "onTaskFinished url=" + str + ", save_path=" + str2);
        this.SAY.onTaskSucc(str, str2, z);
        AppMethodBeat.o(156947);
    }

    @Override // com.tencent.xweb.downloader.b
    public final void d(String str, int i2, boolean z) {
        AppMethodBeat.i(156948);
        Log.i("WXFileDownloaderBridge", "onTaskFailed, url=" + str + ", errCode=" + i2);
        this.SAY.onTaskFail(str, i2, z);
        AppMethodBeat.o(156948);
    }

    @Override // com.tencent.xweb.downloader.b
    public final void j(String str, long j2, long j3) {
        AppMethodBeat.i(156949);
        Log.i("WXFileDownloaderBridge", "onTaskProgressChanged, url=" + str + ", cur_size:" + j2 + ", total_size:" + j3);
        this.SAY.onProgressChange(str, j2, j3);
        AppMethodBeat.o(156949);
    }
}
