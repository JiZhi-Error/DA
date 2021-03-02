package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.c.a.c.a;
import com.tencent.tinker.c.a.c.c;

public final class j extends i<n> {
    private s.a Sif = null;
    private i.e Sig = null;

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.tinker.c.a.c.a, java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ n a(a aVar, n nVar) {
        n nVar2 = nVar;
        return new n(nVar2.off, aVar.ash(nVar2.Sgy), aVar.ash(nVar2.SfM), aVar.asg(nVar2.Sgz));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ int f(n nVar) {
        this.Sif.size++;
        return this.Sig.a(nVar);
    }

    public j(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.Sif = iVar2.Sgk.SgI;
            this.Sig = iVar2.a(this.Sif);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3, int i4, int i5) {
        if (i2 != i4) {
            cVar.Sja.put(i2, i4);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final s.a c(i iVar) {
        return iVar.Sgk.SgI;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3) {
        if (i2 >= 0) {
            cVar.Sjo.asd(i2);
        }
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ n a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.how();
    }
}
