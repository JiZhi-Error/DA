package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;
import com.tencent.tinker.a.a.s;

public final class g extends s.a.AbstractC2212a<g> {
    public int SfT;
    public int SfU;
    public int SfV;
    public int SfW;
    public short[] SfX;
    public b[] SfY;
    public a[] SfZ;

    public g(int i2, int i3, int i4, int i5, int i6, short[] sArr, b[] bVarArr, a[] aVarArr) {
        super(i2);
        this.SfT = i3;
        this.SfU = i4;
        this.SfV = i5;
        this.SfW = i6;
        this.SfX = sArr;
        this.SfY = bVarArr;
        this.SfZ = aVarArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int compareTo(g gVar) {
        int mE = c.mE(this.SfT, gVar.SfT);
        if (mE != 0) {
            return mE;
        }
        int mE2 = c.mE(this.SfU, gVar.SfU);
        if (mE2 != 0) {
            return mE2;
        }
        int mE3 = c.mE(this.SfV, gVar.SfV);
        if (mE3 != 0) {
            return mE3;
        }
        int mE4 = c.mE(this.SfW, gVar.SfW);
        if (mE4 != 0) {
            return mE4;
        }
        int a2 = c.a(this.SfX, gVar.SfX);
        if (a2 != 0) {
            return a2;
        }
        int a3 = c.a(this.SfY, gVar.SfY);
        return a3 == 0 ? c.a(this.SfZ, gVar.SfZ) : a3;
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final int hashCode() {
        return e.hash(Integer.valueOf(this.SfT), Integer.valueOf(this.SfU), Integer.valueOf(this.SfV), Integer.valueOf(this.SfW), this.SfX, this.SfY, this.SfZ);
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final boolean equals(Object obj) {
        if ((obj instanceof g) && compareTo((g) obj) == 0) {
            return true;
        }
        return false;
    }

    public static class b implements Comparable<b> {
        public int Sgd;
        public int Sge;
        public int Sgf;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(b bVar) {
            b bVar2 = bVar;
            int mE = c.mE(this.Sgd, bVar2.Sgd);
            if (mE != 0) {
                return mE;
            }
            int mE2 = c.mE(this.Sge, bVar2.Sge);
            if (mE2 == 0) {
                return c.mE(this.Sgf, bVar2.Sgf);
            }
            return mE2;
        }

        public b(int i2, int i3, int i4) {
            this.Sgd = i2;
            this.Sge = i3;
            this.Sgf = i4;
        }
    }

    public static class a implements Comparable<a> {
        public int[] Sga;
        public int[] Sgb;
        public int Sgc;
        public int offset;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(a aVar) {
            a aVar2 = aVar;
            int c2 = c.c(this.Sga, aVar2.Sga);
            if (c2 != 0) {
                return c2;
            }
            int c3 = c.c(this.Sgb, aVar2.Sgb);
            if (c3 == 0) {
                return c.mE(this.Sgc, aVar2.Sgc);
            }
            return c3;
        }

        public a(int[] iArr, int[] iArr2, int i2, int i3) {
            this.Sga = iArr;
            this.Sgb = iArr2;
            this.Sgc = i2;
            this.offset = i3;
        }
    }
}
