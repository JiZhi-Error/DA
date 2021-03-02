package com.c.a.c;

public final class g<V> extends b implements f {
    public transient V[] cql;
    private transient int[] cqr;
    protected final f cqs = this;

    /* access modifiers changed from: protected */
    @Override // com.c.a.c.b
    public final int hw(int i2) {
        int hw = super.hw(i2);
        this.cql = (V[]) new Object[hw];
        this.cqr = new int[hw];
        return hw;
    }

    /* access modifiers changed from: protected */
    @Override // com.c.a.c.b
    public final int capacity() {
        return this.cql.length;
    }

    public final V e(int i2, V v) {
        boolean d2;
        V v2 = null;
        int hC = hC(i2);
        boolean z = true;
        if (hC < 0) {
            hC = (-hC) - 1;
            v2 = (V) aF(this.cql[hC]);
            z = false;
            d2 = false;
        } else {
            d2 = d(this.cql, hC);
        }
        this.cqr[hC] = i2;
        this.cql[hC] = v;
        if (z) {
            bO(d2);
        }
        return v2;
    }

    /* access modifiers changed from: protected */
    @Override // com.c.a.c.b
    public final void hx(int i2) {
        int length = this.cqr.length;
        int[] iArr = this.cqr;
        V[] vArr = this.cql;
        this.cqr = new int[i2];
        this.cql = (V[]) new Object[i2];
        while (true) {
            length--;
            if (length <= 0) {
                return;
            }
            if (b(vArr, length)) {
                int i3 = iArr[length];
                int hC = hC(i3);
                this.cqr[hC] = i3;
                this.cql[hC] = vArr[length];
            }
        }
    }

    public final V get(int i2) {
        int hB = hB(i2);
        if (hB < 0) {
            return null;
        }
        return (V) aF(this.cql[hB]);
    }

    public static <V> V aF(V v) {
        if (v == n.cqF) {
            return null;
        }
        return v;
    }

    @Override // com.c.a.c.b
    public final void clear() {
        super.clear();
        int[] iArr = this.cqr;
        V[] vArr = this.cql;
        int length = iArr.length;
        while (true) {
            int i2 = length - 1;
            if (length > 0) {
                iArr[i2] = 0;
                vArr[i2] = null;
                length = i2;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int hB(int i2) {
        int[] iArr = this.cqr;
        V[] vArr = this.cql;
        int length = iArr.length;
        int hA = Integer.MAX_VALUE & this.cqs.hA(i2);
        int i3 = hA % length;
        if (!d(vArr, i3) && (c(vArr, i3) || iArr[i3] != i2)) {
            int i4 = (hA % (length - 2)) + 1;
            while (true) {
                i3 -= i4;
                if (i3 < 0) {
                    i3 += length;
                }
                if (d(vArr, i3) || (!c(vArr, i3) && iArr[i3] == i2)) {
                    break;
                }
            }
        }
        if (d(vArr, i3)) {
            return -1;
        }
        return i3;
    }

    private int hC(int i2) {
        V[] vArr = this.cql;
        int[] iArr = this.cqr;
        int length = iArr.length;
        int hA = this.cqs.hA(i2) & Integer.MAX_VALUE;
        int i3 = hA % length;
        if (d(vArr, i3)) {
            return i3;
        }
        if (b(vArr, i3) && iArr[i3] == i2) {
            return (-i3) - 1;
        }
        int i4 = (hA % (length - 2)) + 1;
        int i5 = c(vArr, i3) ? i3 : -1;
        do {
            i3 -= i4;
            if (i3 < 0) {
                i3 += length;
            }
            if (i5 == -1 && c(vArr, i3)) {
                i5 = i3;
            }
            if (!b(vArr, i3)) {
                break;
            }
        } while (iArr[i3] != i2);
        if (c(vArr, i3)) {
            while (!d(vArr, i3) && (c(vArr, i3) || iArr[i3] != i2)) {
                i3 -= i4;
                if (i3 < 0) {
                    i3 += length;
                }
            }
        }
        if (b(vArr, i3)) {
            return (-i3) - 1;
        }
        return i5 != -1 ? i5 : i3;
    }

    public static boolean b(Object[] objArr, int i2) {
        Object obj = objArr[i2];
        return (obj == null || obj == n.cqE) ? false : true;
    }

    private static boolean c(Object[] objArr, int i2) {
        return objArr[i2] == n.cqE;
    }

    private static boolean d(Object[] objArr, int i2) {
        return objArr[i2] == null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (gVar.size() == size()) {
            return a(new a(gVar));
        }
        return false;
    }

    public final int hashCode() {
        b bVar = new b();
        a(bVar);
        return bVar.f110h;
    }

    final class b implements h<V> {

        /* renamed from: h  reason: collision with root package name */
        int f110h;

        b() {
        }

        @Override // com.c.a.c.h
        public final boolean f(int i2, V v) {
            this.f110h += g.this.cqs.hA(i2) ^ com.c.a.a.a.a.ax(v);
            return true;
        }
    }

    static final class a<V> implements h<V> {
        private final g<V> cqt;

        a(g<V> gVar) {
            this.cqt = gVar;
        }

        @Override // com.c.a.c.h
        public final boolean f(int i2, V v) {
            boolean z;
            if (this.cqt.hB(i2) >= 0) {
                V v2 = this.cqt.get(i2);
                if (v == v2 || (v != null && v.equals(v2))) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: V[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.c.a.c.b
    public final void removeAt(int i2) {
        this.cql[i2] = n.cqE;
        super.removeAt(i2);
    }

    public final int[] Kv() {
        int[] iArr = new int[size()];
        int[] iArr2 = this.cqr;
        V[] vArr = this.cql;
        int i2 = 0;
        int length = iArr2.length;
        while (true) {
            int i3 = length - 1;
            if (length <= 0) {
                return iArr;
            }
            if (b(vArr, i3)) {
                iArr[i2] = iArr2[i3];
                i2++;
                length = i3;
            } else {
                length = i3;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.c.a.c.h<V> */
    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(h<V> hVar) {
        int[] iArr = this.cqr;
        V[] vArr = this.cql;
        int length = iArr.length;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return true;
            }
            if (b(vArr, i2) && !hVar.f(iArr[i2], aF(vArr[i2]))) {
                return false;
            }
            length = i2;
        }
    }

    @Override // com.c.a.c.f
    public final int hA(int i2) {
        return i2;
    }

    @Override // com.c.a.c.b, java.lang.Object
    public final /* bridge */ /* synthetic */ Object clone() {
        g gVar = (g) super.clone();
        gVar.cql = (V[]) ((Object[]) this.cql.clone());
        return gVar;
    }
}
