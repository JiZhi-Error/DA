package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.g;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.c.a.c.a;
import com.tencent.tinker.c.a.c.b;
import com.tencent.tinker.c.a.c.c;

public final class g extends i<com.tencent.tinker.a.a.g> {
    private s.a Sib = null;
    private i.e Sic = null;

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.tinker.c.a.c.a, java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ com.tencent.tinker.a.a.g a(a aVar, com.tencent.tinker.a.a.g gVar) {
        g.a[] aVarArr;
        com.tencent.tinker.a.a.g gVar2 = gVar;
        int ass = aVar.ass(gVar2.SfW);
        short[] sArr = gVar2.SfX;
        if (!(sArr == null || sArr.length == 0)) {
            sArr = new b(aVar).a(sArr);
        }
        g.a[] aVarArr2 = gVar2.SfZ;
        if (aVarArr2 == null || aVarArr2.length == 0) {
            aVarArr = aVarArr2;
        } else {
            aVarArr = new g.a[aVarArr2.length];
            for (int i2 = 0; i2 < aVarArr2.length; i2++) {
                g.a aVar2 = aVarArr2[i2];
                int length = aVar2.Sga.length;
                int[] iArr = new int[length];
                for (int i3 = 0; i3 < length; i3++) {
                    iArr[i3] = aVar.ash(aVar2.Sga[i3]);
                }
                aVarArr[i2] = new g.a(iArr, aVar2.Sgb, aVar2.Sgc, aVar2.offset);
            }
        }
        return new com.tencent.tinker.a.a.g(gVar2.off, gVar2.SfT, gVar2.SfU, gVar2.SfV, ass, sArr, gVar2.SfY, aVarArr);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ int f(com.tencent.tinker.a.a.g gVar) {
        this.Sib.size++;
        return this.Sic.b(gVar);
    }

    public g(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.Sib = iVar2.Sgk.SgQ;
            this.Sic = iVar2.a(this.Sib);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3, int i4, int i5) {
        if (i3 != i5) {
            cVar.Sjk.put(i3, i5);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final s.a c(i iVar) {
        return iVar.Sgk.SgQ;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3) {
        if (i3 >= 0) {
            cVar.Sjy.asd(i3);
        }
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ com.tencent.tinker.a.a.g a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.hoA();
    }
}
