package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
public final class k extends j {
    public k(c cVar) {
        super(cVar);
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final long a(a aVar) {
        return 0;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final int Cn(long j2) {
        return 1;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final FileDownloadTaskInfo Co(long j2) {
        AppMethodBeat.i(89032);
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.id = j2;
        fileDownloadTaskInfo.status = -1;
        AppMethodBeat.o(89032);
        return fileDownloadTaskInfo;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final boolean Cp(long j2) {
        return false;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final boolean Cq(long j2) {
        return false;
    }

    @Override // com.tencent.mm.plugin.downloader.model.n
    public final long a(g gVar) {
        AppMethodBeat.i(89031);
        if (Util.isNullOrNil(gVar.kMX)) {
            AppMethodBeat.o(89031);
            return -1;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(gVar.kMX));
        intent.addFlags(268435456);
        try {
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/downloader/model/FileDownloaderImplNormal", JsApiAddDownloadTask.NAME, "(Lcom/tencent/mm/plugin/downloader/model/FileDownloadRequest;)J", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/downloader/model/FileDownloaderImplNormal", JsApiAddDownloadTask.NAME, "(Lcom/tencent/mm/plugin/downloader/model/FileDownloadRequest;)J", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(89031);
            return 0;
        } catch (Exception e2) {
            Log.e("MicroMsg.FileDownloaderImplNormal", "Add download task failed: " + e2.toString());
            AppMethodBeat.o(89031);
            return -1;
        }
    }
}
