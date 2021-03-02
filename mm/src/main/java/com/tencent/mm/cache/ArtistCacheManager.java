package com.tencent.mm.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ArtistCacheManager extends BroadcastReceiver {
    private static ArtistCacheManager gpq;
    public static HashMap<String, a> gpr = new HashMap<>();
    private static HashSet<com.tencent.mm.e.a> gps = new HashSet<>();
    public String gpt;

    static {
        AppMethodBeat.i(9186);
        AppMethodBeat.o(9186);
    }

    public static ArtistCacheManager alA() {
        AppMethodBeat.i(9181);
        if (gpq == null) {
            gpq = new ArtistCacheManager();
        }
        ArtistCacheManager artistCacheManager = gpq;
        AppMethodBeat.o(9181);
        return artistCacheManager;
    }

    public final void Dn(String str) {
        AppMethodBeat.i(204745);
        this.gpt = str;
        if (!gpr.containsKey(str)) {
            gpr.put(str, new a());
        }
        AppMethodBeat.o(204745);
    }

    public final void Do(String str) {
        AppMethodBeat.i(204746);
        this.gpt = null;
        if (gpr.containsKey(str)) {
            gpr.get(str).clearAll();
            gpr.remove(str);
        }
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.cache.ArtistCacheManager.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(9176);
                com.tencent.mm.cl.a.boE(b.aKS());
                AppMethodBeat.o(9176);
            }
        }, "MicroMsg.ArtistCacheManager[clearAllCache]");
        AppMethodBeat.o(204746);
    }

    public final <T extends f> T a(com.tencent.mm.e.a aVar) {
        AppMethodBeat.i(9182);
        if (gpr.containsKey(this.gpt)) {
            T t = (T) gpr.get(this.gpt).c(aVar);
            AppMethodBeat.o(9182);
            return t;
        }
        Log.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", this.gpt);
        AppMethodBeat.o(9182);
        return null;
    }

    public final boolean b(com.tencent.mm.e.a aVar) {
        AppMethodBeat.i(9183);
        if (!gpr.containsKey(this.gpt) || !gpr.get(this.gpt).gpw.containsKey(aVar)) {
            AppMethodBeat.o(9183);
            return false;
        }
        AppMethodBeat.o(9183);
        return true;
    }

    @Deprecated
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(9184);
        Log.i("MicroMsg.ArtistCacheManager", "[onReceive]");
        if (intent != null && intent.getAction().equals("com.tencent.mm.plugin.photoedit.action.clear")) {
            alB();
        }
        AppMethodBeat.o(9184);
    }

    public final void alB() {
        AppMethodBeat.i(9185);
        Log.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
        for (Map.Entry<String, a> entry : gpr.entrySet()) {
            entry.getValue().clearAll();
        }
        gps.clear();
        gpq = null;
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.cache.ArtistCacheManager.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(9177);
                com.tencent.mm.cl.a.boE(b.aKS());
                AppMethodBeat.o(9177);
            }
        }, "MicroMsg.ArtistCacheManager[clearAllCache]");
        c.alF().map.clear();
        AppMethodBeat.o(9185);
    }

    public class a {
        HashMap<com.tencent.mm.e.a, f> gpw = new HashMap<>();

        a() {
            AppMethodBeat.i(9179);
            AppMethodBeat.o(9179);
        }

        public final f c(com.tencent.mm.e.a aVar) {
            f d2;
            AppMethodBeat.i(204743);
            if (!this.gpw.containsKey(aVar) && (d2 = d(aVar)) != null && !this.gpw.containsKey(aVar)) {
                this.gpw.put(aVar, d2);
            }
            f fVar = this.gpw.get(aVar);
            AppMethodBeat.o(204743);
            return fVar;
        }

        private static f d(com.tencent.mm.e.a aVar) {
            AppMethodBeat.i(204744);
            f fVar = null;
            switch (aVar) {
                case DOODLE:
                    fVar = new b();
                    break;
                case EMOJI_AND_TEXT:
                    fVar = new d();
                    break;
                case MOSAIC:
                    fVar = new i();
                    break;
                case CROP_PHOTO:
                    fVar = new a();
                    break;
                case FILTER:
                    fVar = new e();
                    break;
            }
            if (fVar != null) {
                fVar.onCreate();
            }
            AppMethodBeat.o(204744);
            return fVar;
        }

        public final void clearAll() {
            AppMethodBeat.i(9180);
            for (Map.Entry<com.tencent.mm.e.a, f> entry : this.gpw.entrySet()) {
                entry.getValue().onDestroy();
            }
            AppMethodBeat.o(9180);
        }
    }
}
