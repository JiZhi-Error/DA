package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicBoolean;

public final class m extends com.tencent.mm.plugin.appbrand.menu.a.a<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, com.tencent.mm.ui.base.m mVar, String str) {
        AppMethodBeat.i(47646);
        if (agVar.getRuntime().ON().cyA.scene != 1023) {
            mVar.a(this.nfG, context.getString(R.string.r8), R.raw.appbrand_menu_send_to_desktop, 0);
        }
        AppMethodBeat.o(47646);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(final Context context, ag agVar, String str, t tVar) {
        AppMethodBeat.i(47645);
        ag agVar2 = agVar;
        AppBrandSysConfigWC bsB = agVar2.getRuntime().bsB();
        AppBrandInitConfigWC bsC = agVar2.getRuntime().bsC();
        String str2 = bsC.username;
        if (context == null || TextUtils.isEmpty(str2)) {
            Log.i("MicroMsg.MenuDelegate_SendToDesktop", "performItemClick failed, context or username is null or nil.");
            AppMethodBeat.o(47645);
        } else if (!agVar2.isRunning() || agVar2.getRuntime().isDestroyed()) {
            Log.i("MicroMsg.MenuDelegate_SendToDesktop", "performItemClick failed, pageView destroyed");
            AppMethodBeat.o(47645);
        } else {
            AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) agVar2.av(AppBrandSysConfigWC.class);
            final v.a aVar = new v.a(bsC.uin, appBrandSysConfigWC.cze, ((AppBrandInitConfigLU) bsC).brandName, appBrandSysConfigWC.appId, str2);
            final boolean z = PluginAppBrand.getProcessSharedPrefs().getBoolean("key_sendtodesktop_no_more_show_permission_notify_dialog", false);
            Pair<Integer, Integer> a2 = c.a(context, str, z, true, (c.a) new c.a() {
                /* class com.tencent.mm.plugin.appbrand.menu.m.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.base.model.c.a
                public final void d(boolean z, String str, int i2) {
                    AppMethodBeat.i(47639);
                    if (z) {
                        h.INSTANCE.a(15789, Integer.valueOf(i2), 0, str);
                        PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("key_sendtodesktop_no_more_show_permission_notify_dialog", true).apply();
                    }
                    AppMethodBeat.o(47639);
                }
            });
            h.INSTANCE.a(15782, a2.second, 0, str);
            final int i2 = bsB.leE.kNW;
            final int intValue = ((Integer) a2.first).intValue();
            final int intValue2 = ((Integer) a2.second).intValue();
            if (context == null) {
                Log.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or config is null.");
            } else if (aVar.cze == null) {
                Log.e("MicroMsg.AppBrandShortcutManager", "no such user");
            } else {
                Intent a3 = v.a(context, aVar, i2, v.a(context, v.m(aVar.cze), i2), false);
                if (a3 == null) {
                    Log.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
                } else {
                    b.q(context, a3);
                    Log.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", aVar.userName);
                }
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.menu.m.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(47640);
                    atomicBoolean.set(v.a(context, aVar, i2, false));
                    if (atomicBoolean.get()) {
                        h.INSTANCE.idkeyStat(443, 1, 1, false);
                    }
                    if (context == null || !atomicBoolean.get()) {
                        AppMethodBeat.o(47640);
                        return;
                    }
                    c.a(context, intValue, intValue2, z, aVar.appId, true);
                    AppMethodBeat.o(47640);
                }
            });
            i.a(str, agVar2.lBI, 14, "", Util.nowSecond(), 1, 0);
            AppMethodBeat.o(47645);
        }
    }

    m() {
        super(u.SendToDesktop.ordinal());
        AppMethodBeat.i(47644);
        AppMethodBeat.o(47644);
    }

    public static final class a extends as {
        @Override // com.tencent.mm.model.as
        public final boolean rT(int i2) {
            return true;
        }

        @Override // com.tencent.mm.model.as
        public final String getTag() {
            return "MicroMsg.MenuDelegate_SendToDesktop.ConfigMigration";
        }

        @Override // com.tencent.mm.model.as
        public final void transfer(int i2) {
            AppMethodBeat.i(180323);
            if (PluginAppBrand.getProcessSharedPrefs().contains("key_sendtodesktop_no_more_show_permission_notify_dialog")) {
                AppMethodBeat.o(180323);
                return;
            }
            try {
                PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("key_sendtodesktop_no_more_show_permission_notify_dialog", n.NL().get("key_sendtodesktop_no_more_show_permission_notify_dialog", AppEventsConstants.EVENT_PARAM_VALUE_NO).equals("1")).apply();
                AppMethodBeat.o(180323);
            } catch (Throwable th) {
                Log.e("MicroMsg.MenuDelegate_SendToDesktop", "SendToDesktopConfigToMMKVMigration.transfer() error=%s", th);
                AppMethodBeat.o(180323);
            }
        }
    }
}
