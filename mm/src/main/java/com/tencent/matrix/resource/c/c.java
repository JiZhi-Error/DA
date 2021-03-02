package com.tencent.matrix.resource.c;

import com.tencent.matrix.resource.c.a.b;
import com.tencent.matrix.resource.c.b.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c {
    private final InputStream cZf;
    private int coW = 0;

    public c(InputStream inputStream) {
        this.cZf = inputStream;
    }

    public final void a(d dVar) {
        b(dVar);
        c(dVar);
        dVar.Td();
    }

    private void b(d dVar) {
        String q = a.q(this.cZf);
        int o = a.o(this.cZf);
        if (o <= 0 || o >= 1073741823) {
            throw new IOException("bad idSize: ".concat(String.valueOf(o)));
        }
        long p = a.p(this.cZf);
        this.coW = o;
        dVar.a(q, o, p);
    }

    private void c(d dVar) {
        while (true) {
            try {
                int read = this.cZf.read();
                int o = a.o(this.cZf);
                long o2 = Util.MAX_32BIT_VALUE & ((long) a.o(this.cZf));
                switch (read) {
                    case 1:
                        a(o, o2, dVar);
                        break;
                    case 2:
                        b(o, o2, dVar);
                        break;
                    case 4:
                        c(o, o2, dVar);
                        break;
                    case 5:
                        d(o, o2, dVar);
                        break;
                    case 12:
                    case 28:
                        a(read, o, o2, dVar);
                        break;
                    default:
                        b(read, o, o2, dVar);
                        break;
                }
            } catch (EOFException e2) {
                return;
            }
        }
    }

    private void a(int i2, long j2, d dVar) {
        dVar.a(a.a(this.cZf, this.coW), a.b(this.cZf, j2 - ((long) this.coW)), i2, j2);
    }

    private void b(int i2, long j2, d dVar) {
        dVar.a(a.o(this.cZf), a.a(this.cZf, this.coW), a.o(this.cZf), a.a(this.cZf, this.coW), i2, j2);
    }

    private void c(int i2, long j2, d dVar) {
        dVar.a(a.a(this.cZf, this.coW), a.a(this.cZf, this.coW), a.a(this.cZf, this.coW), a.a(this.cZf, this.coW), a.o(this.cZf), a.o(this.cZf), i2, j2);
    }

    private void d(int i2, long j2, d dVar) {
        int o = a.o(this.cZf);
        int o2 = a.o(this.cZf);
        int o3 = a.o(this.cZf);
        b[] bVarArr = new b[o3];
        for (int i3 = 0; i3 < o3; i3++) {
            bVarArr[i3] = a.a(this.cZf, this.coW);
        }
        dVar.a(o, o2, bVarArr, i2, j2);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 157
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    private void a(int r8, int r9, long r10, com.tencent.matrix.resource.c.d r12) {
        /*
        // Method dump skipped, instructions count: 464
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.resource.c.c.a(int, int, long, com.tencent.matrix.resource.c.d):void");
    }

    private void b(int i2, int i3, long j2, d dVar) {
        byte[] bArr = new byte[((int) j2)];
        a.a(this.cZf, bArr, j2);
        dVar.a(i2, i3, j2, bArr);
    }

    private int a(b bVar) {
        bVar.a(a.o(this.cZf), a.a(this.cZf, this.coW));
        return this.coW + 4;
    }

    private int b(b bVar) {
        bVar.a(a.a(this.cZf, this.coW), a.o(this.cZf), a.o(this.cZf));
        return this.coW + 4 + 4;
    }

    private int c(b bVar) {
        bVar.b(a.a(this.cZf, this.coW), a.o(this.cZf), a.o(this.cZf));
        return this.coW + 4 + 4;
    }

    private int d(b bVar) {
        bVar.a(a.a(this.cZf, this.coW), a.o(this.cZf));
        return this.coW + 4;
    }

    private int e(b bVar) {
        bVar.b(a.a(this.cZf, this.coW), a.o(this.cZf));
        return this.coW + 4;
    }

    private int f(b bVar) {
        bVar.c(a.a(this.cZf, this.coW), a.o(this.cZf), a.o(this.cZf));
        return this.coW + 4 + 4;
    }

    private int g(b bVar) {
        b a2 = a.a(this.cZf, this.coW);
        int o = a.o(this.cZf);
        b a3 = a.a(this.cZf, this.coW);
        b a4 = a.a(this.cZf, this.coW);
        a.c(this.cZf, (long) (this.coW << 2));
        int o2 = a.o(this.cZf);
        short n = a.n(this.cZf);
        int i2 = 0;
        int i3 = (this.coW * 7) + 4 + 4 + 2;
        while (i2 < n) {
            a.c(this.cZf, 2);
            i2++;
            i3 = Te() + 2 + i3;
        }
        int n2 = a.n(this.cZf);
        com.tencent.matrix.resource.c.a.a[] aVarArr = new com.tencent.matrix.resource.c.a.a[n2];
        int i4 = 0;
        int i5 = i3 + 2;
        while (i4 < n2) {
            b a5 = a.a(this.cZf, this.coW);
            int read = this.cZf.read();
            com.tencent.matrix.resource.c.a.c iu = com.tencent.matrix.resource.c.a.c.iu(read);
            if (iu == null) {
                throw new IllegalStateException("accept class failed, lost type def of typeId: ".concat(String.valueOf(read)));
            }
            aVarArr[i4] = new com.tencent.matrix.resource.c.a.a(read, a5, a.a(this.cZf, iu, this.coW));
            i4++;
            i5 = this.coW + 1 + iu.getSize(this.coW) + i5;
        }
        int n3 = a.n(this.cZf);
        com.tencent.matrix.resource.c.a.a[] aVarArr2 = new com.tencent.matrix.resource.c.a.a[n3];
        int i6 = i5 + 2;
        for (int i7 = 0; i7 < n3; i7++) {
            aVarArr2[i7] = new com.tencent.matrix.resource.c.a.a(this.cZf.read(), a.a(this.cZf, this.coW), null);
            i6 += this.coW + 1;
        }
        bVar.a(a2, o, a3, a4, o2, aVarArr, aVarArr2);
        return i6;
    }

    private int h(b bVar) {
        b a2 = a.a(this.cZf, this.coW);
        int o = a.o(this.cZf);
        b a3 = a.a(this.cZf, this.coW);
        int o2 = a.o(this.cZf);
        byte[] bArr = new byte[o2];
        a.a(this.cZf, bArr, (long) o2);
        bVar.a(a2, o, a3, bArr);
        return this.coW + 4 + this.coW + 4 + o2;
    }

    private int i(b bVar) {
        b a2 = a.a(this.cZf, this.coW);
        int o = a.o(this.cZf);
        int o2 = a.o(this.cZf);
        b a3 = a.a(this.cZf, this.coW);
        int i2 = o2 * this.coW;
        byte[] bArr = new byte[i2];
        a.a(this.cZf, bArr, (long) i2);
        bVar.a(a2, o, o2, a3, bArr);
        return this.coW + 4 + 4 + this.coW + i2;
    }

    private int a(int i2, b bVar) {
        b a2 = a.a(this.cZf, this.coW);
        int o = a.o(this.cZf);
        int o2 = a.o(this.cZf);
        int read = this.cZf.read();
        com.tencent.matrix.resource.c.a.c iu = com.tencent.matrix.resource.c.a.c.iu(read);
        if (iu == null) {
            throw new IllegalStateException("accept primitive array failed, lost type def of typeId: ".concat(String.valueOf(read)));
        }
        int size = o2 * iu.getSize(this.coW);
        byte[] bArr = new byte[size];
        a.a(this.cZf, bArr, (long) size);
        bVar.a(i2, a2, o, o2, read, bArr);
        return this.coW + 4 + 4 + 1 + size;
    }

    private int j(b bVar) {
        bVar.d(a.a(this.cZf, this.coW), a.o(this.cZf), a.o(this.cZf));
        return this.coW + 4 + 4;
    }

    private int Te() {
        int read = this.cZf.read();
        com.tencent.matrix.resource.c.a.c iu = com.tencent.matrix.resource.c.a.c.iu(read);
        if (iu == null) {
            throw new IllegalStateException("failure to skip type, cannot find type def of typeid: ".concat(String.valueOf(read)));
        }
        int size = iu.getSize(this.coW);
        a.c(this.cZf, (long) size);
        return size + 1;
    }
}
