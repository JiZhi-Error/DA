package com.tencent.mm.plugin.fav.offline;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.offline.b.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.y;
import java.util.HashMap;

public class PluginFavOffline extends f implements a, c, a {
    private static HashMap<Integer, h.b> baseDBFactories;
    private IListener<gv> tcw = new IListener<gv>() {
        /* class com.tencent.mm.plugin.fav.offline.PluginFavOffline.AnonymousClass2 */

        {
            AppMethodBeat.i(160971);
            this.__eventId = gv.class.getName().hashCode();
            AppMethodBeat.o(160971);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gv gvVar) {
            boolean af;
            AppMethodBeat.i(73528);
            gv gvVar2 = gvVar;
            if (gvVar2 != null) {
                String str = gvVar2.dKQ.url;
                if (Util.isNullOrNil(str)) {
                    Log.i("MicroMsg.offline.FavOfflineHelp", "deleteFavOffline url is null!");
                    af = false;
                } else {
                    com.tencent.mm.plugin.fav.offline.b.a ask = ((PluginFavOffline) g.ah(PluginFavOffline.class)).getFavOfflineStorage().ask(str);
                    if (ask == null) {
                        Log.i("MicroMsg.offline.FavOfflineHelp", "deleteFavOffline favOffline is null!");
                        af = false;
                    } else {
                        af = com.tencent.mm.plugin.fav.offline.a.a.af(str, ask.field_path, ask.field_imgDirPath);
                    }
                }
                Log.i("MicroMsg.offline.PluginFavOffline", "FavDeleteEvent url:%s result:%s", gvVar2.dKQ.url, Boolean.valueOf(af));
            }
            AppMethodBeat.o(73528);
            return true;
        }
    };
    private b tcx = null;
    private com.tencent.mm.plugin.fav.offline.a.b tcy = null;

    public PluginFavOffline() {
        AppMethodBeat.i(73529);
        AppMethodBeat.o(73529);
    }

    static {
        AppMethodBeat.i(73537);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("GROUPSOLITAIRE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.fav.offline.PluginFavOffline.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(73537);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(73530);
        this.tcx = new b(g.aAh().hqK);
        this.tcy = new com.tencent.mm.plugin.fav.offline.a.b();
        this.tcw.alive();
        AppMethodBeat.o(73530);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(73531);
        if (this.tcy != null) {
            g.aAg().b(this.tcy.iRt);
            this.tcy = null;
        }
        this.tcw.dead();
        AppMethodBeat.o(73531);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(73532);
        g.b(ae.class, new com.tencent.mm.plugin.fav.offline.a.c());
        AppMethodBeat.o(73532);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(73533);
        if (gVar.aBb()) {
            y.at("favoffline", "favoffline", 3);
        }
        AppMethodBeat.o(73533);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        return baseDBFactories;
    }

    public boolean useOffline(String str, long j2) {
        AppMethodBeat.i(73534);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(73534);
            return false;
        }
        com.tencent.mm.plugin.fav.offline.b.a ask = getFavOfflineStorage().ask(str);
        if (ask == null) {
            Log.i("MicroMsg.offline.PluginFavOffline", "useOffline url(%s) favOffline is null", str);
            AppMethodBeat.o(73534);
            return false;
        }
        if (!getFavOfflineService().tcC) {
            Log.i("MicroMsg.offline.PluginFavOffline", "useOffline url:%s status:%s", ask.field_url, Integer.valueOf(ask.field_status));
            if (ask.field_status != 0) {
                Intent intent = new Intent();
                intent.putExtra("key_path", ask.field_url);
                intent.putExtra("key_detail_info_id", j2);
                com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "fav.offline", ".ui.FavOfflineWebViewUI", intent);
                AppMethodBeat.o(73534);
                return true;
            }
        }
        AppMethodBeat.o(73534);
        return false;
    }

    public b getFavOfflineStorage() {
        AppMethodBeat.i(73535);
        g.aAf().azk();
        b bVar = this.tcx;
        AppMethodBeat.o(73535);
        return bVar;
    }

    public com.tencent.mm.plugin.fav.offline.a.b getFavOfflineService() {
        AppMethodBeat.i(73536);
        g.aAf().azk();
        com.tencent.mm.plugin.fav.offline.a.b bVar = this.tcy;
        AppMethodBeat.o(73536);
        return bVar;
    }

    public static String getFavOfflinePath() {
        return "wcf://favoffline";
    }
}
