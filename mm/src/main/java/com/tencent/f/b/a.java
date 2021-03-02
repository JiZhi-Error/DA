package com.tencent.f.b;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.f.d;
import com.tencent.f.h;
import com.tencent.f.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

public final class a implements c {
    private com.tencent.f.a RSy;
    AtomicLong RTo = new AtomicLong(0);
    private final d RTp;
    volatile long RTq = 0;
    private ConcurrentHashMap<String, C0135a> cache = null;

    public a(Context context, com.tencent.f.a aVar) {
        AppMethodBeat.i(183202);
        this.RTp = aVar.RSv == null ? new b(context) : aVar.RSv;
        this.RSy = aVar;
        hmj();
        AppMethodBeat.o(183202);
    }

    @Override // com.tencent.f.f.a
    public final void d(k kVar) {
        AppMethodBeat.i(183203);
        k.hmA().b(kVar.hmB());
        AppMethodBeat.o(183203);
    }

    @Override // com.tencent.f.f.a
    public final void b(k kVar) {
        AppMethodBeat.i(183204);
        k.hmA().a(kVar.hmB());
        AppMethodBeat.o(183204);
    }

    @Override // com.tencent.f.f.a
    public final void a(k kVar, long j2, long j3) {
        AppMethodBeat.i(256667);
        k.hmA().a(kVar.hmB());
        long[] hmC = kVar.hmC();
        b bVar = new b(kVar.getKey(), hmC[0], hmC[1], kVar.RUL.getName());
        C0135a aVar = hmi().get(bVar.name);
        if (aVar == null) {
            aVar = new C0135a(bVar.name);
            hmi().put(bVar.name, aVar);
        }
        aVar.RTz.add(bVar);
        aVar.RTv += (float) bVar.AVw;
        aVar.RTw += (float) bVar.time;
        int size = aVar.RTz.size();
        boolean z = true;
        if (aVar.RTx > bVar.rate) {
            z = size <= 5000;
            if (!z) {
                aVar.RTs += aVar.RTx;
            }
            aVar.RTx = bVar.rate;
        }
        if (aVar.RTy < bVar.rate) {
            z = size <= 5000;
            if (!z) {
                aVar.RTs += aVar.RTy;
            }
            aVar.RTy = bVar.rate;
        }
        if (z) {
            aVar.RTs = bVar.rate + aVar.RTs;
        }
        aVar.RTt = aVar.RTs / ((float) (size - (size <= 5000 ? 0 : 2)));
        aVar.RTu = (long) ((1.0f * aVar.RTv) / ((float) size));
        aVar.dwv = (long) ((1.0f * aVar.RTw) / ((float) size));
        if (this.RTo.incrementAndGet() >= 5000 && System.currentTimeMillis() - this.RTq >= 600000) {
            h.RTc.aY(new com.tencent.f.i.h() {
                /* class com.tencent.f.b.a.AnonymousClass1 */

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public final String getKey() {
                    return "Experience#persistCache";
                }

                public final void run() {
                    AppMethodBeat.i(183194);
                    a.this.a(a.this.hmi());
                    a.this.RTo.set(0);
                    a.this.RTq = System.currentTimeMillis();
                    AppMethodBeat.o(183194);
                }
            });
        }
        AppMethodBeat.o(256667);
    }

    @Override // com.tencent.f.f.a
    public final void a(k kVar) {
        AppMethodBeat.i(183206);
        k.hmA().d(kVar.hmB());
        AppMethodBeat.o(183206);
    }

    @Override // com.tencent.f.f.a
    public final void c(k kVar) {
        AppMethodBeat.i(183207);
        k.hmA().a(kVar.hmB());
        AppMethodBeat.o(183207);
    }

    @Override // com.tencent.f.f.a
    public final void e(k kVar) {
        AppMethodBeat.i(183208);
        k.hmA().a(kVar.hmB());
        AppMethodBeat.o(183208);
    }

    @Override // com.tencent.f.i.a
    public final boolean ez(String str) {
        AppMethodBeat.i(183209);
        if (str == null) {
            AppMethodBeat.o(183209);
            return true;
        }
        C0135a aVar = hmi().get(str);
        if (aVar == null) {
            AppMethodBeat.o(183209);
            return true;
        } else if (!aVar.hmk()) {
            AppMethodBeat.o(183209);
            return true;
        } else {
            AppMethodBeat.o(183209);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final ConcurrentHashMap<String, C0135a> hmi() {
        AppMethodBeat.i(183210);
        if (this.cache == null) {
            synchronized (this) {
                try {
                    if (this.cache == null) {
                        this.cache = new ConcurrentHashMap<>();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(183210);
                    throw th;
                }
            }
        }
        ConcurrentHashMap<String, C0135a> concurrentHashMap = this.cache;
        AppMethodBeat.o(183210);
        return concurrentHashMap;
    }

    private void hmj() {
        AppMethodBeat.i(183211);
        long uptimeMillis = SystemClock.uptimeMillis();
        this.RTp.delete(this.RSy.zrg);
        StringBuilder sb = new StringBuilder("[buildCache] successfully! \n");
        StringBuilder sb2 = new StringBuilder();
        int i2 = 0;
        for (Map.Entry<String, C0135a> entry : this.RTp.hml().entrySet()) {
            String key = entry.getKey();
            C0135a value = entry.getValue();
            sb2.append("# ").append(key).append('-').append(value.hmk()).append('\n');
            hmi().put(key, value);
            i2++;
        }
        sb.append("# size:").append(i2).append(" cost:").append(SystemClock.uptimeMillis() - uptimeMillis).append("ms\n");
        sb.append((CharSequence) sb2);
        d.RSS.i("Experience", sb.toString(), new Object[0]);
        AppMethodBeat.o(183211);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(ConcurrentHashMap<String, C0135a> concurrentHashMap) {
        AppMethodBeat.i(183212);
        if (concurrentHashMap.size() <= 0) {
            AppMethodBeat.o(183212);
        } else {
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                this.RTp.q(concurrentHashMap.values());
                d.RSS.i("Experience", "[persistCache] successfully! size=" + concurrentHashMap.size() + " cost:" + (SystemClock.uptimeMillis() - uptimeMillis), new Object[0]);
                concurrentHashMap.clear();
                AppMethodBeat.o(183212);
            } catch (Exception e2) {
                d.RSS.e("Experience", "%s", e2.toString());
                AppMethodBeat.o(183212);
            }
        }
    }

    @Override // com.tencent.f.b.c
    public final void onShutdown() {
        AppMethodBeat.i(183213);
        a(hmi());
        AppMethodBeat.o(183213);
    }

    /* renamed from: com.tencent.f.b.a$a  reason: collision with other inner class name */
    public static class C0135a {
        float RTs = 0.0f;
        float RTt = 0.0f;
        long RTu = 0;
        float RTv = 0.0f;
        float RTw = 0.0f;
        float RTx = 1.0f;
        float RTy = 0.0f;
        ConcurrentLinkedQueue<b> RTz = new ConcurrentLinkedQueue<>();
        long dwv = 0;
        String name;

        public C0135a(String str) {
            AppMethodBeat.i(183195);
            this.name = str;
            AppMethodBeat.o(183195);
        }

        public C0135a(String str, float f2, long j2) {
            AppMethodBeat.i(183196);
            this.name = str;
            this.RTt = f2;
            this.RTu = j2;
            AppMethodBeat.o(183196);
        }

        /* access modifiers changed from: package-private */
        public final boolean hmk() {
            return this.RTu >= 5000 || this.RTt >= 0.5f;
        }

        public final String toString() {
            AppMethodBeat.i(183197);
            StringBuilder sb = new StringBuilder();
            sb.append(this.name).append(" ");
            sb.append(this.RTt).append(" ");
            sb.append(hmk()).append(" ");
            sb.append(this.RTz.size());
            String sb2 = sb.toString();
            AppMethodBeat.o(183197);
            return sb2;
        }
    }

    public static class b {
        long AVw;
        String RTA;
        public String name;
        float rate;
        long time;
        long timestamp;

        public b(String str, long j2, long j3, String str2) {
            float f2 = 1.0f;
            AppMethodBeat.i(183198);
            this.name = str;
            this.AVw = j2;
            this.time = j3;
            this.RTA = str2;
            this.rate = j3 > 1 ? (1.0f * ((float) j2)) / ((float) j3) : f2;
            this.timestamp = System.currentTimeMillis();
            AppMethodBeat.o(183198);
        }

        public final int hashCode() {
            AppMethodBeat.i(183199);
            int hashCode = this.name.hashCode();
            AppMethodBeat.o(183199);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(183200);
            boolean equals = this.name.equals(obj);
            AppMethodBeat.o(183200);
            return equals;
        }

        public final String toString() {
            AppMethodBeat.i(183201);
            String str = this.name + " " + this.AVw + " " + this.time;
            AppMethodBeat.o(183201);
            return str;
        }
    }
}
