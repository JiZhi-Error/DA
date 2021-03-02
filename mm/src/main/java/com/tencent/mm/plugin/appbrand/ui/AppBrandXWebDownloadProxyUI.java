package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cr.d;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.xweb.ah;
import com.tencent.xweb.w;
import com.tencent.xweb.xwalk.c;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandXWebDownloadProxyUI extends MMActivity {
    private static boolean nUg = false;
    private Handler mHandler;
    private Runnable nUk;
    private c nYD = null;
    q tipDialog;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(AppBrandXWebDownloadProxyUI appBrandXWebDownloadProxyUI) {
        AppMethodBeat.i(48906);
        appBrandXWebDownloadProxyUI.startTimer();
        AppMethodBeat.o(48906);
    }

    static {
        AppMethodBeat.i(48908);
        d.kT(MMApplicationContext.getContext());
        AppMethodBeat.o(48908);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(48903);
        super.onCreate(bundle);
        Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate");
        y.e(getWindow());
        Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onCreate, kill tool");
        d.bpG("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        boolean isBusy = w.isBusy();
        Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "now status, downloading = %b", Boolean.valueOf(isBusy));
        if (isBusy) {
            Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download");
            if (nUg) {
                setResult(0, new Intent());
                finish();
                AppMethodBeat.o(48903);
                return;
            }
            if (this.nYD == null) {
                this.nYD = new a(this, (byte) 0);
            }
            ah.a(this.nYD);
            Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "is foreground download xweb already downloading, ignore duplicated request");
            AppCompatActivity context = getContext();
            getContext().getString(R.string.zb);
            this.tipDialog = h.a((Context) context, getContext().getString(R.string.sx), true, (DialogInterface.OnCancelListener) null);
            if (this.tipDialog.getWindow() != null) {
                WindowManager.LayoutParams attributes = this.tipDialog.getWindow().getAttributes();
                attributes.dimAmount = 0.0f;
                this.tipDialog.getWindow().setAttributes(attributes);
            }
            this.tipDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(48890);
                    Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "xweb already downloading, user cancel");
                    AppBrandXWebDownloadProxyUI.this.setResult(2, new Intent());
                    AppBrandXWebDownloadProxyUI.this.finish();
                    AppMethodBeat.o(48890);
                }
            });
            startTimer();
            AppMethodBeat.o(48903);
            return;
        }
        this.tipDialog = h.a((Context) getContext(), (String) null, true, (DialogInterface.OnCancelListener) null);
        this.tipDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(48892);
                Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "user cancel download");
                AppBrandXWebDownloadProxyUI.this.setResult(2, new Intent());
                AppBrandXWebDownloadProxyUI.this.finish();
                AppMethodBeat.o(48892);
            }
        });
        if (this.nYD == null) {
            this.nYD = new a(this, (byte) 0);
        }
        ah.a(this.nYD);
        w.hsB();
        AppMethodBeat.o(48903);
    }

    private void startTimer() {
        AppMethodBeat.i(48904);
        this.mHandler = new Handler();
        this.nUk = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(48891);
                boolean unused = AppBrandXWebDownloadProxyUI.nUg = true;
                AppBrandXWebDownloadProxyUI.this.setResult(0, new Intent());
                AppBrandXWebDownloadProxyUI.this.finish();
                AppMethodBeat.o(48891);
            }
        };
        this.mHandler.postDelayed(this.nUk, 20000);
        AppMethodBeat.o(48904);
    }

    final class a implements c {
        boolean nYG;

        private a() {
            this.nYG = false;
        }

        /* synthetic */ a(AppBrandXWebDownloadProxyUI appBrandXWebDownloadProxyUI, byte b2) {
            this();
        }

        @Override // com.tencent.xweb.xwalk.c
        public final boolean bXJ() {
            AppMethodBeat.i(48898);
            this.nYG = true;
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(48896);
                    AppBrandXWebDownloadProxyUI.b(AppBrandXWebDownloadProxyUI.this);
                    AppMethodBeat.o(48896);
                }
            });
            AppMethodBeat.o(48898);
            return true;
        }

        @Override // com.tencent.xweb.xwalk.c
        public final void zq(final int i2) {
            AppMethodBeat.i(48899);
            if (!this.nYG) {
                AppMethodBeat.o(48899);
                return;
            }
            Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDownloadProgress, percent = %d", Integer.valueOf(i2));
            if (AppBrandXWebDownloadProxyUI.this.tipDialog != null) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI.a.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(48897);
                        AppBrandXWebDownloadProxyUI.this.tipDialog.setMessage(AppBrandXWebDownloadProxyUI.this.getContext().getString(R.string.sy, new Object[]{String.valueOf(i2)}));
                        AppMethodBeat.o(48897);
                    }
                });
            }
            AppMethodBeat.o(48899);
        }

        @Override // com.tencent.xweb.xwalk.c
        public final void bXK() {
            AppMethodBeat.i(48900);
            AppBrandXWebDownloadProxyUI.this.nYD = null;
            ah.a(AppBrandXWebDownloadProxyUI.this.nYD);
            AppBrandXWebDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandXWebDownloadProxyUI.this.finish();
            AppMethodBeat.o(48900);
        }

        @Override // com.tencent.xweb.xwalk.c
        public final void bXL() {
            AppMethodBeat.i(48901);
            AppBrandXWebDownloadProxyUI.this.nYD = null;
            ah.a(AppBrandXWebDownloadProxyUI.this.nYD);
            AppBrandXWebDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandXWebDownloadProxyUI.this.finish();
            AppMethodBeat.o(48901);
        }

        @Override // com.tencent.xweb.xwalk.c
        public final void bXM() {
            AppMethodBeat.i(48902);
            AppBrandXWebDownloadProxyUI.this.nYD = null;
            ah.a(AppBrandXWebDownloadProxyUI.this.nYD);
            AppBrandXWebDownloadProxyUI.this.setResult(-1, new Intent());
            AppBrandXWebDownloadProxyUI.this.finish();
            AppMethodBeat.o(48902);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(48905);
        Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "onDestroy");
        this.nYD = null;
        ah.a(this.nYD);
        if (!(this.mHandler == null || this.nUk == null)) {
            this.mHandler.removeCallbacks(this.nUk);
        }
        super.onDestroy();
        AppMethodBeat.o(48905);
    }

    static /* synthetic */ void b(AppBrandXWebDownloadProxyUI appBrandXWebDownloadProxyUI) {
        AppMethodBeat.i(48907);
        Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "showNeedDownloadConfirmDialog finishing[%b] destroyed[%b]", Boolean.valueOf(appBrandXWebDownloadProxyUI.isFinishing()), Boolean.valueOf(appBrandXWebDownloadProxyUI.activityHasDestroyed()));
        if (appBrandXWebDownloadProxyUI.isFinishing() || appBrandXWebDownloadProxyUI.activityHasDestroyed()) {
            AppMethodBeat.o(48907);
            return;
        }
        AnonymousClass4 r0 = new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(48894);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(366, 2, 1, false);
                if (AppBrandXWebDownloadProxyUI.this.isFinishing() || AppBrandXWebDownloadProxyUI.this.activityHasDestroyed()) {
                    AppMethodBeat.o(48894);
                    return;
                }
                AppBrandXWebDownloadProxyUI appBrandXWebDownloadProxyUI = AppBrandXWebDownloadProxyUI.this;
                AppCompatActivity context = AppBrandXWebDownloadProxyUI.this.getContext();
                AppBrandXWebDownloadProxyUI.this.getContext().getString(R.string.zb);
                appBrandXWebDownloadProxyUI.tipDialog = h.a((Context) context, AppBrandXWebDownloadProxyUI.this.getContext().getString(R.string.sx), true, (DialogInterface.OnCancelListener) null);
                AppBrandXWebDownloadProxyUI.this.tipDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI.AnonymousClass4.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(48893);
                        Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "cancel loading download background");
                        AppBrandXWebDownloadProxyUI.this.setResult(2, new Intent());
                        AppBrandXWebDownloadProxyUI.this.finish();
                        AppMethodBeat.o(48893);
                    }
                });
                w.hsC();
                AppBrandXWebDownloadProxyUI.a(AppBrandXWebDownloadProxyUI.this);
                AppMethodBeat.o(48894);
            }
        };
        if (DebuggerShell.bAx()) {
            r0.onClick(null, 0);
            AppMethodBeat.o(48907);
            return;
        }
        AnonymousClass5 r1 = new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(48895);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(366, 3, 1, false);
                Log.i("MicroMsg.AppBrandXWebDownloadProxyUI", "user cancel");
                AppBrandXWebDownloadProxyUI.this.setResult(2, new Intent());
                AppBrandXWebDownloadProxyUI.this.finish();
                AppMethodBeat.o(48895);
            }
        };
        d.a aVar = new d.a(appBrandXWebDownloadProxyUI.getContext());
        aVar.boo(appBrandXWebDownloadProxyUI.getContext().getString(R.string.sw));
        aVar.Dk(false);
        aVar.aoV(R.string.sv).c(r0);
        aVar.aoW(R.string.su).d(r1);
        aVar.hbn().show();
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(366, 1, 1, false);
        AppMethodBeat.o(48907);
    }
}
