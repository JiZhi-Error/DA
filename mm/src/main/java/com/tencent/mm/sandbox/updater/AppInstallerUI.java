package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.i.g;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sandbox.updater.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.d;

public class AppInstallerUI extends MMBaseActivity {
    private static AppInstallerUI NEu = null;
    private int EtH;
    private d NEt = null;
    private DialogInterface.OnClickListener NEv = new DialogInterface.OnClickListener() {
        /* class com.tencent.mm.sandbox.updater.AppInstallerUI.AnonymousClass2 */

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(32612);
            Log.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
            if (AppInstallerUI.this.EtH == 2) {
                j.aL(AppInstallerUI.this, 3);
            }
            String aFr = c.aFr(AppInstallerUI.this.md5);
            Log.d("MicroMsg.AppInstallerUI", aFr);
            if (aFr != null) {
                k.a.NFZ.bC(1, true);
                h.INSTANCE.idkeyStat(405, 72, 1, true);
                AppInstallerUI.a(AppInstallerUI.this, aFr);
                AppMethodBeat.o(32612);
                return;
            }
            h.INSTANCE.idkeyStat(405, 73, 1, true);
            Log.e("MicroMsg.AppInstallerUI", "pack not found!");
            com.tencent.mm.ui.base.h.cD(AppInstallerUI.this, AppInstallerUI.this.getString(R.string.hsk));
            j.gwv();
            AppInstallerUI.this.finish();
            AppMethodBeat.o(32612);
        }
    };
    private String desc;
    private d kdo = null;
    private String md5;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppInstallerUI() {
        AppMethodBeat.i(32616);
        AppMethodBeat.o(32616);
    }

    public static AppInstallerUI gwa() {
        return NEu;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(32617);
        super.onCreate(bundle);
        Log.d("MicroMsg.AppInstallerUI", "onCreate");
        com.tencent.mm.sandbox.c.q(hashCode(), this);
        MMActivity.initLanguage(this);
        if (AppUpdaterUI.gwb() != null && !AppUpdaterUI.gwb().isFinishing()) {
            Log.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
            finish();
            AppMethodBeat.o(32617);
        } else if (NEu == null || NEu.isFinishing() || NEu == this) {
            NEu = this;
            this.md5 = j.gnt();
            if (Util.isNullOrNil(this.md5) || c.aFr(this.md5) == null) {
                finish();
                AppMethodBeat.o(32617);
                return;
            }
            this.desc = j.gwn();
            this.EtH = j.gwo();
            setContentView(R.layout.a3o);
            d.a aVar = new d.a(this);
            aVar.aoO(R.string.dgd);
            aVar.Dk(true);
            aVar.f(new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.sandbox.updater.AppInstallerUI.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(32611);
                    AppInstallerUI.a(AppInstallerUI.this);
                    AppMethodBeat.o(32611);
                }
            });
            aVar.boo(getString(R.string.dgg, new Object[]{this.desc}));
            aVar.aoV(R.string.e3o).a(false, this.NEv);
            aVar.aoW(R.string.hsi).d(null);
            this.kdo = aVar.hbn();
            this.kdo.setCanceledOnTouchOutside(false);
            this.kdo.show();
            h.INSTANCE.idkeyStat(405, 71, 1, true);
            if (this.EtH == 2) {
                j.l(this, 2, j.gwp() + 1);
            }
            AppMethodBeat.o(32617);
        } else {
            Log.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
            finish();
            AppMethodBeat.o(32617);
        }
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(32618);
        Log.d("MicroMsg.AppInstallerUI", "onDestroy");
        if (this.kdo != null && this.kdo.isShowing()) {
            this.kdo.dismiss();
        }
        if (this.NEt != null && this.NEt.isShowing()) {
            this.NEt.dismiss();
        }
        if (NEu == this) {
            NEu = null;
        }
        com.tencent.mm.sandbox.c.r(hashCode(), this);
        super.onDestroy();
        AppMethodBeat.o(32618);
    }

    static /* synthetic */ void a(AppInstallerUI appInstallerUI) {
        AppMethodBeat.i(32619);
        Log.d("MicroMsg.AppInstallerUI", "showInstallCancelAlert");
        if (appInstallerUI.kdo != null && appInstallerUI.kdo.isShowing()) {
            appInstallerUI.kdo.dismiss();
        }
        if (appInstallerUI.NEt == null || !appInstallerUI.NEt.isShowing()) {
            appInstallerUI.NEt = com.tencent.mm.ui.base.h.a((Context) appInstallerUI, (int) R.string.ams, (int) R.string.zb, (int) R.string.amt, (int) R.string.biv, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.sandbox.updater.AppInstallerUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(32614);
                    Log.d("MicroMsg.AppInstallerUI", "install dialog had been canceled");
                    if (AppInstallerUI.this.kdo != null && AppInstallerUI.this.kdo.isShowing()) {
                        AppInstallerUI.this.kdo.dismiss();
                    }
                    k.a.NFZ.bC(2, true);
                    if (AppInstallerUI.this.EtH == 2) {
                        j.aL(AppInstallerUI.this, 4);
                    }
                    h.INSTANCE.idkeyStat(405, 74, 1, true);
                    j.gwq();
                    AppInstallerUI.d(AppInstallerUI.this);
                    AppMethodBeat.o(32614);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.sandbox.updater.AppInstallerUI.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(32615);
                    h.INSTANCE.idkeyStat(405, 75, 1, true);
                    if (AppInstallerUI.this.kdo != null && !AppInstallerUI.this.kdo.isShowing()) {
                        AppInstallerUI.this.kdo.show();
                    }
                    AppMethodBeat.o(32615);
                }
            });
            AppMethodBeat.o(32619);
            return;
        }
        Log.d("MicroMsg.AppInstallerUI", "cancelDialog already shown");
        AppMethodBeat.o(32619);
    }

    static /* synthetic */ void a(AppInstallerUI appInstallerUI, final String str) {
        AppMethodBeat.i(32620);
        new MMHandler().postDelayed(new Runnable() {
            /* class com.tencent.mm.sandbox.updater.AppInstallerUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(32613);
                g.aZ(AppInstallerUI.this, str);
                AppInstallerUI.d(AppInstallerUI.this);
                AppMethodBeat.o(32613);
            }
        }, 300);
        AppMethodBeat.o(32620);
    }

    static /* synthetic */ void d(AppInstallerUI appInstallerUI) {
        AppMethodBeat.i(32621);
        appInstallerUI.finish();
        AppMethodBeat.o(32621);
    }
}
