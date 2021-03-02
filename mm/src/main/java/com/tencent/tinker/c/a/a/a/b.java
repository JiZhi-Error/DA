package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.c.a.c.a;

public final class b extends i<c> {
    private s.a ShR = null;
    private i.e ShS = null;

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.tinker.c.a.c.a, java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ c a(a aVar, c cVar) {
        c cVar2 = cVar;
        int length = cVar2.Sfz.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = aVar.asn(cVar2.Sfz[i2]);
        }
        return new c(cVar2.off, iArr);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ int f(c cVar) {
        this.ShR.size++;
        return this.ShS.b(cVar);
    }

    public b(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.c.a.c.c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.ShR = iVar2.Sgk.SgN;
            this.ShS = iVar2.a(this.ShR);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(com.tencent.tinker.c.a.c.c cVar, int i2, int i3, int i4, int i5) {
        if (i3 != i5) {
            cVar.Sjf.put(i3, i5);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final s.a c(i iVar) {
        return iVar.Sgk.SgN;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(com.tencent.tinker.c.a.c.c cVar, int i2, int i3) {
        if (i3 >= 0) {
            cVar.Sjt.asd(i3);
        }
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ c a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.hoF();
    }
}
