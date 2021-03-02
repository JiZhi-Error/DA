package com.tencent.mm.plugin.comm;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zh;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.m.b;
import com.tencent.mm.pluginsdk.j.a.c.o;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.vfs.y;

public class PluginComm extends f implements i, c, a {
    private IListener qCu = new IListener<zh>() {
        /* class com.tencent.mm.plugin.comm.PluginComm.AnonymousClass2 */

        {
            AppMethodBeat.i(161787);
            this.__eventId = zh.class.getName().hashCode();
            AppMethodBeat.o(161787);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zh zhVar) {
            boolean z;
            AppMethodBeat.i(151477);
            zh zhVar2 = zhVar;
            if (zhVar2 instanceof zh) {
                zh.a aVar = zhVar2.efu;
                if (PluginComm.isVoipStarted() || com.tencent.mm.q.a.att()) {
                    z = true;
                } else {
                    z = false;
                }
                aVar.dya = z;
            }
            AppMethodBeat.o(151477);
            return false;
        }
    };

    public PluginComm() {
        AppMethodBeat.i(151478);
        AppMethodBeat.o(151478);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(151479);
        y.b("xlog", "xlog", 864000000, 583);
        y.a("wallet_images", "wallet/images", 52428800, 7776000000L, 7);
        y.at("CheckResUpdate", "CheckResUpdate", 7);
        y.b("share", "share", 259200000, 103);
        y.a("URLImageCache", "Cache", 134217728, 7776000000L, 39);
        y.a("VUserIcon", "vusericon", 16777216, 7776000000L, 7);
        AppMethodBeat.o(151479);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(151480);
        if (gVar.aBb()) {
            pin(com.tencent.mm.plugin.a.blX());
            pin(com.tencent.mm.plugin.g.a.cxS());
            pin(com.tencent.mm.plugin.h.a.cBk());
            pin(d.dZE());
            pin(com.tencent.mm.plugin.image.c.dZD());
            pin(com.tencent.mm.plugin.u.a.eCP());
            pin(b.eip());
            pin(com.tencent.mm.plugin.c.a.bqE());
            pin(com.tencent.mm.plugin.r.a.eAN());
            pin(o.Kah);
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.m.a.a.class, new com.tencent.mm.plugin.m.a());
            ((com.tencent.mm.plugin.auth.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(com.tencent.mm.plugin.g.a.cxS());
            com.tencent.mm.ui.g.a.a.a(new com.tencent.mm.ui.g.a.b() {
                /* class com.tencent.mm.plugin.comm.PluginComm.AnonymousClass1 */

                @Override // com.tencent.mm.ui.g.a.b
                public final void c(ImageView imageView, String str) {
                    AppMethodBeat.i(151476);
                    a.b.c(imageView, str);
                    AppMethodBeat.o(151476);
                }

                @Override // com.tencent.mm.ui.g.a.b
                public final void d(ImageView imageView, String str) {
                    AppMethodBeat.i(169194);
                    a.b.d(imageView, str);
                    AppMethodBeat.o(169194);
                }
            });
        }
        AppMethodBeat.o(151480);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(151481);
        EventCenter.instance.addListener(this.qCu);
        com.tencent.mm.kernel.g.azz().a(302, this);
        com.tencent.mm.plugin.base.model.c.cjL();
        AppMethodBeat.o(151481);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(151482);
        EventCenter.instance.removeListener(this.qCu);
        com.tencent.mm.kernel.g.azz().b(302, this);
        AppMethodBeat.o(151482);
    }

    public static boolean isVoipStarted() {
        AppMethodBeat.i(151483);
        zj zjVar = new zj();
        zjVar.efx.dKy = 2;
        EventCenter.instance.publish(zjVar);
        boolean z = zjVar.efy.calling;
        AppMethodBeat.o(151483);
        return z;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(223696);
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.base.model.c.cjL();
        }
        AppMethodBeat.o(223696);
    }
}
