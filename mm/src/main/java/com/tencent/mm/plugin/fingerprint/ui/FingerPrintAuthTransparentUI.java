package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fingerprint.d.b;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@a(7)
public class FingerPrintAuthTransparentUI extends WalletBaseUI implements b {
    Dialog mProgressDialog;
    View view = null;
    private int wFZ = 0;
    private c wFc = new c() {
        /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.fingerprint.d.c
        public final void gz(int i2, int i3) {
            AppMethodBeat.i(64482);
            switch (i2) {
                case 0:
                    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "identify success");
                    FingerPrintAuthTransparentUI.this.wGo = i3;
                    FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this);
                    AppMethodBeat.o(64482);
                    return;
                case 2001:
                    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "identify timeout");
                    AppMethodBeat.o(64482);
                    return;
                case 2002:
                    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                    FingerPrintAuthTransparentUI.b(FingerPrintAuthTransparentUI.this);
                    FingerPrintAuthTransparentUI.c(FingerPrintAuthTransparentUI.this);
                    AppMethodBeat.o(64482);
                    return;
                case 2005:
                    String string = MMApplicationContext.getContext().getString(R.string.hd6);
                    com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, i2, "fingerprint error");
                    FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, string);
                    AppMethodBeat.o(64482);
                    return;
                case 2007:
                case 10308:
                    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", Integer.valueOf(i2));
                    String string2 = MMApplicationContext.getContext().getString(R.string.hd4);
                    if (i2 == 10308) {
                        string2 = MMApplicationContext.getContext().getString(R.string.hd5);
                        com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
                    } else {
                        com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, i2, "fingerprint error");
                    }
                    FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, string2);
                    AppMethodBeat.o(64482);
                    return;
                case 2009:
                    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", Integer.valueOf(i2));
                    String string3 = MMApplicationContext.getContext().getString(R.string.hd4);
                    com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, i2, "fingerprint error");
                    com.tencent.mm.plugin.soter.d.a.aaw(2);
                    FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, string3);
                    break;
            }
            AppMethodBeat.o(64482);
        }
    };
    private i wGm = null;
    private d wGn = null;
    private int wGo = -1;
    private Animation wGp;
    private boolean wGq = false;
    private int wGr = 0;
    private boolean wGs = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FingerPrintAuthTransparentUI() {
        AppMethodBeat.i(64497);
        AppMethodBeat.o(64497);
    }

    static /* synthetic */ void a(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI, int i2, String str) {
        AppMethodBeat.i(64515);
        fingerPrintAuthTransparentUI.bl(i2, str);
        AppMethodBeat.o(64515);
    }

    static /* synthetic */ void d(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        AppMethodBeat.i(64516);
        fingerPrintAuthTransparentUI.dKF();
        AppMethodBeat.o(64516);
    }

    static /* synthetic */ void dKH() {
        AppMethodBeat.i(64521);
        dKE();
        AppMethodBeat.o(64521);
    }

    static /* synthetic */ void e(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        AppMethodBeat.i(64517);
        fingerPrintAuthTransparentUI.dKG();
        AppMethodBeat.o(64517);
    }

    static /* synthetic */ void g(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        AppMethodBeat.i(64520);
        fingerPrintAuthTransparentUI.dKD();
        AppMethodBeat.o(64520);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        String string;
        AppMethodBeat.i(64498);
        super.onCreate(bundle);
        Log.i("MicroMsg.FingerPrintAuthTransparentUI", "launch FingerPrintAuthTransparentUI");
        com.tencent.mm.plugin.fingerprint.b.a.i iVar = (com.tencent.mm.plugin.fingerprint.b.a.i) g.af(com.tencent.mm.plugin.fingerprint.b.a.i.class);
        if (!iVar.dKq()) {
            Log.e("MicroMsg.FingerPrintAuthTransparentUI", "device is not support FingerPrintAuth or load fingerpringauth so failed, finish UI!");
            finish();
            AppMethodBeat.o(64498);
        } else if (z.aUo()) {
            Log.e("MicroMsg.FingerPrintAuthTransparentUI", "now account is isPayUPay, finish UI!");
            finish();
            AppMethodBeat.o(64498);
        } else if (iVar.dKn()) {
            Log.e("MicroMsg.FingerPrintAuthTransparentUI", "getIsOpenFPFromLocal is true, finish UI!");
            finish();
            AppMethodBeat.o(64498);
        } else if (!iVar.dKr()) {
            Log.e("MicroMsg.FingerPrintAuthTransparentUI", "isWxHasFingerPrint is false, finish UI!");
            finish();
            AppMethodBeat.o(64498);
        } else {
            an fQI = t.fQI();
            this.wGn = iVar.dKv();
            this.wGs = g.aAh().azQ().getBoolean(ar.a.USERINFO_FINGER_PRINT_LAST_IS_SEVERE_ERROR_BOOLEAN_SYNC, false);
            if (!fQI.fRk() || iVar.dKn()) {
                Log.i("MicroMsg.FingerPrintAuthTransparentUI", "isReg?:" + fQI.fRk() + ";isOpenTouch:" + iVar.dKn());
                Log.e("MicroMsg.FingerPrintAuthTransparentUI", "finish FingerPrintAuthTransparentUI, not show the open guide!");
                finish();
                AppMethodBeat.o(64498);
                return;
            }
            Log.e("MicroMsg.FingerPrintAuthTransparentUI", "show fingerprint auth open guide!");
            f.hlO().hlP();
            h.INSTANCE.a(12924, 1);
            com.tencent.mm.plugin.soter.d.a.aat(0);
            if (getIntent().getBooleanExtra("key_show_guide", true)) {
                if (g.aAh().azQ().getBoolean(ar.a.USERINFO_FINGER_PRINT_IS_FIRST_SHOWN_BOOLEAN_SYNC, true)) {
                    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: first show. no check box");
                    g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_IS_FIRST_SHOWN_BOOLEAN_SYNC, Boolean.FALSE);
                    g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_LAST_IS_SEVERE_ERROR_BOOLEAN_SYNC, Boolean.FALSE);
                    if (this.wGs) {
                        string = getString(R.string.dwx);
                    } else {
                        string = getString(R.string.dww);
                    }
                    com.tencent.mm.ui.base.h.a((Context) this, string, "", getString(R.string.am5), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.AnonymousClass10 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(64491);
                            FingerPrintAuthTransparentUI.e(FingerPrintAuthTransparentUI.this);
                            AppMethodBeat.o(64491);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.AnonymousClass11 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(64492);
                            FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, false);
                            AppMethodBeat.o(64492);
                        }
                    });
                    g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_COUNT_INT_SYNC, (Object) 1);
                    this.wGr = 1;
                    com.tencent.mm.plugin.soter.d.a.ja(1, this.wGr);
                    AppMethodBeat.o(64498);
                    return;
                }
                Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: already shown before. show dialog with check box");
                View inflate = LayoutInflater.from(this).inflate(R.layout.alm, (ViewGroup) null);
                final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.d4u);
                this.wGr = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_COUNT_INT_SYNC, (Object) null)).intValue() + 1;
                g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_COUNT_INT_SYNC, Integer.valueOf(this.wGr));
                com.tencent.mm.plugin.soter.d.a.ja(1, this.wGr);
                com.tencent.mm.ui.base.h.a((Context) this, false, (String) null, inflate, getString(R.string.am5), getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.AnonymousClass12 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(64493);
                        FingerPrintAuthTransparentUI.e(FingerPrintAuthTransparentUI.this);
                        AppMethodBeat.o(64493);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.AnonymousClass13 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(64494);
                        FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, checkBox.isChecked());
                        AppMethodBeat.o(64494);
                    }
                });
                AppMethodBeat.o(64498);
            } else if (getIntent().getBooleanExtra("isFromKinda", false)) {
                com.tencent.mm.plugin.soter.d.a.ja(3, this.wGr);
                String stringExtra = getIntent().getStringExtra("kindaPayPwd");
                if (stringExtra != null) {
                    this.wGn.a(this, new b() {
                        /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.AnonymousClass14 */

                        @Override // com.tencent.mm.plugin.fingerprint.d.b
                        public final void bg(int i2, String str) {
                            AppMethodBeat.i(64495);
                            FingerPrintAuthTransparentUI.this.ku(false);
                            if (i2 == 0) {
                                Log.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
                                FingerPrintAuthTransparentUI.f(FingerPrintAuthTransparentUI.this);
                                FingerPrintAuthTransparentUI.g(FingerPrintAuthTransparentUI.this);
                                AppMethodBeat.o(64495);
                                return;
                            }
                            FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
                            AppMethodBeat.o(64495);
                        }
                    }, stringExtra);
                    ku(true);
                }
                this.mController.setStatusBarColor(getResources().getColor(R.color.afz));
                AppMethodBeat.o(64498);
            } else {
                dKG();
                AppMethodBeat.o(64498);
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(64499);
        super.onResume();
        if (this.wGq) {
            dKD();
        }
        AppMethodBeat.o(64499);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(64500);
        super.onPause();
        Log.i("MicroMsg.FingerPrintAuthTransparentUI", "alvinluo onPause");
        PowerManager.WakeLock newWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        dKE();
        if (newWakeLock != null) {
            newWakeLock.release();
        }
        AppMethodBeat.o(64500);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(64501);
        super.onStop();
        finish();
        AppMethodBeat.o(64501);
    }

    private void dKD() {
        AppMethodBeat.i(64502);
        this.wGn.a(getContext(), new b() {
            /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.fingerprint.d.b
            public final void bg(int i2, String str) {
                AppMethodBeat.i(64489);
                if (i2 == 0) {
                    FingerPrintAuthTransparentUI.d(FingerPrintAuthTransparentUI.this);
                    AppMethodBeat.o(64489);
                } else if (i2 == -1) {
                    FingerPrintAuthTransparentUI.b(FingerPrintAuthTransparentUI.this);
                    AppMethodBeat.o(64489);
                } else {
                    FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, R.string.dbz, str);
                    AppMethodBeat.o(64489);
                }
            }
        });
        AppMethodBeat.o(64502);
    }

    private static void dKE() {
        AppMethodBeat.i(64503);
        Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled");
        ((com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
        AppMethodBeat.o(64503);
    }

    private void dKF() {
        AppMethodBeat.i(64504);
        d dVar = this.wGn;
        new StringBuilder().append(this.wGo);
        dVar.a(this, 2);
        AppMethodBeat.o(64504);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64505);
        boolean onSceneEnd = this.wGn.onSceneEnd(i2, i3, str, qVar);
        AppMethodBeat.o(64505);
        return onSceneEnd;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    private void dKG() {
        AppMethodBeat.i(64506);
        com.tencent.mm.plugin.soter.d.a.ja(3, this.wGr);
        Intent intent = getIntent();
        String str = "";
        if (intent != null) {
            str = intent.getStringExtra("key_pwd1");
        }
        this.wGn.a(this, new b() {
            /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.AnonymousClass15 */

            @Override // com.tencent.mm.plugin.fingerprint.d.b
            public final void bg(int i2, String str) {
                AppMethodBeat.i(64496);
                FingerPrintAuthTransparentUI.this.ku(false);
                if (i2 == 0) {
                    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
                    FingerPrintAuthTransparentUI.f(FingerPrintAuthTransparentUI.this);
                    FingerPrintAuthTransparentUI.g(FingerPrintAuthTransparentUI.this);
                    AppMethodBeat.o(64496);
                    return;
                }
                FingerPrintAuthTransparentUI.a(FingerPrintAuthTransparentUI.this, -1, str);
                AppMethodBeat.o(64496);
            }
        }, str);
        ku(true);
        if (this.wGm != null && this.wGm.isShowing()) {
            this.wGm.dismiss();
        }
        AppMethodBeat.o(64506);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(64507);
        if (this.wGn != null) {
            this.wGn.clear();
        }
        super.finish();
        AppMethodBeat.o(64507);
    }

    private void bl(int i2, String str) {
        String str2;
        AppMethodBeat.i(64508);
        if (TextUtils.isEmpty(str)) {
            str2 = getString(i2);
        } else {
            str2 = str;
        }
        com.tencent.mm.ui.base.h.a((Context) this, str2, "", getString(R.string.idg), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(64486);
                Log.i("MicroMsg.FingerPrintAuthTransparentUI", "showErrorAlert, finish ui!");
                dialogInterface.dismiss();
                FingerPrintAuthTransparentUI.this.finish();
                AppMethodBeat.o(64486);
            }
        });
        AppMethodBeat.o(64508);
    }

    /* access modifiers changed from: protected */
    public final void ku(boolean z) {
        AppMethodBeat.i(64509);
        if (z) {
            this.mProgressDialog = com.tencent.mm.wallet_core.ui.h.a((Context) this, false, (DialogInterface.OnCancelListener) null);
            AppMethodBeat.o(64509);
            return;
        }
        if (this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
            this.mProgressDialog = null;
        }
        AppMethodBeat.o(64509);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64510);
        if (this.wGm != null && this.wGm.isShowing()) {
            this.wGm.dismiss();
            this.wGm = null;
        }
        if (this.wGp != null) {
            this.wGp.cancel();
        }
        ku(false);
        super.onDestroy();
        AppMethodBeat.o(64510);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.b
    public final void bg(int i2, String str) {
        String str2;
        AppMethodBeat.i(64511);
        ku(false);
        if (i2 == 0) {
            Log.i("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay success");
            doSceneProgress(new ad(null, 19), false);
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dc2), getString(R.string.dby), getString(R.string.imn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(64485);
                    dialogInterface.dismiss();
                    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "showSuccessAlert, finish ui!");
                    FingerPrintAuthTransparentUI.this.finish();
                    AppMethodBeat.o(64485);
                }
            });
            AppMethodBeat.o(64511);
        } else if (i2 == -2) {
            Log.e("MicroMsg.FingerPrintAuthTransparentUI", "open fingerprintpay failed");
            if (TextUtils.isEmpty(str)) {
                str2 = getString(R.string.dbz);
            } else {
                str2 = str;
            }
            com.tencent.mm.ui.base.h.a((Context) this, str2, "", getString(R.string.dc7), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(64487);
                    Log.i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
                    FingerPrintAuthTransparentUI.f(FingerPrintAuthTransparentUI.this);
                    FingerPrintAuthTransparentUI.g(FingerPrintAuthTransparentUI.this);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(64487);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(64488);
                    FingerPrintAuthTransparentUI.this.finish();
                    AppMethodBeat.o(64488);
                }
            });
            AppMethodBeat.o(64511);
        } else {
            bl(-1, str);
            AppMethodBeat.o(64511);
        }
    }

    static /* synthetic */ void a(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        AppMethodBeat.i(64512);
        fingerPrintAuthTransparentUI.wGq = false;
        dKE();
        if (fingerPrintAuthTransparentUI.wGm != null && fingerPrintAuthTransparentUI.wGm.isShowing()) {
            fingerPrintAuthTransparentUI.wGm.dismiss();
        }
        fingerPrintAuthTransparentUI.dKF();
        AppMethodBeat.o(64512);
    }

    static /* synthetic */ void b(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        AppMethodBeat.i(64513);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthTransparentUI.wFZ > 1) {
            fingerPrintAuthTransparentUI.wFZ = currentTimeMillis;
            ((TextView) fingerPrintAuthTransparentUI.view.findViewById(R.id.iov)).setVisibility(8);
            final TextView textView = (TextView) fingerPrintAuthTransparentUI.view.findViewById(R.id.c4t);
            textView.setVisibility(4);
            if (fingerPrintAuthTransparentUI.wGp == null) {
                fingerPrintAuthTransparentUI.wGp = AnimationUtils.loadAnimation(fingerPrintAuthTransparentUI.getContext(), R.anim.bt);
            }
            textView.startAnimation(fingerPrintAuthTransparentUI.wGp);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(64490);
                    textView.setVisibility(0);
                    AppMethodBeat.o(64490);
                }
            }, fingerPrintAuthTransparentUI.wGp.getDuration());
            AppMethodBeat.o(64513);
            return;
        }
        AppMethodBeat.o(64513);
    }

    static /* synthetic */ void c(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        AppMethodBeat.i(64514);
        com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        aVar.userCancel();
        if (!aVar.dJU()) {
            Log.e("MicroMsg.FingerPrintAuthTransparentUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
            AppMethodBeat.o(64514);
            return;
        }
        aVar.a(fingerPrintAuthTransparentUI.wFc, true);
        AppMethodBeat.o(64514);
    }

    static /* synthetic */ void a(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI, boolean z) {
        AppMethodBeat.i(64518);
        com.tencent.mm.plugin.soter.d.a.ja(2, fingerPrintAuthTransparentUI.wGr);
        if (z) {
            com.tencent.mm.plugin.soter.d.a.d(10, -1000223, -1, "user permanent cancelled");
            Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled and checked as not show anymore");
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.TRUE);
        } else {
            Log.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: user cancelled but will show again");
            com.tencent.mm.plugin.soter.d.a.d(1, -1000223, -1, "user cancelled");
        }
        fingerPrintAuthTransparentUI.finish();
        AppMethodBeat.o(64518);
    }

    static /* synthetic */ void f(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        ViewGroup viewGroup;
        AppMethodBeat.i(64519);
        Log.i("MicroMsg.FingerPrintAuthTransparentUI", "showIdentifyUI!");
        fingerPrintAuthTransparentUI.view = LayoutInflater.from(fingerPrintAuthTransparentUI).inflate(R.layout.alj, (ViewGroup) null);
        ViewParent parent = fingerPrintAuthTransparentUI.view.getParent();
        if (parent != null) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ((ImageView) fingerPrintAuthTransparentUI.view.findViewById(R.id.d4j)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(64483);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/ui/FingerPrintAuthTransparentUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (FingerPrintAuthTransparentUI.this.wGm != null) {
                    FingerPrintAuthTransparentUI.this.wGm.cancel();
                }
                FingerPrintAuthTransparentUI.dKH();
                FingerPrintAuthTransparentUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/ui/FingerPrintAuthTransparentUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64483);
            }
        });
        if (fingerPrintAuthTransparentUI.wGm != null && fingerPrintAuthTransparentUI.wGm.isShowing()) {
            fingerPrintAuthTransparentUI.wGm.dismiss();
            fingerPrintAuthTransparentUI.wGm = null;
        }
        fingerPrintAuthTransparentUI.wGm = new i(fingerPrintAuthTransparentUI, R.style.a69);
        fingerPrintAuthTransparentUI.wGm.setContentView(fingerPrintAuthTransparentUI.view);
        fingerPrintAuthTransparentUI.wGm.setCanceledOnTouchOutside(false);
        fingerPrintAuthTransparentUI.wGm.setCancelable(true);
        fingerPrintAuthTransparentUI.wGm.show();
        fingerPrintAuthTransparentUI.wGm.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.AnonymousClass3 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(64484);
                dialogInterface.dismiss();
                FingerPrintAuthTransparentUI.dKH();
                FingerPrintAuthTransparentUI.this.finish();
                AppMethodBeat.o(64484);
            }
        });
        com.tencent.mm.ui.base.h.a(fingerPrintAuthTransparentUI, fingerPrintAuthTransparentUI.wGm);
        AppMethodBeat.o(64519);
    }
}
