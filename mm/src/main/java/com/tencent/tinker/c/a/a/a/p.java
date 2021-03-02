package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.t;
import com.tencent.tinker.c.a.c.a;
import com.tencent.tinker.c.a.c.c;

public final class p extends i<t> {
    private s.a Sit = null;
    private i.e Siu = null;

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.tinker.c.a.c.a, java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ t a(a aVar, t tVar) {
        t tVar2 = tVar;
        if (tVar2 == t.Shc) {
            return tVar2;
        }
        short[] sArr = new short[tVar2.Shd.length];
        for (int i2 = 0; i2 < sArr.length; i2++) {
            sArr[i2] = (short) aVar.ash(tVar2.Shd[i2]);
        }
        return new t(tVar2.off, sArr);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ int f(t tVar) {
        this.Sit.size++;
        return this.Siu.a(tVar);
    }

    public p(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.Sit = iVar2.Sgk.SgM;
            this.Siu = iVar2.a(this.Sit);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3, int i4, int i5) {
        if (i3 != i5) {
            cVar.Sjc.put(i3, i5);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final s.a c(i iVar) {
        return iVar.Sgk.SgM;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3) {
        if (i3 >= 0) {
            cVar.Sjq.asd(i3);
        }
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ t a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.hov();
    }
}
