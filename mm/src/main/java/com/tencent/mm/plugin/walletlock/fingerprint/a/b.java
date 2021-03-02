package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.app.Activity;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.zw;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.a;
import com.tencent.mm.plugin.walletlock.c.d;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b extends a {
    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void init() {
        AppMethodBeat.i(129668);
        g gVar = g.instance;
        g.fVs();
        g.instance.afe(2);
        AppMethodBeat.o(129668);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final boolean a(Activity activity, b.AbstractC1929b bVar) {
        AppMethodBeat.i(129669);
        if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class)) {
            Log.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(129669);
            return false;
        } else if (bVar == null || bVar.aR(activity)) {
            zw zwVar = new zw();
            zwVar.egz.egB = 0;
            zwVar.egz.activity = activity;
            EventCenter.instance.publish(zwVar);
            switch (((Integer) zwVar.egA.data).intValue()) {
                case 16:
                    AppMethodBeat.o(129669);
                    return false;
                case 17:
                    Intent intent = new Intent(activity, FingerprintWalletLockUI.class);
                    intent.addFlags(131072);
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.putExtra("scene", aS(activity));
                    intent.setPackage(MMApplicationContext.getPackageName());
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.finish();
                    AppMethodBeat.o(129669);
                    return true;
                default:
                    AppMethodBeat.o(129669);
                    return false;
            }
        } else {
            Log.d("MicroMsg.FingerprintLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
            AppMethodBeat.o(129669);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void a(Activity activity, b.AbstractC1929b bVar, b.a aVar) {
        AppMethodBeat.i(129670);
        if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class)) {
            Log.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(129670);
            return;
        }
        zw zwVar = new zw();
        zwVar.egz.egB = 1;
        zwVar.egz.activity = activity;
        EventCenter.instance.publish(zwVar);
        switch (((Integer) zwVar.egA.data).intValue()) {
            case 17:
                if (bVar != null && !bVar.aR(activity)) {
                    Log.d("MicroMsg.FingerprintLockImpl", "protectMeOnResume: still in filter range, do not activate protection.");
                    break;
                } else {
                    Intent intent = new Intent(activity, FingerprintWalletLockUI.class);
                    intent.addFlags(131072);
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.putExtra("scene", aS(activity));
                    intent.setPackage(MMApplicationContext.getPackageName());
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/walletlock/fingerprint/model/FingerprintLockImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(129670);
                    return;
                }
                break;
        }
        AppMethodBeat.o(129670);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void l(Activity activity, int i2) {
        AppMethodBeat.i(129671);
        if (i2 != 2) {
            AppMethodBeat.o(129671);
        } else if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class)) {
            Log.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(129671);
        } else {
            Intent intent = new Intent();
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_paypwd");
            intent.putExtra("next_action", "next_action.switch_on_pattern");
            intent.putExtra("key_wallet_lock_type", 2);
            c.b(activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent);
            AppMethodBeat.o(129671);
        }
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void b(Activity activity, int i2, int i3) {
        AppMethodBeat.i(129672);
        if (i2 != 2) {
            AppMethodBeat.o(129672);
        } else if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class)) {
            Log.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(129672);
        } else {
            Intent intent = new Intent();
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_paypwd");
            intent.putExtra("next_action", "next_action.switch_on_pattern");
            intent.putExtra("key_wallet_lock_type", 2);
            Log.i("MicroMsg.FingerprintLockImpl", "alvinluo enterNewWalletLockProcessForResult start check pwd ui, wallet lock type: %d", Integer.valueOf(i2));
            c.b(activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i3);
            AppMethodBeat.o(129672);
        }
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void aQ(Activity activity) {
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void m(Activity activity, int i2) {
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final b.AbstractC1929b fUE() {
        AppMethodBeat.i(129673);
        d fVq = d.fVq();
        AppMethodBeat.o(129673);
        return fVq;
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final boolean fUF() {
        AppMethodBeat.i(129674);
        g gVar = g.instance;
        boolean fUJ = g.fUJ();
        AppMethodBeat.o(129674);
        return fUJ;
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final boolean fUG() {
        return false;
    }
}
