package com.tencent.mm.plugin.handoff;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.handoff.c.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0002X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/handoff/PluginHandOff;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/handoff/api/IPluginHandOff;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "appForegroundListener", "com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1;", "userStatusChangeListener", "Lcom/tencent/mm/model/IOnUserStatusChange;", "dependency", "", "execute", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "installed", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "uninstalled", "plugin-handoff_release"})
public final class PluginHandOff extends f implements c, com.tencent.mm.plugin.handoff.a.b {
    private final String TAG = "PluginHandOff";
    private final a yhC = new a();
    private final bc yhD = new b(this);

    public PluginHandOff() {
        AppMethodBeat.i(10338);
        AppMethodBeat.o(10338);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "", "onAppForeground", "plugin-handoff_release"})
    public static final class a extends o.a {
        a() {
        }

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(10329);
            e eVar = e.yim;
            e.T(e.k.yis);
            AppMethodBeat.o(10329);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(10330);
            e eVar = e.yim;
            e.T(e.j.yir);
            AppMethodBeat.o(10330);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onNotifyUserStatusChange"})
    static final class b implements bc {
        final /* synthetic */ PluginHandOff yhE;

        b(PluginHandOff pluginHandOff) {
            this.yhE = pluginHandOff;
        }

        @Override // com.tencent.mm.model.bc
        public final void aVw() {
            AppMethodBeat.i(10331);
            String str = this.yhE.TAG;
            StringBuilder sb = new StringBuilder("webwx online status: ");
            com.tencent.mm.kernel.a aAf = g.aAf();
            p.g(aAf, "MMKernel.account()");
            Log.i(str, sb.append(aAf.azn()).toString());
            com.tencent.mm.plugin.appbrand.service.o oVar = (com.tencent.mm.plugin.appbrand.service.o) g.af(com.tencent.mm.plugin.appbrand.service.o.class);
            if (oVar != null) {
                GetOnLineInfoInfoResult getOnLineInfoInfoResult = new GetOnLineInfoInfoResult();
                getOnLineInfoInfoResult.kDf = oVar.beN();
                getOnLineInfoInfoResult.jjN = oVar.beL();
                getOnLineInfoInfoResult.jjS = oVar.beM();
                ((com.tencent.mm.plugin.appbrand.service.f) g.af(com.tencent.mm.plugin.appbrand.service.f.class)).a("Common_IPC_appid", getOnLineInfoInfoResult);
                ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).a(getOnLineInfoInfoResult);
            }
            com.tencent.mm.kernel.a aAf2 = g.aAf();
            p.g(aAf2, "MMKernel.account()");
            if (aAf2.azn()) {
                Log.i(this.yhE.TAG, "webwx is online, send alllist");
                e.yim.dYk();
            }
            AppMethodBeat.o(10331);
        }
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public final String name() {
        return "plugin-handoff";
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void dependency() {
        AppMethodBeat.i(10332);
        Log.i(this.TAG, "dependency");
        if (MMApplicationContext.isMainProcess()) {
            dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        }
        AppMethodBeat.o(10332);
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void installed() {
        AppMethodBeat.i(10333);
        Log.i(this.TAG, "installed");
        alias(com.tencent.mm.plugin.handoff.a.b.class);
        AppMethodBeat.o(10333);
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void uninstalled() {
        AppMethodBeat.i(10334);
        Log.i(this.TAG, "uninstalled");
        super.uninstalled();
        AppMethodBeat.o(10334);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(10335);
        p.h(gVar, Scopes.PROFILE);
        Log.i(this.TAG, "execute");
        if (gVar.aBb()) {
            g.b(com.tencent.mm.plugin.handoff.a.a.class, e.yim);
            AppMethodBeat.o(10335);
            return;
        }
        g.b(com.tencent.mm.plugin.handoff.a.a.class, new com.tencent.mm.plugin.handoff.c.g());
        AppMethodBeat.o(10335);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(10336);
        Log.i(this.TAG, "onAccountInitialized");
        this.yhC.alive();
        g.aAf().a(this.yhD);
        AppMethodBeat.o(10336);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(10337);
        Log.i(this.TAG, "onAccountRelease");
        this.yhC.dead();
        g.aAf().b(this.yhD);
        AppMethodBeat.o(10337);
    }
}
