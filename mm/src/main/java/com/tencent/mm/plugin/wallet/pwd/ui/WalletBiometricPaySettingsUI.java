package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ce;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

@a(0)
public class WalletBiometricPaySettingsUI extends WalletPreferenceUI {
    private Preference HIQ;
    private Preference HIR;
    private Preference HIS;
    private Preference HIT;
    private int HIU = 0;
    private boolean HIV;
    private boolean HIW;
    private boolean HIX;
    private boolean HIY;
    private com.tencent.mm.plugin.fingerprint.d.a wEQ;

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void d(WalletBiometricPaySettingsUI walletBiometricPaySettingsUI) {
        AppMethodBeat.i(69617);
        walletBiometricPaySettingsUI.fOS();
        AppMethodBeat.o(69617);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69602);
        super.onCreate(bundle);
        if (com.tencent.mm.plugin.wallet.b.a.fPC() && com.tencent.mm.plugin.wallet.b.a.fPB()) {
            this.HIU = 1;
        } else if (com.tencent.mm.plugin.wallet.b.a.fPB()) {
            this.HIU = 2;
        } else if (com.tencent.mm.plugin.wallet.b.a.fPC()) {
            this.HIU = 3;
        } else {
            Log.w("MicroMsg.WalletBiometricPaySettingsUI", "device not support biometric pay!");
            finish();
        }
        if (this.HIU == 1) {
            setMMTitle(R.string.i8j);
        } else if (this.HIU == 2) {
            setMMTitle(R.string.imb);
        } else {
            setMMTitle(R.string.im_);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69599);
                WalletBiometricPaySettingsUI.this.finish();
                AppMethodBeat.o(69599);
                return false;
            }
        });
        this.wEQ = (com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        Log.i("MicroMsg.WalletBiometricPaySettingsUI", "biometric mode: %s", Integer.valueOf(this.HIU));
        initView();
        AppMethodBeat.o(69602);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(69603);
        f preferenceScreen = getPreferenceScreen();
        this.HIQ = preferenceScreen.bmg("biometric_pay_close");
        this.HIQ.alO(8);
        Log.i("MicroMsg.WalletBiometricPaySettingsUI", "fingerprint: %s, faceid: %s", Boolean.valueOf(this.wEQ.dJO()), Boolean.valueOf(this.wEQ.dJR()));
        if (this.HIU == 2 || this.HIU == 3) {
            this.HIR = new Preference(this);
            this.HIR.setKey("key_single_open");
            this.HIR.setTitle(R.string.i8k);
            this.HIR.OZw = false;
            preferenceScreen.a(this.HIR, 0);
            this.HIR.alO(8);
            AppMethodBeat.o(69603);
            return;
        }
        if (this.HIU == 1) {
            this.HIT = new Preference(this);
            this.HIT.setKey("key_faceid_open");
            this.HIT.setTitle(R.string.i8l);
            preferenceScreen.a(this.HIT, 0);
            this.HIS = new Preference(this);
            this.HIS.setKey("key_fingerprint_open");
            this.HIS.setTitle(R.string.i8m);
            preferenceScreen.a(this.HIS, 1);
            this.HIT.alO(8);
            this.HIS.alO(8);
        }
        AppMethodBeat.o(69603);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(69604);
        super.onResume();
        Log.i("MicroMsg.WalletBiometricPaySettingsUI", "update pref check state: %s, %s", Boolean.valueOf(this.wEQ.dJO()), Boolean.valueOf(this.wEQ.dJR()));
        if (this.HIU == 1) {
            if (this.wEQ.dJO()) {
                fOU();
            } else if (this.wEQ.dJR()) {
                fOV();
            } else {
                fOS();
            }
        } else if (this.wEQ.dJO() || this.wEQ.dJR()) {
            fOT();
        } else {
            fOS();
        }
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(69604);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI
    public final boolean e(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.db;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(final f fVar, Preference preference) {
        AppMethodBeat.i(69605);
        Log.i("MicroMsg.WalletBiometricPaySettingsUI", "click key: %s", preference.mKey);
        this.HIY = b(this.HIQ);
        if (this.HIU == 1) {
            this.HIW = b(this.HIT);
            this.HIX = b(this.HIS);
        } else {
            this.HIV = b(this.HIR);
        }
        Log.i("MicroMsg.WalletBiometricPaySettingsUI", "is checked: %s", Boolean.valueOf(b(preference)));
        if (b(preference)) {
            AppMethodBeat.o(69605);
        } else {
            if ("biometric_pay_close".equals(preference.mKey)) {
                String string = getString(R.string.dbu);
                if (this.wEQ.dJR()) {
                    string = getString(R.string.c7u);
                }
                h.a((Context) this, false, string, "", getString(R.string.x_), getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(69601);
                        final Dialog c2 = com.tencent.mm.wallet_core.ui.h.c(WalletBiometricPaySettingsUI.this.getContext(), false, null);
                        final ce ceVar = new ce();
                        ceVar.dFo.dFq = WalletBiometricPaySettingsUI.this.wEQ.dJO() ? 1 : 2;
                        ceVar.callback = new Runnable() {
                            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(69600);
                                if (ceVar.dFp != null) {
                                    if (c2 != null) {
                                        c2.dismiss();
                                    }
                                    Log.i("MicroMsg.WalletBiometricPaySettingsUI", "close event result: %s", Integer.valueOf(ceVar.dFp.retCode));
                                    if (ceVar.dFp.retCode == 0) {
                                        g.aAg().hqi.a(new ad(null, 19), 0);
                                        AppMethodBeat.o(69600);
                                        return;
                                    }
                                    WalletBiometricPaySettingsUI.b(WalletBiometricPaySettingsUI.this);
                                    WalletBiometricPaySettingsUI.c(WalletBiometricPaySettingsUI.this);
                                }
                                AppMethodBeat.o(69600);
                            }
                        };
                        EventCenter.instance.asyncPublish(ceVar, WalletBiometricPaySettingsUI.this.getMainLooper());
                        WalletBiometricPaySettingsUI.d(WalletBiometricPaySettingsUI.this);
                        fVar.notifyDataSetChanged();
                        AppMethodBeat.o(69601);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            } else if ("key_single_open".equals(preference.mKey)) {
                if (this.HIU == 2) {
                    fOW();
                } else if (this.HIU == 3) {
                    fOX();
                }
            } else if ("key_fingerprint_open".equals(preference.mKey)) {
                fOW();
            } else if ("key_faceid_open".equals(preference.mKey)) {
                fOX();
            }
            fVar.notifyDataSetChanged();
            AppMethodBeat.o(69605);
        }
        return false;
    }

    private static void a(Preference preference, boolean z) {
        AppMethodBeat.i(69606);
        preference.setWidgetLayoutResource(z ? R.layout.b_m : R.layout.b_n);
        AppMethodBeat.o(69606);
    }

    private void fOS() {
        AppMethodBeat.i(69607);
        if (this.HIU == 1) {
            a(this.HIS, false);
            a(this.HIT, false);
        } else {
            a(this.HIR, false);
        }
        a(this.HIQ, true);
        AppMethodBeat.o(69607);
    }

    private void fOT() {
        AppMethodBeat.i(69608);
        if (this.HIU == 2 || this.HIU == 3) {
            a(this.HIR, true);
            a(this.HIQ, false);
        }
        AppMethodBeat.o(69608);
    }

    private void fOU() {
        AppMethodBeat.i(69609);
        if (this.HIU == 1) {
            a(this.HIS, true);
            a(this.HIT, false);
            a(this.HIQ, false);
        }
        AppMethodBeat.o(69609);
    }

    private void fOV() {
        AppMethodBeat.i(69610);
        if (this.HIU == 1) {
            a(this.HIS, false);
            a(this.HIT, true);
            a(this.HIQ, false);
        }
        AppMethodBeat.o(69610);
    }

    private void aeA(int i2) {
        AppMethodBeat.i(69611);
        Log.i("MicroMsg.WalletBiometricPaySettingsUI", "start open process: %s", Integer.valueOf(i2));
        Bundle bundle = new Bundle();
        bundle.putInt("open_scene", 1);
        bundle.putInt("key_open_biometric_type", i2);
        com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", bundle);
        AppMethodBeat.o(69611);
    }

    private void aeB(int i2) {
        AppMethodBeat.i(69612);
        Log.i("MicroMsg.WalletBiometricPaySettingsUI", "show enroll biometric guide: %s", Integer.valueOf(i2));
        String string = getString(R.string.imo);
        if (i2 == 1) {
            string = getString(R.string.imq);
        }
        h.a(this, string, "", getString(R.string.imn), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(69612);
    }

    private void fOW() {
        AppMethodBeat.i(69613);
        Log.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open fingerprint");
        if (this.wEQ.dJU()) {
            aeA(1);
            if (this.HIU == 1) {
                fOU();
                AppMethodBeat.o(69613);
                return;
            }
            fOT();
            AppMethodBeat.o(69613);
            return;
        }
        aeB(1);
        AppMethodBeat.o(69613);
    }

    private void fOX() {
        AppMethodBeat.i(69614);
        Log.i("MicroMsg.WalletBiometricPaySettingsUI", "on click open faceid");
        if (this.wEQ.dKc()) {
            aeA(2);
            if (this.HIU == 1) {
                fOV();
                AppMethodBeat.o(69614);
                return;
            }
            fOT();
            AppMethodBeat.o(69614);
            return;
        }
        aeB(2);
        AppMethodBeat.o(69614);
    }

    private static boolean b(Preference preference) {
        return preference.OZG == R.layout.b_m;
    }

    static /* synthetic */ void b(WalletBiometricPaySettingsUI walletBiometricPaySettingsUI) {
        AppMethodBeat.i(69615);
        a(walletBiometricPaySettingsUI.HIQ, walletBiometricPaySettingsUI.HIY);
        if (walletBiometricPaySettingsUI.HIU == 1) {
            a(walletBiometricPaySettingsUI.HIT, walletBiometricPaySettingsUI.HIW);
            a(walletBiometricPaySettingsUI.HIS, walletBiometricPaySettingsUI.HIX);
        } else {
            a(walletBiometricPaySettingsUI.HIR, walletBiometricPaySettingsUI.HIV);
        }
        walletBiometricPaySettingsUI.getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(69615);
    }

    static /* synthetic */ void c(WalletBiometricPaySettingsUI walletBiometricPaySettingsUI) {
        AppMethodBeat.i(69616);
        if (walletBiometricPaySettingsUI.wEQ.dJO()) {
            h.c(walletBiometricPaySettingsUI, walletBiometricPaySettingsUI.getResources().getString(R.string.dbw), "", true);
            AppMethodBeat.o(69616);
            return;
        }
        h.c(walletBiometricPaySettingsUI, walletBiometricPaySettingsUI.getResources().getString(R.string.im8), "", true);
        AppMethodBeat.o(69616);
    }
}
