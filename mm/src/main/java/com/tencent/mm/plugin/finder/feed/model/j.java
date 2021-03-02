package com.tencent.mm.plugin.finder.feed.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.bbn;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;

public final class j {
    private static final ConcurrentHashMap<Long, h> tVA = new ConcurrentHashMap<>();
    public static final a tYb = new a((byte) 0);
    public b lastBuffer;
    public h tXW;
    public h tXX;
    private h tXY;
    private long tXZ;
    final HashMap<String, h> tYa = new HashMap<>();
    public bbn ttO;

    public j() {
        AppMethodBeat.i(244946);
        AppMethodBeat.o(244946);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static h EG(long j2) {
            AppMethodBeat.i(244942);
            if (j.tVA.containsKey(Long.valueOf(j2))) {
                h hVar = (h) j.tVA.remove(Long.valueOf(j2));
                AppMethodBeat.o(244942);
                return hVar;
            }
            AppMethodBeat.o(244942);
            return null;
        }

        public static h al(Intent intent) {
            AppMethodBeat.i(244943);
            long longExtra = intent.getLongExtra("LoaderCacheStoreIntentKey", 0);
            if (longExtra == 0) {
                AppMethodBeat.o(244943);
                return null;
            }
            h EG = EG(longExtra);
            AppMethodBeat.o(244943);
            return EG;
        }
    }

    static {
        AppMethodBeat.i(244947);
        AppMethodBeat.o(244947);
    }

    public static /* synthetic */ void a(j jVar, Intent intent) {
        AppMethodBeat.i(244944);
        p.h(intent, "intent");
        jVar.tXW = a.al(intent);
        if (jVar.tXW != null) {
            AppMethodBeat.o(244944);
        } else {
            AppMethodBeat.o(244944);
        }
    }

    public final void a(h hVar, Intent intent) {
        AppMethodBeat.i(244945);
        p.h(hVar, "toCache");
        p.h(intent, "intent");
        this.tXY = hVar;
        if (this.tXZ != 0) {
            a.EG(this.tXZ);
        }
        long aWy = cl.aWy();
        tVA.put(Long.valueOf(aWy), hVar);
        intent.putExtra("LoaderCacheStoreIntentKey", aWy);
        this.tXZ = aWy;
        AppMethodBeat.o(244945);
    }
}
