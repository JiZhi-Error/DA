package com.tencent.mm.plugin.fcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.fcm.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginFCM extends f implements a {
    private static boolean tnE = true;
    IListener tnF = new IListener<hc>() {
        /* class com.tencent.mm.plugin.fcm.PluginFCM.AnonymousClass1 */

        {
            AppMethodBeat.i(161146);
            this.__eventId = hc.class.getName().hashCode();
            AppMethodBeat.o(161146);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hc hcVar) {
            AppMethodBeat.i(127582);
            Log.i("MicroMsg.FCM.PluginFCM", "fcmRegisterEventListener callback loadFCM=" + PluginFCM.tnE);
            if (PluginFCM.tnE) {
                PluginFCM.access$100(PluginFCM.this);
            }
            AppMethodBeat.o(127582);
            return false;
        }
    };
    IListener tnG = new IListener<hd>() {
        /* class com.tencent.mm.plugin.fcm.PluginFCM.AnonymousClass2 */

        {
            AppMethodBeat.i(161147);
            this.__eventId = hd.class.getName().hashCode();
            AppMethodBeat.o(161147);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hd hdVar) {
            AppMethodBeat.i(127583);
            Log.i("MicroMsg.FCM.PluginFCM", "fcmUnRegisterEventListener callback loadFCM=" + PluginFCM.tnE);
            if (PluginFCM.tnE) {
                PluginFCM.access$200(PluginFCM.this);
            }
            AppMethodBeat.o(127583);
            return false;
        }
    };

    public PluginFCM() {
        AppMethodBeat.i(127584);
        AppMethodBeat.o(127584);
    }

    static /* synthetic */ boolean access$100(PluginFCM pluginFCM) {
        AppMethodBeat.i(127590);
        boolean handleLogin = pluginFCM.handleLogin();
        AppMethodBeat.o(127590);
        return handleLogin;
    }

    static /* synthetic */ boolean access$200(PluginFCM pluginFCM) {
        AppMethodBeat.i(127591);
        boolean handleLogout = pluginFCM.handleLogout();
        AppMethodBeat.o(127591);
        return handleLogout;
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(127585);
        super.installed();
        alias(a.class);
        AppMethodBeat.o(127585);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(127586);
        super.configure(gVar);
        AppMethodBeat.o(127586);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(127587);
        if (gVar.aBb()) {
            Log.i("MicroMsg.FCM.PluginFCM", "register listener at " + gVar.mProcessName);
            if (!a.fj(gVar.ca)) {
                tnE = false;
                AppMethodBeat.o(127587);
                return;
            }
            EventCenter.instance.add(this.tnF);
            EventCenter.instance.add(this.tnG);
        }
        AppMethodBeat.o(127587);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-fcm";
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean handleLogin() {
        /*
        // Method dump skipped, instructions count: 156
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fcm.PluginFCM.handleLogin():boolean");
    }

    private boolean handleLogout() {
        AppMethodBeat.i(127589);
        b cXf = b.cXf();
        if (cXf != null) {
            Log.i("MicroMsg.FCM.FcmRegister", "FCM onLogout. isRegToSvr:" + cXf.cXj());
            WCFirebaseMessagingService.cXl();
            if (cXf.cXj()) {
                cXf.cXi();
            } else {
                e.INSTANCE.idkeyStat(901, 20, 1, false);
            }
            AppMethodBeat.o(127589);
            return true;
        }
        AppMethodBeat.o(127589);
        return false;
    }
}
