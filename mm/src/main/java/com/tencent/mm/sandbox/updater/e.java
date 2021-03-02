package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cr.d;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.xweb.WebView;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;
import com.tencent.xweb.x5.sdk.f;
import com.tencent.xweb.x5.sdk.h;

public final class e implements a {
    private a NFf;
    private boolean NFg;
    private boolean NFh;
    private boolean NFi;
    Intent intent;
    private int kYM;
    private Notification kYy;

    /* synthetic */ e(byte b2) {
        this();
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(32705);
        eVar.dZb();
        AppMethodBeat.o(32705);
    }

    static {
        AppMethodBeat.i(32707);
        d.kT(MMApplicationContext.getContext());
        WXFileDownloaderBridge.a(com.tencent.mm.plugin.cdndownloader.i.a.cyj());
        AppMethodBeat.o(32707);
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        public static final e NFl = new e((byte) 0);

        static {
            AppMethodBeat.i(32697);
            AppMethodBeat.o(32697);
        }
    }

    public static e gwh() {
        return b.NFl;
    }

    private e() {
        AppMethodBeat.i(32698);
        this.NFf = null;
        this.intent = new Intent();
        this.kYy = null;
        this.kYM = 999;
        this.NFg = false;
        this.NFh = false;
        this.NFi = false;
        AppMethodBeat.o(32698);
    }

    private void dZb() {
        AppMethodBeat.i(32699);
        if (this.NFi) {
            Log.i("MicroMsg.TBSDownloadMgr", "TBS already downloaded, ignore duplicated request");
            AppMethodBeat.o(32699);
            return;
        }
        this.NFi = true;
        if (this.NFf == null) {
            this.NFf = new a(this, (byte) 0);
            com.tencent.xweb.x5.sdk.d.a(this.NFf);
            r.pl(2);
        }
        gwi();
        r.pl(3);
        AppMethodBeat.o(32699);
    }

    @Override // com.tencent.mm.sandbox.updater.a
    public final void Ay(boolean z) {
        AppMethodBeat.i(32700);
        if (this.NFf == null) {
            Log.w("MicroMsg.TBSDownloadMgr", "TBS download not inited, ignore");
            AppMethodBeat.o(32700);
            return;
        }
        Context context = MMApplicationContext.getContext();
        boolean isDownloading = f.isDownloading();
        boolean needDownload = f.needDownload(context, this.NFg | this.NFh);
        boolean booleanExtra = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
        boolean isDownloadForeground = f.isDownloadForeground();
        Log.i("MicroMsg.TBSDownloadMgr", "setNetStatChanged, isWifi = %b, downloading = %b, needDownload = %b, ignoreNetworkType = %b", Boolean.valueOf(z), Boolean.valueOf(isDownloading), Boolean.valueOf(needDownload), Boolean.valueOf(booleanExtra));
        if ((z || booleanExtra) && !isDownloading && needDownload) {
            gwi();
            r.pl(3);
            AppMethodBeat.o(32700);
            return;
        }
        if (!z && !booleanExtra && isDownloading && !isDownloadForeground) {
            f.stopDownload();
            r.pl(4);
        }
        AppMethodBeat.o(32700);
    }

    private void gwi() {
        AppMethodBeat.i(32701);
        f.startDownload(MMApplicationContext.getContext());
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            Log.i("MicroMsg.TBSDownloadMgr", "now start download,hasDownloadOverSea over sea = %b, is now oversea = %b", Boolean.valueOf(this.NFh), Boolean.valueOf(this.NFg));
            if (this.NFh || this.NFg) {
                sharedPreferences.edit().putBoolean("tbs_download_oversea", true).commit();
            }
        }
        AppMethodBeat.o(32701);
    }

    @Override // com.tencent.mm.sandbox.updater.a
    public final boolean bu(Intent intent2) {
        AppMethodBeat.i(32702);
        this.intent = intent2;
        this.NFg = this.intent.getIntExtra("intent_extra_download_type", 1) == 2;
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        if (sharedPreferences != null) {
            this.NFh = sharedPreferences.getBoolean("tbs_download_oversea", false);
        }
        Log.i("MicroMsg.TBSDownloadMgr", "isOverSea = %b, hasDownloadOverSea = %b", Boolean.valueOf(this.NFg), Boolean.valueOf(this.NFh));
        boolean isDownloading = f.isDownloading();
        com.tencent.xweb.x5.sdk.d.setUploadCode(MMApplicationContext.getContext(), 133);
        if (this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false)) {
            QbSdk.setDownloadWithoutWifi(true);
        }
        if (isDownloading) {
            Log.i("MicroMsg.TBSDownloadMgr", "TBS already downloading, ignore duplicated request");
            com.tencent.xweb.x5.sdk.d.setUploadCode(MMApplicationContext.getContext(), g.CTRL_INDEX);
            AppMethodBeat.o(32702);
            return true;
        }
        this.NFi = false;
        Context context = MMApplicationContext.getContext();
        int installedTbsCoreVersion = WebView.getInstalledTbsCoreVersion(context);
        boolean a2 = f.a(context, this.NFg | this.NFh, false, new f.a() {
            /* class com.tencent.mm.sandbox.updater.e.AnonymousClass1 */

            @Override // com.tencent.xweb.x5.sdk.f.a
            public final void onNeedDownloadFinish(boolean z, int i2) {
                AppMethodBeat.i(32694);
                boolean isWifi = NetStatusUtil.isWifi(MMApplicationContext.getContext());
                boolean booleanExtra = e.this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
                Log.i("MicroMsg.TBSDownloadMgr", "TBS download onNeedDownloadFinish, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(isWifi), Boolean.valueOf(booleanExtra));
                if ((isWifi || booleanExtra) && z) {
                    e.a(e.this);
                    AppMethodBeat.o(32694);
                    return;
                }
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.sandbox.updater.e.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(32693);
                        UpdaterService.fK();
                        AppMethodBeat.o(32693);
                    }
                }, 500);
                AppMethodBeat.o(32694);
            }
        });
        boolean isWifi = NetStatusUtil.isWifi(context);
        boolean booleanExtra = this.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
        Log.i("MicroMsg.TBSDownloadMgr", "TBS download, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", Integer.valueOf(installedTbsCoreVersion), Boolean.valueOf(a2), Boolean.valueOf(isWifi), Boolean.valueOf(booleanExtra));
        if ((isWifi || booleanExtra) && a2) {
            dZb();
            AppMethodBeat.o(32702);
            return true;
        } else if (isWifi || booleanExtra) {
            AppMethodBeat.o(32702);
            return true;
        } else {
            AppMethodBeat.o(32702);
            return false;
        }
    }

    @Override // com.tencent.mm.sandbox.updater.a
    public final boolean isBusy() {
        AppMethodBeat.i(32703);
        boolean isDownloading = f.isDownloading();
        boolean tBSInstalling = com.tencent.xweb.x5.sdk.d.getTBSInstalling();
        Log.i("MicroMsg.TBSDownloadMgr", "isBusy isDownloading = %b, isInstalling = %b", Boolean.valueOf(isDownloading), Boolean.valueOf(tBSInstalling));
        if (isDownloading || tBSInstalling) {
            AppMethodBeat.o(32703);
            return true;
        }
        AppMethodBeat.o(32703);
        return false;
    }

    @Override // com.tencent.mm.sandbox.updater.a
    public final void onDestroy() {
        AppMethodBeat.i(32704);
        Log.i("MicroMsg.TBSDownloadMgr", "onDestroy");
        AppMethodBeat.o(32704);
    }

    /* access modifiers changed from: package-private */
    public final class a implements h {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }

        @Override // com.tencent.xweb.x5.sdk.h
        public final void onDownloadFinish(int i2) {
            AppMethodBeat.i(32695);
            Log.i("MicroMsg.MyTbsListener", "onDownloadFinish, result = %d", Integer.valueOf(i2));
            r.gH(5, i2);
            if (i2 != 110) {
                if (i2 == 100) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(64, 64, 4, 3, 1, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(64, 3, 1, false);
                }
            }
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                Log.i("MicroMsg.MyTbsListener", "tbs has download finished, save to sharedpreference");
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("tbs_download_finished", true);
                edit.apply();
            }
            AppMethodBeat.o(32695);
        }

        @Override // com.tencent.xweb.x5.sdk.h
        public final void onInstallFinish(int i2) {
            AppMethodBeat.i(32696);
            Log.i("MicroMsg.MyTbsListener", "onInstallFinish, result = %d", Integer.valueOf(i2));
            r.gH(6, i2);
            if (i2 == 200 || i2 == 220) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(64, 64, 7, 6, 1, 1, false);
                e.b(e.this);
                AppMethodBeat.o(32696);
                return;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(64, 6, 1, false);
            AppMethodBeat.o(32696);
        }

        @Override // com.tencent.xweb.x5.sdk.h
        public final void onDownloadProgress(int i2) {
        }
    }

    static /* synthetic */ void b(e eVar) {
        AppMethodBeat.i(32706);
        if (eVar.NFg) {
            String topActivityName = Util.getTopActivityName(MMApplicationContext.getContext());
            Log.i("MicroMsg.TBSDownloadMgr", "topActivityName = %s", topActivityName);
            if (Util.isNullOrNil(topActivityName) || !topActivityName.equalsIgnoreCase("com.tencent.mm.plugin.webview.ui.tools.WebViewUI")) {
                d.bpG("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                Context context = MMApplicationContext.getContext();
                s.c cd = com.tencent.mm.bq.a.cd(context, "reminder_channel_id");
                cd.as(com.tencent.mm.bq.a.ezb());
                cd.f(context.getString(R.string.j0g));
                cd.g(context.getString(R.string.j0f));
                cd.g(2, false);
                cd.E(true);
                cd.Hv = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, new Intent(), 0);
                eVar.kYy = cd.build();
                ((NotificationManager) context.getSystemService("notification")).notify(eVar.kYM, eVar.kYy);
                d.hiy();
            }
        }
        AppMethodBeat.o(32706);
    }
}
