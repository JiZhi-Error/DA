package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.c.a.c.a;
import com.tencent.tinker.c.a.c.c;
import java.lang.reflect.Array;

public final class d extends i<com.tencent.tinker.a.a.d> {
    private s.a ShV = null;
    private i.e ShW = null;

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.tinker.c.a.c.a, java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ com.tencent.tinker.a.a.d a(a aVar, com.tencent.tinker.a.a.d dVar) {
        com.tencent.tinker.a.a.d dVar2 = dVar;
        int asn = aVar.asn(dVar2.SfA);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, dVar2.SfB.length, 2);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2][0] = aVar.asj(dVar2.SfB[i2][0]);
            iArr[i2][1] = aVar.asn(dVar2.SfB[i2][1]);
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, dVar2.SfC.length, 2);
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            iArr2[i3][0] = aVar.ask(dVar2.SfC[i3][0]);
            iArr2[i3][1] = aVar.asn(dVar2.SfC[i3][1]);
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, dVar2.SfD.length, 2);
        for (int i4 = 0; i4 < iArr3.length; i4++) {
            iArr3[i4][0] = aVar.ask(dVar2.SfD[i4][0]);
            iArr3[i4][1] = aVar.aso(dVar2.SfD[i4][1]);
        }
        return new com.tencent.tinker.a.a.d(dVar2.off, asn, iArr, iArr2, iArr3);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ int f(com.tencent.tinker.a.a.d dVar) {
        this.ShV.size++;
        return this.ShW.b(dVar);
    }

    public d(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.ShV = iVar2.Sgk.SgV;
            this.ShW = iVar2.a(this.ShV);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3, int i4, int i5) {
        if (i3 != i5) {
            cVar.Sjg.put(i3, i5);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final s.a c(i iVar) {
        return iVar.Sgk.SgV;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3) {
        if (i3 >= 0) {
            cVar.Sju.asd(i3);
        }
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ com.tencent.tinker.a.a.d a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.hoG();
    }
}
