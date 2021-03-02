package com.tencent.mm.plugin.sport;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.sport.model.SportForegroundService;
import com.tencent.mm.plugin.sport.model.g;
import com.tencent.mm.plugin.sport.model.i;
import com.tencent.mm.plugin.sport.model.j;
import com.tencent.mm.plugin.sport.model.k;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class PluginSport extends f implements b, a, c, a {
    public static HashMap<Integer, h.b> baseDBFactories = new HashMap<>();
    private i FiK;
    private com.tencent.mm.plugin.sport.a.b FiL;
    private com.tencent.mm.plugin.sport.model.a FiM;
    private com.tencent.mm.plugin.sport.model.b FiN;
    private g.a FiO = new g.a() {
        /* class com.tencent.mm.plugin.sport.PluginSport.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.sport.model.g.a
        public final void awp() {
            AppMethodBeat.i(149249);
            com.tencent.mm.plugin.sport.model.a deviceStepManager = PluginSport.this.getDeviceStepManager();
            if (deviceStepManager.FiX != null) {
                deviceStepManager.FiX.fmp();
            }
            AppMethodBeat.o(149249);
        }
    };
    private com.tencent.mm.plugin.sport.model.f FiP;
    private BroadcastReceiver FiQ = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.sport.PluginSport.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(161588);
            if ("com.tencent.mm.plugin.sport.uploadstep".equals(intent.getAction())) {
                com.tencent.f.h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.plugin.sport.PluginSport.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(199373);
                        if (k.hg(MMApplicationContext.getContext()) && k.fmg()) {
                            PluginSport.this.getDeviceStepManager().fmj();
                        }
                        AppMethodBeat.o(199373);
                    }
                }, "UploadSportStepEventHandle");
            }
            AppMethodBeat.o(161588);
        }
    };

    public PluginSport() {
        AppMethodBeat.i(149251);
        AppMethodBeat.o(149251);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(149252);
        if (this.FiK == null) {
            this.FiK = j.fmC();
        }
        if (gVar.aBb()) {
            this.FiL = new b();
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sport.a.b.class, new e(this.FiL));
            AppMethodBeat.o(149252);
            return;
        }
        if (gVar.FY(":push")) {
            getPushSportStepDetector();
            SportForegroundService.fmF();
        }
        AppMethodBeat.o(149252);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(149253);
        this.FiM = new com.tencent.mm.plugin.sport.model.a();
        this.FiN = new com.tencent.mm.plugin.sport.model.b();
        g.a(this.FiO);
        this.FiO.awp();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.plugin.sport.uploadstep");
        MMApplicationContext.getContext().registerReceiver(this.FiQ, intentFilter);
        AppMethodBeat.o(149253);
    }

    public i getSportFileStorage() {
        AppMethodBeat.i(149254);
        if (this.FiK == null) {
            this.FiK = j.fmC();
        }
        i iVar = this.FiK;
        AppMethodBeat.o(149254);
        return iVar;
    }

    public com.tencent.mm.plugin.sport.model.a getDeviceStepManager() {
        return this.FiM;
    }

    public com.tencent.mm.plugin.sport.model.b getExtApiStepManager() {
        return this.FiN;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(149255);
        MMApplicationContext.getContext().unregisterReceiver(this.FiQ);
        g.a(null);
        if (this.FiM != null) {
            com.tencent.mm.plugin.sport.model.a aVar = this.FiM;
            aVar.FiX.fmq();
            aVar.FiY.dead();
            if (aVar.FiZ != null) {
                com.tencent.mm.kernel.g.azz().a(aVar.FiZ);
            }
            this.FiM = null;
        }
        if (this.FiN != null) {
            com.tencent.mm.plugin.sport.model.b bVar = this.FiN;
            bVar.Fjg.dead();
            bVar.FiY.dead();
            if (bVar.FiZ != null) {
                com.tencent.mm.kernel.g.azz().a(bVar.FiZ);
            }
            this.FiN = null;
        }
        AppMethodBeat.o(149255);
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public void parallelsDependency() {
        AppMethodBeat.i(149256);
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bI(com.tencent.mm.kernel.g.ah(s.class));
        AppMethodBeat.o(149256);
    }

    static {
        AppMethodBeat.i(149258);
        AppMethodBeat.o(149258);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        return baseDBFactories;
    }

    public com.tencent.mm.plugin.sport.model.f getPushSportStepDetector() {
        AppMethodBeat.i(149257);
        if (MMApplicationContext.isPushProcess() && this.FiP == null) {
            this.FiP = new com.tencent.mm.plugin.sport.model.f();
        }
        com.tencent.mm.plugin.sport.model.f fVar = this.FiP;
        AppMethodBeat.o(149257);
        return fVar;
    }
}
