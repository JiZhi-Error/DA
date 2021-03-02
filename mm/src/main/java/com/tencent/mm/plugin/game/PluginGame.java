package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.api.i;
import com.tencent.mm.plugin.game.commlib.c.a;
import com.tencent.mm.plugin.game.media.o;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.recordvideo.background.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginGame extends f implements c, i {
    c xtU;

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(40855);
        y.at("Game", "Game", 7);
        if (gVar.aBb()) {
            Log.i("MicroMsg.PluginGame", "PluginGame configure");
            b.a.a(new b());
            if (this.xtU == null) {
                this.xtU = new c();
            }
        }
        if (gVar.FY(":tools")) {
            h.INSTANCE.n(939, 1, 1);
        }
        if (gVar.FY(":toolsmp")) {
            h.INSTANCE.n(939, 10, 1);
        }
        AppMethodBeat.o(40855);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(40856);
        if (gVar.aBb()) {
            Log.i("MicroMsg.PluginGame", "PluginGame execute");
            com.tencent.mm.br.b.bfQ("game");
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.f.class, new f());
            com.tencent.mm.kernel.g.b(e.class, new e());
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.c.class, new d());
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.api.g.class, new com.tencent.mm.kernel.c.e(new o()));
            com.tencent.mm.kernel.g.b(d.class, new com.tencent.mm.plugin.game.media.f());
            AppMethodBeat.o(40856);
            return;
        }
        if (gVar.FY(":tools") || gVar.FY(":toolsmp") || gVar.FZ(":appbrand")) {
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.api.g.class, new com.tencent.mm.kernel.c.e(new o()));
        }
        AppMethodBeat.o(40856);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(40857);
        Log.i("MicroMsg.PluginGame", "onAccountInitialized");
        if (this.xtU != null) {
            c cVar2 = this.xtU;
            ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("gamecenter", cVar2.rBq, true);
            EventCenter.instance.addListener(cVar2.xtq);
            EventCenter.instance.addListener(cVar2.xts);
            EventCenter.instance.addListener(cVar2.xtu);
            EventCenter.instance.addListener(cVar2.grk);
            EventCenter.instance.addListener(cVar2.xtv);
            EventCenter.instance.addListener(cVar2.xtw);
            EventCenter.instance.addListener(cVar2.xtx);
            EventCenter.instance.addListener(cVar2.xty);
            EventCenter.instance.addListener(cVar2.xtz);
            EventCenter.instance.addListener(cVar2.xtD);
            EventCenter.instance.addListener(cVar2.xtE);
            EventCenter.instance.addListener(cVar2.xtA);
            EventCenter.instance.addListener(cVar2.xtF);
            EventCenter.instance.addListener(cVar2.xtG);
            EventCenter.instance.addListener(cVar2.sKr);
            EventCenter.instance.addListener(cVar2.xtH);
            EventCenter.instance.addListener(cVar2.xtt);
            k.cBn();
            com.tencent.mm.plugin.game.model.a.e.cBn();
            c.appForegroundListener.alive();
            a aVar = a.BKb;
            a.a(5, cVar2.xtr);
        }
        checkHaowanPublishState();
        com.tencent.mm.plugin.game.commlib.c.a.dTf().a("game_resource_check", new a.AbstractC1395a() {
            /* class com.tencent.mm.plugin.game.PluginGame.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.game.commlib.c.a.AbstractC1395a
            public final void cBm() {
                AppMethodBeat.i(204096);
                com.tencent.mm.plugin.game.c.b bVar = com.tencent.mm.plugin.game.c.b.xvL;
                com.tencent.mm.plugin.game.c.b.dTh();
                AppMethodBeat.o(204096);
            }
        });
        AppMethodBeat.o(40857);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(40858);
        Log.i("MicroMsg.PluginGame", "onAccountRelease");
        if (this.xtU != null) {
            c cVar = this.xtU;
            ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("gamecenter", cVar.rBq, true);
            EventCenter.instance.removeListener(cVar.xtq);
            EventCenter.instance.removeListener(cVar.xts);
            EventCenter.instance.removeListener(cVar.xtu);
            EventCenter.instance.removeListener(cVar.grk);
            EventCenter.instance.removeListener(cVar.xtv);
            EventCenter.instance.removeListener(cVar.xtw);
            EventCenter.instance.removeListener(cVar.xtx);
            EventCenter.instance.removeListener(cVar.xty);
            EventCenter.instance.removeListener(cVar.xtz);
            EventCenter.instance.removeListener(cVar.xtD);
            EventCenter.instance.removeListener(cVar.xtE);
            EventCenter.instance.removeListener(cVar.xtA);
            EventCenter.instance.removeListener(cVar.xtF);
            EventCenter.instance.removeListener(cVar.xtG);
            EventCenter.instance.removeListener(cVar.sKr);
            EventCenter.instance.removeListener(cVar.xtH);
            EventCenter.instance.removeListener(cVar.xtt);
            k.cBo();
            com.tencent.mm.plugin.game.model.a.e.cBo();
            c.appForegroundListener.dead();
            com.tencent.mm.plugin.recordvideo.background.a aVar = com.tencent.mm.plugin.recordvideo.background.a.BKb;
            com.tencent.mm.plugin.recordvideo.background.a.b(5, cVar.xtr);
        }
        com.tencent.mm.plugin.game.e.c.bZm();
        AppMethodBeat.o(40858);
    }

    private void checkHaowanPublishState() {
        AppMethodBeat.i(40859);
        com.tencent.f.h.RTc.o(new Runnable() {
            /* class com.tencent.mm.plugin.game.PluginGame.AnonymousClass2 */

            public final void run() {
                LinkedList linkedList;
                AppMethodBeat.i(204097);
                try {
                    com.tencent.mm.plugin.game.media.g dSN = ((com.tencent.mm.plugin.game.api.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSN();
                    String format = String.format("select * from %s where %s=%d", "GameHaowanPublishEdition", "publishState", 0);
                    Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryAllPublish: %s", format);
                    Cursor rawQuery = dSN.rawQuery(format, new String[0]);
                    if (rawQuery == null) {
                        linkedList = null;
                    } else {
                        linkedList = new LinkedList();
                        while (rawQuery.moveToNext()) {
                            com.tencent.mm.plugin.game.media.e eVar = new com.tencent.mm.plugin.game.media.e();
                            eVar.convertFrom(rawQuery);
                            linkedList.add(eVar);
                        }
                        rawQuery.close();
                    }
                    if (Util.isNullOrNil(linkedList)) {
                        Log.i("MicroMsg.PluginGame", "checkHaowanPublishState none");
                        AppMethodBeat.o(204097);
                        return;
                    }
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.mm.plugin.game.api.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSN().azY(((com.tencent.mm.plugin.game.media.e) it.next()).field_taskId);
                    }
                    AppMethodBeat.o(204097);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.PluginGame", e2, "", new Object[0]);
                    AppMethodBeat.o(204097);
                }
            }
        }, 500);
        AppMethodBeat.o(40859);
    }
}
