package com.tencent.mm.plugin.updater.model;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.ag;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.updater.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J(\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u001a\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/updater/model/DownloadCallbackListener;", "Lcom/tencent/mm/plugin/downloader/model/IFileDownloadCallback;", "response", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "downloadId", "", "(Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;J)V", "TAG", "", "getDownloadId", "()J", "getResponse", "()Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "onTaskFailed", "", "id", "errCode", "", "hasChangeUrl", "", "onTaskFinished", "savedFilePath", "onTaskMd5Checking", "onTaskPaused", "onTaskProgressChanged", "url", "revcLeng", "totalLen", "onTaskRemoved", "onTaskResumed", "onTaskStarted", "plugin-updater_release"})
public final class a implements m {
    private final com.tencent.mm.plugin.hp.d.b Gwv;
    private final String TAG = "MicroMsg.Updater.DownloadCallbackListener";
    private final long dCa;

    public a(com.tencent.mm.plugin.hp.d.b bVar, long j2) {
        p.h(bVar, "response");
        AppMethodBeat.i(194731);
        this.Gwv = bVar;
        this.dCa = j2;
        AppMethodBeat.o(194731);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void k(long j2, String str) {
        AppMethodBeat.i(194723);
        String str2 = this.TAG;
        StringBuilder append = new StringBuilder("onTaskStarted cdnUrl:").append(this.Gwv.pkK).append(" downloadId:").append(this.dCa).append(" id:").append(j2).append(" savedFilePath:");
        if (str == null) {
            str = "";
        }
        Log.i(str2, append.append(str).toString());
        if (this.dCa == j2) {
            e.INSTANCE.idkeyStat(1429, 12, 1, false);
            h.RTc.aV(d.GwA);
        }
        AppMethodBeat.o(194723);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        public static final d GwA = new d();

        static {
            AppMethodBeat.i(194722);
            AppMethodBeat.o(194722);
        }

        d() {
        }

        public final void run() {
            AppMethodBeat.i(194721);
            Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.ht5), 0).show();
            b bVar = b.GwB;
            b bVar2 = b.GwB;
            String string = b.getString(R.string.j1d);
            b bVar3 = b.GwB;
            b.a(string, b.getString(R.string.ht4, "0%"), null);
            AppMethodBeat.o(194721);
        }
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void b(long j2, String str, boolean z) {
        boolean z2;
        AppMethodBeat.i(194724);
        Log.i(this.TAG, "onTaskFinished cdnUrl:" + this.Gwv.pkK + " downloadId:" + this.dCa + " id:" + j2 + " hasChangeUrl:" + z + " savedFilePath:" + str);
        if (this.dCa == j2) {
            f.cBv();
            f.b(this);
            h.RTc.aV(b.Gwx);
            if (str != null) {
                b bVar = b.GwB;
                com.tencent.mm.plugin.hp.d.b bVar2 = this.Gwv;
                p.h(bVar2, "response");
                p.h(str, "savePath");
                Log.i(b.TAG, "onDownloadFinish savePath:".concat(String.valueOf(str)));
                Integer num = bVar2.pkI;
                if (num != null && num.intValue() == 3) {
                    e.INSTANCE.idkeyStat(1429, 8, 1, false);
                    h.RTc.b(new b.a(str, bVar2), "Updater");
                    AppMethodBeat.o(194724);
                    return;
                }
                Integer num2 = bVar2.pkI;
                if (num2 == null) {
                    AppMethodBeat.o(194724);
                    return;
                }
                if (num2.intValue() == 2) {
                    e.INSTANCE.idkeyStat(1429, 9, 1, false);
                    File file = new File(s.k(str, false));
                    ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(MMApplicationContext.getContext());
                    try {
                        z2 = shareSecurityCheck.verifyPatchMetaSignature(file);
                    } catch (Exception e2) {
                        Log.printErrStackTrace(b.TAG, e2, "verifyPatchMetaSignature", new Object[0]);
                        z2 = false;
                    }
                    if (!z2) {
                        b.fAJ();
                        e.INSTANCE.idkeyStat(1429, 17, 1, false);
                        Log.i(b.TAG, "hot patch verfiy signature error");
                    } else if (ag.WK().WN()) {
                        HashMap<String, String> packagePropertiesIfPresent = shareSecurityCheck.getPackagePropertiesIfPresent();
                        if (packagePropertiesIfPresent != null) {
                            String str2 = packagePropertiesIfPresent.get("patch.client.ver");
                            if (!TextUtils.isEmpty(str2)) {
                                com.tencent.mm.plugin.hp.tinker.b ii = com.tencent.mm.plugin.hp.tinker.b.ii(com.tencent.mm.loader.j.a.CLIENT_VERSION, str2);
                                ii.dZk();
                                ii.dZj();
                            } else {
                                Log.e(b.TAG, "Fail to get patch clientversion.");
                            }
                        }
                        TinkerPatchResultService.a(new b.C1846b(bVar2));
                        com.tencent.tinker.lib.e.a lk = com.tencent.tinker.lib.e.a.lk(MMApplicationContext.getContext());
                        p.g(lk, "Tinker.with(MMApplicationContext.getContext())");
                        int bqH = lk.hph().bqH(file.getAbsolutePath());
                        Log.i(b.TAG, "start to run patch. ret = ".concat(String.valueOf(bqH)));
                        switch (bqH) {
                            case -6:
                                b.e(bVar2);
                                e.INSTANCE.idkeyStat(1429, 30, 1, false);
                                AppMethodBeat.o(194724);
                                return;
                            case -3:
                            case 0:
                                e.INSTANCE.idkeyStat(1429, 22, 1, false);
                                AppMethodBeat.o(194724);
                                return;
                            default:
                                b.fAJ();
                                e.INSTANCE.idkeyStat(1429, 21, 1, false);
                                AppMethodBeat.o(194724);
                                return;
                        }
                    } else {
                        b.fAJ();
                        e.INSTANCE.idkeyStat(1429, 20, 1, false);
                        Log.i(b.TAG, "patch applying is blocked by TinkerEnsuranceOnFault, update basepack with different clientversion to recover.");
                        AppMethodBeat.o(194724);
                        return;
                    }
                }
                AppMethodBeat.o(194724);
                return;
            }
        }
        AppMethodBeat.o(194724);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        public static final b Gwx = new b();

        static {
            AppMethodBeat.i(194719);
            AppMethodBeat.o(194719);
        }

        b() {
        }

        public final void run() {
            AppMethodBeat.i(194718);
            Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.ht_), 0).show();
            b bVar = b.GwB;
            b bVar2 = b.GwB;
            String string = b.getString(R.string.j1d);
            b bVar3 = b.GwB;
            b.a(string, b.getString(R.string.ht_), null);
            AppMethodBeat.o(194718);
        }
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void b(long j2, int i2, boolean z) {
        AppMethodBeat.i(194725);
        Log.i(this.TAG, "onTaskFailed cdnUrl:" + this.Gwv.pkK + " downloadId:" + this.dCa + " id:" + j2 + " errCode:" + i2 + " hasChangeUrl:" + z);
        if (this.dCa == j2) {
            e.INSTANCE.idkeyStat(1429, 13, 1, false);
            f.cBv();
            f.b(this);
            h.RTc.aV(RunnableC1845a.Gww);
        }
        AppMethodBeat.o(194725);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.updater.model.a$a  reason: collision with other inner class name */
    static final class RunnableC1845a implements Runnable {
        public static final RunnableC1845a Gww = new RunnableC1845a();

        static {
            AppMethodBeat.i(194717);
            AppMethodBeat.o(194717);
        }

        RunnableC1845a() {
        }

        public final void run() {
            AppMethodBeat.i(194716);
            Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.ht3), 0).show();
            b bVar = b.GwB;
            b.fAL();
            AppMethodBeat.o(194716);
        }
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void Bd(long j2) {
        AppMethodBeat.i(194726);
        Log.i(this.TAG, "onTaskRemoved cdnUrl:" + this.Gwv.pkK + " downloadId:" + this.dCa + " id:" + j2);
        if (this.dCa == j2) {
            f.cBv();
            f.b(this);
        }
        AppMethodBeat.o(194726);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void Be(long j2) {
        AppMethodBeat.i(194727);
        Log.i(this.TAG, "onTaskPaused cdnUrl:" + this.Gwv.pkK + " downloadId:" + this.dCa + " id:" + j2);
        AppMethodBeat.o(194727);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void a(long j2, String str, long j3, long j4) {
        AppMethodBeat.i(194728);
        p.h(str, "url");
        Log.i(this.TAG, "onTaskProgressChanged cdnUrl:" + this.Gwv.pkK + " downloadId:" + this.dCa + " id:" + j2 + " revcLeng:" + j3 + " totalLen:" + j4);
        if (this.dCa == j2) {
            h.RTc.aV(new c(j3, j4));
        }
        AppMethodBeat.o(194728);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ long Gwy;
        final /* synthetic */ long Gwz;

        c(long j2, long j3) {
            this.Gwy = j2;
            this.Gwz = j3;
        }

        public final void run() {
            AppMethodBeat.i(194720);
            b bVar = b.GwB;
            b bVar2 = b.GwB;
            String string = b.getString(R.string.j1d);
            StringBuilder sb = new StringBuilder();
            b bVar3 = b.GwB;
            b.a(string, sb.append(b.getString(R.string.ht4)).append((this.Gwy * 100) / this.Gwz).append('%').toString(), null);
            AppMethodBeat.o(194720);
        }
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void l(long j2, String str) {
        AppMethodBeat.i(194729);
        Log.i(this.TAG, "onTaskResumed cdnUrl:" + this.Gwv.pkK + " downloadId:" + this.dCa + " id:" + j2);
        AppMethodBeat.o(194729);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void Bf(long j2) {
        AppMethodBeat.i(194730);
        Log.i(this.TAG, "onTaskMd5Checking cdnUrl:" + this.Gwv.pkK + " downloadId:" + this.dCa + " id:" + j2);
        AppMethodBeat.o(194730);
    }
}
