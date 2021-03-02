package android.support.v7.widget;

import android.support.v4.e.l;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ai;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class d implements ai.a {
    private l.a<b> ajR;
    final ArrayList<b> ajS;
    final ArrayList<b> ajT;
    final a ajU;
    Runnable ajV;
    final boolean ajW;
    final ai ajX;
    int ajY;

    /* access modifiers changed from: package-private */
    public interface a {
        void N(int i2, int i3);

        void O(int i2, int i3);

        void P(int i2, int i3);

        void Q(int i2, int i3);

        RecyclerView.v bG(int i2);

        void d(int i2, int i3, Object obj);

        void d(b bVar);

        void e(b bVar);
    }

    d(a aVar) {
        this(aVar, (byte) 0);
    }

    private d(a aVar, byte b2) {
        this.ajR = new l.b(30);
        this.ajS = new ArrayList<>();
        this.ajT = new ArrayList<>();
        this.ajY = 0;
        this.ajU = aVar;
        this.ajW = false;
        this.ajX = new ai(this);
    }

    /* access modifiers changed from: package-private */
    public final void reset() {
        m(this.ajS);
        m(this.ajT);
        this.ajY = 0;
    }

    /* access modifiers changed from: package-private */
    public final void ja() {
        int i2;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        ai aiVar = this.ajX;
        ArrayList<b> arrayList = this.ajS;
        while (true) {
            boolean z3 = false;
            int size = arrayList.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (arrayList.get(size).EX != 8) {
                        z2 = true;
                    } else if (z3) {
                        i2 = size;
                    } else {
                        z2 = z3;
                    }
                    size--;
                    z3 = z2;
                } else {
                    i2 = -1;
                }
            }
            if (i2 != -1) {
                int i5 = i2 + 1;
                b bVar = arrayList.get(i2);
                b bVar2 = arrayList.get(i5);
                switch (bVar2.EX) {
                    case 1:
                        int i6 = 0;
                        if (bVar.akb < bVar2.ajZ) {
                            i6 = -1;
                        }
                        if (bVar.ajZ < bVar2.ajZ) {
                            i6++;
                        }
                        if (bVar2.ajZ <= bVar.ajZ) {
                            bVar.ajZ += bVar2.akb;
                        }
                        if (bVar2.ajZ <= bVar.akb) {
                            bVar.akb += bVar2.akb;
                        }
                        bVar2.ajZ = i6 + bVar2.ajZ;
                        arrayList.set(i2, bVar2);
                        arrayList.set(i5, bVar);
                        break;
                    case 2:
                        b bVar3 = null;
                        boolean z4 = false;
                        if (bVar.ajZ < bVar.akb) {
                            z = false;
                            if (bVar2.ajZ == bVar.ajZ && bVar2.akb == bVar.akb - bVar.ajZ) {
                                z4 = true;
                            }
                        } else {
                            z = true;
                            if (bVar2.ajZ == bVar.akb + 1 && bVar2.akb == bVar.ajZ - bVar.akb) {
                                z4 = true;
                            }
                        }
                        if (bVar.akb >= bVar2.ajZ) {
                            if (bVar.akb < bVar2.ajZ + bVar2.akb) {
                                bVar2.akb--;
                                bVar.EX = 2;
                                bVar.akb = 1;
                                if (bVar2.akb == 0) {
                                    arrayList.remove(i5);
                                    aiVar.arH.c(bVar2);
                                    break;
                                } else {
                                    break;
                                }
                            }
                        } else {
                            bVar2.ajZ--;
                        }
                        if (bVar.ajZ <= bVar2.ajZ) {
                            bVar2.ajZ++;
                        } else if (bVar.ajZ < bVar2.ajZ + bVar2.akb) {
                            bVar3 = aiVar.arH.a(2, bVar.ajZ + 1, (bVar2.ajZ + bVar2.akb) - bVar.ajZ, null);
                            bVar2.akb = bVar.ajZ - bVar2.ajZ;
                        }
                        if (z4) {
                            arrayList.set(i2, bVar2);
                            arrayList.remove(i5);
                            aiVar.arH.c(bVar);
                            break;
                        } else {
                            if (z) {
                                if (bVar3 != null) {
                                    if (bVar.ajZ > bVar3.ajZ) {
                                        bVar.ajZ -= bVar3.akb;
                                    }
                                    if (bVar.akb > bVar3.ajZ) {
                                        bVar.akb -= bVar3.akb;
                                    }
                                }
                                if (bVar.ajZ > bVar2.ajZ) {
                                    bVar.ajZ -= bVar2.akb;
                                }
                                if (bVar.akb > bVar2.ajZ) {
                                    bVar.akb -= bVar2.akb;
                                }
                            } else {
                                if (bVar3 != null) {
                                    if (bVar.ajZ >= bVar3.ajZ) {
                                        bVar.ajZ -= bVar3.akb;
                                    }
                                    if (bVar.akb >= bVar3.ajZ) {
                                        bVar.akb -= bVar3.akb;
                                    }
                                }
                                if (bVar.ajZ >= bVar2.ajZ) {
                                    bVar.ajZ -= bVar2.akb;
                                }
                                if (bVar.akb >= bVar2.ajZ) {
                                    bVar.akb -= bVar2.akb;
                                }
                            }
                            arrayList.set(i2, bVar2);
                            if (bVar.ajZ != bVar.akb) {
                                arrayList.set(i5, bVar);
                            } else {
                                arrayList.remove(i5);
                            }
                            if (bVar3 != null) {
                                arrayList.add(i2, bVar3);
                                break;
                            } else {
                                break;
                            }
                        }
                    case 4:
                        b bVar4 = null;
                        b bVar5 = null;
                        if (bVar.akb < bVar2.ajZ) {
                            bVar2.ajZ--;
                        } else if (bVar.akb < bVar2.ajZ + bVar2.akb) {
                            bVar2.akb--;
                            bVar4 = aiVar.arH.a(4, bVar.ajZ, 1, bVar2.aka);
                        }
                        if (bVar.ajZ <= bVar2.ajZ) {
                            bVar2.ajZ++;
                        } else if (bVar.ajZ < bVar2.ajZ + bVar2.akb) {
                            int i7 = (bVar2.ajZ + bVar2.akb) - bVar.ajZ;
                            bVar5 = aiVar.arH.a(4, bVar.ajZ + 1, i7, bVar2.aka);
                            bVar2.akb -= i7;
                        }
                        arrayList.set(i5, bVar);
                        if (bVar2.akb > 0) {
                            arrayList.set(i2, bVar2);
                        } else {
                            arrayList.remove(i2);
                            aiVar.arH.c(bVar2);
                        }
                        if (bVar4 != null) {
                            arrayList.add(i2, bVar4);
                        }
                        if (bVar5 != null) {
                            arrayList.add(i2, bVar5);
                            break;
                        } else {
                            break;
                        }
                }
            } else {
                int size2 = this.ajS.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    b bVar6 = this.ajS.get(i8);
                    switch (bVar6.EX) {
                        case 1:
                            b(bVar6);
                            break;
                        case 2:
                            int i9 = bVar6.ajZ;
                            int i10 = bVar6.akb + bVar6.ajZ;
                            char c2 = 65535;
                            int i11 = bVar6.ajZ;
                            int i12 = 0;
                            while (i11 < i10) {
                                boolean z5 = false;
                                if (this.ajU.bG(i11) != null || bC(i11)) {
                                    if (c2 == 0) {
                                        a(a(2, i9, i12, null));
                                        z5 = true;
                                    }
                                    c2 = 1;
                                } else {
                                    if (c2 == 1) {
                                        b(a(2, i9, i12, null));
                                        z5 = true;
                                    }
                                    c2 = 0;
                                }
                                if (z5) {
                                    i11 -= i12;
                                    i4 = i10 - i12;
                                    i3 = 1;
                                } else {
                                    i3 = i12 + 1;
                                    i4 = i10;
                                }
                                i11++;
                                i10 = i4;
                                i12 = i3;
                            }
                            if (i12 != bVar6.akb) {
                                c(bVar6);
                                bVar6 = a(2, i9, i12, null);
                            }
                            if (c2 == 0) {
                                a(bVar6);
                                break;
                            } else {
                                b(bVar6);
                                break;
                            }
                            break;
                        case 4:
                            int i13 = bVar6.ajZ;
                            int i14 = 0;
                            int i15 = bVar6.ajZ + bVar6.akb;
                            char c3 = 65535;
                            for (int i16 = bVar6.ajZ; i16 < i15; i16++) {
                                if (this.ajU.bG(i16) != null || bC(i16)) {
                                    if (c3 == 0) {
                                        a(a(4, i13, i14, bVar6.aka));
                                        i14 = 0;
                                        i13 = i16;
                                    }
                                    c3 = 1;
                                } else {
                                    if (c3 == 1) {
                                        b(a(4, i13, i14, bVar6.aka));
                                        i14 = 0;
                                        i13 = i16;
                                    }
                                    c3 = 0;
                                }
                                i14++;
                            }
                            if (i14 != bVar6.akb) {
                                Object obj = bVar6.aka;
                                c(bVar6);
                                bVar6 = a(4, i13, i14, obj);
                            }
                            if (c3 == 0) {
                                a(bVar6);
                                break;
                            } else {
                                b(bVar6);
                                break;
                            }
                            break;
                        case 8:
                            b(bVar6);
                            break;
                    }
                    if (this.ajV != null) {
                        this.ajV.run();
                    }
                }
                this.ajS.clear();
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void jb() {
        int size = this.ajT.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.ajU.e(this.ajT.get(i2));
        }
        m(this.ajT);
        this.ajY = 0;
    }

    private void a(b bVar) {
        int i2;
        boolean z;
        if (bVar.EX == 1 || bVar.EX == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int L = L(bVar.ajZ, bVar.EX);
        int i3 = bVar.ajZ;
        switch (bVar.EX) {
            case 2:
                i2 = 0;
                break;
            case 3:
            default:
                throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(bVar)));
            case 4:
                i2 = 1;
                break;
        }
        int i4 = 1;
        for (int i5 = 1; i5 < bVar.akb; i5++) {
            int L2 = L(bVar.ajZ + (i2 * i5), bVar.EX);
            switch (bVar.EX) {
                case 2:
                    if (L2 == L) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                case 3:
                default:
                    z = false;
                    break;
                case 4:
                    if (L2 == L + 1) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
            }
            if (z) {
                i4++;
            } else {
                b a2 = a(bVar.EX, L, i4, bVar.aka);
                a(a2, i3);
                c(a2);
                if (bVar.EX == 4) {
                    i3 += i4;
                }
                i4 = 1;
                L = L2;
            }
        }
        Object obj = bVar.aka;
        c(bVar);
        if (i4 > 0) {
            b a3 = a(bVar.EX, L, i4, obj);
            a(a3, i3);
            c(a3);
        }
    }

    private void a(b bVar, int i2) {
        this.ajU.d(bVar);
        switch (bVar.EX) {
            case 2:
                this.ajU.N(i2, bVar.akb);
                return;
            case 3:
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            case 4:
                this.ajU.d(i2, bVar.akb, bVar.aka);
                return;
        }
    }

    private int L(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int size = this.ajT.size() - 1;
        int i7 = i2;
        while (size >= 0) {
            b bVar = this.ajT.get(size);
            if (bVar.EX == 8) {
                if (bVar.ajZ < bVar.akb) {
                    i5 = bVar.ajZ;
                    i6 = bVar.akb;
                } else {
                    i5 = bVar.akb;
                    i6 = bVar.ajZ;
                }
                if (i7 < i5 || i7 > i6) {
                    if (i7 < bVar.ajZ) {
                        if (i3 == 1) {
                            bVar.ajZ++;
                            bVar.akb++;
                            i4 = i7;
                        } else if (i3 == 2) {
                            bVar.ajZ--;
                            bVar.akb--;
                        }
                    }
                    i4 = i7;
                } else if (i5 == bVar.ajZ) {
                    if (i3 == 1) {
                        bVar.akb++;
                    } else if (i3 == 2) {
                        bVar.akb--;
                    }
                    i4 = i7 + 1;
                } else {
                    if (i3 == 1) {
                        bVar.ajZ++;
                    } else if (i3 == 2) {
                        bVar.ajZ--;
                    }
                    i4 = i7 - 1;
                }
            } else {
                if (bVar.ajZ <= i7) {
                    if (bVar.EX == 1) {
                        i4 = i7 - bVar.akb;
                    } else if (bVar.EX == 2) {
                        i4 = bVar.akb + i7;
                    }
                } else if (i3 == 1) {
                    bVar.ajZ++;
                    i4 = i7;
                } else if (i3 == 2) {
                    bVar.ajZ--;
                }
                i4 = i7;
            }
            size--;
            i7 = i4;
        }
        for (int size2 = this.ajT.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.ajT.get(size2);
            if (bVar2.EX == 8) {
                if (bVar2.akb == bVar2.ajZ || bVar2.akb < 0) {
                    this.ajT.remove(size2);
                    c(bVar2);
                }
            } else if (bVar2.akb <= 0) {
                this.ajT.remove(size2);
                c(bVar2);
            }
        }
        return i7;
    }

    private boolean bC(int i2) {
        int size = this.ajT.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.ajT.get(i3);
            if (bVar.EX == 8) {
                if (M(bVar.akb, i3 + 1) == i2) {
                    return true;
                }
            } else if (bVar.EX == 1) {
                int i4 = bVar.ajZ + bVar.akb;
                for (int i5 = bVar.ajZ; i5 < i4; i5++) {
                    if (M(i5, i3 + 1) == i2) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void b(b bVar) {
        this.ajT.add(bVar);
        switch (bVar.EX) {
            case 1:
                this.ajU.P(bVar.ajZ, bVar.akb);
                return;
            case 2:
                this.ajU.O(bVar.ajZ, bVar.akb);
                return;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(bVar)));
            case 4:
                this.ajU.d(bVar.ajZ, bVar.akb, bVar.aka);
                return;
            case 8:
                this.ajU.Q(bVar.ajZ, bVar.akb);
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean jc() {
        return this.ajS.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean bD(int i2) {
        return (this.ajY & i2) != 0;
    }

    /* access modifiers changed from: package-private */
    public final int bE(int i2) {
        return M(i2, 0);
    }

    /* access modifiers changed from: package-private */
    public final int M(int i2, int i3) {
        int size = this.ajT.size();
        int i4 = i2;
        while (i3 < size) {
            b bVar = this.ajT.get(i3);
            if (bVar.EX == 8) {
                if (bVar.ajZ == i4) {
                    i4 = bVar.akb;
                } else {
                    if (bVar.ajZ < i4) {
                        i4--;
                    }
                    if (bVar.akb <= i4) {
                        i4++;
                    }
                }
            } else if (bVar.ajZ > i4) {
                continue;
            } else if (bVar.EX == 2) {
                if (i4 < bVar.ajZ + bVar.akb) {
                    return -1;
                }
                i4 -= bVar.akb;
            } else if (bVar.EX == 1) {
                i4 += bVar.akb;
            }
            i3++;
        }
        return i4;
    }

    /* access modifiers changed from: package-private */
    public final void jd() {
        jb();
        int size = this.ajS.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.ajS.get(i2);
            switch (bVar.EX) {
                case 1:
                    this.ajU.e(bVar);
                    this.ajU.P(bVar.ajZ, bVar.akb);
                    break;
                case 2:
                    this.ajU.e(bVar);
                    this.ajU.N(bVar.ajZ, bVar.akb);
                    break;
                case 4:
                    this.ajU.e(bVar);
                    this.ajU.d(bVar.ajZ, bVar.akb, bVar.aka);
                    break;
                case 8:
                    this.ajU.e(bVar);
                    this.ajU.Q(bVar.ajZ, bVar.akb);
                    break;
            }
            if (this.ajV != null) {
                this.ajV.run();
            }
        }
        m(this.ajS);
        this.ajY = 0;
    }

    public final int bF(int i2) {
        int size = this.ajS.size();
        int i3 = i2;
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = this.ajS.get(i4);
            switch (bVar.EX) {
                case 1:
                    if (bVar.ajZ <= i3) {
                        i3 += bVar.akb;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (bVar.ajZ > i3) {
                        continue;
                    } else if (bVar.ajZ + bVar.akb <= i3) {
                        i3 -= bVar.akb;
                        break;
                    } else {
                        return -1;
                    }
                case 8:
                    if (bVar.ajZ == i3) {
                        i3 = bVar.akb;
                        break;
                    } else {
                        if (bVar.ajZ < i3) {
                            i3--;
                        }
                        if (bVar.akb <= i3) {
                            i3++;
                            break;
                        } else {
                            break;
                        }
                    }
            }
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final boolean je() {
        return !this.ajT.isEmpty() && !this.ajS.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public static class b {
        int EX;
        int ajZ;
        Object aka;
        int akb;

        b(int i2, int i3, int i4, Object obj) {
            this.EX = i2;
            this.ajZ = i3;
            this.akb = i4;
            this.aka = obj;
        }

        public final String toString() {
            String str;
            StringBuilder append = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
            switch (this.EX) {
                case 1:
                    str = "add";
                    break;
                case 2:
                    str = "rm";
                    break;
                case 3:
                case 5:
                case 6:
                case 7:
                default:
                    str = "??";
                    break;
                case 4:
                    str = "up";
                    break;
                case 8:
                    str = "mv";
                    break;
            }
            return append.append(str).append(",s:").append(this.ajZ).append("c:").append(this.akb).append(",p:").append(this.aka).append("]").toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.EX != bVar.EX) {
                return false;
            }
            if (this.EX == 8 && Math.abs(this.akb - this.ajZ) == 1 && this.akb == bVar.ajZ && this.ajZ == bVar.akb) {
                return true;
            }
            if (this.akb != bVar.akb) {
                return false;
            }
            if (this.ajZ != bVar.ajZ) {
                return false;
            }
            return this.aka != null ? this.aka.equals(bVar.aka) : bVar.aka == null;
        }

        public final int hashCode() {
            return (((this.EX * 31) + this.ajZ) * 31) + this.akb;
        }
    }

    @Override // android.support.v7.widget.ai.a
    public final b a(int i2, int i3, int i4, Object obj) {
        b acquire = this.ajR.acquire();
        if (acquire == null) {
            return new b(i2, i3, i4, obj);
        }
        acquire.EX = i2;
        acquire.ajZ = i3;
        acquire.akb = i4;
        acquire.aka = obj;
        return acquire;
    }

    @Override // android.support.v7.widget.ai.a
    public final void c(b bVar) {
        if (!this.ajW) {
            bVar.aka = null;
            this.ajR.release(bVar);
        }
    }

    private void m(List<b> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            c(list.get(i2));
        }
        list.clear();
    }
}
