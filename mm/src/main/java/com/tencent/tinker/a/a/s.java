package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.i;
import java.util.Arrays;

public final class s {
    public final a SgE = new a(0, true);
    public final a SgF = new a(1, true);
    public final a SgG = new a(2, true);
    public final a SgH = new a(3, true);
    public final a SgI = new a(4, true);
    public final a SgJ = new a(5, true);
    public final a SgK = new a(6, true);
    public final a SgL = new a(4096, true);
    public final a SgM = new a(4097, true);
    public final a SgN = new a(4098, true);
    public final a SgO = new a(4099, true);
    public final a SgP = new a(8192, false);
    public final a SgQ = new a(8193, true);
    public final a SgR = new a(8194, false);
    public final a SgS = new a(8195, false);
    public final a SgT = new a(8196, false);
    public final a SgU = new a(8197, false);
    public final a SgV = new a(8198, true);
    public final a[] SgW = {this.SgE, this.SgF, this.SgG, this.SgH, this.SgI, this.SgJ, this.SgK, this.SgL, this.SgM, this.SgN, this.SgO, this.SgP, this.SgQ, this.SgR, this.SgS, this.SgT, this.SgU, this.SgV};
    public int SgX;
    public int SgY;
    public int SgZ;
    public int dataSize;
    public int fileSize;
    public int jvw;
    public byte[] yRs = new byte[20];

    /* access modifiers changed from: package-private */
    public final void a(i.e eVar) {
        int i2 = eVar.aKP.getInt();
        int i3 = 0;
        a aVar = null;
        while (i3 < i2) {
            short s = eVar.aKP.getShort();
            eVar.aKP.getShort();
            a[] aVarArr = this.SgW;
            for (a aVar2 : aVarArr) {
                if (aVar2.Sha == s) {
                    int i4 = eVar.aKP.getInt();
                    int i5 = eVar.aKP.getInt();
                    if ((aVar2.size == 0 || aVar2.size == i4) && (aVar2.off == -1 || aVar2.off == i5)) {
                        aVar2.size = i4;
                        aVar2.off = i5;
                        if (aVar == null || aVar.off <= aVar2.off) {
                            i3++;
                            aVar = aVar2;
                        } else {
                            throw new j("Map is unsorted at " + aVar + ", " + aVar2);
                        }
                    } else {
                        throw new j("Unexpected map value for 0x" + Integer.toHexString(s));
                    }
                }
            }
            throw new IllegalArgumentException("No such map item: ".concat(String.valueOf((int) s)));
        }
        this.SgE.off = 0;
        Arrays.sort(this.SgW);
        for (int i6 = 1; i6 < this.SgW.length; i6++) {
            if (this.SgW[i6].off == -1) {
                this.SgW[i6].off = this.SgW[i6 - 1].off;
            }
        }
    }

    public final void hoR() {
        int i2 = this.fileSize;
        for (int length = this.SgW.length - 1; length >= 0; length--) {
            a aVar = this.SgW[length];
            if (aVar.off != -1) {
                if (aVar.off > i2) {
                    throw new j("Map is unsorted at ".concat(String.valueOf(aVar)));
                }
                aVar.byteCount = i2 - aVar.off;
                i2 = aVar.off;
            }
        }
        this.SgZ = this.SgE.byteCount + this.SgF.byteCount + this.SgG.byteCount + this.SgH.byteCount + this.SgI.byteCount + this.SgJ.byteCount + this.SgK.byteCount;
        this.dataSize = this.fileSize - this.SgZ;
    }

    public final void b(i.e eVar) {
        int i2 = 0;
        for (a aVar : this.SgW) {
            if (aVar.exists()) {
                i2++;
            }
        }
        eVar.writeInt(i2);
        a[] aVarArr = this.SgW;
        for (a aVar2 : aVarArr) {
            if (aVar2.exists()) {
                eVar.writeShort(aVar2.Sha);
                eVar.writeShort(0);
                eVar.writeInt(aVar2.size);
                eVar.writeInt(aVar2.off);
            }
        }
    }

    public static class a implements Comparable<a> {
        public final short Sha;
        public boolean Shb;
        public int byteCount = 0;
        public int off = -1;
        public int size = 0;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(a aVar) {
            a aVar2 = aVar;
            if (this.off != aVar2.off) {
                return this.off < aVar2.off ? -1 : 1;
            }
            int arK = arK(this.Sha);
            int arK2 = arK(aVar2.Sha);
            if (arK != arK2) {
                return arK >= arK2 ? 1 : -1;
            }
            return 0;
        }

        public a(int i2, boolean z) {
            this.Sha = (short) i2;
            this.Shb = z;
            if (i2 == 0) {
                this.off = 0;
                this.size = 1;
                this.byteCount = 112;
            } else if (i2 == 4096) {
                this.size = 1;
            }
        }

        public final boolean exists() {
            return this.size > 0;
        }

        private static int arK(int i2) {
            switch (i2) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 4096:
                    return 17;
                case 4097:
                    return 8;
                case 4098:
                    return 11;
                case 4099:
                    return 10;
                case 8192:
                    return 15;
                case 8193:
                    return 14;
                case 8194:
                    return 7;
                case 8195:
                    return 13;
                case 8196:
                    return 9;
                case 8197:
                    return 16;
                case 8198:
                    return 12;
                default:
                    throw new IllegalArgumentException("unknown section type: ".concat(String.valueOf(i2)));
            }
        }

        public final String toString() {
            return String.format("Section[type=%#x,off=%#x,size=%#x]", Short.valueOf(this.Sha), Integer.valueOf(this.off), Integer.valueOf(this.size));
        }

        /* renamed from: com.tencent.tinker.a.a.s$a$a  reason: collision with other inner class name */
        public static abstract class AbstractC2212a<T> implements Comparable<T> {
            public int off;

            public AbstractC2212a(int i2) {
                this.off = i2;
            }

            public int hashCode() {
                return super.hashCode();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
            /* JADX WARN: Multi-variable type inference failed */
            public boolean equals(Object obj) {
                return compareTo(obj) == 0;
            }
        }
    }
}
