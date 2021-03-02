package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class h<_Profile extends g> {
    private static h hrx;
    byte[] hrA = new byte[0];
    public volatile boolean hrB = false;
    public long hrC;
    a hrD = new a();
    private c hry = new c();
    private d<_Profile> hrz;

    /* access modifiers changed from: package-private */
    public static class a extends com.tencent.mm.co.a<com.tencent.mm.kernel.api.g> implements com.tencent.mm.kernel.api.g {
        public a() {
            super(d.UI);
        }

        @Override // com.tencent.mm.kernel.api.g
        public final void WY() {
            AppMethodBeat.i(158309);
            a(new a.AbstractC0297a<com.tencent.mm.kernel.api.g>() {
                /* class com.tencent.mm.kernel.h.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(com.tencent.mm.kernel.api.g gVar) {
                    AppMethodBeat.i(158307);
                    gVar.WY();
                    AppMethodBeat.o(158307);
                }
            });
            AppMethodBeat.o(158309);
        }

        @Override // com.tencent.mm.kernel.api.g
        public final void cQ(final boolean z) {
            AppMethodBeat.i(158310);
            a(new a.AbstractC0297a<com.tencent.mm.kernel.api.g>() {
                /* class com.tencent.mm.kernel.h.a.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(com.tencent.mm.kernel.api.g gVar) {
                    AppMethodBeat.i(158308);
                    gVar.cQ(z);
                    AppMethodBeat.o(158308);
                }
            });
            AppMethodBeat.o(158310);
        }
    }

    private h(_Profile _profile) {
        AppMethodBeat.i(158311);
        this.hrz = new d<>(_profile);
        AppMethodBeat.o(158311);
    }

    public final c aAd() {
        AppMethodBeat.i(158312);
        Assert.assertNotNull("mCorePlugins not initialized!", this.hry);
        c cVar = this.hry;
        AppMethodBeat.o(158312);
        return cVar;
    }

    public final d<_Profile> aAe() {
        AppMethodBeat.i(158313);
        Assert.assertNotNull("mCoreProcess not initialized!", this.hrz);
        d<_Profile> dVar = this.hrz;
        AppMethodBeat.o(158313);
        return dVar;
    }

    public static <_Profile extends g> h<_Profile> aAl() {
        AppMethodBeat.i(158314);
        Assert.assertNotNull("Skeleton not initialized!", hrx);
        h<_Profile> hVar = hrx;
        AppMethodBeat.o(158314);
        return hVar;
    }

    public final void a(com.tencent.mm.kernel.api.g gVar) {
        AppMethodBeat.i(158315);
        boolean z = false;
        synchronized (this.hrA) {
            try {
                if (this.hrB) {
                    z = true;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(158315);
                throw th;
            }
        }
        if (z) {
            gVar.WY();
            AppMethodBeat.o(158315);
            return;
        }
        this.hrD.add(gVar);
        AppMethodBeat.o(158315);
    }

    public final void b(com.tencent.mm.kernel.api.g gVar) {
        AppMethodBeat.i(158316);
        this.hrD.remove(gVar);
        AppMethodBeat.o(158316);
    }

    public static synchronized <_Profile extends g> h<_Profile> c(_Profile _profile) {
        h<_Profile> hVar;
        synchronized (h.class) {
            AppMethodBeat.i(158317);
            if (hrx != null) {
                j.i("MicroMsg.MMSkeleton", "Kernel not null, has initialized.", new Object[0]);
                hVar = hrx;
                AppMethodBeat.o(158317);
            } else {
                j.i("MicroMsg.MMSkeleton", "Initialize skeleton, create whole world.", new Object[0]);
                hVar = new h<>(_profile);
                hrx = hVar;
                AppMethodBeat.o(158317);
            }
        }
        return hVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x007b, code lost:
        if (r10 == null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x007d, code lost:
        r4.b(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0080, code lost:
        r0.htp.htv = java.lang.System.currentTimeMillis();
        r4.c(new com.tencent.mm.kernel.h.AnonymousClass1(r9));
        r0.htp.htw = java.lang.System.currentTimeMillis();
        r4.c(new com.tencent.mm.kernel.h.AnonymousClass2(r9));
        r0.htp.htx = java.lang.System.currentTimeMillis();
        r4.a(com.tencent.mm.vending.h.d.UI, new com.tencent.mm.kernel.h.AnonymousClass3(r9));
        com.tencent.matrix.trace.core.AppMethodBeat.o(158318);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        r0 = aAe().azG();
        r2 = java.lang.System.currentTimeMillis();
        com.tencent.mm.kernel.a.a.k("mmskeleton boot startup for process [%s]...", r0.mProcessName);
        r1 = r0.hqy;
        r1.aAr();
        r4 = com.tencent.mm.vending.g.g.hdG().Du(true);
        r0.htp.htr = java.lang.System.currentTimeMillis();
        r1.VZ();
        r0.htp.hts = java.lang.System.currentTimeMillis();
        r1.Wa();
        com.tencent.mm.kernel.j.FT("installPlugins");
        r0.htp.htt = java.lang.System.currentTimeMillis();
        r1.aAs();
        r0.htp.htu = java.lang.System.currentTimeMillis();
        r1.a(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.vending.h.d r10) {
        /*
        // Method dump skipped, instructions count: 189
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.h.a(com.tencent.mm.vending.h.d):void");
    }
}
