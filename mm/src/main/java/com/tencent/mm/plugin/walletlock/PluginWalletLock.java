package com.tencent.mm.plugin.walletlock;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.on;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginWalletLock extends f implements c, com.tencent.mm.plugin.walletlock.a.a {
    private com.tencent.mm.plugin.walletlock.c.f IuW = null;
    private final LinkedList<Activity> IuX = new LinkedList<>();
    private IListener<on> IuY = new IListener<on>() {
        /* class com.tencent.mm.plugin.walletlock.PluginWalletLock.AnonymousClass1 */

        {
            AppMethodBeat.i(161148);
            this.__eventId = on.class.getName().hashCode();
            AppMethodBeat.o(161148);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(on onVar) {
            AppMethodBeat.i(129641);
            ((b) g.af(b.class)).init();
            AppMethodBeat.o(129641);
            return false;
        }
    };

    public PluginWalletLock() {
        AppMethodBeat.i(129643);
        AppMethodBeat.o(129643);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(129644);
        alias(com.tencent.mm.plugin.walletlock.a.a.class);
        AppMethodBeat.o(129644);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(129645);
        dependsOn(com.tencent.mm.plugin.soter.a.a.class);
        AppMethodBeat.o(129645);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(129646);
        if (gVar.aBb()) {
            Log.i("MicroMsg.PluginWalletLock", "alvinluo registerService IWalletLock and add listeners");
            g.a(b.class, new e(new com.tencent.mm.plugin.walletlock.c.e()));
            ab.a(1, new a(this, (byte) 0));
            this.IuY.alive();
        }
        AppMethodBeat.o(129646);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void uninstalled() {
        AppMethodBeat.i(129647);
        super.uninstalled();
        this.IuY.dead();
        AppMethodBeat.o(129647);
    }

    class a implements y<cqm> {
        private a() {
        }

        /* synthetic */ a(PluginWalletLock pluginWalletLock, byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
        @Override // com.tencent.mm.plugin.messenger.foundation.a.y
        public final /* bridge */ /* synthetic */ void a(cqm cqm) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
        @Override // com.tencent.mm.plugin.messenger.foundation.a.y
        public final /* synthetic */ void b(cqm cqm) {
            AppMethodBeat.i(129642);
            Log.i("MicroMsg.PluginWalletLock", "alvinluo afterSyncDoCmd");
            ((b) g.af(b.class)).init();
            AppMethodBeat.o(129642);
        }
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(187541);
        if (gVar.aBb()) {
            gVar.ca.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.appbrand.ac.a() {
                /* class com.tencent.mm.plugin.walletlock.PluginWalletLock.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.ac.a
                public final void onActivityCreated(Activity activity, Bundle bundle) {
                    AppMethodBeat.i(187539);
                    if (activity instanceof com.tencent.mm.plugin.walletlock.ui.a) {
                        Iterator it = PluginWalletLock.this.IuX.iterator();
                        while (it.hasNext()) {
                            ((Activity) it.next()).finish();
                        }
                        PluginWalletLock.this.IuX.clear();
                        PluginWalletLock.this.IuX.add(activity);
                    }
                    AppMethodBeat.o(187539);
                }

                @Override // com.tencent.mm.plugin.appbrand.ac.a
                public final void onActivityDestroyed(Activity activity) {
                    AppMethodBeat.i(187540);
                    if (activity instanceof com.tencent.mm.plugin.walletlock.ui.a) {
                        PluginWalletLock.this.IuX.remove(activity);
                    }
                    AppMethodBeat.o(187540);
                }
            });
        }
        AppMethodBeat.o(187541);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-wallet-lock";
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        String str;
        AppMethodBeat.i(129648);
        Log.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountInitialized");
        this.IuW = new com.tencent.mm.plugin.walletlock.c.f();
        com.tencent.mm.plugin.walletlock.c.f fVar = this.IuW;
        if (!EventCenter.instance.hadListened(fVar.IwP)) {
            EventCenter.instance.addListener(fVar.IwP);
        }
        if (!EventCenter.instance.hadListened(fVar.IwQ)) {
            EventCenter.instance.addListener(fVar.IwQ);
        }
        if (!EventCenter.instance.hadListened(fVar.IwS)) {
            EventCenter.instance.addListener(fVar.IwS);
        }
        try {
            str = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("PatternLockTimeInterval");
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WalletLockInitTask", e2, "", new Object[0]);
            str = null;
        }
        if (!Util.isNullOrNil(str)) {
            int i2 = Util.getInt(str, 0);
            if (i2 >= 0) {
                Log.d("MicroMsg.WalletLockInitTask", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", Integer.valueOf(i2)));
                com.tencent.mm.plugin.walletlock.gesture.a.a.Ivw = i2;
                AppMethodBeat.o(129648);
                return;
            }
            Log.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
            com.tencent.mm.plugin.walletlock.gesture.a.a.Ivw = 300;
            AppMethodBeat.o(129648);
            return;
        }
        Log.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
        com.tencent.mm.plugin.walletlock.gesture.a.a.Ivw = 300;
        AppMethodBeat.o(129648);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(129649);
        Log.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountRelease");
        if (this.IuW != null) {
            com.tencent.mm.plugin.walletlock.c.f fVar = this.IuW;
            if (EventCenter.instance.hadListened(fVar.IwP)) {
                EventCenter.instance.removeListener(fVar.IwP);
            }
            if (EventCenter.instance.hadListened(fVar.IwQ)) {
                EventCenter.instance.removeListener(fVar.IwQ);
            }
            if (EventCenter.instance.hadListened(fVar.IwS)) {
                EventCenter.instance.removeListener(fVar.IwS);
            }
            i iVar = i.INSTANCE;
            if (iVar.Ixc != null) {
                iVar.Ixc.clear();
            }
        }
        AppMethodBeat.o(129649);
    }
}
