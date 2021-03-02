package com.tencent.mm.plugin.updater.model;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import android.support.v4.app.s;
import android.widget.Toast;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004J'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0011\"\u00020\u0001¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0006J\b\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\b\u0010 \u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/updater/model/ManualUpdaterProcessor;", "", "()V", "NOTIFICATION_ID", "", "TAG", "", "cancelNotification", "", "checkAndShowInstallBsPatchDialog", "", "response", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "dealWithAlphaVersion", "getString", "resId", "args", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "onDownloadFinish", "savePath", "patchRollBack", "prepareToDownload", "process", "processBsPatch", "processHotPatch", "showApplyPatchSuccessDialog", "showNotification", "title", "text", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "updateFailToast", "plugin-updater_release"})
public final class b {
    public static final b GwB = new b();
    static final String TAG = TAG;
    private static final int kYM = kYM;

    static {
        AppMethodBeat.i(194757);
        AppMethodBeat.o(194757);
    }

    private b() {
    }

    public static final /* synthetic */ void fAN() {
        AppMethodBeat.i(194759);
        fAJ();
        AppMethodBeat.o(194759);
    }

    public static final /* synthetic */ boolean h(com.tencent.mm.plugin.hp.d.b bVar) {
        AppMethodBeat.i(194758);
        boolean f2 = f(bVar);
        AppMethodBeat.o(194758);
        return f2;
    }

    public static final /* synthetic */ void i(com.tencent.mm.plugin.hp.d.b bVar) {
        AppMethodBeat.i(194760);
        e(bVar);
        AppMethodBeat.o(194760);
    }

    public final void a(com.tencent.mm.plugin.hp.d.b bVar) {
        AppMethodBeat.i(194744);
        p.h(bVar, "response");
        if (!bVar.dZw()) {
            Log.i(TAG, "check response error");
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 0, 1, false);
            AppMethodBeat.o(194744);
        } else if (bVar.dZx()) {
            Log.i(TAG, "need to rollback");
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 1, 1, false);
            fAK();
            AppMethodBeat.o(194744);
        } else if (!bVar.dZt()) {
            Log.i(TAG, "check not need to update");
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 2, 1, false);
            AppMethodBeat.o(194744);
        } else if (bVar.dZy()) {
            Log.i(TAG, "lower client version");
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 3, 1, false);
            AppMethodBeat.o(194744);
        } else if (CrashReportFactory.isOnlinePatchBlocked()) {
            Log.i(TAG, "patch downloading is blocked by assist.");
            AppMethodBeat.o(194744);
        } else {
            Integer num = bVar.pkI;
            if (num != null && num.intValue() == 3) {
                b(bVar);
                AppMethodBeat.o(194744);
                return;
            }
            Integer num2 = bVar.pkI;
            if (num2 != null && num2.intValue() == 2) {
                c(bVar);
                AppMethodBeat.o(194744);
                return;
            }
            Log.i(TAG, "full apk not support, comming soon");
            AppMethodBeat.o(194744);
        }
    }

    private static void b(com.tencent.mm.plugin.hp.d.b bVar) {
        AppMethodBeat.i(194745);
        Log.i(TAG, "handle bspatch");
        if (com.tencent.mm.plugin.hp.d.c.aBK(bVar.clientVersion)) {
            Log.i(TAG, "handle alpha version " + bVar.clientVersion);
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 4, 1, false);
            g(bVar);
            AppMethodBeat.o(194745);
            return;
        }
        if (!f(bVar)) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 6, 1, false);
            d(bVar);
        }
        AppMethodBeat.o(194745);
    }

    private static void c(com.tencent.mm.plugin.hp.d.b bVar) {
        AppMethodBeat.i(194746);
        Log.i(TAG, "handle hotpatch");
        d(bVar);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 7, 1, false);
        AppMethodBeat.o(194746);
    }

    private static void d(com.tencent.mm.plugin.hp.d.b bVar) {
        AppMethodBeat.i(194747);
        Log.i(TAG, "prepare to download fileMd5:" + bVar.pkL + " fileSize:" + bVar.fileSize + " cdnUrl:" + bVar.pkK);
        if (!p.j(g.getExternalStorageState(), "mounted")) {
            Log.e(TAG, "no sdcard.");
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 9, 1, false);
            AppMethodBeat.o(194747);
        } else if (!com.tencent.mm.compatible.util.e.yV((long) bVar.fileSize)) {
            Log.e(TAG, "sdcard is full.");
            h.RTc.aV(d.GwG);
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 10, 1, false);
            AppMethodBeat.o(194747);
        } else {
            MMApplicationContext.getContext();
            com.tencent.mm.plugin.hp.d.d.dZA();
            com.tencent.mm.plugin.hp.d.d.dZB();
            g.a aVar = new g.a();
            aVar.alj(bVar.pkK);
            aVar.all(bVar.cri);
            aVar.setFileMD5(bVar.pkL);
            aVar.kS(false);
            aVar.kU(true);
            aVar.cBH();
            aVar.kT(false);
            aVar.Fl(2);
            long a2 = com.tencent.mm.plugin.downloader.model.f.cBv().a(aVar.cBG());
            com.tencent.mm.plugin.downloader.model.f.cBv();
            com.tencent.mm.plugin.downloader.model.f.a(new a(bVar, a2));
            Log.i(TAG, "download start");
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 11, 1, false);
            AppMethodBeat.o(194747);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        public static final d GwG = new d();

        static {
            AppMethodBeat.i(194738);
            AppMethodBeat.o(194738);
        }

        d() {
        }

        public final void run() {
            AppMethodBeat.i(194737);
            Toast.makeText(MMApplicationContext.getContext(), (int) R.string.gf8, 0).show();
            AppMethodBeat.o(194737);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ String GwC;
        final /* synthetic */ com.tencent.mm.plugin.hp.d.b GwD;

        a(String str, com.tencent.mm.plugin.hp.d.b bVar) {
            this.GwC = str;
            this.GwD = bVar;
        }

        public final void run() {
            AppMethodBeat.i(194734);
            File file = new File(s.k(this.GwC, false));
            String aBN = com.tencent.mm.plugin.hp.d.d.aBN(this.GwD.ynv);
            String gp = com.tencent.mm.plugin.hp.d.d.gp(MMApplicationContext.getContext());
            String absolutePath = file.getAbsolutePath();
            long aWA = cl.aWA();
            int t = com.tencent.mm.plugin.hp.a.b.t(gp, absolutePath, aBN, this.GwD.ynv);
            b bVar = b.GwB;
            Log.i(b.TAG, "merge bs diff costTime:" + (cl.aWA() - aWA) + ' ' + absolutePath + ' ' + aBN + " retCode:" + t);
            SharePatchFileUtil.safeDeleteFile(new File(absolutePath));
            if (t == 0) {
                b bVar2 = b.GwB;
                if (!b.h(this.GwD)) {
                    b bVar3 = b.GwB;
                    b.fAN();
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 19, 1, false);
                    AppMethodBeat.o(194734);
                    return;
                }
                h.RTc.aV(AnonymousClass1.GwE);
                AppMethodBeat.o(194734);
                return;
            }
            b bVar4 = b.GwB;
            b.fAN();
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 18, 1, false);
            AppMethodBeat.o(194734);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/tinker/lib/service/PatchResult;", "kotlin.jvm.PlatformType", "onPatchResult"})
    /* renamed from: com.tencent.mm.plugin.updater.model.b$b  reason: collision with other inner class name */
    static final class C1846b implements com.tinkerboots.sdk.tinker.a.a {
        final /* synthetic */ com.tencent.mm.plugin.hp.d.b GwD;

        C1846b(com.tencent.mm.plugin.hp.d.b bVar) {
            this.GwD = bVar;
        }

        @Override // com.tinkerboots.sdk.tinker.a.a
        public final void a(com.tencent.tinker.lib.service.a aVar) {
            AppMethodBeat.i(194735);
            TinkerPatchResultService.a((com.tinkerboots.sdk.tinker.a.a) null);
            b bVar = b.GwB;
            Log.i(b.TAG, "patchResult costTime: %s, path: %s, isSuccess: %b", Long.valueOf(aVar.costTime), aVar.SjJ, Boolean.valueOf(aVar.isSuccess));
            if (aVar.isSuccess) {
                b bVar2 = b.GwB;
                b.i(this.GwD);
                AppMethodBeat.o(194735);
                return;
            }
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 24, 1, false);
            b bVar3 = b.GwB;
            b.fAN();
            AppMethodBeat.o(194735);
        }
    }

    static void e(com.tencent.mm.plugin.hp.d.b bVar) {
        AppMethodBeat.i(194748);
        fAL();
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 23, 1, false);
        h.RTc.aV(new e(bVar));
        AppMethodBeat.o(194748);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.hp.d.b GwD;

        e(com.tencent.mm.plugin.hp.d.b bVar) {
            this.GwD = bVar;
        }

        public final void run() {
            AppMethodBeat.i(194741);
            f.a aVar = new f.a(MMApplicationContext.getContext());
            b bVar = b.GwB;
            String sizeMB = Util.getSizeMB((long) this.GwD.fileSize);
            p.g(sizeMB, "Util.getSizeMB(response.fileSize.toLong())");
            aVar.bow(b.getString(R.string.ht7, sizeMB));
            aVar.c(AnonymousClass1.GwH);
            aVar.Dq(true);
            aVar.show();
            b bVar2 = b.GwB;
            Log.i(b.TAG, "hotPatchInstallSuccessDialog show");
            AppMethodBeat.o(194741);
        }
    }

    static void fAJ() {
        AppMethodBeat.i(194749);
        Log.i(TAG, "updateFailToast");
        h.RTc.aV(f.GwI);
        AppMethodBeat.o(194749);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        public static final f GwI = new f();

        static {
            AppMethodBeat.i(194743);
            AppMethodBeat.o(194743);
        }

        f() {
        }

        public final void run() {
            AppMethodBeat.i(194742);
            Context context = MMApplicationContext.getContext();
            b bVar = b.GwB;
            Toast.makeText(context, b.getString(R.string.ht9), 1).show();
            b bVar2 = b.GwB;
            b.fAL();
            AppMethodBeat.o(194742);
        }
    }

    private static boolean f(com.tencent.mm.plugin.hp.d.b bVar) {
        AppMethodBeat.i(194750);
        Log.i(TAG, "checkAndShowInstallBsPatchDialog");
        String aBN = com.tencent.mm.plugin.hp.d.d.aBN(bVar.ynv);
        if (!s.YS(aBN) || !com.tencent.mm.d.a.fP(aBN)) {
            AppMethodBeat.o(194750);
            return false;
        }
        Log.i(TAG, "checkAndShowInstallBsPatchDialog apk ready ".concat(String.valueOf(aBN)));
        r.b(MMApplicationContext.getContext(), aBN, null, false);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1429, 5, 1, false);
        AppMethodBeat.o(194750);
        return true;
    }

    private static void fAK() {
        AppMethodBeat.i(194751);
        Context context = MMApplicationContext.getContext();
        com.tencent.tinker.lib.e.a lk = com.tencent.tinker.lib.e.a.lk(context);
        p.g(lk, ShareConstants.PATCH_DIRECTORY_NAME);
        if (!lk.hpe()) {
            Log.w(TAG, "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return");
            AppMethodBeat.o(194751);
            return;
        }
        Log.i(TAG, "tinker wait screen to clean patch and kill all process");
        new m(context, new c(context, lk));
        SharePatchInfo.rewritePatchInfoFileWithLock(lk.hpf(), new SharePatchInfo(lk.hpd().Ske, "00000000000000000000000000000000", false, true, Build.FINGERPRINT, "odex", false), lk.hpg());
        AppMethodBeat.o(194751);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "isOn", "", "onScreenStateChange"})
    public static final class c implements m.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.tencent.tinker.lib.e.a GwF;

        c(Context context, com.tencent.tinker.lib.e.a aVar) {
            this.$context = context;
            this.GwF = aVar;
        }

        @Override // com.tencent.mm.modelmulti.m.a
        public final void fH(boolean z) {
            AppMethodBeat.i(194736);
            if (!z) {
                b bVar = b.GwB;
                Log.i(b.TAG, "app is background now, i can kill quietly");
                ShareTinkerInternals.killAllOtherProcess(this.$context);
                this.GwF.dZn();
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/plugin/updater/model/ManualUpdaterProcessor$patchRollBack$1", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                Process.killProcess(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/updater/model/ManualUpdaterProcessor$patchRollBack$1", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            }
            AppMethodBeat.o(194736);
        }
    }

    private static void g(com.tencent.mm.plugin.hp.d.b bVar) {
        AppMethodBeat.i(194752);
        Log.i(TAG, "dealWithAlphaVersion " + bVar.clientVersion);
        Context context = MMApplicationContext.getContext();
        String string = Util.isNullOrNil(bVar.ynx) ? context.getString(R.string.yb) : bVar.ynx;
        String str = Util.isNullOrNil(bVar.yny) ? "" : bVar.yny;
        String str2 = Util.isNullOrNil(bVar.ynz) ? HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index" : bVar.ynz;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
        intent.putExtra("rawUrl", str2);
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.setFlags(872415232);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 268435456);
        s.c a2 = com.tencent.mm.bq.a.cd(context, "reminder_channel_id").i((CharSequence) null).i(System.currentTimeMillis()).f(string).g(str).a(activity);
        p.g(a2, "NotificationHelper.getNo…tentIntent(pendingIntent)");
        a2.as(com.tencent.mm.bq.a.ezb());
        p.g(string, "title");
        p.g(str, "text");
        a(string, str, activity);
        AppMethodBeat.o(194752);
    }

    public static void a(String str, String str2, PendingIntent pendingIntent) {
        AppMethodBeat.i(194753);
        p.h(str, "title");
        p.h(str2, "text");
        Notification build = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i((CharSequence) null).E(true).i(System.currentTimeMillis()).f(str).g(str2).a(pendingIntent).as(com.tencent.mm.bq.a.ezb()).build();
        Object systemService = MMApplicationContext.getContext().getSystemService("notification");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.NotificationManager");
            AppMethodBeat.o(194753);
            throw tVar;
        }
        ((NotificationManager) systemService).notify(kYM, build);
        AppMethodBeat.o(194753);
    }

    public static void fAL() {
        AppMethodBeat.i(194754);
        Object systemService = MMApplicationContext.getContext().getSystemService("notification");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.NotificationManager");
            AppMethodBeat.o(194754);
            throw tVar;
        }
        ((NotificationManager) systemService).cancel(kYM);
        AppMethodBeat.o(194754);
    }

    public static String getString(int i2) {
        AppMethodBeat.i(194755);
        String string = MMApplicationContext.getContext().getString(i2);
        p.g(string, "MMApplicationContext.getContext().getString(resId)");
        AppMethodBeat.o(194755);
        return string;
    }

    public static String getString(int i2, Object... objArr) {
        AppMethodBeat.i(194756);
        p.h(objArr, "args");
        String string = MMApplicationContext.getContext().getString(i2, objArr);
        p.g(string, "MMApplicationContext.get…().getString(resId, args)");
        AppMethodBeat.o(194756);
        return string;
    }
}
