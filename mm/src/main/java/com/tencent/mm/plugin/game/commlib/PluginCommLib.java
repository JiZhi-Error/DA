package com.tencent.mm.plugin.game.commlib;

import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.commlib.a.b;
import com.tencent.mm.plugin.game.commlib.util.BatteryManager;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class PluginCommLib extends f implements c, b {
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.game.commlib.PluginCommLib.AnonymousClass2 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(89942);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                a.azj();
            }
            AppMethodBeat.o(89942);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(89943);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!a.azj()) {
                    com.tencent.mm.plugin.game.commlib.util.b.clean();
                }
            }
            AppMethodBeat.o(89943);
        }
    };
    private IListener sKr = new IListener<mi>() {
        /* class com.tencent.mm.plugin.game.commlib.PluginCommLib.AnonymousClass1 */

        {
            AppMethodBeat.i(161739);
            this.__eventId = mi.class.getName().hashCode();
            AppMethodBeat.o(161739);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mi miVar) {
            AppMethodBeat.i(89941);
            Log.i("MicroMsg.PluginCommLib", "manual force login");
            b.dTd().I(true, 4);
            AppMethodBeat.o(89941);
            return false;
        }
    };

    public PluginCommLib() {
        AppMethodBeat.i(89944);
        AppMethodBeat.o(89944);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(89946);
        if (gVar.aBb()) {
            g.b(com.tencent.mm.plugin.game.commlib.a.a.class, new d());
        }
        AppMethodBeat.o(89946);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(89947);
        EventCenter.instance.add(this.sKr);
        this.appForegroundListener.alive();
        if (BatteryManager.xvz == null) {
            BatteryManager.xvz = new BatteryManager.BatteryChangedReceiver((byte) 0);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        MMApplicationContext.getContext().registerReceiver(BatteryManager.xvz, intentFilter);
        AppMethodBeat.o(89947);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(89948);
        EventCenter.instance.removeListener(this.sKr);
        com.tencent.mm.plugin.game.commlib.util.a.bZm();
        this.appForegroundListener.dead();
        if (BatteryManager.xvz != null) {
            MMApplicationContext.getContext().unregisterReceiver(BatteryManager.xvz);
        }
        BatteryManager.xvz = null;
        AppMethodBeat.o(89948);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(89945);
        e.azp(gVar.mProcessName);
        AppMethodBeat.o(89945);
    }
}
