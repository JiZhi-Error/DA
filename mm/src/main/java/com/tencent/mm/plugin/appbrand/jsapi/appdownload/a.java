package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class a implements m {
    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void k(long j2, String str) {
        AppMethodBeat.i(45726);
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw != null) {
            Log.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskStarted, appId: " + Cw.field_appId);
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_started";
            appbrandDownloadState.dCa = Cw.field_downloadId;
            appbrandDownloadState.appId = Cw.field_appId;
            if (Cw.field_totalSize != 0) {
                appbrandDownloadState.progress = (long) ((((float) Cw.field_downloadedSize) / ((float) Cw.field_totalSize)) * 100.0f);
                appbrandDownloadState.lCT = (((float) Cw.field_downloadedSize) * 100.0f) / ((float) Cw.field_totalSize);
            }
            appbrandDownloadState.lCS = Cw.field_totalSize;
            b.a(appbrandDownloadState);
        }
        AppMethodBeat.o(45726);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void b(long j2, String str, boolean z) {
        AppMethodBeat.i(45727);
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw != null) {
            Log.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFinished, appId: " + Cw.field_appId);
            if (Cw.field_downloadInWifi) {
                Cw.field_downloadInWifi = false;
                d.e(Cw);
            }
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_succ";
            appbrandDownloadState.dCa = Cw.field_downloadId;
            appbrandDownloadState.appId = Cw.field_appId;
            appbrandDownloadState.progress = 100;
            appbrandDownloadState.lCS = Cw.field_totalSize;
            b.a(appbrandDownloadState);
        }
        AppMethodBeat.o(45727);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void b(long j2, int i2, boolean z) {
        AppMethodBeat.i(45728);
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw != null) {
            Log.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFailed, appId: %s, downloadInWifi: %b, isWifi: %b", Cw.field_appId, Boolean.valueOf(Cw.field_downloadInWifi), Boolean.valueOf(NetStatusUtil.isWifi(MMApplicationContext.getContext())));
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            if (!Cw.field_downloadInWifi || NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                appbrandDownloadState.state = "download_failed";
            } else {
                appbrandDownloadState.state = "download_wait_wifi";
            }
            appbrandDownloadState.dCa = Cw.field_downloadId;
            appbrandDownloadState.appId = Cw.field_appId;
            appbrandDownloadState.lCS = Cw.field_totalSize;
            b.a(appbrandDownloadState);
        }
        AppMethodBeat.o(45728);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void Bd(long j2) {
        AppMethodBeat.i(45729);
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw != null) {
            Log.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskRemoved, appId: " + Cw.field_appId);
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_removed";
            appbrandDownloadState.dCa = Cw.field_downloadId;
            appbrandDownloadState.appId = Cw.field_appId;
            appbrandDownloadState.lCS = Cw.field_totalSize;
            b.a(appbrandDownloadState);
        }
        AppMethodBeat.o(45729);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void Be(long j2) {
        AppMethodBeat.i(45730);
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw != null) {
            Log.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskPaused, appId: " + Cw.field_appId);
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            if (!Cw.field_downloadInWifi || NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                appbrandDownloadState.state = "download_paused";
            } else {
                appbrandDownloadState.state = "download_wait_wifi";
            }
            appbrandDownloadState.dCa = Cw.field_downloadId;
            appbrandDownloadState.appId = Cw.field_appId;
            appbrandDownloadState.lCS = Cw.field_totalSize;
            if (Cw.field_totalSize != 0) {
                appbrandDownloadState.progress = (long) ((((float) Cw.field_downloadedSize) / ((float) Cw.field_totalSize)) * 100.0f);
                appbrandDownloadState.lCT = (((float) Cw.field_downloadedSize) * 100.0f) / ((float) Cw.field_totalSize);
            }
            b.a(appbrandDownloadState);
        }
        AppMethodBeat.o(45730);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void a(long j2, String str, long j3, long j4) {
        AppMethodBeat.i(226685);
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw != null) {
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_progress_changed";
            appbrandDownloadState.dCa = Cw.field_downloadId;
            appbrandDownloadState.appId = Cw.field_appId;
            if (Cw.field_totalSize != 0) {
                appbrandDownloadState.progress = (long) ((((float) Cw.field_downloadedSize) / ((float) Cw.field_totalSize)) * 100.0f);
                appbrandDownloadState.lCT = (((float) Cw.field_downloadedSize) * 100.0f) / ((float) Cw.field_totalSize);
            }
            Log.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskProgressChanged, appId: %s, progress: %d", Cw.field_appId, Long.valueOf(appbrandDownloadState.progress));
            appbrandDownloadState.lCS = Cw.field_totalSize;
            b.a(appbrandDownloadState);
        }
        AppMethodBeat.o(226685);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void l(long j2, String str) {
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void Bf(long j2) {
    }
}
