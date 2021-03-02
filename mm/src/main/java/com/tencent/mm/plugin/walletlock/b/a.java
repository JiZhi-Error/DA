package com.tencent.mm.plugin.walletlock.b;

import android.app.Activity;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zw;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.d;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a extends com.tencent.mm.plugin.walletlock.c.a {
    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void init() {
        AppMethodBeat.i(129650);
        g gVar = g.instance;
        g.fVt();
        g.instance.afe(3);
        AppMethodBeat.o(129650);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final boolean a(Activity activity, b.AbstractC1929b bVar) {
        AppMethodBeat.i(129651);
        if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class)) {
            Log.d("MicroMsg.FaceIdLockImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(129651);
            return false;
        } else if (bVar == null || bVar.aR(activity)) {
            zw zwVar = new zw();
            zwVar.egz.egB = 0;
            zwVar.egz.activity = activity;
            EventCenter.instance.publish(zwVar);
            switch (((Integer) zwVar.egA.data).intValue()) {
                case 16:
                    AppMethodBeat.o(129651);
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
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/walletlock/faceid/FaceIdLockImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/walletlock/faceid/FaceIdLockImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.finish();
                    AppMethodBeat.o(129651);
                    return true;
                default:
                    AppMethodBeat.o(129651);
                    return false;
            }
        } else {
            Log.d("MicroMsg.FaceIdLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
            AppMethodBeat.o(129651);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void a(Activity activity, b.AbstractC1929b bVar, b.a aVar) {
        AppMethodBeat.i(129652);
        super.a(activity, bVar, aVar);
        AppMethodBeat.o(129652);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void b(Activity activity, int i2, int i3) {
        AppMethodBeat.i(129653);
        super.b(activity, i2, i3);
        AppMethodBeat.o(129653);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final b.AbstractC1929b fUE() {
        AppMethodBeat.i(129654);
        d fVq = d.fVq();
        AppMethodBeat.o(129654);
        return fVq;
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final boolean fUF() {
        AppMethodBeat.i(129655);
        g gVar = g.instance;
        boolean fUK = g.fUK();
        AppMethodBeat.o(129655);
        return fUK;
    }
}
