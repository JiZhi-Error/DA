package android.support.v7.h;

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class c {
    private static final Comparator<f> adp = new Comparator<f>() {
        /* class android.support.v7.h.c.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(f fVar, f fVar2) {
            f fVar3 = fVar;
            f fVar4 = fVar2;
            int i2 = fVar3.x - fVar4.x;
            return i2 == 0 ? fVar3.y - fVar4.y : i2;
        }
    };

    /* renamed from: android.support.v7.h.c$c  reason: collision with other inner class name */
    public static abstract class AbstractC0051c<T> {
        public abstract boolean d(T t, T t2);

        public abstract boolean e(T t, T t2);
    }

    public static b a(a aVar) {
        return a(aVar, true);
    }

    public static b a(a aVar, boolean z) {
        int aB = aVar.aB();
        int aC = aVar.aC();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new e(aB, aC));
        int abs = aB + aC + Math.abs(aB - aC);
        int[] iArr = new int[(abs * 2)];
        int[] iArr2 = new int[(abs * 2)];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            e eVar = (e) arrayList2.remove(arrayList2.size() - 1);
            f a2 = a(aVar, eVar.adA, eVar.adB, eVar.adC, eVar.adD, iArr, iArr2, abs);
            if (a2 != null) {
                if (a2.size > 0) {
                    arrayList.add(a2);
                }
                a2.x += eVar.adA;
                a2.y += eVar.adC;
                e eVar2 = arrayList3.isEmpty() ? new e() : (e) arrayList3.remove(arrayList3.size() - 1);
                eVar2.adA = eVar.adA;
                eVar2.adC = eVar.adC;
                if (a2.reverse) {
                    eVar2.adB = a2.x;
                    eVar2.adD = a2.y;
                } else if (a2.adz) {
                    eVar2.adB = a2.x - 1;
                    eVar2.adD = a2.y;
                } else {
                    eVar2.adB = a2.x;
                    eVar2.adD = a2.y - 1;
                }
                arrayList2.add(eVar2);
                if (!a2.reverse) {
                    eVar.adA = a2.x + a2.size;
                    eVar.adC = a2.y + a2.size;
                } else if (a2.adz) {
                    eVar.adA = a2.x + a2.size + 1;
                    eVar.adC = a2.y + a2.size;
                } else {
                    eVar.adA = a2.x + a2.size;
                    eVar.adC = a2.y + a2.size + 1;
                }
                arrayList2.add(eVar);
            } else {
                arrayList3.add(eVar);
            }
        }
        Collections.sort(arrayList, adp);
        return new b(aVar, arrayList, iArr, iArr2, z);
    }

    private static f a(a aVar, int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        int i7;
        boolean z;
        int i8;
        boolean z2;
        int i9 = i3 - i2;
        int i10 = i5 - i4;
        if (i3 - i2 <= 0 || i5 - i4 <= 0) {
            return null;
        }
        int i11 = i9 - i10;
        int i12 = ((i9 + i10) + 1) / 2;
        Arrays.fill(iArr, (i6 - i12) - 1, i6 + i12 + 1, 0);
        Arrays.fill(iArr2, ((i6 - i12) - 1) + i11, i6 + i12 + 1 + i11, i9);
        boolean z3 = i11 % 2 != 0;
        for (int i13 = 0; i13 <= i12; i13++) {
            for (int i14 = -i13; i14 <= i13; i14 += 2) {
                if (i14 == (-i13) || (i14 != i13 && iArr[(i6 + i14) - 1] < iArr[i6 + i14 + 1])) {
                    i8 = iArr[i6 + i14 + 1];
                    z2 = false;
                } else {
                    i8 = iArr[(i6 + i14) - 1] + 1;
                    z2 = true;
                }
                int i15 = i8 - i14;
                int i16 = i8;
                while (i16 < i9 && i15 < i10 && aVar.i(i2 + i16, i4 + i15)) {
                    i16++;
                    i15++;
                }
                iArr[i6 + i14] = i16;
                if (z3 && i14 >= (i11 - i13) + 1 && i14 <= (i11 + i13) - 1 && iArr[i6 + i14] >= iArr2[i6 + i14]) {
                    f fVar = new f();
                    fVar.x = iArr2[i6 + i14];
                    fVar.y = fVar.x - i14;
                    fVar.size = iArr[i6 + i14] - iArr2[i6 + i14];
                    fVar.adz = z2;
                    fVar.reverse = false;
                    return fVar;
                }
            }
            for (int i17 = -i13; i17 <= i13; i17 += 2) {
                int i18 = i17 + i11;
                if (i18 == i13 + i11 || (i18 != (-i13) + i11 && iArr2[(i6 + i18) - 1] < iArr2[i6 + i18 + 1])) {
                    i7 = iArr2[(i6 + i18) - 1];
                    z = false;
                } else {
                    i7 = iArr2[(i6 + i18) + 1] - 1;
                    z = true;
                }
                int i19 = i7 - i18;
                int i20 = i7;
                while (i20 > 0 && i19 > 0 && aVar.i((i2 + i20) - 1, (i4 + i19) - 1)) {
                    i20--;
                    i19--;
                }
                iArr2[i6 + i18] = i20;
                if (!z3 && i17 + i11 >= (-i13) && i17 + i11 <= i13 && iArr[i6 + i18] >= iArr2[i6 + i18]) {
                    f fVar2 = new f();
                    fVar2.x = iArr2[i6 + i18];
                    fVar2.y = fVar2.x - i18;
                    fVar2.size = iArr[i6 + i18] - iArr2[i6 + i18];
                    fVar2.adz = z;
                    fVar2.reverse = true;
                    return fVar2;
                }
            }
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }

    public static abstract class a {
        public abstract int aB();

        public abstract int aC();

        public abstract boolean i(int i2, int i3);

        public abstract boolean j(int i2, int i3);

        public Object h(int i2, int i3) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class f {
        boolean adz;
        boolean reverse;
        int size;
        int x;
        int y;

        f() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class e {
        int adA;
        int adB;
        int adC;
        int adD;

        public e() {
        }

        public e(int i2, int i3) {
            this.adA = 0;
            this.adB = i2;
            this.adC = 0;
            this.adD = i3;
        }
    }

    public static class b {
        private final List<f> adq;
        private final int[] adr;
        private final int[] ads;
        private final a adt;
        private final int adu;
        private final int adv;
        private final boolean adw;

        b(a aVar, List<f> list, int[] iArr, int[] iArr2, boolean z) {
            this.adq = list;
            this.adr = iArr;
            this.ads = iArr2;
            Arrays.fill(this.adr, 0);
            Arrays.fill(this.ads, 0);
            this.adt = aVar;
            this.adu = aVar.aB();
            this.adv = aVar.aC();
            this.adw = z;
            f fVar = this.adq.isEmpty() ? null : this.adq.get(0);
            if (!(fVar != null && fVar.x == 0 && fVar.y == 0)) {
                f fVar2 = new f();
                fVar2.x = 0;
                fVar2.y = 0;
                fVar2.adz = false;
                fVar2.size = 0;
                fVar2.reverse = false;
                this.adq.add(0, fVar2);
            }
            hA();
        }

        private void hA() {
            int i2 = this.adu;
            int i3 = this.adv;
            for (int size = this.adq.size() - 1; size >= 0; size--) {
                f fVar = this.adq.get(size);
                int i4 = fVar.x + fVar.size;
                int i5 = fVar.y + fVar.size;
                if (this.adw) {
                    while (i2 > i4) {
                        if (this.adr[i2 - 1] == 0) {
                            a(i2, i3, size, false);
                        }
                        i2--;
                    }
                    while (i3 > i5) {
                        if (this.ads[i3 - 1] == 0) {
                            a(i2, i3, size, true);
                        }
                        i3--;
                    }
                }
                for (int i6 = 0; i6 < fVar.size; i6++) {
                    int i7 = fVar.x + i6;
                    int i8 = fVar.y + i6;
                    int i9 = this.adt.j(i7, i8) ? 1 : 2;
                    this.adr[i7] = (i8 << 5) | i9;
                    this.ads[i8] = i9 | (i7 << 5);
                }
                i2 = fVar.x;
                i3 = fVar.y;
            }
        }

        private boolean a(int i2, int i3, int i4, boolean z) {
            int i5;
            int i6;
            int i7 = 8;
            if (z) {
                int i8 = i3 - 1;
                i3--;
                i6 = i2;
                i5 = i8;
            } else {
                i5 = i2 - 1;
                i6 = i2 - 1;
            }
            while (i4 >= 0) {
                f fVar = this.adq.get(i4);
                int i9 = fVar.x + fVar.size;
                int i10 = fVar.y + fVar.size;
                if (z) {
                    for (int i11 = i6 - 1; i11 >= i9; i11--) {
                        if (this.adt.i(i11, i5)) {
                            int i12 = this.adt.j(i11, i5) ? 8 : 4;
                            this.ads[i5] = (i11 << 5) | 16;
                            this.adr[i11] = i12 | (i5 << 5);
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i13 = i3 - 1; i13 >= i10; i13--) {
                        if (this.adt.i(i5, i13)) {
                            if (!this.adt.j(i5, i13)) {
                                i7 = 4;
                            }
                            this.adr[i2 - 1] = (i13 << 5) | 16;
                            this.ads[i13] = i7 | ((i2 - 1) << 5);
                            return true;
                        }
                    }
                    continue;
                }
                i6 = fVar.x;
                i3 = fVar.y;
                i4--;
            }
            return false;
        }

        public final void a(RecyclerView.a aVar) {
            a(new a(aVar));
        }

        public final void a(d dVar) {
            b bVar;
            if (dVar instanceof b) {
                bVar = (b) dVar;
            } else {
                bVar = new b(dVar);
            }
            List<d> arrayList = new ArrayList<>();
            int i2 = this.adu;
            int i3 = this.adv;
            int size = this.adq.size() - 1;
            int i4 = i3;
            while (size >= 0) {
                f fVar = this.adq.get(size);
                int i5 = fVar.size;
                int i6 = fVar.x + i5;
                int i7 = fVar.y + i5;
                if (i6 < i2) {
                    b(arrayList, bVar, i6, i2 - i6, i6);
                }
                if (i7 < i4) {
                    a(arrayList, bVar, i6, i4 - i7, i7);
                }
                for (int i8 = i5 - 1; i8 >= 0; i8--) {
                    if ((this.adr[fVar.x + i8] & 31) == 2) {
                        bVar.c(fVar.x + i8, 1, this.adt.h(fVar.x + i8, fVar.y + i8));
                    }
                }
                i2 = fVar.x;
                size--;
                i4 = fVar.y;
            }
            bVar.hz();
        }

        private static d a(List<d> list, int i2, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                d dVar = list.get(size);
                if (dVar.adx == i2 && dVar.adz == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        d dVar2 = list.get(size);
                        dVar2.ady = (z ? 1 : -1) + dVar2.ady;
                        size++;
                    }
                    return dVar;
                }
                size--;
            }
            return null;
        }

        private void a(List<d> list, d dVar, int i2, int i3, int i4) {
            if (!this.adw) {
                dVar.f(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int i6 = this.ads[i4 + i5] & 31;
                switch (i6) {
                    case 0:
                        dVar.f(i2, 1);
                        for (d dVar2 : list) {
                            dVar2.ady++;
                        }
                        break;
                    case 4:
                    case 8:
                        int i7 = this.ads[i4 + i5] >> 5;
                        dVar.l(a(list, i7, true).ady, i2);
                        if (i6 == 4) {
                            dVar.c(i2, 1, this.adt.h(i7, i4 + i5));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        list.add(new d(i4 + i5, i2, false));
                        break;
                    default:
                        throw new IllegalStateException("unknown flag for pos " + (i5 + i4) + " " + Long.toBinaryString((long) i6));
                }
            }
        }

        private void b(List<d> list, d dVar, int i2, int i3, int i4) {
            if (!this.adw) {
                dVar.k(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int i6 = this.adr[i4 + i5] & 31;
                switch (i6) {
                    case 0:
                        dVar.k(i2 + i5, 1);
                        for (d dVar2 : list) {
                            dVar2.ady--;
                        }
                        break;
                    case 4:
                    case 8:
                        int i7 = this.adr[i4 + i5] >> 5;
                        d a2 = a(list, i7, false);
                        dVar.l(i2 + i5, a2.ady - 1);
                        if (i6 == 4) {
                            dVar.c(a2.ady - 1, 1, this.adt.h(i4 + i5, i7));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        list.add(new d(i4 + i5, i2 + i5, true));
                        break;
                    default:
                        throw new IllegalStateException("unknown flag for pos " + (i5 + i4) + " " + Long.toBinaryString((long) i6));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class d {
        int adx;
        int ady;
        boolean adz;

        public d(int i2, int i3, boolean z) {
            this.adx = i2;
            this.ady = i3;
            this.adz = z;
        }
    }
}
