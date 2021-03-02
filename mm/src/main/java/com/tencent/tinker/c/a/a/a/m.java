package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.c.a.c.a;
import com.tencent.tinker.c.a.c.c;
import java.io.ByteArrayOutputStream;

public final class m extends i<k> {
    private s.a Sil = null;
    private i.e Sim = null;

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.tinker.c.a.c.a, java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ k a(a aVar, k kVar) {
        k kVar2 = kVar;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(kVar2.data.length);
        new a.C2213a(new b(byteArrayOutputStream) {
            /* class com.tencent.tinker.c.a.c.a.AnonymousClass3 */
            final /* synthetic */ ByteArrayOutputStream SiT;

            {
                this.SiT = r2;
            }

            @Override // com.tencent.tinker.a.a.b.b
            public final void writeByte(int i2) {
                this.SiT.write(i2);
            }
        }).c(new com.tencent.tinker.a.a.m(kVar2, 28));
        return new k(kVar2.off, byteArrayOutputStream.toByteArray());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ int f(k kVar) {
        this.Sil.size++;
        return this.Sim.a(kVar);
    }

    public m(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.Sil = iVar2.Sgk.SgU;
            this.Sim = iVar2.a(this.Sil);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3, int i4, int i5) {
        if (i3 != i5) {
            cVar.Sjh.put(i3, i5);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final s.a c(i iVar) {
        return iVar.Sgk.SgU;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3) {
        if (i3 >= 0) {
            cVar.Sjv.asd(i3);
        }
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ k a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.hoH();
    }
}
