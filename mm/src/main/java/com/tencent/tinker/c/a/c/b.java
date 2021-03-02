package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.a.c;
import com.tencent.tinker.a.b.a.d;
import com.tencent.tinker.a.b.a.e;
import com.tencent.tinker.a.b.a.f;
import com.tencent.tinker.a.b.a.g;
import com.tencent.tinker.a.b.a.h;
import java.io.EOFException;

public final class b {
    final a SiV;

    public b(a aVar) {
        this.SiV = aVar;
    }

    public final short[] a(short[] sArr) {
        h hVar = new h(sArr.length);
        c cVar = new c();
        f fVar = new f(hVar, cVar);
        d dVar = new d(new g(sArr));
        try {
            dVar.a(new a(cVar));
            dVar.a(new a(fVar));
            int i2 = hVar.apk;
            if (i2 == hVar.Shs.length) {
                return hVar.Shs;
            }
            short[] sArr2 = new short[i2];
            System.arraycopy(hVar.Shs, 0, sArr2, 0, i2);
            return sArr2;
        } catch (EOFException e2) {
            throw new j(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final class a extends e {
        a(e eVar) {
            super(eVar);
        }

        @Override // com.tencent.tinker.a.b.a.e
        public final void a(int i2, int i3, int i4, int i5, int i6, long j2) {
            super.a(i2, i3, mK(i4, i5), i5, i6, j2);
        }

        @Override // com.tencent.tinker.a.b.a.e
        public final void a(int i2, int i3, int i4, int i5, int i6, long j2, int i7) {
            super.a(i2, i3, mK(i4, i5), i5, i6, j2, i7);
        }

        @Override // com.tencent.tinker.a.b.a.e
        public final void a(int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8) {
            super.a(i2, i3, mK(i4, i5), i5, i6, j2, i7, i8);
        }

        @Override // com.tencent.tinker.a.b.a.e
        public final void a(int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8, int i9) {
            super.a(i2, i3, mK(i4, i5), i5, i6, j2, i7, i8, i9);
        }

        @Override // com.tencent.tinker.a.b.a.e
        public final void a(int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8, int i9, int i10) {
            super.a(i2, i3, mK(i4, i5), i5, i6, j2, i7, i8, i9, i10);
        }

        @Override // com.tencent.tinker.a.b.a.e
        public final void a(int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8, int i9, int i10, int i11) {
            super.a(i2, i3, mK(i4, i5), i5, i6, j2, i7, i8, i9, i10, i11);
        }

        @Override // com.tencent.tinker.a.b.a.e
        public final void b(int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8) {
            super.b(i2, i3, mK(i4, i5), i5, i6, j2, i7, i8);
        }

        private int mK(int i2, int i3) {
            switch (i3) {
                case 2:
                    return b.this.SiV.ash(i2);
                case 3:
                    return b.this.SiV.asg(i2);
                case 4:
                    return b.this.SiV.ask(i2);
                case 5:
                    return b.this.SiV.asj(i2);
                default:
                    return i2;
            }
        }
    }
}
