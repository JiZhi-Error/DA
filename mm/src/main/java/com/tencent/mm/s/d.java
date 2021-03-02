package com.tencent.mm.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class d implements b {
    public static a gRd = null;
    public c gRe = null;

    public static void a(a aVar) {
        AppMethodBeat.i(120679);
        Log.i("WXFileDownloaderBridge", "XWalkLib SetFileDownloaderProxy:" + (aVar == null));
        gRd = aVar;
        AppMethodBeat.o(120679);
    }

    @Override // com.tencent.mm.s.b
    public final void c(String str, String str2, boolean z) {
        AppMethodBeat.i(120680);
        Log.i("WXFileDownloaderBridge", "onTaskFinished url=" + str + ", save_path=" + str2);
        this.gRe.onTaskSucc(str, str2, z);
        AppMethodBeat.o(120680);
    }

    @Override // com.tencent.mm.s.b
    public final void d(String str, int i2, boolean z) {
        AppMethodBeat.i(120681);
        Log.i("WXFileDownloaderBridge", "onTaskFailed, url=" + str + ", errCode=" + i2);
        this.gRe.onTaskFail(str, i2, z);
        AppMethodBeat.o(120681);
    }

    @Override // com.tencent.mm.s.b
    public final void j(String str, long j2, long j3) {
        AppMethodBeat.i(120682);
        Log.i("WXFileDownloaderBridge", "onTaskProgressChanged, url=" + str + ", cur_size:" + j2 + ", total_size:" + j3);
        AppMethodBeat.o(120682);
    }
}
