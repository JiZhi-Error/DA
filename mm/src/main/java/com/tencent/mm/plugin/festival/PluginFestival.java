package com.tencent.mm.plugin.festival;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.festival.a.b;
import com.tencent.mm.plugin.festival.model.aa;
import com.tencent.mm.plugin.festival.model.ac;
import com.tencent.mm.plugin.festival.model.ad;
import com.tencent.mm.plugin.festival.model.af;
import com.tencent.mm.plugin.festival.model.e;
import com.tencent.mm.plugin.festival.model.h;
import com.tencent.mm.plugin.festival.model.j;
import com.tencent.mm.plugin.festival.model.k;
import com.tencent.mm.plugin.festival.model.l;
import com.tencent.mm.plugin.festival.model.s;
import com.tencent.mm.plugin.festival.model.w;
import com.tencent.mm.plugin.festival.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class PluginFestival extends f implements c, b, af {
    private volatile r.a RbW;
    private volatile ad RbX;
    private volatile y RbY;
    private volatile s Rcc;
    private volatile a UpW;
    private String UpX;

    public final String getMyLiveEncUsername() {
        AppMethodBeat.i(261951);
        if (TextUtils.isEmpty(this.UpX)) {
            try {
                String aTY = z.aTY();
                if (!TextUtils.isEmpty(aTY)) {
                    this.UpX = aa.fA(aTY, aa.hRD());
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.PluginFestival", "getMyLiveEncUsername e=%s", e2);
            }
        }
        String str = this.UpX;
        AppMethodBeat.o(261951);
        return str;
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void installed() {
        AppMethodBeat.i(261952);
        alias(b.class);
        AppMethodBeat.o(261952);
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void configure(g gVar) {
        AppMethodBeat.i(261953);
        if (gVar.aBb()) {
            l lVar = l.Uyp;
            com.tencent.mm.vfs.s.boN(l.gWT());
            com.tencent.mm.vfs.y.a("festival_canvas_data", "festival_canvas_data", 52428800, 1209600000, 4);
        }
        AppMethodBeat.o(261953);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        AppMethodBeat.i(261954);
        if (gVar.aBb()) {
            Log.i("MicroMsg.PluginFestival", "execute");
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.festival.a.a.class, new e());
        }
        AppMethodBeat.o(261954);
    }

    private r.a createFestivalSharedDB() {
        AppMethodBeat.i(261955);
        r.a a2 = r.a(hashCode(), com.tencent.mm.kernel.g.aAh().cachePath + "Festival2021.db", collectDatabaseFactory(), true);
        AppMethodBeat.o(261955);
        return a2;
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(261956);
        Log.i("MicroMsg.PluginFestival", "onAccountInitialized");
        this.RbW = createFestivalSharedDB();
        initializeStorages();
        ((com.tencent.mm.plugin.festival.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.festival.a.a.class)).init();
        this.UpW = w.hRA();
        h hVar = h.Uye;
        h.create();
        getMyLiveEncUsername();
        AppMethodBeat.o(261956);
    }

    private void initializeStorages() {
        AppMethodBeat.i(261957);
        this.RbX = new ad(this.RbW);
        this.RbY = new y(this.RbW);
        this.Rcc = new s(this.RbW);
        AppMethodBeat.o(261957);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(261958);
        Log.i("MicroMsg.PluginFestival", "onAccountRelease");
        this.RbX = null;
        this.RbY = null;
        this.RbW.uS(hashCode());
        h hVar = h.Uye;
        h.destroy();
        this.UpW = null;
        AppMethodBeat.o(261958);
    }

    @Override // com.tencent.mm.plugin.festival.model.af
    public final void debugClearCacheData() {
        AppMethodBeat.i(261959);
        String path = this.RbW.getPath();
        this.RbW.uS(hashCode());
        com.tencent.mm.vfs.s.deleteFile(path);
        this.RbW = createFestivalSharedDB();
        initializeStorages();
        AppMethodBeat.o(261959);
    }

    private HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(261960);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("FestivalWish2".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.festival.PluginFestival.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return ad.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf(j.TABLE_NAME.hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.festival.PluginFestival.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return k.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf(y.TABLE_NAME.hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.festival.PluginFestival.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return y.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf(ac.TABLE_NAME.hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.festival.PluginFestival.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return s.SQL_CREATE;
            }
        });
        AppMethodBeat.o(261960);
        return hashMap;
    }

    public final ad getFestivalWishStorage() {
        return this.RbX;
    }

    public final y getTopicStorage() {
        return this.RbY;
    }

    public final s getMusicStorage() {
        return this.Rcc;
    }

    public final a getStrangerAvatarImageLoader() {
        return this.UpW;
    }
}
