package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class b {
    public static int FAILED = -1;
    public static int SUCCESS = 0;
    public f lqg;
    public final String mGo;
    public boolean mgB = false;
    public int nhP;
    public String nhQ = (com.tencent.mm.loader.j.b.aKM() + "appbrand/");
    public SSLContext nhR;
    protected final ArrayList<String> nhS = new ArrayList<>();
    public final Map<String, ConcurrentLinkedQueue<Runnable>> nhT;
    public final ArrayList<com.tencent.mm.plugin.appbrand.s.a.b> nhU = new ArrayList<>();

    public interface a {
        void J(JSONObject jSONObject);

        void a(int i2, String str, String str2, int i3, long j2, Map map);

        void ah(int i2, String str);

        void h(int i2, long j2, long j3);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.s.b$b  reason: collision with other inner class name */
    public interface AbstractC0793b {
        boolean btA();
    }

    static /* synthetic */ void a(b bVar, String str) {
        AppMethodBeat.i(144308);
        bVar.EN(str);
        AppMethodBeat.o(144308);
    }

    static /* synthetic */ void b(b bVar, String str) {
        AppMethodBeat.i(144309);
        bVar.acR(str);
        AppMethodBeat.o(144309);
    }

    public b(f fVar, boolean z) {
        AppMethodBeat.i(144302);
        this.lqg = fVar;
        a aVar = (a) fVar.av(a.class);
        this.nhP = aVar.cyM;
        this.mGo = aVar.nhM;
        this.nhR = j.a(aVar);
        this.nhT = new Hashtable(10);
        this.mgB = z;
        AppMethodBeat.o(144302);
    }

    public final void acR(final String str) {
        AppMethodBeat.i(144303);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.s.b.AnonymousClass2 */

            public final void run() {
                ConcurrentLinkedQueue concurrentLinkedQueue;
                Runnable runnable;
                AppMethodBeat.i(144301);
                synchronized (b.this.nhT) {
                    try {
                        concurrentLinkedQueue = (ConcurrentLinkedQueue) b.this.nhT.get(str);
                        Log.d("MicroMsg.AppBrandNetworkDownload", "hy: url %s queue size %d", str, Integer.valueOf(concurrentLinkedQueue.size()));
                        runnable = (Runnable) concurrentLinkedQueue.peek();
                    } finally {
                        AppMethodBeat.o(144301);
                    }
                }
                if (runnable != null) {
                    runnable.run();
                    concurrentLinkedQueue.poll();
                    if (concurrentLinkedQueue.size() > 0) {
                        Log.i("MicroMsg.AppBrandNetworkDownload", "hy: need execute more");
                        b.b(b.this, str);
                    }
                }
            }
        }, "appbrand_download_thread");
        AppMethodBeat.o(144303);
    }

    private void EN(String str) {
        AppMethodBeat.i(144304);
        if (str == null) {
            AppMethodBeat.o(144304);
            return;
        }
        synchronized (this.nhU) {
            try {
                Iterator<com.tencent.mm.plugin.appbrand.s.a.b> it = this.nhU.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.tencent.mm.plugin.appbrand.s.a.b next = it.next();
                    if (str.equals(next.jEY)) {
                        this.nhU.remove(next);
                        break;
                    }
                }
            } finally {
                AppMethodBeat.o(144304);
            }
        }
    }

    public final com.tencent.mm.plugin.appbrand.s.a.b acS(String str) {
        AppMethodBeat.i(144305);
        if (str == null) {
            AppMethodBeat.o(144305);
            return null;
        }
        synchronized (this.nhU) {
            try {
                Iterator<com.tencent.mm.plugin.appbrand.s.a.b> it = this.nhU.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.appbrand.s.a.b next = it.next();
                    if (str.equals(next.jEY)) {
                        return next;
                    }
                }
                AppMethodBeat.o(144305);
                return null;
            } finally {
                AppMethodBeat.o(144305);
            }
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.s.a.b bVar) {
        AppMethodBeat.i(144306);
        if (bVar == null) {
            AppMethodBeat.o(144306);
            return;
        }
        this.nhS.add(bVar.jEY);
        EN(bVar.jEY);
        bVar.bPN();
        AppMethodBeat.o(144306);
    }

    public final boolean acT(String str) {
        AppMethodBeat.i(144307);
        boolean contains = this.nhS.contains(str);
        AppMethodBeat.o(144307);
        return contains;
    }

    public final void release() {
        AppMethodBeat.i(259485);
        synchronized (this.nhU) {
            try {
                Iterator<com.tencent.mm.plugin.appbrand.s.a.b> it = this.nhU.iterator();
                while (it.hasNext()) {
                    it.next().isRunning = false;
                }
                this.nhU.clear();
            } finally {
                AppMethodBeat.o(259485);
            }
        }
    }
}
