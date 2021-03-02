package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI;
import com.tencent.mm.sdk.platformtools.Log;

public class a implements b {
    protected static int aS(Activity activity) {
        AppMethodBeat.i(129888);
        Log.i("MicroMsg.BaseWalletLockImpl", "alvinluo activity %s", activity.getClass().getSimpleName());
        if (activity.getClass().getSimpleName().equals("MallIndexUI") || activity.getClass().getSimpleName().equals("MallIndexUIv2")) {
            AppMethodBeat.o(129888);
            return 1;
        } else if (activity.getClass().getSimpleName().equals("WalletOfflineCoinPurseUI")) {
            AppMethodBeat.o(129888);
            return 2;
        } else {
            AppMethodBeat.o(129888);
            return -1;
        }
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b
    public void init() {
        AppMethodBeat.i(129889);
        g.instance.afe(0);
        AppMethodBeat.o(129889);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b
    public boolean a(Activity activity, b.AbstractC1929b bVar) {
        return false;
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b
    public void a(Activity activity, b.AbstractC1929b bVar, b.a aVar) {
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b
    public void l(Activity activity, int i2) {
        AppMethodBeat.i(129890);
        Log.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcess walletLockType: %d", Integer.valueOf(i2));
        if (i2 == 1) {
            new c().l(activity, i2);
            AppMethodBeat.o(129890);
            return;
        }
        if (i2 == 2) {
            new com.tencent.mm.plugin.walletlock.fingerprint.a.b().l(activity, i2);
        }
        AppMethodBeat.o(129890);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b
    public void b(Activity activity, int i2, int i3) {
        AppMethodBeat.i(129891);
        Log.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcessForResult walletLockType: %d, requestCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 1) {
            new c().b(activity, i2, i3);
            AppMethodBeat.o(129891);
            return;
        }
        if (i2 == 2) {
            new com.tencent.mm.plugin.walletlock.fingerprint.a.b().b(activity, i2, i3);
        }
        AppMethodBeat.o(129891);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b
    public void aQ(Activity activity) {
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b
    public void m(Activity activity, int i2) {
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b
    public b.AbstractC1929b fUE() {
        return null;
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b
    public boolean fUF() {
        return false;
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b
    public boolean fUG() {
        return false;
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b
    public void j(Activity activity, Intent intent) {
        AppMethodBeat.i(129892);
        intent.setClass(activity, WalletLockSettingUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/walletlock/model/BaseWalletLockImpl", "startWalletLockManagerUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/walletlock/model/BaseWalletLockImpl", "startWalletLockManagerUI", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(129892);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b
    public void c(Activity activity, Intent intent, int i2) {
        AppMethodBeat.i(129893);
        intent.setClass(activity, WalletLockSettingUI.class);
        activity.startActivityForResult(intent, i2);
        AppMethodBeat.o(129893);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b
    public void aeZ(int i2) {
    }
}
