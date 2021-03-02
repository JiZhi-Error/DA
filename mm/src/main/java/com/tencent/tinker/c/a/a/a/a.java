package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.c.a.c.a;
import com.tencent.tinker.c.a.c.c;
import java.io.ByteArrayOutputStream;

public final class a extends i<com.tencent.tinker.a.a.a> {
    private s.a ShP = null;
    private i.e ShQ = null;

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.tinker.c.a.c.a, java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ com.tencent.tinker.a.a.a a(com.tencent.tinker.c.a.c.a aVar, com.tencent.tinker.a.a.a aVar2) {
        com.tencent.tinker.a.a.a aVar3 = aVar2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(aVar3.Sfx.data.length);
        new a.C2213a(new b(byteArrayOutputStream) {
            /* class com.tencent.tinker.c.a.c.a.AnonymousClass4 */
            final /* synthetic */ ByteArrayOutputStream SiT;

            {
                this.SiT = r2;
            }

            @Override // com.tencent.tinker.a.a.b.b
            public final void writeByte(int i2) {
                this.SiT.write(i2);
            }
        }).b(new m(aVar3.Sfx, 29));
        return new com.tencent.tinker.a.a.a(aVar3.off, aVar3.Sfw, new k(aVar3.Sfx.off, byteArrayOutputStream.toByteArray()));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ int f(com.tencent.tinker.a.a.a aVar) {
        this.ShP.size++;
        return this.ShQ.b(aVar);
    }

    public a(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.ShP = iVar2.Sgk.SgT;
            this.ShQ = iVar2.a(this.ShP);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3, int i4, int i5) {
        if (i3 != i5) {
            cVar.Sjd.put(i3, i5);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final s.a c(i iVar) {
        return iVar.Sgk.SgT;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3) {
        if (i3 >= 0) {
            cVar.Sjr.asd(i3);
        }
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ com.tencent.tinker.a.a.a a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.hoD();
    }
}
