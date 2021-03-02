package com.tencent.mm.plugin.performance.b;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class a implements Runnable {
    public static final a AUa = new a();
    private final Map<String, AbstractC1570a> AUb = new ConcurrentHashMap();
    private IListener<ps> AUc;

    /* renamed from: com.tencent.mm.plugin.performance.b.a$a  reason: collision with other inner class name */
    public interface AbstractC1570a {
        String Lb();

        void eCj();

        double eCk();

        long eCl();
    }

    static {
        AppMethodBeat.i(201100);
        AppMethodBeat.o(201100);
    }

    private a() {
        AppMethodBeat.i(201094);
        AppMethodBeat.o(201094);
    }

    public final synchronized void a(AbstractC1570a aVar) {
        AppMethodBeat.i(201095);
        b(aVar);
        d(aVar);
        AppMethodBeat.o(201095);
    }

    public final synchronized void b(AbstractC1570a aVar) {
        AppMethodBeat.i(201096);
        if (this.AUb.containsKey(aVar.Lb())) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(aVar.Lb() + " dice already exists");
            AppMethodBeat.o(201096);
            throw illegalArgumentException;
        }
        this.AUb.put(aVar.Lb(), aVar);
        c(aVar);
        if (this.AUc == null) {
            this.AUc = new IListener<ps>() {
                /* class com.tencent.mm.plugin.performance.b.a.AnonymousClass1 */

                {
                    AppMethodBeat.i(201088);
                    this.__eventId = ps.class.getName().hashCode();
                    AppMethodBeat.o(201088);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(ps psVar) {
                    AppMethodBeat.i(201089);
                    h.RTc.b(a.this, "MicroMsg.DiceCup");
                    a.this.AUc.dead();
                    AppMethodBeat.o(201089);
                    return false;
                }
            };
            this.AUc.alive();
        }
        AppMethodBeat.o(201096);
    }

    private static void c(AbstractC1570a aVar) {
        AppMethodBeat.i(201097);
        Log.i("MicroMsg.DiceCup", "dice [%s]", aVar.Lb());
        b.e(aVar);
        long eCn = b.eCn();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - eCn < TimeUnit.MINUTES.toMillis(aVar.eCl())) {
            Log.i("MicroMsg.DiceCup", "dice [%s] pass cycle", aVar.Lb());
            AppMethodBeat.o(201097);
            return;
        }
        b.HI(currentTimeMillis);
        if (Math.random() <= aVar.eCk() && aVar.eCk() >= 0.0d) {
            aVar.eCj();
        }
        AppMethodBeat.o(201097);
    }

    private synchronized void d(AbstractC1570a aVar) {
        AppMethodBeat.i(201098);
        this.AUb.remove(aVar.Lb());
        if (this.AUb.isEmpty() && this.AUc != null) {
            this.AUc.dead();
            this.AUc = null;
        }
        AppMethodBeat.o(201098);
    }

    public final synchronized void run() {
        AppMethodBeat.i(201099);
        for (Map.Entry<String, AbstractC1570a> entry : this.AUb.entrySet()) {
            c(entry.getValue());
        }
        AppMethodBeat.o(201099);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        private static String AUe;
        private static final b AUf = new b();
        private static final MultiProcessMMKV djK = MultiProcessMMKV.getMMKV("diagnostic_storage");

        private b() {
        }

        static {
            AppMethodBeat.i(201093);
            AppMethodBeat.o(201093);
        }

        public static b e(AbstractC1570a aVar) {
            AppMethodBeat.i(201090);
            AUe = MMApplicationContext.getProcessName() + "_" + aVar.Lb();
            b bVar = AUf;
            AppMethodBeat.o(201090);
            return bVar;
        }

        public static long eCn() {
            AppMethodBeat.i(201091);
            long decodeLong = djK.decodeLong(AUe, 0);
            AppMethodBeat.o(201091);
            return decodeLong;
        }

        public static void HI(long j2) {
            AppMethodBeat.i(201092);
            djK.encode(AUe, j2);
            AppMethodBeat.o(201092);
        }
    }
}
