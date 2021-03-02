package com.tencent.mm.plugin.music;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.music.a.a;
import com.tencent.mm.plugin.music.b.a.d;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.e.l;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.music.model.k;
import com.tencent.mm.plugin.music.model.n;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class PluginMusic extends f implements a {
    private IListener AgM = new IListener<mw>() {
        /* class com.tencent.mm.plugin.music.PluginMusic.AnonymousClass1 */

        {
            AppMethodBeat.i(178785);
            this.__eventId = mw.class.getName().hashCode();
            AppMethodBeat.o(178785);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mw mwVar) {
            AppMethodBeat.i(178786);
            mw mwVar2 = mwVar;
            if (mwVar2 instanceof mw) {
                switch (mwVar2.dSw.action) {
                    case 14:
                        if (((e) b.aS(e.class)).getMode() == 2) {
                            ((e) b.aS(e.class)).euc();
                            break;
                        }
                        break;
                    case 15:
                        if (((e) b.aS(e.class)).getMode() == 2) {
                            ((e) b.aS(e.class)).eud();
                            break;
                        }
                        break;
                }
            }
            AppMethodBeat.o(178786);
            return false;
        }
    };

    public PluginMusic() {
        AppMethodBeat.i(178787);
        AppMethodBeat.o(178787);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(62935);
        alias(a.class);
        AppMethodBeat.o(62935);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-music";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(62936);
        b.init(MMApplicationContext.getContext());
        b.a(c.class, new com.tencent.mm.plugin.music.model.a.c());
        b.a(d.class, new com.tencent.mm.plugin.music.b.a.c());
        b.a(com.tencent.mm.plugin.music.e.b.class, new l());
        com.tencent.mm.plugin.music.b.f.init();
        com.tencent.mm.plugin.music.f.a.a.a(new com.tencent.mm.plugin.music.model.c.b());
        if (gVar.aBb()) {
            Log.i("MicroMsg.Music.PluginMusic", "PluginMusic configure SubCoreMusic");
            pin(new y(o.class));
            com.tencent.mm.kernel.g.b(com.tencent.mm.ay.a.b.class, new n());
            com.tencent.mm.kernel.g.b(com.tencent.mm.ay.a.a.class, new h());
            k.euA();
        }
        this.AgM.alive();
        AppMethodBeat.o(62936);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(62937);
        if (gVar.aBb()) {
            Log.i("MicroMsg.Music.PluginMusic", "PluginMusic execute");
            com.tencent.mm.br.b.bfQ("music");
        }
        AppMethodBeat.o(62937);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void uninstalled() {
        AppMethodBeat.i(62938);
        super.uninstalled();
        com.tencent.mm.plugin.music.b.f.release();
        b.ag(c.class);
        b.ag(d.class);
        b.ag(com.tencent.mm.plugin.music.e.b.class);
        b.release();
        this.AgM.dead();
        k.euB();
        AppMethodBeat.o(62938);
    }
}
