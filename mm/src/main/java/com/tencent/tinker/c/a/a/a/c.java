package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.b;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.c.a.c.a;

public final class c extends i<b> {
    private s.a ShT = null;
    private i.e ShU = null;

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.tinker.c.a.c.a, java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ b a(a aVar, b bVar) {
        b bVar2 = bVar;
        int length = bVar2.Sfy.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = aVar.asm(bVar2.Sfy[i2]);
        }
        return new b(bVar2.off, iArr);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ int f(b bVar) {
        this.ShT.size++;
        return this.ShU.b(bVar);
    }

    public c(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, com.tencent.tinker.c.a.c.c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.ShT = iVar2.Sgk.SgO;
            this.ShU = iVar2.a(this.ShT);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(com.tencent.tinker.c.a.c.c cVar, int i2, int i3, int i4, int i5) {
        if (i3 != i5) {
            cVar.Sje.put(i3, i5);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final s.a c(i iVar) {
        return iVar.Sgk.SgO;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(com.tencent.tinker.c.a.c.c cVar, int i2, int i3) {
        if (i3 >= 0) {
            cVar.Sjs.asd(i3);
        }
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ b a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.hoE();
    }
}
