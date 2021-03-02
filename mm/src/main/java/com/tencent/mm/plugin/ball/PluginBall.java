package com.tencent.mm.plugin.ball;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.a;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.service.FloatBallReportServiceProxy;
import com.tencent.mm.plugin.ball.service.FloatBallServiceProxy;
import com.tencent.mm.plugin.ball.service.c;
import com.tencent.mm.plugin.ball.service.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class PluginBall extends f implements c, com.tencent.mm.plugin.ball.c.c {
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.ball.PluginBall.AnonymousClass1 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(106006);
            Log.i("MicroMsg.PluginBall", "onAppForeground, activity:%s", str);
            if (AppForegroundDelegate.INSTANCE.cPB && g.aAc() && g.af(b.class) != null) {
                boolean isTopApplication = Util.isTopApplication(MMApplicationContext.getContext());
                Log.i("MicroMsg.PluginBall", "alvinluo onAppForeground isTopApplication: %b", Boolean.valueOf(isTopApplication));
                if (isTopApplication) {
                    ((b) g.af(b.class)).jM(true);
                    ((b) g.af(b.class)).jQ(true);
                }
            }
            AppMethodBeat.o(106006);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(106007);
            Log.i("MicroMsg.PluginBall", "onAppBackground, activity:%s", str);
            if (!AppForegroundDelegate.INSTANCE.cPB && g.aAc() && g.af(b.class) != null) {
                ((b) g.af(b.class)).jL(false);
                ((b) g.af(b.class)).jQ(false);
            }
            if (g.af(a.class) != null) {
                ((a) g.af(a.class)).jK(AppForegroundDelegate.INSTANCE.cPB);
            }
            AppMethodBeat.o(106007);
        }
    };

    public PluginBall() {
        AppMethodBeat.i(106008);
        AppMethodBeat.o(106008);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-ball";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(106009);
        Log.i("MicroMsg.PluginBall", "dependency");
        if (MMApplicationContext.isMainProcess()) {
            dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        }
        dependsOn(com.tencent.mm.plugin.handoff.a.b.class);
        AppMethodBeat.o(106009);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(106010);
        Log.i("MicroMsg.PluginBall", "installed");
        alias(com.tencent.mm.plugin.ball.c.c.class);
        AppMethodBeat.o(106010);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void uninstalled() {
        AppMethodBeat.i(106011);
        Log.i("MicroMsg.PluginBall", "uninstalled");
        super.uninstalled();
        AppMethodBeat.o(106011);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(106012);
        Log.i("MicroMsg.PluginBall", "execute");
        if (gVar.aBb()) {
            Log.i("MicroMsg.PluginBall", "register IFloatBallService in MM process");
            g.b(b.class, d.ciB());
            c.a aVar = com.tencent.mm.plugin.ball.service.c.oWM;
            g.b(a.class, c.a.ciA());
            AppMethodBeat.o(106012);
            return;
        }
        FloatBallServiceProxy floatBallServiceProxy = new FloatBallServiceProxy();
        g.b(b.class, floatBallServiceProxy);
        FloatBallReportServiceProxy.a aVar2 = FloatBallReportServiceProxy.oWQ;
        kotlin.f fVar = FloatBallReportServiceProxy.iax;
        FloatBallReportServiceProxy.a aVar3 = FloatBallReportServiceProxy.oWQ;
        g.b(a.class, (FloatBallReportServiceProxy) fVar.getValue());
        Log.i("MicroMsg.PluginBall", "register IFloatBallService in non-MM process, proxy:%s", floatBallServiceProxy);
        AppMethodBeat.o(106012);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(106013);
        Log.i("MicroMsg.PluginBall", "onAccountInitialized");
        this.appForegroundListener.alive();
        if (g.af(b.class) != null) {
            ((b) g.af(b.class)).chL();
        }
        AppMethodBeat.o(106013);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(106014);
        Log.i("MicroMsg.PluginBall", "onAccountRelease");
        this.appForegroundListener.dead();
        if (g.af(b.class) != null) {
            ((b) g.af(b.class)).onAccountRelease();
        }
        AppMethodBeat.o(106014);
    }
}
