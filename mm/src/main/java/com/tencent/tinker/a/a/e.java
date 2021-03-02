package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.s;

public final class e extends s.a.AbstractC2212a<e> {
    public a[] SfE;
    public a[] SfF;
    public b[] SfG;
    public b[] SfH;

    public e(int i2, a[] aVarArr, a[] aVarArr2, b[] bVarArr, b[] bVarArr2) {
        super(i2);
        this.SfE = aVarArr;
        this.SfF = aVarArr2;
        this.SfG = bVarArr;
        this.SfH = bVarArr2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int compareTo(e eVar) {
        int a2 = c.a(this.SfE, eVar.SfE);
        if (a2 != 0) {
            return a2;
        }
        int a3 = c.a(this.SfF, eVar.SfF);
        if (a3 != 0) {
            return a3;
        }
        int a4 = c.a(this.SfG, eVar.SfG);
        return a4 == 0 ? c.a(this.SfH, eVar.SfH) : a4;
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final int hashCode() {
        return com.tencent.tinker.a.a.b.e.hash(this.SfE, this.SfF, this.SfG, this.SfH);
    }

    @Override // com.tencent.tinker.a.a.s.a.AbstractC2212a
    public final boolean equals(Object obj) {
        if ((obj instanceof e) && compareTo((e) obj) == 0) {
            return true;
        }
        return false;
    }

    public static class a implements Comparable<a> {
        public int SfI;
        public int SfJ;

        public a(int i2, int i3) {
            this.SfI = i2;
            this.SfJ = i3;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public int compareTo(a aVar) {
            int mD = c.mD(this.SfI, aVar.SfI);
            return mD != 0 ? mD : c.mE(this.SfJ, aVar.SfJ);
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof a) && compareTo((a) obj) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return com.tencent.tinker.a.a.b.e.hash(Integer.valueOf(this.SfI), Integer.valueOf(this.SfJ));
        }
    }

    public static class b implements Comparable<b> {
        public int SfJ;
        public int SfK;
        public int SfL;

        public b(int i2, int i3, int i4) {
            this.SfK = i2;
            this.SfJ = i3;
            this.SfL = i4;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public int compareTo(b bVar) {
            int mD = c.mD(this.SfK, bVar.SfK);
            if (mD != 0) {
                return mD;
            }
            int mE = c.mE(this.SfJ, bVar.SfJ);
            return mE == 0 ? c.mE(this.SfL, bVar.SfL) : mE;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof b) && compareTo((b) obj) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return com.tencent.tinker.a.a.b.e.hash(Integer.valueOf(this.SfK), Integer.valueOf(this.SfJ), Integer.valueOf(this.SfL));
        }
    }
}
