package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;

public final class d {
    private static d sZZ = null;
    private long endTime = -1;
    MMHandler mHandler = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.fav.a.d.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(103364);
            Iterator<a> it = d.this.sZY.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onFinish();
                }
            }
            d.this.sZY.clear();
            AppMethodBeat.o(103364);
        }
    };
    private boolean mwr = false;
    public ArrayList<a> sZY = new ArrayList<>();
    private long startTime = -1;
    private Object taa = new Object();
    private Runnable tab = new Runnable() {
        /* class com.tencent.mm.plugin.fav.a.d.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(103363);
            ((af) g.ah(af.class)).getFavItemInfoStorage().cUY();
            d.this.endTime = System.currentTimeMillis();
            Log.d("MicroMsg.FavCleanFirstLoader", "calDataBaseDataTotalLength, used: %dms", Long.valueOf(d.this.endTime - d.this.startTime));
            d.this.endTime = -1;
            d.this.startTime = -1;
            synchronized (d.this.taa) {
                try {
                    g.aAh().azQ().set(ar.a.USERFINO_FAV_HAS_DB_DATATOTALLENGTH_BOOLEAN, Boolean.TRUE);
                    d.this.mwr = false;
                } catch (Throwable th) {
                    AppMethodBeat.o(103363);
                    throw th;
                }
            }
            d.this.mHandler.sendEmptyMessage(0);
            AppMethodBeat.o(103363);
        }
    };

    public interface a {
        void onFinish();
    }

    private d() {
        AppMethodBeat.i(103365);
        AppMethodBeat.o(103365);
    }

    public static synchronized d cUs() {
        d dVar;
        synchronized (d.class) {
            AppMethodBeat.i(103366);
            if (sZZ == null) {
                sZZ = new d();
            }
            dVar = sZZ;
            AppMethodBeat.o(103366);
        }
        return dVar;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(103367);
        synchronized (this.taa) {
            try {
                if (((Boolean) g.aAh().azQ().get(ar.a.USERFINO_FAV_HAS_DB_DATATOTALLENGTH_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    if (aVar != null) {
                        aVar.onFinish();
                    }
                    return;
                }
                if (aVar != null) {
                    this.sZY.add(aVar);
                }
                if (this.mwr) {
                    Log.i("MicroMsg.FavCleanFirstLoader", "isLoading is true, ignore");
                    AppMethodBeat.o(103367);
                    return;
                }
                this.mwr = true;
                this.startTime = System.currentTimeMillis();
                ThreadPool.post(this.tab, "FavCleanFirstLoader_CalFavDataLength");
                AppMethodBeat.o(103367);
            } finally {
                AppMethodBeat.o(103367);
            }
        }
    }
}
