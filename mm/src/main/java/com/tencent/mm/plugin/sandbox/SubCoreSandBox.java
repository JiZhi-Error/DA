package com.tencent.mm.plugin.sandbox;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.p.a;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver;
import com.tencent.mm.sandbox.monitor.ExceptionMonitorService;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sandbox.updater.Updater;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class SubCoreSandBox implements bd, c {
    public static boolean Czx = false;
    public static boolean Czy = false;

    public SubCoreSandBox() {
        AppMethodBeat.i(28049);
        Log.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox constructor at: " + System.currentTimeMillis());
        AppMethodBeat.o(28049);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        AppMethodBeat.i(28050);
        Log.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox getBaseDBFactories at: " + System.currentTimeMillis());
        AppMethodBeat.o(28050);
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
        AppMethodBeat.i(28051);
        Log.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox clearPluginData at: " + System.currentTimeMillis());
        AppMethodBeat.o(28051);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(28052);
        Log.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountPostReset at: " + System.currentTimeMillis());
        AppMethodBeat.o(28052);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
        AppMethodBeat.i(28053);
        Log.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onSdcardMount at: " + System.currentTimeMillis());
        AppMethodBeat.o(28053);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(28054);
        Log.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountRelease at: " + System.currentTimeMillis());
        AppMethodBeat.o(28054);
    }

    @Override // com.tencent.mm.plugin.p.c
    public final void elo() {
        AppMethodBeat.i(28055);
        Updater.ajz(16);
        AppMethodBeat.o(28055);
    }

    @Override // com.tencent.mm.plugin.p.c
    public final a c(Context context, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(28056);
        Updater e2 = Updater.e(context, onCancelListener);
        AppMethodBeat.o(28056);
        return e2;
    }

    @Override // com.tencent.mm.plugin.p.c
    public final a d(Context context, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(28057);
        Updater f2 = Updater.f(context, onCancelListener);
        AppMethodBeat.o(28057);
        return f2;
    }

    @Override // com.tencent.mm.plugin.p.c
    public final a gB(Context context) {
        AppMethodBeat.i(28058);
        Updater jt = Updater.jt(context);
        AppMethodBeat.o(28058);
        return jt;
    }

    @Override // com.tencent.mm.plugin.p.c
    public final void gC(Context context) {
        AppMethodBeat.i(28059);
        Updater.gC(context);
        AppMethodBeat.o(28059);
    }

    @Override // com.tencent.mm.plugin.p.c
    public final void h(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(28060);
        Updater.h(str, i2, str2, str3);
        AppMethodBeat.o(28060);
    }

    @Override // com.tencent.mm.plugin.p.c
    public final b elp() {
        AppMethodBeat.i(28061);
        com.tencent.mm.sandbox.a.a aVar = new com.tencent.mm.sandbox.a.a(2);
        AppMethodBeat.o(28061);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.p.c
    public final String aFr(String str) {
        AppMethodBeat.i(28062);
        String aFr = com.tencent.mm.sandbox.monitor.c.aFr(str);
        AppMethodBeat.o(28062);
        return aFr;
    }

    @Override // com.tencent.mm.plugin.p.c
    public final void ak(Context context, Intent intent) {
        AppMethodBeat.i(28063);
        if (context != null) {
            if (MMApplicationContext.isMainProcess()) {
                Log.i("MicroMsg.CrashSecondReport", "reportCrash() process:mm");
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1185, 0, 1, true);
                intent.putExtra("exceptionProcess", "mm");
            } else if (MMApplicationContext.isPushProcess()) {
                Log.i("MicroMsg.CrashSecondReport", "reportCrash() process:push");
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1185, 1, 1, true);
                intent.putExtra("exceptionProcess", "push");
            } else {
                Log.i("MicroMsg.CrashSecondReport", "reportCrash() process:other");
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1185, 2, 1, true);
                intent.putExtra("exceptionProcess", FacebookRequestErrorClassification.KEY_OTHER);
            }
            String bt = com.tencent.mm.sandbox.monitor.a.bt(intent);
            Log.i("MicroMsg.SubCoreSandBox", "startExceptionMonitorService() crashPreventPath:%s", bt);
            intent.putExtra("exceptionPreventPath", bt);
            try {
                intent.setClass(context, ExceptionMonitorService.class);
                MMApplicationContext.getContext().startService(intent);
            } catch (Exception e2) {
                Log.e("MicroMsg.SubCoreSandBox", "startExceptionMonitorService() %s %s", e2.getClass().getSimpleName(), e2.getMessage());
                intent.setClass(context, ExceptionMonitorBroadcastReceiver.class);
                MMApplicationContext.getContext().sendBroadcast(intent);
            }
            com.tencent.mm.sandbox.monitor.a.p(intent, bt);
        }
        AppMethodBeat.o(28063);
    }

    @Override // com.tencent.mm.plugin.p.c
    public final void al(Context context, Intent intent) {
        AppMethodBeat.i(28064);
        intent.setClass(context, AppUpdaterUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sandbox/SubCoreSandBox", "startAppUpdateUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sandbox/SubCoreSandBox", "startAppUpdateUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28064);
    }

    @Override // com.tencent.mm.plugin.p.c
    public final void rp(boolean z) {
        Czx = true;
        Czy = z;
    }
}
