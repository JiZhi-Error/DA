package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.c.a.b.a;
import com.tencent.tinker.c.a.c.c;

public final class n extends i<r> {
    private s.a Sin = null;
    private s.a Sio = null;
    private i.e Sip = null;
    private i.e Siq = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ int f(r rVar) {
        int a2 = this.Sip.a(rVar);
        this.Siq.writeInt(a2);
        this.Sin.size++;
        this.Sio.size++;
        return a2;
    }

    public n(a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.Sin = iVar2.Sgk.SgR;
            this.Sio = iVar2.Sgk.SgF;
            this.Sip = iVar2.a(this.Sin);
            this.Siq = iVar2.a(this.Sio);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3, int i4, int i5) {
        if (i2 != i4) {
            cVar.SiX.put(i2, i4);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final s.a c(i iVar) {
        return iVar.Sgk.SgR;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3) {
        if (i2 >= 0) {
            cVar.Sjl.asd(i2);
        }
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ r a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.hou();
    }
}
