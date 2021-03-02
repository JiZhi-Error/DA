package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.b;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.h;
import com.tencent.soter.a.g.f;
import java.lang.ref.WeakReference;

public class FingerPrintAuthUI extends WalletBaseUI implements b {
    private boolean isPaused = false;
    private Dialog mProgressDialog = null;
    private int wFZ = 0;
    private d wGn = null;
    private Animation wGp;
    private TextView wGu;
    private a wGv;
    private boolean wGw = false;
    private final int wGx = 1;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FingerPrintAuthUI fingerPrintAuthUI, String str, int i2) {
        AppMethodBeat.i(64546);
        fingerPrintAuthUI.dS(str, i2);
        AppMethodBeat.o(64546);
    }

    static /* synthetic */ void d(FingerPrintAuthUI fingerPrintAuthUI) {
        AppMethodBeat.i(64548);
        fingerPrintAuthUI.dKD();
        AppMethodBeat.o(64548);
    }

    static /* synthetic */ void f(FingerPrintAuthUI fingerPrintAuthUI) {
        AppMethodBeat.i(64549);
        fingerPrintAuthUI.dKI();
        AppMethodBeat.o(64549);
    }

    public class a implements c {
        private WeakReference<FingerPrintAuthUI> wGB = null;

        public a(FingerPrintAuthUI fingerPrintAuthUI) {
            AppMethodBeat.i(64529);
            this.wGB = new WeakReference<>(fingerPrintAuthUI);
            AppMethodBeat.o(64529);
        }

        private FingerPrintAuthUI dKJ() {
            AppMethodBeat.i(64530);
            if (this.wGB != null) {
                FingerPrintAuthUI fingerPrintAuthUI = this.wGB.get();
                AppMethodBeat.o(64530);
                return fingerPrintAuthUI;
            }
            AppMethodBeat.o(64530);
            return null;
        }

        @Override // com.tencent.mm.plugin.fingerprint.d.c
        public final void gz(int i2, int i3) {
            AppMethodBeat.i(64531);
            switch (i2) {
                case 0:
                    Log.i("MicroMsg.FingerPrintAuthUI", "identify success");
                    if (dKJ() != null) {
                        FingerPrintAuthUI.a(dKJ(), i3);
                        AppMethodBeat.o(64531);
                        return;
                    }
                    break;
                case 2001:
                    Log.i("MicroMsg.FingerPrintAuthUI", "identify timeout");
                    if (dKJ() != null) {
                        FingerPrintAuthUI.a(FingerPrintAuthUI.this, false);
                        AppMethodBeat.o(64531);
                        return;
                    }
                    break;
                case 2002:
                    Log.i("MicroMsg.FingerPrintAuthUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                    if (dKJ() != null) {
                        FingerPrintAuthUI.a(dKJ());
                        FingerPrintAuthUI.a(FingerPrintAuthUI.this, true);
                        AppMethodBeat.o(64531);
                        return;
                    }
                    break;
                case 2005:
                    String string = MMApplicationContext.getContext().getString(R.string.hd6);
                    com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, i2, "fingerprint error");
                    if (dKJ() != null) {
                        FingerPrintAuthUI.a(dKJ(), string, -1);
                        AppMethodBeat.o(64531);
                        return;
                    }
                    break;
                case 2007:
                case 10308:
                    Log.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", Integer.valueOf(i2));
                    String string2 = MMApplicationContext.getContext().getString(R.string.hd4);
                    if (i2 == 10308) {
                        string2 = MMApplicationContext.getContext().getString(R.string.hd5);
                        com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
                    } else {
                        com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, i2, "fingerprint error");
                    }
                    if (dKJ() != null) {
                        FingerPrintAuthUI.a(dKJ(), string2, -1);
                        AppMethodBeat.o(64531);
                        return;
                    }
                    break;
                case 2009:
                    Log.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", Integer.valueOf(i2));
                    String string3 = MMApplicationContext.getContext().getString(R.string.hd4);
                    com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, i2, "fingerprint error");
                    com.tencent.mm.plugin.soter.d.a.aaw(2);
                    if (dKJ() != null) {
                        FingerPrintAuthUI.a(dKJ(), string3, -1);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(64531);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64532);
        super.onCreate(bundle);
        setMMTitle(getString(R.string.fil));
        this.wGu = (TextView) findViewById(R.id.dz0);
        i iVar = (i) g.af(i.class);
        this.wGn = iVar.dKv();
        if (this.wGn == null) {
            dS(getString(R.string.dbz), -1);
            AppMethodBeat.o(64532);
            return;
        }
        Bundle bx = com.tencent.mm.wallet_core.a.bx(this);
        if (bx != null) {
            String string = bx.getString("pwd");
            if (TextUtils.isEmpty(string)) {
                Log.e("MicroMsg.FingerPrintAuthUI", "get user pwd error");
                dS(getString(R.string.dbz), -1);
                com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, -1, "get user pwd error");
                AppMethodBeat.o(64532);
            } else if (!iVar.dKr()) {
                dS(getString(R.string.imq), -1);
                AppMethodBeat.o(64532);
            } else if (iVar.dKq()) {
                ku(true);
                f.hlO().hlP();
                this.wGn.a(this, new b() {
                    /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.fingerprint.d.b
                    public final void bg(int i2, String str) {
                        AppMethodBeat.i(64522);
                        FingerPrintAuthUI.this.ku(false);
                        if (i2 == 0) {
                            FingerPrintAuthUI.this.wGw = true;
                            if (FingerPrintAuthUI.c(FingerPrintAuthUI.this)) {
                                FingerPrintAuthUI.d(FingerPrintAuthUI.this);
                                AppMethodBeat.o(64522);
                                return;
                            }
                        } else {
                            FingerPrintAuthUI.a(FingerPrintAuthUI.this, str, i2);
                        }
                        AppMethodBeat.o(64522);
                    }
                }, string);
                AppMethodBeat.o(64532);
            } else {
                Log.e("MicroMsg.FingerPrintAuthUI", "device is not support FingerPrintAuth");
                AppMethodBeat.o(64532);
            }
        } else {
            Log.e("MicroMsg.FingerPrintAuthUI", "contextdata is null,for that reason program can't get user pwd");
            dS(getString(R.string.dbz), -1);
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, -1, "contextdata is null,for that reason program can't get user pwd");
            AppMethodBeat.o(64532);
        }
    }

    /* access modifiers changed from: protected */
    public final void ku(final boolean z) {
        AppMethodBeat.i(64533);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(64523);
                if (z) {
                    FingerPrintAuthUI.this.mProgressDialog = h.c(FingerPrintAuthUI.this, false, null);
                    AppMethodBeat.o(64523);
                    return;
                }
                if (FingerPrintAuthUI.this.mProgressDialog != null && FingerPrintAuthUI.this.mProgressDialog.isShowing()) {
                    FingerPrintAuthUI.this.mProgressDialog.dismiss();
                    FingerPrintAuthUI.this.mProgressDialog = null;
                }
                AppMethodBeat.o(64523);
            }
        });
        AppMethodBeat.o(64533);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(64534);
        super.onResume();
        this.isPaused = false;
        if (this.wGw) {
            dKD();
        }
        AppMethodBeat.o(64534);
    }

    private void dKD() {
        AppMethodBeat.i(64535);
        Log.i("MicroMsg.FingerPrintAuthUI", "request Identify2");
        this.wGn.a(getContext(), new b() {
            /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.fingerprint.d.b
            public final void bg(int i2, String str) {
                AppMethodBeat.i(64524);
                if (i2 == 0) {
                    FingerPrintAuthUI.f(FingerPrintAuthUI.this);
                    AppMethodBeat.o(64524);
                } else if (i2 == -1) {
                    FingerPrintAuthUI.a(FingerPrintAuthUI.this);
                    AppMethodBeat.o(64524);
                } else {
                    FingerPrintAuthUI.a(FingerPrintAuthUI.this, str, i2);
                    AppMethodBeat.o(64524);
                }
            }
        });
        AppMethodBeat.o(64535);
    }

    private static void dKE() {
        AppMethodBeat.i(64536);
        Log.i("MicroMsg.FingerPrintAuthUI", "hy: user cancelled");
        ((com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).userCancel();
        AppMethodBeat.o(64536);
    }

    private void dKI() {
        AppMethodBeat.i(64537);
        this.wGn.a(this, 1);
        AppMethodBeat.o(64537);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(64538);
        super.onPause();
        this.isPaused = true;
        PowerManager.WakeLock newWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(536870913, "PostLocationService");
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        dKE();
        if (newWakeLock != null) {
            newWakeLock.release();
        }
        AppMethodBeat.o(64538);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64539);
        Log.i("MicroMsg.FingerPrintAuthUI", "hy: fingerprint auth ui on destroy");
        if (this.wGp != null) {
            this.wGp.cancel();
        }
        this.wGv = null;
        super.onDestroy();
        AppMethodBeat.o(64539);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64540);
        if (this.wGn.onSceneEnd(i2, i3, str, qVar)) {
            AppMethodBeat.o(64540);
            return true;
        } else if (qVar instanceof ad) {
            ku(false);
            com.tencent.mm.wallet_core.a.c(this, new Bundle(), 0);
            Toast.makeText(this, (int) R.string.dc0, 0).show();
            AppMethodBeat.o(64540);
            return true;
        } else {
            AppMethodBeat.o(64540);
            return false;
        }
    }

    private void dS(final String str, final int i2) {
        AppMethodBeat.i(64541);
        this.wGw = false;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(64527);
                String str = str;
                if (Util.isNullOrNil(str)) {
                    str = FingerPrintAuthUI.this.getString(R.string.dbz);
                }
                com.tencent.mm.ui.base.h.a((Context) FingerPrintAuthUI.this, str, "", FingerPrintAuthUI.this.getString(R.string.idg), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.AnonymousClass5.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(64526);
                        com.tencent.mm.wallet_core.a.c(FingerPrintAuthUI.this, new Bundle(), i2);
                        AppMethodBeat.o(64526);
                    }
                });
                AppMethodBeat.o(64527);
            }
        });
        AppMethodBeat.o(64541);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.alk;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.b
    public final void bg(int i2, String str) {
        AppMethodBeat.i(64542);
        if (i2 == 0) {
            Log.i("MicroMsg.FingerPrintAuthUI", "open fingerprintpay success");
            doSceneProgress(new ad(null, 19), false);
            AppMethodBeat.o(64542);
            return;
        }
        ku(false);
        Log.e("MicroMsg.FingerPrintAuthUI", "open fingerprintpay failed");
        com.tencent.mm.ui.base.h.d(this, getString(R.string.dbz), "", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(64528);
                com.tencent.mm.wallet_core.a.c(FingerPrintAuthUI.this, new Bundle(), -1);
                AppMethodBeat.o(64528);
            }
        });
        AppMethodBeat.o(64542);
    }

    static /* synthetic */ void a(FingerPrintAuthUI fingerPrintAuthUI, int i2) {
        AppMethodBeat.i(64543);
        fingerPrintAuthUI.wGw = false;
        dKE();
        String.valueOf(i2);
        fingerPrintAuthUI.dKI();
        AppMethodBeat.o(64543);
    }

    static /* synthetic */ void a(FingerPrintAuthUI fingerPrintAuthUI) {
        AppMethodBeat.i(64544);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - fingerPrintAuthUI.wFZ > 1) {
            fingerPrintAuthUI.wFZ = currentTimeMillis;
            fingerPrintAuthUI.wGu.setText(R.string.dbs);
            fingerPrintAuthUI.wGu.setTextColor(fingerPrintAuthUI.getResources().getColor(R.color.a5c));
            fingerPrintAuthUI.wGu.setVisibility(4);
            if (fingerPrintAuthUI.wGp == null) {
                fingerPrintAuthUI.wGp = AnimationUtils.loadAnimation(fingerPrintAuthUI.getContext(), R.anim.bt);
            }
            fingerPrintAuthUI.wGu.startAnimation(fingerPrintAuthUI.wGp);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(64525);
                    FingerPrintAuthUI.this.wGu.setVisibility(0);
                    AppMethodBeat.o(64525);
                }
            }, fingerPrintAuthUI.wGp.getDuration());
            AppMethodBeat.o(64544);
            return;
        }
        AppMethodBeat.o(64544);
    }

    static /* synthetic */ void a(FingerPrintAuthUI fingerPrintAuthUI, boolean z) {
        AppMethodBeat.i(64545);
        com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        aVar.userCancel();
        if (!aVar.dJU()) {
            Log.e("MicroMsg.FingerPrintAuthUI", "no fingerprints enrolled, use settings to enroll fingerprints first");
            AppMethodBeat.o(64545);
            return;
        }
        if (fingerPrintAuthUI.wGv == null) {
            fingerPrintAuthUI.wGv = new a(fingerPrintAuthUI);
        }
        aVar.a(fingerPrintAuthUI.wGv, z);
        AppMethodBeat.o(64545);
    }

    static /* synthetic */ boolean c(FingerPrintAuthUI fingerPrintAuthUI) {
        boolean z;
        AppMethodBeat.i(64547);
        Object[] objArr = new Object[1];
        if (!fingerPrintAuthUI.isPaused) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("MicroMsg.FingerPrintAuthUI", "hy: is screen on: %b", objArr);
        if (!fingerPrintAuthUI.isPaused) {
            AppMethodBeat.o(64547);
            return true;
        }
        AppMethodBeat.o(64547);
        return false;
    }
}
