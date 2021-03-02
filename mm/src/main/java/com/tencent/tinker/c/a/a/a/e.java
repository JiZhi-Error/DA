package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.c.a.c.a;
import com.tencent.tinker.c.a.c.c;

public final class e extends i<com.tencent.tinker.a.a.e> {
    private s.a ShX = null;
    private i.e ShY = null;

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.tinker.c.a.c.a, java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ com.tencent.tinker.a.a.e a(a aVar, com.tencent.tinker.a.a.e eVar) {
        com.tencent.tinker.a.a.e eVar2 = eVar;
        return new com.tencent.tinker.a.a.e(eVar2.off, aVar.b(eVar2.SfE), aVar.b(eVar2.SfF), aVar.b(eVar2.SfG), aVar.b(eVar2.SfH));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ int f(com.tencent.tinker.a.a.e eVar) {
        this.ShX.size++;
        return this.ShY.b(eVar);
    }

    public e(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.ShX = iVar2.Sgk.SgP;
            this.ShY = iVar2.a(this.ShX);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3, int i4, int i5) {
        if (i3 != i5) {
            cVar.Sji.put(i3, i5);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final s.a c(i iVar) {
        return iVar.Sgk.SgP;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3) {
        if (i3 >= 0) {
            cVar.Sjw.asd(i3);
        }
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ com.tencent.tinker.a.a.e a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.hoC();
    }
}
