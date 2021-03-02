package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.xweb.x5.sdk.f;

public final class g implements b {
    @Override // com.tencent.xweb.x5.sdk.b
    public final boolean lE(Context context) {
        AppMethodBeat.i(154140);
        boolean needSendRequest = TbsDownloader.needSendRequest(context, false);
        AppMethodBeat.o(154140);
        return needSendRequest;
    }

    @Override // com.tencent.xweb.x5.sdk.b
    public final boolean a(Context context, boolean z, boolean z2, f.a aVar) {
        AppMethodBeat.i(154141);
        if (aVar == null) {
            boolean needDownload = TbsDownloader.needDownload(context, z, z2, null);
            AppMethodBeat.o(154141);
            return needDownload;
        }
        boolean needDownload2 = TbsDownloader.needDownload(context, z, z2, new a(aVar));
        AppMethodBeat.o(154141);
        return needDownload2;
    }

    @Override // com.tencent.xweb.x5.sdk.b
    public final void startDownload(Context context, boolean z) {
        AppMethodBeat.i(154142);
        TbsDownloader.startDownload(context, z);
        AppMethodBeat.o(154142);
    }

    @Override // com.tencent.xweb.x5.sdk.b
    public final void stopDownload() {
        AppMethodBeat.i(154143);
        TbsDownloader.stopDownload();
        AppMethodBeat.o(154143);
    }

    @Override // com.tencent.xweb.x5.sdk.b
    public final boolean isDownloading() {
        AppMethodBeat.i(154144);
        boolean isDownloading = TbsDownloader.isDownloading();
        AppMethodBeat.o(154144);
        return isDownloading;
    }

    @Override // com.tencent.xweb.x5.sdk.b
    public final boolean isDownloadForeground() {
        AppMethodBeat.i(154145);
        boolean isDownloadForeground = TbsDownloader.isDownloadForeground();
        AppMethodBeat.o(154145);
        return isDownloadForeground;
    }

    static class a implements TbsDownloader.TbsDownloaderCallback {
        f.a SFK;

        public a(f.a aVar) {
            this.SFK = aVar;
        }

        @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
        public final void onNeedDownloadFinish(boolean z, int i2) {
            AppMethodBeat.i(154139);
            if (this.SFK != null) {
                this.SFK.onNeedDownloadFinish(z, i2);
            }
            AppMethodBeat.o(154139);
        }
    }
}
