package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cr.d;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.xweb.x5.sdk.f;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandTBSDownloadProxyUI extends MMActivity {
    private static boolean nUg = false;
    private Handler mHandler;
    private Runnable nUk;
    private a nWJ = null;
    q tipDialog;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        AppMethodBeat.i(48806);
        appBrandTBSDownloadProxyUI.startTimer();
        AppMethodBeat.o(48806);
    }

    static {
        AppMethodBeat.i(48807);
        d.kT(MMApplicationContext.getContext());
        AppMethodBeat.o(48807);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(48801);
        super.onCreate(bundle);
        Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate");
        this.tipDialog = h.a((Context) getContext(), (String) null, true, (DialogInterface.OnCancelListener) null);
        this.tipDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(48793);
                Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
                AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
                AppBrandTBSDownloadProxyUI.this.finish();
                AppMethodBeat.o(48793);
            }
        });
        y.e(getWindow());
        Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate, kill tool");
        d.bpG("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        boolean isDownloading = f.isDownloading();
        boolean tBSInstalling = com.tencent.xweb.x5.sdk.d.getTBSInstalling();
        boolean isDownloadForeground = f.isDownloadForeground();
        Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "now status, downloading = %b, installing = %b", Boolean.valueOf(isDownloading), Boolean.valueOf(tBSInstalling));
        if (isDownloading || tBSInstalling) {
            if (isDownloadForeground) {
                Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download");
                if (nUg) {
                    setResult(0, new Intent());
                    finish();
                    AppMethodBeat.o(48801);
                    return;
                }
                if (this.nWJ == null) {
                    this.nWJ = new a(this, (byte) 0);
                }
                com.tencent.xweb.x5.sdk.d.a(this.nWJ);
                Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download TBS already downloading, ignore duplicated request");
                AppCompatActivity context = getContext();
                getContext().getString(R.string.zb);
                this.tipDialog = h.a((Context) context, getContext().getString(R.string.sx), true, (DialogInterface.OnCancelListener) null);
                if (this.tipDialog.getWindow() != null) {
                    WindowManager.LayoutParams attributes = this.tipDialog.getWindow().getAttributes();
                    attributes.dimAmount = 0.0f;
                    this.tipDialog.getWindow().setAttributes(attributes);
                }
                this.tipDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(48789);
                        Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
                        AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
                        AppBrandTBSDownloadProxyUI.this.finish();
                        AppMethodBeat.o(48789);
                    }
                });
                startTimer();
                AppMethodBeat.o(48801);
                return;
            }
            Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "isBackGroundDownload reset download");
            f.stopDownload();
        }
        Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download");
        f.a(getContext(), false, true, new f.a() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.AnonymousClass2 */

            @Override // com.tencent.xweb.x5.sdk.f.a
            public final void onNeedDownloadFinish(boolean z, int i2) {
                AppMethodBeat.i(48791);
                if (!z || i2 < 36824) {
                    Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download fail result %s version %d", Boolean.valueOf(z), Integer.valueOf(i2));
                    AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
                    AppBrandTBSDownloadProxyUI.this.finish();
                    AppMethodBeat.o(48791);
                    return;
                }
                Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download success result %s version %d", Boolean.valueOf(z), Integer.valueOf(i2));
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(48790);
                        Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onNeedDownloadFinish : showDialog");
                        AppBrandTBSDownloadProxyUI.a(AppBrandTBSDownloadProxyUI.this);
                        AppMethodBeat.o(48790);
                    }
                });
                AppMethodBeat.o(48791);
            }
        });
        AppMethodBeat.o(48801);
    }

    private void startTimer() {
        AppMethodBeat.i(48802);
        this.mHandler = new Handler();
        this.nUk = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(48792);
                boolean unused = AppBrandTBSDownloadProxyUI.nUg = true;
                AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
                AppBrandTBSDownloadProxyUI.this.finish();
                AppMethodBeat.o(48792);
            }
        };
        this.mHandler.postDelayed(this.nUk, 20000);
        AppMethodBeat.o(48802);
    }

    /* access modifiers changed from: package-private */
    public final class a implements com.tencent.xweb.x5.sdk.h {
        private a() {
        }

        /* synthetic */ a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI, byte b2) {
            this();
        }

        @Override // com.tencent.xweb.x5.sdk.h
        public final void onDownloadFinish(int i2) {
            AppMethodBeat.i(48798);
            Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadFinish, result = %d", Integer.valueOf(i2));
            r.gH(5, i2);
            if (i2 == 100 || i2 == 120 || i2 == 122) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(366, 4, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(366, 5, 1, false);
            }
            if (i2 != 110) {
                if (i2 == 100 || i2 == 120 || i2 == 122) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(64, 64, 4, 3, 1, 1, false);
                } else {
                    AppBrandTBSDownloadProxyUI.this.nWJ = null;
                    com.tencent.xweb.x5.sdk.d.a(AppBrandTBSDownloadProxyUI.this.nWJ);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(64, 3, 1, false);
                    AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
                    AppBrandTBSDownloadProxyUI.this.finish();
                }
                SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                if (sharedPreferences != null) {
                    Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean("tbs_download_finished", true);
                    edit.apply();
                }
                AppMethodBeat.o(48798);
                return;
            }
            SharedPreferences sharedPreferences2 = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences2 != null) {
                Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
                SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                edit2.putBoolean("tbs_download_finished", true);
                edit2.apply();
            }
            AppBrandTBSDownloadProxyUI.this.nWJ = null;
            com.tencent.xweb.x5.sdk.d.a(AppBrandTBSDownloadProxyUI.this.nWJ);
            AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandTBSDownloadProxyUI.this.finish();
            AppMethodBeat.o(48798);
        }

        @Override // com.tencent.xweb.x5.sdk.h
        public final void onInstallFinish(int i2) {
            AppMethodBeat.i(48799);
            Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, result = %d", Integer.valueOf(i2));
            if (AppBrandTBSDownloadProxyUI.this.tipDialog != null) {
                AppBrandTBSDownloadProxyUI.this.tipDialog.dismiss();
                AppBrandTBSDownloadProxyUI.this.tipDialog = null;
            }
            r.gH(6, i2);
            if (i2 == 200 || i2 == 220) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(64, 64, 7, 6, 1, 1, false);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(366, 6, 1, false);
                Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, restart tool");
                d.hiy();
                AppBrandTBSDownloadProxyUI.this.nWJ = null;
                com.tencent.xweb.x5.sdk.d.a(AppBrandTBSDownloadProxyUI.this.nWJ);
                AppBrandTBSDownloadProxyUI.this.setResult(-1, new Intent());
                AppBrandTBSDownloadProxyUI.this.finish();
                AppMethodBeat.o(48799);
                return;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(64, 6, 1, false);
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(366, 7, 1, false);
            AppBrandTBSDownloadProxyUI.this.nWJ = null;
            com.tencent.xweb.x5.sdk.d.a(AppBrandTBSDownloadProxyUI.this.nWJ);
            AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandTBSDownloadProxyUI.this.finish();
            AppMethodBeat.o(48799);
        }

        @Override // com.tencent.xweb.x5.sdk.h
        public final void onDownloadProgress(final int i2) {
            AppMethodBeat.i(48800);
            Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadProgress, percent = %d", Integer.valueOf(i2));
            if (AppBrandTBSDownloadProxyUI.this.tipDialog != null) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(48797);
                        AppBrandTBSDownloadProxyUI.this.tipDialog.setMessage(AppBrandTBSDownloadProxyUI.this.getContext().getString(R.string.sy, new Object[]{String.valueOf(i2)}));
                        AppMethodBeat.o(48797);
                    }
                });
            }
            AppMethodBeat.o(48800);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(48803);
        Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDestroy");
        if (!(this.mHandler == null || this.nUk == null)) {
            this.mHandler.removeCallbacks(this.nUk);
        }
        super.onDestroy();
        AppMethodBeat.o(48803);
    }

    static /* synthetic */ void a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        AppMethodBeat.i(48804);
        if (appBrandTBSDownloadProxyUI.isFinishing() || appBrandTBSDownloadProxyUI.activityHasDestroyed()) {
            AppMethodBeat.o(48804);
            return;
        }
        AnonymousClass5 r0 = new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(48795);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(366, 2, 1, false);
                x.a.zL(false);
                r.pl(2);
                if (AppBrandTBSDownloadProxyUI.this.isFinishing() || AppBrandTBSDownloadProxyUI.this.activityHasDestroyed()) {
                    AppMethodBeat.o(48795);
                    return;
                }
                AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI = AppBrandTBSDownloadProxyUI.this;
                AppCompatActivity context = AppBrandTBSDownloadProxyUI.this.getContext();
                AppBrandTBSDownloadProxyUI.this.getContext().getString(R.string.zb);
                appBrandTBSDownloadProxyUI.tipDialog = h.a((Context) context, AppBrandTBSDownloadProxyUI.this.getContext().getString(R.string.sx), true, (DialogInterface.OnCancelListener) null);
                AppBrandTBSDownloadProxyUI.this.tipDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.AnonymousClass5.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(48794);
                        Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancel loading download background");
                        AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
                        AppBrandTBSDownloadProxyUI.this.finish();
                        AppMethodBeat.o(48794);
                    }
                });
                AppBrandTBSDownloadProxyUI.b(AppBrandTBSDownloadProxyUI.this);
                AppBrandTBSDownloadProxyUI.c(AppBrandTBSDownloadProxyUI.this);
                AppMethodBeat.o(48795);
            }
        };
        if (DebuggerShell.bAx()) {
            r0.onClick(null, 0);
            AppMethodBeat.o(48804);
            return;
        }
        AnonymousClass6 r1 = new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(48796);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(366, 3, 1, false);
                Log.i("MicroMsg.AppBrandTBSDownloadProxyUI", "user cancel");
                x.a.zL(false);
                AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
                AppBrandTBSDownloadProxyUI.this.finish();
                AppMethodBeat.o(48796);
            }
        };
        d.a aVar = new d.a(appBrandTBSDownloadProxyUI.getContext());
        aVar.boo(appBrandTBSDownloadProxyUI.getContext().getString(R.string.sw));
        aVar.Dk(false);
        aVar.aoV(R.string.sv).c(r0);
        aVar.aoW(R.string.su).d(r1);
        aVar.hbn().show();
        x.a.zL(true);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(366, 1, 1, false);
        AppMethodBeat.o(48804);
    }

    static /* synthetic */ void b(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        AppMethodBeat.i(48805);
        if (appBrandTBSDownloadProxyUI.nWJ == null) {
            appBrandTBSDownloadProxyUI.nWJ = new a(appBrandTBSDownloadProxyUI, (byte) 0);
        }
        com.tencent.xweb.x5.sdk.d.a(appBrandTBSDownloadProxyUI.nWJ);
        r.pl(3);
        f.startDownload(MMApplicationContext.getContext(), true);
        AppMethodBeat.o(48805);
    }
}
