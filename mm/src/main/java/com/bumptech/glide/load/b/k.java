package com.bumptech.glide.load.b;

import android.support.v4.e.l;
import android.util.Log;
import com.bumptech.glide.e;
import com.bumptech.glide.g.a.a;
import com.bumptech.glide.g.f;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.b.b.h;
import com.bumptech.glide.load.b.h;
import com.bumptech.glide.load.b.p;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.Executor;

public final class k implements h.a, m, p.a {
    private static final boolean aHe = Log.isLoggable("Engine", 2);
    private final s aHf;
    private final o aHg;
    private final h aHh;
    private final b aHi;
    private final y aHj;
    private final c aHk;
    private final a aHl;
    private final a aHm;

    static {
        AppMethodBeat.i(76990);
        AppMethodBeat.o(76990);
    }

    public k(h hVar, a.AbstractC0068a aVar, com.bumptech.glide.load.b.c.a aVar2, com.bumptech.glide.load.b.c.a aVar3, com.bumptech.glide.load.b.c.a aVar4, com.bumptech.glide.load.b.c.a aVar5, boolean z) {
        this(hVar, aVar, aVar2, aVar3, aVar4, aVar5, z, (byte) 0);
    }

    private k(h hVar, a.AbstractC0068a aVar, com.bumptech.glide.load.b.c.a aVar2, com.bumptech.glide.load.b.c.a aVar3, com.bumptech.glide.load.b.c.a aVar4, com.bumptech.glide.load.b.c.a aVar5, boolean z, byte b2) {
        AppMethodBeat.i(76982);
        this.aHh = hVar;
        this.aHk = new c(aVar);
        a aVar6 = new a(z);
        this.aHm = aVar6;
        synchronized (this) {
            try {
                synchronized (aVar6) {
                    try {
                        aVar6.aFB = this;
                    } catch (Throwable th) {
                        AppMethodBeat.o(76982);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(76982);
                throw th2;
            }
        }
        this.aHg = new o();
        this.aHf = new s();
        this.aHi = new b(aVar2, aVar3, aVar4, aVar5, this);
        this.aHl = new a(this.aHk);
        this.aHj = new y();
        hVar.a(this);
        AppMethodBeat.o(76982);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r21v0, resolved type: java.lang.Class<R> */
    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized <R> d a(e eVar, Object obj, g gVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.g gVar2, j jVar, Map<Class<?>, l<?>> map, boolean z, boolean z2, i iVar, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.e.g gVar3, Executor executor) {
        long j2;
        p<?> b2;
        p<?> pVar;
        d dVar;
        AppMethodBeat.i(204459);
        if (aHe) {
            j2 = f.qt();
        } else {
            j2 = 0;
        }
        n nVar = new n(obj, gVar, i2, i3, map, cls, cls2, iVar);
        if (!z3) {
            b2 = null;
        } else {
            b2 = this.aHm.b(nVar);
            if (b2 != null) {
                b2.acquire();
            }
        }
        if (b2 != null) {
            gVar3.c(b2, com.bumptech.glide.load.a.MEMORY_CACHE);
            if (aHe) {
                a("Loaded resource from active resources", j2, nVar);
            }
            dVar = null;
            AppMethodBeat.o(204459);
        } else {
            if (!z3) {
                pVar = null;
            } else {
                v<?> d2 = this.aHh.d(nVar);
                if (d2 == null) {
                    pVar = null;
                } else if (d2 instanceof p) {
                    pVar = (p) d2;
                } else {
                    pVar = new p<>(d2, true, true);
                }
                if (pVar != null) {
                    pVar.acquire();
                    this.aHm.a(nVar, pVar);
                }
            }
            if (pVar != null) {
                gVar3.c(pVar, com.bumptech.glide.load.a.MEMORY_CACHE);
                if (aHe) {
                    a("Loaded resource from cache", j2, nVar);
                }
                dVar = null;
                AppMethodBeat.o(204459);
            } else {
                l<?> lVar = this.aHf.aG(z6).get(nVar);
                if (lVar != null) {
                    lVar.a(gVar3, executor);
                    if (aHe) {
                        a("Added to existing load", j2, nVar);
                    }
                    dVar = new d(gVar3, lVar);
                    AppMethodBeat.o(204459);
                } else {
                    l<?> a2 = ((l) j.checkNotNull(this.aHi.aGj.acquire(), "Argument must not be null")).a(nVar, z3, z4, z5, z6);
                    a aVar = this.aHl;
                    h<?> hVar = (h) j.checkNotNull(aVar.aGj.acquire(), "Argument must not be null");
                    int i4 = aVar.aHn;
                    aVar.aHn = i4 + 1;
                    g<R> gVar4 = hVar.aGg;
                    h.d dVar2 = hVar.aFY;
                    gVar4.aCm = eVar;
                    gVar4.aDf = obj;
                    gVar4.aFT = gVar;
                    gVar4.width = i2;
                    gVar4.height = i3;
                    gVar4.aGd = jVar;
                    gVar4.aFX = cls;
                    gVar4.aFY = dVar2;
                    gVar4.aDd = cls2;
                    gVar4.aGc = gVar2;
                    gVar4.aFV = iVar;
                    gVar4.aFZ = map;
                    gVar4.aGe = z;
                    gVar4.aGf = z2;
                    hVar.aCm = eVar;
                    hVar.aFT = gVar;
                    hVar.aGc = gVar2;
                    hVar.aGm = nVar;
                    hVar.width = i2;
                    hVar.height = i3;
                    hVar.aGd = jVar;
                    hVar.aGr = z6;
                    hVar.aFV = iVar;
                    hVar.aGn = a2;
                    hVar.order = i4;
                    hVar.aGp = h.f.INITIALIZE;
                    hVar.aDf = obj;
                    this.aHf.aG(a2.aGr).put(nVar, a2);
                    a2.a(gVar3, executor);
                    a2.b(hVar);
                    if (aHe) {
                        a("Started new load", j2, nVar);
                    }
                    dVar = new d(gVar3, a2);
                    AppMethodBeat.o(204459);
                }
            }
        }
        return dVar;
    }

    private static void a(String str, long j2, g gVar) {
        AppMethodBeat.i(76984);
        new StringBuilder().append(str).append(" in ").append(f.p(j2)).append("ms, key: ").append(gVar);
        AppMethodBeat.o(76984);
    }

    public static void b(v<?> vVar) {
        AppMethodBeat.i(76985);
        if (vVar instanceof p) {
            ((p) vVar).release();
            AppMethodBeat.o(76985);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot release anything but an EngineResource");
        AppMethodBeat.o(76985);
        throw illegalArgumentException;
    }

    @Override // com.bumptech.glide.load.b.m
    public final synchronized void a(l<?> lVar, g gVar, p<?> pVar) {
        AppMethodBeat.i(76986);
        if (pVar != null) {
            pVar.a(gVar, this);
            if (pVar.aFI) {
                this.aHm.a(gVar, pVar);
            }
        }
        this.aHf.a(gVar, lVar);
        AppMethodBeat.o(76986);
    }

    @Override // com.bumptech.glide.load.b.m
    public final synchronized void a(l<?> lVar, g gVar) {
        AppMethodBeat.i(76987);
        this.aHf.a(gVar, lVar);
        AppMethodBeat.o(76987);
    }

    @Override // com.bumptech.glide.load.b.b.h.a
    public final void c(v<?> vVar) {
        AppMethodBeat.i(76988);
        this.aHj.e(vVar);
        AppMethodBeat.o(76988);
    }

    @Override // com.bumptech.glide.load.b.p.a
    public final synchronized void b(g gVar, p<?> pVar) {
        AppMethodBeat.i(76989);
        this.aHm.a(gVar);
        if (pVar.aFI) {
            this.aHh.a(gVar, pVar);
            AppMethodBeat.o(76989);
        } else {
            this.aHj.e(pVar);
            AppMethodBeat.o(76989);
        }
    }

    public class d {
        public final l<?> aHu;
        public final com.bumptech.glide.e.g aHv;

        d(com.bumptech.glide.e.g gVar, l<?> lVar) {
            this.aHv = gVar;
            this.aHu = lVar;
        }
    }

    static class c implements h.d {
        private final a.AbstractC0068a aHs;
        private volatile com.bumptech.glide.load.b.b.a aHt;

        c(a.AbstractC0068a aVar) {
            this.aHs = aVar;
        }

        @Override // com.bumptech.glide.load.b.h.d
        public final com.bumptech.glide.load.b.b.a oz() {
            AppMethodBeat.i(76981);
            if (this.aHt == null) {
                synchronized (this) {
                    try {
                        if (this.aHt == null) {
                            this.aHt = this.aHs.pf();
                        }
                        if (this.aHt == null) {
                            this.aHt = new com.bumptech.glide.load.b.b.b();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(76981);
                        throw th;
                    }
                }
            }
            com.bumptech.glide.load.b.b.a aVar = this.aHt;
            AppMethodBeat.o(76981);
            return aVar;
        }
    }

    static class a {
        final h.d aFY;
        final l.a<h<?>> aGj = com.bumptech.glide.g.a.a.a(150, new a.AbstractC0066a<h<?>>() {
            /* class com.bumptech.glide.load.b.k.a.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.bumptech.glide.g.a.a.AbstractC0066a
            public final /* synthetic */ h<?> oR() {
                AppMethodBeat.i(76977);
                h hVar = new h(a.this.aFY, a.this.aGj);
                AppMethodBeat.o(76977);
                return hVar;
            }
        });
        int aHn;

        a(h.d dVar) {
            AppMethodBeat.i(76978);
            this.aFY = dVar;
            AppMethodBeat.o(76978);
        }
    }

    static class b {
        final com.bumptech.glide.load.b.c.a aCB;
        final com.bumptech.glide.load.b.c.a aCu;
        final com.bumptech.glide.load.b.c.a aCv;
        final l.a<l<?>> aGj = com.bumptech.glide.g.a.a.a(150, new a.AbstractC0066a<l<?>>() {
            /* class com.bumptech.glide.load.b.k.b.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.bumptech.glide.g.a.a.AbstractC0066a
            public final /* synthetic */ l<?> oR() {
                AppMethodBeat.i(76979);
                l lVar = new l(b.this.aCv, b.this.aCu, b.this.aHp, b.this.aCB, b.this.aHq, b.this.aGj);
                AppMethodBeat.o(76979);
                return lVar;
            }
        });
        final com.bumptech.glide.load.b.c.a aHp;
        final m aHq;

        b(com.bumptech.glide.load.b.c.a aVar, com.bumptech.glide.load.b.c.a aVar2, com.bumptech.glide.load.b.c.a aVar3, com.bumptech.glide.load.b.c.a aVar4, m mVar) {
            AppMethodBeat.i(76980);
            this.aCv = aVar;
            this.aCu = aVar2;
            this.aHp = aVar3;
            this.aCB = aVar4;
            this.aHq = mVar;
            AppMethodBeat.o(76980);
        }
    }
}
