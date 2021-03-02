package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.t;
import com.tencent.mm.co.a;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.kernel.api.d;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bu;
import com.tencent.mm.network.g;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    private static av hql = null;
    public final a hqh;
    public final t hqi;
    private HashSet<p> hqj = new HashSet<>();
    public p hqk = new p.a() {
        /* class com.tencent.mm.kernel.b.AnonymousClass2 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(132047);
            try {
                HashSet hashSet = new HashSet();
                synchronized (b.this.hqj) {
                    try {
                        hashSet.addAll(b.this.hqj);
                    } catch (Throwable th) {
                        AppMethodBeat.o(132047);
                        throw th;
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((p) it.next()).onNetworkChange(i2);
                }
                AppMethodBeat.o(132047);
            } catch (Exception e2) {
                Log.printErrStackTrace("MMKernel.CoreNetwork", e2, "onNetworkChange caught crash", new Object[0]);
                AppMethodBeat.o(132047);
            }
        }
    };

    public static class a extends com.tencent.mm.co.a<d> implements d {
        a() {
        }

        @Override // com.tencent.mm.kernel.api.d
        public final void b(final g gVar) {
            AppMethodBeat.i(132056);
            a(new a.AbstractC0297a<d>() {
                /* class com.tencent.mm.kernel.b.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(d dVar) {
                    AppMethodBeat.i(132055);
                    dVar.b(gVar);
                    AppMethodBeat.o(132055);
                }
            });
            AppMethodBeat.o(132056);
        }
    }

    public b(t.a aVar, a aVar2) {
        AppMethodBeat.i(132057);
        this.hqi = t.a(aVar);
        this.hqi.iMx = g.aAk();
        aa.iNn = new aa.b() {
            /* class com.tencent.mm.kernel.b.AnonymousClass1 */

            @Override // com.tencent.mm.ak.aa.b
            public final t azA() {
                AppMethodBeat.i(132046);
                t tVar = b.this.hqi;
                AppMethodBeat.o(132046);
                return tVar;
            }
        };
        this.hqh = aVar2;
        AppMethodBeat.o(132057);
    }

    public final void a(p pVar) {
        AppMethodBeat.i(132058);
        synchronized (this.hqj) {
            try {
                this.hqj.add(pVar);
            } finally {
                AppMethodBeat.o(132058);
            }
        }
    }

    public final void b(p pVar) {
        AppMethodBeat.i(132059);
        synchronized (this.hqj) {
            try {
                this.hqj.remove(pVar);
            } finally {
                AppMethodBeat.o(132059);
            }
        }
    }

    public static av azx() {
        return hql;
    }

    public static void a(av avVar) {
        hql = avVar;
    }

    public final t azz() {
        return this.hqi;
    }

    public static void a(int i2, int i3, boolean z, String str) {
        AppMethodBeat.i(132062);
        nk nkVar = new nk();
        nkVar.dTy.status = i2;
        nkVar.dTy.dTz = i3;
        nkVar.dTy.dTA = z;
        nkVar.dTy.dTB = str;
        EventCenter.instance.publish(nkVar);
        AppMethodBeat.o(132062);
    }

    public final void azy() {
        AppMethodBeat.i(132060);
        this.hqi.a(new bu(new bu.a() {
            /* class com.tencent.mm.kernel.b.AnonymousClass3 */

            @Override // com.tencent.mm.model.bu.a
            public final void a(g gVar) {
                AppMethodBeat.i(132048);
                if (gVar == null || gVar.aZh() == null) {
                    AppMethodBeat.o(132048);
                    return;
                }
                gVar.aZh().reset();
                AppMethodBeat.o(132048);
            }
        }, "reset accinfo"), 0);
        AppMethodBeat.o(132060);
    }

    public final byte[] qe(int i2) {
        AppMethodBeat.i(132061);
        try {
            if (this.hqi == null || this.hqi.iMw == null || this.hqi.iMw.aZh() == null) {
                AppMethodBeat.o(132061);
                return null;
            }
            byte[] qe = this.hqi.iMw.aZh().qe(i2);
            AppMethodBeat.o(132061);
            return qe;
        } catch (Exception e2) {
            Log.w("MMKernel.CoreNetwork", "get session key error, %s", e2.getMessage());
            Log.e("MMKernel.CoreNetwork", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132061);
            return null;
        }
    }
}
