package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.c.a.c.a;
import com.tencent.tinker.c.a.c.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public final class h extends i<com.tencent.tinker.a.a.h> {
    private s.a Sid = null;
    private i.e Sie = null;

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.tinker.c.a.c.a, java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ com.tencent.tinker.a.a.h a(a aVar, com.tencent.tinker.a.a.h hVar) {
        com.tencent.tinker.a.a.h hVar2 = hVar;
        int[] iArr = hVar2.Sgh;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr2[i2] = aVar.asg(iArr[i2]);
        }
        byte[] bArr = hVar2.Sgi;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        a.AnonymousClass1 r2 = new com.tencent.tinker.a.a.b.a(byteArrayInputStream) {
            /* class com.tencent.tinker.c.a.c.a.AnonymousClass1 */
            final /* synthetic */ ByteArrayInputStream SiR;

            {
                this.SiR = r2;
            }

            @Override // com.tencent.tinker.a.a.b.a
            public final byte readByte() {
                return (byte) (this.SiR.read() & 255);
            }
        };
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length + 512);
        a.AnonymousClass2 r0 = new b(byteArrayOutputStream) {
            /* class com.tencent.tinker.c.a.c.a.AnonymousClass2 */
            final /* synthetic */ ByteArrayOutputStream Shi;

            {
                this.Shi = r2;
            }

            @Override // com.tencent.tinker.a.a.b.b
            public final void writeByte(int i2) {
                this.Shi.write(i2);
            }
        };
        while (true) {
            int read = byteArrayInputStream.read() & 255;
            byteArrayOutputStream.write(read);
            switch (read) {
                case 0:
                    return new com.tencent.tinker.a.a.h(hVar2.off, hVar2.Sgg, iArr2, byteArrayOutputStream.toByteArray());
                case 1:
                    o.a(r0, o.b(r2));
                    break;
                case 2:
                    o.c(r0, o.a(r2));
                    break;
                case 3:
                case 4:
                    o.a(r0, o.b(r2));
                    o.b(r0, aVar.asg(o.c(r2)));
                    o.b(r0, aVar.ash(o.c(r2)));
                    if (read == 4) {
                        o.b(r0, aVar.asg(o.c(r2)));
                        break;
                    } else {
                        break;
                    }
                case 5:
                case 6:
                    o.a(r0, o.b(r2));
                    break;
                case 9:
                    o.b(r0, aVar.asg(o.c(r2)));
                    break;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ int f(com.tencent.tinker.a.a.h hVar) {
        this.Sid.size++;
        return this.Sie.b(hVar);
    }

    public h(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.Sid = iVar2.Sgk.SgS;
            this.Sie = iVar2.a(this.Sid);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3, int i4, int i5) {
        if (i3 != i5) {
            cVar.Sjj.put(i3, i5);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final s.a c(i iVar) {
        return iVar.Sgk.SgS;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final void a(c cVar, int i2, int i3) {
        if (i3 >= 0) {
            cVar.Sjx.asd(i3);
        }
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.tinker.c.a.a.a.i
    public final /* synthetic */ com.tencent.tinker.a.a.h a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.hoB();
    }
}
