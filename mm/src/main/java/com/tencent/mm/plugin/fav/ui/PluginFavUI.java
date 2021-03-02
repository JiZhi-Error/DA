package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.fav.ui.b.d;
import com.tencent.mm.plugin.fav.ui.c.a;
import com.tencent.mm.plugin.fts.a.n;

public class PluginFavUI extends f implements b, c {
    private a tgZ = new a();
    private a tha = new a();
    private q thb = new q();

    public PluginFavUI() {
        AppMethodBeat.i(107082);
        AppMethodBeat.o(107082);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public void parallelsDependency() {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(107083);
        this.tgZ.alive();
        this.tha.alive();
        this.thb.alive();
        ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a() {
            /* class com.tencent.mm.plugin.fav.ui.PluginFavUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.fts.a.a.a
            public final boolean execute() {
                AppMethodBeat.i(107081);
                ((n) com.tencent.mm.kernel.g.ah(n.class)).registerFTSUILogic(new d());
                ((n) com.tencent.mm.kernel.g.ah(n.class)).registerFTSUILogic(new com.tencent.mm.plugin.fav.ui.b.b());
                AppMethodBeat.o(107081);
                return true;
            }

            @Override // com.tencent.mm.plugin.fts.a.a.a
            public final String getName() {
                return "InitFTSFavUIPluginTask";
            }
        });
        AppMethodBeat.o(107083);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(107084);
        this.tgZ.dead();
        this.tha.dead();
        this.thb.dead();
        AppMethodBeat.o(107084);
    }
}
