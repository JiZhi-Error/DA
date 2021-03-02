package com.tencent.mm.plugin.fingerprint.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI;
import com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdDialog;
import com.tencent.mm.plugin.fingerprint.faceid.auth.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.d;
import com.tencent.soter.core.biometric.FingerprintManagerProxy;

public final class q implements h {
    @Override // com.tencent.mm.plugin.fingerprint.b.h
    public final void a(MMActivity mMActivity, a aVar, Bundle bundle) {
        AppMethodBeat.i(64398);
        WalletFaceIdDialog walletFaceIdDialog = new WalletFaceIdDialog(mMActivity, aVar, bundle);
        walletFaceIdDialog.setCancelable(false);
        mMActivity.getLifecycle().addObserver(walletFaceIdDialog);
        walletFaceIdDialog.show();
        AppMethodBeat.o(64398);
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.h
    public final boolean i(final MMActivity mMActivity) {
        final Bundle bundle;
        String str;
        AppMethodBeat.i(64399);
        if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            Log.i("MicroMsg.WalletSoterService", "has show the finger print auth guide!");
            AppMethodBeat.o(64399);
            return false;
        }
        final d by = com.tencent.mm.wallet_core.a.by(mMActivity);
        Bundle bundle2 = new Bundle();
        if (by != null) {
            bundle = by.dQL;
        } else {
            bundle = bundle2;
        }
        boolean z = false;
        if (mMActivity == null || mMActivity.getIntent() == null || !(z = mMActivity.getIntent().getBooleanExtra("isFromKinda", false))) {
            str = null;
        } else {
            String stringExtra = mMActivity.getIntent().getStringExtra("kindaPayPwd");
            if (stringExtra != null) {
                bundle.putString("key_pwd1", stringExtra);
            }
            str = stringExtra;
        }
        if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
            Log.i("MicroMsg.WalletSoterService", "pwd is empty, not show the finger print auth guide!");
            AppMethodBeat.o(64399);
            return false;
        }
        com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        Log.i("MicroMsg.WalletSoterService", "fingerprint: %s has fingerprint: %s, faceid: %s has faceid: %s", Boolean.valueOf(com.tencent.mm.plugin.wallet.b.a.fPB()), Boolean.valueOf(aVar.dJU()), Boolean.valueOf(com.tencent.mm.plugin.wallet.b.a.fPC()), Boolean.valueOf(aVar.dKc()));
        if (!aVar.dJO() && !aVar.dJR()) {
            if (!com.tencent.mm.plugin.wallet.b.a.fPB() || !aVar.dJU() || !com.tencent.mm.plugin.wallet.b.a.fPC() || !aVar.dKc()) {
                if (com.tencent.mm.plugin.wallet.b.a.fPB() && aVar.dJU() && !aVar.dJO()) {
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    if (z) {
                        intent.putExtra("isFromKinda", z);
                        intent.putExtra("kindaPayPwd", str);
                        intent.putExtra("key_show_guide", false);
                    }
                    c.b(mMActivity, FingerprintManagerProxy.FINGERPRINT_SERVICE, ".ui.FingerPrintAuthTransparentUI", intent);
                } else if (com.tencent.mm.plugin.wallet.b.a.fPC() && aVar.dKc() && !aVar.dJR()) {
                    if (z) {
                        Intent intent2 = new Intent(mMActivity, WalletFaceIdAuthUI.class);
                        intent2.putExtra("pwd", bundle.getString("key_pwd1"));
                        intent2.putExtra("key_scene", 1);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "showOpenGuideAfterPaySucc", "(Lcom/tencent/mm/ui/MMActivity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        mMActivity.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "showOpenGuideAfterPaySucc", "(Lcom/tencent/mm/ui/MMActivity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(64399);
                        return true;
                    }
                    View inflate = LayoutInflater.from(mMActivity).inflate(R.layout.alm, (ViewGroup) null);
                    final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.d4u);
                    ((TextView) inflate.findViewById(R.id.cfr)).setText(mMActivity.getString(R.string.c7w));
                    h.a((Context) mMActivity, false, (String) null, inflate, mMActivity.getString(R.string.am4), mMActivity.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.fingerprint.b.q.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(64393);
                            Intent intent = new Intent(mMActivity, WalletFaceIdAuthUI.class);
                            intent.putExtra("pwd", bundle.getString("key_pwd1"));
                            intent.putExtra("key_scene", 1);
                            MMActivity mMActivity = mMActivity;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            mMActivity.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(64393);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.fingerprint.b.q.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(64394);
                            if (checkBox.isChecked()) {
                                g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.TRUE);
                            }
                            AppMethodBeat.o(64394);
                        }
                    });
                }
            } else if (z) {
                boolean z2 = false;
                int i2 = 0;
                String str2 = null;
                if (!(mMActivity == null || mMActivity.getIntent() == null)) {
                    z2 = mMActivity.getIntent().getBooleanExtra("isFromKinda", false);
                    z = mMActivity.getIntent().getBooleanExtra("bSupportFaceAndTouch", false);
                    i2 = mMActivity.getIntent().getIntExtra("selectBioType", 0);
                    str2 = mMActivity.getIntent().getStringExtra("kindaPayPwd");
                }
                if (z2 && z && str2 != null) {
                    Bundle bundle3 = new Bundle();
                    if (i2 == 1) {
                        Log.i("MicroMsg.WalletSoterService", "click fingerprint btn");
                        bundle3.putBoolean("key_show_guide", false);
                        bundle3.putBoolean("isFromKinda", true);
                        bundle3.putString("kindaPayPwd", str2);
                        Intent intent3 = new Intent();
                        intent3.putExtras(bundle3);
                        c.b(mMActivity, FingerprintManagerProxy.FINGERPRINT_SERVICE, ".ui.FingerPrintAuthTransparentUI", intent3);
                    } else if (i2 == 2) {
                        Log.i("MicroMsg.WalletSoterService", "click faceid btn");
                        Intent intent4 = new Intent(mMActivity, WalletFaceIdAuthUI.class);
                        intent4.putExtra("pwd", str2);
                        intent4.putExtra("key_scene", 1);
                        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent4);
                        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl2.axQ(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "kindaHandleOpenBiometricPay", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        mMActivity.startActivity((Intent) bl2.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl", "kindaHandleOpenBiometricPay", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                }
            } else {
                final i iVar = new i(mMActivity, R.style.a66);
                iVar.setContentView(R.layout.jb);
                final CheckBox checkBox2 = (CheckBox) iVar.findViewById(R.id.ac1);
                TextView textView = (TextView) iVar.findViewById(R.id.ac2);
                TextView textView2 = (TextView) iVar.findViewById(R.id.ac3);
                TextView textView3 = (TextView) iVar.findViewById(R.id.ac0);
                final Bundle bundle4 = new Bundle();
                if (by != null) {
                    bundle4 = by.dQL;
                }
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.fingerprint.b.q.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(64395);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.WalletSoterService", "click faceid btn");
                        Intent intent = new Intent(mMActivity, WalletFaceIdAuthUI.class);
                        intent.putExtra("pwd", bundle4.getString("key_pwd1"));
                        intent.putExtra("key_scene", 1);
                        Activity activity = mMActivity;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        activity.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        iVar.dismiss();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(64395);
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.fingerprint.b.q.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(64396);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.WalletSoterService", "click fingerprint btn");
                        if (by != null) {
                            bundle4.putBoolean("key_show_guide", false);
                            Intent intent = new Intent();
                            intent.putExtras(bundle4);
                            c.b(mMActivity, FingerprintManagerProxy.FINGERPRINT_SERVICE, ".ui.FingerPrintAuthTransparentUI", intent);
                        }
                        iVar.dismiss();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(64396);
                    }
                });
                textView3.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.fingerprint.b.q.AnonymousClass5 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(64397);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.WalletSoterService", "click cancel btn");
                        if (checkBox2.isChecked()) {
                            g.aAh().azQ().set(ar.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.TRUE);
                        }
                        iVar.dismiss();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/mgr/WalletSoterServiceImpl$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(64397);
                    }
                });
                iVar.show();
                mMActivity.addDialog(iVar);
            }
        }
        AppMethodBeat.o(64399);
        return true;
    }
}
