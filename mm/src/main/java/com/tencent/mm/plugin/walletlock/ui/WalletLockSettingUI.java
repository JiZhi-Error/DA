package com.tencent.mm.plugin.walletlock.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.b.a.kz;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.d;

public class WalletLockSettingUI extends MMPreference {
    private IconPreference Ixe;
    private IconPreference Ixf;
    private IconPreference Ixg;
    private IconPreference Ixh;
    private boolean Ixi = false;
    private boolean Ixj = true;
    private boolean Ixk = true;
    private boolean Ixl = true;
    private int gwE = 0;
    private d jzT;
    private int mScene = -1;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WalletLockSettingUI walletLockSettingUI, String str) {
        AppMethodBeat.i(129966);
        walletLockSettingUI.M(0, 4, str);
        AppMethodBeat.o(129966);
    }

    static /* synthetic */ void b(WalletLockSettingUI walletLockSettingUI) {
        AppMethodBeat.i(129967);
        walletLockSettingUI.fVD();
        AppMethodBeat.o(129967);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.dd;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(129950);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(129946);
                if (WalletLockSettingUI.this.Ixi) {
                    WalletLockSettingUI.a(WalletLockSettingUI.this, "user cancel setting wallet lock");
                } else {
                    WalletLockSettingUI.this.finish();
                }
                AppMethodBeat.o(129946);
                return false;
            }
        });
        setMMTitle(R.string.ifh);
        this.screen = getPreferenceScreen();
        this.screen = getPreferenceScreen();
        this.Ixe = (IconPreference) this.screen.bmg("wallet_lock_fingerprint");
        this.Ixf = (IconPreference) this.screen.bmg("wallet_lock_gesture");
        this.Ixg = (IconPreference) this.screen.bmg("wallet_lock_close");
        this.Ixh = (IconPreference) this.screen.bmg("wallet_lock_faceid");
        this.Ixe.alO(8);
        this.Ixf.alO(8);
        this.Ixg.alO(8);
        this.Ixh.alO(8);
        this.screen.m38do("wallet_lock_faceid", true);
        this.gwE = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
        this.mScene = getIntent().getIntExtra("key_wallet_lock_setting_scene", -1);
        if (this.mScene == 1) {
            this.Ixi = true;
            this.Ixj = false;
        }
        kz kzVar = new kz();
        kzVar.eEH = 13;
        kzVar.eXI = 1;
        kzVar.eXJ = (long) this.gwE;
        kzVar.bfK();
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo isNeedFinish: %b, isNeedShowOpenIcon: %b", Boolean.valueOf(this.Ixi), Boolean.valueOf(this.Ixj));
        AppMethodBeat.o(129950);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(129951);
        super.onResume();
        fVD();
        AppMethodBeat.o(129951);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(129952);
        super.onPause();
        if (this.jzT != null && this.jzT.isShowing()) {
            this.jzT.dismiss();
        }
        AppMethodBeat.o(129952);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(129953);
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo onBackPressed");
        if (this.Ixi) {
            M(0, 4, "user cancel setting wallet lock");
            AppMethodBeat.o(129953);
            return;
        }
        finish();
        AppMethodBeat.o(129953);
    }

    private void M(int i2, int i3, String str) {
        AppMethodBeat.i(129954);
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i3);
        intent.putExtra("key_err_msg", str);
        q(i2, intent);
        AppMethodBeat.o(129954);
    }

    private void q(int i2, Intent intent) {
        AppMethodBeat.i(129955);
        setResult(i2, intent);
        finish();
        AppMethodBeat.o(129955);
    }

    private void fVD() {
        AppMethodBeat.i(129956);
        fVH();
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo current wallet lock type: %d", Integer.valueOf(g.instance.fVr()));
        fVE();
        fVF();
        fVG();
        AppMethodBeat.o(129956);
    }

    private void fVE() {
        AppMethodBeat.i(129957);
        g gVar = g.instance;
        if (!g.fVv()) {
            Log.w("MicroMsg.WalletLockSettingUI", "alvinluo FingerprintLock entry is not opened and don't show FingerprintLock entry");
            this.screen.m38do("wallet_lock_fingerprint", true);
            AppMethodBeat.o(129957);
            return;
        }
        boolean hf = m.hf(getContext());
        g gVar2 = g.instance;
        if (g.fUJ()) {
            if (!hf) {
                this.screen.m38do("wallet_lock_fingerprint", false);
                this.Ixe.setDesc(getString(R.string.iew));
                this.Ixe.gLF();
                a(this.Ixe, true, false);
                this.Ixe.setEnabled(false);
                this.Ixe.OYn = true;
                this.Ixk = false;
                AppMethodBeat.o(129957);
                return;
            } else if (this.Ixj) {
                this.screen.m38do("wallet_lock_fingerprint", false);
                a(this.Ixe, true, true);
                AppMethodBeat.o(129957);
                return;
            }
        } else if (!hf) {
            this.screen.m38do("wallet_lock_fingerprint", true);
            AppMethodBeat.o(129957);
            return;
        } else {
            this.screen.m38do("wallet_lock_fingerprint", false);
            a(this.Ixe, false, true);
        }
        AppMethodBeat.o(129957);
    }

    private void fVF() {
        AppMethodBeat.i(129958);
        g gVar = g.instance;
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo isUserSetGesturePwd: %b", Boolean.valueOf(g.fUV()));
        if (g.instance.fVr() == 2 || g.instance.fVr() == 3) {
            a(this.Ixf, false, true);
            this.screen.m38do("wallet_lock_modify_gesture", true);
            AppMethodBeat.o(129958);
            return;
        }
        if (g.instance.fVr() != 1) {
            a(this.Ixf, false, true);
            this.screen.m38do("wallet_lock_modify_gesture", true);
        } else if (this.Ixj) {
            a(this.Ixf, true, true);
            this.screen.m38do("wallet_lock_modify_gesture", false);
            AppMethodBeat.o(129958);
            return;
        }
        AppMethodBeat.o(129958);
    }

    private void fVG() {
        AppMethodBeat.i(129959);
        if (g.instance.fVr() != 0) {
            a(this.Ixg, false, true);
        } else if (this.Ixj) {
            a(this.Ixg, true, true);
            AppMethodBeat.o(129959);
            return;
        }
        AppMethodBeat.o(129959);
    }

    private void fVH() {
        AppMethodBeat.i(129960);
        if (this.Ixe != null && this.Ixk) {
            a(this.Ixe, false, this.Ixk);
        }
        if (this.Ixh != null && this.Ixl) {
            a(this.Ixh, false, this.Ixl);
        }
        if (this.Ixf != null) {
            a(this.Ixf, false, true);
        }
        if (this.Ixg != null) {
            a(this.Ixg, false, true);
        }
        AppMethodBeat.o(129960);
    }

    private void a(Preference preference, boolean z, boolean z2) {
        AppMethodBeat.i(129961);
        if (preference instanceof IconPreference) {
            IconPreference iconPreference = (IconPreference) preference;
            iconPreference.lb(a.fromDPToPix((Context) this, 20), a.fromDPToPix((Context) this, 20));
            if (z) {
                if (z2) {
                    iconPreference.alG(R.raw.radio_on);
                } else {
                    iconPreference.alG(R.raw.radio_default_on);
                }
                iconPreference.alH(0);
                AppMethodBeat.o(129961);
                return;
            }
            iconPreference.alG(R.raw.radio_off);
            iconPreference.alH(0);
        }
        AppMethodBeat.o(129961);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(129962);
        if ("wallet_lock_fingerprint".equals(preference.mKey)) {
            fVH();
            a(preference, true, true);
            if (this.Ixk && (!this.Ixj || g.instance.fVr() != 2)) {
                if (!com.tencent.soter.core.a.ld(this)) {
                    fVI();
                } else if (!this.Ixj || g.instance.fVr() != 2) {
                    Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock");
                    ((b) com.tencent.mm.kernel.g.af(b.class)).b(this, 2, 1);
                }
            }
            AppMethodBeat.o(129962);
            return true;
        } else if ("wallet_lock_faceid".equals(preference.mKey)) {
            fVH();
            a(preference, true, true);
            if (this.Ixl && (!this.Ixj || g.instance.fVr() != 3)) {
                if (!com.tencent.soter.core.a.aV(this, 2)) {
                    fVI();
                } else if (!this.Ixj || g.instance.fVr() == 3) {
                    Log.i("MicroMsg.WalletLockSettingUI", "request open faceid lock");
                    ((b) com.tencent.mm.kernel.g.af(b.class)).b(this, 3, 4);
                }
            }
            AppMethodBeat.o(129962);
            return true;
        } else if ("wallet_lock_gesture".equals(preference.mKey)) {
            fVH();
            a(preference, true, true);
            if (g.instance.fVr() != 1) {
                Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture lock");
                ((b) com.tencent.mm.kernel.g.af(b.class)).b(this, 1, 2);
            }
            AppMethodBeat.o(129962);
            return true;
        } else if ("wallet_lock_close".equals(preference.mKey)) {
            fVH();
            a(preference, true, true);
            if (g.instance.fVr() != 0) {
                Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request close wallet lock");
                ((b) com.tencent.mm.kernel.g.af(b.class)).m(this, 3);
                kz kzVar = new kz();
                kzVar.eEH = 14;
                kzVar.eXI = 1;
                kzVar.bfK();
            }
            AppMethodBeat.o(129962);
            return true;
        } else if ("wallet_lock_modify_gesture".equals(preference.mKey)) {
            ((b) com.tencent.mm.kernel.g.af(b.class)).aQ(this);
            AppMethodBeat.o(129962);
            return true;
        } else {
            AppMethodBeat.o(129962);
            return false;
        }
    }

    private void fVI() {
        AppMethodBeat.i(129963);
        this.jzT = h.d(this, getString(R.string.ifd), "", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(129947);
                WalletLockSettingUI.b(WalletLockSettingUI.this);
                AppMethodBeat.o(129947);
            }
        });
        this.jzT.setCanceledOnTouchOutside(false);
        AppMethodBeat.o(129963);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(129964);
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (intent == null) {
            Log.e("MicroMsg.WalletLockSettingUI", "alvinluo data is null");
            AppMethodBeat.o(129964);
            return;
        }
        int intExtra = intent.getIntExtra("key_err_code", -1);
        Log.i("MicroMsg.WalletLockSettingUI", "alvinluo wallet lock setting onActivityResult errCode: %d", Integer.valueOf(intExtra));
        if (i2 == 1) {
            Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock onActivityResult");
            if (intExtra == 0) {
                if (this.Ixi) {
                    q(i3, intent);
                    AppMethodBeat.o(129964);
                    return;
                }
            } else if (intExtra != 4) {
                Log.i("MicroMsg.WalletLockSettingUI", "alvinluo open fingerprint lock failed");
                amW(getString(R.string.iez));
                AppMethodBeat.o(129964);
                return;
            }
        } else if (i2 == 2) {
            Log.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture onActivityResult");
            if (intExtra == 0) {
                if (this.Ixi) {
                    q(i3, intent);
                }
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(129948);
                        try {
                            com.tencent.soter.a.a.aqK(3);
                            AppMethodBeat.o(129948);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.WalletLockSettingUI", "Remove AK after open gesture lock failed! " + e2.getMessage());
                            AppMethodBeat.o(129948);
                        }
                    }
                }, "WalletLockRemoveAuthKey");
                AppMethodBeat.o(129964);
                return;
            } else if (intExtra != 4) {
                Log.i("MicroMsg.WalletLockSettingUI", "alvinluo open gesture lock failed");
                amW(getString(R.string.ifa));
                AppMethodBeat.o(129964);
                return;
            }
        } else if (i2 == 3) {
            if (intExtra == 0) {
                ((b) com.tencent.mm.kernel.g.af(b.class)).aeZ(0);
                g gVar = g.instance;
                g.fUM();
                fVD();
                Toast.makeText(this, getString(R.string.iet), 0).show();
                com.tencent.mm.plugin.walletlock.c.h.fVx();
                if (this.Ixi) {
                    M(-1, 0, "close wallet lock ok");
                }
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(129949);
                        try {
                            com.tencent.soter.a.a.aqK(3);
                            AppMethodBeat.o(129949);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.WalletLockSettingUI", "Remove AK after close wallet lock failed! " + e2.getMessage());
                            AppMethodBeat.o(129949);
                        }
                    }
                }, "WalletLockRemoveAuthKey");
                kz kzVar = new kz();
                kzVar.eEH = 14;
                kzVar.eXI = 2;
                kzVar.bfK();
                AppMethodBeat.o(129964);
                return;
            } else if (intExtra != 4) {
                amW(getString(R.string.ieu));
            }
        }
        AppMethodBeat.o(129964);
    }

    private void amW(String str) {
        AppMethodBeat.i(129965);
        this.jzT = h.d(this, str, "", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        this.jzT.setCanceledOnTouchOutside(false);
        this.jzT.show();
        AppMethodBeat.o(129965);
    }
}
