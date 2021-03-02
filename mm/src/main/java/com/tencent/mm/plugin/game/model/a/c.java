package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class c implements m {
    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void k(long j2, String str) {
        AppMethodBeat.i(41663);
        c("onTaskStarted", j2, true);
        AppMethodBeat.o(41663);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void b(long j2, String str, boolean z) {
        AppMethodBeat.i(41664);
        Log.i("MicroMsg.GameSilentDownloadCallback", "onTaskFinished");
        a Cw = d.Cw(j2);
        if (Cw != null && Cw.field_autoDownload) {
            f.ap(Cw.field_appId, 0, 0);
            aAq(Cw.field_appId);
        }
        AppMethodBeat.o(41664);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void b(long j2, int i2, boolean z) {
        a Cw;
        AppMethodBeat.i(41665);
        Log.i("MicroMsg.GameSilentDownloadCallback", "onTaskFailed, errCode:%d", Integer.valueOf(i2));
        if (!(i2 == com.tencent.mm.plugin.downloader.a.a.qFl || (Cw = d.Cw(j2)) == null || !Cw.field_autoDownload)) {
            f.ap(Cw.field_appId, 1, i2);
            aAq(Cw.field_appId);
        }
        AppMethodBeat.o(41665);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void Bd(long j2) {
        AppMethodBeat.i(41666);
        Log.i("MicroMsg.GameSilentDownloadCallback", "onTaskRemoved");
        a Cw = d.Cw(j2);
        if (Cw != null && Cw.field_autoDownload) {
            f.ap(Cw.field_appId, 2, 0);
            aAq(Cw.field_appId);
        }
        AppMethodBeat.o(41666);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void Be(long j2) {
        AppMethodBeat.i(41667);
        c("onTaskPaused", j2, false);
        AppMethodBeat.o(41667);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void a(long j2, String str, long j3, long j4) {
        AppMethodBeat.i(204180);
        Log.d("MicroMsg.GameSilentDownloadCallback", "onTaskProgressChanged");
        AppMethodBeat.o(204180);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void l(long j2, String str) {
        AppMethodBeat.i(41669);
        c("onTaskResumed", j2, true);
        AppMethodBeat.o(41669);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void Bf(long j2) {
    }

    private static void aAq(String str) {
        AppMethodBeat.i(41670);
        d dVar = new d();
        dVar.field_appId = str;
        Log.i("MicroMsg.GameSilentDownloadCallback", "removeSilentDownloadTask, appid:%s, ret:%b", str, Boolean.valueOf(((f) g.af(f.class)).dSM().delete(dVar, new String[0])));
        AppMethodBeat.o(41670);
    }

    private static void c(String str, long j2, boolean z) {
        AppMethodBeat.i(41671);
        Log.i("MicroMsg.GameSilentDownloadCallback", str);
        a Cw = d.Cw(j2);
        if (Cw != null && Cw.field_autoDownload) {
            Log.i("MicroMsg.GameSilentDownloadCallback", "%s. appid:%s, ret:%b", str, Cw.field_appId, Boolean.valueOf(((f) g.af(f.class)).dSM().bH(Cw.field_appId, z)));
        }
        AppMethodBeat.o(41671);
    }
}
