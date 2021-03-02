package com.tencent.mm.plugin.walletlock.gesture.a;

import android.app.Activity;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.a;
import com.tencent.mm.plugin.walletlock.c.d;
import com.tencent.mm.plugin.walletlock.c.g;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c extends a {
    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void init() {
        AppMethodBeat.i(129755);
        Log.e("MicroMsg.GestureImpl", "alvinluo gestureimpl init");
        g gVar = g.instance;
        g.yD(true);
        g.instance.afe(1);
        AppMethodBeat.o(129755);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final boolean a(Activity activity, b.AbstractC1929b bVar) {
        AppMethodBeat.i(129756);
        if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class)) {
            Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(129756);
            return false;
        } else if (bVar == null || bVar.aR(activity)) {
            zw zwVar = new zw();
            zwVar.egz.egB = 0;
            zwVar.egz.activity = activity;
            EventCenter.instance.publish(zwVar);
            switch (((Integer) zwVar.egA.data).intValue()) {
                case 16:
                    AppMethodBeat.o(129756);
                    return false;
                case 17:
                    Intent intent = new Intent(activity, GestureGuardLogicUI.class);
                    intent.addFlags(131072);
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.putExtra("scene", aS(activity));
                    intent.setPackage(MMApplicationContext.getPackageName());
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnCreate", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.finish();
                    h.INSTANCE.a(12097, 8, 0, Long.valueOf(System.currentTimeMillis()));
                    AppMethodBeat.o(129756);
                    return true;
                default:
                    AppMethodBeat.o(129756);
                    return false;
            }
        } else {
            Log.d("MicroMsg.GestureImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
            AppMethodBeat.o(129756);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void a(Activity activity, b.AbstractC1929b bVar, b.a aVar) {
        AppMethodBeat.i(129757);
        if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class)) {
            Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(129757);
            return;
        }
        zw zwVar = new zw();
        zwVar.egz.egB = 1;
        zwVar.egz.activity = activity;
        EventCenter.instance.publish(zwVar);
        switch (((Integer) zwVar.egA.data).intValue()) {
            case 17:
                if (bVar != null && !bVar.aR(activity)) {
                    Log.d("MicroMsg.GestureImpl", "protectMeOnResume: still in filter range, do not activate protection.");
                    break;
                } else {
                    Intent intent = new Intent(activity, GestureGuardLogicUI.class);
                    intent.addFlags(131072);
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.putExtra("scene", aS(activity));
                    intent.setPackage(MMApplicationContext.getPackageName());
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "protectMeOnResume", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GuardFilter;Lcom/tencent/mm/plugin/walletlock/api/IWalletLock$GestureGuardCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(129757);
                    return;
                }
                break;
        }
        AppMethodBeat.o(129757);
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void l(Activity activity, int i2) {
        AppMethodBeat.i(129758);
        if (i2 != 1) {
            AppMethodBeat.o(129758);
        } else if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class)) {
            Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(129758);
        } else {
            Intent intent = new Intent();
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_paypwd");
            intent.putExtra("next_action", "next_action.switch_on_pattern");
            intent.putExtra("key_wallet_lock_type", 1);
            com.tencent.mm.br.c.b(activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent);
            AppMethodBeat.o(129758);
        }
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void b(Activity activity, int i2, int i3) {
        AppMethodBeat.i(129759);
        if (i2 != 1) {
            AppMethodBeat.o(129759);
        } else if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class)) {
            Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(129759);
        } else {
            Intent intent = new Intent();
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_paypwd");
            intent.putExtra("next_action", "next_action.switch_on_pattern");
            intent.putExtra("key_wallet_lock_type", 1);
            com.tencent.mm.br.c.b(activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i3);
            AppMethodBeat.o(129759);
        }
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void aQ(Activity activity) {
        AppMethodBeat.i(129760);
        if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class)) {
            Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(129760);
        } else if (!b.fUV()) {
            Log.d("MicroMsg.GestureImpl", "try to enter modify gesture password process while gesture password has been switched off.");
            AppMethodBeat.o(129760);
        } else {
            Intent intent = new Intent(activity, GestureGuardLogicUI.class);
            intent.addFlags(131072);
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
            intent.putExtra("next_action", "next_action.modify_pattern");
            intent.setPackage(MMApplicationContext.getPackageName());
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "enterModifyWalletLockProcess", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "enterModifyWalletLockProcess", "(Landroid/app/Activity;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(129760);
        }
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final void m(Activity activity, int i2) {
        AppMethodBeat.i(129761);
        if (!com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.walletlock.a.a.class)) {
            Log.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
            AppMethodBeat.o(129761);
        } else if (!b.fUV()) {
            Log.d("MicroMsg.GestureImpl", "try to enter close gesture password process while gesture password has been switched off.");
            AppMethodBeat.o(129761);
        } else {
            Intent intent = new Intent(activity, GestureGuardLogicUI.class);
            intent.addFlags(131072);
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
            intent.putExtra("next_action", "next_action.switch_off_pattern");
            intent.setPackage(MMApplicationContext.getPackageName());
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "enterCloseWalletLockProcess", "(Landroid/app/Activity;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/walletlock/gesture/model/GestureImpl", "enterCloseWalletLockProcess", "(Landroid/app/Activity;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(129761);
        }
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final boolean fUF() {
        AppMethodBeat.i(261736);
        boolean fUV = b.fUV();
        AppMethodBeat.o(261736);
        return fUV;
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final boolean fUG() {
        AppMethodBeat.i(129763);
        boolean fUW = b.fUW();
        AppMethodBeat.o(129763);
        return fUW;
    }

    @Override // com.tencent.mm.plugin.walletlock.a.b, com.tencent.mm.plugin.walletlock.c.a
    public final /* synthetic */ b.AbstractC1929b fUE() {
        AppMethodBeat.i(129764);
        d fVq = d.fVq();
        AppMethodBeat.o(129764);
        return fVq;
    }
}
