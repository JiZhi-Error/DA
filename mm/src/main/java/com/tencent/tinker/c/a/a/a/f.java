package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.c.a.c.a;
import com.tencent.tinker.c.a.c.c;

public final class f extends i<com.tencent.tinker.a.a.f> {
    private s.a ShZ = null;
    private i.e Sia = null;

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.tinker.c.a.c.a, java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ com.tencent.tinker.a.a.f a(a aVar, com.tencent.tinker.a.a.f fVar) {
        com.tencent.tinker.a.a.f fVar2 = fVar;
        return new com.tencent.tinker.a.a.f(fVar2.off, aVar.ash(fVar2.SfM), fVar2.SfJ, aVar.ash(fVar2.SfN), aVar.asl(fVar2.SfO), aVar.asg(fVar2.SfP), aVar.asp(fVar2.SfQ), aVar.asr(fVar2.SfR), aVar.asq(fVar2.SfS));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ int f(com.tencent.tinker.a.a.f fVar) {
        this.ShZ.size++;
        return this.Sia.b(fVar);
    }

    public f(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.ShZ = iVar2.Sgk.SgK;
            this.Sia = iVar2.a(this.ShZ);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final s.a c(i iVar) {
        return iVar.Sgk.SgK;
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ com.tencent.tinker.a.a.f a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.hoz();
    }
}
